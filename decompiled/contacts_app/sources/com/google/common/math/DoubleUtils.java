package com.google.common.math;

import com.google.common.base.Preconditions;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
final class DoubleUtils {
    static final int EXPONENT_BIAS = 1023;
    static final long EXPONENT_MASK = 9218868437227405312L;
    static final long IMPLICIT_BIT = 4503599627370496L;
    private static final long ONE_BITS = 0;
    static final int SIGNIFICAND_BITS = 52;
    static final long SIGNIFICAND_MASK = 4503599627370495L;
    static final long SIGN_MASK = Long.MIN_VALUE;

    private DoubleUtils() {
    }

    static double nextDown(double r0) {
        return -Math.nextUp(-r0);
    }

    static long getSignificand(double r3) {
        Preconditions.checkArgument(isFinite(r3), "not a normal value");
        int r0 = Math.getExponent(r3);
        long r4 = Double.doubleToRawLongBits(r3) & SIGNIFICAND_MASK;
        if (r0 != (-1023)) goto L6;
        return r4 << 1;
    L6:
        return r4 | IMPLICIT_BIT;
    }

    static boolean isFinite(double r0) {
        if (Math.getExponent(r0) > EXPONENT_BIAS) goto L5;
        return true;
    L5:
        return false;
    }

    static boolean isNormal(double r0) {
        if (Math.getExponent(r0) < (-1022)) goto L5;
        return true;
    L5:
        return false;
    }

    static double scaleNormalize(double r2) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(r2) & SIGNIFICAND_MASK) | ONE_BITS);
    }

    static double bigToDouble(BigInteger r13) {
        BigInteger r0 = r13.abs();
        boolean r2 = true;
        int r1 = r0.bitLength() - 1;
        if (r1 >= 63) goto L7;
        return r13.longValue();
    L7:
        if (r1 > EXPONENT_BIAS) goto L9;
        int r4 = (r1 - 52) - 1;
        long r5 = r0.shiftRight(r4).longValue();
        long r7 = (r5 >> 1) & SIGNIFICAND_MASK;
        if ((r5 & 1) != 0) goto L13;
    L17:
        r2 = false;
    L18:
        if (r2 == false) goto L21;
        r7 = r7 + 1;
    L21:
        return Double.longBitsToDouble(((((long) (r1 + EXPONENT_BIAS)) << 52) + r7) | (((long) r13.signum()) & Long.MIN_VALUE));
    L13:
        if ((r7 & 1) != 0) goto L18;
        if (r0.getLowestSetBit() >= r4) goto L17;
    L9:
        return ((double) r13.signum()) * Double.POSITIVE_INFINITY;
    }

    static double ensureNonNegative(double r3) {
        Preconditions.checkArgument(!Double.isNaN(r3));
        if (r3 <= 0.0d) goto L5;
        return r3;
    L5:
        return 0.0d;
    }

    static {
        ONE_BITS = Double.doubleToRawLongBits(1.0d);
    }
}
