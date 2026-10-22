package org.bouncycastle.crypto.paddings;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DefaultBufferedBlockCipher;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class PaddedBufferedBlockCipher extends DefaultBufferedBlockCipher {
    BlockCipherPadding padding;

    public PaddedBufferedBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, new PKCS7Padding());
    }

    @Override // org.bouncycastle.crypto.DefaultBufferedBlockCipher, org.bouncycastle.crypto.BufferedBlockCipher
    public int doFinal(byte[] bArr, int i8) {
        int iProcessBlock;
        int blockSize = ((DefaultBufferedBlockCipher) this).cipher.getBlockSize();
        if (((DefaultBufferedBlockCipher) this).forEncryption) {
            if (((DefaultBufferedBlockCipher) this).bufOff != blockSize) {
                iProcessBlock = 0;
            } else {
                if ((blockSize * 2) + i8 > bArr.length) {
                    reset();
                    throw new OutputLengthException("output buffer too short");
                }
                iProcessBlock = ((DefaultBufferedBlockCipher) this).cipher.processBlock(((DefaultBufferedBlockCipher) this).buf, 0, bArr, i8);
                ((DefaultBufferedBlockCipher) this).bufOff = 0;
            }
            this.padding.addPadding(((DefaultBufferedBlockCipher) this).buf, ((DefaultBufferedBlockCipher) this).bufOff);
            return ((DefaultBufferedBlockCipher) this).cipher.processBlock(((DefaultBufferedBlockCipher) this).buf, 0, bArr, i8 + iProcessBlock) + iProcessBlock;
        }
        if (((DefaultBufferedBlockCipher) this).bufOff != blockSize) {
            reset();
            throw new DataLengthException("last block incomplete in decryption");
        }
        BlockCipher blockCipher = ((DefaultBufferedBlockCipher) this).cipher;
        byte[] bArr2 = ((DefaultBufferedBlockCipher) this).buf;
        int iProcessBlock2 = blockCipher.processBlock(bArr2, 0, bArr2, 0);
        ((DefaultBufferedBlockCipher) this).bufOff = 0;
        try {
            int iPadCount = iProcessBlock2 - this.padding.padCount(((DefaultBufferedBlockCipher) this).buf);
            System.arraycopy(((DefaultBufferedBlockCipher) this).buf, 0, bArr, i8, iPadCount);
            return iPadCount;
        } finally {
            reset();
        }
    }

    @Override // org.bouncycastle.crypto.DefaultBufferedBlockCipher, org.bouncycastle.crypto.BufferedBlockCipher
    public int getOutputSize(int i8) {
        int i9 = i8 + ((DefaultBufferedBlockCipher) this).bufOff;
        byte[] bArr = ((DefaultBufferedBlockCipher) this).buf;
        int length = i9 % bArr.length;
        if (length != 0) {
            i9 -= length;
        } else if (!((DefaultBufferedBlockCipher) this).forEncryption) {
            return i9;
        }
        return i9 + bArr.length;
    }

    @Override // org.bouncycastle.crypto.DefaultBufferedBlockCipher, org.bouncycastle.crypto.BufferedBlockCipher
    public int getUpdateOutputSize(int i8) {
        int i9 = i8 + ((DefaultBufferedBlockCipher) this).bufOff;
        byte[] bArr = ((DefaultBufferedBlockCipher) this).buf;
        int length = i9 % bArr.length;
        return length == 0 ? Math.max(0, i9 - bArr.length) : i9 - length;
    }

    @Override // org.bouncycastle.crypto.DefaultBufferedBlockCipher, org.bouncycastle.crypto.BufferedBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        BlockCipher blockCipher;
        ((DefaultBufferedBlockCipher) this).forEncryption = z;
        reset();
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.padding.init(parametersWithRandom.getRandom());
            blockCipher = ((DefaultBufferedBlockCipher) this).cipher;
            cipherParameters = parametersWithRandom.getParameters();
        } else {
            this.padding.init(null);
            blockCipher = ((DefaultBufferedBlockCipher) this).cipher;
        }
        blockCipher.init(z, cipherParameters);
    }

    @Override // org.bouncycastle.crypto.DefaultBufferedBlockCipher, org.bouncycastle.crypto.BufferedBlockCipher
    public int processByte(byte b9, byte[] bArr, int i8) {
        int i9 = ((DefaultBufferedBlockCipher) this).bufOff;
        byte[] bArr2 = ((DefaultBufferedBlockCipher) this).buf;
        int i10 = 0;
        if (i9 == bArr2.length) {
            int iProcessBlock = ((DefaultBufferedBlockCipher) this).cipher.processBlock(bArr2, 0, bArr, i8);
            ((DefaultBufferedBlockCipher) this).bufOff = 0;
            i10 = iProcessBlock;
        }
        byte[] bArr3 = ((DefaultBufferedBlockCipher) this).buf;
        int i11 = ((DefaultBufferedBlockCipher) this).bufOff;
        ((DefaultBufferedBlockCipher) this).bufOff = i11 + 1;
        bArr3[i11] = b9;
        return i10;
    }

    @Override // org.bouncycastle.crypto.DefaultBufferedBlockCipher, org.bouncycastle.crypto.BufferedBlockCipher
    public int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        if (i9 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int blockSize = getBlockSize();
        int updateOutputSize = getUpdateOutputSize(i9);
        if (updateOutputSize > 0 && i10 + updateOutputSize > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        byte[] bArr3 = ((DefaultBufferedBlockCipher) this).buf;
        int length = bArr3.length;
        int i11 = ((DefaultBufferedBlockCipher) this).bufOff;
        int i12 = length - i11;
        int iProcessBlock = 0;
        if (i9 > i12) {
            System.arraycopy(bArr, i8, bArr3, i11, i12);
            i8 += i12;
            i9 -= i12;
            if (bArr == bArr2 && Arrays.segmentsOverlap(i8, i9, i10, updateOutputSize)) {
                bArr = new byte[i9];
                System.arraycopy(bArr2, i8, bArr, 0, i9);
                i8 = 0;
            }
            int iProcessBlock2 = ((DefaultBufferedBlockCipher) this).cipher.processBlock(((DefaultBufferedBlockCipher) this).buf, 0, bArr2, i10);
            ((DefaultBufferedBlockCipher) this).bufOff = 0;
            iProcessBlock = iProcessBlock2;
            while (i9 > ((DefaultBufferedBlockCipher) this).buf.length) {
                iProcessBlock += ((DefaultBufferedBlockCipher) this).cipher.processBlock(bArr, i8, bArr2, i10 + iProcessBlock);
                i9 -= blockSize;
                i8 += blockSize;
            }
        }
        System.arraycopy(bArr, i8, ((DefaultBufferedBlockCipher) this).buf, ((DefaultBufferedBlockCipher) this).bufOff, i9);
        ((DefaultBufferedBlockCipher) this).bufOff += i9;
        return iProcessBlock;
    }

    public PaddedBufferedBlockCipher(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        ((DefaultBufferedBlockCipher) this).cipher = blockCipher;
        this.padding = blockCipherPadding;
        ((DefaultBufferedBlockCipher) this).buf = new byte[blockCipher.getBlockSize()];
        ((DefaultBufferedBlockCipher) this).bufOff = 0;
    }
}
