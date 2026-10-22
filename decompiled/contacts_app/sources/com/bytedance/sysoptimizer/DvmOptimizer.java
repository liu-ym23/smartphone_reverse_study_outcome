package com.bytedance.sysoptimizer;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class DvmOptimizer {
    private static boolean loadOptimizerOnNeed(Context r0) {
        return false;
    }

    private static native void optLinearAllocBuffer();

    private static native void startHookDvmFunc();

    private DvmOptimizer() {
    }

    public static void optDvmLinearAllocBuffer(Context r0) {
        if (loadOptimizerOnNeed(r0) == false) goto L6;
        optLinearAllocBuffer();
        return;
    }

    public static void hookDvmLinearAllocFunc(Context r0) {
        if (loadOptimizerOnNeed(r0) == false) goto L6;
        startHookDvmFunc();
        return;
    }
}
