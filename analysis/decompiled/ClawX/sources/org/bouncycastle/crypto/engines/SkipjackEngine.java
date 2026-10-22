package org.bouncycastle.crypto.engines;

import m0.f;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.KeyParameter;

/* loaded from: classes.dex */
public class SkipjackEngine implements BlockCipher {
    static final int BLOCK_SIZE = 8;
    static short[] ftable = {163, 215, 9, 131, 248, 72, 246, 244, 179, 33, 21, 120, 153, 177, 175, 249, 231, 45, 77, 138, 206, 76, 202, 46, 82, 149, 217, 30, 78, 56, 68, 40, 10, 223, 2, 160, 23, 241, 96, 104, 18, 183, 122, 195, 233, 250, 61, 83, 150, 132, 107, 186, 242, 99, 154, 25, 124, 174, 229, 245, 247, 22, 106, 162, 57, 182, 123, 15, 193, 147, 129, 27, 238, 180, 26, 234, 208, 145, 47, 184, 85, 185, 218, 133, 63, 65, 191, 224, 90, 88, 128, 95, 102, 11, 216, 144, 53, 213, 192, 167, 51, 6, 101, 105, 69, 0, 148, 86, 109, 152, 155, 118, 151, 252, 178, 194, 176, 254, 219, 32, 225, 235, 214, 228, 221, 71, 74, 29, 66, 237, 158, 110, 73, 60, 205, 67, 39, 210, 7, 212, 222, 199, 103, 24, 137, 203, 48, 31, 141, 198, 143, 170, 200, 116, 220, 201, 93, 92, 49, 164, 112, 136, 97, 44, 159, 13, 43, 135, 80, 130, 84, 100, 38, 125, 3, 64, 52, 75, 28, 115, 209, 196, 253, 59, 204, 251, 127, 171, 230, 62, 91, 165, 173, 4, 35, 156, 20, 81, 34, 240, 41, 121, 113, 126, 255, 140, 14, 226, 12, 239, 188, 114, 117, 111, 55, 161, 236, 211, 142, 98, 139, 134, 16, 232, 8, 119, 17, 190, 146, 79, 36, 197, 50, 54, 157, 207, 243, 166, 187, 172, 94, 108, 169, 19, 87, 37, 181, 227, 189, 168, 58, 1, 5, 89, 42, 70};
    private boolean encrypting;
    private int[] key0;
    private int[] key1;
    private int[] key2;
    private int[] key3;

