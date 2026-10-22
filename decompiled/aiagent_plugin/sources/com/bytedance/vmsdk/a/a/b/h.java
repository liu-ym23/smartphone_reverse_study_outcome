package com.bytedance.vmsdk.a.a.b;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: Utf8Charset.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f11705a = null;

    static {
        f11705a = Charset.forName("UTF-8");
    }

    public static byte[] a(String r1) {
        return r1.getBytes("UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
