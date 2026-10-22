package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

/* loaded from: classes.dex */
public class GOST3410Parameters implements CipherParameters {

    /* renamed from: a, reason: collision with root package name */
    private BigInteger f4562a;

    /* renamed from: p, reason: collision with root package name */
    private BigInteger f4563p;

    /* renamed from: q, reason: collision with root package name */
    private BigInteger f4564q;
    private GOST3410ValidationParameters validation;

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f4563p = bigInteger;
        this.f4564q = bigInteger2;
        this.f4562a = bigInteger3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GOST3410Parameters)) {
            return false;
        }
        GOST3410Parameters gOST3410Parameters = (GOST3410Parameters) obj;
        return gOST3410Parameters.getP().equals(this.f4563p) && gOST3410Parameters.getQ().equals(this.f4564q) && gOST3410Parameters.getA().equals(this.f4562a);
    }

    public BigInteger getA() {
        return this.f4562a;
    }

    public BigInteger getP() {
        return this.f4563p;
    }

    public BigInteger getQ() {
        return this.f4564q;
    }

    public GOST3410ValidationParameters getValidationParameters() {
        return this.validation;
    }

    public int hashCode() {
        return this.f4562a.hashCode() ^ (this.f4563p.hashCode() ^ this.f4564q.hashCode());
    }

    public GOST3410Parameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, GOST3410ValidationParameters gOST3410ValidationParameters) {
        this.f4562a = bigInteger3;
        this.f4563p = bigInteger;
        this.f4564q = bigInteger2;
        this.validation = gOST3410ValidationParameters;
    }
}
