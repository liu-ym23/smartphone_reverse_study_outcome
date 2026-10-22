package com.ss.android.common.util;

import com.bytedance.applog.log.m;

/* JADX INFO: compiled from: TLog.java */
/* JADX INFO: loaded from: classes4.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f37294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.bytedance.applog.log.f f37295b = null;

    static {
        f37295b = m.a();
    }

    public static void a(String r1) {
        a(r1, null);
    }

    public static void b(String r1) {
        b(r1, null);
    }

    public static void c(String r1) {
        c(r1, null);
    }

    public static void d(String r1) {
        d(r1, null);
    }

    public static void e(String r1) {
        e(r1, null);
    }

    public static void a(String r1, Throwable r2) {
        c r0 = f37294a;
        if (r0 == null) goto L5;
        r0.a(r1, r2);
    L5:
        f37295b.b(r1, new Object[0]);
    }

    public static void b(String r1, Throwable r2) {
        c r0 = f37294a;
        if (r0 == null) goto L5;
        r0.b(r1, r2);
    L5:
        f37295b.d(r1, new Object[0]);
    }

    public static void c(String r1, Throwable r2) {
        c r0 = f37294a;
        if (r0 == null) goto L5;
        r0.c(r1, r2);
    L5:
        f37295b.c(r1, new Object[0]);
    }

    public static void d(String r1, Throwable r2) {
        c r0 = f37294a;
        if (r0 == null) goto L5;
        r0.d(r1, r2);
    L5:
        f37295b.e(r1, new Object[0]);
    }

    public static void e(String r2, Throwable r3) {
        c r0 = f37294a;
        if (r0 == null) goto L5;
        r0.e(r2, r3);
    L5:
        f37295b.a(r2, r3, new Object[0]);
    }
}
