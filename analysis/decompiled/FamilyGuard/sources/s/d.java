package s;

import java.util.Arrays;
import java.util.HashMap;
import s.i;
import v.d;

/* loaded from: classes.dex */
public class d {

    /* renamed from: r, reason: collision with root package name */
    public static boolean f20152r = false;

    /* renamed from: s, reason: collision with root package name */
    public static boolean f20153s = true;

    /* renamed from: t, reason: collision with root package name */
    public static boolean f20154t = true;

    /* renamed from: u, reason: collision with root package name */
    public static boolean f20155u = true;

    /* renamed from: v, reason: collision with root package name */
    public static boolean f20156v = false;

    /* renamed from: w, reason: collision with root package name */
    private static int f20157w = 1000;

    /* renamed from: x, reason: collision with root package name */
    public static long f20158x;

    /* renamed from: y, reason: collision with root package name */
    public static long f20159y;

    /* renamed from: d, reason: collision with root package name */
    private a f20163d;

    /* renamed from: g, reason: collision with root package name */
    C1044b[] f20166g;

    /* renamed from: n, reason: collision with root package name */
    final C1045c f20173n;

    /* renamed from: q, reason: collision with root package name */
    private a f20176q;

    /* renamed from: a, reason: collision with root package name */
    public boolean f20160a = false;

    /* renamed from: b, reason: collision with root package name */
    int f20161b = 0;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, i> f20162c = null;

    /* renamed from: e, reason: collision with root package name */
    private int f20164e = 32;

    /* renamed from: f, reason: collision with root package name */
    private int f20165f = 32;

    /* renamed from: h, reason: collision with root package name */
    public boolean f20167h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f20168i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean[] f20169j = new boolean[32];

    /* renamed from: k, reason: collision with root package name */
    int f20170k = 1;

    /* renamed from: l, reason: collision with root package name */
    int f20171l = 0;

    /* renamed from: m, reason: collision with root package name */
    private int f20172m = 32;

    /* renamed from: o, reason: collision with root package name */
    private i[] f20174o = new i[f20157w];

    /* renamed from: p, reason: collision with root package name */
    private int f20175p = 0;

    interface a {
        void a(i iVar);

        i b(d dVar, boolean[] zArr);

        void c(a aVar);

        void clear();

        i getKey();

        boolean isEmpty();
    }

    class b extends C1044b {
        public b(C1045c c1045c) {
            this.f20146e = new j(this, c1045c);
        }
    }

    public d() {
        this.f20166g = null;
        this.f20166g = new C1044b[32];
        C();
        C1045c c1045c = new C1045c();
        this.f20173n = c1045c;
        this.f20163d = new h(c1045c);
        if (f20156v) {
            this.f20176q = new b(c1045c);
        } else {
            this.f20176q = new C1044b(c1045c);
        }
    }

    private final int B(a aVar, boolean z5) {
        for (int i5 = 0; i5 < this.f20170k; i5++) {
            this.f20169j[i5] = false;
        }
        boolean z6 = false;
        int i6 = 0;
        while (!z6) {
            i6++;
            if (i6 < this.f20170k * 2) {
                if (aVar.getKey() != null) {
                    this.f20169j[aVar.getKey().f20193c] = true;
                }
                i iVarB = aVar.b(this, this.f20169j);
                if (iVarB != null) {
                    boolean[] zArr = this.f20169j;
                    int i7 = iVarB.f20193c;
                    if (!zArr[i7]) {
                        zArr[i7] = true;
                    }
                }
                if (iVarB != null) {
                    float f5 = Float.MAX_VALUE;
                    int i8 = -1;
                    for (int i9 = 0; i9 < this.f20171l; i9++) {
                        C1044b c1044b = this.f20166g[i9];
                        if (c1044b.f20142a.f20200j != i.a.UNRESTRICTED && !c1044b.f20147f && c1044b.t(iVarB)) {
                            float f6 = c1044b.f20146e.f(iVarB);
                            if (f6 < 0.0f) {
                                float f7 = (-c1044b.f20143b) / f6;
                                if (f7 < f5) {
                                    i8 = i9;
                                    f5 = f7;
                                }
                            }
                        }
                    }
                    if (i8 > -1) {
                        C1044b c1044b2 = this.f20166g[i8];
                        c1044b2.f20142a.f20194d = -1;
                        c1044b2.x(iVarB);
                        i iVar = c1044b2.f20142a;
                        iVar.f20194d = i8;
                        iVar.k(this, c1044b2);
                    }
                } else {
                    z6 = true;
                }
            }
            return i6;
        }
        return i6;
    }

