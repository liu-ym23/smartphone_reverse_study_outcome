package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.Helper;

/* JADX INFO: loaded from: classes4.dex */
public class k extends WidgetRun {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DependencyNode f13370k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d f13371l;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13372a = null;

        static {
            int[] r10 = new int[WidgetRun.RunType.values().length];
            f13372a = r10;
            r10[WidgetRun.RunType.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f13372a[WidgetRun.RunType.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f13372a[WidgetRun.RunType.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public k(ConstraintWidget r10) {
        super(r10);
        DependencyNode r11 = new DependencyNode(this);
        this.f13370k = r11;
        this.f13371l = null;
        DependencyNode r12 = this.f13341h;
        r12.f13326e = DependencyNode.Type.TOP;
        DependencyNode r13 = this.f13342i;
        r13.f13326e = DependencyNode.Type.BOTTOM;
        r11.f13326e = DependencyNode.Type.BASELINE;
        this.f13339f = 1;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void c() {
        ConstraintWidget r10 = this.f13335b;
        if (r10.f13251a == false) goto L6;
        this.f13338e.c(r10.w());
    L6:
        if (this.f13338e.f13331j == true) goto L24;
        this.f13337d = this.f13335b.S();
        if (this.f13335b.Y() == false) goto L10;
        this.f13371l = new com.obric.oui.constraintlayout.core.widgets.analyzer.a(this);
    L10:
        ConstraintWidget.DimensionBehaviour r11 = this.f13337d;
        if (r11 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L13;
    L31:
        d r12 = this.f13338e;
        boolean r13 = r12.f13331j;
        if (r13 == false) goto L80;
        ConstraintWidget r14 = this.f13335b;
        if (r14.f13251a == false) goto L80;
        ConstraintAnchor[] r15 = r14.Y;
        ConstraintAnchor r16 = r15[2];
        ConstraintAnchor r17 = r16.f13245f;
        if (r17 != null) goto L38;
    L52:
        if (r17 == null) goto L58;
        DependencyNode r18 = g(r16);
        if (r18 == null) goto L160;
        a(this.f13341h, r18, this.f13335b.Y[2].f());
        a(this.f13342i, this.f13341h, this.f13338e.f13328g);
        if (this.f13335b.Y() == false) goto L161;
        a(this.f13370k, this.f13341h, this.f13335b.o());
        return;
    L161:
        return;
    L160:
        return;
    L58:
        ConstraintAnchor r19 = r15[3];
        if (r19.f13245f == null) goto L66;
        DependencyNode r20 = g(r19);
        if (r20 == null) goto L64;
        a(this.f13342i, r20, -this.f13335b.Y[3].f());
        a(this.f13341h, this.f13342i, -this.f13338e.f13328g);
    L64:
        if (this.f13335b.Y() == false) goto L163;
        a(this.f13370k, this.f13341h, this.f13335b.o());
        return;
    L163:
        return;
    L66:
        ConstraintAnchor r21 = r15[4];
        if (r21.f13245f == null) goto L72;
        DependencyNode r22 = g(r21);
        if (r22 == null) goto L165;
        a(this.f13370k, r22, 0);
        a(this.f13341h, this.f13370k, -this.f13335b.o());
        a(this.f13342i, this.f13341h, this.f13338e.f13328g);
        return;
    L165:
        return;
    L72:
        if ((r14 instanceof Helper) == false) goto L74;
        return;
    L74:
        if (r14.J() != null) goto L76;
        return;
    L76:
        if (this.f13335b.n(ConstraintAnchor.Type.CENTER).f13245f != null) goto L169;
        DependencyNode r23 = this.f13335b.J().f13261f.f13341h;
        a(this.f13341h, r23, this.f13335b.X());
        a(this.f13342i, this.f13341h, this.f13338e.f13328g);
        if (this.f13335b.Y() == false) goto L170;
        a(this.f13370k, this.f13341h, this.f13335b.o());
        return;
    L170:
        return;
    L169:
        return;
    L38:
        if (r15[3].f13245f == null) goto L52;
        if (r14.j0() == false) goto L42;
        DependencyNode r24 = this.f13341h;
        r24.f13327f = this.f13335b.Y[2].f();
        DependencyNode r25 = this.f13342i;
        r25.f13327f = -this.f13335b.Y[3].f();
    L50:
        if (this.f13335b.Y() == false) goto L158;
        a(this.f13370k, this.f13341h, this.f13335b.o());
        return;
    L158:
        return;
    L42:
        DependencyNode r26 = g(this.f13335b.Y[2]);
        if (r26 == null) goto L45;
        a(this.f13341h, r26, this.f13335b.Y[2].f());
    L45:
        DependencyNode r27 = g(this.f13335b.Y[3]);
        if (r27 == null) goto L48;
        a(this.f13342i, r27, -this.f13335b.Y[3].f());
    L48:
        this.f13341h.f13323b = true;
        this.f13342i.f13323b = true;
    L80:
        if (r13 == false) goto L82;
    L97:
        r12.a(this);
    L98:
        ConstraintWidget r28 = this.f13335b;
        ConstraintAnchor[] r29 = r28.Y;
        ConstraintAnchor r30 = r29[2];
        ConstraintAnchor r31 = r30.f13245f;
        if (r31 == null) goto L115;
        if (r29[3].f13245f == null) goto L115;
        if (r28.j0() == false) goto L105;
        DependencyNode r32 = this.f13341h;
        r32.f13327f = this.f13335b.Y[2].f();
        DependencyNode r33 = this.f13342i;
        r33.f13327f = -this.f13335b.Y[3].f();
    L112:
        if (this.f13335b.Y() == false) goto L155;
        b(this.f13370k, this.f13341h, 1, this.f13371l);
    L155:
        if (this.f13338e.f13333l.size() != 0) goto L172;
        this.f13338e.f13324c = true;
        return;
    L172:
        return;
    L105:
        DependencyNode r34 = g(this.f13335b.Y[2]);
        DependencyNode r35 = g(this.f13335b.Y[3]);
        if (r34 == null) goto L108;
        r34.a(this);
    L108:
        if (r35 == null) goto L110;
        r35.a(this);
    L110:
        this.f13343j = WidgetRun.RunType.CENTER;
    L115:
        if (r31 == null) goto L128;
        DependencyNode r36 = g(r30);
        if (r36 == null) goto L155;
        a(this.f13341h, r36, this.f13335b.Y[2].f());
        b(this.f13342i, this.f13341h, 1, this.f13338e);
        if (this.f13335b.Y() == false) goto L121;
        b(this.f13370k, this.f13341h, 1, this.f13371l);
    L121:
        ConstraintWidget.DimensionBehaviour r37 = this.f13337d;
        ConstraintWidget.DimensionBehaviour r38 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r37 != r38) goto L155;
        if (this.f13335b.u() <= 0.0f) goto L155;
        i r39 = this.f13335b.f13259e;
        if (r39.f13337d != r38) goto L155;
        r39.f13338e.f13332k.add(this.f13338e);
        this.f13338e.f13333l.add(this.f13335b.f13259e.f13338e);
        this.f13338e.f13322a = this;
        goto L155
    L128:
        ConstraintAnchor r40 = r29[3];
        if (r40.f13245f == null) goto L135;
        DependencyNode r41 = g(r40);
        if (r41 == null) goto L155;
        a(this.f13342i, r41, -this.f13335b.Y[3].f());
        b(this.f13341h, this.f13342i, -1, this.f13338e);
        if (this.f13335b.Y() == false) goto L155;
        b(this.f13370k, this.f13341h, 1, this.f13371l);
        goto L155
    L135:
        ConstraintAnchor r42 = r29[4];
        if (r42.f13245f == null) goto L141;
        DependencyNode r43 = g(r42);
        if (r43 == null) goto L155;
        a(this.f13370k, r43, 0);
        b(this.f13341h, this.f13370k, -1, this.f13371l);
        b(this.f13342i, this.f13341h, 1, this.f13338e);
        goto L155
    L141:
        if ((r28 instanceof Helper) == true) goto L155;
        if (r28.J() == null) goto L155;
        DependencyNode r44 = this.f13335b.J().f13261f.f13341h;
        a(this.f13341h, r44, this.f13335b.X());
        b(this.f13342i, this.f13341h, 1, this.f13338e);
        if (this.f13335b.Y() == false) goto L147;
        b(this.f13370k, this.f13341h, 1, this.f13371l);
    L147:
        ConstraintWidget.DimensionBehaviour r45 = this.f13337d;
        ConstraintWidget.DimensionBehaviour r46 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r45 != r46) goto L155;
        if (this.f13335b.u() <= 0.0f) goto L155;
        i r47 = this.f13335b.f13259e;
        if (r47.f13337d != r46) goto L155;
        r47.f13338e.f13332k.add(this.f13338e);
        this.f13338e.f13333l.add(this.f13335b.f13259e.f13338e);
        this.f13338e.f13322a = this;
        goto L155
    L82:
        if (this.f13337d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L97;
        ConstraintWidget r48 = this.f13335b;
        int r49 = r48.f13297x;
        if (r49 == 2) goto L93;
        if (r49 != 3) goto L98;
        if (r48.j0() == true) goto L98;
        ConstraintWidget r50 = this.f13335b;
        if (r50.f13295w == 3) goto L98;
        d r51 = r50.f13259e.f13338e;
        this.f13338e.f13333l.add(r51);
        r51.f13332k.add(this.f13338e);
        d r52 = this.f13338e;
        r52.f13323b = true;
        r52.f13332k.add(this.f13341h);
        this.f13338e.f13332k.add(this.f13342i);
        goto L98
    L93:
        ConstraintWidget r53 = r48.J();
        if (r53 == null) goto L98;
        d r54 = r53.f13261f.f13338e;
        this.f13338e.f13333l.add(r54);
        r54.f13332k.add(this.f13338e);
        d r55 = this.f13338e;
        r55.f13323b = true;
        r55.f13332k.add(this.f13341h);
        this.f13338e.f13332k.add(this.f13342i);
        goto L98
    L13:
        if (r11 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L21;
        ConstraintWidget r56 = this.f13335b.J();
        if (r56 == null) goto L21;
        if (r56.S() != ConstraintWidget.DimensionBehaviour.FIXED) goto L21;
        int r57 = (r56.w() - this.f13335b.R.f()) - this.f13335b.T.f();
        a(this.f13341h, r56.f13261f.f13341h, this.f13335b.R.f());
        a(this.f13342i, r56.f13261f.f13342i, -this.f13335b.T.f());
        this.f13338e.c(r57);
        return;
    L21:
        if (this.f13337d != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
        this.f13338e.c(this.f13335b.w());
        goto L31
    L24:
        if (this.f13337d != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L31;
        ConstraintWidget r58 = this.f13335b.J();
        if (r58 == null) goto L31;
        if (r58.S() != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
        a(this.f13341h, r58.f13261f.f13341h, this.f13335b.R.f());
        a(this.f13342i, r58.f13261f.f13342i, -this.f13335b.T.f());
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        DependencyNode r10 = this.f13341h;
        if (r10.f13331j == false) goto L6;
        this.f13335b.p1(r10.f13328g);
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        this.f13336c = null;
        this.f13341h.b();
        this.f13342i.b();
        this.f13370k.b();
        this.f13338e.b();
        this.f13340g = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean l() {
        if (this.f13337d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return true;
    L5:
        if (this.f13335b.f13297x != 0) goto L7;
        return true;
    L7:
        return false;
    }

    public void p() {
        this.f13340g = false;
        this.f13341h.b();
        this.f13341h.f13331j = false;
        this.f13342i.b();
        this.f13342i.f13331j = false;
        this.f13370k.b();
        this.f13370k.f13331j = false;
        this.f13338e.f13331j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f13335b.s();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r10) {
        int r11 = a.f13372a[this.f13343j.ordinal()];
        if (r11 == 1) goto L10;
        if (r11 == 2) goto L9;
        if (r11 != 3) goto L11;
        ConstraintWidget r12 = this.f13335b;
        m(r10, r12.R, r12.T, 1);
        return;
    L11:
        d r13 = this.f13338e;
        if (r13.f13324c == true) goto L14;
    L39:
        DependencyNode r14 = this.f13341h;
        if (r14.f13324c == false) goto L87;
        DependencyNode r15 = this.f13342i;
        if (r15.f13324c == true) goto L45;
        return;
    L45:
        if (r14.f13331j == false) goto L52;
        if (r15.f13331j == false) goto L52;
        if (this.f13338e.f13331j == false) goto L52;
        return;
    L52:
        if (this.f13338e.f13331j == true) goto L62;
        if (this.f13337d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L62;
        ConstraintWidget r16 = this.f13335b;
        if (r16.f13295w != 0) goto L62;
        if (r16.j0() == true) goto L62;
        DependencyNode r17 = (DependencyNode) this.f13341h.f13333l.get(0);
        DependencyNode r18 = (DependencyNode) this.f13342i.f13333l.get(0);
        int r19 = r17.f13328g;
        DependencyNode r20 = this.f13341h;
        int r21 = r19 + r20.f13327f;
        int r22 = r18.f13328g + this.f13342i.f13327f;
        r20.c(r21);
        this.f13342i.c(r22);
        this.f13338e.c(r22 - r21);
        return;
    L62:
        if (this.f13338e.f13331j == true) goto L76;
        if (this.f13337d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L76;
        if (this.f13334a != 1) goto L76;
        if (this.f13341h.f13333l.size() <= 0) goto L76;
        if (this.f13342i.f13333l.size() <= 0) goto L76;
        DependencyNode r23 = (DependencyNode) this.f13341h.f13333l.get(0);
        DependencyNode r24 = (DependencyNode) this.f13342i.f13333l.get(0);
        int r25 = (r24.f13328g + this.f13342i.f13327f) - (r23.f13328g + this.f13341h.f13327f);
        d r26 = this.f13338e;
        int r27 = r26.f13356m;
        if (r25 >= r27) goto L74;
        r26.c(r25);
        goto L76
    L74:
        r26.c(r27);
    L76:
        if (this.f13338e.f13331j == true) goto L79;
        return;
    L79:
        if (this.f13341h.f13333l.size() > 0) goto L81;
        return;
    L81:
        if (this.f13342i.f13333l.size() <= 0) goto L89;
        DependencyNode r28 = (DependencyNode) this.f13341h.f13333l.get(0);
        DependencyNode r29 = (DependencyNode) this.f13342i.f13333l.get(0);
        int r30 = r28.f13328g + this.f13341h.f13327f;
        int r31 = r29.f13328g + this.f13342i.f13327f;
        float r32 = this.f13335b.Q();
        if (r28 != r29) goto L85;
        r30 = r28.f13328g;
        r31 = r29.f13328g;
        r32 = 0.5f;
    L85:
        this.f13341h.c((int) ((r30 + 0.5f) + (((r31 - r30) - this.f13338e.f13328g) * r32)));
        this.f13342i.c(this.f13341h.f13328g + this.f13338e.f13328g);
        return;
    L89:
        return;
    L87:
        return;
    L14:
        if (r13.f13331j == true) goto L39;
        if (this.f13337d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L39;
        ConstraintWidget r33 = this.f13335b;
        int r34 = r33.f13297x;
        if (r34 == 2) goto L34;
        if (r34 != 3) goto L39;
        if (r33.f13259e.f13338e.f13331j == false) goto L39;
        int r35 = r33.v();
        if (r35 == (-1)) goto L32;
        if (r35 == 0) goto L31;
        if (r35 == 1) goto L28;
        int r36 = 0;
    L33:
        this.f13338e.c(r36);
        goto L39
    L28:
        ConstraintWidget r37 = this.f13335b;
        float r38 = r37.f13259e.f13338e.f13328g;
        float r39 = r37.u();
    L29:
        float r40 = r38 / r39;
    L30:
        r36 = (int) (r40 + 0.5f);
        goto L33
    L31:
        ConstraintWidget r41 = this.f13335b;
        r40 = r41.f13259e.f13338e.f13328g * r41.u();
        goto L30
    L32:
        ConstraintWidget r42 = this.f13335b;
        r38 = r42.f13259e.f13338e.f13328g;
        r39 = r42.u();
        goto L29
    L34:
        ConstraintWidget r43 = r33.J();
        if (r43 == null) goto L39;
        d r44 = r43.f13261f.f13338e;
        if (r44.f13331j == false) goto L39;
        this.f13338e.c((int) ((r44.f13328g * this.f13335b.E) + 0.5f));
        goto L39
    L9:
        n(r10);
        goto L11
    L10:
        o(r10);
        goto L11
    }
}
