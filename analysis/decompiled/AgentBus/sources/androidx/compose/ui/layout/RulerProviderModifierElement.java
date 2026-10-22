package androidx.compose.ui.layout;

import android.annotation.SuppressLint;
import g1.j;
import g1.z;
import i1.f0;
import i1.w0;
import kotlin.Metadata;
import n0.l;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/RulerProviderModifierElement;", "Li1/w0;", "Lg1/z;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SuppressLint({"ModifierNodeInspectableProperties"})
/* loaded from: classes.dex */
final class RulerProviderModifierElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final j f769a;

    public RulerProviderModifierElement(j jVar) {
        this.f769a = jVar;
    }

    @Override // i1.w0
    public final l d() {
        return new z(this.f769a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        RulerProviderModifierElement rulerProviderModifierElement = obj instanceof RulerProviderModifierElement ? (RulerProviderModifierElement) obj : null;
        return (rulerProviderModifierElement != null ? rulerProviderModifierElement.f769a : null) == this.f769a;
    }

    @Override // i1.w0
    public final void f(l lVar) {
        z zVar = (z) lVar;
        j jVar = zVar.f3774t;
        j jVar2 = this.f769a;
        if (jVar != jVar2) {
            zVar.f3774t = jVar2;
            f0.M(i1.l.u(zVar), false, 7);
        }
    }

    public final int hashCode() {
        return this.f769a.hashCode();
    }
}
