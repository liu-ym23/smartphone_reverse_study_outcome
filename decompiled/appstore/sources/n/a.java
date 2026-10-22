package n;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f22311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f22312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f22313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f22314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f22315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f22316f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f22317g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f22318h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f22319i;

    public a(float r10, float r11, float r12, float r13, float r14, float r15, float r16, float r17, float r18) {
        this.f22311a = r10;
        this.f22312b = r11;
        this.f22313c = r12;
        this.f22314d = r13;
        this.f22315e = r14;
        this.f22316f = r15;
        this.f22317g = r16;
        this.f22318h = r17;
        this.f22319i = r18;
    }

    public static a b(float r12, float r13, float r14) {
        float r10 = 100.0f;
        float r11 = 1000.0f;
        float r15 = 0.0f;
        a r16 = null;
        float r17 = 1000.0f;
    L4:
        if (Math.abs(r15 - r10) <= 0.01f) goto L19;
        float r18 = ((r10 - r15) / 2.0f) + r15;
        int r19 = e(r18, r13, r12).p();
        float r20 = b.b(r19);
        float r21 = Math.abs(r14 - r20);
        if (r21 >= 0.2f) goto L11;
        a r22 = c(r19);
        float r110 = r22.a(e(r22.k(), r22.i(), r12));
        if (r110 > 1.0f) goto L11;
        r16 = r22;
        r11 = r21;
        r17 = r110;
    L11:
        if (r11 != 0.0f) goto L16;
        if (r17 == 0.0f) goto L19;
    L16:
        if (r20 < r14) goto L17;
        r10 = r18;
        goto L4
    L17:
        r15 = r18;
    L19:
        return r16;
    }

    public static a c(int r10) {
        return d(r10, h.f22329k);
    }

    public static a d(int r23, h r24) {
        float[] r10 = b.f(r23);
        float[][] r11 = b.f22320a;
        float r12 = r10[0];
        float[] r13 = r11[0];
        float r14 = r13[0] * r12;
        float r15 = r10[1];
        float r16 = r14 + (r13[1] * r15);
        float r17 = r10[2];
        float r18 = r16 + (r13[2] * r17);
        float[] r19 = r11[1];
        float r20 = ((r19[0] * r12) + (r19[1] * r15)) + (r19[2] * r17);
        float[] r21 = r11[2];
        float r22 = ((r12 * r21[0]) + (r15 * r21[1])) + (r17 * r21[2]);
        float r25 = r24.i()[0] * r18;
        float r26 = r24.i()[1] * r20;
        float r27 = r24.i()[2] * r22;
        float r28 = (float) Math.pow(((double) (r24.c() * Math.abs(r25))) / 100.0d, 0.42d);
        float r29 = (float) Math.pow(((double) (r24.c() * Math.abs(r26))) / 100.0d, 0.42d);
        float r30 = (float) Math.pow(((double) (r24.c() * Math.abs(r27))) / 100.0d, 0.42d);
        float r31 = ((Math.signum(r25) * 400.0f) * r28) / (r28 + 27.13f);
        float r32 = ((Math.signum(r26) * 400.0f) * r29) / (r29 + 27.13f);
        float r33 = ((Math.signum(r27) * 400.0f) * r30) / (r30 + 27.13f);
        double r34 = r33;
        float r35 = ((float) (((((double) r31) * 11.0d) + (((double) r32) * (-12.0d))) + r34)) / 11.0f;
        float r36 = ((float) (((double) (r31 + r32)) - (r34 * 2.0d))) / 9.0f;
        float r37 = r32 * 20.0f;
        float r38 = (((r31 * 20.0f) + r37) + (21.0f * r33)) / 20.0f;
        float r39 = (((r31 * 40.0f) + r37) + r33) / 20.0f;
        float r40 = (((float) Math.atan2(r36, r35)) * 180.0f) / 3.1415927f;
        if (r40 >= 0.0f) goto L7;
        r40 = r40 + 360.0f;
    L5:
        float r110 = r40;
        float r41 = (3.1415927f * r110) / 180.0f;
        float r42 = ((float) Math.pow((r39 * r24.f()) / r24.a(), r24.b() * r24.j())) * 100.0f;
        float r43 = r24.d() * (((4.0f / r24.b()) * ((float) Math.sqrt(r42 / 100.0f))) * (r24.a() + 4.0f));
        if (r110 >= 20.14d) goto L12;
        float r111 = 360.0f + r110;
    L13:
        float r44 = ((float) Math.pow(1.64d - Math.pow(0.29d, r24.e()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos(((((double) r111) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * r24.g()) * r24.h()) * ((float) Math.sqrt((r35 * r35) + (r36 * r36)))) / (r38 + 0.305f), 0.9d));
        float r112 = r44 * ((float) Math.sqrt(((double) r42) / 100.0d));
        float r113 = r112 * r24.d();
        float r114 = ((float) Math.sqrt((r44 * r24.b()) / (r24.a() + 4.0f))) * 50.0f;
        float r210 = (1.7f * r42) / ((0.007f * r42) + 1.0f);
        float r45 = ((float) Math.log((0.0228f * r113) + 1.0f)) * 43.85965f;
        double r46 = r41;
        return new a(r110, r112, r42, r43, r113, r114, r210, r45 * ((float) Math.cos(r46)), r45 * ((float) Math.sin(r46)));
    L12:
        r111 = r110;
        goto L13
    L7:
        if (r40 < 360.0f) goto L5;
        r40 = r40 - 360.0f;
        goto L5
    }

    public static a e(float r10, float r11, float r12) {
        return f(r10, r11, r12, h.f22329k);
    }

    public static a f(float r13, float r14, float r15, h r16) {
        double r10 = ((double) r13) / 100.0d;
        float r11 = (((4.0f / r16.b()) * ((float) Math.sqrt(r10))) * (r16.a() + 4.0f)) * r16.d();
        float r12 = r14 * r16.d();
        float r17 = ((float) Math.sqrt(((r14 / ((float) Math.sqrt(r10))) * r16.b()) / (r16.a() + 4.0f))) * 50.0f;
        float r18 = (1.7f * r13) / ((0.007f * r13) + 1.0f);
        float r19 = ((float) Math.log((((double) r12) * 0.0228d) + 1.0d)) * 43.85965f;
        double r20 = (3.1415927f * r15) / 180.0f;
        return new a(r15, r14, r13, r11, r12, r17, r18, r19 * ((float) Math.cos(r20)), r19 * ((float) Math.sin(r20)));
    }

    public static int m(float r10, float r11, float r12) {
        return n(r10, r11, r12, h.f22329k);
    }

    public static int n(float r10, float r11, float r12, h r13) {
        if (r11 < 1.0d) goto L32;
        if (Math.round(r12) <= 0.0d) goto L32;
        if (Math.round(r12) >= 100.0d) goto L32;
        if (r10 >= 0.0f) goto L12;
        float r14 = 0.0f;
    L13:
        a r15 = null;
        boolean r16 = true;
        float r17 = 0.0f;
        float r18 = r11;
    L15:
        if (Math.abs(r17 - r11) < 0.4f) goto L26;
        a r19 = b(r14, r18, r12);
        if (r16 == true) goto L18;
        if (r19 != null) goto L24;
        r11 = r18;
    L25:
        r18 = ((r11 - r17) / 2.0f) + r17;
        goto L15
    L24:
        r17 = r18;
        r15 = r19;
        goto L25
    L18:
        if (r19 != null) goto L20;
        r18 = ((r11 - r17) / 2.0f) + r17;
        r16 = false;
        goto L15
    L20:
        return r19.o(r13);
    L26:
        if (r15 != null) goto L30;
        return b.a(r12);
    L30:
        return r15.o(r13);
    L12:
        r14 = Math.min(360.0f, r10);
    L32:
        return b.a(r12);
    }

    public float a(a r10) {
        float r11 = l() - r10.l();
        float r12 = g() - r10.g();
        float r13 = h() - r10.h();
        return (float) (Math.pow(Math.sqrt(((r11 * r11) + (r12 * r12)) + (r13 * r13)), 0.63d) * 1.41d);
    }

    public float g() {
        return this.f22318h;
    }

    public float h() {
        return this.f22319i;
    }

    public float i() {
        return this.f22312b;
    }

    public float j() {
        return this.f22311a;
    }

    public float k() {
        return this.f22313c;
    }

    public float l() {
        return this.f22317g;
    }

    public int o(h r16) {
        if (i() != 0.0d) goto L5;
    L8:
        float r10 = 0.0f;
    L9:
        float r11 = (float) Math.pow(((double) r10) / Math.pow(1.64d - Math.pow(0.29d, r16.e()), 0.73d), 1.1111111111111112d);
        double r12 = (j() * 3.1415927f) / 180.0f;
        float r13 = ((float) (Math.cos(2.0d + r12) + 3.8d)) * 0.25f;
        float r14 = r16.a() * ((float) Math.pow(((double) k()) / 100.0d, (1.0d / ((double) r16.b())) / ((double) r16.j())));
        float r15 = ((r13 * 3846.1538f) * r16.g()) * r16.h();
        float r17 = r14 / r16.f();
        float r18 = (float) Math.sin(r12);
        float r19 = (float) Math.cos(r12);
        float r20 = (((0.305f + r17) * 23.0f) * r11) / (((r15 * 23.0f) + ((11.0f * r11) * r19)) + ((r11 * 108.0f) * r18));
        float r21 = r19 * r20;
        float r22 = r20 * r18;
        float r23 = r17 * 460.0f;
        float r24 = (((451.0f * r21) + r23) + (288.0f * r22)) / 1403.0f;
        float r25 = ((r23 - (891.0f * r21)) - (261.0f * r22)) / 1403.0f;
        float r26 = ((r23 - (r21 * 220.0f)) - (r22 * 6300.0f)) / 1403.0f;
        float r27 = (Math.signum(r24) * (100.0f / r16.c())) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r24)) * 27.13d) / (400.0d - ((double) Math.abs(r24)))), 2.380952380952381d));
        float r28 = (Math.signum(r25) * (100.0f / r16.c())) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r25)) * 27.13d) / (400.0d - ((double) Math.abs(r25)))), 2.380952380952381d));
        float r29 = (Math.signum(r26) * (100.0f / r16.c())) * ((float) Math.pow((float) Math.max(0.0d, (((double) Math.abs(r26)) * 27.13d) / (400.0d - ((double) Math.abs(r26)))), 2.380952380952381d));
        float r30 = r27 / r16.i()[0];
        float r31 = r28 / r16.i()[1];
        float r32 = r29 / r16.i()[2];
        float[][] r33 = b.f22321b;
        float[] r34 = r33[0];
        float r35 = ((r34[0] * r30) + (r34[1] * r31)) + (r34[2] * r32);
        float[] r36 = r33[1];
        float r37 = ((r36[0] * r30) + (r36[1] * r31)) + (r36[2] * r32);
        float[] r38 = r33[2];
        return androidx.core.graphics.d.b(r35, r37, ((r30 * r38[0]) + (r31 * r38[1])) + (r32 * r38[2]));
    L5:
        if (k() == 0.0d) goto L8;
        r10 = i() / ((float) Math.sqrt(((double) k()) / 100.0d));
        goto L9
    }

    public int p() {
        return o(h.f22329k);
    }
}
