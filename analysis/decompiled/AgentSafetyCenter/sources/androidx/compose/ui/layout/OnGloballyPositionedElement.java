package androidx.compose.ui.layout;

import s1.j0;
import u1.y0;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class OnGloballyPositionedElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public l f974c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof OnGloballyPositionedElement) && this.f974c == ((OnGloballyPositionedElement) obj).f974c;
    }

    @Override // u1.y0
    public final w0.l g() {
        l lVar = this.f974c;
        j0 j0Var = new j0();
        j0Var.f11261s = lVar;
        return j0Var;
    }

    public final int hashCode() {
        return this.f974c.hashCode();
    }

    @Override // u1.y0
    public final void i(w0.l lVar) {
        ((j0) lVar).f11261s = this.f974c;
    }
}
