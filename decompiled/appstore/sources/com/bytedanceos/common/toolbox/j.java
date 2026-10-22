package com.bytedanceos.common.toolbox;

import android.text.TextUtils;
import android.util.Log;
import com.bytedanceos.common.BaseApplication;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {
    public static void a(String r10) {
        if (f(3) == false) goto L6;
        g('d', r10);
        return;
    }

    public static void b(String r10) {
        if (f(6) == false) goto L6;
        g('e', r10);
        return;
    }

    public static String c(Throwable r10) {
        String r11 = "";
        if (r10 != null) goto L5;
        return "";
    L5:
        PrintWriter r12 = null;
        StringWriter r13 = new StringWriter();     // Catch: Throwable -> L12 Exception -> L19
        PrintWriter r14 = new PrintWriter(r13);     // Catch: Throwable -> L12 Exception -> L19
        goto L16
    L22:
        r10.printStackTrace(r14);     // Catch: Throwable -> L9 Exception -> L11
        r11 = r13.toString();     // Catch: Throwable -> L9 Exception -> L11
        r14.close();
    L18:
        return r11;
    L11:
        r12 = r14;
    L9:
        th = th;
        r12 = r14;
    L13:
        if (r12 == null) goto L15;
        r12.close();
    L15:
        throw th;
    L12:
        th = th;
    L16:
        if (r12 == null) goto L18;
        r12.close();
        goto L18
    }

    public static String d() {
        BaseApplication r10 = BaseApplication.c();
        if (r10 != null) goto L5;
        return "LogUtils";
    L5:
        if (r10.o() == false) goto L8;
        return "AppStore";
    L8:
        return "GameStore";
    }

    public static void e(String r10) {
        if (f(4) == false) goto L6;
        g('i', r10);
        return;
    }

    public static boolean f(int r10) {
        if (4 > r10) goto L5;
        return true;
    L5:
        return false;
    }

    public static void g(char r10, String r11) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return;
    L6:
        if (r10 != 'd') goto L8;
        o(r11);
        return;
    L8:
        if (r10 != 'e') goto L10;
        p(r11);
        return;
    L10:
        if (r10 != 'i') goto L12;
        n(r11);
        return;
    L12:
        if (r10 != 'v') goto L14;
        r(r11);
        return;
    L14:
        if (r10 != 'w') goto L26;
        s(r11);
        return;
    }

    public static void h(String r10) {
        n(r10);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Log.i("LogUtils", r10, th);
    }

    public static void i(String r10) {
        p(r10);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Log.e("LogUtils", r10, th);
    }

    public static void j(String r10, Throwable r11) {
        q(r10, r11);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Log.e("LogUtils", r10, r11);
        Log.e("LogUtils", "safeWriteOfflineLogE fallback failed", th);
    }

    public static void k(String r10) {
        s(r10);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Log.w("LogUtils", r10, th);
    }

    public static void l(String r10) {
        if (f(2) == false) goto L6;
        g('v', r10);
        return;
    }

    public static void m(String r10) {
        if (f(5) == false) goto L6;
        g('w', r10);
        return;
    }

    public static void n(String r10) {
        a.a().c(d(), r10);
    }

    public static void o(String r10) {
        a.a().a(d(), r10);
    }

    public static void p(String r10) {
        a.a().b(d(), r10);
    }

    public static void q(String r10, Throwable r11) {
        StringWriter r12 = new StringWriter();
        r11.printStackTrace(new PrintWriter(r12));
        a.a().b(d(), r10 + "\n" + r12.toString());
    }

    public static void r(String r10) {
        a.a().d(d(), r10);
    }

    public static void s(String r10) {
        a.a().e(d(), r10);
    }

    public static void t(String r10) {
    L4:
        e = move-exception;
        n(r10 + " " + c(e));
        return;
    L3:
        throw new RuntimeException("pauseDownloadTask");     // Catch: RuntimeException -> L4
    }
}
