package com.google.crypto.tink.subtle;

import b8.z;
import com.google.crypto.tink.Mac;
import com.google.crypto.tink.prf.Prf;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class PrfMac implements Mac {
    static final int MIN_TAG_SIZE_IN_BYTES = 10;
    private final int tagSize;
    private final Prf wrappedPrf;

    public PrfMac(Prf prf, int i) throws InvalidAlgorithmParameterException {
        this.wrappedPrf = prf;
        this.tagSize = i;
        if (i < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
        }
        prf.compute(new byte[0], i);
    }

    @Override // com.google.crypto.tink.Mac
    public byte[] computeMac(byte[] bArr) {
        return this.wrappedPrf.compute(bArr, this.tagSize);
    }

    @Override // com.google.crypto.tink.Mac
    public void verifyMac(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (Bytes.equal(computeMac(bArr2), bArr)) {
            return;
        }
        z.l("invalid MAC");
    }
}
