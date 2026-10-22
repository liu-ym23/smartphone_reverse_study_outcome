package v0;

import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f14322a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f14323b;

    public g(int i, Integer num) {
        this.f14322a = i;
        this.f14323b = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f14322a == gVar.f14322a && k.a(this.f14323b, gVar.f14323b);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.f14322a) * 31;
        Integer num = this.f14323b;
        return iHashCode + (num == null ? 0 : num.hashCode());
    }

    public final String toString() {
        return "ObjectLocation(group=" + this.f14322a + ", dataOffset=" + this.f14323b + ')';
    }
}
