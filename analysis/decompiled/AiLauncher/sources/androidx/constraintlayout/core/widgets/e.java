package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class e extends i {

    /* renamed from: H1, reason: collision with root package name */
    public ConstraintWidget[] f12123H1;

    /* renamed from: k1, reason: collision with root package name */
    public int f12125k1 = -1;

    /* renamed from: l1, reason: collision with root package name */
    public int f12126l1 = -1;

    /* renamed from: m1, reason: collision with root package name */
    public int f12127m1 = -1;

    /* renamed from: n1, reason: collision with root package name */
    public int f12128n1 = -1;

    /* renamed from: o1, reason: collision with root package name */
    public int f12129o1 = -1;

    /* renamed from: p1, reason: collision with root package name */
    public int f12130p1 = -1;

    /* renamed from: q1, reason: collision with root package name */
    public float f12131q1 = 0.5f;

    /* renamed from: r1, reason: collision with root package name */
    public float f12132r1 = 0.5f;

    /* renamed from: s1, reason: collision with root package name */
    public float f12133s1 = 0.5f;

    /* renamed from: t1, reason: collision with root package name */
    public float f12134t1 = 0.5f;

    /* renamed from: u1, reason: collision with root package name */
    public float f12135u1 = 0.5f;

    /* renamed from: v1, reason: collision with root package name */
    public float f12136v1 = 0.5f;

    /* renamed from: w1, reason: collision with root package name */
    public int f12137w1 = 0;

    /* renamed from: x1, reason: collision with root package name */
    public int f12138x1 = 0;

    /* renamed from: y1, reason: collision with root package name */
    public int f12139y1 = 2;

    /* renamed from: z1, reason: collision with root package name */
    public int f12140z1 = 2;

    /* renamed from: A1, reason: collision with root package name */
    public int f12116A1 = 0;

    /* renamed from: B1, reason: collision with root package name */
    public int f12117B1 = -1;

    /* renamed from: C1, reason: collision with root package name */
    public int f12118C1 = 0;

    /* renamed from: D1, reason: collision with root package name */
    public ArrayList<a> f12119D1 = new ArrayList<>();

    /* renamed from: E1, reason: collision with root package name */
    public ConstraintWidget[] f12120E1 = null;

    /* renamed from: F1, reason: collision with root package name */
    public ConstraintWidget[] f12121F1 = null;

    /* renamed from: G1, reason: collision with root package name */
    public int[] f12122G1 = null;

    /* renamed from: I1, reason: collision with root package name */
    public int f12124I1 = 0;

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f12141a;

        /* renamed from: d, reason: collision with root package name */
        public ConstraintAnchor f12144d;

        /* renamed from: e, reason: collision with root package name */
        public ConstraintAnchor f12145e;

        /* renamed from: f, reason: collision with root package name */
        public ConstraintAnchor f12146f;

        /* renamed from: g, reason: collision with root package name */
        public ConstraintAnchor f12147g;

        /* renamed from: h, reason: collision with root package name */
        public int f12148h;

        /* renamed from: i, reason: collision with root package name */
        public int f12149i;

        /* renamed from: j, reason: collision with root package name */
        public int f12150j;

        /* renamed from: k, reason: collision with root package name */
        public int f12151k;

        /* renamed from: q, reason: collision with root package name */
        public int f12157q;

        /* renamed from: b, reason: collision with root package name */
        public ConstraintWidget f12142b = null;

        /* renamed from: c, reason: collision with root package name */
        public int f12143c = 0;

        /* renamed from: l, reason: collision with root package name */
        public int f12152l = 0;

        /* renamed from: m, reason: collision with root package name */
        public int f12153m = 0;

        /* renamed from: n, reason: collision with root package name */
        public int f12154n = 0;

        /* renamed from: o, reason: collision with root package name */
        public int f12155o = 0;

        /* renamed from: p, reason: collision with root package name */
        public int f12156p = 0;

        public a(int i10, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i11) {
            this.f12148h = 0;
            this.f12149i = 0;
            this.f12150j = 0;
            this.f12151k = 0;
            this.f12157q = 0;
            this.f12141a = i10;
            this.f12144d = constraintAnchor;
            this.f12145e = constraintAnchor2;
            this.f12146f = constraintAnchor3;
            this.f12147g = constraintAnchor4;
            this.f12148h = e.this.E1();
            this.f12149i = e.this.G1();
            this.f12150j = e.this.F1();
            this.f12151k = e.this.D1();
            this.f12157q = i11;
        }

        public void b(ConstraintWidget constraintWidget) {
            if (this.f12141a == 0) {
                int iQ2 = e.this.q2(constraintWidget, this.f12157q);
                if (constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f12156p++;
                    iQ2 = 0;
                }
                this.f12152l += iQ2 + (constraintWidget.X() != 8 ? e.this.f12137w1 : 0);
                int iP2 = e.this.p2(constraintWidget, this.f12157q);
                if (this.f12142b == null || this.f12143c < iP2) {
                    this.f12142b = constraintWidget;
                    this.f12143c = iP2;
                    this.f12153m = iP2;
                }
            } else {
                int iQ22 = e.this.q2(constraintWidget, this.f12157q);
                int iP22 = e.this.p2(constraintWidget, this.f12157q);
                if (constraintWidget.V() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.f12156p++;
                    iP22 = 0;
                }
                this.f12153m += iP22 + (constraintWidget.X() != 8 ? e.this.f12138x1 : 0);
                if (this.f12142b == null || this.f12143c < iQ22) {
                    this.f12142b = constraintWidget;
                    this.f12143c = iQ22;
                    this.f12152l = iQ22;
                }
            }
            this.f12155o++;
        }

        public void c() {
            this.f12143c = 0;
            this.f12142b = null;
            this.f12152l = 0;
            this.f12153m = 0;
            this.f12154n = 0;
            this.f12155o = 0;
            this.f12156p = 0;
        }

        public void d(boolean z10, int i10, boolean z11) {
            ConstraintWidget constraintWidget;
            int i11;
            char c10;
            float f10;
            float f11;
            int i12 = this.f12155o;
            for (int i13 = 0; i13 < i12 && this.f12154n + i13 < e.this.f12124I1; i13++) {
                ConstraintWidget constraintWidget2 = e.this.f12123H1[this.f12154n + i13];
                if (constraintWidget2 != null) {
                    constraintWidget2.x0();
                }
            }
            if (i12 == 0 || this.f12142b == null) {
                return;
            }
            boolean z12 = z11 && i10 == 0;
            int i14 = -1;
            int i15 = -1;
            for (int i16 = 0; i16 < i12; i16++) {
                int i17 = z10 ? (i12 - 1) - i16 : i16;
                if (this.f12154n + i17 >= e.this.f12124I1) {
                    break;
                }
                ConstraintWidget constraintWidget3 = e.this.f12123H1[this.f12154n + i17];
                if (constraintWidget3 != null && constraintWidget3.X() == 0) {
                    if (i14 == -1) {
                        i14 = i16;
                    }
                    i15 = i16;
                }
            }
            ConstraintWidget constraintWidget4 = null;
            if (this.f12141a != 0) {
                ConstraintWidget constraintWidget5 = this.f12142b;
                constraintWidget5.S0(e.this.f12125k1);
                int i18 = this.f12148h;
                if (i10 > 0) {
                    i18 += e.this.f12137w1;
                }
                if (z10) {
                    constraintWidget5.f11968S.a(this.f12146f, i18);
                    if (z11) {
                        constraintWidget5.f11964Q.a(this.f12144d, this.f12150j);
                    }
                    if (i10 > 0) {
                        this.f12146f.f11925d.f11964Q.a(constraintWidget5.f11968S, 0);
                    }
                } else {
                    constraintWidget5.f11964Q.a(this.f12144d, i18);
                    if (z11) {
                        constraintWidget5.f11968S.a(this.f12146f, this.f12150j);
                    }
                    if (i10 > 0) {
                        this.f12144d.f11925d.f11968S.a(constraintWidget5.f11964Q, 0);
                    }
                }
                for (int i19 = 0; i19 < i12 && this.f12154n + i19 < e.this.f12124I1; i19++) {
                    ConstraintWidget constraintWidget6 = e.this.f12123H1[this.f12154n + i19];
                    if (constraintWidget6 != null) {
                        if (i19 == 0) {
                            constraintWidget6.l(constraintWidget6.f11966R, this.f12145e, this.f12149i);
                            int i20 = e.this.f12126l1;
                            float f12 = e.this.f12132r1;
                            if (this.f12154n == 0 && e.this.f12128n1 != -1) {
                                i20 = e.this.f12128n1;
                                f12 = e.this.f12134t1;
                            } else if (z11 && e.this.f12130p1 != -1) {
                                i20 = e.this.f12130p1;
                                f12 = e.this.f12136v1;
                            }
                            constraintWidget6.j1(i20);
                            constraintWidget6.i1(f12);
                        }
                        if (i19 == i12 - 1) {
                            constraintWidget6.l(constraintWidget6.f11970T, this.f12147g, this.f12151k);
                        }
                        if (constraintWidget4 != null) {
                            constraintWidget6.f11966R.a(constraintWidget4.f11970T, e.this.f12138x1);
                            if (i19 == i14) {
                                constraintWidget6.f11966R.u(this.f12149i);
                            }
                            constraintWidget4.f11970T.a(constraintWidget6.f11966R, 0);
                            if (i19 == i15 + 1) {
                                constraintWidget4.f11970T.u(this.f12151k);
                            }
                        }
                        if (constraintWidget6 == constraintWidget5) {
                            constraintWidget4 = constraintWidget6;
                        } else if (z10) {
                            int i21 = e.this.f12139y1;
                            if (i21 == 0) {
                                constraintWidget6.f11968S.a(constraintWidget5.f11968S, 0);
                            } else if (i21 == 1) {
                                constraintWidget6.f11964Q.a(constraintWidget5.f11964Q, 0);
                            } else if (i21 == 2) {
                                constraintWidget6.f11964Q.a(constraintWidget5.f11964Q, 0);
                                constraintWidget6.f11968S.a(constraintWidget5.f11968S, 0);
                            }
                            constraintWidget4 = constraintWidget6;
                        } else {
                            int i22 = e.this.f12139y1;
                            if (i22 == 0) {
                                constraintWidget6.f11964Q.a(constraintWidget5.f11964Q, 0);
                            } else if (i22 == 1) {
                                constraintWidget6.f11968S.a(constraintWidget5.f11968S, 0);
                            } else if (i22 == 2) {
                                if (z12) {
                                    constraintWidget6.f11964Q.a(this.f12144d, this.f12148h);
                                    constraintWidget6.f11968S.a(this.f12146f, this.f12150j);
                                } else {
                                    constraintWidget6.f11964Q.a(constraintWidget5.f11964Q, 0);
                                    constraintWidget6.f11968S.a(constraintWidget5.f11968S, 0);
                                }
                            }
                            constraintWidget4 = constraintWidget6;
                        }
                    }
                }
                return;
            }
            ConstraintWidget constraintWidget7 = this.f12142b;
            constraintWidget7.j1(e.this.f12126l1);
            int i23 = this.f12149i;
            if (i10 > 0) {
                i23 += e.this.f12138x1;
            }
            constraintWidget7.f11966R.a(this.f12145e, i23);
            if (z11) {
                constraintWidget7.f11970T.a(this.f12147g, this.f12151k);
            }
            if (i10 > 0) {
                this.f12145e.f11925d.f11970T.a(constraintWidget7.f11966R, 0);
            }
            char c11 = 3;
            if (e.this.f12140z1 != 3 || constraintWidget7.b0()) {
                constraintWidget = constraintWidget7;
            } else {
                for (int i24 = 0; i24 < i12; i24++) {
                    int i25 = z10 ? (i12 - 1) - i24 : i24;
                    if (this.f12154n + i25 >= e.this.f12124I1) {
                        break;
                    }
                    constraintWidget = e.this.f12123H1[this.f12154n + i25];
                    if (constraintWidget.b0()) {
                        break;
                    }
                }
                constraintWidget = constraintWidget7;
            }
            int i26 = 0;
            while (i26 < i12) {
                int i27 = z10 ? (i12 - 1) - i26 : i26;
                if (this.f12154n + i27 >= e.this.f12124I1) {
                    return;
                }
                ConstraintWidget constraintWidget8 = e.this.f12123H1[this.f12154n + i27];
                if (constraintWidget8 == null) {
                    constraintWidget8 = constraintWidget4;
                    c10 = c11;
                } else {
                    if (i26 == 0) {
                        i11 = 1;
                        constraintWidget8.l(constraintWidget8.f11964Q, this.f12144d, this.f12148h);
                    } else {
                        i11 = 1;
                    }
                    if (i27 == 0) {
                        int i28 = e.this.f12125k1;
                        float f13 = e.this.f12131q1;
                        if (z10) {
                            f13 = 1.0f - f13;
                        }
                        if (this.f12154n != 0 || e.this.f12127m1 == -1) {
                            if (z11 && e.this.f12129o1 != -1) {
                                i28 = e.this.f12129o1;
                                if (z10) {
                                    f11 = e.this.f12135u1;
                                    f10 = 1.0f - f11;
                                    f13 = f10;
                                } else {
                                    f10 = e.this.f12135u1;
                                    f13 = f10;
                                }
                            }
                            constraintWidget8.S0(i28);
                            constraintWidget8.R0(f13);
                        } else {
                            i28 = e.this.f12127m1;
                            if (z10) {
                                f11 = e.this.f12133s1;
                                f10 = 1.0f - f11;
                                f13 = f10;
                                constraintWidget8.S0(i28);
                                constraintWidget8.R0(f13);
                            } else {
                                f10 = e.this.f12133s1;
                                f13 = f10;
                                constraintWidget8.S0(i28);
                                constraintWidget8.R0(f13);
                            }
                        }
                    }
                    if (i26 == i12 - 1) {
                        constraintWidget8.l(constraintWidget8.f11968S, this.f12146f, this.f12150j);
                    }
                    if (constraintWidget4 != null) {
                        constraintWidget8.f11964Q.a(constraintWidget4.f11968S, e.this.f12137w1);
                        if (i26 == i14) {
                            constraintWidget8.f11964Q.u(this.f12148h);
                        }
                        constraintWidget4.f11968S.a(constraintWidget8.f11964Q, 0);
                        if (i26 == i15 + 1) {
                            constraintWidget4.f11968S.u(this.f12150j);
                        }
                    }
                    if (constraintWidget8 != constraintWidget7) {
                        c10 = 3;
                        if (e.this.f12140z1 == 3 && constraintWidget.b0() && constraintWidget8 != constraintWidget && constraintWidget8.b0()) {
                            constraintWidget8.f11972U.a(constraintWidget.f11972U, 0);
                        } else {
                            int i29 = e.this.f12140z1;
                            if (i29 == 0) {
                                constraintWidget8.f11966R.a(constraintWidget7.f11966R, 0);
                            } else if (i29 == i11) {
                                constraintWidget8.f11970T.a(constraintWidget7.f11970T, 0);
                            } else if (z12) {
                                constraintWidget8.f11966R.a(this.f12145e, this.f12149i);
                                constraintWidget8.f11970T.a(this.f12147g, this.f12151k);
                            } else {
                                constraintWidget8.f11966R.a(constraintWidget7.f11966R, 0);
                                constraintWidget8.f11970T.a(constraintWidget7.f11970T, 0);
                            }
                        }
                    } else {
                        c10 = 3;
                    }
                }
                i26++;
                c11 = c10;
                constraintWidget4 = constraintWidget8;
            }
        }

        public int e() {
            return this.f12141a == 1 ? this.f12153m - e.this.f12138x1 : this.f12153m;
        }

        public int f() {
            return this.f12141a == 0 ? this.f12152l - e.this.f12137w1 : this.f12152l;
        }

        public void g(int i10) {
            int i11 = this.f12156p;
            if (i11 == 0) {
                return;
            }
            int i12 = this.f12155o;
            int i13 = i10 / i11;
            for (int i14 = 0; i14 < i12 && this.f12154n + i14 < e.this.f12124I1; i14++) {
                ConstraintWidget constraintWidget = e.this.f12123H1[this.f12154n + i14];
                if (this.f12141a == 0) {
                    if (constraintWidget != null && constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f12022w == 0) {
                        e.this.I1(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i13, constraintWidget.V(), constraintWidget.z());
                    }
                } else if (constraintWidget != null && constraintWidget.V() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.f12024x == 0) {
                    int i15 = i13;
                    e.this.I1(constraintWidget, constraintWidget.C(), constraintWidget.Y(), ConstraintWidget.DimensionBehaviour.FIXED, i15);
                    i13 = i15;
                }
            }
            h();
        }

        public final void h() {
            this.f12152l = 0;
            this.f12153m = 0;
            this.f12142b = null;
            this.f12143c = 0;
            int i10 = this.f12155o;
            for (int i11 = 0; i11 < i10 && this.f12154n + i11 < e.this.f12124I1; i11++) {
                ConstraintWidget constraintWidget = e.this.f12123H1[this.f12154n + i11];
                if (this.f12141a == 0) {
                    int iY = constraintWidget.Y();
                    int i12 = e.this.f12137w1;
                    if (constraintWidget.X() == 8) {
                        i12 = 0;
                    }
                    this.f12152l += iY + i12;
                    int iP2 = e.this.p2(constraintWidget, this.f12157q);
                    if (this.f12142b == null || this.f12143c < iP2) {
                        this.f12142b = constraintWidget;
                        this.f12143c = iP2;
                        this.f12153m = iP2;
                    }
                } else {
                    int iQ2 = e.this.q2(constraintWidget, this.f12157q);
                    int iP22 = e.this.p2(constraintWidget, this.f12157q);
                    int i13 = e.this.f12138x1;
                    if (constraintWidget.X() == 8) {
                        i13 = 0;
                    }
                    this.f12153m += iP22 + i13;
                    if (this.f12142b == null || this.f12143c < iQ2) {
                        this.f12142b = constraintWidget;
                        this.f12143c = iQ2;
                        this.f12152l = iQ2;
                    }
                }
            }
        }

        public void i(int i10) {
            this.f12154n = i10;
        }

        public void j(int i10, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i11, int i12, int i13, int i14, int i15) {
            this.f12141a = i10;
            this.f12144d = constraintAnchor;
            this.f12145e = constraintAnchor2;
            this.f12146f = constraintAnchor3;
            this.f12147g = constraintAnchor4;
            this.f12148h = i11;
            this.f12149i = i12;
            this.f12150j = i13;
            this.f12151k = i14;
            this.f12157q = i15;
        }
    }

    public void A2(float f10) {
        this.f12131q1 = f10;
    }

    public void B2(int i10) {
        this.f12137w1 = i10;
    }

    public void C2(int i10) {
        this.f12125k1 = i10;
    }

    public void D2(float f10) {
        this.f12135u1 = f10;
    }

    public void E2(int i10) {
        this.f12129o1 = i10;
    }

    public void F2(float f10) {
        this.f12136v1 = f10;
    }

    public void G2(int i10) {
        this.f12130p1 = i10;
    }

    @Override // androidx.constraintlayout.core.widgets.i
    public void H1(int i10, int i11, int i12, int i13) {
        int i14;
        ConstraintWidget[] constraintWidgetArr;
        if (this.f37461W0 > 0 && !J1()) {
            M1(0, 0);
            L1(false);
            return;
        }
        int iE1 = E1();
        int iF1 = F1();
        int iG1 = G1();
        int iD1 = D1();
        int[] iArr = new int[2];
        int i15 = (i11 - iE1) - iF1;
        int i16 = this.f12118C1;
        if (i16 == 1) {
            i15 = (i13 - iG1) - iD1;
        }
        int i17 = i15;
        if (i16 == 0) {
            if (this.f12125k1 == -1) {
                this.f12125k1 = 0;
            }
            if (this.f12126l1 == -1) {
                this.f12126l1 = 0;
            }
        } else {
            if (this.f12125k1 == -1) {
                this.f12125k1 = 0;
            }
            if (this.f12126l1 == -1) {
                this.f12126l1 = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArr2 = this.f37460V0;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            i14 = this.f37461W0;
            if (i18 >= i14) {
                break;
            }
            if (this.f37460V0[i18].X() == 8) {
                i19++;
            }
            i18++;
        }
        if (i19 > 0) {
            ConstraintWidget[] constraintWidgetArr3 = new ConstraintWidget[i14 - i19];
            int i20 = 0;
            i14 = 0;
            while (i20 < this.f37461W0) {
                ConstraintWidget constraintWidget = this.f37460V0[i20];
                ConstraintWidget[] constraintWidgetArr4 = constraintWidgetArr3;
                if (constraintWidget.X() != 8) {
                    constraintWidgetArr4[i14] = constraintWidget;
                    i14++;
                }
                i20++;
                constraintWidgetArr3 = constraintWidgetArr4;
            }
            constraintWidgetArr = constraintWidgetArr3;
        } else {
            constraintWidgetArr = constraintWidgetArr2;
        }
        int i21 = i14;
        this.f12123H1 = constraintWidgetArr;
        this.f12124I1 = i21;
        int i22 = this.f12116A1;
        if (i22 == 0) {
            u2(constraintWidgetArr, i21, this.f12118C1, i17, iArr);
        } else if (i22 == 1) {
            s2(constraintWidgetArr, i21, this.f12118C1, i17, iArr);
        } else if (i22 == 2) {
            r2(constraintWidgetArr, i21, this.f12118C1, i17, iArr);
        } else if (i22 == 3) {
            t2(constraintWidgetArr, i21, this.f12118C1, i17, iArr);
        }
        int iMin = iArr[0] + iE1 + iF1;
        int iMin2 = iArr[1] + iG1 + iD1;
        if (i10 == 1073741824) {
            iMin = i11;
        } else if (i10 == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, i11);
        } else if (i10 != 0) {
            iMin = 0;
        }
        if (i12 == 1073741824) {
            iMin2 = i13;
        } else if (i12 == Integer.MIN_VALUE) {
            iMin2 = Math.min(iMin2, i13);
        } else if (i12 != 0) {
            iMin2 = 0;
        }
        M1(iMin, iMin2);
        p1(iMin);
        Q0(iMin2);
        L1(this.f37461W0 > 0);
    }

    public void H2(int i10) {
        this.f12117B1 = i10;
    }

    public void I2(int i10) {
        this.f12118C1 = i10;
    }

    public void J2(int i10) {
        this.f12140z1 = i10;
    }

    public void K2(float f10) {
        this.f12132r1 = f10;
    }

    public void L2(int i10) {
        this.f12138x1 = i10;
    }

    public void M2(int i10) {
        this.f12126l1 = i10;
    }

    public void N2(int i10) {
        this.f12116A1 = i10;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(androidx.constraintlayout.core.c cVar, boolean z10) {
        super.g(cVar, z10);
        boolean z11 = M() != null && ((d) M()).V1();
        int i10 = this.f12116A1;
        if (i10 != 0) {
            if (i10 == 1) {
                int size = this.f12119D1.size();
                int i11 = 0;
                while (i11 < size) {
                    this.f12119D1.get(i11).d(z11, i11, i11 == size + (-1));
                    i11++;
                }
            } else if (i10 == 2) {
                o2(z11);
            } else if (i10 == 3) {
                int size2 = this.f12119D1.size();
                int i12 = 0;
                while (i12 < size2) {
                    this.f12119D1.get(i12).d(z11, i12, i12 == size2 + (-1));
                    i12++;
                }
            }
        } else if (this.f12119D1.size() > 0) {
            this.f12119D1.get(0).d(z11, 0, true);
        }
        L1(false);
    }

    @Override // o0.C4994b, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void n(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        super.n(constraintWidget, map);
        e eVar = (e) constraintWidget;
        this.f12125k1 = eVar.f12125k1;
        this.f12126l1 = eVar.f12126l1;
        this.f12127m1 = eVar.f12127m1;
        this.f12128n1 = eVar.f12128n1;
        this.f12129o1 = eVar.f12129o1;
        this.f12130p1 = eVar.f12130p1;
        this.f12131q1 = eVar.f12131q1;
        this.f12132r1 = eVar.f12132r1;
        this.f12133s1 = eVar.f12133s1;
        this.f12134t1 = eVar.f12134t1;
        this.f12135u1 = eVar.f12135u1;
        this.f12136v1 = eVar.f12136v1;
        this.f12137w1 = eVar.f12137w1;
        this.f12138x1 = eVar.f12138x1;
        this.f12139y1 = eVar.f12139y1;
        this.f12140z1 = eVar.f12140z1;
        this.f12116A1 = eVar.f12116A1;
        this.f12117B1 = eVar.f12117B1;
        this.f12118C1 = eVar.f12118C1;
    }

    public final void o2(boolean z10) {
        ConstraintWidget constraintWidget;
        float f10;
        int i10;
        if (this.f12122G1 == null || this.f12121F1 == null || this.f12120E1 == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f12124I1; i11++) {
            this.f12123H1[i11].x0();
        }
        int[] iArr = this.f12122G1;
        int i12 = iArr[0];
        int i13 = iArr[1];
        float f11 = this.f12131q1;
        ConstraintWidget constraintWidget2 = null;
        int i14 = 0;
        while (i14 < i12) {
            if (z10) {
                i10 = (i12 - i14) - 1;
                f10 = 1.0f - this.f12131q1;
            } else {
                f10 = f11;
                i10 = i14;
            }
            ConstraintWidget constraintWidget3 = this.f12121F1[i10];
            if (constraintWidget3 != null && constraintWidget3.X() != 8) {
                if (i14 == 0) {
                    constraintWidget3.l(constraintWidget3.f11964Q, this.f11964Q, E1());
                    constraintWidget3.S0(this.f12125k1);
                    constraintWidget3.R0(f10);
                }
                if (i14 == i12 - 1) {
                    constraintWidget3.l(constraintWidget3.f11968S, this.f11968S, F1());
                }
                if (i14 > 0 && constraintWidget2 != null) {
                    constraintWidget3.l(constraintWidget3.f11964Q, constraintWidget2.f11968S, this.f12137w1);
                    constraintWidget2.l(constraintWidget2.f11968S, constraintWidget3.f11964Q, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
            i14++;
            f11 = f10;
        }
        for (int i15 = 0; i15 < i13; i15++) {
            ConstraintWidget constraintWidget4 = this.f12120E1[i15];
            if (constraintWidget4 != null && constraintWidget4.X() != 8) {
                if (i15 == 0) {
                    constraintWidget4.l(constraintWidget4.f11966R, this.f11966R, G1());
                    constraintWidget4.j1(this.f12126l1);
                    constraintWidget4.i1(this.f12132r1);
                }
                if (i15 == i13 - 1) {
                    constraintWidget4.l(constraintWidget4.f11970T, this.f11970T, D1());
                }
                if (i15 > 0 && constraintWidget2 != null) {
                    constraintWidget4.l(constraintWidget4.f11966R, constraintWidget2.f11970T, this.f12138x1);
                    constraintWidget2.l(constraintWidget2.f11970T, constraintWidget4.f11966R, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i16 = 0; i16 < i12; i16++) {
            for (int i17 = 0; i17 < i13; i17++) {
                int i18 = (i17 * i12) + i16;
                if (this.f12118C1 == 1) {
                    i18 = (i16 * i13) + i17;
                }
                ConstraintWidget[] constraintWidgetArr = this.f12123H1;
                if (i18 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i18]) != null && constraintWidget.X() != 8) {
                    ConstraintWidget constraintWidget5 = this.f12121F1[i16];
                    ConstraintWidget constraintWidget6 = this.f12120E1[i17];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.l(constraintWidget.f11964Q, constraintWidget5.f11964Q, 0);
                        constraintWidget.l(constraintWidget.f11968S, constraintWidget5.f11968S, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.l(constraintWidget.f11966R, constraintWidget6.f11966R, 0);
                        constraintWidget.l(constraintWidget.f11970T, constraintWidget6.f11970T, 0);
                    }
                }
            }
        }
    }

    public final int p2(ConstraintWidget constraintWidget, int i10) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.V() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i11 = constraintWidget.f12024x;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (constraintWidget.f11940E * i10);
                if (i12 != constraintWidget.z()) {
                    constraintWidget.d1(true);
                    I1(constraintWidget, constraintWidget.C(), constraintWidget.Y(), ConstraintWidget.DimensionBehaviour.FIXED, i12);
                }
                return i12;
            }
            constraintWidget2 = constraintWidget;
            if (i11 == 1) {
                return constraintWidget2.z();
            }
            if (i11 == 3) {
                return (int) ((constraintWidget2.Y() * constraintWidget2.f11989f0) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.z();
    }

    public final int q2(ConstraintWidget constraintWidget, int i10) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i11 = constraintWidget.f12022w;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (constraintWidget.f11934B * i10);
                if (i12 != constraintWidget.Y()) {
                    constraintWidget.d1(true);
                    I1(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i12, constraintWidget.V(), constraintWidget.z());
                }
                return i12;
            }
            constraintWidget2 = constraintWidget;
            if (i11 == 1) {
                return constraintWidget2.Y();
            }
            if (i11 == 3) {
                return (int) ((constraintWidget2.z() * constraintWidget2.f11989f0) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.Y();
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
    public final void r2(androidx.constraintlayout.core.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.e.r2(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    public final void s2(ConstraintWidget[] constraintWidgetArr, int i10, int i11, int i12, int[] iArr) {
        int i13;
        e eVar;
        int i14;
        ConstraintAnchor constraintAnchor;
        int i15;
        e eVar2 = this;
        if (i10 == 0) {
            return;
        }
        eVar2.f12119D1.clear();
        int i16 = i12;
        a aVar = eVar2.new a(i11, eVar2.f11964Q, eVar2.f11966R, eVar2.f11968S, eVar2.f11970T, i16);
        eVar2.f12119D1.add(aVar);
        if (i11 == 0) {
            i13 = 0;
            int i17 = 0;
            int i18 = 0;
            while (i18 < i10) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i18];
                int iQ2 = eVar2.q2(constraintWidget, i16);
                if (constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i19 = i13;
                boolean z10 = (i17 == i16 || (eVar2.f12137w1 + i17) + iQ2 > i16) && aVar.f12142b != null;
                if (!z10 && i18 > 0 && (i15 = eVar2.f12117B1) > 0 && i18 % i15 == 0) {
                    z10 = true;
                }
                if (z10) {
                    aVar = eVar2.new a(i11, eVar2.f11964Q, eVar2.f11966R, eVar2.f11968S, eVar2.f11970T, i16);
                    aVar.i(i18);
                    eVar2.f12119D1.add(aVar);
                } else {
                    if (i18 > 0) {
                        i17 += eVar2.f12137w1 + iQ2;
                    }
                    aVar.b(constraintWidget);
                    i18++;
                    i13 = i19;
                }
                i17 = iQ2;
                aVar.b(constraintWidget);
                i18++;
                i13 = i19;
            }
        } else {
            i13 = 0;
            int i20 = 0;
            int i21 = 0;
            while (i21 < i10) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i21];
                int iP2 = eVar2.p2(constraintWidget2, i16);
                if (constraintWidget2.V() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i22 = i13;
                boolean z11 = (i20 == i16 || (eVar2.f12138x1 + i20) + iP2 > i16) && aVar.f12142b != null;
                if (!z11 && i21 > 0 && (i14 = eVar2.f12117B1) > 0 && i21 % i14 == 0) {
                    z11 = true;
                }
                if (z11) {
                    aVar = eVar2.new a(i11, eVar2.f11964Q, eVar2.f11966R, eVar2.f11968S, eVar2.f11970T, i16);
                    eVar = eVar2;
                    aVar.i(i21);
                    eVar.f12119D1.add(aVar);
                } else {
                    eVar = eVar2;
                    if (i21 > 0) {
                        i20 += eVar.f12138x1 + iP2;
                    }
                    aVar.b(constraintWidget2);
                    i21++;
                    i16 = i12;
                    i13 = i22;
                    eVar2 = eVar;
                }
                i20 = iP2;
                aVar.b(constraintWidget2);
                i21++;
                i16 = i12;
                i13 = i22;
                eVar2 = eVar;
            }
        }
        e eVar3 = eVar2;
        int size = eVar3.f12119D1.size();
        ConstraintAnchor constraintAnchor2 = eVar3.f11964Q;
        ConstraintAnchor constraintAnchor3 = eVar3.f11966R;
        ConstraintAnchor constraintAnchor4 = eVar3.f11968S;
        ConstraintAnchor constraintAnchor5 = eVar3.f11970T;
        int iE1 = eVar3.E1();
        int iG1 = eVar3.G1();
        int iF1 = eVar3.F1();
        int iD1 = eVar3.D1();
        ConstraintWidget.DimensionBehaviour dimensionBehaviourC = eVar3.C();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z12 = dimensionBehaviourC == dimensionBehaviour || eVar3.V() == dimensionBehaviour;
        if (i13 > 0 && z12) {
            for (int i23 = 0; i23 < size; i23++) {
                a aVar2 = eVar3.f12119D1.get(i23);
                if (i11 == 0) {
                    aVar2.g(i12 - aVar2.f());
                } else {
                    aVar2.g(i12 - aVar2.e());
                }
            }
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchor2;
        int iD12 = iD1;
        int i24 = 0;
        int iF12 = iF1;
        int i25 = iG1;
        int i26 = iE1;
        ConstraintAnchor constraintAnchor7 = constraintAnchor5;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        ConstraintAnchor constraintAnchor9 = constraintAnchor3;
        int i27 = 0;
        for (int i28 = 0; i28 < size; i28++) {
            a aVar3 = eVar3.f12119D1.get(i28);
            if (i11 == 0) {
                if (i28 < size - 1) {
                    constraintAnchor7 = eVar3.f12119D1.get(i28 + 1).f12142b.f11966R;
                    iD12 = 0;
                } else {
                    constraintAnchor7 = eVar3.f11970T;
                    iD12 = eVar3.D1();
                }
                ConstraintAnchor constraintAnchor10 = aVar3.f12142b.f11970T;
                int i29 = i27;
                aVar3.j(i11, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i26, i25, iF12, iD12, i12);
                int iMax = Math.max(i24, aVar3.f());
                int iE = aVar3.e() + i29;
                if (i28 > 0) {
                    iE += eVar3.f12138x1;
                }
                i27 = iE;
                i24 = iMax;
                constraintAnchor9 = constraintAnchor10;
                i25 = 0;
            } else {
                int i30 = i24;
                int i31 = i27;
                if (i28 < size - 1) {
                    constraintAnchor = eVar3.f12119D1.get(i28 + 1).f12142b.f11964Q;
                    iF12 = 0;
                } else {
                    constraintAnchor = eVar3.f11968S;
                    iF12 = eVar3.F1();
                }
                constraintAnchor8 = constraintAnchor;
                ConstraintAnchor constraintAnchor11 = aVar3.f12142b.f11968S;
                aVar3.j(i11, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i26, i25, iF12, iD12, i12);
                int iF = aVar3.f() + i30;
                int iMax2 = Math.max(i31, aVar3.e());
                if (i28 > 0) {
                    iF += eVar3.f12137w1;
                }
                int i32 = iF;
                i27 = iMax2;
                i24 = i32;
                i26 = 0;
                constraintAnchor6 = constraintAnchor11;
            }
        }
        iArr[0] = i24;
        iArr[1] = i27;
    }

    public final void t2(ConstraintWidget[] constraintWidgetArr, int i10, int i11, int i12, int[] iArr) {
        int i13;
        e eVar;
        int i14;
        boolean z10;
        ConstraintAnchor constraintAnchor;
        int i15;
        e eVar2 = this;
        if (i10 == 0) {
            return;
        }
        eVar2.f12119D1.clear();
        int i16 = i12;
        a aVar = eVar2.new a(i11, eVar2.f11964Q, eVar2.f11966R, eVar2.f11968S, eVar2.f11970T, i16);
        eVar2.f12119D1.add(aVar);
        boolean z11 = true;
        if (i11 == 0) {
            int i17 = 0;
            i13 = 0;
            int i18 = 0;
            int i19 = 0;
            while (i19 < i10) {
                i17++;
                ConstraintWidget constraintWidget = constraintWidgetArr[i19];
                int iQ2 = eVar2.q2(constraintWidget, i16);
                if (constraintWidget.C() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i20 = i13;
                boolean z12 = (i18 == i16 || (eVar2.f12137w1 + i18) + iQ2 > i16) && aVar.f12142b != null;
                if (!z12 && i19 > 0 && (i15 = eVar2.f12117B1) > 0 && i17 > i15) {
                    z12 = true;
                }
                if (z12) {
                    aVar = eVar2.new a(i11, eVar2.f11964Q, eVar2.f11966R, eVar2.f11968S, eVar2.f11970T, i16);
                    aVar.i(i19);
                    eVar2.f12119D1.add(aVar);
                    i17 = 1;
                } else {
                    if (i19 > 0) {
                        i18 += eVar2.f12137w1 + iQ2;
                    }
                    aVar.b(constraintWidget);
                    i19++;
                    i13 = i20;
                }
                i18 = iQ2;
                aVar.b(constraintWidget);
                i19++;
                i13 = i20;
            }
        } else {
            int i21 = 0;
            i13 = 0;
            int i22 = 0;
            int i23 = 0;
            while (i23 < i10) {
                i21++;
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i23];
                int iP2 = eVar2.p2(constraintWidget2, i16);
                if (constraintWidget2.V() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i13++;
                }
                int i24 = i13;
                boolean z13 = (i22 == i16 || (eVar2.f12138x1 + i22) + iP2 > i16) && aVar.f12142b != null;
                if (!z13 && i23 > 0 && (i14 = eVar2.f12117B1) > 0 && i21 > i14) {
                    z13 = true;
                }
                if (z13) {
                    aVar = eVar2.new a(i11, eVar2.f11964Q, eVar2.f11966R, eVar2.f11968S, eVar2.f11970T, i16);
                    eVar = eVar2;
                    aVar.i(i23);
                    eVar.f12119D1.add(aVar);
                    i21 = 1;
                } else {
                    eVar = eVar2;
                    if (i23 > 0) {
                        i22 += eVar.f12138x1 + iP2;
                    }
                    aVar.b(constraintWidget2);
                    i23++;
                    i16 = i12;
                    i13 = i24;
                    eVar2 = eVar;
                }
                i22 = iP2;
                aVar.b(constraintWidget2);
                i23++;
                i16 = i12;
                i13 = i24;
                eVar2 = eVar;
            }
        }
        e eVar3 = eVar2;
        int size = eVar3.f12119D1.size();
        ConstraintAnchor constraintAnchor2 = eVar3.f11964Q;
        ConstraintAnchor constraintAnchor3 = eVar3.f11966R;
        ConstraintAnchor constraintAnchor4 = eVar3.f11968S;
        ConstraintAnchor constraintAnchor5 = eVar3.f11970T;
        int iE1 = eVar3.E1();
        int iG1 = eVar3.G1();
        int iF1 = eVar3.F1();
        int iD1 = eVar3.D1();
        ConstraintWidget.DimensionBehaviour dimensionBehaviourC = eVar3.C();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z14 = dimensionBehaviourC == dimensionBehaviour || eVar3.V() == dimensionBehaviour;
        if (i13 > 0 && z14) {
            for (int i25 = 0; i25 < size; i25++) {
                a aVar2 = eVar3.f12119D1.get(i25);
                if (i11 == 0) {
                    aVar2.g(i12 - aVar2.f());
                } else {
                    aVar2.g(i12 - aVar2.e());
                }
            }
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchor3;
        int iD12 = iD1;
        int i26 = 0;
        int i27 = 0;
        int iF12 = iF1;
        int i28 = iG1;
        int i29 = iE1;
        ConstraintAnchor constraintAnchor7 = constraintAnchor5;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        ConstraintAnchor constraintAnchor9 = constraintAnchor2;
        int i30 = 0;
        while (i27 < size) {
            a aVar3 = eVar3.f12119D1.get(i27);
            if (i11 == 0) {
                if (i27 < size - 1) {
                    constraintAnchor7 = eVar3.f12119D1.get(i27 + 1).f12142b.f11966R;
                    iD12 = 0;
                } else {
                    constraintAnchor7 = eVar3.f11970T;
                    iD12 = eVar3.D1();
                }
                ConstraintAnchor constraintAnchor10 = aVar3.f12142b.f11970T;
                z10 = z11;
                int i31 = i26;
                aVar3.j(i11, constraintAnchor9, constraintAnchor6, constraintAnchor8, constraintAnchor7, i29, i28, iF12, iD12, i12);
                int iMax = Math.max(i30, aVar3.f());
                int iE = aVar3.e() + i31;
                if (i27 > 0) {
                    iE += eVar3.f12138x1;
                }
                i26 = iE;
                i30 = iMax;
                constraintAnchor6 = constraintAnchor10;
                i28 = 0;
            } else {
                int i32 = i26;
                z10 = z11;
                int i33 = i30;
                if (i27 < size - 1) {
                    constraintAnchor = eVar3.f12119D1.get(i27 + 1).f12142b.f11964Q;
                    iF12 = 0;
                } else {
                    constraintAnchor = eVar3.f11968S;
                    iF12 = eVar3.F1();
                }
                constraintAnchor8 = constraintAnchor;
                ConstraintAnchor constraintAnchor11 = aVar3.f12142b.f11968S;
                aVar3.j(i11, constraintAnchor9, constraintAnchor6, constraintAnchor8, constraintAnchor7, i29, i28, iF12, iD12, i12);
                int iF = aVar3.f() + i33;
                int iMax2 = Math.max(i32, aVar3.e());
                if (i27 > 0) {
                    iF += eVar3.f12137w1;
                }
                int i34 = iF;
                i26 = iMax2;
                i30 = i34;
                i29 = 0;
                constraintAnchor9 = constraintAnchor11;
            }
            i27++;
            z11 = z10;
        }
        iArr[0] = i30;
        iArr[z11 ? 1 : 0] = i26;
    }

    public final void u2(ConstraintWidget[] constraintWidgetArr, int i10, int i11, int i12, int[] iArr) {
        a aVar;
        if (i10 == 0) {
            return;
        }
        if (this.f12119D1.size() == 0) {
            aVar = new a(i11, this.f11964Q, this.f11966R, this.f11968S, this.f11970T, i12);
            this.f12119D1.add(aVar);
        } else {
            a aVar2 = this.f12119D1.get(0);
            aVar2.c();
            aVar2.j(i11, this.f11964Q, this.f11966R, this.f11968S, this.f11970T, E1(), G1(), F1(), D1(), i12);
            aVar = aVar2;
        }
        for (int i13 = 0; i13 < i10; i13++) {
            aVar.b(constraintWidgetArr[i13]);
        }
        iArr[0] = aVar.f();
        iArr[1] = aVar.e();
    }

    public void v2(float f10) {
        this.f12133s1 = f10;
    }

    public void w2(int i10) {
        this.f12127m1 = i10;
    }

    public void x2(float f10) {
        this.f12134t1 = f10;
    }

    public void y2(int i10) {
        this.f12128n1 = i10;
    }

    public void z2(int i10) {
        this.f12139y1 = i10;
    }
}
