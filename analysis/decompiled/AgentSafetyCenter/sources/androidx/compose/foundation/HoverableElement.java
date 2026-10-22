package androidx.compose.foundation;

import t.j0;
import u1.y0;
import v.k;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class HoverableElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public k f850c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HoverableElement) && yb.k.a(((HoverableElement) obj).f850c, this.f850c);
    }

    @Override // u1.y0
    public final l g() {
        k kVar = this.f850c;
        j0 j0Var = new j0();
        j0Var.f13017s = kVar;
        return j0Var;
    }

    public final int hashCode() {
        return this.f850c.hashCode() * 31;
    }

    @Override // u1.y0
    public final void i(l lVar) {
        j0 j0Var = (j0) lVar;
        k kVar = this.f850c;
        if (yb.k.a(j0Var.f13017s, kVar)) {
            return;
        }
        j0Var.D0();
        j0Var.f13017s = kVar;
    }
}
