package com.baidu.bbalbscesium.k.c;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes39.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static byte[] f30360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static byte[] f30361b;

    public b() {
    }

    public static byte[] a() {
        byte[] r100 = f30361b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        byte[] r101 = new BigInteger(a.f30357c).modPow(new BigInteger(a.f30358d), new BigInteger(a.f30359e)).toByteArray();
        f30361b = r101;
        return r101;
    }

    public static byte[] b() {
        byte[] r100 = f30360a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        byte[] r101 = new BigInteger(a.f30355a).modPow(new BigInteger(a.f30356b), new BigInteger(a.f30359e)).toByteArray();
        f30360a = r101;
        return r101;
    }
}
