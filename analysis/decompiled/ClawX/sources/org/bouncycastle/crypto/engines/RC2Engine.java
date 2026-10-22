package org.bouncycastle.crypto.engines;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import m0.f;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.RC2Parameters;
import org.bouncycastle.crypto.signers.PSSSigner;

/* loaded from: classes.dex */
public class RC2Engine implements BlockCipher {
    private static final int BLOCK_SIZE = 8;
    private static byte[] piTable = {-39, 120, -7, -60, 25, -35, -75, -19, 40, -23, -3, 121, 74, -96, -40, -99, -58, 126, 55, -125, 43, 118, 83, -114, 98, 76, 100, -120, 68, -117, -5, -94, 23, -102, 89, -11, -121, -77, 79, 19, 97, 69, 109, -115, 9, -127, 125, 50, -67, -113, 64, -21, -122, -73, 123, 11, -16, -107, 33, 34, 92, 107, 78, -126, 84, -42, 101, -109, -50, 96, -78, 28, 115, 86, -64, 20, -89, -116, -15, -36, 18, 117, -54, 31, 59, -66, -28, -47, 66, 61, -44, 48, -93, 60, -74, 38, 111, -65, 14, -38, 70, 105, 7, 87, 39, -14, 29, -101, PSSSigner.TRAILER_IMPLICIT, -108, 67, 3, -8, 17, -57, -10, -112, -17, 62, -25, 6, -61, -43, 47, -56, 102, 30, -41, 8, -24, -22, -34, -128, 82, -18, -9, -124, -86, 114, -84, 53, 77, 106, 42, -106, 26, -46, 113, 90, 21, 73, 116, 75, -97, -48, 94, 4, 24, -92, -20, -62, -32, 65, 110, 15, 81, -53, -52, 36, -111, -81, 80, -95, -12, 112, 57, -103, 124, 58, -123, 35, -72, -76, 122, -4, 2, 54, 91, 37, 85, -105, 49, 45, 93, -6, -104, -29, -118, -110, -82, 5, -33, 41, 16, 103, 108, -70, -55, -45, 0, -26, -49, -31, -98, -88, 44, 99, 22, 1, 63, 88, -30, -119, -87, 13, 56, 52, 27, -85, 51, -1, -80, -69, 72, 12, 95, -71, -79, -51, 46, -59, -13, -37, 71, -27, -91, -100, 119, 10, -90, 32, 104, -2, AbstractJsonLexerKt.TC_INVALID, -63, -83};
    private boolean encrypting;
    private int[] workingKey;

