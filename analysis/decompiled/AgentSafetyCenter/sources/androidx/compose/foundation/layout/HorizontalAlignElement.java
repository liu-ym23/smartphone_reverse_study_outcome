package androidx.compose.foundation.layout;

import u1.y0;
import w.d0;
import w0.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class HorizontalAlignElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public w0.c f878c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        HorizontalAlignElement horizontalAlignElement = obj instanceof HorizontalAlignElement ? (HorizontalAlignElement) obj : null;
        if (horizontalAlignElement == null) {
            return false;
        }
        return k.a(this.f878c, horizontalAlignElement.f878c);
    }

    @Override // u1.y0
    public final l g() {
        w0.c cVar = this.f878c;
        d0 d0Var = new d0();
        d0Var.f14963s = cVar;
        return d0Var;
    }

    public final int hashCode() {
        return Float.hashCode(this.f878c.f15104a);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        ((d0) lVar).f14963s = this.f878c;
    }
}
