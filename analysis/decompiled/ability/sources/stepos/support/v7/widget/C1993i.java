package stepos.support.v7.widget;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* renamed from: stepos.support.v7.widget.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1993i extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6613a;
    public final /* synthetic */ ActionBarOverlayLayout b;

    public /* synthetic */ C1993i(ActionBarOverlayLayout actionBarOverlayLayout, int i) {
        this.f6613a = i;
        this.b = actionBarOverlayLayout;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationCancel(View view) {
        switch (this.f6613a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.b;
                actionBarOverlayLayout.f6440w = null;
                actionBarOverlayLayout.l = false;
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.b;
                actionBarOverlayLayout2.f6441x = null;
                actionBarOverlayLayout2.l = false;
                break;
        }
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationEnd(View view) {
        switch (this.f6613a) {
            case 0:
                ActionBarOverlayLayout actionBarOverlayLayout = this.b;
                actionBarOverlayLayout.f6440w = null;
                actionBarOverlayLayout.l = false;
                break;
            default:
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.b;
                actionBarOverlayLayout2.f6441x = null;
                actionBarOverlayLayout2.l = false;
                break;
        }
    }
}
