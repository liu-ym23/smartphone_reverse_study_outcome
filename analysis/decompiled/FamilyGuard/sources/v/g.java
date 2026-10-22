package v;

import java.util.ArrayList;
import v.e;

/* loaded from: classes.dex */
public class g extends l {

    /* renamed from: x1, reason: collision with root package name */
    private e[] f23168x1;

    /* renamed from: a1, reason: collision with root package name */
    private int f23145a1 = -1;

    /* renamed from: b1, reason: collision with root package name */
    private int f23146b1 = -1;

    /* renamed from: c1, reason: collision with root package name */
    private int f23147c1 = -1;

    /* renamed from: d1, reason: collision with root package name */
    private int f23148d1 = -1;

    /* renamed from: e1, reason: collision with root package name */
    private int f23149e1 = -1;

    /* renamed from: f1, reason: collision with root package name */
    private int f23150f1 = -1;

    /* renamed from: g1, reason: collision with root package name */
    private float f23151g1 = 0.5f;

    /* renamed from: h1, reason: collision with root package name */
    private float f23152h1 = 0.5f;

    /* renamed from: i1, reason: collision with root package name */
    private float f23153i1 = 0.5f;

    /* renamed from: j1, reason: collision with root package name */
    private float f23154j1 = 0.5f;

    /* renamed from: k1, reason: collision with root package name */
    private float f23155k1 = 0.5f;

    /* renamed from: l1, reason: collision with root package name */
    private float f23156l1 = 0.5f;

    /* renamed from: m1, reason: collision with root package name */
    private int f23157m1 = 0;

    /* renamed from: n1, reason: collision with root package name */
    private int f23158n1 = 0;

    /* renamed from: o1, reason: collision with root package name */
    private int f23159o1 = 2;

    /* renamed from: p1, reason: collision with root package name */
    private int f23160p1 = 2;

    /* renamed from: q1, reason: collision with root package name */
    private int f23161q1 = 0;

    /* renamed from: r1, reason: collision with root package name */
    private int f23162r1 = -1;

    /* renamed from: s1, reason: collision with root package name */
    private int f23163s1 = 0;

    /* renamed from: t1, reason: collision with root package name */
    private ArrayList<a> f23164t1 = new ArrayList<>();

    /* renamed from: u1, reason: collision with root package name */
    private e[] f23165u1 = null;

    /* renamed from: v1, reason: collision with root package name */
    private e[] f23166v1 = null;

    /* renamed from: w1, reason: collision with root package name */
    private int[] f23167w1 = null;

    /* renamed from: y1, reason: collision with root package name */
    private int f23169y1 = 0;

    private class a {

        /* renamed from: a, reason: collision with root package name */
        private int f23170a;

        /* renamed from: d, reason: collision with root package name */
        private d f23173d;

        /* renamed from: e, reason: collision with root package name */
        private d f23174e;

        /* renamed from: f, reason: collision with root package name */
        private d f23175f;

        /* renamed from: g, reason: collision with root package name */
        private d f23176g;

        /* renamed from: h, reason: collision with root package name */
        private int f23177h;

        /* renamed from: i, reason: collision with root package name */
        private int f23178i;

        /* renamed from: j, reason: collision with root package name */
        private int f23179j;

        /* renamed from: k, reason: collision with root package name */
        private int f23180k;

        /* renamed from: q, reason: collision with root package name */
        private int f23186q;

        /* renamed from: b, reason: collision with root package name */
        private e f23171b = null;

        /* renamed from: c, reason: collision with root package name */
        int f23172c = 0;

        /* renamed from: l, reason: collision with root package name */
        private int f23181l = 0;

        /* renamed from: m, reason: collision with root package name */
        private int f23182m = 0;

        /* renamed from: n, reason: collision with root package name */
        private int f23183n = 0;

        /* renamed from: o, reason: collision with root package name */
        private int f23184o = 0;

        /* renamed from: p, reason: collision with root package name */
        private int f23185p = 0;

        public a(int i5, d dVar, d dVar2, d dVar3, d dVar4, int i6) {
            this.f23177h = 0;
            this.f23178i = 0;
            this.f23179j = 0;
            this.f23180k = 0;
            this.f23186q = 0;
            this.f23170a = i5;
            this.f23173d = dVar;
            this.f23174e = dVar2;
            this.f23175f = dVar3;
            this.f23176g = dVar4;
            this.f23177h = g.this.z1();
            this.f23178i = g.this.B1();
            this.f23179j = g.this.A1();
            this.f23180k = g.this.y1();
            this.f23186q = i6;
        }

