package org.bouncycastle.crypto.tls;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.constraints.ConstraintUtils;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.digests.Blake2xsDigest;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public abstract class TlsRsaKeyExchange {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    public static final int PRE_MASTER_SECRET_LENGTH = 48;

    private TlsRsaKeyExchange() {
    }

    private static int caddTo(int i8, int i9, byte[] bArr, byte[] bArr2) {
        int i10 = i9 & 255;
        int i11 = 0;
        for (int i12 = i8 - 1; i12 >= 0; i12--) {
            int i13 = (bArr2[i12] & 255) + (bArr[i12] & i10) + i11;
            bArr2[i12] = (byte) i13;
            i11 = i13 >>> 8;
        }
        return i11;
    }

    private static int checkPkcs1Encoding2(byte[] bArr, int i8, int i9) {
        int i10 = (i8 - i9) - 10;
        int length = bArr.length - i8;
        int length2 = (bArr.length - 1) - i9;
        for (int i11 = 0; i11 < length; i11++) {
            i10 |= -(bArr[i11] & 255);
        }
        int i12 = -((bArr[length] & 255) ^ 2);
        while (true) {
            i12 |= i10;
            length++;
            if (length >= length2) {
                return ((-(bArr[length2] & 255)) | i12) >> 31;
            }
            i10 = (bArr[length] & 255) - 1;
        }
    }

    private static BigInteger convertInput(BigInteger bigInteger, byte[] bArr, int i8, int i9) {
        BigInteger bigIntegerFromUnsignedByteArray = BigIntegers.fromUnsignedByteArray(bArr, i8, i9);
        if (bigIntegerFromUnsignedByteArray.compareTo(bigInteger) < 0) {
            return bigIntegerFromUnsignedByteArray;
        }
        throw new DataLengthException("input too large for RSA cipher.");
    }

    public static byte[] decryptPreMasterSecret(byte[] bArr, int i8, int i9, RSAKeyParameters rSAKeyParameters, int i10, SecureRandom secureRandom) {
        if (bArr == null || i9 < 1 || i9 > getInputLimit(rSAKeyParameters) || i8 < 0 || i8 > bArr.length - i9) {
            throw new IllegalArgumentException("input not a valid EncryptedPreMasterSecret");
        }
        if (!rSAKeyParameters.isPrivate()) {
            throw new IllegalArgumentException("'privateKey' must be an RSA private key");
        }
        BigInteger modulus = rSAKeyParameters.getModulus();
        int iBitLength = modulus.bitLength();
        if (iBitLength < 512) {
            throw new IllegalArgumentException("'privateKey' must be at least 512 bits");
        }
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("RSA", ConstraintUtils.bitsOfSecurityFor(modulus), rSAKeyParameters, CryptoServicePurpose.DECRYPTION));
        if ((i10 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) != i10) {
            throw new IllegalArgumentException("'protocolVersion' must be a 16 bit value");
        }
        SecureRandom secureRandom2 = CryptoServicesRegistrar.getSecureRandom(secureRandom);
        byte[] bArr2 = new byte[48];
        secureRandom2.nextBytes(bArr2);
        try {
            byte[] bArrRsaBlinded = rsaBlinded(rSAKeyParameters, convertInput(modulus, bArr, i8, i9), secureRandom2);
            int length = bArrRsaBlinded.length - 48;
            int iCheckPkcs1Encoding2 = checkPkcs1Encoding2(bArrRsaBlinded, (iBitLength - 1) / 8, 48) | ((-((Pack.bigEndianToShort(bArrRsaBlinded, length) ^ i10) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH)) >> 31);
            for (int i11 = 0; i11 < 48; i11++) {
                bArr2[i11] = (byte) ((bArr2[i11] & iCheckPkcs1Encoding2) | (bArrRsaBlinded[length + i11] & (~iCheckPkcs1Encoding2)));
            }
            Arrays.fill(bArrRsaBlinded, (byte) 0);
        } catch (Exception unused) {
        }
        return bArr2;
    }

    public static int getInputLimit(RSAKeyParameters rSAKeyParameters) {
        return (rSAKeyParameters.getModulus().bitLength() + 7) / 8;
    }

    private static BigInteger rsa(RSAKeyParameters rSAKeyParameters, BigInteger bigInteger) {
        return bigInteger.modPow(rSAKeyParameters.getExponent(), rSAKeyParameters.getModulus());
    }

    private static byte[] rsaBlinded(RSAKeyParameters rSAKeyParameters, BigInteger bigInteger, SecureRandom secureRandom) {
        RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters;
        BigInteger publicExponent;
        BigInteger modulus = rSAKeyParameters.getModulus();
        int iBitLength = (modulus.bitLength() / 8) + 1;
        if (!(rSAKeyParameters instanceof RSAPrivateCrtKeyParameters) || (publicExponent = (rSAPrivateCrtKeyParameters = (RSAPrivateCrtKeyParameters) rSAKeyParameters).getPublicExponent()) == null) {
            return toBytes(rsa(rSAKeyParameters, bigInteger), iBitLength);
        }
        BigInteger bigInteger2 = ONE;
        BigInteger bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(bigInteger2, modulus.subtract(bigInteger2), secureRandom);
        BigInteger bigIntegerModPow = bigIntegerCreateRandomInRange.modPow(publicExponent, modulus);
        BigInteger bigIntegerModOddInverse = BigIntegers.modOddInverse(modulus, bigIntegerCreateRandomInRange);
        BigInteger bigIntegerRsaCrt = rsaCrt(rSAPrivateCrtKeyParameters, bigIntegerModPow.multiply(bigInteger).mod(modulus));
        BigInteger bigIntegerMod = bigIntegerModOddInverse.add(bigInteger2).multiply(bigIntegerRsaCrt).mod(modulus);
        byte[] bytes = toBytes(bigIntegerRsaCrt, iBitLength);
        byte[] bytes2 = toBytes(modulus, iBitLength);
        byte[] bytes3 = toBytes(bigIntegerMod, iBitLength);
        caddTo(iBitLength, subFrom(iBitLength, bytes, bytes3), bytes2, bytes3);
        return bytes3;
    }

    private static BigInteger rsaCrt(RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters, BigInteger bigInteger) {
        BigInteger publicExponent = rSAPrivateCrtKeyParameters.getPublicExponent();
        BigInteger p3 = rSAPrivateCrtKeyParameters.getP();
        BigInteger q8 = rSAPrivateCrtKeyParameters.getQ();
        BigInteger dp = rSAPrivateCrtKeyParameters.getDP();
        BigInteger dq = rSAPrivateCrtKeyParameters.getDQ();
        BigInteger qInv = rSAPrivateCrtKeyParameters.getQInv();
        BigInteger bigIntegerModPow = bigInteger.remainder(p3).modPow(dp, p3);
        BigInteger bigIntegerModPow2 = bigInteger.remainder(q8).modPow(dq, q8);
        BigInteger bigIntegerAdd = bigIntegerModPow.subtract(bigIntegerModPow2).multiply(qInv).mod(p3).multiply(q8).add(bigIntegerModPow2);
        if (bigIntegerAdd.modPow(publicExponent, rSAPrivateCrtKeyParameters.getModulus()).equals(bigInteger)) {
            return bigIntegerAdd;
        }
        throw new IllegalStateException("RSA engine faulty decryption/signing detected");
    }

    private static int subFrom(int i8, byte[] bArr, byte[] bArr2) {
        int i9 = 0;
        for (int i10 = i8 - 1; i10 >= 0; i10--) {
            int i11 = ((bArr2[i10] & 255) - (bArr[i10] & 255)) + i9;
            bArr2[i10] = (byte) i11;
            i9 = i11 >> 8;
        }
        return i9;
    }

    private static byte[] toBytes(BigInteger bigInteger, int i8) {
        byte[] byteArray = bigInteger.toByteArray();
        byte[] bArr = new byte[i8];
        System.arraycopy(byteArray, 0, bArr, i8 - byteArray.length, byteArray.length);
        return bArr;
    }
}
