package stepos.support.v7.app;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.provider.Settings;
import android.view.ViewTreeObserver;
import stepos.support.v7.widget.PopupNestedScrollingLayout;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class t implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f12269a;

    public t(s sVar) {
        this.f12269a = sVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() throws Settings.SettingNotFoundException {
        float f8;
        s sVar = this.f12269a;
        sVar.f12263c.getViewTreeObserver().removeOnPreDrawListener(this);
        h1.f fVar = sVar.f12267g;
        AnimatorSet animatorSet = new AnimatorSet();
        PopupNestedScrollingLayout popupNestedScrollingLayout = sVar.f12263c;
        popupNestedScrollingLayout.setTranslationY(popupNestedScrollingLayout.getCurrentScrollY() <= 0 ? popupNestedScrollingLayout.getUncollapsibleHeight() : popupNestedScrollingLayout.getMeasuredHeight());
        h1.g gVar = new h1.g();
        gVar.a(0.88f);
        gVar.b(340.0f);
        fVar.f9241t = gVar;
        gVar.f9251i = 0.0f;
        try {
            f8 = Settings.Global.getFloat(sVar.f12264d.getContentResolver(), "transition_animation_scale");
        } catch (Exception unused) {
            f8 = 1.0f;
        }
        if (f8 != 0.0f) {
            fVar.h();
        } else {
            popupNestedScrollingLayout.setTranslationY(0.0f);
        }
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(sVar.f12261a, "alpha", 0, sVar.f12262b);
        objectAnimatorOfInt.setInterpolator(s.f12260i);
        objectAnimatorOfInt.setDuration(100L);
        animatorSet.addListener(new com.google.android.material.bottomappbar.a(sVar, 3));
        animatorSet.playTogether(objectAnimatorOfInt);
        animatorSet.start();
        return true;
    }
}
