package org.libpag;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
class m implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PAGView f19251a;

    m(PAGView pAGView) {
        this.f19251a = pAGView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f19251a.f19214w = valueAnimator.getCurrentPlayTime();
        PAGView.i(this.f19251a);
    }
}
