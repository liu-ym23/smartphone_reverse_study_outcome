package p001j;

import androidx.constraintlayout.core.motion.utils.a;
import androidx.constraintlayout.core.motion.utils.b;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f20848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f20849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f20850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f20851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f20852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f20853f;

    static {
    }

    public m() {
    }

    public void a(float r18, float r19, int r20, int r21, float[] r22) {
        float r10 = r22[0];
        float r11 = r22[1];
        float r12 = (r18 - 0.5f) * 2.0f;
        float r13 = (r19 - 0.5f) * 2.0f;
        float r14 = r10 + this.f20850c;
        float r15 = r11 + this.f20851d;
        float r16 = r14 + (this.f20848a * r12);
        float r17 = r15 + (this.f20849b * r13);
        float r23 = (float) Math.toRadians(this.f20853f);
        float r24 = (float) Math.toRadians(this.f20852e);
        double r110 = r23;
        double r111 = r21 * r13;
        float r25 = r16 + (((float) ((((double) ((-r20) * r12)) * Math.sin(r110)) - (Math.cos(r110) * r111))) * r24);
        float r26 = r17 + (r24 * ((float) ((((double) (r20 * r12)) * Math.cos(r110)) - (r111 * Math.sin(r110)))));
        r22[0] = r25;
        r22[1] = r26;
    }

    public void b() {
        this.f20852e = 0.0f;
        this.f20851d = 0.0f;
        this.f20850c = 0.0f;
        this.f20849b = 0.0f;
        this.f20848a = 0.0f;
    }

    public void c(a r10, float r11) {
        if (r10 == null) goto L5;
        this.f20852e = r10.b(r11);
        return;
    }

    public void d(b r10, float r11) {
        if (r10 == null) goto L5;
        this.f20852e = r10.b(r11);
        this.f20853f = r10.a(r11);
        return;
    }

    public void e(a r10, a r11, float r12) {
        if (r10 == null) goto L4;
        this.f20848a = r10.b(r12);
    L4:
        if (r11 == null) goto L7;
        this.f20849b = r11.b(r12);
        return;
    }

    public void f(b r10, b r11, float r12) {
        if (r10 == null) goto L4;
        this.f20848a = r10.b(r12);
    L4:
        if (r11 == null) goto L7;
        this.f20849b = r11.b(r12);
        return;
    }

    public void g(a r10, a r11, float r12) {
        if (r10 == null) goto L4;
        this.f20850c = r10.b(r12);
    L4:
        if (r11 == null) goto L7;
        this.f20851d = r11.b(r12);
        return;
    }

    public void h(b r10, b r11, float r12) {
        if (r10 == null) goto L4;
        this.f20850c = r10.b(r12);
    L4:
        if (r11 == null) goto L7;
        this.f20851d = r11.b(r12);
        return;
    }
}
