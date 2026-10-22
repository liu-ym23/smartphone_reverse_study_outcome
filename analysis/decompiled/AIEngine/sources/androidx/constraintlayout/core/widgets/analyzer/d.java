package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    public final DependencyNode f1178k;

    /* renamed from: l, reason: collision with root package name */
    public h0.a f1179l;

    public d(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.f1178k = dependencyNode;
        this.f1179l = null;
        this.h.f1149e = DependencyNode.Type.h;
        this.f1171i.f1149e = DependencyNode.Type.f1161j;
        dependencyNode.f1149e = DependencyNode.Type.f1162k;
        this.f1169f = 1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, h0.d
    public final void a(h0.d dVar) {
        float f8;
        float f9;
        float f10;
        int i10;
        if (this.f1172j.ordinal() == 3) {
            ConstraintWidget constraintWidget = this.f1165b;
            l(constraintWidget.K, constraintWidget.M, 1);
            return;
        }
        a aVar = this.f1168e;
        boolean z = aVar.f1147c;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1138c;
        if (z && !aVar.f1153j && this.f1167d == dimensionBehaviour) {
            ConstraintWidget constraintWidget2 = this.f1165b;
            int i11 = constraintWidget2.f1129s;
            if (i11 == 2) {
                ConstraintWidget constraintWidget3 = constraintWidget2.V;
                if (constraintWidget3 != null) {
                    if (constraintWidget3.f1105e.f1168e.f1153j) {
                        aVar.d((int) ((r1.f1151g * constraintWidget2.z) + 0.5f));
                    }
                }
            } else if (i11 == 3) {
                a aVar2 = constraintWidget2.f1103d.f1168e;
                if (aVar2.f1153j) {
                    int i12 = constraintWidget2.Z;
                    if (i12 == -1) {
                        f8 = aVar2.f1151g;
                        f9 = constraintWidget2.Y;
                    } else if (i12 == 0) {
                        f10 = aVar2.f1151g * constraintWidget2.Y;
                        i10 = (int) (f10 + 0.5f);
                        aVar.d(i10);
                    } else if (i12 != 1) {
                        i10 = 0;
                        aVar.d(i10);
                    } else {
                        f8 = aVar2.f1151g;
                        f9 = constraintWidget2.Y;
                    }
                    f10 = f8 / f9;
                    i10 = (int) (f10 + 0.5f);
                    aVar.d(i10);
                }
            }
        }
        DependencyNode dependencyNode = this.h;
        boolean z3 = dependencyNode.f1147c;
        ArrayList arrayList = dependencyNode.f1155l;
        if (z3) {
            DependencyNode dependencyNode2 = this.f1171i;
            boolean z10 = dependencyNode2.f1147c;
            ArrayList arrayList2 = dependencyNode2.f1155l;
            if (z10) {
                if (dependencyNode.f1153j && dependencyNode2.f1153j && aVar.f1153j) {
                    return;
                }
                if (!aVar.f1153j && this.f1167d == dimensionBehaviour) {
                    ConstraintWidget constraintWidget4 = this.f1165b;
                    if (constraintWidget4.r == 0 && !constraintWidget4.y()) {
                        DependencyNode dependencyNode3 = (DependencyNode) arrayList.get(0);
                        DependencyNode dependencyNode4 = (DependencyNode) arrayList2.get(0);
                        int i13 = dependencyNode3.f1151g + dependencyNode.f1150f;
                        int i14 = dependencyNode4.f1151g + dependencyNode2.f1150f;
                        dependencyNode.d(i13);
                        dependencyNode2.d(i14);
                        aVar.d(i14 - i13);
                        return;
                    }
                }
                if (!aVar.f1153j && this.f1167d == dimensionBehaviour && this.f1164a == 1 && arrayList.size() > 0 && arrayList2.size() > 0) {
                    DependencyNode dependencyNode5 = (DependencyNode) arrayList.get(0);
                    int i15 = (((DependencyNode) arrayList2.get(0)).f1151g + dependencyNode2.f1150f) - (dependencyNode5.f1151g + dependencyNode.f1150f);
                    int i16 = aVar.f1176m;
                    if (i15 < i16) {
                        aVar.d(i15);
                    } else {
                        aVar.d(i16);
                    }
                }
                if (aVar.f1153j && arrayList.size() > 0 && arrayList2.size() > 0) {
                    DependencyNode dependencyNode6 = (DependencyNode) arrayList.get(0);
                    DependencyNode dependencyNode7 = (DependencyNode) arrayList2.get(0);
                    int i17 = dependencyNode6.f1151g;
                    int i18 = dependencyNode.f1150f + i17;
                    int i19 = dependencyNode7.f1151g;
                    int i20 = dependencyNode2.f1150f + i19;
                    float f11 = this.f1165b.f1110g0;
                    if (dependencyNode6 == dependencyNode7) {
                        f11 = 0.5f;
                    } else {
                        i17 = i18;
                        i19 = i20;
                    }
                    dependencyNode.d((int) ((((i19 - i17) - aVar.f1151g) * f11) + i17 + 0.5f));
                    dependencyNode2.d(dependencyNode.f1151g + aVar.f1151g);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void d() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5 = this.f1165b;
        boolean z = constraintWidget5.f1099a;
        a aVar = this.f1168e;
        if (z) {
            aVar.d(constraintWidget5.k());
        }
        boolean z3 = aVar.f1153j;
        ArrayList arrayList = aVar.f1154k;
        ArrayList arrayList2 = aVar.f1155l;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1139d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.f1136a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.f1138c;
        DependencyNode dependencyNode = this.f1171i;
        DependencyNode dependencyNode2 = this.h;
        if (!z3) {
            ConstraintWidget constraintWidget6 = this.f1165b;
            this.f1167d = constraintWidget6.U[1];
            if (constraintWidget6.E) {
                this.f1179l = new h0.a(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.f1167d;
            if (dimensionBehaviour4 != dimensionBehaviour3) {
                if (dimensionBehaviour4 == dimensionBehaviour && (constraintWidget4 = this.f1165b.V) != null && constraintWidget4.U[1] == dimensionBehaviour2) {
                    int iK = (constraintWidget4.k() - this.f1165b.K.e()) - this.f1165b.M.e();
                    WidgetRun.b(dependencyNode2, constraintWidget4.f1105e.h, this.f1165b.K.e());
                    WidgetRun.b(dependencyNode, constraintWidget4.f1105e.f1171i, -this.f1165b.M.e());
                    aVar.d(iK);
                    return;
                }
                if (dimensionBehaviour4 == dimensionBehaviour2) {
                    aVar.d(this.f1165b.k());
                }
            }
        } else if (this.f1167d == dimensionBehaviour && (constraintWidget2 = (constraintWidget = this.f1165b).V) != null && constraintWidget2.U[1] == dimensionBehaviour2) {
            WidgetRun.b(dependencyNode2, constraintWidget2.f1105e.h, constraintWidget.K.e());
            WidgetRun.b(dependencyNode, constraintWidget2.f1105e.f1171i, -this.f1165b.M.e());
            return;
        }
        boolean z10 = aVar.f1153j;
        DependencyNode dependencyNode3 = this.f1178k;
        if (z10) {
            ConstraintWidget constraintWidget7 = this.f1165b;
            if (constraintWidget7.f1099a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget7.R;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f1088f;
                if (constraintAnchor2 != null && constraintAnchorArr[3].f1088f != null) {
                    if (constraintWidget7.y()) {
                        dependencyNode2.f1150f = this.f1165b.R[2].e();
                        dependencyNode.f1150f = -this.f1165b.R[3].e();
                    } else {
                        DependencyNode dependencyNodeH = WidgetRun.h(this.f1165b.R[2]);
                        if (dependencyNodeH != null) {
                            WidgetRun.b(dependencyNode2, dependencyNodeH, this.f1165b.R[2].e());
                        }
                        DependencyNode dependencyNodeH2 = WidgetRun.h(this.f1165b.R[3]);
                        if (dependencyNodeH2 != null) {
                            WidgetRun.b(dependencyNode, dependencyNodeH2, -this.f1165b.R[3].e());
                        }
                        dependencyNode2.f1146b = true;
                        dependencyNode.f1146b = true;
                    }
                    ConstraintWidget constraintWidget8 = this.f1165b;
                    if (constraintWidget8.E) {
                        WidgetRun.b(dependencyNode3, dependencyNode2, constraintWidget8.c0);
                        return;
                    }
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode dependencyNodeH3 = WidgetRun.h(constraintAnchor);
                    if (dependencyNodeH3 != null) {
                        WidgetRun.b(dependencyNode2, dependencyNodeH3, this.f1165b.R[2].e());
                        WidgetRun.b(dependencyNode, dependencyNode2, aVar.f1151g);
                        ConstraintWidget constraintWidget9 = this.f1165b;
                        if (constraintWidget9.E) {
                            WidgetRun.b(dependencyNode3, dependencyNode2, constraintWidget9.c0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                if (constraintAnchor3.f1088f != null) {
                    DependencyNode dependencyNodeH4 = WidgetRun.h(constraintAnchor3);
                    if (dependencyNodeH4 != null) {
                        WidgetRun.b(dependencyNode, dependencyNodeH4, -this.f1165b.R[3].e());
                        WidgetRun.b(dependencyNode2, dependencyNode, -aVar.f1151g);
                    }
                    ConstraintWidget constraintWidget10 = this.f1165b;
                    if (constraintWidget10.E) {
                        WidgetRun.b(dependencyNode3, dependencyNode2, constraintWidget10.c0);
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                if (constraintAnchor4.f1088f != null) {
                    DependencyNode dependencyNodeH5 = WidgetRun.h(constraintAnchor4);
                    if (dependencyNodeH5 != null) {
                        WidgetRun.b(dependencyNode3, dependencyNodeH5, 0);
                        WidgetRun.b(dependencyNode2, dependencyNode3, -this.f1165b.c0);
                        WidgetRun.b(dependencyNode, dependencyNode2, aVar.f1151g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget7 instanceof g0.a) || constraintWidget7.V == null || constraintWidget7.i(ConstraintAnchor.Type.h).f1088f != null) {
                    return;
                }
                ConstraintWidget constraintWidget11 = this.f1165b;
                WidgetRun.b(dependencyNode2, constraintWidget11.V.f1105e.h, constraintWidget11.s());
                WidgetRun.b(dependencyNode, dependencyNode2, aVar.f1151g);
                ConstraintWidget constraintWidget12 = this.f1165b;
                if (constraintWidget12.E) {
                    WidgetRun.b(dependencyNode3, dependencyNode2, constraintWidget12.c0);
                    return;
                }
                return;
            }
        }
        if (z10 || this.f1167d != dimensionBehaviour3) {
            aVar.b(this);
        } else {
            ConstraintWidget constraintWidget13 = this.f1165b;
            int i10 = constraintWidget13.f1129s;
            if (i10 == 2) {
                ConstraintWidget constraintWidget14 = constraintWidget13.V;
                if (constraintWidget14 != null) {
                    a aVar2 = constraintWidget14.f1105e.f1168e;
                    arrayList2.add(aVar2);
                    aVar2.f1154k.add(aVar);
                    aVar.f1146b = true;
                    arrayList.add(dependencyNode2);
                    arrayList.add(dependencyNode);
                }
            } else if (i10 == 3 && !constraintWidget13.y()) {
                ConstraintWidget constraintWidget15 = this.f1165b;
                if (constraintWidget15.r != 3) {
                    a aVar3 = constraintWidget15.f1103d.f1168e;
                    arrayList2.add(aVar3);
                    aVar3.f1154k.add(aVar);
                    aVar.f1146b = true;
                    arrayList.add(dependencyNode2);
                    arrayList.add(dependencyNode);
                }
            }
        }
        ConstraintWidget constraintWidget16 = this.f1165b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget16.R;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.f1088f;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].f1088f != null) {
            if (constraintWidget16.y()) {
                dependencyNode2.f1150f = this.f1165b.R[2].e();
                dependencyNode.f1150f = -this.f1165b.R[3].e();
            } else {
                DependencyNode dependencyNodeH6 = WidgetRun.h(this.f1165b.R[2]);
                DependencyNode dependencyNodeH7 = WidgetRun.h(this.f1165b.R[3]);
                if (dependencyNodeH6 != null) {
                    dependencyNodeH6.b(this);
                }
                if (dependencyNodeH7 != null) {
                    dependencyNodeH7.b(this);
                }
                this.f1172j = WidgetRun.RunType.f1174b;
            }
            if (this.f1165b.E) {
                c(dependencyNode3, dependencyNode2, 1, this.f1179l);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode dependencyNodeH8 = WidgetRun.h(constraintAnchor5);
            if (dependencyNodeH8 != null) {
                WidgetRun.b(dependencyNode2, dependencyNodeH8, this.f1165b.R[2].e());
                c(dependencyNode, dependencyNode2, 1, aVar);
                if (this.f1165b.E) {
                    c(dependencyNode3, dependencyNode2, 1, this.f1179l);
                }
                if (this.f1167d == dimensionBehaviour3) {
                    ConstraintWidget constraintWidget17 = this.f1165b;
                    if (constraintWidget17.Y > 0.0f) {
                        c cVar = constraintWidget17.f1103d;
                        if (cVar.f1167d == dimensionBehaviour3) {
                            cVar.f1168e.f1154k.add(aVar);
                            arrayList2.add(this.f1165b.f1103d.f1168e);
                            aVar.f1145a = this;
                        }
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.f1088f != null) {
                DependencyNode dependencyNodeH9 = WidgetRun.h(constraintAnchor7);
                if (dependencyNodeH9 != null) {
                    WidgetRun.b(dependencyNode, dependencyNodeH9, -this.f1165b.R[3].e());
                    c(dependencyNode2, dependencyNode, -1, aVar);
                    if (this.f1165b.E) {
                        c(dependencyNode3, dependencyNode2, 1, this.f1179l);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.f1088f != null) {
                    DependencyNode dependencyNodeH10 = WidgetRun.h(constraintAnchor8);
                    if (dependencyNodeH10 != null) {
                        WidgetRun.b(dependencyNode3, dependencyNodeH10, 0);
                        c(dependencyNode2, dependencyNode3, -1, this.f1179l);
                        c(dependencyNode, dependencyNode2, 1, aVar);
                    }
                } else if (!(constraintWidget16 instanceof g0.a) && (constraintWidget3 = constraintWidget16.V) != null) {
                    WidgetRun.b(dependencyNode2, constraintWidget3.f1105e.h, constraintWidget16.s());
                    c(dependencyNode, dependencyNode2, 1, aVar);
                    if (this.f1165b.E) {
                        c(dependencyNode3, dependencyNode2, 1, this.f1179l);
                    }
                    if (this.f1167d == dimensionBehaviour3) {
                        ConstraintWidget constraintWidget18 = this.f1165b;
                        if (constraintWidget18.Y > 0.0f) {
                            c cVar2 = constraintWidget18.f1103d;
                            if (cVar2.f1167d == dimensionBehaviour3) {
                                cVar2.f1168e.f1154k.add(aVar);
                                arrayList2.add(this.f1165b.f1103d.f1168e);
                                aVar.f1145a = this;
                            }
                        }
                    }
                }
            }
        }
        if (arrayList2.size() == 0) {
            aVar.f1147c = true;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void e() {
        DependencyNode dependencyNode = this.h;
        if (dependencyNode.f1153j) {
            this.f1165b.b0 = dependencyNode.f1151g;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void f() {
        this.f1166c = null;
        this.h.c();
        this.f1171i.c();
        this.f1178k.c();
        this.f1168e.c();
        this.f1170g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean k() {
        return this.f1167d != ConstraintWidget.DimensionBehaviour.f1138c || this.f1165b.f1129s == 0;
    }

    public final void m() {
        this.f1170g = false;
        DependencyNode dependencyNode = this.h;
        dependencyNode.c();
        dependencyNode.f1153j = false;
        DependencyNode dependencyNode2 = this.f1171i;
        dependencyNode2.c();
        dependencyNode2.f1153j = false;
        DependencyNode dependencyNode3 = this.f1178k;
        dependencyNode3.c();
        dependencyNode3.f1153j = false;
        this.f1168e.f1153j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f1165b.f1115j0;
    }
}
