package com.google.common.math;

import java.math.BigInteger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
final class MathPreconditions {
    static int checkPositive(@Nullable String r2, int r3) {
        if (r3 <= 0) goto L5;
        return r3;
    L5:
        throw new IllegalArgumentException(r2 + " (" + r3 + ") must be > 0");
    }

    static long checkPositive(@Nullable String r2, long r3) {
        if (r3 <= 0) goto L6;
        return r3;
    L6:
        throw new IllegalArgumentException(r2 + " (" + r3 + ") must be > 0");
    }

    static BigInteger checkPositive(@Nullable String r2, BigInteger r3) {
        if (r3.signum() <= 0) goto L6;
        return r3;
    L6:
        throw new IllegalArgumentException(r2 + " (" + r3 + ") must be > 0");
    }

    static int checkNonNegative(@Nullable String r2, int r3) {
        if (r3 < 0) goto L5;
        return r3;
    L5:
        throw new IllegalArgumentException(r2 + " (" + r3 + ") must be >= 0");
    }

    static long checkNonNegative(@Nullable String r2, long r3) {
        if (r3 < 0) goto L6;
        return r3;
    L6:
        throw new IllegalArgumentException(r2 + " (" + r3 + ") must be >= 0");
    }

    static BigInteger checkNonNegative(@Nullable String r2, BigInteger r3) {
        if (r3.signum() < 0) goto L6;
        return r3;
    L6:
        throw new IllegalArgumentException(r2 + " (" + r3 + ") must be >= 0");
    }

    static double checkNonNegative(@Nullable String r2, double r3) {
        if (r3 < 0.0d) goto L6;
        return r3;
    L6:
        throw new IllegalArgumentException(r2 + " (" + r3 + ") must be >= 0");
    }

    static void checkRoundingUnnecessary(boolean r1) {
        if (r1 == false) goto L5;
        return;
    L5:
        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    }

    static void checkInRange(boolean r1) {
        if (r1 == false) goto L5;
        return;
    L5:
        throw new ArithmeticException("not in range");
    }

    static void checkNoOverflow(boolean r1) {
        if (r1 == false) goto L5;
        return;
    L5:
        throw new ArithmeticException("overflow");
    }

    private MathPreconditions() {
    }
}
