package com.obric.oui.animation.engine;

import android.os.Looper;
import android.util.AndroidRuntimeException;

/* JADX INFO: compiled from: SpringAnimation.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d extends b<d> {
    private e w;
    private float x;
    private boolean y;

    public <K> d(K r1, c<K> r2) {
        super(r1, r2);
        this.w = null;
        this.x = Float.MAX_VALUE;
        this.y = false;
    }

    public e e() {
        return this.w;
    }

    public d a(e r1) {
        this.w = r1;
        return this;
    }

    @Override // com.obric.oui.animation.engine.b
    public void a() {
        h();
        this.w.a(d());
        super.a();
    }

    public void f() {
        if (g() == false) goto L13;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L11;
        if (this.t == false) goto L14;
        this.y = true;
        return;
    L14:
        return;
    L11:
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    L13:
        throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
    }

    public boolean g() {
        if (this.w.f33980b <= 0.0d) goto L5;
        return true;
    L5:
        return false;
    }

    private void h() {
        e r0 = this.w;
        if (r0 == null) goto L14;
        double r1 = r0.a();
        if (r1 > this.u) goto L12;
        if (r1 < this.v) goto L10;
        return;
    L10:
        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    L12:
        throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    L14:
        throw new UnsupportedOperationException("Incomplete com.obric.oui.animation.engine.SpringAnimation: Either final position or a spring force needs to be set.");
    }

    @Override // com.obric.oui.animation.engine.b
    boolean b(long r21) {
        if (this.y == false) goto L10;
        float r1 = this.x;
        if (r1 == Float.MAX_VALUE) goto L7;
        this.w.c(r1);
        this.x = Float.MAX_VALUE;
    L7:
        this.p = this.w.a();
        this.o = 0.0f;
        this.y = false;
        return true;
    L10:
        if (this.x == Float.MAX_VALUE) goto L12;
        this.w.a();
        long r18 = r21 / 2;
        b.a r2 = this.w.a(this.p, this.o, r18);
        this.w.c(this.x);
        this.x = Float.MAX_VALUE;
        b.a r3 = this.w.a(r2.f33976a, r2.f33977b, r18);
        this.p = r3.f33976a;
        this.o = r3.f33977b;
    L13:
        this.p = Math.max(this.p, this.v);
        this.p = Math.min(this.p, this.u);
        if (a(this.p, this.o) == false) goto L17;
        this.p = this.w.a();
        this.o = 0.0f;
        return true;
    L17:
        return false;
    L12:
        b.a r4 = this.w.a(this.p, this.o, r21);
        this.p = r4.f33976a;
        this.o = r4.f33977b;
        goto L13
    }

    @Override // com.obric.oui.animation.engine.b
    boolean a(float r1, float r2) {
        return this.w.a(r1, r2);
    }
}
