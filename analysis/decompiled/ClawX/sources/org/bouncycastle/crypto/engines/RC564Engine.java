package org.bouncycastle.crypto.engines;

import m0.f;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.RC5Parameters;

/* loaded from: classes.dex */
public class RC564Engine implements BlockCipher {
    private static final long P64 = -5196783011329398165L;
    private static final long Q64 = -7046029254386353131L;
    private static final int bytesPerWord = 8;
    private static final int wordSize = 64;
    private boolean forEncryption;
    private int _noRounds = 12;
    private long[] _S = null;

    private long bytesToWord(byte[] bArr, int i8) {
        long j4 = 0;
        for (int i9 = 7; i9 >= 0; i9--) {
            j4 = (j4 << 8) + (bArr[i9 + i8] & 255);
        }
        return j4;
    }

    private int decryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        long jBytesToWord = bytesToWord(bArr, i8);
        long jBytesToWord2 = bytesToWord(bArr, i8 + 8);
        for (int i10 = this._noRounds; i10 >= 1; i10--) {
            int i11 = i10 * 2;
            jBytesToWord2 = rotateRight(jBytesToWord2 - this._S[i11 + 1], jBytesToWord) ^ jBytesToWord;
            jBytesToWord = rotateRight(jBytesToWord - this._S[i11], jBytesToWord2) ^ jBytesToWord2;
        }
        wordToBytes(jBytesToWord - this._S[0], bArr2, i9);
        wordToBytes(jBytesToWord2 - this._S[1], bArr2, i9 + 8);
        return 16;
    }

    private int encryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        long jBytesToWord = bytesToWord(bArr, i8) + this._S[0];
        long jBytesToWord2 = bytesToWord(bArr, i8 + 8) + this._S[1];
        for (int i10 = 1; i10 <= this._noRounds; i10++) {
            int i11 = i10 * 2;
            jBytesToWord = rotateLeft(jBytesToWord ^ jBytesToWord2, jBytesToWord2) + this._S[i11];
            jBytesToWord2 = rotateLeft(jBytesToWord2 ^ jBytesToWord, jBytesToWord) + this._S[i11 + 1];
        }
        wordToBytes(jBytesToWord, bArr2, i9);
        wordToBytes(jBytesToWord2, bArr2, i9 + 8);
        return 16;
    }

    private long rotateLeft(long j4, long j8) {
        long j9 = j8 & 63;
        return (j4 >>> ((int) (64 - j9))) | (j4 << ((int) j9));
    }

    private long rotateRight(long j4, long j8) {
        long j9 = j8 & 63;
        return (j4 << ((int) (64 - j9))) | (j4 >>> ((int) j9));
    }

    private void setKey(byte[] bArr) {
        long[] jArr;
        int length = (bArr.length + 7) / 8;
        long[] jArr2 = new long[length];
        for (int i8 = 0; i8 != bArr.length; i8++) {
            int i9 = i8 / 8;
            jArr2[i9] = jArr2[i9] + ((bArr[i8] & 255) << ((i8 % 8) * 8));
        }
        long[] jArr3 = new long[(this._noRounds + 1) * 2];
        this._S = jArr3;
        jArr3[0] = -5196783011329398165L;
        int i10 = 1;
        while (true) {
            jArr = this._S;
            if (i10 >= jArr.length) {
                break;
            }
            jArr[i10] = jArr[i10 - 1] + Q64;
            i10++;
        }
        int length2 = length > jArr.length ? length * 3 : jArr.length * 3;
        long jRotateLeft = 0;
        long jRotateLeft2 = 0;
        int length3 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length2; i12++) {
            long[] jArr4 = this._S;
            jRotateLeft = rotateLeft(jArr4[length3] + jRotateLeft + jRotateLeft2, 3L);
            jArr4[length3] = jRotateLeft;
            jRotateLeft2 = rotateLeft(jArr2[i11] + jRotateLeft + jRotateLeft2, jRotateLeft2 + jRotateLeft);
            jArr2[i11] = jRotateLeft2;
            length3 = (length3 + 1) % this._S.length;
            i11 = (i11 + 1) % length;
        }
    }

    private void wordToBytes(long j4, byte[] bArr, int i8) {
        for (int i9 = 0; i9 < 8; i9++) {
            bArr[i9 + i8] = (byte) j4;
            j4 >>>= 8;
        }
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "RC5-64";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof RC5Parameters)) {
            throw new IllegalArgumentException(f.h(cipherParameters, "invalid parameter passed to RC564 init - "));
        }
        RC5Parameters rC5Parameters = (RC5Parameters) cipherParameters;
        this.forEncryption = z;
        this._noRounds = rC5Parameters.getRounds();
        byte[] key = rC5Parameters.getKey();
        setKey(key);
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
