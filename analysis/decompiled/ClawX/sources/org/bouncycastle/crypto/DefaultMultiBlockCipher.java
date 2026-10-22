package org.bouncycastle.crypto;

/* loaded from: classes.dex */
public abstract class DefaultMultiBlockCipher implements MultiBlockCipher {
    @Override // org.bouncycastle.crypto.MultiBlockCipher
    public int getMultiBlockSize() {
        return getBlockSize();
    }

    @Override // org.bouncycastle.crypto.MultiBlockCipher
    public int processBlocks(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        int blockSize = getBlockSize();
        int i11 = i9 * blockSize;
        if (bArr == bArr2) {
            bArr = new byte[i11];
            System.arraycopy(bArr2, i8, bArr, 0, i11);
            i8 = 0;
        }
        int iProcessBlock = 0;
        for (int i12 = 0; i12 != i9; i12++) {
            iProcessBlock += processBlock(bArr, i8, bArr2, i10 + iProcessBlock);
            i8 += blockSize;
        }
        return iProcessBlock;
    }
}
