package p0;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* loaded from: classes.dex */
public class h extends WidgetRun {
    public h(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.f11986e.f();
        constraintWidget.f11988f.f();
        this.f12052f = ((androidx.constraintlayout.core.widgets.f) constraintWidget).x1();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, p0.InterfaceC5036d
    public void a(InterfaceC5036d interfaceC5036d) {
        DependencyNode dependencyNode = this.f12054h;
        if (dependencyNode.f12037c && !dependencyNode.f12044j) {
            this.f12054h.d((int) ((dependencyNode.f12046l.get(0).f12041g * ((androidx.constraintlayout.core.widgets.f) this.f12048b).A1()) + 0.5f));
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        androidx.constraintlayout.core.widgets.f fVar = (androidx.constraintlayout.core.widgets.f) this.f12048b;
        int iY1 = fVar.y1();
        int iZ1 = fVar.z1();
        fVar.A1();
        if (fVar.x1() == 1) {
            if (iY1 != -1) {
                this.f12054h.f12046l.add(this.f12048b.f11983c0.f11986e.f12054h);
                this.f12048b.f11983c0.f11986e.f12054h.f12045k.add(this.f12054h);
                this.f12054h.f12040f = iY1;
            } else if (iZ1 != -1) {
                this.f12054h.f12046l.add(this.f12048b.f11983c0.f11986e.f12055i);
                this.f12048b.f11983c0.f11986e.f12055i.f12045k.add(this.f12054h);
                this.f12054h.f12040f = -iZ1;
            } else {
                DependencyNode dependencyNode = this.f12054h;
                dependencyNode.f12036b = true;
                dependencyNode.f12046l.add(this.f12048b.f11983c0.f11986e.f12055i);
                this.f12048b.f11983c0.f11986e.f12055i.f12045k.add(this.f12054h);
            }
            q(this.f12048b.f11986e.f12054h);
            q(this.f12048b.f11986e.f12055i);
            return;
        }
        if (iY1 != -1) {
            this.f12054h.f12046l.add(this.f12048b.f11983c0.f11988f.f12054h);
            this.f12048b.f11983c0.f11988f.f12054h.f12045k.add(this.f12054h);
            this.f12054h.f12040f = iY1;
        } else if (iZ1 != -1) {
            this.f12054h.f12046l.add(this.f12048b.f11983c0.f11988f.f12055i);
            this.f12048b.f11983c0.f11988f.f12055i.f12045k.add(this.f12054h);
            this.f12054h.f12040f = -iZ1;
        } else {
            DependencyNode dependencyNode2 = this.f12054h;
            dependencyNode2.f12036b = true;
            dependencyNode2.f12046l.add(this.f12048b.f11983c0.f11988f.f12055i);
            this.f12048b.f11983c0.f11988f.f12055i.f12045k.add(this.f12054h);
        }
        q(this.f12048b.f11988f.f12054h);
        q(this.f12048b.f11988f.f12055i);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        if (((androidx.constraintlayout.core.widgets.f) this.f12048b).x1() == 1) {
            this.f12048b.r1(this.f12054h.f12041g);
        } else {
            this.f12048b.s1(this.f12054h.f12041g);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f12054h.c();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        return false;
    }

    public final void q(DependencyNode dependencyNode) {
        this.f12054h.f12045k.add(dependencyNode);
        dependencyNode.f12046l.add(this.f12054h);
    }
}
