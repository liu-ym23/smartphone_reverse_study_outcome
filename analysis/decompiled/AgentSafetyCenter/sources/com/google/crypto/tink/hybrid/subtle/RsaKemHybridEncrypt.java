package com.google.crypto.tink.hybrid.subtle;

import com.google.crypto.tink.HybridEncrypt;
import com.google.crypto.tink.aead.subtle.AeadFactory;
import com.google.crypto.tink.subtle.Hkdf;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.Cipher;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class RsaKemHybridEncrypt implements HybridEncrypt {
    private final AeadFactory aeadFactory;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final RSAPublicKey recipientPublicKey;

    public RsaKemHybridEncrypt(RSAPublicKey rSAPublicKey, String str, byte[] bArr, AeadFactory aeadFactory) throws GeneralSecurityException {
        RsaKem.validateRsaModulus(rSAPublicKey.getModulus());
        this.recipientPublicKey = rSAPublicKey;
        this.hkdfHmacAlgo = str;
        this.hkdfSalt = bArr;
        this.aeadFactory = aeadFactory;
    }

    @Override // com.google.crypto.tink.HybridEncrypt
    public byte[] encrypt(byte[] bArr, byte[] bArr2) throws IllegalStateException, GeneralSecurityException {
        byte[] bArrGenerateSecret = RsaKem.generateSecret(this.recipientPublicKey.getModulus());
        Cipher cipher = Cipher.getInstance("RSA/ECB/NoPadding");
        cipher.init(1, this.recipientPublicKey);
        byte[] bArrDoFinal = cipher.doFinal(bArrGenerateSecret);
        byte[] bArrEncrypt = this.aeadFactory.createAead(Hkdf.computeHkdf(this.hkdfHmacAlgo, bArrGenerateSecret, this.hkdfSalt, bArr2, this.aeadFactory.getKeySizeInBytes())).encrypt(bArr, RsaKem.EMPTY_AAD);
        return ByteBuffer.allocate(bArrDoFinal.length + bArrEncrypt.length).put(bArrDoFinal).put(bArrEncrypt).array();
    }
}
