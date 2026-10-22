package j1;

import android.graphics.Canvas;
import android.graphics.RecordingCanvas;
import android.graphics.RenderNode;
import android.view.ViewParent;

/* loaded from: classes.dex */
public final class n1 implements i1.j1 {

    /* renamed from: f, reason: collision with root package name */
    public x0.b f5262f;

    /* renamed from: g, reason: collision with root package name */
    public final u0.p f5263g;

    /* renamed from: h, reason: collision with root package name */
    public final y f5264h;

    /* renamed from: i, reason: collision with root package name */
    public p7.n f5265i;

    /* renamed from: j, reason: collision with root package name */
    public p7.a f5266j;

    /* renamed from: k, reason: collision with root package name */
    public long f5267k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5268l;

    /* renamed from: n, reason: collision with root package name */
    public float[] f5270n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5271o;

    /* renamed from: s, reason: collision with root package name */
    public int f5275s;

    /* renamed from: u, reason: collision with root package name */
    public u0.w f5277u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f5278v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f5279w;

    /* renamed from: y, reason: collision with root package name */
    public boolean f5281y;

    /* renamed from: m, reason: collision with root package name */
    public final float[] f5269m = u0.z.g();

    /* renamed from: p, reason: collision with root package name */
    public d2.c f5272p = new d2.d(1.0f, 1.0f);

    /* renamed from: q, reason: collision with root package name */
    public d2.l f5273q = d2.l.f2793f;

    /* renamed from: r, reason: collision with root package name */
    public final w0.b f5274r = new w0.b();

    /* renamed from: t, reason: collision with root package name */
    public long f5276t = u0.f0.f9906a;

    /* renamed from: x, reason: collision with root package name */
    public boolean f5280x = true;

    /* renamed from: z, reason: collision with root package name */
    public final c1.w f5282z = new c1.w(12, this);

    public n1(x0.b bVar, u0.p pVar, y yVar, p7.n nVar, p7.a aVar) {
        this.f5262f = bVar;
        this.f5263g = pVar;
        this.f5264h = yVar;
        this.f5265i = nVar;
        this.f5266j = aVar;
        long j2 = Integer.MAX_VALUE;
        this.f5267k = (j2 & 4294967295L) | (j2 << 32);
    }

    public final float[] a() {
        float[] fArrG = this.f5270n;
        if (fArrG == null) {
            fArrG = u0.z.g();
            this.f5270n = fArrG;
        }
        if (this.f5279w) {
            this.f5279w = false;
            float[] fArrB = b();
            if (this.f5280x) {
                return fArrB;
            }
            if (!k0.o(fArrB, fArrG)) {
                fArrG[0] = Float.NaN;
                return null;
            }
        } else if (Float.isNaN(fArrG[0])) {
            return null;
        }
        return fArrG;
    }

