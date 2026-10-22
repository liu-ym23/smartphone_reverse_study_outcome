package w;

import java.util.List;
import t.i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v implements s1.f0, n0 {

    /* renamed from: a, reason: collision with root package name */
    public final h f15055a;

    /* renamed from: b, reason: collision with root package name */
    public final w0.c f15056b;

    public v(h hVar, w0.c cVar) {
        this.f15055a = hVar;
        this.f15056b = cVar;
    }

    @Override // w.n0
    public final long a(int i, int i3, int i10, boolean z10) {
        return !z10 ? o2.b.a(0, i10, i, i3) : id.k.p(0, i10, i, i3);
    }

    @Override // w.n0
    public final void b(int i, s1.h0 h0Var, int[] iArr, int[] iArr2) {
        this.f15055a.c(i, h0Var, iArr, iArr2);
    }

    @Override // s1.f0
    public final s1.g0 c(s1.h0 h0Var, List list, long j10) {
        return i1.i(this, o2.a.j(j10), o2.a.k(j10), o2.a.h(j10), o2.a.i(j10), h0Var.e0(this.f15055a.a()), h0Var, list, new s1.o0[list.size()], list.size());
    }

    @Override // w.n0
    public final int d(s1.o0 o0Var) {
        return o0Var.f11277c;
    }

    @Override // w.n0
    public final int e(s1.o0 o0Var) {
        return o0Var.f11278f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f15055a.equals(vVar.f15055a) && this.f15056b.equals(vVar.f15056b);
    }

    @Override // w.n0
    public final s1.g0 f(s1.o0[] o0VarArr, s1.h0 h0Var, int i, int[] iArr, int i3, int i10) {
        return h0Var.Y(i10, i3, kb.t.f7405c, new q(o0VarArr, this, i10, i, h0Var, iArr));
    }

    public final int hashCode() {
        return Float.hashCode(this.f15056b.f15104a) + (this.f15055a.hashCode() * 31);
    }

    public final String toString() {
        return "ColumnMeasurePolicy(verticalArrangement=" + this.f15055a + ", horizontalAlignment=" + this.f15056b + ')';
    }
}
