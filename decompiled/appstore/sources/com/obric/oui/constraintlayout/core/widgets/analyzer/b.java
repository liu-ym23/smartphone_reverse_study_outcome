package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class b extends WidgetRun {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ArrayList f13345k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13346l;

    public b(ConstraintWidget r10, int r11) {
        super(r10);
        this.f13345k = new ArrayList();
        this.f13339f = r11;
        p();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void c() {
        Iterator r10 = this.f13345k.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((WidgetRun) r10.next()).c();
        goto L4
    L6:
        int r11 = this.f13345k.size();
        if (r11 >= 1) goto L9;
        return;
    L9:
        ConstraintWidget r12 = ((WidgetRun) this.f13345k.get(0)).f13335b;
        ConstraintWidget r13 = ((WidgetRun) this.f13345k.get(r11 - 1)).f13335b;
        if (this.f13339f != 0) goto L21;
        ConstraintAnchor r14 = r12.Q;
        ConstraintAnchor r15 = r13.S;
        DependencyNode r16 = h(r14, 0);
        int r17 = r14.f();
        ConstraintWidget r18 = q();
        if (r18 == null) goto L14;
        r17 = r18.Q.f();
    L14:
        if (r16 == null) goto L16;
        a(this.f13341h, r16, r17);
    L16:
        DependencyNode r19 = h(r15, 0);
        int r20 = r15.f();
        ConstraintWidget r21 = r();
        if (r21 == null) goto L19;
        r20 = r21.S.f();
    L19:
        if (r19 == null) goto L31;
        a(this.f13342i, r19, -r20);
    L31:
        this.f13341h.f13322a = this;
        this.f13342i.f13322a = this;
        return;
    L21:
        ConstraintAnchor r22 = r12.R;
        ConstraintAnchor r23 = r13.T;
        DependencyNode r24 = h(r22, 1);
        int r25 = r22.f();
        ConstraintWidget r26 = q();
        if (r26 == null) goto L24;
        r25 = r26.R.f();
    L24:
        if (r24 == null) goto L26;
        a(this.f13341h, r24, r25);
    L26:
        DependencyNode r27 = h(r23, 1);
        int r28 = r23.f();
        ConstraintWidget r29 = r();
        if (r29 == null) goto L29;
        r28 = r29.T.f();
    L29:
        if (r27 == null) goto L31;
        a(this.f13342i, r27, -r28);
        goto L31
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void d() {
        int r10 = 0;
    L4:
        if (r10 >= this.f13345k.size()) goto L6;
        ((WidgetRun) this.f13345k.get(r10)).d();
        r10 = r10 + 1;
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public void e() {
        this.f13336c = null;
        Iterator r10 = this.f13345k.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        ((WidgetRun) r10.next()).e();
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public long i() {
        int r10 = this.f13345k.size();
        long r11 = 0;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L5;
        WidgetRun r13 = (WidgetRun) this.f13345k.get(r12);
        r11 = ((r11 + ((long) r13.f13341h.f13327f)) + r13.i()) + ((long) r13.f13342i.f13327f);
        r12 = r12 + 1;
        goto L3
    L5:
        return r11;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public boolean l() {
        int r10 = this.f13345k.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        if (((WidgetRun) this.f13345k.get(r11)).l() == false) goto L6;
        r11 = r11 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public final void p() {
        ConstraintWidget r10 = this.f13335b;
        ConstraintWidget r11 = r10.K(this.f13339f);
    L3:
        ConstraintWidget r12 = r11;
        ConstraintWidget r13 = r10;
        r10 = r12;
        if (r10 == null) goto L6;
        r11 = r10.K(this.f13339f);
        goto L3
    L6:
        this.f13335b = r13;
        this.f13345k.add(r13.M(this.f13339f));
        ConstraintWidget r14 = r13.I(this.f13339f);
    L7:
        if (r14 == null) goto L9;
        this.f13345k.add(r14.M(this.f13339f));
        r14 = r14.I(this.f13339f);
        goto L7
    L9:
        Iterator r15 = this.f13345k.iterator();
    L11:
        if (r15.hasNext() == false) goto L18;
        WidgetRun r16 = (WidgetRun) r15.next();
        int r17 = this.f13339f;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L11;
        r16.f13335b.f13257d = this;
        goto L11
    L14:
        r16.f13335b.f13255c = this;
        goto L11
    L18:
        if (this.f13339f != 0) goto L25;
        if (((com.obric.oui.constraintlayout.core.widgets.d) this.f13335b.J()).S1() == false) goto L25;
        if (this.f13345k.size() <= 1) goto L25;
        ArrayList r18 = this.f13345k;
        this.f13335b = ((WidgetRun) r18.get(r18.size() - 1)).f13335b;
    L25:
        if (this.f13339f != 0) goto L27;
        int r19 = this.f13335b.y();
    L28:
        this.f13346l = r19;
        return;
    L27:
        r19 = this.f13335b.R();
        goto L28
    }

    public final ConstraintWidget q() {
        int r10 = 0;
    L4:
        if (r10 >= this.f13345k.size()) goto L10;
        WidgetRun r11 = (WidgetRun) this.f13345k.get(r10);
        if (r11.f13335b.U() != 8) goto L8;
        r10 = r10 + 1;
        goto L4
    L8:
        return r11.f13335b;
    L10:
        return null;
    }

    public final ConstraintWidget r() {
        int r10 = this.f13345k.size() - 1;
    L3:
        if (r10 < 0) goto L9;
        WidgetRun r11 = (WidgetRun) this.f13345k.get(r10);
        if (r11.f13335b.U() != 8) goto L7;
        r10 = r10 - 1;
        goto L3
    L7:
        return r11.f13335b;
    L9:
        return null;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder("ChainRun ");
        if (this.f13339f != 0) goto L5;
        String r11 = "horizontal : ";
    L6:
        r10.append(r11);
        Iterator r12 = this.f13345k.iterator();
    L8:
        if (r12.hasNext() == false) goto L11;
        WidgetRun r13 = (WidgetRun) r12.next();
        r10.append("<");
        r10.append(r13);
        r10.append("> ");
        goto L8
    L11:
        return r10.toString();
    L5:
        r11 = "vertical : ";
        goto L6
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.Dependency
    public void update(Dependency r27) {
        if (this.f13341h.f13331j == true) goto L5;
        return;
    L5:
        if (this.f13342i.f13331j == false) goto L323;
        ConstraintWidget r10 = this.f13335b.J();
        if ((r10 instanceof com.obric.oui.constraintlayout.core.widgets.d) == false) goto L10;
        boolean r11 = ((com.obric.oui.constraintlayout.core.widgets.d) r10).S1();
    L11:
        int r12 = this.f13342i.f13328g - this.f13341h.f13328g;
        int r13 = this.f13345k.size();
        int r14 = 0;
    L12:
        int r15 = -1;
        int r16 = 8;
        if (r14 >= r13) goto L17;
        if (((WidgetRun) this.f13345k.get(r14)).f13335b.U() != 8) goto L18;
        r14 = r14 + 1;
    L18:
        int r17 = r13 - 1;
        int r18 = r17;
    L19:
        if (r18 < 0) goto L24;
        if (((WidgetRun) this.f13345k.get(r18)).f13335b.U() != 8) goto L23;
        r18 = r18 - 1;
        goto L19
    L23:
        r15 = r18;
    L24:
        int r19 = 0;
    L26:
        if (r19 >= 2) goto L75;
        int r110 = 0;
        int r111 = 0;
        int r112 = 0;
        int r113 = 0;
        float r114 = 0.0f;
    L28:
        if (r110 >= r13) goto L70;
        WidgetRun r20 = (WidgetRun) this.f13345k.get(r110);
        if (r20.f13335b.U() == r16) goto L69;
        r113 = r113 + 1;
        if (r110 <= 0) goto L36;
        if (r110 < r14) goto L36;
        r111 = r111 + r20.f13341h.f13327f;
    L36:
        d r115 = r20.f13338e;
        int r21 = r115.f13328g;
        if (r20.f13337d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L39;
        boolean r116 = true;
    L40:
        if (r116 == false) goto L52;
        int r117 = this.f13339f;
        if (r117 != 0) goto L47;
        if (r20.f13335b.f13259e.f13338e.f13331j == true) goto L47;
        return;
    L47:
        if (r117 == 1) goto L49;
    L51:
        int r118 = r21;
    L60:
        int r22 = r118;
    L61:
        if (r116 == true) goto L65;
        r112 = r112 + 1;
        float r23 = r20.f13335b.N0[this.f13339f];
        if (r23 < 0.0f) goto L66;
        r114 = r114 + r23;
    L66:
        if (r110 >= r17) goto L69;
        if (r110 >= r15) goto L69;
        r111 = r111 + (-r20.f13342i.f13327f);
        goto L69
    L65:
        r111 = r111 + r22;
        goto L66
    L49:
        if (r20.f13335b.f13261f.f13338e.f13331j == true) goto L51;
        return;
    L52:
        r118 = r21;
        if (r20.f13334a != 1) goto L58;
        if (r19 != 0) goto L58;
        r22 = r115.f13356m;
        r112 = r112 + 1;
    L56:
        r116 = true;
    L58:
        if (r115.f13331j == false) goto L60;
        r22 = r118;
        goto L56
    L39:
        r116 = false;
    L69:
        r110 = r110 + 1;
        r16 = 8;
        goto L28
    L70:
        if (r111 < r12) goto L74;
        if (r112 == 0) goto L74;
        r19 = r19 + 1;
        r16 = 8;
    L74:
        int r24 = r113;
    L76:
        int r25 = this.f13341h.f13328g;
        if (r11 == false) goto L80;
        r25 = this.f13342i.f13328g;
    L80:
        if (r111 > r12) goto L82;
    L85:
        if (r112 <= 0) goto L135;
        float r119 = r12 - r111;
        int r120 = (int) ((r119 / r112) + 0.5f);
        int r121 = 0;
        int r122 = 0;
    L87:
        if (r121 >= r13) goto L114;
        WidgetRun r26 = (WidgetRun) this.f13345k.get(r121);
        int r123 = r120;
        int r28 = r111;
        if (r26.f13335b.U() != 8) goto L92;
    L90:
        r11 = r11;
        r25 = r25;
        r119 = r119;
    L113:
        r121 = r121 + 1;
        r120 = r123;
        r111 = r28;
        r25 = r25;
        r119 = r119;
        r11 = r11;
        r24 = r24;
        goto L87
    L92:
        if (r26.f13337d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L90;
        d r124 = r26.f13338e;
        if (r124.f13331j == true) goto L90;
        if (r114 <= 0.0f) goto L98;
        int r29 = (int) (((r26.f13335b.N0[this.f13339f] * r119) / r114) + 0.5f);
    L100:
        if (this.f13339f != 0) goto L102;
        ConstraintWidget r125 = r26.f13335b;
        int r126 = r125.A;
        int r127 = r125.f13301z;
    L104:
        if (r26.f13334a != 1) goto L106;
        int r30 = Math.min(r29, r124.f13356m);
    L107:
        int r31 = Math.max(r127, r30);
        if (r126 <= 0) goto L110;
        r31 = Math.min(r126, r31);
    L110:
        if (r31 == r29) goto L112;
        r122 = r122 + 1;
        r29 = r31;
    L112:
        r26.f13338e.c(r29);
        goto L113
    L106:
        r30 = r29;
        goto L107
    L102:
        ConstraintWidget r128 = r26.f13335b;
        int r129 = r128.D;
        r127 = r128.C;
        r126 = r129;
        goto L104
    L98:
        r29 = r123;
        goto L100
    L114:
        boolean r210 = r11;
        int r211 = r24;
        int r212 = r25;
        int r213 = r111;
        if (r122 <= 0) goto L129;
        r112 = r112 - r122;
        int r32 = 0;
        r111 = 0;
    L117:
        if (r32 >= r13) goto L130;
        WidgetRun r33 = (WidgetRun) this.f13345k.get(r32);
        if (r33.f13335b.U() == 8) goto L128;
        if (r32 <= 0) goto L124;
        if (r32 < r14) goto L124;
        r111 = r111 + r33.f13341h.f13327f;
    L124:
        r111 = r111 + r33.f13338e.f13328g;
        if (r32 >= r17) goto L128;
        if (r32 >= r15) goto L128;
        r111 = r111 + (-r33.f13342i.f13327f);
    L128:
        r32 = r32 + 1;
    L130:
        int r34 = 2;
        if (this.f13346l != 2) goto L134;
        if (r122 != 0) goto L134;
        int r35 = 0;
        this.f13346l = 0;
    L136:
        if (r111 <= r12) goto L138;
        this.f13346l = r34;
    L138:
        if (r211 <= 0) goto L142;
        if (r112 != 0) goto L142;
        if (r14 != r15) goto L142;
        this.f13346l = r34;
    L142:
        int r36 = this.f13346l;
        if (r36 != 1) goto L191;
        int r37 = r211;
        if (r37 <= 1) goto L147;
        int r38 = (r12 - r111) / (r37 - 1);
    L150:
        if (r112 <= 0) goto L152;
        r38 = r35;
    L152:
        int r39 = r35;
        int r40 = r212;
    L153:
        if (r39 >= r13) goto L324;
        if (r210 == false) goto L156;
        int r41 = r13 - (r39 + 1);
    L157:
        WidgetRun r42 = (WidgetRun) this.f13345k.get(r41);
        if (r42.f13335b.U() != 8) goto L160;
        r42.f13341h.c(r40);
        r42.f13342i.c(r40);
    L190:
        r39 = r39 + 1;
        goto L153
    L160:
        if (r39 <= 0) goto L164;
        if (r210 == false) goto L163;
        r40 = r40 - r38;
        goto L164
    L163:
        r40 = r40 + r38;
    L164:
        if (r39 <= 0) goto L169;
        if (r39 < r14) goto L169;
        if (r210 == false) goto L168;
        r40 = r40 - r42.f13341h.f13327f;
        goto L169
    L168:
        r40 = r40 + r42.f13341h.f13327f;
    L169:
        if (r210 == false) goto L171;
        r42.f13342i.c(r40);
    L172:
        d r43 = r42.f13338e;
        int r130 = r43.f13328g;
        if (r42.f13337d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L175;
    L177:
        if (r210 == false) goto L179;
        r40 = r40 - r130;
    L180:
        if (r210 == false) goto L183;
        r42.f13341h.c(r40);
    L184:
        r42.f13340g = true;
        if (r39 >= r17) goto L190;
        if (r39 >= r15) goto L190;
        if (r210 == false) goto L189;
        r40 = r40 - (-r42.f13342i.f13327f);
        goto L190
    L189:
        r40 = r40 + (-r42.f13342i.f13327f);
        goto L190
    L183:
        r42.f13342i.c(r40);
        goto L184
    L179:
        r40 = r40 + r130;
        goto L180
    L175:
        if (r42.f13334a != 1) goto L177;
        r130 = r43.f13356m;
        goto L177
    L171:
        r42.f13341h.c(r40);
        goto L172
    L156:
        r41 = r39;
        goto L157
    L324:
        return;
    L147:
        if (r37 != 1) goto L149;
        r38 = (r12 - r111) / 2;
        goto L150
    L149:
        r38 = r35;
        goto L150
    L191:
        int r44 = r211;
        if (r36 != 0) goto L233;
        int r45 = (r12 - r111) / (r44 + 1);
        if (r112 <= 0) goto L196;
        r45 = r35;
    L196:
        int r46 = r35;
        int r47 = r212;
    L197:
        if (r46 >= r13) goto L325;
        if (r210 == false) goto L200;
        int r48 = r13 - (r46 + 1);
    L201:
        WidgetRun r49 = (WidgetRun) this.f13345k.get(r48);
        if (r49.f13335b.U() != 8) goto L204;
        r49.f13341h.c(r47);
        r49.f13342i.c(r47);
    L231:
        r46 = r46 + 1;
        goto L197
    L204:
        if (r210 == false) goto L206;
        int r50 = r47 - r45;
    L207:
        if (r46 <= 0) goto L212;
        if (r46 < r14) goto L212;
        if (r210 == false) goto L211;
        r50 = r50 - r49.f13341h.f13327f;
        goto L212
    L211:
        r50 = r50 + r49.f13341h.f13327f;
    L212:
        if (r210 == false) goto L214;
        r49.f13342i.c(r50);
    L215:
        d r51 = r49.f13338e;
        int r131 = r51.f13328g;
        if (r49.f13337d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L218;
    L220:
        if (r210 == false) goto L222;
        r47 = r50 - r131;
    L223:
        if (r210 == false) goto L225;
        r49.f13341h.c(r47);
    L226:
        if (r46 >= r17) goto L231;
        if (r46 >= r15) goto L231;
        if (r210 == false) goto L230;
        r47 = r47 - (-r49.f13342i.f13327f);
        goto L231
    L230:
        r47 = r47 + (-r49.f13342i.f13327f);
        goto L231
    L225:
        r49.f13342i.c(r47);
        goto L226
    L222:
        r47 = r50 + r131;
        goto L223
    L218:
        if (r49.f13334a != 1) goto L220;
        r131 = Math.min(r131, r51.f13356m);
        goto L220
    L214:
        r49.f13341h.c(r50);
        goto L215
    L206:
        r50 = r47 + r45;
        goto L207
    L200:
        r48 = r46;
        goto L201
    L325:
        return;
    L233:
        if (r36 == 2) goto L235;
        return;
    L235:
        if (this.f13339f != 0) goto L237;
        float r52 = this.f13335b.x();
    L238:
        if (r210 == false) goto L240;
        r52 = 1.0f - r52;
    L240:
        int r53 = (int) (((r12 - r111) * r52) + 0.5f);
        if (r53 < 0) goto L243;
        if (r112 > 0) goto L243;
    L244:
        if (r210 == false) goto L246;
        int r54 = r212 - r53;
    L247:
        int r55 = r35;
    L248:
        if (r55 >= r13) goto L326;
        if (r210 == false) goto L251;
        int r56 = r13 - (r55 + 1);
    L252:
        WidgetRun r57 = (WidgetRun) this.f13345k.get(r56);
        if (r57.f13335b.U() != 8) goto L255;
        r57.f13341h.c(r54);
        r57.f13342i.c(r54);
    L280:
        r55 = r55 + 1;
        goto L248
    L255:
        if (r55 <= 0) goto L260;
        if (r55 < r14) goto L260;
        if (r210 == false) goto L259;
        r54 = r54 - r57.f13341h.f13327f;
        goto L260
    L259:
        r54 = r54 + r57.f13341h.f13327f;
    L260:
        if (r210 == false) goto L262;
        r57.f13342i.c(r54);
    L263:
        d r58 = r57.f13338e;
        int r132 = r58.f13328g;
        if (r57.f13337d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L269;
        if (r57.f13334a != 1) goto L269;
        r132 = r58.f13356m;
    L269:
        if (r210 == false) goto L271;
        r54 = r54 - r132;
    L272:
        if (r210 == false) goto L274;
        r57.f13341h.c(r54);
    L275:
        if (r55 >= r17) goto L280;
        if (r55 >= r15) goto L280;
        if (r210 == false) goto L279;
        r54 = r54 - (-r57.f13342i.f13327f);
        goto L280
    L279:
        r54 = r54 + (-r57.f13342i.f13327f);
        goto L280
    L274:
        r57.f13342i.c(r54);
        goto L275
    L271:
        r54 = r54 + r132;
        goto L272
    L262:
        r57.f13341h.c(r54);
        goto L263
    L251:
        r56 = r55;
        goto L252
    L326:
        return;
    L246:
        r54 = r212 + r53;
    L243:
        r53 = r35;
        goto L244
    L237:
        r52 = this.f13335b.Q();
    L134:
        r35 = 0;
        goto L136
    L129:
        r111 = r213;
        goto L130
    L135:
        r210 = r11;
        r211 = r24;
        r212 = r25;
        r35 = 0;
        r34 = 2;
        goto L136
    L82:
        if (r11 == false) goto L84;
        r25 = r25 + ((int) (((r111 - r12) / 2.0f) + 0.5f));
        goto L85
    L84:
        r25 = r25 - ((int) (((r111 - r12) / 2.0f) + 0.5f));
        goto L85
    L75:
        r24 = 0;
        r111 = 0;
        r112 = 0;
        r114 = 0.0f;
        goto L76
    L17:
        r14 = -1;
        goto L18
    L10:
        r11 = false;
        goto L11
    }
}
