package org.bouncycastle.crypto.kems;

import java.math.BigInteger;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.EncapsulatedSecretExtractor;
import org.bouncycastle.crypto.params.SAKKEPrivateKeyParameters;
import org.bouncycastle.crypto.params.SAKKEPublicKeyParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import org.tukaani.xz.LZMA2Options;
import p7.d0;
import p7.h;
import p7.r;

/* loaded from: classes.dex */
public class SAKKEKEMExtractor implements EncapsulatedSecretExtractor {
    private final r K_bs;
    private final r P;
    private final r Z_S;
    private final h curve;
    private final Digest digest;
    private final BigInteger identifier;

    /* renamed from: n, reason: collision with root package name */
    private final int f4491n;

    /* renamed from: p, reason: collision with root package name */
    private final BigInteger f4492p;

    /* renamed from: q, reason: collision with root package name */
    private final BigInteger f4493q;

    public SAKKEKEMExtractor(SAKKEPrivateKeyParameters sAKKEPrivateKeyParameters) {
        SAKKEPublicKeyParameters publicParams = sAKKEPrivateKeyParameters.getPublicParams();
        this.curve = publicParams.getCurve();
        BigInteger q8 = publicParams.getQ();
        this.f4493q = q8;
        r point = publicParams.getPoint();
        this.P = point;
        this.f4492p = publicParams.getPrime();
        this.Z_S = publicParams.getZ();
        BigInteger identifier = publicParams.getIdentifier();
        this.identifier = identifier;
        this.K_bs = point.m(identifier.add(sAKKEPrivateKeyParameters.getMasterSecret()).modInverse(q8)).o();
        this.f4491n = publicParams.getN();
        this.digest = publicParams.getDigest();
    }

    public static BigInteger computePairing(r rVar, r rVar2, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = BigInteger.ONE;
        boolean z = false;
        BigInteger[] bigIntegerArrFp2Multiply = {bigInteger3, BigInteger.ZERO};
        BigInteger bigIntegerSubtract = bigInteger2.subtract(bigInteger3);
        int iBitLength = bigIntegerSubtract.bitLength();
        rVar2.b();
        BigInteger bigIntegerT = rVar2.f4818b.t();
        BigInteger bigIntegerT2 = rVar2.d().t();
        rVar.b();
        BigInteger bigIntegerT3 = rVar.f4818b.t();
        BigInteger bigIntegerT4 = rVar.d().t();
        BigInteger bigIntegerValueOf = BigInteger.valueOf(3L);
        int i8 = iBitLength - 2;
        r rVarO = rVar;
        while (i8 >= 0) {
            rVarO.b();
            BigInteger bigIntegerT5 = rVarO.f4818b.t();
            BigInteger bigIntegerT6 = rVarO.d().t();
            boolean z2 = z;
            BigInteger bigIntegerMod = bigIntegerT5.multiply(bigIntegerT5).mod(bigInteger).subtract(BigInteger.ONE).multiply(bigIntegerValueOf).multiply(BigIntegers.modOddInverse(bigInteger, bigIntegerT6.shiftLeft(1))).mod(bigInteger);
            BigInteger[] bigIntegerArrFp2PointSquare = fp2PointSquare(bigIntegerArrFp2Multiply[z2 ? 1 : 0], bigIntegerArrFp2Multiply[1], bigInteger);
            bigIntegerArrFp2Multiply = fp2Multiply(bigIntegerArrFp2PointSquare[z2 ? 1 : 0], bigIntegerArrFp2PointSquare[1], bigIntegerMod.multiply(bigIntegerT.add(bigIntegerT5)).subtract(bigIntegerT6).mod(bigInteger), bigIntegerT2, bigInteger);
            rVarO = rVarO.x().o();
            if (bigIntegerSubtract.testBit(i8)) {
                rVarO.b();
                BigInteger bigIntegerT7 = rVarO.f4818b.t();
                BigInteger bigIntegerT8 = rVarO.d().t();
                bigIntegerArrFp2Multiply = fp2Multiply(bigIntegerArrFp2Multiply[z2 ? 1 : 0], bigIntegerArrFp2Multiply[1], bigIntegerT8.subtract(bigIntegerT4).multiply(BigIntegers.modOddInverse(bigInteger, bigIntegerT7.subtract(bigIntegerT3))).mod(bigInteger).multiply(bigIntegerT.add(bigIntegerT7)).subtract(bigIntegerT8).mod(bigInteger), bigIntegerT2, bigInteger);
                if (i8 > 0) {
                    rVarO = rVarO.a(rVar).o();
                }
            }
            i8--;
            z = z2 ? 1 : 0;
        }
        boolean z8 = z;
        BigInteger[] bigIntegerArrFp2PointSquare2 = fp2PointSquare(bigIntegerArrFp2Multiply[z8 ? 1 : 0], bigIntegerArrFp2Multiply[1], bigInteger);
        BigInteger[] bigIntegerArrFp2PointSquare3 = fp2PointSquare(bigIntegerArrFp2PointSquare2[z8 ? 1 : 0], bigIntegerArrFp2PointSquare2[1], bigInteger);
        return bigIntegerArrFp2PointSquare3[1].multiply(BigIntegers.modOddInverse(bigInteger, bigIntegerArrFp2PointSquare3[z8 ? 1 : 0])).mod(bigInteger);
    }

