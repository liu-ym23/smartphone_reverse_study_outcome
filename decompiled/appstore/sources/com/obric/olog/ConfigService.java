package com.obric.olog;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public class ConfigService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Messenger f12198a;

    public ConfigService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        getApplicationContext();
        Log.d("ConfigService", "onBind");
        return this.f12198a.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d("olog ConfigService", "onCreate");
        this.f12198a = new Messenger(new jc.a(getApplicationContext()));
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.d("olog ConfigService", "onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent r10) {
        Log.d("olog ConfigService", "onUnbind");
        return super.onUnbind(r10);
    }
}
