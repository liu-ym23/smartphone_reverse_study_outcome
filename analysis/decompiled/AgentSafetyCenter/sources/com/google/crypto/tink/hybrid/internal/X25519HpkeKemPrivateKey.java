package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.subtle.X25519;
import com.google.crypto.tink.util.Bytes;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class X25519HpkeKemPrivateKey implements HpkeKemPrivateKey {
    private final Bytes privateKey;
    private final Bytes publicKey;

    private X25519HpkeKemPrivateKey(byte[] bArr, byte[] bArr2) {
        this.privateKey = Bytes.copyFrom(bArr);
        this.publicKey = Bytes.copyFrom(bArr2);
    }

    public static X25519HpkeKemPrivateKey fromBytes(byte[] bArr) {
        return new X25519HpkeKemPrivateKey(bArr, X25519.publicFromPrivate(bArr));
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKemPrivateKey
    public Bytes getSerializedPrivate() {
        return this.privateKey;
    }

    @Override // com.google.crypto.tink.hybrid.internal.HpkeKemPrivateKey
    public Bytes getSerializedPublic() {
        return this.publicKey;
    }
}
