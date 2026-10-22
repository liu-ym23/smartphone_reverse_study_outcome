package com.bytedance.apm.h;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ApmAlogHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f4640a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f4641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static c f4642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static c f4643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile com.bytedance.apm6.foundation.a f4644e;

    static {
    }

    public static void a(boolean r0) {
        f4640a = r0;
    }

    public static boolean a() {
        return f4641b;
    }

    public static void a(c r2) {
        c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r2, c.class, "com.obric.aiagent.plugin");
        f4642c = r3;
        if (r3 == null) goto L6;
        f4640a = true;
        return;
    }

    public static void a(com.bytedance.apm6.foundation.a r2) {
        f4644e = (com.bytedance.apm6.foundation.a) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.apm6.foundation.a.class, "com.obric.aiagent.plugin");
    }

    public static void a(String r1, String r2) {
        if (f4640a == false) goto L8;
        c r0 = f4642c;
        if (r0 == null) goto L9;
        r0.a(r1, r2);
        return;
    L9:
        return;
    }

    public static void b(String r1, String r2) {
        if (f4640a == false) goto L8;
        c r0 = f4642c;
        if (r0 == null) goto L9;
        r0.c(r1, r2);
        return;
    L9:
        return;
    }

    public static void c(String r1, String r2) {
        if (f4641b == false) goto L8;
        c r0 = f4642c;
        if (r0 == null) goto L9;
        r0.c(r1, r2);
        return;
    L9:
        return;
    }

    public static void d(String r1, String r2) {
        if (f4644e == null) goto L6;
        f4644e.a(r1, r2);
        return;
    }

    public static boolean b() {
        if (f4644e == null) goto L6;
        return true;
    L6:
        return false;
    }

    public static c c() {
        return f4643d;
    }
}
