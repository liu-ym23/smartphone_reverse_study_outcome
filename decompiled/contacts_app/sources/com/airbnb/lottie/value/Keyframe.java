package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;

/* JADX INFO: loaded from: classes.dex */
public class Keyframe<T> {
    private static final float UNSET_FLOAT = -3987645.8f;
    private static final int UNSET_INT = 784923401;
    private final LottieComposition composition;
    public Float endFrame;
    private float endProgress;
    public T endValue;
    private float endValueFloat;
    private int endValueInt;
    public final Interpolator interpolator;
    public PointF pathCp1;
    public PointF pathCp2;
    public final float startFrame;
    private float startProgress;
    public final T startValue;
    private float startValueFloat;
    private int startValueInt;
    public final Interpolator xInterpolator;
    public final Interpolator yInterpolator;

    public Keyframe(LottieComposition r2, T r3, T r4, Interpolator r5, float r6, Float r7) {
        this.startValueFloat = UNSET_FLOAT;
        this.endValueFloat = UNSET_FLOAT;
        this.startValueInt = UNSET_INT;
        this.endValueInt = UNSET_INT;
        this.startProgress = Float.MIN_VALUE;
        this.endProgress = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.composition = r2;
        this.startValue = r3;
        this.endValue = r4;
        this.interpolator = r5;
        this.xInterpolator = null;
        this.yInterpolator = null;
        this.startFrame = r6;
        this.endFrame = r7;
    }

    public Keyframe(LottieComposition r2, T r3, T r4, Interpolator r5, Interpolator r6, float r7, Float r8) {
        this.startValueFloat = UNSET_FLOAT;
        this.endValueFloat = UNSET_FLOAT;
        this.startValueInt = UNSET_INT;
        this.endValueInt = UNSET_INT;
        this.startProgress = Float.MIN_VALUE;
        this.endProgress = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.composition = r2;
        this.startValue = r3;
        this.endValue = r4;
        this.interpolator = null;
        this.xInterpolator = r5;
        this.yInterpolator = r6;
        this.startFrame = r7;
        this.endFrame = r8;
    }

    protected Keyframe(LottieComposition r2, T r3, T r4, Interpolator r5, Interpolator r6, Interpolator r7, float r8, Float r9) {
        this.startValueFloat = UNSET_FLOAT;
        this.endValueFloat = UNSET_FLOAT;
        this.startValueInt = UNSET_INT;
        this.endValueInt = UNSET_INT;
        this.startProgress = Float.MIN_VALUE;
        this.endProgress = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.composition = r2;
        this.startValue = r3;
        this.endValue = r4;
        this.interpolator = r5;
        this.xInterpolator = r6;
        this.yInterpolator = r7;
        this.startFrame = r8;
        this.endFrame = r9;
    }

    public Keyframe(T r3) {
        this.startValueFloat = UNSET_FLOAT;
        this.endValueFloat = UNSET_FLOAT;
        this.startValueInt = UNSET_INT;
        this.endValueInt = UNSET_INT;
        this.startProgress = Float.MIN_VALUE;
        this.endProgress = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.composition = null;
        this.startValue = r3;
        this.endValue = r3;
        this.interpolator = null;
        this.xInterpolator = null;
        this.yInterpolator = null;
        this.startFrame = Float.MIN_VALUE;
        this.endFrame = Float.valueOf(Float.MAX_VALUE);
    }

    private Keyframe(T r3, T r4) {
        this.startValueFloat = UNSET_FLOAT;
        this.endValueFloat = UNSET_FLOAT;
        this.startValueInt = UNSET_INT;
        this.endValueInt = UNSET_INT;
        this.startProgress = Float.MIN_VALUE;
        this.endProgress = Float.MIN_VALUE;
        this.pathCp1 = null;
        this.pathCp2 = null;
        this.composition = null;
        this.startValue = r3;
        this.endValue = r4;
        this.interpolator = null;
        this.xInterpolator = null;
        this.yInterpolator = null;
        this.startFrame = Float.MIN_VALUE;
        this.endFrame = Float.valueOf(Float.MAX_VALUE);
    }

    public Keyframe<T> copyWith(T r1, T r2) {
        return new Keyframe(r1, r2);
    }

    public float getStartProgress() {
        LottieComposition r0 = this.composition;
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        if (this.startProgress != Float.MIN_VALUE) goto L10;
        this.startProgress = (this.startFrame - r0.getStartFrame()) / this.composition.getDurationFrames();
    L10:
        return this.startProgress;
    }

    public float getEndProgress() {
        if (this.composition != null) goto L6;
        return 1.0f;
    L6:
        if (this.endProgress != Float.MIN_VALUE) goto L12;
        if (this.endFrame != null) goto L10;
        this.endProgress = 1.0f;
        goto L12
    L10:
        this.endProgress = getStartProgress() + ((this.endFrame.floatValue() - this.startFrame) / this.composition.getDurationFrames());
    L12:
        return this.endProgress;
    }

    public boolean isStatic() {
        if (this.interpolator == null) goto L5;
    L9:
        return false;
    L5:
        if (this.xInterpolator != null) goto L9;
        if (this.yInterpolator != null) goto L9;
        return true;
    }

    public boolean containsProgress(float r2) {
        if (r2 >= getStartProgress()) goto L5;
    L7:
        return false;
    L5:
        if (r2 >= getEndProgress()) goto L7;
        return true;
    }

    public float getStartValueFloat() {
        if (this.startValueFloat != UNSET_FLOAT) goto L6;
        this.startValueFloat = ((Float) this.startValue).floatValue();
    L6:
        return this.startValueFloat;
    }

    public float getEndValueFloat() {
        if (this.endValueFloat != UNSET_FLOAT) goto L6;
        this.endValueFloat = ((Float) this.endValue).floatValue();
    L6:
        return this.endValueFloat;
    }

    public int getStartValueInt() {
        if (this.startValueInt != UNSET_INT) goto L6;
        this.startValueInt = ((Integer) this.startValue).intValue();
    L6:
        return this.startValueInt;
    }

    public int getEndValueInt() {
        if (this.endValueInt != UNSET_INT) goto L6;
        this.endValueInt = ((Integer) this.endValue).intValue();
    L6:
        return this.endValueInt;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.startValue + ", endValue=" + this.endValue + ", startFrame=" + this.startFrame + ", endFrame=" + this.endFrame + ", interpolator=" + this.interpolator + '}';
    }
}
