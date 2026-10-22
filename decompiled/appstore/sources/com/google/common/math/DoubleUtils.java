package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
final class DoubleUtils {
    static final int EXPONENT_BIAS = 1023;
    static final long EXPONENT_MASK = 9218868437227405312L;
    static final long IMPLICIT_BIT = 4503599627370496L;

    @VisibleForTesting
    static final long ONE_BITS = 4607182418800017408L;
    static final int SIGNIFICAND_BITS = 52;
    static final long SIGNIFICAND_MASK = 4503599627370495L;
    static final long SIGN_MASK = Long.MIN_VALUE;

    private DoubleUtils() {
    }

    public static double bigToDouble(BigInteger r13) {
        BigInteger r10 = r13.abs();
        int r11 = r10.bitLength();
        int r12 = r11 - 1;
        if (r12 >= 63) goto L7;
        return r13.longValue();
    L7:
        if (r12 > EXPONENT_BIAS) goto L9;
        int r14 = r11 - 54;
        long r15 = r10.shiftRight(r14).longValue();
        long r16 = r15 >> 1;
        long r17 = SIGNIFICAND_MASK & r16;
        if ((r15 & 1) == 0) goto L18;
        if ((r16 & 1) == 0) goto L15;
    L16:
        r17 = r17 + 1;
        goto L18
    L15:
        if (r10.getLowestSetBit() < r14) goto L16;
    L18:
        return Double.longBitsToDouble(((((long) (r11 + 1022)) << 52) + r17) | (((long) r13.signum()) & SIGN_MASK));
    L9:
        return ((double) r13.signum()) * Double.POSITIVE_INFINITY;
    }

    public static double ensureNonNegative(double r10) {
        Preconditions.checkArgument(!Double.isNaN(r10));
        if (r10 <= 0.0d) goto L5;
        return r10;
    L5:
        return 0.0d;
    }

    public static long getSignificand(double r10) {
        Preconditions.checkArgument(isFinite(r10), "not a normal value");
        int r11 = Math.getExponent(r10);
        long r12 = Double.doubleToRawLongBits(r10) & SIGNIFICAND_MASK;
        if (r11 != (-1023)) goto L6;
        return r12 << 1;
    L6:
        return r12 | IMPLICIT_BIT;
    }

    public static boolean isFinite(double r10) {
        if (Math.getExponent(r10) > EXPONENT_BIAS) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isNormal(double r10) {
        if (Math.getExponent(r10) < (-1022)) goto L5;
        return true;
    L5:
        return false;
    }

    public static double nextDown(double r10) {
        return -Math.nextUp(-r10);
    }

    public static double scaleNormalize(double r10) {
        return Double.longBitsToDouble((Double.doubleToRawLongBits(r10) & SIGNIFICAND_MASK) | ONE_BITS);
    }
}
