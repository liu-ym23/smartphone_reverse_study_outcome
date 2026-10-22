package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;

/* loaded from: classes.dex */
public class CMacWithIV extends CMac {
    public CMacWithIV(BlockCipher blockCipher) {
        super(blockCipher);
    }

    public CMacWithIV(BlockCipher blockCipher, int i8) {
        super(blockCipher, i8);
    }

    @Override // org.bouncycastle.crypto.macs.CMac
    public void validate(CipherParameters cipherParameters) {
    }
}
