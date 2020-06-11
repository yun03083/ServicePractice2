package android.cs.pusan.ac.servicepractice;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyService extends Service {
    ServiceThread thread;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId){
        myServiceHandler handler = new myServiceHandler();
        thread = new ServiceThread(handler);
        thread.start();
        return START_STICKY;
    }

    public void onDestroy(){
        thread.stopForever();
        thread = null;
    }

    class myServiceHandler extends Handler {
        public void handleMessage(android.os.Message msg) {
            Toast.makeText(MyService.this, "서비스가 실행 중 입니다.", Toast.LENGTH_LONG).show();
        }
    }
}
