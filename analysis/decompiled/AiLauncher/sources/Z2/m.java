package Z2;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* loaded from: classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public final n[] f7208a = new n[4];

    /* renamed from: b, reason: collision with root package name */
    public final Matrix[] f7209b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    public final Matrix[] f7210c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    public final PointF f7211d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    public final Path f7212e = new Path();

    /* renamed from: f, reason: collision with root package name */
    public final Path f7213f = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final n f7214g = new n();

    /* renamed from: h, reason: collision with root package name */
    public final float[] f7215h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    public final float[] f7216i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    public final Path f7217j = new Path();

    /* renamed from: k, reason: collision with root package name */
    public final Path f7218k = new Path();

    /* renamed from: l, reason: collision with root package name */
    public boolean f7219l = true;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final m f7220a = new m();
    }

    public interface b {
        void a(n nVar, Matrix matrix, int i10);

        void b(n nVar, Matrix matrix, int i10);
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final l f7221a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f7222b;

        /* renamed from: c, reason: collision with root package name */
        public final RectF f7223c;

        /* renamed from: d, reason: collision with root package name */
        public final b f7224d;

        /* renamed from: e, reason: collision with root package name */
        public final float f7225e;

        public c(l lVar, float f10, RectF rectF, b bVar, Path path) {
            this.f7224d = bVar;
            this.f7221a = lVar;
            this.f7225e = f10;
            this.f7223c = rectF;
            this.f7222b = path;
        }
    }

    public m() {
        for (int i10 = 0; i10 < 4; i10++) {
            this.f7208a[i10] = new n();
            this.f7209b[i10] = new Matrix();
            this.f7210c[i10] = new Matrix();
        }
    }

    public static m l() {
        return a.f7220a;
    }

    public final float a(int i10) {
        return ((i10 + 1) % 4) * 90;
    }

    public final void b(c cVar, int i10) {
        this.f7215h[0] = this.f7208a[i10].k();
        this.f7215h[1] = this.f7208a[i10].l();
        this.f7209b[i10].mapPoints(this.f7215h);
        if (i10 == 0) {
            Path path = cVar.f7222b;
            float[] fArr = this.f7215h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f7222b;
            float[] fArr2 = this.f7215h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f7208a[i10].d(this.f7209b[i10], cVar.f7222b);
        b bVar = cVar.f7224d;
        if (bVar != null) {
            bVar.b(this.f7208a[i10], this.f7209b[i10], i10);
        }
    }

    public final void c(c cVar, int i10) {
        int i11 = (i10 + 1) % 4;
        this.f7215h[0] = this.f7208a[i10].i();
        this.f7215h[1] = this.f7208a[i10].j();
        this.f7209b[i10].mapPoints(this.f7215h);
        this.f7216i[0] = this.f7208a[i11].k();
        this.f7216i[1] = this.f7208a[i11].l();
        this.f7209b[i11].mapPoints(this.f7216i);
        float f10 = this.f7215h[0];
        float[] fArr = this.f7216i;
        float fMax = Math.max(((float) Math.hypot(f10 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float fJ = j(cVar.f7223c, i10);
        this.f7214g.n(0.0f, 0.0f);
        g gVarK = k(i10, cVar.f7221a);
        gVarK.d(fMax, fJ, cVar.f7225e, this.f7214g);
        this.f7217j.reset();
        this.f7214g.d(this.f7210c[i10], this.f7217j);
        if (this.f7219l && (gVarK.a() || m(this.f7217j, i10) || m(this.f7217j, i11))) {
            Path path = this.f7217j;
            path.op(path, this.f7213f, Path.Op.DIFFERENCE);
            this.f7215h[0] = this.f7214g.k();
            this.f7215h[1] = this.f7214g.l();
            this.f7210c[i10].mapPoints(this.f7215h);
            Path path2 = this.f7212e;
            float[] fArr2 = this.f7215h;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.f7214g.d(this.f7210c[i10], this.f7212e);
        } else {
            this.f7214g.d(this.f7210c[i10], cVar.f7222b);
        }
        b bVar = cVar.f7224d;
        if (bVar != null) {
            bVar.a(this.f7214g, this.f7210c[i10], i10);
        }
    }

    public void d(l lVar, float f10, RectF rectF, b bVar, Path path) {
        f(lVar, null, f10, rectF, bVar, path);
    }

    public void e(l lVar, float f10, RectF rectF, Path path) {
        d(lVar, f10, rectF, null, path);
    }

    public void f(l lVar, float[] fArr, float f10, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.f7212e.rewind();
        this.f7213f.rewind();
        this.f7213f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(lVar, f10, rectF, bVar, path);
        for (int i10 = 0; i10 < 4; i10++) {
            n(cVar, i10, fArr);
            o(i10);
        }
        for (int i11 = 0; i11 < 4; i11++) {
            b(cVar, i11);
            c(cVar, i11);
        }
        path.close();
        this.f7212e.close();
        if (this.f7212e.isEmpty()) {
            return;
        }
        path.op(this.f7212e, Path.Op.UNION);
    }

    public final void g(int i10, RectF rectF, PointF pointF) {
        if (i10 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i10 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i10 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    public d h(int i10, l lVar) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? lVar.t() : lVar.r() : lVar.j() : lVar.l();
    }

    public final e i(int i10, l lVar) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? lVar.s() : lVar.q() : lVar.i() : lVar.k();
    }

    public final float j(RectF rectF, int i10) {
        float[] fArr = this.f7215h;
        n nVar = this.f7208a[i10];
        fArr[0] = nVar.f7228c;
        fArr[1] = nVar.f7229d;
        this.f7209b[i10].mapPoints(fArr);
        return (i10 == 1 || i10 == 3) ? Math.abs(rectF.centerX() - this.f7215h[0]) : Math.abs(rectF.centerY() - this.f7215h[1]);
    }

    public final g k(int i10, l lVar) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? lVar.o() : lVar.p() : lVar.n() : lVar.h();
    }

    public final boolean m(Path path, int i10) {
        this.f7218k.reset();
        this.f7208a[i10].d(this.f7209b[i10], this.f7218k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f7218k.computeBounds(rectF, true);
        path.op(this.f7218k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }

    public final void n(c cVar, int i10, float[] fArr) {
        i(i10, cVar.f7221a).b(this.f7208a[i10], 90.0f, cVar.f7225e, cVar.f7223c, fArr == null ? h(i10, cVar.f7221a) : new Z2.c(fArr[i10]));
        float fA = a(i10);
        this.f7209b[i10].reset();
        g(i10, cVar.f7223c, this.f7211d);
        Matrix matrix = this.f7209b[i10];
        PointF pointF = this.f7211d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f7209b[i10].preRotate(fA);
    }

    public final void o(int i10) {
        this.f7215h[0] = this.f7208a[i10].i();
        this.f7215h[1] = this.f7208a[i10].j();
        this.f7209b[i10].mapPoints(this.f7215h);
        float fA = a(i10);
        this.f7210c[i10].reset();
        Matrix matrix = this.f7210c[i10];
        float[] fArr = this.f7215h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f7210c[i10].preRotate(fA);
    }
}
