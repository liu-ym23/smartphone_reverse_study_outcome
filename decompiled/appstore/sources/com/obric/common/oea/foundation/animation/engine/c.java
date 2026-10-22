package com.obric.common.oea.foundation.animation.engine;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends DynamicAnimation {
    public d A;
    public float B;
    public boolean C;

    public c(Object r10, a r11) {
        super(r10, r11);
        this.A = null;
        this.B = Float.MAX_VALUE;
        this.C = false;
    }

    @Override // com.obric.common.oea.foundation.animation.engine.DynamicAnimation
    public void k() {
        p();
        this.A.f(f());
        super.k();
    }

    @Override // com.obric.common.oea.foundation.animation.engine.DynamicAnimation
    public boolean m(long r21) {
        if (this.C == false) goto L10;
        float r10 = this.B;
        if (r10 == Float.MAX_VALUE) goto L7;
        this.A.d(r10);
        this.B = Float.MAX_VALUE;
    L7:
        this.f11522b = this.A.a();
        this.f11521a = 0.0f;
        this.C = false;
        return true;
    L10:
        if (this.B == Float.MAX_VALUE) goto L12;
        this.A.a();
        long r18 = r21 / 2;
        DynamicAnimation.o r11 = this.A.g(this.f11522b, this.f11521a, r18);
        this.A.d(this.B);
        this.B = Float.MAX_VALUE;
        DynamicAnimation.o r12 = this.A.g(r11.f11533a, r11.f11534b, r18);
        this.f11522b = r12.f11533a;
        this.f11521a = r12.f11534b;
    L13:
        float r13 = Math.max(this.f11522b, this.f11528h);
        this.f11522b = r13;
        float r14 = Math.min(r13, this.f11527g);
        this.f11522b = r14;
        if (o(r14, this.f11521a) == false) goto L17;
        this.f11522b = this.A.a();
        this.f11521a = 0.0f;
        return true;
    L17:
        return false;
    L12:
        DynamicAnimation.o r15 = this.A.g(this.f11522b, this.f11521a, r21);
        this.f11522b = r15.f11533a;
        this.f11521a = r15.f11534b;
        goto L13
    }

    public void n(float r10) {
        if (g() == false) goto L6;
        this.B = r10;
        return;
    L6:
        if (this.A != null) goto L8;
        this.A = new d(r10);
    L8:
        this.A.d(r10);
        k();
    }

    public boolean o(float r10, float r11) {
        return this.A.isAtEquilibrium(r10, r11);
    }

    public final void p() {
        d r10 = this.A;
        if (r10 == null) goto L14;
        double r11 = r10.a();
        if (r11 > this.f11527g) goto L12;
        if (r11 < this.f11528h) goto L10;
        return;
    L10:
        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    L12:
        throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    L14:
        throw new UnsupportedOperationException("Incomplete com.obric.oui.animation.engine.SpringAnimation: Either final position or a spring force needs to be set.");
    }

    public c q(d r10) {
        this.A = r10;
        return this;
    }
}