        private void h() {
            this.f23181l = 0;
            this.f23182m = 0;
            this.f23171b = null;
            this.f23172c = 0;
            int i5 = this.f23184o;
            for (int i6 = 0; i6 < i5 && this.f23183n + i6 < g.this.f23169y1; i6++) {
                e eVar = g.this.f23168x1[this.f23183n + i6];
                if (this.f23170a == 0) {
                    int iW = eVar.W();
                    int i7 = g.this.f23157m1;
                    if (eVar.V() == 8) {
                        i7 = 0;
                    }
                    this.f23181l += iW + i7;
                    int iK2 = g.this.k2(eVar, this.f23186q);
                    if (this.f23171b == null || this.f23172c < iK2) {
                        this.f23171b = eVar;
                        this.f23172c = iK2;
                        this.f23182m = iK2;
                    }
                } else {
                    int iL2 = g.this.l2(eVar, this.f23186q);
                    int iK22 = g.this.k2(eVar, this.f23186q);
                    int i8 = g.this.f23158n1;
                    if (eVar.V() == 8) {
                        i8 = 0;
                    }
                    this.f23182m += iK22 + i8;
                    if (this.f23171b == null || this.f23172c < iL2) {
                        this.f23171b = eVar;
                        this.f23172c = iL2;
                        this.f23181l = iL2;
                    }
                }
            }
        }

        public void b(e eVar) {
            if (this.f23170a == 0) {
                int iL2 = g.this.l2(eVar, this.f23186q);
                if (eVar.A() == e.b.MATCH_CONSTRAINT) {
                    this.f23185p++;
                    iL2 = 0;
                }
                this.f23181l += iL2 + (eVar.V() != 8 ? g.this.f23157m1 : 0);
                int iK2 = g.this.k2(eVar, this.f23186q);
                if (this.f23171b == null || this.f23172c < iK2) {
                    this.f23171b = eVar;
                    this.f23172c = iK2;
                    this.f23182m = iK2;
                }
            } else {
                int iL22 = g.this.l2(eVar, this.f23186q);
                int iK22 = g.this.k2(eVar, this.f23186q);
                if (eVar.T() == e.b.MATCH_CONSTRAINT) {
                    this.f23185p++;
                    iK22 = 0;
                }
                this.f23182m += iK22 + (eVar.V() != 8 ? g.this.f23158n1 : 0);
                if (this.f23171b == null || this.f23172c < iL22) {
                    this.f23171b = eVar;
                    this.f23172c = iL22;
                    this.f23181l = iL22;
                }
            }
            this.f23184o++;
        }

        public void c() {
            this.f23172c = 0;
            this.f23171b = null;
            this.f23181l = 0;
            this.f23182m = 0;
            this.f23183n = 0;
            this.f23184o = 0;
            this.f23185p = 0;
        }

