package org.bouncycastle.util;

/* loaded from: classes.dex */
public abstract class Pack {
    public static int bigEndianToInt(byte[] bArr, int i8) {
        return (bArr[i8 + 3] & 255) | (bArr[i8] << 24) | ((bArr[i8 + 1] & 255) << 16) | ((bArr[i8 + 2] & 255) << 8);
    }

    public static long bigEndianToLong(byte[] bArr, int i8) {
        return (bigEndianToInt(bArr, i8 + 4) & 4294967295L) | ((bigEndianToInt(bArr, i8) & 4294967295L) << 32);
    }

    public static short bigEndianToShort(byte[] bArr, int i8) {
        return (short) ((bArr[i8 + 1] & 255) | ((bArr[i8] & 255) << 8));
    }

    public static void intToBigEndian(int i8, byte[] bArr, int i9) {
        bArr[i9] = (byte) (i8 >>> 24);
        bArr[i9 + 1] = (byte) (i8 >>> 16);
        bArr[i9 + 2] = (byte) (i8 >>> 8);
        bArr[i9 + 3] = (byte) i8;
    }

    public static void intToLittleEndian(int i8, byte[] bArr, int i9) {
        bArr[i9] = (byte) i8;
        bArr[i9 + 1] = (byte) (i8 >>> 8);
        bArr[i9 + 2] = (byte) (i8 >>> 16);
        bArr[i9 + 3] = (byte) (i8 >>> 24);
    }

    public static int littleEndianToInt(byte[] bArr, int i8) {
        return (bArr[i8 + 3] << 24) | (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16);
    }

    public static int littleEndianToInt_High(byte[] bArr, int i8, int i9) {
        return littleEndianToInt_Low(bArr, i8, i9) << ((4 - i9) << 3);
    }

    public static int littleEndianToInt_Low(byte[] bArr, int i8, int i9) {
        int i10 = bArr[i8] & 255;
        int i11 = 0;
        for (int i12 = 1; i12 < i9; i12++) {
            i11 += 8;
            i10 |= (bArr[i8 + i12] & 255) << i11;
        }
        return i10;
    }

    public static long littleEndianToLong(byte[] bArr, int i8) {
        return ((littleEndianToInt(bArr, i8 + 4) & 4294967295L) << 32) | (littleEndianToInt(bArr, i8) & 4294967295L);
    }

    public static long littleEndianToLong_High(byte[] bArr, int i8, int i9) {
        return littleEndianToLong_Low(bArr, i8, i9) << ((8 - i9) << 3);
    }

    public static long littleEndianToLong_Low(byte[] bArr, int i8, int i9) {
        long j4 = bArr[i8] & 255;
        for (int i10 = 1; i10 < i9; i10++) {
            j4 = (j4 << 8) | (bArr[i8 + i10] & 255);
        }
        return j4;
    }

    public static short littleEndianToShort(byte[] bArr, int i8) {
        return (short) (((bArr[i8 + 1] & 255) << 8) | (bArr[i8] & 255));
    }

    public static void longToBigEndian(long j4, byte[] bArr, int i8) {
        intToBigEndian((int) (j4 >>> 32), bArr, i8);
        intToBigEndian((int) (j4 & 4294967295L), bArr, i8 + 4);
    }

    public static void longToLittleEndian(long j4, byte[] bArr, int i8) {
        intToLittleEndian((int) (4294967295L & j4), bArr, i8);
        intToLittleEndian((int) (j4 >>> 32), bArr, i8 + 4);
    }

    public static void longToLittleEndian_High(long j4, byte[] bArr, int i8, int i9) {
        int i10 = 56;
        bArr[i8] = (byte) (j4 >>> 56);
        for (int i11 = 1; i11 < i9; i11++) {
            i10 -= 8;
            bArr[i8 + i11] = (byte) (j4 >>> i10);
        }
    }

