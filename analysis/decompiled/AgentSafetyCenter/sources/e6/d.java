package e6;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public f6.h f3521a;

    /* renamed from: b, reason: collision with root package name */
    public f6.f f3522b;

    /* renamed from: c, reason: collision with root package name */
    public h6.e f3523c;

    /* renamed from: d, reason: collision with root package name */
    public f6.d f3524d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return yb.k.a(this.f3521a, dVar.f3521a) && this.f3522b == dVar.f3522b && yb.k.a(this.f3523c, dVar.f3523c) && this.f3524d == dVar.f3524d;
    }

    public final int hashCode() {
        f6.h hVar = this.f3521a;
        int iHashCode = (hVar != null ? hVar.hashCode() : 0) * 31;
        f6.f fVar = this.f3522b;
        int iHashCode2 = (iHashCode + (fVar != null ? fVar.hashCode() : 0)) * 28629151;
        h6.e eVar = this.f3523c;
        int iHashCode3 = (iHashCode2 + (eVar != null ? eVar.hashCode() : 0)) * 31;
        f6.d dVar = this.f3524d;
        return (iHashCode3 + (dVar != null ? dVar.hashCode() : 0)) * 887503681;
    }
}
