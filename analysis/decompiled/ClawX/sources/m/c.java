package m;

import androidx.emoji2.text.p;
import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: p, reason: collision with root package name */
    public static boolean f3855p = false;

    /* renamed from: q, reason: collision with root package name */
    public static int f3856q = 1000;

    /* renamed from: c, reason: collision with root package name */
    public final e f3859c;

    /* renamed from: f, reason: collision with root package name */
    public b[] f3861f;

    /* renamed from: l, reason: collision with root package name */
    public final a4.d f3867l;

    /* renamed from: o, reason: collision with root package name */
    public b f3870o;

    /* renamed from: a, reason: collision with root package name */
    public boolean f3857a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f3858b = 0;
    public int d = 32;

    /* renamed from: e, reason: collision with root package name */
    public int f3860e = 32;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3862g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean[] f3863h = new boolean[32];

    /* renamed from: i, reason: collision with root package name */
    public int f3864i = 1;

    /* renamed from: j, reason: collision with root package name */
    public int f3865j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f3866k = 32;

    /* renamed from: m, reason: collision with root package name */
    public g[] f3868m = new g[f3856q];

    /* renamed from: n, reason: collision with root package name */
    public int f3869n = 0;

    public c() {
        this.f3861f = null;
        this.f3861f = new b[32];
        s();
        a4.d dVar = new a4.d(8);
        dVar.f96b = new d0.b();
        dVar.f97c = new d0.b();
        dVar.d = new g[32];
        this.f3867l = dVar;
        e eVar = new e(dVar);
        eVar.f3872f = new g[128];
        eVar.f3873g = new g[128];
        eVar.f3874h = 0;
        eVar.f3875i = new p(9, eVar);
        this.f3859c = eVar;
        this.f3870o = new b(dVar);
    }

    public static int n(Object obj) {
        g gVar = ((o.c) obj).f4211i;
        if (gVar != null) {
            return (int) (gVar.f3880e + 0.5f);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v0 */
    public final g a(int i8) {
        d0.b bVar = (d0.b) this.f3867l.f97c;
        int i9 = bVar.f1758b;
        g gVar = null;
        if (i9 > 0) {
            int i10 = i9 - 1;
            ?? r3 = bVar.f1757a;
            ?? r42 = r3[i10];
            r3[i10] = 0;
            bVar.f1758b = i10;
            gVar = r42;
        }
        g gVar2 = gVar;
        if (gVar2 == null) {
            gVar2 = new g(i8);
            gVar2.f3887m = i8;
        } else {
            gVar2.c();
            gVar2.f3887m = i8;
        }
        int i11 = this.f3869n;
        int i12 = f3856q;
        if (i11 >= i12) {
            int i13 = i12 * 2;
            f3856q = i13;
            this.f3868m = (g[]) Arrays.copyOf(this.f3868m, i13);
        }
        g[] gVarArr = this.f3868m;
        int i14 = this.f3869n;
        this.f3869n = i14 + 1;
        gVarArr[i14] = gVar2;
        return gVar2;
    }

    public final void b(g gVar, g gVar2, int i8, float f3, g gVar3, g gVar4, int i9, int i10) {
        b bVarL = l();
        if (gVar2 == gVar3) {
            bVarL.d.g(gVar, 1.0f);
            bVarL.d.g(gVar4, 1.0f);
            bVarL.d.g(gVar2, -2.0f);
        } else if (f3 == 0.5f) {
            bVarL.d.g(gVar, 1.0f);
            bVarL.d.g(gVar2, -1.0f);
            bVarL.d.g(gVar3, -1.0f);
            bVarL.d.g(gVar4, 1.0f);
            if (i8 > 0 || i9 > 0) {
                bVarL.f3852b = (-i8) + i9;
            }
        } else if (f3 <= 0.0f) {
            bVarL.d.g(gVar, -1.0f);
            bVarL.d.g(gVar2, 1.0f);
            bVarL.f3852b = i8;
        } else if (f3 >= 1.0f) {
            bVarL.d.g(gVar4, -1.0f);
            bVarL.d.g(gVar3, 1.0f);
            bVarL.f3852b = -i9;
        } else {
            float f7 = 1.0f - f3;
            bVarL.d.g(gVar, f7 * 1.0f);
            bVarL.d.g(gVar2, f7 * (-1.0f));
            bVarL.d.g(gVar3, (-1.0f) * f3);
            bVarL.d.g(gVar4, 1.0f * f3);
            if (i8 > 0 || i9 > 0) {
                bVarL.f3852b = (i9 * f3) + ((-i8) * f7);
            }
        }
        if (i10 != 8) {
            bVarL.a(this, i10);
        }
        c(bVarL);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(m.b r18) {
        /*
            Method dump skipped, instructions count: 453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.c.c(m.b):void");
    }

    public final void d(g gVar, int i8) {
        int i9 = gVar.f3879c;
        if (i9 == -1) {
            gVar.d(this, i8);
            for (int i10 = 0; i10 < this.f3858b + 1; i10++) {
                g gVar2 = ((g[]) this.f3867l.d)[i10];
            }
            return;
        }
        if (i9 == -1) {
            b bVarL = l();
            bVarL.f3851a = gVar;
            float f3 = i8;
            gVar.f3880e = f3;
            bVarL.f3852b = f3;
            bVarL.f3854e = true;
            c(bVarL);
            return;
        }
        b bVar = this.f3861f[i9];
        if (bVar.f3854e) {
            bVar.f3852b = i8;
            return;
        }
        if (bVar.d.d() == 0) {
            bVar.f3854e = true;
            bVar.f3852b = i8;
            return;
        }
        b bVarL2 = l();
        if (i8 < 0) {
            bVarL2.f3852b = i8 * (-1);
            bVarL2.d.g(gVar, 1.0f);
        } else {
            bVarL2.f3852b = i8;
            bVarL2.d.g(gVar, -1.0f);
        }
        c(bVarL2);
    }

    public final void e(g gVar, g gVar2, int i8, int i9) {
        if (i9 == 8 && gVar2.f3881f && gVar.f3879c == -1) {
            gVar.d(this, gVar2.f3880e + i8);
            return;
        }
        b bVarL = l();
        boolean z = false;
        if (i8 != 0) {
            if (i8 < 0) {
                i8 *= -1;
                z = true;
            }
            bVarL.f3852b = i8;
        }
        if (z) {
            bVarL.d.g(gVar, 1.0f);
            bVarL.d.g(gVar2, -1.0f);
        } else {
            bVarL.d.g(gVar, -1.0f);
            bVarL.d.g(gVar2, 1.0f);
        }
        if (i9 != 8) {
            bVarL.a(this, i9);
        }
        c(bVarL);
    }

    public final void f(g gVar, g gVar2, int i8, int i9) {
        b bVarL = l();
        g gVarM = m();
        gVarM.d = 0;
        bVarL.b(gVar, gVar2, gVarM, i8);
        if (i9 != 8) {
            bVarL.d.g(j(i9), (int) (bVarL.d.c(gVarM) * (-1.0f)));
        }
        c(bVarL);
    }

    public final void g(g gVar, g gVar2, int i8, int i9) {
        b bVarL = l();
        g gVarM = m();
        gVarM.d = 0;
        bVarL.c(gVar, gVar2, gVarM, i8);
        if (i9 != 8) {
            bVarL.d.g(j(i9), (int) (bVarL.d.c(gVarM) * (-1.0f)));
        }
        c(bVarL);
    }

    public final void h(b bVar) {
        int i8;
        if (bVar.f3854e) {
            bVar.f3851a.d(this, bVar.f3852b);
        } else {
            b[] bVarArr = this.f3861f;
            int i9 = this.f3865j;
            bVarArr[i9] = bVar;
            g gVar = bVar.f3851a;
            gVar.f3879c = i9;
            this.f3865j = i9 + 1;
            gVar.e(this, bVar);
        }
        if (this.f3857a) {
            int i10 = 0;
            while (i10 < this.f3865j) {
                if (this.f3861f[i10] == null) {
                    System.out.println("WTF");
                }
                b bVar2 = this.f3861f[i10];
                if (bVar2 != null && bVar2.f3854e) {
                    bVar2.f3851a.d(this, bVar2.f3852b);
                    ((d0.b) this.f3867l.f96b).b(bVar2);
                    this.f3861f[i10] = null;
                    int i11 = i10 + 1;
                    int i12 = i11;
                    while (true) {
                        i8 = this.f3865j;
                        if (i11 >= i8) {
                            break;
                        }
                        b[] bVarArr2 = this.f3861f;
                        int i13 = i11 - 1;
                        b bVar3 = bVarArr2[i11];
                        bVarArr2[i13] = bVar3;
                        g gVar2 = bVar3.f3851a;
                        if (gVar2.f3879c == i11) {
                            gVar2.f3879c = i13;
                        }
                        i12 = i11;
                        i11++;
                    }
                    if (i12 < i8) {
                        this.f3861f[i12] = null;
                    }
                    this.f3865j = i8 - 1;
                    i10--;
                }
                i10++;
            }
            this.f3857a = false;
        }
    }

    public final void i() {
        for (int i8 = 0; i8 < this.f3865j; i8++) {
            b bVar = this.f3861f[i8];
            bVar.f3851a.f3880e = bVar.f3852b;
        }
    }

    public final g j(int i8) {
        if (this.f3864i + 1 >= this.f3860e) {
            o();
        }
        g gVarA = a(4);
        float[] fArr = gVarA.f3883h;
        int i9 = this.f3858b + 1;
        this.f3858b = i9;
        this.f3864i++;
        gVarA.f3878b = i9;
        gVarA.d = i8;
        ((g[]) this.f3867l.d)[i9] = gVarA;
        e eVar = this.f3859c;
        eVar.f3875i.f623b = gVarA;
        Arrays.fill(fArr, 0.0f);
        fArr[gVarA.d] = 1.0f;
        eVar.j(gVarA);
        return gVarA;
    }

    public final g k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.f3864i + 1 >= this.f3860e) {
            o();
        }
        if (!(obj instanceof o.c)) {
            return null;
        }
        o.c cVar = (o.c) obj;
        g gVar = cVar.f4211i;
        if (gVar == null) {
            cVar.k();
            gVar = cVar.f4211i;
        }
        int i8 = gVar.f3878b;
        a4.d dVar = this.f3867l;
        if (i8 != -1 && i8 <= this.f3858b && ((g[]) dVar.d)[i8] != null) {
            return gVar;
        }
        if (i8 != -1) {
            gVar.c();
        }
        int i9 = this.f3858b + 1;
        this.f3858b = i9;
        this.f3864i++;
        gVar.f3878b = i9;
        gVar.f3887m = 1;
        ((g[]) dVar.d)[i9] = gVar;
        return gVar;
    }

    public final b l() {
        Object obj;
        a4.d dVar = this.f3867l;
        d0.b bVar = (d0.b) dVar.f96b;
        int i8 = bVar.f1758b;
        if (i8 > 0) {
            int i9 = i8 - 1;
            Object[] objArr = bVar.f1757a;
            obj = objArr[i9];
            objArr[i9] = null;
            bVar.f1758b = i9;
        } else {
            obj = null;
        }
        b bVar2 = (b) obj;
        if (bVar2 == null) {
            return new b(dVar);
        }
        bVar2.f3851a = null;
        bVar2.d.b();
        bVar2.f3852b = 0.0f;
        bVar2.f3854e = false;
        return bVar2;
    }

    public final g m() {
        if (this.f3864i + 1 >= this.f3860e) {
            o();
        }
        g gVarA = a(3);
        int i8 = this.f3858b + 1;
        this.f3858b = i8;
        this.f3864i++;
        gVarA.f3878b = i8;
        ((g[]) this.f3867l.d)[i8] = gVarA;
        return gVarA;
    }

    public final void o() {
        int i8 = this.d * 2;
        this.d = i8;
        this.f3861f = (b[]) Arrays.copyOf(this.f3861f, i8);
        a4.d dVar = this.f3867l;
        dVar.d = (g[]) Arrays.copyOf((g[]) dVar.d, this.d);
        int i9 = this.d;
        this.f3863h = new boolean[i9];
        this.f3860e = i9;
        this.f3866k = i9;
    }

    public final void p() {
        e eVar = this.f3859c;
        if (eVar.e()) {
            i();
            return;
        }
        if (!this.f3862g) {
            q(eVar);
            return;
        }
        for (int i8 = 0; i8 < this.f3865j; i8++) {
            if (!this.f3861f[i8].f3854e) {
                q(eVar);
                return;
            }
        }
        i();
    }

    public final void q(e eVar) {
        int i8 = 0;
        while (true) {
            if (i8 >= this.f3865j) {
                break;
            }
            b bVar = this.f3861f[i8];
            int i9 = 1;
            if (bVar.f3851a.f3887m != 1) {
                float f3 = 0.0f;
                if (bVar.f3852b < 0.0f) {
                    boolean z = false;
                    int i10 = 0;
                    while (!z) {
                        i10 += i9;
                        float f7 = Float.MAX_VALUE;
                        int i11 = -1;
                        int i12 = -1;
                        int i13 = 0;
                        int i14 = 0;
                        while (i13 < this.f3865j) {
                            b bVar2 = this.f3861f[i13];
                            if (bVar2.f3851a.f3887m != i9 && !bVar2.f3854e && bVar2.f3852b < f3) {
                                int iD = bVar2.d.d();
                                int i15 = 0;
                                while (i15 < iD) {
                                    g gVarE = bVar2.d.e(i15);
                                    float fC = bVar2.d.c(gVarE);
                                    if (fC > f3) {
                                        for (int i16 = 0; i16 < 9; i16++) {
                                            float f9 = gVarE.f3882g[i16] / fC;
                                            if ((f9 < f7 && i16 == i14) || i16 > i14) {
                                                i14 = i16;
                                                i12 = gVarE.f3878b;
                                                i11 = i13;
                                                f7 = f9;
                                            }
                                        }
                                    }
                                    i15++;
                                    f3 = 0.0f;
                                }
                            }
                            i13++;
                            f3 = 0.0f;
                            i9 = 1;
                        }
                        if (i11 != -1) {
                            b bVar3 = this.f3861f[i11];
                            bVar3.f3851a.f3879c = -1;
                            bVar3.g(((g[]) this.f3867l.d)[i12]);
                            g gVar = bVar3.f3851a;
                            gVar.f3879c = i11;
                            gVar.e(this, bVar3);
                        } else {
                            z = true;
                        }
                        if (i10 > this.f3864i / 2) {
                            z = true;
                        }
                        f3 = 0.0f;
                        i9 = 1;
                    }
                }
            }
            i8++;
        }
        r(eVar);
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0092 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(m.b r17) {
        /*
            Method dump skipped, instructions count: 177
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.c.r(m.b):void");
    }

    public final void s() {
        for (int i8 = 0; i8 < this.f3865j; i8++) {
            b bVar = this.f3861f[i8];
            if (bVar != null) {
                ((d0.b) this.f3867l.f96b).b(bVar);
            }
            this.f3861f[i8] = null;
        }
    }

    public final void t() {
        a4.d dVar;
        int i8 = 0;
        while (true) {
            dVar = this.f3867l;
            g[] gVarArr = (g[]) dVar.d;
            if (i8 >= gVarArr.length) {
                break;
            }
            g gVar = gVarArr[i8];
            if (gVar != null) {
                gVar.c();
            }
            i8++;
        }
        d0.b bVar = (d0.b) dVar.f97c;
        g[] gVarArr2 = this.f3868m;
        int length = this.f3869n;
        bVar.getClass();
        if (length > gVarArr2.length) {
            length = gVarArr2.length;
        }
        for (int i9 = 0; i9 < length; i9++) {
            g gVar2 = gVarArr2[i9];
            int i10 = bVar.f1758b;
            Object[] objArr = bVar.f1757a;
            if (i10 < objArr.length) {
                objArr[i10] = gVar2;
                bVar.f1758b = i10 + 1;
            }
        }
        this.f3869n = 0;
        Arrays.fill((g[]) dVar.d, (Object) null);
        this.f3858b = 0;
        e eVar = this.f3859c;
        eVar.f3874h = 0;
        eVar.f3852b = 0.0f;
        this.f3864i = 1;
        for (int i11 = 0; i11 < this.f3865j; i11++) {
            b bVar2 = this.f3861f[i11];
        }
        s();
        this.f3865j = 0;
        this.f3870o = new b(dVar);
    }
}
