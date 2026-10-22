package androidx.compose.ui.input.nestedscroll;

import n1.d;
import n1.g;
import r2.i;
import u1.y0;
import w0.l;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
final class NestedScrollElement extends y0 {

    /* renamed from: c, reason: collision with root package name */
    public i f966c;

    /* renamed from: f, reason: collision with root package name */
    public d f967f;

    public final boolean equals(Object obj) {
        if (!(obj instanceof NestedScrollElement)) {
            return false;
        }
        NestedScrollElement nestedScrollElement = (NestedScrollElement) obj;
        return k.a(nestedScrollElement.f966c, this.f966c) && k.a(nestedScrollElement.f967f, this.f967f);
    }

    @Override // u1.y0
    public final l g() {
        return new g(this.f966c, this.f967f);
    }

    public final int hashCode() {
        int iHashCode = this.f966c.hashCode() * 31;
        d dVar = this.f967f;
        return iHashCode + (dVar != null ? dVar.hashCode() : 0);
    }

    @Override // u1.y0
    public final void i(l lVar) {
        g gVar = (g) lVar;
        i iVar = this.f966c;
        d dVar = this.f967f;
        gVar.f8638s = iVar;
        d dVar2 = gVar.f8639t;
        if (dVar2.f8626a == gVar) {
            dVar2.f8626a = null;
        }
        if (dVar == null) {
            gVar.f8639t = new d();
        } else if (!dVar.equals(dVar2)) {
            gVar.f8639t = dVar;
        }
        if (gVar.f15126r) {
            d dVar3 = gVar.f8639t;
            dVar3.f8626a = gVar;
            dVar3.f8627b = null;
            gVar.f8640u = null;
            dVar3.f8628c = new ad.l(gVar, 16);
            dVar3.f8629d = gVar.p0();
        }
    }
}
