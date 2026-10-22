package com.fasterxml.jackson.core.io.schubfach;

import v7.o;

/* loaded from: classes2.dex */
public final class DoubleToDecimal {
    private static final int BQ_MASK = 2047;
    private static final long C_MIN = 4503599627370496L;
    static final long C_TINY = 3;
    static final int E_MAX = 309;
    static final int E_MIN = -323;

    /* renamed from: H, reason: collision with root package name */
    static final int f2253H = 17;
    static final int K_MAX = 292;
    static final int K_MIN = -324;
    private static final int MASK_28 = 268435455;
    private static final long MASK_63 = Long.MAX_VALUE;
    private static final int MINUS_INF = 4;
    private static final int MINUS_ZERO = 2;
    private static final int NAN = 5;
    private static final int NON_SPECIAL = 0;

    /* renamed from: P, reason: collision with root package name */
    static final int f2254P = 53;
    private static final int PLUS_INF = 3;
    private static final int PLUS_ZERO = 1;
    static final int Q_MAX = 971;
    static final int Q_MIN = -1074;
    private static final long T_MASK = 4503599627370495L;

    /* renamed from: W, reason: collision with root package name */
    private static final int f2255W = 11;
    public final int MAX_CHARS = 24;
    private final byte[] bytes = new byte[24];
    private int index;

    private DoubleToDecimal() {
    }

    private void append(int i) {
        byte[] bArr = this.bytes;
        int i6 = this.index + 1;
        this.index = i6;
        bArr[i6] = (byte) i;
    }

    private void append8Digits(int i) {
        int iY = y(i);
        for (int i6 = 0; i6 < 8; i6++) {
            int i10 = iY * 10;
            appendDigit(i10 >>> 28);
            iY = i10 & MASK_28;
        }
    }

    private void appendDigit(int i) {
        byte[] bArr = this.bytes;
        int i6 = this.index + 1;
        this.index = i6;
        bArr[i6] = (byte) (i + 48);
    }

    private String charsToString() {
        return new String(this.bytes, 0, 0, this.index + 1);
    }

    private void exponent(int i) {
        append(69);
        if (i < 0) {
            append(45);
            i = -i;
        }
        if (i < 10) {
            appendDigit(i);
            return;
        }
        if (i >= 100) {
            int i6 = (i * 1311) >>> 17;
            appendDigit(i6);
            i -= i6 * 100;
        }
        int i10 = (i * o.META_DATA_FIELD_NUMBER) >>> 10;
        appendDigit(i10);
        appendDigit(i - (i10 * 10));
    }

    private void lowDigits(int i) {
        if (i != 0) {
            append8Digits(i);
        }
        removeTrailingZeroes();
    }

    private void removeTrailingZeroes() {
        int i;
        byte b;
        while (true) {
            byte[] bArr = this.bytes;
            i = this.index;
            b = bArr[i];
            if (b != 48) {
                break;
            } else {
                this.index = i - 1;
            }
        }
        if (b == 46) {
            this.index = i + 1;
        }
    }

    private static long rop(long j5, long j6, long j10) {
        long jMultiplyHigh = MathUtils.multiplyHigh(j6, j10);
        long j11 = j5 * j10;
        long jMultiplyHigh2 = MathUtils.multiplyHigh(j5, j10);
        long j12 = (j11 >>> 1) + jMultiplyHigh;
        return (jMultiplyHigh2 + (j12 >>> 63)) | (((j12 & Long.MAX_VALUE) + Long.MAX_VALUE) >>> 63);
    }

    private int toChars(long j5, int i) {
        int iFlog10pow2 = MathUtils.flog10pow2(64 - Long.numberOfLeadingZeros(j5));
        if (j5 >= MathUtils.pow10(iFlog10pow2)) {
            iFlog10pow2++;
        }
        long jPow10 = j5 * MathUtils.pow10(17 - iFlog10pow2);
        int i6 = i + iFlog10pow2;
        long jMultiplyHigh = MathUtils.multiplyHigh(jPow10, 193428131138340668L) >>> 20;
        int i10 = (int) (jPow10 - (100000000 * jMultiplyHigh));
        int i11 = (int) ((1441151881 * jMultiplyHigh) >>> 57);
        int i12 = (int) (jMultiplyHigh - (100000000 * i11));
        return (i6 <= 0 || i6 > 7) ? (-3 >= i6 || i6 > 0) ? toChars3(i11, i12, i10, i6) : toChars2(i11, i12, i10, i6) : toChars1(i11, i12, i10, i6);
    }

    private int toChars1(int i, int i6, int i10, int i11) {
        appendDigit(i);
        int iY = y(i6);
        int i12 = 1;
        while (i12 < i11) {
            int i13 = iY * 10;
            appendDigit(i13 >>> 28);
            iY = i13 & MASK_28;
            i12++;
        }
        append(46);
        while (i12 <= 8) {
            int i14 = iY * 10;
            appendDigit(i14 >>> 28);
            iY = i14 & MASK_28;
            i12++;
        }
        lowDigits(i10);
        return 0;
    }

