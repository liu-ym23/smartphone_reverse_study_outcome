package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes.dex */
public class SAKKEPrivateKeyParameters extends AsymmetricKeyParameter {
    private static final BigInteger qMinOne = SAKKEPublicKeyParameters.f4579q.subtract(BigInteger.ONE);
    private final SAKKEPublicKeyParameters publicParams;
    private final BigInteger z;

    public SAKKEPrivateKeyParameters(BigInteger bigInteger, SAKKEPublicKeyParameters sAKKEPublicKeyParameters) {
        super(true);
        this.z = bigInteger;
        this.publicParams = sAKKEPublicKeyParameters;
        if (!sAKKEPublicKeyParameters.getPoint().m(bigInteger).o().c(sAKKEPublicKeyParameters.getZ())) {
            throw new IllegalStateException("public key and private key of SAKKE do not match");
        }
    }

    public BigInteger getMasterSecret() {
        return this.z;
    }

    public SAKKEPublicKeyParameters getPublicParams() {
        return this.publicParams;
    }

    public SAKKEPrivateKeyParameters(SecureRandom secureRandom) {
        super(true);
        BigInteger bigInteger = BigIntegers.TWO;
        BigInteger bigInteger2 = qMinOne;
        BigInteger bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(bigInteger, bigInteger2, secureRandom);
        this.z = bigIntegerCreateRandomInRange;
        this.publicParams = new SAKKEPublicKeyParameters(BigIntegers.createRandomInRange(bigInteger, bigInteger2, secureRandom), SAKKEPublicKeyParameters.P.m(bigIntegerCreateRandomInRange).o());
    }
}
