package org.bouncycastle.crypto;

/* loaded from: classes.dex */
public interface MultiBlockCipher extends BlockCipher {
    int getMultiBlockSize();

    int processBlocks(byte[] bArr, int i8, int i9, byte[] bArr2, int i10);
}
