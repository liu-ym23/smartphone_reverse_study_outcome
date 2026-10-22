package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

/* loaded from: classes2.dex */
class FastFloatMath {
    private static final int FLOAT_EXPONENT_BIAS = 127;
    private static final int FLOAT_MAX_EXPONENT_POWER_OF_TEN = 38;
    private static final int FLOAT_MAX_EXPONENT_POWER_OF_TWO = 127;
    private static final int FLOAT_MIN_EXPONENT_POWER_OF_TEN = -45;
    private static final int FLOAT_MIN_EXPONENT_POWER_OF_TWO = -126;
    private static final float[] FLOAT_POWER_OF_TEN = {1.0f, 10.0f, 100.0f, 1000.0f, 10000.0f, 100000.0f, 1000000.0f, 1.0E7f, 1.0E8f, 1.0E9f, 1.0E10f};
    private static final int FLOAT_SIGNIFICAND_WIDTH = 24;

    private FastFloatMath() {
    }

    public static float fastScalb(float f, int i) {
        return Float.intBitsToFloat((i + 127) << 23) * f;
    }

    public static float tryDecFloatToFloatTruncated(boolean z10, long j5, int i, boolean z11, int i6) {
        if (j5 == 0) {
            return z10 ? -0.0f : 0.0f;
        }
        if (!z11) {
            if (FLOAT_MIN_EXPONENT_POWER_OF_TEN > i || i > 38) {
                return Float.NaN;
            }
            return tryDecToFloatWithFastAlgorithm(z10, j5, i);
        }
        if (FLOAT_MIN_EXPONENT_POWER_OF_TEN <= i6 && i6 <= 38) {
            float fTryDecToFloatWithFastAlgorithm = tryDecToFloatWithFastAlgorithm(z10, j5, i6);
            float fTryDecToFloatWithFastAlgorithm2 = tryDecToFloatWithFastAlgorithm(z10, j5 + 1, i6);
            if (!Float.isNaN(fTryDecToFloatWithFastAlgorithm) && fTryDecToFloatWithFastAlgorithm2 == fTryDecToFloatWithFastAlgorithm) {
                return fTryDecToFloatWithFastAlgorithm;
            }
        }
        return Float.NaN;
    }

    public static float tryDecToFloatWithFastAlgorithm(boolean z10, long j5, int i) {
        if (-10 <= i && i <= 10 && Long.compareUnsigned(j5, 16777215L) <= 0) {
            float f = j5;
            float f7 = i < 0 ? f / FLOAT_POWER_OF_TEN[-i] : f * FLOAT_POWER_OF_TEN[i];
            return z10 ? -f7 : f7;
        }
        long j6 = FastDoubleMath.MANTISSA_64[i + 325];
        long j10 = ((i * 217706) >> 16) + 191;
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j5);
        long jUnsignedMultiplyHigh = FastIntegerMath.unsignedMultiplyHigh(j5 << iNumberOfLeadingZeros, j6);
        long j11 = jUnsignedMultiplyHigh >>> 63;
        long j12 = jUnsignedMultiplyHigh >>> ((int) (38 + j11));
        int i6 = iNumberOfLeadingZeros + ((int) (j11 ^ 1));
        long j13 = jUnsignedMultiplyHigh & 274877906943L;
        if (j13 != 274877906943L) {
            if (j13 != 0 || (3 & j12) != 1) {
                long j14 = (j12 + 1) >>> 1;
                if (j14 >= 16777216) {
                    i6--;
                    j14 = 8388608;
                }
                long j15 = j14 & (-8388609);
                long j16 = j10 - i6;
                if (j16 >= 1 && j16 <= 254) {
                    return Float.intBitsToFloat((int) (j15 | (j16 << 23) | (z10 ? 2147483648L : 0L)));
                }
            }
        }
        return Float.NaN;
    }

    public static float tryHexFloatToFloatTruncated(boolean z10, long j5, int i, boolean z11, int i6) {
        if (z11) {
            i = i6;
        }
        if (FLOAT_MIN_EXPONENT_POWER_OF_TWO > i || i > 127) {
            return Float.NaN;
        }
        float fFastScalb = fastScalb(j5 + (j5 < 0 ? 1.8446744E19f : 0.0f), i);
        return z10 ? -fFastScalb : fFastScalb;
    }
}
