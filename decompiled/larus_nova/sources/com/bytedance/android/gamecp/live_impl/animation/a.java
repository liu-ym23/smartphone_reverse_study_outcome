package com.bytedance.android.gamecp.live_impl.animation;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f57786a = null;

    static {
        f57786a = new a();
    }

    public a() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        if (r100 < 0.0f) goto L8;
        if (r100 > 0.26958525f) goto L8;
        return (r100 * 434.0f) / 117;
    L8:
        if (r100 < 0.26958525f) goto L13;
        if (r100 > 0.5391705f) goto L13;
        float r101 = 3;
        float r102 = (r100 * 868.0f) / 117;
    L19:
        return r101 - r102;
    L13:
        if (r100 >= 0.5391705f) goto L15;
    L17:
        r101 = 4.34f;
        r102 = r100 * 4.34f;
        goto L19
    L15:
        if (r100 > 0.76958525f) goto L17;
        return (r100 * 8.68f) - 5.68f;
    }
}
