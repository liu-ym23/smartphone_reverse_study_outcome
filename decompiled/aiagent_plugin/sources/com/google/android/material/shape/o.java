package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ShapePath.java */
/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f13571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f13572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f13573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f13574d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f13575e;

    @Deprecated
    public float f;
    private final List<e> g;
    private final List<f> h;
    private boolean i;

    /* JADX INFO: compiled from: ShapePath.java */
    static class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f13579a;

        public a(c r1) {
            this.f13579a = r1;
        }

        @Override // com.google.android.material.shape.o.f
        public void a(Matrix r9, com.google.android.material.h.a r10, int r11, Canvas r12) {
            float r6 = c.a(this.f13579a);
            float r7 = c.b(this.f13579a);
            r10.a(r12, r9, new RectF(c.c(this.f13579a), c.d(this.f13579a), c.e(this.f13579a), c.f(this.f13579a)), r11, r6, r7);
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    static class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f13580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f13581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f13582c;

        public b(d r1, float r2, float r3) {
            this.f13580a = r1;
            this.f13581b = r2;
            this.f13582c = r3;
        }

        @Override // com.google.android.material.shape.o.f
        public void a(Matrix r6, com.google.android.material.h.a r7, int r8, Canvas r9) {
            RectF r2 = new RectF(0.0f, 0.0f, (float) Math.hypot(d.a(this.f13580a) - this.f13582c, d.b(this.f13580a) - this.f13581b), 0.0f);
            Matrix r0 = new Matrix(r6);
            r0.preTranslate(this.f13581b, this.f13582c);
            r0.preRotate(a());
            r7.a(r9, r0, r2, r8);
        }

        float a() {
            return (float) Math.toDegrees(Math.atan((d.a(this.f13580a) - this.f13582c) / (d.b(this.f13580a) - this.f13581b)));
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class c extends e {
        private static final RectF h = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Deprecated
        public float f13583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f13584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f13585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f13586d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f13587e;

        @Deprecated
        public float f;

        static /* synthetic */ float a(c r0) {
            return r0.e();
        }

        static /* synthetic */ void a(c r0, float r1) {
            r0.e(r1);
        }

        static /* synthetic */ float b(c r0) {
            return r0.f();
        }

        static /* synthetic */ void b(c r0, float r1) {
            r0.f(r1);
        }

        static /* synthetic */ float c(c r0) {
            return r0.a();
        }

        static /* synthetic */ float d(c r0) {
            return r0.b();
        }

        static /* synthetic */ float e(c r0) {
            return r0.c();
        }

        static /* synthetic */ float f(c r0) {
            return r0.d();
        }

        static {
            h = new RectF();
        }

        public c(float r1, float r2, float r3, float r4) {
            a(r1);
            b(r2);
            c(r3);
            d(r4);
        }

        @Override // com.google.android.material.shape.o.e
        public void a(Matrix r6, Path r7) {
            Matrix r0 = this.g;
            r6.invert(r0);
            r7.transform(r0);
            RectF r1 = h;
            r1.set(a(), b(), c(), d());
            r7.arcTo(r1, e(), f(), false);
            r7.transform(r6);
        }

        private float a() {
            return this.f13583a;
        }

        private float b() {
            return this.f13584b;
        }

        private float c() {
            return this.f13585c;
        }

        private float d() {
            return this.f13586d;
        }

        private void a(float r1) {
            this.f13583a = r1;
        }

        private void b(float r1) {
            this.f13584b = r1;
        }

        private void c(float r1) {
            this.f13585c = r1;
        }

        private void d(float r1) {
            this.f13586d = r1;
        }

        private float e() {
            return this.f13587e;
        }

        private float f() {
            return this.f;
        }

        private void e(float r1) {
            this.f13587e = r1;
        }

        private void f(float r1) {
            this.f = r1;
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f13588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f13589b;

        public d() {
        }

        static /* synthetic */ float a(d r0) {
            return r0.f13589b;
        }

        static /* synthetic */ float a(d r0, float r1) {
            r0.f13588a = r1;
            return r1;
        }

        static /* synthetic */ float b(d r0) {
            return r0.f13588a;
        }

        static /* synthetic */ float b(d r0, float r1) {
            r0.f13589b = r1;
            return r1;
        }

        @Override // com.google.android.material.shape.o.e
        public void a(Matrix r2, Path r3) {
            Matrix r0 = this.g;
            r2.invert(r0);
            r3.transform(r0);
            r3.lineTo(this.f13588a, this.f13589b);
            r3.transform(r2);
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    public static abstract class e {
        protected final Matrix g;

        public abstract void a(Matrix r1, Path r2);

        public e() {
            this.g = new Matrix();
        }
    }

    /* JADX INFO: compiled from: ShapePath.java */
    static abstract class f {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final Matrix f13590d = null;

        public abstract void a(Matrix r1, com.google.android.material.h.a r2, int r3, Canvas r4);

        f() {
        }

        static {
            f13590d = new Matrix();
        }

        public final void a(com.google.android.material.h.a r2, int r3, Canvas r4) {
            a(f13590d, r2, r3, r4);
        }
    }

    public o() {
        this.g = new ArrayList();
        this.h = new ArrayList();
        a(0.0f, 0.0f);
    }

    public void a(float r3, float r4) {
        a(r3, r4, 270.0f, 0.0f);
    }

    public void a(float r1, float r2, float r3, float r4) {
        b(r1);
        c(r2);
        d(r1);
        e(r2);
        f(r3);
        g((r3 + r4) % 360.0f);
        this.g.clear();
        this.h.clear();
        this.i = false;
    }

    public void b(float r5, float r6) {
        d r0 = new d();
        d.a(r0, r5);
        d.b(r0, r6);
        this.g.add(r0);
        b r1 = new b(r0, d(), e());
        a(r1, r1.a() + 270.0f, r1.a() + 270.0f);
        d(r5);
        e(r6);
    }

    public void a(float r5, float r6, float r7, float r8, float r9, float r10) {
        c r0 = new c(r5, r6, r7, r8);
        c.a(r0, r9);
        c.b(r0, r10);
        this.g.add(r0);
        a r1 = new a(r0);
        float r2 = r9 + r10;
        if (r10 >= 0.0f) goto L5;
        boolean r11 = true;
    L7:
        if (r11 == false) goto L9;
        r9 = (r9 + 180.0f) % 360.0f;
    L9:
        if (r11 == false) goto L11;
        float r3 = (180.0f + r2) % 360.0f;
    L12:
        a(r1, r9, r3);
        double r4 = r2;
        d(((r5 + r7) * 0.5f) + (((r7 - r5) / 2.0f) * ((float) Math.cos(Math.toRadians(r4)))));
        e(((r6 + r8) * 0.5f) + (((r8 - r6) / 2.0f) * ((float) Math.sin(Math.toRadians(r4)))));
        return;
    L11:
        r3 = r2;
        goto L12
    L5:
        r11 = false;
        goto L7
    }

    public void a(Matrix r6, Path r7) {
        int r0 = this.g.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((e) ZeusTransformUtils.preCheckCast(this.g.get(r1), e.class, "com.obric.aiagent.plugin")).a(r6, r7);
        r1 = r1 + 1;
        goto L3
    }

    f a(Matrix r3) {
        a(g());
        final Matrix r0 = new Matrix(r3);
        final ArrayList r4 = new ArrayList(this.h);
        return new AnonymousClass1(this, r4, r0);
    }

    private void a(f r1, float r2, float r3) {
        a(r2);
        this.h.add(r1);
        f(r3);
    }

    boolean a() {
        return this.i;
    }

    private void a(float r7) {
        if (f() != r7) goto L5;
        return;
    L5:
        float r0 = ((r7 - f()) + 360.0f) % 360.0f;
        if (r0 <= 180.0f) goto L8;
        return;
    L8:
        c r1 = new c(d(), e(), d(), e());
        c.a(r1, f());
        c.b(r1, r0);
        this.h.add(new a(r1));
        f(r7);
    }

    float b() {
        return this.f13571a;
    }

    float c() {
        return this.f13572b;
    }

    float d() {
        return this.f13573c;
    }

    float e() {
        return this.f13574d;
    }

    private float f() {
        return this.f13575e;
    }

    private float g() {
        return this.f;
    }

    private void b(float r1) {
        this.f13571a = r1;
    }

    private void c(float r1) {
        this.f13572b = r1;
    }

    private void d(float r1) {
        this.f13573c = r1;
    }

    private void e(float r1) {
        this.f13574d = r1;
    }

    private void f(float r1) {
        this.f13575e = r1;
    }

    private void g(float r1) {
        this.f = r1;
    }
}
