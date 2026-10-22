package gc;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final String f9134a;

    /* renamed from: b, reason: collision with root package name */
    public final dc.e f9135b;

    public g(String str, dc.e eVar) {
        this.f9134a = str;
        this.f9135b = eVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return kotlin.jvm.internal.g.b(this.f9134a, gVar.f9134a) && kotlin.jvm.internal.g.b(this.f9135b, gVar.f9135b);
    }

    public final int hashCode() {
        return this.f9135b.hashCode() + (this.f9134a.hashCode() * 31);
    }

    public final String toString() {
        return "MatchGroup(value=" + this.f9134a + ", range=" + this.f9135b + ')';
    }
}
