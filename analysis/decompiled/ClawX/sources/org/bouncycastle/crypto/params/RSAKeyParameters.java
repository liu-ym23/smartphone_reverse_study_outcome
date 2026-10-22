package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import java.security.SecureRandom;
import kotlinx.serialization.json.internal.ReaderJsonLexerKt;
import o7.a;
import o7.b;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Properties;

/* loaded from: classes.dex */
public class RSAKeyParameters extends AsymmetricKeyParameter {
    private BigInteger exponent;
    private BigInteger modulus;
    private static final BigIntegers.Cache validated = new BigIntegers.Cache();
    private static final BigInteger SMALL_PRIMES_PRODUCT = new BigInteger("8138e8a0fcf3a4e84a771d40fd305d7f4aa59306d7251de54d98af8fe95729a1f73d893fa424cd2edc8636a6c3285e022b0e3866a565ae8108eed8591cd4fe8d2ce86165a978d719ebf647f362d33fca29cd179fb42401cbaf3df0c614056f9c8f3cfd51e474afb6bc6974f78db8aba8e9e517fded658591ab7502bd41849462f", 16);

    public RSAKeyParameters(boolean z, BigInteger bigInteger, BigInteger bigInteger2) {
        this(z, bigInteger, bigInteger2, false);
    }

    private static int getMRIterations(int i8) {
        if (i8 >= 1536) {
            return 3;
        }
        if (i8 >= 1024) {
            return 4;
        }
        return i8 >= 512 ? 7 : 50;
    }

    private static boolean hasAnySmallFactors(BigInteger bigInteger) {
        BigInteger bigInteger2 = SMALL_PRIMES_PRODUCT;
        if (bigInteger.bitLength() < bigInteger2.bitLength()) {
            bigInteger2 = bigInteger;
            bigInteger = bigInteger2;
        }
        return !BigIntegers.modOddIsCoprimeVar(bigInteger, bigInteger2);
    }

    private static BigInteger validate(BigInteger bigInteger, boolean z) {
        a aVar;
        boolean z2;
        BigInteger bigIntegerModPow;
        if (z) {
            validated.add(bigInteger);
            return bigInteger;
        }
        if ((bigInteger.intValue() & 1) == 0) {
            throw new IllegalArgumentException("RSA modulus is even");
        }
        if (Properties.isOverrideSet("org.bouncycastle.rsa.allow_unsafe_mod")) {
            return bigInteger;
        }
        if (Properties.asInteger("org.bouncycastle.rsa.max_size", ReaderJsonLexerKt.BATCH_SIZE) < bigInteger.bitLength()) {
            throw new IllegalArgumentException("RSA modulus out of range");
        }
        if (hasAnySmallFactors(bigInteger)) {
            throw new IllegalArgumentException("RSA modulus has a small prime factor");
        }
        int iAsInteger = Properties.asInteger("org.bouncycastle.rsa.max_mr_tests", getMRIterations(bigInteger.bitLength() / 2));
        if (iAsInteger > 0) {
            SecureRandom secureRandom = CryptoServicesRegistrar.getSecureRandom();
            BigInteger bigInteger2 = b.f4333a;
            BigInteger bigInteger3 = b.f4334b;
            b.a(bigInteger);
            if (secureRandom == null) {
                throw new IllegalArgumentException("'random' cannot be null");
            }
            if (iAsInteger < 1) {
                throw new IllegalArgumentException("'iterations' must be > 0");
            }
            if (bigInteger.bitLength() != 2) {
                if (bigInteger.testBit(0)) {
                    BigInteger bigIntegerSubtract = bigInteger.subtract(bigInteger2);
                    BigInteger bigIntegerSubtract2 = bigInteger.subtract(bigInteger3);
                    int lowestSetBit = bigIntegerSubtract.getLowestSetBit();
                    BigInteger bigIntegerShiftRight = bigIntegerSubtract.shiftRight(lowestSetBit);
                    int i8 = 0;
                    while (true) {
                        if (i8 >= iAsInteger) {
                            aVar = new a(false);
                            break;
                        }
                        BigInteger bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(bigInteger3, bigIntegerSubtract2, secureRandom);
                        if (bigIntegerCreateRandomInRange.gcd(bigInteger).compareTo(bigInteger2) > 0) {
                            aVar = new a(true);
                            break;
                        }
                        BigInteger bigIntegerModPow2 = bigIntegerCreateRandomInRange.modPow(bigIntegerShiftRight, bigInteger);
                        if (!bigIntegerModPow2.equals(bigInteger2) && !bigIntegerModPow2.equals(bigIntegerSubtract)) {
                            int i9 = 1;
                            while (true) {
                                if (i9 >= lowestSetBit) {
                                    z2 = false;
                                    bigIntegerModPow = bigIntegerModPow2;
                                    break;
                                }
                                bigIntegerModPow = bigIntegerModPow2.modPow(bigInteger3, bigInteger);
                                if (bigIntegerModPow.equals(bigIntegerSubtract)) {
                                    z2 = true;
                                    break;
                                }
                                if (bigIntegerModPow.equals(bigInteger2)) {
                                    z2 = false;
                                    break;
                                }
                                i9++;
                                bigIntegerModPow2 = bigIntegerModPow;
                            }
                            if (!z2) {
                                if (!bigIntegerModPow.equals(bigInteger2)) {
                                    bigIntegerModPow2 = bigIntegerModPow.modPow(bigInteger3, bigInteger);
                                    if (bigIntegerModPow2.equals(bigInteger2)) {
                                        bigIntegerModPow2 = bigIntegerModPow;
                                    }
                                }
                                aVar = bigIntegerModPow2.subtract(bigInteger2).gcd(bigInteger).compareTo(bigInteger2) > 0 ? new a(true) : new a(true);
                            }
                        }
                        i8++;
                    }
                } else {
                    aVar = new a(true);
                }
            } else {
                aVar = new a(false);
            }
            if (!aVar.f4332a) {
                throw new IllegalArgumentException("RSA modulus is not composite");
            }
        }
        validated.add(bigInteger);
        return bigInteger;
    }

    public BigInteger getExponent() {
        return this.exponent;
    }

    public BigInteger getModulus() {
        return this.modulus;
    }

    public RSAKeyParameters(boolean z, BigInteger bigInteger, BigInteger bigInteger2, boolean z2) {
        super(z);
        if (!z && (bigInteger2.intValue() & 1) == 0) {
            throw new IllegalArgumentException("RSA publicExponent is even");
        }
        this.modulus = validated.contains(bigInteger) ? bigInteger : validate(bigInteger, z2);
        this.exponent = bigInteger2;
    }
}
