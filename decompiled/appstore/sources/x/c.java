package x;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f25408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f25409b;

    public c(float[] r10) {
        this.f25408a = r10;
        this.f25409b = 1.0f / (r10.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r10) {
        if (r10 < 1.0f) goto L6;
        return 1.0f;
    L6:
        if (r10 > 0.0f) goto L8;
        return 0.0f;
    L8:
        float[] r11 = this.f25408a;
        int r12 = Math.min((int) ((r11.length - 1) * r10), r11.length - 2);
        float r13 = this.f25409b;
        float r14 = (r10 - (r12 * r13)) / r13;
        float[] r15 = this.f25408a;
        float r16 = r15[r12];
        return r16 + (r14 * (r15[r12 + 1] - r16));
    }
}
