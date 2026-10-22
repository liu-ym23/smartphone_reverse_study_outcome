package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import p7.a;
import p7.d0;
import p7.r;

/* loaded from: classes.dex */
public class ECDHBasicAgreement implements BasicAgreement {
    private ECPrivateKeyParameters key;

    @Override // org.bouncycastle.crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) cipherParameters;
        ECDomainParameters parameters = this.key.getParameters();
        if (!parameters.equals(eCPublicKeyParameters.getParameters())) {
            throw new IllegalStateException("ECDH public key has wrong domain parameters");
        }
        BigInteger d = this.key.getD();
        r rVarA = d0.a(parameters.getCurve(), eCPublicKeyParameters.getQ());
        if (rVarA.k()) {
            throw new IllegalStateException("Infinity is not a valid public key for ECDH");
        }
        BigInteger h3 = parameters.getH();
        if (!h3.equals(a.f4758b)) {
            d = parameters.getHInv().multiply(d).mod(parameters.getN());
            rVarA = d0.p(rVarA, h3);
        }
        r rVarO = rVarA.m(d).o();
        if (rVarO.k()) {
            throw new IllegalStateException("Infinity is not a valid agreement value for ECDH");
        }
        rVarO.b();
        return rVarO.f4818b.t();
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public int getFieldSize() {
        return this.key.getParameters().getCurve().k();
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public void init(CipherParameters cipherParameters) {
        ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) cipherParameters;
        this.key = eCPrivateKeyParameters;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties("ECDH", eCPrivateKeyParameters));
    }
}
