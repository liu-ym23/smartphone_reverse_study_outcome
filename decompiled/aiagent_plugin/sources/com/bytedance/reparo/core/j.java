package com.bytedance.reparo.core;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PatchLogger.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f9297a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f9298b;

    /* JADX INFO: compiled from: PatchLogger.java */
    public interface a {
        void a(String r1);

        void a(String r1, String r2);

        void a(String r1, String r2, Throwable r3);

        void c(String r1, String r2);

        void c(String r1, String r2, Throwable r3);

        void e(String r1, String r2);

        void g(String r1, String r2);

        void h(String r1, String r2);
    }

    public j() {
    }

    static {
        a r0 = new AnonymousClass1();
        f9297a = r0;
        f9298b = r0;
    }

    public static void a(a r2) {
        f9298b = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
    }

    public static a a() {
        return f9298b;
    }

    public static void a(String r3, String r4) {
        f9298b.a("reparo-core/" + r3, r4);
    }

    public static void b(String r3, String r4) {
        f9298b.c("reparo-core/" + r3, r4);
    }

    public static void c(String r3, String r4) {
        f9298b.e("reparo-core/" + r3, r4);
    }

    public static void a(String r3, String r4, Throwable r5) {
        f9298b.a("reparo-core/" + r3, r4, r5);
    }

    public static void d(String r3, String r4) {
        f9298b.g("reparo-core/" + r3, r4);
    }

    public static void b(String r3, String r4, Throwable r5) {
        f9298b.c("reparo-core/" + r3, r4, r5);
    }

    public static void a(String r4, String[] r5) {
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        String r2 = r5[r1];
        if (r2 == null) goto L11;
        f9298b.h(r4, r2);
        r1 = r1 + 1;
        goto L3
    L11:
        return;
    }

    public static void a(String[] r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        String r2 = r4[r1];
        if (r2 == null) goto L11;
        f9298b.a(r2);
        r1 = r1 + 1;
        goto L3
    L11:
        return;
    }
}
