package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DSAExt;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import p7.a;
import p7.d0;
import p7.n;
import p7.r;
import p7.s;

/* loaded from: classes.dex */
public class ECGOST3410Signer implements DSAExt {
    ECKeyParameters key;
    SecureRandom random;

    public n createBasePointMultiplier() {
        return new s(0);
    }

    @Override // org.bouncycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        BigInteger bigInteger = new BigInteger(1, Arrays.reverse(bArr));
        ECDomainParameters parameters = this.key.getParameters();
        BigInteger n3 = parameters.getN();
        BigInteger d = ((ECPrivateKeyParameters) this.key).getD();
        n nVarCreateBasePointMultiplier = createBasePointMultiplier();
        while (true) {
            BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(n3.bitLength(), this.random);
            BigInteger bigInteger2 = a.f4757a;
            if (!bigIntegerCreateRandomBigInteger.equals(bigInteger2)) {
                r rVarO = ((d0) nVarCreateBasePointMultiplier).m(parameters.getG(), bigIntegerCreateRandomBigInteger).o();
                rVarO.b();
                BigInteger bigIntegerMod = rVarO.f4818b.t().mod(n3);
                if (bigIntegerMod.equals(bigInteger2)) {
                    continue;
                } else {
                    BigInteger bigIntegerMod2 = bigIntegerCreateRandomBigInteger.multiply(bigInteger).add(d.multiply(bigIntegerMod)).mod(n3);
                    if (!bigIntegerMod2.equals(bigInteger2)) {
                        return new BigInteger[]{bigIntegerMod, bigIntegerMod2};
                    }
                }
            }
        }
    }

    @Override // org.bouncycastle.crypto.DSAExt
    public BigInteger getOrder() {
        return this.key.getParameters().getN();
    }

    @Override // org.bouncycastle.crypto.DSA
    public void init(boolean z, CipherParameters cipherParameters) {
        SecureRandom random = null;
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                random = parametersWithRandom.getRandom();
                cipherParameters = parametersWithRandom.getParameters();
            }
            this.key = (ECPrivateKeyParameters) cipherParameters;
            this.random = CryptoServicesRegistrar.getSecureRandom(random);
        } else {
            this.key = (ECPublicKeyParameters) cipherParameters;
            this.random = null;
        }
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties("ECGOST3410", this.key, z));
    }

    @Override // org.bouncycastle.crypto.DSA
    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = new BigInteger(1, Arrays.reverse(bArr));
        BigInteger n3 = this.key.getParameters().getN();
        BigInteger bigInteger4 = a.f4758b;
        if (bigInteger.compareTo(bigInteger4) < 0 || bigInteger.compareTo(n3) >= 0 || bigInteger2.compareTo(bigInteger4) < 0 || bigInteger2.compareTo(n3) >= 0) {
            return false;
        }
        BigInteger bigIntegerModOddInverseVar = BigIntegers.modOddInverseVar(n3, bigInteger3);
        r rVarO = d0.q(this.key.getParameters().getG(), ((ECPublicKeyParameters) this.key).getQ(), bigInteger2.multiply(bigIntegerModOddInverseVar).mod(n3), n3.subtract(bigInteger).multiply(bigIntegerModOddInverseVar).mod(n3)).o();
        if (rVarO.k()) {
            return false;
        }
        rVarO.b();
        return rVarO.f4818b.t().mod(n3).equals(bigInteger);
    }
}
