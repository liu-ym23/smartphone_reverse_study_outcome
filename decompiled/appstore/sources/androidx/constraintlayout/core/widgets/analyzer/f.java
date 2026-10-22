package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {
    public static l a(ConstraintWidget r10, int r11, ArrayList r12, l r13) {
        if (r11 != 0) goto L4;
        int r14 = r10.S0;
    L5:
        int r15 = 0;
        if (r14 == (-1)) goto L19;
        if (r13 != null) goto L9;
    L10:
        int r16 = 0;
    L12:
        if (r16 >= r12.size()) goto L21;
        l r17 = (l) r12.get(r16);
        if (r17.c() == r14) goto L15;
        r16 = r16 + 1;
        goto L12
    L15:
        if (r13 == null) goto L17;
        r13.g(r11, r17);
        r12.remove(r13);
    L17:
        r13 = r17;
    L21:
        if (r13 != null) goto L37;
        if ((r10 instanceof k.a) == false) goto L33;
        int r18 = ((k.a) r10).t1(r11);
        if (r18 == (-1)) goto L33;
        int r19 = 0;
    L28:
        if (r19 >= r12.size()) goto L33;
        l r20 = (l) r12.get(r19);
        if (r20.c() == r18) goto L31;
        r19 = r19 + 1;
        goto L28
    L31:
        r13 = r20;
    L33:
        if (r13 != null) goto L35;
        r13 = new l(r11);
    L35:
        r12.add(r13);
    L37:
        if (r13.a(r10) == true) goto L39;
    L48:
        return r13;
    L39:
        if ((r10 instanceof androidx.constraintlayout.core.widgets.e) == false) goto L44;
        androidx.constraintlayout.core.widgets.e r21 = (androidx.constraintlayout.core.widgets.e) r10;
        ConstraintAnchor r22 = r21.s1();
        if (r21.t1() != 0) goto L43;
        r15 = 1;
    L43:
        r22.c(r15, r12, r13);
    L44:
        if (r11 != 0) goto L46;
        r10.S0 = r13.c();
        r10.Q.c(r11, r12, r13);
        r10.S.c(r11, r12, r13);
    L47:
        r10.X.c(r11, r12, r13);
        goto L48
    L46:
        r10.T0 = r13.c();
        r10.R.c(r11, r12, r13);
        r10.U.c(r11, r12, r13);
        r10.T.c(r11, r12, r13);
        goto L47
    L9:
        if (r14 != r13.f1582b) goto L10;
    L19:
        if (r14 == (-1)) goto L21;
        return r13;
    L4:
        r14 = r10.T0;
        goto L5
    }

    public static l b(ArrayList r10, int r11) {
        int r12 = r10.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L8;
        l r14 = (l) r10.get(r13);
        if (r11 == r14.f1582b) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L8:
        return null;
    }

    public static boolean c(ConstraintWidgetContainer r16, BasicMeasure.Measurer r17) {
        ArrayList r10 = r16.s1();
        int r11 = r10.size();
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L11;
        ConstraintWidget r14 = (ConstraintWidget) r10.get(r13);
        if (d(r16.z(), r16.S(), r14.z(), r14.S()) == false) goto L6;
        if ((r14 instanceof androidx.constraintlayout.core.widgets.d) == true) goto L9;
        r13 = r13 + 1;
        goto L3
    L9:
        return false;
    L6:
        return false;
    L11:
        Metrics r15 = r16.f1487b1;
        if (r15 == null) goto L14;
        r15.E++;
    L14:
        int r18 = 0;
        ArrayList r19 = null;
        ArrayList r20 = null;
        ArrayList r21 = null;
        ArrayList r22 = null;
        ArrayList r110 = null;
        ArrayList r111 = null;
    L15:
        if (r18 >= r11) goto L76;
        ConstraintWidget r112 = (ConstraintWidget) r10.get(r18);
        if (d(r16.z(), r16.S(), r112.z(), r112.S()) == true) goto L20;
        ConstraintWidgetContainer.U1(r12, r112, r17, r16.A1, BasicMeasure.a.f1516k);
    L20:
        boolean r23 = r112 instanceof androidx.constraintlayout.core.widgets.e;
        if (r23 == false) goto L33;
        androidx.constraintlayout.core.widgets.e r113 = (androidx.constraintlayout.core.widgets.e) r112;
        if (r113.t1() != 0) goto L28;
        if (r21 != null) goto L26;
        r21 = new ArrayList();
    L26:
        r21.add(r113);
    L28:
        if (r113.t1() != 1) goto L33;
        if (r19 != null) goto L31;
        r19 = new ArrayList();
    L31:
        r19.add(r113);
    L33:
        if ((r112 instanceof k.a) == false) goto L54;
        if ((r112 instanceof androidx.constraintlayout.core.widgets.a) == false) goto L46;
        androidx.constraintlayout.core.widgets.a r24 = (androidx.constraintlayout.core.widgets.a) r112;
        if (r24.y1() != 0) goto L42;
        if (r20 != null) goto L40;
        r20 = new ArrayList();
    L40:
        r20.add(r24);
    L42:
        if (r24.y1() != 1) goto L54;
        if (r22 != null) goto L45;
        r22 = new ArrayList();
    L45:
        r22.add(r24);
        goto L54
    L46:
        k.a r25 = (k.a) r112;
        if (r20 != null) goto L49;
        r20 = new ArrayList();
    L49:
        r20.add(r25);
        if (r22 != null) goto L52;
        r22 = new ArrayList();
    L52:
        r22.add(r25);
    L54:
        if (r112.Q.f1426f != null) goto L64;
        if (r112.S.f1426f != null) goto L64;
        if (r23 == true) goto L64;
        if ((r112 instanceof androidx.constraintlayout.core.widgets.a) == true) goto L64;
        if (r110 != null) goto L62;
        r110 = new ArrayList();
    L62:
        r110.add(r112);
    L64:
        if (r112.R.f1426f != null) goto L75;
        if (r112.T.f1426f != null) goto L75;
        if (r112.U.f1426f != null) goto L75;
        if (r23 == true) goto L75;
        if ((r112 instanceof androidx.constraintlayout.core.widgets.a) == true) goto L75;
        if (r111 != null) goto L74;
        r111 = new ArrayList();
    L74:
        r111.add(r112);
    L75:
        r18 = r18 + 1;
        r12 = 0;
        goto L15
    L76:
        ArrayList r26 = new ArrayList();
        if (r19 == null) goto L82;
        Iterator r27 = r19.iterator();
    L80:
        if (r27.hasNext() == false) goto L82;
        a((androidx.constraintlayout.core.widgets.e) r27.next(), 0, r26, null);
    L82:
        int r28 = 0;
        l r114 = null;
        if (r20 == null) goto L88;
        Iterator r29 = r20.iterator();
    L86:
        if (r29.hasNext() == false) goto L88;
        k.a r30 = (k.a) r29.next();
        l r31 = a(r30, r28, r26, r114);
        r30.s1(r26, r28, r31);
        r31.b(r26);
        r28 = 0;
        r114 = null;
    L88:
        ConstraintAnchor r32 = r16.n(ConstraintAnchor.Type.LEFT);
        if (r32.d() == null) goto L94;
        Iterator r33 = r32.d().iterator();
    L92:
        if (r33.hasNext() == false) goto L94;
        a(((ConstraintAnchor) r33.next()).f1424d, 0, r26, null);
    L94:
        ConstraintAnchor r34 = r16.n(ConstraintAnchor.Type.RIGHT);
        if (r34.d() == null) goto L100;
        Iterator r35 = r34.d().iterator();
    L98:
        if (r35.hasNext() == false) goto L100;
        a(((ConstraintAnchor) r35.next()).f1424d, 0, r26, null);
    L100:
        ConstraintAnchor r36 = r16.n(ConstraintAnchor.Type.CENTER);
        if (r36.d() == null) goto L106;
        Iterator r37 = r36.d().iterator();
    L104:
        if (r37.hasNext() == false) goto L106;
        a(((ConstraintAnchor) r37.next()).f1424d, 0, r26, null);
    L106:
        l r38 = null;
        if (r110 == null) goto L112;
        Iterator r39 = r110.iterator();
    L110:
        if (r39.hasNext() == false) goto L112;
        a((ConstraintWidget) r39.next(), 0, r26, null);
    L112:
        if (r21 == null) goto L117;
        Iterator r40 = r21.iterator();
    L115:
        if (r40.hasNext() == false) goto L117;
        a((androidx.constraintlayout.core.widgets.e) r40.next(), 1, r26, null);
    L117:
        int r41 = 1;
        if (r22 == null) goto L123;
        Iterator r42 = r22.iterator();
    L121:
        if (r42.hasNext() == false) goto L123;
        k.a r43 = (k.a) r42.next();
        l r44 = a(r43, r41, r26, r38);
        r43.s1(r26, r41, r44);
        r44.b(r26);
        r41 = 1;
        r38 = null;
    L123:
        ConstraintAnchor r45 = r16.n(ConstraintAnchor.Type.TOP);
        if (r45.d() == null) goto L129;
        Iterator r46 = r45.d().iterator();
    L127:
        if (r46.hasNext() == false) goto L129;
        a(((ConstraintAnchor) r46.next()).f1424d, 1, r26, null);
    L129:
        ConstraintAnchor r47 = r16.n(ConstraintAnchor.Type.BASELINE);
        if (r47.d() == null) goto L135;
        Iterator r48 = r47.d().iterator();
    L133:
        if (r48.hasNext() == false) goto L135;
        a(((ConstraintAnchor) r48.next()).f1424d, 1, r26, null);
    L135:
        ConstraintAnchor r49 = r16.n(ConstraintAnchor.Type.BOTTOM);
        if (r49.d() == null) goto L141;
        Iterator r50 = r49.d().iterator();
    L139:
        if (r50.hasNext() == false) goto L141;
        a(((ConstraintAnchor) r50.next()).f1424d, 1, r26, null);
    L141:
        ConstraintAnchor r51 = r16.n(ConstraintAnchor.Type.CENTER);
        if (r51.d() == null) goto L148;
        Iterator r52 = r51.d().iterator();
    L145:
        if (r52.hasNext() == false) goto L148;
        a(((ConstraintAnchor) r52.next()).f1424d, 1, r26, null);
    L148:
        if (r111 == null) goto L153;
        Iterator r53 = r111.iterator();
    L151:
        if (r53.hasNext() == false) goto L153;
        a((ConstraintWidget) r53.next(), 1, r26, null);
    L153:
        int r54 = 0;
    L154:
        if (r54 >= r11) goto L163;
        ConstraintWidget r55 = (ConstraintWidget) r10.get(r54);
        if (r55.r0() == false) goto L161;
        l r56 = b(r26, r55.S0);
        l r57 = b(r26, r55.T0);
        if (r56 == null) goto L161;
        if (r57 == null) goto L161;
        r56.g(0, r57);
        r57.i(2);
        r26.remove(r56);
    L161:
        r54 = r54 + 1;
        goto L154
    L163:
        if (r26.size() > 1) goto L167;
        return false;
    L167:
        if (r16.z() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L179;
        Iterator r58 = r26.iterator();
        l r59 = null;
        int r60 = 0;
    L170:
        if (r58.hasNext() == false) goto L177;
        l r61 = (l) r58.next();
        if (r61.d() == 1) goto L170;
        r61.h(false);
        int r62 = r61.f(r16.M1(), 0);
        if (r62 <= r60) goto L170;
        r59 = r61;
        r60 = r62;
        goto L170
    L177:
        if (r59 == null) goto L179;
        r16.Q0(ConstraintWidget.DimensionBehaviour.FIXED);
        r16.l1(r60);
        r59.h(true);
    L181:
        if (r16.S() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L194;
        Iterator r63 = r26.iterator();
        l r64 = null;
        int r65 = 0;
    L184:
        if (r63.hasNext() == false) goto L191;
        l r66 = (l) r63.next();
        if (r66.d() == 0) goto L184;
        r66.h(false);
        int r67 = r66.f(r16.M1(), 1);
        if (r67 <= r65) goto L184;
        r64 = r66;
        r65 = r67;
        goto L184
    L191:
        boolean r68 = false;
        boolean r69 = true;
        if (r64 == null) goto L195;
        r16.h1(ConstraintWidget.DimensionBehaviour.FIXED);
        r16.M0(r65);
        r64.h(true);
        l r70 = r64;
    L196:
        if (r59 != null) goto L201;
        if (r70 != null) goto L201;
        return r68;
    L201:
        return r69;
    L195:
        r70 = null;
        goto L196
    L194:
        r68 = false;
        r69 = true;
    L179:
        r59 = null;
        goto L181
    }

    public static boolean d(ConstraintWidget.DimensionBehaviour r10, ConstraintWidget.DimensionBehaviour r11, ConstraintWidget.DimensionBehaviour r12, ConstraintWidget.DimensionBehaviour r13) {
        ConstraintWidget.DimensionBehaviour r14 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r12 == r14) goto L11;
        ConstraintWidget.DimensionBehaviour r15 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r12 == r15) goto L11;
        if (r12 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L10;
        if (r10 != r15) goto L11;
    L10:
        boolean r16 = false;
    L12:
        if (r13 == r14) goto L20;
        ConstraintWidget.DimensionBehaviour r17 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r13 == r17) goto L20;
        if (r13 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L19;
        if (r11 != r17) goto L20;
    L19:
        boolean r18 = false;
    L21:
        if (r16 == true) goto L25;
        if (r18 == true) goto L25;
        return false;
    L25:
        return true;
    L20:
        r18 = true;
    L11:
        r16 = true;
        goto L12
    }
}
