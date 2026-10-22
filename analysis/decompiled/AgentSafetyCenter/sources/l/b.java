package l;

import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;
import m.m1;
import m.v0;
import stepos.support.v7.widget.j0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends m1 {

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f7522n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ View f7523o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(m.x xVar, m.x xVar2, int i) {
        super(xVar2);
        this.f7522n = i;
        this.f7523o = xVar;
    }

    @Override // m.m1
    public final b0 b() {
        m.g gVar;
        stepos.support.v7.widget.l lVar;
        switch (this.f7522n) {
            case 0:
                c cVar = ((ActionMenuItemView) this.f7523o).f720p;
                if (cVar == null || (gVar = ((m.h) cVar).f7918a.f7962x) == null) {
                    return null;
                }
                return gVar.a();
            case 1:
                m.g gVar2 = ((m.j) this.f7523o).f7929h.f7961w;
                if (gVar2 == null) {
                    return null;
                }
                return gVar2.a();
            case 2:
                stepos.support.v7.widget.l lVar2 = ((stepos.support.v7.widget.o) this.f7523o).f12781h.E;
                if (lVar2 == null) {
                    return null;
                }
                return lVar2.f13404m;
            default:
                te.d dVar = ((stepos.support.v7.view.menu.ActionMenuItemView) this.f7523o).f12531p;
                if (dVar == null || (lVar = ((stepos.support.v7.widget.m) dVar).f12777a.F) == null) {
                    return null;
                }
                return lVar.f13404m;
        }
    }

    @Override // m.m1
    public final boolean c() {
        b0 b0VarB;
        stepos.support.v7.widget.l lVar;
        switch (this.f7522n) {
            case 0:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.f7523o;
                k kVar = actionMenuItemView.f718n;
                if (kVar == null || !kVar.a(actionMenuItemView.f715k) || (b0VarB = b()) == null || !b0VarB.b()) {
                }
                break;
            case 1:
                ((m.j) this.f7523o).f7929h.l();
                break;
            case 2:
                ((stepos.support.v7.widget.o) this.f7523o).f12781h.o();
                break;
            default:
                stepos.support.v7.view.menu.ActionMenuItemView actionMenuItemView2 = (stepos.support.v7.view.menu.ActionMenuItemView) this.f7523o;
                te.k kVar2 = actionMenuItemView2.f12529n;
                if (kVar2 != null && kVar2.d(actionMenuItemView2.f12526k)) {
                    te.d dVar = actionMenuItemView2.f12531p;
                    j0 j0Var = (dVar == null || (lVar = ((stepos.support.v7.widget.m) dVar).f12777a.F) == null) ? null : lVar.f13404m;
                    if (j0Var == null || !j0Var.D.isShowing()) {
                    }
                }
                break;
        }
        return true;
    }

    @Override // m.m1
    public boolean d() {
        switch (this.f7522n) {
            case 1:
                m.k kVar = ((m.j) this.f7523o).f7929h;
                if (kVar.f7963y != null) {
                    return false;
                }
                kVar.f();
                return true;
            case 2:
                stepos.support.v7.widget.q qVar = ((stepos.support.v7.widget.o) this.f7523o).f12781h;
                if (qVar.G != null) {
                    return false;
                }
                qVar.j();
                return true;
            default:
                return super.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(v0 v0Var, int i) {
        super(v0Var);
        this.f7522n = i;
        this.f7523o = v0Var;
    }
}
