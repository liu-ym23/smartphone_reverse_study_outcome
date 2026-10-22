package com.blankj.utilcode.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f6219a = null;

    static {
        f6219a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static byte[] a(byte[] r10, byte[] r11) {
        return b(r10, r11, "HmacSHA256");
    }

    public static byte[] b(byte[] r10, byte[] r11, String r12) {
        if (r10 != null) goto L5;
    L14:
        return null;
    L5:
        if (r10.length == 0) goto L14;
        if (r11 == null) goto L14;
        if (r11.length == 0) goto L14;
        SecretKeySpec r13 = new SecretKeySpec(r11, r12);     // Catch: Throwable -> L12
        Mac r14 = Mac.getInstance(r12);     // Catch: Throwable -> L12
        r14.init(r13);     // Catch: Throwable -> L12
        return r14.doFinal(r10);
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L14
    }
}
