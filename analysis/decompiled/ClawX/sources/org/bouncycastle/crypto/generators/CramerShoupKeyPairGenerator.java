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
import org.bouncycastle.crypto.params.CramerShoupKeyGenerationParameters;
import org.bouncycastle.crypto.params.CramerShoupParameters;
import org.bouncycastle.crypto.params.CramerShoupPrivateKeyParameters;
import org.bouncycastle.crypto.params.CramerShoupPublicKeyParameters;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes.dex */
public class CramerShoupKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private CramerShoupKeyGenerationParameters param;

    private CramerShoupPublicKeyParameters calculatePublicKey(CramerShoupParameters cramerShoupParameters, CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParameters) {
        BigInteger g12 = cramerShoupParameters.getG1();
        BigInteger g22 = cramerShoupParameters.getG2();
        BigInteger p3 = cramerShoupParameters.getP();
        return new CramerShoupPublicKeyParameters(cramerShoupParameters, g12.modPow(cramerShoupPrivateKeyParameters.getX1(), p3).multiply(g22.modPow(cramerShoupPrivateKeyParameters.getX2(), p3)), g12.modPow(cramerShoupPrivateKeyParameters.getY1(), p3).multiply(g22.modPow(cramerShoupPrivateKeyParameters.getY2(), p3)), g12.modPow(cramerShoupPrivateKeyParameters.getZ(), p3));
    }

    private CramerShoupPrivateKeyParameters generatePrivateKey(SecureRandom secureRandom, CramerShoupParameters cramerShoupParameters) {
        BigInteger p3 = cramerShoupParameters.getP();
        return new CramerShoupPrivateKeyParameters(cramerShoupParameters, generateRandomElement(p3, secureRandom), generateRandomElement(p3, secureRandom), generateRandomElement(p3, secureRandom), generateRandomElement(p3, secureRandom), generateRandomElement(p3, secureRandom));
    }

    private BigInteger generateRandomElement(BigInteger bigInteger, SecureRandom secureRandom) {
        BigInteger bigInteger2 = ONE;
        return BigIntegers.createRandomInRange(bigInteger2, bigInteger.subtract(bigInteger2), secureRandom);
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        CramerShoupParameters parameters = this.param.getParameters();
        CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParametersGeneratePrivateKey = generatePrivateKey(this.param.getRandom(), parameters);
        CramerShoupPublicKeyParameters cramerShoupPublicKeyParametersCalculatePublicKey = calculatePublicKey(parameters, cramerShoupPrivateKeyParametersGeneratePrivateKey);
        cramerShoupPrivateKeyParametersGeneratePrivateKey.setPk(cramerShoupPublicKeyParametersCalculatePublicKey);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) cramerShoupPublicKeyParametersCalculatePublicKey, (AsymmetricKeyParameter) cramerShoupPrivateKeyParametersGeneratePrivateKey);
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        CramerShoupKeyGenerationParameters cramerShoupKeyGenerationParameters = (CramerShoupKeyGenerationParameters) keyGenerationParameters;
        this.param = cramerShoupKeyGenerationParameters;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("CramerShoupKeyGen", ConstraintUtils.bitsOfSecurityFor(cramerShoupKeyGenerationParameters.getParameters().getP()), this.param.getParameters(), CryptoServicePurpose.KEYGEN));
    }
}
