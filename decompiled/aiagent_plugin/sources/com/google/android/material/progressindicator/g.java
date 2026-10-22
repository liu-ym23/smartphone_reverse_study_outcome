package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* JADX INFO: compiled from: IndeterminateAnimatorDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class g<T extends Animator> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected IndeterminateDrawable f13518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final float[] f13519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int[] f13520d;

    public float a(int r1, int r2, int r3) {
        return (r1 - r2) / r3;
    }

    abstract void a();

    public abstract void a(Animatable2Compat.a r1);

    abstract void b();

    abstract void c();

    public abstract void d();

    public abstract void e();

    public g(int r2) {
        this.f13519c = new float[r2 * 2];
        this.f13520d = new int[r2];
    }

    public void a(IndeterminateDrawable r1) {
        this.f13518b = r1;
    }
}
