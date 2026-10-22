package com.stepos.common.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.provider.Settings;
import android.view.ViewTreeObserver;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* renamed from: com.stepos.common.widget.t, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class ViewTreeObserverOnPreDrawListenerC1114t implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3812a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ViewTreeObserverOnPreDrawListenerC1114t(Object obj, int i) {
        this.f3812a = i;
        this.b = obj;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() throws Settings.SettingNotFoundException {
        float f;
        int i = this.f3812a;
        Object obj = this.b;
        switch (i) {
            case 0:
                EmptyView emptyView = (EmptyView) obj;
                emptyView.d.getViewTreeObserver().removeOnPreDrawListener(this);
                emptyView.d.post(new A6.l(this, 22));
                break;
            default:
                stepos.support.v7.app.F f7 = (stepos.support.v7.app.F) obj;
                f7.c.getViewTreeObserver().removeOnPreDrawListener(this);
                SpringAnimation springAnimation = f7.g;
                AnimatorSet animatorSet = new AnimatorSet();
                PopupNestedScrollingLayout popupNestedScrollingLayout = f7.c;
                popupNestedScrollingLayout.setTranslationY(popupNestedScrollingLayout.getCurrentScrollY() <= 0 ? popupNestedScrollingLayout.getUncollapsibleHeight() : popupNestedScrollingLayout.getMeasuredHeight());
                springAnimation.setSpring(new SpringForce().setDampingRatio(0.88f).setStiffness(340.0f));
                springAnimation.getSpring().setFinalPosition(0.0f);
                try {
                    f = Settings.Global.getFloat(f7.d.getContentResolver(), "transition_animation_scale");
                } catch (Exception unused) {
                    f = 1.0f;
                }
                if (f != 0.0f) {
                    springAnimation.start();
                } else {
                    popupNestedScrollingLayout.setTranslationY(0.0f);
                }
                ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(f7.f6216a, "alpha", 0, f7.b);
                objectAnimatorOfInt.setInterpolator(stepos.support.v7.app.F.i);
                objectAnimatorOfInt.setDuration(100L);
                animatorSet.addListener(new stepos.support.v7.app.E(f7, 0));
                animatorSet.playTogether(objectAnimatorOfInt);
                animatorSet.start();
                break;
        }
        return true;
    }
}
