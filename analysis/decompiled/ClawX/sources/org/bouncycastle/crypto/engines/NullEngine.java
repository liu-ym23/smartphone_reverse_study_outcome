package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* loaded from: classes.dex */
public class NullEngine implements BlockCipher {
    protected static final int DEFAULT_BLOCK_SIZE = 1;
    private final int blockSize;
    private boolean initialised;

    public NullEngine() {
        this(1);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Null";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        this.initialised = true;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        if (!this.initialised) {
            throw new IllegalStateException("Null engine not initialised");
        }
        int i10 = this.blockSize;
        if (i8 + i10 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i10 + i9 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i11 = 0;
        while (true) {
            int i12 = this.blockSize;
            if (i11 >= i12) {
                return i12;
            }
            bArr2[i9 + i11] = bArr[i8 + i11];
            i11++;
        }
    }

    public NullEngine(int i8) {
        this.blockSize = i8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
