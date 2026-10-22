package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.util.BigIntegers;
import p7.d0;

/* loaded from: classes.dex */
class DHKeyGeneratorHelper {
    static final DHKeyGeneratorHelper INSTANCE = new DHKeyGeneratorHelper();
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    private DHKeyGeneratorHelper() {
    }

    public BigInteger calculatePrivate(DHParameters dHParameters, SecureRandom secureRandom) {
        BigInteger bigIntegerCreateRandomInRange;
        BigInteger bit;
        int l3 = dHParameters.getL();
        if (l3 != 0) {
            int i8 = l3 >>> 2;
            do {
                bit = BigIntegers.createRandomBigInteger(l3, secureRandom).setBit(l3 - 1);
            } while (d0.e(bit) < i8);
            return bit;
        }
        BigInteger bigInteger = TWO;
        int m3 = dHParameters.getM();
        BigInteger bigIntegerShiftLeft = m3 != 0 ? ONE.shiftLeft(m3 - 1) : bigInteger;
        BigInteger q8 = dHParameters.getQ();
        if (q8 == null) {
            q8 = dHParameters.getP();
        }
        BigInteger bigIntegerSubtract = q8.subtract(bigInteger);
        int iBitLength = bigIntegerSubtract.bitLength() >>> 2;
        do {
            bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(bigIntegerShiftLeft, bigIntegerSubtract, secureRandom);
        } while (d0.e(bigIntegerCreateRandomInRange) < iBitLength);
        return bigIntegerCreateRandomInRange;
    }

    public BigInteger calculatePublic(DHParameters dHParameters, BigInteger bigInteger) {
        return dHParameters.getG().modPow(bigInteger, dHParameters.getP());
    }
}
