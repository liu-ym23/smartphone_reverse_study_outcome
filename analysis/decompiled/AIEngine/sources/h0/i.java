package h0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i extends WidgetRun {
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, h0.d
    public final void a(d dVar) {
        DependencyNode dependencyNode = this.h;
        if (dependencyNode.f1147c && !dependencyNode.f1153j) {
            dependencyNode.d((int) ((((DependencyNode) dependencyNode.f1155l.get(0)).f1151g * ((androidx.constraintlayout.core.widgets.f) this.f1165b).f1222r0) + 0.5f));
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void d() {
        ConstraintWidget constraintWidget = this.f1165b;
        androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) constraintWidget;
        int i10 = fVar.f1223s0;
        int i11 = fVar.f1224t0;
        int i12 = fVar.f1226v0;
        DependencyNode dependencyNode = this.h;
        if (i12 == 1) {
            if (i10 != -1) {
                dependencyNode.f1155l.add(constraintWidget.V.f1103d.h);
                this.f1165b.V.f1103d.h.f1154k.add(dependencyNode);
                dependencyNode.f1150f = i10;
            } else if (i11 != -1) {
                dependencyNode.f1155l.add(constraintWidget.V.f1103d.f1171i);
                this.f1165b.V.f1103d.f1171i.f1154k.add(dependencyNode);
                dependencyNode.f1150f = -i11;
            } else {
                dependencyNode.f1146b = true;
                dependencyNode.f1155l.add(constraintWidget.V.f1103d.f1171i);
                this.f1165b.V.f1103d.f1171i.f1154k.add(dependencyNode);
            }
            m(this.f1165b.f1103d.h);
            m(this.f1165b.f1103d.f1171i);
            return;
        }
        if (i10 != -1) {
            dependencyNode.f1155l.add(constraintWidget.V.f1105e.h);
            this.f1165b.V.f1105e.h.f1154k.add(dependencyNode);
            dependencyNode.f1150f = i10;
        } else if (i11 != -1) {
            dependencyNode.f1155l.add(constraintWidget.V.f1105e.f1171i);
            this.f1165b.V.f1105e.f1171i.f1154k.add(dependencyNode);
            dependencyNode.f1150f = -i11;
        } else {
            dependencyNode.f1146b = true;
            dependencyNode.f1155l.add(constraintWidget.V.f1105e.f1171i);
            this.f1165b.V.f1105e.f1171i.f1154k.add(dependencyNode);
        }
        m(this.f1165b.f1105e.h);
        m(this.f1165b.f1105e.f1171i);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void e() {
        ConstraintWidget constraintWidget = this.f1165b;
        int i10 = ((androidx.constraintlayout.core.widgets.f) constraintWidget).f1226v0;
        DependencyNode dependencyNode = this.h;
        if (i10 == 1) {
            constraintWidget.f1100a0 = dependencyNode.f1151g;
        } else {
            constraintWidget.b0 = dependencyNode.f1151g;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void f() {
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
