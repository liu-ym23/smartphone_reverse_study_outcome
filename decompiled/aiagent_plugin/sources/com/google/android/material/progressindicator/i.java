package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import java.util.Arrays;

/* JADX INFO: compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
final class i extends g<ObjectAnimator> {
    private static final Property<i, Float> j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ObjectAnimator f13524a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FastOutSlowInInterpolator f13525e;
    private final b f;
    private int g;
    private boolean h;
    private float i;

    @Override // com.google.android.material.progressindicator.g
    public void a(Animatable2Compat.a r1) {
    }

    @Override // com.google.android.material.progressindicator.g
    public void c() {
    }

    @Override // com.google.android.material.progressindicator.g
    public void e() {
    }

    static /* synthetic */ int a(i r0) {
        return r0.g;
    }

    static /* synthetic */ int a(i r0, int r1) {
        r0.g = r1;
        return r1;
    }

    static /* synthetic */ boolean a(i r0, boolean r1) {
        r0.h = r1;
        return r1;
    }

    static /* synthetic */ b b(i r0) {
        return r0.f;
    }

    static /* synthetic */ float c(i r0) {
        return r0.i();
    }

    public i(k r2) {
        super(3);
        this.g = 1;
        this.f = r2;
        this.f13525e = new FastOutSlowInInterpolator();
    }

    @Override // com.google.android.material.progressindicator.g
    public void a() {
        g();
        f();
        this.f13524a.start();
    }

    private void g() {
        if (this.f13524a != null) goto L6;
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, j, new float[]{0.0f, 1.0f});
        this.f13524a = r0;
        r0.setDuration(333);
        this.f13524a.setInterpolator(null);
        this.f13524a.setRepeatCount(-1);
        this.f13524a.addListener(new LinearIndeterminateContiguousAnimatorDelegate$1(this));
        return;
    }

    @Override // com.google.android.material.progressindicator.g
    public void b() {
        ObjectAnimator r0 = this.f13524a;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // com.google.android.material.progressindicator.g
    public void d() {
        f();
    }

    private void a(int r5) {
        this.f13519c[0] = 0.0f;
        float r6 = a(r5, 0, 667);
        float[] r0 = this.f13519c;
        float[] r1 = this.f13519c;
        float r2 = this.f13525e.getInterpolation(r6);
        r1[2] = r2;
        r0[1] = r2;
        float[] r3 = this.f13519c;
        float[] r4 = this.f13519c;
        FastOutSlowInInterpolator r7 = this.f13525e;
        float r8 = r7.getInterpolation(r6 + 0.49925038f);
        r4[4] = r8;
        r3[3] = r8;
        this.f13519c[5] = 1.0f;
    }

    private void h() {
        if (this.h == true) goto L5;
        return;
    L5:
        if (this.f13519c[3] >= 1.0f) goto L9;
        this.f13520d[2] = this.f13520d[1];
        this.f13520d[1] = this.f13520d[0];
        this.f13520d[0] = com.google.android.material.color.b.b(this.f.f13508c[this.g], this.f13518b.getAlpha());
        this.h = false;
        return;
    }

    void f() {
        this.h = true;
        this.g = 1;
        Arrays.fill(this.f13520d, com.google.android.material.color.b.b(this.f.f13508c[0], this.f13518b.getAlpha()));
    }

    private float i() {
        return this.i;
    }

    void a(float r2) {
        this.i = r2;
        a((int) (r2 * 333.0f));
        h();
        this.f13518b.invalidateSelf();
    }

    static {
        final Class<Float> r1 = Float.class;
        final String r2 = "animationFraction";
        j = new LinearIndeterminateContiguousAnimatorDelegate$2(r1, r2);
    }
}
