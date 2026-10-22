package androidx.transition;

import android.graphics.Path;

/* JADX INFO: compiled from: ArcMotion.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f2807a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f2808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f2809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f2810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f2811e;
    private float f;
    private float g;

    static {
        f2807a = (float) Math.tan(Math.toRadians(35.0d));
    }

    public b() {
        this.f2808b = 0.0f;
        this.f2809c = 0.0f;
        this.f2810d = 70.0f;
        this.f2811e = 0.0f;
        this.f = 0.0f;
        this.g = f2807a;
    }

    @Override // androidx.transition.o
    public Path a(float r12, float r13, float r14, float r15) {
        Path r7 = new Path();
        r7.moveTo(r12, r13);
        float r0 = r14 - r12;
        float r1 = r15 - r13;
        float r2 = (r0 * r0) + (r1 * r1);
        float r3 = (r12 + r14) / 2.0f;
        float r5 = (r13 + r15) / 2.0f;
        float r6 = 0.25f * r2;
        if (r13 <= r15) goto L5;
        boolean r8 = true;
    L7:
        if (Math.abs(r0) >= Math.abs(r1)) goto L13;
        float r4 = Math.abs(r2 / (r1 * 2.0f));
        if (r8 == false) goto L11;
        float r9 = r4 + r15;
        float r10 = r14;
    L12:
        float r11 = this.f;
    L18:
        float r16 = (r6 * r11) * r11;
        float r17 = r3 - r10;
        float r18 = r5 - r9;
        float r19 = (r17 * r17) + (r18 * r18);
        float r110 = this.g;
        float r20 = (r6 * r110) * r110;
        if (r19 < r16) goto L26;
        if (r19 <= r20) goto L24;
        r16 = r20;
        goto L26
    L24:
        r16 = 0.0f;
    L26:
        if (r16 == 0.0f) goto L28;
        float r111 = (float) Math.sqrt(r16 / r19);
        r10 = ((r10 - r3) * r111) + r3;
        r9 = r5 + (r111 * (r9 - r5));
    L28:
        r7.cubicTo((r12 + r10) / 2.0f, (r13 + r9) / 2.0f, (r10 + r14) / 2.0f, (r9 + r15) / 2.0f, r14, r15);
        return r7;
    L11:
        r9 = r4 + r13;
        r10 = r12;
        goto L12
    L13:
        float r21 = r2 / (r0 * 2.0f);
        if (r8 == false) goto L16;
        r9 = r13;
        r10 = r21 + r12;
    L17:
        r11 = this.f2811e;
        goto L18
    L16:
        r10 = r14 - r21;
        r9 = r15;
        goto L17
    L5:
        r8 = false;
        goto L7
    }
}
