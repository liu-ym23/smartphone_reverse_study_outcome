package com.google.common.math;

import com.android.contacts.common.compat.DirectorySdkCompat;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.bytedance.sysoptimizer.StackLeakChecker;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes2.dex */
public final class LongMath {
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;
    static final int[] biggestBinomials = null;
    static final int[] biggestSimpleBinomials = null;
    static final long[] factorials = null;
    static final long[] halfPowersOf10 = null;
    static final byte[] maxLog10ForLeadingZeros = null;
    static final long[] powersOf10 = null;

    /* JADX INFO: renamed from: com.google.common.math.LongMath$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$java$math$RoundingMode = null;

        static {
            int[] r0 = new int[RoundingMode.values().length];
            $SwitchMap$java$math$RoundingMode = r0;
            r0[RoundingMode.UNNECESSARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
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

    static boolean fitsInInt(long r2) {
        if (((int) r2) != r2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isPowerOfTwo(long r7) {
        boolean r3 = true;
        if (r7 <= 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r7 & (r7 - 1)) == 0) goto L11;
        r3 = false;
    L11:
        return r2 & r3;
    L5:
        r2 = false;
        goto L7
    }

    static int lessThanBranchFree(long r0, long r2) {
        return (int) ((~(~(r0 - r2))) >>> 63);
    }

    public static long mean(long r2, long r4) {
        return (r2 & r4) + ((r2 ^ r4) >> 1);
    }

    public static int log2(long r2, RoundingMode r4) {
        MathPreconditions.checkPositive(MaterialConfigFormatNames.X, r2);
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r4.ordinal()]) {
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
        int r5 = Long.numberOfLeadingZeros(r2);
        long r0 = MAX_POWER_OF_SQRT2_UNSIGNED >>> r5;
        return (63 - r5) + lessThanBranchFree(r0, r2);
    L10:
        MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(r2));
        goto L12
    L5:
        throw new AssertionError("impossible");
    L9:
        return 64 - Long.numberOfLeadingZeros(r2 - 1);
    L12:
        return 63 - Long.numberOfLeadingZeros(r2);
    }

    public static int log10(long r4, RoundingMode r6) {
        MathPreconditions.checkPositive(MaterialConfigFormatNames.X, r4);
        int r0 = log10Floor(r4);
        long r1 = powersOf10[r0];
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r6.ordinal()]) {
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
        int r5 = lessThanBranchFree(halfPowersOf10[r0], r4);
    L8:
        return r0 + r5;
    L9:
        r5 = lessThanBranchFree(r1, r4);
    L15:
        return r0;
    L5:
        throw new AssertionError();
    L11:
        if (r4 != r1) goto L13;
        boolean r7 = true;
    L14:
        MathPreconditions.checkRoundingUnnecessary(r7);
        goto L15
    L13:
        r7 = false;
        goto L14
    }

    static int log10Floor(long r3) {
        byte r0 = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(r3)];
        return r0 - lessThanBranchFree(r3, powersOf10[r0]);
    }

    static {
        maxLog10ForLeadingZeros = new byte[]{19, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, 17, 17, 17, Ascii.DLE, Ascii.DLE, Ascii.DLE, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SO, Ascii.SO, Ascii.SO, Ascii.CR, Ascii.CR, Ascii.CR, Ascii.FF, Ascii.FF, Ascii.FF, Ascii.FF, Ascii.VT, Ascii.VT, Ascii.VT, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};
        powersOf10 = new long[]{1, 10, 100, 1000, 10000, 100000, 1000000, StackLeakChecker.CHECK_INTERVAL_10_SEC, 100000000, DirectorySdkCompat.ENTERPRISE_LOCAL_DEFAULT, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};
        halfPowersOf10 = new long[]{3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
        factorials = new long[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
        biggestBinomials = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, HttpStatus.SC_PARTIAL_CONTENT, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
        biggestSimpleBinomials = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    }

    public static long pow(long r8, int r10) {
        MathPreconditions.checkNonNegative("exponent", r10);
        if ((-2) <= r8) goto L5;
    L36:
        long r4 = 1;
    L37:
        if (r10 == 0) goto L54;
        if (r10 == 1) goto L45;
        if ((r10 & 1) != 0) goto L42;
        long r6 = 1;
    L43:
        r4 = r4 * r6;
        r8 = r8 * r8;
        r10 = r10 >> 1;
        goto L37
    L42:
        r6 = r8;
        goto L43
    L45:
        return r4 * r8;
    L54:
        return r4;
    L5:
        if (r8 > 2) goto L36;
        int r9 = (int) r8;
        if (r9 != (-2)) goto L9;
        if (r10 < 64) goto L31;
        return 0;
    L31:
        if ((r10 & 1) != 0) goto L34;
        return 1 << r10;
    L34:
        return -(1 << r10);
    L9:
        if (r9 == (-1)) goto L25;
        if (r9 == 0) goto L20;
        if (r9 != 1) goto L13;
        return 1;
    L13:
        if (r9 != 2) goto L18;
        if (r10 < 64) goto L16;
        return 0;
    L16:
        return 1 << r10;
    L18:
        throw new AssertionError();
    L20:
        if (r10 != 0) goto L23;
        return 1;
    L23:
        return 0;
    L25:
        if ((r10 & 1) == 0) goto L52;
        return -1;
    L52:
        return 1;
    }

    public static long sqrt(long r8, RoundingMode r10) {
        MathPreconditions.checkNonNegative(MaterialConfigFormatNames.X, r8);
        if (fitsInInt(r8) == true) goto L5;
        long r0 = (long) Math.sqrt(r8);
        long r2 = r0 * r0;
        boolean r6 = true;
        int r7 = 1;
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r10.ordinal()]) {
            case 1: goto L25;
            case 2: goto L21;
            case 3: goto L21;
            case 4: goto L17;
            case 5: goto L17;
            case 6: goto L11;
            case 7: goto L11;
            case 8: goto L11;
            default: goto L9;
        };
    L9:
        throw new AssertionError();
    L11:
        if (r8 < r2) goto L14;
        r7 = 0;
    L14:
        long r1 = r0 - ((long) r7);
        return r1 + ((long) lessThanBranchFree((r1 * r1) + r1, r8));
    L17:
        if (r8 > r2) goto L19;
        return r0;
    L19:
        return r0 + 1;
    L21:
        if (r8 < r2) goto L23;
        return r0;
    L23:
        return r0 - 1;
    L25:
        if (r2 == r8) goto L28;
        r6 = false;
    L28:
        MathPreconditions.checkRoundingUnnecessary(r6);
        return r0;
    L5:
        return IntMath.sqrt((int) r8, r10);
    }

    public static long divide(long r9, long r11, RoundingMode r13) {
        Preconditions.checkNotNull(r13);
        long r0 = r9 / r11;
        long r2 = r9 - (r11 * r0);
        if (r2 != 0) goto L5;
        return r0;
    L5:
        boolean r10 = true;
        int r12 = ((int) ((r9 ^ r11) >> 63)) | 1;
        switch(AnonymousClass1.$SwitchMap$java$math$RoundingMode[r13.ordinal()]) {
            case 1: goto L30;
            case 2: goto L34;
            case 3: goto L28;
            case 4: goto L35;
            case 5: goto L26;
            case 6: goto L9;
            case 7: goto L9;
            case 8: goto L9;
            default: goto L8;
        };
    L9:
        long r3 = Math.abs(r2);
        long r4 = r3 - (Math.abs(r11) - r3);
        if (r4 == 0) goto L12;
        if (r4 <= 0) goto L34;
    L12:
        if (r13 != RoundingMode.HALF_UP) goto L14;
        boolean r14 = true;
    L16:
        if (r13 != RoundingMode.HALF_EVEN) goto L18;
        boolean r15 = true;
    L20:
        if ((1 & r0) != 0) goto L23;
        r10 = false;
    L23:
        r10 = (r10 & r15) | r14;
        goto L35
    L18:
        r15 = false;
        goto L20
    L14:
        r14 = false;
        goto L16
    L26:
        if (r12 <= 0) goto L34;
    L28:
        if (r12 >= 0) goto L34;
    L30:
        if (r2 == 0) goto L33;
        r10 = false;
    L33:
        MathPreconditions.checkRoundingUnnecessary(r10);
    L34:
        r10 = false;
    L35:
        if (r10 == true) goto L37;
        return r0;
    L37:
        return r0 + ((long) r12);
    L8:
        throw new AssertionError();
    }

    public static int mod(long r2, int r4) {
        return (int) mod(r2, r4);
    }

    public static long mod(long r3, long r5) {
        if (r5 <= 0) goto L10;
        long r4 = r3 % r5;
        if (r4 < 0) goto L8;
        return r4;
    L8:
        return r4 + r5;
    L10:
        throw new ArithmeticException("Modulus must be positive");
    }

    public static long gcd(long r4, long r6) {
        MathPreconditions.checkNonNegative("a", r4);
        MathPreconditions.checkNonNegative("b", r6);
        if (r4 != 0) goto L6;
        return r6;
    L6:
        if (r6 != 0) goto L8;
        return r4;
    L8:
        int r0 = Long.numberOfTrailingZeros(r4);
        long r5 = r4 >> r0;
        int r1 = Long.numberOfTrailingZeros(r6);
        long r7 = r6 >> r1;
    L10:
        if (r5 == r7) goto L13;
        long r8 = r5 - r7;
        long r2 = (r8 >> 63) & r8;
        long r9 = (r8 - r2) - r2;
        r7 = r7 + r2;
        r5 = r9 >> Long.numberOfTrailingZeros(r9);
        goto L10
    L13:
        return r5 << Math.min(r0, r1);
    }

    public static long checkedAdd(long r5, long r7) {
        long r0 = r5 + r7;
        boolean r8 = true;
        if ((r7 ^ r5) >= 0) goto L5;
        boolean r9 = true;
    L7:
        if ((r5 ^ r0) >= 0) goto L10;
        r8 = false;
    L10:
        MathPreconditions.checkNoOverflow(r9 | r8);
        return r0;
    L5:
        r9 = false;
        goto L7
    }

    public static long checkedSubtract(long r5, long r7) {
        long r0 = r5 - r7;
        boolean r8 = true;
        if ((r7 ^ r5) < 0) goto L5;
        boolean r9 = true;
    L7:
        if ((r5 ^ r0) >= 0) goto L10;
        r8 = false;
    L10:
        MathPreconditions.checkNoOverflow(r9 | r8);
        return r0;
    L5:
        r9 = false;
        goto L7
    }

    public static long checkedMultiply(long r6, long r8) {
        int r0 = ((Long.numberOfLeadingZeros(r6) + Long.numberOfLeadingZeros(~r6)) + Long.numberOfLeadingZeros(r8)) + Long.numberOfLeadingZeros(~r8);
        if (r0 > 65) goto L5;
        boolean r2 = true;
        if (r0 < 64) goto L9;
        boolean r1 = true;
    L10:
        MathPreconditions.checkNoOverflow(r1);
        if (r6 < 0) goto L13;
        boolean r3 = true;
    L15:
        if (r8 == Long.MIN_VALUE) goto L17;
        boolean r4 = true;
    L18:
        MathPreconditions.checkNoOverflow(r3 | r4);
        long r5 = r6 * r8;
        if (r6 != 0) goto L21;
    L24:
        MathPreconditions.checkNoOverflow(r2);
        return r5;
    L21:
        if ((r5 / r6) == r8) goto L24;
        r2 = false;
        goto L24
    L17:
        r4 = false;
        goto L18
    L13:
        r3 = false;
        goto L15
    L9:
        r1 = false;
        goto L10
    L5:
        return r6 * r8;
    }

    public static long checkedPow(long r7, int r9) {
        MathPreconditions.checkNonNegative("exponent", r9);
        boolean r1 = false;
        if (r7 < (-2)) goto L5;
        boolean r0 = true;
    L7:
        if (r7 > 2) goto L9;
        boolean r3 = true;
    L10:
        boolean r2 = r0 & r3;
        long r4 = 1;
        if (r2 == false) goto L45;
        int r8 = (int) r7;
        if (r8 == (-2)) goto L38;
        if (r8 == (-1)) goto L33;
        if (r8 == 0) goto L28;
        if (r8 != 1) goto L19;
        return 1;
    L19:
        if (r8 != 2) goto L26;
        if (r9 >= 63) goto L23;
        r1 = true;
    L23:
        MathPreconditions.checkNoOverflow(r1);
        return 1 << r9;
    L26:
        throw new AssertionError();
    L28:
        if (r9 == 0) goto L66;
        return 0;
    L66:
        return 1;
    L33:
        if ((r9 & 1) != 0) goto L36;
        return 1;
    L36:
        return -1;
    L38:
        if (r9 >= 64) goto L40;
        r1 = true;
    L40:
        MathPreconditions.checkNoOverflow(r1);
        if ((r9 & 1) != 0) goto L44;
        return 1 << r9;
    L44:
        return (-1) << r9;
    L45:
        if (r9 == 0) goto L59;
        if (r9 == 1) goto L58;
        if ((r9 & 1) == 0) goto L50;
        r4 = checkedMultiply(r4, r7);
    L50:
        r9 = r9 >> 1;
        if (r9 <= 0) goto L45;
        if (r7 > FLOOR_SQRT_MAX_LONG) goto L55;
        boolean r5 = true;
    L56:
        MathPreconditions.checkNoOverflow(r5);
        r7 = r7 * r7;
        goto L45
    L55:
        r5 = false;
        goto L56
    L58:
        return checkedMultiply(r4, r7);
    L59:
        return r4;
    L9:
        r3 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    public static long factorial(int r2) {
        MathPreconditions.checkNonNegative("n", r2);
        long[] r0 = factorials;
        if (r2 < r0.length) goto L7;
        return Long.MAX_VALUE;
    L7:
        return r0[r2];
    }

    public static long binomial(int r11, int r12) {
        MathPreconditions.checkNonNegative("n", r11);
        MathPreconditions.checkNonNegative("k", r12);
        if (r12 > r11) goto L5;
        boolean r2 = true;
    L6:
        int r3 = 2;
        Preconditions.checkArgument(r2, "k (%s) > n (%s)", new Object[]{Integer.valueOf(r12), Integer.valueOf(r11)});
        if (r12 <= (r11 >> 1)) goto L10;
        r12 = r11 - r12;
    L10:
        if (r12 == 0) goto L42;
        if (r12 == 1) goto L41;
        long[] r0 = factorials;
        if (r11 < r0.length) goto L15;
        int[] r1 = biggestBinomials;
        if (r12 < r1.length) goto L19;
        return Long.MAX_VALUE;
    L19:
        if (r11 > r1[r12]) goto L47;
        int[] r4 = biggestSimpleBinomials;
        if (r12 < r4.length) goto L24;
    L29:
        long r5 = r11;
        int r6 = log2(r5, RoundingMode.CEILING);
        int r13 = r11 - 1;
        long r7 = 1;
        long r8 = r5;
        int r9 = r6;
        int r10 = 2;
        long r14 = 1;
    L30:
        if (r10 > r12) goto L37;
        r9 = r9 + r6;
        if (r9 >= 63) goto L34;
        r8 = r8 * ((long) r13);
        r7 = r7 * ((long) r10);
    L35:
        r10 = r10 + 1;
        r13 = r13 - 1;
        goto L30
    L34:
        r14 = multiplyFraction(r14, r8, r7);
        r8 = r13;
        r7 = r10;
        r9 = r6;
        goto L35
    L37:
        return multiplyFraction(r14, r8, r7);
    L24:
        if (r11 > r4[r12]) goto L29;
        int r15 = r11 - 1;
        long r16 = r11;
    L26:
        if (r3 > r12) goto L28;
        r16 = (r16 * ((long) r15)) / ((long) r3);
        r15 = r15 - 1;
        r3 = r3 + 1;
        goto L26
    L28:
        return r16;
    L47:
        return Long.MAX_VALUE;
    L15:
        return r0[r11] / (r0[r12] * r0[r11 - r12]);
    L41:
        return r11;
    L42:
        return 1;
    L5:
        r2 = false;
        goto L6
    }

    static long multiplyFraction(long r2, long r4, long r6) {
        if (r2 == 1) goto L5;
        long r0 = gcd(r2, r6);
        return (r2 / r0) * (r4 / (r6 / r0));
    L5:
        return r4 / r6;
    }

    private LongMath() {
    }
}
