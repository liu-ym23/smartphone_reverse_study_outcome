package h;

import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import m.b1;
import m.v2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t implements b1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4893a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f4894b;

    public /* synthetic */ t(int i) {
        this.f4893a = i;
    }

    @Override // m.b1
    public final void onDetachedFromWindow() {
        m.k kVar;
        switch (this.f4893a) {
            case 0:
                e0 e0Var = (e0) this.f4894b;
                ActionBarOverlayLayout actionBarOverlayLayout = e0Var.f4801s;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.e();
                    ActionMenuView actionMenuView = ((v2) actionBarOverlayLayout.i).f8097a.f804c;
                    if (actionMenuView != null && (kVar = actionMenuView.f796x) != null) {
                        kVar.f();
                        m.g gVar = kVar.f7962x;
                        if (gVar != null && gVar.b()) {
                            gVar.i.dismiss();
                        }
                    }
                }
                if (e0Var.f4806x != null) {
                    e0Var.f4795m.getDecorView().removeCallbacks(e0Var.f4807y);
                    if (e0Var.f4806x.isShowing()) {
                        try {
                            e0Var.f4806x.dismiss();
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                    e0Var.f4806x = null;
                }
                n3.o0 o0Var = e0Var.f4808z;
                if (o0Var != null) {
                    o0Var.b();
                }
                l.l lVar = e0Var.x(0).f4773h;
                if (lVar != null) {
                    lVar.c(true);
                    break;
                }
                break;
            default:
                stepos.support.v7.app.o oVar = (stepos.support.v7.app.o) this.f4894b;
                stepos.support.v7.widget.b0 b0Var = oVar.f12402u;
                if (b0Var != null) {
                    b0Var.i();
                }
                if (oVar.f12407z != null) {
                    oVar.f12388f.getDecorView().removeCallbacks(oVar.A);
                    if (oVar.f12407z.isShowing()) {
                        try {
                            oVar.f12407z.dismiss();
                        } catch (IllegalArgumentException unused2) {
                        }
                    }
                    oVar.f12407z = null;
                }
                oVar.p();
                te.l lVar2 = oVar.r(0).f12467h;
                if (lVar2 != null) {
                    lVar2.c(true);
                    break;
                }
                break;
        }
    }
}
