package androidx.compose.foundation.layout;

import u1.y0;
import w.l0;
import w.m0;
import w0.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class PaddingValuesElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public l0 f890c;

    public final boolean equals(Object obj) {
        PaddingValuesElement paddingValuesElement = obj instanceof PaddingValuesElement ? (PaddingValuesElement) obj : null;
        if (paddingValuesElement == null) {
            return false;
        }
        return k.a(this.f890c, paddingValuesElement.f890c);
    }

    @Override // u1.y0
    public final l g() {
        l0 l0Var = this.f890c;
        m0 m0Var = new m0();
        m0Var.f15009s = l0Var;
        return m0Var;
    }

    public final int hashCode() {
        return this.f890c.hashCode();
    }

    @Override // u1.y0
    public final void i(l lVar) {
        ((m0) lVar).f15009s = this.f890c;
    }
}
