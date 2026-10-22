package org.bouncycastle.crypto;

/* loaded from: classes.dex */
public interface DerivationFunction {
    int generateBytes(byte[] bArr, int i8, int i9);

    void init(DerivationParameters derivationParameters);
}
