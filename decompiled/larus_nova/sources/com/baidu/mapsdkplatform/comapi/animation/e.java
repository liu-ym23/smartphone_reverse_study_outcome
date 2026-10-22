package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;

/* JADX INFO: loaded from: classes39.dex */
public class e extends BDAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animator f32008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f32009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Interpolator f32010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Animation.AnimationListener f32011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32012e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32013f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float[] f32014g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f32015h;

    public class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f32016a;

        public a(e r100) {
            this.f32016a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r100) {
            if (e.a(this.f32016a) == null) goto L6;
            e.a(this.f32016a).onAnimationCancel();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            if (e.a(this.f32016a) == null) goto L6;
            e.a(this.f32016a).onAnimationEnd();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r100) {
            if (e.a(this.f32016a) == null) goto L6;
            e.a(this.f32016a).onAnimationRepeat();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r100) {
            if (e.a(this.f32016a) == null) goto L6;
            e.a(this.f32016a).onAnimationStart();
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
        Animator r100 = this.f32008a;
        if (r100 == null) goto L6;
        r100.cancel();
        this.f32008a = null;
        return;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void startAnimation() {
        Animator r100 = this.f32008a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.start();
    }

    public int a() {
        return this.f32012e;
    }

    public ObjectAnimator a(Marker r100) {
        int r101 = this.f32015h;
        if (r101 != 1) goto L6;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_X, this.f32014g);
    L9:
        if (r102 == null) goto L13;
        r102.setRepeatCount(this.f32013f);
        r102.setRepeatMode(a());
        r102.setDuration(this.f32009b);
        Interpolator r103 = this.f32010c;
        if (r103 == null) goto L13;
        r102.setInterpolator(r103);
    L13:
        return r102;
    L6:
        if (r101 != 2) goto L8;
        r102 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_Y, this.f32014g);
        goto L9
    L8:
        r102 = null;
        goto L9
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
        this.f32011d = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setDuration(long r100) {
        if (r100 >= 0) goto L5;
        r100 = 0;
    L5:
        this.f32009b = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setInterpolator(Interpolator r100) {
        this.f32010c = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatCount(int r100) {
        if (r100 <= 0) goto L4;
    L5:
        this.f32013f = r100;
        return;
    L4:
        if (r100 == (-1)) goto L5;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatMode(int r100) {
        this.f32012e = r100;
    }

    public static /* synthetic */ Animation.AnimationListener a(e r100) {
        return r100.f32011d;
    }

    public e(int r100, float... r101) {
        this.f32008a = null;
        this.f32009b = 0;
        this.f32010c = null;
        this.f32011d = null;
        this.f32012e = 1;
        this.f32013f = 0;
        this.f32014g = r101;
        this.f32015h = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimation(Marker r100, Animation r101) {
        ObjectAnimator r102 = a(r100);
        this.f32008a = r102;
        addAnimationListener(r102);
    }
}
