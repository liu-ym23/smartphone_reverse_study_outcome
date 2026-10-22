package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;

/* JADX INFO: loaded from: classes39.dex */
public class a extends BDAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animator f31977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f31978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Interpolator f31979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Animation.AnimationListener f31980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f31981e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f31982f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f31983g;

    /* JADX INFO: renamed from: com.baidu.mapsdkplatform.comapi.animation.a$a, reason: collision with other inner class name */
    public class C0641a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f31984a;

        public C0641a(a r100) {
            this.f31984a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r100) {
            if (a.a(this.f31984a) == null) goto L6;
            a.a(this.f31984a).onAnimationCancel();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            if (a.a(this.f31984a) == null) goto L6;
            a.a(this.f31984a).onAnimationEnd();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r100) {
            if (a.a(this.f31984a) == null) goto L6;
            a.a(this.f31984a).onAnimationRepeat();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r100) {
            if (a.a(this.f31984a) == null) goto L6;
            a.a(this.f31984a).onAnimationStart();
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
        Animator r100 = this.f31977a;
        if (r100 == null) goto L6;
        r100.cancel();
        this.f31977a = null;
        return;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void startAnimation() {
        Animator r100 = this.f31977a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.start();
    }

    public int a() {
        return this.f31981e;
    }

    public a(float... r100) {
        this.f31977a = null;
        this.f31978b = 0;
        this.f31979c = null;
        this.f31980d = null;
        this.f31981e = 1;
        this.f31982f = 0;
        this.f31983g = r100;
    }

    public ObjectAnimator a(Marker r100) {
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "alpha", this.f31983g);
        if (r101 == null) goto L7;
        r101.setRepeatCount(this.f31982f);
        r101.setRepeatMode(a());
        r101.setDuration(this.f31978b);
        Interpolator r102 = this.f31979c;
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
        r100.addListener(new C0641a(this));
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimationListener(Animation.AnimationListener r100) {
        this.f31980d = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setDuration(long r100) {
        if (r100 >= 0) goto L5;
        r100 = 0;
    L5:
        this.f31978b = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setInterpolator(Interpolator r100) {
        this.f31979c = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatCount(int r100) {
        if (r100 <= 0) goto L4;
    L5:
        this.f31982f = r100;
        return;
    L4:
        if (r100 == (-1)) goto L5;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatMode(int r100) {
        this.f31981e = r100;
    }

    public static /* synthetic */ Animation.AnimationListener a(a r100) {
        return r100.f31980d;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimation(Marker r100, Animation r101) {
        ObjectAnimator r102 = a(r100);
        this.f31977a = r102;
        addAnimationListener(r102);
    }
}
