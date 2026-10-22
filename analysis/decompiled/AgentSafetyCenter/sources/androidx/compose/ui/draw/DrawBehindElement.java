package androidx.compose.ui.draw;

import a1.e;
import u1.y0;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class DrawBehindElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public l f946c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DrawBehindElement) && this.f946c == ((DrawBehindElement) obj).f946c;
    }

    @Override // u1.y0
    public final w0.l g() {
        l lVar = this.f946c;
        e eVar = new e();
        eVar.f16s = lVar;
        return eVar;
    }

    public final int hashCode() {
        return this.f946c.hashCode();
    }

    @Override // u1.y0
    public final void i(w0.l lVar) {
        ((e) lVar).f16s = this.f946c;
    }
}
