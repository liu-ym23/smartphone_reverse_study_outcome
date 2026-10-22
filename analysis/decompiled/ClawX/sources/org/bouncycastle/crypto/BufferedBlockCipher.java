package org.bouncycastle.crypto;

/* loaded from: classes.dex */
public class BufferedBlockCipher {
    protected byte[] buf;
    protected int bufOff;
    protected BlockCipher cipher;
    protected boolean forEncryption;
    protected MultiBlockCipher mbCipher;
    protected boolean partialBlockOkay;
    protected boolean pgpCFB;

    public BufferedBlockCipher() {
    }

    private int processBuffer(byte[] bArr, int i8) {
        this.bufOff = 0;
        MultiBlockCipher multiBlockCipher = this.mbCipher;
        if (multiBlockCipher == null) {
            return this.cipher.processBlock(this.buf, 0, bArr, i8);
        }
        byte[] bArr2 = this.buf;
        return multiBlockCipher.processBlocks(bArr2, 0, bArr2.length / multiBlockCipher.getBlockSize(), bArr, i8);
    }

    public int doFinal(byte[] bArr, int i8) {
        byte[] bArr2;
        int i9;
        int iProcessBlocks;
        int blockSize;
        try {
            int i10 = this.bufOff;
            if (i8 + i10 > bArr.length) {
                throw new OutputLengthException("output buffer too short for doFinal()");
            }
            int i11 = 0;
            if (i10 != 0) {
                MultiBlockCipher multiBlockCipher = this.mbCipher;
                if (multiBlockCipher != null) {
                    int blockSize2 = i10 / multiBlockCipher.getBlockSize();
                    bArr2 = bArr;
                    i9 = i8;
                    iProcessBlocks = this.mbCipher.processBlocks(this.buf, 0, blockSize2, bArr2, i9);
                    blockSize = blockSize2 * this.mbCipher.getBlockSize();
                } else {
                    bArr2 = bArr;
                    i9 = i8;
                    iProcessBlocks = 0;
                    blockSize = 0;
                }
                if (this.bufOff == blockSize) {
                    i11 = iProcessBlocks;
                } else {
                    if (!this.partialBlockOkay) {
                        throw new DataLengthException("data not block size aligned");
                    }
                    BlockCipher blockCipher = this.cipher;
                    byte[] bArr3 = this.buf;
                    blockCipher.processBlock(bArr3, blockSize, bArr3, blockSize);
                    System.arraycopy(this.buf, blockSize, bArr2, i9 + iProcessBlocks, this.bufOff - blockSize);
                    int i12 = (this.bufOff - blockSize) + iProcessBlocks;
                    this.bufOff = 0;
                    i11 = i12;
                }
            }
            reset();
            return i11;
        } catch (Throwable th) {
            reset();
            throw th;
        }
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public int getOutputSize(int i8) {
        if (!this.pgpCFB || !this.forEncryption) {
            return i8 + this.bufOff;
        }
        return this.cipher.getBlockSize() + 2 + i8 + this.bufOff;
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public int getUpdateOutputSize(int i8) {
        int length;
        int i9 = i8 + this.bufOff;
        if (this.pgpCFB && this.forEncryption) {
            length = (i9 % this.buf.length) - (this.cipher.getBlockSize() + 2);
            return i9 - length;
        }
        int length2 = this.buf.length;
        length = i9 % length2;
        return i9 - length;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        this.forEncryption = z;
        reset();
        this.cipher.init(z, cipherParameters);
    }

    public int processByte(byte b9, byte[] bArr, int i8) {
        byte[] bArr2 = this.buf;
        int i9 = this.bufOff;
        int i10 = i9 + 1;
        this.bufOff = i10;
        bArr2[i9] = b9;
        if (i10 == bArr2.length) {
            return processBuffer(bArr, i8);
        }
        return 0;
    }

    public int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        byte[] bArr3;
        int i11;
        int i12;
        int i13;
        if (i9 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int blockSize = getBlockSize();
        int updateOutputSize = getUpdateOutputSize(i9);
        if (updateOutputSize > 0 && updateOutputSize + i10 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        byte[] bArr4 = this.buf;
        int length = bArr4.length;
        int i14 = this.bufOff;
        int i15 = length - i14;
        if (i9 > i15) {
            if (i14 != 0) {
                System.arraycopy(bArr, i8, bArr4, i14, i15);
                i13 = i8 + i15;
                i12 = i9 - i15;
            } else {
                i13 = i8;
                i12 = i9;
            }
            if (bArr == bArr2) {
                byte[] bArr5 = new byte[i12];
                System.arraycopy(bArr2, i13, bArr5, 0, i12);
                bArr3 = bArr5;
                i11 = 0;
            } else {
                i11 = i13;
                bArr3 = bArr;
            }
            iProcessBuffer = this.bufOff != 0 ? processBuffer(bArr2, i10) : 0;
            MultiBlockCipher multiBlockCipher = this.mbCipher;
            if (multiBlockCipher != null) {
                int multiBlockSize = (this.mbCipher.getMultiBlockSize() / blockSize) * (i12 / multiBlockCipher.getMultiBlockSize());
                if (multiBlockSize > 0) {
                    iProcessBuffer += this.mbCipher.processBlocks(bArr3, i11, multiBlockSize, bArr2, i10 + iProcessBuffer);
                    int i16 = multiBlockSize * blockSize;
                    i12 -= i16;
                    i11 += i16;
                }
            } else {
                while (i12 > this.buf.length) {
                    iProcessBuffer += this.cipher.processBlock(bArr3, i11, bArr2, i10 + iProcessBuffer);
                    i12 -= blockSize;
                    i11 += blockSize;
                }
            }
        } else {
            bArr3 = bArr;
            i11 = i8;
            i12 = i9;
        }
        System.arraycopy(bArr3, i11, this.buf, this.bufOff, i12);
        int i17 = this.bufOff + i12;
        this.bufOff = i17;
        return i17 == this.buf.length ? iProcessBuffer + processBuffer(bArr2, i10 + iProcessBuffer) : iProcessBuffer;
    }

    public void reset() {
        int i8 = 0;
        while (true) {
            byte[] bArr = this.buf;
            if (i8 >= bArr.length) {
                this.bufOff = 0;
                this.cipher.reset();
                return;
            } else {
                bArr[i8] = 0;
                i8++;
            }
        }
    }

    public BufferedBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
        if (blockCipher instanceof MultiBlockCipher) {
            MultiBlockCipher multiBlockCipher = (MultiBlockCipher) blockCipher;
            this.mbCipher = multiBlockCipher;
            this.buf = new byte[multiBlockCipher.getMultiBlockSize()];
        } else {
            this.mbCipher = null;
            this.buf = new byte[blockCipher.getBlockSize()];
        }
        boolean z = false;
        this.bufOff = 0;
        String algorithmName = blockCipher.getAlgorithmName();
        int iIndexOf = algorithmName.indexOf(47) + 1;
        boolean z2 = iIndexOf > 0 && algorithmName.startsWith("PGP", iIndexOf);
        this.pgpCFB = z2;
        if (z2 || (blockCipher instanceof StreamCipher)) {
            this.partialBlockOkay = true;
            return;
        }
        if (iIndexOf > 0 && algorithmName.startsWith("OpenPGP", iIndexOf)) {
            z = true;
        }
        this.partialBlockOkay = z;
    }
}
