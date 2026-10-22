package com.google.crypto.tink.hybrid.internal;

import com.google.crypto.tink.subtle.EllipticCurves;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class NistCurvesHpkeKemPrivateKey implements HpkeKemPrivateKey {
    private final Bytes privateKey;
    private final Bytes publicKey;

    private NistCurvesHpkeKemPrivateKey(byte[] bArr, byte[] bArr2) {
        this.privateKey = Bytes.copyFrom(bArr);
        this.publicKey = Bytes.copyFrom(bArr2);
    }

    public static NistCurvesHpkeKemPrivateKey fromBytes(byte[] bArr, byte[] bArr2, EllipticCurves.CurveType curveType) throws GeneralSecurityException {
        EllipticCurves.validatePublicKey(EllipticCurves.getEcPublicKey(curveType, EllipticCurves.PointFormatType.UNCOMPRESSED, bArr2), EllipticCurves.getEcPrivateKey(curveType, bArr));
        return new NistCurvesHpkeKemPrivateKey(bArr, bArr2);
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
