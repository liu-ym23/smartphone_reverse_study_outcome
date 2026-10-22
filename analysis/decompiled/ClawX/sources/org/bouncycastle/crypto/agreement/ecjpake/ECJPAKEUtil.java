package org.bouncycastle.crypto.agreement.ecjpake;

import a8.b;
import java.math.BigInteger;
import java.security.SecureRandom;
import m0.f;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.Strings;
import p7.h;
import p7.m;
import p7.r;

/* loaded from: classes.dex */
public class ECJPAKEUtil {
    static final BigInteger ZERO = BigInteger.valueOf(0);
    static final BigInteger ONE = BigInteger.valueOf(1);

    public static r calculateA(r rVar, BigInteger bigInteger) {
        return rVar.m(bigInteger);
    }

    public static r calculateGA(r rVar, r rVar2, r rVar3) {
        return rVar.a(rVar2).a(rVar3);
    }

    public static r calculateGx(r rVar, BigInteger bigInteger) {
        return rVar.m(bigInteger);
    }

    private static BigInteger calculateHashForZeroKnowledgeProof(r rVar, r rVar2, r rVar3, String str, Digest digest) {
        digest.reset();
        updateDigestIncludingSize(digest, rVar);
        updateDigestIncludingSize(digest, rVar2);
        updateDigestIncludingSize(digest, rVar3);
        updateDigestIncludingSize(digest, str);
        byte[] bArr = new byte[digest.getDigestSize()];
        digest.doFinal(bArr, 0);
        return new BigInteger(bArr);
    }

    public static BigInteger calculateKeyingMaterial(BigInteger bigInteger, r rVar, BigInteger bigInteger2, BigInteger bigInteger3, r rVar2) {
        r rVarO = rVar2.u(rVar.m(bigInteger2.multiply(bigInteger3).mod(bigInteger))).m(bigInteger2).o();
        rVarO.b();
        return rVarO.f4818b.t();
    }

    private static byte[] calculateMacKey(BigInteger bigInteger, Digest digest) {
        digest.reset();
        updateDigest(digest, bigInteger);
        updateDigest(digest, "ECJPAKE_KC");
        byte[] bArr = new byte[digest.getDigestSize()];
        digest.doFinal(bArr, 0);
        return bArr;
    }

    public static BigInteger calculateMacTag(String str, String str2, r rVar, r rVar2, r rVar3, r rVar4, BigInteger bigInteger, Digest digest) {
        byte[] bArrCalculateMacKey = calculateMacKey(bigInteger, digest);
        HMac hMac = new HMac(digest);
        byte[] bArr = new byte[hMac.getMacSize()];
        hMac.init(new KeyParameter(bArrCalculateMacKey));
        updateMac(hMac, "KC_1_U");
        updateMac(hMac, str);
        updateMac(hMac, str2);
        updateMac(hMac, rVar);
        updateMac(hMac, rVar2);
        updateMac(hMac, rVar3);
        updateMac(hMac, rVar4);
        hMac.doFinal(bArr, 0);
        Arrays.fill(bArrCalculateMacKey, (byte) 0);
        return new BigInteger(bArr);
    }

    public static BigInteger calculateS(BigInteger bigInteger, byte[] bArr) throws CryptoException {
        BigInteger bigIntegerMod = new BigInteger(1, bArr).mod(bigInteger);
        if (bigIntegerMod.signum() != 0) {
            return bigIntegerMod;
        }
        throw new CryptoException("MUST ensure s is not equal to 0 modulo n");
    }

    public static BigInteger calculateX2s(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return bigInteger2.multiply(bigInteger3).mod(bigInteger);
    }

    public static ECSchnorrZKP calculateZeroKnowledgeProof(r rVar, BigInteger bigInteger, BigInteger bigInteger2, r rVar2, Digest digest, String str, SecureRandom secureRandom) {
        BigInteger bigInteger3 = BigInteger.ONE;
        BigInteger bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(bigInteger3, bigInteger.subtract(bigInteger3), secureRandom);
        r rVarM = rVar.m(bigIntegerCreateRandomInRange);
        return new ECSchnorrZKP(rVarM, bigIntegerCreateRandomInRange.subtract(bigInteger2.multiply(calculateHashForZeroKnowledgeProof(rVar, rVarM, rVar2, str, digest))).mod(bigInteger));
    }

    public static BigInteger generateX1(BigInteger bigInteger, SecureRandom secureRandom) {
        BigInteger bigInteger2 = ONE;
        return BigIntegers.createRandomInRange(bigInteger2, bigInteger.subtract(bigInteger2), secureRandom);
    }

    private static byte[] intToByteArray(int i8) {
        return new byte[]{(byte) (i8 >>> 24), (byte) (i8 >>> 16), (byte) (i8 >>> 8), (byte) i8};
    }

