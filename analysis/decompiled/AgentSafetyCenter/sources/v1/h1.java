package v1;

import android.view.ViewParent;
import com.google.crypto.tink.shaded.protobuf.Reader;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h1 implements u1.m1 {

    /* renamed from: c, reason: collision with root package name */
    public g1.b f14453c;

    /* renamed from: f, reason: collision with root package name */
    public final d1.u f14454f;

    /* renamed from: g, reason: collision with root package name */
    public final t f14455g;

    /* renamed from: h, reason: collision with root package name */
    public xb.p f14456h;
    public xb.a i;

    /* renamed from: j, reason: collision with root package name */
    public long f14457j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f14458k;

    /* renamed from: l, reason: collision with root package name */
    public final float[] f14459l;

    /* renamed from: m, reason: collision with root package name */
    public float[] f14460m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f14461n;

    /* renamed from: o, reason: collision with root package name */
    public o2.c f14462o;

    /* renamed from: p, reason: collision with root package name */
    public o2.l f14463p;

    /* renamed from: q, reason: collision with root package name */
    public final f1.b f14464q;

    /* renamed from: r, reason: collision with root package name */
    public int f14465r;

    /* renamed from: s, reason: collision with root package name */
    public long f14466s;

    /* renamed from: t, reason: collision with root package name */
    public d1.c0 f14467t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f14468u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f14469v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f14470w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f14471x;

    /* renamed from: y, reason: collision with root package name */
    public final a2.m f14472y;

    public h1(g1.b bVar, d1.u uVar, t tVar, xb.p pVar, xb.a aVar) {
        this.f14453c = bVar;
        this.f14454f = uVar;
        this.f14455g = tVar;
        this.f14456h = pVar;
        this.i = aVar;
        long j10 = Reader.READ_DONE;
        this.f14457j = (j10 & 4294967295L) | (j10 << 32);
        this.f14459l = d1.f0.i();
        this.f14462o = p5.f.b(1.0f, 1.0f);
        this.f14463p = o2.l.f9123c;
        this.f14464q = new f1.b();
        this.f14466s = d1.m0.f3015b;
        this.f14470w = true;
        this.f14472y = new a2.m(this, 26);
    }

    public final float[] a() {
        float[] fArrI = this.f14460m;
        if (fArrI == null) {
            fArrI = d1.f0.i();
            this.f14460m = fArrI;
        }
        if (this.f14469v) {
            this.f14469v = false;
            float[] fArrB = b();
            if (this.f14470w) {
                return fArrB;
            }
            if (!g0.s(fArrB, fArrI)) {
                fArrI[0] = Float.NaN;
                return null;
            }
        } else if (Float.isNaN(fArrI[0])) {
            return null;
        }
        return fArrI;
    }

    public final float[] b() {
        boolean z10 = this.f14468u;
        float[] fArr = this.f14459l;
        if (z10) {
            g1.b bVar = this.f14453c;
            long jA = bVar.f4221v;
            if ((9223372034707292159L & jA) == 9205357640488583168L) {
                jA = a.a.A(ac.a.i0(this.f14457j));
            }
            float fIntBitsToFloat = Float.intBitsToFloat((int) (jA >> 32));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jA & 4294967295L));
            g1.c cVar = bVar.f4201a;
            float f5 = cVar.f4232j;
            float f10 = cVar.f4233k;
            double d7 = 0.0f * 0.017453292519943295d;
            float fSin = (float) Math.sin(d7);
            float fCos = (float) Math.cos(d7);
            float f11 = -fSin;
            float f12 = (0.0f * fCos) - (1.0f * fSin);
            float f13 = (1.0f * fCos) + (0.0f * fSin);
            float fSin2 = (float) Math.sin(d7);
            float fCos2 = (float) Math.cos(d7);
            float f14 = -fSin2;
            float f15 = fSin * fSin2;
            float f16 = fSin * fCos2;
            float f17 = fCos * fSin2;
            float f18 = fCos * fCos2;
            float f19 = (f13 * fSin2) + (0.0f * fCos2);
            float f20 = (f13 * fCos2) + ((-0.0f) * fSin2);
            float fSin3 = (float) Math.sin(d7);
            float fCos3 = (float) Math.cos(d7);
            float f21 = -fSin3;
            float f22 = (fCos3 * f15) + (f21 * fCos2);
            float f23 = ((f15 * fSin3) + (fCos2 * fCos3)) * f5;
            float f24 = fSin3 * fCos * f5;
            float f25 = ((fSin3 * f16) + (fCos3 * f14)) * f5;
            float f26 = f22 * f10;
            float f27 = fCos * fCos3 * f10;
            float f28 = ((fCos3 * f16) + (f21 * f14)) * f10;
            float f29 = f17 * 1.0f;
            float f30 = f11 * 1.0f;
            float f31 = f18 * 1.0f;
            if (fArr.length >= 16) {
                fArr[0] = f23;
                fArr[1] = f24;
                fArr[2] = f25;
                fArr[3] = 0.0f;
                fArr[4] = f26;
                fArr[5] = f27;
                fArr[6] = f28;
                fArr[7] = 0.0f;
                fArr[8] = f29;
                fArr[9] = f30;
                fArr[10] = f31;
                fArr[11] = 0.0f;
                float f32 = -fIntBitsToFloat;
                fArr[12] = ((f23 * f32) - (f26 * fIntBitsToFloat2)) + f19 + fIntBitsToFloat;
                fArr[13] = ((f24 * f32) - (f27 * fIntBitsToFloat2)) + f12 + fIntBitsToFloat2;
                fArr[14] = ((f32 * f25) - (fIntBitsToFloat2 * f28)) + f20;
                fArr[15] = 1.0f;
            }
            this.f14468u = false;
            this.f14470w = d1.f0.j(fArr);
        }
        return fArr;
    }

    public final void c() {
        if (this.f14461n || this.f14458k) {
            return;
        }
        this.f14455g.invalidate();
        f(true);
    }

    public final void d(long j10) {
        t tVar = this.f14455g;
        if (tVar.f14545j) {
            tVar.I(-4.0f);
        }
        g1.b bVar = this.f14453c;
        if (!o2.i.b(bVar.f4219t, j10)) {
            bVar.f4219t = j10;
            bVar.h(j10, bVar.f4220u);
        }
        ViewParent parent = tVar.getParent();
        if (parent != null) {
            parent.onDescendantInvalidated(tVar, tVar);
        }
    }

    public final void e(long j10) {
        if (o2.k.b(j10, this.f14457j)) {
            return;
        }
        t tVar = this.f14455g;
        if (tVar.f14545j) {
            tVar.I(-4.0f);
        }
        this.f14457j = j10;
        c();
    }

    public final void f(boolean z10) {
        if (z10 != this.f14461n) {
            this.f14461n = z10;
            t tVar = this.f14455g;
            ArrayList arrayList = tVar.B;
            boolean z11 = tVar.D;
            if (!z10) {
                if (z11) {
                    return;
                }
                arrayList.remove(this);
                ArrayList arrayList2 = tVar.C;
                if (arrayList2 != null) {
                    arrayList2.remove(this);
                    return;
                }
                return;
            }
            if (!z11) {
                arrayList.add(this);
                return;
            }
            ArrayList arrayList3 = tVar.C;
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                tVar.C = arrayList3;
            }
            arrayList3.add(this);
        }
    }

    public final void g() {
        if (this.f14461n) {
            if (!d1.m0.b(this.f14466s, d1.m0.f3015b) && !o2.k.b(this.f14453c.f4220u, this.f14457j)) {
                g1.b bVar = this.f14453c;
                float fIntBitsToFloat = Float.intBitsToFloat((int) (this.f14466s >> 32)) * ((int) (this.f14457j >> 32));
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (this.f14466s & 4294967295L)) * ((int) (this.f14457j & 4294967295L));
                bVar.g((Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
            }
            g1.b bVar2 = this.f14453c;
            o2.c cVar = this.f14462o;
            o2.l lVar = this.f14463p;
            long j10 = this.f14457j;
            if (!o2.k.b(bVar2.f4220u, j10)) {
                bVar2.f4220u = j10;
                bVar2.h(bVar2.f4219t, j10);
                if (bVar2.i == 9205357640488583168L) {
                    bVar2.f4207g = true;
                    bVar2.a();
                }
            }
            bVar2.f4202b = cVar;
            bVar2.f4203c = lVar;
            bVar2.f4204d = this.f14472y;
            bVar2.f();
            f(false);
        }
    }
}
