package com.baidu.mapapi.animation;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import com.baidu.mapapi.map.OverlayUtil;
import com.baidu.mapsdkplatform.comapi.animation.d;
import com.baidu.platform.comapi.bmsdk.animation.BmAccelerateDecelerateInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmAccelerateInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;
import com.baidu.platform.comapi.bmsdk.animation.BmAnticipateInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmAnticipateOvershootInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmBounceInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmCycleInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmDecelerateInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmLinearInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmOvershootInterpolator;
import com.baidu.platform.comapi.bmsdk.animation.BmScaleAnimation;

/* JADX INFO: loaded from: classes39.dex */
public class ScaleAnimation extends Animation {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float[] f30527d;

    public class a implements BmAnimation.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ScaleAnimation f30528a;

        public a(ScaleAnimation r100) {
            this.f30528a = r100;
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void a(BmAnimation r100) {
            if (r100 == null) goto L7;
            Animation.AnimationListener r101 = r100.animationListener;
            if (r101 == null) goto L8;
            r101.onAnimationStart();
            return;
        L8:
            return;
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void b(BmAnimation r100) {
            if (r100 == null) goto L7;
            Animation.AnimationListener r101 = r100.animationListener;
            if (r101 == null) goto L8;
            r101.onAnimationEnd();
            return;
        L8:
            return;
        }

        @Override // com.baidu.platform.comapi.bmsdk.animation.BmAnimation.a
        public void c(BmAnimation r100) {
            if (r100 == null) goto L7;
            Animation.AnimationListener r101 = r100.animationListener;
            if (r101 == null) goto L8;
            r101.onAnimationRepeat();
            return;
        L8:
            return;
        }
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void cancel() {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L5;
        this.bmAnimation.cancel();
        return;
    L5:
        this.bdAnimation.cancelAnimation();
    }

    @Override // com.baidu.mapapi.animation.Animation
    public long getDuration() {
        return this.f30520c;
    }

    @Override // com.baidu.mapapi.animation.Animation
    public int getRepeatCount() {
        return this.f30519b;
    }

    @Override // com.baidu.mapapi.animation.Animation
    public Animation.RepeatMode getRepeatMode() {
        return this.f30518a;
    }

    public float[] getScale() {
        return this.f30527d;
    }

    public ScaleAnimation(float... r100) {
        if (r100 == null) goto L13;
        if (r100.length == 0) goto L13;
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        this.bmAnimation = new BmScaleAnimation(r100[0], r100[r100.length - 1]);
    L10:
        this.f30527d = r100;
        return;
    L9:
        this.bdAnimation = new d(r100);
    L13:
        throw new NullPointerException("BDMapSDKException: the scales is null");
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setAnimationListener(Animation.AnimationListener r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L5;
        this.bmAnimation.setAnimationListener(r100);
        this.bmAnimation.setAnimationListener(new a(this));
        return;
    L5:
        this.bdAnimation.setAnimationListener(r100);
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setDuration(long r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L5;
        this.bmAnimation.setDuration(r100);
    L6:
        this.f30520c = r100;
        return;
    L5:
        this.bdAnimation.setDuration(r100);
        goto L6
    }

    @Override // com.baidu.mapapi.animation.Animation
    public void setInterpolator(Interpolator r100) {
        if (OverlayUtil.isOverlayUpgrade() == true) goto L5;
        this.bdAnimation.setInterpolator(r100);
        return;
    L5:
        if ((r100 instanceof LinearInterpolator) == false) goto L8;
        BmLinearInterpolator r101 = new BmLinearInterpolator();
        this.bmAnimation.setInterpolator(r101);
        return;
    L8:
        if ((r100 instanceof CycleInterpolator) == false) goto L11;
        BmCycleInterpolator r102 = new BmCycleInterpolator();
        this.bmAnimation.setInterpolator(r102);
        return;
    L11:
        if ((r100 instanceof BounceInterpolator) == false) goto L14;
        BmBounceInterpolator r103 = new BmBounceInterpolator();
        this.bmAnimation.setInterpolator(r103);
        return;
    L14:
        if ((r100 instanceof DecelerateInterpolator) == false) goto L17;
        BmDecelerateInterpolator r104 = new BmDecelerateInterpolator();
        this.bmAnimation.setInterpolator(r104);
        return;
    L17:
        if ((r100 instanceof OvershootInterpolator) == false) goto L20;
        BmOvershootInterpolator r105 = new BmOvershootInterpolator();
        this.bmAnimation.setInterpolator(r105);
        return;
    L20:
        if ((r100 instanceof AccelerateInterpolator) == false) goto L23;
        BmAccelerateInterpolator r106 = new BmAccelerateInterpolator();
        this.bmAnimation.setInterpolator(r106);
        return;
    L23:
        if ((r100 instanceof AccelerateDecelerateInterpolator) == false) goto L26;
        BmAccelerateDecelerateInterpolator r107 = new BmAccelerateDecelerateInterpolator();
        this.bmAnimation.setInterpolator(r107);
        return;
    L26:
        if ((r100 instanceof AnticipateInterpolator) == false) goto L29;
        BmAnticipateInterpolator r108 = new BmAnticipateInterpolator();
        this.bmAnimation.setInterpolator(r108);
        return;
    L29:
        if ((r100 instanceof AnticipateOvershootInterpolator) == false) goto L41;
        BmAnticipateOvershootInterpolator r109 = new BmAnticipateOvershootInterpolator();
        this.bmAnimation.setInterpolator(r109);
        return;
    }

    public void setRepeatCount(int r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L5;
        this.bmAnimation.setRepeatCount(r100);
    L6:
        this.f30519b = r100;
        return;
    L5:
        this.bdAnimation.setRepeatCount(r100);
        goto L6
    }

    public void setRepeatDelay(long r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmAnimation r101 = this.bmAnimation;
        if (r101 != null) goto L7;
        return;
    L7:
        r101.setRepeatDelay(r100);
        return;
    }

    public void setRepeatMode(Animation.RepeatMode r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L14;
        BmAnimation r101 = this.bmAnimation;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r100 != Animation.RepeatMode.RESTART) goto L11;
        r101.setRepeatMode(1);
    L19:
        this.f30518a = r100;
        return;
    L11:
        if (r100 != Animation.RepeatMode.REVERSE) goto L19;
        r101.setRepeatMode(2);
        goto L19
    L14:
        if (r100 != Animation.RepeatMode.RESTART) goto L17;
        this.bdAnimation.setRepeatMode(1);
        goto L19
    L17:
        if (r100 != Animation.RepeatMode.REVERSE) goto L19;
        this.bdAnimation.setRepeatMode(2);
        goto L19
    }

    public void setStartDelay(long r100) {
        if (OverlayUtil.isOverlayUpgrade() == false) goto L9;
        BmAnimation r101 = this.bmAnimation;
        if (r101 != null) goto L7;
        return;
    L7:
        r101.setStartDelay(r100);
        return;
    }
}
