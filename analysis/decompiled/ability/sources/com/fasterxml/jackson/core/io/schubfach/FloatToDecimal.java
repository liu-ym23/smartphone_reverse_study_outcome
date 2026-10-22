package com.fasterxml.jackson.core.io.schubfach;

import v7.o;

/* loaded from: classes2.dex */
public final class FloatToDecimal {
    private static final int BQ_MASK = 255;
    private static final int C_MIN = 8388608;
    static final int C_TINY = 8;
    static final int E_MAX = 39;
    static final int E_MIN = -44;

    /* renamed from: H, reason: collision with root package name */
    static final int f2256H = 9;
    static final int K_MAX = 31;
    static final int K_MIN = -45;
    private static final int MASK_28 = 268435455;
    private static final long MASK_32 = 4294967295L;
    private static final int MINUS_INF = 4;
    private static final int MINUS_ZERO = 2;
    private static final int NAN = 5;
    private static final int NON_SPECIAL = 0;

    /* renamed from: P, reason: collision with root package name */
    static final int f2257P = 24;
    private static final int PLUS_INF = 3;
    private static final int PLUS_ZERO = 1;
    static final int Q_MAX = 104;
    static final int Q_MIN = -149;
    private static final int T_MASK = 8388607;

    /* renamed from: W, reason: collision with root package name */
    private static final int f2258W = 8;
    public final int MAX_CHARS = 15;
    private final byte[] bytes = new byte[15];
    private int index;

    private FloatToDecimal() {
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
        int i6 = (i * o.META_DATA_FIELD_NUMBER) >>> 10;
        appendDigit(i6);
        appendDigit(i - (i6 * 10));
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

    private static int rop(long j5, long j6) {
        long jMultiplyHigh = MathUtils.multiplyHigh(j5, j6);
        return (int) ((((jMultiplyHigh & MASK_32) + MASK_32) >>> 32) | (jMultiplyHigh >>> 31));
    }

    private int toChars(int i, int i6) {
        int iFlog10pow2 = MathUtils.flog10pow2(32 - Integer.numberOfLeadingZeros(i));
        long j5 = i;
        if (j5 >= MathUtils.pow10(iFlog10pow2)) {
            iFlog10pow2++;
        }
        int iPow10 = (int) (j5 * MathUtils.pow10(9 - iFlog10pow2));
        int i10 = i6 + iFlog10pow2;
        int i11 = (int) ((iPow10 * 1441151881) >>> 57);
        int i12 = iPow10 - (100000000 * i11);
        return (i10 <= 0 || i10 > 7) ? (-3 >= i10 || i10 > 0) ? toChars3(i11, i12, i10) : toChars2(i11, i12, i10) : toChars1(i11, i12, i10);
    }

    private int toChars1(int i, int i6, int i10) {
        appendDigit(i);
        int iY = y(i6);
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

    private int toChars2(int i, int i6, int i10) {
        appendDigit(0);
        append(46);
        while (i10 < 0) {
            appendDigit(0);
            i10++;
        }
        appendDigit(i);
        append8Digits(i6);
        removeTrailingZeroes();
        return 0;
    }

    private int toChars3(int i, int i6, int i10) {
        appendDigit(i);
        append(46);
        append8Digits(i6);
        removeTrailingZeroes();
        exponent(i10 - 1);
        return 0;
    }

    private int toDecimal(float f) {
        int iFloatToRawIntBits = Float.floatToRawIntBits(f);
        int i = T_MASK & iFloatToRawIntBits;
        int i6 = (iFloatToRawIntBits >>> 23) & 255;
        if (i6 >= 255) {
            if (i != 0) {
                return 5;
            }
            return iFloatToRawIntBits > 0 ? 3 : 4;
        }
        this.index = -1;
        if (iFloatToRawIntBits < 0) {
            append(45);
        }
        if (i6 == 0) {
            return i != 0 ? i < 8 ? toDecimal(Q_MIN, i * 10, -1) : toDecimal(Q_MIN, i, 0) : iFloatToRawIntBits == 0 ? 1 : 2;
        }
        int i10 = 150 - i6;
        int i11 = i | 8388608;
        if ((i10 > 0) & (i10 < 24)) {
            int i12 = i11 >> i10;
            if ((i12 << i10) == i11) {
                return toChars(i12, 0);
            }
        }
        return toDecimal(-i10, i11, 0);
    }

    private String toDecimalString(float f) {
        int decimal = toDecimal(f);
        return decimal != 0 ? decimal != 1 ? decimal != 2 ? decimal != 3 ? decimal != 4 ? "NaN" : "-Infinity" : "Infinity" : "-0.0" : "0.0" : charsToString();
    }

    public static String toString(float f) {
        return new FloatToDecimal().toDecimalString(f);
    }

    private int y(int i) {
        return ((int) (MathUtils.multiplyHigh((i + 1) << 28, 193428131138340668L) >>> 20)) - 1;
    }

    private int toDecimal(int i, int i6, int i10) {
        long j5;
        int iFlog10threeQuartersPow2;
        int i11 = i6 & 1;
        long j6 = i6 << 2;
        long j10 = j6 + 2;
        if ((i6 != 8388608) | (i == Q_MIN)) {
            j5 = j6 - 2;
            iFlog10threeQuartersPow2 = MathUtils.flog10pow2(i);
        } else {
            j5 = j6 - 1;
            iFlog10threeQuartersPow2 = MathUtils.flog10threeQuartersPow2(i);
        }
        int iFlog2pow10 = i + MathUtils.flog2pow10(-iFlog10threeQuartersPow2) + 33;
        long jG1 = 1 + MathUtils.g1(iFlog10threeQuartersPow2);
        int iRop = rop(jG1, j6 << iFlog2pow10);
        int iRop2 = rop(jG1, j5 << iFlog2pow10);
        int iRop3 = rop(jG1, j10 << iFlog2pow10);
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
}
