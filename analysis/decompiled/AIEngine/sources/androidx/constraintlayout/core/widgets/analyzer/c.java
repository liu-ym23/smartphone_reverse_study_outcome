package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f1177k = new int[2];

    public c(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.h.f1149e = DependencyNode.Type.f1159d;
        this.f1171i.f1149e = DependencyNode.Type.f1160e;
        this.f1169f = 0;
    }

    public static void m(int[] iArr, int i10, int i11, int i12, int i13, float f8, int i14) {
        int i15 = i11 - i10;
        int i16 = i13 - i12;
        if (i14 != -1) {
            if (i14 == 0) {
                iArr[0] = (int) ((i16 * f8) + 0.5f);
                iArr[1] = i16;
                return;
            } else {
                if (i14 != 1) {
                    return;
                }
                iArr[0] = i15;
                iArr[1] = (int) ((i15 * f8) + 0.5f);
                return;
            }
        }
        int i17 = (int) ((i16 * f8) + 0.5f);
        int i18 = (int) ((i15 / f8) + 0.5f);
        if (i17 <= i15) {
            iArr[0] = i17;
            iArr[1] = i16;
        } else if (i18 <= i16) {
            iArr[0] = i15;
            iArr[1] = i18;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, h0.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(h0.d r24) {
        /*
            Method dump skipped, instructions count: 903
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.c.a(h0.d):void");
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void d() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget constraintWidget5 = this.f1165b;
        boolean z = constraintWidget5.f1099a;
        a aVar = this.f1168e;
        if (z) {
            aVar.d(constraintWidget5.q());
        }
        boolean z3 = aVar.f1153j;
        ArrayList arrayList = aVar.f1154k;
        ArrayList arrayList2 = aVar.f1155l;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.f1139d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.f1138c;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.f1136a;
        DependencyNode dependencyNode = this.f1171i;
        DependencyNode dependencyNode2 = this.h;
        if (!z3) {
            ConstraintWidget constraintWidget6 = this.f1165b;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = constraintWidget6.U[0];
            this.f1167d = dimensionBehaviour6;
            if (dimensionBehaviour6 != dimensionBehaviour4) {
                if (dimensionBehaviour6 == dimensionBehaviour3 && (constraintWidget4 = constraintWidget6.V) != null && ((dimensionBehaviour2 = constraintWidget4.U[0]) == dimensionBehaviour5 || dimensionBehaviour2 == dimensionBehaviour3)) {
                    int iQ = (constraintWidget4.q() - this.f1165b.J.e()) - this.f1165b.L.e();
                    WidgetRun.b(dependencyNode2, constraintWidget4.f1103d.h, this.f1165b.J.e());
                    WidgetRun.b(dependencyNode, constraintWidget4.f1103d.f1171i, -this.f1165b.L.e());
                    aVar.d(iQ);
                    return;
                }
                if (dimensionBehaviour6 == dimensionBehaviour5) {
                    aVar.d(constraintWidget6.q());
                }
            }
        } else if (this.f1167d == dimensionBehaviour3 && (constraintWidget2 = (constraintWidget = this.f1165b).V) != null && ((dimensionBehaviour = constraintWidget2.U[0]) == dimensionBehaviour5 || dimensionBehaviour == dimensionBehaviour3)) {
            WidgetRun.b(dependencyNode2, constraintWidget2.f1103d.h, constraintWidget.J.e());
            WidgetRun.b(dependencyNode, constraintWidget2.f1103d.f1171i, -this.f1165b.L.e());
            return;
        }
        if (aVar.f1153j) {
            ConstraintWidget constraintWidget7 = this.f1165b;
            if (constraintWidget7.f1099a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget7.R;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f1088f;
                if (constraintAnchor2 != null && constraintAnchorArr[1].f1088f != null) {
                    if (constraintWidget7.x()) {
                        dependencyNode2.f1150f = this.f1165b.R[0].e();
                        dependencyNode.f1150f = -this.f1165b.R[1].e();
                        return;
                    }
                    DependencyNode dependencyNodeH = WidgetRun.h(this.f1165b.R[0]);
                    if (dependencyNodeH != null) {
                        WidgetRun.b(dependencyNode2, dependencyNodeH, this.f1165b.R[0].e());
                    }
                    DependencyNode dependencyNodeH2 = WidgetRun.h(this.f1165b.R[1]);
                    if (dependencyNodeH2 != null) {
                        WidgetRun.b(dependencyNode, dependencyNodeH2, -this.f1165b.R[1].e());
                    }
                    dependencyNode2.f1146b = true;
                    dependencyNode.f1146b = true;
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode dependencyNodeH3 = WidgetRun.h(constraintAnchor);
                    if (dependencyNodeH3 != null) {
                        WidgetRun.b(dependencyNode2, dependencyNodeH3, this.f1165b.R[0].e());
                        WidgetRun.b(dependencyNode, dependencyNode2, aVar.f1151g);
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                if (constraintAnchor3.f1088f != null) {
                    DependencyNode dependencyNodeH4 = WidgetRun.h(constraintAnchor3);
                    if (dependencyNodeH4 != null) {
                        WidgetRun.b(dependencyNode, dependencyNodeH4, -this.f1165b.R[1].e());
                        WidgetRun.b(dependencyNode2, dependencyNode, -aVar.f1151g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget7 instanceof g0.a) || constraintWidget7.V == null || constraintWidget7.i(ConstraintAnchor.Type.h).f1088f != null) {
                    return;
                }
                ConstraintWidget constraintWidget8 = this.f1165b;
                WidgetRun.b(dependencyNode2, constraintWidget8.V.f1103d.h, constraintWidget8.r());
                WidgetRun.b(dependencyNode, dependencyNode2, aVar.f1151g);
                return;
            }
        }
        if (this.f1167d == dimensionBehaviour4) {
            ConstraintWidget constraintWidget9 = this.f1165b;
            int i10 = constraintWidget9.r;
            if (i10 == 2) {
                ConstraintWidget constraintWidget10 = constraintWidget9.V;
                if (constraintWidget10 != null) {
                    a aVar2 = constraintWidget10.f1105e.f1168e;
                    arrayList2.add(aVar2);
                    aVar2.f1154k.add(aVar);
                    aVar.f1146b = true;
                    arrayList.add(dependencyNode2);
                    arrayList.add(dependencyNode);
                }
            } else if (i10 == 3) {
                if (constraintWidget9.f1129s == 3) {
                    dependencyNode2.f1145a = this;
                    dependencyNode.f1145a = this;
                    d dVar = constraintWidget9.f1105e;
                    dVar.h.f1145a = this;
                    dVar.f1171i.f1145a = this;
                    aVar.f1145a = this;
                    if (constraintWidget9.y()) {
                        arrayList2.add(this.f1165b.f1105e.f1168e);
                        this.f1165b.f1105e.f1168e.f1154k.add(aVar);
                        d dVar2 = this.f1165b.f1105e;
                        dVar2.f1168e.f1145a = this;
                        arrayList2.add(dVar2.h);
                        arrayList2.add(this.f1165b.f1105e.f1171i);
                        this.f1165b.f1105e.h.f1154k.add(aVar);
                        this.f1165b.f1105e.f1171i.f1154k.add(aVar);
                    } else if (this.f1165b.x()) {
                        this.f1165b.f1105e.f1168e.f1155l.add(aVar);
                        arrayList.add(this.f1165b.f1105e.f1168e);
                    } else {
                        this.f1165b.f1105e.f1168e.f1155l.add(aVar);
                    }
                } else {
                    a aVar3 = constraintWidget9.f1105e.f1168e;
                    arrayList2.add(aVar3);
                    aVar3.f1154k.add(aVar);
                    this.f1165b.f1105e.h.f1154k.add(aVar);
                    this.f1165b.f1105e.f1171i.f1154k.add(aVar);
                    aVar.f1146b = true;
                    arrayList.add(dependencyNode2);
                    arrayList.add(dependencyNode);
                    dependencyNode2.f1155l.add(aVar);
                    dependencyNode.f1155l.add(aVar);
                }
            }
        }
        ConstraintWidget constraintWidget11 = this.f1165b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget11.R;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.f1088f;
        if (constraintAnchor5 != null && constraintAnchorArr2[1].f1088f != null) {
            if (constraintWidget11.x()) {
                dependencyNode2.f1150f = this.f1165b.R[0].e();
                dependencyNode.f1150f = -this.f1165b.R[1].e();
                return;
            }
            DependencyNode dependencyNodeH5 = WidgetRun.h(this.f1165b.R[0]);
            DependencyNode dependencyNodeH6 = WidgetRun.h(this.f1165b.R[1]);
            if (dependencyNodeH5 != null) {
                dependencyNodeH5.b(this);
            }
            if (dependencyNodeH6 != null) {
                dependencyNodeH6.b(this);
            }
            this.f1172j = WidgetRun.RunType.f1174b;
            return;
        }
        if (constraintAnchor5 != null) {
            DependencyNode dependencyNodeH7 = WidgetRun.h(constraintAnchor4);
            if (dependencyNodeH7 != null) {
                WidgetRun.b(dependencyNode2, dependencyNodeH7, this.f1165b.R[0].e());
                c(dependencyNode, dependencyNode2, 1, aVar);
                return;
            }
            return;
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
        if (constraintAnchor6.f1088f != null) {
            DependencyNode dependencyNodeH8 = WidgetRun.h(constraintAnchor6);
            if (dependencyNodeH8 != null) {
                WidgetRun.b(dependencyNode, dependencyNodeH8, -this.f1165b.R[1].e());
                c(dependencyNode2, dependencyNode, -1, aVar);
                return;
            }
            return;
        }
        if ((constraintWidget11 instanceof g0.a) || (constraintWidget3 = constraintWidget11.V) == null) {
            return;
        }
        WidgetRun.b(dependencyNode2, constraintWidget3.f1103d.h, constraintWidget11.r());
        c(dependencyNode, dependencyNode2, 1, aVar);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void e() {
        DependencyNode dependencyNode = this.h;
        if (dependencyNode.f1153j) {
            this.f1165b.f1100a0 = dependencyNode.f1151g;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void f() {
        this.f1166c = null;
        this.h.c();
        this.f1171i.c();
        this.f1168e.c();
        this.f1170g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean k() {
        return this.f1167d != ConstraintWidget.DimensionBehaviour.f1138c || this.f1165b.r == 0;
    }

    public final void n() {
        this.f1170g = false;
        DependencyNode dependencyNode = this.h;
        dependencyNode.c();
        dependencyNode.f1153j = false;
        DependencyNode dependencyNode2 = this.f1171i;
        dependencyNode2.c();
        dependencyNode2.f1153j = false;
        this.f1168e.f1153j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f1165b.f1115j0;
    }
}
