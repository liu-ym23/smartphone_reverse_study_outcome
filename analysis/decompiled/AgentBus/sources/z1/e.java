package z1;

import a4.u;
import android.graphics.Paint;
import android.text.TextPaint;
import b0.i0;
import c2.l;
import h4.s;
import u0.b0;
import u0.m;
import u0.z;

/* loaded from: classes.dex */
public final class e extends TextPaint {

    /* renamed from: a, reason: collision with root package name */
    public s f11770a;

    /* renamed from: b, reason: collision with root package name */
    public l f11771b;

    /* renamed from: c, reason: collision with root package name */
    public int f11772c;

    /* renamed from: d, reason: collision with root package name */
    public b0 f11773d;

    /* renamed from: e, reason: collision with root package name */
    public m f11774e;

    /* renamed from: f, reason: collision with root package name */
    public z f11775f;

    /* renamed from: g, reason: collision with root package name */
    public i0 f11776g;

    /* renamed from: h, reason: collision with root package name */
    public t0.e f11777h;

    /* renamed from: i, reason: collision with root package name */
    public w0.c f11778i;

    public final s a() {
        s sVar = this.f11770a;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this);
        this.f11770a = sVar2;
        return sVar2;
    }

    public final void b(int i2) {
        if (i2 == this.f11772c) {
            return;
        }
        a().d(i2);
        this.f11772c = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(u0.z r6, long r7, float r9) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto Ld
            r5.f11776g = r0
            r5.f11775f = r0
            r5.f11777h = r0
            r5.setShader(r0)
            return
        Ld:
            boolean r1 = r6 instanceof u0.e0
            if (r1 == 0) goto L1d
            u0.e0 r6 = (u0.e0) r6
            long r6 = r6.f9902b
            long r6 = s7.a.I(r9, r6)
            r5.d(r6)
            return
        L1d:
            boolean r1 = r6 instanceof u0.k
            if (r1 == 0) goto L71
            u0.z r1 = r5.f11775f
            boolean r1 = q7.k.a(r1, r6)
            r2 = 0
            if (r1 == 0) goto L38
            t0.e r1 = r5.f11777h
            if (r1 != 0) goto L30
            r1 = r2
            goto L36
        L30:
            long r3 = r1.f9668a
            boolean r1 = t0.e.a(r3, r7)
        L36:
            if (r1 != 0) goto L58
        L38:
            r3 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 == 0) goto L42
            r2 = 1
        L42:
            if (r2 == 0) goto L58
            r5.f11775f = r6
            t0.e r1 = new t0.e
            r1.<init>(r7)
            r5.f11777h = r1
            b0.a2 r1 = new b0.a2
            r1.<init>(r6, r7)
            b0.i0 r6 = b0.b.j(r1)
            r5.f11776g = r6
        L58:
            h4.s r6 = r5.a()
            b0.i0 r7 = r5.f11776g
            if (r7 == 0) goto L67
            java.lang.Object r7 = r7.getValue()
            android.graphics.Shader r7 = (android.graphics.Shader) r7
            goto L68
        L67:
            r7 = r0
        L68:
            r6.g(r7)
            r5.f11774e = r0
            z1.j.a(r5, r9)
            return
        L71:
            a4.u r5 = new a4.u
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: z1.e.c(u0.z, long, float):void");
    }

    public final void d(long j2) {
        m mVar = this.f11774e;
        if (mVar == null ? false : m.c(mVar.f9918a, j2)) {
            return;
        }
        if (j2 != 16) {
            this.f11774e = new m(j2);
            setColor(z.o(j2));
            this.f11776g = null;
            this.f11775f = null;
            this.f11777h = null;
            setShader(null);
        }
    }

    public final void e(w0.c cVar) {
        if (cVar == null || q7.k.a(this.f11778i, cVar)) {
            return;
        }
        this.f11778i = cVar;
        if (cVar.equals(w0.f.f10635b)) {
            setStyle(Paint.Style.FILL);
            return;
        }
        if (!(cVar instanceof w0.g)) {
            throw new u();
        }
        a().k(1);
        s sVarA = a();
        w0.g gVar = (w0.g) cVar;
        ((Paint) sVarA.f4155g).setStrokeWidth(gVar.f10636b);
        ((Paint) a().f4155g).setStrokeMiter(4.0f);
        a().j();
        a().h(gVar.f10637c);
        ((Paint) a().f4155g).setPathEffect(null);
    }

    public final void f(b0 b0Var) {
        if (b0Var == null || q7.k.a(this.f11773d, b0Var)) {
            return;
        }
        this.f11773d = b0Var;
        if (b0Var.equals(b0.f9889d)) {
            clearShadowLayer();
            return;
        }
        b0 b0Var2 = this.f11773d;
        float f10 = b0Var2.f9892c;
        if (f10 == 0.0f) {
            f10 = Float.MIN_VALUE;
        }
        setShadowLayer(f10, Float.intBitsToFloat((int) (b0Var2.f9891b >> 32)), Float.intBitsToFloat((int) (this.f11773d.f9891b & 4294967295L)), z.o(this.f11773d.f9890a));
    }

    public final void g(l lVar) {
        if (lVar == null || q7.k.a(this.f11771b, lVar)) {
            return;
        }
        this.f11771b = lVar;
        int i2 = lVar.f1877a;
        setUnderlineText((i2 | 1) == i2);
        int i10 = this.f11771b.f1877a;
        setStrikeThruText((i10 | 2) == i10);
    }
}