    private void C() {
        int i5 = 0;
        if (f20156v) {
            while (i5 < this.f20171l) {
                C1044b c1044b = this.f20166g[i5];
                if (c1044b != null) {
                    this.f20173n.f20148a.a(c1044b);
                }
                this.f20166g[i5] = null;
                i5++;
            }
            return;
        }
        while (i5 < this.f20171l) {
            C1044b c1044b2 = this.f20166g[i5];
            if (c1044b2 != null) {
                this.f20173n.f20149b.a(c1044b2);
            }
            this.f20166g[i5] = null;
            i5++;
        }
    }

    private i a(i.a aVar, String str) {
        i iVarB = this.f20173n.f20150c.b();
        if (iVarB == null) {
            iVarB = new i(aVar, str);
            iVarB.j(aVar, str);
        } else {
            iVarB.h();
            iVarB.j(aVar, str);
        }
        int i5 = this.f20175p;
        int i6 = f20157w;
        if (i5 >= i6) {
            int i7 = i6 * 2;
            f20157w = i7;
            this.f20174o = (i[]) Arrays.copyOf(this.f20174o, i7);
        }
        i[] iVarArr = this.f20174o;
        int i8 = this.f20175p;
        this.f20175p = i8 + 1;
        iVarArr[i8] = iVarB;
        return iVarB;
    }

    private final void l(C1044b c1044b) {
        int i5;
        if (f20154t && c1044b.f20147f) {
            c1044b.f20142a.i(this, c1044b.f20143b);
        } else {
            C1044b[] c1044bArr = this.f20166g;
            int i6 = this.f20171l;
            c1044bArr[i6] = c1044b;
            i iVar = c1044b.f20142a;
            iVar.f20194d = i6;
            this.f20171l = i6 + 1;
            iVar.k(this, c1044b);
        }
        if (f20154t && this.f20160a) {
            int i7 = 0;
            while (i7 < this.f20171l) {
                if (this.f20166g[i7] == null) {
                    System.out.println("WTF");
                }
                C1044b c1044b2 = this.f20166g[i7];
                if (c1044b2 != null && c1044b2.f20147f) {
                    c1044b2.f20142a.i(this, c1044b2.f20143b);
                    if (f20156v) {
                        this.f20173n.f20148a.a(c1044b2);
                    } else {
                        this.f20173n.f20149b.a(c1044b2);
                    }
                    this.f20166g[i7] = null;
                    int i8 = i7 + 1;
                    int i9 = i8;
                    while (true) {
                        i5 = this.f20171l;
                        if (i8 >= i5) {
                            break;
                        }
                        C1044b[] c1044bArr2 = this.f20166g;
                        int i10 = i8 - 1;
                        C1044b c1044b3 = c1044bArr2[i8];
                        c1044bArr2[i10] = c1044b3;
                        i iVar2 = c1044b3.f20142a;
                        if (iVar2.f20194d == i8) {
                            iVar2.f20194d = i10;
                        }
                        i9 = i8;
                        i8++;
                    }
                    if (i9 < i5) {
                        this.f20166g[i9] = null;
                    }
                    this.f20171l = i5 - 1;
                    i7--;
                }
                i7++;
            }
            this.f20160a = false;
        }
    }

