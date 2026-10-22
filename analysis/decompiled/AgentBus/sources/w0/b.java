package w0;

import a4.u;
import android.graphics.Paint;
import android.graphics.Shader;
import d2.l;
import h4.s;
import o4.d0;
import q7.k;
import u0.i;
import u0.m;
import u0.z;
import u5.h;

/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: f, reason: collision with root package name */
    public final a f10629f;

    /* renamed from: g, reason: collision with root package name */
    public final h f10630g;

    /* renamed from: h, reason: collision with root package name */
    public s f10631h;

    /* renamed from: i, reason: collision with root package name */
    public s f10632i;

    public b() {
        l lVar = l.f2793f;
        a aVar = new a();
        aVar.f10625a = c.f10633a;
        aVar.f10626b = lVar;
        aVar.f10627c = e.f10634a;
        aVar.f10628d = 0L;
        this.f10629f = aVar;
        h hVar = new h();
        hVar.f10131c = this;
        hVar.f10129a = new d0(15, hVar);
        this.f10630g = hVar;
    }

    public static s a(b bVar, long j2, c cVar, int i2) {
        s sVarE = bVar.e(cVar);
        Paint paint = (Paint) sVarE.f4155g;
        if (!m.c(z.b(paint.getColor()), j2)) {
            sVarE.e(j2);
        }
        if (((Shader) sVarE.f4156h) != null) {
            sVarE.g(null);
        }
        if (!k.a((i) sVarE.f4157i, null)) {
            sVarE.f(null);
        }
        if (sVarE.f4154f != i2) {
            sVarE.d(i2);
        }
        if (paint.isFilterBitmap()) {
            return sVarE;
        }
        paint.setFilterBitmap(true);
        return sVarE;
    }

    @Override // w0.d
    public final void L(long j2, long j4, long j10, float f10) {
        u0.l lVar = this.f10629f.f10627c;
        s sVarE = this.f10632i;
        if (sVarE == null) {
            sVarE = z.e();
            sVarE.k(1);
            this.f10632i = sVarE;
        }
        Paint paint = (Paint) sVarE.f4155g;
        if (!m.c(z.b(paint.getColor()), j2)) {
            sVarE.e(j2);
        }
        if (((Shader) sVarE.f4156h) != null) {
            sVarE.g(null);
        }
        if (!k.a((i) sVarE.f4157i, null)) {
            sVarE.f(null);
        }
        if (sVarE.f4154f != 3) {
            sVarE.d(3);
        }
        if (paint.getStrokeWidth() != f10) {
            paint.setStrokeWidth(f10);
        }
        if (paint.getStrokeMiter() != 4.0f) {
            paint.setStrokeMiter(4.0f);
        }
        if (sVarE.a() != 0) {
            sVarE.h(0);
        }
        if (sVarE.b() != 0) {
            sVarE.j();
        }
        if (!paint.isFilterBitmap()) {
            paint.setFilterBitmap(true);
        }
        lVar.d(j4, j10, sVarE);
    }

    @Override // w0.d
    public final void O(u0.f fVar, z zVar, float f10, c cVar, int i2) {
        this.f10629f.f10627c.k(fVar, b(zVar, cVar, f10, null, i2));
    }

    @Override // w0.d
    public final void U(long j2, long j4, long j10, c cVar, int i2) {
        int i10 = (int) (j4 >> 32);
        int i11 = (int) (j4 & 4294967295L);
        this.f10629f.f10627c.l(Float.intBitsToFloat(i10), Float.intBitsToFloat(i11), Float.intBitsToFloat((int) (j10 >> 32)) + Float.intBitsToFloat(i10), Float.intBitsToFloat((int) (j10 & 4294967295L)) + Float.intBitsToFloat(i11), a(this, j2, cVar, i2));
    }

    public final s b(z zVar, c cVar, float f10, i iVar, int i2) {
        s sVarE = e(cVar);
        Paint paint = (Paint) sVarE.f4155g;
        if (zVar != null) {
            zVar.f(f10, d(), sVarE);
        } else {
            if (((Shader) sVarE.f4156h) != null) {
                sVarE.g(null);
            }
            long jB = z.b(paint.getColor());
            long j2 = m.f9912b;
            if (!m.c(jB, j2)) {
                sVarE.e(j2);
            }
            if (paint.getAlpha() / 255.0f != f10) {
                sVarE.c(f10);
            }
        }
        if (!k.a((i) sVarE.f4157i, iVar)) {
            sVarE.f(iVar);
        }
        if (sVarE.f4154f != i2) {
            sVarE.d(i2);
        }
        if (paint.isFilterBitmap()) {
            return sVarE;
        }
        paint.setFilterBitmap(true);
        return sVarE;
    }

    @Override // d2.c
    public final float c() {
        return this.f10629f.f10625a.c();
    }

    public final s e(c cVar) {
        if (k.a(cVar, f.f10635b)) {
            s sVar = this.f10631h;
            if (sVar != null) {
                return sVar;
            }
            s sVarE = z.e();
            sVarE.k(0);
            this.f10631h = sVarE;
            return sVarE;
        }
        if (!(cVar instanceof g)) {
            throw new u();
        }
        s sVarE2 = this.f10632i;
        if (sVarE2 == null) {
            sVarE2 = z.e();
            sVarE2.k(1);
            this.f10632i = sVarE2;
        }
        Paint paint = (Paint) sVarE2.f4155g;
        float strokeWidth = paint.getStrokeWidth();
        g gVar = (g) cVar;
        float f10 = gVar.f10636b;
        if (strokeWidth != f10) {
            paint.setStrokeWidth(f10);
        }
        int iA = sVarE2.a();
        int i2 = gVar.f10637c;
        if (iA != i2) {
            sVarE2.h(i2);
        }
        if (paint.getStrokeMiter() != 4.0f) {
            paint.setStrokeMiter(4.0f);
        }
        if (sVarE2.b() == 0) {
            return sVarE2;
        }
        sVarE2.j();
        return sVarE2;
    }

    @Override // d2.c
    public final float j() {
        return this.f10629f.f10625a.j();
    }

    @Override // w0.d
    public final h r() {
        return this.f10630g;
    }

    @Override // w0.d
    public final void z(long j2, float f10, float f11, long j4, long j10, c cVar) {
        int i2 = (int) (j4 >> 32);
        int i10 = (int) (j4 & 4294967295L);
        this.f10629f.f10627c.j(Float.intBitsToFloat(i2), Float.intBitsToFloat(i10), Float.intBitsToFloat((int) (j10 >> 32)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j10 & 4294967295L)) + Float.intBitsToFloat(i10), f10, f11, a(this, j2, cVar, 3));
    }
}
