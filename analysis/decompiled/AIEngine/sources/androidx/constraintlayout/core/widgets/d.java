package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import androidx.constraintlayout.widget.ConstraintLayout;
import h0.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends g0.b {
    public int A0;
    public int B0;
    public c[] C0;
    public c[] D0;
    public int E0;
    public boolean F0;
    public boolean G0;
    public WeakReference<ConstraintAnchor> H0;
    public WeakReference<ConstraintAnchor> I0;
    public WeakReference<ConstraintAnchor> J0;
    public WeakReference<ConstraintAnchor> K0;
    public final HashSet<ConstraintWidget> L0;
    public final b.a M0;

    /* renamed from: s0, reason: collision with root package name */
    public final h0.b f1196s0 = new h0.b(this);

    /* renamed from: t0, reason: collision with root package name */
    public final h0.f f1197t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f1198u0;

    /* renamed from: v0, reason: collision with root package name */
    public b.InterfaceC0086b f1199v0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f1200w0;

    /* renamed from: x0, reason: collision with root package name */
    public final androidx.constraintlayout.core.c f1201x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f1202y0;
    public int z0;

    public d() {
        h0.f fVar = new h0.f();
        fVar.f9190b = true;
        fVar.f9191c = true;
        fVar.f9193e = new ArrayList<>();
        new ArrayList();
        fVar.f9194f = null;
        fVar.f9195g = new b.a();
        fVar.h = new ArrayList<>();
        fVar.f9189a = this;
        fVar.f9192d = this;
        this.f1197t0 = fVar;
        this.f1199v0 = null;
        this.f1200w0 = false;
        this.f1201x0 = new androidx.constraintlayout.core.c();
        this.A0 = 0;
        this.B0 = 0;
        this.C0 = new c[4];
        this.D0 = new c[4];
        this.E0 = 257;
        this.F0 = false;
        this.G0 = false;
        this.H0 = null;
        this.I0 = null;
        this.J0 = null;
        this.K0 = null;
        this.L0 = new HashSet<>();
        this.M0 = new b.a();
    }

    public static void V(ConstraintWidget constraintWidget, b.InterfaceC0086b interfaceC0086b, b.a aVar) {
        int i10;
        int i11;
        if (interfaceC0086b == null) {
            return;
        }
        int i12 = constraintWidget.f1113i0;
        int[] iArr = constraintWidget.f1130t;
        if (i12 == 8 || (constraintWidget instanceof f) || (constraintWidget instanceof a)) {
            aVar.f9182e = 0;
            aVar.f9183f = 0;
            return;
        }
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.U;
        aVar.f9178a = dimensionBehaviourArr[0];
        aVar.f9179b = dimensionBehaviourArr[1];
        aVar.f9180c = constraintWidget.q();
        aVar.f9181d = constraintWidget.k();
        aVar.f9185i = false;
        aVar.f9186j = 0;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f9178a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.f1138c;
        boolean z = dimensionBehaviour == dimensionBehaviour2;
        boolean z3 = aVar.f9179b == dimensionBehaviour2;
        boolean z10 = z && constraintWidget.Y > 0.0f;
        boolean z11 = z3 && constraintWidget.Y > 0.0f;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.f1137b;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.f1136a;
        if (z && constraintWidget.t(0) && constraintWidget.r == 0 && !z10) {
            aVar.f9178a = dimensionBehaviour3;
            if (z3 && constraintWidget.f1129s == 0) {
                aVar.f9178a = dimensionBehaviour4;
            }
            z = false;
        }
        if (z3 && constraintWidget.t(1) && constraintWidget.f1129s == 0 && !z11) {
            aVar.f9179b = dimensionBehaviour3;
            if (z && constraintWidget.r == 0) {
                aVar.f9179b = dimensionBehaviour4;
            }
            z3 = false;
        }
        if (constraintWidget.A()) {
            aVar.f9178a = dimensionBehaviour4;
            z = false;
        }
        if (constraintWidget.B()) {
            aVar.f9179b = dimensionBehaviour4;
            z3 = false;
        }
        if (z10) {
            if (iArr[0] == 4) {
                aVar.f9178a = dimensionBehaviour4;
            } else if (!z3) {
                if (aVar.f9179b == dimensionBehaviour4) {
                    i11 = aVar.f9181d;
                } else {
                    aVar.f9178a = dimensionBehaviour3;
                    ((ConstraintLayout.b) interfaceC0086b).b(constraintWidget, aVar);
                    i11 = aVar.f9183f;
                }
                aVar.f9178a = dimensionBehaviour4;
                aVar.f9180c = (int) (constraintWidget.Y * i11);
            }
        }
        if (z11) {
            if (iArr[1] == 4) {
                aVar.f9179b = dimensionBehaviour4;
            } else if (!z) {
                if (aVar.f9178a == dimensionBehaviour4) {
                    i10 = aVar.f9180c;
                } else {
                    aVar.f9179b = dimensionBehaviour3;
                    ((ConstraintLayout.b) interfaceC0086b).b(constraintWidget, aVar);
                    i10 = aVar.f9182e;
                }
                aVar.f9179b = dimensionBehaviour4;
                if (constraintWidget.Z == -1) {
                    aVar.f9181d = (int) (i10 / constraintWidget.Y);
                } else {
                    aVar.f9181d = (int) (constraintWidget.Y * i10);
                }
            }
        }
        ((ConstraintLayout.b) interfaceC0086b).b(constraintWidget, aVar);
        constraintWidget.O(aVar.f9182e);
        constraintWidget.L(aVar.f9183f);
        constraintWidget.E = aVar.h;
        constraintWidget.I(aVar.f9184g);
        aVar.f9186j = 0;
    }

    @Override // g0.b, androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void C() {
        this.f1201x0.t();
        this.f1202y0 = 0;
        this.z0 = 0;
        super.C();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void P(boolean z, boolean z3) {
        super.P(z, z3);
        int size = this.f8946r0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f8946r0.get(i10).P(z, z3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:339:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:364:0x065c  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x0672  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0682  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x068d  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0698 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:384:0x069e  */
    /* JADX WARN: Removed duplicated region for block: B:387:0x06a5  */
    /* JADX WARN: Removed duplicated region for block: B:391:0x06ac  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x06b6  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:427:0x0740  */
    /* JADX WARN: Removed duplicated region for block: B:466:0x07f9  */
    /* JADX WARN: Removed duplicated region for block: B:475:0x0838  */
    /* JADX WARN: Removed duplicated region for block: B:481:0x0854 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:496:0x08b8  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x08ca  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x08e4  */
    /* JADX WARN: Removed duplicated region for block: B:503:0x08ee  */
    /* JADX WARN: Removed duplicated region for block: B:505:0x08f1  */
    /* JADX WARN: Removed duplicated region for block: B:517:0x0921 A[PHI: r15 r25
      0x0921: PHI (r15v10 boolean) = (r15v9 boolean), (r15v14 boolean), (r15v14 boolean), (r15v14 boolean) binds: [B:504:0x08ef, B:512:0x090b, B:513:0x090d, B:515:0x0913] A[DONT_GENERATE, DONT_INLINE]
      0x0921: PHI (r25v7 boolean) = (r25v6 boolean), (r25v8 boolean), (r25v8 boolean), (r25v8 boolean) binds: [B:504:0x08ef, B:512:0x090b, B:513:0x090d, B:515:0x0913] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:519:0x0927  */
    /* JADX WARN: Removed duplicated region for block: B:523:0x0939  */
    /* JADX WARN: Removed duplicated region for block: B:593:0x0928 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r14v9 */
    @Override // g0.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R() {
        /*
            Method dump skipped, instructions count: 2375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.d.R():void");
    }

    public final void S(ConstraintWidget constraintWidget, int i10) {
        if (i10 == 0) {
            int i11 = this.A0 + 1;
            c[] cVarArr = this.D0;
            if (i11 >= cVarArr.length) {
                this.D0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
            }
            c[] cVarArr2 = this.D0;
            int i12 = this.A0;
            cVarArr2[i12] = new c(constraintWidget, 0, this.f1200w0);
            this.A0 = i12 + 1;
            return;
        }
        if (i10 == 1) {
            int i13 = this.B0 + 1;
            c[] cVarArr3 = this.C0;
            if (i13 >= cVarArr3.length) {
                this.C0 = (c[]) Arrays.copyOf(cVarArr3, cVarArr3.length * 2);
            }
            c[] cVarArr4 = this.C0;
            int i14 = this.B0;
            cVarArr4[i14] = new c(constraintWidget, 1, this.f1200w0);
            this.B0 = i14 + 1;
        }
    }

    public final void T(androidx.constraintlayout.core.c cVar) {
        d dVar;
        androidx.constraintlayout.core.c cVar2;
        boolean zW = W(64);
        b(cVar, zW);
        int size = this.f8946r0.size();
        boolean z = false;
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.f8946r0.get(i10);
            boolean[] zArr = constraintWidget.T;
            zArr[0] = false;
            zArr[1] = false;
            if (constraintWidget instanceof a) {
                z = true;
            }
        }
        if (z) {
            for (int i11 = 0; i11 < size; i11++) {
                ConstraintWidget constraintWidget2 = this.f8946r0.get(i11);
                if (constraintWidget2 instanceof a) {
                    a aVar = (a) constraintWidget2;
                    for (int i12 = 0; i12 < aVar.f8945s0; i12++) {
                        ConstraintWidget constraintWidget3 = aVar.f8944r0[i12];
                        if (aVar.f1142u0 || constraintWidget3.c()) {
                            int i13 = aVar.f1141t0;
                            if (i13 == 0 || i13 == 1) {
                                constraintWidget3.T[0] = true;
                            } else if (i13 == 2 || i13 == 3) {
                                constraintWidget3.T[1] = true;
                            }
                        }
                    }
                }
            }
        }
        HashSet<ConstraintWidget> hashSet = this.L0;
        hashSet.clear();
        for (int i14 = 0; i14 < size; i14++) {
            ConstraintWidget constraintWidget4 = this.f8946r0.get(i14);
            constraintWidget4.getClass();
            boolean z3 = constraintWidget4 instanceof h;
            if (z3 || (constraintWidget4 instanceof f)) {
                if (z3) {
                    hashSet.add(constraintWidget4);
                } else {
                    constraintWidget4.b(cVar, zW);
                }
            }
        }
        while (hashSet.size() > 0) {
            int size2 = hashSet.size();
            Iterator<ConstraintWidget> it = hashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h hVar = (h) it.next();
                for (int i15 = 0; i15 < hVar.f8945s0; i15++) {
                    if (hashSet.contains(hVar.f8944r0[i15])) {
                        hVar.b(cVar, zW);
                        hashSet.remove(hVar);
                        break;
                    }
                }
            }
            if (size2 == hashSet.size()) {
                Iterator<ConstraintWidget> it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    it2.next().b(cVar, zW);
                }
                hashSet.clear();
            }
        }
        boolean z10 = androidx.constraintlayout.core.c.f1062q;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1137b;
        if (z10) {
            HashSet<ConstraintWidget> hashSet2 = new HashSet<>();
            for (int i16 = 0; i16 < size; i16++) {
                ConstraintWidget constraintWidget5 = this.f8946r0.get(i16);
                constraintWidget5.getClass();
                if (!(constraintWidget5 instanceof h) && !(constraintWidget5 instanceof f)) {
                    hashSet2.add(constraintWidget5);
                }
            }
            dVar = this;
            cVar2 = cVar;
            dVar.a(this, cVar2, hashSet2, this.U[0] == dimensionBehaviour ? 0 : 1, false);
            Iterator<ConstraintWidget> it3 = hashSet2.iterator();
            while (it3.hasNext()) {
                ConstraintWidget next = it3.next();
                g.a(dVar, cVar2, next);
                next.b(cVar2, zW);
            }
        } else {
            dVar = this;
            cVar2 = cVar;
            for (int i17 = 0; i17 < size; i17++) {
                ConstraintWidget constraintWidget6 = dVar.f8946r0.get(i17);
                if (constraintWidget6 instanceof d) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget6.U;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.f1136a;
                    if (dimensionBehaviour2 == dimensionBehaviour) {
                        constraintWidget6.M(dimensionBehaviour4);
                    }
                    if (dimensionBehaviour3 == dimensionBehaviour) {
                        constraintWidget6.N(dimensionBehaviour4);
                    }
                    constraintWidget6.b(cVar2, zW);
                    if (dimensionBehaviour2 == dimensionBehaviour) {
                        constraintWidget6.M(dimensionBehaviour2);
                    }
                    if (dimensionBehaviour3 == dimensionBehaviour) {
                        constraintWidget6.N(dimensionBehaviour3);
                    }
                } else {
                    g.a(dVar, cVar2, constraintWidget6);
                    if (!(constraintWidget6 instanceof h) && !(constraintWidget6 instanceof f)) {
                        constraintWidget6.b(cVar2, zW);
                    }
                }
            }
        }
        if (dVar.A0 > 0) {
            b.a(dVar, cVar2, null, 0);
        }
        if (dVar.B0 > 0) {
            b.a(dVar, cVar2, null, 1);
        }
    }

    public final boolean U(int i10, boolean z) {
        boolean z3;
        boolean z10;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        boolean z11;
        h0.f fVar = this.f1197t0;
        ArrayList<WidgetRun> arrayList = fVar.f9193e;
        d dVar = fVar.f9189a;
        boolean z12 = false;
        ConstraintWidget.DimensionBehaviour dimensionBehaviourJ = dVar.j(0);
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = dVar.U;
        ConstraintWidget.DimensionBehaviour dimensionBehaviourJ2 = dVar.j(1);
        int iR = dVar.r();
        int iS = dVar.s();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.f1136a;
        if (z && (dimensionBehaviourJ == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1137b) || dimensionBehaviourJ2 == dimensionBehaviour)) {
            int size = arrayList.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    z11 = z;
                    break;
                }
                WidgetRun widgetRun = arrayList.get(i11);
                i11++;
                WidgetRun widgetRun2 = widgetRun;
                if (widgetRun2.f1169f == i10 && !widgetRun2.k()) {
                    z11 = false;
                    break;
                }
            }
            if (i10 == 0) {
                if (z11 && dimensionBehaviourJ == dimensionBehaviour) {
                    dVar.M(dimensionBehaviour2);
                    dVar.O(fVar.d(dVar, 0));
                    dVar.f1103d.f1168e.d(dVar.q());
                }
            } else if (z11 && dimensionBehaviourJ2 == dimensionBehaviour) {
                dVar.N(dimensionBehaviour2);
                dVar.L(fVar.d(dVar, 1));
                dVar.f1105e.f1168e.d(dVar.k());
            }
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.f1139d;
        if (i10 == 0) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = dimensionBehaviourArr[0];
            if (dimensionBehaviour4 == dimensionBehaviour2 || dimensionBehaviour4 == dimensionBehaviour3) {
                int iQ = dVar.q() + iR;
                dVar.f1103d.f1171i.d(iQ);
                dVar.f1103d.f1168e.d(iQ - iR);
                z10 = true;
                z3 = true;
            } else {
                z3 = true;
                z10 = false;
            }
        } else {
            z3 = true;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr[1];
            if (dimensionBehaviour5 == dimensionBehaviour2 || dimensionBehaviour5 == dimensionBehaviour3) {
                int iK = dVar.k() + iS;
                dVar.f1105e.f1171i.d(iK);
                dVar.f1105e.f1168e.d(iK - iS);
                z10 = true;
            } else {
                z10 = false;
            }
        }
        fVar.g();
        int size2 = arrayList.size();
        int i12 = 0;
        while (i12 < size2) {
            WidgetRun widgetRun3 = arrayList.get(i12);
            i12++;
            WidgetRun widgetRun4 = widgetRun3;
            if (widgetRun4.f1169f == i10 && (widgetRun4.f1165b != dVar || widgetRun4.f1170g)) {
                widgetRun4.e();
            }
        }
        int size3 = arrayList.size();
        int i13 = 0;
        while (true) {
            if (i13 >= size3) {
                z12 = z3;
                break;
            }
            WidgetRun widgetRun5 = arrayList.get(i13);
            i13++;
            WidgetRun widgetRun6 = widgetRun5;
            if (widgetRun6.f1169f == i10 && (z10 || widgetRun6.f1165b != dVar)) {
                if (!widgetRun6.h.f1153j || !widgetRun6.f1171i.f1153j || (!(widgetRun6 instanceof h0.c) && !widgetRun6.f1168e.f1153j)) {
                    break;
                }
            }
        }
        dVar.M(dimensionBehaviourJ);
        dVar.N(dimensionBehaviourJ2);
        return z12;
    }

    public final boolean W(int i10) {
        return (this.E0 & i10) == i10;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void n(StringBuilder sb2) {
        sb2.append(this.f1114j + ":{\n");
        StringBuilder sb3 = new StringBuilder("  actualWidth:");
        sb3.append(this.W);
        sb2.append(sb3.toString());
        sb2.append("\n");
        sb2.append("  actualHeight:" + this.X);
        sb2.append("\n");
        ArrayList<ConstraintWidget> arrayList = this.f8946r0;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            ConstraintWidget constraintWidget = arrayList.get(i10);
            i10++;
            constraintWidget.n(sb2);
            sb2.append(",\n");
        }
        sb2.append("}");
    }
}
