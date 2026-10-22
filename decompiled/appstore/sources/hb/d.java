package hb;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f20389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f20391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f20392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f20393e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f20394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f20395g;

    public d(float r10) {
        this.f20395g = r10;
        this.f20389a = Math.sqrt(50.0f);
        this.f20394f = 1.0f;
    }

    public final float a() {
        return this.f20394f;
    }

    public final float b() {
        double r10 = this.f20389a;
        return (float) (r10 * r10);
    }

    public final void c() {
        if (this.f20390b == false) goto L6;
        return;
    L6:
        if (this.f20395g == e.b()) goto L18;
        float r10 = this.f20394f;
        double r11 = ((double) r10) * ((double) r10);
        float r12 = 1;
        if (r10 <= r12) goto L11;
        double r13 = this.f20389a;
        double r14 = r11 - ((double) 1);
        this.f20391c = (((double) (-r10)) * r13) + (r13 * Math.sqrt(r14));
        double r15 = -this.f20394f;
        double r16 = this.f20389a;
        this.f20392d = (r15 * r16) - (r16 * Math.sqrt(r14));
    L15:
        this.f20390b = true;
        return;
    L11:
        if (r10 < 0) goto L15;
        if (r10 >= r12) goto L15;
        this.f20393e = this.f20389a * Math.sqrt(((double) 1) - r11);
        goto L15
    L18:
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    public final void d(float r10) {
        if (r10 < 0) goto L7;
        this.f20394f = r10;
        this.f20390b = false;
        return;
    L7:
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public final void e(float r10) {
        this.f20395g = r10;
    }

    public final void f(float r10) {
        if (b() <= 0) goto L7;
        this.f20389a = Math.sqrt(r10);
        this.f20390b = false;
        return;
    L7:
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public final c g(float r17, float r18, long r19) {
        c();
        double r10 = r19 / 1000.0d;
        float r11 = r17 - this.f20395g;
        float r12 = this.f20394f;
        if (r12 <= 1) goto L6;
        double r13 = r11;
        double r14 = this.f20392d;
        double r15 = r18;
        double r16 = this.f20391c;
        double r20 = r13 - (((r14 * r13) - r15) / (r14 - r16));
        double r21 = ((r13 * r14) - r15) / (r14 - r16);
        double r22 = (Math.exp(r14 * r10) * r20) + (Math.exp(this.f20391c * r10) * r21);
        double r110 = this.f20392d;
        double r23 = (r20 * r110) * Math.exp(r110 * r10);
        double r111 = this.f20391c;
        double r24 = r23 + ((r21 * r111) * Math.exp(r111 * r10));
    L10:
        return e.a((float) (r22 + ((double) this.f20395g)), (float) r24);
    L6:
        if (r12 != 1.0f) goto L8;
        double r25 = this.f20389a;
        double r26 = r11;
        double r27 = ((double) r18) + (r25 * r26);
        double r28 = r26 + (r27 * r10);
        double r29 = Math.exp((-r25) * r10) * r28;
        double r30 = r28 * Math.exp((-this.f20389a) * r10);
        double r112 = this.f20389a;
        r22 = r29;
        r24 = (r30 * (-r112)) + (r27 * Math.exp((-r112) * r10));
        goto L10
    L8:
        double r31 = ((double) 1) / this.f20393e;
        double r113 = this.f20389a;
        double r114 = r11;
        double r32 = r31 * (((((double) r12) * r113) * r114) + ((double) r18));
        double r33 = Math.exp((((double) (-r12)) * r113) * r10) * ((Math.cos(this.f20393e * r10) * r114) + (Math.sin(this.f20393e * r10) * r32));
        double r34 = this.f20389a;
        float r35 = this.f20394f;
        double r115 = ((-r34) * r33) * ((double) r35);
        double r36 = Math.exp((((double) (-r35)) * r34) * r10);
        double r116 = this.f20393e;
        double r37 = ((-r116) * r114) * Math.sin(r116 * r10);
        double r117 = this.f20393e;
        r24 = (r36 * (r37 + ((r32 * r117) * Math.cos(r117 * r10)))) + r115;
        r22 = r33;
        goto L10
    }
}
