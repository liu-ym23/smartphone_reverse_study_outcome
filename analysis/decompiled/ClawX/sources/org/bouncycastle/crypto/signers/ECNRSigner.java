package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DSAExt;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.crypto.params.ECKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.BigIntegers;
import p7.a;
import p7.d0;
import p7.r;

/* loaded from: classes.dex */
public class ECNRSigner implements DSAExt {
    private boolean forSigning;
    private ECKeyParameters key;
    private SecureRandom random;

    private BigInteger extractT(ECPublicKeyParameters eCPublicKeyParameters, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger n3 = eCPublicKeyParameters.getParameters().getN();
        if (bigInteger.compareTo(a.f4758b) < 0 || bigInteger.compareTo(n3) >= 0 || bigInteger2.compareTo(a.f4757a) < 0 || bigInteger2.compareTo(n3) >= 0) {
            return null;
        }
        r rVarO = d0.q(eCPublicKeyParameters.getParameters().getG(), eCPublicKeyParameters.getQ(), bigInteger2, bigInteger).o();
        if (rVarO.k()) {
            return null;
        }
        rVarO.b();
        return bigInteger.subtract(rVarO.f4818b.t()).mod(n3);
    }

    @Override // org.bouncycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair;
        BigInteger bigIntegerMod;
        if (!this.forSigning) {
            throw new IllegalStateException("not initialised for signing");
        }
        BigInteger order = getOrder();
        BigInteger bigInteger = new BigInteger(1, bArr);
        ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) this.key;
        if (bigInteger.compareTo(order) >= 0) {
            throw new DataLengthException("input too large for ECNR key");
        }
        do {
            ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
            eCKeyPairGenerator.init(new ECKeyGenerationParameters(eCPrivateKeyParameters.getParameters(), this.random));
            asymmetricCipherKeyPairGenerateKeyPair = eCKeyPairGenerator.generateKeyPair();
            r q8 = ((ECPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()).getQ();
            q8.b();
            bigIntegerMod = q8.f4818b.t().add(bigInteger).mod(order);
        } while (bigIntegerMod.equals(a.f4757a));
        return new BigInteger[]{bigIntegerMod, ((ECPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()).getD().subtract(bigIntegerMod.multiply(eCPrivateKeyParameters.getD())).mod(order)};
    }

    @Override // org.bouncycastle.crypto.DSAExt
    public BigInteger getOrder() {
        return this.key.getParameters().getN();
    }

    public byte[] getRecoveredMessage(BigInteger bigInteger, BigInteger bigInteger2) {
        if (this.forSigning) {
            throw new IllegalStateException("not initialised for verifying/recovery");
        }
        BigInteger bigIntegerExtractT = extractT((ECPublicKeyParameters) this.key, bigInteger, bigInteger2);
        if (bigIntegerExtractT != null) {
            return BigIntegers.asUnsignedByteArray(bigIntegerExtractT);
        }
        return null;
    }

    @Override // org.bouncycastle.crypto.DSA
    public void init(boolean z, CipherParameters cipherParameters) {
        this.forSigning = z;
        SecureRandom random = null;
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                random = parametersWithRandom.getRandom();
                cipherParameters = parametersWithRandom.getParameters();
            }
            this.key = (ECPrivateKeyParameters) cipherParameters;
            this.random = CryptoServicesRegistrar.getSecureRandom(random);
        } else {
            this.key = (ECPublicKeyParameters) cipherParameters;
            this.random = null;
        }
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties("ECNR", this.key, z));
    }

    @Override // org.bouncycastle.crypto.DSA
    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        if (this.forSigning) {
            throw new IllegalStateException("not initialised for verifying");
        }
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) this.key;
        BigInteger n3 = eCPublicKeyParameters.getParameters().getN();
        int iBitLength = n3.bitLength();
        BigInteger bigInteger3 = new BigInteger(1, bArr);
        if (bigInteger3.bitLength() > iBitLength) {
            throw new DataLengthException("input too large for ECNR key.");
        }
        BigInteger bigIntegerExtractT = extractT(eCPublicKeyParameters, bigInteger, bigInteger2);
        return bigIntegerExtractT != null && bigIntegerExtractT.equals(bigInteger3.mod(n3));
    }
}
