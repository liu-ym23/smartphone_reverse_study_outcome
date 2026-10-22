package androidx.recyclerview.base;

import android.view.animation.BaseInterpolator;

/* JADX INFO: loaded from: classes.dex */
public class e extends BaseInterpolator {
    public e() {
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r10) {
        return Math.min(1.0f, (1.0f - (((9.06472f * r10) + 1.0f) * ((float) Math.exp(r10 * (-9.06472f))))) * 1.0011656f);
    }
}
