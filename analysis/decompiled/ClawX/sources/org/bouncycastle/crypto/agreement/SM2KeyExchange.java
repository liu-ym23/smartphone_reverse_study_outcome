package org.bouncycastle.crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithID;
import org.bouncycastle.crypto.params.SM2KeyExchangePrivateParameters;
import org.bouncycastle.crypto.params.SM2KeyExchangePublicParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;
import p7.d0;
import p7.m;
import p7.r;

/* loaded from: classes.dex */
public class SM2KeyExchange {
    private final Digest digest;
    private ECDomainParameters ecParams;
    private ECPrivateKeyParameters ephemeralKey;
    private r ephemeralPubPoint;
    private boolean initiator;
    private ECPrivateKeyParameters staticKey;
    private r staticPubPoint;
    private byte[] userID;

    /* renamed from: w, reason: collision with root package name */
    private int f4374w;

    public SM2KeyExchange() {
        this(new SM3Digest());
    }

    private byte[] S1(Digest digest, r rVar, byte[] bArr) {
        digest.update((byte) 2);
        addFieldElement(digest, rVar.d());
        digest.update(bArr, 0, bArr.length);
        return digestDoFinal();
    }

    private byte[] S2(Digest digest, r rVar, byte[] bArr) {
        digest.update((byte) 3);
        addFieldElement(digest, rVar.d());
        digest.update(bArr, 0, bArr.length);
        return digestDoFinal();
    }

    private void addFieldElement(Digest digest, m mVar) {
        byte[] bArrE = mVar.e();
        digest.update(bArrE, 0, bArrE.length);
    }

    private void addUserID(Digest digest, byte[] bArr) {
        int length = bArr.length * 8;
        digest.update((byte) (length >>> 8));
        digest.update((byte) length);
        digest.update(bArr, 0, bArr.length);
    }

    private byte[] calculateInnerHash(Digest digest, r rVar, byte[] bArr, byte[] bArr2, r rVar2, r rVar3) {
        rVar.b();
        addFieldElement(digest, rVar.f4818b);
        digest.update(bArr, 0, bArr.length);
        digest.update(bArr2, 0, bArr2.length);
        rVar2.b();
        addFieldElement(digest, rVar2.f4818b);
        addFieldElement(digest, rVar2.d());
        rVar3.b();
        addFieldElement(digest, rVar3.f4818b);
        addFieldElement(digest, rVar3.d());
        return digestDoFinal();
    }

    private r calculateU(SM2KeyExchangePublicParameters sM2KeyExchangePublicParameters) {
        ECDomainParameters parameters = this.staticKey.getParameters();
        r rVarA = d0.a(parameters.getCurve(), sM2KeyExchangePublicParameters.getStaticPublicKey().getQ());
        r rVarA2 = d0.a(parameters.getCurve(), sM2KeyExchangePublicParameters.getEphemeralPublicKey().getQ());
        r rVar = this.ephemeralPubPoint;
        rVar.b();
        BigInteger bigIntegerReduce = reduce(rVar.f4818b.t());
        rVarA2.b();
        BigInteger bigIntegerReduce2 = reduce(rVarA2.f4818b.t());
        BigInteger bigIntegerMod = this.ecParams.getH().multiply(this.staticKey.getD().add(bigIntegerReduce.multiply(this.ephemeralKey.getD()))).mod(this.ecParams.getN());
        return d0.q(rVarA, rVarA2, bigIntegerMod, bigIntegerMod.multiply(bigIntegerReduce2).mod(this.ecParams.getN())).o();
    }

    private static byte[] checkUserID(byte[] bArr) {
        if (bArr.length < 8192) {
            return bArr;
        }
        throw new IllegalArgumentException("SM2 user ID must be less than 2^16 bits long");
    }

    private byte[] digestDoFinal() {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        return bArr;
    }

    private byte[] getZ(Digest digest, byte[] bArr, r rVar) {
        addUserID(digest, bArr);
        addFieldElement(digest, this.ecParams.getCurve().f4798b);
        addFieldElement(digest, this.ecParams.getCurve().f4799c);
        r g6 = this.ecParams.getG();
        g6.b();
        addFieldElement(digest, g6.f4818b);
        addFieldElement(digest, this.ecParams.getG().d());
        rVar.b();
        addFieldElement(digest, rVar.f4818b);
        addFieldElement(digest, rVar.d());
        return digestDoFinal();
    }

    private byte[] kdf(r rVar, byte[] bArr, byte[] bArr2, int i8) {
        Memoable memoable;
        Memoable memoableCopy;
        int digestSize = this.digest.getDigestSize();
        byte[] bArr3 = new byte[Math.max(4, digestSize)];
        int i9 = (i8 + 7) / 8;
        byte[] bArr4 = new byte[i9];
        Digest digest = this.digest;
        if (digest instanceof Memoable) {
            rVar.b();
            addFieldElement(digest, rVar.f4818b);
            addFieldElement(this.digest, rVar.d());
            this.digest.update(bArr, 0, bArr.length);
            this.digest.update(bArr2, 0, bArr2.length);
            memoable = (Memoable) this.digest;
            memoableCopy = memoable.copy();
        } else {
            memoable = null;
            memoableCopy = null;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < i9) {
            if (memoable != null) {
                memoable.reset(memoableCopy);
            } else {
                Digest digest2 = this.digest;
                rVar.b();
                addFieldElement(digest2, rVar.f4818b);
                addFieldElement(this.digest, rVar.d());
                this.digest.update(bArr, 0, bArr.length);
                this.digest.update(bArr2, 0, bArr2.length);
            }
            i11++;
            Pack.intToBigEndian(i11, bArr3, 0);
            this.digest.update(bArr3, 0, 4);
            this.digest.doFinal(bArr3, 0);
            int iMin = Math.min(digestSize, i9 - i10);
            System.arraycopy(bArr3, 0, bArr4, i10, iMin);
            i10 += iMin;
        }
        return bArr4;
    }