    public static BigInteger[] fp2Multiply(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        return new BigInteger[]{bigInteger.multiply(bigInteger3).subtract(bigInteger2.multiply(bigInteger4)).mod(bigInteger5), bigInteger.multiply(bigInteger4).add(bigInteger2.multiply(bigInteger3)).mod(bigInteger5)};
    }

    public static BigInteger[] fp2PointSquare(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return new BigInteger[]{bigInteger.add(bigInteger2).multiply(bigInteger.subtract(bigInteger2)).mod(bigInteger3), bigInteger.multiply(bigInteger2).shiftLeft(1).mod(bigInteger3)};
    }

    @Override // org.bouncycastle.crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        r rVarQ;
        r rVarG = this.curve.g(Arrays.copyOfRange(bArr, 0, 257));
        BigInteger bigIntegerFromUnsignedByteArray = BigIntegers.fromUnsignedByteArray(bArr, 257, 16);
        BigInteger bigIntegerComputePairing = computePairing(rVarG, this.K_bs, this.f4492p, this.f4493q);
        BigInteger bigIntegerMod = bigIntegerFromUnsignedByteArray.xor(SAKKEKEMSGenerator.hashToIntegerRange(bigIntegerComputePairing.toByteArray(), BigInteger.ONE.shiftLeft(this.f4491n), this.digest)).mod(this.f4492p);
        BigInteger bigInteger = this.identifier;
        BigInteger bigIntegerHashToIntegerRange = SAKKEKEMSGenerator.hashToIntegerRange(Arrays.concatenate(bigIntegerMod.toByteArray(), bigInteger.toByteArray()), this.f4493q, this.digest);
        BigInteger bigInteger2 = this.curve.d;
        if (bigInteger2 == null) {
            rVarQ = this.P.m(bigInteger).a(this.Z_S).m(bigIntegerHashToIntegerRange);
        } else {
            rVarQ = d0.q(this.P, this.Z_S, bigInteger.multiply(bigIntegerHashToIntegerRange).mod(bigInteger2), bigIntegerHashToIntegerRange);
        }
        if (rVarQ.u(rVarG).k()) {
            return BigIntegers.asUnsignedByteArray(this.f4491n / 8, bigIntegerMod);
        }
        throw new IllegalStateException("Validation of R_bS failed");
    }

    @Override // org.bouncycastle.crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return LZMA2Options.NICE_LEN_MAX;
    }
}
