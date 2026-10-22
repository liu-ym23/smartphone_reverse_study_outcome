package com.bytedance.sysoptimizer;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class DvmOptimizer {
    private DvmOptimizer() {
    }

    public static void hookDvmLinearAllocFunc(Context r10) {
        if (loadOptimizerOnNeed(r10) == false) goto L6;
        startHookDvmFunc();
        return;
    }

    private static boolean loadOptimizerOnNeed(Context r10) {
        return false;
    }

    public static void optDvmLinearAllocBuffer(Context r10) {
        if (loadOptimizerOnNeed(r10) == false) goto L6;
        optLinearAllocBuffer();
        return;
    }

    private static native void optLinearAllocBuffer();

    private static native void startHookDvmFunc();
}
