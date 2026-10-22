package w;

import k0.k1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x0 implements y0 {

    /* renamed from: a, reason: collision with root package name */
    public String f15064a;

    /* renamed from: b, reason: collision with root package name */
    public k1 f15065b;

    @Override // w.y0
    public final int a(o2.c cVar, o2.l lVar) {
        return e().f14978c;
    }

    @Override // w.y0
    public final int b(o2.c cVar, o2.l lVar) {
        return e().f14976a;
    }

    @Override // w.y0
    public final int c(o2.c cVar) {
        return e().f14977b;
    }

    @Override // w.y0
    public final int d(o2.c cVar) {
        return e().f14979d;
    }

    public final g0 e() {
        return (g0) this.f15065b.getValue();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x0) {
            return yb.k.a(e(), ((x0) obj).e());
        }
        return false;
    }

    public final void f(g0 g0Var) {
        this.f15065b.setValue(g0Var);
    }

    public final int hashCode() {
        return this.f15064a.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f15064a);
        sb2.append("(left=");
        sb2.append(e().f14976a);
        sb2.append(", top=");
        sb2.append(e().f14977b);
        sb2.append(", right=");
        sb2.append(e().f14978c);
        sb2.append(", bottom=");
        return androidx.activity.b.l(sb2, e().f14979d, ')');
    }
}
