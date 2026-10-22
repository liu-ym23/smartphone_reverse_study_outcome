package com.ttnet.org.chromium.base;

import android.util.Log;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j {
    public static void a(String r10, String r11, Object... r12) {
        Throwable r13 = c(r12);
        String r14 = b(r11, r13, r12);
        if (r13 == null) goto L5;
        Log.e(g(r10), r14, r13);
        return;
    L5:
        Log.e(g(r10), r14);
    }

    public static String b(String r10, Throwable r11, Object... r12) {
        if (r12 == null) goto L10;
        if (r11 != null) goto L7;
        if (r12.length <= 0) goto L7;
    L9:
        return String.format(Locale.US, r10, r12);
    L7:
        if (r12.length > 1) goto L9;
        return r10;
    L10:
        return r10;
    }

    public static Throwable c(Object[] r10) {
        if (r10 != null) goto L5;
    L12:
        return null;
    L5:
        if (r10.length == 0) goto L12;
        Object r11 = r10[r10.length - 1];
        if ((r11 instanceof Throwable) == true) goto L11;
        return null;
    L11:
        return (Throwable) r11;
    }

    public static void d(String r10, String r11, Object... r12) {
        Throwable r13 = c(r12);
        String r14 = b(r11, r13, r12);
        if (r13 == null) goto L5;
        Log.i(g(r10), r14, r13);
        return;
    L5:
        Log.i(g(r10), r14);
    }

    public static boolean e() {
        return true;
    }

    public static boolean f(String r10, int r11) {
        if (e() == true) goto L9;
        if (r11 > 4) goto L9;
        return false;
    L9:
        return Log.isLoggable(r10, r11);
    }

    public static String g(String r10) {
        if (r10.startsWith("cr_") == false) goto L6;
        return r10;
    L6:
        if (r10.startsWith("cr.") == false) goto L8;
        int r11 = 3;
    L10:
        return "cr_" + r10.substring(r11, r10.length());
    L8:
        r11 = 0;
        goto L10
    }

    public static void h(String r10, String r11, Object... r12) {
        Throwable r13 = c(r12);
        String r14 = b(r11, r13, r12);
        if (r13 == null) goto L5;
        Log.w(g(r10), r14, r13);
        return;
    L5:
        Log.w(g(r10), r14);
    }
}
