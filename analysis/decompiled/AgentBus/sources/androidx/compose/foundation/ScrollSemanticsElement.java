package androidx.compose.foundation;

import i1.w0;
import kotlin.Metadata;
import m.x;
import n0.l;
import o.v0;
import o.y0;
import q7.k;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/ScrollSemanticsElement;", "Li1/w0;", "Lo/v0;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class ScrollSemanticsElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final y0 f715a;

    public ScrollSemanticsElement(y0 y0Var) {
        this.f715a = y0Var;
    }

    @Override // i1.w0
    public final l d() {
        v0 v0Var = new v0();
        v0Var.f7137t = this.f715a;
        v0Var.f7138u = true;
        return v0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ScrollSemanticsElement) && k.a(this.f715a, ((ScrollSemanticsElement) obj).f715a);
    }

    @Override // i1.w0
    public final void f(l lVar) {
        v0 v0Var = (v0) lVar;
        v0Var.f7137t = this.f715a;
        v0Var.f7138u = true;
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + x.e(x.e(this.f715a.hashCode() * 31, 961, false), 31, true);
    }

    public final String toString() {
        return "ScrollSemanticsElement(state=" + this.f715a + ", reverseScrolling=false, flingBehavior=null, isScrollable=true, isVertical=true)";
    }
}
