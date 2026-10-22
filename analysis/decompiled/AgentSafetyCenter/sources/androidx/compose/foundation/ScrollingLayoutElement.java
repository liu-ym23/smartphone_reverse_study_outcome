package androidx.compose.foundation;

import t.h1;
import t.k1;
import u1.y0;
import w0.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class ScrollingLayoutElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public h1 f856c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f857f;

    public final boolean equals(Object obj) {
        if (!(obj instanceof ScrollingLayoutElement)) {
            return false;
        }
        ScrollingLayoutElement scrollingLayoutElement = (ScrollingLayoutElement) obj;
        return k.a(this.f856c, scrollingLayoutElement.f856c) && this.f857f == scrollingLayoutElement.f857f;
    }

    @Override // u1.y0
    public final l g() {
        h1 h1Var = this.f856c;
        boolean z10 = this.f857f;
        k1 k1Var = new k1();
        k1Var.f13027s = h1Var;
        k1Var.f13028t = z10;
        return k1Var;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f857f) + k0.a.h(this.f856c.hashCode() * 31, 31, false);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        k1 k1Var = (k1) lVar;
        k1Var.f13027s = this.f856c;
        k1Var.f13028t = this.f857f;
    }
}
