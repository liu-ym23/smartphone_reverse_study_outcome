package org.bouncycastle.crypto.ec;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import p7.d0;
import p7.h;
import p7.r;

/* loaded from: classes.dex */
public class ECElGamalDecryptor implements ECDecryptor {
    private ECPrivateKeyParameters key;

    @Override // org.bouncycastle.crypto.ec.ECDecryptor
    public r decrypt(ECPair eCPair) {
        ECPrivateKeyParameters eCPrivateKeyParameters = this.key;
        if (eCPrivateKeyParameters == null) {
            throw new IllegalStateException("ECElGamalDecryptor not initialised");
        }
        h curve = eCPrivateKeyParameters.getParameters().getCurve();
        return d0.a(curve, eCPair.getY()).u(d0.a(curve, eCPair.getX()).m(this.key.getD())).o();
    }

    @Override // org.bouncycastle.crypto.ec.ECDecryptor
    public void init(CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ECPrivateKeyParameters)) {
            throw new IllegalArgumentException("ECPrivateKeyParameters are required for decryption.");
        }
        this.key = (ECPrivateKeyParameters) cipherParameters;
    }
}
