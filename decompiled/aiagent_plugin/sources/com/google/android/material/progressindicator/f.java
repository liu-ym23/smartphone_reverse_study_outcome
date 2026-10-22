package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.android.material.progressindicator.b;

/* JADX INFO: compiled from: DrawingDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class f<S extends b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    S f13516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DrawableWithAnimatedVisibilityChange f13517b;

    abstract int a();

    abstract void a(Canvas r1, float r2);

    abstract void a(Canvas r1, Paint r2);

    abstract void a(Canvas r1, Paint r2, float r3, float r4, int r5);

    abstract int b();

    public f(S r1) {
        this.f13516a = r1;
    }

    public void a(DrawableWithAnimatedVisibilityChange r1) {
        this.f13517b = r1;
    }

    void b(Canvas r2, float r3) {
        this.f13516a.c();
        a(r2, r3);
    }
}
