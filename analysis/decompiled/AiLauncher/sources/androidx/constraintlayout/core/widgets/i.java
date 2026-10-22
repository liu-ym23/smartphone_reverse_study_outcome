package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashSet;
import o0.C4994b;
import p0.C5034b;

/* loaded from: classes.dex */
public class i extends C4994b {

    /* renamed from: X0, reason: collision with root package name */
    public int f12169X0 = 0;

    /* renamed from: Y0, reason: collision with root package name */
    public int f12170Y0 = 0;

    /* renamed from: Z0, reason: collision with root package name */
    public int f12171Z0 = 0;

    /* renamed from: a1, reason: collision with root package name */
    public int f12172a1 = 0;

    /* renamed from: b1, reason: collision with root package name */
    public int f12173b1 = 0;

    /* renamed from: c1, reason: collision with root package name */
    public int f12174c1 = 0;

    /* renamed from: d1, reason: collision with root package name */
    public int f12175d1 = 0;

    /* renamed from: e1, reason: collision with root package name */
    public int f12176e1 = 0;

    /* renamed from: f1, reason: collision with root package name */
    public boolean f12177f1 = false;

    /* renamed from: g1, reason: collision with root package name */
    public int f12178g1 = 0;

    /* renamed from: h1, reason: collision with root package name */
    public int f12179h1 = 0;

    /* renamed from: i1, reason: collision with root package name */
    public C5034b.a f12180i1 = new C5034b.a();

    /* renamed from: j1, reason: collision with root package name */
    public C5034b.InterfaceC0492b f12181j1 = null;

    public boolean A1(HashSet<ConstraintWidget> hashSet) {
        for (int i10 = 0; i10 < this.f37461W0; i10++) {
            if (hashSet.contains(this.f37460V0[i10])) {
                return true;
            }
        }
        return false;
    }

    public int B1() {
        return this.f12179h1;
    }

    public int C1() {
        return this.f12178g1;
    }

    public int D1() {
        return this.f12170Y0;
    }

    public int E1() {
        return this.f12175d1;
    }

    public int F1() {
        return this.f12176e1;
    }

    public int G1() {
        return this.f12169X0;
    }

    public void H1(int i10, int i11, int i12, int i13) {
    }

    public void I1(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i10, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i11) {
        while (this.f12181j1 == null && M() != null) {
            this.f12181j1 = ((d) M()).O1();
        }
        C5034b.a aVar = this.f12180i1;
        aVar.f38013a = dimensionBehaviour;
        aVar.f38014b = dimensionBehaviour2;
        aVar.f38015c = i10;
        aVar.f38016d = i11;
        this.f12181j1.b(constraintWidget, aVar);
        constraintWidget.p1(this.f12180i1.f38017e);
        constraintWidget.Q0(this.f12180i1.f38018f);
        constraintWidget.P0(this.f12180i1.f38020h);
        constraintWidget.F0(this.f12180i1.f38019g);
    }

    public boolean J1() {
        ConstraintWidget constraintWidget = this.f11983c0;
        C5034b.InterfaceC0492b interfaceC0492bO1 = constraintWidget != null ? ((d) constraintWidget).O1() : null;
        if (interfaceC0492bO1 == null) {
            return false;
        }
        for (int i10 = 0; i10 < this.f37461W0; i10++) {
            ConstraintWidget constraintWidget2 = this.f37460V0[i10];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof f)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviourW = constraintWidget2.w(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviourW2 = constraintWidget2.w(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviourW != dimensionBehaviour || constraintWidget2.f12022w == 1 || dimensionBehaviourW2 != dimensionBehaviour || constraintWidget2.f12024x == 1) {
                    if (dimensionBehaviourW == dimensionBehaviour) {
                        dimensionBehaviourW = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (dimensionBehaviourW2 == dimensionBehaviour) {
                        dimensionBehaviourW2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    C5034b.a aVar = this.f12180i1;
                    aVar.f38013a = dimensionBehaviourW;
                    aVar.f38014b = dimensionBehaviourW2;
                    aVar.f38015c = constraintWidget2.Y();
                    this.f12180i1.f38016d = constraintWidget2.z();
                    interfaceC0492bO1.b(constraintWidget2, this.f12180i1);
                    constraintWidget2.p1(this.f12180i1.f38017e);
                    constraintWidget2.Q0(this.f12180i1.f38018f);
                    constraintWidget2.F0(this.f12180i1.f38019g);
                }
            }
        }
        return true;
    }

    public boolean K1() {
        return this.f12177f1;
    }

    public void L1(boolean z10) {
        this.f12177f1 = z10;
    }

    public void M1(int i10, int i11) {
        this.f12178g1 = i10;
        this.f12179h1 = i11;
    }

    public void N1(int i10) {
        this.f12171Z0 = i10;
        this.f12169X0 = i10;
        this.f12172a1 = i10;
        this.f12170Y0 = i10;
        this.f12173b1 = i10;
        this.f12174c1 = i10;
    }

    public void O1(int i10) {
        this.f12170Y0 = i10;
    }

    public void P1(int i10) {
        this.f12174c1 = i10;
    }

    public void Q1(int i10) {
        this.f12171Z0 = i10;
        this.f12175d1 = i10;
    }

    public void R1(int i10) {
        this.f12172a1 = i10;
        this.f12176e1 = i10;
    }

    public void S1(int i10) {
        this.f12173b1 = i10;
        this.f12175d1 = i10;
        this.f12176e1 = i10;
    }

    public void T1(int i10) {
        this.f12169X0 = i10;
    }

    @Override // o0.C4994b, o0.InterfaceC4993a
    public void c(d dVar) {
        z1();
    }

    public void y1(boolean z10) {
        int i10 = this.f12173b1;
        if (i10 > 0 || this.f12174c1 > 0) {
            if (z10) {
                this.f12175d1 = this.f12174c1;
                this.f12176e1 = i10;
            } else {
                this.f12175d1 = i10;
                this.f12176e1 = this.f12174c1;
            }
        }
    }

    public void z1() {
        for (int i10 = 0; i10 < this.f37461W0; i10++) {
            ConstraintWidget constraintWidget = this.f37460V0[i10];
            if (constraintWidget != null) {
                constraintWidget.Z0(true);
            }
        }
    }
}
