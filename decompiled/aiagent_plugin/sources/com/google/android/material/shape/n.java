package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o[] f13560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Matrix[] f13561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix[] f13562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PointF f13563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Path f13564e;
    private final Path f;
    private final o g;
    private final float[] h;
    private final float[] i;
    private final Path j;
    private final Path k;
    private boolean l;

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final n f13565a = null;

        static {
            f13565a = new n();
        }
    }

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    public interface b {
        void a(o r1, Matrix r2, int r3);

        void b(o r1, Matrix r2, int r3);
    }

    /* JADX INFO: compiled from: ShapeAppearancePathProvider.java */
    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f13566a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f13567b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final RectF f13568c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f13569d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f13570e;

        c(m r3, float r4, RectF r5, b r6, Path r7) {
            this.f13569d = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.aiagent.plugin");
            this.f13566a = r3;
            this.f13570e = r4;
            this.f13568c = r5;
            this.f13567b = r7;
        }
    }

    private float b(int r1) {
        return (r1 + 1) * 90;
    }

    public n() {
        this.f13560a = new o[4];
        this.f13561b = new Matrix[4];
        this.f13562c = new Matrix[4];
        this.f13563d = new PointF();
        this.f13564e = new Path();
        this.f = new Path();
        this.g = new o();
        this.h = new float[2];
        this.i = new float[2];
        this.j = new Path();
        this.k = new Path();
        this.l = true;
        int r1 = 0;
    L3:
        if (r1 >= 4) goto L5;
        this.f13560a[r1] = new o();
        this.f13561b[r1] = new Matrix();
        this.f13562c[r1] = new Matrix();
        r1 = r1 + 1;
        goto L3
    }

    public static n a() {
        return a.f13565a;
    }

    public void a(m r7, float r8, RectF r9, Path r10) {
        a(r7, r8, r9, null, r10);
    }

    public void a(m r7, float r8, RectF r9, b r10, Path r11) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r10, b.class, "com.obric.aiagent.plugin");
        r11.rewind();
        this.f13564e.rewind();
        this.f.rewind();
        this.f.addRect(r9, Path.Direction.CW);
        c r12 = new c(r7, r8, r9, r4, r11);
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r14 >= 4) goto L6;
        a(r12, r14);
        a(r14);
        r14 = r14 + 1;
    L6:
        if (r13 >= 4) goto L8;
        b(r12, r13);
        c(r12, r13);
        r13 = r13 + 1;
        goto L6
    L8:
        r11.close();
        this.f13564e.close();
        if (Build.VERSION.SDK_INT >= 19) goto L11;
        return;
    L11:
        if (this.f13564e.isEmpty() == true) goto L17;
        r11.op(this.f13564e, Path.Op.UNION);
        return;
    }

    private void a(c r8, int r9) {
        com.google.android.material.shape.c r6 = b(r9, r8.f13566a);
        a(r9, r8.f13566a).a(this.f13560a[r9], 90.0f, r8.f13570e, r8.f13568c, r6);
        float r0 = b(r9);
        this.f13561b[r9].reset();
        a(r9, r8.f13568c, this.f13563d);
        this.f13561b[r9].setTranslate(this.f13563d.x, this.f13563d.y);
        this.f13561b[r9].preRotate(r0);
    }

    private void a(int r6) {
        this.h[0] = this.f13560a[r6].d();
        this.h[1] = this.f13560a[r6].e();
        this.f13561b[r6].mapPoints(this.h);
        float r0 = b(r6);
        this.f13562c[r6].reset();
        Matrix r1 = this.f13562c[r6];
        float[] r4 = this.h;
        r1.setTranslate(r4[0], r4[1]);
        this.f13562c[r6].preRotate(r0);
    }

    private void b(c r5, int r6) {
        this.h[0] = this.f13560a[r6].b();
        this.h[1] = this.f13560a[r6].c();
        this.f13561b[r6].mapPoints(this.h);
        if (r6 != 0) goto L5;
        Path r0 = r5.f13567b;
        float[] r1 = this.h;
        r0.moveTo(r1[0], r1[1]);
    L6:
        this.f13560a[r6].a(this.f13561b[r6], r5.f13567b);
        if (r5.f13569d == null) goto L10;
        r5.f13569d.a(this.f13560a[r6], this.f13561b[r6], r6);
        return;
    L10:
        return;
    L5:
        Path r2 = r5.f13567b;
        float[] r3 = this.h;
        r2.lineTo(r3[0], r3[1]);
        goto L6
    }

    private void c(c r9, int r10) {
        int r0 = (r10 + 1) % 4;
        this.h[0] = this.f13560a[r10].d();
        this.h[1] = this.f13560a[r10].e();
        this.f13561b[r10].mapPoints(this.h);
        this.i[0] = this.f13560a[r0].b();
        this.i[1] = this.f13560a[r0].c();
        this.f13561b[r0].mapPoints(this.i);
        float[] r1 = this.h;
        float r2 = r1[0];
        float[] r5 = this.i;
        float r3 = Math.max(((float) Math.hypot(r2 - r5[0], r1[1] - r5[1])) - 0.001f, 0.0f);
        float r6 = a(r9.f13568c, r10);
        this.g.a(0.0f, 0.0f);
        f r4 = c(r10, r9.f13566a);
        r4.a(r3, r6, r9.f13570e, this.g);
        this.j.reset();
        this.g.a(this.f13562c[r10], this.j);
        if (this.l == true) goto L5;
    L13:
        this.g.a(this.f13562c[r10], r9.f13567b);
    L15:
        if (r9.f13569d == null) goto L18;
        r9.f13569d.b(this.g, this.f13562c[r10], r10);
        return;
    L18:
        return;
    L5:
        if (Build.VERSION.SDK_INT < 19) goto L13;
        if (r4.g() == false) goto L9;
    L12:
        Path r7 = this.j;
        r7.op(r7, this.f, Path.Op.DIFFERENCE);
        this.h[0] = this.g.b();
        this.h[1] = this.g.c();
        this.f13562c[r10].mapPoints(this.h);
        Path r8 = this.f13564e;
        float[] r11 = this.h;
        r8.moveTo(r11[0], r11[1]);
        this.g.a(this.f13562c[r10], this.f13564e);
        goto L15
    L9:
        if (a(this.j, r10) == true) goto L12;
        if (a(this.j, r0) == false) goto L13;
        goto L12
    }

    private boolean a(Path r3, int r4) {
        this.k.reset();
        this.f13560a[r4].a(this.f13561b[r4], this.k);
        RectF r5 = new RectF();
        r3.computeBounds(r5, true);
        this.k.computeBounds(r5, true);
        r3.op(this.k, Path.Op.INTERSECT);
        r3.computeBounds(r5, true);
        if (r5.isEmpty() == true) goto L5;
        return true;
    L5:
        if (r5.width() > 1.0f) goto L7;
    L9:
        return false;
    L7:
        if (r5.height() <= 1.0f) goto L9;
        return true;
    }

    private float a(RectF r5, int r6) {
        this.h[0] = this.f13560a[r6].f13573c;
        this.h[1] = this.f13560a[r6].f13574d;
        this.f13561b[r6].mapPoints(this.h);
        if (r6 == 1) goto L9;
        if (r6 == 3) goto L9;
        return Math.abs(r5.centerY() - this.h[1]);
    L9:
        return Math.abs(r5.centerX() - this.h[0]);
    }

    private d a(int r1, m r2) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return r2.c();
    L11:
        return r2.b();
    L13:
        return r2.e();
    L15:
        return r2.d();
    }

    private com.google.android.material.shape.c b(int r1, m r2) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return r2.g();
    L11:
        return r2.f();
    L13:
        return r2.i();
    L15:
        return r2.h();
    }

    private f c(int r1, m r2) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L11;
        return r2.l();
    L11:
        return r2.k();
    L13:
        return r2.j();
    L15:
        return r2.m();
    }

    private void a(int r1, RectF r2, PointF r3) {
        if (r1 != 1) goto L5;
        r3.set(r2.right, r2.bottom);
        return;
    L5:
        if (r1 != 2) goto L7;
        r3.set(r2.left, r2.bottom);
        return;
    L7:
        if (r1 == 3) goto L9;
        r3.set(r2.right, r2.top);
        return;
    L9:
        r3.set(r2.left, r2.top);
    }

    void a(boolean r1) {
        this.l = r1;
    }
}
