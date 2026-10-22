package f1;

import d1.o;
import o2.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public o2.c f3854a;

    /* renamed from: b, reason: collision with root package name */
    public l f3855b;

    /* renamed from: c, reason: collision with root package name */
    public o f3856c;

    /* renamed from: d, reason: collision with root package name */
    public long f3857d;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return k.a(this.f3854a, aVar.f3854a) && this.f3855b == aVar.f3855b && k.a(this.f3856c, aVar.f3856c) && c1.e.b(this.f3857d, aVar.f3857d);
    }

    public final int hashCode() {
        return Long.hashCode(this.f3857d) + ((this.f3856c.hashCode() + ((this.f3855b.hashCode() + (this.f3854a.hashCode() * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "DrawParams(density=" + this.f3854a + ", layoutDirection=" + this.f3855b + ", canvas=" + this.f3856c + ", size=" + ((Object) c1.e.g(this.f3857d)) + ')';
    }
}
