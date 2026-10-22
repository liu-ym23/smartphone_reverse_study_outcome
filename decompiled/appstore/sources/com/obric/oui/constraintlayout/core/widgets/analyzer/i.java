package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import com.obric.oui.constraintlayout.core.widgets.Helper;

/* JADX INFO: loaded from: classes4.dex */
public class i extends WidgetRun {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int[] f13360k;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13361a = null;

        static {
            int[] r10 = new int[WidgetRun.RunType.values().length];
            f13361a = r10;
            r10[WidgetRun.RunType.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f13361a[WidgetRun.RunType.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f13361a[WidgetRun.RunType.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f13360k = new int[2];
    }

    public i(ConstraintWidget r10) {
        super(r10);
        DependencyNode r11 = this.f13341h;
        r11.f13326e = DependencyNode.Type.LEFT;
        DependencyNode r12 = this.f13342i;
        r12.f13326e = DependencyNode.Type.RIGHT;
        this.f13339f = 0;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void c() {
        ConstraintWidget r10 = this.f13335b;
        if (r10.f13251a == false) goto L6;
        this.f13338e.c(r10.V());
    L6:
        if (this.f13338e.f13331j == true) goto L22;
        ConstraintWidget.DimensionBehaviour r11 = this.f13335b.z();
        this.f13337d = r11;
        if (r11 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        ConstraintWidget.DimensionBehaviour r12 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (r11 != r12) goto L20;
        ConstraintWidget r13 = this.f13335b.J();
        if (r13 == null) goto L20;
        if (r13.z() != ConstraintWidget.DimensionBehaviour.FIXED) goto L16;
    L17:
        int r14 = (r13.V() - this.f13335b.Q.f()) - this.f13335b.S.f();
        a(this.f13341h, r13.f13259e.f13341h, this.f13335b.Q.f());
        a(this.f13342i, r13.f13259e.f13342i, -this.f13335b.S.f());
        this.f13338e.c(r14);
        return;
    L16:
        if (r13.z() == r12) goto L17;
    L20:
        if (this.f13337d != ConstraintWidget.DimensionBehaviour.FIXED) goto L32;
        this.f13338e.c(this.f13335b.V());
    L32:
        d r15 = this.f13338e;
        if (r15.f13331j == false) goto L67;
        ConstraintWidget r16 = this.f13335b;
        if (r16.f13251a == false) goto L67;
        ConstraintAnchor[] r17 = r16.Y;
        ConstraintAnchor r18 = r17[0];
        ConstraintAnchor r19 = r18.f13245f;
        if (r19 != null) goto L39;
    L50:
        if (r19 == null) goto L54;
        DependencyNode r20 = g(r18);
        if (r20 == null) goto L117;
        a(this.f13341h, r20, this.f13335b.Y[0].f());
        a(this.f13342i, this.f13341h, this.f13338e.f13328g);
        return;
    L117:
        return;
    L54:
        ConstraintAnchor r21 = r17[1];
        if (r21.f13245f == null) goto L60;
        DependencyNode r22 = g(r21);
        if (r22 == null) goto L119;
        a(this.f13342i, r22, -this.f13335b.Y[1].f());
        a(this.f13341h, this.f13342i, -this.f13338e.f13328g);
        return;
    L119:
        return;
    L60:
        if ((r16 instanceof Helper) == false) goto L62;
        return;
    L62:
        if (r16.J() != null) goto L64;
        return;
    L64:
        if (this.f13335b.n(ConstraintAnchor.Type.CENTER).f13245f != null) goto L123;
        DependencyNode r23 = this.f13335b.J().f13259e.f13341h;
        a(this.f13341h, r23, this.f13335b.W());
        a(this.f13342i, this.f13341h, this.f13338e.f13328g);
        return;
    L123:
        return;
    L39:
        if (r17[1].f13245f == null) goto L50;
        if (r16.h0() == false) goto L43;
        DependencyNode r24 = this.f13341h;
        r24.f13327f = this.f13335b.Y[0].f();
        DependencyNode r25 = this.f13342i;
        r25.f13327f = -this.f13335b.Y[1].f();
        return;
    L43:
        DependencyNode r26 = g(this.f13335b.Y[0]);
        if (r26 == null) goto L46;
        a(this.f13341h, r26, this.f13335b.Y[0].f());
    L46:
        DependencyNode r27 = g(this.f13335b.Y[1]);
        if (r27 == null) goto L49;
        a(this.f13342i, r27, -this.f13335b.Y[1].f());
    L49:
        this.f13341h.f13323b = true;
        this.f13342i.f13323b = true;
        return;
    L67:
        if (this.f13337d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L87;
        ConstraintWidget r28 = this.f13335b;
        int r29 = r28.f13295w;
        if (r29 != 2) goto L71;
        ConstraintWidget r30 = r28.J();
        if (r30 == null) goto L87;
        d r31 = r30.f13261f.f13338e;
        this.f13338e.f13333l.add(r31);
        r31.f13332k.add(this.f13338e);
        d r32 = this.f13338e;
        r32.f13323b = true;
        r32.f13332k.add(this.f13341h);
        this.f13338e.f13332k.add(this.f13342i);
        goto L87
    L71:
        if (r29 != 3) goto L87;
        if (r28.f13297x != 3) goto L82;
        this.f13341h.f13322a = this;
        this.f13342i.f13322a = this;
        k r33 = r28.f13261f;
        r33.f13341h.f13322a = this;
        r33.f13342i.f13322a = this;
        r15.f13322a = this;
        if (r28.j0() == false) goto L79;
        this.f13338e.f13333l.add(this.f13335b.f13261f.f13338e);
        this.f13335b.f13261f.f13338e.f13332k.add(this.f13338e);
        k r34 = this.f13335b.f13261f;
        r34.f13338e.f13322a = this;
        this.f13338e.f13333l.add(r34.f13341h);
        this.f13338e.f13333l.add(this.f13335b.f13261f.f13342i);
        this.f13335b.f13261f.f13341h.f13332k.add(this.f13338e);
        this.f13335b.f13261f.f13342i.f13332k.add(this.f13338e);
        goto L87
    L79:
        if (this.f13335b.h0() == false) goto L81;
        this.f13335b.f13261f.f13338e.f13333l.add(this.f13338e);
        this.f13338e.f13332k.add(this.f13335b.f13261f.f13338e);
        goto L87
    L81:
        this.f13335b.f13261f.f13338e.f13333l.add(this.f13338e);
        goto L87
    L82:
        d r35 = r28.f13261f.f13338e;
        r15.f13333l.add(r35);
        r35.f13332k.add(this.f13338e);
        this.f13335b.f13261f.f13341h.f13332k.add(this.f13338e);
        this.f13335b.f13261f.f13342i.f13332k.add(this.f13338e);
        d r36 = this.f13338e;
        r36.f13323b = true;
        r36.f13332k.add(this.f13341h);
        this.f13338e.f13332k.add(this.f13342i);
        this.f13341h.f13333l.add(this.f13338e);
        this.f13342i.f13333l.add(this.f13338e);
    L87:
        ConstraintWidget r37 = this.f13335b;
        ConstraintAnchor[] r38 = r37.Y;
        ConstraintAnchor r39 = r38[0];
        ConstraintAnchor r40 = r39.f13245f;
        if (r40 != null) goto L90;
    L100:
        if (r40 == null) goto L104;
        DependencyNode r41 = g(r39);
        if (r41 == null) goto L127;
        a(this.f13341h, r41, this.f13335b.Y[0].f());
        b(this.f13342i, this.f13341h, 1, this.f13338e);
        return;
    L127:
        return;
    L104:
        ConstraintAnchor r42 = r38[1];
        if (r42.f13245f == null) goto L110;
        DependencyNode r43 = g(r42);
        if (r43 == null) goto L129;
        a(this.f13342i, r43, -this.f13335b.Y[1].f());
        b(this.f13341h, this.f13342i, -1, this.f13338e);
        return;
    L129:
        return;
    L110:
        if ((r37 instanceof Helper) == false) goto L112;
        return;
    L112:
        if (r37.J() == null) goto L132;
        DependencyNode r44 = this.f13335b.J().f13259e.f13341h;
        a(this.f13341h, r44, this.f13335b.W());
        b(this.f13342i, this.f13341h, 1, this.f13338e);
        return;
    L132:
        return;
    L90:
        if (r38[1].f13245f == null) goto L100;
        if (r37.h0() == false) goto L94;
        DependencyNode r45 = this.f13341h;
        r45.f13327f = this.f13335b.Y[0].f();
        DependencyNode r46 = this.f13342i;
        r46.f13327f = -this.f13335b.Y[1].f();
        return;
    L94:
        DependencyNode r47 = g(this.f13335b.Y[0]);
        DependencyNode r48 = g(this.f13335b.Y[1]);
        if (r47 == null) goto L97;
        r47.a(this);
    L97:
        if (r48 == null) goto L99;
        r48.a(this);
    L99:
        this.f13343j = WidgetRun.RunType.CENTER;
        return;
    L22:
        ConstraintWidget.DimensionBehaviour r49 = this.f13337d;
        ConstraintWidget.DimensionBehaviour r50 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (r49 != r50) goto L32;
        ConstraintWidget r51 = this.f13335b.J();
        if (r51 == null) goto L32;
        if (r51.z() != ConstraintWidget.DimensionBehaviour.FIXED) goto L29;
    L30:
        a(this.f13341h, r51.f13259e.f13341h, this.f13335b.Q.f());
        a(this.f13342i, r51.f13259e.f13342i, -this.f13335b.S.f());
        return;
    L29:
        if (r51.z() != r50) goto L32;
        goto L30
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        DependencyNode r10 = this.f13341h;
        if (r10.f13331j == false) goto L6;
        this.f13335b.o1(r10.f13328g);
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        this.f13336c = null;
        this.f13341h.b();
        this.f13342i.b();
        this.f13338e.b();
        this.f13340g = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean l() {
        if (this.f13337d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return true;
    L5:
        if (this.f13335b.f13295w != 0) goto L7;
        return true;
    L7:
        return false;
    }

    public final void p(int[] r10, int r11, int r12, int r13, int r14, float r15, int r16) {
        int r17 = r12 - r11;
        int r18 = r14 - r13;
        if (r16 == (-1)) goto L9;
        if (r16 == 0) goto L8;
        if (r16 != 1) goto L19;
        r10[0] = r17;
        r10[1] = (int) ((r17 * r15) + 0.5f);
        return;
    L19:
        return;
    L8:
        r10[0] = (int) ((r18 * r15) + 0.5f);
        r10[1] = r18;
        return;
    L9:
        int r19 = (int) ((r18 * r15) + 0.5f);
        int r20 = (int) ((r17 / r15) + 0.5f);
        if (r19 > r17) goto L12;
        r10[0] = r19;
        r10[1] = r18;
        return;
    L12:
        if (r20 > r18) goto L18;
        r10[0] = r17;
        r10[1] = r20;
        return;
    }

    public void q() {
        this.f13340g = false;
        this.f13341h.b();
        this.f13341h.f13331j = false;
        this.f13342i.b();
        this.f13342i.f13331j = false;
        this.f13338e.f13331j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f13335b.s();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r17) {
        int r10 = a.f13361a[this.f13343j.ordinal()];
        if (r10 == 1) goto L10;
        if (r10 == 2) goto L9;
        if (r10 != 3) goto L12;
        ConstraintWidget r11 = this.f13335b;
        m(r17, r11.Q, r11.S, 0);
        return;
    L12:
        if (this.f13338e.f13331j == false) goto L14;
    L135:
        DependencyNode r12 = this.f13341h;
        if (r12.f13324c == false) goto L187;
        DependencyNode r13 = this.f13342i;
        if (r13.f13324c == true) goto L141;
        return;
    L141:
        if (r12.f13331j == false) goto L148;
        if (r13.f13331j == false) goto L148;
        if (this.f13338e.f13331j == false) goto L148;
        return;
    L148:
        if (this.f13338e.f13331j == true) goto L158;
        if (this.f13337d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L158;
        ConstraintWidget r14 = this.f13335b;
        if (r14.f13295w != 0) goto L158;
        if (r14.h0() == true) goto L158;
        DependencyNode r15 = (DependencyNode) this.f13341h.f13333l.get(0);
        DependencyNode r16 = (DependencyNode) this.f13342i.f13333l.get(0);
        int r18 = r15.f13328g;
        DependencyNode r19 = this.f13341h;
        int r20 = r18 + r19.f13327f;
        int r21 = r16.f13328g + this.f13342i.f13327f;
        r19.c(r20);
        this.f13342i.c(r21);
        this.f13338e.c(r21 - r20);
        return;
    L158:
        if (this.f13338e.f13331j == true) goto L172;
        if (this.f13337d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L172;
        if (this.f13334a != 1) goto L172;
        if (this.f13341h.f13333l.size() <= 0) goto L172;
        if (this.f13342i.f13333l.size() <= 0) goto L172;
        DependencyNode r22 = (DependencyNode) this.f13341h.f13333l.get(0);
        DependencyNode r23 = (DependencyNode) this.f13342i.f13333l.get(0);
        int r24 = Math.min((r23.f13328g + this.f13342i.f13327f) - (r22.f13328g + this.f13341h.f13327f), this.f13338e.f13356m);
        ConstraintWidget r25 = this.f13335b;
        int r26 = r25.A;
        int r27 = Math.max(r25.f13301z, r24);
        if (r26 <= 0) goto L170;
        r27 = Math.min(r26, r27);
    L170:
        this.f13338e.c(r27);
    L172:
        if (this.f13338e.f13331j == true) goto L174;
        return;
    L174:
        DependencyNode r28 = (DependencyNode) this.f13341h.f13333l.get(0);
        DependencyNode r29 = (DependencyNode) this.f13342i.f13333l.get(0);
        int r30 = r28.f13328g + this.f13341h.f13327f;
        int r31 = r29.f13328g + this.f13342i.f13327f;
        float r32 = this.f13335b.x();
        if (r28 != r29) goto L177;
        r30 = r28.f13328g;
        r31 = r29.f13328g;
        r32 = 0.5f;
    L177:
        this.f13341h.c((int) ((r30 + 0.5f) + (((r31 - r30) - this.f13338e.f13328g) * r32)));
        this.f13342i.c(this.f13341h.f13328g + this.f13338e.f13328g);
        return;
    L187:
        return;
    L14:
        if (this.f13337d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L135;
        ConstraintWidget r33 = this.f13335b;
        int r34 = r33.f13295w;
        if (r34 == 2) goto L130;
        if (r34 != 3) goto L135;
        int r35 = r33.f13297x;
        if (r35 == 0) goto L34;
        if (r35 == 3) goto L34;
        int r36 = r33.v();
        if (r36 == (-1)) goto L32;
        if (r36 == 0) goto L31;
        if (r36 == 1) goto L28;
        int r37 = 0;
    L33:
        this.f13338e.c(r37);
        goto L135
    L28:
        ConstraintWidget r38 = this.f13335b;
        float r39 = r38.f13261f.f13338e.f13328g;
        float r40 = r38.u();
    L29:
        float r41 = r39 * r40;
    L30:
        r37 = (int) (r41 + 0.5f);
        goto L33
    L31:
        ConstraintWidget r42 = this.f13335b;
        r41 = r42.f13261f.f13338e.f13328g / r42.u();
        goto L30
    L32:
        ConstraintWidget r43 = this.f13335b;
        r39 = r43.f13261f.f13338e.f13328g;
        r40 = r43.u();
    L34:
        k r44 = r33.f13261f;
        DependencyNode r110 = r44.f13341h;
        DependencyNode r111 = r44.f13342i;
        if (r33.Q.f13245f == null) goto L37;
        boolean r45 = true;
    L39:
        if (r33.R.f13245f == null) goto L41;
        boolean r46 = true;
    L43:
        if (r33.S.f13245f == null) goto L45;
        boolean r47 = true;
    L47:
        if (r33.T.f13245f == null) goto L49;
        boolean r48 = true;
    L50:
        int r112 = r33.v();
        if (r45 == false) goto L88;
        if (r46 == false) goto L88;
        if (r47 == false) goto L88;
        if (r48 == false) goto L88;
        float r113 = this.f13335b.u();
        if (r110.f13331j == true) goto L58;
    L66:
        DependencyNode r49 = this.f13341h;
        if (r49.f13331j == false) goto L77;
        DependencyNode r50 = this.f13342i;
        if (r50.f13331j == false) goto L77;
        if (r110.f13324c == true) goto L73;
        return;
    L73:
        if (r111.f13324c == false) goto L181;
        p(f13360k, r49.f13328g + r49.f13327f, r50.f13328g - r50.f13327f, ((DependencyNode) r110.f13333l.get(0)).f13328g + r110.f13327f, ((DependencyNode) r111.f13333l.get(0)).f13328g - r111.f13327f, r113, r112);
        this.f13338e.c(f13360k[0]);
        this.f13335b.f13261f.f13338e.c(f13360k[1]);
        goto L77
    L181:
        return;
    L77:
        DependencyNode r51 = this.f13341h;
        if (r51.f13324c == true) goto L80;
        return;
    L80:
        if (this.f13342i.f13324c == true) goto L82;
        return;
    L82:
        if (r110.f13324c == true) goto L84;
        return;
    L84:
        if (r111.f13324c == false) goto L184;
        p(f13360k, ((DependencyNode) r51.f13333l.get(0)).f13328g + this.f13341h.f13327f, ((DependencyNode) this.f13342i.f13333l.get(0)).f13328g - this.f13342i.f13327f, ((DependencyNode) r110.f13333l.get(0)).f13328g + r110.f13327f, ((DependencyNode) r111.f13333l.get(0)).f13328g - r111.f13327f, r113, r112);
        this.f13338e.c(f13360k[0]);
        this.f13335b.f13261f.f13338e.c(f13360k[1]);
        goto L135
    L184:
        return;
    L58:
        if (r111.f13331j == false) goto L66;
        DependencyNode r52 = this.f13341h;
        if (r52.f13324c == true) goto L62;
        return;
    L62:
        if (this.f13342i.f13324c == false) goto L180;
        p(f13360k, ((DependencyNode) r52.f13333l.get(0)).f13328g + this.f13341h.f13327f, ((DependencyNode) this.f13342i.f13333l.get(0)).f13328g - this.f13342i.f13327f, r110.f13328g + r110.f13327f, r111.f13328g - r111.f13327f, r113, r112);
        this.f13338e.c(f13360k[0]);
        this.f13335b.f13261f.f13338e.c(f13360k[1]);
        return;
    L180:
        return;
    L88:
        if (r45 == false) goto L109;
        if (r47 == false) goto L109;
        if (this.f13341h.f13324c == true) goto L93;
        return;
    L93:
        if (this.f13342i.f13324c == false) goto L185;
        float r53 = this.f13335b.u();
        int r54 = ((DependencyNode) this.f13341h.f13333l.get(0)).f13328g + this.f13341h.f13327f;
        int r55 = ((DependencyNode) this.f13342i.f13333l.get(0)).f13328g - this.f13342i.f13327f;
        if (r112 == (-1)) goto L104;
        if (r112 == 0) goto L104;
        if (r112 != 1) goto L135;
        int r56 = f(r55 - r54, 0);
        int r57 = (int) ((r56 / r53) + 0.5f);
        int r58 = f(r57, 1);
        if (r57 == r58) goto L103;
        r56 = (int) ((r58 * r53) + 0.5f);
    L103:
        this.f13338e.c(r56);
        this.f13335b.f13261f.f13338e.c(r58);
    L104:
        int r59 = f(r55 - r54, 0);
        int r60 = (int) ((r59 * r53) + 0.5f);
        int r61 = f(r60, 1);
        if (r60 == r61) goto L107;
        r59 = (int) ((r61 / r53) + 0.5f);
    L107:
        this.f13338e.c(r59);
        this.f13335b.f13261f.f13338e.c(r61);
        goto L135
    L185:
        return;
    L109:
        if (r46 == false) goto L135;
        if (r48 == false) goto L135;
        if (r110.f13324c == true) goto L114;
        return;
    L114:
        if (r111.f13324c == false) goto L186;
        float r62 = this.f13335b.u();
        int r63 = ((DependencyNode) r110.f13333l.get(0)).f13328g + r110.f13327f;
        int r64 = ((DependencyNode) r111.f13333l.get(0)).f13328g - r111.f13327f;
        if (r112 == (-1)) goto L125;
        if (r112 == 0) goto L121;
        if (r112 == 1) goto L125;
    L121:
        int r65 = f(r64 - r63, 1);
        int r66 = (int) ((r65 * r62) + 0.5f);
        int r67 = f(r66, 0);
        if (r66 == r67) goto L124;
        r65 = (int) ((r67 / r62) + 0.5f);
    L124:
        this.f13338e.c(r67);
        this.f13335b.f13261f.f13338e.c(r65);
    L125:
        int r68 = f(r64 - r63, 1);
        int r69 = (int) ((r68 / r62) + 0.5f);
        int r70 = f(r69, 0);
        if (r69 == r70) goto L128;
        r68 = (int) ((r70 * r62) + 0.5f);
    L128:
        this.f13338e.c(r70);
        this.f13335b.f13261f.f13338e.c(r68);
        goto L135
    L186:
        return;
    L49:
        r48 = false;
        goto L50
    L45:
        r47 = false;
        goto L47
    L41:
        r46 = false;
        goto L43
    L37:
        r45 = false;
        goto L39
    L130:
        ConstraintWidget r71 = r33.J();
        if (r71 == null) goto L135;
        d r72 = r71.f13259e.f13338e;
        if (r72.f13331j == false) goto L135;
        this.f13338e.c((int) ((r72.f13328g * this.f13335b.B) + 0.5f));
        goto L135
    L9:
        n(r17);
        goto L12
    L10:
        o(r17);
        goto L12
    }
}
