package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@CanIgnoreReturnValue
@GwtCompatible
final class MathPreconditions {
    private MathPreconditions() {
    }

    public static void checkInRangeForRoundingInputs(boolean r10, double r11, RoundingMode r12) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new ArithmeticException("rounded value is out of range for input " + r11 + " and rounding mode " + r12);
    }

    public static void checkNoOverflow(boolean r10, String r11, int r12, int r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new ArithmeticException("overflow: " + r11 + "(" + r12 + ", " + r13 + ")");
    }

    public static int checkNonNegative(@NullableDecl String r10, int r11) {
        if (r11 < 0) goto L5;
        return r11;
    L5:
        throw new IllegalArgumentException(r10 + " (" + r11 + ") must be >= 0");
    }

    public static int checkPositive(@NullableDecl String r10, int r11) {
        if (r11 <= 0) goto L5;
        return r11;
    L5:
        throw new IllegalArgumentException(r10 + " (" + r11 + ") must be > 0");
    }

    public static void checkRoundingUnnecessary(boolean r10) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    }

    public static void checkNoOverflow(boolean r10, String r11, long r12, long r13) {
        if (r10 == false) goto L5;
        return;
    L5:
        throw new ArithmeticException("overflow: " + r11 + "(" + r12 + ", " + r13 + ")");
    }

    public static long checkNonNegative(@NullableDecl String r10, long r11) {
        if (r11 < 0) goto L6;
        return r11;
    L6:
        throw new IllegalArgumentException(r10 + " (" + r11 + ") must be >= 0");
    }

    public static long checkPositive(@NullableDecl String r10, long r11) {
        if (r11 <= 0) goto L6;
        return r11;
    L6:
        throw new IllegalArgumentException(r10 + " (" + r11 + ") must be > 0");
    }

    public static BigInteger checkNonNegative(@NullableDecl String r10, BigInteger r11) {
        if (r11.signum() < 0) goto L6;
        return r11;
    L6:
        throw new IllegalArgumentException(r10 + " (" + r11 + ") must be >= 0");
    }

    public static BigInteger checkPositive(@NullableDecl String r10, BigInteger r11) {
        if (r11.signum() <= 0) goto L6;
        return r11;
    L6:
        throw new IllegalArgumentException(r10 + " (" + r11 + ") must be > 0");
    }

    public static double checkNonNegative(@NullableDecl String r10, double r11) {
        if (r11 < 0.0d) goto L6;
        return r11;
    L6:
        throw new IllegalArgumentException(r10 + " (" + r11 + ") must be >= 0");
    }
}
