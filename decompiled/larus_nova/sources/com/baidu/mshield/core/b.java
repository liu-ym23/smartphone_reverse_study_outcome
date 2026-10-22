package com.baidu.mshield.core;

import java.util.Random;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f32390a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static byte[] a() {
        char[] r100 = f32390a.toCharArray();     // Catch: Throwable -> L8
        char[] r101 = new char[16];     // Catch: Throwable -> L8
        int r102 = 0;
    L4:
        if (r102 >= 16) goto L6;
        r101[r102] = r100[new Random().nextInt(62)];     // Catch: Throwable -> L8
        r102 = r102 + 1;     // Catch: Throwable -> L8
        goto L4
    L6:
        return new String(r101).getBytes();
    L8:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return new byte[0];
    }
}
