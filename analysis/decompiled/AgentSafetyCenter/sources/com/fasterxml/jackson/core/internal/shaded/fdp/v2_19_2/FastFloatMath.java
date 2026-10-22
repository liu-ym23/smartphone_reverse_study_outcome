package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
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

    public static float fastScalb(float f5, int i) {
        return Float.intBitsToFloat((i + 127) << 23) * f5;
    }

    public static float tryDecFloatToFloatTruncated(boolean z10, long j10, int i, boolean z11, int i3) {
        if (j10 == 0) {
            return z10 ? -0.0f : 0.0f;
        }
        if (!z11) {
            if (FLOAT_MIN_EXPONENT_POWER_OF_TEN > i || i > 38) {
                return Float.NaN;
            }
            return tryDecToFloatWithFastAlgorithm(z10, j10, i);
        }
        if (FLOAT_MIN_EXPONENT_POWER_OF_TEN <= i3 && i3 <= 38) {
            float fTryDecToFloatWithFastAlgorithm = tryDecToFloatWithFastAlgorithm(z10, j10, i3);
            float fTryDecToFloatWithFastAlgorithm2 = tryDecToFloatWithFastAlgorithm(z10, j10 + 1, i3);
            if (!Float.isNaN(fTryDecToFloatWithFastAlgorithm) && fTryDecToFloatWithFastAlgorithm2 == fTryDecToFloatWithFastAlgorithm) {
                return fTryDecToFloatWithFastAlgorithm;
            }
        }
        return Float.NaN;
    }

    public static float tryDecToFloatWithFastAlgorithm(boolean z10, long j10, int i) {
        if (-10 <= i && i <= 10 && Long.compareUnsigned(j10, 16777215L) <= 0) {
            float f5 = j10;
            float f10 = i < 0 ? f5 / FLOAT_POWER_OF_TEN[-i] : f5 * FLOAT_POWER_OF_TEN[i];
            return z10 ? -f10 : f10;
        }
        long j11 = FastDoubleMath.MANTISSA_64[i + 325];
        long j12 = ((i * 217706) >> 16) + 191;
        int iNumberOfLeadingZeros = Long.numberOfLeadingZeros(j10);
        long jUnsignedMultiplyHigh = FastIntegerMath.unsignedMultiplyHigh(j10 << iNumberOfLeadingZeros, j11);
        long j13 = jUnsignedMultiplyHigh >>> 63;
        long j14 = jUnsignedMultiplyHigh >>> ((int) (38 + j13));
        int i3 = iNumberOfLeadingZeros + ((int) (j13 ^ 1));
        long j15 = jUnsignedMultiplyHigh & 274877906943L;
        if (j15 != 274877906943L) {
            if (j15 != 0 || (3 & j14) != 1) {
                long j16 = (j14 + 1) >>> 1;
                if (j16 >= 16777216) {
                    i3--;
                    j16 = 8388608;
                }
                long j17 = j16 & (-8388609);
                long j18 = j12 - i3;
                if (j18 >= 1 && j18 <= 254) {
                    return Float.intBitsToFloat((int) (j17 | (j18 << 23) | (z10 ? 2147483648L : 0L)));
                }
            }
        }
        return Float.NaN;
    }

    public static float tryHexFloatToFloatTruncated(boolean z10, long j10, int i, boolean z11, int i3) {
        if (z11) {
            i = i3;
        }
        if (FLOAT_MIN_EXPONENT_POWER_OF_TWO > i || i > 127) {
            return Float.NaN;
        }
        float fFastScalb = fastScalb(j10 + (j10 < 0 ? 1.8446744E19f : 0.0f), i);
        return z10 ? -fFastScalb : fFastScalb;
    }
}
