package androidx.compose.ui.draw;

import i1.w0;
import kotlin.Metadata;
import n0.l;
import p7.k;
import r0.d;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/draw/DrawBehindElement;", "Li1/w0;", "Lr0/d;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class DrawBehindElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final k f755a;

    public DrawBehindElement(k kVar) {
        this.f755a = kVar;
    }

    @Override // i1.w0
    public final l d() {
        d dVar = new d();
        dVar.f8962t = this.f755a;
        return dVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DrawBehindElement) {
            return this.f755a == ((DrawBehindElement) obj).f755a;
        }
        return false;
    }

    @Override // i1.w0
    public final void f(l lVar) {
        ((d) lVar).f8962t = this.f755a;
    }

    public final int hashCode() {
        return this.f755a.hashCode();
    }
}
