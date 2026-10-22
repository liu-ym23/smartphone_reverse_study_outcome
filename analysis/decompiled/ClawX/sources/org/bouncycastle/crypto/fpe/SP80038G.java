package org.bouncycastle.crypto.fpe;

import a8.b;
import java.math.BigInteger;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.hpke.HPKE;
import org.bouncycastle.crypto.util.RadixConverter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Bytes;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
class SP80038G {
    protected static final int BLOCK_SIZE = 16;
    static final String FF1_DISABLED = "org.bouncycastle.fpe.disable_ff1";
    static final String FPE_DISABLED = "org.bouncycastle.fpe.disable";
    protected static final double LOG2 = Math.log(2.0d);
    protected static final double TWO_TO_96 = Math.pow(2.0d, 96.0d);

    public static int calculateB_FF1(int i8, int i9) {
        int iNumberOfTrailingZeros = Integers.numberOfTrailingZeros(i8);
        int iBitLength = iNumberOfTrailingZeros * i9;
        int i10 = i8 >>> iNumberOfTrailingZeros;
        if (i10 != 1) {
            iBitLength += BigInteger.valueOf(i10).pow(i9).bitLength();
        }
        return (iBitLength + 7) / 8;
    }

    public static BigInteger[] calculateModUV(BigInteger bigInteger, int i8, int i9) {
        BigInteger bigIntegerPow = bigInteger.pow(i8);
        BigInteger[] bigIntegerArr = {bigIntegerPow, bigIntegerPow};
        if (i9 != i8) {
            bigIntegerArr[1] = bigIntegerPow.multiply(bigInteger);
        }
        return bigIntegerArr;
    }

    public static byte[] calculateP_FF1(int i8, byte b9, int i9, int i10) {
        byte[] bArr = {1, 2, 1, 0, (byte) (i8 >> 8), (byte) i8, 10, b9, 0, 0, 0, 0, 0, 0, 0, 0};
        Pack.intToBigEndian(i9, bArr, 8);
        Pack.intToBigEndian(i10, bArr, 12);
        return bArr;
    }

    public static byte[] calculateTweak64_FF3_1(byte[] bArr) {
        byte b9 = bArr[0];
        byte b10 = bArr[1];
        byte b11 = bArr[2];
        byte b12 = bArr[3];
        return new byte[]{b9, b10, b11, (byte) (b12 & 240), bArr[4], bArr[5], bArr[6], (byte) (b12 << 4)};
    }

    public static BigInteger calculateY_FF1(BlockCipher blockCipher, byte[] bArr, int i8, int i9, int i10, byte[] bArr2, short[] sArr, RadixConverter radixConverter) {
        int length = bArr.length;
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(radixConverter.fromEncoding(sArr));
        int i11 = ((-(length + i8 + 1)) & 15) + length;
        int i12 = i11 + 1 + i8;
        byte[] bArr3 = new byte[i12];
        System.arraycopy(bArr, 0, bArr3, 0, length);
        bArr3[i11] = (byte) i10;
        System.arraycopy(bArrAsUnsignedByteArray, 0, bArr3, i12 - bArrAsUnsignedByteArray.length, bArrAsUnsignedByteArray.length);
        byte[] bArrPrf = prf(blockCipher, Arrays.concatenate(bArr2, bArr3));
        if (i9 > 16) {
            int i13 = (i9 + 15) / 16;
            byte[] bArr4 = new byte[i13 * 16];
            int iBigEndianToInt = Pack.bigEndianToInt(bArrPrf, 12);
            System.arraycopy(bArrPrf, 0, bArr4, 0, 16);
            for (int i14 = 1; i14 < i13; i14++) {
                int i15 = i14 * 16;
                System.arraycopy(bArrPrf, 0, bArr4, i15, 12);
                Pack.intToBigEndian(iBigEndianToInt ^ i14, bArr4, i15 + 12);
                blockCipher.processBlock(bArr4, i15, bArr4, i15);
            }
            bArrPrf = bArr4;
        }
        return num(bArrPrf, 0, i9);
    }

