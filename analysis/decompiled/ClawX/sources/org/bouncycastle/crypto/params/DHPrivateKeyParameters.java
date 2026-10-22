package org.bouncycastle.crypto.params;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class DHPrivateKeyParameters extends DHKeyParameters {

    /* renamed from: x, reason: collision with root package name */
    private BigInteger f4546x;

    public DHPrivateKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(true, dHParameters);
        this.f4546x = bigInteger;
    }

    @Override // org.bouncycastle.crypto.params.DHKeyParameters
    public boolean equals(Object obj) {
        return (obj instanceof DHPrivateKeyParameters) && ((DHPrivateKeyParameters) obj).getX().equals(this.f4546x) && super.equals(obj);
    }

    public BigInteger getX() {
        return this.f4546x;
    }

    @Override // org.bouncycastle.crypto.params.DHKeyParameters
    public int hashCode() {
        return super.hashCode() ^ this.f4546x.hashCode();
    }
}
