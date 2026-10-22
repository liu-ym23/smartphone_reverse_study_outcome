package com.obric.oui.animation.engine;

import android.os.Looper;
import android.util.AndroidRuntimeException;

/* JADX INFO: loaded from: classes4.dex */
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

    @Override // com.obric.oui.animation.engine.DynamicAnimation
    public void o() {
        u();
        this.A.f(f());
        super.o();
    }

    @Override // com.obric.oui.animation.engine.DynamicAnimation
    public boolean q(long r21) {
        if (this.C == false) goto L10;
        float r10 = this.B;
        if (r10 == Float.MAX_VALUE) goto L7;
        this.A.d(r10);
        this.B = Float.MAX_VALUE;
    L7:
        this.f12327b = this.A.a();
        this.f12326a = 0.0f;
        this.C = false;
        return true;
    L10:
        if (this.B == Float.MAX_VALUE) goto L12;
        this.A.a();
        long r18 = r21 / 2;
        DynamicAnimation.o r11 = this.A.g(this.f12327b, this.f12326a, r18);
        this.A.d(this.B);
        this.B = Float.MAX_VALUE;
        DynamicAnimation.o r12 = this.A.g(r11.f12338a, r11.f12339b, r18);
        this.f12327b = r12.f12338a;
        this.f12326a = r12.f12339b;
    L13:
        float r13 = Math.max(this.f12327b, this.f12333h);
        this.f12327b = r13;
        float r14 = Math.min(r13, this.f12332g);
        this.f12327b = r14;
        if (t(r14, this.f12326a) == false) goto L17;
        this.f12327b = this.A.a();
        this.f12326a = 0.0f;
        return true;
    L17:
        return false;
    L12:
        DynamicAnimation.o r15 = this.A.g(this.f12327b, this.f12326a, r21);
        this.f12327b = r15.f12338a;
        this.f12326a = r15.f12339b;
        goto L13
    }

    public boolean r() {
        if (this.A.f12342b <= 0.0d) goto L5;
        return true;
    L5:
        return false;
    }

    public c s() {
        return this.A;
    }

    public boolean t(float r10, float r11) {
        return this.A.isAtEquilibrium(r10, r11);
    }

    public final void u() {
        c r10 = this.A;
        if (r10 == null) goto L14;
        double r11 = r10.a();
        if (r11 > this.f12332g) goto L12;
        if (r11 < this.f12333h) goto L10;
        return;
    L10:
        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    L12:
        throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    L14:
        throw new UnsupportedOperationException("Incomplete com.obric.oui.animation.engine.SpringAnimation: Either final position or a spring force needs to be set.");
    }

    public b v(c r10) {
        this.A = r10;
        return this;
    }

    public void w() {
        if (r() == false) goto L13;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L11;
        if (this.f12331f == false) goto L14;
        this.C = true;
        return;
    L14:
        return;
    L11:
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    L13:
        throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
    }
}
