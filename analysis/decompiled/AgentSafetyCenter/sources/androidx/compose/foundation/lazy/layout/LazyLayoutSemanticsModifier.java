package androidx.compose.foundation.lazy.layout;

import java.lang.invoke.VarHandle;
import u.f0;
import u1.f;
import u1.y0;
import w0.l;
import y.h0;
import y.i0;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class LazyLayoutSemanticsModifier extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public xb.a f910c;

    /* renamed from: f, reason: collision with root package name */
    public x.c f911f;

    /* renamed from: g, reason: collision with root package name */
    public f0 f912g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f913h;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyLayoutSemanticsModifier)) {
            return false;
        }
        LazyLayoutSemanticsModifier lazyLayoutSemanticsModifier = (LazyLayoutSemanticsModifier) obj;
        return this.f910c == lazyLayoutSemanticsModifier.f910c && k.a(this.f911f, lazyLayoutSemanticsModifier.f911f) && this.f912g == lazyLayoutSemanticsModifier.f912g && this.f913h == lazyLayoutSemanticsModifier.f913h;
    }

    @Override // u1.y0
    public final l g() {
        xb.a aVar = this.f910c;
        x.c cVar = this.f911f;
        f0 f0Var = this.f912g;
        boolean z10 = this.f913h;
        i0 i0Var = new i0();
        i0Var.f15752s = aVar;
        i0Var.f15753t = cVar;
        i0Var.f15754u = f0Var;
        i0Var.f15755v = z10;
        i0Var.f15757x = new h0(i0Var, 0);
        i0Var.B0();
        VarHandle.storeStoreFence();
        return i0Var;
    }

    public final int hashCode() {
        return Boolean.hashCode(false) + k0.a.h((this.f912g.hashCode() + ((this.f911f.hashCode() + (this.f910c.hashCode() * 31)) * 31)) * 31, 31, this.f913h);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        i0 i0Var = (i0) lVar;
        xb.a aVar = this.f910c;
        x.c cVar = this.f911f;
        f0 f0Var = this.f912g;
        boolean z10 = this.f913h;
        i0Var.f15752s = aVar;
        i0Var.f15753t = cVar;
        if (i0Var.f15754u != f0Var) {
            i0Var.f15754u = f0Var;
            f.n(i0Var);
        }
        if (i0Var.f15755v == z10) {
            return;
        }
        i0Var.f15755v = z10;
        i0Var.B0();
        f.n(i0Var);
    }
}
