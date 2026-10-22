package androidx.compose.ui.input.pointer;

import java.lang.invoke.VarHandle;
import o1.a;
import o1.m;
import u1.y0;
import w0.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PointerHoverIconModifierElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public a f968c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PointerHoverIconModifierElement) && k.a(this.f968c, ((PointerHoverIconModifierElement) obj).f968c);
    }

    @Override // u1.y0
    public final l g() {
        a aVar = this.f968c;
        m mVar = new m();
        mVar.f9063s = aVar;
        VarHandle.storeStoreFence();
        return mVar;
    }

    public final int hashCode() {
        return Boolean.hashCode(false) + (this.f968c.f8999b * 31);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        m mVar = (m) lVar;
        a aVar = this.f968c;
        if (k.a(mVar.f9063s, aVar)) {
            return;
        }
        mVar.f9063s = aVar;
        if (mVar.f9064t) {
            mVar.D0();
        }
    }

    public final String toString() {
        return "PointerHoverIconModifierElement(icon=" + this.f968c + ", overrideDescendants=false)";
    }
}
