package stepos.support.v7.app;

import java.util.WeakHashMap;
import stepos.support.v7.widget.ActionBarContainer;
import stepos.support.v7.widget.ActionBarCoordinatorLayout;
import stepos.support.v7.widget.StepOSAppBarLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class y extends ac.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f12519g = 1;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ a0 f12520h;

    @Override // n3.p0
    public final void d() {
        switch (this.f12519g) {
            case 0:
                a0 a0Var = this.f12520h;
                ActionBarContainer actionBarContainer = a0Var.f12273h;
                if (actionBarContainer != null) {
                    actionBarContainer.setVisibility(8);
                }
                a0Var.f12270e.setVisibility(8);
                a0Var.f12270e.setTransitioning(false);
                a0Var.f12281q = null;
                a0Var.f12284t = false;
                p5.c cVar = a0Var.f12276l;
                if (cVar != null) {
                    cVar.e(a0Var.f12275k);
                    a0Var.f12275k = null;
                    a0Var.f12276l = null;
                }
                ActionBarCoordinatorLayout actionBarCoordinatorLayout = a0Var.f12268c;
                if (actionBarCoordinatorLayout != null) {
                    WeakHashMap weakHashMap = n3.k0.f8724a;
                    actionBarCoordinatorLayout.requestApplyInsets();
                    break;
                }
                break;
            default:
                a0 a0Var2 = this.f12520h;
                a0Var2.f12281q = null;
                a0Var2.f12284t = true;
                StepOSAppBarLayout stepOSAppBarLayout = a0Var2.f12270e;
                WeakHashMap weakHashMap2 = n3.k0.f8724a;
                stepOSAppBarLayout.setTranslationY(0.0f);
                ActionBarContainer actionBarContainer2 = a0Var2.f12273h;
                if (actionBarContainer2 != null) {
                    actionBarContainer2.setTranslationY(0.0f);
                }
                a0Var2.f12270e.requestLayout();
                break;
        }
    }
}
