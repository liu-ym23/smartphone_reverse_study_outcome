package org.bouncycastle.crypto.params;

/* loaded from: classes.dex */
public class IESWithCipherParameters extends IESParameters {
    private int cipherKeySize;

    public IESWithCipherParameters(byte[] bArr, byte[] bArr2, int i8, int i9) {
        super(bArr, bArr2, i8);
        this.cipherKeySize = i9;
    }

    public int getCipherKeySize() {
        return this.cipherKeySize;
    }
}