    private BigInteger reduce(BigInteger bigInteger) {
        return bigInteger.and(BigInteger.valueOf(1L).shiftLeft(this.f4374w).subtract(BigInteger.valueOf(1L))).setBit(this.f4374w);
    }

    public byte[] calculateKey(int i8, CipherParameters cipherParameters) {
        SM2KeyExchangePublicParameters sM2KeyExchangePublicParameters;
        byte[] bArrCheckUserID;
        if (cipherParameters instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters;
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) parametersWithID.getParameters();
            bArrCheckUserID = checkUserID(parametersWithID.getID());
        } else {
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) cipherParameters;
            bArrCheckUserID = new byte[0];
        }
        byte[] z = getZ(this.digest, this.userID, this.staticPubPoint);
        byte[] z2 = getZ(this.digest, bArrCheckUserID, sM2KeyExchangePublicParameters.getStaticPublicKey().getQ());
        r rVarCalculateU = calculateU(sM2KeyExchangePublicParameters);
        return this.initiator ? kdf(rVarCalculateU, z, z2, i8) : kdf(rVarCalculateU, z2, z, i8);
    }

    public byte[][] calculateKeyWithConfirmation(int i8, byte[] bArr, CipherParameters cipherParameters) {
        SM2KeyExchangePublicParameters sM2KeyExchangePublicParameters;
        byte[] bArrCheckUserID;
        if (cipherParameters instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters;
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) parametersWithID.getParameters();
            bArrCheckUserID = checkUserID(parametersWithID.getID());
        } else {
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) cipherParameters;
            bArrCheckUserID = new byte[0];
        }
        if (this.initiator && bArr == null) {
            throw new IllegalArgumentException("if initiating, confirmationTag must be set");
        }
        byte[] z = getZ(this.digest, this.userID, this.staticPubPoint);
        byte[] z2 = getZ(this.digest, bArrCheckUserID, sM2KeyExchangePublicParameters.getStaticPublicKey().getQ());
        r rVarCalculateU = calculateU(sM2KeyExchangePublicParameters);
        if (!this.initiator) {
            byte[] bArrKdf = kdf(rVarCalculateU, z2, z, i8);
            byte[] bArrCalculateInnerHash = calculateInnerHash(this.digest, rVarCalculateU, z2, z, sM2KeyExchangePublicParameters.getEphemeralPublicKey().getQ(), this.ephemeralPubPoint);
            return new byte[][]{bArrKdf, S1(this.digest, rVarCalculateU, bArrCalculateInnerHash), S2(this.digest, rVarCalculateU, bArrCalculateInnerHash)};
        }
        byte[] bArrKdf2 = kdf(rVarCalculateU, z, z2, i8);
        byte[] bArrCalculateInnerHash2 = calculateInnerHash(this.digest, rVarCalculateU, z, z2, this.ephemeralPubPoint, sM2KeyExchangePublicParameters.getEphemeralPublicKey().getQ());
        if (Arrays.constantTimeAreEqual(S1(this.digest, rVarCalculateU, bArrCalculateInnerHash2), bArr)) {
            return new byte[][]{bArrKdf2, S2(this.digest, rVarCalculateU, bArrCalculateInnerHash2)};
        }
        throw new IllegalStateException("confirmation tag mismatch");
    }

    public void init(CipherParameters cipherParameters) {
        SM2KeyExchangePrivateParameters sM2KeyExchangePrivateParameters;
        if (cipherParameters instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters;
            sM2KeyExchangePrivateParameters = (SM2KeyExchangePrivateParameters) parametersWithID.getParameters();
            this.userID = checkUserID(parametersWithID.getID());
        } else {
            sM2KeyExchangePrivateParameters = (SM2KeyExchangePrivateParameters) cipherParameters;
            this.userID = new byte[0];
        }
        this.initiator = sM2KeyExchangePrivateParameters.isInitiator();
        this.staticKey = sM2KeyExchangePrivateParameters.getStaticPrivateKey();
        this.ephemeralKey = sM2KeyExchangePrivateParameters.getEphemeralPrivateKey();
        this.ecParams = this.staticKey.getParameters();
        this.staticPubPoint = sM2KeyExchangePrivateParameters.getStaticPublicPoint();
        this.ephemeralPubPoint = sM2KeyExchangePrivateParameters.getEphemeralPublicPoint();
        this.f4374w = (this.ecParams.getCurve().l() / 2) - 1;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties("SM2KE", this.staticKey));
    }

    public SM2KeyExchange(Digest digest) {
        this.digest = digest;
    }
}
