package org.bouncycastle.crypto.ec;

import org.bouncycastle.crypto.CipherParameters;
import p7.r;

/* loaded from: classes.dex */
public interface ECEncryptor {
    ECPair encrypt(r rVar);

    void init(CipherParameters cipherParameters);
}
