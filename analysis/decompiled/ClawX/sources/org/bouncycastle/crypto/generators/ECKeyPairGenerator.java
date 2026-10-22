package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.constraints.ConstraintUtils;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.util.BigIntegers;
import p7.a;
import p7.d0;
import p7.n;
import p7.s;

/* loaded from: classes.dex */
public class ECKeyPairGenerator implements AsymmetricCipherKeyPairGenerator, a {
    private final String name;
    ECDomainParameters params;
    SecureRandom random;

    public ECKeyPairGenerator() {
        this("ECKeyGen");
    }

    public n createBasePointMultiplier() {
        return new s(0);
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger n3 = this.params.getN();
        int iBitLength = n3.bitLength();
        int i8 = iBitLength >>> 2;
        while (true) {
            BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(iBitLength, this.random);
            if (!isOutOfRangeD(bigIntegerCreateRandomBigInteger, n3) && d0.e(bigIntegerCreateRandomBigInteger) >= i8) {
                return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new ECPublicKeyParameters(((d0) createBasePointMultiplier()).m(this.params.getG(), bigIntegerCreateRandomBigInteger), this.params), (AsymmetricKeyParameter) new ECPrivateKeyParameters(bigIntegerCreateRandomBigInteger, this.params));
            }
        }
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        ECKeyGenerationParameters eCKeyGenerationParameters = (ECKeyGenerationParameters) keyGenerationParameters;
        this.random = eCKeyGenerationParameters.getRandom();
        ECDomainParameters domainParameters = eCKeyGenerationParameters.getDomainParameters();
        this.params = domainParameters;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(this.name, ConstraintUtils.bitsOfSecurityFor(domainParameters.getCurve()), eCKeyGenerationParameters.getDomainParameters(), CryptoServicePurpose.KEYGEN));
    }

    public boolean isOutOfRangeD(BigInteger bigInteger, BigInteger bigInteger2) {
        return bigInteger.compareTo(a.f4758b) < 0 || bigInteger.compareTo(bigInteger2) >= 0;
    }

    public ECKeyPairGenerator(String str) {
        this.name = str;
    }
}
