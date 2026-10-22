package w;

import java.lang.invoke.VarHandle;
import k0.k1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 implements s1.r, t1.c, t1.g {

    /* renamed from: c, reason: collision with root package name */
    public final y0 f14970c;

    /* renamed from: f, reason: collision with root package name */
    public final k1 f14971f;

    /* renamed from: g, reason: collision with root package name */
    public final k1 f14972g;

    public f0(b bVar) {
        this.f14970c = bVar;
        this.f14971f = k0.z.v(bVar);
        this.f14972g = k0.z.v(bVar);
    }

    @Override // t1.c
    public final void e(t1.h hVar) {
        y0 y0Var = (y0) hVar.d(b1.f14958a);
        a0 a0Var = new a0();
        y0 y0Var2 = this.f14970c;
        a0Var.f14949a = y0Var2;
        a0Var.f14950b = y0Var;
        VarHandle.storeStoreFence();
        this.f14971f.setValue(a0Var);
        this.f14972g.setValue(t1.e.q(y0Var, y0Var2));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f0) {
            return yb.k.a(((f0) obj).f14970c, this.f14970c);
        }
        return false;
    }

    @Override // s1.r
    public final s1.g0 f(u1.o0 o0Var, s1.e0 e0Var, long j10) {
        k1 k1Var = this.f14971f;
        int iB = ((y0) k1Var.getValue()).b(o0Var, o0Var.getLayoutDirection());
        int iC = ((y0) k1Var.getValue()).c(o0Var);
        int iA = ((y0) k1Var.getValue()).a(o0Var, o0Var.getLayoutDirection()) + iB;
        int iD = ((y0) k1Var.getValue()).d(o0Var) + iC;
        s1.o0 o0VarQ = e0Var.q(o2.b.h(j10, -iA, -iD));
        return o0Var.Y(o2.b.f(o0VarQ.f11277c + iA, j10), o2.b.e(o0VarQ.f11278f + iD, j10), kb.t.f7405c, new h0.s0(o0VarQ, iB, iC, 2));
    }

    @Override // t1.g
    public final t1.i getKey() {
        return b1.f14958a;
    }

    @Override // t1.g
    public final Object getValue() {
        return (y0) this.f14972g.getValue();
    }

    public final int hashCode() {
        return this.f14970c.hashCode();
    }
}
