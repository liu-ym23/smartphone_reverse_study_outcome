package com.stepos.common.widget;

import android.view.animation.Animation;
import h.RunnableC0583a;

/* loaded from: classes.dex */
public final class s implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11965a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PraiseView f11966b;

    public /* synthetic */ s(PraiseView praiseView, int i4) {
        this.f11965a = i4;
        this.f11966b = praiseView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        int i4 = this.f11965a;
        PraiseView praiseView = this.f11966b;
        switch (i4) {
            case 0:
                int i5 = PraiseView.f11713r;
                praiseView.getClass();
                break;
            default:
                if (praiseView.f11724k.getChildCount() >= 1) {
                    praiseView.f11724k.removeViewAt(0);
                }
                praiseView.post(new RunnableC0583a(21, this));
                break;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        switch (this.f11965a) {
            case 0:
                break;
            default:
                int i4 = PraiseView.f11713r;
                this.f11966b.getClass();
                break;
        }
    }
}
