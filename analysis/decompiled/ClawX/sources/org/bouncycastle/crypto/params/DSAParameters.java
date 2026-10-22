package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

/* loaded from: classes.dex */
public class DSAParameters implements CipherParameters {

    /* renamed from: g, reason: collision with root package name */
    private BigInteger f4549g;

    /* renamed from: p, reason: collision with root package name */
    private BigInteger f4550p;

    /* renamed from: q, reason: collision with root package name */
    private BigInteger f4551q;
    private DSAValidationParameters validation;

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f4549g = bigInteger3;
        this.f4550p = bigInteger;
        this.f4551q = bigInteger2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DSAParameters)) {
            return false;
        }
        DSAParameters dSAParameters = (DSAParameters) obj;
        return dSAParameters.getP().equals(this.f4550p) && dSAParameters.getQ().equals(this.f4551q) && dSAParameters.getG().equals(this.f4549g);
    }

    public BigInteger getG() {
        return this.f4549g;
    }

    public BigInteger getP() {
        return this.f4550p;
    }

    public BigInteger getQ() {
        return this.f4551q;
    }

    public DSAValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return getG().hashCode() ^ (getP().hashCode() ^ getQ().hashCode());
    }

    public DSAParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, DSAValidationParameters dSAValidationParameters) {
        this.f4549g = bigInteger3;
        this.f4550p = bigInteger;
        this.f4551q = bigInteger2;
        this.validation = dSAValidationParameters;
    }
}
