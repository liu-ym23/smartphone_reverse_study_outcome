package androidx.compose.foundation;

import i1.j;
import i1.w0;
import kotlin.Metadata;
import n0.l;
import o.l0;
import o.m0;
import q.i;
import q7.k;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/IndicationModifierElement;", "Li1/w0;", "Lo/l0;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class IndicationModifierElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final i f713a;

    /* renamed from: b, reason: collision with root package name */
    public final m0 f714b;

    public IndicationModifierElement(i iVar, m0 m0Var) {
        this.f713a = iVar;
        this.f714b = m0Var;
    }

    @Override // i1.w0
    public final l d() {
        j jVarB = this.f714b.b(this.f713a);
        l0 l0Var = new l0();
        l0Var.f7081v = jVarB;
        l0Var.l0(jVarB);
        return l0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IndicationModifierElement)) {
            return false;
        }
        IndicationModifierElement indicationModifierElement = (IndicationModifierElement) obj;
        return k.a(this.f713a, indicationModifierElement.f713a) && k.a(this.f714b, indicationModifierElement.f714b);
    }

    @Override // i1.w0
    public final void f(l lVar) {
        l0 l0Var = (l0) lVar;
        j jVarB = this.f714b.b(this.f713a);
        l0Var.m0(l0Var.f7081v);
        l0Var.f7081v = jVarB;
        l0Var.l0(jVarB);
    }

    public final int hashCode() {
        return this.f714b.hashCode() + (this.f713a.hashCode() * 31);
    }
}
