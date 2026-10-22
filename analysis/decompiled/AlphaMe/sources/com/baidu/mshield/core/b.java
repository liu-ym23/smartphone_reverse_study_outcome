package com.baidu.mshield.core;

import java.util.Random;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f8291a = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static byte[] a() {
        try {
            char[] charArray = f8291a.toCharArray();
            char[] cArr = new char[16];
            for (int i4 = 0; i4 < 16; i4++) {
                cArr[i4] = charArray[new Random().nextInt(62)];
            }
            return new String(cArr).getBytes();
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return new byte[0];
        }
    }
}
