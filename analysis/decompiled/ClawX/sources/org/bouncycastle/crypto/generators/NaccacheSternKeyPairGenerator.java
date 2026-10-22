package org.bouncycastle.crypto.generators;

import a8.b;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Vector;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.constraints.ConstraintUtils;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.NaccacheSternKeyGenerationParameters;
import org.bouncycastle.crypto.params.NaccacheSternKeyParameters;
import org.bouncycastle.crypto.params.NaccacheSternPrivateKeyParameters;
import org.bouncycastle.util.BigIntegers;

/* loaded from: classes.dex */
public class NaccacheSternKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private NaccacheSternKeyGenerationParameters param;
    private static int[] smallPrimes = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557};
    private static final BigInteger ONE = BigInteger.valueOf(1);

    private static Vector findFirstPrimes(int i8) {
        Vector vector = new Vector(i8);
        for (int i9 = 0; i9 != i8; i9++) {
            vector.addElement(BigInteger.valueOf(smallPrimes[i9]));
        }
        return vector;
    }

    private static BigInteger generatePrime(int i8, int i9, SecureRandom secureRandom) {
        BigInteger bigIntegerCreateRandomPrime;
        do {
            bigIntegerCreateRandomPrime = BigIntegers.createRandomPrime(i8, i9, secureRandom);
        } while (bigIntegerCreateRandomPrime.bitLength() != i8);
        return bigIntegerCreateRandomPrime;
    }

    private static int getInt(SecureRandom secureRandom, int i8) {
        int iNextInt;
        int i9;
        if (((-i8) & i8) == i8) {
            return (int) ((i8 * (secureRandom.nextInt() & Integer.MAX_VALUE)) >> 31);
        }
        do {
            iNextInt = secureRandom.nextInt() & Integer.MAX_VALUE;
            i9 = iNextInt % i8;
        } while ((i8 - 1) + (iNextInt - i9) < 0);
        return i9;
    }

    private static Vector permuteList(Vector vector, SecureRandom secureRandom) {
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (int i8 = 0; i8 < vector.size(); i8++) {
            vector3.addElement(vector.elementAt(i8));
        }
        vector2.addElement(vector3.elementAt(0));
        while (true) {
            vector3.removeElementAt(0);
            if (vector3.size() == 0) {
                return vector2;
            }
            vector2.insertElementAt(vector3.elementAt(0), getInt(secureRandom, vector2.size() + 1));
        }
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger bigIntegerGeneratePrime;
        BigInteger bigIntegerAdd;
        BigInteger bigIntegerGeneratePrime2;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigIntegerAdd2;
        boolean z;
        BigInteger bigIntegerMultiply;
        BigInteger bigInteger3;
        BigInteger bigInteger4;
        BigInteger bigInteger5;
        long j4;
        BigInteger bigIntegerMod;
        BigInteger bigInteger6;
        BigInteger bigInteger7;
        int i8;
        PrintStream printStream;
        StringBuilder sb;
        int i9;
        BigInteger bigIntegerCreateRandomPrime;
        SecureRandom secureRandom;
        int i10;
        SecureRandom secureRandom2;
        int i11;
        BigInteger bigInteger8;
        BigInteger bigInteger9;
        int i12;
        int strength = this.param.getStrength();
        SecureRandom random = this.param.getRandom();
        int certainty = this.param.getCertainty();
        boolean zIsDebug = this.param.isDebug();
        if (zIsDebug) {
            System.out.println("Fetching first " + this.param.getCntSmallPrimes() + " primes.");
        }
        Vector vectorPermuteList = permuteList(findFirstPrimes(this.param.getCntSmallPrimes()), random);
        BigInteger bigIntegerMultiply2 = ONE;
        BigInteger bigIntegerMultiply3 = bigIntegerMultiply2;
        for (int i13 = 0; i13 < vectorPermuteList.size() / 2; i13++) {
            bigIntegerMultiply3 = bigIntegerMultiply3.multiply((BigInteger) vectorPermuteList.elementAt(i13));
        }
        for (int size = vectorPermuteList.size() / 2; size < vectorPermuteList.size(); size++) {
            bigIntegerMultiply2 = bigIntegerMultiply2.multiply((BigInteger) vectorPermuteList.elementAt(size));
        }
        BigInteger bigIntegerMultiply4 = bigIntegerMultiply3.multiply(bigIntegerMultiply2);
        int iBitLength = (((strength - bigIntegerMultiply4.bitLength()) - 48) / 2) + 1;
        BigInteger bigIntegerGeneratePrime3 = generatePrime(iBitLength, certainty, random);
        BigInteger bigIntegerGeneratePrime4 = generatePrime(iBitLength, certainty, random);
        if (zIsDebug) {
            System.out.println("generating p and q");
        }
        BigInteger bigIntegerShiftLeft = bigIntegerGeneratePrime3.multiply(bigIntegerMultiply3).shiftLeft(1);
        BigInteger bigIntegerShiftLeft2 = bigIntegerGeneratePrime4.multiply(bigIntegerMultiply2).shiftLeft(1);
        long j8 = 0;
        while (true) {
            j8++;
            int i14 = 24;
            bigIntegerGeneratePrime = generatePrime(24, certainty, random);
            bigIntegerAdd = bigIntegerGeneratePrime.multiply(bigIntegerShiftLeft).add(ONE);
            if (bigIntegerAdd.isProbablePrime(certainty)) {
                while (true) {
                    bigIntegerGeneratePrime2 = generatePrime(i14, certainty, random);
                    if (!bigIntegerGeneratePrime.equals(bigIntegerGeneratePrime2)) {
                        BigInteger bigIntegerMultiply5 = bigIntegerGeneratePrime2.multiply(bigIntegerShiftLeft2);
                        bigInteger = bigIntegerShiftLeft2;
                        bigInteger2 = ONE;
                        bigIntegerAdd2 = bigIntegerMultiply5.add(bigInteger2);
                        if (bigIntegerAdd2.isProbablePrime(certainty)) {
                            break;
                        }
                        bigIntegerShiftLeft2 = bigInteger;
                        i14 = 24;
                    }
                }
                z = zIsDebug;
                if (BigIntegers.modOddIsCoprime(bigIntegerGeneratePrime.multiply(bigIntegerGeneratePrime2), bigIntegerMultiply4)) {
                    BigInteger bigInteger10 = bigIntegerShiftLeft;
                    bigIntegerMultiply = bigIntegerAdd.multiply(bigIntegerAdd2);
                    bigInteger3 = bigInteger10;
                    if (bigIntegerMultiply.bitLength() >= strength) {
                        break;
                    }
                    int i15 = strength;
                    secureRandom2 = random;
                    i11 = certainty;
                    bigInteger8 = bigIntegerGeneratePrime3;
                    bigInteger9 = bigIntegerGeneratePrime4;
                    if (z) {
                        PrintStream printStream2 = System.out;
                        i12 = i15;
                        StringBuilder sbS = b.s(i12, "key size too small. Should be ", " but is actually ");
                        sbS.append(bigIntegerAdd.multiply(bigIntegerAdd2).bitLength());
                        printStream2.println(sbS.toString());
                    } else {
                        i12 = i15;
                    }
                    bigIntegerGeneratePrime3 = bigInteger8;
                    strength = i12;
                    bigIntegerGeneratePrime4 = bigInteger9;
                    bigIntegerShiftLeft2 = bigInteger;
                    zIsDebug = z;
                    bigIntegerShiftLeft = bigInteger3;
                    random = secureRandom2;
                    certainty = i11;
                } else {
                    secureRandom2 = random;
                    i11 = certainty;
                }
            } else {
                bigInteger = bigIntegerShiftLeft2;
                secureRandom2 = random;
                i11 = certainty;
                z = zIsDebug;
            }
            bigInteger3 = bigIntegerShiftLeft;
            bigInteger9 = bigIntegerGeneratePrime4;
            bigInteger8 = bigIntegerGeneratePrime3;
            i12 = strength;
            bigIntegerGeneratePrime3 = bigInteger8;
            strength = i12;
            bigIntegerGeneratePrime4 = bigInteger9;
            bigIntegerShiftLeft2 = bigInteger;
            zIsDebug = z;
            bigIntegerShiftLeft = bigInteger3;
            random = secureRandom2;
            certainty = i11;
        }
        BigInteger bigInteger11 = bigIntegerGeneratePrime4;
        if (z) {
            bigInteger4 = bigIntegerGeneratePrime3;
            System.out.println("needed " + j8 + " tries to generate p and q.");
        } else {
            bigInteger4 = bigIntegerGeneratePrime3;
        }
        BigInteger bigIntegerMultiply6 = bigIntegerAdd.subtract(bigInteger2).multiply(bigIntegerAdd2.subtract(bigInteger2));
        if (z) {
            System.out.println("generating g");
        }
        long j9 = 0;
        while (true) {
            Vector vector = new Vector();
            bigInteger5 = bigIntegerAdd2;
            j4 = j9;
            int i16 = 0;
            while (i16 != vectorPermuteList.size()) {
                BigInteger bigIntegerDivide = bigIntegerMultiply6.divide((BigInteger) vectorPermuteList.elementAt(i16));
                while (true) {
                    j4++;
                    i9 = i16;
                    bigIntegerCreateRandomPrime = BigIntegers.createRandomPrime(strength, certainty, random);
                    secureRandom = random;
                    i10 = certainty;
                    if (bigIntegerCreateRandomPrime.modPow(bigIntegerDivide, bigIntegerMultiply).equals(ONE)) {
                        i16 = i9;
                        random = secureRandom;
                        certainty = i10;
                    }
                }
                vector.addElement(bigIntegerCreateRandomPrime);
                i16 = i9 + 1;
                random = secureRandom;
                certainty = i10;
            }
            SecureRandom secureRandom3 = random;
            int i17 = certainty;
            bigIntegerMod = ONE;
            for (int i18 = 0; i18 < vectorPermuteList.size(); i18++) {
                bigIntegerMod = bigIntegerMod.multiply(((BigInteger) vector.elementAt(i18)).modPow(bigIntegerMultiply4.divide((BigInteger) vectorPermuteList.elementAt(i18)), bigIntegerMultiply)).mod(bigIntegerMultiply);
            }
            int i19 = 0;
            while (true) {
                if (i19 >= vectorPermuteList.size()) {
                    BigInteger bigIntegerModPow = bigIntegerMod.modPow(bigIntegerMultiply6.divide(BigInteger.valueOf(4L)), bigIntegerMultiply);
                    BigInteger bigInteger12 = ONE;
                    if (!bigIntegerModPow.equals(bigInteger12)) {
                        if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigIntegerGeneratePrime), bigIntegerMultiply).equals(bigInteger12)) {
                            if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigIntegerGeneratePrime2), bigIntegerMultiply).equals(bigInteger12)) {
                                bigInteger6 = bigInteger4;
                                if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigInteger6), bigIntegerMultiply).equals(bigInteger12)) {
                                    bigInteger7 = bigInteger11;
                                    if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide(bigInteger7), bigIntegerMultiply).equals(bigInteger12)) {
                                        break;
                                    }
                                    if (z) {
                                        i8 = strength;
                                        System.out.println("g has order phi(n)/b\n g: " + bigIntegerMod);
                                    }
                                } else {
                                    if (z) {
                                        System.out.println("g has order phi(n)/a\n g: " + bigIntegerMod);
                                    }
                                    bigInteger7 = bigInteger11;
                                }
                            } else if (z) {
                                printStream = System.out;
                                sb = new StringBuilder("g has order phi(n)/q'\n g: ");
                                sb.append(bigIntegerMod);
                                printStream.println(sb.toString());
                            }
                        } else if (z) {
                            printStream = System.out;
                            sb = new StringBuilder("g has order phi(n)/p'\n g: ");
                            sb.append(bigIntegerMod);
                            printStream.println(sb.toString());
                        }
                    } else if (z) {
                        printStream = System.out;
                        sb = new StringBuilder("g has order phi(n)/4\n g:");
                        sb.append(bigIntegerMod);
                        printStream.println(sb.toString());
                    }
                } else if (!bigIntegerMod.modPow(bigIntegerMultiply6.divide((BigInteger) vectorPermuteList.elementAt(i19)), bigIntegerMultiply).equals(ONE)) {
                    i19++;
                } else if (z) {
                    System.out.println("g has order phi(n)/" + vectorPermuteList.elementAt(i19) + "\n g: " + bigIntegerMod);
                }
            }
            bigInteger7 = bigInteger11;
            bigInteger6 = bigInteger4;
            i8 = strength;
            bigInteger4 = bigInteger6;
            j9 = j4;
            strength = i8;
            random = secureRandom3;
            certainty = i17;
            bigInteger11 = bigInteger7;
            bigIntegerAdd2 = bigInteger5;
        }
        if (z) {
            System.out.println("needed " + j4 + " tries to generate g");
            System.out.println();
            System.out.println("found new NaccacheStern cipher variables:");
            System.out.println("smallPrimes: " + vectorPermuteList);
            System.out.println("sigma:...... " + bigIntegerMultiply4 + " (" + bigIntegerMultiply4.bitLength() + " bits)");
            PrintStream printStream3 = System.out;
            StringBuilder sb2 = new StringBuilder("a:.......... ");
            sb2.append(bigInteger6);
            printStream3.println(sb2.toString());
            System.out.println("b:.......... " + bigInteger7);
            System.out.println("p':......... " + bigIntegerGeneratePrime);
            System.out.println("q':......... " + bigIntegerGeneratePrime2);
            System.out.println("p:.......... " + bigIntegerAdd);
            System.out.println("q:.......... " + bigInteger5);
            System.out.println("n:.......... " + bigIntegerMultiply);
            System.out.println("phi(n):..... " + bigIntegerMultiply6);
            System.out.println("g:.......... " + bigIntegerMod);
            System.out.println();
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new NaccacheSternKeyParameters(false, bigIntegerMod, bigIntegerMultiply, bigIntegerMultiply4.bitLength()), (AsymmetricKeyParameter) new NaccacheSternPrivateKeyParameters(bigIntegerMod, bigIntegerMultiply, bigIntegerMultiply4.bitLength(), vectorPermuteList, bigIntegerMultiply6));
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (NaccacheSternKeyGenerationParameters) keyGenerationParameters;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("NaccacheStern KeyGen", ConstraintUtils.bitsOfSecurityForFF(keyGenerationParameters.getStrength()), keyGenerationParameters, CryptoServicePurpose.KEYGEN));
    }
}
