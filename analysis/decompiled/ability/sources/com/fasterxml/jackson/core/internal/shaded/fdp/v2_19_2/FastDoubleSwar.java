package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

/* loaded from: classes2.dex */
class FastDoubleSwar {
    public static double fma(double d, double d6, double d10) {
        return (d * d6) + d10;
    }

    public static boolean isDigit(byte b) {
        return ((char) (b + (-48))) < '\n';
    }

    public static boolean isEightDigits(byte[] bArr, int i) {
        return isEightDigitsUtf8(readLongLE(bArr, i));
    }

    public static boolean isEightDigitsUtf16(long j5, long j6) {
        return ((((j5 + 19703549022044230L) | (j5 - 13511005043687472L)) | ((j6 + 19703549022044230L) | (j6 - 13511005043687472L))) & (-35747867511423104L)) == 0;
    }

    public static boolean isEightDigitsUtf8(long j5) {
        return (((j5 + 5063812098665367110L) | (j5 - 3472328296227680304L)) & (-9187201950435737472L)) == 0;
    }

    public static boolean isEightZeroes(byte[] bArr, int i) {
        return isEightZeroesUtf8(readLongLE(bArr, i));
    }

    public static boolean isEightZeroesUtf16(long j5, long j6) {
        return j5 == 13511005043687472L && j6 == 13511005043687472L;
    }

    public static boolean isEightZeroesUtf8(long j5) {
        return j5 == 3472328296227680304L;
    }

