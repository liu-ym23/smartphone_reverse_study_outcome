package com.fasterxml.jackson.core.io.schubfach;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class DoubleToDecimal {
    private static final int BQ_MASK = 2047;
    private static final long C_MIN = 4503599627370496L;
    static final long C_TINY = 3;
    static final int E_MAX = 309;
    static final int E_MIN = -323;
    static final int H = 17;
    static final int K_MAX = 292;
    static final int K_MIN = -324;
    private static final int MASK_28 = 268435455;
    private static final long MASK_63 = Long.MAX_VALUE;
    private static final int MINUS_INF = 4;
    private static final int MINUS_ZERO = 2;
    private static final int NAN = 5;
    private static final int NON_SPECIAL = 0;
    static final int P = 53;
    private static final int PLUS_INF = 3;
    private static final int PLUS_ZERO = 1;
    static final int Q_MAX = 971;
    static final int Q_MIN = -1074;
    private static final long T_MASK = 4503599627370495L;
    private static final int W = 11;
    public final int MAX_CHARS = 24;
    private final byte[] bytes = new byte[24];
    private int index;

    private DoubleToDecimal() {
    }

    private void append(int i) {
        byte[] bArr = this.bytes;
        int i3 = this.index + 1;
        this.index = i3;
        bArr[i3] = (byte) i;
    }

    private void append8Digits(int i) {
        int iY = y(i);
        for (int i3 = 0; i3 < 8; i3++) {
            int i10 = iY * 10;
            appendDigit(i10 >>> 28);
            iY = i10 & MASK_28;
        }
    }

    private void appendDigit(int i) {
        byte[] bArr = this.bytes;
        int i3 = this.index + 1;
        this.index = i3;
        bArr[i3] = (byte) (i + 48);
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
            int i3 = (i * 1311) >>> 17;
            appendDigit(i3);
            i -= i3 * 100;
        }
        int i10 = (i * 103) >>> 10;
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
        byte b10;
        while (true) {
            byte[] bArr = this.bytes;
            i = this.index;
            b10 = bArr[i];
            if (b10 != 48) {
                break;
            } else {
                this.index = i - 1;
            }
        }
        if (b10 == 46) {
            this.index = i + 1;
        }
    }

    private static long rop(long j10, long j11, long j12) {
        long jMultiplyHigh = MathUtils.multiplyHigh(j11, j12);
        long j13 = j10 * j12;
        long jMultiplyHigh2 = MathUtils.multiplyHigh(j10, j12);
        long j14 = (j13 >>> 1) + jMultiplyHigh;
        return (jMultiplyHigh2 + (j14 >>> 63)) | (((j14 & MASK_63) + MASK_63) >>> 63);
    }

    private int toChars(long j10, int i) {
        int iFlog10pow2 = MathUtils.flog10pow2(64 - Long.numberOfLeadingZeros(j10));
        if (j10 >= MathUtils.pow10(iFlog10pow2)) {
            iFlog10pow2++;
        }
        long jPow10 = j10 * MathUtils.pow10(17 - iFlog10pow2);
        int i3 = i + iFlog10pow2;
        long jMultiplyHigh = MathUtils.multiplyHigh(jPow10, 193428131138340668L) >>> 20;
        int i10 = (int) (jPow10 - (100000000 * jMultiplyHigh));
        int i11 = (int) ((1441151881 * jMultiplyHigh) >>> 57);
        int i12 = (int) (jMultiplyHigh - (100000000 * i11));
        return (i3 <= 0 || i3 > 7) ? (-3 >= i3 || i3 > 0) ? toChars3(i11, i12, i10, i3) : toChars2(i11, i12, i10, i3) : toChars1(i11, i12, i10, i3);
    }

    private int toChars1(int i, int i3, int i10, int i11) {
        appendDigit(i);
        int iY = y(i3);
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

    private int toChars2(int i, int i3, int i10, int i11) {
        appendDigit(0);
        append(46);
        while (i11 < 0) {
            appendDigit(0);
            i11++;
        }
        appendDigit(i);
        append8Digits(i3);
        lowDigits(i10);
        return 0;
    }

    private int toChars3(int i, int i3, int i10, int i11) {
        appendDigit(i);
        append(46);
        append8Digits(i3);
        lowDigits(i10);
        exponent(i11 - 1);
        return 0;
    }

    private int toDecimal(int i, long j10, int i3) {
        long j11;
        int iFlog10threeQuartersPow2;
        char c9;
        long j12;
        int i10 = ((int) j10) & 1;
        long j13 = j10 << 2;
        long j14 = j13 + 2;
        if ((j10 != C_MIN) || (i == Q_MIN)) {
            j11 = j13 - 2;
            iFlog10threeQuartersPow2 = MathUtils.flog10pow2(i);
        } else {
            j11 = j13 - 1;
            iFlog10threeQuartersPow2 = MathUtils.flog10threeQuartersPow2(i);
        }
        int iFlog2pow10 = i + MathUtils.flog2pow10(-iFlog10threeQuartersPow2) + 2;
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
            c9 = 1;
            int i11 = iFlog10threeQuartersPow2;
            long j17 = i10;
            boolean z10 = jRop2 + j17 <= (jMultiplyHigh << 2);
            if (z10 != ((j16 << 2) + j17 <= jRop3)) {
                if (!z10) {
                    jMultiplyHigh = j16;
                }
                return toChars(jMultiplyHigh, i11);
            }
            iFlog10threeQuartersPow2 = i11;
        } else {
            c9 = 1;
            j12 = 1;
        }
        long j18 = j15 + j12;
        long j19 = i10;
        char c10 = jRop2 + j19 <= (j15 << 2) ? c9 : (char) 0;
        if (c10 != ((j18 << 2) + j19 <= jRop3 ? c9 : (char) 0)) {
            if (c10 == 0) {
                j15 = j18;
            }
            return toChars(j15, iFlog10threeQuartersPow2 + i3);
        }
        long j20 = jRop - ((j15 + j18) << c9);
        if (j20 >= 0 && (j20 != 0 || (j15 & j12) != 0)) {
            j15 = j18;
        }
        return toChars(j15, iFlog10threeQuartersPow2 + i3);
    }

    private String toDecimalString(double d7) {
        int decimal = toDecimal(d7);
        return decimal != 0 ? decimal != 1 ? decimal != 2 ? decimal != 3 ? decimal != 4 ? "NaN" : "-Infinity" : "Infinity" : "-0.0" : "0.0" : charsToString();
    }

    public static String toString(double d7) {
        return new DoubleToDecimal().toDecimalString(d7);
    }

    private int y(int i) {
        return ((int) (MathUtils.multiplyHigh((i + 1) << 28, 193428131138340668L) >>> 20)) - 1;
    }

    private int toDecimal(double d7) {
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d7);
        long j10 = T_MASK & jDoubleToRawLongBits;
        int i = ((int) (jDoubleToRawLongBits >>> 52)) & BQ_MASK;
        if (i >= BQ_MASK) {
            if (j10 != 0) {
                return 5;
            }
            return jDoubleToRawLongBits > 0 ? 3 : 4;
        }
        this.index = -1;
        if (jDoubleToRawLongBits < 0) {
            append(45);
        }
        if (i == 0) {
            if (j10 == 0) {
                return jDoubleToRawLongBits == 0 ? 1 : 2;
            }
            if (j10 < C_TINY) {
                return toDecimal(Q_MIN, j10 * 10, -1);
            }
            return toDecimal(Q_MIN, j10, 0);
        }
        int i3 = 1075 - i;
        long j11 = j10 | C_MIN;
        if ((i3 < 53) & (i3 > 0)) {
            long j12 = j11 >> i3;
            if ((j12 << i3) == j11) {
                return toChars(j12, 0);
            }
        }
        return toDecimal(-i3, j11, 0);
    }
}
