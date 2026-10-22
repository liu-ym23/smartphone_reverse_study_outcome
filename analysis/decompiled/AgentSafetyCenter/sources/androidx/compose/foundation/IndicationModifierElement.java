package androidx.compose.foundation;

import t.s0;
import t.t0;
import u1.y0;
import v.k;
import w0.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class IndicationModifierElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public k f851c;

    /* renamed from: f, reason: collision with root package name */
    public t0 f852f;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndicationModifierElement)) {
            return false;
        }
        IndicationModifierElement indicationModifierElement = (IndicationModifierElement) obj;
        return yb.k.a(this.f851c, indicationModifierElement.f851c) && yb.k.a(this.f852f, indicationModifierElement.f852f);
    }

    @Override // u1.y0
    public final l g() {
        u1.l lVarA = this.f852f.a(this.f851c);
        s0 s0Var = new s0();
        s0Var.f13063u = lVarA;
        s0Var.B0(lVarA);
        return s0Var;
    }

    public final int hashCode() {
        return this.f852f.hashCode() + (this.f851c.hashCode() * 31);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        s0 s0Var = (s0) lVar;
        u1.l lVarA = this.f852f.a(this.f851c);
        s0Var.C0(s0Var.f13063u);
        s0Var.f13063u = lVarA;
        s0Var.B0(lVarA);
    }
}
