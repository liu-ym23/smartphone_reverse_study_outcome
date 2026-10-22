package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.AlphaAnimation;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.animation.RotateAnimation;
import com.baidu.mapapi.animation.ScaleAnimation;
import com.baidu.mapapi.animation.SingleScaleAnimation;
import com.baidu.mapapi.animation.Transformation;
import com.baidu.mapapi.map.Marker;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class b extends BDAnimation {

    /* renamed from: a, reason: collision with root package name */
    private Animator f7861a = null;

    /* renamed from: b, reason: collision with root package name */
    private long f7862b = 0;

    /* renamed from: c, reason: collision with root package name */
    private Interpolator f7863c = null;

    /* renamed from: d, reason: collision with root package name */
    private Animation.AnimationListener f7864d = null;

    /* renamed from: e, reason: collision with root package name */
    private int f7865e = 0;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<Animation> f7866f = new ArrayList<>();

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (b.this.f7864d != null) {
                b.this.f7864d.onAnimationCancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (b.this.f7864d != null) {
                b.this.f7864d.onAnimationEnd();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            if (b.this.f7864d != null) {
                b.this.f7864d.onAnimationRepeat();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (b.this.f7864d != null) {
                b.this.f7864d.onAnimationStart();
            }
        }
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
        Animator animator = this.f7861a;
        if (animator != null) {
            animator.cancel();
            this.f7861a = null;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void setAnimation(Marker marker, Animation animation) {
        ObjectAnimator objectAnimatorA;
        this.f7861a = new AnimatorSet();
        ArrayList<Animation> arrayList = this.f7866f;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.clear();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            Animation animation2 = arrayList.get(i4);
            if (animation2 != null && (objectAnimatorA = a(marker, animation2)) != null) {
                arrayList2.add(objectAnimatorA);
            }
        }
        long j4 = this.f7862b;
        if (j4 != 0) {
            this.f7861a.setDuration(j4);
        }
        Interpolator interpolator = this.f7863c;
        if (interpolator != null) {
            this.f7861a.setInterpolator(interpolator);
        }
        if (arrayList2.size() != 0) {
            int i5 = this.f7865e;
            if (i5 == 0) {
                ((AnimatorSet) this.f7861a).playTogether(arrayList2);
            } else if (i5 == 1) {
                ((AnimatorSet) this.f7861a).playSequentially(arrayList2);
            }
        }
        addAnimationListener(this.f7861a);
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        this.f7864d = animationListener;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimatorSetMode(int i4) {
        this.f7865e = i4;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setDuration(long j4) {
        if (j4 < 0) {
            j4 = 0;
        }
        this.f7862b = j4;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setInterpolator(Interpolator interpolator) {
        this.f7863c = interpolator;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatCount(int i4) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatMode(int i4) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setTypeEvaluator(TypeEvaluator typeEvaluator) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    @TargetApi(11)
    public void startAnimation() {
        Animator animator = this.f7861a;
        if (animator == null) {
            return;
        }
        animator.start();
    }

    public void a(Animation animation) {
        if (this.f7866f.contains(animation)) {
            return;
        }
        this.f7866f.add(animation);
    }

    @TargetApi(11)
    private ObjectAnimator a(Marker marker, Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return ((com.baidu.mapsdkplatform.comapi.animation.a) animation.bdAnimation).a(marker);
        }
        if (animation instanceof RotateAnimation) {
            return ((c) animation.bdAnimation).a(marker);
        }
        if (animation instanceof Transformation) {
            return ((f) animation.bdAnimation).a(marker);
        }
        if (animation instanceof ScaleAnimation) {
            return ((d) animation.bdAnimation).a(marker);
        }
        if (animation instanceof SingleScaleAnimation) {
            return ((e) animation.bdAnimation).a(marker);
        }
        return null;
    }
}
