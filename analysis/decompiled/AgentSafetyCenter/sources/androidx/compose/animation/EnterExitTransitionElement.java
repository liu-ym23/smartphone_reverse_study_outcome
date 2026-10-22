package androidx.compose.animation;

import java.lang.invoke.VarHandle;
import o2.b;
import r.f0;
import r.g0;
import r.h0;
import r.i0;
import r.u;
import r.x;
import s.e1;
import u1.y0;
import w0.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class EnterExitTransitionElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public e1 f829c;

    /* renamed from: f, reason: collision with root package name */
    public s.y0 f830f;

    /* renamed from: g, reason: collision with root package name */
    public s.y0 f831g;

    /* renamed from: h, reason: collision with root package name */
    public s.y0 f832h;
    public h0 i;

    /* renamed from: j, reason: collision with root package name */
    public i0 f833j;

    /* renamed from: k, reason: collision with root package name */
    public xb.a f834k;

    /* renamed from: l, reason: collision with root package name */
    public x f835l;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnterExitTransitionElement)) {
            return false;
        }
        EnterExitTransitionElement enterExitTransitionElement = (EnterExitTransitionElement) obj;
        return k.a(this.f829c, enterExitTransitionElement.f829c) && k.a(this.f830f, enterExitTransitionElement.f830f) && k.a(this.f831g, enterExitTransitionElement.f831g) && k.a(this.f832h, enterExitTransitionElement.f832h) && k.a(this.i, enterExitTransitionElement.i) && k.a(this.f833j, enterExitTransitionElement.f833j) && k.a(this.f834k, enterExitTransitionElement.f834k) && k.a(this.f835l, enterExitTransitionElement.f835l);
    }

    @Override // u1.y0
    public final l g() {
        e1 e1Var = this.f829c;
        s.y0 y0Var = this.f830f;
        s.y0 y0Var2 = this.f831g;
        s.y0 y0Var3 = this.f832h;
        h0 h0Var = this.i;
        i0 i0Var = this.f833j;
        xb.a aVar = this.f834k;
        x xVar = this.f835l;
        g0 g0Var = new g0();
        g0Var.f10283s = e1Var;
        g0Var.f10284t = y0Var;
        g0Var.f10285u = y0Var2;
        g0Var.f10286v = y0Var3;
        g0Var.f10287w = h0Var;
        g0Var.f10288x = i0Var;
        g0Var.f10289y = aVar;
        g0Var.f10290z = xVar;
        g0Var.A = u.f10343a;
        b.b(0, 0, 15);
        g0Var.C = new f0(g0Var, 0);
        g0Var.D = new f0(g0Var, 1);
        VarHandle.storeStoreFence();
        return g0Var;
    }

    public final int hashCode() {
        int iHashCode = this.f829c.hashCode() * 31;
        s.y0 y0Var = this.f830f;
        int iHashCode2 = (iHashCode + (y0Var == null ? 0 : y0Var.hashCode())) * 31;
        s.y0 y0Var2 = this.f831g;
        int iHashCode3 = (iHashCode2 + (y0Var2 == null ? 0 : y0Var2.hashCode())) * 31;
        s.y0 y0Var3 = this.f832h;
        return this.f835l.hashCode() + ((this.f834k.hashCode() + ((this.f833j.f10306a.hashCode() + ((this.i.f10297a.hashCode() + ((iHashCode3 + (y0Var3 != null ? y0Var3.hashCode() : 0)) * 31)) * 31)) * 31)) * 31);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        g0 g0Var = (g0) lVar;
        g0Var.f10283s = this.f829c;
        g0Var.f10284t = this.f830f;
        g0Var.f10285u = this.f831g;
        g0Var.f10286v = this.f832h;
        g0Var.f10287w = this.i;
        g0Var.f10288x = this.f833j;
        g0Var.f10289y = this.f834k;
        g0Var.f10290z = this.f835l;
    }

    public final String toString() {
        return "EnterExitTransitionElement(transition=" + this.f829c + ", sizeAnimation=" + this.f830f + ", offsetAnimation=" + this.f831g + ", slideAnimation=" + this.f832h + ", enter=" + this.i + ", exit=" + this.f833j + ", isEnabled=" + this.f834k + ", graphicsLayerBlock=" + this.f835l + ')';
    }
}
