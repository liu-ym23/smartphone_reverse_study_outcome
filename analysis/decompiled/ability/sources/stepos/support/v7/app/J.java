package stepos.support.v7.app;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import fa.C1449a;
import stepos.support.v7.widget.ActionBarContainer;
import stepos.support.v7.widget.ActionBarCoordinatorLayout;

/* loaded from: classes4.dex */
public final class J extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6220a;
    public final /* synthetic */ L b;

    public /* synthetic */ J(L l, int i) {
        this.f6220a = i;
        this.b = l;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationEnd(View view) {
        switch (this.f6220a) {
            case 0:
                L l = this.b;
                ActionBarContainer actionBarContainer = l.h;
                if (actionBarContainer != null) {
                    actionBarContainer.setVisibility(8);
                }
                l.f6226t = false;
                l.f6223q = null;
                break;
            case 1:
                L l5 = this.b;
                ActionBarContainer actionBarContainer2 = l5.h;
                if (actionBarContainer2 != null) {
                    ViewCompat.setTranslationY(actionBarContainer2, 0.0f);
                    l5.f6226t = true;
                }
                l5.f6223q = null;
                break;
            case 2:
                L l9 = this.b;
                ActionBarContainer actionBarContainer3 = l9.h;
                if (actionBarContainer3 != null) {
                    actionBarContainer3.setVisibility(8);
                }
                l9.e.setVisibility(8);
                l9.e.setTransitioning(false);
                l9.f6223q = null;
                l9.f6226t = false;
                C1449a c1449a = l9.l;
                if (c1449a != null) {
                    c1449a.d((Ua.c) l9.k);
                    l9.k = null;
                    l9.l = null;
                }
                ActionBarCoordinatorLayout actionBarCoordinatorLayout = l9.c;
                if (actionBarCoordinatorLayout != null) {
                    ViewCompat.requestApplyInsets(actionBarCoordinatorLayout);
                    break;
                }
                break;
            default:
                L l10 = this.b;
                l10.f6223q = null;
                l10.f6226t = true;
                ViewCompat.setTranslationY(l10.e, 0.0f);
                ActionBarContainer actionBarContainer4 = l10.h;
                if (actionBarContainer4 != null) {
                    ViewCompat.setTranslationY(actionBarContainer4, 0.0f);
                }
                l10.e.requestLayout();
                break;
        }
    }
}
