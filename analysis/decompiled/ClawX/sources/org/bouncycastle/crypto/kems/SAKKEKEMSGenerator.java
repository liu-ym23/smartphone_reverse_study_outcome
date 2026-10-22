package org.bouncycastle.crypto.kems;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.crypto.SecretWithEncapsulation;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.SAKKEPublicKeyParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import p7.d0;
import p7.h;
import p7.r;

/* loaded from: classes.dex */
public class SAKKEKEMSGenerator implements EncapsulatedSecretGenerator {
    private final SecureRandom random;

    public SAKKEKEMSGenerator(SecureRandom secureRandom) {
        this.random = secureRandom;
    }

    public static BigInteger hashToIntegerRange(byte[] bArr, BigInteger bigInteger, Digest digest) {
        int digestSize = digest.getDigestSize();
        byte[] bArr2 = new byte[digestSize];
        digest.update(bArr, 0, bArr.length);
        digest.doFinal(bArr2, 0);
        int digestSize2 = digest.getDigestSize();
        byte[] bArr3 = new byte[digestSize2];
        int iBitLength = bigInteger.bitLength() >> 8;
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        int digestSize3 = digest.getDigestSize();
        byte[] bArr4 = new byte[digestSize3];
        for (int i8 = 0; i8 <= iBitLength; i8++) {
            digest.update(bArr3, 0, digestSize2);
            digest.doFinal(bArr3, 0);
            digest.update(bArr3, 0, digestSize2);
            digest.update(bArr2, 0, digestSize);
            digest.doFinal(bArr4, 0);
            bigIntegerAdd = bigIntegerAdd.shiftLeft(digestSize3 * 8).add(new BigInteger(1, bArr4));
        }
        return bigIntegerAdd.mod(bigInteger);
    }

    @Override // org.bouncycastle.crypto.EncapsulatedSecretGenerator
    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        SAKKEPublicKeyParameters sAKKEPublicKeyParameters = (SAKKEPublicKeyParameters) asymmetricKeyParameter;
        r z = sAKKEPublicKeyParameters.getZ();
        BigInteger identifier = sAKKEPublicKeyParameters.getIdentifier();
        BigInteger prime = sAKKEPublicKeyParameters.getPrime();
        BigInteger q8 = sAKKEPublicKeyParameters.getQ();
        BigInteger g6 = sAKKEPublicKeyParameters.getG();
        int n3 = sAKKEPublicKeyParameters.getN();
        h curve = sAKKEPublicKeyParameters.getCurve();
        r point = sAKKEPublicKeyParameters.getPoint();
        Digest digest = sAKKEPublicKeyParameters.getDigest();
        BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(n3, this.random);
        BigInteger bigIntegerHashToIntegerRange = hashToIntegerRange(Arrays.concatenate(bigIntegerCreateRandomBigInteger.toByteArray(), identifier.toByteArray()), q8, digest);
        BigInteger bigInteger = curve.d;
        r rVarO = (bigInteger == null ? point.m(identifier).a(z).m(bigIntegerHashToIntegerRange) : d0.q(point, z, identifier.multiply(bigIntegerHashToIntegerRange).mod(bigInteger), bigIntegerHashToIntegerRange)).o();
        BigInteger bigInteger2 = BigInteger.ONE;
        r rVarD = curve.d(bigInteger2, g6);
        BigInteger bigInteger3 = bigInteger2;
        BigInteger bigInteger4 = g6;
        for (int iBitLength = bigIntegerHashToIntegerRange.bitLength() - 2; iBitLength >= 0; iBitLength--) {
            BigInteger[] bigIntegerArrFp2PointSquare = SAKKEKEMExtractor.fp2PointSquare(bigInteger3, bigInteger4, prime);
            rVarD = rVarD.w(2);
            BigInteger bigInteger5 = bigIntegerArrFp2PointSquare[0];
            BigInteger bigInteger6 = bigIntegerArrFp2PointSquare[1];
            if (bigIntegerHashToIntegerRange.testBit(iBitLength)) {
                BigInteger[] bigIntegerArrFp2Multiply = SAKKEKEMExtractor.fp2Multiply(bigInteger5, bigInteger6, bigInteger2, g6, prime);
                bigInteger5 = bigIntegerArrFp2Multiply[0];
                bigInteger6 = bigIntegerArrFp2Multiply[1];
            }
            BigInteger bigInteger7 = bigInteger5;
            bigInteger4 = bigInteger6;
            bigInteger3 = bigInteger7;
        }
        return new SecretWithEncapsulationImpl(BigIntegers.asUnsignedByteArray(n3 / 8, bigIntegerCreateRandomBigInteger), Arrays.concatenate(rVarO.g(false), BigIntegers.asUnsignedByteArray(16, bigIntegerCreateRandomBigInteger.xor(hashToIntegerRange(bigInteger4.multiply(BigIntegers.modOddInverse(prime, bigInteger3)).mod(prime).toByteArray(), BigInteger.ONE.shiftLeft(n3), digest)))));
    }
}
