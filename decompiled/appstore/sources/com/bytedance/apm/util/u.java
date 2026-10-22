package com.bytedance.apm.util;

import android.os.Looper;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {
    public static boolean a() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }
}
