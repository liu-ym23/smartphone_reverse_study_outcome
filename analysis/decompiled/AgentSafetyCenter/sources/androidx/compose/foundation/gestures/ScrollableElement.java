package androidx.compose.foundation.gestures;

import a1.g;
import a2.m;
import b1.q;
import b1.s;
import java.lang.invoke.VarHandle;
import n1.d;
import o1.i0;
import s.t;
import sa.c;
import t.b1;
import u.e;
import u.f0;
import u.h;
import u.i;
import u.k;
import u.k0;
import u.t0;
import u.u0;
import u.z0;
import u1.f;
import u1.y0;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class ScrollableElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public u0 f865c;

    /* renamed from: f, reason: collision with root package name */
    public f0 f866f;

    /* renamed from: g, reason: collision with root package name */
    public b1 f867g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f868h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public k f869j;

    /* renamed from: k, reason: collision with root package name */
    public v.k f870k;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScrollableElement)) {
            return false;
        }
        ScrollableElement scrollableElement = (ScrollableElement) obj;
        return yb.k.a(this.f865c, scrollableElement.f865c) && this.f866f == scrollableElement.f866f && yb.k.a(this.f867g, scrollableElement.f867g) && this.f868h == scrollableElement.f868h && this.i == scrollableElement.i && yb.k.a(this.f869j, scrollableElement.f869j) && yb.k.a(this.f870k, scrollableElement.f870k);
    }

    @Override // u1.y0
    public final l g() {
        u0 u0Var = this.f865c;
        b1 b1Var = this.f867g;
        k kVar = this.f869j;
        f0 f0Var = this.f866f;
        boolean z10 = this.f868h;
        boolean z11 = this.i;
        v.k kVar2 = this.f870k;
        e eVar = e.f13445g;
        t0 t0Var = new t0();
        t0Var.f13586u = f0Var;
        t0Var.f13587v = eVar;
        t0Var.f13588w = z10;
        t0Var.f13589x = kVar2;
        t0Var.C = b1Var;
        t0Var.D = kVar;
        d dVar = new d();
        t0Var.E = dVar;
        k0 k0Var = new k0();
        k0Var.f13516s = z10;
        VarHandle.storeStoreFence();
        t0Var.B0(k0Var);
        t0Var.F = k0Var;
        g gVar = new g(a.f873c);
        t tVar = new t();
        tVar.f11121a = gVar;
        VarHandle.storeStoreFence();
        k kVar3 = new k(tVar);
        t0Var.G = kVar3;
        b1 b1Var2 = t0Var.C;
        k kVar4 = t0Var.D;
        if (kVar4 != null) {
            kVar3 = kVar4;
        }
        z0 z0Var = new z0();
        z0Var.f13624a = u0Var;
        z0Var.f13625b = b1Var2;
        z0Var.f13626c = kVar3;
        z0Var.f13627d = f0Var;
        z0Var.f13628e = z11;
        z0Var.f13629f = dVar;
        z0Var.f13630g = 1;
        z0Var.f13631h = a.f871a;
        u.y0 y0Var = new u.y0();
        y0Var.f13619a = z0Var;
        VarHandle.storeStoreFence();
        z0Var.i = y0Var;
        z0Var.f13632j = new m(z0Var, 19);
        VarHandle.storeStoreFence();
        t0Var.H = z0Var;
        l3.d dVar2 = new l3.d();
        dVar2.f7721f = z0Var;
        dVar2.f7720c = z10;
        VarHandle.storeStoreFence();
        t0Var.I = dVar2;
        i iVar = new i();
        iVar.f13479s = f0Var;
        iVar.f13480t = z0Var;
        iVar.f13481u = z11;
        c cVar = new c(5, false);
        cVar.f12170f = new m0.e(new h[16]);
        VarHandle.storeStoreFence();
        iVar.f13482v = cVar;
        iVar.f13486z = 0L;
        VarHandle.storeStoreFence();
        t0Var.B0(iVar);
        t0Var.J = iVar;
        t0Var.B0(new n1.g(dVar2, dVar));
        t0Var.B0(new q(new androidx.room.d(1, s.f1853a, s.class, "onDispatchEventsCompleted", "onDispatchEventsCompleted(Landroidx/compose/ui/focus/FocusTargetNode;)V", 0, 0, 1), 3));
        z.d dVar3 = new z.d();
        dVar3.f16135s = iVar;
        t0Var.B0(dVar3);
        m mVar = new m(t0Var, 18);
        t.f0 f0Var2 = new t.f0();
        f0Var2.f12977s = mVar;
        VarHandle.storeStoreFence();
        t0Var.B0(f0Var2);
        VarHandle.storeStoreFence();
        return t0Var;
    }

    public final int hashCode() {
        int iHashCode = (this.f866f.hashCode() + (this.f865c.hashCode() * 31)) * 31;
        b1 b1Var = this.f867g;
        int iH = k0.a.h(k0.a.h((iHashCode + (b1Var != null ? b1Var.hashCode() : 0)) * 31, 31, this.f868h), 31, this.i);
        k kVar = this.f869j;
        int iHashCode2 = (iH + (kVar != null ? kVar.hashCode() : 0)) * 31;
        v.k kVar2 = this.f870k;
        return (iHashCode2 + (kVar2 != null ? kVar2.hashCode() : 0)) * 31;
    }

    @Override // u1.y0
    public final void i(l lVar) {
        boolean z10;
        i0 i0Var;
        t0 t0Var = (t0) lVar;
        u0 u0Var = this.f865c;
        f0 f0Var = this.f866f;
        b1 b1Var = this.f867g;
        boolean z11 = this.f868h;
        boolean z12 = this.i;
        k kVar = this.f869j;
        v.k kVar2 = this.f870k;
        z0 z0Var = t0Var.H;
        boolean z13 = true;
        boolean z14 = false;
        if (t0Var.f13588w != z11) {
            t0Var.I.f7720c = z11;
            t0Var.F.f13516s = z11;
            z10 = true;
        } else {
            z10 = false;
        }
        k kVar3 = kVar == null ? t0Var.G : kVar;
        d dVar = t0Var.E;
        if (!yb.k.a(z0Var.f13624a, u0Var)) {
            z0Var.f13624a = u0Var;
            z14 = true;
        }
        z0Var.f13625b = b1Var;
        if (z0Var.f13627d != f0Var) {
            z0Var.f13627d = f0Var;
            z14 = true;
        }
        if (z0Var.f13628e != z12) {
            z0Var.f13628e = z12;
            z14 = true;
        }
        z0Var.f13626c = kVar3;
        z0Var.f13629f = dVar;
        i iVar = t0Var.J;
        iVar.f13479s = f0Var;
        iVar.f13481u = z12;
        t0Var.C = b1Var;
        t0Var.D = kVar;
        e eVar = e.f13445g;
        f0 f0Var2 = z0Var.f13627d;
        f0 f0Var3 = f0.f13453c;
        if (f0Var2 != f0Var3) {
            f0Var3 = f0.f13454f;
        }
        t0Var.f13587v = eVar;
        if (t0Var.f13588w != z11) {
            t0Var.f13588w = z11;
            if (!z11) {
                t0Var.H0();
                i0 i0Var2 = t0Var.B;
                if (i0Var2 != null) {
                    t0Var.C0(i0Var2);
                }
                t0Var.B = null;
            }
            z14 = true;
        }
        if (!yb.k.a(t0Var.f13589x, kVar2)) {
            t0Var.H0();
            t0Var.f13589x = kVar2;
        }
        if (t0Var.f13586u != f0Var3) {
            t0Var.f13586u = f0Var3;
        } else {
            z13 = z14;
        }
        if (z13 && (i0Var = t0Var.B) != null) {
            i0Var.C0();
        }
        if (z10) {
            t0Var.L = null;
            t0Var.M = null;
            f.n(t0Var);
        }
    }
}
