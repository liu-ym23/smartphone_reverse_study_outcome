package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.util.Properties;

/* loaded from: classes.dex */
public class DHParameters implements CipherParameters {
    private static final int DEFAULT_MINIMUM_LENGTH = 160;

    /* renamed from: g, reason: collision with root package name */
    private BigInteger f4540g;

    /* renamed from: j, reason: collision with root package name */
    private BigInteger f4541j;

    /* renamed from: l, reason: collision with root package name */
    private int f4542l;

    /* renamed from: m, reason: collision with root package name */
    private int f4543m;

    /* renamed from: p, reason: collision with root package name */
    private BigInteger f4544p;

    /* renamed from: q, reason: collision with root package name */
    private BigInteger f4545q;
    private DHValidationParameters validation;

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, null, 0);
    }

    private static int getDefaultMParam(int i8) {
        return (i8 != 0 && i8 < DEFAULT_MINIMUM_LENGTH) ? i8 : DEFAULT_MINIMUM_LENGTH;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DHParameters)) {
            return false;
        }
        DHParameters dHParameters = (DHParameters) obj;
        if (getQ() != null) {
            if (!getQ().equals(dHParameters.getQ())) {
                return false;
            }
        } else if (dHParameters.getQ() != null) {
            return false;
        }
        return dHParameters.getP().equals(this.f4544p) && dHParameters.getG().equals(this.f4540g);
    }

    public BigInteger getG() {
        return this.f4540g;
    }

    public BigInteger getJ() {
        return this.f4541j;
    }

    public int getL() {
        return this.f4542l;
    }

    public int getM() {
        return this.f4543m;
    }

    public BigInteger getP() {
        return this.f4544p;
    }

    public BigInteger getQ() {
        return this.f4545q;
    }

    public DHValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return (getQ() != null ? getQ().hashCode() : 0) ^ (getP().hashCode() ^ getG().hashCode());
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this(bigInteger, bigInteger2, bigInteger3, 0);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i8) {
        this(bigInteger, bigInteger2, bigInteger3, getDefaultMParam(i8), i8, null, null);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i8, int i9) {
        this(bigInteger, bigInteger2, bigInteger3, i8, i9, null, null);
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i8, int i9, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        if (i9 != 0) {
            if (i9 > bigInteger.bitLength()) {
                throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
            }
            if (i9 < i8) {
                throw new IllegalArgumentException("when l value specified, it may not be less than m value");
            }
        }
        if (i8 > bigInteger.bitLength() && !Properties.isOverrideSet("org.bouncycastle.dh.allow_unsafe_p_value")) {
            throw new IllegalArgumentException("unsafe p value so small specific l required");
        }
        this.f4540g = bigInteger2;
        this.f4544p = bigInteger;
        this.f4545q = bigInteger3;
        this.f4543m = i8;
        this.f4542l = i9;
        this.f4541j = bigInteger4;
        this.validation = dHValidationParameters;
    }

    public DHParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, DHValidationParameters dHValidationParameters) {
        this(bigInteger, bigInteger2, bigInteger3, DEFAULT_MINIMUM_LENGTH, 0, bigInteger4, dHValidationParameters);
    }
}
