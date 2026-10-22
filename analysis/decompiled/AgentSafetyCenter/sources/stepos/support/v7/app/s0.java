package stepos.support.v7.app;

import java.util.WeakHashMap;
import stepos.support.v7.widget.ActionBarContainer;
import stepos.support.v7.widget.ActionBarOverlayLayout;
import stepos.support.v7.widget.FitsWindowsContentLayout;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class s0 extends ac.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f12477g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ t0 f12478h;

    public /* synthetic */ s0(t0 t0Var, int i) {
        this.f12477g = i;
        this.f12478h = t0Var;
    }

    @Override // n3.p0
    public final void d() {
        FitsWindowsContentLayout fitsWindowsContentLayout;
        int i = this.f12477g;
        t0 t0Var = this.f12478h;
        switch (i) {
            case 0:
                if (t0Var.f12494q && (fitsWindowsContentLayout = t0Var.f12486h) != null) {
                    WeakHashMap weakHashMap = n3.k0.f8724a;
                    fitsWindowsContentLayout.setTranslationY(0.0f);
                    t0Var.f12482d.setTranslationY(0.0f);
                }
                ActionBarContainer actionBarContainer = t0Var.f12485g;
                if (actionBarContainer != null) {
                    actionBarContainer.setVisibility(8);
                }
                t0Var.f12482d.setVisibility(8);
                t0Var.f12482d.setTransitioning(false);
                t0Var.f12498u = null;
                t0Var.f12503z = false;
                p5.c cVar = t0Var.f12489l;
                if (cVar != null) {
                    cVar.e(t0Var.f12488k);
                    t0Var.f12488k = null;
                    t0Var.f12489l = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = t0Var.f12481c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap2 = n3.k0.f8724a;
                    actionBarOverlayLayout.requestApplyInsets();
                    break;
                }
                break;
            default:
                t0Var.f12498u = null;
                t0Var.f12503z = true;
                ActionBarContainer actionBarContainer2 = t0Var.f12482d;
                WeakHashMap weakHashMap3 = n3.k0.f8724a;
                actionBarContainer2.setTranslationY(0.0f);
                ActionBarContainer actionBarContainer3 = t0Var.f12485g;
                if (actionBarContainer3 != null) {
                    actionBarContainer3.setTranslationY(0.0f);
                }
                t0Var.f12482d.requestLayout();
                break;
        }
    }
}
