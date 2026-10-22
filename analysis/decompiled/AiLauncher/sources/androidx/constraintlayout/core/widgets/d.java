package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.zyql.ai.selector.camera.CustomCameraView;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import l0.C4856b;
import o0.C4995c;
import p0.C5034b;
import p0.C5037e;

/* loaded from: classes.dex */
public class d extends C4995c {

    /* renamed from: Y0, reason: collision with root package name */
    public int f12088Y0;

    /* renamed from: c1, reason: collision with root package name */
    public int f12092c1;

    /* renamed from: d1, reason: collision with root package name */
    public int f12093d1;

    /* renamed from: e1, reason: collision with root package name */
    public int f12094e1;

    /* renamed from: f1, reason: collision with root package name */
    public int f12095f1;

    /* renamed from: W0, reason: collision with root package name */
    public C5034b f12086W0 = new C5034b(this);

    /* renamed from: X0, reason: collision with root package name */
    public C5037e f12087X0 = new C5037e(this);

    /* renamed from: Z0, reason: collision with root package name */
    public C5034b.InterfaceC0492b f12089Z0 = null;

    /* renamed from: a1, reason: collision with root package name */
    public boolean f12090a1 = false;

    /* renamed from: b1, reason: collision with root package name */
    public androidx.constraintlayout.core.c f12091b1 = new androidx.constraintlayout.core.c();

    /* renamed from: g1, reason: collision with root package name */
    public int f12096g1 = 0;

    /* renamed from: h1, reason: collision with root package name */
    public int f12097h1 = 0;

    /* renamed from: i1, reason: collision with root package name */
    public c[] f12098i1 = new c[4];

    /* renamed from: j1, reason: collision with root package name */
    public c[] f12099j1 = new c[4];

    /* renamed from: k1, reason: collision with root package name */
    public boolean f12100k1 = false;

    /* renamed from: l1, reason: collision with root package name */
    public boolean f12101l1 = false;

    /* renamed from: m1, reason: collision with root package name */
    public boolean f12102m1 = false;

    /* renamed from: n1, reason: collision with root package name */
    public int f12103n1 = 0;

    /* renamed from: o1, reason: collision with root package name */
    public int f12104o1 = 0;

    /* renamed from: p1, reason: collision with root package name */
    public int f12105p1 = CustomCameraView.BUTTON_STATE_ONLY_CAPTURE;

    /* renamed from: q1, reason: collision with root package name */
    public boolean f12106q1 = false;

    /* renamed from: r1, reason: collision with root package name */
    public boolean f12107r1 = false;

    /* renamed from: s1, reason: collision with root package name */
    public boolean f12108s1 = false;

    /* renamed from: t1, reason: collision with root package name */
    public int f12109t1 = 0;

    /* renamed from: u1, reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f12110u1 = null;

    /* renamed from: v1, reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f12111v1 = null;

    /* renamed from: w1, reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f12112w1 = null;

    /* renamed from: x1, reason: collision with root package name */
    public WeakReference<ConstraintAnchor> f12113x1 = null;

    /* renamed from: y1, reason: collision with root package name */
    public HashSet<ConstraintWidget> f12114y1 = new HashSet<>();

    /* renamed from: z1, reason: collision with root package name */
    public C5034b.a f12115z1 = new C5034b.a();

