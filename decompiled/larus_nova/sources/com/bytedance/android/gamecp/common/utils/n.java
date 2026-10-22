package com.bytedance.android.gamecp.common.utils;

import com.vivo.push.PushClientConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f57245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f57246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f57247c;

    static {
        f57245a = -1;
        f57246b = "";
    }

    public static boolean a(long r100) {
        long r101 = System.currentTimeMillis();
        if ((r101 - f57247c) >= r100) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        f57247c = r101;
    L8:
        return r102;
    L5:
        r102 = false;
        goto L6
    }

    public static boolean b(int r100) {
        if (f57245a == r100) goto L6;
        f57245a = r100;
        f57247c = 0;
    L6:
        return a(500);
    }

    public static boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        if ((!Intrinsics.areEqual(f57246b, r100)) == false) goto L6;
        f57246b = r100;
        f57247c = 0;
    L6:
        return a(1000);
    }
}
