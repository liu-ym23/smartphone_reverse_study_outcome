package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends WidgetRun {
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, h0.d
    public final void a(h0.d dVar) {
        androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) this.f1165b;
        int i10 = aVar.f1141t0;
        DependencyNode dependencyNode = this.h;
        ArrayList arrayList = dependencyNode.f1155l;
        int size = arrayList.size();
        int i11 = 0;
        int i12 = -1;
        int i13 = 0;
        while (i13 < size) {
            Object obj = arrayList.get(i13);
            i13++;
            int i14 = ((DependencyNode) obj).f1151g;
            if (i12 == -1 || i14 < i12) {
                i12 = i14;
            }
            if (i11 < i14) {
                i11 = i14;
            }
        }
        if (i10 == 0 || i10 == 2) {
            dependencyNode.d(i12 + aVar.f1143v0);
        } else {
            dependencyNode.d(i11 + aVar.f1143v0);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void d() {
        ConstraintWidget constraintWidget = this.f1165b;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            DependencyNode dependencyNode = this.h;
            dependencyNode.f1146b = true;
            ArrayList arrayList = dependencyNode.f1155l;
            androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) constraintWidget;
            int i10 = aVar.f1141t0;
            boolean z = aVar.f1142u0;
            int i11 = 0;
            if (i10 == 0) {
                dependencyNode.f1149e = DependencyNode.Type.f1159d;
                while (i11 < aVar.f8945s0) {
                    ConstraintWidget constraintWidget2 = aVar.f8944r0[i11];
                    if (z || constraintWidget2.f1113i0 != 8) {
                        DependencyNode dependencyNode2 = constraintWidget2.f1103d.h;
                        dependencyNode2.f1154k.add(dependencyNode);
                        arrayList.add(dependencyNode2);
                    }
                    i11++;
                }
                m(this.f1165b.f1103d.h);
                m(this.f1165b.f1103d.f1171i);
                return;
            }
            if (i10 == 1) {
                dependencyNode.f1149e = DependencyNode.Type.f1160e;
                while (i11 < aVar.f8945s0) {
                    ConstraintWidget constraintWidget3 = aVar.f8944r0[i11];
                    if (z || constraintWidget3.f1113i0 != 8) {
                        DependencyNode dependencyNode3 = constraintWidget3.f1103d.f1171i;
                        dependencyNode3.f1154k.add(dependencyNode);
                        arrayList.add(dependencyNode3);
                    }
                    i11++;
                }
                m(this.f1165b.f1103d.h);
                m(this.f1165b.f1103d.f1171i);
                return;
            }
            if (i10 == 2) {
                dependencyNode.f1149e = DependencyNode.Type.h;
                while (i11 < aVar.f8945s0) {
                    ConstraintWidget constraintWidget4 = aVar.f8944r0[i11];
                    if (z || constraintWidget4.f1113i0 != 8) {
                        DependencyNode dependencyNode4 = constraintWidget4.f1105e.h;
                        dependencyNode4.f1154k.add(dependencyNode);
                        arrayList.add(dependencyNode4);
                    }
                    i11++;
                }
                m(this.f1165b.f1105e.h);
                m(this.f1165b.f1105e.f1171i);
                return;
            }
            if (i10 != 3) {
                return;
            }
            dependencyNode.f1149e = DependencyNode.Type.f1161j;
            while (i11 < aVar.f8945s0) {
                ConstraintWidget constraintWidget5 = aVar.f8944r0[i11];
                if (z || constraintWidget5.f1113i0 != 8) {
                    DependencyNode dependencyNode5 = constraintWidget5.f1105e.f1171i;
                    dependencyNode5.f1154k.add(dependencyNode);
                    arrayList.add(dependencyNode5);
                }
                i11++;
            }
            m(this.f1165b.f1105e.h);
            m(this.f1165b.f1105e.f1171i);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void e() {
        ConstraintWidget constraintWidget = this.f1165b;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            int i10 = ((androidx.constraintlayout.core.widgets.a) constraintWidget).f1141t0;
            DependencyNode dependencyNode = this.h;
            if (i10 == 0 || i10 == 1) {
                constraintWidget.f1100a0 = dependencyNode.f1151g;
            } else {
                constraintWidget.b0 = dependencyNode.f1151g;
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void f() {
        this.f1166c = null;
        this.h.c();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean k() {
        return false;
    }

    public final void m(DependencyNode dependencyNode) {
        DependencyNode dependencyNode2 = this.h;
        dependencyNode2.f1154k.add(dependencyNode);
        dependencyNode.f1155l.add(dependencyNode2);
    }
}
