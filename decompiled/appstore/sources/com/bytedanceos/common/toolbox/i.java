package com.bytedanceos.common.toolbox;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {
    public static int a(String r10, String r11) {
        return g(3, r10, r11, null);
    }

    public static int b(String r10, String r11) {
        return g(6, r10, r11, null);
    }

    public static int c(String r10, String r11, Throwable r12) {
        return g(6, r10, r11, r12);
    }

    public static String d(Throwable r10) {
        return Log.getStackTraceString(r10);
    }

    public static int e(String r10, String r11) {
        return g(4, r10, r11, null);
    }

    public static boolean f(int r10) {
        if (r10 < 4) goto L5;
        return true;
    L5:
        return false;
    }

    public static int g(int r10, String r11, String r12, Throwable r13) {
        if (f(r10) == true) goto L5;
        return 0;
    L5:
        if (r11 != null) goto L7;
        r11 = "";
    L7:
        if (r12 != null) goto L9;
        r12 = "null";
    L9:
        if (r13 == null) goto L12;
        r12 = r12 + '\n' + d(r13);
    L12:
        if (h(r10, r11, r12) == true) goto L14;
        i(r10, r11, r12);
    L14:
        return 0;
    }

    public static boolean h(int r10, String r11, String r12) {
        if (r10 != 2) goto L5;
        a.a().d(r11, r12);     // Catch: Throwable -> L19
        return true;
    L5:
        if (r10 != 3) goto L7;
        a.a().a(r11, r12);     // Catch: Throwable -> L19
        return true;
    L7:
        if (r10 != 5) goto L9;
        a.a().e(r11, r12);     // Catch: Throwable -> L19
        return true;
    L9:
        if (r10 != 6) goto L11;
    L13:
        a.a().b(r11, r12);     // Catch: Throwable -> L19
        return true;
    L11:
        if (r10 == 7) goto L13;
        a.a().c(r11, r12);     // Catch: Throwable -> L19
        return true;
    L19:
        return false;
    }

    public static void i(int r10, String r11, String r12) {
        Log.println(r10, r11, r12);
    }

    public static int j(String r10, String r11) {
        return g(2, r10, r11, null);
    }

    public static int k(String r10, String r11) {
        return g(5, r10, r11, null);
    }

    public static int l(String r10, String r11, Throwable r12) {
        return g(5, r10, r11, r12);
    }
}
