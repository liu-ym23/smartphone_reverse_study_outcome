package w;

import k0.k1;
import n3.m1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements y0 {

    /* renamed from: a, reason: collision with root package name */
    public int f14952a;

    /* renamed from: b, reason: collision with root package name */
    public String f14953b;

    /* renamed from: c, reason: collision with root package name */
    public k1 f14954c;

    /* renamed from: d, reason: collision with root package name */
    public k1 f14955d;

    @Override // w.y0
    public final int a(o2.c cVar, o2.l lVar) {
        return e().f3902c;
    }

    @Override // w.y0
    public final int b(o2.c cVar, o2.l lVar) {
        return e().f3900a;
    }

    @Override // w.y0
    public final int c(o2.c cVar) {
        return e().f3901b;
    }

    @Override // w.y0
    public final int d(o2.c cVar) {
        return e().f3903d;
    }

    public final f3.b e() {
        return (f3.b) this.f14954c.getValue();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.f14952a == ((b) obj).f14952a;
    }

    public final void f(m1 m1Var, int i) {
        int i3 = this.f14952a;
        if (i == 0 || (i & i3) != 0) {
            this.f14954c.setValue(m1Var.f8737a.i(i3));
            this.f14955d.setValue(Boolean.valueOf(m1Var.f8737a.u(i3)));
        }
    }

    public final int hashCode() {
        return this.f14952a;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f14953b);
        sb2.append('(');
        sb2.append(e().f3900a);
        sb2.append(", ");
        sb2.append(e().f3901b);
        sb2.append(", ");
        sb2.append(e().f3902c);
        sb2.append(", ");
        return androidx.activity.b.l(sb2, e().f3903d, ')');
    }
}
