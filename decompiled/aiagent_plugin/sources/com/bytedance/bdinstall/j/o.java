package com.bytedance.bdinstall.j;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: RequestIdGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static r<String> f6326a;

    static {
        f6326a = c();
    }

    private static r<String> c() {
        return new AnonymousClass1();
    }

    public static String a() {
        return (String) ZeusTransformUtils.preCheckCast(f6326a.c(new Object[0]), String.class, "com.obric.aiagent.plugin");
    }

    public static void b() {
        f6326a = c();
    }
}
