package org.bouncycastle.crypto.ec;

import org.bouncycastle.crypto.CipherParameters;
import p7.r;

/* loaded from: classes.dex */
public interface ECDecryptor {
    r decrypt(ECPair eCPair);

    void init(CipherParameters cipherParameters);
}
