package org.bouncycastle.crypto.engines;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import m0.f;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class GOST3412_2015Engine implements BlockCipher {
    protected static final int BLOCK_SIZE = 16;
    private static final byte[] PI = {-4, -18, -35, 17, -49, 110, 49, 22, -5, -60, -6, -38, 35, -59, 4, 77, -23, 119, -16, -37, -109, 46, -103, -70, 23, 54, -15, -69, 20, -51, 95, -63, -7, 24, 101, 90, -30, 92, -17, 33, -127, 28, 60, 66, -117, 1, -114, 79, 5, -124, 2, -82, -29, 106, -113, -96, 6, 11, -19, -104, AbstractJsonLexerKt.TC_INVALID, -44, -45, 31, -21, 52, 44, 81, -22, -56, 72, -85, -14, 42, 104, -94, -3, 58, -50, -52, -75, 112, 14, 86, 8, 12, 118, 18, -65, 114, 19, 71, -100, -73, 93, -121, 21, -95, -106, 41, 16, 123, -102, -57, -13, -111, 120, 111, -99, -98, -78, -79, 50, 117, 25, 61, -1, 53, -118, 126, 109, 84, -58, -128, -61, -67, 13, 87, -33, -11, 36, -87, 62, -88, 67, -55, -41, 121, -42, -10, 124, 34, -71, 3, -32, 15, -20, -34, 122, -108, -80, PSSSigner.TRAILER_IMPLICIT, -36, -24, 40, 80, 78, 51, 10, 74, -89, -105, 96, 115, 30, 0, 98, 68, 26, -72, 56, -126, 100, -97, 38, 65, -83, 69, 70, -110, 39, 94, 85, 47, -116, -93, -91, 125, 105, -43, -107, 59, 7, 88, -77, 64, -122, -84, 29, -9, 48, 55, 107, -28, -120, -39, -25, -119, -31, 27, -125, 73, 76, 63, -8, -2, -115, 83, -86, -112, -54, -40, -123, 97, 32, 113, 103, -92, 45, 43, 9, 91, -53, -101, 37, -48, -66, -27, 108, 82, 89, -90, 116, -46, -26, -12, -76, -64, -47, 102, -81, -62, 57, 75, 99, -74};
    private static final byte[] inversePI = {-91, 45, 50, -113, 14, 48, 56, -64, 84, -26, -98, 57, 85, 126, 82, -111, 100, 3, 87, 90, 28, 96, 7, 24, 33, 114, -88, -47, 41, -58, -92, 63, -32, 39, -115, 12, -126, -22, -82, -76, -102, 99, 73, -27, 66, -28, 21, -73, -56, 6, 112, -99, 65, 117, 25, -55, -86, -4, 77, -65, 42, 115, -124, -43, -61, -81, 43, -122, -89, -79, -78, 91, 70, -45, -97, -3, -44, 15, -100, 47, -101, 67, -17, -39, 121, -74, 83, AbstractJsonLexerKt.TC_INVALID, -63, -16, 35, -25, 37, 94, -75, 30, -94, -33, -90, -2, -84, 34, -7, -30, 74, PSSSigner.TRAILER_IMPLICIT, 53, -54, -18, 120, 5, 107, 81, -31, 89, -93, -14, 113, 86, 17, 106, -119, -108, 101, -116, -69, 119, 60, 123, 40, -85, -46, 49, -34, -60, 95, -52, -49, 118, 44, -72, -40, 46, 54, -37, 105, -77, 20, -107, -66, 98, -95, 59, 22, 102, -23, 92, 108, 109, -83, 55, 97, 75, -71, -29, -70, -15, -96, -123, -125, -38, 71, -59, -80, 51, -6, -106, 111, 110, -62, -10, 80, -1, 93, -87, -114, 23, 27, -105, 125, -20, 88, -9, 31, -5, 124, 9, 13, 122, 103, 69, -121, -36, -24, 79, 29, 78, 4, -21, -8, -13, 62, 61, -67, -118, -120, -35, -51, 11, 19, -104, 2, -109, -128, -112, -48, 36, 52, -53, -19, -12, -50, -103, 16, 68, 64, -110, 58, 1, 38, 18, 26, 72, 104, -11, -127, -117, -57, -42, 32, 10, 8, 0, 76, -41, 116};
    private boolean forEncryption;
    private final byte[] lFactors = {-108, 32, -123, 16, -62, -64, 1, -5, 1, -64, -62, 16, -123, 32, -108, 1};
    private int KEY_LENGTH = 32;
    private int SUB_LENGTH = 32 / 2;
    private byte[][] subKeys = null;
    private byte[][] _gf_mul = init_gf256_mul_table();

    private void C(byte[] bArr, int i8) {
        Arrays.clear(bArr);
        bArr[15] = (byte) i8;
        L(bArr);
    }

    private void F(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArrLSX = LSX(bArr, bArr2);
        X(bArrLSX, bArr3);
        System.arraycopy(bArr2, 0, bArr3, 0, this.SUB_LENGTH);
        System.arraycopy(bArrLSX, 0, bArr2, 0, this.SUB_LENGTH);
    }

    private void GOST3412_2015Func(byte[] bArr, int i8, byte[] bArr2, int i9) {
        byte[][] bArr3;
        byte[] bArrCopyOf = new byte[16];
        System.arraycopy(bArr, i8, bArrCopyOf, 0, 16);
        int i10 = 9;
        if (this.forEncryption) {
            for (int i11 = 0; i11 < 9; i11++) {
                bArrCopyOf = Arrays.copyOf(LSX(this.subKeys[i11], bArrCopyOf), 16);
            }
            X(bArrCopyOf, this.subKeys[9]);
        } else {
            while (true) {
                bArr3 = this.subKeys;
                if (i10 <= 0) {
                    break;
                }
                bArrCopyOf = Arrays.copyOf(XSL(bArr3[i10], bArrCopyOf), 16);
                i10--;
            }
            X(bArrCopyOf, bArr3[0]);
        }
        System.arraycopy(bArrCopyOf, 0, bArr2, i9, 16);
    }

    private void L(byte[] bArr) {
        for (int i8 = 0; i8 < 16; i8++) {
            R(bArr);
        }
    }

    private byte[] LSX(byte[] bArr, byte[] bArr2) {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        X(bArrCopyOf, bArr2);
        S(bArrCopyOf);
        L(bArrCopyOf);
        return bArrCopyOf;
    }

    private void R(byte[] bArr) {
        byte bL = l(bArr);
        System.arraycopy(bArr, 0, bArr, 1, 15);
        bArr[0] = bL;
    }

    private void S(byte[] bArr) {
        for (int i8 = 0; i8 < bArr.length; i8++) {
            bArr[i8] = PI[unsignedByte(bArr[i8])];
        }
    }

    private void X(byte[] bArr, byte[] bArr2) {
        for (int i8 = 0; i8 < bArr.length; i8++) {
            bArr[i8] = (byte) (bArr[i8] ^ bArr2[i8]);
        }
    }

    private byte[] XSL(byte[] bArr, byte[] bArr2) {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        X(bArrCopyOf, bArr2);
        inverseL(bArrCopyOf);
        inverseS(bArrCopyOf);
        return bArrCopyOf;
    }

    private void generateSubKeys(byte[] bArr) {
        int i8;
        if (bArr.length != this.KEY_LENGTH) {
            throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
        }
        this.subKeys = new byte[10][];
        for (int i9 = 0; i9 < 10; i9++) {
            this.subKeys[i9] = new byte[this.SUB_LENGTH];
        }
        int i10 = this.SUB_LENGTH;
        byte[] bArr2 = new byte[i10];
        byte[] bArr3 = new byte[i10];
        int i11 = 0;
        while (true) {
            i8 = this.SUB_LENGTH;
            if (i11 >= i8) {
                break;
            }
            byte[][] bArr4 = this.subKeys;
            byte[] bArr5 = bArr4[0];
            byte b9 = bArr[i11];
            bArr2[i11] = b9;
            bArr5[i11] = b9;
            byte[] bArr6 = bArr4[1];
            byte b10 = bArr[i8 + i11];
            bArr3[i11] = b10;
            bArr6[i11] = b10;
            i11++;
        }
        byte[] bArr7 = new byte[i8];
        for (int i12 = 1; i12 < 5; i12++) {
            for (int i13 = 1; i13 <= 8; i13++) {
                C(bArr7, ((i12 - 1) * 8) + i13);
                F(bArr7, bArr2, bArr3);
            }
            int i14 = i12 * 2;
            System.arraycopy(bArr2, 0, this.subKeys[i14], 0, this.SUB_LENGTH);
            System.arraycopy(bArr3, 0, this.subKeys[i14 + 1], 0, this.SUB_LENGTH);
        }
    }

    private static byte[][] init_gf256_mul_table() {
        byte[][] bArr = new byte[256][];
        for (int i8 = 0; i8 < 256; i8++) {
            bArr[i8] = new byte[256];
            for (int i9 = 0; i9 < 256; i9++) {
                bArr[i8][i9] = kuz_mul_gf256_slow((byte) i8, (byte) i9);
            }
        }
        return bArr;
    }

    private void inverseL(byte[] bArr) {
        for (int i8 = 0; i8 < 16; i8++) {
            inverseR(bArr);
        }
    }

    private void inverseR(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 1, bArr2, 0, 15);
        bArr2[15] = bArr[0];
        byte bL = l(bArr2);
        System.arraycopy(bArr, 1, bArr, 0, 15);
        bArr[15] = bL;
    }

    private void inverseS(byte[] bArr) {
        for (int i8 = 0; i8 < bArr.length; i8++) {
            bArr[i8] = inversePI[unsignedByte(bArr[i8])];
        }
    }

    private static byte kuz_mul_gf256_slow(byte b9, byte b10) {
        byte b11 = 0;
        for (byte b12 = 0; b12 < 8 && b9 != 0 && b10 != 0; b12 = (byte) (b12 + 1)) {
            if ((b10 & 1) != 0) {
                b11 = (byte) (b11 ^ b9);
            }
            byte b13 = (byte) (b9 & 128);
            b9 = (byte) (b9 << 1);
            if (b13 != 0) {
                b9 = (byte) (b9 ^ 195);
            }
            b10 = (byte) (b10 >> 1);
        }
        return b11;
    }

    private byte l(byte[] bArr) {
        byte b9 = bArr[15];
        for (int i8 = 14; i8 >= 0; i8--) {
            b9 = (byte) (b9 ^ this._gf_mul[unsignedByte(bArr[i8])][unsignedByte(this.lFactors[i8])]);
        }
        return b9;
    }

    private int unsignedByte(byte b9) {
        return b9 & 255;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "GOST3412_2015";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.forEncryption = z;
            generateSubKeys(((KeyParameter) cipherParameters).getKey());
        } else if (cipherParameters != null) {
            throw new IllegalArgumentException(f.h(cipherParameters, "invalid parameter passed to GOST3412_2015 init - "));
        }
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        if (this.subKeys == null) {
            throw new IllegalStateException("GOST3412_2015 engine not initialised");
        }
        if (i8 + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i9 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        GOST3412_2015Func(bArr, i8, bArr2, i9);
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
