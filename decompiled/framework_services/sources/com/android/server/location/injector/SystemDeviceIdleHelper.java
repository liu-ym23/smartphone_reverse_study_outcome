package com.android.server.location.injector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.PowerManager;
import com.android.internal.util.Preconditions;
import com.android.server.FgThread;

/* JADX INFO: loaded from: classes2.dex */
public class SystemDeviceIdleHelper extends DeviceIdleHelper {
    private final Context mContext;
    private PowerManager mPowerManager;
    private BroadcastReceiver mReceiver;
    private boolean mRegistrationRequired;
    private boolean mSystemReady;

    public SystemDeviceIdleHelper(Context context) {
        this.mContext = context;
    }

    public synchronized void onSystemReady() {
        monitor-enter(this);
        this.mSystemReady = true;     // Catch: Throwable -> L7
        PowerManager r0 = (PowerManager) this.mContext.getSystemService(PowerManager.class);     // Catch: Throwable -> L7
        r0.getClass();     // Catch: Throwable -> L7
        this.mPowerManager = r0;     // Catch: Throwable -> L7
        onRegistrationStateChanged();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.location.injector.DeviceIdleHelper
    protected synchronized void registerInternal() {
        monitor-enter(this);
        this.mRegistrationRequired = true;     // Catch: Throwable -> L7
        onRegistrationStateChanged();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.location.injector.DeviceIdleHelper
    protected synchronized void unregisterInternal() {
        monitor-enter(this);
        this.mRegistrationRequired = false;     // Catch: Throwable -> L7
        onRegistrationStateChanged();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onRegistrationStateChanged() {
        if (this.mSystemReady == true) goto L5;
        return;
    L5:
        long identity = Binder.clearCallingIdentity();
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L7:
        if (this.mRegistrationRequired == false) goto L15;
        if (this.mReceiver != null) goto L15;
        BroadcastReceiver receiver = new AnonymousClass1(this);     // Catch: Throwable -> L12
        this.mContext.registerReceiver(receiver, new IntentFilter("android.os.action.DEVICE_IDLE_MODE_CHANGED"), null, FgThread.getHandler());     // Catch: Throwable -> L12
        this.mReceiver = receiver;     // Catch: Throwable -> L12
    L19:
        Binder.restoreCallingIdentity(identity);
        return;
    L15:
        if (this.mRegistrationRequired == true) goto L19;
        if (this.mReceiver == null) goto L19;
        BroadcastReceiver receiver2 = this.mReceiver;     // Catch: Throwable -> L12
        this.mReceiver = null;     // Catch: Throwable -> L12
        this.mContext.unregisterReceiver(receiver2);     // Catch: Throwable -> L12
        goto L19
    }

    @Override // com.android.server.location.injector.DeviceIdleHelper
    public boolean isDeviceIdle() {
        if (this.mPowerManager == null) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkState(r0);
        return this.mPowerManager.isDeviceIdleMode();
    L5:
        r0 = false;
        goto L6
    }
}