    private void n() {
        for (int i5 = 0; i5 < this.f20171l; i5++) {
            C1044b c1044b = this.f20166g[i5];
            c1044b.f20142a.f20196f = c1044b.f20143b;
        }
    }

    public static C1044b s(d dVar, i iVar, i iVar2, float f5) {
        return dVar.r().j(iVar, iVar2, f5);
    }

    private int u(a aVar) {
        float f5;
        float f6;
        for (int i5 = 0; i5 < this.f20171l; i5++) {
            C1044b c1044b = this.f20166g[i5];
            if (c1044b.f20142a.f20200j != i.a.UNRESTRICTED) {
                float f7 = 0.0f;
                if (c1044b.f20143b < 0.0f) {
                    boolean z5 = false;
                    int i6 = 0;
                    while (!z5) {
                        i6++;
                        float f8 = Float.MAX_VALUE;
                        int i7 = 0;
                        int i8 = -1;
                        int i9 = -1;
                        int i10 = 0;
                        while (true) {
                            if (i7 >= this.f20171l) {
                                break;
                            }
                            C1044b c1044b2 = this.f20166g[i7];
                            if (c1044b2.f20142a.f20200j == i.a.UNRESTRICTED || c1044b2.f20147f || c1044b2.f20143b >= f7) {
                                f5 = f7;
                            } else if (f20155u) {
                                int iB = c1044b2.f20146e.b();
                                int i11 = 0;
                                while (i11 < iB) {
                                    i iVarE = c1044b2.f20146e.e(i11);
                                    float f9 = c1044b2.f20146e.f(iVarE);
                                    if (f9 <= f7) {
                                        f6 = f7;
                                    } else {
                                        f6 = f7;
                                        for (int i12 = 0; i12 < 9; i12++) {
                                            float f10 = iVarE.f20198h[i12] / f9;
                                            if ((f10 < f8 && i12 == i10) || i12 > i10) {
                                                i10 = i12;
                                                i9 = iVarE.f20193c;
                                                i8 = i7;
                                                f8 = f10;
                                            }
                                        }
                                    }
                                    i11++;
                                    f7 = f6;
                                }
                                f5 = f7;
                            } else {
                                f5 = f7;
                                for (int i13 = 1; i13 < this.f20170k; i13++) {
                                    i iVar = this.f20173n.f20151d[i13];
                                    float f11 = c1044b2.f20146e.f(iVar);
                                    if (f11 > f5) {
                                        for (int i14 = 0; i14 < 9; i14++) {
                                            float f12 = iVar.f20198h[i14] / f11;
                                            if ((f12 < f8 && i14 == i10) || i14 > i10) {
                                                i10 = i14;
                                                i8 = i7;
                                                i9 = i13;
                                                f8 = f12;
                                            }
                                        }
                                    }
                                }
                            }
                            i7++;
                            f7 = f5;
                        }
                        float f13 = f7;
                        if (i8 != -1) {
                            C1044b c1044b3 = this.f20166g[i8];
                            c1044b3.f20142a.f20194d = -1;
                            c1044b3.x(this.f20173n.f20151d[i9]);
                            i iVar2 = c1044b3.f20142a;
                            iVar2.f20194d = i8;
                            iVar2.k(this, c1044b3);
                        } else {
                            z5 = true;
                        }
                        if (i6 > this.f20170k / 2) {
                            z5 = true;
                        }
                        f7 = f13;
                    }
                    return i6;
                }
            }
        }
        return 0;
    }

    public static e w() {
        return null;
    }

    private void y() {
        int i5 = this.f20164e * 2;
        this.f20164e = i5;
        this.f20166g = (C1044b[]) Arrays.copyOf(this.f20166g, i5);
        C1045c c1045c = this.f20173n;
        c1045c.f20151d = (i[]) Arrays.copyOf(c1045c.f20151d, this.f20164e);
        int i6 = this.f20164e;
        this.f20169j = new boolean[i6];
        this.f20165f = i6;
        this.f20172m = i6;
    }

