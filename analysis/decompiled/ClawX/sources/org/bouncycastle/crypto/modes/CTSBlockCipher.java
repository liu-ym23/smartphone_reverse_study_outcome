package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DefaultBufferedBlockCipher;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class CTSBlockCipher extends DefaultBufferedBlockCipher {
    private int blockSize;

    public CTSBlockCipher(BlockCipher blockCipher) {
        if (blockCipher instanceof StreamBlockCipher) {
            throw new IllegalArgumentException("CTSBlockCipher can only accept ECB, or CBC ciphers");
        }
        ((DefaultBufferedBlockCipher) this).cipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        ((DefaultBufferedBlockCipher) this).buf = new byte[blockSize * 2];
        ((DefaultBufferedBlockCipher) this).bufOff = 0;
    }

    @Override // org.bouncycastle.crypto.DefaultBufferedBlockCipher, org.bouncycastle.crypto.BufferedBlockCipher
    public int doFinal(byte[] bArr, int i8) {
        if (((DefaultBufferedBlockCipher) this).bufOff + i8 > bArr.length) {
            throw new OutputLengthException("output buffer to small in doFinal");
        }
        int blockSize = ((DefaultBufferedBlockCipher) this).cipher.getBlockSize();
        int i9 = ((DefaultBufferedBlockCipher) this).bufOff;
        int i10 = i9 - blockSize;
        byte[] bArr2 = new byte[blockSize];
        if (((DefaultBufferedBlockCipher) this).forEncryption) {
            if (i9 < blockSize) {
                throw new DataLengthException("need at least one block of input for CTS");
            }
            ((DefaultBufferedBlockCipher) this).cipher.processBlock(((DefaultBufferedBlockCipher) this).buf, 0, bArr2, 0);
            int i11 = ((DefaultBufferedBlockCipher) this).bufOff;
            if (i11 > blockSize) {
                while (true) {
                    byte[] bArr3 = ((DefaultBufferedBlockCipher) this).buf;
                    if (i11 == bArr3.length) {
                        break;
                    }
                    bArr3[i11] = bArr2[i11 - blockSize];
                    i11++;
                }
                for (int i12 = blockSize; i12 != ((DefaultBufferedBlockCipher) this).bufOff; i12++) {
                    byte[] bArr4 = ((DefaultBufferedBlockCipher) this).buf;
                    bArr4[i12] = (byte) (bArr4[i12] ^ bArr2[i12 - blockSize]);
                }
                BlockCipher blockCipher = ((DefaultBufferedBlockCipher) this).cipher;
                if (blockCipher instanceof CBCModeCipher) {
                    ((CBCModeCipher) blockCipher).getUnderlyingCipher().processBlock(((DefaultBufferedBlockCipher) this).buf, blockSize, bArr, i8);
                } else {
                    blockCipher.processBlock(((DefaultBufferedBlockCipher) this).buf, blockSize, bArr, i8);
                }
                System.arraycopy(bArr2, 0, bArr, i8 + blockSize, i10);
            } else {
                System.arraycopy(bArr2, 0, bArr, i8, blockSize);
            }
        } else {
            if (i9 < blockSize) {
                throw new DataLengthException("need at least one block of input for CTS");
            }
            byte[] bArr5 = new byte[blockSize];
            if (i9 > blockSize) {
                BlockCipher blockCipher2 = ((DefaultBufferedBlockCipher) this).cipher;
                if (blockCipher2 instanceof CBCModeCipher) {
                    ((CBCModeCipher) blockCipher2).getUnderlyingCipher().processBlock(((DefaultBufferedBlockCipher) this).buf, 0, bArr2, 0);
                } else {
                    blockCipher2.processBlock(((DefaultBufferedBlockCipher) this).buf, 0, bArr2, 0);
                }
                for (int i13 = blockSize; i13 != ((DefaultBufferedBlockCipher) this).bufOff; i13++) {
                    int i14 = i13 - blockSize;
                    bArr5[i14] = (byte) (bArr2[i14] ^ ((DefaultBufferedBlockCipher) this).buf[i13]);
                }
                System.arraycopy(((DefaultBufferedBlockCipher) this).buf, blockSize, bArr2, 0, i10);
                ((DefaultBufferedBlockCipher) this).cipher.processBlock(bArr2, 0, bArr, i8);
                System.arraycopy(bArr5, 0, bArr, i8 + blockSize, i10);
            } else {
                ((DefaultBufferedBlockCipher) this).cipher.processBlock(((DefaultBufferedBlockCipher) this).buf, 0, bArr2, 0);
                System.arraycopy(bArr2, 0, bArr, i8, blockSize);
            }
        }
        int i15 = ((DefaultBufferedBlockCipher) this).bufOff;
        reset();
        return i15;
    }

    @Override // org.bouncycastle.crypto.DefaultBufferedBlockCipher, org.bouncycastle.crypto.BufferedBlockCipher
    public int getOutputSize(int i8) {
        return i8 + ((DefaultBufferedBlockCipher) this).bufOff;
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
            byte[] bArr3 = ((DefaultBufferedBlockCipher) this).buf;
            int i11 = this.blockSize;
            System.arraycopy(bArr3, i11, bArr3, 0, i11);
            ((DefaultBufferedBlockCipher) this).bufOff = this.blockSize;
            i10 = iProcessBlock;
        }
        byte[] bArr4 = ((DefaultBufferedBlockCipher) this).buf;
        int i12 = ((DefaultBufferedBlockCipher) this).bufOff;
        ((DefaultBufferedBlockCipher) this).bufOff = i12 + 1;
        bArr4[i12] = b9;
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
        int i13 = 0;
        if (i9 > i12) {
            System.arraycopy(bArr, i8, bArr3, i11, i12);
            i8 += i12;
            i9 -= i12;
            if (bArr == bArr2 && Arrays.segmentsOverlap(i8, i9, i10, updateOutputSize)) {
                bArr = new byte[i9];
                System.arraycopy(bArr2, i8, bArr, 0, i9);
                i8 = 0;
            }
            int iProcessBlock = ((DefaultBufferedBlockCipher) this).cipher.processBlock(((DefaultBufferedBlockCipher) this).buf, 0, bArr2, i10);
            byte[] bArr4 = ((DefaultBufferedBlockCipher) this).buf;
            System.arraycopy(bArr4, blockSize, bArr4, 0, blockSize);
            ((DefaultBufferedBlockCipher) this).bufOff = blockSize;
            while (i9 > blockSize) {
                System.arraycopy(bArr, i8, ((DefaultBufferedBlockCipher) this).buf, ((DefaultBufferedBlockCipher) this).bufOff, blockSize);
                iProcessBlock += ((DefaultBufferedBlockCipher) this).cipher.processBlock(((DefaultBufferedBlockCipher) this).buf, 0, bArr2, i10 + iProcessBlock);
                byte[] bArr5 = ((DefaultBufferedBlockCipher) this).buf;
                System.arraycopy(bArr5, blockSize, bArr5, 0, blockSize);
                i9 -= blockSize;
                i8 += blockSize;
            }
            i13 = iProcessBlock;
        }
        System.arraycopy(bArr, i8, ((DefaultBufferedBlockCipher) this).buf, ((DefaultBufferedBlockCipher) this).bufOff, i9);
        ((DefaultBufferedBlockCipher) this).bufOff += i9;
        return i13;
    }
}
