package stepos.support.v7.widget;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

/* renamed from: stepos.support.v7.widget.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ViewTreeObserverOnPreDrawListenerC1985e implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f6608a;
    public final /* synthetic */ ActionBarContextView b;

    public ViewTreeObserverOnPreDrawListenerC1985e(ActionBarContextView actionBarContextView, ViewGroup viewGroup, int i) {
        this.b = actionBarContextView;
        this.f6608a = viewGroup;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ViewGroup viewGroup = this.f6608a;
        viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
        ActionBarContextView actionBarContextView = this.b;
        int i = actionBarContextView.f6411w;
        C4.a aVar = actionBarContextView.y;
        if (i == 2) {
            aVar.onAnimationEnd(viewGroup);
            return false;
        }
        ViewCompat.setTranslationY(viewGroup, viewGroup.getHeight());
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatTranslationY = ViewCompat.animate(viewGroup).translationY(0.0f);
        viewPropertyAnimatorCompatTranslationY.setDuration(260L);
        viewPropertyAnimatorCompatTranslationY.setInterpolator(ActionBarContextView.f6404A);
        ((ActionBarContextView) aVar.c).f6413z = viewPropertyAnimatorCompatTranslationY;
        viewPropertyAnimatorCompatTranslationY.setListener(aVar);
        viewPropertyAnimatorCompatTranslationY.start();
        return false;
    }
}
