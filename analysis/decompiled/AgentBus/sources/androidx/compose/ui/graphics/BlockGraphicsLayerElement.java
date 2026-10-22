package androidx.compose.ui.graphics;

import i1.d1;
import i1.w0;
import kotlin.Metadata;
import n0.l;
import p7.k;
import u0.j;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/BlockGraphicsLayerElement;", "Li1/w0;", "Lu0/j;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class BlockGraphicsLayerElement extends w0 {

    /* renamed from: a, reason: collision with root package name */
    public final k f757a;

    public BlockGraphicsLayerElement(k kVar) {
        this.f757a = kVar;
    }

    @Override // i1.w0
    public final l d() {
        j jVar = new j();
        jVar.f9911t = this.f757a;
        return jVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BlockGraphicsLayerElement) {
            return this.f757a == ((BlockGraphicsLayerElement) obj).f757a;
        }
        return false;
    }

    @Override // i1.w0
    public final void f(l lVar) {
        j jVar = (j) lVar;
        jVar.f9911t = this.f757a;
        d1 d1Var = i1.l.s(jVar, 2).f4438u;
        if (d1Var != null) {
            d1Var.W0(jVar.f9911t, true);
        }
    }

    public final int hashCode() {
        return this.f757a.hashCode();
    }
}
