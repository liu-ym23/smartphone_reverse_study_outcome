package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;

/* JADX INFO: loaded from: classes39.dex */
public abstract class BDAnimation {
    public abstract void addAnimationListener(Animator r100);

    public abstract void cancelAnimation();

    public abstract void setAnimation(Marker r100, Animation r101);

    public abstract void setAnimationListener(Animation.AnimationListener r100);

    public abstract void setAnimatorSetMode(int r100);

    public abstract void setDuration(long r100);

    public abstract void setInterpolator(Interpolator r100);

    public abstract void setRepeatCount(int r100);

    public abstract void setRepeatMode(int r100);

    public abstract void setTypeEvaluator(TypeEvaluator r100);

    public abstract void startAnimation();

    public BDAnimation() {
    }
}
