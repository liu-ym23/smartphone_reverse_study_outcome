package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;

/* JADX INFO: loaded from: classes39.dex */
public class d extends BDAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animator f32000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f32001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Interpolator f32002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Animation.AnimationListener f32003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f32006g;

    public class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f32007a;

        public a(d r100) {
            this.f32007a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r100) {
            if (d.a(this.f32007a) == null) goto L6;
            d.a(this.f32007a).onAnimationCancel();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            if (d.a(this.f32007a) == null) goto L6;
            d.a(this.f32007a).onAnimationEnd();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r100) {
            if (d.a(this.f32007a) == null) goto L6;
            d.a(this.f32007a).onAnimationRepeat();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r100) {
            if (d.a(this.f32007a) == null) goto L6;
            d.a(this.f32007a).onAnimationStart();
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
        Animator r100 = this.f32000a;
        if (r100 == null) goto L6;
        r100.cancel();
        this.f32000a = null;
        return;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void startAnimation() {
        Animator r100 = this.f32000a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.start();
    }

    public int a() {
        return this.f32004e;
    }

    public d(float... r100) {
        this.f32000a = null;
        this.f32001b = 0;
        this.f32002c = null;
        this.f32003d = null;
        this.f32004e = 1;
        this.f32005f = 0;
        this.f32006g = r100;
    }

    public ObjectAnimator a(Marker r100) {
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "scale", this.f32006g);
        if (r101 == null) goto L7;
        r101.setRepeatCount(this.f32005f);
        r101.setRepeatMode(a());
        r101.setDuration(this.f32001b);
        Interpolator r102 = this.f32002c;
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
        this.f32003d = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setDuration(long r100) {
        if (r100 >= 0) goto L5;
        r100 = 0;
    L5:
        this.f32001b = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setInterpolator(Interpolator r100) {
        this.f32002c = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatCount(int r100) {
        if (r100 <= 0) goto L4;
    L5:
        this.f32005f = r100;
        return;
    L4:
        if (r100 == (-1)) goto L5;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatMode(int r100) {
        this.f32004e = r100;
    }

    public static /* synthetic */ Animation.AnimationListener a(d r100) {
        return r100.f32003d;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimation(Marker r100, Animation r101) {
        ObjectAnimator r102 = a(r100);
        this.f32000a = r102;
        addAnimationListener(r102);
    }
}
