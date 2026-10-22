package p001j;

import androidx.constraintlayout.core.motion.utils.StopEngine;

/* JADX INFO: loaded from: classes.dex */
public class k implements StopEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f20822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f20823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f20824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f20825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f20826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f20827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f20828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f20829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f20830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20831j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f20832k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f20833l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f20834m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f20835n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f20836o;

    public k() {
        this.f20833l = false;
        this.f20836o = false;
    }

    public final float a(float r10) {
        this.f20836o = false;
        float r11 = this.f20825d;
        if (r10 > r11) goto L6;
        float r12 = this.f20822a;
        return (r12 * r10) + ((((this.f20823b - r12) * r10) * r10) / (r11 * 2.0f));
    L6:
        int r13 = this.f20831j;
        if (r13 == 1) goto L9;
        float r14 = r10 - r11;
        float r15 = this.f20826e;
        if (r14 >= r15) goto L15;
        float r16 = this.f20828g;
        float r17 = this.f20823b;
        return (r16 + (r17 * r14)) + ((((this.f20824c - r17) * r14) * r14) / (r15 * 2.0f));
    L15:
        if (r13 == 2) goto L17;
        float r18 = r14 - r15;
        float r19 = this.f20827f;
        if (r18 > r19) goto L22;
        float r20 = this.f20829h;
        float r21 = this.f20824c;
        return (r20 + (r21 * r18)) - (((r21 * r18) * r18) / (r19 * 2.0f));
    L22:
        this.f20836o = true;
        return this.f20830i;
    L17:
        return this.f20829h;
    L9:
        return this.f20828g;
    }

    public void b(float r10, float r11, float r12, float r13, float r14, float r15) {
        boolean r16 = false;
        this.f20836o = false;
        this.f20834m = r10;
        if (r10 <= r11) goto L5;
        r16 = true;
    L5:
        this.f20833l = r16;
        if (r16 == false) goto L8;
        c(-r12, r10 - r11, r14, r15, r13);
        return;
    L8:
        c(r12, r11 - r10, r14, r15, r13);
    }

    public final void c(float r10, float r11, float r12, float r13, float r14) {
        this.f20836o = false;
        if (r10 != 0.0f) goto L5;
        r10 = 1.0E-4f;
    L5:
        this.f20822a = r10;
        float r15 = r10 / r12;
        float r16 = (r15 * r10) / 2.0f;
        if (r10 >= 0.0f) goto L14;
        float r17 = (float) Math.sqrt((r11 - ((((-r10) / r12) * r10) / 2.0f)) * r12);
        if (r17 >= r13) goto L11;
        this.f20832k = "backward accelerate, decelerate";
        this.f20831j = 2;
        this.f20822a = r10;
        this.f20823b = r17;
        this.f20824c = 0.0f;
        float r18 = (r17 - r10) / r12;
        this.f20825d = r18;
        this.f20826e = r17 / r12;
        this.f20828g = ((r10 + r17) * r18) / 2.0f;
        this.f20829h = r11;
        this.f20830i = r11;
        return;
    L11:
        this.f20832k = "backward accelerate cruse decelerate";
        this.f20831j = 3;
        this.f20822a = r10;
        this.f20823b = r13;
        this.f20824c = r13;
        float r19 = (r13 - r10) / r12;
        this.f20825d = r19;
        float r110 = r13 / r12;
        this.f20827f = r110;
        float r20 = ((r10 + r13) * r19) / 2.0f;
        float r111 = (r110 * r13) / 2.0f;
        this.f20826e = ((r11 - r20) - r111) / r13;
        this.f20828g = r20;
        this.f20829h = r11 - r111;
        this.f20830i = r11;
        return;
    L14:
        if (r16 < r11) goto L17;
        this.f20832k = "hard stop";
        this.f20831j = 1;
        this.f20822a = r10;
        this.f20823b = 0.0f;
        this.f20828g = r11;
        this.f20825d = (2.0f * r11) / r10;
        return;
    L17:
        float r21 = r11 - r16;
        float r22 = r21 / r10;
        if ((r22 + r15) >= r14) goto L21;
        this.f20832k = "cruse decelerate";
        this.f20831j = 2;
        this.f20822a = r10;
        this.f20823b = r10;
        this.f20824c = 0.0f;
        this.f20828g = r21;
        this.f20829h = r11;
        this.f20825d = r22;
        this.f20826e = r15;
        return;
    L21:
        float r112 = (float) Math.sqrt((r12 * r11) + ((r10 * r10) / 2.0f));
        float r23 = (r112 - r10) / r12;
        this.f20825d = r23;
        float r24 = r112 / r12;
        this.f20826e = r24;
        if (r112 >= r13) goto L25;
        this.f20832k = "accelerate decelerate";
        this.f20831j = 2;
        this.f20822a = r10;
        this.f20823b = r112;
        this.f20824c = 0.0f;
        this.f20825d = r23;
        this.f20826e = r24;
        this.f20828g = ((r10 + r112) * r23) / 2.0f;
        this.f20829h = r11;
        return;
    L25:
        this.f20832k = "accelerate cruse decelerate";
        this.f20831j = 3;
        this.f20822a = r10;
        this.f20823b = r13;
        this.f20824c = r13;
        float r113 = (r13 - r10) / r12;
        this.f20825d = r113;
        float r114 = r13 / r12;
        this.f20827f = r114;
        float r25 = ((r10 + r13) * r113) / 2.0f;
        float r115 = (r114 * r13) / 2.0f;
        this.f20826e = ((r11 - r25) - r115) / r13;
        this.f20828g = r25;
        this.f20829h = r11 - r115;
        this.f20830i = r11;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String r10, float r11) {
        String r12 = r10 + " ===== " + this.f20832k + "\n";
        StringBuilder r13 = new StringBuilder();
        r13.append(r12);
        r13.append(r10);
        if (this.f20833l == false) goto L5;
        String r14 = "backwards";
    L6:
        r13.append(r14);
        r13.append(" time = ");
        r13.append(r11);
        r13.append("  stages ");
        r13.append(this.f20831j);
        r13.append("\n");
        String r15 = r13.toString() + r10 + " dur " + this.f20825d + " vel " + this.f20822a + " pos " + this.f20828g + "\n";
        if (this.f20831j <= 1) goto L10;
        r15 = r15 + r10 + " dur " + this.f20826e + " vel " + this.f20823b + " pos " + this.f20829h + "\n";
    L10:
        if (this.f20831j <= 2) goto L12;
        r15 = r15 + r10 + " dur " + this.f20827f + " vel " + this.f20824c + " pos " + this.f20830i + "\n";
    L12:
        float r16 = this.f20825d;
        if (r11 <= r16) goto L15;
        int r17 = this.f20831j;
        if (r17 == 1) goto L19;
        float r18 = r11 - r16;
        float r19 = this.f20826e;
        if (r18 < r19) goto L23;
        if (r17 != 2) goto L28;
        return r15 + r10 + "end stage 1\n";
    L28:
        if ((r18 - r19) >= this.f20827f) goto L32;
        return r15 + r10 + " stage 2\n";
    L32:
        return r15 + r10 + " end stage 2\n";
    L23:
        return r15 + r10 + " stage 1\n";
    L19:
        return r15 + r10 + "end stage 0\n";
    L15:
        return r15 + r10 + "stage 0\n";
    L5:
        r14 = "forward ";
        goto L6
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float r10) {
        float r11 = a(r10);
        this.f20835n = r10;
        boolean r12 = this.f20833l;
        float r13 = this.f20834m;
        if (r12 == false) goto L6;
        return r13 - r11;
    L6:
        return r13 + r11;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float r10) {
        float r11 = this.f20825d;
        if (r10 > r11) goto L7;
        float r12 = this.f20822a;
        float r13 = this.f20823b;
    L6:
        return r12 + (((r13 - r12) * r10) / r11);
    L7:
        int r14 = this.f20831j;
        if (r14 != 1) goto L11;
        return 0.0f;
    L11:
        r10 = r10 - r11;
        r11 = this.f20826e;
        if (r10 >= r11) goto L15;
        r12 = this.f20823b;
        r13 = this.f20824c;
        goto L6
    L15:
        if (r14 == 2) goto L17;
        float r15 = r10 - r11;
        float r16 = this.f20827f;
        if (r15 >= r16) goto L23;
        float r17 = this.f20824c;
        return r17 - ((r15 * r17) / r16);
    L23:
        return this.f20830i;
    L17:
        return this.f20829h;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        if (getVelocity() < 1.0E-5f) goto L5;
    L7:
        return false;
    L5:
        if (Math.abs(this.f20830i - this.f20835n) >= 1.0E-5f) goto L7;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        if (this.f20833l == false) goto L6;
        return -getVelocity(this.f20835n);
    L6:
        return getVelocity(this.f20835n);
    }
}
