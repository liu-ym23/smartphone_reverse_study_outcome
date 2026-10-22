package org.bouncycastle.crypto;

/* loaded from: classes.dex */
public interface KeyEncapsulation {
    CipherParameters decrypt(byte[] bArr, int i8, int i9, int i10);

    CipherParameters encrypt(byte[] bArr, int i8, int i9);

    void init(CipherParameters cipherParameters);
}
