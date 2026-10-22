package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends h {

    /* renamed from: b1, reason: collision with root package name */
    public ConstraintWidget[] f1204b1;
    public int E0 = -1;
    public int F0 = -1;
    public int G0 = -1;
    public int H0 = -1;
    public int I0 = -1;
    public int J0 = -1;
    public float K0 = 0.5f;
    public float L0 = 0.5f;
    public float M0 = 0.5f;
    public float N0 = 0.5f;
    public float O0 = 0.5f;
    public float P0 = 0.5f;
    public int Q0 = 0;
    public int R0 = 0;
    public int S0 = 2;
    public int T0 = 2;
    public int U0 = 0;
    public int V0 = -1;
    public int W0 = 0;
    public final ArrayList<a> X0 = new ArrayList<>();
    public ConstraintWidget[] Y0 = null;
    public ConstraintWidget[] Z0 = null;

    /* renamed from: a1, reason: collision with root package name */
    public int[] f1203a1 = null;

    /* renamed from: c1, reason: collision with root package name */
    public int f1205c1 = 0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public int f1206a;

        /* renamed from: d, reason: collision with root package name */
        public ConstraintAnchor f1209d;

        /* renamed from: e, reason: collision with root package name */
        public ConstraintAnchor f1210e;

        /* renamed from: f, reason: collision with root package name */
        public ConstraintAnchor f1211f;

        /* renamed from: g, reason: collision with root package name */
        public ConstraintAnchor f1212g;
        public int h;

        /* renamed from: i, reason: collision with root package name */
        public int f1213i;

        /* renamed from: j, reason: collision with root package name */
        public int f1214j;

        /* renamed from: k, reason: collision with root package name */
        public int f1215k;

        /* renamed from: q, reason: collision with root package name */
        public int f1221q;

        /* renamed from: b, reason: collision with root package name */
        public ConstraintWidget f1207b = null;

        /* renamed from: c, reason: collision with root package name */
        public int f1208c = 0;

        /* renamed from: l, reason: collision with root package name */
        public int f1216l = 0;

        /* renamed from: m, reason: collision with root package name */
        public int f1217m = 0;

        /* renamed from: n, reason: collision with root package name */
        public int f1218n = 0;

        /* renamed from: o, reason: collision with root package name */
        public int f1219o = 0;

        /* renamed from: p, reason: collision with root package name */
        public int f1220p = 0;

        public a(int i10, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i11) {
            this.f1206a = i10;
            this.f1209d = constraintAnchor;
            this.f1210e = constraintAnchor2;
            this.f1211f = constraintAnchor3;
            this.f1212g = constraintAnchor4;
            this.h = e.this.f1233x0;
            this.f1213i = e.this.f1229t0;
            this.f1214j = e.this.f1234y0;
            this.f1215k = e.this.f1230u0;
            this.f1221q = i11;
        }

        public final void a(ConstraintWidget constraintWidget) {
            int i10 = this.f1206a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1138c;
            e eVar = e.this;
            if (i10 == 0) {
                int iW = eVar.W(constraintWidget, this.f1221q);
                if (constraintWidget.U[0] == dimensionBehaviour) {
                    this.f1220p++;
                    iW = 0;
                }
                this.f1216l = iW + (constraintWidget.f1113i0 != 8 ? eVar.Q0 : 0) + this.f1216l;
                int iV = eVar.V(constraintWidget, this.f1221q);
                if (this.f1207b == null || this.f1208c < iV) {
                    this.f1207b = constraintWidget;
                    this.f1208c = iV;
                    this.f1217m = iV;
                }
            } else {
                int iW2 = eVar.W(constraintWidget, this.f1221q);
                int iV2 = eVar.V(constraintWidget, this.f1221q);
                if (constraintWidget.U[1] == dimensionBehaviour) {
                    this.f1220p++;
                    iV2 = 0;
                }
                this.f1217m = iV2 + (constraintWidget.f1113i0 != 8 ? eVar.R0 : 0) + this.f1217m;
                if (this.f1207b == null || this.f1208c < iW2) {
                    this.f1207b = constraintWidget;
                    this.f1208c = iW2;
                    this.f1216l = iW2;
                }
            }
            this.f1219o++;
        }

        public final void b(int i10, boolean z, boolean z3) {
            e eVar;
            int i11;
            int i12;
            ConstraintWidget constraintWidget;
            boolean z10;
            int i13;
            int i14;
            char c9;
            float f8;
            float f9;
            float f10;
            int i15;
            float f11;
            float f12;
            int i16;
            int i17 = this.f1219o;
            int i18 = 0;
            while (true) {
                eVar = e.this;
                if (i18 >= i17 || (i16 = this.f1218n + i18) >= eVar.f1205c1) {
                    break;
                }
                ConstraintWidget constraintWidget2 = eVar.f1204b1[i16];
                if (constraintWidget2 != null) {
                    constraintWidget2.D();
                }
                i18++;
            }
            if (i17 == 0 || this.f1207b == null) {
                return;
            }
            boolean z11 = z3 && i10 == 0;
            int i19 = -1;
            int i20 = -1;
            for (int i21 = 0; i21 < i17; i21++) {
                int i22 = this.f1218n + (z ? (i17 - 1) - i21 : i21);
                if (i22 >= eVar.f1205c1) {
                    break;
                }
                ConstraintWidget constraintWidget3 = eVar.f1204b1[i22];
                if (constraintWidget3 != null && constraintWidget3.f1113i0 == 0) {
                    if (i19 == -1) {
                        i19 = i21;
                    }
                    i20 = i21;
                }
            }
            if (this.f1206a == 0) {
                ConstraintWidget constraintWidget4 = this.f1207b;
                constraintWidget4.f1119l0 = eVar.F0;
                ConstraintAnchor constraintAnchor = constraintWidget4.M;
                ConstraintAnchor constraintAnchor2 = constraintWidget4.K;
                int i23 = this.f1213i;
                if (i10 > 0) {
                    i23 += eVar.R0;
                }
                constraintAnchor2.a(this.f1210e, i23);
                if (z3) {
                    constraintAnchor.a(this.f1212g, this.f1215k);
                }
                if (i10 > 0) {
                    this.f1210e.f1086d.M.a(constraintAnchor2, 0);
                }
                if (eVar.T0 != 3 || constraintWidget4.E) {
                    constraintWidget = constraintWidget4;
                } else {
                    for (int i24 = 0; i24 < i17; i24++) {
                        int i25 = this.f1218n + (z ? (i17 - 1) - i24 : i24);
                        if (i25 >= eVar.f1205c1) {
                            break;
                        }
                        constraintWidget = eVar.f1204b1[i25];
                        if (constraintWidget.E) {
                            break;
                        }
                    }
                    constraintWidget = constraintWidget4;
                }
                int i26 = 0;
                ConstraintWidget constraintWidget5 = null;
                while (i26 < i17) {
                    int i27 = z ? (i17 - 1) - i26 : i26;
                    int i28 = this.f1218n + i27;
                    if (i28 >= eVar.f1205c1) {
                        return;
                    }
                    ConstraintWidget constraintWidget6 = eVar.f1204b1[i28];
                    if (constraintWidget6 == null) {
                        i14 = i17;
                        z10 = z11;
                        i13 = i20;
                        c9 = 3;
                    } else {
                        ConstraintAnchor constraintAnchor3 = constraintWidget6.M;
                        ConstraintAnchor constraintAnchor4 = constraintWidget6.K;
                        ConstraintAnchor constraintAnchor5 = constraintWidget6.J;
                        z10 = z11;
                        if (i26 == 0) {
                            i13 = i20;
                            constraintWidget6.f(constraintAnchor5, this.f1209d, this.h);
                        } else {
                            i13 = i20;
                        }
                        if (i27 == 0) {
                            int i29 = eVar.E0;
                            if (z) {
                                f8 = 1.0f;
                                f9 = 1.0f - eVar.K0;
                            } else {
                                f8 = 1.0f;
                                f9 = eVar.K0;
                            }
                            if (this.f1218n == 0) {
                                i15 = eVar.G0;
                                f10 = f9;
                                if (i15 != -1) {
                                    if (z) {
                                        f12 = eVar.M0;
                                        f11 = f8 - f12;
                                        constraintWidget6.f1117k0 = i15;
                                        constraintWidget6.f1108f0 = f11;
                                    } else {
                                        f11 = eVar.M0;
                                        constraintWidget6.f1117k0 = i15;
                                        constraintWidget6.f1108f0 = f11;
                                    }
                                }
                            } else {
                                f10 = f9;
                            }
                            if (!z3 || (i15 = eVar.I0) == -1) {
                                i15 = i29;
                                f11 = f10;
                            } else if (z) {
                                f12 = eVar.O0;
                                f11 = f8 - f12;
                            } else {
                                f11 = eVar.O0;
                            }
                            constraintWidget6.f1117k0 = i15;
                            constraintWidget6.f1108f0 = f11;
                        }
                        if (i26 == i17 - 1) {
                            i14 = i17;
                            constraintWidget6.f(constraintWidget6.L, this.f1211f, this.f1214j);
                        } else {
                            i14 = i17;
                        }
                        if (constraintWidget5 != null) {
                            ConstraintAnchor constraintAnchor6 = constraintWidget5.L;
                            constraintAnchor5.a(constraintAnchor6, eVar.Q0);
                            if (i26 == i19) {
                                int i30 = this.h;
                                if (constraintAnchor5.h()) {
                                    constraintAnchor5.h = i30;
                                }
                            }
                            constraintAnchor6.a(constraintAnchor5, 0);
                            if (i26 == i13 + 1) {
                                int i31 = this.f1214j;
                                if (constraintAnchor6.h()) {
                                    constraintAnchor6.h = i31;
                                }
                            }
                        }
                        if (constraintWidget6 != constraintWidget4) {
                            int i32 = eVar.T0;
                            c9 = 3;
                            if (i32 == 3 && constraintWidget.E && constraintWidget6 != constraintWidget && constraintWidget6.E) {
                                constraintWidget6.N.a(constraintWidget.N, 0);
                            } else if (i32 == 0) {
                                constraintAnchor4.a(constraintAnchor2, 0);
                            } else if (i32 == 1) {
                                constraintAnchor3.a(constraintAnchor, 0);
                            } else if (z10) {
                                constraintAnchor4.a(this.f1210e, this.f1213i);
                                constraintAnchor3.a(this.f1212g, this.f1215k);
                            } else {
                                constraintAnchor4.a(constraintAnchor2, 0);
                                constraintAnchor3.a(constraintAnchor, 0);
                            }
                        } else {
                            c9 = 3;
                        }
                        constraintWidget5 = constraintWidget6;
                    }
                    i26++;
                    z11 = z10;
                    i20 = i13;
                    i17 = i14;
                }
                return;
            }
            int i33 = i17;
            boolean z12 = z11;
            int i34 = i20;
            ConstraintWidget constraintWidget7 = this.f1207b;
            constraintWidget7.f1117k0 = eVar.E0;
            ConstraintAnchor constraintAnchor7 = constraintWidget7.J;
            ConstraintAnchor constraintAnchor8 = constraintWidget7.L;
            int i35 = this.h;
            if (i10 > 0) {
                i35 += eVar.Q0;
            }
            if (z) {
                constraintAnchor8.a(this.f1211f, i35);
                if (z3) {
                    constraintAnchor7.a(this.f1209d, this.f1214j);
                }
                if (i10 > 0) {
                    this.f1211f.f1086d.J.a(constraintAnchor8, 0);
                }
            } else {
                constraintAnchor7.a(this.f1209d, i35);
                if (z3) {
                    constraintAnchor8.a(this.f1211f, this.f1214j);
                }
                if (i10 > 0) {
                    this.f1209d.f1086d.L.a(constraintAnchor7, 0);
                }
            }
            int i36 = 0;
            ConstraintWidget constraintWidget8 = null;
            while (true) {
                int i37 = i33;
                if (i36 >= i37 || (i11 = this.f1218n + i36) >= eVar.f1205c1) {
                    return;
                }
                ConstraintWidget constraintWidget9 = eVar.f1204b1[i11];
                if (constraintWidget9 == null) {
                    i33 = i37;
                } else {
                    ConstraintAnchor constraintAnchor9 = constraintWidget9.K;
                    ConstraintAnchor constraintAnchor10 = constraintWidget9.L;
                    ConstraintAnchor constraintAnchor11 = constraintWidget9.J;
                    if (i36 == 0) {
                        constraintWidget9.f(constraintAnchor9, this.f1210e, this.f1213i);
                        int i38 = eVar.F0;
                        float f13 = eVar.L0;
                        if (this.f1218n == 0) {
                            int i39 = eVar.H0;
                            i33 = i37;
                            i12 = -1;
                            if (i39 != -1) {
                                f13 = eVar.N0;
                            }
                            i38 = i39;
                            constraintWidget9.f1119l0 = i38;
                            constraintWidget9.f1110g0 = f13;
                        } else {
                            i33 = i37;
                            i12 = -1;
                        }
                        if (z3 && (i39 = eVar.J0) != i12) {
                            f13 = eVar.P0;
                            i38 = i39;
                        }
                        constraintWidget9.f1119l0 = i38;
                        constraintWidget9.f1110g0 = f13;
                    } else {
                        i33 = i37;
                    }
                    if (i36 == i33 - 1) {
                        constraintWidget9.f(constraintWidget9.M, this.f1212g, this.f1215k);
                    }
                    if (constraintWidget8 != null) {
                        ConstraintAnchor constraintAnchor12 = constraintWidget8.M;
                        constraintAnchor9.a(constraintAnchor12, eVar.R0);
                        if (i36 == i19) {
                            int i40 = this.f1213i;
                            if (constraintAnchor9.h()) {
                                constraintAnchor9.h = i40;
                            }
                        }
                        constraintAnchor12.a(constraintAnchor9, 0);
                        if (i36 == i34 + 1) {
                            int i41 = this.f1215k;
                            if (constraintAnchor12.h()) {
                                constraintAnchor12.h = i41;
                            }
                        }
                    }
                    if (constraintWidget9 == constraintWidget7) {
                        constraintWidget8 = constraintWidget9;
                    } else if (z) {
                        int i42 = eVar.S0;
                        if (i42 == 0) {
                            constraintAnchor10.a(constraintAnchor8, 0);
                        } else if (i42 == 1) {
                            constraintAnchor11.a(constraintAnchor7, 0);
                        } else if (i42 == 2) {
                            constraintAnchor11.a(constraintAnchor7, 0);
                            constraintAnchor10.a(constraintAnchor8, 0);
                        }
                        constraintWidget8 = constraintWidget9;
                    } else {
                        int i43 = eVar.S0;
                        if (i43 == 0) {
                            constraintAnchor11.a(constraintAnchor7, 0);
                        } else if (i43 == 1) {
                            constraintAnchor10.a(constraintAnchor8, 0);
                        } else if (i43 == 2) {
                            if (z12) {
                                constraintAnchor11.a(this.f1209d, this.h);
                                constraintAnchor10.a(this.f1211f, this.f1214j);
                            } else {
                                constraintAnchor11.a(constraintAnchor7, 0);
                                constraintAnchor10.a(constraintAnchor8, 0);
                            }
                        }
                        constraintWidget8 = constraintWidget9;
                    }
                }
                i36++;
            }
        }

        public final int c() {
            return this.f1206a == 1 ? this.f1217m - e.this.R0 : this.f1217m;
        }

        public final int d() {
            return this.f1206a == 0 ? this.f1216l - e.this.Q0 : this.f1216l;
        }

        public final void e(int i10) {
            int i11 = this.f1220p;
            if (i11 == 0) {
                return;
            }
            int i12 = this.f1219o;
            int i13 = i10 / i11;
            for (int i14 = 0; i14 < i12; i14++) {
                int i15 = this.f1218n;
                int i16 = i15 + i14;
                e eVar = e.this;
                if (i16 >= eVar.f1205c1) {
                    break;
                }
                ConstraintWidget constraintWidget = eVar.f1204b1[i15 + i14];
                int i17 = this.f1206a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1136a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.f1138c;
                if (i17 == 0) {
                    if (constraintWidget != null) {
                        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.U;
                        if (dimensionBehaviourArr[0] == dimensionBehaviour2 && constraintWidget.r == 0) {
                            eVar.U(constraintWidget, dimensionBehaviour, i13, dimensionBehaviourArr[1], constraintWidget.k());
                        }
                    }
                } else if (constraintWidget != null) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidget.U;
                    if (dimensionBehaviourArr2[1] == dimensionBehaviour2 && constraintWidget.f1129s == 0) {
                        int i18 = i13;
                        eVar.U(constraintWidget, dimensionBehaviourArr2[0], constraintWidget.q(), dimensionBehaviour, i18);
                        i13 = i18;
                    }
                }
            }
            this.f1216l = 0;
            this.f1217m = 0;
            this.f1207b = null;
            this.f1208c = 0;
            int i19 = this.f1219o;
            for (int i20 = 0; i20 < i19; i20++) {
                int i21 = this.f1218n + i20;
                e eVar2 = e.this;
                if (i21 >= eVar2.f1205c1) {
                    return;
                }
                ConstraintWidget constraintWidget2 = eVar2.f1204b1[i21];
                if (this.f1206a == 0) {
                    int iQ = constraintWidget2.q();
                    int i22 = eVar2.Q0;
                    if (constraintWidget2.f1113i0 == 8) {
                        i22 = 0;
                    }
                    this.f1216l = iQ + i22 + this.f1216l;
                    int iV = eVar2.V(constraintWidget2, this.f1221q);
                    if (this.f1207b == null || this.f1208c < iV) {
                        this.f1207b = constraintWidget2;
                        this.f1208c = iV;
                        this.f1217m = iV;
                    }
                } else {
                    int iW = eVar2.W(constraintWidget2, this.f1221q);
                    int iV2 = eVar2.V(constraintWidget2, this.f1221q);
                    int i23 = eVar2.R0;
                    if (constraintWidget2.f1113i0 == 8) {
                        i23 = 0;
                    }
                    this.f1217m = iV2 + i23 + this.f1217m;
                    if (this.f1207b == null || this.f1208c < iW) {
                        this.f1207b = constraintWidget2;
                        this.f1208c = iW;
                        this.f1216l = iW;
                    }
                }
            }
        }

        public final void f(int i10, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i11, int i12, int i13, int i14, int i15) {
            this.f1206a = i10;
            this.f1209d = constraintAnchor;
            this.f1210e = constraintAnchor2;
            this.f1211f = constraintAnchor3;
            this.f1212g = constraintAnchor4;
            this.h = i11;
            this.f1213i = i12;
            this.f1214j = i13;
            this.f1215k = i14;
            this.f1221q = i15;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:404:0x06da  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x06f9  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x06fc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x011b  */
    @Override // androidx.constraintlayout.core.widgets.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T(int r39, int r40, int r41, int r42) {
        /*
            Method dump skipped, instructions count: 1793
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.e.T(int, int, int, int):void");
    }

    public final int V(ConstraintWidget constraintWidget, int i10) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.U;
        if (dimensionBehaviourArr[1] == ConstraintWidget.DimensionBehaviour.f1138c) {
            int i11 = constraintWidget.f1129s;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (constraintWidget.z * i10);
                if (i12 != constraintWidget.k()) {
                    constraintWidget.f1109g = true;
                    U(constraintWidget, dimensionBehaviourArr[0], constraintWidget.q(), ConstraintWidget.DimensionBehaviour.f1136a, i12);
                }
                return i12;
            }
            constraintWidget2 = constraintWidget;
            if (i11 == 1) {
                return constraintWidget2.k();
            }
            if (i11 == 3) {
                return (int) ((constraintWidget2.q() * constraintWidget2.Y) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.k();
    }

    public final int W(ConstraintWidget constraintWidget, int i10) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.U;
        if (dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.f1138c) {
            int i11 = constraintWidget.r;
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 2) {
                int i12 = (int) (constraintWidget.f1133w * i10);
                if (i12 != constraintWidget.q()) {
                    constraintWidget.f1109g = true;
                    U(constraintWidget, ConstraintWidget.DimensionBehaviour.f1136a, i12, dimensionBehaviourArr[1], constraintWidget.k());
                }
                return i12;
            }
            constraintWidget2 = constraintWidget;
            if (i11 == 1) {
                return constraintWidget2.q();
            }
            if (i11 == 3) {
                return (int) ((constraintWidget2.k() * constraintWidget2.Y) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.q();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void b(androidx.constraintlayout.core.c cVar, boolean z) {
        ConstraintWidget constraintWidget;
        float f8;
        int i10;
        super.b(cVar, z);
        ConstraintWidget constraintWidget2 = this.V;
        boolean z3 = constraintWidget2 != null && ((d) constraintWidget2).f1200w0;
        int i11 = this.U0;
        ArrayList<a> arrayList = this.X0;
        if (i11 != 0) {
            if (i11 == 1) {
                int size = arrayList.size();
                int i12 = 0;
                while (i12 < size) {
                    arrayList.get(i12).b(i12, z3, i12 == size + (-1));
                    i12++;
                }
            } else if (i11 != 2) {
                if (i11 == 3) {
                    int size2 = arrayList.size();
                    int i13 = 0;
                    while (i13 < size2) {
                        arrayList.get(i13).b(i13, z3, i13 == size2 + (-1));
                        i13++;
                    }
                }
            } else if (this.f1203a1 != null && this.Z0 != null && this.Y0 != null) {
                for (int i14 = 0; i14 < this.f1205c1; i14++) {
                    this.f1204b1[i14].D();
                }
                int[] iArr = this.f1203a1;
                int i15 = iArr[0];
                int i16 = iArr[1];
                float f9 = this.K0;
                ConstraintWidget constraintWidget3 = null;
                int i17 = 0;
                while (i17 < i15) {
                    if (z3) {
                        i10 = (i15 - i17) - 1;
                        f8 = 1.0f - this.K0;
                    } else {
                        f8 = f9;
                        i10 = i17;
                    }
                    ConstraintWidget constraintWidget4 = this.Z0[i10];
                    if (constraintWidget4 != null) {
                        ConstraintAnchor constraintAnchor = constraintWidget4.J;
                        if (constraintWidget4.f1113i0 != 8) {
                            if (i17 == 0) {
                                constraintWidget4.f(constraintAnchor, this.J, this.f1233x0);
                                constraintWidget4.f1117k0 = this.E0;
                                constraintWidget4.f1108f0 = f8;
                            }
                            if (i17 == i15 - 1) {
                                constraintWidget4.f(constraintWidget4.L, this.L, this.f1234y0);
                            }
                            if (i17 > 0 && constraintWidget3 != null) {
                                ConstraintAnchor constraintAnchor2 = constraintWidget3.L;
                                constraintWidget4.f(constraintAnchor, constraintAnchor2, this.Q0);
                                constraintWidget3.f(constraintAnchor2, constraintAnchor, 0);
                            }
                            constraintWidget3 = constraintWidget4;
                        }
                    }
                    i17++;
                    f9 = f8;
                }
                for (int i18 = 0; i18 < i16; i18++) {
                    ConstraintWidget constraintWidget5 = this.Y0[i18];
                    if (constraintWidget5 != null) {
                        ConstraintAnchor constraintAnchor3 = constraintWidget5.K;
                        if (constraintWidget5.f1113i0 != 8) {
                            if (i18 == 0) {
                                constraintWidget5.f(constraintAnchor3, this.K, this.f1229t0);
                                constraintWidget5.f1119l0 = this.F0;
                                constraintWidget5.f1110g0 = this.L0;
                            }
                            if (i18 == i16 - 1) {
                                constraintWidget5.f(constraintWidget5.M, this.M, this.f1230u0);
                            }
                            if (i18 > 0 && constraintWidget3 != null) {
                                ConstraintAnchor constraintAnchor4 = constraintWidget3.M;
                                constraintWidget5.f(constraintAnchor3, constraintAnchor4, this.R0);
                                constraintWidget3.f(constraintAnchor4, constraintAnchor3, 0);
                            }
                            constraintWidget3 = constraintWidget5;
                        }
                    }
                }
                for (int i19 = 0; i19 < i15; i19++) {
                    for (int i20 = 0; i20 < i16; i20++) {
                        int i21 = (i20 * i15) + i19;
                        if (this.W0 == 1) {
                            i21 = (i19 * i16) + i20;
                        }
                        ConstraintWidget[] constraintWidgetArr = this.f1204b1;
                        if (i21 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i21]) != null && constraintWidget.f1113i0 != 8) {
                            ConstraintWidget constraintWidget6 = this.Z0[i19];
                            ConstraintWidget constraintWidget7 = this.Y0[i20];
                            if (constraintWidget != constraintWidget6) {
                                constraintWidget.f(constraintWidget.J, constraintWidget6.J, 0);
                                constraintWidget.f(constraintWidget.L, constraintWidget6.L, 0);
                            }
                            if (constraintWidget != constraintWidget7) {
                                constraintWidget.f(constraintWidget.K, constraintWidget7.K, 0);
                                constraintWidget.f(constraintWidget.M, constraintWidget7.M, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            arrayList.get(0).b(0, z3, true);
        }
        this.z0 = false;
    }
}
