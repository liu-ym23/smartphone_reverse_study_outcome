package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.BigIntegers;
import p7.a;
import p7.h;
import p7.r;

/* loaded from: classes.dex */
public class ECDomainParameters implements a {
    private final r G;
    private final h curve;

    /* renamed from: h, reason: collision with root package name */
    private final BigInteger f4555h;
    private BigInteger hInv;

    /* renamed from: n, reason: collision with root package name */
    private final BigInteger f4556n;
    private final byte[] seed;

    public ECDomainParameters(X9ECParameters x9ECParameters) {
        this(x9ECParameters.getCurve(), x9ECParameters.getG(), x9ECParameters.getN(), x9ECParameters.getH(), x9ECParameters.getSeed());
    }

    public static r validatePublicPoint(h hVar, r rVar) {
        if (rVar == null) {
            throw new NullPointerException("Point cannot be null");
        }
        if (!hVar.i(rVar.f4817a)) {
            throw new IllegalArgumentException("Point must be on the same curve");
        }
        r rVarO = hVar.n(rVar).o();
        if (rVarO.k()) {
            throw new IllegalArgumentException("Point at infinity");
        }
        if (rVarO.j(false, true)) {
            return rVarO;
        }
        throw new IllegalArgumentException("Point not on curve");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ECDomainParameters)) {
            return false;
        }
        ECDomainParameters eCDomainParameters = (ECDomainParameters) obj;
        return this.curve.i(eCDomainParameters.curve) && this.G.c(eCDomainParameters.G) && this.f4556n.equals(eCDomainParameters.f4556n);
    }

    public h getCurve() {
        return this.curve;
    }

    public r getG() {
        return this.G;
    }

    public BigInteger getH() {
        return this.f4555h;
    }

    public synchronized BigInteger getHInv() {
        try {
            if (this.hInv == null) {
                this.hInv = BigIntegers.modOddInverseVar(this.f4556n, this.f4555h);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.hInv;
    }

    public BigInteger getN() {
        return this.f4556n;
    }

    public byte[] getSeed() {
        return Arrays.clone(this.seed);
    }

    public int hashCode() {
        return this.f4556n.hashCode() ^ ((((this.curve.hashCode() ^ 1028) * 257) ^ this.G.hashCode()) * 257);
    }

    public BigInteger validatePrivateScalar(BigInteger bigInteger) {
        if (bigInteger == null) {
            throw new NullPointerException("Scalar cannot be null");
        }
        if (bigInteger.compareTo(a.f4758b) < 0 || bigInteger.compareTo(getN()) >= 0) {
            throw new IllegalArgumentException("Scalar is not in the interval [1, n - 1]");
        }
        return bigInteger;
    }

    public ECDomainParameters(h hVar, r rVar, BigInteger bigInteger) {
        this(hVar, rVar, bigInteger, a.f4758b, null);
    }

    public ECDomainParameters(h hVar, r rVar, BigInteger bigInteger, BigInteger bigInteger2) {
        this(hVar, rVar, bigInteger, bigInteger2, null);
    }

    public ECDomainParameters(h hVar, r rVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        this.hInv = null;
        if (hVar == null) {
            throw new NullPointerException("curve");
        }
        if (bigInteger == null) {
            throw new NullPointerException("n");
        }
        this.curve = hVar;
        this.G = validatePublicPoint(hVar, rVar);
        this.f4556n = bigInteger;
        this.f4555h = bigInteger2;
        this.seed = Arrays.clone(bArr);
    }

    public r validatePublicPoint(r rVar) {
        return validatePublicPoint(getCurve(), rVar);
    }
}
