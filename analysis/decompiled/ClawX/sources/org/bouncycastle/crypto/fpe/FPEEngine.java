package org.bouncycastle.crypto.fpe;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.FPEParameters;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public abstract class FPEEngine {
    protected final BlockCipher baseCipher;
    protected boolean forEncryption;
    protected FPEParameters fpeParameters;

    public FPEEngine(BlockCipher blockCipher) {
        this.baseCipher = blockCipher;
    }

    public static byte[] toByteArray(short[] sArr) {
        byte[] bArr = new byte[sArr.length * 2];
        for (int i8 = 0; i8 != sArr.length; i8++) {
            Pack.shortToBigEndian(sArr[i8], bArr, i8 * 2);
        }
        return bArr;
    }

    public static short[] toShortArray(byte[] bArr) {
        if ((bArr.length & 1) != 0) {
            throw new IllegalArgumentException("data must be an even number of bytes for a wide radix");
        }
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i8 = 0; i8 != length; i8++) {
            sArr[i8] = Pack.bigEndianToShort(bArr, i8 * 2);
        }
        return sArr;
    }

    public abstract int decryptBlock(byte[] bArr, int i8, int i9, byte[] bArr2, int i10);

    public abstract int encryptBlock(byte[] bArr, int i8, int i9, byte[] bArr2, int i10);

    public abstract String getAlgorithmName();

    public abstract void init(boolean z, CipherParameters cipherParameters);

    public int processBlock(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        if (this.fpeParameters == null) {
            throw new IllegalStateException("FPE engine not initialized");
        }
        if (i9 < 0) {
            throw new IllegalArgumentException("input length cannot be negative");
        }
        if (bArr == null || bArr2 == null) {
            throw new NullPointerException("buffer value is null");
        }
        if (bArr.length < i8 + i9) {
            throw new DataLengthException("input buffer too short");
        }
        if (bArr2.length >= i10 + i9) {
            return this.forEncryption ? encryptBlock(bArr, i8, i9, bArr2, i10) : decryptBlock(bArr, i8, i9, bArr2, i10);
        }
        throw new OutputLengthException("output buffer too short");
    }
}
