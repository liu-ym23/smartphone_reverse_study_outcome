package i1;

import d1.l0;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends c0 {

    /* renamed from: b, reason: collision with root package name */
    public float[] f5607b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f5608c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public boolean f5609d = true;

    /* renamed from: e, reason: collision with root package name */
    public long f5610e = d1.p.f3024g;

    /* renamed from: f, reason: collision with root package name */
    public List f5611f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5612g;

    /* renamed from: h, reason: collision with root package name */
    public d1.h f5613h;
    public xb.l i;

    /* renamed from: j, reason: collision with root package name */
    public final a2.m f5614j;

    /* renamed from: k, reason: collision with root package name */
    public String f5615k;

    /* renamed from: l, reason: collision with root package name */
    public float f5616l;

    /* renamed from: m, reason: collision with root package name */
    public float f5617m;

    /* renamed from: n, reason: collision with root package name */
    public float f5618n;

    /* renamed from: o, reason: collision with root package name */
    public float f5619o;

    /* renamed from: p, reason: collision with root package name */
    public float f5620p;

    /* renamed from: q, reason: collision with root package name */
    public float f5621q;

    /* renamed from: r, reason: collision with root package name */
    public float f5622r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f5623s;

    public c() {
        int i = h0.f5700a;
        this.f5611f = kb.s.f7404c;
        this.f5612g = true;
        this.f5614j = new a2.m(this, 4);
        this.f5615k = "";
        this.f5619o = 1.0f;
        this.f5620p = 1.0f;
        this.f5623s = true;
    }

    @Override // i1.c0
    public final void a(f1.d dVar) {
        if (this.f5623s) {
            float[] fArrI = this.f5607b;
            if (fArrI == null) {
                fArrI = d1.f0.i();
                this.f5607b = fArrI;
            } else {
                d1.f0.n(fArrI);
            }
            d1.f0.v(fArrI, this.f5621q + this.f5617m, this.f5622r + this.f5618n);
            float f5 = this.f5616l;
            if (fArrI.length >= 16) {
                double d7 = f5 * 0.017453292519943295d;
                float fSin = (float) Math.sin(d7);
                float fCos = (float) Math.cos(d7);
                float f10 = fArrI[0];
                float f11 = fArrI[4];
                float f12 = (fSin * f11) + (fCos * f10);
                float f13 = -fSin;
                float f14 = (f11 * fCos) + (f10 * f13);
                float f15 = fArrI[1];
                float f16 = fArrI[5];
                float f17 = (fSin * f16) + (fCos * f15);
                float f18 = (f16 * fCos) + (f15 * f13);
                float f19 = fArrI[2];
                float f20 = fArrI[6];
                float f21 = (fSin * f20) + (fCos * f19);
                float f22 = (f20 * fCos) + (f19 * f13);
                float f23 = fArrI[3];
                float f24 = fArrI[7];
                fArrI[0] = f12;
                fArrI[1] = f17;
                fArrI[2] = f21;
                fArrI[3] = (fSin * f24) + (fCos * f23);
                fArrI[4] = f14;
                fArrI[5] = f18;
                fArrI[6] = f22;
                fArrI[7] = (fCos * f24) + (f13 * f23);
            }
            float f25 = this.f5619o;
            float f26 = this.f5620p;
            if (fArrI.length >= 16) {
                fArrI[0] = fArrI[0] * f25;
                fArrI[1] = fArrI[1] * f25;
                fArrI[2] = fArrI[2] * f25;
                fArrI[3] = fArrI[3] * f25;
                fArrI[4] = fArrI[4] * f26;
                fArrI[5] = fArrI[5] * f26;
                fArrI[6] = fArrI[6] * f26;
                fArrI[7] = fArrI[7] * f26;
                fArrI[8] = fArrI[8] * 1.0f;
                fArrI[9] = fArrI[9] * 1.0f;
                fArrI[10] = fArrI[10] * 1.0f;
                fArrI[11] = fArrI[11] * 1.0f;
            }
            d1.f0.v(fArrI, -this.f5617m, -this.f5618n);
            this.f5623s = false;
        }
        if (this.f5612g) {
            if (!this.f5611f.isEmpty()) {
                d1.h hVarA = this.f5613h;
                if (hVarA == null) {
                    hVarA = d1.k.a();
                    this.f5613h = hVarA;
                }
                b.d(this.f5611f, hVarA);
            }
            this.f5612g = false;
        }
        p5.m mVarA0 = dVar.a0();
        long jD = mVarA0.D();
        mVarA0.y().i();
        try {
            a1.g gVar = (a1.g) mVarA0.f9741f;
            float[] fArr = this.f5607b;
            if (fArr != null) {
                ((p5.m) gVar.f19f).y().k(fArr);
            }
            d1.h hVar = this.f5613h;
            if (!this.f5611f.isEmpty() && hVar != null) {
                ((p5.m) gVar.f19f).y().a(hVar);
            }
            ArrayList arrayList = this.f5608c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((c0) arrayList.get(i)).a(dVar);
            }
        } finally {
            mVarA0.y().o();
            mVarA0.R(jD);
        }
    }

    @Override // i1.c0
    public final xb.l b() {
        return this.i;
    }

    @Override // i1.c0
    public final void d(a2.m mVar) {
        this.i = mVar;
    }

    public final void e(int i, c0 c0Var) {
        ArrayList arrayList = this.f5608c;
        if (i < arrayList.size()) {
            arrayList.set(i, c0Var);
        } else {
            arrayList.add(c0Var);
        }
        g(c0Var);
        c0Var.d(this.f5614j);
        c();
    }

    public final void f(long j10) {
        if (this.f5609d && j10 != 16) {
            long j11 = this.f5610e;
            if (j11 == 16) {
                this.f5610e = j10;
                return;
            }
            int i = h0.f5700a;
            if (d1.p.i(j11) == d1.p.i(j10) && d1.p.h(j11) == d1.p.h(j10) && d1.p.f(j11) == d1.p.f(j10)) {
                return;
            }
            this.f5609d = false;
            this.f5610e = d1.p.f3024g;
        }
    }

    public final void g(c0 c0Var) {
        if (!(c0Var instanceof h)) {
            if (c0Var instanceof c) {
                c cVar = (c) c0Var;
                if (cVar.f5609d && this.f5609d) {
                    f(cVar.f5610e);
                    return;
                } else {
                    this.f5609d = false;
                    this.f5610e = d1.p.f3024g;
                    return;
                }
            }
            return;
        }
        h hVar = (h) c0Var;
        d1.f0 f0Var = hVar.f5682b;
        if (this.f5609d && f0Var != null) {
            if (f0Var instanceof l0) {
                f(((l0) f0Var).f3013b);
            } else {
                this.f5609d = false;
                this.f5610e = d1.p.f3024g;
            }
        }
        d1.f0 f0Var2 = hVar.f5687g;
        if (this.f5609d && f0Var2 != null) {
            if (f0Var2 instanceof l0) {
                f(((l0) f0Var2).f3013b);
            } else {
                this.f5609d = false;
                this.f5610e = d1.p.f3024g;
            }
        }
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("VGroup: ");
        sb2.append(this.f5615k);
        ArrayList arrayList = this.f5608c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            c0 c0Var = (c0) arrayList.get(i);
            sb2.append("\t");
            sb2.append(c0Var.toString());
            sb2.append("\n");
        }
        return sb2.toString();
    }
}
