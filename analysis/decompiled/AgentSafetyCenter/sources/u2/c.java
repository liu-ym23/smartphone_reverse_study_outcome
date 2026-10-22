package u2;

import java.util.Arrays;
import p5.m;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: p, reason: collision with root package name */
    public static boolean f13995p = false;

    /* renamed from: q, reason: collision with root package name */
    public static int f13996q = 1000;

    /* renamed from: a, reason: collision with root package name */
    public boolean f13997a;

    /* renamed from: b, reason: collision with root package name */
    public int f13998b;

    /* renamed from: c, reason: collision with root package name */
    public d f13999c;

    /* renamed from: d, reason: collision with root package name */
    public int f14000d;

    /* renamed from: e, reason: collision with root package name */
    public int f14001e;

    /* renamed from: f, reason: collision with root package name */
    public b[] f14002f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14003g;

    /* renamed from: h, reason: collision with root package name */
    public boolean[] f14004h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f14005j;

    /* renamed from: k, reason: collision with root package name */
    public int f14006k;

    /* renamed from: l, reason: collision with root package name */
    public m f14007l;

    /* renamed from: m, reason: collision with root package name */
    public e[] f14008m;

    /* renamed from: n, reason: collision with root package name */
    public int f14009n;

    /* renamed from: o, reason: collision with root package name */
    public b f14010o;

    public static int n(Object obj) {
        e eVar = ((w2.d) obj).i;
        if (eVar != null) {
            return (int) (eVar.i + 0.5f);
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v0 */
    public final e a(int i) {
        m3.c cVar = (m3.c) this.f14007l.f9742g;
        int i3 = cVar.f8195b;
        e eVar = null;
        if (i3 > 0) {
            int i10 = i3 - 1;
            ?? r32 = cVar.f8194a;
            ?? r42 = r32[i10];
            r32[i10] = 0;
            cVar.f8195b = i10;
            eVar = r42;
        }
        e eVar2 = eVar;
        if (eVar2 == null) {
            eVar2 = new e(i);
            eVar2.f14024p = i;
        } else {
            eVar2.c();
            eVar2.f14024p = i;
        }
        int i11 = this.f14009n;
        int i12 = f13996q;
        if (i11 >= i12) {
            int i13 = i12 * 2;
            f13996q = i13;
            this.f14008m = (e[]) Arrays.copyOf(this.f14008m, i13);
        }
        e[] eVarArr = this.f14008m;
        int i14 = this.f14009n;
        this.f14009n = i14 + 1;
        eVarArr[i14] = eVar2;
        return eVar2;
    }

    public final void b(e eVar, e eVar2, int i, float f5, e eVar3, e eVar4, int i3, int i10) {
        b bVarL = l();
        if (eVar2 == eVar3) {
            bVarL.f13993d.g(eVar, 1.0f);
            bVarL.f13993d.g(eVar4, 1.0f);
            bVarL.f13993d.g(eVar2, -2.0f);
        } else {
            a aVar = bVarL.f13993d;
            if (f5 == 0.5f) {
                aVar.g(eVar, 1.0f);
                bVarL.f13993d.g(eVar2, -1.0f);
                bVarL.f13993d.g(eVar3, -1.0f);
                bVarL.f13993d.g(eVar4, 1.0f);
                if (i > 0 || i3 > 0) {
                    bVarL.f13991b = (-i) + i3;
                }
            } else if (f5 <= 0.0f) {
                aVar.g(eVar, -1.0f);
                bVarL.f13993d.g(eVar2, 1.0f);
                bVarL.f13991b = i;
            } else if (f5 >= 1.0f) {
                aVar.g(eVar4, -1.0f);
                bVarL.f13993d.g(eVar3, 1.0f);
                bVarL.f13991b = -i3;
            } else {
                float f10 = 1.0f - f5;
                aVar.g(eVar, f10 * 1.0f);
                bVarL.f13993d.g(eVar2, f10 * (-1.0f));
                bVarL.f13993d.g(eVar3, (-1.0f) * f5);
                bVarL.f13993d.g(eVar4, 1.0f * f5);
                if (i > 0 || i3 > 0) {
                    bVarL.f13991b = (i3 * f5) + ((-i) * f10);
                }
            }
        }
        if (i10 != 8) {
            bVarL.a(this, i10);
        }
        c(bVarL);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(u2.b r18) {
        /*
            Method dump skipped, instructions count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.c.c(u2.b):void");
    }

    public final void d(e eVar, int i) {
        int i3 = eVar.f14016g;
        if (i3 == -1) {
            eVar.d(this, i);
            for (int i10 = 0; i10 < this.f13998b + 1; i10++) {
                e eVar2 = ((e[]) this.f14007l.f9743h)[i10];
            }
            return;
        }
        if (i3 == -1) {
            b bVarL = l();
            bVarL.f13990a = eVar;
            float f5 = i;
            eVar.i = f5;
            bVarL.f13991b = f5;
            bVarL.f13994e = true;
            c(bVarL);
            return;
        }
        b bVar = this.f14002f[i3];
        if (bVar.f13994e) {
            bVar.f13991b = i;
            return;
        }
        if (bVar.f13993d.d() == 0) {
            bVar.f13994e = true;
            bVar.f13991b = i;
            return;
        }
        b bVarL2 = l();
        if (i < 0) {
            bVarL2.f13991b = i * (-1);
            bVarL2.f13993d.g(eVar, 1.0f);
        } else {
            bVarL2.f13991b = i;
            bVarL2.f13993d.g(eVar, -1.0f);
        }
        c(bVarL2);
    }

    public final void e(e eVar, e eVar2, int i, int i3) {
        if (i3 == 8 && eVar2.f14018j && eVar.f14016g == -1) {
            eVar.d(this, eVar2.i + i);
            return;
        }
        b bVarL = l();
        boolean z10 = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z10 = true;
            }
            bVarL.f13991b = i;
        }
        a aVar = bVarL.f13993d;
        if (z10) {
            aVar.g(eVar, 1.0f);
            bVarL.f13993d.g(eVar2, -1.0f);
        } else {
            aVar.g(eVar, -1.0f);
            bVarL.f13993d.g(eVar2, 1.0f);
        }
        if (i3 != 8) {
            bVarL.a(this, i3);
        }
        c(bVarL);
    }

    public final void f(e eVar, e eVar2, int i, int i3) {
        b bVarL = l();
        e eVarM = m();
        eVarM.f14017h = 0;
        bVarL.b(eVar, eVar2, eVarM, i);
        if (i3 != 8) {
            bVarL.f13993d.g(j(i3), (int) (bVarL.f13993d.c(eVarM) * (-1.0f)));
        }
        c(bVarL);
    }

    public final void g(e eVar, e eVar2, int i, int i3) {
        b bVarL = l();
        e eVarM = m();
        eVarM.f14017h = 0;
        bVarL.c(eVar, eVar2, eVarM, i);
        if (i3 != 8) {
            bVarL.f13993d.g(j(i3), (int) (bVarL.f13993d.c(eVarM) * (-1.0f)));
        }
        c(bVarL);
    }

    public final void h(b bVar) {
        int i;
        if (bVar.f13994e) {
            bVar.f13990a.d(this, bVar.f13991b);
        } else {
            b[] bVarArr = this.f14002f;
            int i3 = this.f14005j;
            bVarArr[i3] = bVar;
            e eVar = bVar.f13990a;
            eVar.f14016g = i3;
            this.f14005j = i3 + 1;
            eVar.e(this, bVar);
        }
        if (this.f13997a) {
            int i10 = 0;
            while (i10 < this.f14005j) {
                if (this.f14002f[i10] == null) {
                    System.out.println("WTF");
                }
                b bVar2 = this.f14002f[i10];
                if (bVar2 != null && bVar2.f13994e) {
                    bVar2.f13990a.d(this, bVar2.f13991b);
                    ((m3.c) this.f14007l.f9741f).c(bVar2);
                    this.f14002f[i10] = null;
                    int i11 = i10 + 1;
                    int i12 = i11;
                    while (true) {
                        i = this.f14005j;
                        if (i11 >= i) {
                            break;
                        }
                        b[] bVarArr2 = this.f14002f;
                        int i13 = i11 - 1;
                        b bVar3 = bVarArr2[i11];
                        bVarArr2[i13] = bVar3;
                        e eVar2 = bVar3.f13990a;
                        if (eVar2.f14016g == i11) {
                            eVar2.f14016g = i13;
                        }
                        i12 = i11;
                        i11++;
                    }
                    if (i12 < i) {
                        this.f14002f[i12] = null;
                    }
                    this.f14005j = i - 1;
                    i10--;
                }
                i10++;
            }
            this.f13997a = false;
        }
    }

    public final void i() {
        for (int i = 0; i < this.f14005j; i++) {
            b bVar = this.f14002f[i];
            bVar.f13990a.i = bVar.f13991b;
        }
    }

    public final e j(int i) {
        if (this.i + 1 >= this.f14001e) {
            o();
        }
        e eVarA = a(4);
        float[] fArr = eVarA.f14020l;
        int i3 = this.f13998b + 1;
        this.f13998b = i3;
        this.i++;
        eVarA.f14015f = i3;
        eVarA.f14017h = i;
        ((e[]) this.f14007l.f9743h)[i3] = eVarA;
        d dVar = this.f13999c;
        dVar.i.f9722f = eVarA;
        Arrays.fill(fArr, 0.0f);
        fArr[eVarA.f14017h] = 1.0f;
        dVar.j(eVarA);
        return eVarA;
    }

    public final e k(Object obj) {
        m mVar = this.f14007l;
        if (obj == null) {
            return null;
        }
        if (this.i + 1 >= this.f14001e) {
            o();
        }
        if (!(obj instanceof w2.d)) {
            return null;
        }
        w2.d dVar = (w2.d) obj;
        e eVar = dVar.i;
        if (eVar == null) {
            dVar.h();
            eVar = dVar.i;
        }
        int i = eVar.f14015f;
        if (i != -1 && i <= this.f13998b && ((e[]) mVar.f9743h)[i] != null) {
            return eVar;
        }
        if (i != -1) {
            eVar.c();
        }
        int i3 = this.f13998b + 1;
        this.f13998b = i3;
        this.i++;
        eVar.f14015f = i3;
        eVar.f14024p = 1;
        ((e[]) mVar.f9743h)[i3] = eVar;
        return eVar;
    }

    public final b l() {
        Object obj;
        m mVar = this.f14007l;
        m3.c cVar = (m3.c) mVar.f9741f;
        int i = cVar.f8195b;
        if (i > 0) {
            int i3 = i - 1;
            Object[] objArr = cVar.f8194a;
            obj = objArr[i3];
            objArr[i3] = null;
            cVar.f8195b = i3;
        } else {
            obj = null;
        }
        b bVar = (b) obj;
        if (bVar == null) {
            return new b(mVar);
        }
        bVar.f13990a = null;
        bVar.f13993d.b();
        bVar.f13991b = 0.0f;
        bVar.f13994e = false;
        return bVar;
    }

    public final e m() {
        if (this.i + 1 >= this.f14001e) {
            o();
        }
        e eVarA = a(3);
        int i = this.f13998b + 1;
        this.f13998b = i;
        this.i++;
        eVarA.f14015f = i;
        ((e[]) this.f14007l.f9743h)[i] = eVarA;
        return eVarA;
    }

    public final void o() {
        int i = this.f14000d * 2;
        this.f14000d = i;
        this.f14002f = (b[]) Arrays.copyOf(this.f14002f, i);
        m mVar = this.f14007l;
        mVar.f9743h = (e[]) Arrays.copyOf((e[]) mVar.f9743h, this.f14000d);
        int i3 = this.f14000d;
        this.f14004h = new boolean[i3];
        this.f14001e = i3;
        this.f14006k = i3;
    }

    public final void p() {
        d dVar = this.f13999c;
        if (dVar.e()) {
            i();
            return;
        }
        if (!this.f14003g) {
            q(dVar);
            return;
        }
        for (int i = 0; i < this.f14005j; i++) {
            if (!this.f14002f[i].f13994e) {
                q(dVar);
                return;
            }
        }
        i();
    }

    public final void q(d dVar) {
        int i = 0;
        while (true) {
            if (i >= this.f14005j) {
                break;
            }
            b bVar = this.f14002f[i];
            int i3 = 1;
            if (bVar.f13990a.f14024p != 1) {
                float f5 = 0.0f;
                if (bVar.f13991b < 0.0f) {
                    boolean z10 = false;
                    int i10 = 0;
                    while (!z10) {
                        i10 += i3;
                        float f10 = Float.MAX_VALUE;
                        int i11 = -1;
                        int i12 = -1;
                        int i13 = 0;
                        int i14 = 0;
                        while (i13 < this.f14005j) {
                            b bVar2 = this.f14002f[i13];
                            if (bVar2.f13990a.f14024p != i3 && !bVar2.f13994e && bVar2.f13991b < f5) {
                                int iD = bVar2.f13993d.d();
                                int i15 = 0;
                                while (i15 < iD) {
                                    e eVarE = bVar2.f13993d.e(i15);
                                    float fC = bVar2.f13993d.c(eVarE);
                                    if (fC > f5) {
                                        for (int i16 = 0; i16 < 9; i16++) {
                                            float f11 = eVarE.f14019k[i16] / fC;
                                            if ((f11 < f10 && i16 == i14) || i16 > i14) {
                                                i14 = i16;
                                                i12 = eVarE.f14015f;
                                                i11 = i13;
                                                f10 = f11;
                                            }
                                        }
                                    }
                                    i15++;
                                    f5 = 0.0f;
                                }
                            }
                            i13++;
                            f5 = 0.0f;
                            i3 = 1;
                        }
                        if (i11 != -1) {
                            b bVar3 = this.f14002f[i11];
                            bVar3.f13990a.f14016g = -1;
                            bVar3.g(((e[]) this.f14007l.f9743h)[i12]);
                            e eVar = bVar3.f13990a;
                            eVar.f14016g = i11;
                            eVar.e(this, bVar3);
                        } else {
                            z10 = true;
                        }
                        if (i10 > this.i / 2) {
                            z10 = true;
                        }
                        f5 = 0.0f;
                        i3 = 1;
                    }
                }
            }
            i++;
        }
        r(dVar);
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0092 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(u2.b r17) {
        /*
            Method dump skipped, instructions count: 177
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.c.r(u2.b):void");
    }

    public final void s() {
        for (int i = 0; i < this.f14005j; i++) {
            b bVar = this.f14002f[i];
            if (bVar != null) {
                ((m3.c) this.f14007l.f9741f).c(bVar);
            }
            this.f14002f[i] = null;
        }
    }

    public final void t() {
        m mVar = this.f14007l;
        int i = 0;
        while (true) {
            e[] eVarArr = (e[]) mVar.f9743h;
            if (i >= eVarArr.length) {
                break;
            }
            e eVar = eVarArr[i];
            if (eVar != null) {
                eVar.c();
            }
            i++;
        }
        m3.c cVar = (m3.c) mVar.f9742g;
        e[] eVarArr2 = this.f14008m;
        int length = this.f14009n;
        cVar.getClass();
        if (length > eVarArr2.length) {
            length = eVarArr2.length;
        }
        for (int i3 = 0; i3 < length; i3++) {
            e eVar2 = eVarArr2[i3];
            int i10 = cVar.f8195b;
            Object[] objArr = cVar.f8194a;
            if (i10 < objArr.length) {
                objArr[i10] = eVar2;
                cVar.f8195b = i10 + 1;
            }
        }
        this.f14009n = 0;
        Arrays.fill((e[]) mVar.f9743h, (Object) null);
        this.f13998b = 0;
        d dVar = this.f13999c;
        dVar.f14013h = 0;
        dVar.f13991b = 0.0f;
        this.i = 1;
        for (int i11 = 0; i11 < this.f14005j; i11++) {
            b bVar = this.f14002f[i11];
        }
        s();
        this.f14005j = 0;
        this.f14010o = new b(mVar);
    }
}
