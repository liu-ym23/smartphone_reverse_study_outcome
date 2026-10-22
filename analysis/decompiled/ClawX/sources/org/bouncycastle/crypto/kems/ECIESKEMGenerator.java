package org.bouncycastle.crypto.kems;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.crypto.SecretWithEncapsulation;
import org.bouncycastle.crypto.constraints.ConstraintUtils;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import p7.d0;
import p7.h;
import p7.n;
import p7.r;
import p7.s;

/* loaded from: classes.dex */
public class ECIESKEMGenerator implements EncapsulatedSecretGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private boolean CofactorMode;
    private boolean OldCofactorMode;
    private boolean SingleHashMode;
    private DerivationFunction kdf;
    private final int keySize;
    private SecureRandom rnd;

    public ECIESKEMGenerator(int i8, DerivationFunction derivationFunction, SecureRandom secureRandom) {
        this.keySize = i8;
        this.kdf = derivationFunction;
        this.rnd = secureRandom;
        this.CofactorMode = false;
        this.OldCofactorMode = false;
        this.SingleHashMode = false;
    }

    private n createBasePointMultiplier() {
        return new s(0);
    }

    public static byte[] deriveKey(boolean z, DerivationFunction derivationFunction, int i8, byte[] bArr, byte[] bArr2) {
        if (!z) {
            byte[] bArrConcatenate = Arrays.concatenate(bArr, bArr2);
            Arrays.fill(bArr2, (byte) 0);
            bArr2 = bArrConcatenate;
        }
        try {
            derivationFunction.init(new KDFParameters(bArr2, null));
            byte[] bArr3 = new byte[i8];
            derivationFunction.generateBytes(bArr3, 0, i8);
            return bArr3;
        } finally {
            Arrays.fill(bArr2, (byte) 0);
        }
    }

    @Override // org.bouncycastle.crypto.EncapsulatedSecretGenerator
    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        if (!(asymmetricKeyParameter instanceof ECPublicKeyParameters)) {
            throw new IllegalArgumentException("EC public key required");
        }
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) asymmetricKeyParameter;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("ECIESKem", ConstraintUtils.bitsOfSecurityFor(eCPublicKeyParameters.getParameters().getCurve()), asymmetricKeyParameter, CryptoServicePurpose.ENCRYPTION));
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        h curve = parameters.getCurve();
        BigInteger n3 = parameters.getN();
        BigInteger h3 = parameters.getH();
        BigInteger bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(ONE, n3, this.rnd);
        r[] rVarArr = {((d0) createBasePointMultiplier()).m(parameters.getG(), bigIntegerCreateRandomInRange), eCPublicKeyParameters.getQ().m(this.OldCofactorMode ? bigIntegerCreateRandomInRange.multiply(h3).mod(n3) : bigIntegerCreateRandomInRange)};
        curve.getClass();
        curve.p(rVarArr, 0, 2, null);
        r rVar = rVarArr[0];
        r rVar2 = rVarArr[1];
        byte[] bArrG = rVar.g(false);
        byte[] bArr = new byte[bArrG.length];
        System.arraycopy(bArrG, 0, bArr, 0, bArrG.length);
        rVar2.b();
        return new SecretWithEncapsulationImpl(deriveKey(this.SingleHashMode, this.kdf, this.keySize, bArrG, rVar2.f4818b.e()), bArr);
    }

    public ECIESKEMGenerator(int i8, DerivationFunction derivationFunction, SecureRandom secureRandom, boolean z, boolean z2, boolean z8) {
        this.kdf = derivationFunction;
        this.rnd = secureRandom;
        this.keySize = i8;
        this.CofactorMode = z;
        if (z) {
            this.OldCofactorMode = false;
        } else {
            this.OldCofactorMode = z2;
        }
        this.SingleHashMode = z8;
    }
}