    public static boolean Y1(int i10, ConstraintWidget constraintWidget, C5034b.InterfaceC0492b interfaceC0492b, C5034b.a aVar, int i11) {
        int i12;
        int i13;
        if (interfaceC0492b == null) {
            return false;
        }
        if (constraintWidget.X() == 8 || (constraintWidget instanceof f) || (constraintWidget instanceof a)) {
            aVar.f38017e = 0;
            aVar.f38018f = 0;
            return false;
        }
        aVar.f38013a = constraintWidget.C();
        aVar.f38014b = constraintWidget.V();
        aVar.f38015c = constraintWidget.Y();
        aVar.f38016d = constraintWidget.z();
        aVar.f38021i = false;
        aVar.f38022j = i11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f38013a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z10 = dimensionBehaviour == dimensionBehaviour2;
        boolean z11 = aVar.f38014b == dimensionBehaviour2;
        boolean z12 = z10 && constraintWidget.f11989f0 > 0.0f;
        boolean z13 = z11 && constraintWidget.f11989f0 > 0.0f;
        if (z10 && constraintWidget.c0(0) && constraintWidget.f12022w == 0 && !z12) {
            aVar.f38013a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z11 && constraintWidget.f12024x == 0) {
                aVar.f38013a = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z10 = false;
        }
        if (z11 && constraintWidget.c0(1) && constraintWidget.f12024x == 0 && !z13) {
            aVar.f38014b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z10 && constraintWidget.f12022w == 0) {
                aVar.f38014b = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z11 = false;
        }
        if (constraintWidget.p0()) {
            aVar.f38013a = ConstraintWidget.DimensionBehaviour.FIXED;
            z10 = false;
        }
        if (constraintWidget.q0()) {
            aVar.f38014b = ConstraintWidget.DimensionBehaviour.FIXED;
            z11 = false;
        }
        if (z12) {
            if (constraintWidget.f12026y[0] == 4) {
                aVar.f38013a = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z11) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = aVar.f38014b;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour3 == dimensionBehaviour4) {
                    i13 = aVar.f38016d;
                } else {
                    aVar.f38013a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    interfaceC0492b.b(constraintWidget, aVar);
                    i13 = aVar.f38018f;
                }
                aVar.f38013a = dimensionBehaviour4;
                aVar.f38015c = (int) (constraintWidget.x() * i13);
            }
        }
        if (z13) {
            if (constraintWidget.f12026y[1] == 4) {
                aVar.f38014b = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z10) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = aVar.f38013a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour5 == dimensionBehaviour6) {
                    i12 = aVar.f38015c;
                } else {
                    aVar.f38014b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    interfaceC0492b.b(constraintWidget, aVar);
                    i12 = aVar.f38017e;
                }
                aVar.f38014b = dimensionBehaviour6;
                if (constraintWidget.y() == -1) {
                    aVar.f38016d = (int) (i12 / constraintWidget.x());
                } else {
                    aVar.f38016d = (int) (constraintWidget.x() * i12);
                }
            }
        }
        interfaceC0492b.b(constraintWidget, aVar);
        constraintWidget.p1(aVar.f38017e);
        constraintWidget.Q0(aVar.f38018f);
        constraintWidget.P0(aVar.f38020h);
        constraintWidget.F0(aVar.f38019g);
        aVar.f38022j = C5034b.a.f38010k;
        return aVar.f38021i;
    }

    public void A1(ConstraintWidget constraintWidget, int i10) {
        if (i10 == 0) {
            C1(constraintWidget);
        } else if (i10 == 1) {
            H1(constraintWidget);
        }
    }

    public boolean B1(androidx.constraintlayout.core.c cVar) {
        d dVar;
        androidx.constraintlayout.core.c cVar2;
        boolean zZ1 = Z1(64);
        g(cVar, zZ1);
        int size = this.f37462V0.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.f37462V0.get(i10);
            constraintWidget.X0(0, false);
            constraintWidget.X0(1, false);
            if (constraintWidget instanceof a) {
                z10 = true;
            }
        }
        if (z10) {
            for (int i11 = 0; i11 < size; i11++) {
                ConstraintWidget constraintWidget2 = this.f37462V0.get(i11);
                if (constraintWidget2 instanceof a) {
                    ((a) constraintWidget2).D1();
                }
            }
        }
        this.f12114y1.clear();
        for (int i12 = 0; i12 < size; i12++) {
            ConstraintWidget constraintWidget3 = this.f37462V0.get(i12);
            if (constraintWidget3.f()) {
                if (constraintWidget3 instanceof i) {
                    this.f12114y1.add(constraintWidget3);
                } else {
                    constraintWidget3.g(cVar, zZ1);
                }
            }
        }
        while (this.f12114y1.size() > 0) {
            int size2 = this.f12114y1.size();
            Iterator<ConstraintWidget> it = this.f12114y1.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i iVar = (i) it.next();
                if (iVar.A1(this.f12114y1)) {
                    iVar.g(cVar, zZ1);
                    this.f12114y1.remove(iVar);
                    break;
                }
            }
            if (size2 == this.f12114y1.size()) {
                Iterator<ConstraintWidget> it2 = this.f12114y1.iterator();
                while (it2.hasNext()) {
                    it2.next().g(cVar, zZ1);
                }
                this.f12114y1.clear();
            }
        }
        if (androidx.constraintlayout.core.c.f11873s) {
            HashSet<ConstraintWidget> hashSet = new HashSet<>();
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget4 = this.f37462V0.get(i13);
                if (!constraintWidget4.f()) {
                    hashSet.add(constraintWidget4);
                }
            }
            dVar = this;
            cVar2 = cVar;
            dVar.e(this, cVar2, hashSet, C() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
            Iterator<ConstraintWidget> it3 = hashSet.iterator();
            while (it3.hasNext()) {
                ConstraintWidget next = it3.next();
                g.a(dVar, cVar2, next);
                next.g(cVar2, zZ1);
            }
        } else {
            dVar = this;
            cVar2 = cVar;
            for (int i14 = 0; i14 < size; i14++) {
                ConstraintWidget constraintWidget5 = dVar.f37462V0.get(i14);
                if (constraintWidget5 instanceof d) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget5.f11981b0;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget5.U0(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget5.l1(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget5.g(cVar2, zZ1);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget5.U0(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget5.l1(dimensionBehaviour2);
                    }
                } else {
                    g.a(dVar, cVar2, constraintWidget5);
                    if (!constraintWidget5.f()) {
                        constraintWidget5.g(cVar2, zZ1);
                    }
                }
            }
        }
        if (dVar.f12096g1 > 0) {
            b.b(dVar, cVar2, null, 0);
        }
        if (dVar.f12097h1 > 0) {
            b.b(dVar, cVar2, null, 1);
        }
        return true;
    }

    public final void C1(ConstraintWidget constraintWidget) {
        int i10 = this.f12096g1 + 1;
        c[] cVarArr = this.f12099j1;
        if (i10 >= cVarArr.length) {
            this.f12099j1 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f12099j1[this.f12096g1] = new c(constraintWidget, 0, V1());
        this.f12096g1++;
    }

    public void D1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f12113x1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f12113x1.get().e()) {
            this.f12113x1 = new WeakReference<>(constraintAnchor);
        }
    }

    public void E1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f12111v1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f12111v1.get().e()) {
            this.f12111v1 = new WeakReference<>(constraintAnchor);
        }
    }

    public final void F1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.f12091b1.h(solverVariable, this.f12091b1.q(constraintAnchor), 0, 5);
    }

    public final void G1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.f12091b1.h(this.f12091b1.q(constraintAnchor), solverVariable, 0, 5);
    }

    public final void H1(ConstraintWidget constraintWidget) {
        int i10 = this.f12097h1 + 1;
        c[] cVarArr = this.f12098i1;
        if (i10 >= cVarArr.length) {
            this.f12098i1 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.f12098i1[this.f12097h1] = new c(constraintWidget, 1, V1());
        this.f12097h1++;
    }

    public void I1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f12112w1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f12112w1.get().e()) {
            this.f12112w1 = new WeakReference<>(constraintAnchor);
        }
    }

    public void J1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.f12110u1;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.e() > this.f12110u1.get().e()) {
            this.f12110u1 = new WeakReference<>(constraintAnchor);
        }
    }

    public boolean K1(boolean z10) {
        return this.f12087X0.f(z10);
    }

    public boolean L1(boolean z10) {
        return this.f12087X0.g(z10);
    }

    public boolean M1(boolean z10, int i10) {
        return this.f12087X0.h(z10, i10);
    }

    public void N1(C4856b c4856b) {
        this.f12091b1.v(c4856b);
    }

    public C5034b.InterfaceC0492b O1() {
        return this.f12089Z0;
    }

    public int P1() {
        return this.f12105p1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void Q(StringBuilder sb2) {
        sb2.append(this.f12006o + ":{\n");
        sb2.append("  actualWidth:" + this.f11985d0);
        sb2.append("\n");
        sb2.append("  actualHeight:" + this.f11987e0);
        sb2.append("\n");
        Iterator<ConstraintWidget> it = w1().iterator();
        while (it.hasNext()) {
            it.next().Q(sb2);
            sb2.append(",\n");
        }
        sb2.append("}");
    }

    public androidx.constraintlayout.core.c Q1() {
        return this.f12091b1;
    }

    public boolean R1() {
        return false;
    }

    public void S1() {
        this.f12087X0.j();
    }

    public void T1() {
        this.f12087X0.k();
    }

    public boolean U1() {
        return this.f12108s1;
    }

    public boolean V1() {
        return this.f12090a1;
    }

    public boolean W1() {
        return this.f12107r1;
    }

    public long X1(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        this.f12092c1 = i17;
        this.f12093d1 = i18;
        return this.f12086W0.d(this, i10, i17, i18, i11, i12, i13, i14, i15, i16);
    }

    public boolean Z1(int i10) {
        return (this.f12105p1 & i10) == i10;
    }

    public final void a2() {
        this.f12096g1 = 0;
        this.f12097h1 = 0;
    }

    public void b2(C5034b.InterfaceC0492b interfaceC0492b) {
        this.f12089Z0 = interfaceC0492b;
        this.f12087X0.n(interfaceC0492b);
    }

    public void c2(int i10) {
        this.f12105p1 = i10;
        androidx.constraintlayout.core.c.f11873s = Z1(512);
    }

    public void d2(int i10) {
        this.f12088Y0 = i10;
    }

    public void e2(boolean z10) {
        this.f12090a1 = z10;
    }

    public boolean f2(androidx.constraintlayout.core.c cVar, boolean[] zArr) {
        zArr[2] = false;
        boolean zZ1 = Z1(64);
        v1(cVar, zZ1);
        int size = this.f37462V0.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.f37462V0.get(i10);
            constraintWidget.v1(cVar, zZ1);
            if (constraintWidget.e0()) {
                z10 = true;
            }
        }
        return z10;
    }

    public void g2() {
        this.f12086W0.e(this);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void u1(boolean z10, boolean z11) {
        super.u1(z10, z11);
        int size = this.f37462V0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f37462V0.get(i10).u1(z10, z11);
        }
    }

    @Override // o0.C4995c, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void v0() {
        this.f12091b1.E();
        this.f12092c1 = 0;
        this.f12094e1 = 0;
        this.f12093d1 = 0;
        this.f12095f1 = 0;
        this.f12106q1 = false;
        super.v0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x023c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0329 A[PHI: r13 r19
      0x0329: PHI (r13v9 boolean) = (r13v8 boolean), (r13v11 boolean), (r13v11 boolean), (r13v11 boolean) binds: [B:150:0x02e5, B:159:0x030e, B:160:0x0310, B:162:0x0316] A[DONT_GENERATE, DONT_INLINE]
      0x0329: PHI (r19v4 boolean) = (r19v3 boolean), (r19v6 boolean), (r19v6 boolean), (r19v6 boolean) binds: [B:150:0x02e5, B:159:0x030e, B:160:0x0310, B:162:0x0316] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0330  */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [boolean] */
    @Override // o0.C4995c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void x1() {
        /*
            Method dump skipped, instructions count: 850
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.d.x1():void");
    }
}
