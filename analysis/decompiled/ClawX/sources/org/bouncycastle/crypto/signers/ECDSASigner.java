package org.bouncycastle.crypto.signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DSAExt;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.util.BigIntegers;
import p7.a;
import p7.d0;
import p7.h;
import p7.m;
import p7.n;
import p7.r;
import p7.s;

/* loaded from: classes.dex */
public class ECDSASigner implements a, DSAExt {
    private final DSAKCalculator kCalculator;
    private ECKeyParameters key;
    private SecureRandom random;

    public ECDSASigner() {
        this.kCalculator = new RandomDSAKCalculator();
    }

    public BigInteger calculateE(BigInteger bigInteger, byte[] bArr) {
        int iBitLength = bigInteger.bitLength();
        int length = bArr.length * 8;
        BigInteger bigInteger2 = new BigInteger(1, bArr);
        return iBitLength < length ? bigInteger2.shiftRight(length - iBitLength) : bigInteger2;
    }

    public n createBasePointMultiplier() {
        return new s(0);
    }

    @Override // org.bouncycastle.crypto.DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        ECDomainParameters parameters = this.key.getParameters();
        BigInteger n3 = parameters.getN();
        BigInteger bigIntegerCalculateE = calculateE(n3, bArr);
        BigInteger d = ((ECPrivateKeyParameters) this.key).getD();
        if (this.kCalculator.isDeterministic()) {
            this.kCalculator.init(n3, d, bArr);
        } else {
            this.kCalculator.init(n3, this.random);
        }
        n nVarCreateBasePointMultiplier = createBasePointMultiplier();
        while (true) {
            BigInteger bigIntegerNextK = this.kCalculator.nextK();
            r rVarO = ((d0) nVarCreateBasePointMultiplier).m(parameters.getG(), bigIntegerNextK).o();
            rVarO.b();
            BigInteger bigIntegerMod = rVarO.f4818b.t().mod(n3);
            BigInteger bigInteger = a.f4757a;
            if (!bigIntegerMod.equals(bigInteger)) {
                BigInteger bigIntegerMod2 = BigIntegers.modOddInverse(n3, bigIntegerNextK).multiply(bigIntegerCalculateE.add(d.multiply(bigIntegerMod))).mod(n3);
                if (!bigIntegerMod2.equals(bigInteger)) {
                    return new BigInteger[]{bigIntegerMod, bigIntegerMod2};
                }
            }
        }
    }

    public m getDenominator(int i8, r rVar) {
        if (i8 != 1) {
            if (i8 == 2 || i8 == 3 || i8 == 4) {
                return rVar.i().o();
            }
            if (i8 != 6 && i8 != 7) {
                return null;
            }
        }
        return rVar.i();
    }

    @Override // org.bouncycastle.crypto.DSAExt
    public BigInteger getOrder() {
        return this.key.getParameters().getN();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    @Override // org.bouncycastle.crypto.DSA
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void init(boolean r3, org.bouncycastle.crypto.CipherParameters r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L1a
            boolean r0 = r4 instanceof org.bouncycastle.crypto.params.ParametersWithRandom
            if (r0 == 0) goto L15
            org.bouncycastle.crypto.params.ParametersWithRandom r4 = (org.bouncycastle.crypto.params.ParametersWithRandom) r4
            org.bouncycastle.crypto.CipherParameters r0 = r4.getParameters()
            org.bouncycastle.crypto.params.ECPrivateKeyParameters r0 = (org.bouncycastle.crypto.params.ECPrivateKeyParameters) r0
            r2.key = r0
            java.security.SecureRandom r4 = r4.getRandom()
            goto L1e
        L15:
            org.bouncycastle.crypto.params.ECPrivateKeyParameters r4 = (org.bouncycastle.crypto.params.ECPrivateKeyParameters) r4
        L17:
            r2.key = r4
            goto L1d
        L1a:
            org.bouncycastle.crypto.params.ECPublicKeyParameters r4 = (org.bouncycastle.crypto.params.ECPublicKeyParameters) r4
            goto L17
        L1d:
            r4 = 0
        L1e:
            java.lang.String r0 = "ECDSA"
            org.bouncycastle.crypto.params.ECKeyParameters r1 = r2.key
            org.bouncycastle.crypto.CryptoServiceProperties r0 = org.bouncycastle.crypto.signers.Utils.getDefaultProperties(r0, r1, r3)
            org.bouncycastle.crypto.CryptoServicesRegistrar.checkConstraints(r0)
            if (r3 == 0) goto L35
            org.bouncycastle.crypto.signers.DSAKCalculator r3 = r2.kCalculator
            boolean r3 = r3.isDeterministic()
            if (r3 != 0) goto L35
            r3 = 1
            goto L36
        L35:
            r3 = 0
        L36:
            java.security.SecureRandom r3 = r2.initSecureRandom(r3, r4)
            r2.random = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.signers.ECDSASigner.init(boolean, org.bouncycastle.crypto.CipherParameters):void");
    }

    public SecureRandom initSecureRandom(boolean z, SecureRandom secureRandom) {
        if (z) {
            return CryptoServicesRegistrar.getSecureRandom(secureRandom);
        }
        return null;
    }

    @Override // org.bouncycastle.crypto.DSA
    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3;
        m denominator;
        ECDomainParameters parameters = this.key.getParameters();
        BigInteger n3 = parameters.getN();
        BigInteger bigIntegerCalculateE = calculateE(n3, bArr);
        BigInteger bigInteger4 = a.f4758b;
        if (bigInteger.compareTo(bigInteger4) < 0 || bigInteger.compareTo(n3) >= 0 || bigInteger2.compareTo(bigInteger4) < 0 || bigInteger2.compareTo(n3) >= 0) {
            return false;
        }
        BigInteger bigIntegerModOddInverseVar = BigIntegers.modOddInverseVar(n3, bigInteger2);
        r rVarQ = d0.q(parameters.getG(), ((ECPublicKeyParameters) this.key).getQ(), bigIntegerCalculateE.multiply(bigIntegerModOddInverseVar).mod(n3), bigInteger.multiply(bigIntegerModOddInverseVar).mod(n3));
        if (rVarQ.k()) {
            return false;
        }
        h hVar = rVarQ.f4817a;
        if (hVar == null || (bigInteger3 = hVar.f4800e) == null || bigInteger3.compareTo(a.f4761f) > 0 || (denominator = getDenominator(hVar.f4801f, rVarQ)) == null || denominator.i()) {
            r rVarO = rVarQ.o();
            rVarO.b();
            return rVarO.f4818b.t().mod(n3).equals(bigInteger);
        }
        m mVar = rVarQ.f4818b;
        while (hVar.o(bigInteger)) {
            if (hVar.j(bigInteger).j(denominator).equals(mVar)) {
                return true;
            }
            bigInteger = bigInteger.add(n3);
        }
        return false;
    }

    public ECDSASigner(DSAKCalculator dSAKCalculator) {
        this.kCalculator = dSAKCalculator;
    }
}
