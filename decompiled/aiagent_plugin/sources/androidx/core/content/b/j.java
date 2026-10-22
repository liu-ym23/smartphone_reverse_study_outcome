package androidx.core.content.b;

/* JADX INFO: compiled from: ViewingConditions.java */
/* JADX INFO: loaded from: classes.dex */
final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final j f1187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f1188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f1189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f1190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f1191e;
    private final float f;
    private final float g;
    private final float[] h;
    private final float i;
    private final float j;
    private final float k;

    static {
        f1187a = a(b.f1158c, (float) ((((double) b.c(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    }

    float a() {
        return this.f1188b;
    }

    float b() {
        return this.g;
    }

    float c() {
        return this.f1189c;
    }

    float d() {
        return this.f1190d;
    }

    float e() {
        return this.f1191e;
    }

    float f() {
        return this.f;
    }

    float[] g() {
        return this.h;
    }

    float h() {
        return this.i;
    }

    float i() {
        return this.j;
    }

    float j() {
        return this.k;
    }

    private j(float r1, float r2, float r3, float r4, float r5, float r6, float[] r7, float r8, float r9, float r10) {
        this.g = r1;
        this.f1188b = r2;
        this.f1189c = r3;
        this.f1190d = r4;
        this.f1191e = r5;
        this.f = r6;
        this.h = r7;
        this.i = r8;
        this.j = r9;
        this.k = r10;
    }

    static j a(float[] r21, float r22, float r23, float r24, boolean r25) {
        float[][] r1 = b.f1156a;
        float r3 = ((r21[0] * r1[0][0]) + (r21[1] * r1[0][1])) + (r21[2] * r1[0][2]);
        float r6 = ((r21[0] * r1[1][0]) + (r21[1] * r1[1][1])) + (r21[2] * r1[1][2]);
        float r7 = ((r21[0] * r1[2][0]) + (r21[1] * r1[2][1])) + (r21[2] * r1[2][2]);
        float r8 = (r24 / 10.0f) + 0.8f;
        if (r8 < 0.9d) goto L5;
        float r2 = b.a(0.59f, 0.69f, (r8 - 0.9f) * 10.0f);
    L6:
        float r15 = r2;
        if (r25 == false) goto L9;
        float r9 = 1.0f;
    L10:
        double r10 = r9;
        if (r10 <= 1.0d) goto L14;
        r9 = 1.0f;
    L16:
        float[] r14 = {(((100.0f / r3) * r9) + 1.0f) - r9, (((100.0f / r6) * r9) + 1.0f) - r9, (((100.0f / r7) * r9) + 1.0f) - r9};
        float r11 = 1.0f / ((5.0f * r22) + 1.0f);
        float r12 = ((r11 * r11) * r11) * r11;
        float r4 = 1.0f - r12;
        float r0 = (r12 * r22) + (((0.1f * r4) * r4) * ((float) Math.cbrt(((double) r22) * 5.0d)));
        float r13 = b.c(r23) / r21[1];
        double r16 = r13;
        float r20 = ((float) Math.sqrt(r16)) + 1.48f;
        float r5 = 0.725f / ((float) Math.pow(r16, 0.2d));
        float[] r17 = {(float) Math.pow(((double) ((r14[0] * r0) * r3)) / 100.0d, 0.42d), (float) Math.pow(((double) ((r14[1] * r0) * r6)) / 100.0d, 0.42d), (float) Math.pow(((double) ((r14[2] * r0) * r7)) / 100.0d, 0.42d)};
        float[] r18 = {(r17[0] * 400.0f) / (r17[0] + 27.13f), (r17[1] * 400.0f) / (r17[1] + 27.13f), (r17[2] * 400.0f) / (r17[2] + 27.13f)};
        return new j(r13, (((r18[0] * 2.0f) + r18[1]) + (r18[2] * 0.05f)) * r5, r5, r5, r15, r8, r14, r0, (float) Math.pow(r0, 0.25d), r20);
    L14:
        if (r10 >= 0.0d) goto L16;
        r9 = 0.0f;
        goto L16
    L9:
        r9 = (1.0f - (((float) Math.exp(((-r22) - 42.0f) / 92.0f)) * 0.2777778f)) * r8;
        goto L10
    L5:
        r2 = b.a(0.525f, 0.59f, (r8 - 0.8f) * 10.0f);
        goto L6
    }
}
