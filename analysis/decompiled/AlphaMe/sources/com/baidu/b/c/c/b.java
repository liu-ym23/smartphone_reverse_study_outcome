package com.baidu.b.c.c;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static byte[] f4845a;

    /* renamed from: b, reason: collision with root package name */
    private static byte[] f4846b;

    public static byte[] a() {
        byte[] bArr = f4845a;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f4840a).modPow(new BigInteger(a.f4841b), new BigInteger(a.f4844e)).toByteArray();
        f4845a = byteArray;
        return byteArray;
    }

    public static byte[] b() {
        byte[] bArr = f4846b;
        if (bArr != null) {
            return bArr;
        }
        byte[] byteArray = new BigInteger(a.f4842c).modPow(new BigInteger(a.f4843d), new BigInteger(a.f4844e)).toByteArray();
        f4846b = byteArray;
        return byteArray;
    }
}
