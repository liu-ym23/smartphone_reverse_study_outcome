package com.google.crypto.tink.subtle;

import b8.z;
import com.google.crypto.tink.PublicKeyVerify;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import g5.f;
import java.security.GeneralSecurityException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class Ed25519Verify implements PublicKeyVerify {
    public static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    public static final int PUBLIC_KEY_LEN = 32;
    public static final int SIGNATURE_LEN = 64;
    private final com.google.crypto.tink.util.Bytes publicKey;

    public Ed25519Verify(byte[] bArr) {
        if (!FIPS.isCompatible()) {
            throw new IllegalStateException(new GeneralSecurityException("Can not use Ed25519 in FIPS-mode."));
        }
        if (bArr.length == 32) {
            this.publicKey = com.google.crypto.tink.util.Bytes.copyFrom(bArr);
        } else {
            f.s("Given public key's length is not 32.");
            throw null;
        }
    }

    @Override // com.google.crypto.tink.PublicKeyVerify
    public void verify(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr.length != 64) {
            z.l("The length of the signature is not 64.");
        } else {
            if (Ed25519.verify(bArr2, bArr, this.publicKey.toByteArray())) {
                return;
            }
            z.l("Signature check failed.");
        }
    }
}
