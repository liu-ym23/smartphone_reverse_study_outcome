package org.bouncycastle.crypto.ec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.util.BigIntegers;
import p7.a;

/* loaded from: classes.dex */
class ECUtil {
    public static BigInteger generateK(BigInteger bigInteger, SecureRandom secureRandom) {
        int iBitLength = bigInteger.bitLength();
        while (true) {
            BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(iBitLength, secureRandom);
            if (!bigIntegerCreateRandomBigInteger.equals(a.f4757a) && bigIntegerCreateRandomBigInteger.compareTo(bigInteger) < 0) {
                return bigIntegerCreateRandomBigInteger;
            }
        }
    }
}
