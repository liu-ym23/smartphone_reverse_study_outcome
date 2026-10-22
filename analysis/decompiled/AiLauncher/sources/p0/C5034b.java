package p0;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import o0.InterfaceC4993a;

/* renamed from: p0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5034b {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<ConstraintWidget> f38007a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    public a f38008b = new a();

    /* renamed from: c, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.d f38009c;

    /* renamed from: p0.b$a */
    public static class a {

        /* renamed from: k, reason: collision with root package name */
        public static int f38010k = 0;

        /* renamed from: l, reason: collision with root package name */
        public static int f38011l = 1;

        /* renamed from: m, reason: collision with root package name */
        public static int f38012m = 2;

        /* renamed from: a, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f38013a;

        /* renamed from: b, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f38014b;

        /* renamed from: c, reason: collision with root package name */
        public int f38015c;

        /* renamed from: d, reason: collision with root package name */
        public int f38016d;

        /* renamed from: e, reason: collision with root package name */
        public int f38017e;

        /* renamed from: f, reason: collision with root package name */
        public int f38018f;

        /* renamed from: g, reason: collision with root package name */
        public int f38019g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f38020h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f38021i;

        /* renamed from: j, reason: collision with root package name */
        public int f38022j;
    }

    /* renamed from: p0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0492b {
        void a();

        void b(ConstraintWidget constraintWidget, a aVar);
    }

    public C5034b(androidx.constraintlayout.core.widgets.d dVar) {
        this.f38009c = dVar;
    }

    public final boolean a(InterfaceC0492b interfaceC0492b, ConstraintWidget constraintWidget, int i10) {
        this.f38008b.f38013a = constraintWidget.C();
        this.f38008b.f38014b = constraintWidget.V();
        this.f38008b.f38015c = constraintWidget.Y();
        this.f38008b.f38016d = constraintWidget.z();
        a aVar = this.f38008b;
        aVar.f38021i = false;
        aVar.f38022j = i10;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f38013a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z10 = dimensionBehaviour == dimensionBehaviour2;
        boolean z11 = aVar.f38014b == dimensionBehaviour2;
        boolean z12 = z10 && constraintWidget.f11989f0 > 0.0f;
        boolean z13 = z11 && constraintWidget.f11989f0 > 0.0f;
        if (z12 && constraintWidget.f12026y[0] == 4) {
            aVar.f38013a = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z13 && constraintWidget.f12026y[1] == 4) {
            aVar.f38014b = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        interfaceC0492b.b(constraintWidget, aVar);
        constraintWidget.p1(this.f38008b.f38017e);
        constraintWidget.Q0(this.f38008b.f38018f);
        constraintWidget.P0(this.f38008b.f38020h);
        constraintWidget.F0(this.f38008b.f38019g);
        a aVar2 = this.f38008b;
        aVar2.f38022j = a.f38010k;
        return aVar2.f38021i;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0097 A[PHI: r10
      0x0097: PHI (r10v2 boolean) = (r10v1 boolean), (r10v1 boolean), (r10v1 boolean), (r10v4 boolean), (r10v4 boolean) binds: [B:32:0x0061, B:34:0x0067, B:36:0x006b, B:54:0x0094, B:52:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(androidx.constraintlayout.core.widgets.d r13) {
        /*
            r12 = this;
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r13.f37462V0
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r13.Z1(r1)
            p0.b$b r2 = r13.O1()
            r3 = 0
            r4 = r3
        L12:
            if (r4 >= r0) goto La4
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r5 = r13.f37462V0
            java.lang.Object r5 = r5.get(r4)
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r5
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.f
            if (r6 == 0) goto L22
            goto La0
        L22:
            boolean r6 = r5 instanceof androidx.constraintlayout.core.widgets.a
            if (r6 == 0) goto L28
            goto La0
        L28:
            boolean r6 = r5.n0()
            if (r6 == 0) goto L30
            goto La0
        L30:
            if (r1 == 0) goto L47
            androidx.constraintlayout.core.widgets.analyzer.c r6 = r5.f11986e
            if (r6 == 0) goto L47
            androidx.constraintlayout.core.widgets.analyzer.d r7 = r5.f11988f
            if (r7 == 0) goto L47
            androidx.constraintlayout.core.widgets.analyzer.a r6 = r6.f12051e
            boolean r6 = r6.f12044j
            if (r6 == 0) goto L47
            androidx.constraintlayout.core.widgets.analyzer.a r6 = r7.f12051e
            boolean r6 = r6.f12044j
            if (r6 == 0) goto L47
            goto La0
        L47:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r6 = r5.w(r3)
            r7 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r8 = r5.w(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r6 != r9) goto L60
            int r10 = r5.f12022w
            if (r10 == r7) goto L60
            if (r8 != r9) goto L60
            int r10 = r5.f12024x
            if (r10 == r7) goto L60
            r10 = r7
            goto L61
        L60:
            r10 = r3
        L61:
            if (r10 != 0) goto L97
            boolean r11 = r13.Z1(r7)
            if (r11 == 0) goto L97
            boolean r11 = r5 instanceof androidx.constraintlayout.core.widgets.i
            if (r11 != 0) goto L97
            if (r6 != r9) goto L7c
            int r11 = r5.f12022w
            if (r11 != 0) goto L7c
            if (r8 == r9) goto L7c
            boolean r11 = r5.k0()
            if (r11 != 0) goto L7c
            r10 = r7
        L7c:
            if (r8 != r9) goto L8b
            int r11 = r5.f12024x
            if (r11 != 0) goto L8b
            if (r6 == r9) goto L8b
            boolean r11 = r5.k0()
            if (r11 != 0) goto L8b
            r10 = r7
        L8b:
            if (r6 == r9) goto L8f
            if (r8 != r9) goto L97
        L8f:
            float r6 = r5.f11989f0
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L97
            goto L98
        L97:
            r7 = r10
        L98:
            if (r7 == 0) goto L9b
            goto La0
        L9b:
            int r6 = p0.C5034b.a.f38010k
            r12.a(r2, r5, r6)
        La0:
            int r4 = r4 + 1
            goto L12
        La4:
            r2.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.C5034b.b(androidx.constraintlayout.core.widgets.d):void");
    }

    public final void c(androidx.constraintlayout.core.widgets.d dVar, String str, int i10, int i11, int i12) {
        dVar.getClass();
        int iK = dVar.K();
        int iJ = dVar.J();
        dVar.f1(0);
        dVar.e1(0);
        dVar.p1(i11);
        dVar.Q0(i12);
        dVar.f1(iK);
        dVar.e1(iJ);
        this.f38009c.d2(i10);
        this.f38009c.x1();
    }

    public long d(androidx.constraintlayout.core.widgets.d dVar, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        boolean zM1;
        int i19;
        int i20;
        int i21;
        boolean z10;
        int i22;
        int i23;
        boolean z11;
        C5034b c5034b = this;
        InterfaceC0492b interfaceC0492bO1 = dVar.O1();
        int size = dVar.f37462V0.size();
        int iY = dVar.Y();
        int iZ = dVar.z();
        boolean zB = androidx.constraintlayout.core.widgets.g.b(i10, 128);
        boolean z12 = zB || androidx.constraintlayout.core.widgets.g.b(i10, 64);
        if (z12) {
            for (int i24 = 0; i24 < size; i24++) {
                ConstraintWidget constraintWidget = dVar.f37462V0.get(i24);
                ConstraintWidget.DimensionBehaviour dimensionBehaviourC = constraintWidget.C();
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z13 = (dimensionBehaviourC == dimensionBehaviour) && (constraintWidget.V() == dimensionBehaviour) && constraintWidget.x() > 0.0f;
                if ((constraintWidget.k0() && z13) || ((constraintWidget.m0() && z13) || (constraintWidget instanceof androidx.constraintlayout.core.widgets.i) || constraintWidget.k0() || constraintWidget.m0())) {
                    z12 = false;
                    break;
                }
            }
        }
        if (z12) {
            boolean z14 = androidx.constraintlayout.core.c.f11873s;
        }
        boolean z15 = z12 & ((i13 == 1073741824 && i15 == 1073741824) || zB);
        int i25 = 2;
        if (z15) {
            int iMin = Math.min(dVar.I(), i14);
            int iMin2 = Math.min(dVar.H(), i16);
            if (i13 == 1073741824 && dVar.Y() != iMin) {
                dVar.p1(iMin);
                dVar.S1();
            }
            if (i15 == 1073741824 && dVar.z() != iMin2) {
                dVar.Q0(iMin2);
                dVar.S1();
            }
            if (i13 == 1073741824 && i15 == 1073741824) {
                zM1 = dVar.K1(zB);
                i19 = 2;
            } else {
                boolean zL1 = dVar.L1(zB);
                if (i13 == 1073741824) {
                    zL1 &= dVar.M1(zB, 0);
                    i19 = 1;
                } else {
                    i19 = 0;
                }
                if (i15 == 1073741824) {
                    zM1 = dVar.M1(zB, 1) & zL1;
                    i19++;
                } else {
                    zM1 = zL1;
                }
            }
            if (zM1) {
                dVar.u1(i13 == 1073741824, i15 == 1073741824);
            }
        } else {
            zM1 = false;
            i19 = 0;
        }
        if (zM1 && i19 == 2) {
            return 0L;
        }
        int iP1 = dVar.P1();
        if (size > 0) {
            b(dVar);
        }
        e(dVar);
        int size2 = c5034b.f38007a.size();
        if (size > 0) {
            c5034b.c(dVar, "First pass", 0, iY, iZ);
            i20 = iY;
            i21 = iZ;
        } else {
            i20 = iY;
            i21 = iZ;
        }
        if (size2 > 0) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviourC2 = dVar.C();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z16 = dimensionBehaviourC2 == dimensionBehaviour2;
            boolean z17 = dVar.V() == dimensionBehaviour2;
            int iMax = Math.max(dVar.Y(), c5034b.f38009c.K());
            int iMax2 = Math.max(dVar.z(), c5034b.f38009c.J());
            int i26 = 0;
            boolean zK1 = false;
            while (i26 < size2) {
                ConstraintWidget constraintWidget2 = c5034b.f38007a.get(i26);
                if (constraintWidget2 instanceof androidx.constraintlayout.core.widgets.i) {
                    int iY2 = constraintWidget2.Y();
                    int iZ2 = constraintWidget2.z();
                    i23 = i20;
                    boolean zA = c5034b.a(interfaceC0492bO1, constraintWidget2, a.f38011l) | zK1;
                    int iY3 = constraintWidget2.Y();
                    int iZ3 = constraintWidget2.z();
                    if (iY3 != iY2) {
                        constraintWidget2.p1(iY3);
                        if (z16 && constraintWidget2.O() > iMax) {
                            iMax = Math.max(iMax, constraintWidget2.O() + constraintWidget2.q(ConstraintAnchor.Type.RIGHT).f());
                        }
                        z11 = true;
                    } else {
                        z11 = zA;
                    }
                    if (iZ3 != iZ2) {
                        constraintWidget2.Q0(iZ3);
                        if (z17 && constraintWidget2.t() > iMax2) {
                            iMax2 = Math.max(iMax2, constraintWidget2.t() + constraintWidget2.q(ConstraintAnchor.Type.BOTTOM).f());
                        }
                        z11 = true;
                    }
                    zK1 = z11 | ((androidx.constraintlayout.core.widgets.i) constraintWidget2).K1();
                } else {
                    i23 = i20;
                }
                i26++;
                i20 = i23;
                i25 = 2;
            }
            int i27 = i20;
            int i28 = i25;
            int i29 = 0;
            while (i29 < i28) {
                int i30 = 0;
                while (i30 < size2) {
                    ConstraintWidget constraintWidget3 = c5034b.f38007a.get(i30);
                    if (((constraintWidget3 instanceof InterfaceC4993a) && !(constraintWidget3 instanceof androidx.constraintlayout.core.widgets.i)) || (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.f) || constraintWidget3.X() == 8 || ((z15 && constraintWidget3.f11986e.f12051e.f12044j && constraintWidget3.f11988f.f12051e.f12044j) || (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.i))) {
                        z10 = z15;
                        i22 = size2;
                    } else {
                        int iY4 = constraintWidget3.Y();
                        int iZ4 = constraintWidget3.z();
                        z10 = z15;
                        int iR = constraintWidget3.r();
                        int i31 = a.f38011l;
                        i22 = size2;
                        if (i29 == 1) {
                            i31 = a.f38012m;
                        }
                        boolean zA2 = c5034b.a(interfaceC0492bO1, constraintWidget3, i31) | zK1;
                        int iY5 = constraintWidget3.Y();
                        int iZ5 = constraintWidget3.z();
                        if (iY5 != iY4) {
                            constraintWidget3.p1(iY5);
                            if (z16 && constraintWidget3.O() > iMax) {
                                iMax = Math.max(iMax, constraintWidget3.O() + constraintWidget3.q(ConstraintAnchor.Type.RIGHT).f());
                            }
                            zA2 = true;
                        }
                        if (iZ5 != iZ4) {
                            constraintWidget3.Q0(iZ5);
                            if (z17 && constraintWidget3.t() > iMax2) {
                                iMax2 = Math.max(iMax2, constraintWidget3.t() + constraintWidget3.q(ConstraintAnchor.Type.BOTTOM).f());
                            }
                            zA2 = true;
                        }
                        zK1 = (!constraintWidget3.b0() || iR == constraintWidget3.r()) ? zA2 : true;
                    }
                    i30++;
                    c5034b = this;
                    size2 = i22;
                    z15 = z10;
                }
                boolean z18 = z15;
                int i32 = size2;
                if (!zK1) {
                    break;
                }
                i29++;
                c(dVar, "intermediate pass", i29, i27, i21);
                c5034b = this;
                size2 = i32;
                z15 = z18;
                i28 = 2;
                zK1 = false;
            }
        }
        dVar.c2(iP1);
        return 0L;
    }

    public void e(androidx.constraintlayout.core.widgets.d dVar) {
        this.f38007a.clear();
        int size = dVar.f37462V0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = dVar.f37462V0.get(i10);
            ConstraintWidget.DimensionBehaviour dimensionBehaviourC = constraintWidget.C();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviourC == dimensionBehaviour || constraintWidget.V() == dimensionBehaviour) {
                this.f38007a.add(constraintWidget);
            }
        }
        dVar.S1();
    }
}
