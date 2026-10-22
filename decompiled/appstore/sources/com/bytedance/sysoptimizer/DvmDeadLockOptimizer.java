package com.bytedance.sysoptimizer;

import android.content.Context;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class DvmDeadLockOptimizer {
    private static String TAG = "SYSOPTIMIZER";
    private static boolean mOptimized = false;

    static {
    }

    private DvmDeadLockOptimizer() {
    }

    private static boolean loadOptimizerOnNeed(Context r10) {
        return false;
    }

    private static native boolean optimize();

    public static synchronized boolean optimize(Context r10) {
        monitor-enter(DvmDeadLockOptimizer.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (mOptimized == false) goto L10;
        monitor-exit(DvmDeadLockOptimizer.class);
        return true;
    L10:
        if (loadOptimizerOnNeed(r10) == true) goto L23;
    L18:
        monitor-exit(DvmDeadLockOptimizer.class);
        return false;
    L23:
        boolean r11 = optimize();     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        mOptimized = r11;     // Catch: Throwable -> L14 UnsatisfiedLinkError -> L16
        monitor-exit(DvmDeadLockOptimizer.class);
        return r11;
    L16:
        e = move-exception;
        Log.e(TAG, "failed to optimize, UnsatisfiedLinkError", e);     // Catch: Throwable -> L14
        goto L18
    }
}
