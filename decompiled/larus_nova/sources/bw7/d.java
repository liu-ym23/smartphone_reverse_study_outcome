package bw7;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes23.dex */
public final class d implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r100) {
        float r101 = 1.0f - r100;
        return 0.15f * (1.0f - (r101 * r101));
    }

    public d() {
    }
}
