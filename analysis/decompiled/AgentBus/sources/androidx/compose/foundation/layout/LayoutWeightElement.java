package androidx.compose.foundation.layout;

import i1.w0;
import kotlin.Metadata;
import n0.l;
import r.a0;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/LayoutWeightElement;", "Li1/w0;", "Lr/a0;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutWeightElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final float f731a;

    public LayoutWeightElement(float f10) {
        this.f731a = f10;
    }

    @Override // i1.w0
    public final l d() {
        a0 a0Var = new a0();
        a0Var.f8841t = this.f731a;
        a0Var.f8842u = true;
        return a0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        LayoutWeightElement layoutWeightElement = obj instanceof LayoutWeightElement ? (LayoutWeightElement) obj : null;
        return layoutWeightElement != null && this.f731a == layoutWeightElement.f731a;
    }

    @Override // i1.w0
    public final void f(l lVar) {
        a0 a0Var = (a0) lVar;
        a0Var.f8841t = this.f731a;
        a0Var.f8842u = true;
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + (Float.hashCode(this.f731a) * 31);
    }
}
