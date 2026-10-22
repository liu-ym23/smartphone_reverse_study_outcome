package com.fasterxml.jackson.core.io.schubfach;

/* loaded from: classes.dex */
public final class DoubleToDecimal {
    private static final int BQ_MASK = 2047;
    private static final long C_MIN = 4503599627370496L;
    static final long C_TINY = 3;
    static final int E_MAX = 309;
    static final int E_MIN = -323;

    /* renamed from: H, reason: collision with root package name */
    static final int f19318H = 17;
    static final int K_MAX = 292;
    static final int K_MIN = -324;
    private static final int MASK_28 = 268435455;
    private static final long MASK_63 = Long.MAX_VALUE;
    private static final int MINUS_INF = 4;
    private static final int MINUS_ZERO = 2;
    private static final int NAN = 5;
    private static final int NON_SPECIAL = 0;

    /* renamed from: P, reason: collision with root package name */
    static final int f19319P = 53;
    private static final int PLUS_INF = 3;
    private static final int PLUS_ZERO = 1;
    static final int Q_MAX = 971;
    static final int Q_MIN = -1074;
    private static final long T_MASK = 4503599627370495L;

    /* renamed from: W, reason: collision with root package name */
    private static final int f19320W = 11;
    public final int MAX_CHARS = 24;
    private final byte[] bytes = new byte[24];
    private int index;

    private DoubleToDecimal() {
    }

    private void append(int i10) {
        byte[] bArr = this.bytes;
        int i11 = this.index + 1;
        this.index = i11;
        bArr[i11] = (byte) i10;
    }

    private void append8Digits(int i10) {
        int iY = y(i10);
        for (int i11 = 0; i11 < 8; i11++) {
            int i12 = iY * 10;
            appendDigit(i12 >>> 28);
            iY = i12 & MASK_28;
        }
    }

    private void appendDigit(int i10) {
        byte[] bArr = this.bytes;
        int i11 = this.index + 1;
        this.index = i11;
        bArr[i11] = (byte) (i10 + 48);
    }

    private String charsToString() {
        return new String(this.bytes, 0, 0, this.index + 1);
    }

    private void exponent(int i10) {
        append(69);
        if (i10 < 0) {
            append(45);
            i10 = -i10;
        }
        if (i10 < 10) {
            appendDigit(i10);
            return;
        }
        if (i10 >= 100) {
            int i11 = (i10 * 1311) >>> 17;
            appendDigit(i11);
            i10 -= i11 * 100;
        }
        int i12 = (i10 * 103) >>> 10;
        appendDigit(i12);
        appendDigit(i10 - (i12 * 10));
    }

    private void lowDigits(int i10) {
        if (i10 != 0) {
            append8Digits(i10);
        }
        removeTrailingZeroes();
    }

    private void removeTrailingZeroes() {
        int i10;
        byte b10;
        while (true) {
            byte[] bArr = this.bytes;
            i10 = this.index;
            b10 = bArr[i10];
            if (b10 != 48) {
                break;
            } else {
                this.index = i10 - 1;
            }
        }
        if (b10 == 46) {
            this.index = i10 + 1;
        }
    }

    private static long rop(long j10, long j11, long j12) {
        long jMultiplyHigh = MathUtils.multiplyHigh(j11, j12);
        long j13 = j10 * j12;
        long jMultiplyHigh2 = MathUtils.multiplyHigh(j10, j12);
        long j14 = (j13 >>> 1) + jMultiplyHigh;
        return (jMultiplyHigh2 + (j14 >>> 63)) | (((j14 & Long.MAX_VALUE) + Long.MAX_VALUE) >>> 63);
    }

    private int toChars(long j10, int i10) {
        int iFlog10pow2 = MathUtils.flog10pow2(64 - Long.numberOfLeadingZeros(j10));
        if (j10 >= MathUtils.pow10(iFlog10pow2)) {
            iFlog10pow2++;
        }
        long jPow10 = j10 * MathUtils.pow10(17 - iFlog10pow2);
        int i11 = i10 + iFlog10pow2;
        long jMultiplyHigh = MathUtils.multiplyHigh(jPow10, 193428131138340668L) >>> 20;
        int i12 = (int) (jPow10 - (100000000 * jMultiplyHigh));
        int i13 = (int) ((1441151881 * jMultiplyHigh) >>> 57);
        int i14 = (int) (jMultiplyHigh - (100000000 * i13));
        return (i11 <= 0 || i11 > 7) ? (-3 >= i11 || i11 > 0) ? toChars3(i13, i14, i12, i11) : toChars2(i13, i14, i12, i11) : toChars1(i13, i14, i12, i11);
    }

    private int toChars1(int i10, int i11, int i12, int i13) {
        appendDigit(i10);
        int iY = y(i11);
        int i14 = 1;
        while (i14 < i13) {
            int i15 = iY * 10;
            appendDigit(i15 >>> 28);
            iY = i15 & MASK_28;
            i14++;
        }
        append(46);
        while (i14 <= 8) {
            int i16 = iY * 10;
            appendDigit(i16 >>> 28);
            iY = i16 & MASK_28;
            i14++;
        }
        lowDigits(i12);
        return 0;
    }

