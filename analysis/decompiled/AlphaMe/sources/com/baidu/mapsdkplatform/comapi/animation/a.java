package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;
import com.stepos.activeview.moveline.item.ViewTweenItem;

/* loaded from: classes.dex */
public class a extends BDAnimation {

    /* renamed from: a, reason: collision with root package name */
    private Animator f7853a = null;

    /* renamed from: b, reason: collision with root package name */
    private long f7854b = 0;

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f7855c = null;

    /* renamed from: d, reason: collision with root package name */
    private Animation.AnimationListener f7856d = null;

    /* renamed from: e, reason: collision with root package name */
    private int f7857e = 1;

    /* renamed from: f, reason: collision with root package name */
    private int f7858f = 0;

    /* renamed from: g, reason: collision with root package name */
    private float[] f7859g;

    /* renamed from: com.baidu.mapsdkplatform.comapi.animation.a$a, reason: collision with other inner class name */
    public class C0024a implements Animator.AnimatorListener {
        public C0024a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (a.this.f7856d != null) {
                a.this.f7856d.onAnimationCancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (a.this.f7856d != null) {
                a.this.f7856d.onAnimationEnd();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (a.this.f7856d != null) {
                a.this.f7856d.onAnimationRepeat();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (a.this.f7856d != null) {
                a.this.f7856d.onAnimationStart();
            }
        }
    }

    public a(float... fArr) {
        this.f7859g = fArr;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void addAnimationListener(Animator animator) {
        if (animator == null) {
            return;
        }
        animator.addListener(new C0024a());
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void cancelAnimation() {
        Animator animator = this.f7853a;
        if (animator != null) {
            animator.cancel();
            this.f7853a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void setAnimation(Marker marker, Animation animation) {
        ObjectAnimator objectAnimatorA = a(marker);
        this.f7853a = objectAnimatorA;
        addAnimationListener(objectAnimatorA);
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f7856d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimatorSetMode(int i4) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setDuration(long j4) {
        if (j4 < 0) {
            j4 = 0;
        }
        this.f7854b = j4;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setInterpolator(Interpolator interpolator) {
        this.f7855c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatCount(int i4) {
        if (i4 > 0 || i4 == -1) {
            this.f7858f = i4;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatMode(int i4) {
        this.f7857e = i4;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setTypeEvaluator(TypeEvaluator typeEvaluator) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void startAnimation() {
        Animator animator = this.f7853a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    public int a() {
        return this.f7857e;
    }

    @TargetApi(11)
    public ObjectAnimator a(Marker marker) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(marker, ViewTweenItem.ALPHA, this.f7859g);
        if (objectAnimatorOfFloat != null) {
            objectAnimatorOfFloat.setRepeatCount(this.f7858f);
            objectAnimatorOfFloat.setRepeatMode(a());
            objectAnimatorOfFloat.setDuration(this.f7854b);
            Interpolator interpolator = this.f7855c;
            if (interpolator != null) {
                objectAnimatorOfFloat.setInterpolator(interpolator);
            }
        }
        return objectAnimatorOfFloat;
    }
}
