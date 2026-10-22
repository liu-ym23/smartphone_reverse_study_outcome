package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.Ed25519;
import java.lang.reflect.Array;
import java.math.BigInteger;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class Ed25519Constants {
    static final Ed25519.CachedXYT[] B2;
    static final Ed25519.CachedXYT[][] B_TABLE;
    static final long[] D;
    static final long[] D2;
    private static final BigInteger D2_BI;
    private static final BigInteger D_BI;
    private static final BigInteger P_BI;
    static final long[] SQRTM1;
    private static final BigInteger SQRTM1_BI;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Point {

        /* renamed from: x, reason: collision with root package name */
        private BigInteger f2484x;

        /* renamed from: y, reason: collision with root package name */
        private BigInteger f2485y;

        private Point() {
        }
    }

    static {
        BigInteger bigIntegerSubtract = BigInteger.valueOf(2L).pow(255).subtract(BigInteger.valueOf(19L));
        P_BI = bigIntegerSubtract;
        BigInteger bigIntegerMod = BigInteger.valueOf(-121665L).multiply(BigInteger.valueOf(121666L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        D_BI = bigIntegerMod;
        BigInteger bigIntegerMod2 = BigInteger.valueOf(2L).multiply(bigIntegerMod).mod(bigIntegerSubtract);
        D2_BI = bigIntegerMod2;
        BigInteger bigIntegerModPow = BigInteger.valueOf(2L).modPow(bigIntegerSubtract.subtract(BigInteger.ONE).divide(BigInteger.valueOf(4L)), bigIntegerSubtract);
        SQRTM1_BI = bigIntegerModPow;
        Point point = new Point();
        point.f2485y = BigInteger.valueOf(4L).multiply(BigInteger.valueOf(5L).modInverse(bigIntegerSubtract)).mod(bigIntegerSubtract);
        point.f2484x = recoverX(point.f2485y);
        D = Field25519.expand(toLittleEndian(bigIntegerMod));
        D2 = Field25519.expand(toLittleEndian(bigIntegerMod2));
        SQRTM1 = Field25519.expand(toLittleEndian(bigIntegerModPow));
        B_TABLE = (Ed25519.CachedXYT[][]) Array.newInstance((Class<?>) Ed25519.CachedXYT.class, 32, 8);
        Point pointEdwards = point;
        for (int i = 0; i < 32; i++) {
            Point pointEdwards2 = pointEdwards;
            for (int i3 = 0; i3 < 8; i3++) {
                B_TABLE[i][i3] = getCachedXYT(pointEdwards2);
                pointEdwards2 = edwards(pointEdwards2, pointEdwards);
            }
            for (int i10 = 0; i10 < 8; i10++) {
                pointEdwards = edwards(pointEdwards, pointEdwards);
            }
        }
        Point pointEdwards3 = edwards(point, point);
        B2 = new Ed25519.CachedXYT[8];
        for (int i11 = 0; i11 < 8; i11++) {
            B2[i11] = getCachedXYT(point);
            point = edwards(point, pointEdwards3);
        }
    }

    private Ed25519Constants() {
    }

    private static Point edwards(Point point, Point point2) {
        Point point3 = new Point();
        BigInteger bigIntegerMultiply = D_BI.multiply(point.f2484x.multiply(point2.f2484x).multiply(point.f2485y).multiply(point2.f2485y));
        BigInteger bigInteger = P_BI;
        BigInteger bigIntegerMod = bigIntegerMultiply.mod(bigInteger);
        BigInteger bigIntegerAdd = point.f2484x.multiply(point2.f2485y).add(point2.f2484x.multiply(point.f2485y));
        BigInteger bigInteger2 = BigInteger.ONE;
        point3.f2484x = bigIntegerAdd.multiply(bigInteger2.add(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        point3.f2485y = point.f2485y.multiply(point2.f2485y).add(point.f2484x.multiply(point2.f2484x)).multiply(bigInteger2.subtract(bigIntegerMod).modInverse(bigInteger)).mod(bigInteger);
        return point3;
    }

    private static Ed25519.CachedXYT getCachedXYT(Point point) {
        BigInteger bigIntegerAdd = point.f2485y.add(point.f2484x);
        BigInteger bigInteger = P_BI;
        return new Ed25519.CachedXYT(Field25519.expand(toLittleEndian(bigIntegerAdd.mod(bigInteger))), Field25519.expand(toLittleEndian(point.f2485y.subtract(point.f2484x).mod(bigInteger))), Field25519.expand(toLittleEndian(D2_BI.multiply(point.f2484x).multiply(point.f2485y).mod(bigInteger))));
    }

    private static BigInteger recoverX(BigInteger bigInteger) {
        BigInteger bigIntegerPow = bigInteger.pow(2);
        BigInteger bigInteger2 = BigInteger.ONE;
        BigInteger bigIntegerSubtract = bigIntegerPow.subtract(bigInteger2);
        BigInteger bigIntegerAdd = D_BI.multiply(bigInteger.pow(2)).add(bigInteger2);
        BigInteger bigInteger3 = P_BI;
        BigInteger bigIntegerMultiply = bigIntegerSubtract.multiply(bigIntegerAdd.modInverse(bigInteger3));
        BigInteger bigIntegerModPow = bigIntegerMultiply.modPow(bigInteger3.add(BigInteger.valueOf(3L)).divide(BigInteger.valueOf(8L)), bigInteger3);
        if (!bigIntegerModPow.pow(2).subtract(bigIntegerMultiply).mod(bigInteger3).equals(BigInteger.ZERO)) {
            bigIntegerModPow = bigIntegerModPow.multiply(SQRTM1_BI).mod(bigInteger3);
        }
        return bigIntegerModPow.testBit(0) ? bigInteger3.subtract(bigIntegerModPow) : bigIntegerModPow;
    }

    private static byte[] toLittleEndian(BigInteger bigInteger) {
        byte[] bArr = new byte[32];
        byte[] byteArray = bigInteger.toByteArray();
        System.arraycopy(byteArray, 0, bArr, 32 - byteArray.length, byteArray.length);
        for (int i = 0; i < 16; i++) {
            byte b10 = bArr[i];
            int i3 = 31 - i;
            bArr[i] = bArr[i3];
            bArr[i3] = b10;
        }
        return bArr;
    }
}
