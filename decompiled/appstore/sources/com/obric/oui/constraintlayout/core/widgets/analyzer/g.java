package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;

/* JADX INFO: loaded from: classes4.dex */
public class g extends WidgetRun {
    public g(ConstraintWidget r10) {
        super(r10);
        r10.f13259e.e();
        r10.f13261f.e();
        this.f13339f = ((com.obric.oui.constraintlayout.core.widgets.f) r10).u1();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void c() {
        com.obric.oui.constraintlayout.core.widgets.f r10 = (com.obric.oui.constraintlayout.core.widgets.f) this.f13335b;
        int r11 = r10.v1();
        int r12 = r10.w1();
        r10.x1();
        if (r10.u1() != 1) goto L10;
        if (r11 == (-1)) goto L6;
        this.f13341h.f13333l.add(this.f13335b.f13256c0.f13259e.f13341h);
        this.f13335b.f13256c0.f13259e.f13341h.f13332k.add(this.f13341h);
        this.f13341h.f13327f = r11;
    L9:
        p(this.f13335b.f13259e.f13341h);
        p(this.f13335b.f13259e.f13342i);
        return;
    L6:
        if (r12 == (-1)) goto L8;
        this.f13341h.f13333l.add(this.f13335b.f13256c0.f13259e.f13342i);
        this.f13335b.f13256c0.f13259e.f13342i.f13332k.add(this.f13341h);
        int r13 = -r12;
        this.f13341h.f13327f = r13;
        goto L9
    L8:
        DependencyNode r14 = this.f13341h;
        r14.f13323b = true;
        r14.f13333l.add(this.f13335b.f13256c0.f13259e.f13342i);
        this.f13335b.f13256c0.f13259e.f13342i.f13332k.add(this.f13341h);
        goto L9
    L10:
        if (r11 == (-1)) goto L12;
        this.f13341h.f13333l.add(this.f13335b.f13256c0.f13261f.f13341h);
        this.f13335b.f13256c0.f13261f.f13341h.f13332k.add(this.f13341h);
        this.f13341h.f13327f = r11;
    L15:
        p(this.f13335b.f13261f.f13341h);
        p(this.f13335b.f13261f.f13342i);
        return;
    L12:
        if (r12 == (-1)) goto L14;
        this.f13341h.f13333l.add(this.f13335b.f13256c0.f13261f.f13342i);
        this.f13335b.f13256c0.f13261f.f13342i.f13332k.add(this.f13341h);
        int r15 = -r12;
        this.f13341h.f13327f = r15;
        goto L15
    L14:
        DependencyNode r16 = this.f13341h;
        r16.f13323b = true;
        r16.f13333l.add(this.f13335b.f13256c0.f13261f.f13342i);
        this.f13335b.f13256c0.f13261f.f13342i.f13332k.add(this.f13341h);
        goto L15
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        if (((com.obric.oui.constraintlayout.core.widgets.f) this.f13335b).u1() != 1) goto L5;
        this.f13335b.o1(this.f13341h.f13328g);
        return;
    L5:
        this.f13335b.p1(this.f13341h.f13328g);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        this.f13341h.b();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean l() {
        return false;
    }

    public final void p(DependencyNode r10) {
        this.f13341h.f13332k.add(r10);
        r10.f13333l.add(this.f13341h);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r10) {
        DependencyNode r11 = this.f13341h;
        if (r11.f13324c == true) goto L6;
        return;
    L6:
        if (r11.f13331j == false) goto L8;
        return;
    L8:
        this.f13341h.c((int) ((((DependencyNode) r11.f13333l.get(0)).f13328g * ((com.obric.oui.constraintlayout.core.widgets.f) this.f13335b).x1()) + 0.5f));
    }
}
