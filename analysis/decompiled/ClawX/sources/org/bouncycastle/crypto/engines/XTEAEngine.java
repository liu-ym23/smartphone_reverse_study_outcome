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
public class XTEAEngine implements BlockCipher {
    private static final int block_size = 8;
    private static final int delta = -1640531527;
    private static final int rounds = 32;
    private boolean _forEncryption;
    private int[] _S = new int[4];
    private int[] _sum0 = new int[32];
    private int[] _sum1 = new int[32];
    private boolean _initialised = false;

    private int bytesToInt(byte[] bArr, int i8) {
        int i9 = i8 + 2;
        return ((bArr[i8 + 1] & 255) << 16) | (bArr[i8] << 24) | ((bArr[i9] & 255) << 8) | (bArr[i8 + 3] & 255);
    }

    private int decryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int iBytesToInt = bytesToInt(bArr, i8);
        int iBytesToInt2 = bytesToInt(bArr, i8 + 4);
        for (int i10 = 31; i10 >= 0; i10--) {
            iBytesToInt2 -= (((iBytesToInt << 4) ^ (iBytesToInt >>> 5)) + iBytesToInt) ^ this._sum1[i10];
            iBytesToInt -= (((iBytesToInt2 << 4) ^ (iBytesToInt2 >>> 5)) + iBytesToInt2) ^ this._sum0[i10];
        }
        unpackInt(iBytesToInt, bArr2, i9);
        unpackInt(iBytesToInt2, bArr2, i9 + 4);
        return 8;
    }

    private int encryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int iBytesToInt = bytesToInt(bArr, i8);
        int iBytesToInt2 = bytesToInt(bArr, i8 + 4);
        for (int i10 = 0; i10 < 32; i10++) {
            iBytesToInt += (((iBytesToInt2 << 4) ^ (iBytesToInt2 >>> 5)) + iBytesToInt2) ^ this._sum0[i10];
            iBytesToInt2 += (((iBytesToInt << 4) ^ (iBytesToInt >>> 5)) + iBytesToInt) ^ this._sum1[i10];
        }
        unpackInt(iBytesToInt, bArr2, i9);
        unpackInt(iBytesToInt2, bArr2, i9 + 4);
        return 8;
    }

    private void setKey(byte[] bArr) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException("Key size must be 128 bits.");
        }
        int i8 = 0;
        int i9 = 0;
        while (i8 < 4) {
            this._S[i8] = bytesToInt(bArr, i9);
            i8++;
            i9 += 4;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < 32; i11++) {
            int[] iArr = this._sum0;
            int[] iArr2 = this._S;
            iArr[i11] = iArr2[i10 & 3] + i10;
            i10 -= 1640531527;
            this._sum1[i11] = iArr2[(i10 >>> 11) & 3] + i10;
        }
    }

    private void unpackInt(int i8, byte[] bArr, int i9) {
        bArr[i9] = (byte) (i8 >>> 24);
        bArr[i9 + 1] = (byte) (i8 >>> 16);
        bArr[i9 + 2] = (byte) (i8 >>> 8);
        bArr[i9 + 3] = (byte) i8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "XTEA";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException(f.h(cipherParameters, "invalid parameter passed to TEA init - "));
        }
        this._forEncryption = z;
        this._initialised = true;
        setKey(((KeyParameter) cipherParameters).getKey());
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 128, cipherParameters, Utils.getPurpose(z)));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        if (!this._initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        }
        if (i8 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i9 + 8 <= bArr2.length) {
            return this._forEncryption ? encryptBlock(bArr, i8, bArr2, i9) : decryptBlock(bArr, i8, bArr2, i9);
        }
        throw new OutputLengthException("output buffer too short");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
