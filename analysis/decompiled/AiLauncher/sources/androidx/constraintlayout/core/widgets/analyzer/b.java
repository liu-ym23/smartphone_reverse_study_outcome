package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import java.util.Iterator;
import p0.InterfaceC5036d;

/* loaded from: classes.dex */
public class b extends WidgetRun {
    public b(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void q(DependencyNode dependencyNode) {
        this.f12054h.f12045k.add(dependencyNode);
        dependencyNode.f12046l.add(this.f12054h);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, p0.InterfaceC5036d
    public void a(InterfaceC5036d interfaceC5036d) {
        androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) this.f12048b;
        int iA1 = aVar.A1();
        Iterator<DependencyNode> it = this.f12054h.f12046l.iterator();
        int i10 = 0;
        int i11 = -1;
        while (it.hasNext()) {
            int i12 = it.next().f12041g;
            if (i11 == -1 || i12 < i11) {
                i11 = i12;
            }
            if (i10 < i12) {
                i10 = i12;
            }
        }
        if (iA1 == 0 || iA1 == 2) {
            this.f12054h.d(i11 + aVar.B1());
        } else {
            this.f12054h.d(i10 + aVar.B1());
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget constraintWidget = this.f12048b;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            this.f12054h.f12036b = true;
            androidx.constraintlayout.core.widgets.a aVar = (androidx.constraintlayout.core.widgets.a) constraintWidget;
            int iA1 = aVar.A1();
            boolean zZ1 = aVar.z1();
            int i10 = 0;
            if (iA1 == 0) {
                this.f12054h.f12039e = DependencyNode.Type.LEFT;
                while (i10 < aVar.f37461W0) {
                    ConstraintWidget constraintWidget2 = aVar.f37460V0[i10];
                    if (zZ1 || constraintWidget2.X() != 8) {
                        DependencyNode dependencyNode = constraintWidget2.f11986e.f12054h;
                        dependencyNode.f12045k.add(this.f12054h);
                        this.f12054h.f12046l.add(dependencyNode);
                    }
                    i10++;
                }
                q(this.f12048b.f11986e.f12054h);
                q(this.f12048b.f11986e.f12055i);
                return;
            }
            if (iA1 == 1) {
                this.f12054h.f12039e = DependencyNode.Type.RIGHT;
                while (i10 < aVar.f37461W0) {
                    ConstraintWidget constraintWidget3 = aVar.f37460V0[i10];
                    if (zZ1 || constraintWidget3.X() != 8) {
                        DependencyNode dependencyNode2 = constraintWidget3.f11986e.f12055i;
                        dependencyNode2.f12045k.add(this.f12054h);
                        this.f12054h.f12046l.add(dependencyNode2);
                    }
                    i10++;
                }
                q(this.f12048b.f11986e.f12054h);
                q(this.f12048b.f11986e.f12055i);
                return;
            }
            if (iA1 == 2) {
                this.f12054h.f12039e = DependencyNode.Type.TOP;
                while (i10 < aVar.f37461W0) {
                    ConstraintWidget constraintWidget4 = aVar.f37460V0[i10];
                    if (zZ1 || constraintWidget4.X() != 8) {
                        DependencyNode dependencyNode3 = constraintWidget4.f11988f.f12054h;
                        dependencyNode3.f12045k.add(this.f12054h);
                        this.f12054h.f12046l.add(dependencyNode3);
                    }
                    i10++;
                }
                q(this.f12048b.f11988f.f12054h);
                q(this.f12048b.f11988f.f12055i);
                return;
            }
            if (iA1 != 3) {
                return;
            }
            this.f12054h.f12039e = DependencyNode.Type.BOTTOM;
            while (i10 < aVar.f37461W0) {
                ConstraintWidget constraintWidget5 = aVar.f37460V0[i10];
                if (zZ1 || constraintWidget5.X() != 8) {
                    DependencyNode dependencyNode4 = constraintWidget5.f11988f.f12055i;
                    dependencyNode4.f12045k.add(this.f12054h);
                    this.f12054h.f12046l.add(dependencyNode4);
                }
                i10++;
            }
            q(this.f12048b.f11988f.f12054h);
            q(this.f12048b.f11988f.f12055i);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        ConstraintWidget constraintWidget = this.f12048b;
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.a) {
            int iA1 = ((androidx.constraintlayout.core.widgets.a) constraintWidget).A1();
            if (iA1 == 0 || iA1 == 1) {
                this.f12048b.r1(this.f12054h.f12041g);
            } else {
                this.f12048b.s1(this.f12054h.f12041g);
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void f() {
        this.f12049c = null;
        this.f12054h.c();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean m() {
        return false;
    }
}
