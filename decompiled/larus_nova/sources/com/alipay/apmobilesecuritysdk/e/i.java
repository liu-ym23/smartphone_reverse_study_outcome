package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f25104a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f25105b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f25106c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f25107d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f25108e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Map<String, String> f25109f;

    static {
        f25109f = new HashMap();
    }

    public static synchronized String a(String r100) {
        monitor-enter(i.class);
        String r101 = "apdidTokenCache" + r100;     // Catch: Throwable -> L13
        if (f25109f.containsKey(r101) == false) goto L11;
        String r102 = f25109f.get(r101);     // Catch: Throwable -> L13
        if (com.alipay.sdk.m.z.a.b(r102) == false) goto L11;
        monitor-exit(i.class);
        return r102;
    L11:
        monitor-exit(i.class);
        return "";
    L13:
        th = move-exception;
        throw th;
    }

    public static synchronized void a() {
        monitor-enter(i.class);
        monitor-exit(i.class);
    }

    public static synchronized void a(b r100) {
        monitor-enter(i.class);
        if (r100 != null) goto L12;
    L10:
        monitor-exit(i.class);
        return;
    L12:
        f25104a = r100.f25090a;     // Catch: Throwable -> L7
        f25105b = r100.f25091b;     // Catch: Throwable -> L7
        f25106c = r100.f25092c;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(c r100) {
        monitor-enter(i.class);
        if (r100 != null) goto L12;
    L10:
        monitor-exit(i.class);
        return;
    L12:
        f25104a = r100.f25093a;     // Catch: Throwable -> L7
        f25105b = r100.f25094b;     // Catch: Throwable -> L7
        f25107d = r100.f25096d;     // Catch: Throwable -> L7
        f25108e = r100.f25097e;     // Catch: Throwable -> L7
        f25106c = r100.f25095c;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void a(String r100, String r101) {
        monitor-enter(i.class);
        String r102 = "apdidTokenCache" + r100;     // Catch: Throwable -> L10
        if (f25109f.containsKey(r102) == false) goto L7;
        f25109f.remove(r102);     // Catch: Throwable -> L10
    L7:
        f25109f.put(r102, r101);     // Catch: Throwable -> L10
        monitor-exit(i.class);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean a(Context r100, String r101) {
        monitor-enter(i.class);
        long r102 = h.a(r100);     // Catch: Throwable -> L22
        if (r102 < 0) goto L7;
    L23:
        if (Math.abs(System.currentTimeMillis() - h.h(r100, r101)) >= r102) goto L16;
        monitor-exit(i.class);
        return true;
    L16:
        monitor-exit(i.class);
        return false;
    L14:
        th = move-exception;
        com.alipay.apmobilesecuritysdk.c.a.a(th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L7:
        r102 = 86400000;
        goto L23
    }

    public static synchronized String b() {
        monitor-enter(i.class);
        String r100 = f25104a;     // Catch: Throwable -> L7
        monitor-exit(i.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static void b(String r100) {
        f25104a = r100;
    }

    public static synchronized String c() {
        monitor-enter(i.class);
        String r100 = f25105b;     // Catch: Throwable -> L7
        monitor-exit(i.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static void c(String r100) {
        f25105b = r100;
    }

    public static synchronized String d() {
        monitor-enter(i.class);
        String r100 = f25107d;     // Catch: Throwable -> L7
        monitor-exit(i.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static void d(String r100) {
        f25106c = r100;
    }

    public static synchronized String e() {
        monitor-enter(i.class);
        String r100 = f25108e;     // Catch: Throwable -> L7
        monitor-exit(i.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static void e(String r100) {
        f25107d = r100;
    }

    public static synchronized String f() {
        monitor-enter(i.class);
        String r100 = f25106c;     // Catch: Throwable -> L7
        monitor-exit(i.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static void f(String r100) {
        f25108e = r100;
    }

    public static synchronized c g() {
        monitor-enter(i.class);
        c r100 = new c(f25104a, f25105b, f25106c, f25107d, f25108e);     // Catch: Throwable -> L7
        monitor-exit(i.class);
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static void h() {
        f25109f.clear();
        f25104a = "";
        f25105b = "";
        f25107d = "";
        f25108e = "";
        f25106c = "";
    }
}
