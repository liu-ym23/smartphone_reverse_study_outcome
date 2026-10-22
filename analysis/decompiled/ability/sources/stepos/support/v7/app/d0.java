package stepos.support.v7.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import fa.C1449a;
import stepos.support.v7.widget.ActionBarContainer;
import stepos.support.v7.widget.ActionBarOverlayLayout;
import stepos.support.v7.widget.FitsWindowsContentLayout;

/* loaded from: classes4.dex */
public final class d0 extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6294a;
    public final /* synthetic */ e0 b;

    public /* synthetic */ d0(e0 e0Var, int i) {
        this.f6294a = i;
        this.b = e0Var;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationEnd(View view) {
        FitsWindowsContentLayout fitsWindowsContentLayout;
        switch (this.f6294a) {
            case 0:
                e0 e0Var = this.b;
                ActionBarContainer actionBarContainer = e0Var.g;
                if (actionBarContainer != null) {
                    actionBarContainer.setVisibility(8);
                }
                e0Var.f6311z = false;
                e0Var.u = null;
                break;
            case 1:
                e0 e0Var2 = this.b;
                ActionBarContainer actionBarContainer2 = e0Var2.g;
                if (actionBarContainer2 != null) {
                    ViewCompat.setTranslationY(actionBarContainer2, 0.0f);
                    e0Var2.f6311z = true;
                }
                e0Var2.u = null;
                break;
            case 2:
                e0 e0Var3 = this.b;
                if (e0Var3.f6304q && (fitsWindowsContentLayout = e0Var3.h) != null) {
                    ViewCompat.setTranslationY(fitsWindowsContentLayout, 0.0f);
                    ViewCompat.setTranslationY(e0Var3.d, 0.0f);
                }
                ActionBarContainer actionBarContainer3 = e0Var3.g;
                if (actionBarContainer3 != null) {
                    actionBarContainer3.setVisibility(8);
                }
                e0Var3.d.setVisibility(8);
                e0Var3.d.setTransitioning(false);
                e0Var3.u = null;
                e0Var3.f6311z = false;
                C1449a c1449a = e0Var3.l;
                if (c1449a != null) {
                    c1449a.d((Ua.c) e0Var3.k);
                    e0Var3.k = null;
                    e0Var3.l = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = e0Var3.c;
                if (actionBarOverlayLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarOverlayLayout);
                    break;
                }
                break;
            default:
                e0 e0Var4 = this.b;
                e0Var4.u = null;
                e0Var4.f6311z = true;
                ViewCompat.setTranslationY(e0Var4.d, 0.0f);
                ActionBarContainer actionBarContainer4 = e0Var4.g;
                if (actionBarContainer4 != null) {
                    ViewCompat.setTranslationY(actionBarContainer4, 0.0f);
                }
                e0Var4.d.requestLayout();
                break;
        }
    }
}
