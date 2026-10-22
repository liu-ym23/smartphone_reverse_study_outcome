package com.google.crypto.tink.hybrid.internal;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class HpkeKemEncapOutput {
    private final byte[] encapsulatedKey;
    private final byte[] sharedSecret;

    public HpkeKemEncapOutput(byte[] bArr, byte[] bArr2) {
        this.sharedSecret = bArr;
        this.encapsulatedKey = bArr2;
    }

    public byte[] getEncapsulatedKey() {
        return this.encapsulatedKey;
    }

    public byte[] getSharedSecret() {
        return this.sharedSecret;
    }
}
