package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.CipherParameters;

/* loaded from: classes.dex */
public interface AEADCipher {
    int doFinal(byte[] bArr, int i8);

    String getAlgorithmName();

    byte[] getMac();

    int getOutputSize(int i8);

    int getUpdateOutputSize(int i8);

    void init(boolean z, CipherParameters cipherParameters);

    void processAADByte(byte b9);

    void processAADBytes(byte[] bArr, int i8, int i9);

    int processByte(byte b9, byte[] bArr, int i8);

    int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10);

    void reset();
}
