package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.DefaultBufferedBlockCipher;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class NISTCTSBlockCipher extends DefaultBufferedBlockCipher {
    public static final int CS1 = 1;
    public static final int CS2 = 2;
    public static final int CS3 = 3;
    private final int blockSize;
    private final int type;

    public NISTCTSBlockCipher(int i8, BlockCipher blockCipher) {
        this.type = i8;
        ((DefaultBufferedBlockCipher) this).cipher = CBCBlockCipher.newInstance(blockCipher);
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
                throw new DataLengthException("need at least one block of input for NISTCTS");
            }
            if (i9 > blockSize) {
                byte[] bArr3 = new byte[blockSize];
                int i11 = this.type;
                if (i11 == 2 || i11 == 3) {
                    ((DefaultBufferedBlockCipher) this).cipher.processBlock(((DefaultBufferedBlockCipher) this).buf, 0, bArr2, 0);
                    System.arraycopy(((DefaultBufferedBlockCipher) this).buf, blockSize, bArr3, 0, i10);
                    ((DefaultBufferedBlockCipher) this).cipher.processBlock(bArr3, 0, bArr3, 0);
                    if (this.type == 2 && i10 == blockSize) {
                        System.arraycopy(bArr2, 0, bArr, i8, blockSize);
                        System.arraycopy(bArr3, 0, bArr, i8 + blockSize, i10);
                    } else {
                        System.arraycopy(bArr3, 0, bArr, i8, blockSize);
                        System.arraycopy(bArr2, 0, bArr, i8 + blockSize, i10);
                    }
                } else {
                    System.arraycopy(((DefaultBufferedBlockCipher) this).buf, 0, bArr2, 0, blockSize);
                    ((DefaultBufferedBlockCipher) this).cipher.processBlock(bArr2, 0, bArr2, 0);
                    System.arraycopy(bArr2, 0, bArr, i8, i10);
                    System.arraycopy(((DefaultBufferedBlockCipher) this).buf, ((DefaultBufferedBlockCipher) this).bufOff - i10, bArr3, 0, i10);
                    ((DefaultBufferedBlockCipher) this).cipher.processBlock(bArr3, 0, bArr3, 0);
                    System.arraycopy(bArr3, 0, bArr, i8 + i10, blockSize);
                }
            } else {
                ((DefaultBufferedBlockCipher) this).cipher.processBlock(((DefaultBufferedBlockCipher) this).buf, 0, bArr2, 0);
                System.arraycopy(bArr2, 0, bArr, i8, blockSize);
            }
        } else {
            if (i9 < blockSize) {
                throw new DataLengthException("need at least one block of input for CTS");
            }
            byte[] bArr4 = new byte[blockSize];
            if (i9 > blockSize) {
                int i12 = this.type;
                if (i12 == 3 || (i12 == 2 && (((DefaultBufferedBlockCipher) this).buf.length - i9) % blockSize != 0)) {
                    BlockCipher blockCipher = ((DefaultBufferedBlockCipher) this).cipher;
                    if (blockCipher instanceof CBCModeCipher) {
                        ((CBCModeCipher) blockCipher).getUnderlyingCipher().processBlock(((DefaultBufferedBlockCipher) this).buf, 0, bArr2, 0);
                    } else {
                        blockCipher.processBlock(((DefaultBufferedBlockCipher) this).buf, 0, bArr2, 0);
                    }
                    for (int i13 = blockSize; i13 != ((DefaultBufferedBlockCipher) this).bufOff; i13++) {
                        int i14 = i13 - blockSize;
                        bArr4[i14] = (byte) (bArr2[i14] ^ ((DefaultBufferedBlockCipher) this).buf[i13]);
                    }
                    System.arraycopy(((DefaultBufferedBlockCipher) this).buf, blockSize, bArr2, 0, i10);
                    ((DefaultBufferedBlockCipher) this).cipher.processBlock(bArr2, 0, bArr, i8);
                } else {
                    ((CBCModeCipher) ((DefaultBufferedBlockCipher) this).cipher).getUnderlyingCipher().processBlock(((DefaultBufferedBlockCipher) this).buf, ((DefaultBufferedBlockCipher) this).bufOff - blockSize, bArr4, 0);
                    System.arraycopy(((DefaultBufferedBlockCipher) this).buf, 0, bArr2, 0, blockSize);
                    if (i10 != blockSize) {
                        System.arraycopy(bArr4, i10, bArr2, i10, blockSize - i10);
                    }
                    ((DefaultBufferedBlockCipher) this).cipher.processBlock(bArr2, 0, bArr2, 0);
                    System.arraycopy(bArr2, 0, bArr, i8, blockSize);
                    for (int i15 = 0; i15 != i10; i15++) {
                        bArr4[i15] = (byte) (bArr4[i15] ^ ((DefaultBufferedBlockCipher) this).buf[i15]);
                    }
                }
                System.arraycopy(bArr4, 0, bArr, i8 + blockSize, i10);
            } else {
                ((DefaultBufferedBlockCipher) this).cipher.processBlock(((DefaultBufferedBlockCipher) this).buf, 0, bArr2, 0);
                System.arraycopy(bArr2, 0, bArr, i8, blockSize);
            }
        }
        int i16 = ((DefaultBufferedBlockCipher) this).bufOff;
        reset();
        return i16;
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
