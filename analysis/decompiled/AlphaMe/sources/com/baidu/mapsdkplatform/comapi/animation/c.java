package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;

/* loaded from: classes.dex */
public class c extends BDAnimation {

    /* renamed from: a, reason: collision with root package name */
    private Animator f7868a = null;

    /* renamed from: b, reason: collision with root package name */
    private long f7869b = 0;

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f7870c = null;

    /* renamed from: d, reason: collision with root package name */
    private Animation.AnimationListener f7871d = null;

    /* renamed from: e, reason: collision with root package name */
    private int f7872e = 1;

    /* renamed from: f, reason: collision with root package name */
    private int f7873f = 0;

    /* renamed from: g, reason: collision with root package name */
    private float[] f7874g;

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (c.this.f7871d != null) {
                c.this.f7871d.onAnimationCancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (c.this.f7871d != null) {
                c.this.f7871d.onAnimationEnd();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (c.this.f7871d != null) {
                c.this.f7871d.onAnimationRepeat();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (c.this.f7871d != null) {
                c.this.f7871d.onAnimationStart();
            }
        }
    }

    public c(float... fArr) {
        this.f7874g = fArr;
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
        Animator animator = this.f7868a;
        if (animator != null) {
            animator.cancel();
            this.f7868a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void setAnimation(Marker marker, Animation animation) {
        ObjectAnimator objectAnimatorA = a(marker);
        this.f7868a = objectAnimatorA;
        addAnimationListener(objectAnimatorA);
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f7871d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimatorSetMode(int i4) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setDuration(long j4) {
        if (j4 < 0) {
            j4 = 0;
        }
        this.f7869b = j4;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setInterpolator(Interpolator interpolator) {
        this.f7870c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatCount(int i4) {
        if (i4 > 0 || i4 == -1) {
            this.f7873f = i4;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatMode(int i4) {
        this.f7872e = i4;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setTypeEvaluator(TypeEvaluator typeEvaluator) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void startAnimation() {
        Animator animator = this.f7868a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    public int a() {
        return this.f7872e;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(marker, "rotate", this.f7874g);
        if (objectAnimatorOfFloat != null) {
            objectAnimatorOfFloat.setRepeatCount(this.f7873f);
            objectAnimatorOfFloat.setRepeatMode(a());
            objectAnimatorOfFloat.setDuration(this.f7869b);
            Interpolator interpolator = this.f7870c;
            if (interpolator != null) {
                objectAnimatorOfFloat.setInterpolator(interpolator);
            }
        }
        return objectAnimatorOfFloat;
    }
}
