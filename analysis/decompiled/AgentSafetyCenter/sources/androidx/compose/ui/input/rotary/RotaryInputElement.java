package androidx.compose.ui.input.rotary;

import u1.y0;
import v1.n;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class RotaryInputElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public n f972c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RotaryInputElement) && this.f972c == ((RotaryInputElement) obj).f972c;
    }

    @Override // u1.y0
    public final l g() {
        n nVar = this.f972c;
        q1.a aVar = new q1.a();
        aVar.f10072s = nVar;
        return aVar;
    }

    public final int hashCode() {
        n nVar = this.f972c;
        return (nVar != null ? nVar.hashCode() : 0) * 31;
    }

    @Override // u1.y0
    public final void i(l lVar) {
        ((q1.a) lVar).f10072s = this.f972c;
    }
}
