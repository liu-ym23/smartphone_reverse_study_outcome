package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class h extends WidgetRun {
    public h(ConstraintWidget r10) {
        super(r10);
    }

    private void p(DependencyNode r10) {
        this.f13341h.f13332k.add(r10);
        r10.f13333l.add(this.f13341h);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void c() {
        ConstraintWidget r10 = this.f13335b;
        if ((r10 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L69;
        this.f13341h.f13323b = true;
        com.obric.oui.constraintlayout.core.widgets.a r11 = (com.obric.oui.constraintlayout.core.widgets.a) r10;
        int r12 = r11.x1();
        boolean r13 = r11.w1();
        int r14 = 0;
        if (r12 == 0) goto L45;
        if (r12 != 1) goto L8;
        DependencyNode r15 = this.f13341h;
        r15.f13326e = DependencyNode.Type.RIGHT;
    L36:
        if (r14 >= r11.W0) goto L44;
        ConstraintWidget r16 = r11.V0[r14];
        if (r13 == false) goto L40;
    L42:
        DependencyNode r17 = r16.f13259e.f13342i;
        r17.f13332k.add(this.f13341h);
        this.f13341h.f13333l.add(r17);
    L43:
        r14 = r14 + 1;
        goto L36
    L40:
        if (r16.U() != 8) goto L42;
    L44:
        p(this.f13335b.f13259e.f13341h);
        p(this.f13335b.f13259e.f13342i);
        return;
    L8:
        if (r12 != 2) goto L10;
        DependencyNode r18 = this.f13341h;
        r18.f13326e = DependencyNode.Type.TOP;
    L25:
        if (r14 >= r11.W0) goto L33;
        ConstraintWidget r19 = r11.V0[r14];
        if (r13 == false) goto L29;
    L31:
        DependencyNode r20 = r19.f13261f.f13341h;
        r20.f13332k.add(this.f13341h);
        this.f13341h.f13333l.add(r20);
    L32:
        r14 = r14 + 1;
        goto L25
    L29:
        if (r19.U() != 8) goto L31;
    L33:
        p(this.f13335b.f13261f.f13341h);
        p(this.f13335b.f13261f.f13342i);
        return;
    L10:
        if (r12 != 3) goto L73;
        DependencyNode r21 = this.f13341h;
        r21.f13326e = DependencyNode.Type.BOTTOM;
    L14:
        if (r14 >= r11.W0) goto L22;
        ConstraintWidget r22 = r11.V0[r14];
        if (r13 == false) goto L18;
    L20:
        DependencyNode r23 = r22.f13261f.f13342i;
        r23.f13332k.add(this.f13341h);
        this.f13341h.f13333l.add(r23);
    L21:
        r14 = r14 + 1;
        goto L14
    L18:
        if (r22.U() != 8) goto L20;
    L22:
        p(this.f13335b.f13261f.f13341h);
        p(this.f13335b.f13261f.f13342i);
        return;
    L73:
        return;
    L45:
        DependencyNode r24 = this.f13341h;
        r24.f13326e = DependencyNode.Type.LEFT;
    L47:
        if (r14 >= r11.W0) goto L55;
        ConstraintWidget r25 = r11.V0[r14];
        if (r13 == false) goto L51;
    L53:
        DependencyNode r26 = r25.f13259e.f13341h;
        r26.f13332k.add(this.f13341h);
        this.f13341h.f13333l.add(r26);
    L54:
        r14 = r14 + 1;
        goto L47
    L51:
        if (r25.U() != 8) goto L53;
    L55:
        p(this.f13335b.f13259e.f13341h);
        p(this.f13335b.f13259e.f13342i);
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        ConstraintWidget r10 = this.f13335b;
        if ((r10 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L12;
        int r11 = ((com.obric.oui.constraintlayout.core.widgets.a) r10).x1();
        if (r11 != 0) goto L7;
    L10:
        this.f13335b.o1(this.f13341h.f13328g);
        return;
    L7:
        if (r11 == 1) goto L10;
        this.f13335b.p1(this.f13341h.f13328g);
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        this.f13336c = null;
        this.f13341h.b();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean l() {
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r10) {
        com.obric.oui.constraintlayout.core.widgets.a r11 = (com.obric.oui.constraintlayout.core.widgets.a) this.f13335b;
        int r12 = r11.x1();
        Iterator r13 = this.f13341h.f13333l.iterator();
        int r14 = 0;
        int r15 = -1;
    L4:
        if (r13.hasNext() == false) goto L11;
        int r16 = ((DependencyNode) r13.next()).f13328g;
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
        this.f13341h.c(r15 + r11.y1());
        return;
    L13:
        if (r12 == 2) goto L16;
        this.f13341h.c(r14 + r11.y1());
    }
}
