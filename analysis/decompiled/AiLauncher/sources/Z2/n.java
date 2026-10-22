package Z2;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f7226a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f7227b;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f7228c;

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f7229d;

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f7230e;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f7231f;

    /* renamed from: g, reason: collision with root package name */
    public final List<f> f7232g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final List<g> f7233h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public boolean f7234i;

    public class a extends g {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f7235c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Matrix f7236d;

        public a(List list, Matrix matrix) {
            this.f7235c = list;
            this.f7236d = matrix;
        }

        @Override // Z2.n.g
        public void b(Matrix matrix, Y2.a aVar, int i10, Canvas canvas) {
            Iterator it = this.f7235c.iterator();
            while (it.hasNext()) {
                ((g) it.next()).b(this.f7236d, aVar, i10, canvas);
            }
        }
    }

    public static class b extends g {

        /* renamed from: c, reason: collision with root package name */
        public final d f7238c;

        public b(d dVar) {
            this.f7238c = dVar;
        }

        @Override // Z2.n.g
        public void b(Matrix matrix, Y2.a aVar, int i10, Canvas canvas) {
            aVar.a(canvas, matrix, new RectF(this.f7238c.k(), this.f7238c.o(), this.f7238c.l(), this.f7238c.j()), i10, this.f7238c.m(), this.f7238c.n());
        }
    }

    public static class c extends g {

        /* renamed from: c, reason: collision with root package name */
        public final e f7239c;

        /* renamed from: d, reason: collision with root package name */
        public final float f7240d;

        /* renamed from: e, reason: collision with root package name */
        public final float f7241e;

        public c(e eVar, float f10, float f11) {
            this.f7239c = eVar;
            this.f7240d = f10;
            this.f7241e = f11;
        }

        @Override // Z2.n.g
        public void b(Matrix matrix, Y2.a aVar, int i10, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f7239c.f7250c - this.f7241e, this.f7239c.f7249b - this.f7240d), 0.0f);
            this.f7253a.set(matrix);
            this.f7253a.preTranslate(this.f7240d, this.f7241e);
            this.f7253a.preRotate(c());
            aVar.b(canvas, this.f7253a, rectF, i10);
        }

        public float c() {
            return (float) Math.toDegrees(Math.atan((this.f7239c.f7250c - this.f7241e) / (this.f7239c.f7249b - this.f7240d)));
        }
    }

    public static class d extends f {

        /* renamed from: h, reason: collision with root package name */
        public static final RectF f7242h = new RectF();

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f7243b;

        /* renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f7244c;

        /* renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f7245d;

        /* renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f7246e;

        /* renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f7247f;

        /* renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f7248g;

        public d(float f10, float f11, float f12, float f13) {
            q(f10);
            u(f11);
            r(f12);
            p(f13);
        }

        @Override // Z2.n.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f7251a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f7242h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }

        public final float j() {
            return this.f7246e;
        }

        public final float k() {
            return this.f7243b;
        }

        public final float l() {
            return this.f7245d;
        }

        public final float m() {
            return this.f7247f;
        }

        public final float n() {
            return this.f7248g;
        }

        public final float o() {
            return this.f7244c;
        }

        public final void p(float f10) {
            this.f7246e = f10;
        }

        public final void q(float f10) {
            this.f7243b = f10;
        }

        public final void r(float f10) {
            this.f7245d = f10;
        }

        public final void s(float f10) {
            this.f7247f = f10;
        }

        public final void t(float f10) {
            this.f7248g = f10;
        }

        public final void u(float f10) {
            this.f7244c = f10;
        }
    }

    public static class e extends f {

        /* renamed from: b, reason: collision with root package name */
        public float f7249b;

        /* renamed from: c, reason: collision with root package name */
        public float f7250c;

        @Override // Z2.n.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f7251a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f7249b, this.f7250c);
            path.transform(matrix);
        }
    }

    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f7251a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public static abstract class g {

        /* renamed from: b, reason: collision with root package name */
        public static final Matrix f7252b = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f7253a = new Matrix();

        public final void a(Y2.a aVar, int i10, Canvas canvas) {
            b(f7252b, aVar, i10, canvas);
        }

        public abstract void b(Matrix matrix, Y2.a aVar, int i10, Canvas canvas);
    }

    public n() {
        n(0.0f, 0.0f);
    }

    public void a(float f10, float f11, float f12, float f13, float f14, float f15) {
        d dVar = new d(f10, f11, f12, f13);
        dVar.s(f14);
        dVar.t(f15);
        this.f7232g.add(dVar);
        b bVar = new b(dVar);
        float f16 = f14 + f15;
        boolean z10 = f15 < 0.0f;
        if (z10) {
            f14 = (f14 + 180.0f) % 360.0f;
        }
        c(bVar, f14, z10 ? (180.0f + f16) % 360.0f : f16);
        double d10 = f16;
        r(((f10 + f12) * 0.5f) + (((f12 - f10) / 2.0f) * ((float) Math.cos(Math.toRadians(d10)))));
        s(((f11 + f13) * 0.5f) + (((f13 - f11) / 2.0f) * ((float) Math.sin(Math.toRadians(d10)))));
    }

    public final void b(float f10) {
        if (g() == f10) {
            return;
        }
        float fG = ((f10 - g()) + 360.0f) % 360.0f;
        if (fG > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(fG);
        this.f7233h.add(new b(dVar));
        p(f10);
    }

    public final void c(g gVar, float f10, float f11) {
        b(f10);
        this.f7233h.add(gVar);
        p(f11);
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f7232g.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f7232g.get(i10).a(matrix, path);
        }
    }

    public boolean e() {
        return this.f7234i;
    }

    public g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f7233h), new Matrix(matrix));
    }

    public final float g() {
        return this.f7230e;
    }

    public final float h() {
        return this.f7231f;
    }

    public float i() {
        return this.f7228c;
    }

    public float j() {
        return this.f7229d;
    }

    public float k() {
        return this.f7226a;
    }

    public float l() {
        return this.f7227b;
    }

    public void m(float f10, float f11) {
        e eVar = new e();
        eVar.f7249b = f10;
        eVar.f7250c = f11;
        this.f7232g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f10);
        s(f11);
    }

    public void n(float f10, float f11) {
        o(f10, f11, 270.0f, 0.0f);
    }

    public void o(float f10, float f11, float f12, float f13) {
        t(f10);
        u(f11);
        r(f10);
        s(f11);
        p(f12);
        q((f12 + f13) % 360.0f);
        this.f7232g.clear();
        this.f7233h.clear();
        this.f7234i = false;
    }

    public final void p(float f10) {
        this.f7230e = f10;
    }

    public final void q(float f10) {
        this.f7231f = f10;
    }

    public final void r(float f10) {
        this.f7228c = f10;
    }

    public final void s(float f10) {
        this.f7229d = f10;
    }

    public final void t(float f10) {
        this.f7226a = f10;
    }

    public final void u(float f10) {
        this.f7227b = f10;
    }
}
