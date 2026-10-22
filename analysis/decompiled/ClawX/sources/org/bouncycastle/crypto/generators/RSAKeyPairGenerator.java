package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import o7.b;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.constraints.ConstraintUtils;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.util.BigIntegers;
import p7.d0;

/* loaded from: classes.dex */
public class RSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private RSAKeyGenerationParameters param;

    private static int getNumberOfIterations(int i8, int i9) {
        if (i8 >= 1536) {
            if (i9 <= 100) {
                return 3;
            }
            if (i9 <= 128) {
                return 4;
            }
            return ((i9 - 127) / 2) + 4;
        }
        if (i8 >= 1024) {
            if (i9 <= 100) {
                return 4;
            }
            if (i9 <= 112) {
                return 5;
            }
            return ((i9 - 111) / 2) + 5;
        }
        if (i8 < 512) {
            if (i9 <= 80) {
                return 40;
            }
            return ((i9 - 79) / 2) + 40;
        }
        if (i9 <= 80) {
            return 5;
        }
        if (i9 <= 100) {
            return 7;
        }
        return ((i9 - 99) / 2) + 7;
    }

    public BigInteger chooseRandomPrime(int i8, BigInteger bigInteger, BigInteger bigInteger2) {
        for (int i9 = 0; i9 != i8 * 5; i9++) {
            BigInteger bigIntegerCreateRandomPrime = BigIntegers.createRandomPrime(i8, 1, this.param.getRandom());
            BigInteger bigIntegerMod = bigIntegerCreateRandomPrime.mod(bigInteger);
            BigInteger bigInteger3 = ONE;
            if (!bigIntegerMod.equals(bigInteger3) && bigIntegerCreateRandomPrime.multiply(bigIntegerCreateRandomPrime).compareTo(bigInteger2) >= 0 && isProbablePrime(bigIntegerCreateRandomPrime) && bigInteger.gcd(bigIntegerCreateRandomPrime.subtract(bigInteger3)).equals(bigInteger3)) {
                return bigIntegerCreateRandomPrime;
            }
        }
        throw new IllegalStateException("unable to generate prime number for RSA key");
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger bigIntegerChooseRandomPrime;
        BigInteger bigIntegerChooseRandomPrime2;
        BigInteger bigIntegerMultiply;
        RSAKeyPairGenerator rSAKeyPairGenerator = this;
        int strength = rSAKeyPairGenerator.param.getStrength();
        int i8 = (strength + 1) / 2;
        int i9 = strength - i8;
        int i10 = strength / 2;
        int i11 = i10 - 100;
        int i12 = strength / 3;
        if (i11 < i12) {
            i11 = i12;
        }
        int i13 = strength >> 2;
        BigInteger bigIntegerPow = BigInteger.valueOf(2L).pow(i10);
        BigInteger bigInteger = ONE;
        BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft(strength - 1);
        BigInteger bigIntegerShiftLeft2 = bigInteger.shiftLeft(i11);
        AsymmetricCipherKeyPair asymmetricCipherKeyPair = null;
        boolean z = false;
        while (!z) {
            BigInteger publicExponent = rSAKeyPairGenerator.param.getPublicExponent();
            do {
                bigIntegerChooseRandomPrime = rSAKeyPairGenerator.chooseRandomPrime(i8, publicExponent, bigIntegerShiftLeft);
                while (true) {
                    bigIntegerChooseRandomPrime2 = rSAKeyPairGenerator.chooseRandomPrime(i9, publicExponent, bigIntegerShiftLeft);
                    BigInteger bigIntegerAbs = bigIntegerChooseRandomPrime2.subtract(bigIntegerChooseRandomPrime).abs();
                    if (bigIntegerAbs.bitLength() >= i11 && bigIntegerAbs.compareTo(bigIntegerShiftLeft2) > 0) {
                        bigIntegerMultiply = bigIntegerChooseRandomPrime.multiply(bigIntegerChooseRandomPrime2);
                        if (bigIntegerMultiply.bitLength() == strength) {
                            break;
                        }
                        bigIntegerChooseRandomPrime = bigIntegerChooseRandomPrime.max(bigIntegerChooseRandomPrime2);
                    } else {
                        rSAKeyPairGenerator = this;
                        strength = strength;
                    }
                }
            } while (d0.e(bigIntegerMultiply) < i13);
            if (bigIntegerChooseRandomPrime.compareTo(bigIntegerChooseRandomPrime2) < 0) {
                bigIntegerChooseRandomPrime2 = bigIntegerChooseRandomPrime;
                bigIntegerChooseRandomPrime = bigIntegerChooseRandomPrime2;
            }
            BigInteger bigInteger2 = ONE;
            BigInteger bigIntegerSubtract = bigIntegerChooseRandomPrime.subtract(bigInteger2);
            BigInteger bigIntegerSubtract2 = bigIntegerChooseRandomPrime2.subtract(bigInteger2);
            int i14 = strength;
            BigInteger bigIntegerModInverse = publicExponent.modInverse(bigIntegerSubtract.divide(bigIntegerSubtract.gcd(bigIntegerSubtract2)).multiply(bigIntegerSubtract2));
            if (bigIntegerModInverse.compareTo(bigIntegerPow) > 0) {
                z = true;
                asymmetricCipherKeyPair = new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new RSAKeyParameters(false, bigIntegerMultiply, publicExponent, true), (AsymmetricKeyParameter) new RSAPrivateCrtKeyParameters(bigIntegerMultiply, publicExponent, bigIntegerModInverse, bigIntegerChooseRandomPrime, bigIntegerChooseRandomPrime2, bigIntegerModInverse.remainder(bigIntegerSubtract), bigIntegerModInverse.remainder(bigIntegerSubtract2), BigIntegers.modOddInverse(bigIntegerChooseRandomPrime, bigIntegerChooseRandomPrime2), true));
            }
            rSAKeyPairGenerator = this;
            strength = i14;
        }
        return asymmetricCipherKeyPair;
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (RSAKeyGenerationParameters) keyGenerationParameters;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("RSAKeyGen", ConstraintUtils.bitsOfSecurityForFF(keyGenerationParameters.getStrength()), null, CryptoServicePurpose.KEYGEN));
    }

    public boolean isProbablePrime(BigInteger bigInteger) {
        return !b.b(bigInteger) && b.c(bigInteger, this.param.getRandom(), getNumberOfIterations(bigInteger.bitLength(), this.param.getCertainty()));
    }
}
