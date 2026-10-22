package s;

import java.util.ArrayList;
import s.d;
import s.i;

/* renamed from: s.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1044b implements d.a {

    /* renamed from: e, reason: collision with root package name */
    public a f20146e;

    /* renamed from: a, reason: collision with root package name */
    i f20142a = null;

    /* renamed from: b, reason: collision with root package name */
    float f20143b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    boolean f20144c = false;

    /* renamed from: d, reason: collision with root package name */
    ArrayList<i> f20145d = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    boolean f20147f = false;

    /* renamed from: s.b$a */
    public interface a {
        void a(i iVar, float f5);

        int b();

        float c(C1044b c1044b, boolean z5);

        void clear();

        float d(i iVar, boolean z5);

        i e(int i5);

        float f(i iVar);

        void g();

        float h(int i5);

        boolean i(i iVar);

        void j(float f5);

        void k(i iVar, float f5, boolean z5);
    }

    public C1044b() {
    }

    private boolean u(i iVar, d dVar) {
        return iVar.f20203m <= 1;
    }

    private i w(boolean[] zArr, i iVar) {
        i.a aVar;
        int iB = this.f20146e.b();
        i iVar2 = null;
        float f5 = 0.0f;
        for (int i5 = 0; i5 < iB; i5++) {
            float fH = this.f20146e.h(i5);
            if (fH < 0.0f) {
                i iVarE = this.f20146e.e(i5);
                if ((zArr == null || !zArr[iVarE.f20193c]) && iVarE != iVar && (((aVar = iVarE.f20200j) == i.a.SLACK || aVar == i.a.ERROR) && fH < f5)) {
                    f5 = fH;
                    iVar2 = iVarE;
                }
            }
        }
        return iVar2;
    }

    public void A(d dVar, i iVar, boolean z5) {
        if (iVar == null || !iVar.f20197g) {
            return;
        }
        this.f20143b += iVar.f20196f * this.f20146e.f(iVar);
        this.f20146e.d(iVar, z5);
        if (z5) {
            iVar.g(this);
        }
        if (d.f20154t && this.f20146e.b() == 0) {
            this.f20147f = true;
            dVar.f20160a = true;
        }
    }

    public void B(d dVar, C1044b c1044b, boolean z5) {
        this.f20143b += c1044b.f20143b * this.f20146e.c(c1044b, z5);
        if (z5) {
            c1044b.f20142a.g(this);
        }
        if (d.f20154t && this.f20142a != null && this.f20146e.b() == 0) {
            this.f20147f = true;
            dVar.f20160a = true;
        }
    }

    public void C(d dVar, i iVar, boolean z5) {
        if (iVar == null || !iVar.f20204n) {
            return;
        }
        float f5 = this.f20146e.f(iVar);
        this.f20143b += iVar.f20206p * f5;
        this.f20146e.d(iVar, z5);
        if (z5) {
            iVar.g(this);
        }
        this.f20146e.k(dVar.f20173n.f20151d[iVar.f20205o], f5, z5);
        if (d.f20154t && this.f20146e.b() == 0) {
            this.f20147f = true;
            dVar.f20160a = true;
        }
    }

    public void D(d dVar) {
        if (dVar.f20166g.length == 0) {
            return;
        }
        boolean z5 = false;
        while (!z5) {
            int iB = this.f20146e.b();
            for (int i5 = 0; i5 < iB; i5++) {
                i iVarE = this.f20146e.e(i5);
                if (iVarE.f20194d != -1 || iVarE.f20197g || iVarE.f20204n) {
                    this.f20145d.add(iVarE);
                }
            }
            int size = this.f20145d.size();
            if (size > 0) {
                for (int i6 = 0; i6 < size; i6++) {
                    i iVar = this.f20145d.get(i6);
                    if (iVar.f20197g) {
                        A(dVar, iVar, true);
                    } else if (iVar.f20204n) {
                        C(dVar, iVar, true);
                    } else {
                        B(dVar, dVar.f20166g[iVar.f20194d], true);
                    }
                }
                this.f20145d.clear();
            } else {
                z5 = true;
            }
        }
        if (d.f20154t && this.f20142a != null && this.f20146e.b() == 0) {
            this.f20147f = true;
            dVar.f20160a = true;
        }
    }

    @Override // s.d.a
    public void a(i iVar) {
        int i5 = iVar.f20195e;
        float f5 = 1.0f;
        if (i5 != 1) {
            if (i5 == 2) {
                f5 = 1000.0f;
            } else if (i5 == 3) {
                f5 = 1000000.0f;
            } else if (i5 == 4) {
                f5 = 1.0E9f;
            } else if (i5 == 5) {
                f5 = 1.0E12f;
            }
        }
        this.f20146e.a(iVar, f5);
    }

    @Override // s.d.a
    public i b(d dVar, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // s.d.a
    public void c(d.a aVar) {
        if (aVar instanceof C1044b) {
            C1044b c1044b = (C1044b) aVar;
            this.f20142a = null;
            this.f20146e.clear();
            for (int i5 = 0; i5 < c1044b.f20146e.b(); i5++) {
                this.f20146e.k(c1044b.f20146e.e(i5), c1044b.f20146e.h(i5), true);
            }
        }
    }

    @Override // s.d.a
    public void clear() {
        this.f20146e.clear();
        this.f20142a = null;
        this.f20143b = 0.0f;
    }

    public C1044b d(d dVar, int i5) {
        this.f20146e.a(dVar.o(i5, "ep"), 1.0f);
        this.f20146e.a(dVar.o(i5, "em"), -1.0f);
        return this;
    }

    C1044b e(i iVar, int i5) {
        this.f20146e.a(iVar, i5);
        return this;
    }

    boolean f(d dVar) {
        boolean z5;
        i iVarG = g(dVar);
        if (iVarG == null) {
            z5 = true;
        } else {
            x(iVarG);
            z5 = false;
        }
        if (this.f20146e.b() == 0) {
            this.f20147f = true;
        }
        return z5;
    }

    i g(d dVar) {
        int iB = this.f20146e.b();
        i iVar = null;
        float f5 = 0.0f;
        float f6 = 0.0f;
        boolean z5 = false;
        boolean z6 = false;
        i iVar2 = null;
        for (int i5 = 0; i5 < iB; i5++) {
            float fH = this.f20146e.h(i5);
            i iVarE = this.f20146e.e(i5);
            if (iVarE.f20200j == i.a.UNRESTRICTED) {
                if (iVar == null || f5 > fH) {
                    boolean zU = u(iVarE, dVar);
                    z5 = zU;
                    f5 = fH;
                    iVar = iVarE;
                } else if (!z5 && u(iVarE, dVar)) {
                    f5 = fH;
                    iVar = iVarE;
                    z5 = true;
                }
            } else if (iVar == null && fH < 0.0f) {
                if (iVar2 == null || f6 > fH) {
                    boolean zU2 = u(iVarE, dVar);
                    z6 = zU2;
                    f6 = fH;
                    iVar2 = iVarE;
                } else if (!z6 && u(iVarE, dVar)) {
                    f6 = fH;
                    iVar2 = iVarE;
                    z6 = true;
                }
            }
        }
        return iVar != null ? iVar : iVar2;
    }

    @Override // s.d.a
    public i getKey() {
        return this.f20142a;
    }

    C1044b h(i iVar, i iVar2, int i5, float f5, i iVar3, i iVar4, int i6) {
        if (iVar2 == iVar3) {
            this.f20146e.a(iVar, 1.0f);
            this.f20146e.a(iVar4, 1.0f);
            this.f20146e.a(iVar2, -2.0f);
            return this;
        }
        if (f5 == 0.5f) {
            this.f20146e.a(iVar, 1.0f);
            this.f20146e.a(iVar2, -1.0f);
            this.f20146e.a(iVar3, -1.0f);
            this.f20146e.a(iVar4, 1.0f);
            if (i5 > 0 || i6 > 0) {
                this.f20143b = (-i5) + i6;
                return this;
            }
        } else {
            if (f5 <= 0.0f) {
                this.f20146e.a(iVar, -1.0f);
                this.f20146e.a(iVar2, 1.0f);
                this.f20143b = i5;
                return this;
            }
            if (f5 >= 1.0f) {
                this.f20146e.a(iVar4, -1.0f);
                this.f20146e.a(iVar3, 1.0f);
                this.f20143b = -i6;
                return this;
            }
            float f6 = 1.0f - f5;
            this.f20146e.a(iVar, f6 * 1.0f);
            this.f20146e.a(iVar2, f6 * (-1.0f));
            this.f20146e.a(iVar3, (-1.0f) * f5);
            this.f20146e.a(iVar4, 1.0f * f5);
            if (i5 > 0 || i6 > 0) {
                this.f20143b = ((-i5) * f6) + (i6 * f5);
                return this;
            }
        }
        return this;
    }

    C1044b i(i iVar, int i5) {
        this.f20142a = iVar;
        float f5 = i5;
        iVar.f20196f = f5;
        this.f20143b = f5;
        this.f20147f = true;
        return this;
    }

    @Override // s.d.a
    public boolean isEmpty() {
        return this.f20142a == null && this.f20143b == 0.0f && this.f20146e.b() == 0;
    }

    C1044b j(i iVar, i iVar2, float f5) {
        this.f20146e.a(iVar, -1.0f);
        this.f20146e.a(iVar2, f5);
        return this;
    }

    public C1044b k(i iVar, i iVar2, i iVar3, i iVar4, float f5) {
        this.f20146e.a(iVar, -1.0f);
        this.f20146e.a(iVar2, 1.0f);
        this.f20146e.a(iVar3, f5);
        this.f20146e.a(iVar4, -f5);
        return this;
    }

    public C1044b l(float f5, float f6, float f7, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f20143b = 0.0f;
        if (f6 == 0.0f || f5 == f7) {
            this.f20146e.a(iVar, 1.0f);
            this.f20146e.a(iVar2, -1.0f);
            this.f20146e.a(iVar4, 1.0f);
            this.f20146e.a(iVar3, -1.0f);
            return this;
        }
        if (f5 == 0.0f) {
            this.f20146e.a(iVar, 1.0f);
            this.f20146e.a(iVar2, -1.0f);
            return this;
        }
        if (f7 == 0.0f) {
            this.f20146e.a(iVar3, 1.0f);
            this.f20146e.a(iVar4, -1.0f);
            return this;
        }
        float f8 = (f5 / f6) / (f7 / f6);
        this.f20146e.a(iVar, 1.0f);
        this.f20146e.a(iVar2, -1.0f);
        this.f20146e.a(iVar4, f8);
        this.f20146e.a(iVar3, -f8);
        return this;
    }

    public C1044b m(i iVar, int i5) {
        if (i5 < 0) {
            this.f20143b = i5 * (-1);
            this.f20146e.a(iVar, 1.0f);
            return this;
        }
        this.f20143b = i5;
        this.f20146e.a(iVar, -1.0f);
        return this;
    }

    public C1044b n(i iVar, i iVar2, int i5) {
        boolean z5 = false;
        if (i5 != 0) {
            if (i5 < 0) {
                i5 *= -1;
                z5 = true;
            }
            this.f20143b = i5;
        }
        if (z5) {
            this.f20146e.a(iVar, 1.0f);
            this.f20146e.a(iVar2, -1.0f);
            return this;
        }
        this.f20146e.a(iVar, -1.0f);
        this.f20146e.a(iVar2, 1.0f);
        return this;
    }

    public C1044b o(i iVar, i iVar2, i iVar3, int i5) {
        boolean z5 = false;
        if (i5 != 0) {
            if (i5 < 0) {
                i5 *= -1;
                z5 = true;
            }
            this.f20143b = i5;
        }
        if (z5) {
            this.f20146e.a(iVar, 1.0f);
            this.f20146e.a(iVar2, -1.0f);
            this.f20146e.a(iVar3, -1.0f);
            return this;
        }
        this.f20146e.a(iVar, -1.0f);
        this.f20146e.a(iVar2, 1.0f);
        this.f20146e.a(iVar3, 1.0f);
        return this;
    }

    public C1044b p(i iVar, i iVar2, i iVar3, int i5) {
        boolean z5 = false;
        if (i5 != 0) {
            if (i5 < 0) {
                i5 *= -1;
                z5 = true;
            }
            this.f20143b = i5;
        }
        if (z5) {
            this.f20146e.a(iVar, 1.0f);
            this.f20146e.a(iVar2, -1.0f);
            this.f20146e.a(iVar3, 1.0f);
            return this;
        }
        this.f20146e.a(iVar, -1.0f);
        this.f20146e.a(iVar2, 1.0f);
        this.f20146e.a(iVar3, -1.0f);
        return this;
    }

    public C1044b q(i iVar, i iVar2, i iVar3, i iVar4, float f5) {
        this.f20146e.a(iVar3, 0.5f);
        this.f20146e.a(iVar4, 0.5f);
        this.f20146e.a(iVar, -0.5f);
        this.f20146e.a(iVar2, -0.5f);
        this.f20143b = -f5;
        return this;
    }

    void r() {
        float f5 = this.f20143b;
        if (f5 < 0.0f) {
            this.f20143b = f5 * (-1.0f);
            this.f20146e.g();
        }
    }

    boolean s() {
        i iVar = this.f20142a;
        if (iVar != null) {
            return iVar.f20200j == i.a.UNRESTRICTED || this.f20143b >= 0.0f;
        }
        return false;
    }

    boolean t(i iVar) {
        return this.f20146e.i(iVar);
    }

    public String toString() {
        return z();
    }

    public i v(i iVar) {
        return w(null, iVar);
    }

    void x(i iVar) {
        i iVar2 = this.f20142a;
        if (iVar2 != null) {
            this.f20146e.a(iVar2, -1.0f);
            this.f20142a.f20194d = -1;
            this.f20142a = null;
        }
        float fD = this.f20146e.d(iVar, true) * (-1.0f);
        this.f20142a = iVar;
        if (fD == 1.0f) {
            return;
        }
        this.f20143b /= fD;
        this.f20146e.j(fD);
    }

    public void y() {
        this.f20142a = null;
        this.f20146e.clear();
        this.f20143b = 0.0f;
        this.f20147f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    java.lang.String z() {
        /*
            Method dump skipped, instructions count: 257
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s.C1044b.z():java.lang.String");
    }

    public C1044b(C1045c c1045c) {
        this.f20146e = new C1043a(this, c1045c);
    }
}
