package com.bytedance.android.gamecp.live_impl.animation.task;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements Interpolator {
    public h() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        if (r100 <= 0.5714286f) goto L6;
        return 1.03f - (((r100 - 0.5714286f) * 0.03f) / (1 - 0.5714286f));
    L6:
        return (r100 * 1.03f) / 0.5714286f;
    }
}
