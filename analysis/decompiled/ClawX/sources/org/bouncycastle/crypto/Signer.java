package org.bouncycastle.crypto;

/* loaded from: classes.dex */
public interface Signer {
    byte[] generateSignature();

    void init(boolean z, CipherParameters cipherParameters);

    void reset();

    void update(byte b9);

    void update(byte[] bArr, int i8, int i9);

    boolean verifySignature(byte[] bArr);
}
