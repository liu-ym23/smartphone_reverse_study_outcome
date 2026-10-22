package com.bytedance.crash.o;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: NpthLog.java */
/* JADX INFO: loaded from: classes.dex */
public final class r {
    private static final String TAG = "NPTH";

    public static void a(Object r1) {
        if (com.bytedance.crash.config.h.f() == false) goto L6;
        a(TAG, String.valueOf(r1));
        return;
    }

    public static void a(String r1, Object r2) {
        if (com.bytedance.crash.config.h.f() == false) goto L6;
        b(TAG, r1 + " " + r2);
        return;
    }

    public static void b(Object r1) {
        if (com.bytedance.crash.config.h.d() == false) goto L6;
        b(TAG, String.valueOf(r1));
        return;
    }

    public static void b(String r1, Object r2) {
        if (com.bytedance.crash.config.h.d() == false) goto L6;
        b(TAG, r1 + " " + r2);
        return;
    }

    public static void a(Throwable r1) {
        a(TAG, r1);
    }

    public static void a(String r1) {
        c(TAG, r1);
    }

    public static void a(String r1, Throwable r2) {
        if (com.bytedance.crash.config.h.d() == false) goto L6;
        b(r1, r2);
        return;
    }

    public static void c(String r1, String r2) {
        if (com.bytedance.crash.config.h.d() == false) goto L6;
        d(r1, r2);
        return;
    }

    public static void a(String r1, String r2, Throwable r3) {
        if (com.bytedance.crash.config.h.d() == false) goto L6;
        b(r1, r2, r3);
        return;
    }

    public static void b(Throwable r1) {
        c("", r1);
    }

    public static void c(String r1, Throwable r2) {
        c(TAG, r1, r2);
    }

    public static void c(String r1, Object r2) {
        e(TAG, r1 + " " + r2);
    }

    public static void a(String r1, Object r2, Throwable r3) {
        if (com.bytedance.crash.config.h.d() == false) goto L6;
        c(TAG, r1 + " " + r2, r3);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int d(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, Throwable r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2, Throwable r3) {
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
    public static int c(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
