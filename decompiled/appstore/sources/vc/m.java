package vc;

/* JADX INFO: loaded from: classes4.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f25219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f25220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f25221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f25222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f25223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f25224f;

    static {
    }

    public m() {
    }

    public void a(float r18, float r19, int r20, int r21, float[] r22) {
        float r10 = r22[0];
        float r11 = r22[1];
        float r12 = (r18 - 0.5f) * 2.0f;
        float r13 = (r19 - 0.5f) * 2.0f;
        float r14 = r10 + this.f25221c;
        float r15 = r11 + this.f25222d;
        float r16 = r14 + (this.f25219a * r12);
        float r17 = r15 + (this.f25220b * r13);
        float r23 = (float) Math.toRadians(this.f25224f);
        float r24 = (float) Math.toRadians(this.f25223e);
        double r110 = r23;
        double r111 = r21 * r13;
        float r25 = r16 + (((float) ((((double) ((-r20) * r12)) * Math.sin(r110)) - (Math.cos(r110) * r111))) * r24);
        float r26 = r17 + (r24 * ((float) ((((double) (r20 * r12)) * Math.cos(r110)) - (r111 * Math.sin(r110)))));
        r22[0] = r25;
        r22[1] = r26;
    }

    public void b() {
        this.f25223e = 0.0f;
        this.f25222d = 0.0f;
        this.f25221c = 0.0f;
        this.f25220b = 0.0f;
        this.f25219a = 0.0f;
    }

    public void c(com.obric.oui.constraintlayout.core.motion.utils.a r10, float r11) {
        if (r10 == null) goto L5;
        this.f25223e = r10.b(r11);
        return;
    }

    public void d(com.obric.oui.constraintlayout.core.motion.utils.b r10, float r11) {
        if (r10 == null) goto L5;
        this.f25223e = r10.b(r11);
        this.f25224f = r10.a(r11);
        return;
    }

    public void e(com.obric.oui.constraintlayout.core.motion.utils.a r10, com.obric.oui.constraintlayout.core.motion.utils.a r11, float r12) {
        if (r10 == null) goto L4;
        this.f25219a = r10.b(r12);
    L4:
        if (r11 == null) goto L7;
        this.f25220b = r11.b(r12);
        return;
    }

    public void f(com.obric.oui.constraintlayout.core.motion.utils.b r10, com.obric.oui.constraintlayout.core.motion.utils.b r11, float r12) {
        if (r10 == null) goto L4;
        this.f25219a = r10.b(r12);
    L4:
        if (r11 == null) goto L7;
        this.f25220b = r11.b(r12);
        return;
    }

    public void g(com.obric.oui.constraintlayout.core.motion.utils.a r10, com.obric.oui.constraintlayout.core.motion.utils.a r11, float r12) {
        if (r10 == null) goto L4;
        this.f25221c = r10.b(r12);
    L4:
        if (r11 == null) goto L7;
        this.f25222d = r11.b(r12);
        return;
    }

    public void h(com.obric.oui.constraintlayout.core.motion.utils.b r10, com.obric.oui.constraintlayout.core.motion.utils.b r11, float r12) {
        if (r10 == null) goto L4;
        this.f25221c = r10.b(r12);
    L4:
        if (r11 == null) goto L7;
        this.f25222d = r11.b(r12);
        return;
    }
}