    public SkipjackEngine() {
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 80));
    }

    private int g(int i8, int i9) {
        int i10 = (i9 >> 8) & 255;
        int i11 = i9 & 255;
        short[] sArr = ftable;
        int i12 = i10 ^ sArr[this.key0[i8] ^ i11];
        int i13 = i11 ^ sArr[this.key1[i8] ^ i12];
        int i14 = i12 ^ sArr[this.key2[i8] ^ i13];
        return (i14 << 8) + (sArr[this.key3[i8] ^ i14] ^ i13);
    }

    private CryptoServicePurpose getPurpose() {
        return this.key0 == null ? CryptoServicePurpose.ANY : this.encrypting ? CryptoServicePurpose.ENCRYPTION : CryptoServicePurpose.DECRYPTION;
    }

    private int h(int i8, int i9) {
        int i10 = i9 & 255;
        int i11 = (i9 >> 8) & 255;
        short[] sArr = ftable;
        int i12 = i10 ^ sArr[this.key3[i8] ^ i11];
        int i13 = i11 ^ sArr[this.key2[i8] ^ i12];
        int i14 = i12 ^ sArr[this.key1[i8] ^ i13];
        return ((sArr[this.key0[i8] ^ i14] ^ i13) << 8) + i14;
    }

    public int decryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int i10 = (bArr[i8] << 8) + (bArr[i8 + 1] & 255);
        int i11 = (bArr[i8 + 2] << 8) + (bArr[i8 + 3] & 255);
        int i12 = (bArr[i8 + 4] << 8) + (bArr[i8 + 5] & 255);
        int i13 = (bArr[i8 + 6] << 8) + (bArr[i8 + 7] & 255);
        int i14 = 31;
        for (int i15 = 0; i15 < 2; i15++) {
            int i16 = 0;
            while (i16 < 8) {
                int iH = h(i14, i11);
                int i17 = (i12 ^ iH) ^ (i14 + 1);
                i14--;
                i16++;
                int i18 = i13;
                i13 = i10;
                i10 = iH;
                i11 = i17;
                i12 = i18;
            }
            int i19 = 0;
            while (i19 < 8) {
                int i20 = (i10 ^ i11) ^ (i14 + 1);
                int iH2 = h(i14, i11);
                i14--;
                i19++;
                int i21 = i13;
                i13 = i20;
                i10 = iH2;
                i11 = i12;
                i12 = i21;
            }
        }
        bArr2[i9] = (byte) (i10 >> 8);
        bArr2[i9 + 1] = (byte) i10;
        bArr2[i9 + 2] = (byte) (i11 >> 8);
        bArr2[i9 + 3] = (byte) i11;
        bArr2[i9 + 4] = (byte) (i12 >> 8);
        bArr2[i9 + 5] = (byte) i12;
        bArr2[i9 + 6] = (byte) (i13 >> 8);
        bArr2[i9 + 7] = (byte) i13;
        return 8;
    }

    public int encryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int i10 = (bArr[i8] << 8) + (bArr[i8 + 1] & 255);
        int iG = (bArr[i8 + 2] << 8) + (bArr[i8 + 3] & 255);
        int i11 = (bArr[i8 + 4] << 8) + (bArr[i8 + 5] & 255);
        int i12 = (bArr[i8 + 6] << 8) + (bArr[i8 + 7] & 255);
        int i13 = 0;
        for (int i14 = 0; i14 < 2; i14++) {
            int i15 = 0;
            while (i15 < 8) {
                int iG2 = g(i13, i10);
                i13++;
                i15++;
                int i16 = iG;
                iG = iG2;
                i10 = (i12 ^ iG2) ^ i13;
                i12 = i11;
                i11 = i16;
            }
            int i17 = 0;
            while (i17 < 8) {
                int i18 = i13 + 1;
                int i19 = (iG ^ i10) ^ i18;
                i17++;
                iG = g(i13, i10);
                i10 = i12;
                i12 = i11;
                i11 = i19;
                i13 = i18;
            }
        }
        bArr2[i9] = (byte) (i10 >> 8);
        bArr2[i9 + 1] = (byte) i10;
        bArr2[i9 + 2] = (byte) (iG >> 8);
        bArr2[i9 + 3] = (byte) iG;
        bArr2[i9 + 4] = (byte) (i11 >> 8);
        bArr2[i9 + 5] = (byte) i11;
        bArr2[i9 + 6] = (byte) (i12 >> 8);
        bArr2[i9 + 7] = (byte) i12;
        return 8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "SKIPJACK";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException(f.h(cipherParameters, "invalid parameter passed to SKIPJACK init - "));
        }
        byte[] key = ((KeyParameter) cipherParameters).getKey();
        this.encrypting = z;
        this.key0 = new int[32];
        this.key1 = new int[32];
        this.key2 = new int[32];
        this.key3 = new int[32];
        for (int i8 = 0; i8 < 32; i8++) {
            int i9 = i8 * 4;
            this.key0[i8] = key[i9 % 10] & 255;
            this.key1[i8] = key[(i9 + 1) % 10] & 255;
            this.key2[i8] = key[(i9 + 2) % 10] & 255;
            this.key3[i8] = key[(i9 + 3) % 10] & 255;
        }
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 80, cipherParameters, getPurpose()));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        if (this.key1 == null) {
            throw new IllegalStateException("SKIPJACK engine not initialised");
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
