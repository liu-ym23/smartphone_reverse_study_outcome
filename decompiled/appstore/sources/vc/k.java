package vc;

import com.obric.oui.constraintlayout.core.motion.utils.StopEngine;

/* JADX INFO: loaded from: classes4.dex */
public class k implements StopEngine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f25192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f25193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f25194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f25195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f25196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f25197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f25198g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f25199h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f25200i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f25201j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f25202k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f25203l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f25204m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f25205n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f25206o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f25207p;

    public k() {
        this.f25203l = false;
        this.f25207p = false;
    }

    public final float a(float r10) {
        this.f25207p = false;
        float r11 = this.f25195d;
        if (r10 > r11) goto L6;
        float r12 = this.f25192a;
        return (r12 * r10) + ((((this.f25193b - r12) * r10) * r10) / (r11 * 2.0f));
    L6:
        int r13 = this.f25201j;
        if (r13 == 1) goto L9;
        float r14 = r10 - r11;
        float r15 = this.f25196e;
        if (r14 >= r15) goto L15;
        float r16 = this.f25198g;
        float r17 = this.f25193b;
        return (r16 + (r17 * r14)) + ((((this.f25194c - r17) * r14) * r14) / (r15 * 2.0f));
    L15:
        if (r13 == 2) goto L17;
        float r18 = r14 - r15;
        float r19 = this.f25197f;
        if (r18 > r19) goto L22;
        float r20 = this.f25199h;
        float r21 = this.f25194c;
        return (r20 + (r21 * r18)) - (((r21 * r18) * r18) / (r19 * 2.0f));
    L22:
        this.f25207p = true;
        return this.f25200i;
    L17:
        return this.f25199h;
    L9:
        return this.f25198g;
    }

    public void b(float r10, float r11, float r12, float r13, float r14, float r15) {
        boolean r16 = false;
        this.f25207p = false;
        this.f25204m = r10;
        if (r10 <= r11) goto L5;
        r16 = true;
    L5:
        this.f25203l = r16;
        if (r16 == false) goto L8;
        c(-r12, r10 - r11, r14, r15, r13);
        return;
    L8:
        c(r12, r11 - r10, r14, r15, r13);
    }

    public final void c(float r10, float r11, float r12, float r13, float r14) {
        this.f25207p = false;
        this.f25200i = r11;
        if (r10 != 0.0f) goto L5;
        r10 = 1.0E-4f;
    L5:
        float r15 = r10 / r12;
        float r16 = (r15 * r10) / 2.0f;
        if (r10 >= 0.0f) goto L14;
        float r17 = (float) Math.sqrt((r11 - ((((-r10) / r12) * r10) / 2.0f)) * r12);
        if (r17 >= r13) goto L11;
        this.f25202k = "backward accelerate, decelerate";
        this.f25201j = 2;
        this.f25192a = r10;
        this.f25193b = r17;
        this.f25194c = 0.0f;
        float r18 = (r17 - r10) / r12;
        this.f25195d = r18;
        this.f25196e = r17 / r12;
        this.f25198g = ((r10 + r17) * r18) / 2.0f;
        this.f25199h = r11;
        this.f25200i = r11;
        return;
    L11:
        this.f25202k = "backward accelerate cruse decelerate";
        this.f25201j = 3;
        this.f25192a = r10;
        this.f25193b = r13;
        this.f25194c = r13;
        float r19 = (r13 - r10) / r12;
        this.f25195d = r19;
        float r110 = r13 / r12;
        this.f25197f = r110;
        float r20 = ((r10 + r13) * r19) / 2.0f;
        float r111 = (r110 * r13) / 2.0f;
        this.f25196e = ((r11 - r20) - r111) / r13;
        this.f25198g = r20;
        this.f25199h = r11 - r111;
        this.f25200i = r11;
        return;
    L14:
        if (r16 < r11) goto L17;
        this.f25202k = "hard stop";
        this.f25201j = 1;
        this.f25192a = r10;
        this.f25193b = 0.0f;
        this.f25198g = r11;
        this.f25195d = (2.0f * r11) / r10;
        return;
    L17:
        float r21 = r11 - r16;
        float r22 = r21 / r10;
        if ((r22 + r15) >= r14) goto L21;
        this.f25202k = "cruse decelerate";
        this.f25201j = 2;
        this.f25192a = r10;
        this.f25193b = r10;
        this.f25194c = 0.0f;
        this.f25198g = r21;
        this.f25199h = r11;
        this.f25195d = r22;
        this.f25196e = r15;
        return;
    L21:
        float r112 = (float) Math.sqrt((r12 * r11) + ((r10 * r10) / 2.0f));
        float r23 = (r112 - r10) / r12;
        this.f25195d = r23;
        float r24 = r112 / r12;
        this.f25196e = r24;
        if (r112 >= r13) goto L25;
        this.f25202k = "accelerate decelerate";
        this.f25201j = 2;
        this.f25192a = r10;
        this.f25193b = r112;
        this.f25194c = 0.0f;
        this.f25195d = r23;
        this.f25196e = r24;
        this.f25198g = ((r10 + r112) * r23) / 2.0f;
        this.f25199h = r11;
        return;
    L25:
        this.f25202k = "accelerate cruse decelerate";
        this.f25201j = 3;
        this.f25192a = r10;
        this.f25193b = r13;
        this.f25194c = r13;
        float r113 = (r13 - r10) / r12;
        this.f25195d = r113;
        float r114 = r13 / r12;
        this.f25197f = r114;
        float r25 = ((r10 + r13) * r113) / 2.0f;
        float r115 = (r114 * r13) / 2.0f;
        this.f25196e = ((r11 - r25) - r115) / r13;
        this.f25198g = r25;
        this.f25199h = r11 - r115;
        this.f25200i = r11;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.StopEngine
    public String debug(String r10, float r11) {
        String r12 = r10 + " ===== " + this.f25202k + "\n";
        StringBuilder r13 = new StringBuilder();
        r13.append(r12);
        r13.append(r10);
        if (this.f25203l == false) goto L5;
        String r14 = "backwards";
    L6:
        r13.append(r14);
        r13.append(" time = ");
        r13.append(r11);
        r13.append("  stages ");
        r13.append(this.f25201j);
        r13.append("\n");
        String r15 = r13.toString() + r10 + " dur " + this.f25195d + " vel " + this.f25192a + " pos " + this.f25198g + "\n";
        if (this.f25201j <= 1) goto L10;
        r15 = r15 + r10 + " dur " + this.f25196e + " vel " + this.f25193b + " pos " + this.f25199h + "\n";
    L10:
        if (this.f25201j <= 2) goto L12;
        r15 = r15 + r10 + " dur " + this.f25197f + " vel " + this.f25194c + " pos " + this.f25200i + "\n";
    L12:
        float r16 = this.f25195d;
        if (r11 <= r16) goto L15;
        int r17 = this.f25201j;
        if (r17 == 1) goto L19;
        float r18 = r11 - r16;
        float r19 = this.f25196e;
        if (r18 < r19) goto L23;
        if (r17 != 2) goto L28;
        return r15 + r10 + "end stage 1\n";
    L28:
        if ((r18 - r19) >= this.f25197f) goto L32;
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

    @Override // com.obric.oui.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float r10) {
        float r11 = a(r10);
        this.f25205n = r11;
        this.f25206o = r10;
        boolean r12 = this.f25203l;
        float r13 = this.f25204m;
        if (r12 == false) goto L6;
        return r13 - r11;
    L6:
        return r13 + r11;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float r10) {
        float r11 = this.f25195d;
        if (r10 > r11) goto L7;
        float r12 = this.f25192a;
        float r13 = this.f25193b;
    L6:
        return r12 + (((r13 - r12) * r10) / r11);
    L7:
        int r14 = this.f25201j;
        if (r14 != 1) goto L10;
        return 0.0f;
    L10:
        r10 = r10 - r11;
        r11 = this.f25196e;
        if (r10 >= r11) goto L14;
        r12 = this.f25193b;
        r13 = this.f25194c;
        goto L6
    L14:
        if (r14 != 2) goto L16;
        return 0.0f;
    L16:
        float r15 = r10 - r11;
        float r16 = this.f25197f;
        if (r15 >= r16) goto L20;
        float r17 = this.f25194c;
        return r17 - ((r15 * r17) / r16);
    L20:
        return 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        if (getVelocity() < 1.0E-5f) goto L5;
    L7:
        return false;
    L5:
        if (Math.abs(this.f25200i - this.f25205n) >= 1.0E-5f) goto L7;
        return true;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        if (this.f25203l == false) goto L6;
        return -getVelocity(this.f25206o);
    L6:
        return getVelocity(this.f25206o);
    }
}
