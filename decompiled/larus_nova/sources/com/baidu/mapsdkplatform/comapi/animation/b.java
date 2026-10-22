package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.AlphaAnimation;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.animation.RotateAnimation;
import com.baidu.mapapi.animation.ScaleAnimation;
import com.baidu.mapapi.animation.SingleScaleAnimation;
import com.baidu.mapapi.animation.Transformation;
import com.baidu.mapapi.map.Marker;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes39.dex */
public class b extends BDAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Animator f31985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f31986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Interpolator f31987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Animation.AnimationListener f31988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f31989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<Animation> f31990f;

    public class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f31991a;

        public a(b r100) {
            this.f31991a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r100) {
            if (b.a(this.f31991a) == null) goto L6;
            b.a(this.f31991a).onAnimationCancel();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            if (b.a(this.f31991a) == null) goto L6;
            b.a(this.f31991a).onAnimationEnd();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r100) {
            if (b.a(this.f31991a) == null) goto L6;
            b.a(this.f31991a).onAnimationRepeat();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r100) {
            if (b.a(this.f31991a) == null) goto L6;
            b.a(this.f31991a).onAnimationStart();
            return;
        }
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatCount(int r100) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setRepeatMode(int r100) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setTypeEvaluator(TypeEvaluator r100) {
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void cancelAnimation() {
        Animator r100 = this.f31985a;
        if (r100 == null) goto L6;
        r100.cancel();
        this.f31985a = null;
        return;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void startAnimation() {
        Animator r100 = this.f31985a;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.start();
    }

    public b() {
        this.f31985a = null;
        this.f31986b = 0;
        this.f31987c = null;
        this.f31988d = null;
        this.f31989e = 0;
        this.f31990f = new ArrayList();
    }

    public void a(Animation r100) {
        if (this.f31990f.contains(r100) == true) goto L6;
        this.f31990f.add(r100);
        return;
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
        this.f31988d = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimatorSetMode(int r100) {
        this.f31989e = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setDuration(long r100) {
        if (r100 >= 0) goto L5;
        r100 = 0;
    L5:
        this.f31986b = r100;
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setInterpolator(Interpolator r100) {
        this.f31987c = r100;
    }

    public static /* synthetic */ Animation.AnimationListener a(b r100) {
        return r100.f31988d;
    }

    private ObjectAnimator a(Marker r100, Animation r101) {
        if ((r101 instanceof AlphaAnimation) == false) goto L6;
        return ((com.baidu.mapsdkplatform.comapi.animation.a) r101.bdAnimation).a(r100);
    L6:
        if ((r101 instanceof RotateAnimation) == false) goto L9;
        return ((c) r101.bdAnimation).a(r100);
    L9:
        if ((r101 instanceof Transformation) == false) goto L12;
        return ((f) r101.bdAnimation).a(r100);
    L12:
        if ((r101 instanceof ScaleAnimation) == false) goto L15;
        return ((d) r101.bdAnimation).a(r100);
    L15:
        if ((r101 instanceof SingleScaleAnimation) == true) goto L23;
        return null;
    L23:
        return ((e) r101.bdAnimation).a(r100);
    }

    @Override // com.baidu.mapsdkplatform.comapi.animation.BDAnimation
    public void setAnimation(Marker r100, Animation r101) {
        this.f31985a = new AnimatorSet();
        ArrayList<Animation> r102 = this.f31990f;
        ArrayList r103 = new ArrayList();
        r103.clear();
        int r104 = 0;
    L4:
        if (r104 >= r102.size()) goto L11;
        Animation r105 = (Animation) ListProtector.get(r102, r104);
        if (r105 == null) goto L10;
        ObjectAnimator r106 = a(r100, r105);
        if (r106 == null) goto L10;
        r103.add(r106);
    L10:
        r104 = r104 + 1;
        goto L4
    L11:
        long r107 = this.f31986b;
        if (r107 == 0) goto L14;
        this.f31985a.setDuration(r107);
    L14:
        Interpolator r108 = this.f31987c;
        if (r108 == null) goto L18;
        this.f31985a.setInterpolator(r108);
    L18:
        if (r103.size() == 0) goto L25;
        int r109 = this.f31989e;
        if (r109 != 0) goto L23;
        ((AnimatorSet) this.f31985a).playTogether(r103);
        goto L25
    L23:
        if (r109 != 1) goto L25;
        ((AnimatorSet) this.f31985a).playSequentially(r103);
    L25:
        addAnimationListener(this.f31985a);
    }
}
