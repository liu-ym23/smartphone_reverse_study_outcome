package w0;

import d2.l;
import q7.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public d2.c f10625a;

    /* renamed from: b, reason: collision with root package name */
    public l f10626b;

    /* renamed from: c, reason: collision with root package name */
    public u0.l f10627c;

    /* renamed from: d, reason: collision with root package name */
    public long f10628d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(this.f10625a, aVar.f10625a) && this.f10626b == aVar.f10626b && k.a(this.f10627c, aVar.f10627c) && t0.e.a(this.f10628d, aVar.f10628d);
    }

    public final int hashCode() {
        return Long.hashCode(this.f10628d) + ((this.f10627c.hashCode() + ((this.f10626b.hashCode() + (this.f10625a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "DrawParams(density=" + this.f10625a + ", layoutDirection=" + this.f10626b + ", canvas=" + this.f10627c + ", size=" + ((Object) t0.e.f(this.f10628d)) + ')';
    }
}
