package org.bouncycastle.crypto.engines;

import m0.f;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.RC5Parameters;

/* loaded from: classes.dex */
public class RC532Engine implements BlockCipher {
    private static final int P32 = -1209970333;
    private static final int Q32 = -1640531527;
    private boolean forEncryption;
    private int _noRounds = 12;
    private int[] _S = null;

    private int bytesToWord(byte[] bArr, int i8) {
        return (bArr[i8] & 255) | ((bArr[i8 + 1] & 255) << 8) | ((bArr[i8 + 2] & 255) << 16) | ((bArr[i8 + 3] & 255) << 24);
    }

    private int decryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int iBytesToWord = bytesToWord(bArr, i8);
        int iBytesToWord2 = bytesToWord(bArr, i8 + 4);
        for (int i10 = this._noRounds; i10 >= 1; i10--) {
            int i11 = i10 * 2;
            iBytesToWord2 = rotateRight(iBytesToWord2 - this._S[i11 + 1], iBytesToWord) ^ iBytesToWord;
            iBytesToWord = rotateRight(iBytesToWord - this._S[i11], iBytesToWord2) ^ iBytesToWord2;
        }
        wordToBytes(iBytesToWord - this._S[0], bArr2, i9);
        wordToBytes(iBytesToWord2 - this._S[1], bArr2, i9 + 4);
        return 8;
    }

    private int encryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int iBytesToWord = bytesToWord(bArr, i8) + this._S[0];
        int iBytesToWord2 = bytesToWord(bArr, i8 + 4) + this._S[1];
        for (int i10 = 1; i10 <= this._noRounds; i10++) {
            int i11 = i10 * 2;
            iBytesToWord = rotateLeft(iBytesToWord ^ iBytesToWord2, iBytesToWord2) + this._S[i11];
            iBytesToWord2 = rotateLeft(iBytesToWord2 ^ iBytesToWord, iBytesToWord) + this._S[i11 + 1];
        }
        wordToBytes(iBytesToWord, bArr2, i9);
        wordToBytes(iBytesToWord2, bArr2, i9 + 4);
        return 8;
    }

    private int rotateLeft(int i8, int i9) {
        int i10 = i9 & 31;
        return (i8 >>> (32 - i10)) | (i8 << i10);
    }

    private int rotateRight(int i8, int i9) {
        int i10 = i9 & 31;
        return (i8 << (32 - i10)) | (i8 >>> i10);
    }

    private void setKey(byte[] bArr) {
        int[] iArr;
        int length = (bArr.length + 3) / 4;
        int[] iArr2 = new int[length];
        for (int i8 = 0; i8 != bArr.length; i8++) {
            int i9 = i8 / 4;
            iArr2[i9] = iArr2[i9] + ((bArr[i8] & 255) << ((i8 % 4) * 8));
        }
        int[] iArr3 = new int[(this._noRounds + 1) * 2];
        this._S = iArr3;
        iArr3[0] = P32;
        int i10 = 1;
        while (true) {
            iArr = this._S;
            if (i10 >= iArr.length) {
                break;
            }
            iArr[i10] = iArr[i10 - 1] + Q32;
            i10++;
        }
        int length2 = length > iArr.length ? length * 3 : iArr.length * 3;
        int length3 = 0;
        int iRotateLeft = 0;
        int iRotateLeft2 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length2; i12++) {
            int[] iArr4 = this._S;
            iRotateLeft = rotateLeft(iArr4[length3] + iRotateLeft + iRotateLeft2, 3);
            iArr4[length3] = iRotateLeft;
            iRotateLeft2 = rotateLeft(iArr2[i11] + iRotateLeft + iRotateLeft2, iRotateLeft2 + iRotateLeft);
            iArr2[i11] = iRotateLeft2;
            length3 = (length3 + 1) % this._S.length;
            i11 = (i11 + 1) % length;
        }
    }

    private void wordToBytes(int i8, byte[] bArr, int i9) {
        bArr[i9] = (byte) i8;
        bArr[i9 + 1] = (byte) (i8 >> 8);
        bArr[i9 + 2] = (byte) (i8 >> 16);
        bArr[i9 + 3] = (byte) (i8 >> 24);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "RC5-32";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        byte[] key;
        if (cipherParameters instanceof RC5Parameters) {
            RC5Parameters rC5Parameters = (RC5Parameters) cipherParameters;
            this._noRounds = rC5Parameters.getRounds();
            key = rC5Parameters.getKey();
            setKey(key);
        } else {
            if (!(cipherParameters instanceof KeyParameter)) {
                throw new IllegalArgumentException(f.h(cipherParameters, "invalid parameter passed to RC532 init - "));
            }
            key = ((KeyParameter) cipherParameters).getKey();
            setKey(key);
        }
        this.forEncryption = z;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), key.length * 8, cipherParameters, Utils.getPurpose(z)));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        return this.forEncryption ? encryptBlock(bArr, i8, bArr2, i9) : decryptBlock(bArr, i8, bArr2, i9);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
