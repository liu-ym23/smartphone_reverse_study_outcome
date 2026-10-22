package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class CramerShoupPrivateKeyParameters extends CramerShoupKeyParameters {
    private CramerShoupPublicKeyParameters pk;

    /* renamed from: x1, reason: collision with root package name */
    private BigInteger f4535x1;

    /* renamed from: x2, reason: collision with root package name */
    private BigInteger f4536x2;

    /* renamed from: y1, reason: collision with root package name */
    private BigInteger f4537y1;
    private BigInteger y2;
    private BigInteger z;

    public CramerShoupPrivateKeyParameters(CramerShoupParameters cramerShoupParameters, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
        super(true, cramerShoupParameters);
        this.f4535x1 = bigInteger;
        this.f4536x2 = bigInteger2;
        this.f4537y1 = bigInteger3;
        this.y2 = bigInteger4;
        this.z = bigInteger5;
    }

    @Override // org.bouncycastle.crypto.params.CramerShoupKeyParameters
    public boolean equals(Object obj) {
        if (!(obj instanceof CramerShoupPrivateKeyParameters)) {
            return false;
        }
        CramerShoupPrivateKeyParameters cramerShoupPrivateKeyParameters = (CramerShoupPrivateKeyParameters) obj;
        return cramerShoupPrivateKeyParameters.getX1().equals(this.f4535x1) && cramerShoupPrivateKeyParameters.getX2().equals(this.f4536x2) && cramerShoupPrivateKeyParameters.getY1().equals(this.f4537y1) && cramerShoupPrivateKeyParameters.getY2().equals(this.y2) && cramerShoupPrivateKeyParameters.getZ().equals(this.z) && super.equals(obj);
    }

    public CramerShoupPublicKeyParameters getPk() {
        return this.pk;
    }

    public BigInteger getX1() {
        return this.f4535x1;
    }

    public BigInteger getX2() {
        return this.f4536x2;
    }

    public BigInteger getY1() {
        return this.f4537y1;
    }

    public BigInteger getY2() {
        return this.y2;
    }

    public BigInteger getZ() {
        return this.z;
    }

    @Override // org.bouncycastle.crypto.params.CramerShoupKeyParameters
    public int hashCode() {
        return super.hashCode() ^ ((((this.f4535x1.hashCode() ^ this.f4536x2.hashCode()) ^ this.f4537y1.hashCode()) ^ this.y2.hashCode()) ^ this.z.hashCode());
    }

    public void setPk(CramerShoupPublicKeyParameters cramerShoupPublicKeyParameters) {
        this.pk = cramerShoupPublicKeyParameters;
    }
}
