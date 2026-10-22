package com.google.common.math;

import com.bytedance.keva.KevaImpl;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.tmall.wireless.tangram.structure.card.FixCard;
import java.math.RoundingMode;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class IntMath {

    @VisibleForTesting
    static final int FLOOR_SQRT_MAX_INT = 46340;

    @VisibleForTesting
    static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;

    @VisibleForTesting
    static final int MAX_SIGNED_POWER_OF_TWO = 1073741824;

    @VisibleForTesting
    static int[] biggestBinomials;
    private static final int[] factorials = null;

    @VisibleForTesting
    static final int[] halfPowersOf10 = null;

    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros = null;

    @VisibleForTesting
    static final int[] powersOf10 = null;

    /* JADX INFO: renamed from: com.google.common.math.IntMath$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode = null;

        static {
            int[] r10 = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = r10;
            r10[RoundingMode.UNNECESSARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L20:
            $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L34:
            $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L22:
            $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L28:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L30:
            $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L19
            return;
        }
    }

    static {
        maxLog10ForLeadingZeros = new byte[]{9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};
        powersOf10 = new int[]{1, 10, 100, 1000, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, 100000, 1000000, 10000000, 100000000, 1000000000};
        halfPowersOf10 = new int[]{3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Channel.UNLIMITED};
        factorials = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
        biggestBinomials = new int[]{Channel.UNLIMITED, Channel.UNLIMITED, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};
    }

    private IntMath() {
    }

    public static int binomial(int r10, int r11) {
        MathPreconditions.checkNonNegative("n", r10);
        MathPreconditions.checkNonNegative("k", r11);
        int r12 = 0;
        if (r11 > r10) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13, "k (%s) > n (%s)", r11, r10);
        if (r11 <= (r10 >> 1)) goto L9;
        r11 = r10 - r11;
    L9:
        int[] r14 = biggestBinomials;
        if (r11 < r14.length) goto L12;
        return Channel.UNLIMITED;
    L12:
        if (r10 > r14[r11]) goto L26;
        if (r11 == 0) goto L21;
        if (r11 == 1) goto L25;
        long r15 = 1;
    L17:
        if (r12 >= r11) goto L20;
        long r16 = r15 * ((long) (r10 - r12));
        r12 = r12 + 1;
        r15 = r16 / ((long) r12);
        goto L17
    L20:
        return (int) r15;
    L25:
        return r10;
    L21:
        return 1;
    L26:
        return Channel.UNLIMITED;
    L5:
        r13 = false;
        goto L6
    }

    @Beta
    public static int ceilingPowerOfTwo(int r10) {
        MathPreconditions.checkPositive(FixCard.FixStyle.KEY_X, r10);
        if (r10 > 1073741824) goto L7;
        return 1 << (-Integer.numberOfLeadingZeros(r10 - 1));
    L7:
        throw new ArithmeticException("ceilingPowerOfTwo(" + r10 + ") not representable as an int");
    }

    public static int checkedAdd(int r10, int r11) {
        long r12 = ((long) r10) + ((long) r11);
        int r13 = (int) r12;
        if (r12 != r13) goto L5;
        boolean r14 = true;
    L6:
        MathPreconditions.checkNoOverflow(r14, "checkedAdd", r10, r11);
        return r13;
    L5:
        r14 = false;
        goto L6
    }

    public static int checkedMultiply(int r10, int r11) {
        long r12 = ((long) r10) * ((long) r11);
        int r13 = (int) r12;
        if (r12 != r13) goto L5;
        boolean r14 = true;
    L6:
        MathPreconditions.checkNoOverflow(r14, "checkedMultiply", r10, r11);
        return r13;
    L5:
        r14 = false;
        goto L6
    }

    public static int checkedPow(int r10, int r11) {
        MathPreconditions.checkNonNegative("exponent", r11);
        boolean r12 = false;
        if (r10 == (-2)) goto L43;
        if (r10 == (-1)) goto L39;
        if (r10 == 0) goto L35;
        if (r10 != 1) goto L8;
        return 1;
    L8:
        if (r10 == 2) goto L30;
        int r13 = 1;
    L10:
        if (r11 == 0) goto L28;
        if (r11 == 1) goto L27;
        if ((r11 & 1) == 0) goto L15;
        r13 = checkedMultiply(r13, r10);
    L15:
        r11 = r11 >> 1;
        if (r11 <= 0) goto L10;
        if ((-46340) > r10) goto L20;
        boolean r14 = true;
    L22:
        if (r10 > FLOOR_SQRT_MAX_INT) goto L24;
        boolean r15 = true;
    L25:
        MathPreconditions.checkNoOverflow(r14 & r15, "checkedPow", r10, r11);
        r10 = r10 * r10;
        goto L10
    L24:
        r15 = false;
        goto L25
    L20:
        r14 = false;
        goto L22
    L27:
        return checkedMultiply(r13, r10);
    L28:
        return r13;
    L30:
        if (r11 >= 31) goto L32;
        r12 = true;
    L32:
        MathPreconditions.checkNoOverflow(r12, "checkedPow", r10, r11);
        return 1 << r11;
    L35:
        if (r11 == 0) goto L37;
        return 0;
    L37:
        return 1;
    L39:
        if ((r11 & 1) == 0) goto L41;
        return -1;
    L41:
        return 1;
    L43:
        if (r11 >= 32) goto L45;
        r12 = true;
    L45:
        MathPreconditions.checkNoOverflow(r12, "checkedPow", r10, r11);
        if ((r11 & 1) != 0) goto L49;
        return 1 << r11;
    L49:
        return (-1) << r11;
    }

    public static int checkedSubtract(int r10, int r11) {
        long r12 = ((long) r10) - ((long) r11);
        int r13 = (int) r12;
        if (r12 != r13) goto L5;
        boolean r14 = true;
    L6:
        MathPreconditions.checkNoOverflow(r14, "checkedSubtract", r10, r11);
        return r13;
    L5:
        r14 = false;
        goto L6
    }

    public static int divide(int r10, int r11, RoundingMode r12) {
        Preconditions.checkNotNull(r12);
        if (r11 == 0) goto L38;
        int r13 = r10 / r11;
        int r14 = r10 - (r11 * r13);
        if (r14 != 0) goto L7;
        return r13;
    L7:
        boolean r15 = true;
        int r16 = ((r10 ^ r11) >> 31) | 1;
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r12.ordinal()]) {
            case 1: goto L32;
            case 2: goto L39;
            case 3: goto L30;
            case 4: goto L44;
            case 5: goto L28;
            case 6: goto L11;
            case 7: goto L11;
            case 8: goto L11;
            default: goto L10;
        };
    L11:
        int r17 = Math.abs(r14);
        int r18 = r17 - (Math.abs(r11) - r17);
        if (r18 == 0) goto L14;
        if (r18 > 0) goto L44;
        return r13;
    L14:
        if (r12 == RoundingMode.HALF_UP) goto L44;
        if (r12 != RoundingMode.HALF_EVEN) goto L18;
        boolean r19 = true;
    L20:
        if ((r13 & 1) != 0) goto L24;
        r15 = false;
    L24:
        if ((r19 & r15) == true) goto L44;
        return r13;
    L18:
        r19 = false;
        goto L20
    L28:
        if (r16 > 0) goto L44;
        return r13;
    L30:
        if (r16 < 0) goto L44;
        return r13;
    L32:
        if (r14 == 0) goto L35;
        r15 = false;
    L35:
        MathPreconditions.checkRoundingUnnecessary(r15);
        return r13;
    L39:
        return r13;
    L10:
        throw new AssertionError();
    L44:
        return r13 + r16;
    L38:
        throw new ArithmeticException("/ by zero");
    }

    public static int factorial(int r10) {
        MathPreconditions.checkNonNegative("n", r10);
        int[] r11 = factorials;
        if (r10 < r11.length) goto L7;
        return Channel.UNLIMITED;
    L7:
        return r11[r10];
    }

    @Beta
    public static int floorPowerOfTwo(int r10) {
        MathPreconditions.checkPositive(FixCard.FixStyle.KEY_X, r10);
        return Integer.highestOneBit(r10);
    }

    public static int gcd(int r10, int r11) {
        MathPreconditions.checkNonNegative("a", r10);
        MathPreconditions.checkNonNegative("b", r11);
        if (r10 != 0) goto L5;
        return r11;
    L5:
        if (r11 != 0) goto L7;
        return r10;
    L7:
        int r12 = Integer.numberOfTrailingZeros(r10);
        int r13 = r10 >> r12;
        int r14 = Integer.numberOfTrailingZeros(r11);
        int r15 = r11 >> r14;
    L8:
        if (r13 == r15) goto L11;
        int r16 = r13 - r15;
        int r17 = (r16 >> 31) & r16;
        int r18 = (r16 - r17) - r17;
        r15 = r15 + r17;
        r13 = r18 >> Integer.numberOfTrailingZeros(r18);
        goto L8
    L11:
        return r13 << Math.min(r12, r14);
    }

    public static boolean isPowerOfTwo(int r10) {
        boolean r11 = false;
        if (r10 <= 0) goto L5;
        boolean r12 = true;
    L7:
        if ((r10 & (r10 - 1)) != 0) goto L10;
        r11 = true;
    L10:
        return r12 & r11;
    L5:
        r12 = false;
        goto L7
    }

    @Beta
    @GwtIncompatible
    public static boolean isPrime(int r10) {
        return LongMath.isPrime(r10);
    }

    @VisibleForTesting
    public static int lessThanBranchFree(int r10, int r11) {
        return (~(~(r10 - r11))) >>> 31;
    }

    @GwtIncompatible
    public static int log10(int r10, RoundingMode r11) {
        MathPreconditions.checkPositive(FixCard.FixStyle.KEY_X, r10);
        int r12 = log10Floor(r10);
        int r13 = powersOf10[r12];
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r11.ordinal()]) {
            case 1: goto L10;
            case 2: goto L14;
            case 3: goto L14;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        int r14 = lessThanBranchFree(halfPowersOf10[r12], r10);
    L8:
        return r12 + r14;
    L9:
        r14 = lessThanBranchFree(r13, r10);
        goto L8
    L10:
        if (r10 != r13) goto L12;
        boolean r15 = true;
    L13:
        MathPreconditions.checkRoundingUnnecessary(r15);
        goto L14
    L12:
        r15 = false;
    L14:
        return r12;
    L5:
        throw new AssertionError();
    }

    private static int log10Floor(int r10) {
        byte r11 = maxLog10ForLeadingZeros[Integer.numberOfLeadingZeros(r10)];
        return r11 - lessThanBranchFree(r10, powersOf10[r11]);
    }

    public static int log2(int r10, RoundingMode r11) {
        MathPreconditions.checkPositive(FixCard.FixStyle.KEY_X, r10);
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r11.ordinal()]) {
            case 1: goto L10;
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        int r12 = Integer.numberOfLeadingZeros(r10);
        return (31 - r12) + lessThanBranchFree(MAX_POWER_OF_SQRT2_UNSIGNED >>> r12, r10);
    L10:
        MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(r10));
        goto L12
    L5:
        throw new AssertionError();
    L9:
        return 32 - Integer.numberOfLeadingZeros(r10 - 1);
    L12:
        return 31 - Integer.numberOfLeadingZeros(r10);
    }

    public static int mean(int r10, int r11) {
        return (r10 & r11) + ((r10 ^ r11) >> 1);
    }

    public static int mod(int r10, int r11) {
        if (r11 <= 0) goto L9;
        int r12 = r10 % r11;
        if (r12 < 0) goto L7;
        return r12;
    L7:
        return r12 + r11;
    L9:
        throw new ArithmeticException("Modulus " + r11 + " must be > 0");
    }

    @GwtIncompatible
    public static int pow(int r10, int r11) {
        MathPreconditions.checkNonNegative("exponent", r11);
        if (r10 != (-2)) goto L5;
        if (r11 < 32) goto L35;
        return 0;
    L35:
        if ((r11 & 1) != 0) goto L38;
        return 1 << r11;
    L38:
        return -(1 << r11);
    L5:
        if (r10 == (-1)) goto L29;
        if (r10 == 0) goto L25;
        if (r10 != 1) goto L9;
        return 1;
    L9:
        if (r10 == 2) goto L21;
        int r12 = 1;
    L11:
        if (r11 == 0) goto L20;
        if (r11 == 1) goto L19;
        if ((r11 & 1) != 0) goto L16;
        int r13 = 1;
    L17:
        r12 = r12 * r13;
        r10 = r10 * r10;
        r11 = r11 >> 1;
        goto L11
    L16:
        r13 = r10;
        goto L17
    L19:
        return r10 * r12;
    L20:
        return r12;
    L21:
        if (r11 < 32) goto L23;
        return 0;
    L23:
        return 1 << r11;
    L25:
        if (r11 == 0) goto L27;
        return 0;
    L27:
        return 1;
    L29:
        if ((r11 & 1) != 0) goto L32;
        return 1;
    L32:
        return -1;
    }

    @Beta
    public static int saturatedAdd(int r10, int r11) {
        return Ints.saturatedCast(((long) r10) + ((long) r11));
    }

    @Beta
    public static int saturatedMultiply(int r10, int r11) {
        return Ints.saturatedCast(((long) r10) * ((long) r11));
    }

    @Beta
    public static int saturatedPow(int r10, int r11) {
        MathPreconditions.checkNonNegative("exponent", r11);
        if (r10 == (-2)) goto L48;
        if (r10 == (-1)) goto L44;
        if (r10 == 0) goto L39;
        if (r10 != 1) goto L9;
        return 1;
    L9:
        if (r10 == 2) goto L34;
        int r12 = ((r10 >>> 31) & (r11 & 1)) + Channel.UNLIMITED;
        int r13 = 1;
    L11:
        if (r11 == 0) goto L32;
        if (r11 == 1) goto L31;
        if ((r11 & 1) == 0) goto L16;
        r13 = saturatedMultiply(r13, r10);
    L16:
        r11 = r11 >> 1;
        if (r11 <= 0) goto L11;
        if ((-46340) <= r10) goto L21;
        boolean r14 = true;
    L23:
        if (r10 <= FLOOR_SQRT_MAX_INT) goto L25;
        boolean r15 = true;
    L27:
        if ((r14 | r15) == true) goto L28;
        r10 = r10 * r10;
        goto L11
    L28:
        return r12;
    L25:
        r15 = false;
        goto L27
    L21:
        r14 = false;
        goto L23
    L31:
        return saturatedMultiply(r13, r10);
    L32:
        return r13;
    L34:
        if (r11 < 31) goto L37;
        return Channel.UNLIMITED;
    L37:
        return 1 << r11;
    L39:
        if (r11 != 0) goto L42;
        return 1;
    L42:
        return 0;
    L44:
        if ((r11 & 1) == 0) goto L46;
        return -1;
    L46:
        return 1;
    L48:
        if (r11 < 32) goto L52;
        return (r11 & 1) + Channel.UNLIMITED;
    L52:
        if ((r11 & 1) != 0) goto L55;
        return 1 << r11;
    L55:
        return (-1) << r11;
    }

    @Beta
    public static int saturatedSubtract(int r10, int r11) {
        return Ints.saturatedCast(((long) r10) - ((long) r11));
    }

    @GwtIncompatible
    public static int sqrt(int r10, RoundingMode r11) {
        MathPreconditions.checkNonNegative(FixCard.FixStyle.KEY_X, r10);
        int r12 = sqrtFloor(r10);
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r11.ordinal()]) {
            case 1: goto L11;
            case 2: goto L15;
            case 3: goto L15;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L6;
            case 7: goto L6;
            case 8: goto L6;
            default: goto L5;
        };
    L6:
        int r13 = lessThanBranchFree((r12 * r12) + r12, r10);
    L8:
        return r12 + r13;
    L9:
        r13 = lessThanBranchFree(r12 * r12, r10);
    L15:
        return r12;
    L5:
        throw new AssertionError();
    L11:
        if ((r12 * r12) != r10) goto L13;
        boolean r14 = true;
    L14:
        MathPreconditions.checkRoundingUnnecessary(r14);
        goto L15
    L13:
        r14 = false;
        goto L14
    }

    private static int sqrtFloor(int r10) {
        return (int) Math.sqrt(r10);
    }
}
