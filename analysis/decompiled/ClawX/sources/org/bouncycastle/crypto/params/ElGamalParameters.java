package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

/* loaded from: classes.dex */
public class ElGamalParameters implements CipherParameters {

    /* renamed from: g, reason: collision with root package name */
    private BigInteger f4558g;

    /* renamed from: l, reason: collision with root package name */
    private int f4559l;

    /* renamed from: p, reason: collision with root package name */
    private BigInteger f4560p;

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2) {
        this(bigInteger, bigInteger2, 0);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ElGamalParameters)) {
            return false;
        }
        ElGamalParameters elGamalParameters = (ElGamalParameters) obj;
        return elGamalParameters.getP().equals(this.f4560p) && elGamalParameters.getG().equals(this.f4558g) && elGamalParameters.getL() == this.f4559l;
    }

    public BigInteger getG() {
        return this.f4558g;
    }

    public int getL() {
        return this.f4559l;
    }

    public BigInteger getP() {
        return this.f4560p;
    }

    public int hashCode() {
        return (getP().hashCode() ^ getG().hashCode()) + this.f4559l;
    }

    public ElGamalParameters(BigInteger bigInteger, BigInteger bigInteger2, int i8) {
        this.f4558g = bigInteger2;
        this.f4560p = bigInteger;
        this.f4559l = i8;
    }
}
