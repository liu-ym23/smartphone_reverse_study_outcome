package y;

/* loaded from: classes.dex */
public final class c0 implements o.m0 {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11366a;

    /* renamed from: b, reason: collision with root package name */
    public final long f11367b;

    public c0(long j2, boolean z4) {
        this.f11366a = z4;
        this.f11367b = j2;
    }

    @Override // o.m0
    public final i1.j b(q.i iVar) {
        return new n(iVar, this.f11366a, new o4.d0(22, this));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        if (this.f11366a == c0Var.f11366a && d2.f.a(Float.NaN, Float.NaN)) {
            return u0.m.c(this.f11367b, c0Var.f11367b);
        }
        return false;
    }

    public final int hashCode() {
        int iD = m.x.d(Float.NaN, Boolean.hashCode(this.f11366a) * 31, 961);
        int i2 = u0.m.f9917g;
        return Long.hashCode(this.f11367b) + iD;
    }
}
