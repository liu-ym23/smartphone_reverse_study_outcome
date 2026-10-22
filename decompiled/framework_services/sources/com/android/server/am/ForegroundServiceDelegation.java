package com.android.server.am;

import android.app.ForegroundServiceDelegationOptions;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public class ForegroundServiceDelegation {
    public final IBinder mBinder;
    public final ServiceConnection mConnection;
    public final ForegroundServiceDelegationOptions mOptions;

    public ForegroundServiceDelegation(ForegroundServiceDelegationOptions options, ServiceConnection connection) {
        this.mBinder = new Binder();
        this.mOptions = options;
        this.mConnection = connection;
    }
}
