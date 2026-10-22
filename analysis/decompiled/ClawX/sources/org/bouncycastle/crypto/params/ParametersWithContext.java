package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class ParametersWithContext implements CipherParameters {
    private byte[] context;
    private CipherParameters parameters;

    public ParametersWithContext(CipherParameters cipherParameters, byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("'context' cannot be null");
        }
        this.parameters = cipherParameters;
        this.context = Arrays.clone(bArr);
    }

    public void copyContextTo(byte[] bArr, int i8, int i9) {
        byte[] bArr2 = this.context;
        if (bArr2.length != i9) {
            throw new IllegalArgumentException("len");
        }
        System.arraycopy(bArr2, 0, bArr, i8, i9);
    }

    public byte[] getContext() {
        return Arrays.clone(this.context);
    }

    public int getContextLength() {
        return this.context.length;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}
