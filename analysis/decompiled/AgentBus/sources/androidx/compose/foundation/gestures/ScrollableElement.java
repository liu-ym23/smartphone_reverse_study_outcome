package androidx.compose.foundation.gestures;

import c1.x;
import i1.w0;
import kotlin.Metadata;
import n0.l;
import nb.f;
import p.e;
import p.e0;
import p.s0;
import p.t0;
import p.y0;
import q.i;
import q7.k;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableElement;", "Li1/w0;", "Lp/s0;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class ScrollableElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final t0 f722a;

    /* renamed from: b, reason: collision with root package name */
    public final e0 f723b;

    /* renamed from: c, reason: collision with root package name */
    public final o.t0 f724c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f725d;

    /* renamed from: e, reason: collision with root package name */
    public final i f726e;

    public ScrollableElement(o.t0 t0Var, e0 e0Var, t0 t0Var2, i iVar, boolean z4) {
        this.f722a = t0Var2;
        this.f723b = e0Var;
        this.f724c = t0Var;
        this.f725d = z4;
        this.f726e = iVar;
    }

    @Override // i1.w0
    public final l d() {
        boolean z4 = this.f725d;
        return new s0(this.f724c, this.f723b, this.f722a, this.f726e, z4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScrollableElement)) {
            return false;
        }
        ScrollableElement scrollableElement = (ScrollableElement) obj;
        return k.a(this.f722a, scrollableElement.f722a) && this.f723b == scrollableElement.f723b && this.f724c.equals(scrollableElement.f724c) && this.f725d == scrollableElement.f725d && k.a(this.f726e, scrollableElement.f726e);
    }

    @Override // i1.w0
    public final void f(l lVar) {
        boolean z4;
        x xVar;
        s0 s0Var = (s0) lVar;
        y0 y0Var = s0Var.H;
        boolean z10 = true;
        boolean z11 = false;
        if (!s0Var.f8179x) {
            s0Var.I.getClass();
            s0Var.F.getClass();
            z4 = true;
        } else {
            z4 = false;
        }
        f fVar = s0Var.G;
        i5.f fVar2 = s0Var.E;
        t0 t0Var = y0Var.f8216a;
        t0 t0Var2 = this.f722a;
        if (!k.a(t0Var, t0Var2)) {
            y0Var.f8216a = t0Var2;
            z11 = true;
        }
        o.t0 t0Var3 = this.f724c;
        y0Var.f8217b = t0Var3;
        e0 e0Var = y0Var.f8219d;
        e0 e0Var2 = this.f723b;
        if (e0Var != e0Var2) {
            y0Var.f8219d = e0Var2;
            z11 = true;
        }
        boolean z12 = y0Var.f8220e;
        boolean z13 = this.f725d;
        if (z12 != z13) {
            y0Var.f8220e = z13;
            z11 = true;
        }
        y0Var.f8218c = fVar;
        y0Var.f8221f = fVar2;
        p.i iVar = s0Var.J;
        iVar.f8117t = e0Var2;
        iVar.f8119v = z13;
        s0Var.D = t0Var3;
        e eVar = e.f8079i;
        e0 e0Var3 = y0Var.f8219d;
        e0 e0Var4 = e0.f8081f;
        if (e0Var3 != e0Var4) {
            e0Var4 = e0.f8082g;
        }
        s0Var.f8178w = eVar;
        if (!s0Var.f8179x) {
            s0Var.f8179x = true;
            z11 = true;
        }
        i iVar2 = s0Var.f8180y;
        i iVar3 = this.f726e;
        if (!k.a(iVar2, iVar3)) {
            s0Var.r0();
            s0Var.f8180y = iVar3;
        }
        if (s0Var.f8177v != e0Var4) {
            s0Var.f8177v = e0Var4;
        } else {
            z10 = z11;
        }
        if (z10 && (xVar = s0Var.C) != null) {
            xVar.m0();
        }
        if (z4) {
            s0Var.L = null;
            s0Var.M = null;
            i1.l.n(s0Var);
        }
    }

    public final int hashCode() {
        int iE = m.x.e(m.x.e((this.f724c.hashCode() + ((this.f723b.hashCode() + (this.f722a.hashCode() * 31)) * 31)) * 31, 31, true), 961, this.f725d);
        i iVar = this.f726e;
        return (iE + (iVar != null ? iVar.hashCode() : 0)) * 31;
    }
}
