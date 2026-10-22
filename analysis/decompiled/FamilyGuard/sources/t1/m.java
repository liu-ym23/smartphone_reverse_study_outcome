package t1;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;

/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    private final n[] f22410a = new n[4];

    /* renamed from: b, reason: collision with root package name */
    private final Matrix[] f22411b = new Matrix[4];

    /* renamed from: c, reason: collision with root package name */
    private final Matrix[] f22412c = new Matrix[4];

    /* renamed from: d, reason: collision with root package name */
    private final PointF f22413d = new PointF();

    /* renamed from: e, reason: collision with root package name */
    private final Path f22414e = new Path();

    /* renamed from: f, reason: collision with root package name */
    private final Path f22415f = new Path();

    /* renamed from: g, reason: collision with root package name */
    private final n f22416g = new n();

    /* renamed from: h, reason: collision with root package name */
    private final float[] f22417h = new float[2];

    /* renamed from: i, reason: collision with root package name */
    private final float[] f22418i = new float[2];

    /* renamed from: j, reason: collision with root package name */
    private final Path f22419j = new Path();

    /* renamed from: k, reason: collision with root package name */
    private final Path f22420k = new Path();

    /* renamed from: l, reason: collision with root package name */
    private boolean f22421l = true;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static final m f22422a = new m();
    }

    public interface b {
        void a(n nVar, Matrix matrix, int i5);

        void b(n nVar, Matrix matrix, int i5);
    }

    static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final l f22423a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f22424b;

        /* renamed from: c, reason: collision with root package name */
        public final RectF f22425c;

        /* renamed from: d, reason: collision with root package name */
        public final b f22426d;

        /* renamed from: e, reason: collision with root package name */
        public final float f22427e;

        c(l lVar, float f5, RectF rectF, b bVar, Path path) {
            this.f22426d = bVar;
            this.f22423a = lVar;
            this.f22427e = f5;
            this.f22425c = rectF;
            this.f22424b = path;
        }
    }

    public m() {
        for (int i5 = 0; i5 < 4; i5++) {
            this.f22410a[i5] = new n();
            this.f22411b[i5] = new Matrix();
            this.f22412c[i5] = new Matrix();
        }
    }

    private float a(int i5) {
        return ((i5 + 1) % 4) * 90;
    }

    private void b(c cVar, int i5) {
        this.f22417h[0] = this.f22410a[i5].k();
        this.f22417h[1] = this.f22410a[i5].l();
        this.f22411b[i5].mapPoints(this.f22417h);
        if (i5 == 0) {
            Path path = cVar.f22424b;
            float[] fArr = this.f22417h;
            path.moveTo(fArr[0], fArr[1]);
        } else {
            Path path2 = cVar.f22424b;
            float[] fArr2 = this.f22417h;
            path2.lineTo(fArr2[0], fArr2[1]);
        }
        this.f22410a[i5].d(this.f22411b[i5], cVar.f22424b);
        b bVar = cVar.f22426d;
        if (bVar != null) {
            bVar.a(this.f22410a[i5], this.f22411b[i5], i5);
        }
    }

    private void c(c cVar, int i5) {
        int i6 = (i5 + 1) % 4;
        this.f22417h[0] = this.f22410a[i5].i();
        this.f22417h[1] = this.f22410a[i5].j();
        this.f22411b[i5].mapPoints(this.f22417h);
        this.f22418i[0] = this.f22410a[i6].k();
        this.f22418i[1] = this.f22410a[i6].l();
        this.f22411b[i6].mapPoints(this.f22418i);
        float f5 = this.f22417h[0];
        float[] fArr = this.f22418i;
        float fMax = Math.max(((float) Math.hypot(f5 - fArr[0], r1[1] - fArr[1])) - 0.001f, 0.0f);
        float fH = h(cVar.f22425c, i5);
        this.f22416g.n(0.0f, 0.0f);
        C1114g c1114gI = i(i5, cVar.f22423a);
        c1114gI.d(fMax, fH, cVar.f22427e, this.f22416g);
        this.f22419j.reset();
        this.f22416g.d(this.f22412c[i5], this.f22419j);
        if (this.f22421l && (c1114gI.b() || k(this.f22419j, i5) || k(this.f22419j, i6))) {
            Path path = this.f22419j;
            path.op(path, this.f22415f, Path.Op.DIFFERENCE);
            this.f22417h[0] = this.f22416g.k();
            this.f22417h[1] = this.f22416g.l();
            this.f22412c[i5].mapPoints(this.f22417h);
            Path path2 = this.f22414e;
            float[] fArr2 = this.f22417h;
            path2.moveTo(fArr2[0], fArr2[1]);
            this.f22416g.d(this.f22412c[i5], this.f22414e);
        } else {
            this.f22416g.d(this.f22412c[i5], cVar.f22424b);
        }
        b bVar = cVar.f22426d;
        if (bVar != null) {
            bVar.b(this.f22416g, this.f22412c[i5], i5);
        }
    }

    private void e(int i5, RectF rectF, PointF pointF) {
        if (i5 == 1) {
            pointF.set(rectF.right, rectF.bottom);
            return;
        }
        if (i5 == 2) {
            pointF.set(rectF.left, rectF.bottom);
        } else if (i5 != 3) {
            pointF.set(rectF.right, rectF.top);
        } else {
            pointF.set(rectF.left, rectF.top);
        }
    }

    private C1112e g(int i5, l lVar) {
        return i5 != 1 ? i5 != 2 ? i5 != 3 ? lVar.s() : lVar.q() : lVar.i() : lVar.k();
    }

    private float h(RectF rectF, int i5) {
        float[] fArr = this.f22417h;
        n nVar = this.f22410a[i5];
        fArr[0] = nVar.f22430c;
        fArr[1] = nVar.f22431d;
        this.f22411b[i5].mapPoints(fArr);
        return (i5 == 1 || i5 == 3) ? Math.abs(rectF.centerX() - this.f22417h[0]) : Math.abs(rectF.centerY() - this.f22417h[1]);
    }

    private C1114g i(int i5, l lVar) {
        return i5 != 1 ? i5 != 2 ? i5 != 3 ? lVar.o() : lVar.p() : lVar.n() : lVar.h();
    }

    public static m j() {
        return a.f22422a;
    }

    private boolean k(Path path, int i5) {
        this.f22420k.reset();
        this.f22410a[i5].d(this.f22411b[i5], this.f22420k);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        this.f22420k.computeBounds(rectF, true);
        path.op(this.f22420k, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }

    private void l(c cVar, int i5, float[] fArr) {
        g(i5, cVar.f22423a).b(this.f22410a[i5], 90.0f, cVar.f22427e, cVar.f22425c, fArr == null ? f(i5, cVar.f22423a) : new C1110c(fArr[i5]));
        float fA = a(i5);
        this.f22411b[i5].reset();
        e(i5, cVar.f22425c, this.f22413d);
        Matrix matrix = this.f22411b[i5];
        PointF pointF = this.f22413d;
        matrix.setTranslate(pointF.x, pointF.y);
        this.f22411b[i5].preRotate(fA);
    }

    private void m(int i5) {
        this.f22417h[0] = this.f22410a[i5].i();
        this.f22417h[1] = this.f22410a[i5].j();
        this.f22411b[i5].mapPoints(this.f22417h);
        float fA = a(i5);
        this.f22412c[i5].reset();
        Matrix matrix = this.f22412c[i5];
        float[] fArr = this.f22417h;
        matrix.setTranslate(fArr[0], fArr[1]);
        this.f22412c[i5].preRotate(fA);
    }

    public void d(l lVar, float[] fArr, float f5, RectF rectF, b bVar, Path path) {
        path.rewind();
        this.f22414e.rewind();
        this.f22415f.rewind();
        this.f22415f.addRect(rectF, Path.Direction.CW);
        c cVar = new c(lVar, f5, rectF, bVar, path);
        for (int i5 = 0; i5 < 4; i5++) {
            l(cVar, i5, fArr);
            m(i5);
        }
        for (int i6 = 0; i6 < 4; i6++) {
            b(cVar, i6);
            c(cVar, i6);
        }
        path.close();
        this.f22414e.close();
        if (this.f22414e.isEmpty()) {
            return;
        }
        path.op(this.f22414e, Path.Op.UNION);
    }

    InterfaceC1111d f(int i5, l lVar) {
        return i5 != 1 ? i5 != 2 ? i5 != 3 ? lVar.t() : lVar.r() : lVar.j() : lVar.l();
    }
}
