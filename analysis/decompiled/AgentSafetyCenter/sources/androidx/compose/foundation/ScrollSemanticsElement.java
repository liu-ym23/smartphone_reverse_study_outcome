package androidx.compose.foundation;

import t.e1;
import t.h1;
import u1.y0;
import w0.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class ScrollSemanticsElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public h1 f853c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f854f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f855g;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScrollSemanticsElement)) {
            return false;
        }
        ScrollSemanticsElement scrollSemanticsElement = (ScrollSemanticsElement) obj;
        return k.a(this.f853c, scrollSemanticsElement.f853c) && this.f854f == scrollSemanticsElement.f854f && this.f855g == scrollSemanticsElement.f855g;
    }

    @Override // u1.y0
    public final l g() {
        h1 h1Var = this.f853c;
        boolean z10 = this.f855g;
        e1 e1Var = new e1();
        e1Var.f12967s = h1Var;
        e1Var.f12968t = z10;
        return e1Var;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f855g) + k0.a.h(k0.a.h(this.f853c.hashCode() * 31, 961, false), 31, this.f854f);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        e1 e1Var = (e1) lVar;
        e1Var.f12967s = this.f853c;
        e1Var.f12968t = this.f855g;
    }

    public final String toString() {
        return "ScrollSemanticsElement(state=" + this.f853c + ", reverseScrolling=false, flingBehavior=null, isScrollable=" + this.f854f + ", isVertical=" + this.f855g + ')';
    }
}
