package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;

/* loaded from: classes.dex */
public class e extends BDAnimation {

    /* renamed from: a, reason: collision with root package name */
    private Animator f7884a = null;

    /* renamed from: b, reason: collision with root package name */
    private long f7885b = 0;

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f7886c = null;

    /* renamed from: d, reason: collision with root package name */
    private Animation.AnimationListener f7887d = null;

    /* renamed from: e, reason: collision with root package name */
    private int f7888e = 1;

    /* renamed from: f, reason: collision with root package name */
    private int f7889f = 0;

    /* renamed from: g, reason: collision with root package name */
    private float[] f7890g;

    /* renamed from: h, reason: collision with root package name */
    private int f7891h;

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (e.this.f7887d != null) {
                e.this.f7887d.onAnimationCancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (e.this.f7887d != null) {
                e.this.f7887d.onAnimationEnd();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (e.this.f7887d != null) {
                e.this.f7887d.onAnimationRepeat();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (e.this.f7887d != null) {
                e.this.f7887d.onAnimationStart();
            }
        }
    }

    public e(int i4, float... fArr) {
        this.f7890g = fArr;
        this.f7891h = i4;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void addAnimationListener(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new a());
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void cancelAnimation() {
        Animator animator = this.f7884a;
        if (animator != null) {
            animator.cancel();
            this.f7884a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void setAnimation(Marker marker, Animation animation) {
        ObjectAnimator objectAnimatorA = a(marker);
        this.f7884a = objectAnimatorA;
        addAnimationListener(objectAnimatorA);
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f7887d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimatorSetMode(int i4) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setDuration(long j4) {
        if (j4 < 0) {
            j4 = 0;
        }
        this.f7885b = j4;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setInterpolator(Interpolator interpolator) {
        this.f7886c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatCount(int i4) {
        if (i4 > 0 || i4 == -1) {
            this.f7889f = i4;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatMode(int i4) {
        this.f7888e = i4;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setTypeEvaluator(TypeEvaluator typeEvaluator) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void startAnimation() {
        Animator animator = this.f7884a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    public int a() {
        return this.f7888e;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator objectAnimatorOfFloat;
        int i4 = this.f7891h;
        if (i4 == 1) {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(marker, "scaleX", this.f7890g);
        } else {
            objectAnimatorOfFloat = i4 == 2 ? ObjectAnimator.ofFloat(marker, "scaleY", this.f7890g) : null;
        }
        if (objectAnimatorOfFloat != null) {
            objectAnimatorOfFloat.setRepeatCount(this.f7889f);
            objectAnimatorOfFloat.setRepeatMode(a());
            objectAnimatorOfFloat.setDuration(this.f7885b);
            Interpolator interpolator = this.f7886c;
            if (interpolator != null) {
                objectAnimatorOfFloat.setInterpolator(interpolator);
            }
        }
        return objectAnimatorOfFloat;
    }
}
