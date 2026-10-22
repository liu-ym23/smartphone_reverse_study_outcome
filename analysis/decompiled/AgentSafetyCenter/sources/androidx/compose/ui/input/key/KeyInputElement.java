package androidx.compose.ui.input.key;

import m1.d;
import u1.y0;
import v1.p;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class KeyInputElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public p f965c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof KeyInputElement) && this.f965c == ((KeyInputElement) obj).f965c;
    }

    @Override // u1.y0
    public final l g() {
        p pVar = this.f965c;
        d dVar = new d();
        dVar.f8188s = pVar;
        return dVar;
    }

    public final int hashCode() {
        p pVar = this.f965c;
        return (pVar != null ? pVar.hashCode() : 0) * 31;
    }

    @Override // u1.y0
    public final void i(l lVar) {
        ((d) lVar).f8188s = this.f965c;
    }
}