    private static void updateDigest(Digest digest, String str) {
        byte[] uTF8ByteArray = Strings.toUTF8ByteArray(str);
        digest.update(uTF8ByteArray, 0, uTF8ByteArray.length);
        Arrays.fill(uTF8ByteArray, (byte) 0);
    }

    private static void updateDigestIncludingSize(Digest digest, String str) {
        byte[] uTF8ByteArray = Strings.toUTF8ByteArray(str);
        digest.update(intToByteArray(uTF8ByteArray.length), 0, 4);
        digest.update(uTF8ByteArray, 0, uTF8ByteArray.length);
        Arrays.fill(uTF8ByteArray, (byte) 0);
    }

    private static void updateMac(Mac mac, String str) {
        byte[] uTF8ByteArray = Strings.toUTF8ByteArray(str);
        mac.update(uTF8ByteArray, 0, uTF8ByteArray.length);
        Arrays.fill(uTF8ByteArray, (byte) 0);
    }

    public static void validateMacTag(String str, String str2, r rVar, r rVar2, r rVar3, r rVar4, BigInteger bigInteger, Digest digest, BigInteger bigInteger2) throws CryptoException {
        if (!calculateMacTag(str2, str, rVar3, rVar4, rVar, rVar2, bigInteger, digest).equals(bigInteger2)) {
            throw new CryptoException("Partner MacTag validation failed. Therefore, the password, MAC, or digest algorithm of each participant does not match.");
        }
    }

    public static void validateNotNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(b.n(str, " must not be null"));
        }
    }

    public static void validateParticipantIdsDiffer(String str, String str2) throws CryptoException {
        if (str.equals(str2)) {
            throw new CryptoException(f.d("Both participants are using the same participantId (", str, "). This is not allowed. Each participant must use a unique participantId."));
        }
    }

    public static void validateParticipantIdsEqual(String str, String str2) throws CryptoException {
        if (!str.equals(str2)) {
            throw new CryptoException(b.q("Received payload from incorrect partner (", str2, "). Expected to receive payload from ", str, "."));
        }
    }

    public static void validateZeroKnowledgeProof(r rVar, r rVar2, ECSchnorrZKP eCSchnorrZKP, BigInteger bigInteger, BigInteger bigInteger2, h hVar, BigInteger bigInteger3, String str, Digest digest) throws CryptoException {
        r v8 = eCSchnorrZKP.getV();
        BigInteger rVar3 = eCSchnorrZKP.getr();
        BigInteger bigIntegerCalculateHashForZeroKnowledgeProof = calculateHashForZeroKnowledgeProof(rVar, v8, rVar2, str, digest);
        if (rVar2.k()) {
            throw new CryptoException("Zero-knowledge proof validation failed: X cannot equal infinity");
        }
        r rVarO = rVar2.o();
        rVarO.b();
        m mVar = rVarO.f4818b;
        if (mVar.t().signum() >= 0) {
            rVarO.b();
            if (mVar.t().compareTo(bigInteger) < 0 && rVarO.d().t().signum() >= 0 && rVarO.d().t().compareTo(bigInteger) < 0) {
                try {
                    hVar.g(rVar2.g(true));
                    if (rVar2.m(bigInteger3).k()) {
                        throw new CryptoException("Zero-knowledge proof validation failed: Nx cannot be infinity");
                    }
                    if (!v8.c(rVar.m(rVar3).a(rVar2.m(bigIntegerCalculateHashForZeroKnowledgeProof.mod(bigInteger2))))) {
                        throw new CryptoException("Zero-knowledge proof validation failed: V must be a point on the curve");
                    }
                    return;
                } catch (Exception e9) {
                    throw new CryptoException("Zero-knowledge proof validation failed: x does not lie on the curve", e9);
                }
            }
        }
        throw new CryptoException("Zero-knowledge proof validation failed: x and y are not in the field");
    }

    public static BigInteger calculateS(BigInteger bigInteger, char[] cArr) {
        return calculateS(bigInteger, Strings.toUTF8ByteArray(cArr));
    }

    private static void updateDigest(Digest digest, BigInteger bigInteger) {
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(bigInteger);
        digest.update(bArrAsUnsignedByteArray, 0, bArrAsUnsignedByteArray.length);
        Arrays.fill(bArrAsUnsignedByteArray, (byte) 0);
    }

    private static void updateDigestIncludingSize(Digest digest, r rVar) {
        byte[] bArrG = rVar.g(true);
        digest.update(intToByteArray(bArrG.length), 0, 4);
        digest.update(bArrG, 0, bArrG.length);
        Arrays.fill(bArrG, (byte) 0);
    }

    private static void updateMac(Mac mac, r rVar) {
        byte[] bArrG = rVar.g(true);
        mac.update(bArrG, 0, bArrG.length);
        Arrays.fill(bArrG, (byte) 0);
    }

    private static void updateDigest(Digest digest, r rVar) {
        byte[] bArrG = rVar.g(true);
        digest.update(bArrG, 0, bArrG.length);
        Arrays.fill(bArrG, (byte) 0);
    }
}
