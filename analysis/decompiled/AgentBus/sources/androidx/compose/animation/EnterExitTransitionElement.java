package androidx.compose.animation;

import i1.w0;
import kotlin.Metadata;
import m.o;
import m.w;
import m.y;
import m.z;
import n.b1;
import n.u0;
import n0.l;
import q7.k;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/animation/EnterExitTransitionElement;", "Li1/w0;", "Lm/w;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class EnterExitTransitionElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final b1 f697a;

    /* renamed from: b, reason: collision with root package name */
    public final u0 f698b;

    /* renamed from: c, reason: collision with root package name */
    public final u0 f699c;

    /* renamed from: d, reason: collision with root package name */
    public final y f700d;

    /* renamed from: e, reason: collision with root package name */
    public final z f701e;

    /* renamed from: f, reason: collision with root package name */
    public final p7.a f702f;

    /* renamed from: g, reason: collision with root package name */
    public final o f703g;

    public EnterExitTransitionElement(b1 b1Var, u0 u0Var, u0 u0Var2, y yVar, z zVar, p7.a aVar, o oVar) {
        this.f697a = b1Var;
        this.f698b = u0Var;
        this.f699c = u0Var2;
        this.f700d = yVar;
        this.f701e = zVar;
        this.f702f = aVar;
        this.f703g = oVar;
    }

    @Override // i1.w0
    public final l d() {
        return new w(this.f697a, this.f698b, this.f699c, this.f700d, this.f701e, this.f702f, this.f703g);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnterExitTransitionElement)) {
            return false;
        }
        EnterExitTransitionElement enterExitTransitionElement = (EnterExitTransitionElement) obj;
        return this.f697a.equals(enterExitTransitionElement.f697a) && k.a(this.f698b, enterExitTransitionElement.f698b) && k.a(this.f699c, enterExitTransitionElement.f699c) && this.f700d.equals(enterExitTransitionElement.f700d) && this.f701e.equals(enterExitTransitionElement.f701e) && k.a(this.f702f, enterExitTransitionElement.f702f) && k.a(this.f703g, enterExitTransitionElement.f703g);
    }

    @Override // i1.w0
    public final void f(l lVar) {
        w wVar = (w) lVar;
        wVar.f6109t = this.f697a;
        wVar.f6110u = this.f698b;
        wVar.f6111v = this.f699c;
        wVar.f6112w = this.f700d;
        wVar.f6113x = this.f701e;
        wVar.f6114y = this.f702f;
        wVar.f6115z = this.f703g;
    }

    public final int hashCode() {
        int iHashCode = this.f697a.hashCode() * 31;
        u0 u0Var = this.f698b;
        int iHashCode2 = (iHashCode + (u0Var == null ? 0 : u0Var.hashCode())) * 31;
        u0 u0Var2 = this.f699c;
        return this.f703g.hashCode() + ((this.f702f.hashCode() + ((this.f701e.f6120a.hashCode() + ((this.f700d.f6117a.hashCode() + ((iHashCode2 + (u0Var2 != null ? u0Var2.hashCode() : 0)) * 961)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "EnterExitTransitionElement(transition=" + this.f697a + ", sizeAnimation=" + this.f698b + ", offsetAnimation=" + this.f699c + ", slideAnimation=null, enter=" + this.f700d + ", exit=" + this.f701e + ", isEnabled=" + this.f702f + ", graphicsLayerBlock=" + this.f703g + ')';
    }
}
