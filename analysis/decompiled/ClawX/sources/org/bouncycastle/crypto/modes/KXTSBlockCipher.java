package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DefaultBufferedBlockCipher;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class KXTSBlockCipher extends DefaultBufferedBlockCipher {
    private static final long RED_POLY_128 = 135;
    private static final long RED_POLY_256 = 1061;
    private static final long RED_POLY_512 = 293;
    private final int blockSize;
    private int counter;
    private final long reductionPolynomial;
    private final long[] tw_current;
    private final long[] tw_init;

    public KXTSBlockCipher(BlockCipher blockCipher) {
        ((DefaultBufferedBlockCipher) this).cipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.reductionPolynomial = getReductionPolynomial(blockSize);
        this.tw_init = new long[blockSize >>> 3];
        this.tw_current = new long[blockSize >>> 3];
        this.counter = -1;
    }

    private static void GF_double(long j4, long[] jArr) {
        long j8 = 0;
        int i8 = 0;
        while (i8 < jArr.length) {
            long j9 = jArr[i8];
            jArr[i8] = j8 ^ (j9 << 1);
            i8++;
            j8 = j9 >>> 63;
        }
        jArr[0] = (j4 & (-j8)) ^ jArr[0];
    }

    public static long getReductionPolynomial(int i8) {
        if (i8 == 16) {
            return RED_POLY_128;
        }
        if (i8 == 32) {
            return RED_POLY_256;
        }
        if (i8 == 64) {
            return RED_POLY_512;
        }
        throw new IllegalArgumentException("Only 128, 256, and 512 -bit block sizes supported");
    }

    private void processBlock(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int i10 = this.counter;
        if (i10 == -1) {
            throw new IllegalStateException("Attempt to process too many blocks");
        }
        this.counter = i10 + 1;
        GF_double(this.reductionPolynomial, this.tw_current);
        byte[] bArr3 = new byte[this.blockSize];
        Pack.longToLittleEndian(this.tw_current, bArr3, 0);
        int i11 = this.blockSize;
        byte[] bArr4 = new byte[i11];
        System.arraycopy(bArr3, 0, bArr4, 0, i11);
        for (int i12 = 0; i12 < this.blockSize; i12++) {
            bArr4[i12] = (byte) (bArr4[i12] ^ bArr[i8 + i12]);
        }
        ((DefaultBufferedBlockCipher) this).cipher.processBlock(bArr4, 0, bArr4, 0);
        for (int i13 = 0; i13 < this.blockSize; i13++) {
            bArr2[i9 + i13] = (byte) (bArr4[i13] ^ bArr3[i13]);
        }
    }

    @Override // org.bouncycastle.crypto.DefaultBufferedBlockCipher, org.bouncycastle.crypto.BufferedBlockCipher
    public int doFinal(byte[] bArr, int i8) {
        reset();
        return 0;
    }

    @Override // org.bouncycastle.crypto.DefaultBufferedBlockCipher, org.bouncycastle.crypto.BufferedBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("Invalid parameters passed");
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        CipherParameters parameters = parametersWithIV.getParameters();
        byte[] iv = parametersWithIV.getIV();
        int length = iv.length;
        int i8 = this.blockSize;
        if (length != i8) {
            throw new IllegalArgumentException("Currently only support IVs of exactly one block");
        }
        byte[] bArr = new byte[i8];
        System.arraycopy(iv, 0, bArr, 0, i8);
        ((DefaultBufferedBlockCipher) this).cipher.init(true, parameters);
        ((DefaultBufferedBlockCipher) this).cipher.processBlock(bArr, 0, bArr, 0);
        ((DefaultBufferedBlockCipher) this).cipher.init(z, parameters);
        Pack.littleEndianToLong(bArr, 0, this.tw_init);
        long[] jArr = this.tw_init;
        System.arraycopy(jArr, 0, this.tw_current, 0, jArr.length);
        this.counter = 0;
    }

    @Override // org.bouncycastle.crypto.DefaultBufferedBlockCipher, org.bouncycastle.crypto.BufferedBlockCipher
    public int processByte(byte b9, byte[] bArr, int i8) {
        throw new IllegalStateException("unsupported operation");
    }

    @Override // org.bouncycastle.crypto.DefaultBufferedBlockCipher, org.bouncycastle.crypto.BufferedBlockCipher
    public int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        if (bArr.length - i8 < i9) {
            throw new DataLengthException("Input buffer too short");
        }
        if (bArr2.length - i8 < i9) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (i9 % this.blockSize != 0) {
            throw new IllegalArgumentException("Partial blocks not supported");
        }
        int i11 = 0;
        if (bArr == bArr2 && Arrays.segmentsOverlap(i8, i9, i10, i9)) {
            bArr = new byte[i9];
            System.arraycopy(bArr2, i8, bArr, 0, i9);
            i8 = 0;
        }
        while (i11 < i9) {
            processBlock(bArr, i8 + i11, bArr2, i10 + i11);
            i11 += this.blockSize;
        }
        return i9;
    }

    @Override // org.bouncycastle.crypto.DefaultBufferedBlockCipher, org.bouncycastle.crypto.BufferedBlockCipher
    public void reset() {
        ((DefaultBufferedBlockCipher) this).cipher.reset();
        long[] jArr = this.tw_init;
        System.arraycopy(jArr, 0, this.tw_current, 0, jArr.length);
        this.counter = 0;
    }

    @Override // org.bouncycastle.crypto.DefaultBufferedBlockCipher, org.bouncycastle.crypto.BufferedBlockCipher
    public int getOutputSize(int i8) {
        return i8;
    }

    @Override // org.bouncycastle.crypto.DefaultBufferedBlockCipher, org.bouncycastle.crypto.BufferedBlockCipher
    public int getUpdateOutputSize(int i8) {
        return i8;
    }
}
