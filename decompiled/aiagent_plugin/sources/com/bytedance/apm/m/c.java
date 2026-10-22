package com.bytedance.apm.m;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SamplerHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f4730a;

    static {
        f4730a = new a();
    }

    public static void a(b r2) {
        f4730a = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
    }

    public static boolean a(String r1) {
        return f4730a.a(r1);
    }

    public static boolean b(String r1) {
        return f4730a.b(r1);
    }

    public static boolean c(String r1) {
        return f4730a.c(r1);
    }

    public static boolean d(String r1) {
        return f4730a.d(r1);
    }

    public static boolean a(String r1, String r2) {
        return f4730a.a(r1, r2);
    }

    public static boolean e(String r1) {
        return f4730a.e(r1);
    }
}
