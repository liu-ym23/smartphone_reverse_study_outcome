package d1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 extends c0 {

    /* renamed from: a, reason: collision with root package name */
    public final c1.d f2959a;

    /* renamed from: b, reason: collision with root package name */
    public final h f2960b;

    public b0(c1.d dVar) {
        h hVarA;
        this.f2959a = dVar;
        if (td.h.z(dVar)) {
            hVarA = null;
        } else {
            hVarA = k.a();
            h.a(hVarA, dVar);
        }
        this.f2960b = hVarA;
    }

    @Override // d1.c0
    public final c1.c a() {
        c1.d dVar = this.f2959a;
        return new c1.c(dVar.f2171a, dVar.f2172b, dVar.f2173c, dVar.f2174d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b0) {
            return this.f2959a.equals(((b0) obj).f2959a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2959a.hashCode();
    }
}
