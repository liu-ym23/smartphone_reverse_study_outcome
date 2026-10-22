package vc;

import com.obric.oui.constraintlayout.core.motion.utils.StopEngine;

/* JADX INFO: loaded from: classes4.dex */
public class i implements StopEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f25180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f25182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f25183d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f25184e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f25185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f25186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f25187h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f25188i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f25189j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f25190k;

    public i() {
        this.f25180a = 0.5d;
        this.f25181b = false;
        this.f25190k = 0;
    }

    public final void a(double r25) {
        if (r25 > 0.0d) goto L5;
        return;
    L5:
        double r10 = this.f25182c;
        double r11 = this.f25180a;
        int r12 = (int) ((9.0d / ((Math.sqrt(r10 / ((double) this.f25188i)) * r25) * 4.0d)) + 1.0d);
        double r13 = r25 / ((double) r12);
        int r14 = 0;
    L6:
        if (r14 >= r12) goto L20;
        float r15 = this.f25186g;
        double r16 = this.f25183d;
        double r17 = -r10;
        double r18 = r17 * (((double) r15) - r16);
        float r19 = this.f25187h;
        double r110 = r10;
        double r111 = r18 - (((double) r19) * r11);
        float r20 = this.f25188i;
        double r112 = r11;
        double r113 = r111 / ((double) r20);
        double r21 = ((double) r19) + ((r113 * r13) / 2.0d);
        double r114 = ((((-((((double) r15) + ((r13 * r21) / 2.0d)) - r16)) * r110) - (r21 * r112)) / ((double) r20)) * r13;
        double r22 = ((double) r19) + (r114 / 2.0d);
        float r115 = r19 + ((float) r114);
        this.f25187h = r115;
        float r23 = r15 + ((float) (r22 * r13));
        this.f25186g = r23;
        int r24 = this.f25190k;
        if (r24 <= 0) goto L19;
        if (r23 < 0.0f) goto L12;
    L14:
        float r26 = this.f25186g;
        if (r26 <= 1.0f) goto L19;
        if ((r24 & 2) != 2) goto L19;
        this.f25186g = 2.0f - r26;
        this.f25187h = -this.f25187h;
        goto L19
    L12:
        if ((r24 & 1) != 1) goto L14;
        this.f25186g = -r23;
        this.f25187h = -r115;
    L19:
        r14 = r14 + 1;
        r10 = r110;
        r11 = r112;
        goto L6
    }

    public void b(float r10, float r11, float r12, float r13, float r14, float r15, float r16, int r17) {
        this.f25183d = r11;
        this.f25180a = r15;
        this.f25181b = false;
        this.f25186g = r10;
        this.f25184e = r12;
        this.f25182c = r14;
        this.f25188i = r13;
        this.f25189j = r16;
        this.f25190k = r17;
        this.f25185f = 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.StopEngine
    public String debug(String r10, float r11) {
        return null;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float r10) {
        a(r10 - this.f25185f);
        this.f25185f = r10;
        if (isStopped() == false) goto L6;
        this.f25186g = (float) this.f25183d;
    L6:
        return this.f25186g;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float r10) {
        return this.f25187h;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        double r10 = ((double) this.f25186g) - this.f25183d;
        double r11 = this.f25182c;
        double r12 = this.f25187h;
        if (Math.sqrt((((r12 * r12) * ((double) this.f25188i)) + ((r11 * r10) * r10)) / r11) > this.f25189j) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return 0.0f;
    }
}