    private void decryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int iRotateWordLeft = ((bArr[i8 + 7] & 255) << 8) + (bArr[i8 + 6] & 255);
        int iRotateWordLeft2 = ((bArr[i8 + 5] & 255) << 8) + (bArr[i8 + 4] & 255);
        int iRotateWordLeft3 = ((bArr[i8 + 3] & 255) << 8) + (bArr[i8 + 2] & 255);
        int iRotateWordLeft4 = ((bArr[i8 + 1] & 255) << 8) + (bArr[i8] & 255);
        for (int i10 = 60; i10 >= 44; i10 -= 4) {
            iRotateWordLeft = rotateWordLeft(iRotateWordLeft, 11) - ((((~iRotateWordLeft2) & iRotateWordLeft4) + (iRotateWordLeft3 & iRotateWordLeft2)) + this.workingKey[i10 + 3]);
            iRotateWordLeft2 = rotateWordLeft(iRotateWordLeft2, 13) - ((((~iRotateWordLeft3) & iRotateWordLeft) + (iRotateWordLeft4 & iRotateWordLeft3)) + this.workingKey[i10 + 2]);
            iRotateWordLeft3 = rotateWordLeft(iRotateWordLeft3, 14) - ((((~iRotateWordLeft4) & iRotateWordLeft2) + (iRotateWordLeft & iRotateWordLeft4)) + this.workingKey[i10 + 1]);
            iRotateWordLeft4 = rotateWordLeft(iRotateWordLeft4, 15) - ((((~iRotateWordLeft) & iRotateWordLeft3) + (iRotateWordLeft2 & iRotateWordLeft)) + this.workingKey[i10]);
        }
        int[] iArr = this.workingKey;
        int iRotateWordLeft5 = iRotateWordLeft - iArr[iRotateWordLeft2 & 63];
        int iRotateWordLeft6 = iRotateWordLeft2 - iArr[iRotateWordLeft3 & 63];
        int iRotateWordLeft7 = iRotateWordLeft3 - iArr[iRotateWordLeft4 & 63];
        int iRotateWordLeft8 = iRotateWordLeft4 - iArr[iRotateWordLeft5 & 63];
        for (int i11 = 40; i11 >= 20; i11 -= 4) {
            iRotateWordLeft5 = rotateWordLeft(iRotateWordLeft5, 11) - ((((~iRotateWordLeft6) & iRotateWordLeft8) + (iRotateWordLeft7 & iRotateWordLeft6)) + this.workingKey[i11 + 3]);
            iRotateWordLeft6 = rotateWordLeft(iRotateWordLeft6, 13) - ((((~iRotateWordLeft7) & iRotateWordLeft5) + (iRotateWordLeft8 & iRotateWordLeft7)) + this.workingKey[i11 + 2]);
            iRotateWordLeft7 = rotateWordLeft(iRotateWordLeft7, 14) - ((((~iRotateWordLeft8) & iRotateWordLeft6) + (iRotateWordLeft5 & iRotateWordLeft8)) + this.workingKey[i11 + 1]);
            iRotateWordLeft8 = rotateWordLeft(iRotateWordLeft8, 15) - ((((~iRotateWordLeft5) & iRotateWordLeft7) + (iRotateWordLeft6 & iRotateWordLeft5)) + this.workingKey[i11]);
        }
        int[] iArr2 = this.workingKey;
        int iRotateWordLeft9 = iRotateWordLeft5 - iArr2[iRotateWordLeft6 & 63];
        int iRotateWordLeft10 = iRotateWordLeft6 - iArr2[iRotateWordLeft7 & 63];
        int iRotateWordLeft11 = iRotateWordLeft7 - iArr2[iRotateWordLeft8 & 63];
        int iRotateWordLeft12 = iRotateWordLeft8 - iArr2[iRotateWordLeft9 & 63];
        for (int i12 = 16; i12 >= 0; i12 -= 4) {
            iRotateWordLeft9 = rotateWordLeft(iRotateWordLeft9, 11) - ((((~iRotateWordLeft10) & iRotateWordLeft12) + (iRotateWordLeft11 & iRotateWordLeft10)) + this.workingKey[i12 + 3]);
            iRotateWordLeft10 = rotateWordLeft(iRotateWordLeft10, 13) - ((((~iRotateWordLeft11) & iRotateWordLeft9) + (iRotateWordLeft12 & iRotateWordLeft11)) + this.workingKey[i12 + 2]);
            iRotateWordLeft11 = rotateWordLeft(iRotateWordLeft11, 14) - ((((~iRotateWordLeft12) & iRotateWordLeft10) + (iRotateWordLeft9 & iRotateWordLeft12)) + this.workingKey[i12 + 1]);
            iRotateWordLeft12 = rotateWordLeft(iRotateWordLeft12, 15) - ((((~iRotateWordLeft9) & iRotateWordLeft11) + (iRotateWordLeft10 & iRotateWordLeft9)) + this.workingKey[i12]);
        }
        bArr2[i9] = (byte) iRotateWordLeft12;
        bArr2[i9 + 1] = (byte) (iRotateWordLeft12 >> 8);
        bArr2[i9 + 2] = (byte) iRotateWordLeft11;
        bArr2[i9 + 3] = (byte) (iRotateWordLeft11 >> 8);
        bArr2[i9 + 4] = (byte) iRotateWordLeft10;
        bArr2[i9 + 5] = (byte) (iRotateWordLeft10 >> 8);
        bArr2[i9 + 6] = (byte) iRotateWordLeft9;
        bArr2[i9 + 7] = (byte) (iRotateWordLeft9 >> 8);
    }

    private void encryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int iRotateWordLeft = ((bArr[i8 + 7] & 255) << 8) + (bArr[i8 + 6] & 255);
        int iRotateWordLeft2 = ((bArr[i8 + 5] & 255) << 8) + (bArr[i8 + 4] & 255);
        int iRotateWordLeft3 = ((bArr[i8 + 3] & 255) << 8) + (bArr[i8 + 2] & 255);
        int iRotateWordLeft4 = ((bArr[i8 + 1] & 255) << 8) + (bArr[i8] & 255);
        for (int i10 = 0; i10 <= 16; i10 += 4) {
            iRotateWordLeft4 = rotateWordLeft(iRotateWordLeft4 + ((~iRotateWordLeft) & iRotateWordLeft3) + (iRotateWordLeft2 & iRotateWordLeft) + this.workingKey[i10], 1);
            iRotateWordLeft3 = rotateWordLeft(iRotateWordLeft3 + ((~iRotateWordLeft4) & iRotateWordLeft2) + (iRotateWordLeft & iRotateWordLeft4) + this.workingKey[i10 + 1], 2);
            iRotateWordLeft2 = rotateWordLeft(iRotateWordLeft2 + ((~iRotateWordLeft3) & iRotateWordLeft) + (iRotateWordLeft4 & iRotateWordLeft3) + this.workingKey[i10 + 2], 3);
            iRotateWordLeft = rotateWordLeft(iRotateWordLeft + ((~iRotateWordLeft2) & iRotateWordLeft4) + (iRotateWordLeft3 & iRotateWordLeft2) + this.workingKey[i10 + 3], 5);
        }
        int[] iArr = this.workingKey;
        int iRotateWordLeft5 = iRotateWordLeft4 + iArr[iRotateWordLeft & 63];
        int iRotateWordLeft6 = iRotateWordLeft3 + iArr[iRotateWordLeft5 & 63];
        int iRotateWordLeft7 = iRotateWordLeft2 + iArr[iRotateWordLeft6 & 63];
        int iRotateWordLeft8 = iRotateWordLeft + iArr[iRotateWordLeft7 & 63];
        for (int i11 = 20; i11 <= 40; i11 += 4) {
            iRotateWordLeft5 = rotateWordLeft(iRotateWordLeft5 + ((~iRotateWordLeft8) & iRotateWordLeft6) + (iRotateWordLeft7 & iRotateWordLeft8) + this.workingKey[i11], 1);
            iRotateWordLeft6 = rotateWordLeft(iRotateWordLeft6 + ((~iRotateWordLeft5) & iRotateWordLeft7) + (iRotateWordLeft8 & iRotateWordLeft5) + this.workingKey[i11 + 1], 2);
            iRotateWordLeft7 = rotateWordLeft(iRotateWordLeft7 + ((~iRotateWordLeft6) & iRotateWordLeft8) + (iRotateWordLeft5 & iRotateWordLeft6) + this.workingKey[i11 + 2], 3);
            iRotateWordLeft8 = rotateWordLeft(iRotateWordLeft8 + ((~iRotateWordLeft7) & iRotateWordLeft5) + (iRotateWordLeft6 & iRotateWordLeft7) + this.workingKey[i11 + 3], 5);
        }
        int[] iArr2 = this.workingKey;
        int iRotateWordLeft9 = iRotateWordLeft5 + iArr2[iRotateWordLeft8 & 63];
        int iRotateWordLeft10 = iRotateWordLeft6 + iArr2[iRotateWordLeft9 & 63];
        int iRotateWordLeft11 = iRotateWordLeft7 + iArr2[iRotateWordLeft10 & 63];
        int iRotateWordLeft12 = iRotateWordLeft8 + iArr2[iRotateWordLeft11 & 63];
        for (int i12 = 44; i12 < 64; i12 += 4) {
            iRotateWordLeft9 = rotateWordLeft(iRotateWordLeft9 + ((~iRotateWordLeft12) & iRotateWordLeft10) + (iRotateWordLeft11 & iRotateWordLeft12) + this.workingKey[i12], 1);
            iRotateWordLeft10 = rotateWordLeft(iRotateWordLeft10 + ((~iRotateWordLeft9) & iRotateWordLeft11) + (iRotateWordLeft12 & iRotateWordLeft9) + this.workingKey[i12 + 1], 2);
            iRotateWordLeft11 = rotateWordLeft(iRotateWordLeft11 + ((~iRotateWordLeft10) & iRotateWordLeft12) + (iRotateWordLeft9 & iRotateWordLeft10) + this.workingKey[i12 + 2], 3);
            iRotateWordLeft12 = rotateWordLeft(iRotateWordLeft12 + ((~iRotateWordLeft11) & iRotateWordLeft9) + (iRotateWordLeft10 & iRotateWordLeft11) + this.workingKey[i12 + 3], 5);
        }
        bArr2[i9] = (byte) iRotateWordLeft9;
        bArr2[i9 + 1] = (byte) (iRotateWordLeft9 >> 8);
        bArr2[i9 + 2] = (byte) iRotateWordLeft10;
        bArr2[i9 + 3] = (byte) (iRotateWordLeft10 >> 8);
        bArr2[i9 + 4] = (byte) iRotateWordLeft11;
        bArr2[i9 + 5] = (byte) (iRotateWordLeft11 >> 8);
        bArr2[i9 + 6] = (byte) iRotateWordLeft12;
        bArr2[i9 + 7] = (byte) (iRotateWordLeft12 >> 8);
    }

    private int[] generateWorkingKey(byte[] bArr, int i8) {
        int[] iArr = new int[128];
        for (int i9 = 0; i9 != bArr.length; i9++) {
            iArr[i9] = bArr[i9] & 255;
        }
        int length = bArr.length;
        if (length < 128) {
            int i10 = iArr[length - 1];
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                i10 = piTable[(i10 + iArr[i11]) & 255] & 255;
                int i13 = length + 1;
                iArr[length] = i10;
                if (i13 >= 128) {
                    break;
                }
                length = i13;
                i11 = i12;
            }
        }
        int i14 = (i8 + 7) >> 3;
        int i15 = 128 - i14;
        int i16 = piTable[(255 >> ((-i8) & 7)) & iArr[i15]] & 255;
        iArr[i15] = i16;
        for (int i17 = 127 - i14; i17 >= 0; i17--) {
            i16 = piTable[i16 ^ iArr[i17 + i14]] & 255;
            iArr[i17] = i16;
        }
        int[] iArr2 = new int[64];
        for (int i18 = 0; i18 != 64; i18++) {
            int i19 = i18 * 2;
            iArr2[i18] = iArr[i19] + (iArr[i19 + 1] << 8);
        }
        return iArr2;
    }

    private int rotateWordLeft(int i8, int i9) {
        int i10 = 65535 & i8;
        return (i10 >> (16 - i9)) | (i10 << i9);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "RC2";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        byte[] key;
        this.encrypting = z;
        if (cipherParameters instanceof RC2Parameters) {
            RC2Parameters rC2Parameters = (RC2Parameters) cipherParameters;
            this.workingKey = generateWorkingKey(rC2Parameters.getKey(), rC2Parameters.getEffectiveKeyBits());
            key = rC2Parameters.getKey();
        } else {
            if (!(cipherParameters instanceof KeyParameter)) {
                throw new IllegalArgumentException(f.h(cipherParameters, "invalid parameter passed to RC2 init - "));
            }
            key = ((KeyParameter) cipherParameters).getKey();
            this.workingKey = generateWorkingKey(key, key.length * 8);
        }
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), key.length * 8, cipherParameters, Utils.getPurpose(z)));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public final int processBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        if (this.workingKey == null) {
            throw new IllegalStateException("RC2 engine not initialised");
        }
        if (i8 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i9 + 8 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        if (this.encrypting) {
            encryptBlock(bArr, i8, bArr2, i9);
            return 8;
        }
        decryptBlock(bArr, i8, bArr2, i9);
        return 8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
