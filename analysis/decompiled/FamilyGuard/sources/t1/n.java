package t1;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import s1.C1047a;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public float f22428a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public float f22429b;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public float f22430c;

    /* renamed from: d, reason: collision with root package name */
    @Deprecated
    public float f22431d;

    /* renamed from: e, reason: collision with root package name */
    @Deprecated
    public float f22432e;

    /* renamed from: f, reason: collision with root package name */
    @Deprecated
    public float f22433f;

    /* renamed from: g, reason: collision with root package name */
    private final List<f> f22434g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private final List<g> f22435h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private boolean f22436i;

    class a extends g {

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f22437c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Matrix f22438d;

        a(List list, Matrix matrix) {
            this.f22437c = list;
            this.f22438d = matrix;
        }

        @Override // t1.n.g
        public void a(Matrix matrix, C1047a c1047a, int i5, Canvas canvas) {
            Iterator it = this.f22437c.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(this.f22438d, c1047a, i5, canvas);
            }
        }
    }

    static class b extends g {

        /* renamed from: c, reason: collision with root package name */
        private final d f22440c;

        public b(d dVar) {
            this.f22440c = dVar;
        }

        @Override // t1.n.g
        public void a(Matrix matrix, C1047a c1047a, int i5, Canvas canvas) {
            c1047a.a(canvas, matrix, new RectF(this.f22440c.k(), this.f22440c.o(), this.f22440c.l(), this.f22440c.j()), i5, this.f22440c.m(), this.f22440c.n());
        }
    }

    static class c extends g {

        /* renamed from: c, reason: collision with root package name */
        private final e f22441c;

        /* renamed from: d, reason: collision with root package name */
        private final float f22442d;

        /* renamed from: e, reason: collision with root package name */
        private final float f22443e;

        public c(e eVar, float f5, float f6) {
            this.f22441c = eVar;
            this.f22442d = f5;
            this.f22443e = f6;
        }

        @Override // t1.n.g
        public void a(Matrix matrix, C1047a c1047a, int i5, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(this.f22441c.f22452c - this.f22443e, this.f22441c.f22451b - this.f22442d), 0.0f);
            this.f22455a.set(matrix);
            this.f22455a.preTranslate(this.f22442d, this.f22443e);
            this.f22455a.preRotate(c());
            c1047a.b(canvas, this.f22455a, rectF, i5);
        }

        float c() {
            return (float) Math.toDegrees(Math.atan((this.f22441c.f22452c - this.f22443e) / (this.f22441c.f22451b - this.f22442d)));
        }
    }

    public static class d extends f {

        /* renamed from: h, reason: collision with root package name */
        private static final RectF f22444h = new RectF();

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public float f22445b;

        /* renamed from: c, reason: collision with root package name */
        @Deprecated
        public float f22446c;

        /* renamed from: d, reason: collision with root package name */
        @Deprecated
        public float f22447d;

        /* renamed from: e, reason: collision with root package name */
        @Deprecated
        public float f22448e;

        /* renamed from: f, reason: collision with root package name */
        @Deprecated
        public float f22449f;

        /* renamed from: g, reason: collision with root package name */
        @Deprecated
        public float f22450g;

        public d(float f5, float f6, float f7, float f8) {
            q(f5);
            u(f6);
            r(f7);
            p(f8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float j() {
            return this.f22448e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float k() {
            return this.f22445b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float l() {
            return this.f22447d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float m() {
            return this.f22449f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float n() {
            return this.f22450g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float o() {
            return this.f22446c;
        }

        private void p(float f5) {
            this.f22448e = f5;
        }

        private void q(float f5) {
            this.f22445b = f5;
        }

        private void r(float f5) {
            this.f22447d = f5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(float f5) {
            this.f22449f = f5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t(float f5) {
            this.f22450g = f5;
        }

        private void u(float f5) {
            this.f22446c = f5;
        }

        @Override // t1.n.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f22453a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            RectF rectF = f22444h;
            rectF.set(k(), o(), l(), j());
            path.arcTo(rectF, m(), n(), false);
            path.transform(matrix);
        }
    }

    public static class e extends f {

        /* renamed from: b, reason: collision with root package name */
        private float f22451b;

        /* renamed from: c, reason: collision with root package name */
        private float f22452c;

        @Override // t1.n.f
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.f22453a;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f22451b, this.f22452c);
            path.transform(matrix);
        }
    }

    public static abstract class f {

        /* renamed from: a, reason: collision with root package name */
        protected final Matrix f22453a = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    static abstract class g {

        /* renamed from: b, reason: collision with root package name */
        static final Matrix f22454b = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        final Matrix f22455a = new Matrix();

        g() {
        }

        public abstract void a(Matrix matrix, C1047a c1047a, int i5, Canvas canvas);

        public final void b(C1047a c1047a, int i5, Canvas canvas) {
            a(f22454b, c1047a, i5, canvas);
        }
    }

    public n() {
        n(0.0f, 0.0f);
    }

    private void b(float f5) {
        if (g() == f5) {
            return;
        }
        float fG = ((f5 - g()) + 360.0f) % 360.0f;
        if (fG > 180.0f) {
            return;
        }
        d dVar = new d(i(), j(), i(), j());
        dVar.s(g());
        dVar.t(fG);
        this.f22435h.add(new b(dVar));
        p(f5);
    }

    private void c(g gVar, float f5, float f6) {
        b(f5);
        this.f22435h.add(gVar);
        p(f6);
    }

    private float g() {
        return this.f22432e;
    }

    private float h() {
        return this.f22433f;
    }

    private void p(float f5) {
        this.f22432e = f5;
    }

    private void q(float f5) {
        this.f22433f = f5;
    }

    private void r(float f5) {
        this.f22430c = f5;
    }

    private void s(float f5) {
        this.f22431d = f5;
    }

    private void t(float f5) {
        this.f22428a = f5;
    }

    private void u(float f5) {
        this.f22429b = f5;
    }

    public void a(float f5, float f6, float f7, float f8, float f9, float f10) {
        d dVar = new d(f5, f6, f7, f8);
        dVar.s(f9);
        dVar.t(f10);
        this.f22434g.add(dVar);
        b bVar = new b(dVar);
        float f11 = f9 + f10;
        boolean z5 = f10 < 0.0f;
        if (z5) {
            f9 = (f9 + 180.0f) % 360.0f;
        }
        c(bVar, f9, z5 ? (180.0f + f11) % 360.0f : f11);
        double d6 = f11;
        r(((f5 + f7) * 0.5f) + (((f7 - f5) / 2.0f) * ((float) Math.cos(Math.toRadians(d6)))));
        s(((f6 + f8) * 0.5f) + (((f8 - f6) / 2.0f) * ((float) Math.sin(Math.toRadians(d6)))));
    }

    public void d(Matrix matrix, Path path) {
        int size = this.f22434g.size();
        for (int i5 = 0; i5 < size; i5++) {
            this.f22434g.get(i5).a(matrix, path);
        }
    }

    boolean e() {
        return this.f22436i;
    }

    g f(Matrix matrix) {
        b(h());
        return new a(new ArrayList(this.f22435h), new Matrix(matrix));
    }

    float i() {
        return this.f22430c;
    }

    float j() {
        return this.f22431d;
    }

    float k() {
        return this.f22428a;
    }

    float l() {
        return this.f22429b;
    }

    public void m(float f5, float f6) {
        e eVar = new e();
        eVar.f22451b = f5;
        eVar.f22452c = f6;
        this.f22434g.add(eVar);
        c cVar = new c(eVar, i(), j());
        c(cVar, cVar.c() + 270.0f, cVar.c() + 270.0f);
        r(f5);
        s(f6);
    }

    public void n(float f5, float f6) {
        o(f5, f6, 270.0f, 0.0f);
    }

    public void o(float f5, float f6, float f7, float f8) {
        t(f5);
        u(f6);
        r(f5);
        s(f6);
        p(f7);
        q((f7 + f8) % 360.0f);
        this.f22434g.clear();
        this.f22435h.clear();
        this.f22436i = false;
    }
}
