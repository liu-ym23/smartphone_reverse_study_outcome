package com.obric.oui.texteffects.runtime;

import android.view.animation.Interpolator;
import d.h.b.h;
import d.l.n;

/* JADX INFO: compiled from: AeAnimatorInterpolator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AeAnimatorInterpolator implements Interpolator {
    private final float easeHigh;
    private final float easeLow;
    private final double highPower;
    private final double lowPower;
    private final int mode;

    public AeAnimatorInterpolator() {
        this(0, 0.0f, 0.0f, 7, null);
    }

    public AeAnimatorInterpolator(int r10, float r11, float r12) {
        this.mode = r10;
        this.easeLow = r11;
        this.easeHigh = r12;
        double r7 = r11;
        if (r11 < 0.0f) goto L5;
        double r8 = r7 * 1.5d;
    L6:
        this.lowPower = r8 + 1.0d;
        if (r12 < 0.0f) goto L9;
        double r13 = ((double) r12) * 1.5d;
    L10:
        this.highPower = r13 + 1.0d;
        return;
    L9:
        r13 = ((double) r12) * 0.6d;
        goto L10
    L5:
        r8 = r7 * 0.6d;
        goto L6
    }

    public /* synthetic */ AeAnimatorInterpolator(int r2, float r3, float r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 0.0f;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = 0.0f;
    L11:
        this(r2, r3, r4);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r13) {
        if (this.mode != 0) goto L5;
        double r3 = r13;
    L6:
        double r4 = n.a(r3, 0.0d, 1.0d);
        float r14 = this.easeLow;
        boolean r6 = true;
        if (r14 != 0.0f) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L19;
        if (this.easeHigh != 0.0f) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L19;
        return (float) r4;
    L14:
        r7 = false;
    L19:
        if (r14 != 0.0f) goto L21;
        boolean r15 = true;
    L22:
        if (r15 == true) goto L24;
        double r8 = ((Math.pow(r4, this.lowPower) - r4) * (1.0d - r4)) + r4;
    L26:
        if (this.easeHigh == 0.0f) goto L29;
        r6 = false;
    L29:
        if (r6 == true) goto L32;
        r8 = r8 + (((1.0d - Math.pow(1.0d - r4, this.highPower)) - r8) * r4);
    L32:
        return (float) r8;
    L24:
        r8 = r4;
        goto L26
    L21:
        r15 = false;
        goto L22
    L9:
        r5 = false;
        goto L10
    L5:
        r3 = 1.0d - ((double) r13);
        goto L6
    }
}
