package androidx.compose.foundation.layout;

import i1.w0;
import kotlin.Metadata;
import n0.l;
import q7.k;
import r.c0;
import r.d0;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesElement;", "Li1/w0;", "Lr/d0;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class PaddingValuesElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final c0 f736a;

    public PaddingValuesElement(c0 c0Var) {
        this.f736a = c0Var;
    }

    @Override // i1.w0
    public final l d() {
        d0 d0Var = new d0();
        d0Var.f8856t = this.f736a;
        return d0Var;
    }

    public final boolean equals(Object obj) {
        PaddingValuesElement paddingValuesElement = obj instanceof PaddingValuesElement ? (PaddingValuesElement) obj : null;
        if (paddingValuesElement == null) {
            return false;
        }
        return k.a(this.f736a, paddingValuesElement.f736a);
    }

    @Override // i1.w0
    public final void f(l lVar) {
        ((d0) lVar).f8856t = this.f736a;
    }

    public final int hashCode() {
        return this.f736a.hashCode();
    }
}
