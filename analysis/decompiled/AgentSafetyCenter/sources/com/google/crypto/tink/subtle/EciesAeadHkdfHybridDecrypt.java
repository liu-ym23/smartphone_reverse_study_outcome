package com.google.crypto.tink.subtle;

import b8.z;
import com.google.crypto.tink.HybridDecrypt;
import com.google.crypto.tink.subtle.EllipticCurves;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class EciesAeadHkdfHybridDecrypt implements HybridDecrypt {
    private static final byte[] EMPTY_AAD = new byte[0];
    private final EciesAeadHkdfDemHelper demHelper;
    private final EllipticCurves.PointFormatType ecPointFormat;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final EciesHkdfRecipientKem recipientKem;
    private final ECPrivateKey recipientPrivateKey;

    public EciesAeadHkdfHybridDecrypt(ECPrivateKey eCPrivateKey, byte[] bArr, String str, EllipticCurves.PointFormatType pointFormatType, EciesAeadHkdfDemHelper eciesAeadHkdfDemHelper) {
        this.recipientPrivateKey = eCPrivateKey;
        this.recipientKem = new EciesHkdfRecipientKem(eCPrivateKey);
        this.hkdfSalt = bArr;
        this.hkdfHmacAlgo = str;
        this.ecPointFormat = pointFormatType;
        this.demHelper = eciesAeadHkdfDemHelper;
    }

    @Override // com.google.crypto.tink.HybridDecrypt
    public byte[] decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int iEncodingSizeInBytes = EllipticCurves.encodingSizeInBytes(this.recipientPrivateKey.getParams().getCurve(), this.ecPointFormat);
        if (bArr.length < iEncodingSizeInBytes) {
            z.l("ciphertext too short");
            return null;
        }
        return this.demHelper.getAeadOrDaead(this.recipientKem.generateKey(Arrays.copyOfRange(bArr, 0, iEncodingSizeInBytes), this.hkdfHmacAlgo, this.hkdfSalt, bArr2, this.demHelper.getSymmetricKeySizeInBytes(), this.ecPointFormat)).decrypt(Arrays.copyOfRange(bArr, iEncodingSizeInBytes, bArr.length), EMPTY_AAD);
    }
}
