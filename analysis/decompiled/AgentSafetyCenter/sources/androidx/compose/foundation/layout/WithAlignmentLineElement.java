package androidx.compose.foundation.layout;

import s1.l;
import u1.y0;
import w.t0;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class WithAlignmentLineElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public l f897c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        WithAlignmentLineElement withAlignmentLineElement = obj instanceof WithAlignmentLineElement ? (WithAlignmentLineElement) obj : null;
        if (withAlignmentLineElement == null) {
            return false;
        }
        return k.a(this.f897c, withAlignmentLineElement.f897c);
    }

    @Override // u1.y0
    public final w0.l g() {
        l lVar = this.f897c;
        t0 t0Var = new t0();
        t0Var.f15048s = lVar;
        return t0Var;
    }

    public final int hashCode() {
        return this.f897c.hashCode();
    }

    @Override // u1.y0
    public final void i(w0.l lVar) {
        ((t0) lVar).f15048s = this.f897c;
    }
}
