package com.stepos.common.animator;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.stepos.common.widget.StepSeekBar;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public SpringAnimation f3559a;
    public SpringAnimation b;
    public StepSeekBar c;
    public float d;
    public float e;
    public boolean f;

    public final void a(boolean z10) {
        StepSeekBar stepSeekBar = this.c;
        SpringAnimation springAnimation = this.f3559a;
        if (springAnimation != null && springAnimation.isRunning()) {
            this.f3559a.cancel();
        }
        SpringAnimation springAnimation2 = this.b;
        if (springAnimation2 != null && springAnimation2.isRunning()) {
            this.b.cancel();
        }
        SpringAnimation springAnimation3 = new SpringAnimation(stepSeekBar, DynamicAnimation.SCALE_Y);
        SpringForce springForce = new SpringForce();
        springForce.setFinalPosition(z10 ? this.e : 1.0f);
        springForce.setStiffness(250.0f).setDampingRatio(0.89f);
        springAnimation3.setSpring(springForce);
        this.b = springAnimation3;
        springAnimation3.start();
        SpringAnimation springAnimation4 = new SpringAnimation(stepSeekBar, DynamicAnimation.SCALE_X);
        SpringForce springForce2 = new SpringForce();
        springForce2.setFinalPosition(z10 ? this.d : 1.0f);
        springForce2.setStiffness(250.0f).setDampingRatio(0.89f);
        springAnimation4.setSpring(springForce2);
        this.f3559a = springAnimation4;
        springAnimation4.start();
    }
}
