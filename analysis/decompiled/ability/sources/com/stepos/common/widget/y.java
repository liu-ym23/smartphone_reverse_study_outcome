package com.stepos.common.widget;

import android.view.animation.Animation;

/* loaded from: classes3.dex */
public final class y implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3822a;
    public final /* synthetic */ PraiseView b;

    public /* synthetic */ y(PraiseView praiseView, int i) {
        this.f3822a = i;
        this.b = praiseView;
    }

    private final void a(Animation animation) {
    }

    private final void b(Animation animation) {
    }

    private final void c(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        int i = this.f3822a;
        PraiseView praiseView = this.b;
        switch (i) {
            case 0:
                int i6 = PraiseView.f3734r;
                praiseView.getClass();
                break;
            default:
                if (praiseView.k.getChildCount() >= 1) {
                    praiseView.k.removeViewAt(0);
                }
                praiseView.post(new A6.l(this, 23));
                break;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i = this.f3822a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        switch (this.f3822a) {
            case 0:
                break;
            default:
                int i = PraiseView.f3734r;
                this.b.getClass();
                break;
        }
    }
}
