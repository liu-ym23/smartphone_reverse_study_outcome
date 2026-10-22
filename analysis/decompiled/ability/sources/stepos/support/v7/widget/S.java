package stepos.support.v7.widget;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: classes4.dex */
public final class S implements DynamicAnimation.OnAnimationUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PopupNestedScrollingLayout f6500a;

    public S(PopupNestedScrollingLayout popupNestedScrollingLayout) {
        this.f6500a = popupNestedScrollingLayout;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f7) {
        PopupNestedScrollingLayout popupNestedScrollingLayout = this.f6500a;
        popupNestedScrollingLayout.g(((int) f) - popupNestedScrollingLayout.p);
    }
}
