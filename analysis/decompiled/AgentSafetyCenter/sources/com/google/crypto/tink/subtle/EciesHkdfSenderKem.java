package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.EllipticCurves;
import g5.f;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class EciesHkdfSenderKem {
    private final ECPublicKey recipientPublicKey;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static final class KemKey {
        private final com.google.crypto.tink.util.Bytes kemBytes;
        private final com.google.crypto.tink.util.Bytes symmetricKey;

        public KemKey(byte[] bArr, byte[] bArr2) {
            if (bArr == null) {
                f.g("KemBytes must be non-null");
                throw null;
            }
            if (bArr2 == null) {
                f.g("symmetricKey must be non-null");
                throw null;
            }
            this.kemBytes = com.google.crypto.tink.util.Bytes.copyFrom(bArr);
            this.symmetricKey = com.google.crypto.tink.util.Bytes.copyFrom(bArr2);
        }

        public byte[] getKemBytes() {
            return this.kemBytes.toByteArray();
        }

        public byte[] getSymmetricKey() {
            return this.symmetricKey.toByteArray();
        }
    }

    public EciesHkdfSenderKem(ECPublicKey eCPublicKey) {
        this.recipientPublicKey = eCPublicKey;
    }

    public KemKey generateKey(String str, byte[] bArr, byte[] bArr2, int i, EllipticCurves.PointFormatType pointFormatType) throws GeneralSecurityException {
        KeyPair keyPairGenerateKeyPair = EllipticCurves.generateKeyPair(this.recipientPublicKey.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) keyPairGenerateKeyPair.getPublic();
        byte[] bArrComputeSharedSecret = EllipticCurves.computeSharedSecret((ECPrivateKey) keyPairGenerateKeyPair.getPrivate(), this.recipientPublicKey);
        byte[] bArrPointEncode = EllipticCurves.pointEncode(eCPublicKey.getParams().getCurve(), pointFormatType, eCPublicKey.getW());
        return new KemKey(bArrPointEncode, Hkdf.computeEciesHkdfSymmetricKey(bArrPointEncode, bArrComputeSharedSecret, str, bArr, bArr2, i));
    }
}