    void A(a aVar) {
        u(aVar);
        B(aVar, false);
        n();
    }

    public void D() {
        C1045c c1045c;
        int i5 = 0;
        while (true) {
            c1045c = this.f20173n;
            i[] iVarArr = c1045c.f20151d;
            if (i5 >= iVarArr.length) {
                break;
            }
            i iVar = iVarArr[i5];
            if (iVar != null) {
                iVar.h();
            }
            i5++;
        }
        c1045c.f20150c.c(this.f20174o, this.f20175p);
        this.f20175p = 0;
        Arrays.fill(this.f20173n.f20151d, (Object) null);
        HashMap<String, i> map = this.f20162c;
        if (map != null) {
            map.clear();
        }
        this.f20161b = 0;
        this.f20163d.clear();
        this.f20170k = 1;
        for (int i6 = 0; i6 < this.f20171l; i6++) {
            C1044b c1044b = this.f20166g[i6];
            if (c1044b != null) {
                c1044b.f20144c = false;
            }
        }
        C();
        this.f20171l = 0;
        if (f20156v) {
            this.f20176q = new b(this.f20173n);
        } else {
            this.f20176q = new C1044b(this.f20173n);
        }
    }

    public void b(v.e eVar, v.e eVar2, float f5, int i5) {
        d.b bVar = d.b.LEFT;
        i iVarQ = q(eVar.o(bVar));
        d.b bVar2 = d.b.TOP;
        i iVarQ2 = q(eVar.o(bVar2));
        d.b bVar3 = d.b.RIGHT;
        i iVarQ3 = q(eVar.o(bVar3));
        d.b bVar4 = d.b.BOTTOM;
        i iVarQ4 = q(eVar.o(bVar4));
        i iVarQ5 = q(eVar2.o(bVar));
        i iVarQ6 = q(eVar2.o(bVar2));
        i iVarQ7 = q(eVar2.o(bVar3));
        i iVarQ8 = q(eVar2.o(bVar4));
        C1044b c1044bR = r();
        double d6 = f5;
        double d7 = i5;
        c1044bR.q(iVarQ2, iVarQ4, iVarQ6, iVarQ8, (float) (Math.sin(d6) * d7));
        d(c1044bR);
        C1044b c1044bR2 = r();
        c1044bR2.q(iVarQ, iVarQ3, iVarQ5, iVarQ7, (float) (Math.cos(d6) * d7));
        d(c1044bR2);
    }

