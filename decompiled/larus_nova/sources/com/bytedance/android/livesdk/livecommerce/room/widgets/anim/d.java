package com.bytedance.android.livesdk.livecommerce.room.widgets.anim;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes10.dex */
public final class d implements Interpolator {
    public d() {
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        if (r100 <= 0.75f) goto L6;
        return 1.02f - (((r100 - 0.75f) * 0.02f) / (1 - 0.75f));
    L6:
        return (r100 * 1.02f) / 0.75f;
    }
}
