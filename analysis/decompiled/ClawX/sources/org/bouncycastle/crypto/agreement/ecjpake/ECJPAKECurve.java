package org.bouncycastle.crypto.agreement.ecjpake;

import java.math.BigInteger;
import p7.d;
import p7.g;
import p7.r;

/* loaded from: classes.dex */
public class ECJPAKECurve {
    private final d curve;

    /* renamed from: g, reason: collision with root package name */
    private final r f4375g;

    public ECJPAKECurve(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7) {
        ECJPAKEUtil.validateNotNull(bigInteger2, "a");
        ECJPAKEUtil.validateNotNull(bigInteger3, "b");
        ECJPAKEUtil.validateNotNull(bigInteger, "q");
        ECJPAKEUtil.validateNotNull(bigInteger4, "n");
        ECJPAKEUtil.validateNotNull(bigInteger5, "h");
        ECJPAKEUtil.validateNotNull(bigInteger6, "g_x");
        ECJPAKEUtil.validateNotNull(bigInteger7, "g_y");
        if (!bigInteger.isProbablePrime(20)) {
            throw new IllegalArgumentException("Field size q must be prime");
        }
        BigInteger bigInteger8 = BigInteger.ZERO;
        if (bigInteger2.compareTo(bigInteger8) < 0 || bigInteger2.compareTo(bigInteger) >= 0) {
            throw new IllegalArgumentException("The parameter 'a' is not in the field [0, q-1]");
        }
        if (bigInteger3.compareTo(bigInteger8) < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
            throw new IllegalArgumentException("The parameter 'b' is not in the field [0, q-1]");
        }
        if (calculateDeterminant(bigInteger, bigInteger2, bigInteger3).equals(bigInteger8)) {
            throw new IllegalArgumentException("The curve is singular, i.e the discriminant is equal to 0 mod q.");
        }
        if (!bigInteger4.isProbablePrime(20)) {
            throw new IllegalArgumentException("The order n must be prime");
        }
        g gVar = new g(bigInteger, bigInteger2, bigInteger3, bigInteger4, bigInteger5, false);
        this.curve = gVar;
        this.f4375g = gVar.t(bigInteger6, bigInteger7);
    }

    private static BigInteger calculateDeterminant(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return bigInteger2.multiply(bigInteger2).mod(bigInteger).multiply(bigInteger2).mod(bigInteger).shiftLeft(2).add(bigInteger3.multiply(bigInteger3).mod(bigInteger).multiply(BigInteger.valueOf(27L))).mod(bigInteger);
    }

    public BigInteger getA() {
        return this.curve.f4798b.t();
    }

    public BigInteger getB() {
        return this.curve.f4799c.t();
    }

    public d getCurve() {
        return this.curve;
    }

    public r getG() {
        return this.f4375g;
    }

    public BigInteger getH() {
        return this.curve.f4800e;
    }

    public BigInteger getN() {
        return this.curve.d;
    }

    public BigInteger getQ() {
        return this.curve.u();
    }

    public ECJPAKECurve(d dVar, r rVar) {
        ECJPAKEUtil.validateNotNull(dVar, "curve");
        ECJPAKEUtil.validateNotNull(rVar, "g");
        ECJPAKEUtil.validateNotNull(dVar.d, "n");
        ECJPAKEUtil.validateNotNull(dVar.f4800e, "h");
        this.curve = dVar;
        this.f4375g = rVar;
    }
}
