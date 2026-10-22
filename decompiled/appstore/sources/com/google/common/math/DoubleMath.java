package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class DoubleMath {
    private static final double LN_2 = 0.0d;

    @VisibleForTesting
    static final int MAX_FACTORIAL = 170;
    private static final double MAX_INT_AS_DOUBLE = 2.147483647E9d;
    private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18d;
    private static final double MIN_INT_AS_DOUBLE = -2.147483648E9d;
    private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18d;

    @VisibleForTesting
    static final double[] everySixteenthFactorial = null;

    /* JADX INFO: renamed from: com.google.common.math.DoubleMath$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode = null;

        static {
            int[] r10 = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = r10;
            r10[RoundingMode.UNNECESSARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static {
        LN_2 = Math.log(2.0d);
        everySixteenthFactorial = new double[]{1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};
    }

    private DoubleMath() {
    }

    @CanIgnoreReturnValue
    @GwtIncompatible
    private static double checkFinite(double r10) {
        Preconditions.checkArgument(DoubleUtils.isFinite(r10));
        return r10;
    }

    public static double factorial(int r10) {
        MathPreconditions.checkNonNegative("n", r10);
        if (r10 <= MAX_FACTORIAL) goto L6;
        return Double.POSITIVE_INFINITY;
    L6:
        int r11 = (r10 & (-16)) + 1;
        double r12 = 1.0d;
    L7:
        if (r11 > r10) goto L10;
        r12 = r12 * ((double) r11);
        r11 = r11 + 1;
        goto L7
    L10:
        return r12 * everySixteenthFactorial[r10 >> 4];
    }

    public static int fuzzyCompare(double r10, double r11, double r12) {
        if (fuzzyEquals(r10, r11, r12) == false) goto L7;
        return 0;
    L7:
        if (r10 >= r11) goto L11;
        return -1;
    L11:
        if (r10 <= r11) goto L15;
        return 1;
    L15:
        return Booleans.compare(Double.isNaN(r10), Double.isNaN(r11));
    }

    public static boolean fuzzyEquals(double r10, double r11, double r12) {
        MathPreconditions.checkNonNegative("tolerance", r12);
        if (Math.copySign(r10 - r11, 1.0d) > r12) goto L5;
    L12:
        return true;
    L5:
        if (r10 == r11) goto L12;
        if (Double.isNaN(r10) == true) goto L9;
    L11:
        return false;
    L9:
        if (Double.isNaN(r11) == false) goto L11;
        goto L11
    }

    @GwtIncompatible
    public static boolean isMathematicalInteger(double r10) {
        if (DoubleUtils.isFinite(r10) == true) goto L5;
    L9:
        return false;
    L5:
        if (r10 != 0.0d) goto L7;
    L8:
        return true;
    L7:
        if ((52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(r10))) > Math.getExponent(r10)) goto L9;
        goto L8
    }

    @GwtIncompatible
    public static boolean isPowerOfTwo(double r10) {
        if (r10 > 0.0d) goto L5;
        return false;
    L5:
        if (DoubleUtils.isFinite(r10) == false) goto L11;
        long r11 = DoubleUtils.getSignificand(r10);
        if ((r11 & (r11 - 1)) != 0) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }

    public static double log2(double r10) {
        return Math.log(r10) / LN_2;
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(double... r11) {
        int r10 = 1;
        if (r11.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "Cannot take mean of 0 values");
        double r13 = checkFinite(r11[0]);
        long r14 = 1;
    L8:
        if (r10 >= r11.length) goto L10;
        checkFinite(r11[r10]);
        r14 = r14 + 1;
        r13 = r13 + ((r11[r10] - r13) / r14);
        r10 = r10 + 1;
        goto L8
    L10:
        return r13;
    L5:
        r12 = false;
        goto L6
    }

    @GwtIncompatible
    public static double roundIntermediate(double r10, RoundingMode r11) {
        if (DoubleUtils.isFinite(r10) == false) goto L45;
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r11.ordinal()]) {
            case 1: goto L42;
            case 2: goto L36;
            case 3: goto L29;
            case 4: goto L46;
            case 5: goto L20;
            case 6: goto L18;
            case 7: goto L12;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        double r12 = Math.rint(r10);
        if (Math.abs(r10 - r12) != 0.5d) goto L11;
        return r10;
    L11:
        return r12;
    L12:
        double r13 = Math.rint(r10);
        if (Math.abs(r10 - r13) == 0.5d) goto L15;
        return r13;
    L15:
        return r10 + Math.copySign(0.5d, r10);
    L42:
        MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(r10));
        return r10;
    L46:
        return r10;
    L7:
        throw new AssertionError();
    L18:
        return Math.rint(r10);
    L20:
        if (isMathematicalInteger(r10) == false) goto L22;
        return r10;
    L22:
        long r14 = (long) r10;
        if (r10 <= 0.0d) goto L25;
        int r15 = 1;
    L27:
        return r14 + ((long) r15);
    L25:
        r15 = -1;
        goto L27
    L29:
        if (r10 > 0.0d) goto L31;
        return r10;
    L31:
        if (isMathematicalInteger(r10) == false) goto L34;
        return r10;
    L34:
        return ((long) r10) + 1;
    L36:
        if (r10 < 0.0d) goto L38;
        return r10;
    L38:
        if (isMathematicalInteger(r10) == false) goto L41;
        return r10;
    L41:
        return ((long) r10) - 1;
    L45:
        throw new ArithmeticException("input is infinite or NaN");
    }

    @GwtIncompatible
    public static BigInteger roundToBigInteger(double r10, RoundingMode r11) {
        double r12 = roundIntermediate(r10, r11);
        boolean r13 = false;
        if ((MIN_LONG_AS_DOUBLE - r12) >= 1.0d) goto L5;
        boolean r14 = true;
    L7:
        if (r12 >= MAX_LONG_AS_DOUBLE_PLUS_ONE) goto L10;
        r13 = true;
    L10:
        if ((r14 & r13) == true) goto L12;
        BigInteger r15 = BigInteger.valueOf(DoubleUtils.getSignificand(r12)).shiftLeft(Math.getExponent(r12) - 52);
        if (r12 < 0.0d) goto L16;
        return r15;
    L16:
        return r15.negate();
    L12:
        return BigInteger.valueOf((long) r12);
    L5:
        r14 = false;
        goto L7
    }

    @GwtIncompatible
    public static int roundToInt(double r10, RoundingMode r11) {
        double r12 = roundIntermediate(r10, r11);
        boolean r13 = false;
        if (r12 <= (-2.147483649E9d)) goto L5;
        boolean r14 = true;
    L7:
        if (r12 >= 2.147483648E9d) goto L9;
        r13 = true;
    L9:
        MathPreconditions.checkInRangeForRoundingInputs(r14 & r13, r10, r11);
        return (int) r12;
    L5:
        r14 = false;
        goto L7
    }

    @GwtIncompatible
    public static long roundToLong(double r10, RoundingMode r11) {
        double r12 = roundIntermediate(r10, r11);
        boolean r13 = false;
        if ((MIN_LONG_AS_DOUBLE - r12) >= 1.0d) goto L5;
        boolean r14 = true;
    L7:
        if (r12 >= MAX_LONG_AS_DOUBLE_PLUS_ONE) goto L9;
        r13 = true;
    L9:
        MathPreconditions.checkInRangeForRoundingInputs(r14 & r13, r10, r11);
        return (long) r12;
    L5:
        r14 = false;
        goto L7
    }

    @GwtIncompatible
    public static int log2(double r10, RoundingMode r11) {
        boolean r12 = false;
        if (r10 > 0.0d) goto L5;
    L7:
        boolean r13 = false;
    L8:
        Preconditions.checkArgument(r13, "x must be positive and finite");
        int r14 = Math.getExponent(r10);
        if (DoubleUtils.isNormal(r10) == true) goto L13;
        return log2(r10 * 4.503599627370496E15d, r11) - 52;
    L13:
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r11.ordinal()]) {
            case 1: goto L27;
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L23;
            case 5: goto L19;
            case 6: goto L16;
            case 7: goto L16;
            case 8: goto L16;
            default: goto L15;
        };
    L16:
        double r15 = DoubleUtils.scaleNormalize(r10);
        if ((r15 * r15) <= 2.0d) goto L28;
        r12 = true;
        goto L28
    L19:
        if (r14 < 0) goto L21;
        r12 = true;
    L21:
        boolean r16 = isPowerOfTwo(r10);
    L22:
        r12 = r12 & (!r16);
        goto L28
    L23:
        if (r14 >= 0) goto L25;
        r12 = true;
    L25:
        r16 = isPowerOfTwo(r10);
        goto L22
    L26:
        r12 = !isPowerOfTwo(r10);
        goto L28
    L27:
        MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(r10));
    L28:
        if (r12 == true) goto L30;
        return r14;
    L30:
        return r14 + 1;
    L15:
        throw new AssertionError();
    L5:
        if (DoubleUtils.isFinite(r10) == false) goto L7;
        r13 = true;
        goto L8
    }

    @Deprecated
    public static double mean(int... r10) {
        int r11 = 0;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "Cannot take mean of 0 values");
        long r13 = 0;
    L8:
        if (r11 >= r10.length) goto L11;
        r13 = r13 + ((long) r10[r11]);
        r11 = r11 + 1;
        goto L8
    L11:
        return r13 / ((double) r10.length);
    L5:
        r12 = false;
        goto L6
    }

    @Deprecated
    public static double mean(long... r11) {
        int r10 = 1;
        if (r11.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "Cannot take mean of 0 values");
        double r13 = r11[0];
        long r14 = 1;
    L8:
        if (r10 >= r11.length) goto L10;
        r14 = r14 + 1;
        r13 = r13 + ((r11[r10] - r13) / r14);
        r10 = r10 + 1;
        goto L8
    L10:
        return r13;
    L5:
        r12 = false;
        goto L6
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(Iterable<? extends Number> r10) {
        return mean(r10.iterator());
    }

    @GwtIncompatible
    @Deprecated
    public static double mean(Iterator<? extends Number> r10) {
        Preconditions.checkArgument(r10.hasNext(), "Cannot take mean of 0 values");
        double r11 = checkFinite(r10.next().doubleValue());
        long r12 = 1;
    L4:
        if (r10.hasNext() == false) goto L6;
        r12 = r12 + 1;
        r11 = r11 + ((checkFinite(r10.next().doubleValue()) - r11) / r12);
        goto L4
    L6:
        return r11;
    }
}