    public static BigInteger calculateY_FF3(BlockCipher blockCipher, byte[] bArr, int i8, int i9, short[] sArr, RadixConverter radixConverter) {
        byte[] bArr2 = new byte[16];
        Pack.intToBigEndian(Pack.bigEndianToInt(bArr, i8) ^ i9, bArr2, 0);
        BigIntegers.asUnsignedByteArray(radixConverter.fromEncoding(sArr), bArr2, 4, 12);
        Arrays.reverseInPlace(bArr2);
        blockCipher.processBlock(bArr2, 0, bArr2, 0);
        Arrays.reverseInPlace(bArr2);
        return num(bArr2, 0, 16);
    }

    public static void checkArgs(BlockCipher blockCipher, boolean z, int i8, byte[] bArr, int i9, int i10) {
        checkCipher(blockCipher);
        if (i8 < 2 || i8 > 256) {
            throw new IllegalArgumentException();
        }
        checkData(z, i8, bArr, i9, i10);
    }

    public static void checkCipher(BlockCipher blockCipher) {
        if (16 != blockCipher.getBlockSize()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkData(boolean z, int i8, byte[] bArr, int i9, int i10) {
        checkLength(z, i8, i10);
        for (int i11 = 0; i11 < i10; i11++) {
            if ((bArr[i9 + i11] & 255) >= i8) {
                throw new IllegalArgumentException("input data outside of radix");
            }
        }
    }

    private static void checkLength(boolean z, int i8, int i9) {
        int iFloor;
        if (i9 >= 2) {
            double d = i8;
            if (Math.pow(d, i9) >= 1000000.0d) {
                if (!z && i9 > (iFloor = ((int) Math.floor(Math.log(TWO_TO_96) / Math.log(d))) * 2)) {
                    throw new IllegalArgumentException(b.j(iFloor, "maximum input length is "));
                }
                return;
            }
        }
        throw new IllegalArgumentException("input too short");
    }

    public static short[] decFF1(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, int i8, int i9, int i10, short[] sArr, short[] sArr2) {
        int radix = radixConverter.getRadix();
        int length = bArr.length;
        int iCalculateB_FF1 = calculateB_FF1(radix, i10);
        int i11 = (iCalculateB_FF1 + 7) & (-4);
        byte[] bArrCalculateP_FF1 = calculateP_FF1(radix, (byte) i9, i8, length);
        BigInteger[] bigIntegerArrCalculateModUV = calculateModUV(BigInteger.valueOf(radix), i9, i10);
        int i12 = 9;
        short[] sArr3 = sArr2;
        int i13 = i9;
        short[] sArr4 = sArr;
        while (i12 >= 0) {
            int i14 = iCalculateB_FF1;
            byte[] bArr2 = bArrCalculateP_FF1;
            int i15 = i12;
            i13 = i8 - i13;
            radixConverter.toEncoding(radixConverter.fromEncoding(sArr3).subtract(calculateY_FF1(blockCipher, bArr, i14, i11, i15, bArr2, sArr4, radixConverter)).mod(bigIntegerArrCalculateModUV[i15 & 1]), i13, sArr3);
            i12 = i15 - 1;
            short[] sArr5 = sArr3;
            sArr3 = sArr4;
            sArr4 = sArr5;
            bArrCalculateP_FF1 = bArr2;
            iCalculateB_FF1 = i14;
        }
        return Arrays.concatenate(sArr4, sArr3);
    }

    private static short[] decFF3_1(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, int i8, int i9, int i10, short[] sArr, short[] sArr2) {
        BigInteger[] bigIntegerArrCalculateModUV = calculateModUV(BigInteger.valueOf(radixConverter.getRadix()), i9, i10);
        Arrays.reverseInPlace(sArr);
        Arrays.reverseInPlace(sArr2);
        short[] sArr3 = sArr;
        short[] sArr4 = sArr2;
        int i11 = 7;
        while (i11 >= 0) {
            i10 = i8 - i10;
            int i12 = i11 & 1;
            BlockCipher blockCipher2 = blockCipher;
            RadixConverter radixConverter2 = radixConverter;
            radixConverter2.toEncoding(radixConverter2.fromEncoding(sArr4).subtract(calculateY_FF3(blockCipher2, bArr, 4 - (i12 * 4), i11, sArr3, radixConverter2)).mod(bigIntegerArrCalculateModUV[1 - i12]), i10, sArr4);
            i11--;
            short[] sArr5 = sArr3;
            sArr3 = sArr4;
            sArr4 = sArr5;
            blockCipher = blockCipher2;
            radixConverter = radixConverter2;
        }
        Arrays.reverseInPlace(sArr3);
        Arrays.reverseInPlace(sArr4);
        return Arrays.concatenate(sArr3, sArr4);
    }

    public static byte[] decryptFF1(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, byte[] bArr2, int i8, int i9) {
        checkArgs(blockCipher, true, radixConverter.getRadix(), bArr2, i8, i9);
        int i10 = i9 / 2;
        int i11 = i9 - i10;
        return toByte(decFF1(blockCipher, radixConverter, bArr, i9, i10, i11, toShort(bArr2, i8, i10), toShort(bArr2, i8 + i10, i11)));
    }

    public static short[] decryptFF1w(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, short[] sArr, int i8, int i9) {
        checkArgs(blockCipher, true, radixConverter.getRadix(), sArr, i8, i9);
        int i10 = i9 / 2;
        int i11 = i9 - i10;
        short[] sArr2 = new short[i10];
        short[] sArr3 = new short[i11];
        System.arraycopy(sArr, i8, sArr2, 0, i10);
        System.arraycopy(sArr, i8 + i10, sArr3, 0, i11);
        return decFF1(blockCipher, radixConverter, bArr, i9, i10, i11, sArr2, sArr3);
    }

    public static byte[] decryptFF3(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, byte[] bArr2, int i8, int i9) {
        checkArgs(blockCipher, false, radixConverter.getRadix(), bArr2, i8, i9);
        if (bArr.length == 8) {
            return implDecryptFF3(blockCipher, radixConverter, bArr, bArr2, i8, i9);
        }
        throw new IllegalArgumentException();
    }

    public static byte[] decryptFF3_1(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, byte[] bArr2, int i8, int i9) {
        checkArgs(blockCipher, false, radixConverter.getRadix(), bArr2, i8, i9);
        if (bArr.length == 7) {
            return implDecryptFF3(blockCipher, radixConverter, calculateTweak64_FF3_1(bArr), bArr2, i8, i9);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    public static short[] decryptFF3_1w(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, short[] sArr, int i8, int i9) {
        checkArgs(blockCipher, false, radixConverter.getRadix(), sArr, i8, i9);
        if (bArr.length == 7) {
            return implDecryptFF3w(blockCipher, radixConverter, calculateTweak64_FF3_1(bArr), sArr, i8, i9);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    private static short[] encFF1(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, int i8, int i9, int i10, short[] sArr, short[] sArr2) {
        int radix = radixConverter.getRadix();
        int length = bArr.length;
        int iCalculateB_FF1 = calculateB_FF1(radix, i10);
        int i11 = (iCalculateB_FF1 + 7) & (-4);
        byte[] bArrCalculateP_FF1 = calculateP_FF1(radix, (byte) i9, i8, length);
        BigInteger[] bigIntegerArrCalculateModUV = calculateModUV(BigInteger.valueOf(radix), i9, i10);
        int i12 = 0;
        short[] sArr3 = sArr;
        int i13 = i10;
        short[] sArr4 = sArr2;
        while (i12 < 10) {
            int i14 = iCalculateB_FF1;
            byte[] bArr2 = bArrCalculateP_FF1;
            int i15 = i12;
            i13 = i8 - i13;
            radixConverter.toEncoding(radixConverter.fromEncoding(sArr3).add(calculateY_FF1(blockCipher, bArr, i14, i11, i15, bArr2, sArr4, radixConverter)).mod(bigIntegerArrCalculateModUV[i15 & 1]), i13, sArr3);
            i12 = i15 + 1;
            short[] sArr5 = sArr3;
            sArr3 = sArr4;
            sArr4 = sArr5;
            bArrCalculateP_FF1 = bArr2;
            iCalculateB_FF1 = i14;
        }
        return Arrays.concatenate(sArr3, sArr4);
    }

    private static short[] encFF3_1(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, int i8, int i9, int i10, short[] sArr, short[] sArr2) {
        BigInteger[] bigIntegerArrCalculateModUV = calculateModUV(BigInteger.valueOf(radixConverter.getRadix()), i9, i10);
        Arrays.reverseInPlace(sArr);
        Arrays.reverseInPlace(sArr2);
        short[] sArr3 = sArr2;
        int i11 = 0;
        while (i11 < 8) {
            i9 = i8 - i9;
            int i12 = i11 & 1;
            BlockCipher blockCipher2 = blockCipher;
            RadixConverter radixConverter2 = radixConverter;
            radixConverter2.toEncoding(radixConverter2.fromEncoding(sArr).add(calculateY_FF3(blockCipher2, bArr, 4 - (i12 * 4), i11, sArr3, radixConverter2)).mod(bigIntegerArrCalculateModUV[1 - i12]), i9, sArr);
            i11++;
            short[] sArr4 = sArr3;
            sArr3 = sArr;
            sArr = sArr4;
            blockCipher = blockCipher2;
            radixConverter = radixConverter2;
        }
        Arrays.reverseInPlace(sArr);
        Arrays.reverseInPlace(sArr3);
        return Arrays.concatenate(sArr, sArr3);
    }

    public static byte[] encryptFF1(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, byte[] bArr2, int i8, int i9) {
        checkArgs(blockCipher, true, radixConverter.getRadix(), bArr2, i8, i9);
        int i10 = i9 / 2;
        int i11 = i9 - i10;
        return toByte(encFF1(blockCipher, radixConverter, bArr, i9, i10, i11, toShort(bArr2, i8, i10), toShort(bArr2, i8 + i10, i11)));
    }

    public static short[] encryptFF1w(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, short[] sArr, int i8, int i9) {
        checkArgs(blockCipher, true, radixConverter.getRadix(), sArr, i8, i9);
        int i10 = i9 / 2;
        int i11 = i9 - i10;
        short[] sArr2 = new short[i10];
        short[] sArr3 = new short[i11];
        System.arraycopy(sArr, i8, sArr2, 0, i10);
        System.arraycopy(sArr, i8 + i10, sArr3, 0, i11);
        return encFF1(blockCipher, radixConverter, bArr, i9, i10, i11, sArr2, sArr3);
    }

    public static byte[] encryptFF3(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, byte[] bArr2, int i8, int i9) {
        checkArgs(blockCipher, false, radixConverter.getRadix(), bArr2, i8, i9);
        if (bArr.length == 8) {
            return implEncryptFF3(blockCipher, radixConverter, bArr, bArr2, i8, i9);
        }
        throw new IllegalArgumentException();
    }

    public static byte[] encryptFF3_1(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, byte[] bArr2, int i8, int i9) {
        checkArgs(blockCipher, false, radixConverter.getRadix(), bArr2, i8, i9);
        if (bArr.length == 7) {
            return encryptFF3(blockCipher, radixConverter, calculateTweak64_FF3_1(bArr), bArr2, i8, i9);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    public static short[] encryptFF3_1w(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, short[] sArr, int i8, int i9) {
        checkArgs(blockCipher, false, radixConverter.getRadix(), sArr, i8, i9);
        if (bArr.length == 7) {
            return encryptFF3w(blockCipher, radixConverter, calculateTweak64_FF3_1(bArr), sArr, i8, i9);
        }
        throw new IllegalArgumentException("tweak should be 56 bits");
    }

    public static short[] encryptFF3w(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, short[] sArr, int i8, int i9) {
        checkArgs(blockCipher, false, radixConverter.getRadix(), sArr, i8, i9);
        if (bArr.length == 8) {
            return implEncryptFF3w(blockCipher, radixConverter, bArr, sArr, i8, i9);
        }
        throw new IllegalArgumentException();
    }

    public static byte[] implDecryptFF3(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, byte[] bArr2, int i8, int i9) {
        int i10 = i9 / 2;
        int i11 = i9 - i10;
        return toByte(decFF3_1(blockCipher, radixConverter, bArr, i9, i10, i11, toShort(bArr2, i8, i11), toShort(bArr2, i8 + i11, i10)));
    }

    public static short[] implDecryptFF3w(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, short[] sArr, int i8, int i9) {
        int i10 = i9 / 2;
        int i11 = i9 - i10;
        short[] sArr2 = new short[i11];
        short[] sArr3 = new short[i10];
        System.arraycopy(sArr, i8, sArr2, 0, i11);
        System.arraycopy(sArr, i8 + i11, sArr3, 0, i10);
        return decFF3_1(blockCipher, radixConverter, bArr, i9, i10, i11, sArr2, sArr3);
    }

    public static byte[] implEncryptFF3(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, byte[] bArr2, int i8, int i9) {
        int i10 = i9 / 2;
        int i11 = i9 - i10;
        return toByte(encFF3_1(blockCipher, radixConverter, bArr, i9, i10, i11, toShort(bArr2, i8, i11), toShort(bArr2, i8 + i11, i10)));
    }

    public static short[] implEncryptFF3w(BlockCipher blockCipher, RadixConverter radixConverter, byte[] bArr, short[] sArr, int i8, int i9) {
        int i10 = i9 / 2;
        int i11 = i9 - i10;
        short[] sArr2 = new short[i11];
        short[] sArr3 = new short[i10];
        System.arraycopy(sArr, i8, sArr2, 0, i11);
        System.arraycopy(sArr, i8 + i11, sArr3, 0, i10);
        return encFF3_1(blockCipher, radixConverter, bArr, i9, i10, i11, sArr2, sArr3);
    }

    public static BigInteger num(byte[] bArr, int i8, int i9) {
        return new BigInteger(1, Arrays.copyOfRange(bArr, i8, i9 + i8));
    }

    public static byte[] prf(BlockCipher blockCipher, byte[] bArr) {
        if (bArr.length % 16 != 0) {
            throw new IllegalArgumentException();
        }
        int length = bArr.length / 16;
        byte[] bArr2 = new byte[16];
        for (int i8 = 0; i8 < length; i8++) {
            Bytes.xorTo(16, bArr, i8 * 16, bArr2, 0);
            blockCipher.processBlock(bArr2, 0, bArr2, 0);
        }
        return bArr2;
    }

    private static byte[] toByte(short[] sArr) {
        int length = sArr.length;
        byte[] bArr = new byte[length];
        for (int i8 = 0; i8 != length; i8++) {
            bArr[i8] = (byte) sArr[i8];
        }
        return bArr;
    }

    private static short[] toShort(byte[] bArr, int i8, int i9) {
        short[] sArr = new short[i9];
        for (int i10 = 0; i10 != i9; i10++) {
            sArr[i10] = (short) (bArr[i8 + i10] & 255);
        }
        return sArr;
    }

    public static void checkArgs(BlockCipher blockCipher, boolean z, int i8, short[] sArr, int i9, int i10) {
        checkCipher(blockCipher);
        if (i8 < 2 || i8 > 65536) {
            throw new IllegalArgumentException();
        }
        checkData(z, i8, sArr, i9, i10);
    }

    public static void checkData(boolean z, int i8, short[] sArr, int i9, int i10) {
        checkLength(z, i8, i10);
        for (int i11 = 0; i11 < i10; i11++) {
            if ((sArr[i9 + i11] & HPKE.aead_EXPORT_ONLY) >= i8) {
                throw new IllegalArgumentException("input data outside of radix");
            }
        }
    }
}
