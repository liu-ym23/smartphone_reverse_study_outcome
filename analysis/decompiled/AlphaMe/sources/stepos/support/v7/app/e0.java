package stepos.support.v7.app;

import android.view.View;
import com.stepos.alphame.utils.Property;
import java.util.WeakHashMap;
import stepos.support.v7.widget.ActionBarContainer;
import stepos.support.v7.widget.ActionBarOverlayLayout;
import stepos.support.v7.widget.FitsWindowsContentLayout;

/* loaded from: classes2.dex */
public final class e0 extends C.b {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f14447e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ g0 f14448f;

    public /* synthetic */ e0(g0 g0Var, int i4) {
        this.f14447e = i4;
        this.f14448f = g0Var;
    }

    @Override // C.b, K.f0
    public final void c(View view) {
        FitsWindowsContentLayout fitsWindowsContentLayout;
        int i4 = this.f14447e;
        g0 g0Var = this.f14448f;
        switch (i4) {
            case 2:
                if (g0Var.f14496q && (fitsWindowsContentLayout = g0Var.f14487h) != null) {
                    WeakHashMap weakHashMap = K.S.f939a;
                    fitsWindowsContentLayout.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
                    g0Var.f14483d.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
                }
                ActionBarContainer actionBarContainer = g0Var.f14486g;
                if (actionBarContainer != null) {
                    actionBarContainer.setVisibility(8);
                }
                g0Var.f14483d.setVisibility(8);
                g0Var.f14483d.setTransitioning(false);
                g0Var.f14500u = null;
                g0Var.f14505z = false;
                K3.b bVar = g0Var.f14491l;
                if (bVar != null) {
                    bVar.e(g0Var.f14490k);
                    g0Var.f14490k = null;
                    g0Var.f14491l = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = g0Var.f14482c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap2 = K.S.f939a;
                    K.H.c(actionBarOverlayLayout);
                    break;
                }
                break;
            default:
                g0Var.f14500u = null;
                g0Var.f14505z = true;
                ActionBarContainer actionBarContainer2 = g0Var.f14483d;
                WeakHashMap weakHashMap3 = K.S.f939a;
                actionBarContainer2.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
                ActionBarContainer actionBarContainer3 = g0Var.f14486g;
                if (actionBarContainer3 != null) {
                    actionBarContainer3.setTranslationY(Property.DEFAULT_FLOAT_VALUE);
                }
                g0Var.f14483d.requestLayout();
                break;
        }
    }
}
