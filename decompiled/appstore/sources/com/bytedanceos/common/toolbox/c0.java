package com.bytedanceos.common.toolbox;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c0 {
    public static byte[] a(String r10) {
        return r10.getBytes(Charset.defaultCharset());
    }

    public static int b(String r10) {
        return d0.a(r10);
    }

    public static long c(String r10) {
        return d0.b(r10);
    }

    public static String d(byte[] r10) {
        return new String(r10, Charset.defaultCharset());
    }

    public static Charset e() {
        return Charset.defaultCharset();
    }

    public static boolean f(float r10, float r11) {
        if (Math.abs(r10 - r11) > 1.0E-11f) goto L5;
        return true;
    L5:
        return false;
    }
}
