package com.android.server.health;

import android.hardware.health.HealthInfo;
import android.hardware.health.IHealth;
import android.hardware.health.IHealthInfoCallback;
import android.os.RemoteException;
import android.os.Trace;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
public class HealthRegCallbackAidl {
    private static final String TAG = "HealthRegCallbackAidl";
    private final IHealthInfoCallback mHalInfoCallback;
    private final HealthInfoCallback mServiceInfoCallback;

    private class HalInfoCallback extends IHealthInfoCallback.Stub {
        final /* synthetic */ HealthRegCallbackAidl this$0;

        /* synthetic */ HalInfoCallback(HealthRegCallbackAidl r1, HealthRegCallbackAidlIA r2) {
            this(r1);
        }

        private HalInfoCallback(HealthRegCallbackAidl r1) {
            this.this$0 = r1;
        }

        @Override // android.hardware.health.IHealthInfoCallback
        public void healthInfoChanged(HealthInfo healthInfo) throws RemoteException {
            HealthRegCallbackAidl.m4435$$Nest$fgetmServiceInfoCallback(this.this$0).update(healthInfo);
        }

        @Override // android.hardware.health.IHealthInfoCallback
        public String getInterfaceHash() {
            return "c8d014c7bb950af538396f3e5a409c69b7b9335c";
        }

        @Override // android.hardware.health.IHealthInfoCallback
        public int getInterfaceVersion() {
            return 4;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceInfoCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ HealthInfoCallback m4435$$Nest$fgetmServiceInfoCallback(HealthRegCallbackAidl r0) {
        return r0.mServiceInfoCallback;
    }

    HealthRegCallbackAidl(HealthInfoCallback healthInfoCallback) {
        this.mHalInfoCallback = new HalInfoCallback(this, null);
        this.mServiceInfoCallback = healthInfoCallback;
    }

    public void onRegistration(IHealth oldService, IHealth newService) {
        if (this.mServiceInfoCallback != null) goto L5;
        return;
    L5:
        Trace.traceBegin(524288, "HealthUnregisterCallbackAidl");
        unregisterCallback(oldService, this.mHalInfoCallback);     // Catch: Throwable -> L14
        Trace.traceEnd(524288);
        Trace.traceBegin(524288, "HealthRegisterCallbackAidl");
        registerCallback(newService, this.mHalInfoCallback);     // Catch: Throwable -> L11
        Trace.traceEnd(524288);
        return;
    L11:
        th = move-exception;
        Trace.traceEnd(524288);
        throw th;
    L14:
        th = move-exception;
        Trace.traceEnd(524288);
        throw th;
    }

    private static void unregisterCallback(IHealth oldService, IHealthInfoCallback cb) {
        if (oldService != null) goto L9;
        return;
    L9:
        oldService.unregisterCallback(cb);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.w(TAG, "health: cannot unregister previous callback (transaction error): " + e.getMessage());
    }

    private static void registerCallback(IHealth newService, IHealthInfoCallback cb) {
        newService.registerCallback(cb);     // Catch: RemoteException -> L9
        newService.update();     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        Slog.e(TAG, "health: cannot update after registering health info callback", e);
        return;
    L9:
        e = move-exception;
        Slog.e(TAG, "health: cannot register callback, framework may cease to receive updates on health / battery info!", e);
    }
}
