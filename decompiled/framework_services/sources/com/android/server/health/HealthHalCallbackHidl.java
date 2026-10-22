package com.android.server.health;

import android.hardware.health.Translate;
import android.hardware.health.V2_0.HealthInfo;
import android.hardware.health.V2_0.IHealth;
import android.hardware.health.V2_0.Result;
import android.hardware.health.V2_1.IHealthInfoCallback;
import android.os.RemoteException;
import android.os.Trace;
import android.util.Slog;

/* JADX INFO: loaded from: classes2.dex */
class HealthHalCallbackHidl extends IHealthInfoCallback.Stub implements HealthServiceWrapperHidl.Callback {
    private static final String TAG = null;
    private HealthInfoCallback mCallback;

    static {
        TAG = HealthHalCallbackHidl.class.getSimpleName();
    }

    private static void traceBegin(String name) {
        Trace.traceBegin(524288, name);
    }

    private static void traceEnd() {
        Trace.traceEnd(524288);
    }

    HealthHalCallbackHidl(HealthInfoCallback callback) {
        this.mCallback = callback;
    }

    @Override // android.hardware.health.V2_0.IHealthInfoCallback
    public void healthInfoChanged(HealthInfo props) {
        android.hardware.health.V2_1.HealthInfo propsLatest = new android.hardware.health.V2_1.HealthInfo();
        propsLatest.legacy = props;
        propsLatest.batteryCapacityLevel = -1;
        propsLatest.batteryChargeTimeToFullNowSeconds = -1;
        this.mCallback.update(Translate.h2aTranslate(propsLatest));
    }

    @Override // android.hardware.health.V2_1.IHealthInfoCallback
    public void healthInfoChanged_2_1(android.hardware.health.V2_1.HealthInfo props) {
        this.mCallback.update(Translate.h2aTranslate(props));
    }

    @Override // com.android.server.health.HealthServiceWrapperHidl.Callback
    public void onRegistration(IHealth oldService, IHealth newService, String instance) {
        if (newService != null) goto L4;
        return;
    L4:
        traceBegin("HealthUnregisterCallback");
        if (oldService != null) goto L36;
    L14:
        traceEnd();
        traceBegin("HealthRegisterCallback");
        int r = newService.registerCallback(this);     // Catch: Throwable -> L24 RemoteException -> L26
        if (r == 0) goto L28;
        Slog.w(TAG, "health: cannot register callback: " + Result.toString(r));     // Catch: Throwable -> L24 RemoteException -> L26
        traceEnd();
        return;
    L28:
        newService.update();     // Catch: Throwable -> L24 RemoteException -> L26
    L29:
        traceEnd();
        return;
    L26:
        ex = move-exception;
        Slog.e(TAG, "health: cannot register callback (transaction error): " + ex.getMessage());     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        traceEnd();
        throw th;
    L36:
        int r2 = oldService.unregisterCallback(this);     // Catch: Throwable -> L10 RemoteException -> L12
        if (r2 == 0) goto L14;
        Slog.w(TAG, "health: cannot unregister previous callback: " + Result.toString(r2));     // Catch: Throwable -> L10 RemoteException -> L12
    L12:
        ex = move-exception;
        Slog.w(TAG, "health: cannot unregister previous callback (transaction error): " + ex.getMessage());     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        traceEnd();
        throw th;
    }
}
