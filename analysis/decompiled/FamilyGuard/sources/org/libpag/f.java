package org.libpag;

import android.animation.ValueAnimator;

/* loaded from: classes.dex */
class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ PAGImageView f19230a;

    f(PAGImageView pAGImageView) {
        this.f19230a = pAGImageView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        if (this.f19230a.f19177u.a()) {
            if (this.f19230a.f19175s != null || this.f19230a.g()) {
                this.f19230a.f19182z = valueAnimator.getCurrentPlayTime();
                k.a(this.f19230a);
            }
        }
    }
}
