package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.BigIntegers;
import p7.d0;

/* loaded from: classes.dex */
class DHParametersHelper {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    public static BigInteger[] generateSafePrimes(int i8, int i9, SecureRandom secureRandom) {
        int i10 = i8 - 1;
        int i11 = i8 >>> 2;
        while (true) {
            BigInteger bigIntegerCreateRandomPrime = BigIntegers.createRandomPrime(i10, 2, secureRandom);
            BigInteger bigIntegerAdd = bigIntegerCreateRandomPrime.shiftLeft(1).add(ONE);
            if (bigIntegerAdd.isProbablePrime(i9) && (i9 <= 2 || bigIntegerCreateRandomPrime.isProbablePrime(i9 - 2))) {
                if (d0.e(bigIntegerAdd) >= i11) {
                    return new BigInteger[]{bigIntegerAdd, bigIntegerCreateRandomPrime};
                }
            }
        }
    }

    public static BigInteger selectGenerator(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger bigIntegerModPow;
        BigInteger bigIntegerSubtract = bigInteger.subtract(TWO);
        do {
            BigInteger bigInteger3 = TWO;
            bigIntegerModPow = BigIntegers.createRandomInRange(bigInteger3, bigIntegerSubtract, secureRandom).modPow(bigInteger3, bigInteger);
        } while (bigIntegerModPow.equals(ONE));
        return bigIntegerModPow;
    }
}