    public final float[] b() {
        boolean z4 = this.f5278v;
        float[] fArr = this.f5269m;
        if (z4) {
            x0.b bVar = this.f5262f;
            long jR = bVar.f11084v;
            x0.c cVar = bVar.f11063a;
            if ((9223372034707292159L & jR) == 9205357640488583168L) {
                jR = nb.i.r(ib.k.W(this.f5267k));
            }
            float fIntBitsToFloat = Float.intBitsToFloat((int) (jR >> 32));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jR & 4294967295L));
            float f10 = cVar.f11096j;
            float f11 = cVar.f11097k;
            double d6 = 0.0f * 0.017453292519943295d;
            float fSin = (float) Math.sin(d6);
            float fCos = (float) Math.cos(d6);
            float f12 = -fSin;
            float f13 = (0.0f * fCos) - (1.0f * fSin);
            float f14 = (1.0f * fCos) + (0.0f * fSin);
            float fSin2 = (float) Math.sin(d6);
            float fCos2 = (float) Math.cos(d6);
            float f15 = -fSin2;
            float f16 = fSin * fSin2;
            float f17 = fSin * fCos2;
            float f18 = fCos * fSin2;
            float f19 = fCos * fCos2;
            float f20 = (f14 * fSin2) + (0.0f * fCos2);
            float f21 = (f14 * fCos2) + ((-0.0f) * fSin2);
            float fSin3 = (float) Math.sin(d6);
            float fCos3 = (float) Math.cos(d6);
            float f22 = -fSin3;
            float f23 = (fCos3 * f16) + (f22 * fCos2);
            float f24 = ((f16 * fSin3) + (fCos2 * fCos3)) * f10;
            float f25 = fSin3 * fCos * f10;
            float f26 = ((fSin3 * f17) + (fCos3 * f15)) * f10;
            float f27 = f23 * f11;
            float f28 = fCos * fCos3 * f11;
            float f29 = ((fCos3 * f17) + (f22 * f15)) * f11;
            float f30 = f18 * 1.0f;
            float f31 = f12 * 1.0f;
            float f32 = f19 * 1.0f;
            if (fArr.length >= 16) {
                fArr[0] = f24;
                fArr[1] = f25;
                fArr[2] = f26;
                fArr[3] = 0.0f;
                fArr[4] = f27;
                fArr[5] = f28;
                fArr[6] = f29;
                fArr[7] = 0.0f;
                fArr[8] = f30;
                fArr[9] = f31;
                fArr[10] = f32;
                fArr[11] = 0.0f;
                float f33 = -fIntBitsToFloat;
                fArr[12] = ((f24 * f33) - (f27 * fIntBitsToFloat2)) + f20 + fIntBitsToFloat;
                fArr[13] = ((f25 * f33) - (f28 * fIntBitsToFloat2)) + f13 + fIntBitsToFloat2;
                fArr[14] = ((f33 * f26) - (fIntBitsToFloat2 * f29)) + f21;
                fArr[15] = 1.0f;
            }
            this.f5278v = false;
            this.f5280x = u0.z.h(fArr);
        }
        return fArr;
    }

    public final long c(long j2, boolean z4) {
        float[] fArrB;
        if (z4) {
            fArrB = a();
            if (fArrB == null) {
                return 9187343241974906880L;
            }
        } else {
            fArrB = b();
        }
        return this.f5280x ? j2 : u0.z.j(fArrB, j2);
    }

    public final void d(long j2) {
        y yVar = this.f5264h;
        if (yVar.f5364k) {
            yVar.F(-4.0f);
        }
        x0.b bVar = this.f5262f;
        if (!d2.i.a(bVar.f11082t, j2)) {
            bVar.f11082t = j2;
            long j4 = bVar.f11083u;
            x0.c cVar = bVar.f11063a;
            int i2 = (int) (j2 >> 32);
            int i10 = (int) (j2 & 4294967295L);
            cVar.f11089c.setPosition(i2, i10, ((int) (j4 >> 32)) + i2, ((int) (4294967295L & j4)) + i10);
            cVar.f11090d = ib.k.W(j4);
        }
        ViewParent parent = yVar.getParent();
        if (parent != null) {
            parent.onDescendantInvalidated(yVar, yVar);
        }
    }

    public final void e(long j2) {
        if (d2.k.a(j2, this.f5267k)) {
            return;
        }
        y yVar = this.f5264h;
        if (yVar.f5364k) {
            yVar.F(-4.0f);
        }
        this.f5267k = j2;
        if (this.f5271o || this.f5268l) {
            return;
        }
        yVar.invalidate();
        if (true != this.f5271o) {
            this.f5271o = true;
            yVar.r(this, true);
        }
    }

    public final void f() {
        if (this.f5271o) {
            if (this.f5276t != u0.f0.f9906a && !d2.k.a(this.f5262f.f11083u, this.f5267k)) {
                x0.b bVar = this.f5262f;
                float fA = u0.f0.a(this.f5276t) * ((int) (this.f5267k >> 32));
                float fB = u0.f0.b(this.f5276t) * ((int) (this.f5267k & 4294967295L));
                long jFloatToRawIntBits = (Float.floatToRawIntBits(fB) & 4294967295L) | (Float.floatToRawIntBits(fA) << 32);
                if (!t0.b.b(bVar.f11084v, jFloatToRawIntBits)) {
                    bVar.f11084v = jFloatToRawIntBits;
                    RenderNode renderNode = bVar.f11063a.f11089c;
                    if ((9223372034707292159L & jFloatToRawIntBits) == 9205357640488583168L) {
                        renderNode.resetPivot();
                    } else {
                        renderNode.setPivotX(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)));
                        renderNode.setPivotY(Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)));
                    }
                }
            }
            x0.b bVar2 = this.f5262f;
            d2.c cVar = this.f5272p;
            d2.l lVar = this.f5273q;
            long j2 = this.f5267k;
            long j4 = bVar2.f11083u;
            x0.c cVar2 = bVar2.f11063a;
            if (!d2.k.a(j4, j2)) {
                bVar2.f11083u = j2;
                long j10 = bVar2.f11082t;
                int i2 = (int) (j10 >> 32);
                int i10 = (int) (j10 & 4294967295L);
                cVar2.f11089c.setPosition(i2, i10, ((int) (j2 >> 32)) + i2, ((int) (j2 & 4294967295L)) + i10);
                cVar2.f11090d = ib.k.W(j2);
                if (bVar2.f11071i == 9205357640488583168L) {
                    bVar2.f11069g = true;
                    bVar2.a();
                }
            }
            bVar2.f11064b = cVar;
            bVar2.f11065c = lVar;
            bVar2.f11066d = this.f5282z;
            r8.c cVar3 = bVar2.f11067e;
            w0.b bVar3 = cVar2.f11088b;
            RenderNode renderNode2 = cVar2.f11089c;
            RecordingCanvas recordingCanvasBeginRecording = renderNode2.beginRecording();
            try {
                o4.d0 d0Var = cVar2.f11087a;
                u0.a aVar = (u0.a) d0Var.f7326g;
                Canvas canvas = aVar.f9869a;
                aVar.f9869a = recordingCanvasBeginRecording;
                u5.h hVar = bVar3.f10630g;
                hVar.h(cVar);
                hVar.i(lVar);
                hVar.f10130b = bVar2;
                hVar.j(cVar2.f11090d);
                hVar.g(aVar);
                cVar3.invoke(bVar3);
                ((u0.a) d0Var.f7326g).f9869a = canvas;
                renderNode2.endRecording();
                if (this.f5271o) {
                    this.f5271o = false;
                    this.f5264h.r(this, false);
                }
            } catch (Throwable th) {
                renderNode2.endRecording();
                throw th;
            }
        }
    }

    @Override // i1.j1
    public final void invalidate() {
        if (this.f5271o || this.f5268l) {
            return;
        }
        y yVar = this.f5264h;
        yVar.invalidate();
        if (true != this.f5271o) {
            this.f5271o = true;
            yVar.r(this, true);
        }
    }
}
