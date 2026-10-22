package w0;

import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g implements m {

    /* renamed from: c, reason: collision with root package name */
    public m f15109c;

    /* renamed from: f, reason: collision with root package name */
    public m f15110f;

    @Override // w0.m
    public final boolean a(xb.l lVar) {
        return this.f15109c.a(lVar) && this.f15110f.a(lVar);
    }

    @Override // w0.m
    public final Object c(Object obj, p pVar) {
        return this.f15110f.c(this.f15109c.c(obj, pVar), pVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f15109c.equals(gVar.f15109c) && yb.k.a(this.f15110f, gVar.f15110f);
    }

    public final int hashCode() {
        return (this.f15110f.hashCode() * 31) + this.f15109c.hashCode();
    }

    public final String toString() {
        return k0.a.s(new StringBuilder("["), (String) c("", f.f15108c), ']');
    }
}
