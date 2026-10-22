package androidx.compose.foundation.layout;

import u1.y0;
import w.j0;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class OffsetPxElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public l f884c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f885f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        OffsetPxElement offsetPxElement = obj instanceof OffsetPxElement ? (OffsetPxElement) obj : null;
        return offsetPxElement != null && this.f884c == offsetPxElement.f884c && this.f885f == offsetPxElement.f885f;
    }

    @Override // u1.y0
    public final w0.l g() {
        l lVar = this.f884c;
        boolean z10 = this.f885f;
        j0 j0Var = new j0();
        j0Var.f14988s = lVar;
        j0Var.f14989t = z10;
        return j0Var;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f885f) + (this.f884c.hashCode() * 31);
    }

    @Override // u1.y0
    public final void i(w0.l lVar) {
        j0 j0Var = (j0) lVar;
        j0Var.f14988s = this.f884c;
        j0Var.f14989t = this.f885f;
    }

    public final String toString() {
        return "OffsetPxModifier(offset=" + this.f884c + ", rtlAware=" + this.f885f + ')';
    }
}
