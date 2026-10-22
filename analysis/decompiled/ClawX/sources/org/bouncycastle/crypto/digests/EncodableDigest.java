package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.EncodableService;

/* loaded from: classes.dex */
public interface EncodableDigest extends EncodableService {
    @Override // org.bouncycastle.crypto.EncodableService
    byte[] getEncodedState();
}
