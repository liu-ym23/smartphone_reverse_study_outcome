package sb;

import java.math.BigInteger;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public BigInteger f9631a;

    /* renamed from: b, reason: collision with root package name */
    public BigInteger f9632b;

    /* renamed from: c, reason: collision with root package name */
    public BigInteger f9633c;

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        BigInteger bigInteger = aVar.f9633c;
        BigInteger bigInteger2 = this.f9633c;
        if (bigInteger2 != null) {
            if (!bigInteger2.equals(bigInteger)) {
                return false;
            }
        } else if (bigInteger != null) {
            return false;
        }
        return aVar.f9632b.equals(this.f9632b) && aVar.f9631a.equals(this.f9631a);
    }

    public final int hashCode() {
        int iHashCode = this.f9632b.hashCode() ^ this.f9631a.hashCode();
        BigInteger bigInteger = this.f9633c;
        return (bigInteger != null ? bigInteger.hashCode() : 0) ^ iHashCode;
    }
}
