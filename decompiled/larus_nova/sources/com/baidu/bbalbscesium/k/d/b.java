package com.baidu.bbalbscesium.k.d;

import java.math.BigInteger;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;

/* JADX INFO: loaded from: classes39.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SecureRandom f30363a = null;

    static {
        f30363a = new SecureRandom();
    }

    private b() {
    }

    public static int a(BigInteger r100) {
        return (r100.bitLength() + 7) >> 3;
    }

    private static BigInteger a(byte[] r100, BigInteger r101) throws BadPaddingException {
        BigInteger r102 = new BigInteger(1, r100);
        if (r102.compareTo(r101) >= 0) goto L6;
        return r102;
    L6:
        throw new BadPaddingException("Message is larger than modulus");
    }

    private static byte[] a(BigInteger r100, int r101) {
        byte[] r102 = r100.toByteArray();
        int r103 = r102.length;
        if (r103 != r101) goto L6;
        return r102;
    L6:
        if (r103 == (r101 + 1)) goto L8;
    L11:
        if (r103 < r101) goto L14;
        return null;
    L14:
        byte[] r104 = new byte[r101];
        System.arraycopy(r102, 0, r104, r101 - r103, r103);
        return r104;
    L8:
        if (r102[0] != 0) goto L11;
        byte[] r105 = new byte[r101];
        System.arraycopy(r102, 1, r105, 0, r101);
        return r105;
    }

    public static byte[] a(byte[] r100, int r101, int r102) {
        if (r101 == 0) goto L4;
    L6:
        byte[] r103 = new byte[r102];
        System.arraycopy(r100, r101, r103, 0, r102);
        return r103;
    L4:
        if (r102 != r100.length) goto L6;
        return r100;
    }

    public static byte[] a(byte[] r100, d r101) throws BadPaddingException {
        return a(r100, r101.a(), r101.b());
    }

    private static byte[] a(byte[] r100, BigInteger r101, BigInteger r102) throws BadPaddingException {
        return a(a(r100, r101).modPow(r102, r101), a(r101));
    }
}
