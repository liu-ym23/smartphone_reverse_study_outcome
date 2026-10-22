package org.bouncycastle.crypto;

/* loaded from: classes.dex */
public interface Wrapper {
    String getAlgorithmName();

    void init(boolean z, CipherParameters cipherParameters);

    byte[] unwrap(byte[] bArr, int i8, int i9);

    byte[] wrap(byte[] bArr, int i8, int i9);
}
