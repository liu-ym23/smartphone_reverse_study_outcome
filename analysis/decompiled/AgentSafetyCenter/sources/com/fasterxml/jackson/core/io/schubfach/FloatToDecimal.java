package com.fasterxml.jackson.core.io.schubfach;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class FloatToDecimal {
    private static final int BQ_MASK = 255;
    private static final int C_MIN = 8388608;
    static final int C_TINY = 8;
    static final int E_MAX = 39;
    static final int E_MIN = -44;
    static final int H = 9;
    static final int K_MAX = 31;
    static final int K_MIN = -45;
    private static final int MASK_28 = 268435455;
    private static final long MASK_32 = 4294967295L;
    private static final int MINUS_INF = 4;
    private static final int MINUS_ZERO = 2;
    private static final int NAN = 5;
    private static final int NON_SPECIAL = 0;
    static final int P = 24;
    private static final int PLUS_INF = 3;
    private static final int PLUS_ZERO = 1;
    static final int Q_MAX = 104;
    static final int Q_MIN = -149;
    private static final int T_MASK = 8388607;
    private static final int W = 8;
    public final int MAX_CHARS = 15;
    private final byte[] bytes = new byte[15];
    private int index;

    private FloatToDecimal() {
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
        int i3 = (i * 103) >>> 10;
        appendDigit(i3);
        appendDigit(i - (i3 * 10));
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

    private static int rop(long j10, long j11) {
        long jMultiplyHigh = MathUtils.multiplyHigh(j10, j11);
        return (int) ((((jMultiplyHigh & MASK_32) + MASK_32) >>> 32) | (jMultiplyHigh >>> 31));
    }

    private int toChars(int i, int i3) {
        int iFlog10pow2 = MathUtils.flog10pow2(32 - Integer.numberOfLeadingZeros(i));
        long j10 = i;
        if (j10 >= MathUtils.pow10(iFlog10pow2)) {
            iFlog10pow2++;
        }
        int iPow10 = (int) (j10 * MathUtils.pow10(9 - iFlog10pow2));
        int i10 = i3 + iFlog10pow2;
        int i11 = (int) ((iPow10 * 1441151881) >>> 57);
        int i12 = iPow10 - (100000000 * i11);
        return (i10 <= 0 || i10 > 7) ? (-3 >= i10 || i10 > 0) ? toChars3(i11, i12, i10) : toChars2(i11, i12, i10) : toChars1(i11, i12, i10);
    }

    private int toChars1(int i, int i3, int i10) {
        appendDigit(i);
        int iY = y(i3);
        int i11 = 1;
        while (i11 < i10) {
            int i12 = iY * 10;
            appendDigit(i12 >>> 28);
            iY = i12 & MASK_28;
            i11++;
        }
        append(46);
        while (i11 <= 8) {
            int i13 = iY * 10;
            appendDigit(i13 >>> 28);
            iY = i13 & MASK_28;
            i11++;
        }
        removeTrailingZeroes();
        return 0;
    }

    private int toChars2(int i, int i3, int i10) {
        appendDigit(0);
        append(46);
        while (i10 < 0) {
            appendDigit(0);
            i10++;
        }
        appendDigit(i);
        append8Digits(i3);
        removeTrailingZeroes();
        return 0;
    }

    private int toChars3(int i, int i3, int i10) {
        appendDigit(i);
        append(46);
        append8Digits(i3);
        removeTrailingZeroes();
        exponent(i10 - 1);
        return 0;
    }

    private int toDecimal(int i, int i3, int i10) {
        long j10;
        int iFlog10threeQuartersPow2;
        int i11 = i3 & 1;
        long j11 = i3 << 2;
        long j12 = j11 + 2;
        if ((i3 != C_MIN) || (i == Q_MIN)) {
            j10 = j11 - 2;
            iFlog10threeQuartersPow2 = MathUtils.flog10pow2(i);
        } else {
            j10 = j11 - 1;
            iFlog10threeQuartersPow2 = MathUtils.flog10threeQuartersPow2(i);
        }
        int iFlog2pow10 = i + MathUtils.flog2pow10(-iFlog10threeQuartersPow2) + 33;
        long jG1 = 1 + MathUtils.g1(iFlog10threeQuartersPow2);
        int iRop = rop(jG1, j11 << iFlog2pow10);
        int iRop2 = rop(jG1, j10 << iFlog2pow10);
        int iRop3 = rop(jG1, j12 << iFlog2pow10);
        int i12 = iRop >> 2;
        if (i12 >= 100) {
            int i13 = ((int) ((i12 * 1717986919) >>> 34)) * 10;
            int i14 = i13 + 10;
            boolean z10 = iRop2 + i11 <= (i13 << 2);
            if (z10 != ((i14 << 2) + i11 <= iRop3)) {
                if (!z10) {
                    i13 = i14;
                }
                return toChars(i13, iFlog10threeQuartersPow2);
            }
        }
        int i15 = i12 + 1;
        boolean z11 = iRop2 + i11 <= (i12 << 2);
        if (z11 != ((i15 << 2) + i11 <= iRop3)) {
            if (!z11) {
                i12 = i15;
            }
            return toChars(i12, iFlog10threeQuartersPow2 + i10);
        }
        int i16 = iRop - ((i12 + i15) << 1);
        if (i16 >= 0 && (i16 != 0 || (i12 & 1) != 0)) {
            i12 = i15;
        }
        return toChars(i12, iFlog10threeQuartersPow2 + i10);
    }

    private String toDecimalString(float f5) {
        int decimal = toDecimal(f5);
        return decimal != 0 ? decimal != 1 ? decimal != 2 ? decimal != 3 ? decimal != 4 ? "NaN" : "-Infinity" : "Infinity" : "-0.0" : "0.0" : charsToString();
    }

    public static String toString(float f5) {
        return new FloatToDecimal().toDecimalString(f5);
    }

    private int y(int i) {
        return ((int) (MathUtils.multiplyHigh((i + 1) << 28, 193428131138340668L) >>> 20)) - 1;
    }

    private int toDecimal(float f5) {
        int iFloatToRawIntBits = Float.floatToRawIntBits(f5);
        int i = T_MASK & iFloatToRawIntBits;
        int i3 = (iFloatToRawIntBits >>> 23) & BQ_MASK;
        if (i3 >= BQ_MASK) {
            if (i != 0) {
                return 5;
            }
            return iFloatToRawIntBits > 0 ? 3 : 4;
        }
        this.index = -1;
        if (iFloatToRawIntBits < 0) {
            append(45);
        }
        if (i3 == 0) {
            if (i == 0) {
                return iFloatToRawIntBits == 0 ? 1 : 2;
            }
            if (i < 8) {
                return toDecimal(Q_MIN, i * 10, -1);
            }
            return toDecimal(Q_MIN, i, 0);
        }
        int i10 = 150 - i3;
        int i11 = i | C_MIN;
        if ((i10 > 0) & (i10 < 24)) {
            int i12 = i11 >> i10;
            if ((i12 << i10) == i11) {
                return toChars(i12, 0);
            }
        }
        return toDecimal(-i10, i11, 0);
    }
}
