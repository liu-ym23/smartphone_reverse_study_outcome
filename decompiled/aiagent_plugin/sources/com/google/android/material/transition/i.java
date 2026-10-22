package com.google.android.material.transition;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;

/* JADX INFO: compiled from: MaskEvaluator.java */
/* JADX INFO: loaded from: classes2.dex */
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f13728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f13729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f13730c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.android.material.shape.n f13731d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.google.android.material.shape.m f13732e;

    i() {
        this.f13728a = new Path();
        this.f13729b = new Path();
        this.f13730c = new Path();
        this.f13731d = com.google.android.material.shape.n.a();
    }

    void a(float r8, com.google.android.material.shape.m r9, com.google.android.material.shape.m r10, RectF r11, RectF r12, RectF r13, MaterialContainerTransform.a r14) {
        com.google.android.material.shape.m r15 = n.a(r9, r10, r11, r13, r14.a(), r14.b(), r8);
        this.f13732e = r15;
        this.f13731d.a(r15, 1.0f, r12, this.f13729b);
        this.f13731d.a(this.f13732e, 1.0f, r13, this.f13730c);
        if (Build.VERSION.SDK_INT < 23) goto L6;
        this.f13728a.op(this.f13729b, this.f13730c, Path.Op.UNION);
        return;
    }

    void a(Canvas r3) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r3.clipPath(this.f13728a);
        return;
    L5:
        r3.clipPath(this.f13729b);
        r3.clipPath(this.f13730c, Region.Op.UNION);
    }

    Path a() {
        return this.f13728a;
    }

    com.google.android.material.shape.m b() {
        return this.f13732e;
    }
}
