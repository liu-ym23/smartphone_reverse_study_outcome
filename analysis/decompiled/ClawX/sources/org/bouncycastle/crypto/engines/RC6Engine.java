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
public class RC6Engine implements BlockCipher {
    private static final int LGW = 5;
    private static final int P32 = -1209970333;
    private static final int Q32 = -1640531527;
    private static final int _noRounds = 20;
    private static final int bytesPerWord = 4;
    private static final int wordSize = 32;
    private int[] _S = null;
    private boolean forEncryption;

    private int bytesToWord(byte[] bArr, int i8) {
        int i9 = 0;
        for (int i10 = 3; i10 >= 0; i10--) {
            i9 = (i9 << 8) + (bArr[i10 + i8] & 255);
        }
        return i9;
    }

    private int decryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int iBytesToWord = bytesToWord(bArr, i8);
        int iBytesToWord2 = bytesToWord(bArr, i8 + 4);
        int iBytesToWord3 = bytesToWord(bArr, i8 + 8);
        int iBytesToWord4 = bytesToWord(bArr, i8 + 12);
        int[] iArr = this._S;
        int i10 = iBytesToWord3 - iArr[43];
        int iRotateRight = iBytesToWord - iArr[42];
        int i11 = 20;
        while (i11 >= 1) {
            int iRotateLeft = rotateLeft(((iRotateRight * 2) + 1) * iRotateRight, 5);
            int iRotateLeft2 = rotateLeft(((i10 * 2) + 1) * i10, 5);
            int i12 = i11 * 2;
            int iRotateRight2 = rotateRight(iBytesToWord2 - this._S[i12 + 1], iRotateLeft) ^ iRotateLeft2;
            i11--;
            int i13 = iRotateRight;
            iRotateRight = rotateRight(iBytesToWord4 - this._S[i12], iRotateLeft2) ^ iRotateLeft;
            iBytesToWord4 = i10;
            i10 = iRotateRight2;
            iBytesToWord2 = i13;
        }
        int[] iArr2 = this._S;
        int i14 = iBytesToWord4 - iArr2[1];
        int i15 = iBytesToWord2 - iArr2[0];
        wordToBytes(iRotateRight, bArr2, i9);
        wordToBytes(i15, bArr2, i9 + 4);
        wordToBytes(i10, bArr2, i9 + 8);
        wordToBytes(i14, bArr2, i9 + 12);
        return 16;
    }

    private int encryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int iBytesToWord = bytesToWord(bArr, i8);
        int iBytesToWord2 = bytesToWord(bArr, i8 + 4);
        int iBytesToWord3 = bytesToWord(bArr, i8 + 8);
        int iBytesToWord4 = bytesToWord(bArr, i8 + 12);
        int[] iArr = this._S;
        int i10 = iBytesToWord2 + iArr[0];
        int i11 = iBytesToWord4 + iArr[1];
        int i12 = 1;
        while (i12 <= 20) {
            int iRotateLeft = rotateLeft(((i10 * 2) + 1) * i10, 5);
            int iRotateLeft2 = rotateLeft(((i11 * 2) + 1) * i11, 5);
            int i13 = i12 * 2;
            int iRotateLeft3 = rotateLeft(iBytesToWord ^ iRotateLeft, iRotateLeft2) + this._S[i13];
            int iRotateLeft4 = rotateLeft(iBytesToWord3 ^ iRotateLeft2, iRotateLeft) + this._S[i13 + 1];
            i12++;
            iBytesToWord3 = i11;
            i11 = iRotateLeft3;
            iBytesToWord = i10;
            i10 = iRotateLeft4;
        }
        int[] iArr2 = this._S;
        int i14 = iBytesToWord + iArr2[42];
        int i15 = iBytesToWord3 + iArr2[43];
        wordToBytes(i14, bArr2, i9);
        wordToBytes(i10, bArr2, i9 + 4);
        wordToBytes(i15, bArr2, i9 + 8);
        wordToBytes(i11, bArr2, i9 + 12);
        return 16;
    }

    private int rotateLeft(int i8, int i9) {
        return (i8 << i9) | (i8 >>> (-i9));
    }

    private int rotateRight(int i8, int i9) {
        return (i8 >>> i9) | (i8 << (-i9));
    }

    private void setKey(byte[] bArr) {
        int[] iArr;
        int length = bArr.length;
        int length2 = (bArr.length + 3) / 4;
        int[] iArr2 = new int[length2];
        for (int length3 = bArr.length - 1; length3 >= 0; length3--) {
            int i8 = length3 / 4;
            iArr2[i8] = (iArr2[i8] << 8) + (bArr[length3] & 255);
        }
        int[] iArr3 = new int[44];
        this._S = iArr3;
        iArr3[0] = P32;
        int i9 = 1;
        while (true) {
            iArr = this._S;
            if (i9 >= iArr.length) {
                break;
            }
            iArr[i9] = iArr[i9 - 1] + Q32;
            i9++;
        }
        int length4 = length2 > iArr.length ? length2 * 3 : iArr.length * 3;
        int length5 = 0;
        int iRotateLeft = 0;
        int iRotateLeft2 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < length4; i11++) {
            int[] iArr4 = this._S;
            iRotateLeft = rotateLeft(iArr4[length5] + iRotateLeft + iRotateLeft2, 3);
            iArr4[length5] = iRotateLeft;
            iRotateLeft2 = rotateLeft(iArr2[i10] + iRotateLeft + iRotateLeft2, iRotateLeft2 + iRotateLeft);
            iArr2[i10] = iRotateLeft2;
            length5 = (length5 + 1) % this._S.length;
            i10 = (i10 + 1) % length2;
        }
    }

    private void wordToBytes(int i8, byte[] bArr, int i9) {
        for (int i10 = 0; i10 < 4; i10++) {
            bArr[i10 + i9] = (byte) i8;
            i8 >>>= 8;
        }
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "RC6";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException(f.h(cipherParameters, "invalid parameter passed to RC6 init - "));
        }
        this.forEncryption = z;
        byte[] key = ((KeyParameter) cipherParameters).getKey();
        setKey(key);
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), key.length * 8, cipherParameters, Utils.getPurpose(z)));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int blockSize = getBlockSize();
        if (this._S == null) {
            throw new IllegalStateException("RC6 engine not initialised");
        }
        if (i8 + blockSize > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (blockSize + i9 <= bArr2.length) {
            return this.forEncryption ? encryptBlock(bArr, i8, bArr2, i9) : decryptBlock(bArr, i8, bArr2, i9);
        }
        throw new OutputLengthException("output buffer too short");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
