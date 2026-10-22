package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.BasicAgreement;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.MQVPrivateParameters;
import org.bouncycastle.crypto.params.MQVPublicParameters;
import org.bouncycastle.util.Properties;
import p7.a;
import p7.d0;
import p7.h;
import p7.r;

/* loaded from: classes.dex */
public class ECMQVBasicAgreement implements BasicAgreement {
    MQVPrivateParameters privParams;

    private r calculateMqvAgreement(ECDomainParameters eCDomainParameters, ECPrivateKeyParameters eCPrivateKeyParameters, ECPrivateKeyParameters eCPrivateKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters, ECPublicKeyParameters eCPublicKeyParameters2, ECPublicKeyParameters eCPublicKeyParameters3) {
        BigInteger n3 = eCDomainParameters.getN();
        int iBitLength = (n3.bitLength() + 1) / 2;
        BigInteger bigIntegerShiftLeft = a.f4758b.shiftLeft(iBitLength);
        h curve = eCDomainParameters.getCurve();
        r rVarA = d0.a(curve, eCPublicKeyParameters.getQ());
        r rVarA2 = d0.a(curve, eCPublicKeyParameters2.getQ());
        r rVarA3 = d0.a(curve, eCPublicKeyParameters3.getQ());
        rVarA.b();
        BigInteger bigIntegerMod = eCPrivateKeyParameters.getD().multiply(rVarA.f4818b.t().mod(bigIntegerShiftLeft).setBit(iBitLength)).add(eCPrivateKeyParameters2.getD()).mod(n3);
        rVarA3.b();
        BigInteger bit = rVarA3.f4818b.t().mod(bigIntegerShiftLeft).setBit(iBitLength);
        BigInteger bigIntegerMod2 = eCDomainParameters.getH().multiply(bigIntegerMod).mod(n3);
        return d0.q(rVarA2, rVarA3, bit.multiply(bigIntegerMod2).mod(n3), bigIntegerMod2);
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public BigInteger calculateAgreement(CipherParameters cipherParameters) {
        if (Properties.isOverrideSet("org.bouncycastle.ec.disable_mqv")) {
            throw new IllegalStateException("ECMQV explicitly disabled");
        }
        MQVPublicParameters mQVPublicParameters = (MQVPublicParameters) cipherParameters;
        ECPrivateKeyParameters staticPrivateKey = this.privParams.getStaticPrivateKey();
        ECDomainParameters parameters = staticPrivateKey.getParameters();
        if (!parameters.equals(mQVPublicParameters.getStaticPublicKey().getParameters())) {
            throw new IllegalStateException("ECMQV public key components have wrong domain parameters");
        }
        r rVarO = calculateMqvAgreement(parameters, staticPrivateKey, this.privParams.getEphemeralPrivateKey(), this.privParams.getEphemeralPublicKey(), mQVPublicParameters.getStaticPublicKey(), mQVPublicParameters.getEphemeralPublicKey()).o();
        if (rVarO.k()) {
            throw new IllegalStateException("Infinity is not a valid agreement value for MQV");
        }
        rVarO.b();
        return rVarO.f4818b.t();
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public int getFieldSize() {
        return this.privParams.getStaticPrivateKey().getParameters().getCurve().k();
    }

    @Override // org.bouncycastle.crypto.BasicAgreement
    public void init(CipherParameters cipherParameters) {
        MQVPrivateParameters mQVPrivateParameters = (MQVPrivateParameters) cipherParameters;
        this.privParams = mQVPrivateParameters;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties("ECMQV", mQVPrivateParameters.getStaticPrivateKey()));
    }
}
