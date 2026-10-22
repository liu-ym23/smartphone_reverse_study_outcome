package com.google.crypto.tink.mac.internal;

import b8.z;
import com.google.crypto.tink.config.internal.TinkFipsUtil;
import com.google.crypto.tink.mac.AesCmacKey;
import com.google.crypto.tink.mac.ChunkedMac;
import com.google.crypto.tink.mac.ChunkedMacComputation;
import com.google.crypto.tink.mac.ChunkedMacVerification;
import com.google.crypto.tink.util.Bytes;
import java.security.GeneralSecurityException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class ChunkedAesCmacImpl implements ChunkedMac {
    private static final TinkFipsUtil.AlgorithmFipsCompatibility FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private final AesCmacKey key;

    public ChunkedAesCmacImpl(AesCmacKey aesCmacKey) throws GeneralSecurityException {
        if (FIPS.isCompatible()) {
            this.key = aesCmacKey;
        } else {
            z.l("Can not use AES-CMAC in FIPS-mode.");
            throw null;
        }
    }

    @Override // com.google.crypto.tink.mac.ChunkedMac
    public ChunkedMacComputation createComputation() {
        return new ChunkedAesCmacComputation(this.key);
    }

    @Override // com.google.crypto.tink.mac.ChunkedMac
    public ChunkedMacVerification createVerification(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length < this.key.getOutputPrefix().size()) {
            z.l("Tag too short");
            return null;
        }
        if (this.key.getOutputPrefix().equals(Bytes.copyFrom(bArr, 0, this.key.getOutputPrefix().size()))) {
            return new ChunkedAesCmacVerification(this.key, bArr);
        }
        z.l("Wrong tag prefix");
        return null;
    }
}
