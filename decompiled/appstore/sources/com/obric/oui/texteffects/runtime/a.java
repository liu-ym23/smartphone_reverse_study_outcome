package com.obric.oui.texteffects.runtime;

import android.view.animation.Interpolator;
import bg.h;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f17325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f17326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f17327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f17328e;

    public a(int r10, float r11, float r12) {
        this.f17324a = r10;
        this.f17325b = r11;
        this.f17326c = r12;
        double r13 = r11;
        if (r11 < 0.0f) goto L6;
        double r14 = r13 * 1.5d;
    L7:
        this.f17327d = r14 + 1.0d;
        if (r12 < 0.0f) goto L11;
        double r15 = ((double) r12) * 1.5d;
    L12:
        this.f17328e = r15 + 1.0d;
        return;
    L11:
        r15 = ((double) r12) * 0.6d;
        goto L12
    L6:
        r14 = r13 * 0.6d;
        goto L7
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r12) {
        if (this.f17324a != 0) goto L6;
        double r10 = r12;
    L7:
        double r11 = h.i(r10, 0.0d, 1.0d);
        float r13 = this.f17325b;
        if (r13 != 0.0f) goto L14;
        if (this.f17326c != 0.0f) goto L14;
        return (float) r11;
    L14:
        if (r13 != 0.0f) goto L16;
        double r14 = r11;
    L18:
        if (this.f17326c == 0.0f) goto L22;
        r14 = r14 + (((1.0d - Math.pow(1.0d - r11, this.f17328e)) - r14) * r11);
    L22:
        return (float) r14;
    L16:
        r14 = ((Math.pow(r11, this.f17327d) - r11) * (1.0d - r11)) + r11;
        goto L18
    L6:
        r10 = 1.0d - ((double) r12);
        goto L7
    }
}
