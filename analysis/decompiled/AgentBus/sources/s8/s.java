package s8;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final e9.f f9605a;

    /* renamed from: b, reason: collision with root package name */
    public final l8.o f9606b;

    public s(e9.f fVar, l8.o oVar) {
        q7.k.e(fVar, "name");
        this.f9605a = fVar;
        this.f9606b = oVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof s) {
            return q7.k.a(this.f9605a, ((s) obj).f9605a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f9605a.hashCode();
    }
}
