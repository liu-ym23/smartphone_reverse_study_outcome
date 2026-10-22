package com.stepos.deepbinder.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@f.a
/* loaded from: classes.dex */
public final class ProcessStateService extends Service {
    private volatile boolean isBound;

    @Override // android.app.Service
    @f.a
    @SuppressLint({"WrongConstant"})
    public IBinder onBind(Intent intent) {
        if (!this.isBound) {
            getApplication().bindService(new Intent(this, (Class<?>) ProcessStateService.class), new a(), 1);
            this.isBound = true;
        }
        return new Binder();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }
    }
}
