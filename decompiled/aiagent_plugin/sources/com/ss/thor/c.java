package com.ss.thor;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f37585a = 3;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f37586b = 3;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f37587c = 3;

    static {
    }

    public static boolean a() {
        int r0 = f37585a;
        if (r0 == 3) goto L7;
        if (r0 == 1) goto L6;
        return false;
    L6:
        return true;
    L7:
        String r1 = Build.BRAND;
        if (TextUtils.isEmpty(r1) == false) goto L10;
    L12:
        int r2 = 2;
    L13:
        f37585a = r2;
        if (r2 == 1) goto L16;
        return false;
    L16:
        return true;
    L10:
        if (r1.toLowerCase().contains("oppo") == false) goto L12;
        r2 = 1;
        goto L13
    }

    public static boolean b() {
        int r0 = f37586b;
        if (r0 == 3) goto L7;
        if (r0 == 1) goto L6;
        return false;
    L6:
        return true;
    L7:
        String r1 = Build.HARDWARE;
        if (TextUtils.isEmpty(r1) == false) goto L10;
    L14:
        int r2 = 2;
    L15:
        f37586b = r2;
        if (r2 == 1) goto L18;
        return false;
    L18:
        return true;
    L10:
        if (r1.toLowerCase().contains("hi") == false) goto L12;
    L13:
        r2 = 1;
        goto L15
    L12:
        if (r1.toLowerCase().contains("kirin") == false) goto L14;
        goto L13
    }

    public static boolean c() {
        int r0 = f37587c;
        if (r0 == 3) goto L7;
        if (r0 == 1) goto L6;
        return false;
    L6:
        return true;
    L7:
        String r1 = Build.BRAND;
        if (TextUtils.isEmpty(r1) == false) goto L10;
    L12:
        int r2 = 2;
    L13:
        f37587c = r2;
        if (r2 == 1) goto L16;
        return false;
    L16:
        return true;
    L10:
        if (r1.toLowerCase().contains("samsung") == false) goto L12;
        r2 = 1;
        goto L13
    }
}
