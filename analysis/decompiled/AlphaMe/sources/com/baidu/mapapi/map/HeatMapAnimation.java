package com.baidu.mapapi.map;

/* loaded from: classes.dex */
public class HeatMapAnimation {

    /* renamed from: a, reason: collision with root package name */
    private int f6438a;

    /* renamed from: b, reason: collision with root package name */
    private AnimationType f6439b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f6440c;

    public enum AnimationType {
        Linear,
        InQuad,
        OutQuad,
        InOutQuad,
        OutInQuad,
        InCubic,
        OutCubic,
        InOutCubic,
        OutInCubic,
        InQuart,
        OutQuart,
        InOutQuart,
        OutInQuart,
        InQuint,
        OutQuint,
        InOutQuint,
        OutInQuint,
        InSine,
        OutSine,
        InOutSine,
        OutInSine,
        InExpo,
        OutExpo,
        InOutExpo,
        OutInExpo,
        InCirc,
        OutCirc,
        InOutCirc,
        OutInCirc,
        InElastic,
        OutElastic,
        InOutElastic,
        OutInElastic,
        InBack,
        OutBack,
        InOutBack,
        OutInBack,
        InBounce,
        OutBounce,
        InOutBounce,
        OutInBounce,
        InCurve,
        OutCurve,
        SineCurve,
        CosineCurve
    }

    public HeatMapAnimation(boolean z4, int i4, AnimationType animationType) {
        this.f6438a = 100;
        this.f6439b = AnimationType.Linear;
        if (i4 >= 0) {
            this.f6438a = i4;
        }
        this.f6439b = animationType;
        this.f6440c = z4;
    }

    public int getAnimationType() {
        return this.f6439b.ordinal();
    }

    public int getDuration() {
        return this.f6438a;
    }

    public boolean getIsAnimation() {
        return this.f6440c;
    }

    public void setAnimation(boolean z4) {
        this.f6440c = z4;
    }

    public void setAnimationType(AnimationType animationType) {
        this.f6439b = animationType;
    }

    public void setDuration(int i4) {
        this.f6438a = i4;
    }
}
