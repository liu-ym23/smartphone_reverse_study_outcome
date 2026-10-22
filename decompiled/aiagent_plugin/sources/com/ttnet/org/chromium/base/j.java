package com.ttnet.org.chromium.base;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: Log.java */
/* JADX INFO: loaded from: classes4.dex */
public class j {
    private static boolean a() {
        return false;
    }

    private j() {
    }

    private static String a(String r1, Throwable r2, Object... r3) {
        if (r3 == null) goto L10;
        if (r2 != null) goto L7;
        if (r3.length <= 0) goto L7;
    L9:
        return String.format(Locale.US, r1, r3);
    L7:
        if (r3.length > 1) goto L9;
        return r1;
    L10:
        return r1;
    }

    public static String a(String r3) {
        if (r3.startsWith("cr_") == false) goto L5;
        return r3;
    L5:
        int r1 = 0;
        if (r3.startsWith("cr.") == false) goto L9;
        r1 = 3;
    L9:
        return "cr_" + r3.substring(r1, r3.length());
    }

    private static String b(String r2, Throwable r3, Object... r4) {
        return "[" + b() + "] " + a(r2, r3, r4);
    }

    public static boolean a(String r1, int r2) {
        if (a() == true) goto L9;
        if (r2 > 4) goto L9;
        return false;
    L9:
        return b(r1, r2);
    }

    public static void a(String r1, String r2, Object... r3) {
        if (a() == true) goto L5;
        return;
    L5:
        Throwable r0 = a(r3);
        String r4 = b(r2, r0, r3);
        if (r0 == null) goto L8;
        a(a(r1), r4, r0);
        return;
    L8:
        a(a(r1), r4);
    }

    public static void b(String r1, String r2, Object... r3) {
        if (a() == true) goto L5;
        return;
    L5:
        Throwable r0 = a(r3);
        String r4 = b(r2, r0, r3);
        if (r0 == null) goto L8;
        b(a(r1), r4, r0);
        return;
    L8:
        b(a(r1), r4);
    }

    public static void c(String r1, String r2, Object... r3) {
        Throwable r0 = a(r3);
        String r4 = a(r2, r0, r3);
        if (r0 == null) goto L5;
        c(a(r1), r4, r0);
        return;
    L5:
        c(a(r1), r4);
    }

    public static void d(String r1, String r2, Object... r3) {
        Throwable r0 = a(r3);
        String r4 = a(r2, r0, r3);
        if (r0 == null) goto L5;
        d(a(r1), r4, r0);
        return;
    L5:
        d(a(r1), r4);
    }

    public static void e(String r1, String r2, Object... r3) {
        Throwable r0 = a(r3);
        String r4 = a(r2, r0, r3);
        if (r0 == null) goto L5;
        e(a(r1), r4, r0);
        return;
    L5:
        e(a(r1), r4);
    }

    private static Throwable a(Object[] r2) {
        if (r2 != null) goto L5;
    L12:
        return null;
    L5:
        if (r2.length == 0) goto L12;
        Object r3 = r2[r2.length - 1];
        if (ZeusTransformUtils.instanceOf(r3, Throwable.class) == true) goto L11;
        return null;
    L11:
        return (Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin");
    }

    private static String b() {
        StackTraceElement[] r0 = Thread.currentThread().getStackTrace();
        String r1 = j.class.getName();
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L10;
        if (r0[r2].getClassName().equals(r1) == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        r2 = r2 + 3;
    L10:
        return r0[r2].getFileName() + ":" + r0[r2].getLineNumber();
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean b(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.v(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int d(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int e(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
