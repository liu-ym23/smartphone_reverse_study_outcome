package org.bouncycastle.crypto.agreement.kdf;

import org.bouncycastle.crypto.DerivationParameters;

/* loaded from: classes.dex */
public class GSKKDFParameters implements DerivationParameters {
    private final byte[] nonce;
    private final int startCounter;
    private final byte[] z;

    public GSKKDFParameters(byte[] bArr, int i8) {
        this(bArr, i8, null);
    }

    public byte[] getNonce() {
        return this.nonce;
    }

    public int getStartCounter() {
        return this.startCounter;
    }

    public byte[] getZ() {
        return this.z;
    }

    public GSKKDFParameters(byte[] bArr, int i8, byte[] bArr2) {
        this.z = bArr;
        this.startCounter = i8;
        this.nonce = bArr2;
    }
}
