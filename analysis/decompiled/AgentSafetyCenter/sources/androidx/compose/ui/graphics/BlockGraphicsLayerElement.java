package androidx.compose.ui.graphics;

import d1.m;
import u1.f;
import u1.g1;
import u1.y0;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class BlockGraphicsLayerElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public l f954c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BlockGraphicsLayerElement) && this.f954c == ((BlockGraphicsLayerElement) obj).f954c;
    }

    @Override // u1.y0
    public final w0.l g() {
        l lVar = this.f954c;
        m mVar = new m();
        mVar.f3014s = lVar;
        return mVar;
    }

    public final int hashCode() {
        return this.f954c.hashCode();
    }

    @Override // u1.y0
    public final void i(w0.l lVar) {
        m mVar = (m) lVar;
        mVar.f3014s = this.f954c;
        g1 g1Var = f.s(mVar, 2).f13811t;
        if (g1Var != null) {
            g1Var.b1(mVar.f3014s, true);
        }
    }
}
