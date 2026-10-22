package com.android.server.biometrics.sensors.fingerprint.aidl;

import android.util.Slog;
import com.android.server.SysOptBridge;

/* JADX INFO: loaded from: classes.dex */
final class SysOptPerfLock {
    private static final String TAG = "SysOptPerfLock";
    private int mHandle;
    private final Object mLock;

    SysOptPerfLock() {
        this.mLock = new Object();
        this.mHandle = -1;
    }

    void acquireType(int hintId, int type, int durationMs) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Slog.d(TAG, "acquireType enter mHandle=" + this.mHandle);     // Catch: Throwable -> L8
        if (this.mHandle <= 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        int handle = SysOptBridge.getFactory().getBoostFrameworkService().perfLockAcquireType(hintId, type, durationMs);     // Catch: Throwable -> L8
        Slog.d(TAG, "acquireType perfLockAcquireType hintId=" + hintId + ", type=" + type + ", durationMs=" + durationMs + " handle=" + handle);     // Catch: Throwable -> L8
        if (handle <= 0) goto L13;
        this.mHandle = handle;     // Catch: Throwable -> L8
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void release(String reason) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Slog.d(TAG, "release enter reason=" + reason + ", handle=" + this.mHandle);     // Catch: Throwable -> L8
        int handle = this.mHandle;     // Catch: Throwable -> L8
        if (handle > 0) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mHandle = -1;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        Slog.d(TAG, "release perfLockReleaseHandler reason=" + reason + ", handle=" + handle);
        SysOptBridge.getFactory().getBoostFrameworkService().perfLockReleaseHandler(handle);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void release() {
        release(null);
    }

    static boolean shouldReleaseOnError(int errorCode) {
        if (errorCode == 5) goto L8;
        if (errorCode == 1) goto L9;
        return false;
    L9:
        return true;
    L8:
        return true;
    }
}
