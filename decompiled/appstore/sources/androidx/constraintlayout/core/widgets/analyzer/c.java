package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConstraintWidgetContainer f1554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintWidgetContainer f1557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList f1558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f1559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BasicMeasure.Measurer f1560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public BasicMeasure.a f1561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f1562i;

    public c(ConstraintWidgetContainer r10) {
        this.f1555b = true;
        this.f1556c = true;
        this.f1558e = new ArrayList();
        this.f1559f = new ArrayList();
        this.f1560g = null;
        this.f1561h = new BasicMeasure.a();
        this.f1562i = new ArrayList();
        this.f1554a = r10;
        this.f1557d = r10;
    }

    public final void a(DependencyNode r10, int r11, int r12, DependencyNode r13, ArrayList r14, j r15) {
        WidgetRun r16 = r10.f1532d;
        if (r16.f1543c != null) goto L54;
        ConstraintWidgetContainer r17 = this.f1554a;
        if (r16 != r17.f1440e) goto L7;
        return;
    L7:
        if (r16 == r17.f1442f) goto L80;
        if (r15 != null) goto L11;
        r15 = new j(r16, r12);
        r14.add(r15);
    L11:
        r16.f1543c = r15;
        r15.a(r16);
        Iterator r18 = r16.f1548h.f1539k.iterator();
    L13:
        if (r18.hasNext() == false) goto L17;
        Dependency r19 = (Dependency) r18.next();
        if ((r19 instanceof DependencyNode) == false) goto L13;
        a((DependencyNode) r19, r11, 0, r13, r14, r15);
        goto L13
    L17:
        Iterator r110 = r16.f1549i.f1539k.iterator();
    L19:
        if (r110.hasNext() == false) goto L24;
        Dependency r20 = (Dependency) r110.next();
        if ((r20 instanceof DependencyNode) == false) goto L19;
        a((DependencyNode) r20, r11, 1, r13, r14, r15);
        goto L19
    L24:
        if (r11 == 1) goto L26;
    L33:
        Iterator r21 = r16.f1548h.f1540l.iterator();
    L35:
        if (r21.hasNext() == false) goto L40;
        DependencyNode r22 = (DependencyNode) r21.next();
        if (r22 != r13) goto L39;
        r15.f1571b = true;
    L39:
        a(r22, r11, 0, r13, r14, r15);
        goto L35
    L40:
        Iterator r23 = r16.f1549i.f1540l.iterator();
    L42:
        if (r23.hasNext() == false) goto L47;
        DependencyNode r24 = (DependencyNode) r23.next();
        if (r24 != r13) goto L46;
        r15.f1571b = true;
    L46:
        a(r24, r11, 1, r13, r14, r15);
        goto L42
    L47:
        if (r11 == 1) goto L49;
        return;
    L49:
        if ((r16 instanceof k) == false) goto L79;
        Iterator r25 = ((k) r16).f1577k.f1540l.iterator();
    L52:
        if (r25.hasNext() == false) goto L81;
        a((DependencyNode) r25.next(), r11, 2, r13, r14, r15);
        goto L52
    L81:
        return;
    L79:
        return;
    L26:
        if ((r16 instanceof k) == false) goto L33;
        Iterator r26 = ((k) r16).f1577k.f1539k.iterator();
    L29:
        if (r26.hasNext() == false) goto L33;
        Dependency r27 = (Dependency) r26.next();
        if ((r27 instanceof DependencyNode) == false) goto L29;
        a((DependencyNode) r27, r11, 2, r13, r14, r15);
        goto L29
    L80:
        return;
    }

    public final boolean b(ConstraintWidgetContainer r17) {
        Iterator r10 = r17.V0.iterator();
    L4:
        if (r10.hasNext() == false) goto L141;
        ConstraintWidget r11 = (ConstraintWidget) r10.next();
        ConstraintWidget.DimensionBehaviour[] r12 = r11.f1435b0;
        ConstraintWidget.DimensionBehaviour r13 = r12[0];
        ConstraintWidget.DimensionBehaviour r14 = r12[1];
        if (r11.U() == 8) goto L7;
        if (r11.B >= 1.0f) goto L14;
        if (r13 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
        r11.f1476w = 2;
    L14:
        if (r11.E >= 1.0f) goto L19;
        if (r14 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
        r11.f1478x = 2;
    L19:
        if (r11.u() <= 0.0f) goto L41;
        ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r13 == r15) goto L23;
    L27:
        if (r14 == r15) goto L29;
    L33:
        if (r13 != r15) goto L41;
        if (r14 != r15) goto L41;
        if (r11.f1476w != 0) goto L39;
        r11.f1476w = 3;
    L39:
        if (r11.f1478x != 0) goto L41;
        r11.f1478x = 3;
        goto L41
    L29:
        if (r13 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L31;
    L32:
        r11.f1478x = 3;
        goto L41
    L31:
        if (r13 != ConstraintWidget.DimensionBehaviour.FIXED) goto L33;
    L23:
        if (r14 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L25;
    L26:
        r11.f1476w = 3;
        goto L41
    L25:
        if (r14 != ConstraintWidget.DimensionBehaviour.FIXED) goto L27;
    L41:
        ConstraintWidget.DimensionBehaviour r16 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r13 == r16) goto L44;
    L50:
        ConstraintWidget.DimensionBehaviour r18 = r13;
        if (r14 == r16) goto L53;
    L59:
        ConstraintWidget.DimensionBehaviour r19 = r14;
        i r20 = r11.f1440e;
        r20.f1544d = r18;
        int r21 = r11.f1476w;
        r20.f1541a = r21;
        k r22 = r11.f1442f;
        r22.f1544d = r19;
        int r110 = r11.f1478x;
        r22.f1541a = r110;
        ConstraintWidget.DimensionBehaviour r23 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (r18 != r23) goto L62;
    L65:
        if (r19 == r23) goto L132;
        if (r19 == ConstraintWidget.DimensionBehaviour.FIXED) goto L132;
        if (r19 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L132;
    L72:
        if (r18 != r16) goto L93;
        ConstraintWidget.DimensionBehaviour r111 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r19 != r111) goto L76;
    L77:
        if (r21 == 3) goto L78;
        if (r21 != 1) goto L83;
        l(r11, r111, 0, r19, 0);
        r11.f1440e.f1545e.f1563m = r11.V();
        goto L4
    L83:
        if (r21 == 2) goto L84;
        ConstraintAnchor[] r112 = r11.Y;
        if (r112[0].f1426f == null) goto L92;
        if (r112[1].f1426f != null) goto L93;
    L92:
        l(r11, r111, 0, r19, 0);
        r11.f1440e.f1545e.c(r11.V());
        r11.f1442f.f1545e.c(r11.w());
        r11.f1432a = true;
        goto L4
    L84:
        ConstraintWidget.DimensionBehaviour r113 = r17.f1435b0[0];
        ConstraintWidget.DimensionBehaviour r114 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r113 == r114) goto L87;
        if (r113 != r23) goto L93;
    L87:
        l(r11, r114, (int) ((r11.B * r17.V()) + 0.5f), r19, r11.w());
        r11.f1440e.f1545e.c(r11.V());
        r11.f1442f.f1545e.c(r11.w());
        r11.f1432a = true;
        goto L4
    L78:
        if (r19 != r111) goto L80;
        l(r11, r111, 0, r111, 0);
    L80:
        int r24 = r11.w();
        int r25 = (int) ((r24 * r11.f1443f0) + 0.5f);
        ConstraintWidget.DimensionBehaviour r26 = ConstraintWidget.DimensionBehaviour.FIXED;
        l(r11, r26, r25, r26, r24);
        r11.f1440e.f1545e.c(r11.V());
        r11.f1442f.f1545e.c(r11.w());
        r11.f1432a = true;
        goto L4
    L76:
        if (r19 == ConstraintWidget.DimensionBehaviour.FIXED) goto L77;
    L93:
        if (r19 != r16) goto L118;
        ConstraintWidget.DimensionBehaviour r115 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r18 != r115) goto L97;
    L98:
        if (r110 == 3) goto L99;
        if (r110 != 1) goto L108;
        l(r11, r18, 0, r115, 0);
        r11.f1442f.f1545e.f1563m = r11.w();
        goto L4
    L108:
        if (r110 == 2) goto L109;
        ConstraintAnchor[] r27 = r11.Y;
        if (r27[2].f1426f == null) goto L117;
        if (r27[3].f1426f != null) goto L118;
    L117:
        l(r11, r115, 0, r19, 0);
        r11.f1440e.f1545e.c(r11.V());
        r11.f1442f.f1545e.c(r11.w());
        r11.f1432a = true;
        goto L4
    L109:
        ConstraintWidget.DimensionBehaviour r28 = r17.f1435b0[1];
        ConstraintWidget.DimensionBehaviour r29 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r28 == r29) goto L112;
        if (r28 != r23) goto L118;
    L112:
        l(r11, r18, r11.V(), r29, (int) ((r11.E * r17.w()) + 0.5f));
        r11.f1440e.f1545e.c(r11.V());
        r11.f1442f.f1545e.c(r11.w());
        r11.f1432a = true;
        goto L4
    L99:
        if (r18 != r115) goto L101;
        l(r11, r115, 0, r115, 0);
    L101:
        int r30 = r11.V();
        float r31 = r11.f1443f0;
        if (r11.v() != (-1)) goto L104;
        r31 = 1.0f / r31;
    L104:
        ConstraintWidget.DimensionBehaviour r32 = ConstraintWidget.DimensionBehaviour.FIXED;
        l(r11, r32, r30, r32, (int) ((r30 * r31) + 0.5f));
        r11.f1440e.f1545e.c(r11.V());
        r11.f1442f.f1545e.c(r11.w());
        r11.f1432a = true;
        goto L4
    L97:
        if (r18 == ConstraintWidget.DimensionBehaviour.FIXED) goto L98;
    L118:
        if (r18 != r16) goto L4;
        if (r19 != r16) goto L4;
        if (r21 == 1) goto L131;
        if (r110 == 1) goto L131;
        if (r110 != 2) goto L4;
        if (r21 != 2) goto L4;
        ConstraintWidget.DimensionBehaviour[] r33 = r17.f1435b0;
        ConstraintWidget.DimensionBehaviour r34 = r33[0];
        ConstraintWidget.DimensionBehaviour r35 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r34 != r35) goto L4;
        if (r33[1] != r35) goto L4;
        l(r11, r35, (int) ((r11.B * r17.V()) + 0.5f), r35, (int) ((r11.E * r17.w()) + 0.5f));
        r11.f1440e.f1545e.c(r11.V());
        r11.f1442f.f1545e.c(r11.w());
        r11.f1432a = true;
    L131:
        ConstraintWidget.DimensionBehaviour r36 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        l(r11, r36, 0, r36, 0);
        r11.f1440e.f1545e.f1563m = r11.V();
        r11.f1442f.f1545e.f1563m = r11.w();
    L132:
        int r37 = r11.V();
        if (r18 != r23) goto L135;
        int r38 = (r17.V() - r11.Q.f1427g) - r11.S.f1427g;
        ConstraintWidget.DimensionBehaviour r39 = ConstraintWidget.DimensionBehaviour.FIXED;
    L136:
        int r40 = r11.w();
        if (r19 != r23) goto L139;
        int r41 = (r17.w() - r11.R.f1427g) - r11.T.f1427g;
        ConstraintWidget.DimensionBehaviour r42 = ConstraintWidget.DimensionBehaviour.FIXED;
    L140:
        l(r11, r39, r38, r42, r41);
        r11.f1440e.f1545e.c(r11.V());
        r11.f1442f.f1545e.c(r11.w());
        r11.f1432a = true;
        goto L4
    L139:
        r41 = r40;
        r42 = r19;
        goto L140
    L135:
        r38 = r37;
        r39 = r18;
        goto L136
    L62:
        if (r18 == ConstraintWidget.DimensionBehaviour.FIXED) goto L65;
        if (r18 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L72;
    L53:
        if (r11.f1478x != 1) goto L59;
        if (r11.R.f1426f != null) goto L57;
    L58:
        r14 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        goto L59
    L57:
        if (r11.T.f1426f != null) goto L59;
    L44:
        if (r11.f1476w != 1) goto L50;
        if (r11.Q.f1426f != null) goto L48;
    L49:
        r13 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        goto L50
    L48:
        if (r11.S.f1426f != null) goto L50;
    L7:
        r11.f1432a = true;
        goto L4
    L141:
        return false;
    }

    public void c() {
        d(this.f1558e);
        this.f1562i.clear();
        j.f1569h = 0;
        i(this.f1554a.f1440e, 0, this.f1562i);
        i(this.f1554a.f1442f, 1, this.f1562i);
        this.f1555b = false;
    }

    public void d(ArrayList r10) {
        r10.clear();
        this.f1557d.f1440e.e();
        this.f1557d.f1442f.e();
        r10.add(this.f1557d.f1440e);
        r10.add(this.f1557d.f1442f);
        Iterator r11 = this.f1557d.V0.iterator();
        HashSet r12 = null;
    L4:
        if (r11.hasNext() == false) goto L29;
        ConstraintWidget r13 = (ConstraintWidget) r11.next();
        if ((r13 instanceof androidx.constraintlayout.core.widgets.e) == true) goto L7;
        if (r13.h0() == true) goto L11;
        r10.add(r13.f1440e);
    L18:
        if (r13.j0() == true) goto L20;
        r10.add(r13.f1442f);
    L27:
        if ((r13 instanceof k.a) == false) goto L4;
        r10.add(new h(r13));
        goto L4
    L20:
        if (r13.f1438d != null) goto L22;
        r13.f1438d = new b(r13, 1);
    L22:
        if (r12 != null) goto L24;
        r12 = new HashSet();
    L24:
        r12.add(r13.f1438d);
        goto L27
    L11:
        if (r13.f1436c != null) goto L13;
        r13.f1436c = new b(r13, 0);
    L13:
        if (r12 != null) goto L15;
        r12 = new HashSet();
    L15:
        r12.add(r13.f1436c);
        goto L18
    L7:
        r10.add(new g(r13));
        goto L4
    L29:
        if (r12 == null) goto L31;
        r10.addAll(r12);
    L31:
        Iterator r14 = r10.iterator();
    L33:
        if (r14.hasNext() == false) goto L35;
        ((WidgetRun) r14.next()).e();
        goto L33
    L35:
        Iterator r15 = r10.iterator();
    L37:
        if (r15.hasNext() == false) goto L42;
        WidgetRun r16 = (WidgetRun) r15.next();
        if (r16.f1542b == this.f1557d) goto L37;
        r16.c();
        goto L37
    }

    public final int e(ConstraintWidgetContainer r10, int r11) {
        int r12 = this.f1562i.size();
        long r13 = 0;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L6;
        r13 = Math.max(r13, ((j) this.f1562i.get(r14)).b(r10, r11));
        r14 = r14 + 1;
        goto L3
    L6:
        return (int) r13;
    }

    public boolean f(boolean r10) {
        boolean r11 = false;
        if (this.f1555b == false) goto L5;
    L6:
        Iterator r12 = this.f1554a.V0.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        ConstraintWidget r13 = (ConstraintWidget) r12.next();
        r13.m();
        r13.f1432a = false;
        r13.f1440e.q();
        r13.f1442f.p();
        goto L8
    L10:
        this.f1554a.m();
        ConstraintWidgetContainer r14 = this.f1554a;
        r14.f1432a = false;
        r14.f1440e.q();
        this.f1554a.f1442f.p();
        this.f1556c = false;
    L12:
        if (b(this.f1557d) == false) goto L14;
        return false;
    L14:
        this.f1554a.n1(0);
        this.f1554a.o1(0);
        ConstraintWidget.DimensionBehaviour r15 = this.f1554a.t(0);
        ConstraintWidget.DimensionBehaviour r16 = this.f1554a.t(1);
        if (this.f1555b == false) goto L17;
        c();
    L17:
        int r17 = this.f1554a.W();
        int r18 = this.f1554a.X();
        this.f1554a.f1440e.f1548h.c(r17);
        this.f1554a.f1442f.f1548h.c(r18);
        m();
        ConstraintWidget.DimensionBehaviour r19 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r15 == r19) goto L20;
        if (r16 == r19) goto L20;
    L35:
        ConstraintWidgetContainer r110 = this.f1554a;
        ConstraintWidget.DimensionBehaviour r20 = r110.f1435b0[0];
        ConstraintWidget.DimensionBehaviour r21 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r20 != r21) goto L38;
    L41:
        int r111 = r110.V() + r17;
        this.f1554a.f1440e.f1549i.c(r111);
        this.f1554a.f1440e.f1545e.c(r111 - r17);
        m();
        ConstraintWidgetContainer r112 = this.f1554a;
        ConstraintWidget.DimensionBehaviour r22 = r112.f1435b0[1];
        if (r22 != r21) goto L44;
    L45:
        int r113 = r112.w() + r18;
        this.f1554a.f1442f.f1549i.c(r113);
        this.f1554a.f1442f.f1545e.c(r113 - r18);
    L46:
        m();
        boolean r114 = true;
    L47:
        Iterator r23 = this.f1558e.iterator();
    L49:
        if (r23.hasNext() == false) goto L56;
        WidgetRun r24 = (WidgetRun) r23.next();
        if (r24.f1542b != this.f1554a) goto L55;
        if (r24.f1547g == false) goto L49;
    L55:
        r24.d();
        goto L49
    L56:
        Iterator r25 = this.f1558e.iterator();
    L58:
        if (r25.hasNext() == false) goto L79;
        WidgetRun r26 = (WidgetRun) r25.next();
        if (r114 == true) goto L65;
        if (r26.f1542b == this.f1554a) goto L58;
    L65:
        if (r26.f1548h.f1538j == false) goto L80;
        if (r26.f1549i.f1538j == true) goto L73;
        if ((r26 instanceof g) == false) goto L80;
    L73:
        if (r26.f1545e.f1538j == true) goto L58;
        if ((r26 instanceof b) == true) goto L58;
        if ((r26 instanceof g) == true) goto L58;
    L80:
        this.f1554a.Q0(r15);
        this.f1554a.h1(r16);
        return r11;
    L79:
        r11 = true;
        goto L80
    L44:
        if (r22 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L46;
    L38:
        if (r20 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L41;
        r114 = false;
    L20:
        if (r10 == false) goto L27;
        Iterator r27 = this.f1558e.iterator();
    L23:
        if (r27.hasNext() == false) goto L27;
        if (((WidgetRun) r27.next()).l() == true) goto L23;
        r10 = false;
    L27:
        if (r10 == true) goto L29;
    L31:
        if (r10 == false) goto L35;
        if (r16 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L35;
        this.f1554a.h1(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r115 = this.f1554a;
        r115.M0(e(r115, 1));
        ConstraintWidgetContainer r116 = this.f1554a;
        r116.f1442f.f1545e.c(r116.w());
        goto L35
    L29:
        if (r15 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L31;
        this.f1554a.Q0(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r28 = this.f1554a;
        r28.l1(e(r28, 0));
        ConstraintWidgetContainer r29 = this.f1554a;
        r29.f1440e.f1545e.c(r29.V());
        goto L31
    L5:
        if (this.f1556c == false) goto L12;
        goto L6
    }

    public boolean g(boolean r10) {
        if (this.f1555b == false) goto L10;
        Iterator r11 = this.f1554a.V0.iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        ConstraintWidget r12 = (ConstraintWidget) r11.next();
        r12.m();
        r12.f1432a = false;
        i r13 = r12.f1440e;
        r13.f1545e.f1538j = false;
        r13.f1547g = false;
        r13.q();
        k r14 = r12.f1442f;
        r14.f1545e.f1538j = false;
        r14.f1547g = false;
        r14.p();
        goto L6
    L8:
        this.f1554a.m();
        ConstraintWidgetContainer r15 = this.f1554a;
        r15.f1432a = false;
        i r16 = r15.f1440e;
        r16.f1545e.f1538j = false;
        r16.f1547g = false;
        r16.q();
        k r17 = this.f1554a.f1442f;
        r17.f1545e.f1538j = false;
        r17.f1547g = false;
        r17.p();
        c();
    L10:
        if (b(this.f1557d) == false) goto L12;
        return false;
    L12:
        this.f1554a.n1(0);
        this.f1554a.o1(0);
        this.f1554a.f1440e.f1548h.c(0);
        this.f1554a.f1442f.f1548h.c(0);
        return true;
    }

    public boolean h(boolean r10, int r11) {
        boolean r12 = false;
        ConstraintWidget.DimensionBehaviour r13 = this.f1554a.t(0);
        ConstraintWidget.DimensionBehaviour r14 = this.f1554a.t(1);
        int r15 = this.f1554a.W();
        int r16 = this.f1554a.X();
        if (r10 == false) goto L24;
        ConstraintWidget.DimensionBehaviour r17 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r13 == r17) goto L7;
        if (r14 != r17) goto L24;
    L7:
        Iterator r18 = this.f1558e.iterator();
    L9:
        if (r18.hasNext() == false) goto L15;
        WidgetRun r19 = (WidgetRun) r18.next();
        if (r19.f1546f != r11) goto L9;
        if (r19.l() == true) goto L9;
        r10 = false;
    L15:
        if (r11 != 0) goto L20;
        if (r10 == false) goto L24;
        if (r13 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L24;
        this.f1554a.Q0(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r110 = this.f1554a;
        r110.l1(e(r110, 0));
        ConstraintWidgetContainer r111 = this.f1554a;
        r111.f1440e.f1545e.c(r111.V());
        goto L24
    L20:
        if (r10 == false) goto L24;
        if (r14 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L24;
        this.f1554a.h1(ConstraintWidget.DimensionBehaviour.FIXED);
        ConstraintWidgetContainer r112 = this.f1554a;
        r112.M0(e(r112, 1));
        ConstraintWidgetContainer r113 = this.f1554a;
        r113.f1442f.f1545e.c(r113.w());
    L24:
        if (r11 != 0) goto L31;
        ConstraintWidgetContainer r114 = this.f1554a;
        ConstraintWidget.DimensionBehaviour r20 = r114.f1435b0[0];
        if (r20 != ConstraintWidget.DimensionBehaviour.FIXED) goto L28;
    L29:
        int r115 = r114.V() + r15;
        this.f1554a.f1440e.f1549i.c(r115);
        this.f1554a.f1440e.f1545e.c(r115 - r15);
    L30:
        boolean r116 = true;
    L38:
        m();
        Iterator r21 = this.f1558e.iterator();
    L40:
        if (r21.hasNext() == false) goto L50;
        WidgetRun r22 = (WidgetRun) r21.next();
        if (r22.f1546f != r11) goto L40;
        if (r22.f1542b != this.f1554a) goto L49;
        if (r22.f1547g == false) goto L40;
    L49:
        r22.d();
        goto L40
    L50:
        Iterator r23 = this.f1558e.iterator();
    L52:
        if (r23.hasNext() == false) goto L71;
        WidgetRun r24 = (WidgetRun) r23.next();
        if (r24.f1546f != r11) goto L52;
        if (r116 == true) goto L61;
        if (r24.f1542b == this.f1554a) goto L52;
    L61:
        if (r24.f1548h.f1538j == false) goto L72;
        if (r24.f1549i.f1538j == false) goto L72;
        if ((r24 instanceof b) == true) goto L52;
        if (r24.f1545e.f1538j == true) goto L52;
    L72:
        this.f1554a.Q0(r13);
        this.f1554a.h1(r14);
        return r12;
    L71:
        r12 = true;
        goto L72
    L28:
        if (r20 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L29;
    L36:
        r116 = false;
        goto L38
    L31:
        ConstraintWidgetContainer r117 = this.f1554a;
        ConstraintWidget.DimensionBehaviour r25 = r117.f1435b0[1];
        if (r25 != ConstraintWidget.DimensionBehaviour.FIXED) goto L34;
    L37:
        int r118 = r117.w() + r16;
        this.f1554a.f1442f.f1549i.c(r118);
        this.f1554a.f1442f.f1545e.c(r118 - r16);
        goto L30
    L34:
        if (r25 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L36;
        goto L36
    }

    public final void i(WidgetRun r11, int r12, ArrayList r13) {
        Iterator r10 = r11.f1548h.f1539k.iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        Dependency r14 = (Dependency) r10.next();
        if ((r14 instanceof DependencyNode) == true) goto L7;
        if ((r14 instanceof WidgetRun) == false) goto L4;
        a(((WidgetRun) r14).f1548h, r12, 0, r11.f1549i, r13, null);
        goto L4
    L7:
        a((DependencyNode) r14, r12, 0, r11.f1549i, r13, null);
        goto L4
    L11:
        Iterator r15 = r11.f1549i.f1539k.iterator();
    L13:
        if (r15.hasNext() == false) goto L21;
        Dependency r16 = (Dependency) r15.next();
        if ((r16 instanceof DependencyNode) == true) goto L16;
        if ((r16 instanceof WidgetRun) == false) goto L13;
        a(((WidgetRun) r16).f1549i, r12, 1, r11.f1548h, r13, null);
        goto L13
    L16:
        a((DependencyNode) r16, r12, 1, r11.f1548h, r13, null);
        goto L13
    L21:
        if (r12 != 1) goto L28;
        Iterator r17 = ((k) r11).f1577k.f1539k.iterator();
    L24:
        if (r17.hasNext() == false) goto L50;
        Dependency r18 = (Dependency) r17.next();
        if ((r18 instanceof DependencyNode) == false) goto L24;
        a((DependencyNode) r18, r12, 2, null, r13, null);
        goto L24
    L50:
        return;
    }

    public void j() {
        this.f1555b = true;
    }

    public void k() {
        this.f1556c = true;
    }

    public final void l(ConstraintWidget r10, ConstraintWidget.DimensionBehaviour r11, int r12, ConstraintWidget.DimensionBehaviour r13, int r14) {
        BasicMeasure.a r15 = this.f1561h;
        r15.f1519a = r11;
        r15.f1520b = r13;
        r15.f1521c = r12;
        r15.f1522d = r14;
        this.f1560g.measure(r10, r15);
        r10.l1(this.f1561h.f1523e);
        r10.M0(this.f1561h.f1524f);
        r10.L0(this.f1561h.f1526h);
        r10.B0(this.f1561h.f1525g);
    }

    public void m() {
        Iterator r10 = this.f1554a.V0.iterator();
    L4:
        if (r10.hasNext() == false) goto L42;
        ConstraintWidget r11 = (ConstraintWidget) r10.next();
        if (r11.f1432a == true) goto L4;
        ConstraintWidget.DimensionBehaviour[] r12 = r11.f1435b0;
        boolean r13 = false;
        ConstraintWidget.DimensionBehaviour r14 = r12[0];
        ConstraintWidget.DimensionBehaviour r15 = r12[1];
        int r16 = r11.f1476w;
        int r17 = r11.f1478x;
        ConstraintWidget.DimensionBehaviour r18 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r14 != r18) goto L11;
    L15:
        boolean r19 = true;
    L16:
        if (r15 != r18) goto L18;
    L20:
        r13 = true;
    L21:
        d r20 = r11.f1440e.f1545e;
        boolean r21 = r20.f1538j;
        d r22 = r11.f1442f.f1545e;
        boolean r110 = r22.f1538j;
        if (r21 == false) goto L25;
        if (r110 == false) goto L25;
        ConstraintWidget.DimensionBehaviour r23 = ConstraintWidget.DimensionBehaviour.FIXED;
        l(r11, r23, r20.f1535g, r23, r22.f1535g);
        r11.f1432a = true;
    L38:
        if (r11.f1432a == false) goto L4;
        d r24 = r11.f1442f.f1578l;
        if (r24 == null) goto L4;
        r24.c(r11.o());
    L25:
        if (r21 == false) goto L31;
        if (r13 == false) goto L31;
        l(r11, ConstraintWidget.DimensionBehaviour.FIXED, r20.f1535g, r18, r22.f1535g);
        if (r15 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L30;
        r11.f1442f.f1545e.f1563m = r11.w();
        goto L38
    L30:
        r11.f1442f.f1545e.c(r11.w());
        r11.f1432a = true;
    L31:
        if (r110 == false) goto L38;
        if (r19 == false) goto L38;
        l(r11, r18, r20.f1535g, ConstraintWidget.DimensionBehaviour.FIXED, r22.f1535g);
        if (r14 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L36;
        r11.f1440e.f1545e.f1563m = r11.V();
        goto L38
    L36:
        r11.f1440e.f1545e.c(r11.V());
        r11.f1432a = true;
        goto L38
    L18:
        if (r15 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L21;
        if (r17 != 1) goto L21;
    L11:
        if (r14 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L14;
        if (r16 == 1) goto L15;
    L14:
        r19 = false;
        goto L16
    }

    public void n(BasicMeasure.Measurer r10) {
        this.f1560g = r10;
    }
}
