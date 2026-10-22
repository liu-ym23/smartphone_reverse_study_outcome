package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DefaultBufferedBlockCipher;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

/* loaded from: classes.dex */
public class PaddedBlockCipher extends DefaultBufferedBlockCipher {
    public PaddedBlockCipher(BlockCipher blockCipher) {
        ((DefaultBufferedBlockCipher) this).cipher = blockCipher;
        ((DefaultBufferedBlockCipher) this).buf = new byte[blockCipher.getBlockSize()];
        ((DefaultBufferedBlockCipher) this).bufOff = 0;
    }

    @Override // org.bouncycastle.crypto.DefaultBufferedBlockCipher, org.bouncycastle.crypto.BufferedBlockCipher
    public int doFinal(byte[] bArr, int i8) throws InvalidCipherTextException {
        int iProcessBlock;
        int iProcessBlock2;
        int blockSize = ((DefaultBufferedBlockCipher) this).cipher.getBlockSize();
        if (((DefaultBufferedBlockCipher) this).forEncryption) {
            if (((DefaultBufferedBlockCipher) this).bufOff != blockSize) {
                iProcessBlock2 = 0;
            } else {
                if ((blockSize * 2) + i8 > bArr.length) {
                    throw new OutputLengthException("output buffer too short");
                }
                iProcessBlock2 = ((DefaultBufferedBlockCipher) this).cipher.processBlock(((DefaultBufferedBlockCipher) this).buf, 0, bArr, i8);
                ((DefaultBufferedBlockCipher) this).bufOff = 0;
            }
            byte b9 = (byte) (blockSize - ((DefaultBufferedBlockCipher) this).bufOff);
            while (true) {
                int i9 = ((DefaultBufferedBlockCipher) this).bufOff;
                if (i9 >= blockSize) {
                    break;
                }
                ((DefaultBufferedBlockCipher) this).buf[i9] = b9;
                ((DefaultBufferedBlockCipher) this).bufOff = i9 + 1;
            }
            iProcessBlock = ((DefaultBufferedBlockCipher) this).cipher.processBlock(((DefaultBufferedBlockCipher) this).buf, 0, bArr, i8 + iProcessBlock2) + iProcessBlock2;
        } else {
            if (((DefaultBufferedBlockCipher) this).bufOff != blockSize) {
                throw new DataLengthException("last block incomplete in decryption");
            }
            BlockCipher blockCipher = ((DefaultBufferedBlockCipher) this).cipher;
            byte[] bArr2 = ((DefaultBufferedBlockCipher) this).buf;
            int iProcessBlock3 = blockCipher.processBlock(bArr2, 0, bArr2, 0);
            ((DefaultBufferedBlockCipher) this).bufOff = 0;
            byte[] bArr3 = ((DefaultBufferedBlockCipher) this).buf;
            int i10 = bArr3[blockSize - 1] & 255;
            if (i10 > blockSize) {
                throw new InvalidCipherTextException("pad block corrupted");
            }
            int i11 = iProcessBlock3 - i10;
            System.arraycopy(bArr3, 0, bArr, i8, i11);
            iProcessBlock = i11;
        }
        reset();
        return iProcessBlock;
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
        return length == 0 ? i9 - bArr.length : i9 - length;
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
        if (updateOutputSize > 0 && updateOutputSize + i10 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        byte[] bArr3 = ((DefaultBufferedBlockCipher) this).buf;
        int length = bArr3.length;
        int i11 = ((DefaultBufferedBlockCipher) this).bufOff;
        int i12 = length - i11;
        int iProcessBlock = 0;
        if (i9 > i12) {
            System.arraycopy(bArr, i8, bArr3, i11, i12);
            int iProcessBlock2 = ((DefaultBufferedBlockCipher) this).cipher.processBlock(((DefaultBufferedBlockCipher) this).buf, 0, bArr2, i10);
            ((DefaultBufferedBlockCipher) this).bufOff = 0;
            i9 -= i12;
            i8 += i12;
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
}
