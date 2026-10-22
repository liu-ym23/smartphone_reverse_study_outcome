package com.baidu.mapsdkplatform.comapi.animation;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.view.animation.Interpolator;
import com.baidu.mapapi.animation.Animation;
import com.baidu.mapapi.map.Marker;

/* loaded from: classes.dex */
public abstract class BDAnimation {
    public abstract void addAnimationListener(Animator animator);

    public abstract void cancelAnimation();

    public abstract void setAnimation(Marker marker, Animation animation);

    public abstract void setAnimationListener(Animation.AnimationListener animationListener);

    public abstract void setAnimatorSetMode(int i4);

    public abstract void setDuration(long j4);

    public abstract void setInterpolator(Interpolator interpolator);

    public abstract void setRepeatCount(int i4);

    public abstract void setRepeatMode(int i4);

    public abstract void setTypeEvaluator(TypeEvaluator typeEvaluator);

    public abstract void startAnimation();
}
