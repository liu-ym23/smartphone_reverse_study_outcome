package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import o0.InterfaceC4993a;
import p0.C5033a;
import p0.InterfaceC5036d;

/* loaded from: classes.dex */
public class d extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    public DependencyNode f12061k;

    /* renamed from: l, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.a f12062l;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12063a;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f12063a = iArr;
            try {
                iArr[WidgetRun.RunType.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12063a[WidgetRun.RunType.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12063a[WidgetRun.RunType.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public d(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.f12061k = dependencyNode;
        this.f12062l = null;
        this.f12054h.f12039e = DependencyNode.Type.TOP;
        this.f12055i.f12039e = DependencyNode.Type.BOTTOM;
        dependencyNode.f12039e = DependencyNode.Type.BASELINE;
        this.f12052f = 1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, p0.InterfaceC5036d
    public void a(InterfaceC5036d interfaceC5036d) {
        float f10;
        float fX;
        float fX2;
        int i10;
        int i11 = a.f12063a[this.f12056j.ordinal()];
        if (i11 == 1) {
            p(interfaceC5036d);
        } else if (i11 == 2) {
            o(interfaceC5036d);
        } else if (i11 == 3) {
            ConstraintWidget constraintWidget = this.f12048b;
            n(interfaceC5036d, constraintWidget.f11966R, constraintWidget.f11970T, 1);
            return;
        }
        androidx.constraintlayout.core.widgets.analyzer.a aVar = this.f12051e;
        if (aVar.f12037c && !aVar.f12044j && this.f12050d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget2 = this.f12048b;
            int i12 = constraintWidget2.f12024x;
            if (i12 == 2) {
                ConstraintWidget constraintWidgetM = constraintWidget2.M();
                if (constraintWidgetM != null) {
                    if (constraintWidgetM.f11988f.f12051e.f12044j) {
                        this.f12051e.d((int) ((r7.f12041g * this.f12048b.f11940E) + 0.5f));
                    }
                }
            } else if (i12 == 3 && constraintWidget2.f11986e.f12051e.f12044j) {
                int iY = constraintWidget2.y();
                if (iY == -1) {
                    ConstraintWidget constraintWidget3 = this.f12048b;
                    f10 = constraintWidget3.f11986e.f12051e.f12041g;
                    fX = constraintWidget3.x();
                } else if (iY == 0) {
                    fX2 = r7.f11986e.f12051e.f12041g * this.f12048b.x();
                    i10 = (int) (fX2 + 0.5f);
                    this.f12051e.d(i10);
                } else if (iY != 1) {
                    i10 = 0;
                    this.f12051e.d(i10);
                } else {
                    ConstraintWidget constraintWidget4 = this.f12048b;
                    f10 = constraintWidget4.f11986e.f12051e.f12041g;
                    fX = constraintWidget4.x();
                }
                fX2 = f10 / fX;
                i10 = (int) (fX2 + 0.5f);
                this.f12051e.d(i10);
            }
        }
        DependencyNode dependencyNode = this.f12054h;
        if (dependencyNode.f12037c) {
            DependencyNode dependencyNode2 = this.f12055i;
            if (dependencyNode2.f12037c) {
                if (dependencyNode.f12044j && dependencyNode2.f12044j && this.f12051e.f12044j) {
                    return;
                }
                if (!this.f12051e.f12044j && this.f12050d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    ConstraintWidget constraintWidget5 = this.f12048b;
                    if (constraintWidget5.f12022w == 0 && !constraintWidget5.m0()) {
                        DependencyNode dependencyNode3 = this.f12054h.f12046l.get(0);
                        DependencyNode dependencyNode4 = this.f12055i.f12046l.get(0);
                        int i13 = dependencyNode3.f12041g;
                        DependencyNode dependencyNode5 = this.f12054h;
                        int i14 = i13 + dependencyNode5.f12040f;
                        int i15 = dependencyNode4.f12041g + this.f12055i.f12040f;
                        dependencyNode5.d(i14);
                        this.f12055i.d(i15);
                        this.f12051e.d(i15 - i14);
                        return;
                    }
                }
                if (!this.f12051e.f12044j && this.f12050d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.f12047a == 1 && this.f12054h.f12046l.size() > 0 && this.f12055i.f12046l.size() > 0) {
                    DependencyNode dependencyNode6 = this.f12054h.f12046l.get(0);
                    int i16 = (this.f12055i.f12046l.get(0).f12041g + this.f12055i.f12040f) - (dependencyNode6.f12041g + this.f12054h.f12040f);
                    androidx.constraintlayout.core.widgets.analyzer.a aVar2 = this.f12051e;
                    int i17 = aVar2.f12058m;
                    if (i16 < i17) {
                        aVar2.d(i16);
                    } else {
                        aVar2.d(i17);
                    }
                }
                if (this.f12051e.f12044j && this.f12054h.f12046l.size() > 0 && this.f12055i.f12046l.size() > 0) {
                    DependencyNode dependencyNode7 = this.f12054h.f12046l.get(0);
                    DependencyNode dependencyNode8 = this.f12055i.f12046l.get(0);
                    int i18 = dependencyNode7.f12041g + this.f12054h.f12040f;
                    int i19 = dependencyNode8.f12041g + this.f12055i.f12040f;
                    float fT = this.f12048b.T();
                    if (dependencyNode7 == dependencyNode8) {
                        i18 = dependencyNode7.f12041g;
                        i19 = dependencyNode8.f12041g;
                        fT = 0.5f;
                    }
                    this.f12054h.d((int) (i18 + 0.5f + (((i19 - i18) - this.f12051e.f12041g) * fT)));
                    this.f12055i.d(this.f12054h.f12041g + this.f12051e.f12041g);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget constraintWidgetM;
        ConstraintWidget constraintWidgetM2;
        ConstraintWidget constraintWidget = this.f12048b;
        if (constraintWidget.f11978a) {
            this.f12051e.d(constraintWidget.z());
        }
        if (!this.f12051e.f12044j) {
            this.f12050d = this.f12048b.V();
            if (this.f12048b.b0()) {
                this.f12062l = new C5033a(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.f12050d;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidgetM2 = this.f12048b.M()) != null && constraintWidgetM2.V() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int iZ = (constraintWidgetM2.z() - this.f12048b.f11966R.f()) - this.f12048b.f11970T.f();
                    b(this.f12054h, constraintWidgetM2.f11988f.f12054h, this.f12048b.f11966R.f());
                    b(this.f12055i, constraintWidgetM2.f11988f.f12055i, -this.f12048b.f11970T.f());
                    this.f12051e.d(iZ);
                    return;
                }
                if (this.f12050d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f12051e.d(this.f12048b.z());
                }
            }
        } else if (this.f12050d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidgetM = this.f12048b.M()) != null && constraintWidgetM.V() == ConstraintWidget.DimensionBehaviour.FIXED) {
            b(this.f12054h, constraintWidgetM.f11988f.f12054h, this.f12048b.f11966R.f());
            b(this.f12055i, constraintWidgetM.f11988f.f12055i, -this.f12048b.f11970T.f());
            return;
        }
        androidx.constraintlayout.core.widgets.analyzer.a aVar = this.f12051e;
        boolean z10 = aVar.f12044j;
        if (z10) {
            ConstraintWidget constraintWidget2 = this.f12048b;
            if (constraintWidget2.f11978a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.f11976Y;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f11927f;
                if (constraintAnchor2 != null && constraintAnchorArr[3].f11927f != null) {
                    if (constraintWidget2.m0()) {
                        this.f12054h.f12040f = this.f12048b.f11976Y[2].f();
                        this.f12055i.f12040f = -this.f12048b.f11976Y[3].f();
                    } else {
                        DependencyNode dependencyNodeH = h(this.f12048b.f11976Y[2]);
                        if (dependencyNodeH != null) {
                            b(this.f12054h, dependencyNodeH, this.f12048b.f11976Y[2].f());
                        }
                        DependencyNode dependencyNodeH2 = h(this.f12048b.f11976Y[3]);
                        if (dependencyNodeH2 != null) {
                            b(this.f12055i, dependencyNodeH2, -this.f12048b.f11976Y[3].f());
                        }
                        this.f12054h.f12036b = true;
                        this.f12055i.f12036b = true;
                    }
                    if (this.f12048b.b0()) {
                        b(this.f12061k, this.f12054h, this.f12048b.r());
                        return;
                    }
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode dependencyNodeH3 = h(constraintAnchor);
                    if (dependencyNodeH3 != null) {
                        b(this.f12054h, dependencyNodeH3, this.f12048b.f11976Y[2].f());
                        b(this.f12055i, this.f12054h, this.f12051e.f12041g);
                        if (this.f12048b.b0()) {
                            b(this.f12061k, this.f12054h, this.f12048b.r());
                            return;
                        }
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                if (constraintAnchor3.f11927f != null) {
                    DependencyNode dependencyNodeH4 = h(constraintAnchor3);
                    if (dependencyNodeH4 != null) {
                        b(this.f12055i, dependencyNodeH4, -this.f12048b.f11976Y[3].f());
                        b(this.f12054h, this.f12055i, -this.f12051e.f12041g);
                    }
                    if (this.f12048b.b0()) {
                        b(this.f12061k, this.f12054h, this.f12048b.r());
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                if (constraintAnchor4.f11927f != null) {
                    DependencyNode dependencyNodeH5 = h(constraintAnchor4);
                    if (dependencyNodeH5 != null) {
                        b(this.f12061k, dependencyNodeH5, 0);
                        b(this.f12054h, this.f12061k, -this.f12048b.r());
                        b(this.f12055i, this.f12054h, this.f12051e.f12041g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget2 instanceof InterfaceC4993a) || constraintWidget2.M() == null || this.f12048b.q(ConstraintAnchor.Type.CENTER).f11927f != null) {
                    return;
                }
                b(this.f12054h, this.f12048b.M().f11988f.f12054h, this.f12048b.a0());
                b(this.f12055i, this.f12054h, this.f12051e.f12041g);
                if (this.f12048b.b0()) {
                    b(this.f12061k, this.f12054h, this.f12048b.r());
                    return;
                }
                return;
            }
        }
        if (z10 || this.f12050d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            aVar.b(this);
        } else {
            ConstraintWidget constraintWidget3 = this.f12048b;
            int i10 = constraintWidget3.f12024x;
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
            } else if (i10 == 3 && !constraintWidget3.m0()) {
                ConstraintWidget constraintWidget4 = this.f12048b;
                if (constraintWidget4.f12022w != 3) {
                    androidx.constraintlayout.core.widgets.analyzer.a aVar4 = constraintWidget4.f11986e.f12051e;
                    this.f12051e.f12046l.add(aVar4);
                    aVar4.f12045k.add(this.f12051e);
                    androidx.constraintlayout.core.widgets.analyzer.a aVar5 = this.f12051e;
                    aVar5.f12036b = true;
                    aVar5.f12045k.add(this.f12054h);
                    this.f12051e.f12045k.add(this.f12055i);
                }
            }
        }
        ConstraintWidget constraintWidget5 = this.f12048b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.f11976Y;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.f11927f;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].f11927f != null) {
            if (constraintWidget5.m0()) {
                this.f12054h.f12040f = this.f12048b.f11976Y[2].f();
                this.f12055i.f12040f = -this.f12048b.f11976Y[3].f();
            } else {
                DependencyNode dependencyNodeH6 = h(this.f12048b.f11976Y[2]);
                DependencyNode dependencyNodeH7 = h(this.f12048b.f11976Y[3]);
                if (dependencyNodeH6 != null) {
                    dependencyNodeH6.b(this);
                }
                if (dependencyNodeH7 != null) {
                    dependencyNodeH7.b(this);
                }
                this.f12056j = WidgetRun.RunType.CENTER;
            }
            if (this.f12048b.b0()) {
                c(this.f12061k, this.f12054h, 1, this.f12062l);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode dependencyNodeH8 = h(constraintAnchor5);
            if (dependencyNodeH8 != null) {
                b(this.f12054h, dependencyNodeH8, this.f12048b.f11976Y[2].f());
                c(this.f12055i, this.f12054h, 1, this.f12051e);
                if (this.f12048b.b0()) {
                    c(this.f12061k, this.f12054h, 1, this.f12062l);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f12050d;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.f12048b.x() > 0.0f) {
                    c cVar = this.f12048b.f11986e;
                    if (cVar.f12050d == dimensionBehaviour3) {
                        cVar.f12051e.f12045k.add(this.f12051e);
                        this.f12051e.f12046l.add(this.f12048b.f11986e.f12051e);
                        this.f12051e.f12035a = this;
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.f11927f != null) {
                DependencyNode dependencyNodeH9 = h(constraintAnchor7);
                if (dependencyNodeH9 != null) {
                    b(this.f12055i, dependencyNodeH9, -this.f12048b.f11976Y[3].f());
                    c(this.f12054h, this.f12055i, -1, this.f12051e);
                    if (this.f12048b.b0()) {
                        c(this.f12061k, this.f12054h, 1, this.f12062l);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.f11927f != null) {
                    DependencyNode dependencyNodeH10 = h(constraintAnchor8);
                    if (dependencyNodeH10 != null) {
                        b(this.f12061k, dependencyNodeH10, 0);
                        c(this.f12054h, this.f12061k, -1, this.f12062l);
                        c(this.f12055i, this.f12054h, 1, this.f12051e);
                    }
                } else if (!(constraintWidget5 instanceof InterfaceC4993a) && constraintWidget5.M() != null) {
                    b(this.f12054h, this.f12048b.M().f11988f.f12054h, this.f12048b.a0());
                    c(this.f12055i, this.f12054h, 1, this.f12051e);
                    if (this.f12048b.b0()) {
                        c(this.f12061k, this.f12054h, 1, this.f12062l);
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.f12050d;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour4 == dimensionBehaviour5 && this.f12048b.x() > 0.0f) {
                        c cVar2 = this.f12048b.f11986e;
                        if (cVar2.f12050d == dimensionBehaviour5) {
                            cVar2.f12051e.f12045k.add(this.f12051e);
                            this.f12051e.f12046l.add(this.f12048b.f11986e.f12051e);
                            this.f12051e.f12035a = this;
                        }
                    }
                }
            }
        }
        if (this.f12051e.f12046l.size() == 0) {
            this.f12051e.f12037c = true;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        DependencyNode dependencyNode = this.f12054h;
        if (dependencyNode.f12044j) {
            this.f12048b.s1(dependencyNode.f12041g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f12049c = null;
        this.f12054h.c();
        this.f12055i.c();
        this.f12061k.c();
        this.f12051e.c();
        this.f12053g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        return this.f12050d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f12048b.f12024x == 0;
    }

    public void q() {
        this.f12053g = false;
        this.f12054h.c();
        this.f12054h.f12044j = false;
        this.f12055i.c();
        this.f12055i.f12044j = false;
        this.f12061k.c();
        this.f12061k.f12044j = false;
        this.f12051e.f12044j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f12048b.v();
    }
}
