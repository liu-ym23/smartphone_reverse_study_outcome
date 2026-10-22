package com.baidu.b.c.d;

import java.math.BigInteger;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final SecureRandom f4848a = new SecureRandom();

    public static int a(BigInteger bigInteger) {
        return (bigInteger.bitLength() + 7) >> 3;
    }

    private static BigInteger a(byte[] bArr, BigInteger bigInteger) throws BadPaddingException {
        BigInteger bigInteger2 = new BigInteger(1, bArr);
        if (bigInteger2.compareTo(bigInteger) < 0) {
            return bigInteger2;
        }
        throw new BadPaddingException("Message is larger than modulus");
    }

    private static byte[] a(BigInteger bigInteger, int i4) {
        byte[] byteArray = bigInteger.toByteArray();
        int length = byteArray.length;
        if (length == i4) {
            return byteArray;
        }
        if (length == i4 + 1 && byteArray[0] == 0) {
            byte[] bArr = new byte[i4];
            System.arraycopy(byteArray, 1, bArr, 0, i4);
            return bArr;
        }
        if (length >= i4) {
            return null;
        }
        byte[] bArr2 = new byte[i4];
        System.arraycopy(byteArray, 0, bArr2, i4 - length, length);
        return bArr2;
    }

    public static byte[] a(byte[] bArr, int i4, int i5) {
        if (i4 == 0 && i5 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i5];
        System.arraycopy(bArr, i4, bArr2, 0, i5);
        return bArr2;
    }

    public static byte[] a(byte[] bArr, d dVar) throws BadPaddingException {
        return a(bArr, dVar.a(), dVar.b());
    }

    private static byte[] a(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) throws BadPaddingException {
        return a(a(bArr, bigInteger).modPow(bigInteger2, bigInteger), a(bigInteger));
    }
}
