package org.bouncycastle.crypto.threshold;

import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class ShamirSplitSecretShare implements SecretShare {

    /* renamed from: r, reason: collision with root package name */
    final int f4591r;
    private final byte[] secretShare;

    public ShamirSplitSecretShare(byte[] bArr) {
        this.secretShare = Arrays.clone(bArr);
        this.f4591r = 1;
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        return Arrays.clone(this.secretShare);
    }

    public ShamirSplitSecretShare(byte[] bArr, int i8) {
        this.secretShare = Arrays.clone(bArr);
        this.f4591r = i8;
    }
}
