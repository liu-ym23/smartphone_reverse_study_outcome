package sb;

import java.math.BigInteger;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final BigInteger f9634a;

    /* renamed from: b, reason: collision with root package name */
    public final BigInteger f9635b;

    /* renamed from: c, reason: collision with root package name */
    public final BigInteger f9636c;

    /* renamed from: d, reason: collision with root package name */
    public final c f9637d;

    public b(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, c cVar) {
        this.f9634a = bigInteger3;
        this.f9636c = bigInteger;
        this.f9635b = bigInteger2;
        this.f9637d = cVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return bVar.f9636c.equals(this.f9636c) && bVar.f9635b.equals(this.f9635b) && bVar.f9634a.equals(this.f9634a);
    }

    public final int hashCode() {
        return this.f9634a.hashCode() ^ (this.f9636c.hashCode() ^ this.f9635b.hashCode());
    }
}
