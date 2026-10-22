package org.bouncycastle.crypto;

/* loaded from: classes.dex */
public interface Mac {
    int doFinal(byte[] bArr, int i8);

    String getAlgorithmName();

    int getMacSize();

    void init(CipherParameters cipherParameters);

    void reset();

    void update(byte b9);

    void update(byte[] bArr, int i8, int i9);
}