    public static void shortToBigEndian(short s8, byte[] bArr, int i8) {
        bArr[i8] = (byte) (s8 >>> 8);
        bArr[i8 + 1] = (byte) s8;
    }

    public static void shortToLittleEndian(short s8, byte[] bArr, int i8) {
        bArr[i8] = (byte) s8;
        bArr[i8 + 1] = (byte) (s8 >>> 8);
    }

    public static void bigEndianToInt(byte[] bArr, int i8, int[] iArr) {
        for (int i9 = 0; i9 < iArr.length; i9++) {
            iArr[i9] = bigEndianToInt(bArr, i8);
            i8 += 4;
        }
    }

    public static long bigEndianToLong(byte[] bArr, int i8, int i9) {
        long j4 = 0;
        for (int i10 = 0; i10 < i9; i10++) {
            j4 |= (bArr[i10 + i8] & 255) << ((7 - i10) << 3);
        }
        return j4;
    }

    public static void intToBigEndian(int[] iArr, int i8, int i9, byte[] bArr, int i10) {
        for (int i11 = 0; i11 < i9; i11++) {
            intToBigEndian(iArr[i8 + i11], bArr, i10);
            i10 += 4;
        }
    }

    public static void intToLittleEndian(int[] iArr, int i8, int i9, byte[] bArr, int i10) {
        for (int i11 = 0; i11 < i9; i11++) {
            intToLittleEndian(iArr[i8 + i11], bArr, i10);
            i10 += 4;
        }
    }

    public static void littleEndianToInt(byte[] bArr, int i8, int[] iArr) {
        for (int i9 = 0; i9 < iArr.length; i9++) {
            iArr[i9] = littleEndianToInt(bArr, i8);
            i8 += 4;
        }
    }

    public static long littleEndianToLong(byte[] bArr, int i8, int i9) {
        long j4 = 0;
        for (int i10 = 0; i10 < i9; i10++) {
            j4 |= (bArr[i8 + i10] & 255) << (i10 << 3);
        }
        return j4;
    }

