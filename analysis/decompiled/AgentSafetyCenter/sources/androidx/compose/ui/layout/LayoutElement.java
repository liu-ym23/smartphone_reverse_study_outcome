package androidx.compose.ui.layout;

import s1.s;
import u1.y0;
import w0.l;
import xb.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class LayoutElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public q f973c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LayoutElement) && this.f973c == ((LayoutElement) obj).f973c;
    }

    @Override // u1.y0
    public final l g() {
        q qVar = this.f973c;
        s sVar = new s();
        sVar.f11293s = qVar;
        return sVar;
    }

    public final int hashCode() {
        return this.f973c.hashCode();
    }

    @Override // u1.y0
    public final void i(l lVar) {
        ((s) lVar).f11293s = this.f973c;
    }
}
