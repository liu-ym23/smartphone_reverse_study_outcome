package org.bouncycastle.crypto;

/* loaded from: classes.dex */
public interface StreamCipher {
    String getAlgorithmName();

    void init(boolean z, CipherParameters cipherParameters);

    int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10);

    void reset();

    byte returnByte(byte b9);
}
