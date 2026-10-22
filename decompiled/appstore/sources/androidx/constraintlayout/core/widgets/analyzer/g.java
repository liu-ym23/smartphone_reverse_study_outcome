package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes.dex */
public class g extends WidgetRun {
    public g(ConstraintWidget r10) {
        super(r10);
        r10.f1440e.e();
        r10.f1442f.e();
        this.f1546f = ((androidx.constraintlayout.core.widgets.e) r10).t1();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void c() {
        androidx.constraintlayout.core.widgets.e r10 = (androidx.constraintlayout.core.widgets.e) this.f1542b;
        int r11 = r10.u1();
        int r12 = r10.v1();
        r10.w1();
        if (r10.t1() != 1) goto L10;
        if (r11 == (-1)) goto L6;
        this.f1548h.f1540l.add(this.f1542b.f1437c0.f1440e.f1548h);
        this.f1542b.f1437c0.f1440e.f1548h.f1539k.add(this.f1548h);
        this.f1548h.f1534f = r11;
    L9:
        p(this.f1542b.f1440e.f1548h);
        p(this.f1542b.f1440e.f1549i);
        return;
    L6:
        if (r12 == (-1)) goto L8;
        this.f1548h.f1540l.add(this.f1542b.f1437c0.f1440e.f1549i);
        this.f1542b.f1437c0.f1440e.f1549i.f1539k.add(this.f1548h);
        int r13 = -r12;
        this.f1548h.f1534f = r13;
        goto L9
    L8:
        DependencyNode r14 = this.f1548h;
        r14.f1530b = true;
        r14.f1540l.add(this.f1542b.f1437c0.f1440e.f1549i);
        this.f1542b.f1437c0.f1440e.f1549i.f1539k.add(this.f1548h);
        goto L9
    L10:
        if (r11 == (-1)) goto L12;
        this.f1548h.f1540l.add(this.f1542b.f1437c0.f1442f.f1548h);
        this.f1542b.f1437c0.f1442f.f1548h.f1539k.add(this.f1548h);
        this.f1548h.f1534f = r11;
    L15:
        p(this.f1542b.f1442f.f1548h);
        p(this.f1542b.f1442f.f1549i);
        return;
    L12:
        if (r12 == (-1)) goto L14;
        this.f1548h.f1540l.add(this.f1542b.f1437c0.f1442f.f1549i);
        this.f1542b.f1437c0.f1442f.f1549i.f1539k.add(this.f1548h);
        int r15 = -r12;
        this.f1548h.f1534f = r15;
        goto L15
    L14:
        DependencyNode r16 = this.f1548h;
        r16.f1530b = true;
        r16.f1540l.add(this.f1542b.f1437c0.f1442f.f1549i);
        this.f1542b.f1437c0.f1442f.f1549i.f1539k.add(this.f1548h);
        goto L15
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        if (((androidx.constraintlayout.core.widgets.e) this.f1542b).t1() != 1) goto L5;
        this.f1542b.n1(this.f1548h.f1535g);
        return;
    L5:
        this.f1542b.o1(this.f1548h.f1535g);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        this.f1548h.b();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean l() {
        return false;
    }

    public final void p(DependencyNode r10) {
        this.f1548h.f1539k.add(r10);
        r10.f1540l.add(this.f1548h);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r10) {
        DependencyNode r11 = this.f1548h;
        if (r11.f1531c == true) goto L6;
        return;
    L6:
        if (r11.f1538j == false) goto L8;
        return;
    L8:
        this.f1548h.c((int) ((((DependencyNode) r11.f1540l.get(0)).f1535g * ((androidx.constraintlayout.core.widgets.e) this.f1542b).w1()) + 0.5f));
    }
}
