package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithUKM;
import org.bouncycastle.util.Arrays;
import p7.d0;
import p7.r;

/* loaded from: classes.dex */
public class ECVKOAgreement {
    private final Digest digest;
    private ECPrivateKeyParameters key;
    private BigInteger ukm;

    public ECVKOAgreement(Digest digest) {
        this.digest = digest;
    }

    public byte[] calculateAgreement(CipherParameters cipherParameters) {
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) cipherParameters;
        ECDomainParameters parameters = this.key.getParameters();
        if (!parameters.equals(eCPublicKeyParameters.getParameters())) {
            throw new IllegalStateException("ECVKO public key has wrong domain parameters");
        }
        BigInteger bigIntegerMod = parameters.getH().multiply(this.ukm).multiply(this.key.getD()).mod(parameters.getN());
        r rVarA = d0.a(parameters.getCurve(), eCPublicKeyParameters.getQ());
        if (rVarA.k()) {
            throw new IllegalStateException("Infinity is not a valid public key for ECVKO");
        }
        r rVarO = rVarA.m(bigIntegerMod).o();
        if (rVarO.k()) {
            throw new IllegalStateException("Infinity is not a valid agreement value for ECVKO");
        }
        byte[] bArrG = rVarO.g(false);
        int length = bArrG.length;
        int i8 = length / 2;
        int i9 = i8 * 2;
        int i10 = length - i9;
        Arrays.reverseInPlace(bArrG, i10, i8);
        Arrays.reverseInPlace(bArrG, length - i8, i8);
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.update(bArrG, i10, i9);
        this.digest.doFinal(bArr, 0);
        return bArr;
    }

    public int getAgreementSize() {
        return this.digest.getDigestSize();
    }

    public int getFieldSize() {
        return this.key.getParameters().getCurve().k();
    }

    public void init(CipherParameters cipherParameters) {
        ParametersWithUKM parametersWithUKM = (ParametersWithUKM) cipherParameters;
        this.key = (ECPrivateKeyParameters) parametersWithUKM.getParameters();
        this.ukm = new BigInteger(1, Arrays.reverse(parametersWithUKM.getUKM()));
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties("ECVKO", this.key));
    }
}
