package androidx.dynamicanimation.animation;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Force {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f3000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f3001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public double f3003d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f3004e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f3005f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f3006g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f3007h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public double f3008i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DynamicAnimation.o f3009j;

    public c() {
        this.f3000a = Math.sqrt(1500.0d);
        this.f3001b = 0.5d;
        this.f3002c = false;
        this.f3008i = Double.MAX_VALUE;
        this.f3009j = new DynamicAnimation.o();
    }

    public float a() {
        return (float) this.f3008i;
    }

    public final void b() {
        if (this.f3002c == false) goto L6;
        return;
    L6:
        if (this.f3008i == Double.MAX_VALUE) goto L18;
        double r10 = this.f3001b;
        if (r10 <= 1.0d) goto L11;
        double r11 = this.f3000a;
        this.f3005f = ((-r10) * r11) + (r11 * Math.sqrt((r10 * r10) - 1.0d));
        double r12 = this.f3001b;
        double r13 = this.f3000a;
        this.f3006g = ((-r12) * r13) - (r13 * Math.sqrt((r12 * r12) - 1.0d));
    L15:
        this.f3002c = true;
        return;
    L11:
        if (r10 < 0.0d) goto L15;
        if (r10 >= 1.0d) goto L15;
        this.f3007h = this.f3000a * Math.sqrt(1.0d - (r10 * r10));
        goto L15
    L18:
        throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
    }

    public c c(float r10) {
        if (r10 < 0.0f) goto L7;
        this.f3001b = r10;
        this.f3002c = false;
        return this;
    L7:
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public c d(float r10) {
        this.f3008i = r10;
        return this;
    }

    public c e(float r10) {
        if (r10 <= 0.0f) goto L7;
        this.f3000a = Math.sqrt(r10);
        this.f3002c = false;
        return this;
    L7:
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    public void f(double r10) {
        double r11 = Math.abs(r10);
        this.f3003d = r11;
        this.f3004e = r11 * 62.5d;
    }

    public DynamicAnimation.o g(double r17, double r19, long r21) {
        b();
        double r10 = r21 / 1000.0d;
        double r11 = r17 - this.f3008i;
        double r12 = this.f3001b;
        if (r12 <= 1.0d) goto L6;
        double r13 = this.f3006g;
        double r14 = this.f3005f;
        double r15 = r11 - (((r13 * r11) - r19) / (r13 - r14));
        double r16 = ((r11 * r13) - r19) / (r13 - r14);
        double r18 = (Math.pow(2.718281828459045d, r13 * r10) * r15) + (Math.pow(2.718281828459045d, this.f3005f * r10) * r16);
        double r110 = this.f3006g;
        double r20 = (r15 * r110) * Math.pow(2.718281828459045d, r110 * r10);
        double r111 = this.f3005f;
        double r22 = r20 + ((r16 * r111) * Math.pow(2.718281828459045d, r111 * r10));
    L9:
        DynamicAnimation.o r23 = this.f3009j;
        r23.f2997a = (float) (r18 + this.f3008i);
        r23.f2998b = (float) r22;
        return r23;
    L6:
        if (r12 != 1.0d) goto L8;
        double r24 = this.f3000a;
        double r25 = r19 + (r24 * r11);
        double r26 = r11 + (r25 * r10);
        r18 = Math.pow(2.718281828459045d, (-r24) * r10) * r26;
        double r27 = r26 * Math.pow(2.718281828459045d, (-this.f3000a) * r10);
        double r112 = this.f3000a;
        r22 = (r25 * Math.pow(2.718281828459045d, (-r112) * r10)) + (r27 * (-r112));
        goto L9
    L8:
        double r28 = 1.0d / this.f3007h;
        double r113 = this.f3000a;
        double r29 = r28 * (((r12 * r113) * r11) + r19);
        double r30 = Math.pow(2.718281828459045d, ((-r12) * r113) * r10) * ((Math.cos(this.f3007h * r10) * r11) + (Math.sin(this.f3007h * r10) * r29));
        double r114 = this.f3000a;
        double r115 = this.f3001b;
        double r116 = ((-r114) * r30) * r115;
        double r31 = Math.pow(2.718281828459045d, ((-r115) * r114) * r10);
        double r117 = this.f3007h;
        double r32 = ((-r117) * r11) * Math.sin(r117 * r10);
        double r33 = this.f3007h;
        r22 = r116 + (r31 * (r32 + ((r29 * r33) * Math.cos(r33 * r10))));
        r18 = r30;
        goto L9
    }

    @Override // androidx.dynamicanimation.animation.Force
    public float getAcceleration(float r10, float r11) {
        float r12 = r10 - a();
        double r13 = this.f3000a;
        double r14 = r13 * r13;
        double r15 = (r13 * 2.0d) * this.f3001b;
        return (float) (((-r14) * ((double) r12)) - (r15 * ((double) r11)));
    }

    @Override // androidx.dynamicanimation.animation.Force
    public boolean isAtEquilibrium(float r10, float r11) {
        if (Math.abs(r11) < this.f3004e) goto L5;
        return false;
    L5:
        if (Math.abs(r10 - a()) >= this.f3003d) goto L10;
        return true;
    L10:
        return false;
    }

    public c(float r10) {
        this.f3000a = Math.sqrt(1500.0d);
        this.f3001b = 0.5d;
        this.f3002c = false;
        this.f3008i = Double.MAX_VALUE;
        this.f3009j = new DynamicAnimation.o();
        this.f3008i = r10;
    }
}
