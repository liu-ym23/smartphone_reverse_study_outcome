package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;

/* JADX INFO: loaded from: classes39.dex */
public class c extends BDAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animator f31992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f31993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Interpolator f31994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Animation.AnimationListener f31995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f31996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f31997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f31998g;

    public class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f31999a;

        public a(c r100) {
            this.f31999a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r100) {
            if (c.a(this.f31999a) == null) goto L6;
            c.a(this.f31999a).onAnimationCancel();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            if (c.a(this.f31999a) == null) goto L6;
            c.a(this.f31999a).onAnimationEnd();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r100) {
            if (c.a(this.f31999a) == null) goto L6;
            c.a(this.f31999a).onAnimationRepeat();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r100) {
            if (c.a(this.f31999a) == null) goto L6;
            c.a(this.f31999a).onAnimationStart();
            return;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimatorSetMode(int r100) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setTypeEvaluator(TypeEvaluator r100) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void cancelAnimation() {
        Animator r100 = this.f31992a;
        if (r100 == null) goto L6;
        r100.cancel();
        this.f31992a = null;
        return;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void startAnimation() {
        Animator r100 = this.f31992a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.start();
    }

    public int a() {
        return this.f31996e;
    }

    public c(float... r100) {
        this.f31992a = null;
        this.f31993b = 0;
        this.f31994c = null;
        this.f31995d = null;
        this.f31996e = 1;
        this.f31997f = 0;
        this.f31998g = r100;
    }

    public ObjectAnimator a(Marker r100) {
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "rotate", this.f31998g);
        if (r101 == null) goto L7;
        r101.setRepeatCount(this.f31997f);
        r101.setRepeatMode(a());
        r101.setDuration(this.f31993b);
        Interpolator r102 = this.f31994c;
        if (r102 == null) goto L7;
        r101.setInterpolator(r102);
    L7:
        return r101;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void addAnimationListener(Animator r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.addListener(new a(this));
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimationListener(Animation.AnimationListener r100) {
        this.f31995d = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setDuration(long r100) {
        if (r100 >= 0) goto L5;
        r100 = 0;
    L5:
        this.f31993b = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setInterpolator(Interpolator r100) {
        this.f31994c = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatCount(int r100) {
        if (r100 <= 0) goto L4;
    L5:
        this.f31997f = r100;
        return;
    L4:
        if (r100 == (-1)) goto L5;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatMode(int r100) {
        this.f31996e = r100;
    }

    public static /* synthetic */ Animation.AnimationListener a(c r100) {
        return r100.f31995d;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimation(Marker r100, Animation r101) {
        ObjectAnimator r102 = a(r100);
        this.f31992a = r102;
        addAnimationListener(r102);
    }
}