        public void d(boolean z5, int i5, boolean z6) {
            e eVar;
            int i6;
            char c6;
            float f5;
            float f6;
            int i7 = this.f23184o;
            for (int i8 = 0; i8 < i7 && this.f23183n + i8 < g.this.f23169y1; i8++) {
                e eVar2 = g.this.f23168x1[this.f23183n + i8];
                if (eVar2 != null) {
                    eVar2.u0();
                }
            }
            if (i7 == 0 || this.f23171b == null) {
                return;
            }
            boolean z7 = z6 && i5 == 0;
            int i9 = -1;
            int i10 = -1;
            for (int i11 = 0; i11 < i7; i11++) {
                int i12 = z5 ? (i7 - 1) - i11 : i11;
                if (this.f23183n + i12 >= g.this.f23169y1) {
                    break;
                }
                e eVar3 = g.this.f23168x1[this.f23183n + i12];
                if (eVar3 != null && eVar3.V() == 0) {
                    if (i9 == -1) {
                        i9 = i11;
                    }
                    i10 = i11;
                }
            }
            e eVar4 = null;
            if (this.f23170a != 0) {
                e eVar5 = this.f23171b;
                eVar5.N0(g.this.f23145a1);
                int i13 = this.f23177h;
                if (i5 > 0) {
                    i13 += g.this.f23157m1;
                }
                if (z5) {
                    eVar5.f23046Q.a(this.f23175f, i13);
                    if (z6) {
                        eVar5.f23044O.a(this.f23173d, this.f23179j);
                    }
                    if (i5 > 0) {
                        this.f23175f.f23002d.f23044O.a(eVar5.f23046Q, 0);
                    }
                } else {
                    eVar5.f23044O.a(this.f23173d, i13);
                    if (z6) {
                        eVar5.f23046Q.a(this.f23175f, this.f23179j);
                    }
                    if (i5 > 0) {
                        this.f23173d.f23002d.f23046Q.a(eVar5.f23044O, 0);
                    }
                }
                for (int i14 = 0; i14 < i7 && this.f23183n + i14 < g.this.f23169y1; i14++) {
                    e eVar6 = g.this.f23168x1[this.f23183n + i14];
                    if (eVar6 != null) {
                        if (i14 == 0) {
                            eVar6.k(eVar6.f23045P, this.f23174e, this.f23178i);
                            int i15 = g.this.f23146b1;
                            float f7 = g.this.f23152h1;
                            if (this.f23183n == 0 && g.this.f23148d1 != -1) {
                                i15 = g.this.f23148d1;
                                f7 = g.this.f23154j1;
                            } else if (z6 && g.this.f23150f1 != -1) {
                                i15 = g.this.f23150f1;
                                f7 = g.this.f23156l1;
                            }
                            eVar6.e1(i15);
                            eVar6.d1(f7);
                        }
                        if (i14 == i7 - 1) {
                            eVar6.k(eVar6.f23047R, this.f23176g, this.f23180k);
                        }
                        if (eVar4 != null) {
                            eVar6.f23045P.a(eVar4.f23047R, g.this.f23158n1);
                            if (i14 == i9) {
                                eVar6.f23045P.u(this.f23178i);
                            }
                            eVar4.f23047R.a(eVar6.f23045P, 0);
                            if (i14 == i10 + 1) {
                                eVar4.f23047R.u(this.f23180k);
                            }
                        }
                        if (eVar6 == eVar5) {
                            eVar4 = eVar6;
                        } else if (z5) {
                            int i16 = g.this.f23159o1;
                            if (i16 == 0) {
                                eVar6.f23046Q.a(eVar5.f23046Q, 0);
                            } else if (i16 == 1) {
                                eVar6.f23044O.a(eVar5.f23044O, 0);
                            } else if (i16 == 2) {
                                eVar6.f23044O.a(eVar5.f23044O, 0);
                                eVar6.f23046Q.a(eVar5.f23046Q, 0);
                            }
                            eVar4 = eVar6;
                        } else {
                            int i17 = g.this.f23159o1;
                            if (i17 == 0) {
                                eVar6.f23044O.a(eVar5.f23044O, 0);
                            } else if (i17 == 1) {
                                eVar6.f23046Q.a(eVar5.f23046Q, 0);
                            } else if (i17 == 2) {
                                if (z7) {
                                    eVar6.f23044O.a(this.f23173d, this.f23177h);
                                    eVar6.f23046Q.a(this.f23175f, this.f23179j);
                                } else {
                                    eVar6.f23044O.a(eVar5.f23044O, 0);
                                    eVar6.f23046Q.a(eVar5.f23046Q, 0);
                                }
                            }
                            eVar4 = eVar6;
                        }
                    }
                }
                return;
            }
            e eVar7 = this.f23171b;
            eVar7.e1(g.this.f23146b1);
            int i18 = this.f23178i;
            if (i5 > 0) {
                i18 += g.this.f23158n1;
            }
            eVar7.f23045P.a(this.f23174e, i18);
            if (z6) {
                eVar7.f23047R.a(this.f23176g, this.f23180k);
            }
            if (i5 > 0) {
                this.f23174e.f23002d.f23047R.a(eVar7.f23045P, 0);
            }
            char c7 = 3;
            if (g.this.f23160p1 != 3 || eVar7.Z()) {
                eVar = eVar7;
            } else {
                for (int i19 = 0; i19 < i7; i19++) {
                    int i20 = z5 ? (i7 - 1) - i19 : i19;
                    if (this.f23183n + i20 >= g.this.f23169y1) {
                        break;
                    }
                    eVar = g.this.f23168x1[this.f23183n + i20];
                    if (eVar.Z()) {
                        break;
                    }
                }
                eVar = eVar7;
            }
            int i21 = 0;
            while (i21 < i7) {
                int i22 = z5 ? (i7 - 1) - i21 : i21;
                if (this.f23183n + i22 >= g.this.f23169y1) {
                    return;
                }
                e eVar8 = g.this.f23168x1[this.f23183n + i22];
                if (eVar8 == null) {
                    eVar8 = eVar4;
                    c6 = c7;
                } else {
                    if (i21 == 0) {
                        i6 = 1;
                        eVar8.k(eVar8.f23044O, this.f23173d, this.f23177h);
                    } else {
                        i6 = 1;
                    }
                    if (i22 == 0) {
                        int i23 = g.this.f23145a1;
                        float f8 = g.this.f23151g1;
                        if (z5) {
                            f8 = 1.0f - f8;
                        }
                        if (this.f23183n != 0 || g.this.f23147c1 == -1) {
                            if (z6 && g.this.f23149e1 != -1) {
                                i23 = g.this.f23149e1;
                                if (z5) {
                                    f6 = g.this.f23155k1;
                                    f5 = 1.0f - f6;
                                    f8 = f5;
                                } else {
                                    f5 = g.this.f23155k1;
                                    f8 = f5;
                                }
                            }
                            eVar8.N0(i23);
                            eVar8.M0(f8);
                        } else {
                            i23 = g.this.f23147c1;
                            if (z5) {
                                f6 = g.this.f23153i1;
                                f5 = 1.0f - f6;
                                f8 = f5;
                                eVar8.N0(i23);
                                eVar8.M0(f8);
                            } else {
                                f5 = g.this.f23153i1;
                                f8 = f5;
                                eVar8.N0(i23);
                                eVar8.M0(f8);
                            }
                        }
                    }
                    if (i21 == i7 - 1) {
                        eVar8.k(eVar8.f23046Q, this.f23175f, this.f23179j);
                    }
                    if (eVar4 != null) {
                        eVar8.f23044O.a(eVar4.f23046Q, g.this.f23157m1);
                        if (i21 == i9) {
                            eVar8.f23044O.u(this.f23177h);
                        }
                        eVar4.f23046Q.a(eVar8.f23044O, 0);
                        if (i21 == i10 + 1) {
                            eVar4.f23046Q.u(this.f23179j);
                        }
                    }
                    if (eVar8 != eVar7) {
                        c6 = 3;
                        if (g.this.f23160p1 == 3 && eVar.Z() && eVar8 != eVar && eVar8.Z()) {
                            eVar8.f23048S.a(eVar.f23048S, 0);
                        } else {
                            int i24 = g.this.f23160p1;
                            if (i24 == 0) {
                                eVar8.f23045P.a(eVar7.f23045P, 0);
                            } else if (i24 == i6) {
                                eVar8.f23047R.a(eVar7.f23047R, 0);
                            } else if (z7) {
                                eVar8.f23045P.a(this.f23174e, this.f23178i);
                                eVar8.f23047R.a(this.f23176g, this.f23180k);
                            } else {
                                eVar8.f23045P.a(eVar7.f23045P, 0);
                                eVar8.f23047R.a(eVar7.f23047R, 0);
                            }
                        }
                    } else {
                        c6 = 3;
                    }
                }
                i21++;
                c7 = c6;
                eVar4 = eVar8;
            }
        }

