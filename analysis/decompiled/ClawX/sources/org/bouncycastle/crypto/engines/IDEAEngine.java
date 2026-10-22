package org.bouncycastle.crypto.engines;

import m0.f;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.KeyParameter;

/* loaded from: classes.dex */
public class IDEAEngine implements BlockCipher {
    private static final int BASE = 65537;
    protected static final int BLOCK_SIZE = 8;
    private static final int MASK = 65535;
    private boolean forEncryption;
    private int[] workingKey = null;

    public IDEAEngine() {
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 128));
    }

    private int bytesToWord(byte[] bArr, int i8) {
        return ((bArr[i8] << 8) & 65280) + (bArr[i8 + 1] & 255);
    }

    private int[] expandKey(byte[] bArr) {
        int i8;
        int[] iArr = new int[52];
        int i9 = 0;
        if (bArr.length < 16) {
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArr, 0, bArr2, 16 - bArr.length, bArr.length);
            bArr = bArr2;
        }
        while (true) {
            if (i9 >= 8) {
                break;
            }
            iArr[i9] = bytesToWord(bArr, i9 * 2);
            i9++;
        }
        for (i8 = 8; i8 < 52; i8++) {
            int i10 = i8 & 7;
            if (i10 < 6) {
                iArr[i8] = (((iArr[i8 - 7] & 127) << 9) | (iArr[i8 - 6] >> 7)) & 65535;
            } else if (i10 == 6) {
                iArr[i8] = (((iArr[i8 - 7] & 127) << 9) | (iArr[i8 - 14] >> 7)) & 65535;
            } else {
                iArr[i8] = (((iArr[i8 - 15] & 127) << 9) | (iArr[i8 - 14] >> 7)) & 65535;
            }
        }
        return iArr;
    }

    private int[] generateWorkingKey(boolean z, byte[] bArr) {
        return z ? expandKey(bArr) : invertKey(expandKey(bArr));
    }

    private void ideaFunc(int[] iArr, byte[] bArr, int i8, byte[] bArr2, int i9) {
        int iBytesToWord = bytesToWord(bArr, i8);
        int iBytesToWord2 = bytesToWord(bArr, i8 + 2);
        int iBytesToWord3 = bytesToWord(bArr, i8 + 4);
        int iBytesToWord4 = bytesToWord(bArr, i8 + 6);
        int i10 = 0;
        int i11 = iBytesToWord3;
        int i12 = iBytesToWord2;
        int i13 = iBytesToWord;
        int i14 = 0;
        while (i10 < 8) {
            int iMul = mul(i13, iArr[i14]);
            int i15 = (i12 + iArr[i14 + 1]) & 65535;
            int i16 = (i11 + iArr[i14 + 2]) & 65535;
            int iMul2 = mul(iBytesToWord4, iArr[i14 + 3]);
            int i17 = i14 + 5;
            int iMul3 = mul(i16 ^ iMul, iArr[i14 + 4]);
            i14 += 6;
            int iMul4 = mul(((i15 ^ iMul2) + iMul3) & 65535, iArr[i17]);
            int i18 = 65535 & (iMul3 + iMul4);
            i13 = iMul ^ iMul4;
            iBytesToWord4 = iMul2 ^ i18;
            int i19 = i16 ^ iMul4;
            i10++;
            i11 = i15 ^ i18;
            i12 = i19;
        }
        wordToBytes(mul(i13, iArr[i14]), bArr2, i9);
        wordToBytes(i11 + iArr[i14 + 1], bArr2, i9 + 2);
        wordToBytes(i12 + iArr[i14 + 2], bArr2, i9 + 4);
        wordToBytes(mul(iBytesToWord4, iArr[i14 + 3]), bArr2, i9 + 6);
    }

    private int[] invertKey(int[] iArr) {
        int[] iArr2 = new int[52];
        int iMulInv = mulInv(iArr[0]);
        int iAddInv = addInv(iArr[1]);
        int iAddInv2 = addInv(iArr[2]);
        iArr2[51] = mulInv(iArr[3]);
        iArr2[50] = iAddInv2;
        iArr2[49] = iAddInv;
        int i8 = 48;
        iArr2[48] = iMulInv;
        int i9 = 4;
        for (int i10 = 1; i10 < 8; i10++) {
            int i11 = iArr[i9];
            iArr2[i8 - 1] = iArr[i9 + 1];
            iArr2[i8 - 2] = i11;
            int iMulInv2 = mulInv(iArr[i9 + 2]);
            int iAddInv3 = addInv(iArr[i9 + 3]);
            int i12 = i9 + 5;
            int iAddInv4 = addInv(iArr[i9 + 4]);
            i9 += 6;
            iArr2[i8 - 3] = mulInv(iArr[i12]);
            iArr2[i8 - 4] = iAddInv3;
            iArr2[i8 - 5] = iAddInv4;
            i8 -= 6;
            iArr2[i8] = iMulInv2;
        }
        int i13 = iArr[i9];
        iArr2[i8 - 1] = iArr[i9 + 1];
        iArr2[i8 - 2] = i13;
        int iMulInv3 = mulInv(iArr[i9 + 2]);
        int iAddInv5 = addInv(iArr[i9 + 3]);
        int iAddInv6 = addInv(iArr[i9 + 4]);
        iArr2[i8 - 3] = mulInv(iArr[i9 + 5]);
        iArr2[i8 - 4] = iAddInv6;
        iArr2[i8 - 5] = iAddInv5;
        iArr2[i8 - 6] = iMulInv3;
        return iArr2;
    }

    private int mul(int i8, int i9) {
        int i10;
        if (i8 == 0) {
            i10 = BASE - i9;
        } else if (i9 == 0) {
            i10 = BASE - i8;
        } else {
            int i11 = i8 * i9;
            int i12 = i11 & 65535;
            int i13 = i11 >>> 16;
            i10 = (i12 - i13) + (i12 < i13 ? 1 : 0);
        }
        return 65535 & i10;
    }

    private int mulInv(int i8) {
        if (i8 < 2) {
            return i8;
        }
        int i9 = BASE / i8;
        int i10 = BASE % i8;
        int i11 = 1;
        while (i10 != 1) {
            int i12 = i8 / i10;
            i8 %= i10;
            i11 = ((i12 * i9) + i11) & 65535;
            if (i8 == 1) {
                return i11;
            }
            int i13 = i10 / i8;
            i10 %= i8;
            i9 = ((i13 * i11) + i9) & 65535;
        }
        return (1 - i9) & 65535;
    }

    private void wordToBytes(int i8, byte[] bArr, int i9) {
        bArr[i9] = (byte) (i8 >>> 8);
        bArr[i9 + 1] = (byte) i8;
    }

    public int addInv(int i8) {
        return (0 - i8) & 65535;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "IDEA";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException(f.h(cipherParameters, "invalid parameter passed to IDEA init - "));
        }
        byte[] key = ((KeyParameter) cipherParameters).getKey();
        this.workingKey = generateWorkingKey(z, key);
        this.forEncryption = z;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), key.length * 8, cipherParameters, Utils.getPurpose(z)));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int[] iArr = this.workingKey;
        if (iArr == null) {
            throw new IllegalStateException("IDEA engine not initialised");
        }
        if (i8 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i9 + 8 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        ideaFunc(iArr, bArr, i8, bArr2, i9);
        return 8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
