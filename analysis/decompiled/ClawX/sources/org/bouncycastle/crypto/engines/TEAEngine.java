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
public class TEAEngine implements BlockCipher {
    private static final int block_size = 8;
    private static final int d_sum = -957401312;
    private static final int delta = -1640531527;
    private static final int rounds = 32;
    private int _a;
    private int _b;
    private int _c;
    private int _d;
    private boolean _forEncryption;
    private boolean _initialised = false;

    private int bytesToInt(byte[] bArr, int i8) {
        int i9 = i8 + 2;
        return ((bArr[i8 + 1] & 255) << 16) | (bArr[i8] << 24) | ((bArr[i9] & 255) << 8) | (bArr[i8 + 3] & 255);
    }

    private int decryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int iBytesToInt = bytesToInt(bArr, i8);
        int iBytesToInt2 = bytesToInt(bArr, i8 + 4);
        int i10 = d_sum;
        for (int i11 = 0; i11 != 32; i11++) {
            iBytesToInt2 -= (((iBytesToInt << 4) + this._c) ^ (iBytesToInt + i10)) ^ ((iBytesToInt >>> 5) + this._d);
            iBytesToInt -= (((iBytesToInt2 << 4) + this._a) ^ (iBytesToInt2 + i10)) ^ ((iBytesToInt2 >>> 5) + this._b);
            i10 += 1640531527;
        }
        unpackInt(iBytesToInt, bArr2, i9);
        unpackInt(iBytesToInt2, bArr2, i9 + 4);
        return 8;
    }

    private int encryptBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int iBytesToInt = bytesToInt(bArr, i8);
        int iBytesToInt2 = bytesToInt(bArr, i8 + 4);
        int i10 = iBytesToInt;
        int i11 = 0;
        for (int i12 = 0; i12 != 32; i12++) {
            i11 -= 1640531527;
            i10 += (((iBytesToInt2 << 4) + this._a) ^ (iBytesToInt2 + i11)) ^ ((iBytesToInt2 >>> 5) + this._b);
            iBytesToInt2 += (((i10 << 4) + this._c) ^ (i10 + i11)) ^ ((i10 >>> 5) + this._d);
        }
        unpackInt(i10, bArr2, i9);
        unpackInt(iBytesToInt2, bArr2, i9 + 4);
        return 8;
    }

    private void setKey(byte[] bArr) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException("Key size must be 128 bits.");
        }
        this._a = bytesToInt(bArr, 0);
        this._b = bytesToInt(bArr, 4);
        this._c = bytesToInt(bArr, 8);
        this._d = bytesToInt(bArr, 12);
    }

    private void unpackInt(int i8, byte[] bArr, int i9) {
        bArr[i9] = (byte) (i8 >>> 24);
        bArr[i9 + 1] = (byte) (i8 >>> 16);
        bArr[i9 + 2] = (byte) (i8 >>> 8);
        bArr[i9 + 3] = (byte) i8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "TEA";
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
