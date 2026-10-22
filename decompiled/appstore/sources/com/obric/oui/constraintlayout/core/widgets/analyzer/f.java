package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
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
        if ((r10 instanceof wc.a) == false) goto L33;
        int r18 = ((wc.a) r10).u1(r11);
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
        if ((r10 instanceof com.obric.oui.constraintlayout.core.widgets.f) == false) goto L44;
        com.obric.oui.constraintlayout.core.widgets.f r21 = (com.obric.oui.constraintlayout.core.widgets.f) r10;
        ConstraintAnchor r22 = r21.t1();
        if (r21.u1() != 0) goto L43;
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
        if (r14 != r13.c()) goto L10;
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
        if (r11 == r14.c()) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L8:
        return null;
    }

    public static boolean c(com.obric.oui.constraintlayout.core.widgets.d r16, BasicMeasure.Measurer r17) {
        ArrayList r10 = r16.t1();
        int r11 = r10.size();
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L11;
        ConstraintWidget r14 = (ConstraintWidget) r10.get(r13);
        if (d(r16.z(), r16.S(), r14.z(), r14.S()) == false) goto L6;
        if ((r14 instanceof com.obric.oui.constraintlayout.core.widgets.e) == true) goto L9;
        r13 = r13 + 1;
        goto L3
    L9:
        return false;
    L6:
        return false;
    L11:
        int r15 = 0;
        ArrayList r18 = null;
        ArrayList r19 = null;
        ArrayList r20 = null;
        ArrayList r21 = null;
        ArrayList r110 = null;
        ArrayList r111 = null;
    L12:
        if (r15 >= r11) goto L73;
        ConstraintWidget r112 = (ConstraintWidget) r10.get(r15);
        if (d(r16.z(), r16.S(), r112.z(), r112.S()) == true) goto L17;
        com.obric.oui.constraintlayout.core.widgets.d.V1(r12, r112, r17, r16.f13434z1, BasicMeasure.a.f13309k);
    L17:
        boolean r22 = r112 instanceof com.obric.oui.constraintlayout.core.widgets.f;
        if (r22 == false) goto L30;
        com.obric.oui.constraintlayout.core.widgets.f r113 = (com.obric.oui.constraintlayout.core.widgets.f) r112;
        if (r113.u1() != 0) goto L25;
        if (r20 != null) goto L23;
        r20 = new ArrayList();
    L23:
        r20.add(r113);
    L25:
        if (r113.u1() != 1) goto L30;
        if (r18 != null) goto L28;
        r18 = new ArrayList();
    L28:
        r18.add(r113);
    L30:
        if ((r112 instanceof wc.a) == false) goto L51;
        if ((r112 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L43;
        com.obric.oui.constraintlayout.core.widgets.a r23 = (com.obric.oui.constraintlayout.core.widgets.a) r112;
        if (r23.z1() != 0) goto L39;
        if (r19 != null) goto L37;
        r19 = new ArrayList();
    L37:
        r19.add(r23);
    L39:
        if (r23.z1() != 1) goto L51;
        if (r21 != null) goto L42;
        r21 = new ArrayList();
    L42:
        r21.add(r23);
        goto L51
    L43:
        wc.a r24 = (wc.a) r112;
        if (r19 != null) goto L46;
        r19 = new ArrayList();
    L46:
        r19.add(r24);
        if (r21 != null) goto L49;
        r21 = new ArrayList();
    L49:
        r21.add(r24);
    L51:
        if (r112.Q.f13245f != null) goto L61;
        if (r112.S.f13245f != null) goto L61;
        if (r22 == true) goto L61;
        if ((r112 instanceof com.obric.oui.constraintlayout.core.widgets.a) == true) goto L61;
        if (r110 != null) goto L59;
        r110 = new ArrayList();
    L59:
        r110.add(r112);
    L61:
        if (r112.R.f13245f != null) goto L72;
        if (r112.T.f13245f != null) goto L72;
        if (r112.U.f13245f != null) goto L72;
        if (r22 == true) goto L72;
        if ((r112 instanceof com.obric.oui.constraintlayout.core.widgets.a) == true) goto L72;
        if (r111 != null) goto L71;
        r111 = new ArrayList();
    L71:
        r111.add(r112);
    L72:
        r15 = r15 + 1;
        r12 = 0;
        goto L12
    L73:
        ArrayList r25 = new ArrayList();
        if (r18 == null) goto L79;
        Iterator r26 = r18.iterator();
    L77:
        if (r26.hasNext() == false) goto L79;
        a((com.obric.oui.constraintlayout.core.widgets.f) r26.next(), 0, r25, null);
    L79:
        int r27 = 0;
        l r114 = null;
        if (r19 == null) goto L85;
        Iterator r28 = r19.iterator();
    L83:
        if (r28.hasNext() == false) goto L85;
        wc.a r29 = (wc.a) r28.next();
        l r30 = a(r29, r27, r25, r114);
        r29.t1(r25, r27, r30);
        r30.b(r25);
        r27 = 0;
        r114 = null;
    L85:
        ConstraintAnchor r31 = r16.n(ConstraintAnchor.Type.LEFT);
        if (r31.d() == null) goto L91;
        Iterator r32 = r31.d().iterator();
    L89:
        if (r32.hasNext() == false) goto L91;
        a(((ConstraintAnchor) r32.next()).f13243d, 0, r25, null);
    L91:
        ConstraintAnchor r33 = r16.n(ConstraintAnchor.Type.RIGHT);
        if (r33.d() == null) goto L97;
        Iterator r34 = r33.d().iterator();
    L95:
        if (r34.hasNext() == false) goto L97;
        a(((ConstraintAnchor) r34.next()).f13243d, 0, r25, null);
    L97:
        ConstraintAnchor r35 = r16.n(ConstraintAnchor.Type.CENTER);
        if (r35.d() == null) goto L103;
        Iterator r36 = r35.d().iterator();
    L101:
        if (r36.hasNext() == false) goto L103;
        a(((ConstraintAnchor) r36.next()).f13243d, 0, r25, null);
    L103:
        l r37 = null;
        if (r110 == null) goto L109;
        Iterator r38 = r110.iterator();
    L107:
        if (r38.hasNext() == false) goto L109;
        a((ConstraintWidget) r38.next(), 0, r25, null);
    L109:
        if (r20 == null) goto L114;
        Iterator r39 = r20.iterator();
    L112:
        if (r39.hasNext() == false) goto L114;
        a((com.obric.oui.constraintlayout.core.widgets.f) r39.next(), 1, r25, null);
    L114:
        int r40 = 1;
        if (r21 == null) goto L120;
        Iterator r41 = r21.iterator();
    L118:
        if (r41.hasNext() == false) goto L120;
        wc.a r42 = (wc.a) r41.next();
        l r43 = a(r42, r40, r25, r37);
        r42.t1(r25, r40, r43);
        r43.b(r25);
        r40 = 1;
        r37 = null;
    L120:
        ConstraintAnchor r44 = r16.n(ConstraintAnchor.Type.TOP);
        if (r44.d() == null) goto L126;
        Iterator r45 = r44.d().iterator();
    L124:
        if (r45.hasNext() == false) goto L126;
        a(((ConstraintAnchor) r45.next()).f13243d, 1, r25, null);
    L126:
        ConstraintAnchor r46 = r16.n(ConstraintAnchor.Type.BASELINE);
        if (r46.d() == null) goto L132;
        Iterator r47 = r46.d().iterator();
    L130:
        if (r47.hasNext() == false) goto L132;
        a(((ConstraintAnchor) r47.next()).f13243d, 1, r25, null);
    L132:
        ConstraintAnchor r48 = r16.n(ConstraintAnchor.Type.BOTTOM);
        if (r48.d() == null) goto L138;
        Iterator r49 = r48.d().iterator();
    L136:
        if (r49.hasNext() == false) goto L138;
        a(((ConstraintAnchor) r49.next()).f13243d, 1, r25, null);
    L138:
        ConstraintAnchor r50 = r16.n(ConstraintAnchor.Type.CENTER);
        if (r50.d() == null) goto L145;
        Iterator r51 = r50.d().iterator();
    L142:
        if (r51.hasNext() == false) goto L145;
        a(((ConstraintAnchor) r51.next()).f13243d, 1, r25, null);
    L145:
        if (r111 == null) goto L150;
        Iterator r52 = r111.iterator();
    L148:
        if (r52.hasNext() == false) goto L150;
        a((ConstraintWidget) r52.next(), 1, r25, null);
    L150:
        int r53 = 0;
    L151:
        if (r53 >= r11) goto L160;
        ConstraintWidget r54 = (ConstraintWidget) r10.get(r53);
        if (r54.r0() == false) goto L158;
        l r55 = b(r25, r54.S0);
        l r56 = b(r25, r54.T0);
        if (r55 == null) goto L158;
        if (r56 == null) goto L158;
        r55.g(0, r56);
        r56.i(2);
        r25.remove(r55);
    L158:
        r53 = r53 + 1;
        goto L151
    L160:
        if (r25.size() > 1) goto L164;
        return false;
    L164:
        if (r16.z() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L176;
        Iterator r57 = r25.iterator();
        l r58 = null;
        int r59 = 0;
    L167:
        if (r57.hasNext() == false) goto L174;
        l r60 = (l) r57.next();
        if (r60.d() == 1) goto L167;
        r60.h(false);
        int r61 = r60.f(r16.N1(), 0);
        if (r61 <= r59) goto L167;
        r58 = r60;
        r59 = r61;
        goto L167
    L174:
        if (r58 == null) goto L176;
        r16.R0(ConstraintWidget.DimensionBehaviour.FIXED);
        r16.m1(r59);
        r58.h(true);
    L178:
        if (r16.S() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L191;
        Iterator r62 = r25.iterator();
        l r63 = null;
        int r64 = 0;
    L181:
        if (r62.hasNext() == false) goto L188;
        l r65 = (l) r62.next();
        if (r65.d() == 0) goto L181;
        r65.h(false);
        int r66 = r65.f(r16.N1(), 1);
        if (r66 <= r64) goto L181;
        r63 = r65;
        r64 = r66;
        goto L181
    L188:
        boolean r67 = false;
        boolean r68 = true;
        if (r63 == null) goto L192;
        r16.i1(ConstraintWidget.DimensionBehaviour.FIXED);
        r16.N0(r64);
        r63.h(true);
        l r69 = r63;
    L193:
        if (r58 != null) goto L198;
        if (r69 != null) goto L198;
        return r67;
    L198:
        return r68;
    L192:
        r69 = null;
        goto L193
    L191:
        r67 = false;
        r68 = true;
    L176:
        r58 = null;
        goto L178
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
