package com.google.android.material.transition.platform;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import com.google.android.material.shape.n;

/* JADX INFO: compiled from: MaskEvaluator.java */
/* JADX INFO: loaded from: classes2.dex */
class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f13764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f13765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f13766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final n f13767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.google.android.material.shape.m f13768e;

    i() {
        this.f13764a = new Path();
        this.f13765b = new Path();
        this.f13766c = new Path();
        this.f13767d = n.a();
    }

    void a(float r8, com.google.android.material.shape.m r9, com.google.android.material.shape.m r10, RectF r11, RectF r12, RectF r13, MaterialContainerTransform.a r14) {
        com.google.android.material.shape.m r15 = l.a(r9, r10, r11, r13, r14.a(), r14.b(), r8);
        this.f13768e = r15;
        this.f13767d.a(r15, 1.0f, r12, this.f13765b);
        this.f13767d.a(this.f13768e, 1.0f, r13, this.f13766c);
        if (Build.VERSION.SDK_INT < 23) goto L6;
        this.f13764a.op(this.f13765b, this.f13766c, Path.Op.UNION);
        return;
    }

    void a(Canvas r3) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r3.clipPath(this.f13764a);
        return;
    L5:
        r3.clipPath(this.f13765b);
        r3.clipPath(this.f13766c, Region.Op.UNION);
    }

    Path a() {
        return this.f13764a;
    }

    com.google.android.material.shape.m b() {
        return this.f13768e;
    }
}
