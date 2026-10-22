package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class CramerShoupPublicKeyParameters extends CramerShoupKeyParameters {

    /* renamed from: c, reason: collision with root package name */
    private BigInteger f4538c;
    private BigInteger d;

    /* renamed from: h, reason: collision with root package name */
    private BigInteger f4539h;

    public CramerShoupPublicKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        super(false, cramerShoupParameters);
        this.f4538c = bigInteger;
        this.d = bigInteger2;
        this.f4539h = bigInteger3;
    }

    @Override // org.bouncycastle.crypto.params.CramerShoupKeyParameters
    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPublicKeyParameters)) {
            return false;
        }
        CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters = (CramerShoupPublicKeyParameters) obj;
        return cramerShoupPublicKeyParameters.getC().equals(this.f4538c) && cramerShoupPublicKeyParameters.getD().equals(this.d) && cramerShoupPublicKeyParameters.getH().equals(this.f4539h) && super.equals(obj);
    }

    public BigInteger getC() {
        return this.f4538c;
    }

    public BigInteger getD() {
        return this.d;
    }

    public BigInteger getH() {
        return this.f4539h;
    }

    @Override // org.bouncycastle.crypto.params.CramerShoupKeyParameters
    public int hashCode() {
        return super.hashCode() ^ ((this.f4538c.hashCode() ^ this.d.hashCode()) ^ this.f4539h.hashCode());
    }
}
