package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import o0.InterfaceC4993a;

/* loaded from: classes.dex */
public class c extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    public static int[] f12059k = new int[2];

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12060a;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f12060a = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12060a[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12060a[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public c(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.f12054h.f12039e = DependencyNode.Type.LEFT;
        this.f12055i.f12039e = DependencyNode.Type.RIGHT;
        this.f12052f = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x02ca  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, p0.InterfaceC5036d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(p0.InterfaceC5036d r14) {
        /*
            Method dump skipped, instructions count: 1067
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.c.a(p0.d):void");
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget constraintWidgetM;
        ConstraintWidget constraintWidgetM2;
        ConstraintWidget constraintWidget = this.f12048b;
        if (constraintWidget.f11978a) {
            this.f12051e.d(constraintWidget.Y());
        }
        if (this.f12051e.f12044j) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.f12050d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour == dimensionBehaviour2 && (constraintWidgetM = this.f12048b.M()) != null && (constraintWidgetM.C() == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetM.C() == dimensionBehaviour2)) {
                b(this.f12054h, constraintWidgetM.f11986e.f12054h, this.f12048b.f11964Q.f());
                b(this.f12055i, constraintWidgetM.f11986e.f12055i, -this.f12048b.f11968S.f());
                return;
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviourC = this.f12048b.C();
            this.f12050d = dimensionBehaviourC;
            if (dimensionBehaviourC != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (dimensionBehaviourC == dimensionBehaviour3 && (constraintWidgetM2 = this.f12048b.M()) != null && (constraintWidgetM2.C() == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidgetM2.C() == dimensionBehaviour3)) {
                    int iY = (constraintWidgetM2.Y() - this.f12048b.f11964Q.f()) - this.f12048b.f11968S.f();
                    b(this.f12054h, constraintWidgetM2.f11986e.f12054h, this.f12048b.f11964Q.f());
                    b(this.f12055i, constraintWidgetM2.f11986e.f12055i, -this.f12048b.f11968S.f());
                    this.f12051e.d(iY);
                    return;
                }
                if (this.f12050d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f12051e.d(this.f12048b.Y());
                }
            }
        }
        androidx.constraintlayout.core.widgets.analyzer.a aVar = this.f12051e;
        if (aVar.f12044j) {
            ConstraintWidget constraintWidget2 = this.f12048b;
            if (constraintWidget2.f11978a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.f11976Y;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f11927f;
                if (constraintAnchor2 != null && constraintAnchorArr[1].f11927f != null) {
                    if (constraintWidget2.k0()) {
                        this.f12054h.f12040f = this.f12048b.f11976Y[0].f();
                        this.f12055i.f12040f = -this.f12048b.f11976Y[1].f();
                        return;
                    }
                    DependencyNode dependencyNodeH = h(this.f12048b.f11976Y[0]);
                    if (dependencyNodeH != null) {
                        b(this.f12054h, dependencyNodeH, this.f12048b.f11976Y[0].f());
                    }
                    DependencyNode dependencyNodeH2 = h(this.f12048b.f11976Y[1]);
                    if (dependencyNodeH2 != null) {
                        b(this.f12055i, dependencyNodeH2, -this.f12048b.f11976Y[1].f());
                    }
                    this.f12054h.f12036b = true;
                    this.f12055i.f12036b = true;
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode dependencyNodeH3 = h(constraintAnchor);
                    if (dependencyNodeH3 != null) {
                        b(this.f12054h, dependencyNodeH3, this.f12048b.f11976Y[0].f());
                        b(this.f12055i, this.f12054h, this.f12051e.f12041g);
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                if (constraintAnchor3.f11927f != null) {
                    DependencyNode dependencyNodeH4 = h(constraintAnchor3);
                    if (dependencyNodeH4 != null) {
                        b(this.f12055i, dependencyNodeH4, -this.f12048b.f11976Y[1].f());
                        b(this.f12054h, this.f12055i, -this.f12051e.f12041g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof InterfaceC4993a) || constraintWidget2.M() == null || this.f12048b.q(ConstraintAnchor.Type.CENTER).f11927f != null) {
                    return;
                }
                b(this.f12054h, this.f12048b.M().f11986e.f12054h, this.f12048b.Z());
                b(this.f12055i, this.f12054h, this.f12051e.f12041g);
                return;
            }
        }
        if (this.f12050d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f12048b;
            int i10 = constraintWidget3.f12022w;
            if (i10 == 2) {
                ConstraintWidget constraintWidgetM3 = constraintWidget3.M();
                if (constraintWidgetM3 != null) {
                    androidx.constraintlayout.core.widgets.analyzer.a aVar2 = constraintWidgetM3.f11988f.f12051e;
                    this.f12051e.f12046l.add(aVar2);
                    aVar2.f12045k.add(this.f12051e);
                    androidx.constraintlayout.core.widgets.analyzer.a aVar3 = this.f12051e;
                    aVar3.f12036b = true;
                    aVar3.f12045k.add(this.f12054h);
                    this.f12051e.f12045k.add(this.f12055i);
                }
            } else if (i10 == 3) {
                if (constraintWidget3.f12024x == 3) {
                    this.f12054h.f12035a = this;
                    this.f12055i.f12035a = this;
                    d dVar = constraintWidget3.f11988f;
                    dVar.f12054h.f12035a = this;
                    dVar.f12055i.f12035a = this;
                    aVar.f12035a = this;
                    if (constraintWidget3.m0()) {
                        this.f12051e.f12046l.add(this.f12048b.f11988f.f12051e);
                        this.f12048b.f11988f.f12051e.f12045k.add(this.f12051e);
                        d dVar2 = this.f12048b.f11988f;
                        dVar2.f12051e.f12035a = this;
                        this.f12051e.f12046l.add(dVar2.f12054h);
                        this.f12051e.f12046l.add(this.f12048b.f11988f.f12055i);
                        this.f12048b.f11988f.f12054h.f12045k.add(this.f12051e);
                        this.f12048b.f11988f.f12055i.f12045k.add(this.f12051e);
                    } else if (this.f12048b.k0()) {
                        this.f12048b.f11988f.f12051e.f12046l.add(this.f12051e);
                        this.f12051e.f12045k.add(this.f12048b.f11988f.f12051e);
                    } else {
                        this.f12048b.f11988f.f12051e.f12046l.add(this.f12051e);
                    }
                } else {
                    androidx.constraintlayout.core.widgets.analyzer.a aVar4 = constraintWidget3.f11988f.f12051e;
                    aVar.f12046l.add(aVar4);
                    aVar4.f12045k.add(this.f12051e);
                    this.f12048b.f11988f.f12054h.f12045k.add(this.f12051e);
                    this.f12048b.f11988f.f12055i.f12045k.add(this.f12051e);
                    androidx.constraintlayout.core.widgets.analyzer.a aVar5 = this.f12051e;
                    aVar5.f12036b = true;
                    aVar5.f12045k.add(this.f12054h);
                    this.f12051e.f12045k.add(this.f12055i);
                    this.f12054h.f12046l.add(this.f12051e);
                    this.f12055i.f12046l.add(this.f12051e);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.f12048b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.f11976Y;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.f11927f;
        if (constraintAnchor5 != null && constraintAnchorArr2[1].f11927f != null) {
            if (constraintWidget4.k0()) {
                this.f12054h.f12040f = this.f12048b.f11976Y[0].f();
                this.f12055i.f12040f = -this.f12048b.f11976Y[1].f();
                return;
            }
            DependencyNode dependencyNodeH5 = h(this.f12048b.f11976Y[0]);
            DependencyNode dependencyNodeH6 = h(this.f12048b.f11976Y[1]);
            if (dependencyNodeH5 != null) {
                dependencyNodeH5.b(this);
            }
            if (dependencyNodeH6 != null) {
                dependencyNodeH6.b(this);
            }
            this.f12056j = WidgetRun.RunType.CENTER;
            return;
        }
        if (constraintAnchor5 != null) {
            DependencyNode dependencyNodeH7 = h(constraintAnchor4);
            if (dependencyNodeH7 != null) {
                b(this.f12054h, dependencyNodeH7, this.f12048b.f11976Y[0].f());
                c(this.f12055i, this.f12054h, 1, this.f12051e);
                return;
            }
            return;
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
        if (constraintAnchor6.f11927f != null) {
            DependencyNode dependencyNodeH8 = h(constraintAnchor6);
            if (dependencyNodeH8 != null) {
                b(this.f12055i, dependencyNodeH8, -this.f12048b.f11976Y[1].f());
                c(this.f12054h, this.f12055i, -1, this.f12051e);
                return;
            }
            return;
        }
        if ((constraintWidget4 instanceof InterfaceC4993a) || constraintWidget4.M() == null) {
            return;
        }
        b(this.f12054h, this.f12048b.M().f11986e.f12054h, this.f12048b.Z());
        c(this.f12055i, this.f12054h, 1, this.f12051e);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        DependencyNode dependencyNode = this.f12054h;
        if (dependencyNode.f12044j) {
            this.f12048b.r1(dependencyNode.f12041g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f12049c = null;
        this.f12054h.c();
        this.f12055i.c();
        this.f12051e.c();
        this.f12053g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        return this.f12050d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f12048b.f12022w == 0;
    }

    public final void q(int[] iArr, int i10, int i11, int i12, int i13, float f10, int i14) {
        int i15 = i11 - i10;
        int i16 = i13 - i12;
        if (i14 != -1) {
            if (i14 == 0) {
                iArr[0] = (int) ((i16 * f10) + 0.5f);
                iArr[1] = i16;
                return;
            } else {
                if (i14 != 1) {
                    return;
                }
                iArr[0] = i15;
                iArr[1] = (int) ((i15 * f10) + 0.5f);
                return;
            }
        }
        int i17 = (int) ((i16 * f10) + 0.5f);
        int i18 = (int) ((i15 / f10) + 0.5f);
        if (i17 <= i15) {
            iArr[0] = i17;
            iArr[1] = i16;
        } else if (i18 <= i16) {
            iArr[0] = i15;
            iArr[1] = i18;
        }
    }

    public void r() {
        this.f12053g = false;
        this.f12054h.c();
        this.f12054h.f12044j = false;
        this.f12055i.c();
        this.f12055i.f12044j = false;
        this.f12051e.f12044j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f12048b.v();
    }
}
