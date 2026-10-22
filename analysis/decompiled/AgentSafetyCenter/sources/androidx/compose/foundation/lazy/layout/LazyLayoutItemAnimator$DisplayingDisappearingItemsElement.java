package androidx.compose.foundation.lazy.layout;

import u1.y0;
import w0.l;
import y.q;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class LazyLayoutItemAnimator$DisplayingDisappearingItemsElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public a f909c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LazyLayoutItemAnimator$DisplayingDisappearingItemsElement) && k.a(this.f909c, ((LazyLayoutItemAnimator$DisplayingDisappearingItemsElement) obj).f909c);
    }

    @Override // u1.y0
    public final l g() {
        a aVar = this.f909c;
        q qVar = new q();
        qVar.f15815s = aVar;
        return qVar;
    }

    public final int hashCode() {
        return this.f909c.hashCode();
    }

    @Override // u1.y0
    public final void i(l lVar) {
        q qVar = (q) lVar;
        a aVar = this.f909c;
        if (k.a(qVar.f15815s, aVar) || !qVar.f15114c.f15126r) {
            return;
        }
        qVar.f15815s.c();
        aVar.getClass();
        qVar.f15815s = aVar;
    }

    public final String toString() {
        return "DisplayingDisappearingItemsElement(animator=" + this.f909c + ')';
    }
}