    public static int readIntBE(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static int readIntLE(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
    }

    public static long readLongBE(byte[] bArr, int i) {
        return (bArr[i + 7] & 255) | ((bArr[i] & 255) << 56) | ((bArr[i + 1] & 255) << 48) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
    }

    public static long readLongLE(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 7] & 255) << 56) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
    }

    public static int tryToParseEightDigits(char[] cArr, int i) {
        return tryToParseEightDigitsUtf16(cArr[i] | (cArr[i + 1] << 16) | (cArr[i + 2] << 32) | (cArr[i + 3] << 48), (cArr[i + 7] << 48) | cArr[i + 4] | (cArr[i + 5] << 16) | (cArr[i + 6] << 32));
    }

    public static int tryToParseEightDigitsUtf16(long j5, long j6) {
        long j10 = j5 - 13511005043687472L;
        long j11 = j6 - 13511005043687472L;
        if ((((j5 + 19703549022044230L) | j10 | (j6 + 19703549022044230L) | j11) & (-35747867511423104L)) != 0) {
            return -1;
        }
        return (((int) ((j10 * 281475406208040961L) >>> 48)) * 10000) + ((int) ((j11 * 281475406208040961L) >>> 48));
    }

    public static int tryToParseEightDigitsUtf8(long j5) {
        long j6 = j5 - 3472328296227680304L;
        if ((((j5 + 5063812098665367110L) | j6) & (-9187201950435737472L)) != 0) {
            return -1;
        }
        long j10 = (10 * j6) + (j6 >>> 8);
        return (int) (((((j10 >>> 16) & 1095216660735L) * 42949672960001L) + ((j10 & 1095216660735L) * 4294967296000100L)) >>> 32);
    }

    public static long tryToParseEightHexDigits(CharSequence charSequence, int i) {
        return tryToParseEightHexDigitsUtf16((charSequence.charAt(i) << 48) | (charSequence.charAt(i + 1) << 32) | (charSequence.charAt(i + 2) << 16) | charSequence.charAt(i + 3), charSequence.charAt(i + 7) | (charSequence.charAt(i + 4) << 48) | (charSequence.charAt(i + 5) << 32) | (charSequence.charAt(i + 6) << 16));
    }

    public static long tryToParseEightHexDigitsUtf16(long j5, long j6) {
        if (((j5 | j6) & (-71777214294589696L)) != 0) {
            return -1L;
        }
        long j10 = j5 * 65792;
        long j11 = j6 * 65792;
        return tryToParseEightHexDigitsUtf8(((j10 & 4294901760L) << 16) | (j10 & (-281474976710656L)) | (((-281474976710656L) & j11) >>> 32) | ((j11 & 4294901760L) >>> 16));
    }

    public static long tryToParseEightHexDigitsUtf8(long j5) {
        long j6 = (j5 - 3472328296227680304L) & (-9187201950435737472L);
        long j10 = (5063812098665367110L + j5) & (-9187201950435737472L);
        long j11 = j5 | 2314885530818453536L;
        long j12 = j11 - 3472328296227680304L;
        if ((j6 | j10) != ((j11 - 7451037802321897319L) & (-9187201950435737472L) & (j11 - (-2242545357980376863L)))) {
            return -1L;
        }
        long j13 = (j10 >>> 7) * 255;
        long j14 = ((~j13) & j12) | (j12 - (j13 & 2821266740684990247L));
        long j15 = (j14 | (j14 >>> 4)) & 71777214294589695L;
        long j16 = j15 | (j15 >>> 8);
        return (j16 & 65535) | ((j16 >>> 16) & 4294901760L);
    }

    public static int tryToParseFourDigits(char[] cArr, int i) {
        return tryToParseFourDigitsUtf16((cArr[i + 3] << 48) | cArr[i] | (cArr[i + 1] << 16) | (cArr[i + 2] << 32));
    }

    public static int tryToParseFourDigitsUtf16(long j5) {
        long j6 = j5 - 13511005043687472L;
        if ((((j5 + 19703549022044230L) | j6) & (-35747867511423104L)) != 0) {
            return -1;
        }
        return (int) ((j6 * 281475406208040961L) >>> 48);
    }

    public static int tryToParseFourDigitsUtf8(int i) {
        int i6 = i - 808464432;
        if ((((i + 1179010630) | i6) & (-2139062144)) != 0) {
            return -1;
        }
        int i10 = (i6 * 2561) >>> 8;
        return ((i10 & 255) * 100) + ((i10 & 16711680) >> 16);
    }

    public static int tryToParseUpTo7Digits(byte[] bArr, int i, int i6) {
        int i10 = 0;
        boolean zIsDigit = true;
        while (i < i6) {
            byte b = bArr[i];
            zIsDigit &= isDigit(b);
            i10 = ((i10 * 10) + b) - 48;
            i++;
        }
        if (zIsDigit) {
            return i10;
        }
        return -1;
    }

    public static void writeIntBE(byte[] bArr, int i, int i6) {
        bArr[i] = (byte) (i6 >>> 24);
        bArr[i + 1] = (byte) (i6 >>> 16);
        bArr[i + 2] = (byte) (i6 >>> 8);
        bArr[i + 3] = (byte) i6;
    }

    public static void writeLongBE(byte[] bArr, int i, long j5) {
        bArr[i] = (byte) (j5 >>> 56);
        bArr[i + 1] = (byte) (j5 >>> 48);
        bArr[i + 2] = (byte) (j5 >>> 40);
        bArr[i + 3] = (byte) (j5 >>> 32);
        bArr[i + 4] = (byte) (j5 >>> 24);
        bArr[i + 5] = (byte) (j5 >>> 16);
        bArr[i + 6] = (byte) (j5 >>> 8);
        bArr[i + 7] = (byte) j5;
    }

    public static boolean isDigit(char c) {
        return ((char) (c + 65488)) < '\n';
    }

    public static boolean isEightDigits(char[] cArr, int i) {
        return isEightDigitsUtf16(cArr[i] | (cArr[i + 1] << 16) | (cArr[i + 2] << 32) | (cArr[i + 3] << 48), (cArr[i + 7] << 48) | cArr[i + 4] | (cArr[i + 5] << 16) | (cArr[i + 6] << 32));
    }

    public static boolean isEightZeroes(CharSequence charSequence, int i) {
        boolean z10 = true;
        for (int i6 = 0; i6 < 8; i6++) {
            z10 &= '0' == charSequence.charAt(i6 + i);
        }
        return z10;
    }

    public static int tryToParseEightDigitsUtf8(byte[] bArr, int i) {
        return tryToParseEightDigitsUtf8(readLongLE(bArr, i));
    }

    public static boolean isEightZeroes(char[] cArr, int i) {
        return isEightZeroesUtf16(cArr[i] | (cArr[i + 1] << 16) | (cArr[i + 2] << 32) | (cArr[i + 3] << 48), (cArr[i + 7] << 48) | cArr[i + 4] | (cArr[i + 5] << 16) | (cArr[i + 6] << 32));
    }

    public static int tryToParseFourDigits(CharSequence charSequence, int i) {
        return tryToParseFourDigitsUtf16((charSequence.charAt(i + 3) << 48) | charSequence.charAt(i) | (charSequence.charAt(i + 1) << 16) | (charSequence.charAt(i + 2) << 32));
    }

    public static int tryToParseUpTo7Digits(char[] cArr, int i, int i6) {
        int i10 = 0;
        boolean zIsDigit = true;
        while (i < i6) {
            char c = cArr[i];
            zIsDigit &= isDigit(c);
            i10 = ((i10 * 10) + c) - 48;
            i++;
        }
        if (zIsDigit) {
            return i10;
        }
        return -1;
    }

    public static int tryToParseEightDigits(byte[] bArr, int i) {
        return tryToParseEightDigitsUtf8(readLongLE(bArr, i));
    }

    public static boolean isEightDigits(CharSequence charSequence, int i) {
        boolean zIsDigit = true;
        for (int i6 = 0; i6 < 8; i6++) {
            zIsDigit &= isDigit(charSequence.charAt(i6 + i));
        }
        return zIsDigit;
    }

    public static int tryToParseEightDigits(CharSequence charSequence, int i) {
        return tryToParseEightDigitsUtf16(charSequence.charAt(i) | (charSequence.charAt(i + 1) << 16) | (charSequence.charAt(i + 2) << 32) | (charSequence.charAt(i + 3) << 48), (charSequence.charAt(i + 7) << 48) | charSequence.charAt(i + 4) | (charSequence.charAt(i + 5) << 16) | (charSequence.charAt(i + 6) << 32));
    }

    public static int tryToParseUpTo7Digits(CharSequence charSequence, int i, int i6) {
        int i10 = 0;
        boolean zIsDigit = true;
        while (i < i6) {
            char cCharAt = charSequence.charAt(i);
            zIsDigit &= isDigit(cCharAt);
            i10 = ((i10 * 10) + cCharAt) - 48;
            i++;
        }
        if (zIsDigit) {
            return i10;
        }
        return -1;
    }

    public static int tryToParseFourDigits(byte[] bArr, int i) {
        return tryToParseFourDigitsUtf8(readIntLE(bArr, i));
    }

    public static long tryToParseEightHexDigits(char[] cArr, int i) {
        return tryToParseEightHexDigitsUtf16((cArr[i] << 48) | (cArr[i + 1] << 32) | (cArr[i + 2] << 16) | cArr[i + 3], cArr[i + 7] | (cArr[i + 4] << 48) | (cArr[i + 5] << 32) | (cArr[i + 6] << 16));
    }

    public static long tryToParseEightHexDigits(byte[] bArr, int i) {
        return tryToParseEightHexDigitsUtf8(readLongBE(bArr, i));
    }
}