    public void c(i iVar, i iVar2, int i5, float f5, i iVar3, i iVar4, int i6, int i7) {
        C1044b c1044bR = r();
        c1044bR.h(iVar, iVar2, i5, f5, iVar3, iVar4, i6);
        if (i7 != 8) {
            c1044bR.d(this, i7);
        }
        d(c1044bR);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(s.C1044b r6) {
        /*
            r5 = this;
            if (r6 != 0) goto L4
            goto L8a
        L4:
            int r0 = r5.f20171l
            r1 = 1
            int r0 = r0 + r1
            int r2 = r5.f20172m
            if (r0 >= r2) goto L13
            int r0 = r5.f20170k
            int r0 = r0 + r1
            int r2 = r5.f20165f
            if (r0 < r2) goto L16
        L13:
            r5.y()
        L16:
            boolean r0 = r6.f20147f
            r2 = 0
            if (r0 != 0) goto L85
            r6.D(r5)
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L25
            goto L8a
        L25:
            r6.r()
            boolean r0 = r6.f(r5)
            if (r0 == 0) goto L7c
            s.i r0 = r5.p()
            r6.f20142a = r0
            int r3 = r5.f20171l
            r5.l(r6)
            int r4 = r5.f20171l
            int r3 = r3 + r1
            if (r4 != r3) goto L7c
            s.d$a r2 = r5.f20176q
            r2.c(r6)
            s.d$a r2 = r5.f20176q
            r5.B(r2, r1)
            int r2 = r0.f20194d
            r3 = -1
            if (r2 != r3) goto L7d
            s.i r2 = r6.f20142a
            if (r2 != r0) goto L5a
            s.i r0 = r6.v(r0)
            if (r0 == 0) goto L5a
            r6.x(r0)
        L5a:
            boolean r0 = r6.f20147f
            if (r0 != 0) goto L63
            s.i r0 = r6.f20142a
            r0.k(r5, r6)
        L63:
            boolean r0 = s.d.f20156v
            if (r0 == 0) goto L6f
            s.c r0 = r5.f20173n
            s.f<s.b> r0 = r0.f20148a
            r0.a(r6)
            goto L76
        L6f:
            s.c r0 = r5.f20173n
            s.f<s.b> r0 = r0.f20149b
            r0.a(r6)
        L76:
            int r0 = r5.f20171l
            int r0 = r0 - r1
            r5.f20171l = r0
            goto L7d
        L7c:
            r1 = r2
        L7d:
            boolean r0 = r6.s()
            if (r0 != 0) goto L84
            goto L8a
        L84:
            r2 = r1
        L85:
            if (r2 != 0) goto L8a
            r5.l(r6)
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: s.d.d(s.b):void");
    }

    public C1044b e(i iVar, i iVar2, int i5, int i6) {
        if (f20153s && i6 == 8 && iVar2.f20197g && iVar.f20194d == -1) {
            iVar.i(this, iVar2.f20196f + i5);
            return null;
        }
        C1044b c1044bR = r();
        c1044bR.n(iVar, iVar2, i5);
        if (i6 != 8) {
            c1044bR.d(this, i6);
        }
        d(c1044bR);
        return c1044bR;
    }

    public void f(i iVar, int i5) {
        if (f20153s && iVar.f20194d == -1) {
            float f5 = i5;
            iVar.i(this, f5);
            for (int i6 = 0; i6 < this.f20161b + 1; i6++) {
                i iVar2 = this.f20173n.f20151d[i6];
                if (iVar2 != null && iVar2.f20204n && iVar2.f20205o == iVar.f20193c) {
                    iVar2.i(this, iVar2.f20206p + f5);
                }
            }
            return;
        }
        int i7 = iVar.f20194d;
        if (i7 == -1) {
            C1044b c1044bR = r();
            c1044bR.i(iVar, i5);
            d(c1044bR);
            return;
        }
        C1044b c1044b = this.f20166g[i7];
        if (c1044b.f20147f) {
            c1044b.f20143b = i5;
            return;
        }
        if (c1044b.f20146e.b() == 0) {
            c1044b.f20147f = true;
            c1044b.f20143b = i5;
        } else {
            C1044b c1044bR2 = r();
            c1044bR2.m(iVar, i5);
            d(c1044bR2);
        }
    }

    public void g(i iVar, i iVar2, int i5, boolean z5) {
        C1044b c1044bR = r();
        i iVarT = t();
        iVarT.f20195e = 0;
        c1044bR.o(iVar, iVar2, iVarT, i5);
        d(c1044bR);
    }

    public void h(i iVar, i iVar2, int i5, int i6) {
        C1044b c1044bR = r();
        i iVarT = t();
        iVarT.f20195e = 0;
        c1044bR.o(iVar, iVar2, iVarT, i5);
        if (i6 != 8) {
            m(c1044bR, (int) (c1044bR.f20146e.f(iVarT) * (-1.0f)), i6);
        }
        d(c1044bR);
    }

    public void i(i iVar, i iVar2, int i5, boolean z5) {
        C1044b c1044bR = r();
        i iVarT = t();
        iVarT.f20195e = 0;
        c1044bR.p(iVar, iVar2, iVarT, i5);
        d(c1044bR);
    }

    public void j(i iVar, i iVar2, int i5, int i6) {
        C1044b c1044bR = r();
        i iVarT = t();
        iVarT.f20195e = 0;
        c1044bR.p(iVar, iVar2, iVarT, i5);
        if (i6 != 8) {
            m(c1044bR, (int) (c1044bR.f20146e.f(iVarT) * (-1.0f)), i6);
        }
        d(c1044bR);
    }

    public void k(i iVar, i iVar2, i iVar3, i iVar4, float f5, int i5) {
        C1044b c1044bR = r();
        c1044bR.k(iVar, iVar2, iVar3, iVar4, f5);
        if (i5 != 8) {
            c1044bR.d(this, i5);
        }
        d(c1044bR);
    }

    void m(C1044b c1044b, int i5, int i6) {
        c1044b.e(o(i6, null), i5);
    }

    public i o(int i5, String str) {
        if (this.f20170k + 1 >= this.f20165f) {
            y();
        }
        i iVarA = a(i.a.ERROR, str);
        int i6 = this.f20161b + 1;
        this.f20161b = i6;
        this.f20170k++;
        iVarA.f20193c = i6;
        iVarA.f20195e = i5;
        this.f20173n.f20151d[i6] = iVarA;
        this.f20163d.a(iVarA);
        return iVarA;
    }

    public i p() {
        if (this.f20170k + 1 >= this.f20165f) {
            y();
        }
        i iVarA = a(i.a.SLACK, null);
        int i5 = this.f20161b + 1;
        this.f20161b = i5;
        this.f20170k++;
        iVarA.f20193c = i5;
        this.f20173n.f20151d[i5] = iVarA;
        return iVarA;
    }

    public i q(Object obj) {
        i iVarI = null;
        if (obj == null) {
            return null;
        }
        if (this.f20170k + 1 >= this.f20165f) {
            y();
        }
        if (obj instanceof v.d) {
            v.d dVar = (v.d) obj;
            iVarI = dVar.i();
            if (iVarI == null) {
                dVar.s(this.f20173n);
                iVarI = dVar.i();
            }
            int i5 = iVarI.f20193c;
            if (i5 != -1 && i5 <= this.f20161b && this.f20173n.f20151d[i5] != null) {
                return iVarI;
            }
            if (i5 != -1) {
                iVarI.h();
            }
            int i6 = this.f20161b + 1;
            this.f20161b = i6;
            this.f20170k++;
            iVarI.f20193c = i6;
            iVarI.f20200j = i.a.UNRESTRICTED;
            this.f20173n.f20151d[i6] = iVarI;
        }
        return iVarI;
    }

    public C1044b r() {
        C1044b c1044bB;
        if (f20156v) {
            c1044bB = this.f20173n.f20148a.b();
            if (c1044bB == null) {
                c1044bB = new b(this.f20173n);
                f20159y++;
            } else {
                c1044bB.y();
            }
        } else {
            c1044bB = this.f20173n.f20149b.b();
            if (c1044bB == null) {
                c1044bB = new C1044b(this.f20173n);
                f20158x++;
            } else {
                c1044bB.y();
            }
        }
        i.e();
        return c1044bB;
    }

    public i t() {
        if (this.f20170k + 1 >= this.f20165f) {
            y();
        }
        i iVarA = a(i.a.SLACK, null);
        int i5 = this.f20161b + 1;
        this.f20161b = i5;
        this.f20170k++;
        iVarA.f20193c = i5;
        this.f20173n.f20151d[i5] = iVarA;
        return iVarA;
    }

    public C1045c v() {
        return this.f20173n;
    }

    public int x(Object obj) {
        i iVarI = ((v.d) obj).i();
        if (iVarI != null) {
            return (int) (iVarI.f20196f + 0.5f);
        }
        return 0;
    }

    public void z() {
        if (this.f20163d.isEmpty()) {
            n();
            return;
        }
        if (!this.f20167h && !this.f20168i) {
            A(this.f20163d);
            return;
        }
        for (int i5 = 0; i5 < this.f20171l; i5++) {
            if (!this.f20166g[i5].f20147f) {
                A(this.f20163d);
                return;
            }
        }
        n();
    }
}
