package k2;

import android.graphics.Paint;
import android.text.TextPaint;
import d1.f0;
import d1.i0;
import d1.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends TextPaint {

    /* renamed from: a, reason: collision with root package name */
    public d1.f f7193a;

    /* renamed from: b, reason: collision with root package name */
    public n2.l f7194b;

    /* renamed from: c, reason: collision with root package name */
    public int f7195c;

    /* renamed from: d, reason: collision with root package name */
    public i0 f7196d;

    /* renamed from: e, reason: collision with root package name */
    public p f7197e;

    /* renamed from: f, reason: collision with root package name */
    public f0 f7198f;

    /* renamed from: g, reason: collision with root package name */
    public k0.i0 f7199g;

    /* renamed from: h, reason: collision with root package name */
    public c1.e f7200h;
    public td.h i;

    public final d1.f a() {
        d1.f fVar = this.f7193a;
        if (fVar != null) {
            return fVar;
        }
        d1.f fVar2 = new d1.f(this);
        this.f7193a = fVar2;
        return fVar2;
    }

    public final void b(int i) {
        if (i == this.f7195c) {
            return;
        }
        a().d(i);
        this.f7195c = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(d1.f0 r6, long r7, float r9) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto Ld
            r5.f7199g = r0
            r5.f7198f = r0
            r5.f7200h = r0
            r5.setShader(r0)
            return
        Ld:
            boolean r1 = r6 instanceof d1.l0
            if (r1 == 0) goto L1d
            d1.l0 r6 = (d1.l0) r6
            long r6 = r6.f3013b
            long r6 = p5.f.D(r9, r6)
            r5.d(r6)
            return
        L1d:
            boolean r1 = r6 instanceof d1.h0
            if (r1 == 0) goto L77
            d1.f0 r1 = r5.f7198f
            boolean r1 = yb.k.a(r1, r6)
            r2 = 0
            if (r1 == 0) goto L38
            c1.e r1 = r5.f7200h
            if (r1 != 0) goto L30
            r1 = r2
            goto L36
        L30:
            long r3 = r1.f2179a
            boolean r1 = c1.e.b(r3, r7)
        L36:
            if (r1 != 0) goto L5e
        L38:
            r3 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L42
            r2 = 1
        L42:
            if (r2 == 0) goto L5e
            r5.f7198f = r6
            c1.e r1 = c1.e.a(r7)
            r5.f7200h = r1
            k2.e r1 = new k2.e
            r1.<init>()
            r1.f7191c = r6
            r1.f7192f = r7
            java.lang.invoke.VarHandle.storeStoreFence()
            k0.i0 r6 = k0.z.q(r1)
            r5.f7199g = r6
        L5e:
            d1.f r6 = r5.a()
            k0.i0 r7 = r5.f7199g
            if (r7 == 0) goto L6d
            java.lang.Object r7 = r7.getValue()
            android.graphics.Shader r7 = (android.graphics.Shader) r7
            goto L6e
        L6d:
            r7 = r0
        L6e:
            r6.g(r7)
            r5.f7197e = r0
            k2.k.b(r5, r9)
            return
        L77:
            g5.f.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.f.c(d1.f0, long, float):void");
    }

    public final void d(long j10) {
        p pVar = this.f7197e;
        if (pVar == null ? false : p.d(pVar.f3026a, j10)) {
            return;
        }
        if (j10 != 16) {
            this.f7197e = p.a(j10);
            setColor(f0.r(j10));
            this.f7199g = null;
            this.f7198f = null;
            this.f7200h = null;
            setShader(null);
        }
    }

    public final void e(td.h hVar) {
        if (hVar == null || yb.k.a(this.i, hVar)) {
            return;
        }
        this.i = hVar;
        if (hVar.equals(f1.f.f3864e)) {
            setStyle(Paint.Style.FILL);
            return;
        }
        if (!(hVar instanceof f1.g)) {
            g5.f.a();
            return;
        }
        a().j(1);
        f1.g gVar = (f1.g) hVar;
        ((Paint) a().f2968b).setStrokeWidth(gVar.f3865e);
        ((Paint) a().f2968b).setStrokeMiter(gVar.f3866f);
        a().i(gVar.f3868h);
        a().h(gVar.f3867g);
        d1.f fVarA = a();
        d1.i iVar = gVar.i;
        ((Paint) fVarA.f2968b).setPathEffect(iVar != null ? iVar.f2996a : null);
        fVarA.f2971e = iVar;
    }

    public final void f(i0 i0Var) {
        if (i0Var == null || yb.k.a(this.f7196d, i0Var)) {
            return;
        }
        this.f7196d = i0Var;
        if (i0Var.equals(i0.f2997d)) {
            clearShadowLayer();
            return;
        }
        i0 i0Var2 = this.f7196d;
        float f5 = i0Var2.f3000c;
        if (f5 == 0.0f) {
            f5 = Float.MIN_VALUE;
        }
        setShadowLayer(f5, Float.intBitsToFloat((int) (i0Var2.f2999b >> 32)), Float.intBitsToFloat((int) (this.f7196d.f2999b & 4294967295L)), f0.r(this.f7196d.f2998a));
    }

    public final void g(n2.l lVar) {
        if (lVar == null || yb.k.a(this.f7194b, lVar)) {
            return;
        }
        this.f7194b = lVar;
        int i = lVar.f8665a;
        setUnderlineText((i | 1) == i);
        int i3 = this.f7194b.f8665a;
        setStrikeThruText((i3 | 2) == i3);
    }
}
