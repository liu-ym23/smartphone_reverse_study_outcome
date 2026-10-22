package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class h extends WidgetRun {
    public h(ConstraintWidget r10) {
        super(r10);
    }

    private void p(DependencyNode r10) {
        this.f1548h.f1539k.add(r10);
        r10.f1540l.add(this.f1548h);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void c() {
        ConstraintWidget r10 = this.f1542b;
        if ((r10 instanceof androidx.constraintlayout.core.widgets.a) == false) goto L69;
        this.f1548h.f1530b = true;
        androidx.constraintlayout.core.widgets.a r11 = (androidx.constraintlayout.core.widgets.a) r10;
        int r12 = r11.w1();
        boolean r13 = r11.v1();
        int r14 = 0;
        if (r12 == 0) goto L45;
        if (r12 != 1) goto L8;
        DependencyNode r15 = this.f1548h;
        r15.f1533e = DependencyNode.Type.RIGHT;
    L36:
        if (r14 >= r11.W0) goto L44;
        ConstraintWidget r16 = r11.V0[r14];
        if (r13 == false) goto L40;
    L42:
        DependencyNode r17 = r16.f1440e.f1549i;
        r17.f1539k.add(this.f1548h);
        this.f1548h.f1540l.add(r17);
    L43:
        r14 = r14 + 1;
        goto L36
    L40:
        if (r16.U() != 8) goto L42;
    L44:
        p(this.f1542b.f1440e.f1548h);
        p(this.f1542b.f1440e.f1549i);
        return;
    L8:
        if (r12 != 2) goto L10;
        DependencyNode r18 = this.f1548h;
        r18.f1533e = DependencyNode.Type.TOP;
    L25:
        if (r14 >= r11.W0) goto L33;
        ConstraintWidget r19 = r11.V0[r14];
        if (r13 == false) goto L29;
    L31:
        DependencyNode r20 = r19.f1442f.f1548h;
        r20.f1539k.add(this.f1548h);
        this.f1548h.f1540l.add(r20);
    L32:
        r14 = r14 + 1;
        goto L25
    L29:
        if (r19.U() != 8) goto L31;
    L33:
        p(this.f1542b.f1442f.f1548h);
        p(this.f1542b.f1442f.f1549i);
        return;
    L10:
        if (r12 != 3) goto L73;
        DependencyNode r21 = this.f1548h;
        r21.f1533e = DependencyNode.Type.BOTTOM;
    L14:
        if (r14 >= r11.W0) goto L22;
        ConstraintWidget r22 = r11.V0[r14];
        if (r13 == false) goto L18;
    L20:
        DependencyNode r23 = r22.f1442f.f1549i;
        r23.f1539k.add(this.f1548h);
        this.f1548h.f1540l.add(r23);
    L21:
        r14 = r14 + 1;
        goto L14
    L18:
        if (r22.U() != 8) goto L20;
    L22:
        p(this.f1542b.f1442f.f1548h);
        p(this.f1542b.f1442f.f1549i);
        return;
    L73:
        return;
    L45:
        DependencyNode r24 = this.f1548h;
        r24.f1533e = DependencyNode.Type.LEFT;
    L47:
        if (r14 >= r11.W0) goto L55;
        ConstraintWidget r25 = r11.V0[r14];
        if (r13 == false) goto L51;
    L53:
        DependencyNode r26 = r25.f1440e.f1548h;
        r26.f1539k.add(this.f1548h);
        this.f1548h.f1540l.add(r26);
    L54:
        r14 = r14 + 1;
        goto L47
    L51:
        if (r25.U() != 8) goto L53;
    L55:
        p(this.f1542b.f1440e.f1548h);
        p(this.f1542b.f1440e.f1549i);
        return;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget r10 = this.f1542b;
        if ((r10 instanceof androidx.constraintlayout.core.widgets.a) == false) goto L12;
        int r11 = ((androidx.constraintlayout.core.widgets.a) r10).w1();
        if (r11 != 0) goto L7;
    L10:
        this.f1542b.n1(this.f1548h.f1535g);
        return;
    L7:
        if (r11 == 1) goto L10;
        this.f1542b.o1(this.f1548h.f1535g);
        return;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        this.f1543c = null;
        this.f1548h.b();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean l() {
        return false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r10) {
        androidx.constraintlayout.core.widgets.a r11 = (androidx.constraintlayout.core.widgets.a) this.f1542b;
        int r12 = r11.w1();
        Iterator r13 = this.f1548h.f1540l.iterator();
        int r14 = 0;
        int r15 = -1;
    L4:
        if (r13.hasNext() == false) goto L11;
        int r16 = ((DependencyNode) r13.next()).f1535g;
        if (r15 == (-1)) goto L8;
        if (r16 < r15) goto L8;
    L9:
        if (r14 >= r16) goto L4;
        r14 = r16;
    L8:
        r15 = r16;
        goto L9
    L11:
        if (r12 != 0) goto L13;
    L16:
        this.f1548h.c(r15 + r11.x1());
        return;
    L13:
        if (r12 == 2) goto L16;
        this.f1548h.c(r14 + r11.x1());
    }
}
