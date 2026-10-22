package u5;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends g {

    /* renamed from: a, reason: collision with root package name */
    public h1.b f14053a;

    /* renamed from: b, reason: collision with root package name */
    public e6.e f14054b;

    @Override // u5.g
    public final h1.b a() {
        return this.f14053a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return yb.k.a(this.f14053a, dVar.f14053a) && this.f14054b.equals(dVar.f14054b);
    }

    public final int hashCode() {
        h1.b bVar = this.f14053a;
        return this.f14054b.hashCode() + ((bVar == null ? 0 : bVar.hashCode()) * 31);
    }

    public final String toString() {
        return "Error(painter=" + this.f14053a + ", result=" + this.f14054b + ')';
    }
}
