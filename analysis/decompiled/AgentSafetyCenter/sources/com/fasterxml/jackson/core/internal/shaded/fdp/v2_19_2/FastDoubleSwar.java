package com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class FastDoubleSwar {
    public static double fma(double d7, double d10, double d11) {
        return (d7 * d10) + d11;
    }

    public static boolean isDigit(byte b10) {
        return ((char) (b10 + (-48))) < '\n';
    }

    public static boolean isEightDigits(char[] cArr, int i) {
        return isEightDigitsUtf16(cArr[i] | (cArr[i + 1] << 16) | (cArr[i + 2] << 32) | (cArr[i + 3] << 48), (cArr[i + 7] << 48) | cArr[i + 4] | (cArr[i + 5] << 16) | (cArr[i + 6] << 32));
    }

    public static boolean isEightDigitsUtf16(long j10, long j11) {
        return ((((j10 + 19703549022044230L) | (j10 - 13511005043687472L)) | ((j11 + 19703549022044230L) | (j11 - 13511005043687472L))) & (-35747867511423104L)) == 0;
    }

    public static boolean isEightDigitsUtf8(long j10) {
        return (((j10 + 5063812098665367110L) | (j10 - 3472328296227680304L)) & (-9187201950435737472L)) == 0;
    }

    public static boolean isEightZeroes(char[] cArr, int i) {
        return isEightZeroesUtf16(cArr[i] | (cArr[i + 1] << 16) | (cArr[i + 2] << 32) | (cArr[i + 3] << 48), (cArr[i + 7] << 48) | cArr[i + 4] | (cArr[i + 5] << 16) | (cArr[i + 6] << 32));
    }

    public static boolean isEightZeroesUtf16(long j10, long j11) {
        return j10 == 13511005043687472L && j11 == 13511005043687472L;
    }

    public static boolean isEightZeroesUtf8(long j10) {
        return j10 == 3472328296227680304L;
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

    public static int tryToParseEightDigits(CharSequence charSequence, int i) {
        return tryToParseEightDigitsUtf16(charSequence.charAt(i) | (charSequence.charAt(i + 1) << 16) | (charSequence.charAt(i + 2) << 32) | (charSequence.charAt(i + 3) << 48), (charSequence.charAt(i + 7) << 48) | charSequence.charAt(i + 4) | (charSequence.charAt(i + 5) << 16) | (charSequence.charAt(i + 6) << 32));
    }

    public static int tryToParseEightDigitsUtf16(long j10, long j11) {
        long j12 = j10 - 13511005043687472L;
        long j13 = j11 - 13511005043687472L;
        if ((((j10 + 19703549022044230L) | j12 | (j11 + 19703549022044230L) | j13) & (-35747867511423104L)) != 0) {
            return -1;
        }
        return (((int) ((j12 * 281475406208040961L) >>> 48)) * 10000) + ((int) ((j13 * 281475406208040961L) >>> 48));
    }

    public static int tryToParseEightDigitsUtf8(long j10) {
        long j11 = j10 - 3472328296227680304L;
        if ((((j10 + 5063812098665367110L) | j11) & (-9187201950435737472L)) != 0) {
            return -1;
        }
        long j12 = (10 * j11) + (j11 >>> 8);
        return (int) (((((j12 >>> 16) & 1095216660735L) * 42949672960001L) + ((j12 & 1095216660735L) * 4294967296000100L)) >>> 32);
    }

    public static long tryToParseEightHexDigits(CharSequence charSequence, int i) {
        return tryToParseEightHexDigitsUtf16((charSequence.charAt(i) << 48) | (charSequence.charAt(i + 1) << 32) | (charSequence.charAt(i + 2) << 16) | charSequence.charAt(i + 3), charSequence.charAt(i + 7) | (charSequence.charAt(i + 4) << 48) | (charSequence.charAt(i + 5) << 32) | (charSequence.charAt(i + 6) << 16));
    }

    public static long tryToParseEightHexDigitsUtf16(long j10, long j11) {
        if (((j10 | j11) & (-71777214294589696L)) != 0) {
            return -1L;
        }
        long j12 = j10 * 65792;
        long j13 = j11 * 65792;
        return tryToParseEightHexDigitsUtf8(((j12 & 4294901760L) << 16) | (j12 & (-281474976710656L)) | (((-281474976710656L) & j13) >>> 32) | ((j13 & 4294901760L) >>> 16));
    }

    public static long tryToParseEightHexDigitsUtf8(long j10) {
        long j11 = (j10 - 3472328296227680304L) & (-9187201950435737472L);
        long j12 = (5063812098665367110L + j10) & (-9187201950435737472L);
        long j13 = j10 | 2314885530818453536L;
        long j14 = j13 - 3472328296227680304L;
        if ((j11 | j12) != ((j13 - 7451037802321897319L) & (-9187201950435737472L) & (j13 - (-2242545357980376863L)))) {
            return -1L;
        }
        long j15 = (j12 >>> 7) * 255;
        long j16 = ((~j15) & j14) | (j14 - (j15 & 2821266740684990247L));
        long j17 = (j16 | (j16 >>> 4)) & 71777214294589695L;
        long j18 = j17 | (j17 >>> 8);
        return (j18 & 65535) | ((j18 >>> 16) & 4294901760L);
    }

    public static int tryToParseFourDigits(CharSequence charSequence, int i) {
        return tryToParseFourDigitsUtf16((charSequence.charAt(i + 3) << 48) | charSequence.charAt(i) | (charSequence.charAt(i + 1) << 16) | (charSequence.charAt(i + 2) << 32));
    }

    public static int tryToParseFourDigitsUtf16(long j10) {
        long j11 = j10 - 13511005043687472L;
        if ((((j10 + 19703549022044230L) | j11) & (-35747867511423104L)) != 0) {
            return -1;
        }
        return (int) ((j11 * 281475406208040961L) >>> 48);
    }

    public static int tryToParseFourDigitsUtf8(int i) {
        int i3 = i - 808464432;
        if ((((i + 1179010630) | i3) & (-2139062144)) != 0) {
            return -1;
        }
        int i10 = (i3 * 2561) >>> 8;
        return ((i10 & 255) * 100) + ((i10 & 16711680) >> 16);
    }

    public static int tryToParseUpTo7Digits(CharSequence charSequence, int i, int i3) {
        int i10 = 0;
        boolean zIsDigit = true;
        while (i < i3) {
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

    public static void writeIntBE(byte[] bArr, int i, int i3) {
        bArr[i] = (byte) (i3 >>> 24);
        bArr[i + 1] = (byte) (i3 >>> 16);
        bArr[i + 2] = (byte) (i3 >>> 8);
        bArr[i + 3] = (byte) i3;
    }

    public static void writeLongBE(byte[] bArr, int i, long j10) {
        bArr[i] = (byte) (j10 >>> 56);
        bArr[i + 1] = (byte) (j10 >>> 48);
        bArr[i + 2] = (byte) (j10 >>> 40);
        bArr[i + 3] = (byte) (j10 >>> 32);
        bArr[i + 4] = (byte) (j10 >>> 24);
        bArr[i + 5] = (byte) (j10 >>> 16);
        bArr[i + 6] = (byte) (j10 >>> 8);
        bArr[i + 7] = (byte) j10;
    }

    public static boolean isDigit(char c9) {
        return ((char) (c9 + 65488)) < '\n';
    }

    public static int tryToParseUpTo7Digits(char[] cArr, int i, int i3) {
        int i10 = 0;
        boolean zIsDigit = true;
        while (i < i3) {
            char c9 = cArr[i];
            zIsDigit &= isDigit(c9);
            i10 = ((i10 * 10) + c9) - 48;
            i++;
        }
        if (zIsDigit) {
            return i10;
        }
        return -1;
    }

    public static int tryToParseUpTo7Digits(byte[] bArr, int i, int i3) {
        int i10 = 0;
        boolean zIsDigit = true;
        while (i < i3) {
            byte b10 = bArr[i];
            zIsDigit &= isDigit(b10);
            i10 = ((i10 * 10) + b10) - 48;
            i++;
        }
        if (zIsDigit) {
            return i10;
        }
        return -1;
    }

    public static int tryToParseFourDigits(char[] cArr, int i) {
        return tryToParseFourDigitsUtf16((cArr[i + 3] << 48) | cArr[i] | (cArr[i + 1] << 16) | (cArr[i + 2] << 32));
    }

    public static int tryToParseFourDigits(byte[] bArr, int i) {
        return tryToParseFourDigitsUtf8(readIntLE(bArr, i));
    }

    public static boolean isEightDigits(byte[] bArr, int i) {
        return isEightDigitsUtf8(readLongLE(bArr, i));
    }

    public static boolean isEightZeroes(CharSequence charSequence, int i) {
        boolean z10 = true;
        for (int i3 = 0; i3 < 8; i3++) {
            z10 &= '0' == charSequence.charAt(i3 + i);
        }
        return z10;
    }

    public static boolean isEightDigits(CharSequence charSequence, int i) {
        boolean zIsDigit = true;
        for (int i3 = 0; i3 < 8; i3++) {
            zIsDigit &= isDigit(charSequence.charAt(i3 + i));
        }
        return zIsDigit;
    }

    public static boolean isEightZeroes(byte[] bArr, int i) {
        return isEightZeroesUtf8(readLongLE(bArr, i));
    }

    public static int tryToParseEightDigitsUtf8(byte[] bArr, int i) {
        return tryToParseEightDigitsUtf8(readLongLE(bArr, i));
    }

    public static int tryToParseEightDigits(byte[] bArr, int i) {
        return tryToParseEightDigitsUtf8(readLongLE(bArr, i));
    }

    public static int tryToParseEightDigits(char[] cArr, int i) {
        return tryToParseEightDigitsUtf16(cArr[i] | (cArr[i + 1] << 16) | (cArr[i + 2] << 32) | (cArr[i + 3] << 48), (cArr[i + 7] << 48) | cArr[i + 4] | (cArr[i + 5] << 16) | (cArr[i + 6] << 32));
    }

    public static long tryToParseEightHexDigits(char[] cArr, int i) {
        return tryToParseEightHexDigitsUtf16((cArr[i] << 48) | (cArr[i + 1] << 32) | (cArr[i + 2] << 16) | cArr[i + 3], cArr[i + 7] | (cArr[i + 4] << 48) | (cArr[i + 5] << 32) | (cArr[i + 6] << 16));
    }

    public static long tryToParseEightHexDigits(byte[] bArr, int i) {
        return tryToParseEightHexDigitsUtf8(readLongBE(bArr, i));
    }
}
