package org.bouncycastle.crypto;

/* loaded from: classes.dex */
public interface Digest {
    int doFinal(byte[] bArr, int i8);

    String getAlgorithmName();

    int getDigestSize();

    void reset();

    void update(byte b9);

    void update(byte[] bArr, int i8, int i9);
}
