package com.bytedance.android.gamecp.live_impl.animation.task;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements Interpolator {
    public c() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        if (r100 <= 0.42857143f) goto L6;
        return 1.03f - (((r100 - 0.42857143f) * 1.03f) / (1 - 0.42857143f));
    L6:
        return 1 + ((r100 * 0.03f) / 0.42857143f);
    }
}
