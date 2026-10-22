package com.baidu.mapapi.animation;

import android.view.animation.Interpolator;
import com.baidu.mapsdkplatform.comapi.animation.BDAnimation;
import com.baidu.platform.comapi.bmsdk.animation.BmAnimation;

/* loaded from: classes.dex */
public abstract class Animation {

    /* renamed from: a, reason: collision with root package name */
    RepeatMode f5976a;

    /* renamed from: b, reason: collision with root package name */
    int f5977b;
    public BDAnimation bdAnimation;
    public BmAnimation bmAnimation;

    /* renamed from: c, reason: collision with root package name */
    long f5978c;

    public interface AnimationListener {
        void onAnimationCancel();

        void onAnimationEnd();

        void onAnimationRepeat();

        void onAnimationStart();
    }

    public enum RepeatMode {
        RESTART,
        REVERSE
    }

    public abstract void cancel();

    public long getDuration() {
        return this.f5978c;
    }

    public int getRepeatCount() {
        return this.f5977b;
    }

    public RepeatMode getRepeatMode() {
        return this.f5976a;
    }

    public abstract void setAnimationListener(AnimationListener animationListener);

    public abstract void setDuration(long j4);

    public abstract void setInterpolator(Interpolator interpolator);
}
