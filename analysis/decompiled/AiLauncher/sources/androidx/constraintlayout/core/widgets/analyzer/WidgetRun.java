package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import p0.InterfaceC5036d;
import p0.i;

/* loaded from: classes.dex */
public abstract class WidgetRun implements InterfaceC5036d {

    /* renamed from: a, reason: collision with root package name */
    public int f12047a;

    /* renamed from: b, reason: collision with root package name */
    public ConstraintWidget f12048b;

    /* renamed from: c, reason: collision with root package name */
    public i f12049c;

    /* renamed from: d, reason: collision with root package name */
    public ConstraintWidget.DimensionBehaviour f12050d;

    /* renamed from: e, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.analyzer.a f12051e = new androidx.constraintlayout.core.widgets.analyzer.a(this);

    /* renamed from: f, reason: collision with root package name */
    public int f12052f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f12053g = false;

    /* renamed from: h, reason: collision with root package name */
    public DependencyNode f12054h = new DependencyNode(this);

    /* renamed from: i, reason: collision with root package name */
    public DependencyNode f12055i = new DependencyNode(this);

    /* renamed from: j, reason: collision with root package name */
    public RunType f12056j = RunType.NONE;

    public enum RunType {
        NONE,
        START,
        END,
        CENTER
    }

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12057a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f12057a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12057a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12057a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12057a[ConstraintAnchor.Type.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12057a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.f12048b = constraintWidget;
    }

    @Override // p0.InterfaceC5036d
    public void a(InterfaceC5036d interfaceC5036d) {
    }

    public final void b(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i10) {
        dependencyNode.f12046l.add(dependencyNode2);
        dependencyNode.f12040f = i10;
        dependencyNode2.f12045k.add(dependencyNode);
    }

    public final void c(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i10, androidx.constraintlayout.core.widgets.analyzer.a aVar) {
        dependencyNode.f12046l.add(dependencyNode2);
        dependencyNode.f12046l.add(this.f12051e);
        dependencyNode.f12042h = i10;
        dependencyNode.f12043i = aVar;
        dependencyNode2.f12045k.add(dependencyNode);
        aVar.f12045k.add(dependencyNode);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i10, int i11) {
        if (i11 == 0) {
            ConstraintWidget constraintWidget = this.f12048b;
            int i12 = constraintWidget.f11932A;
            int iMax = Math.max(constraintWidget.f12028z, i10);
            if (i12 > 0) {
                iMax = Math.min(i12, i10);
            }
            if (iMax != i10) {
                return iMax;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.f12048b;
            int i13 = constraintWidget2.f11938D;
            int iMax2 = Math.max(constraintWidget2.f11936C, i10);
            if (i13 > 0) {
                iMax2 = Math.min(i13, i10);
            }
            if (iMax2 != i10) {
                return iMax2;
            }
        }
        return i10;
    }

    public final DependencyNode h(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f11927f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f11925d;
        int i10 = a.f12057a[constraintAnchor2.f11926e.ordinal()];
        if (i10 == 1) {
            return constraintWidget.f11986e.f12054h;
        }
        if (i10 == 2) {
            return constraintWidget.f11986e.f12055i;
        }
        if (i10 == 3) {
            return constraintWidget.f11988f.f12054h;
        }
        if (i10 == 4) {
            return constraintWidget.f11988f.f12061k;
        }
        if (i10 != 5) {
            return null;
        }
        return constraintWidget.f11988f.f12055i;
    }

    public final DependencyNode i(ConstraintAnchor constraintAnchor, int i10) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f11927f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f11925d;
        WidgetRun widgetRun = i10 == 0 ? constraintWidget.f11986e : constraintWidget.f11988f;
        int i11 = a.f12057a[constraintAnchor2.f11926e.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 5) {
                        return null;
                    }
                }
            }
            return widgetRun.f12055i;
        }
        return widgetRun.f12054h;
    }

    public long j() {
        if (this.f12051e.f12044j) {
            return r2.f12041g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f12053g;
    }

    public final void l(int i10, int i11) {
        int i12 = this.f12047a;
        if (i12 == 0) {
            this.f12051e.d(g(i11, i10));
            return;
        }
        if (i12 == 1) {
            this.f12051e.d(Math.min(g(this.f12051e.f12058m, i10), i11));
            return;
        }
        if (i12 == 2) {
            ConstraintWidget constraintWidgetM = this.f12048b.M();
            if (constraintWidgetM != null) {
                if ((i10 == 0 ? constraintWidgetM.f11986e : constraintWidgetM.f11988f).f12051e.f12044j) {
                    this.f12051e.d(g((int) ((r9.f12041g * (i10 == 0 ? this.f12048b.f11934B : this.f12048b.f11940E)) + 0.5f), i10));
                    return;
                }
                return;
            }
            return;
        }
        if (i12 != 3) {
            return;
        }
        ConstraintWidget constraintWidget = this.f12048b;
        WidgetRun widgetRun = constraintWidget.f11986e;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = widgetRun.f12050d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (dimensionBehaviour == dimensionBehaviour2 && widgetRun.f12047a == 3) {
            d dVar = constraintWidget.f11988f;
            if (dVar.f12050d == dimensionBehaviour2 && dVar.f12047a == 3) {
                return;
            }
        }
        if (i10 == 0) {
            widgetRun = constraintWidget.f11988f;
        }
        if (widgetRun.f12051e.f12044j) {
            float fX = constraintWidget.x();
            this.f12051e.d(i10 == 1 ? (int) ((widgetRun.f12051e.f12041g / fX) + 0.5f) : (int) ((fX * widgetRun.f12051e.f12041g) + 0.5f));
        }
    }

    public abstract boolean m();

    public void n(InterfaceC5036d interfaceC5036d, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i10) {
        DependencyNode dependencyNodeH = h(constraintAnchor);
        DependencyNode dependencyNodeH2 = h(constraintAnchor2);
        if (dependencyNodeH.f12044j && dependencyNodeH2.f12044j) {
            int iF = dependencyNodeH.f12041g + constraintAnchor.f();
            int iF2 = dependencyNodeH2.f12041g - constraintAnchor2.f();
            int i11 = iF2 - iF;
            if (!this.f12051e.f12044j && this.f12050d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                l(i10, i11);
            }
            androidx.constraintlayout.core.widgets.analyzer.a aVar = this.f12051e;
            if (aVar.f12044j) {
                if (aVar.f12041g == i11) {
                    this.f12054h.d(iF);
                    this.f12055i.d(iF2);
                    return;
                }
                float fA = i10 == 0 ? this.f12048b.A() : this.f12048b.T();
                if (dependencyNodeH == dependencyNodeH2) {
                    iF = dependencyNodeH.f12041g;
                    iF2 = dependencyNodeH2.f12041g;
                    fA = 0.5f;
                }
                this.f12054h.d((int) (iF + 0.5f + (((iF2 - iF) - this.f12051e.f12041g) * fA)));
                this.f12055i.d(this.f12054h.f12041g + this.f12051e.f12041g);
            }
        }
    }

    public void o(InterfaceC5036d interfaceC5036d) {
    }

    public void p(InterfaceC5036d interfaceC5036d) {
    }
}