        public int e() {
            return this.f23170a == 1 ? this.f23182m - g.this.f23158n1 : this.f23182m;
        }

        public int f() {
            return this.f23170a == 0 ? this.f23181l - g.this.f23157m1 : this.f23181l;
        }

        public void g(int i5) {
            int i6 = this.f23185p;
            if (i6 == 0) {
                return;
            }
            int i7 = this.f23184o;
            int i8 = i5 / i6;
            for (int i9 = 0; i9 < i7 && this.f23183n + i9 < g.this.f23169y1; i9++) {
                e eVar = g.this.f23168x1[this.f23183n + i9];
                if (this.f23170a == 0) {
                    if (eVar != null && eVar.A() == e.b.MATCH_CONSTRAINT && eVar.f23100w == 0) {
                        g.this.D1(eVar, e.b.FIXED, i8, eVar.T(), eVar.x());
                    }
                } else if (eVar != null && eVar.T() == e.b.MATCH_CONSTRAINT && eVar.f23102x == 0) {
                    int i10 = i8;
                    g.this.D1(eVar, eVar.A(), eVar.W(), e.b.FIXED, i10);
                    i8 = i10;
                }
            }
            h();
        }

        public void i(int i5) {
            this.f23183n = i5;
        }

        public void j(int i5, d dVar, d dVar2, d dVar3, d dVar4, int i6, int i7, int i8, int i9, int i10) {
            this.f23170a = i5;
            this.f23173d = dVar;
            this.f23174e = dVar2;
            this.f23175f = dVar3;
            this.f23176g = dVar4;
            this.f23177h = i6;
            this.f23178i = i7;
            this.f23179j = i8;
            this.f23180k = i9;
            this.f23186q = i10;
        }
    }

