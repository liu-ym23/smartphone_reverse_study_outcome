package n;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final h f22329k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f22330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f22331b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f22332c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f22333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f22334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f22335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float[] f22336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f22337h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f22338i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f22339j;

    static {
        f22329k = k(b.f22322c, (float) ((((double) b.h(50.0f)) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);
    }

    public h(float r10, float r11, float r12, float r13, float r14, float r15, float[] r16, float r17, float r18, float r19) {
        this.f22335f = r10;
        this.f22330a = r11;
        this.f22331b = r12;
        this.f22332c = r13;
        this.f22333d = r14;
        this.f22334e = r15;
        this.f22336g = r16;
        this.f22337h = r17;
        this.f22338i = r18;
        this.f22339j = r19;
    }

    public static h k(float[] r23, float r24, float r25, float r26, boolean r27) {
        float[][] r10 = b.f22320a;
        float r11 = r23[0];
        float[] r12 = r10[0];
        float r13 = r12[0] * r11;
        float r14 = r23[1];
        float r15 = r13 + (r12[1] * r14);
        float r16 = r23[2];
        float r17 = r15 + (r12[2] * r16);
        float[] r18 = r10[1];
        float r19 = ((r18[0] * r11) + (r18[1] * r14)) + (r18[2] * r16);
        float[] r20 = r10[2];
        float r21 = ((r11 * r20[0]) + (r14 * r20[1])) + (r16 * r20[2]);
        float r22 = (r26 / 10.0f) + 0.8f;
        if (r22 < 0.9d) goto L6;
        float r28 = b.d(0.59f, 0.69f, (r22 - 0.9f) * 10.0f);
    L5:
        float r110 = r28;
        if (r27 == false) goto L10;
        float r29 = 1.0f;
    L11:
        double r111 = r29;
        if (r111 <= 1.0d) goto L15;
        r29 = 1.0f;
    L17:
        float[] r30 = {(((100.0f / r17) * r29) + 1.0f) - r29, (((100.0f / r19) * r29) + 1.0f) - r29, (((100.0f / r21) * r29) + 1.0f) - r29};
        float r112 = 1.0f / ((5.0f * r24) + 1.0f);
        float r113 = ((r112 * r112) * r112) * r112;
        float r31 = 1.0f - r113;
        float r32 = (r113 * r24) + (((0.1f * r31) * r31) * ((float) Math.cbrt(((double) r24) * 5.0d)));
        float r114 = b.h(r25) / r23[1];
        double r33 = r114;
        float r210 = ((float) Math.sqrt(r33)) + 1.48f;
        float r115 = 0.725f / ((float) Math.pow(r33, 0.2d));
        float[] r34 = {(float) Math.pow(((double) ((r30[0] * r32) * r17)) / 100.0d, 0.42d), (float) Math.pow(((double) ((r30[1] * r32) * r19)) / 100.0d, 0.42d), (float) Math.pow(((double) ((r30[2] * r32) * r21)) / 100.0d, 0.42d)};
        float r35 = r34[0];
        float r36 = (r35 * 400.0f) / (r35 + 27.13f);
        float r37 = r34[1];
        float r116 = (r37 * 400.0f) / (r37 + 27.13f);
        float r38 = r34[2];
        float[] r39 = {r36, r116, (400.0f * r38) / (r38 + 27.13f)};
        return new h(r114, (((r39[0] * 2.0f) + r39[1]) + (r39[2] * 0.05f)) * r115, r115, r115, r110, r22, r30, r32, (float) Math.pow(r32, 0.25d), r210);
    L15:
        if (r111 >= 0.0d) goto L17;
        r29 = 0.0f;
        goto L17
    L10:
        r29 = (1.0f - (((float) Math.exp(((-r24) - 42.0f) / 92.0f)) * 0.2777778f)) * r22;
        goto L11
    L6:
        r28 = b.d(0.525f, 0.59f, (r22 - 0.8f) * 10.0f);
        goto L5
    }

    public float a() {
        return this.f22330a;
    }

    public float b() {
        return this.f22333d;
    }

    public float c() {
        return this.f22337h;
    }

    public float d() {
        return this.f22338i;
    }

    public float e() {
        return this.f22335f;
    }

    public float f() {
        return this.f22331b;
    }

    public float g() {
        return this.f22334e;
    }

    public float h() {
        return this.f22332c;
    }

    public float[] i() {
        return this.f22336g;
    }

    public float j() {
        return this.f22339j;
    }
}
