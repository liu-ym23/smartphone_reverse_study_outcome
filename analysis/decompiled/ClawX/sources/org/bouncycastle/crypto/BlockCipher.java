package org.bouncycastle.crypto;

/* loaded from: classes.dex */
public interface BlockCipher {
    String getAlgorithmName();

    int getBlockSize();

    void init(boolean z, CipherParameters cipherParameters);

    int processBlock(byte[] bArr, int i8, byte[] bArr2, int i9);

    void reset();
}
