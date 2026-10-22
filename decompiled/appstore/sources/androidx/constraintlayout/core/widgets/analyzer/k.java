package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;

/* JADX INFO: loaded from: classes.dex */
public class k extends WidgetRun {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DependencyNode f1577k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public d f1578l;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1579a = null;

        static {
            int[] r10 = new int[WidgetRun.RunType.values().length];
            f1579a = r10;
            r10[WidgetRun.RunType.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f1579a[WidgetRun.RunType.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f1579a[WidgetRun.RunType.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public k(ConstraintWidget r10) {
        super(r10);
        DependencyNode r11 = new DependencyNode(this);
        this.f1577k = r11;
        this.f1578l = null;
        DependencyNode r12 = this.f1548h;
        r12.f1533e = DependencyNode.Type.TOP;
        DependencyNode r13 = this.f1549i;
        r13.f1533e = DependencyNode.Type.BOTTOM;
        r11.f1533e = DependencyNode.Type.BASELINE;
        this.f1546f = 1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void c() {
        ConstraintWidget r10 = this.f1542b;
        if (r10.f1432a == false) goto L6;
        this.f1545e.c(r10.w());
    L6:
        if (this.f1545e.f1538j == true) goto L24;
        this.f1544d = this.f1542b.S();
        if (this.f1542b.Y() == false) goto L10;
        this.f1578l = new androidx.constraintlayout.core.widgets.analyzer.a(this);
    L10:
        ConstraintWidget.DimensionBehaviour r11 = this.f1544d;
        if (r11 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L13;
    L31:
        d r12 = this.f1545e;
        boolean r13 = r12.f1538j;
        if (r13 == false) goto L80;
        ConstraintWidget r14 = this.f1542b;
        if (r14.f1432a == false) goto L80;
        ConstraintAnchor[] r15 = r14.Y;
        ConstraintAnchor r16 = r15[2];
        ConstraintAnchor r17 = r16.f1426f;
        if (r17 != null) goto L38;
    L52:
        if (r17 == null) goto L58;
        DependencyNode r18 = g(r16);
        if (r18 == null) goto L160;
        a(this.f1548h, r18, this.f1542b.Y[2].f());
        a(this.f1549i, this.f1548h, this.f1545e.f1535g);
        if (this.f1542b.Y() == false) goto L161;
        a(this.f1577k, this.f1548h, this.f1542b.o());
        return;
    L161:
        return;
    L160:
        return;
    L58:
        ConstraintAnchor r19 = r15[3];
        if (r19.f1426f == null) goto L66;
        DependencyNode r20 = g(r19);
        if (r20 == null) goto L64;
        a(this.f1549i, r20, -this.f1542b.Y[3].f());
        a(this.f1548h, this.f1549i, -this.f1545e.f1535g);
    L64:
        if (this.f1542b.Y() == false) goto L163;
        a(this.f1577k, this.f1548h, this.f1542b.o());
        return;
    L163:
        return;
    L66:
        ConstraintAnchor r21 = r15[4];
        if (r21.f1426f == null) goto L72;
        DependencyNode r22 = g(r21);
        if (r22 == null) goto L165;
        a(this.f1577k, r22, 0);
        a(this.f1548h, this.f1577k, -this.f1542b.o());
        a(this.f1549i, this.f1548h, this.f1545e.f1535g);
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
        if (this.f1542b.n(ConstraintAnchor.Type.CENTER).f1426f != null) goto L169;
        DependencyNode r23 = this.f1542b.J().f1442f.f1548h;
        a(this.f1548h, r23, this.f1542b.X());
        a(this.f1549i, this.f1548h, this.f1545e.f1535g);
        if (this.f1542b.Y() == false) goto L170;
        a(this.f1577k, this.f1548h, this.f1542b.o());
        return;
    L170:
        return;
    L169:
        return;
    L38:
        if (r15[3].f1426f == null) goto L52;
        if (r14.j0() == false) goto L42;
        DependencyNode r24 = this.f1548h;
        r24.f1534f = this.f1542b.Y[2].f();
        DependencyNode r25 = this.f1549i;
        r25.f1534f = -this.f1542b.Y[3].f();
    L50:
        if (this.f1542b.Y() == false) goto L158;
        a(this.f1577k, this.f1548h, this.f1542b.o());
        return;
    L158:
        return;
    L42:
        DependencyNode r26 = g(this.f1542b.Y[2]);
        if (r26 == null) goto L45;
        a(this.f1548h, r26, this.f1542b.Y[2].f());
    L45:
        DependencyNode r27 = g(this.f1542b.Y[3]);
        if (r27 == null) goto L48;
        a(this.f1549i, r27, -this.f1542b.Y[3].f());
    L48:
        this.f1548h.f1530b = true;
        this.f1549i.f1530b = true;
    L80:
        if (r13 == false) goto L82;
    L97:
        r12.a(this);
    L98:
        ConstraintWidget r28 = this.f1542b;
        ConstraintAnchor[] r29 = r28.Y;
        ConstraintAnchor r30 = r29[2];
        ConstraintAnchor r31 = r30.f1426f;
        if (r31 == null) goto L115;
        if (r29[3].f1426f == null) goto L115;
        if (r28.j0() == false) goto L105;
        DependencyNode r32 = this.f1548h;
        r32.f1534f = this.f1542b.Y[2].f();
        DependencyNode r33 = this.f1549i;
        r33.f1534f = -this.f1542b.Y[3].f();
    L112:
        if (this.f1542b.Y() == false) goto L155;
        b(this.f1577k, this.f1548h, 1, this.f1578l);
    L155:
        if (this.f1545e.f1540l.size() != 0) goto L172;
        this.f1545e.f1531c = true;
        return;
    L172:
        return;
    L105:
        DependencyNode r34 = g(this.f1542b.Y[2]);
        DependencyNode r35 = g(this.f1542b.Y[3]);
        if (r34 == null) goto L108;
        r34.a(this);
    L108:
        if (r35 == null) goto L110;
        r35.a(this);
    L110:
        this.f1550j = WidgetRun.RunType.CENTER;
    L115:
        if (r31 == null) goto L128;
        DependencyNode r36 = g(r30);
        if (r36 == null) goto L155;
        a(this.f1548h, r36, this.f1542b.Y[2].f());
        b(this.f1549i, this.f1548h, 1, this.f1545e);
        if (this.f1542b.Y() == false) goto L121;
        b(this.f1577k, this.f1548h, 1, this.f1578l);
    L121:
        ConstraintWidget.DimensionBehaviour r37 = this.f1544d;
        ConstraintWidget.DimensionBehaviour r38 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r37 != r38) goto L155;
        if (this.f1542b.u() <= 0.0f) goto L155;
        i r39 = this.f1542b.f1440e;
        if (r39.f1544d != r38) goto L155;
        r39.f1545e.f1539k.add(this.f1545e);
        this.f1545e.f1540l.add(this.f1542b.f1440e.f1545e);
        this.f1545e.f1529a = this;
        goto L155
    L128:
        ConstraintAnchor r40 = r29[3];
        if (r40.f1426f == null) goto L135;
        DependencyNode r41 = g(r40);
        if (r41 == null) goto L155;
        a(this.f1549i, r41, -this.f1542b.Y[3].f());
        b(this.f1548h, this.f1549i, -1, this.f1545e);
        if (this.f1542b.Y() == false) goto L155;
        b(this.f1577k, this.f1548h, 1, this.f1578l);
        goto L155
    L135:
        ConstraintAnchor r42 = r29[4];
        if (r42.f1426f == null) goto L141;
        DependencyNode r43 = g(r42);
        if (r43 == null) goto L155;
        a(this.f1577k, r43, 0);
        b(this.f1548h, this.f1577k, -1, this.f1578l);
        b(this.f1549i, this.f1548h, 1, this.f1545e);
        goto L155
    L141:
        if ((r28 instanceof Helper) == true) goto L155;
        if (r28.J() == null) goto L155;
        DependencyNode r44 = this.f1542b.J().f1442f.f1548h;
        a(this.f1548h, r44, this.f1542b.X());
        b(this.f1549i, this.f1548h, 1, this.f1545e);
        if (this.f1542b.Y() == false) goto L147;
        b(this.f1577k, this.f1548h, 1, this.f1578l);
    L147:
        ConstraintWidget.DimensionBehaviour r45 = this.f1544d;
        ConstraintWidget.DimensionBehaviour r46 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r45 != r46) goto L155;
        if (this.f1542b.u() <= 0.0f) goto L155;
        i r47 = this.f1542b.f1440e;
        if (r47.f1544d != r46) goto L155;
        r47.f1545e.f1539k.add(this.f1545e);
        this.f1545e.f1540l.add(this.f1542b.f1440e.f1545e);
        this.f1545e.f1529a = this;
        goto L155
    L82:
        if (this.f1544d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L97;
        ConstraintWidget r48 = this.f1542b;
        int r49 = r48.f1478x;
        if (r49 == 2) goto L93;
        if (r49 != 3) goto L98;
        if (r48.j0() == true) goto L98;
        ConstraintWidget r50 = this.f1542b;
        if (r50.f1476w == 3) goto L98;
        d r51 = r50.f1440e.f1545e;
        this.f1545e.f1540l.add(r51);
        r51.f1539k.add(this.f1545e);
        d r52 = this.f1545e;
        r52.f1530b = true;
        r52.f1539k.add(this.f1548h);
        this.f1545e.f1539k.add(this.f1549i);
        goto L98
    L93:
        ConstraintWidget r53 = r48.J();
        if (r53 == null) goto L98;
        d r54 = r53.f1442f.f1545e;
        this.f1545e.f1540l.add(r54);
        r54.f1539k.add(this.f1545e);
        d r55 = this.f1545e;
        r55.f1530b = true;
        r55.f1539k.add(this.f1548h);
        this.f1545e.f1539k.add(this.f1549i);
        goto L98
    L13:
        if (r11 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L21;
        ConstraintWidget r56 = this.f1542b.J();
        if (r56 == null) goto L21;
        if (r56.S() != ConstraintWidget.DimensionBehaviour.FIXED) goto L21;
        int r57 = (r56.w() - this.f1542b.R.f()) - this.f1542b.T.f();
        a(this.f1548h, r56.f1442f.f1548h, this.f1542b.R.f());
        a(this.f1549i, r56.f1442f.f1549i, -this.f1542b.T.f());
        this.f1545e.c(r57);
        return;
    L21:
        if (this.f1544d != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
        this.f1545e.c(this.f1542b.w());
        goto L31
    L24:
        if (this.f1544d != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L31;
        ConstraintWidget r58 = this.f1542b.J();
        if (r58 == null) goto L31;
        if (r58.S() != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
        a(this.f1548h, r58.f1442f.f1548h, this.f1542b.R.f());
        a(this.f1549i, r58.f1442f.f1549i, -this.f1542b.T.f());
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        DependencyNode r10 = this.f1548h;
        if (r10.f1538j == false) goto L6;
        this.f1542b.o1(r10.f1535g);
        return;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        this.f1543c = null;
        this.f1548h.b();
        this.f1549i.b();
        this.f1577k.b();
        this.f1545e.b();
        this.f1547g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean l() {
        if (this.f1544d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return true;
    L5:
        if (this.f1542b.f1478x != 0) goto L7;
        return true;
    L7:
        return false;
    }

    public void p() {
        this.f1547g = false;
        this.f1548h.b();
        this.f1548h.f1538j = false;
        this.f1549i.b();
        this.f1549i.f1538j = false;
        this.f1577k.b();
        this.f1577k.f1538j = false;
        this.f1545e.f1538j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f1542b.s();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r10) {
        int r11 = a.f1579a[this.f1550j.ordinal()];
        if (r11 == 1) goto L10;
        if (r11 == 2) goto L9;
        if (r11 != 3) goto L11;
        ConstraintWidget r12 = this.f1542b;
        m(r10, r12.R, r12.T, 1);
        return;
    L11:
        d r13 = this.f1545e;
        if (r13.f1531c == true) goto L14;
    L39:
        DependencyNode r14 = this.f1548h;
        if (r14.f1531c == false) goto L87;
        DependencyNode r15 = this.f1549i;
        if (r15.f1531c == true) goto L45;
        return;
    L45:
        if (r14.f1538j == false) goto L52;
        if (r15.f1538j == false) goto L52;
        if (this.f1545e.f1538j == false) goto L52;
        return;
    L52:
        if (this.f1545e.f1538j == true) goto L62;
        if (this.f1544d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L62;
        ConstraintWidget r16 = this.f1542b;
        if (r16.f1476w != 0) goto L62;
        if (r16.j0() == true) goto L62;
        DependencyNode r17 = (DependencyNode) this.f1548h.f1540l.get(0);
        DependencyNode r18 = (DependencyNode) this.f1549i.f1540l.get(0);
        int r19 = r17.f1535g;
        DependencyNode r20 = this.f1548h;
        int r21 = r19 + r20.f1534f;
        int r22 = r18.f1535g + this.f1549i.f1534f;
        r20.c(r21);
        this.f1549i.c(r22);
        this.f1545e.c(r22 - r21);
        return;
    L62:
        if (this.f1545e.f1538j == true) goto L76;
        if (this.f1544d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L76;
        if (this.f1541a != 1) goto L76;
        if (this.f1548h.f1540l.size() <= 0) goto L76;
        if (this.f1549i.f1540l.size() <= 0) goto L76;
        DependencyNode r23 = (DependencyNode) this.f1548h.f1540l.get(0);
        DependencyNode r24 = (DependencyNode) this.f1549i.f1540l.get(0);
        int r25 = (r24.f1535g + this.f1549i.f1534f) - (r23.f1535g + this.f1548h.f1534f);
        d r26 = this.f1545e;
        int r27 = r26.f1563m;
        if (r25 >= r27) goto L74;
        r26.c(r25);
        goto L76
    L74:
        r26.c(r27);
    L76:
        if (this.f1545e.f1538j == true) goto L79;
        return;
    L79:
        if (this.f1548h.f1540l.size() > 0) goto L81;
        return;
    L81:
        if (this.f1549i.f1540l.size() <= 0) goto L89;
        DependencyNode r28 = (DependencyNode) this.f1548h.f1540l.get(0);
        DependencyNode r29 = (DependencyNode) this.f1549i.f1540l.get(0);
        int r30 = r28.f1535g + this.f1548h.f1534f;
        int r31 = r29.f1535g + this.f1549i.f1534f;
        float r32 = this.f1542b.Q();
        if (r28 != r29) goto L85;
        r30 = r28.f1535g;
        r31 = r29.f1535g;
        r32 = 0.5f;
    L85:
        this.f1548h.c((int) ((r30 + 0.5f) + (((r31 - r30) - this.f1545e.f1535g) * r32)));
        this.f1549i.c(this.f1548h.f1535g + this.f1545e.f1535g);
        return;
    L89:
        return;
    L87:
        return;
    L14:
        if (r13.f1538j == true) goto L39;
        if (this.f1544d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L39;
        ConstraintWidget r33 = this.f1542b;
        int r34 = r33.f1478x;
        if (r34 == 2) goto L34;
        if (r34 != 3) goto L39;
        if (r33.f1440e.f1545e.f1538j == false) goto L39;
        int r35 = r33.v();
        if (r35 == (-1)) goto L32;
        if (r35 == 0) goto L31;
        if (r35 == 1) goto L28;
        int r36 = 0;
    L33:
        this.f1545e.c(r36);
        goto L39
    L28:
        ConstraintWidget r37 = this.f1542b;
        float r38 = r37.f1440e.f1545e.f1535g;
        float r39 = r37.u();
    L29:
        float r40 = r38 / r39;
    L30:
        r36 = (int) (r40 + 0.5f);
        goto L33
    L31:
        ConstraintWidget r41 = this.f1542b;
        r40 = r41.f1440e.f1545e.f1535g * r41.u();
        goto L30
    L32:
        ConstraintWidget r42 = this.f1542b;
        r38 = r42.f1440e.f1545e.f1535g;
        r39 = r42.u();
        goto L29
    L34:
        ConstraintWidget r43 = r33.J();
        if (r43 == null) goto L39;
        d r44 = r43.f1442f.f1545e;
        if (r44.f1538j == false) goto L39;
        this.f1545e.c((int) ((r44.f1535g * this.f1542b.E) + 0.5f));
        goto L39
    L9:
        n(r10);
        goto L11
    L10:
        o(r10);
        goto L11
    }
}
