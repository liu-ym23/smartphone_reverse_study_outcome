package com.android.server.display.utils;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes2.dex */
public class CubicBezierInterpolator implements Interpolator {
    private final float mX1;
    private final float mX2;
    private final float mY1;
    private final float mY2;

    public CubicBezierInterpolator(float x1, float y1, float x2, float y2) {
        this.mX1 = x1;
        this.mY1 = y1;
        this.mX2 = x2;
        this.mY2 = y2;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float v) {
        return getY(getTForXValue(v));
    }

    private float getX(float t) {
        return getCoordinate(t, this.mX1, this.mX2);
    }

    private float getY(float t) {
        return getCoordinate(t, this.mY1, this.mY2);
    }

    private float getCoordinate(float t, float p1, float p2) {
        if (t != 0.0f) goto L5;
    L9:
        return t;
    L5:
        if (t == 1.0f) goto L9;
        float ip0 = linearInterpolate(0.0f, p1, t);
        float ip1 = linearInterpolate(p1, p2, t);
        float ip2 = linearInterpolate(p2, 1.0f, t);
        return linearInterpolate(linearInterpolate(ip0, ip1, t), linearInterpolate(ip1, ip2, t), t);
    }

    private float linearInterpolate(float a, float b, float progress) {
        return ((b - a) * progress) + a;
    }

    private float getTForXValue(float x) {
        if (x > 0.0f) goto L6;
        return 0.0f;
    L6:
        if (x < 1.0f) goto L8;
        return 1.0f;
    L8:
        float t = x;
        float minT = 0.0f;
        float maxT = 1.0f;
        float value = 0.0f;
        int i = 0;
    L10:
        if (i >= 8) goto L22;
        value = getX(t);
        double derivative = (getX(t + 1.0E-6f) - value) / 1.0E-6f;
        if (Math.abs(value - x) < 1.0E-6f) goto L13;
        if (Math.abs(derivative) < 9.999999974752427E-7d) goto L22;
        if (value >= x) goto L20;
        minT = t;
    L21:
        t = (float) (((double) t) - (((double) (value - x)) / derivative));
        i = i + 1;
        goto L10
    L20:
        maxT = t;
        goto L21
    L13:
        return t;
    L22:
        int i2 = 0;
    L24:
        if (Math.abs(value - x) <= 1.0E-6f) goto L31;
        if (i2 >= 8) goto L31;
        if (value >= x) goto L29;
        minT = t;
        float r10 = t + maxT;
    L30:
        t = r10 / 2.0f;
        value = getX(t);
        i2 = i2 + 1;
        goto L24
    L29:
        maxT = t;
        r10 = t + minT;
    L31:
        return t;
    }
}
