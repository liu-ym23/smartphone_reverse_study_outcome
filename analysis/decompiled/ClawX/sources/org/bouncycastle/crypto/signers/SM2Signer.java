package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.digests.SM3Digest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithID;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.BigIntegers;
import org.bouncycastle.util.encoders.Hex;
import p7.a;
import p7.d0;
import p7.m;
import p7.n;
import p7.r;
import p7.s;

/* loaded from: classes.dex */
public class SM2Signer implements Signer, a {
    private final Digest digest;
    private ECKeyParameters ecKey;
    private ECDomainParameters ecParams;
    private final DSAEncoding encoding;
    private final DSAKCalculator kCalculator;
    private r pubPoint;
    private int state;
    private byte[] z;

    public static final class State {
        static final int DATA = 2;
        static final int INIT = 1;
        static final int UNINITIALIZED = 0;

        private State() {
        }
    }

    public SM2Signer() {
        this(StandardDSAEncoding.INSTANCE, new SM3Digest());
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

    private void checkData() {
        int i8 = this.state;
        if (i8 != 1) {
            if (i8 != 2) {
                throw new IllegalStateException("SM2Signer needs to be initialized");
            }
        } else {
            Digest digest = this.digest;
            byte[] bArr = this.z;
            digest.update(bArr, 0, bArr.length);
            this.state = 2;
        }
    }

    private byte[] digestDoFinal() {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        return bArr;
    }

    private byte[] getZ(byte[] bArr) {
        addUserID(this.digest, bArr);
        addFieldElement(this.digest, this.ecParams.getCurve().f4798b);
        addFieldElement(this.digest, this.ecParams.getCurve().f4799c);
        Digest digest = this.digest;
        r g6 = this.ecParams.getG();
        g6.b();
        addFieldElement(digest, g6.f4818b);
        addFieldElement(this.digest, this.ecParams.getG().d());
        Digest digest2 = this.digest;
        r rVar = this.pubPoint;
        rVar.b();
        addFieldElement(digest2, rVar.f4818b);
        addFieldElement(this.digest, this.pubPoint.d());
        return digestDoFinal();
    }

    private boolean verifySignature(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger n3 = this.ecParams.getN();
        BigInteger bigInteger3 = a.f4758b;
        if (bigInteger.compareTo(bigInteger3) < 0 || bigInteger.compareTo(n3) >= 0 || bigInteger2.compareTo(bigInteger3) < 0 || bigInteger2.compareTo(n3) >= 0) {
            return false;
        }
        BigInteger bigIntegerCalculateE = calculateE(n3, digestDoFinal());
        BigInteger bigIntegerMod = bigInteger.add(bigInteger2).mod(n3);
        if (bigIntegerMod.equals(a.f4757a)) {
            return false;
        }
        r rVarO = d0.q(this.ecParams.getG(), ((ECPublicKeyParameters) this.ecKey).getQ(), bigInteger2, bigIntegerMod).o();
        if (rVarO.k()) {
            return false;
        }
        rVarO.b();
        return bigIntegerCalculateE.add(rVarO.f4818b.t()).mod(n3).equals(bigInteger);
    }

    public BigInteger calculateE(BigInteger bigInteger, byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public n createBasePointMultiplier() {
        return new s(0);
    }

    @Override // org.bouncycastle.crypto.Signer
    public byte[] generateSignature() {
        checkData();
        byte[] bArrDigestDoFinal = digestDoFinal();
        BigInteger n3 = this.ecParams.getN();
        BigInteger bigIntegerCalculateE = calculateE(n3, bArrDigestDoFinal);
        BigInteger d = ((ECPrivateKeyParameters) this.ecKey).getD();
        n nVarCreateBasePointMultiplier = createBasePointMultiplier();
        while (true) {
            BigInteger bigIntegerNextK = this.kCalculator.nextK();
            r rVarO = ((d0) nVarCreateBasePointMultiplier).m(this.ecParams.getG(), bigIntegerNextK).o();
            rVarO.b();
            BigInteger bigIntegerMod = bigIntegerCalculateE.add(rVarO.f4818b.t()).mod(n3);
            BigInteger bigInteger = a.f4757a;
            if (!bigIntegerMod.equals(bigInteger) && !bigIntegerMod.add(bigIntegerNextK).equals(n3)) {
                BigInteger bigIntegerMod2 = BigIntegers.modOddInverse(n3, d.add(a.f4758b)).multiply(bigIntegerNextK.subtract(bigIntegerMod.multiply(d)).mod(n3)).mod(n3);
                if (!bigIntegerMod2.equals(bigInteger)) {
                    try {
                        try {
                            return this.encoding.encode(this.ecParams.getN(), bigIntegerMod, bigIntegerMod2);
                        } catch (Exception e9) {
                            throw new CryptoException("unable to encode signature: " + e9.getMessage(), e9);
                        }
                    } finally {
                        reset();
                    }
                }
            }
        }
    }

    @Override // org.bouncycastle.crypto.Signer
    public void init(boolean z, CipherParameters cipherParameters) {
        byte[] bArrDecodeStrict;
        r q8;
        SecureRandom random;
        if (cipherParameters instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters;
            CipherParameters parameters = parametersWithID.getParameters();
            byte[] id = parametersWithID.getID();
            if (id.length >= 8192) {
                throw new IllegalArgumentException("SM2 user ID must be less than 2^16 bits long");
            }
            bArrDecodeStrict = id;
            cipherParameters = parameters;
        } else {
            bArrDecodeStrict = Hex.decodeStrict("31323334353637383132333435363738");
        }
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                CipherParameters parameters2 = parametersWithRandom.getParameters();
                random = parametersWithRandom.getRandom();
                cipherParameters = parameters2;
            } else {
                random = null;
            }
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) cipherParameters;
            this.ecKey = eCPrivateKeyParameters;
            this.ecParams = eCPrivateKeyParameters.getParameters();
            BigInteger d = eCPrivateKeyParameters.getD();
            BigInteger n3 = this.ecParams.getN();
            BigInteger bigInteger = a.f4758b;
            if (d.compareTo(bigInteger) < 0 || d.compareTo(n3.subtract(bigInteger)) >= 0) {
                throw new IllegalArgumentException("SM2 private key out of range");
            }
            this.kCalculator.init(n3, CryptoServicesRegistrar.getSecureRandom(random));
            q8 = ((d0) createBasePointMultiplier()).m(this.ecParams.getG(), d).o();
        } else {
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) cipherParameters;
            this.ecKey = eCPublicKeyParameters;
            this.ecParams = eCPublicKeyParameters.getParameters();
            q8 = eCPublicKeyParameters.getQ();
        }
        this.pubPoint = q8;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties("ECNR", this.ecKey, z));
        this.digest.reset();
        this.z = getZ(bArrDecodeStrict);
        this.state = 1;
    }

    @Override // org.bouncycastle.crypto.Signer
    public void reset() {
        int i8 = this.state;
        if (i8 != 1) {
            if (i8 != 2) {
                throw new IllegalStateException("SM2Signer needs to be initialized");
            }
            this.digest.reset();
            this.state = 1;
        }
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte b9) {
        checkData();
        this.digest.update(b9);
    }

    public SM2Signer(Digest digest) {
        this(StandardDSAEncoding.INSTANCE, digest);
    }

    @Override // org.bouncycastle.crypto.Signer
    public void update(byte[] bArr, int i8, int i9) {
        checkData();
        this.digest.update(bArr, i8, i9);
    }

    public SM2Signer(DSAEncoding dSAEncoding) {
        this.kCalculator = new RandomDSAKCalculator();
        this.state = 0;
        this.encoding = dSAEncoding;
        this.digest = new SM3Digest();
    }

    public SM2Signer(DSAEncoding dSAEncoding, Digest digest) {
        this.kCalculator = new RandomDSAKCalculator();
        this.state = 0;
        this.encoding = dSAEncoding;
        this.digest = digest;
    }

    @Override // org.bouncycastle.crypto.Signer
    public boolean verifySignature(byte[] bArr) {
        checkData();
        try {
            BigInteger[] bigIntegerArrDecode = this.encoding.decode(this.ecParams.getN(), bArr);
            return verifySignature(bigIntegerArrDecode[0], bigIntegerArrDecode[1]);
        } catch (Exception unused) {
            return false;
        } finally {
            reset();
        }
    }
}
