package p001j;

import androidx.constraintlayout.core.motion.utils.StopEngine;

/* JADX INFO: loaded from: classes.dex */
public class i implements StopEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f20810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f20812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f20813d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f20814e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f20815f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f20816g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f20817h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f20818i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f20819j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f20820k;

    public i() {
        this.f20810a = 0.5d;
        this.f20811b = false;
        this.f20820k = 0;
    }

    public final void a(double r25) {
        double r10 = this.f20812c;
        double r11 = this.f20810a;
        int r12 = (int) ((9.0d / ((Math.sqrt(r10 / ((double) this.f20818i)) * r25) * 4.0d)) + 1.0d);
        double r13 = r25 / ((double) r12);
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L17;
        float r15 = this.f20816g;
        double r16 = this.f20813d;
        double r17 = -r10;
        double r18 = r17 * (((double) r15) - r16);
        float r19 = this.f20817h;
        double r110 = r10;
        double r111 = r18 - (((double) r19) * r11);
        float r20 = this.f20818i;
        double r112 = r11;
        double r113 = r111 / ((double) r20);
        double r21 = ((double) r19) + ((r113 * r13) / 2.0d);
        double r114 = ((((-((((double) r15) + ((r13 * r21) / 2.0d)) - r16)) * r110) - (r21 * r112)) / ((double) r20)) * r13;
        double r22 = ((double) r19) + (r114 / 2.0d);
        float r23 = (float) (((double) r19) + r114);
        this.f20817h = r23;
        float r24 = (float) (((double) r15) + (r22 * r13));
        this.f20816g = r24;
        int r26 = this.f20820k;
        if (r26 <= 0) goto L16;
        if (r24 < 0.0f) goto L9;
    L11:
        float r27 = this.f20816g;
        if (r27 <= 1.0f) goto L16;
        if ((r26 & 2) != 2) goto L16;
        this.f20816g = 2.0f - r27;
        this.f20817h = -this.f20817h;
        goto L16
    L9:
        if ((r26 & 1) != 1) goto L11;
        this.f20816g = -r24;
        this.f20817h = -r23;
    L16:
        r14 = r14 + 1;
        r10 = r110;
        r11 = r112;
        goto L3
    }

    public void b(float r10, float r11, float r12, float r13, float r14, float r15, float r16, int r17) {
        this.f20813d = r11;
        this.f20810a = r15;
        this.f20811b = false;
        this.f20816g = r10;
        this.f20814e = r12;
        this.f20812c = r14;
        this.f20818i = r13;
        this.f20819j = r16;
        this.f20820k = r17;
        this.f20815f = 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String r10, float r11) {
        return null;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float r10) {
        a(r10 - this.f20815f);
        this.f20815f = r10;
        return this.f20816g;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float r10) {
        return this.f20817h;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        double r10 = ((double) this.f20816g) - this.f20813d;
        double r11 = this.f20812c;
        double r12 = this.f20817h;
        if (Math.sqrt((((r12 * r12) * ((double) this.f20818i)) + ((r11 * r10) * r10)) / r11) > this.f20819j) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return 0.0f;
    }
}
