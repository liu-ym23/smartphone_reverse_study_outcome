package com.obric.olog;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class ConfigService extends Service {
    private static final String TAG = "olog ConfigService";
    private Messenger mMessenger;

    public ConfigService() {
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        this.mMessenger = new Messenger(new ConfigHandler(getApplicationContext()));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r2) {
        getApplicationContext();
        Log.d("ConfigService", "onBind");
        return this.mMessenger.getBinder();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r3) {
        Log.d(TAG, "onUnbind");
        return super.onUnbind(r3);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }
}