    public static void littleEndianToShort(byte[] bArr, int i8, short[] sArr, int i9, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sArr[i9 + i11] = littleEndianToShort(bArr, i8);
            i8 += 2;
        }
    }

    @Deprecated
    public static void longToBigEndian(long j4, byte[] bArr, int i8, int i9) {
        for (int i10 = i9 - 1; i10 >= 0; i10--) {
            bArr[i10 + i8] = (byte) (255 & j4);
            j4 >>>= 8;
        }
    }

    public static void longToLittleEndian(long j4, byte[] bArr, int i8, int i9) {
        for (int i10 = 0; i10 < i9; i10++) {
            bArr[i8 + i10] = (byte) (j4 >>> (i10 << 3));
        }
    }

    public static byte[] shortToBigEndian(short s8) {
        byte[] bArr = new byte[2];
        shortToBigEndian(s8, bArr, 0);
        return bArr;
    }

    public static void shortToLittleEndian(short[] sArr, int i8, int i9, byte[] bArr, int i10) {
        for (int i11 = 0; i11 < i9; i11++) {
            shortToLittleEndian(sArr[i8 + i11], bArr, i10);
            i10 += 2;
        }
    }

    public static void bigEndianToInt(byte[] bArr, int i8, int[] iArr, int i9, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            iArr[i9 + i11] = bigEndianToInt(bArr, i8);
            i8 += 4;
        }
    }

    public static void bigEndianToLong(byte[] bArr, int i8, long[] jArr) {
        for (int i9 = 0; i9 < jArr.length; i9++) {
            jArr[i9] = bigEndianToLong(bArr, i8);
            i8 += 8;
        }
    }

    public static void intToBigEndian(int[] iArr, byte[] bArr, int i8) {
        for (int i9 : iArr) {
            intToBigEndian(i9, bArr, i8);
            i8 += 4;
        }
    }

    public static void intToLittleEndian(int[] iArr, byte[] bArr, int i8) {
        for (int i9 : iArr) {
            intToLittleEndian(i9, bArr, i8);
            i8 += 4;
        }
    }

    public static void littleEndianToInt(byte[] bArr, int i8, int[] iArr, int i9, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            iArr[i9 + i11] = littleEndianToInt(bArr, i8);
            i8 += 4;
        }
    }

    public static void littleEndianToLong(byte[] bArr, int i8, long[] jArr) {
        for (int i9 = 0; i9 < jArr.length; i9++) {
            jArr[i9] = littleEndianToLong(bArr, i8);
            i8 += 8;
        }
    }

    public static void longToBigEndian(long[] jArr, int i8, int i9, byte[] bArr, int i10) {
        for (int i11 = 0; i11 < i9; i11++) {
            longToBigEndian(jArr[i8 + i11], bArr, i10);
            i10 += 8;
        }
    }

    public static void longToLittleEndian(long[] jArr, int i8, int i9, byte[] bArr, int i10) {
        for (int i11 = 0; i11 < i9; i11++) {
            longToLittleEndian(jArr[i8 + i11], bArr, i10);
            i10 += 8;
        }
    }

    public static byte[] shortToLittleEndian(short s8) {
        byte[] bArr = new byte[2];
        shortToLittleEndian(s8, bArr, 0);
        return bArr;
    }

    public static void bigEndianToLong(byte[] bArr, int i8, long[] jArr, int i9, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            jArr[i9 + i11] = bigEndianToLong(bArr, i8);
            i8 += 8;
        }
    }

    public static byte[] intToBigEndian(int i8) {
        byte[] bArr = new byte[4];
        intToBigEndian(i8, bArr, 0);
        return bArr;
    }

    public static byte[] intToLittleEndian(int i8) {
        byte[] bArr = new byte[4];
        intToLittleEndian(i8, bArr, 0);
        return bArr;
    }

    public static int[] littleEndianToInt(byte[] bArr, int i8, int i9) {
        int[] iArr = new int[i9];
        for (int i10 = 0; i10 < i9; i10++) {
            iArr[i10] = littleEndianToInt(bArr, i8);
            i8 += 4;
        }
        return iArr;
    }

    public static void littleEndianToLong(byte[] bArr, int i8, long[] jArr, int i9, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            jArr[i9 + i11] = littleEndianToLong(bArr, i8);
            i8 += 8;
        }
    }

    public static void longToBigEndian(long[] jArr, byte[] bArr, int i8) {
        for (long j4 : jArr) {
            longToBigEndian(j4, bArr, i8);
            i8 += 8;
        }
    }

    public static void longToLittleEndian(long[] jArr, byte[] bArr, int i8) {
        for (long j4 : jArr) {
            longToLittleEndian(j4, bArr, i8);
            i8 += 8;
        }
    }

    public static byte[] intToBigEndian(int[] iArr) {
        byte[] bArr = new byte[iArr.length * 4];
        intToBigEndian(iArr, bArr, 0);
        return bArr;
    }

    public static byte[] intToLittleEndian(int[] iArr) {
        byte[] bArr = new byte[iArr.length * 4];
        intToLittleEndian(iArr, bArr, 0);
        return bArr;
    }

    public static byte[] longToBigEndian(long j4) {
        byte[] bArr = new byte[8];
        longToBigEndian(j4, bArr, 0);
        return bArr;
    }

    public static byte[] longToLittleEndian(long j4) {
        byte[] bArr = new byte[8];
        longToLittleEndian(j4, bArr, 0);
        return bArr;
    }

    public static byte[] longToBigEndian(long[] jArr) {
        byte[] bArr = new byte[jArr.length * 8];
        longToBigEndian(jArr, bArr, 0);
        return bArr;
    }

    public static byte[] longToLittleEndian(long[] jArr) {
        byte[] bArr = new byte[jArr.length * 8];
        longToLittleEndian(jArr, bArr, 0);
        return bArr;
    }
}
