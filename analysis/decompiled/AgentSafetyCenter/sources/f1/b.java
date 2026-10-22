package f1;

import android.graphics.Paint;
import android.graphics.Shader;
import d1.f0;
import d1.i;
import d1.o;
import d1.p;
import java.lang.invoke.VarHandle;
import o2.l;
import p5.m;
import td.h;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements d {

    /* renamed from: c, reason: collision with root package name */
    public final a f3858c;

    /* renamed from: f, reason: collision with root package name */
    public final m f3859f;

    /* renamed from: g, reason: collision with root package name */
    public d1.f f3860g;

    /* renamed from: h, reason: collision with root package name */
    public d1.f f3861h;

    public b() {
        o2.d dVar = c.f3862a;
        l lVar = l.f9123c;
        a aVar = new a();
        aVar.f3854a = dVar;
        aVar.f3855b = lVar;
        aVar.f3856c = e.f3863a;
        aVar.f3857d = 0L;
        this.f3858c = aVar;
        int i = 8;
        m mVar = new m(i);
        mVar.f9743h = this;
        a1.g gVar = new a1.g(i, false);
        gVar.f19f = mVar;
        VarHandle.storeStoreFence();
        mVar.f9741f = gVar;
        VarHandle.storeStoreFence();
        this.f3859f = mVar;
    }

    public static d1.f b(b bVar, long j10, h hVar, int i) {
        d1.f fVarD = bVar.d(hVar);
        Paint paint = (Paint) fVarD.f2968b;
        if (!p.d(f0.b(paint.getColor()), j10)) {
            fVarD.e(j10);
        }
        if (((Shader) fVarD.f2969c) != null) {
            fVarD.g(null);
        }
        if (!k.a((d1.l) fVarD.f2970d, null)) {
            fVarD.f(null);
        }
        if (fVarD.f2967a != i) {
            fVarD.d(i);
        }
        if (paint.isFilterBitmap()) {
            return fVarD;
        }
        paint.setFilterBitmap(true);
        return fVarD;
    }

    @Override // f1.d
    public final void C(d1.h hVar, long j10, h hVar2) {
        this.f3858c.f3856c.d(hVar, b(this, j10, hVar2, 3));
    }

    @Override // f1.d
    public final void G(d1.e eVar, long j10, long j11, long j12, float f5, d1.l lVar, int i) {
        this.f3858c.f3856c.r(eVar, j10, j11, j12, c(null, f.f3864e, f5, lVar, 3, i));
    }

    @Override // f1.d
    public final void K(long j10, long j11, long j12, h hVar, int i) {
        int i3 = (int) (j11 >> 32);
        int i10 = (int) (j11 & 4294967295L);
        this.f3858c.f3856c.b(Float.intBitsToFloat(i3), Float.intBitsToFloat(i10), Float.intBitsToFloat((int) (j12 >> 32)) + Float.intBitsToFloat(i3), Float.intBitsToFloat((int) (j12 & 4294967295L)) + Float.intBitsToFloat(i10), b(this, j10, hVar, i));
    }

    @Override // f1.d
    public final void O(long j10, float f5, long j11, h hVar) {
        this.f3858c.f3856c.q(f5, j11, b(this, j10, hVar, 3));
    }

    @Override // o2.c
    public final float T() {
        return this.f3858c.f3854a.T();
    }

    @Override // o2.c
    public final float a() {
        return this.f3858c.f3854a.a();
    }

    @Override // f1.d
    public final m a0() {
        return this.f3859f;
    }

    public final d1.f c(f0 f0Var, h hVar, float f5, d1.l lVar, int i, int i3) {
        d1.f fVarD = d(hVar);
        Paint paint = (Paint) fVarD.f2968b;
        if (f0Var != null) {
            f0Var.g(f5, e(), fVarD);
        } else {
            if (((Shader) fVarD.f2969c) != null) {
                fVarD.g(null);
            }
            long jB = f0.b(paint.getColor());
            long j10 = p.f3019b;
            if (!p.d(jB, j10)) {
                fVarD.e(j10);
            }
            if (paint.getAlpha() / 255.0f != f5) {
                fVarD.c(f5);
            }
        }
        if (!k.a((d1.l) fVarD.f2970d, lVar)) {
            fVarD.f(lVar);
        }
        if (fVarD.f2967a != i) {
            fVarD.d(i);
        }
        if (paint.isFilterBitmap() == i3) {
            return fVarD;
        }
        paint.setFilterBitmap(true ^ (i3 == 0));
        return fVarD;
    }

    public final d1.f d(h hVar) {
        if (k.a(hVar, f.f3864e)) {
            d1.f fVar = this.f3860g;
            if (fVar != null) {
                return fVar;
            }
            d1.f fVarF = f0.f();
            fVarF.j(0);
            this.f3860g = fVarF;
            return fVarF;
        }
        if (!(hVar instanceof g)) {
            g5.f.a();
            return null;
        }
        d1.f fVarF2 = this.f3861h;
        if (fVarF2 == null) {
            fVarF2 = f0.f();
            fVarF2.j(1);
            this.f3861h = fVarF2;
        }
        Paint paint = (Paint) fVarF2.f2968b;
        float strokeWidth = paint.getStrokeWidth();
        g gVar = (g) hVar;
        i iVar = gVar.i;
        float f5 = gVar.f3865e;
        if (strokeWidth != f5) {
            paint.setStrokeWidth(f5);
        }
        int iA = fVarF2.a();
        int i = gVar.f3867g;
        if (iA != i) {
            fVarF2.h(i);
        }
        float strokeMiter = paint.getStrokeMiter();
        float f10 = gVar.f3866f;
        if (strokeMiter != f10) {
            paint.setStrokeMiter(f10);
        }
        int iB = fVarF2.b();
        int i3 = gVar.f3868h;
        if (iB != i3) {
            fVarF2.i(i3);
        }
        if (!k.a((i) fVarF2.f2971e, iVar)) {
            paint.setPathEffect(iVar != null ? iVar.f2996a : null);
            fVarF2.f2971e = iVar;
        }
        return fVarF2;
    }

    @Override // f1.d
    public final l getLayoutDirection() {
        return this.f3858c.f3855b;
    }

    @Override // f1.d
    public final void i0(d1.h hVar, f0 f0Var, float f5, h hVar2, int i) {
        this.f3858c.f3856c.d(hVar, c(f0Var, hVar2, f5, null, i, 1));
    }

    @Override // f1.d
    public final void j(long j10, long j11, long j12, float f5, i iVar) {
        o oVar = this.f3858c.f3856c;
        d1.f fVarF = this.f3861h;
        if (fVarF == null) {
            fVarF = f0.f();
            fVarF.j(1);
            this.f3861h = fVarF;
        }
        Paint paint = (Paint) fVarF.f2968b;
        if (!p.d(f0.b(paint.getColor()), j10)) {
            fVarF.e(j10);
        }
        if (((Shader) fVarF.f2969c) != null) {
            fVarF.g(null);
        }
        if (!k.a((d1.l) fVarF.f2970d, null)) {
            fVarF.f(null);
        }
        if (fVarF.f2967a != 3) {
            fVarF.d(3);
        }
        if (paint.getStrokeWidth() != f5) {
            paint.setStrokeWidth(f5);
        }
        if (paint.getStrokeMiter() != 4.0f) {
            paint.setStrokeMiter(4.0f);
        }
        if (fVarF.a() != 0) {
            fVarF.h(0);
        }
        if (fVarF.b() != 0) {
            fVarF.i(0);
        }
        if (!k.a((i) fVarF.f2971e, iVar)) {
            paint.setPathEffect(iVar != null ? iVar.f2996a : null);
            fVarF.f2971e = iVar;
        }
        if (!paint.isFilterBitmap()) {
            paint.setFilterBitmap(true);
        }
        oVar.g(j11, j12, fVarF);
    }

    @Override // f1.d
    public final void n0(long j10, float f5, float f10, long j11, long j12, h hVar) {
        int i = (int) (j11 >> 32);
        int i3 = (int) (j11 & 4294967295L);
        this.f3858c.f3856c.h(Float.intBitsToFloat(i), Float.intBitsToFloat(i3), Float.intBitsToFloat((int) (j12 >> 32)) + Float.intBitsToFloat(i), Float.intBitsToFloat((int) (j12 & 4294967295L)) + Float.intBitsToFloat(i3), f5, f10, b(this, j10, hVar, 3));
    }
}
