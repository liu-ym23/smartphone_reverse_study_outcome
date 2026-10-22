package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DSAExt;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import p7.d0;
import p7.h;
import p7.m;
import p7.n;
import p7.r;
import p7.s;

/* loaded from: classes.dex */
public class DSTU4145Signer implements DSAExt {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private ECKeyParameters key;
    private SecureRandom random;

    private static BigInteger fieldElement2Integer(BigInteger bigInteger, m mVar) {
        return truncate(mVar.t(), bigInteger.bitLength() - 1);
    }

    private static BigInteger generateRandomInteger(BigInteger bigInteger, SecureRandom secureRandom) {
        return BigIntegers.createRandomBigInteger(bigInteger.bitLength() - 1, secureRandom);
    }

    private static m hash2FieldElement(h hVar, byte[] bArr) {
        return hVar.j(truncate(new BigInteger(1, Arrays.reverse(bArr)), hVar.l()));
    }

    private static BigInteger truncate(BigInteger bigInteger, int i8) {
        return bigInteger.bitLength() > i8 ? bigInteger.mod(ONE.shiftLeft(i8)) : bigInteger;
    }

    public n createBasePointMultiplier() {
        return new s(0);
    }

    @Override // org.bouncycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        ECDomainParameters parameters = this.key.getParameters();
        h curve = parameters.getCurve();
        m mVarHash2FieldElement = hash2FieldElement(curve, bArr);
        if (mVarHash2FieldElement.i()) {
            mVarHash2FieldElement = curve.j(ONE);
        }
        BigInteger n3 = parameters.getN();
        BigInteger d = ((ECPrivateKeyParameters) this.key).getD();
        n nVarCreateBasePointMultiplier = createBasePointMultiplier();
        while (true) {
            BigInteger bigIntegerGenerateRandomInteger = generateRandomInteger(n3, this.random);
            r rVarO = ((d0) nVarCreateBasePointMultiplier).m(parameters.getG(), bigIntegerGenerateRandomInteger).o();
            rVarO.b();
            m mVar = rVarO.f4818b;
            if (!mVar.i()) {
                BigInteger bigIntegerFieldElement2Integer = fieldElement2Integer(n3, mVarHash2FieldElement.j(mVar));
                if (bigIntegerFieldElement2Integer.signum() != 0) {
                    BigInteger bigIntegerMod = bigIntegerFieldElement2Integer.multiply(d).add(bigIntegerGenerateRandomInteger).mod(n3);
                    if (bigIntegerMod.signum() != 0) {
                        return new BigInteger[]{bigIntegerFieldElement2Integer, bigIntegerMod};
                    }
                } else {
                    continue;
                }
            }
        }
    }

    @Override // org.bouncycastle.crypto.DSAExt
    public BigInteger getOrder() {
        return this.key.getParameters().getN();
    }

    @Override // org.bouncycastle.crypto.DSA
    public void init(boolean z, CipherParameters cipherParameters) {
        ECKeyParameters eCKeyParameters;
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.random = parametersWithRandom.getRandom();
                cipherParameters = parametersWithRandom.getParameters();
            } else {
                this.random = CryptoServicesRegistrar.getSecureRandom();
            }
            eCKeyParameters = (ECPrivateKeyParameters) cipherParameters;
        } else {
            eCKeyParameters = (ECPublicKeyParameters) cipherParameters;
        }
        this.key = eCKeyParameters;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties("DSTU4145", this.key, z));
    }

    @Override // org.bouncycastle.crypto.DSA
    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger.signum() <= 0 || bigInteger2.signum() <= 0) {
            return false;
        }
        ECDomainParameters parameters = this.key.getParameters();
        BigInteger n3 = parameters.getN();
        if (bigInteger.compareTo(n3) >= 0 || bigInteger2.compareTo(n3) >= 0) {
            return false;
        }
        h curve = parameters.getCurve();
        m mVarHash2FieldElement = hash2FieldElement(curve, bArr);
        if (mVarHash2FieldElement.i()) {
            mVarHash2FieldElement = curve.j(ONE);
        }
        r rVarO = d0.q(parameters.getG(), ((ECPublicKeyParameters) this.key).getQ(), bigInteger2, bigInteger).o();
        if (rVarO.k()) {
            return false;
        }
        rVarO.b();
        return fieldElement2Integer(n3, mVarHash2FieldElement.j(rVarO.f4818b)).compareTo(bigInteger) == 0;
    }
}
