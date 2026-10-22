package h;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;
import stepos.support.v7.widget.ActionBarContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u extends ac.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4895g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f4896h;

    public /* synthetic */ u(int i) {
        this.f4895g = i;
    }

    @Override // ac.a, n3.p0
    public void c() {
        switch (this.f4895g) {
            case 0:
                ((r) this.f4896h).f4891f.f4805w.setVisibility(0);
                break;
            case 1:
                e0 e0Var = (e0) this.f4896h;
                e0Var.f4805w.setVisibility(0);
                if (e0Var.f4805w.getParent() instanceof View) {
                    View view = (View) e0Var.f4805w.getParent();
                    WeakHashMap weakHashMap = n3.k0.f8724a;
                    view.requestApplyInsets();
                    break;
                }
                break;
            case 3:
                ((stepos.support.v7.app.p) this.f4896h).f12410f.f12406y.setVisibility(0);
                break;
            case 4:
                stepos.support.v7.app.o oVar = (stepos.support.v7.app.o) this.f4896h;
                oVar.f12406y.setVisibility(0);
                oVar.f12406y.sendAccessibilityEvent(32);
                if (oVar.f12406y.getParent() != null) {
                    View view2 = (View) oVar.f12406y.getParent();
                    WeakHashMap weakHashMap2 = n3.k0.f8724a;
                    view2.requestApplyInsets();
                    break;
                }
                break;
        }
    }

    @Override // n3.p0
    public final void d() {
        switch (this.f4895g) {
            case 0:
                e0 e0Var = ((r) this.f4896h).f4891f;
                e0Var.f4805w.setAlpha(1.0f);
                e0Var.f4808z.e(null);
                e0Var.f4808z = null;
                break;
            case 1:
                e0 e0Var2 = (e0) this.f4896h;
                e0Var2.f4805w.setAlpha(1.0f);
                e0Var2.f4808z.e(null);
                e0Var2.f4808z = null;
                break;
            case 2:
                e0 e0Var3 = (e0) ((p5.l) this.f4896h).f9739f;
                e0Var3.f4805w.setVisibility(8);
                PopupWindow popupWindow = e0Var3.f4806x;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (e0Var3.f4805w.getParent() instanceof View) {
                    View view = (View) e0Var3.f4805w.getParent();
                    WeakHashMap weakHashMap = n3.k0.f8724a;
                    view.requestApplyInsets();
                }
                e0Var3.f4805w.e();
                e0Var3.f4808z.e(null);
                e0Var3.f4808z = null;
                ViewGroup viewGroup = e0Var3.C;
                WeakHashMap weakHashMap2 = n3.k0.f8724a;
                viewGroup.requestApplyInsets();
                break;
            case 3:
                stepos.support.v7.app.o oVar = ((stepos.support.v7.app.p) this.f4896h).f12410f;
                ActionBarContextView actionBarContextView = oVar.f12406y;
                WeakHashMap weakHashMap3 = n3.k0.f8724a;
                actionBarContextView.setAlpha(1.0f);
                oVar.B.e(null);
                oVar.B = null;
                break;
            case 4:
                stepos.support.v7.app.o oVar2 = (stepos.support.v7.app.o) this.f4896h;
                ActionBarContextView actionBarContextView2 = oVar2.f12406y;
                WeakHashMap weakHashMap4 = n3.k0.f8724a;
                actionBarContextView2.setAlpha(1.0f);
                oVar2.B.e(null);
                oVar2.B = null;
                break;
            default:
                stepos.support.v7.app.o oVar3 = (stepos.support.v7.app.o) ((p5.c) this.f4896h).f9718g;
                oVar3.f12406y.setVisibility(8);
                PopupWindow popupWindow2 = oVar3.f12407z;
                if (popupWindow2 != null) {
                    popupWindow2.dismiss();
                } else if (oVar3.f12406y.getParent() instanceof View) {
                    View view2 = (View) oVar3.f12406y.getParent();
                    WeakHashMap weakHashMap5 = n3.k0.f8724a;
                    view2.requestApplyInsets();
                }
                oVar3.f12406y.removeAllViews();
                oVar3.B.e(null);
                oVar3.B = null;
                break;
        }
    }
}