    private void j2(boolean z5) {
        e eVar;
        float f5;
        int i5;
        if (this.f23167w1 == null || this.f23166v1 == null || this.f23165u1 == null) {
            return;
        }
        for (int i6 = 0; i6 < this.f23169y1; i6++) {
            this.f23168x1[i6].u0();
        }
        int[] iArr = this.f23167w1;
        int i7 = iArr[0];
        int i8 = iArr[1];
        float f6 = this.f23151g1;
        e eVar2 = null;
        int i9 = 0;
        while (i9 < i7) {
            if (z5) {
                i5 = (i7 - i9) - 1;
                f5 = 1.0f - this.f23151g1;
            } else {
                f5 = f6;
                i5 = i9;
            }
            e eVar3 = this.f23166v1[i5];
            if (eVar3 != null && eVar3.V() != 8) {
                if (i9 == 0) {
                    eVar3.k(eVar3.f23044O, this.f23044O, z1());
                    eVar3.N0(this.f23145a1);
                    eVar3.M0(f5);
                }
                if (i9 == i7 - 1) {
                    eVar3.k(eVar3.f23046Q, this.f23046Q, A1());
                }
                if (i9 > 0 && eVar2 != null) {
                    eVar3.k(eVar3.f23044O, eVar2.f23046Q, this.f23157m1);
                    eVar2.k(eVar2.f23046Q, eVar3.f23044O, 0);
                }
                eVar2 = eVar3;
            }
            i9++;
            f6 = f5;
        }
        for (int i10 = 0; i10 < i8; i10++) {
            e eVar4 = this.f23165u1[i10];
            if (eVar4 != null && eVar4.V() != 8) {
                if (i10 == 0) {
                    eVar4.k(eVar4.f23045P, this.f23045P, B1());
                    eVar4.e1(this.f23146b1);
                    eVar4.d1(this.f23152h1);
                }
                if (i10 == i8 - 1) {
                    eVar4.k(eVar4.f23047R, this.f23047R, y1());
                }
                if (i10 > 0 && eVar2 != null) {
                    eVar4.k(eVar4.f23045P, eVar2.f23047R, this.f23158n1);
                    eVar2.k(eVar2.f23047R, eVar4.f23045P, 0);
                }
                eVar2 = eVar4;
            }
        }
        for (int i11 = 0; i11 < i7; i11++) {
            for (int i12 = 0; i12 < i8; i12++) {
                int i13 = (i12 * i7) + i11;
                if (this.f23163s1 == 1) {
                    i13 = (i11 * i8) + i12;
                }
                e[] eVarArr = this.f23168x1;
                if (i13 < eVarArr.length && (eVar = eVarArr[i13]) != null && eVar.V() != 8) {
                    e eVar5 = this.f23166v1[i11];
                    e eVar6 = this.f23165u1[i12];
                    if (eVar != eVar5) {
                        eVar.k(eVar.f23044O, eVar5.f23044O, 0);
                        eVar.k(eVar.f23046Q, eVar5.f23046Q, 0);
                    }
                    if (eVar != eVar6) {
                        eVar.k(eVar.f23045P, eVar6.f23045P, 0);
                        eVar.k(eVar.f23047R, eVar6.f23047R, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int k2(e eVar, int i5) {
        e eVar2;
        if (eVar == null) {
            return 0;
        }
        if (eVar.T() == e.b.MATCH_CONSTRAINT) {
            int i6 = eVar.f23102x;
            if (i6 == 0) {
                return 0;
            }
            if (i6 == 2) {
                int i7 = (int) (eVar.f23028E * i5);
                if (i7 != eVar.x()) {
                    eVar.Y0(true);
                    D1(eVar, eVar.A(), eVar.W(), e.b.FIXED, i7);
                }
                return i7;
            }
            eVar2 = eVar;
            if (i6 == 1) {
                return eVar2.x();
            }
            if (i6 == 3) {
                return (int) ((eVar2.W() * eVar2.f23063d0) + 0.5f);
            }
        } else {
            eVar2 = eVar;
        }
        return eVar2.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int l2(e eVar, int i5) {
        e eVar2;
        if (eVar == null) {
            return 0;
        }
        if (eVar.A() == e.b.MATCH_CONSTRAINT) {
            int i6 = eVar.f23100w;
            if (i6 == 0) {
                return 0;
            }
            if (i6 == 2) {
                int i7 = (int) (eVar.f23022B * i5);
                if (i7 != eVar.W()) {
                    eVar.Y0(true);
                    D1(eVar, e.b.FIXED, i7, eVar.T(), eVar.x());
                }
                return i7;
            }
            eVar2 = eVar;
            if (i6 == 1) {
                return eVar2.W();
            }
            if (i6 == 3) {
                return (int) ((eVar2.x() * eVar2.f23063d0) + 0.5f);
            }
        } else {
            eVar2 = eVar;
        }
        return eVar2.W();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m2(v.e[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v.g.m2(v.e[], int, int, int, int[]):void");
    }

    private void n2(e[] eVarArr, int i5, int i6, int i7, int[] iArr) {
        int i8;
        g gVar;
        int i9;
        d dVar;
        int i10;
        g gVar2 = this;
        if (i5 == 0) {
            return;
        }
        gVar2.f23164t1.clear();
        int i11 = i7;
        a aVar = gVar2.new a(i6, gVar2.f23044O, gVar2.f23045P, gVar2.f23046Q, gVar2.f23047R, i11);
        gVar2.f23164t1.add(aVar);
        if (i6 == 0) {
            i8 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i13 < i5) {
                e eVar = eVarArr[i13];
                int iL2 = gVar2.l2(eVar, i11);
                if (eVar.A() == e.b.MATCH_CONSTRAINT) {
                    i8++;
                }
                int i14 = i8;
                boolean z5 = (i12 == i11 || (gVar2.f23157m1 + i12) + iL2 > i11) && aVar.f23171b != null;
                if (!z5 && i13 > 0 && (i10 = gVar2.f23162r1) > 0 && i13 % i10 == 0) {
                    z5 = true;
                }
                if (z5) {
                    aVar = gVar2.new a(i6, gVar2.f23044O, gVar2.f23045P, gVar2.f23046Q, gVar2.f23047R, i11);
                    aVar.i(i13);
                    gVar2.f23164t1.add(aVar);
                } else {
                    if (i13 > 0) {
                        i12 += gVar2.f23157m1 + iL2;
                    }
                    aVar.b(eVar);
                    i13++;
                    i8 = i14;
                }
                i12 = iL2;
                aVar.b(eVar);
                i13++;
                i8 = i14;
            }
        } else {
            i8 = 0;
            int i15 = 0;
            int i16 = 0;
            while (i16 < i5) {
                e eVar2 = eVarArr[i16];
                int iK2 = gVar2.k2(eVar2, i11);
                if (eVar2.T() == e.b.MATCH_CONSTRAINT) {
                    i8++;
                }
                int i17 = i8;
                boolean z6 = (i15 == i11 || (gVar2.f23158n1 + i15) + iK2 > i11) && aVar.f23171b != null;
                if (!z6 && i16 > 0 && (i9 = gVar2.f23162r1) > 0 && i16 % i9 == 0) {
                    z6 = true;
                }
                if (z6) {
                    aVar = gVar2.new a(i6, gVar2.f23044O, gVar2.f23045P, gVar2.f23046Q, gVar2.f23047R, i11);
                    gVar = gVar2;
                    aVar.i(i16);
                    gVar.f23164t1.add(aVar);
                } else {
                    gVar = gVar2;
                    if (i16 > 0) {
                        i15 += gVar.f23158n1 + iK2;
                    }
                    aVar.b(eVar2);
                    i16++;
                    i11 = i7;
                    i8 = i17;
                    gVar2 = gVar;
                }
                i15 = iK2;
                aVar.b(eVar2);
                i16++;
                i11 = i7;
                i8 = i17;
                gVar2 = gVar;
            }
        }
        g gVar3 = gVar2;
        int size = gVar3.f23164t1.size();
        d dVar2 = gVar3.f23044O;
        d dVar3 = gVar3.f23045P;
        d dVar4 = gVar3.f23046Q;
        d dVar5 = gVar3.f23047R;
        int iZ1 = gVar3.z1();
        int iB1 = gVar3.B1();
        int iA1 = gVar3.A1();
        int iY1 = gVar3.y1();
        e.b bVarA = gVar3.A();
        e.b bVar = e.b.WRAP_CONTENT;
        boolean z7 = bVarA == bVar || gVar3.T() == bVar;
        if (i8 > 0 && z7) {
            for (int i18 = 0; i18 < size; i18++) {
                a aVar2 = gVar3.f23164t1.get(i18);
                if (i6 == 0) {
                    aVar2.g(i7 - aVar2.f());
                } else {
                    aVar2.g(i7 - aVar2.e());
                }
            }
        }
        d dVar6 = dVar2;
        int iY12 = iY1;
        int i19 = 0;
        int iA12 = iA1;
        int i20 = iB1;
        int i21 = iZ1;
        d dVar7 = dVar5;
        d dVar8 = dVar4;
        d dVar9 = dVar3;
        int i22 = 0;
        for (int i23 = 0; i23 < size; i23++) {
            a aVar3 = gVar3.f23164t1.get(i23);
            if (i6 == 0) {
                if (i23 < size - 1) {
                    dVar7 = gVar3.f23164t1.get(i23 + 1).f23171b.f23045P;
                    iY12 = 0;
                } else {
                    dVar7 = gVar3.f23047R;
                    iY12 = gVar3.y1();
                }
                d dVar10 = aVar3.f23171b.f23047R;
                int i24 = i22;
                aVar3.j(i6, dVar6, dVar9, dVar8, dVar7, i21, i20, iA12, iY12, i7);
                int iMax = Math.max(i19, aVar3.f());
                int iE = aVar3.e() + i24;
                if (i23 > 0) {
                    iE += gVar3.f23158n1;
                }
                i22 = iE;
                i19 = iMax;
                dVar9 = dVar10;
                i20 = 0;
            } else {
                int i25 = i19;
                int i26 = i22;
                if (i23 < size - 1) {
                    dVar = gVar3.f23164t1.get(i23 + 1).f23171b.f23044O;
                    iA12 = 0;
                } else {
                    dVar = gVar3.f23046Q;
                    iA12 = gVar3.A1();
                }
                dVar8 = dVar;
                d dVar11 = aVar3.f23171b.f23046Q;
                aVar3.j(i6, dVar6, dVar9, dVar8, dVar7, i21, i20, iA12, iY12, i7);
                int iF = aVar3.f() + i25;
                int iMax2 = Math.max(i26, aVar3.e());
                if (i23 > 0) {
                    iF += gVar3.f23157m1;
                }
                int i27 = iF;
                i22 = iMax2;
                i19 = i27;
                i21 = 0;
                dVar6 = dVar11;
            }
        }
        iArr[0] = i19;
        iArr[1] = i22;
    }

    private void o2(e[] eVarArr, int i5, int i6, int i7, int[] iArr) {
        int i8;
        g gVar;
        int i9;
        boolean z5;
        d dVar;
        int i10;
        g gVar2 = this;
        if (i5 == 0) {
            return;
        }
        gVar2.f23164t1.clear();
        int i11 = i7;
        a aVar = gVar2.new a(i6, gVar2.f23044O, gVar2.f23045P, gVar2.f23046Q, gVar2.f23047R, i11);
        gVar2.f23164t1.add(aVar);
        boolean z6 = true;
        if (i6 == 0) {
            int i12 = 0;
            i8 = 0;
            int i13 = 0;
            int i14 = 0;
            while (i14 < i5) {
                int i15 = i12 + 1;
                e eVar = eVarArr[i14];
                int iL2 = gVar2.l2(eVar, i11);
                if (eVar.A() == e.b.MATCH_CONSTRAINT) {
                    i8++;
                }
                int i16 = i8;
                boolean z7 = (i13 == i11 || (gVar2.f23157m1 + i13) + iL2 > i11) && aVar.f23171b != null;
                if (!z7 && i14 > 0 && (i10 = gVar2.f23162r1) > 0 && i15 > i10) {
                    z7 = true;
                }
                if (z7) {
                    aVar = gVar2.new a(i6, gVar2.f23044O, gVar2.f23045P, gVar2.f23046Q, gVar2.f23047R, i11);
                    aVar.i(i14);
                    gVar2.f23164t1.add(aVar);
                    i12 = i15;
                    i13 = iL2;
                } else {
                    i13 = i14 > 0 ? i13 + gVar2.f23157m1 + iL2 : iL2;
                    i12 = 0;
                }
                aVar.b(eVar);
                i14++;
                i8 = i16;
            }
        } else {
            int i17 = 0;
            i8 = 0;
            int i18 = 0;
            while (i18 < i5) {
                e eVar2 = eVarArr[i18];
                int iK2 = gVar2.k2(eVar2, i11);
                if (eVar2.T() == e.b.MATCH_CONSTRAINT) {
                    i8++;
                }
                int i19 = i8;
                boolean z8 = (i17 == i11 || (gVar2.f23158n1 + i17) + iK2 > i11) && aVar.f23171b != null;
                if (!z8 && i18 > 0 && (i9 = gVar2.f23162r1) > 0 && i9 < 0) {
                    z8 = true;
                }
                if (z8) {
                    aVar = gVar2.new a(i6, gVar2.f23044O, gVar2.f23045P, gVar2.f23046Q, gVar2.f23047R, i11);
                    gVar = gVar2;
                    aVar.i(i18);
                    gVar.f23164t1.add(aVar);
                } else {
                    gVar = gVar2;
                    if (i18 > 0) {
                        i17 += gVar.f23158n1 + iK2;
                    }
                    aVar.b(eVar2);
                    i18++;
                    i11 = i7;
                    i8 = i19;
                    gVar2 = gVar;
                }
                i17 = iK2;
                aVar.b(eVar2);
                i18++;
                i11 = i7;
                i8 = i19;
                gVar2 = gVar;
            }
        }
        g gVar3 = gVar2;
        int size = gVar3.f23164t1.size();
        d dVar2 = gVar3.f23044O;
        d dVar3 = gVar3.f23045P;
        d dVar4 = gVar3.f23046Q;
        d dVar5 = gVar3.f23047R;
        int iZ1 = gVar3.z1();
        int iB1 = gVar3.B1();
        int iA1 = gVar3.A1();
        int iY1 = gVar3.y1();
        e.b bVarA = gVar3.A();
        e.b bVar = e.b.WRAP_CONTENT;
        boolean z9 = bVarA == bVar || gVar3.T() == bVar;
        if (i8 > 0 && z9) {
            for (int i20 = 0; i20 < size; i20++) {
                a aVar2 = gVar3.f23164t1.get(i20);
                if (i6 == 0) {
                    aVar2.g(i7 - aVar2.f());
                } else {
                    aVar2.g(i7 - aVar2.e());
                }
            }
        }
        d dVar6 = dVar3;
        int iY12 = iY1;
        int i21 = 0;
        int i22 = 0;
        int iA12 = iA1;
        int i23 = iB1;
        int i24 = iZ1;
        d dVar7 = dVar5;
        d dVar8 = dVar4;
        d dVar9 = dVar2;
        int i25 = 0;
        while (i22 < size) {
            a aVar3 = gVar3.f23164t1.get(i22);
            if (i6 == 0) {
                if (i22 < size - 1) {
                    dVar7 = gVar3.f23164t1.get(i22 + 1).f23171b.f23045P;
                    iY12 = 0;
                } else {
                    dVar7 = gVar3.f23047R;
                    iY12 = gVar3.y1();
                }
                z5 = z6;
                d dVar10 = aVar3.f23171b.f23047R;
                int i26 = i21;
                aVar3.j(i6, dVar9, dVar6, dVar8, dVar7, i24, i23, iA12, iY12, i7);
                int iMax = Math.max(i25, aVar3.f());
                int iE = aVar3.e() + i26;
                if (i22 > 0) {
                    iE += gVar3.f23158n1;
                }
                i21 = iE;
                i25 = iMax;
                dVar6 = dVar10;
                i23 = 0;
            } else {
                int i27 = i25;
                z5 = z6;
                int i28 = i21;
                if (i22 < size - 1) {
                    dVar = gVar3.f23164t1.get(i22 + 1).f23171b.f23044O;
                    iA12 = 0;
                } else {
                    dVar = gVar3.f23046Q;
                    iA12 = gVar3.A1();
                }
                dVar8 = dVar;
                d dVar11 = aVar3.f23171b.f23046Q;
                aVar3.j(i6, dVar9, dVar6, dVar8, dVar7, i24, i23, iA12, iY12, i7);
                int iF = aVar3.f() + i27;
                int iMax2 = Math.max(i28, aVar3.e());
                if (i22 > 0) {
                    iF += gVar3.f23157m1;
                }
                int i29 = iF;
                i21 = iMax2;
                i25 = i29;
                i24 = 0;
                dVar9 = dVar11;
            }
            i22++;
            z6 = z5;
        }
        iArr[0] = i25;
        iArr[z6 ? 1 : 0] = i21;
    }

    private void p2(e[] eVarArr, int i5, int i6, int i7, int[] iArr) {
        a aVar;
        if (i5 == 0) {
            return;
        }
        if (this.f23164t1.size() == 0) {
            aVar = new a(i6, this.f23044O, this.f23045P, this.f23046Q, this.f23047R, i7);
            this.f23164t1.add(aVar);
        } else {
            a aVar2 = this.f23164t1.get(0);
            aVar2.c();
            aVar2.j(i6, this.f23044O, this.f23045P, this.f23046Q, this.f23047R, z1(), B1(), A1(), y1(), i7);
            aVar = aVar2;
        }
        for (int i8 = 0; i8 < i5; i8++) {
            aVar.b(eVarArr[i8]);
        }
        iArr[0] = aVar.f();
        iArr[1] = aVar.e();
    }

    public void A2(float f5) {
        this.f23156l1 = f5;
    }

    public void B2(int i5) {
        this.f23150f1 = i5;
    }

    @Override // v.l
    public void C1(int i5, int i6, int i7, int i8) {
        int i9;
        e[] eVarArr;
        if (this.f23198M0 > 0 && !E1()) {
            H1(0, 0);
            G1(false);
            return;
        }
        int iZ1 = z1();
        int iA1 = A1();
        int iB1 = B1();
        int iY1 = y1();
        int[] iArr = new int[2];
        int i10 = (i6 - iZ1) - iA1;
        int i11 = this.f23163s1;
        if (i11 == 1) {
            i10 = (i8 - iB1) - iY1;
        }
        int i12 = i10;
        if (i11 == 0) {
            if (this.f23145a1 == -1) {
                this.f23145a1 = 0;
            }
            if (this.f23146b1 == -1) {
                this.f23146b1 = 0;
            }
        } else {
            if (this.f23145a1 == -1) {
                this.f23145a1 = 0;
            }
            if (this.f23146b1 == -1) {
                this.f23146b1 = 0;
            }
        }
        e[] eVarArr2 = this.f23197L0;
        int i13 = 0;
        int i14 = 0;
        while (true) {
            i9 = this.f23198M0;
            if (i13 >= i9) {
                break;
            }
            if (this.f23197L0[i13].V() == 8) {
                i14++;
            }
            i13++;
        }
        if (i14 > 0) {
            e[] eVarArr3 = new e[i9 - i14];
            int i15 = 0;
            i9 = 0;
            while (i15 < this.f23198M0) {
                e eVar = this.f23197L0[i15];
                e[] eVarArr4 = eVarArr3;
                if (eVar.V() != 8) {
                    eVarArr4[i9] = eVar;
                    i9++;
                }
                i15++;
                eVarArr3 = eVarArr4;
            }
            eVarArr = eVarArr3;
        } else {
            eVarArr = eVarArr2;
        }
        int i16 = i9;
        this.f23168x1 = eVarArr;
        this.f23169y1 = i16;
        int i17 = this.f23161q1;
        if (i17 == 0) {
            p2(eVarArr, i16, this.f23163s1, i12, iArr);
        } else if (i17 == 1) {
            n2(eVarArr, i16, this.f23163s1, i12, iArr);
        } else if (i17 == 2) {
            m2(eVarArr, i16, this.f23163s1, i12, iArr);
        } else if (i17 == 3) {
            o2(eVarArr, i16, this.f23163s1, i12, iArr);
        }
        int iMin = iArr[0] + iZ1 + iA1;
        int iMin2 = iArr[1] + iB1 + iY1;
        if (i5 == 1073741824) {
            iMin = i6;
        } else if (i5 == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, i6);
        } else if (i5 != 0) {
            iMin = 0;
        }
        if (i7 == 1073741824) {
            iMin2 = i8;
        } else if (i7 == Integer.MIN_VALUE) {
            iMin2 = Math.min(iMin2, i8);
        } else if (i7 != 0) {
            iMin2 = 0;
        }
        H1(iMin, iMin2);
        k1(iMin);
        L0(iMin2);
        G1(this.f23198M0 > 0);
    }

    public void C2(int i5) {
        this.f23162r1 = i5;
    }

    public void D2(int i5) {
        this.f23163s1 = i5;
    }

    public void E2(int i5) {
        this.f23160p1 = i5;
    }

    public void F2(float f5) {
        this.f23152h1 = f5;
    }

    public void G2(int i5) {
        this.f23158n1 = i5;
    }

    public void H2(int i5) {
        this.f23146b1 = i5;
    }

    public void I2(int i5) {
        this.f23161q1 = i5;
    }

    @Override // v.e
    public void g(s.d dVar, boolean z5) {
        super.g(dVar, z5);
        boolean z6 = K() != null && ((f) K()).P1();
        int i5 = this.f23161q1;
        if (i5 != 0) {
            if (i5 == 1) {
                int size = this.f23164t1.size();
                int i6 = 0;
                while (i6 < size) {
                    this.f23164t1.get(i6).d(z6, i6, i6 == size + (-1));
                    i6++;
                }
            } else if (i5 == 2) {
                j2(z6);
            } else if (i5 == 3) {
                int size2 = this.f23164t1.size();
                int i7 = 0;
                while (i7 < size2) {
                    this.f23164t1.get(i7).d(z6, i7, i7 == size2 + (-1));
                    i7++;
                }
            }
        } else if (this.f23164t1.size() > 0) {
            this.f23164t1.get(0).d(z6, 0, true);
        }
        G1(false);
    }

    public void q2(float f5) {
        this.f23153i1 = f5;
    }

    public void r2(int i5) {
        this.f23147c1 = i5;
    }

    public void s2(float f5) {
        this.f23154j1 = f5;
    }

    public void t2(int i5) {
        this.f23148d1 = i5;
    }

    public void u2(int i5) {
        this.f23159o1 = i5;
    }

    public void v2(float f5) {
        this.f23151g1 = f5;
    }

    public void w2(int i5) {
        this.f23157m1 = i5;
    }

    public void x2(int i5) {
        this.f23145a1 = i5;
    }

    public void y2(float f5) {
        this.f23155k1 = f5;
    }

    public void z2(int i5) {
        this.f23149e1 = i5;
    }
}
