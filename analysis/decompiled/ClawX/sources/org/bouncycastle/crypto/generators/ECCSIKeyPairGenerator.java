package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECCSIKeyGenerationParameters;
import org.bouncycastle.crypto.params.ECCSIPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECCSIPublicKeyParameters;
import org.bouncycastle.util.BigIntegers;
import p7.r;

/* loaded from: classes.dex */
public class ECCSIKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private r G;
    private Digest digest;
    private ECCSIKeyGenerationParameters parameters;

    /* renamed from: q, reason: collision with root package name */
    private BigInteger f4481q;

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        SecureRandom random = this.parameters.getRandom();
        this.digest.reset();
        byte[] id = this.parameters.getId();
        r kpak = this.parameters.getKPAK();
        BigInteger bigIntegerMod = BigIntegers.createRandomBigInteger(256, random).mod(this.f4481q);
        r rVarO = this.G.m(bigIntegerMod).o();
        byte[] bArrG = this.G.g(false);
        this.digest.update(bArrG, 0, bArrG.length);
        byte[] bArrG2 = kpak.g(false);
        this.digest.update(bArrG2, 0, bArrG2.length);
        this.digest.update(id, 0, id.length);
        byte[] bArrG3 = rVarO.g(false);
        this.digest.update(bArrG3, 0, bArrG3.length);
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new ECCSIPublicKeyParameters(rVarO), (AsymmetricKeyParameter) new ECCSIPrivateKeyParameters(this.parameters.computeSSK(new BigInteger(1, bArr).mod(this.f4481q).multiply(bigIntegerMod)), new ECCSIPublicKeyParameters(rVarO)));
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        ECCSIKeyGenerationParameters eCCSIKeyGenerationParameters = (ECCSIKeyGenerationParameters) keyGenerationParameters;
        this.parameters = eCCSIKeyGenerationParameters;
        this.f4481q = eCCSIKeyGenerationParameters.getQ();
        this.G = this.parameters.getG();
        this.digest = this.parameters.getDigest();
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("ECCSI", this.parameters.getN(), null, CryptoServicePurpose.KEYGEN));
    }
}