    private int toChars2(int i, int i6, int i10, int i11) {
        appendDigit(0);
        append(46);
        while (i11 < 0) {
            appendDigit(0);
            i11++;
        }
        appendDigit(i);
        append8Digits(i6);
        lowDigits(i10);
        return 0;
    }

    private int toChars3(int i, int i6, int i10, int i11) {
        appendDigit(i);
        append(46);
        append8Digits(i6);
        lowDigits(i10);
        exponent(i11 - 1);
        return 0;
    }

    private int toDecimal(double d) {
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        long j5 = T_MASK & jDoubleToRawLongBits;
        int i = ((int) (jDoubleToRawLongBits >>> 52)) & BQ_MASK;
        if (i >= BQ_MASK) {
            if (j5 != 0) {
                return 5;
            }
            return jDoubleToRawLongBits > 0 ? 3 : 4;
        }
        this.index = -1;
        if (jDoubleToRawLongBits < 0) {
            append(45);
        }
        if (i == 0) {
            return j5 != 0 ? j5 < C_TINY ? toDecimal(Q_MIN, j5 * 10, -1) : toDecimal(Q_MIN, j5, 0) : jDoubleToRawLongBits == 0 ? 1 : 2;
        }
        int i6 = 1075 - i;
        long j6 = j5 | C_MIN;
        if ((i6 < 53) & (i6 > 0)) {
            long j10 = j6 >> i6;
            if ((j10 << i6) == j6) {
                return toChars(j10, 0);
            }
        }
        return toDecimal(-i6, j6, 0);
    }

    private String toDecimalString(double d) {
        int decimal = toDecimal(d);
        return decimal != 0 ? decimal != 1 ? decimal != 2 ? decimal != 3 ? decimal != 4 ? "NaN" : "-Infinity" : "Infinity" : "-0.0" : "0.0" : charsToString();
    }

    public static String toString(double d) {
        return new DoubleToDecimal().toDecimalString(d);
    }

    private int y(int i) {
        return ((int) (MathUtils.multiplyHigh((i + 1) << 28, 193428131138340668L) >>> 20)) - 1;
    }

    private int toDecimal(int i, long j5, int i6) {
        long j6;
        int iFlog10threeQuartersPow2;
        char c;
        long j10;
        int i10 = ((int) j5) & 1;
        long j11 = j5 << 2;
        long j12 = j11 + 2;
        if ((j5 != C_MIN) | (i == Q_MIN)) {
            j6 = j11 - 2;
            iFlog10threeQuartersPow2 = MathUtils.flog10pow2(i);
        } else {
            j6 = j11 - 1;
            iFlog10threeQuartersPow2 = MathUtils.flog10threeQuartersPow2(i);
        }
        int iFlog2pow10 = i + MathUtils.flog2pow10(-iFlog10threeQuartersPow2) + 2;
        long jG1 = MathUtils.g1(iFlog10threeQuartersPow2);
        long jG0 = MathUtils.g0(iFlog10threeQuartersPow2);
        long jRop = rop(jG1, jG0, j11 << iFlog2pow10);
        long jRop2 = rop(jG1, jG0, j6 << iFlog2pow10);
        long jRop3 = rop(jG1, jG0, j12 << iFlog2pow10);
        long j13 = jRop >> 2;
        if (j13 >= 100) {
            j10 = 1;
            long jMultiplyHigh = MathUtils.multiplyHigh(j13, 1844674407370955168L) * 10;
            long j14 = jMultiplyHigh + 10;
            c = 1;
            int i11 = iFlog10threeQuartersPow2;
            long j15 = i10;
            boolean z10 = jRop2 + j15 <= (jMultiplyHigh << 2);
            if (z10 != ((j14 << 2) + j15 <= jRop3)) {
                if (!z10) {
                    jMultiplyHigh = j14;
                }
                return toChars(jMultiplyHigh, i11);
            }
            iFlog10threeQuartersPow2 = i11;
        } else {
            c = 1;
            j10 = 1;
        }
        long j16 = j13 + j10;
        long j17 = i10;
        char c2 = jRop2 + j17 <= (j13 << 2) ? c : (char) 0;
        if (c2 != ((j16 << 2) + j17 <= jRop3 ? c : (char) 0)) {
            if (c2 == 0) {
                j13 = j16;
            }
            return toChars(j13, iFlog10threeQuartersPow2 + i6);
        }
        long j18 = jRop - ((j13 + j16) << c);
        if (j18 >= 0 && (j18 != 0 || (j13 & j10) != 0)) {
            j13 = j16;
        }
        return toChars(j13, iFlog10threeQuartersPow2 + i6);
    }
}
