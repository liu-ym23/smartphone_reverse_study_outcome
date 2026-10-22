package com.bytedance.crash.config;

import com.bytedance.crash.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RuntimeConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f7299a = 8000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f7300b = 500;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f7301c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static o f7302d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f7303e;
    private static boolean f;
    private static boolean g;

    /* JADX INFO: compiled from: RuntimeConfig.java */
    static class a implements o {
        a() {
        }

        @Override // com.bytedance.crash.o
        public byte[] a(byte[] r1) {
            return com.bytedance.crash.o.g.a(r1);
        }
    }

    static {
        f7302d = new a();
        f = true;
        g = true;
    }

    public static long a() {
        return f7300b;
    }

    public static void a(long r0) {
        f7300b = r0;
    }

    public static long b() {
        return f7299a;
    }

    public static void b(long r0) {
        f7299a = r0;
    }

    public static o c() {
        return f7302d;
    }

    public static void a(o r2) {
        o r3 = (o) ZeusTransformUtils.wrapperContextForParams(r2, o.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        f7302d = r3;
        return;
    }

    public static boolean d() {
        return f7301c;
    }

    public static void a(boolean r0) {
        f7301c = r0;
    }

    public static boolean e() {
        return f7303e;
    }

    public static boolean f() {
        if (d() == true) goto L5;
    L7:
        return false;
    L5:
        if (g() == false) goto L7;
        return true;
    }

    public static boolean g() {
        com.bytedance.crash.monitor.a r0 = com.bytedance.crash.monitor.h.a();
        if (r0 != null) goto L5;
        return false;
    L5:
        String r1 = r0.f();
        if (r1 != null) goto L8;
        return false;
    L8:
        if (r1.contains("test_crash") == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static void b(boolean r0) {
        f = r0;
    }

    public static boolean h() {
        return f;
    }

    public static void c(boolean r0) {
        g = r0;
    }

    public static boolean i() {
        return g;
    }
}
