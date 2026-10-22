package androidx.dynamicanimation.animation;

/* JADX INFO: loaded from: classes.dex */
public final class b extends DynamicAnimation {
    public c A;
    public float B;
    public boolean C;

    public b(Object r10, a r11) {
        super(r10, r11);
        this.A = null;
        this.B = Float.MAX_VALUE;
        this.C = false;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public void j() {
        o();
        this.A.f(d());
        super.j();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public boolean l(long r21) {
        if (this.C == false) goto L10;
        float r10 = this.B;
        if (r10 == Float.MAX_VALUE) goto L7;
        this.A.d(r10);
        this.B = Float.MAX_VALUE;
    L7:
        this.f2986b = this.A.a();
        this.f2985a = 0.0f;
        this.C = false;
        return true;
    L10:
        if (this.B == Float.MAX_VALUE) goto L12;
        this.A.a();
        long r18 = r21 / 2;
        DynamicAnimation.o r11 = this.A.g(this.f2986b, this.f2985a, r18);
        this.A.d(this.B);
        this.B = Float.MAX_VALUE;
        DynamicAnimation.o r12 = this.A.g(r11.f2997a, r11.f2998b, r18);
        this.f2986b = r12.f2997a;
        this.f2985a = r12.f2998b;
    L13:
        float r13 = Math.max(this.f2986b, this.f2992h);
        this.f2986b = r13;
        float r14 = Math.min(r13, this.f2991g);
        this.f2986b = r14;
        if (n(r14, this.f2985a) == false) goto L17;
        this.f2986b = this.A.a();
        this.f2985a = 0.0f;
        return true;
    L17:
        return false;
    L12:
        DynamicAnimation.o r15 = this.A.g(this.f2986b, this.f2985a, r21);
        this.f2986b = r15.f2997a;
        this.f2985a = r15.f2998b;
        goto L13
    }

    public void m(float r10) {
        if (e() == false) goto L6;
        this.B = r10;
        return;
    L6:
        if (this.A != null) goto L8;
        this.A = new c(r10);
    L8:
        this.A.d(r10);
        j();
    }

    public boolean n(float r10, float r11) {
        return this.A.isAtEquilibrium(r10, r11);
    }

    public final void o() {
        c r10 = this.A;
        if (r10 == null) goto L14;
        double r11 = r10.a();
        if (r11 > this.f2991g) goto L12;
        if (r11 < this.f2992h) goto L10;
        return;
    L10:
        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    L12:
        throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    L14:
        throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
    }

    public b p(c r10) {
        this.A = r10;
        return this;
    }
}
