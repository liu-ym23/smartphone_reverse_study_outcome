package com.bytedance.android.livesdk.utils;

/* JADX INFO: loaded from: classes11.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f158946a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f158947b;

    public static boolean a(int r100) {
        if (f158946a == r100) goto L5;
        f158946a = r100;
        f158947b = 0;
    L5:
        long r101 = System.currentTimeMillis();
        if ((r101 - f158947b) >= 500) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        f158947b = r101;
    L11:
        return r102;
    L8:
        r102 = false;
        goto L9
    }
}
