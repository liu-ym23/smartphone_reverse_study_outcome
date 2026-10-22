package com.stepos.common.animator;

import android.view.animation.Interpolator;
import androidx.dynamicanimation.animation.SpringAnimation;

/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3563a;
    public final /* synthetic */ SpringAnimation b;

    public /* synthetic */ e(SpringAnimation springAnimation, int i) {
        this.f3563a = i;
        this.b = springAnimation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f3563a;
        SpringAnimation springAnimation = this.b;
        switch (i) {
            case 0:
                Interpolator interpolator = StepOSPressAnimationDrawable.f3546C;
                if (springAnimation != null) {
                    springAnimation.start();
                    break;
                }
                break;
            default:
                if (springAnimation != null) {
                    springAnimation.start();
                    break;
                }
                break;
        }
    }
}