    private int toChars2(int i10, int i11, int i12, int i13) {
        appendDigit(0);
        append(46);
        while (i13 < 0) {
            appendDigit(0);
            i13++;
        }
        appendDigit(i10);
        append8Digits(i11);
        lowDigits(i12);
        return 0;
    }

    private int toChars3(int i10, int i11, int i12, int i13) {
        appendDigit(i10);
        append(46);
        append8Digits(i11);
        lowDigits(i12);
        exponent(i13 - 1);
        return 0;
    }

    private int toDecimal(double d10) {
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d10);
        long j10 = T_MASK & jDoubleToRawLongBits;
        int i10 = ((int) (jDoubleToRawLongBits >>> 52)) & BQ_MASK;
        if (i10 >= BQ_MASK) {
            if (j10 != 0) {
                return 5;
            }
            return jDoubleToRawLongBits > 0 ? 3 : 4;
        }
        this.index = -1;
        if (jDoubleToRawLongBits < 0) {
            append(45);
        }
        if (i10 == 0) {
            return j10 != 0 ? j10 < 3 ? toDecimal(Q_MIN, j10 * 10, -1) : toDecimal(Q_MIN, j10, 0) : jDoubleToRawLongBits == 0 ? 1 : 2;
        }
        int i11 = 1075 - i10;
        long j11 = j10 | C_MIN;
        if ((i11 < 53) & (i11 > 0)) {
            long j12 = j11 >> i11;
            if ((j12 << i11) == j11) {
                return toChars(j12, 0);
            }
        }
        return toDecimal(-i11, j11, 0);
    }

    private String toDecimalString(double d10) {
        int decimal = toDecimal(d10);
        return decimal != 0 ? decimal != 1 ? decimal != 2 ? decimal != 3 ? decimal != 4 ? "NaN" : "-Infinity" : "Infinity" : "-0.0" : "0.0" : charsToString();
    }

    public static String toString(double d10) {
        return new DoubleToDecimal().toDecimalString(d10);
    }

    private int y(int i10) {
        return ((int) (MathUtils.multiplyHigh((i10 + 1) << 28, 193428131138340668L) >>> 20)) - 1;
    }

    private int toDecimal(int i10, long j10, int i11) {
        long j11;
        int iFlog10threeQuartersPow2;
        char c10;
        long j12;
        int i12 = ((int) j10) & 1;
        long j13 = j10 << 2;
        long j14 = j13 + 2;
        if ((j10 != C_MIN) | (i10 == Q_MIN)) {
            j11 = j13 - 2;
            iFlog10threeQuartersPow2 = MathUtils.flog10pow2(i10);
        } else {
            j11 = j13 - 1;
            iFlog10threeQuartersPow2 = MathUtils.flog10threeQuartersPow2(i10);
        }
        int iFlog2pow10 = i10 + MathUtils.flog2pow10(-iFlog10threeQuartersPow2) + 2;
        long jG1 = MathUtils.g1(iFlog10threeQuartersPow2);
        long jG0 = MathUtils.g0(iFlog10threeQuartersPow2);
        long jRop = rop(jG1, jG0, j13 << iFlog2pow10);
        long jRop2 = rop(jG1, jG0, j11 << iFlog2pow10);
        long jRop3 = rop(jG1, jG0, j14 << iFlog2pow10);
        long j15 = jRop >> 2;
        if (j15 >= 100) {
            j12 = 1;
            long jMultiplyHigh = MathUtils.multiplyHigh(j15, 1844674407370955168L) * 10;
            long j16 = jMultiplyHigh + 10;
            c10 = 1;
            int i13 = iFlog10threeQuartersPow2;
            long j17 = i12;
            boolean z10 = jRop2 + j17 <= (jMultiplyHigh << 2);
            if (z10 != ((j16 << 2) + j17 <= jRop3)) {
                if (!z10) {
                    jMultiplyHigh = j16;
                }
                return toChars(jMultiplyHigh, i13);
            }
            iFlog10threeQuartersPow2 = i13;
        } else {
            c10 = 1;
            j12 = 1;
        }
        long j18 = j15 + j12;
        long j19 = i12;
        char c11 = jRop2 + j19 <= (j15 << 2) ? c10 : (char) 0;
        if (c11 != ((j18 << 2) + j19 <= jRop3 ? c10 : (char) 0)) {
            if (c11 == 0) {
                j15 = j18;
            }
            return toChars(j15, iFlog10threeQuartersPow2 + i11);
        }
        long j20 = jRop - ((j15 + j18) << c10);
        if (j20 >= 0 && (j20 != 0 || (j15 & j12) != 0)) {
            j15 = j18;
        }
        return toChars(j15, iFlog10threeQuartersPow2 + i11);
    }
}
