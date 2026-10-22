package w;

import java.util.List;
import t.i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r0 implements s1.f0, n0 {

    /* renamed from: a, reason: collision with root package name */
    public final f f15040a;

    /* renamed from: b, reason: collision with root package name */
    public final w0.d f15041b;

    public r0(f fVar, w0.d dVar) {
        this.f15040a = fVar;
        this.f15041b = dVar;
    }

    @Override // w.n0
    public final long a(int i, int i3, int i10, boolean z10) {
        return !z10 ? o2.b.a(i, i3, 0, i10) : id.k.q(i, i3, 0, i10);
    }

    @Override // w.n0
    public final void b(int i, s1.h0 h0Var, int[] iArr, int[] iArr2) {
        this.f15040a.b(h0Var, i, iArr, h0Var.getLayoutDirection(), iArr2);
    }

    @Override // s1.f0
    public final s1.g0 c(s1.h0 h0Var, List list, long j10) {
        return i1.i(this, o2.a.k(j10), o2.a.j(j10), o2.a.i(j10), o2.a.h(j10), h0Var.e0(this.f15040a.a()), h0Var, list, new s1.o0[list.size()], list.size());
    }

    @Override // w.n0
    public final int d(s1.o0 o0Var) {
        return o0Var.f11278f;
    }

    @Override // w.n0
    public final int e(s1.o0 o0Var) {
        return o0Var.f11277c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r0)) {
            return false;
        }
        r0 r0Var = (r0) obj;
        return this.f15040a.equals(r0Var.f15040a) && this.f15041b.equals(r0Var.f15041b);
    }

    @Override // w.n0
    public final s1.g0 f(s1.o0[] o0VarArr, s1.h0 h0Var, int i, int[] iArr, int i3, int i10) {
        return h0Var.Y(i3, i10, kb.t.f7405c, new q0(o0VarArr, this, i10, i, iArr));
    }

    public final int hashCode() {
        return Float.hashCode(this.f15041b.f15105a) + (this.f15040a.hashCode() * 31);
    }

    public final String toString() {
        return "RowMeasurePolicy(horizontalArrangement=" + this.f15040a + ", verticalAlignment=" + this.f15041b + ')';
    }
}
