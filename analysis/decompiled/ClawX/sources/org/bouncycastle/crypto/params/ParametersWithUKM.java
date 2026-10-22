package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

/* loaded from: classes.dex */
public class ParametersWithUKM implements CipherParameters {
    private CipherParameters parameters;
    private byte[] ukm;

    public ParametersWithUKM(CipherParameters cipherParameters, byte[] bArr) {
        this(cipherParameters, bArr, 0, bArr.length);
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }

    public byte[] getUKM() {
        return this.ukm;
    }

    public ParametersWithUKM(CipherParameters cipherParameters, byte[] bArr, int i8, int i9) {
        byte[] bArr2 = new byte[i9];
        this.ukm = bArr2;
        this.parameters = cipherParameters;
        System.arraycopy(bArr, i8, bArr2, 0, i9);
    }
}
