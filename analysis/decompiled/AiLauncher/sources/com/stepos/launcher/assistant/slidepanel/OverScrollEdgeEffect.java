package com.stepos.launcher.assistant.slidepanel;

import android.content.Context;

/* loaded from: classes.dex */
public class OverScrollEdgeEffect extends TranslateEdgeEffect {
    private static final float MAX_PULL_DISTANCE = 0.7f;
    private static final double SPRING_BACK_DAMPING_RATIO = 0.99d;
    private static final double SPRING_BACK_STIFFNESS = 228.0d;
    private static final int STATE_PULL = 1;
    private static final int STATE_RELEASED = 0;
    private int mPullState;
    private float mUndampedDistance;

    public OverScrollEdgeEffect(Context context) {
        super(context);
        this.mUndampedDistance = 0.0f;
        this.mPullState = 0;
    }

    @Override // o7.C5011b
    public double getSpringDampingRatio() {
        return SPRING_BACK_DAMPING_RATIO;
    }

    @Override // o7.C5011b
    public double getSpringStiffness() {
        return SPRING_BACK_STIFFNESS;
    }

    @Override // com.stepos.launcher.assistant.slidepanel.EdgeEffectCompat, o7.C5011b
    public float onPullDistance(float f10, float f11) {
        if (this.mPullState == 0) {
            this.mUndampedDistance = o7.c.a(getDistance(), 0.7f);
            this.mPullState = 1;
        }
        if (f10 > 0.0f) {
            float f12 = this.mUndampedDistance + f10;
            this.mUndampedDistance = f12;
            float fOnPullDistance = super.onPullDistance(o7.c.b(f12, 0.7f) - getDistance(), f11);
            return fOnPullDistance == 0.0f ? fOnPullDistance : f10;
        }
        float fMax = Math.max(0.0f, getDistance() + f10);
        float distance = fMax - getDistance();
        this.mUndampedDistance = o7.c.a(fMax, 0.7f);
        float fOnPullDistance2 = super.onPullDistance(distance, f11);
        return fOnPullDistance2 == 0.0f ? fOnPullDistance2 : distance;
    }

    public void onPullToDistance(float f10, float f11) {
        onPullDistance(o7.c.a(f10, 0.7f), f11);
    }

    @Override // o7.C5011b
    public void onRelease() {
        super.onRelease();
        this.mPullState = 0;
    }
}
