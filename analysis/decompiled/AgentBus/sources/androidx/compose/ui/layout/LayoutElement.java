package androidx.compose.ui.layout;

import i1.w0;
import kotlin.Metadata;
import n0.l;
import p7.o;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/LayoutElement;", "Li1/w0;", "Lg1/l;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class LayoutElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final o f768a;

    public LayoutElement(o oVar) {
        this.f768a = oVar;
    }

    @Override // i1.w0
    public final l d() {
        g1.l lVar = new g1.l();
        lVar.f3750t = this.f768a;
        return lVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LayoutElement) {
            return this.f768a == ((LayoutElement) obj).f768a;
        }
        return false;
    }

    @Override // i1.w0
    public final void f(l lVar) {
        ((g1.l) lVar).f3750t = this.f768a;
    }

    public final int hashCode() {
        return this.f768a.hashCode();
    }
}
