package com.bytedance.android.live.core.utils;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes45.dex */
public final class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f66231a;

    public static boolean a() {
        long r100 = SystemClock.uptimeMillis();
        long r101 = r100 - f66231a;
        f66231a = r100;
        if (r101 <= 500) goto L5;
        return true;
    L5:
        return false;
    }
}
