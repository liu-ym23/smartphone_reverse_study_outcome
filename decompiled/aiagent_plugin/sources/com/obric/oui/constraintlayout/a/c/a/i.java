package com.obric.oui.constraintlayout.a.c.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: Grouping.java */
/* JADX INFO: loaded from: classes4.dex */
public class i {
    public static boolean a(com.obric.oui.constraintlayout.a.c.e.a r3, com.obric.oui.constraintlayout.a.c.e.a r4, com.obric.oui.constraintlayout.a.c.e.a r5, com.obric.oui.constraintlayout.a.c.e.a r6) {
        if (r5 != com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L5;
    L12:
        boolean r7 = true;
    L14:
        if (r6 != com.obric.oui.constraintlayout.a.c.e.a.f34756a) goto L16;
    L23:
        boolean r8 = true;
    L24:
        if (r7 == true) goto L28;
        if (r8 == true) goto L28;
        return false;
    L28:
        return true;
    L16:
        if (r6 == com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L23;
        if (r6 == com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L20;
    L22:
        r8 = false;
        goto L24
    L20:
        if (r4 == com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L22;
    L5:
        if (r5 == com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L12;
        if (r5 == com.obric.oui.constraintlayout.a.c.e.a.f34759d) goto L9;
    L11:
        r7 = false;
        goto L14
    L9:
        if (r3 == com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L11;
        goto L11
    }

    public static boolean a(com.obric.oui.constraintlayout.a.c.f r17, b.InterfaceC0938b r18) {
        b.InterfaceC0938b r1 = (b.InterfaceC0938b) ZeusTransformUtils.wrapperContextForParams(r18, b.InterfaceC0938b.class, "com.obric.aiagent.plugin");
        ArrayList<com.obric.oui.constraintlayout.a.c.e> r3 = r17.ak();
        int r4 = r3.size();
        int r6 = 0;
    L3:
        if (r6 >= r4) goto L12;
        com.obric.oui.constraintlayout.a.c.e r7 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r3.get(r6), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (a(r17.aa(), r17.ab(), r7.aa(), r7.ab()) == false) goto L6;
        if (ZeusTransformUtils.instanceOf(r7, com.obric.oui.constraintlayout.a.c.g.class) == true) goto L9;
        r6 = r6 + 1;
        goto L3
    L9:
        return false;
    L6:
        return false;
    L12:
        if (r17.aB == null) goto L14;
        r17.aB.G++;
    L14:
        int r8 = 0;
        ArrayList r9 = null;
        ArrayList r10 = null;
        ArrayList r11 = null;
        ArrayList r12 = null;
        ArrayList r13 = null;
        ArrayList r14 = null;
    L15:
        if (r8 >= r4) goto L77;
        com.obric.oui.constraintlayout.a.c.e r15 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r3.get(r8), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        ArrayList<com.obric.oui.constraintlayout.a.c.e> r16 = r3;
        if (a(r17.aa(), r17.ab(), r15.aa(), r15.ab()) == true) goto L20;
        com.obric.oui.constraintlayout.a.c.f.a(0, r15, r1, r17.aT, b.a.f34678a);
    L20:
        if (ZeusTransformUtils.instanceOf(r15, com.obric.oui.constraintlayout.a.c.h.class) == false) goto L32;
        com.obric.oui.constraintlayout.a.c.h r5 = (com.obric.oui.constraintlayout.a.c.h) ZeusTransformUtils.preCheckCast(r15, com.obric.oui.constraintlayout.a.c.h.class, "com.obric.aiagent.plugin");
        if (r5.c() != 0) goto L27;
        if (r11 != null) goto L25;
        r11 = new ArrayList();
    L25:
        r11.add(r5);
    L27:
        if (r5.c() != 1) goto L32;
        if (r9 != null) goto L30;
        r9 = new ArrayList();
    L30:
        r9.add(r5);
    L32:
        if (ZeusTransformUtils.instanceOf(r15, com.obric.oui.constraintlayout.a.c.j.class) == false) goto L53;
        if (ZeusTransformUtils.instanceOf(r15, com.obric.oui.constraintlayout.a.c.a.class) == false) goto L45;
        com.obric.oui.constraintlayout.a.c.a r19 = (com.obric.oui.constraintlayout.a.c.a) ZeusTransformUtils.preCheckCast(r15, com.obric.oui.constraintlayout.a.c.a.class, "com.obric.aiagent.plugin");
        if (r19.h() != 0) goto L41;
        if (r10 != null) goto L39;
        r10 = new ArrayList();
    L39:
        r10.add(r19);
    L41:
        if (r19.h() != 1) goto L53;
        if (r12 != null) goto L44;
        r12 = new ArrayList();
    L44:
        r12.add(r19);
        goto L53
    L45:
        com.obric.oui.constraintlayout.a.c.j r20 = (com.obric.oui.constraintlayout.a.c.j) ZeusTransformUtils.preCheckCast(r15, com.obric.oui.constraintlayout.a.c.j.class, "com.obric.aiagent.plugin");
        if (r10 != null) goto L48;
        r10 = new ArrayList();
    L48:
        r10.add(r20);
        if (r12 != null) goto L51;
        r12 = new ArrayList();
    L51:
        r12.add(r20);
    L53:
        if (r15.B.f34739c != null) goto L64;
        if (r15.D.f34739c != null) goto L64;
        if (ZeusTransformUtils.instanceOf(r15, com.obric.oui.constraintlayout.a.c.h.class) == true) goto L64;
        if (ZeusTransformUtils.instanceOf(r15, com.obric.oui.constraintlayout.a.c.a.class) == true) goto L64;
        if (r13 != null) goto L62;
        r13 = new ArrayList();
    L62:
        r13.add(r15);
    L64:
        if (r15.C.f34739c != null) goto L76;
        if (r15.E.f34739c != null) goto L76;
        if (r15.F.f34739c != null) goto L76;
        if (ZeusTransformUtils.instanceOf(r15, com.obric.oui.constraintlayout.a.c.h.class) == true) goto L76;
        if (ZeusTransformUtils.instanceOf(r15, com.obric.oui.constraintlayout.a.c.a.class) == true) goto L76;
        if (r14 != null) goto L75;
        r14 = new ArrayList();
    L75:
        r14.add(r15);
    L76:
        r8 = r8 + 1;
        r3 = r16;
        goto L15
    L77:
        ArrayList<com.obric.oui.constraintlayout.a.c.e> r110 = r3;
        ArrayList<o> r2 = new ArrayList();
        if (r9 == null) goto L83;
        Iterator r21 = r9.iterator();
    L81:
        if (r21.hasNext() == false) goto L83;
        a((com.obric.oui.constraintlayout.a.c.h) ZeusTransformUtils.preCheckCast(r21.next(), com.obric.oui.constraintlayout.a.c.h.class, "com.obric.aiagent.plugin"), 0, r2, null);
    L83:
        if (r10 == null) goto L88;
        Iterator r22 = r10.iterator();
    L86:
        if (r22.hasNext() == false) goto L88;
        com.obric.oui.constraintlayout.a.c.j r23 = (com.obric.oui.constraintlayout.a.c.j) ZeusTransformUtils.preCheckCast(r22.next(), com.obric.oui.constraintlayout.a.c.j.class, "com.obric.aiagent.plugin");
        o r24 = a(r23, 0, r2, null);
        r23.a(r2, 0, r24);
        r24.a(r2);
    L88:
        com.obric.oui.constraintlayout.a.c.d r25 = r17.a(com.obric.oui.constraintlayout.a.c.d.a.f34744b);
        if (r25.a() == null) goto L94;
        Iterator<com.obric.oui.constraintlayout.a.c.d> r26 = r25.a().iterator();
    L92:
        if (r26.hasNext() == false) goto L94;
        a(((com.obric.oui.constraintlayout.a.c.d) ZeusTransformUtils.preCheckCast(r26.next(), com.obric.oui.constraintlayout.a.c.d.class, "com.obric.aiagent.plugin")).f34737a, 0, r2, null);
    L94:
        com.obric.oui.constraintlayout.a.c.d r27 = r17.a(com.obric.oui.constraintlayout.a.c.d.a.f34746d);
        if (r27.a() == null) goto L100;
        Iterator<com.obric.oui.constraintlayout.a.c.d> r28 = r27.a().iterator();
    L98:
        if (r28.hasNext() == false) goto L100;
        a(((com.obric.oui.constraintlayout.a.c.d) ZeusTransformUtils.preCheckCast(r28.next(), com.obric.oui.constraintlayout.a.c.d.class, "com.obric.aiagent.plugin")).f34737a, 0, r2, null);
    L100:
        com.obric.oui.constraintlayout.a.c.d r29 = r17.a(com.obric.oui.constraintlayout.a.c.d.a.g);
        if (r29.a() == null) goto L106;
        Iterator<com.obric.oui.constraintlayout.a.c.d> r30 = r29.a().iterator();
    L104:
        if (r30.hasNext() == false) goto L106;
        a(((com.obric.oui.constraintlayout.a.c.d) ZeusTransformUtils.preCheckCast(r30.next(), com.obric.oui.constraintlayout.a.c.d.class, "com.obric.aiagent.plugin")).f34737a, 0, r2, null);
    L106:
        if (r13 == null) goto L111;
        Iterator r31 = r13.iterator();
    L109:
        if (r31.hasNext() == false) goto L111;
        a((com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r31.next(), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin"), 0, r2, null);
    L111:
        if (r11 == null) goto L116;
        Iterator r32 = r11.iterator();
    L114:
        if (r32.hasNext() == false) goto L116;
        a((com.obric.oui.constraintlayout.a.c.h) ZeusTransformUtils.preCheckCast(r32.next(), com.obric.oui.constraintlayout.a.c.h.class, "com.obric.aiagent.plugin"), 1, r2, null);
    L116:
        if (r12 == null) goto L121;
        Iterator r33 = r12.iterator();
    L119:
        if (r33.hasNext() == false) goto L121;
        com.obric.oui.constraintlayout.a.c.j r34 = (com.obric.oui.constraintlayout.a.c.j) ZeusTransformUtils.preCheckCast(r33.next(), com.obric.oui.constraintlayout.a.c.j.class, "com.obric.aiagent.plugin");
        o r35 = a(r34, 1, r2, null);
        r34.a(r2, 1, r35);
        r35.a(r2);
    L121:
        com.obric.oui.constraintlayout.a.c.d r36 = r17.a(com.obric.oui.constraintlayout.a.c.d.a.f34745c);
        if (r36.a() == null) goto L127;
        Iterator<com.obric.oui.constraintlayout.a.c.d> r37 = r36.a().iterator();
    L125:
        if (r37.hasNext() == false) goto L127;
        a(((com.obric.oui.constraintlayout.a.c.d) ZeusTransformUtils.preCheckCast(r37.next(), com.obric.oui.constraintlayout.a.c.d.class, "com.obric.aiagent.plugin")).f34737a, 1, r2, null);
    L127:
        com.obric.oui.constraintlayout.a.c.d r38 = r17.a(com.obric.oui.constraintlayout.a.c.d.a.f);
        if (r38.a() == null) goto L133;
        Iterator<com.obric.oui.constraintlayout.a.c.d> r39 = r38.a().iterator();
    L131:
        if (r39.hasNext() == false) goto L133;
        a(((com.obric.oui.constraintlayout.a.c.d) ZeusTransformUtils.preCheckCast(r39.next(), com.obric.oui.constraintlayout.a.c.d.class, "com.obric.aiagent.plugin")).f34737a, 1, r2, null);
    L133:
        com.obric.oui.constraintlayout.a.c.d r40 = r17.a(com.obric.oui.constraintlayout.a.c.d.a.f34747e);
        if (r40.a() == null) goto L139;
        Iterator<com.obric.oui.constraintlayout.a.c.d> r41 = r40.a().iterator();
    L137:
        if (r41.hasNext() == false) goto L139;
        a(((com.obric.oui.constraintlayout.a.c.d) ZeusTransformUtils.preCheckCast(r41.next(), com.obric.oui.constraintlayout.a.c.d.class, "com.obric.aiagent.plugin")).f34737a, 1, r2, null);
    L139:
        com.obric.oui.constraintlayout.a.c.d r42 = r17.a(com.obric.oui.constraintlayout.a.c.d.a.g);
        if (r42.a() == null) goto L145;
        Iterator<com.obric.oui.constraintlayout.a.c.d> r43 = r42.a().iterator();
    L143:
        if (r43.hasNext() == false) goto L145;
        a(((com.obric.oui.constraintlayout.a.c.d) ZeusTransformUtils.preCheckCast(r43.next(), com.obric.oui.constraintlayout.a.c.d.class, "com.obric.aiagent.plugin")).f34737a, 1, r2, null);
    L145:
        if (r14 == null) goto L150;
        Iterator r44 = r14.iterator();
    L148:
        if (r44.hasNext() == false) goto L150;
        a((com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r44.next(), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin"), 1, r2, null);
    L150:
        int r45 = 0;
    L151:
        if (r45 >= r4) goto L160;
        ArrayList<com.obric.oui.constraintlayout.a.c.e> r46 = r110;
        com.obric.oui.constraintlayout.a.c.e r47 = (com.obric.oui.constraintlayout.a.c.e) ZeusTransformUtils.preCheckCast(r46.get(r45), com.obric.oui.constraintlayout.a.c.e.class, "com.obric.aiagent.plugin");
        if (r47.x() == false) goto L158;
        o r48 = a(r2, r47.ax);
        o r49 = a(r2, r47.ay);
        if (r48 == null) goto L158;
        if (r49 == null) goto L158;
        r48.a(0, r49);
        r49.a(2);
        r2.remove(r48);
    L158:
        r45 = r45 + 1;
        r110 = r46;
        goto L151
    L160:
        if (r2.size() > 1) goto L164;
        return false;
    L164:
        if (r17.aa() != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L176;
        Iterator<o> r50 = r2.iterator();
        o r51 = null;
        int r111 = 0;
    L167:
        if (r50.hasNext() == false) goto L174;
        o r52 = (o) ZeusTransformUtils.preCheckCast(r50.next(), o.class, "com.obric.aiagent.plugin");
        if (r52.a() == 1) goto L167;
        r52.a(false);
        int r53 = r52.a(r17.aj(), 0);
        if (r53 <= r111) goto L167;
        r51 = r52;
        r111 = r53;
        goto L167
    L174:
        if (r51 == null) goto L176;
        r17.a(com.obric.oui.constraintlayout.a.c.e.a.f34756a);
        r17.q(r111);
        r51.a(true);
    L178:
        if (r17.ab() != com.obric.oui.constraintlayout.a.c.e.a.f34757b) goto L191;
        Iterator<o> r54 = r2.iterator();
        o r55 = null;
        int r112 = 0;
    L181:
        if (r54.hasNext() == false) goto L188;
        o r56 = (o) ZeusTransformUtils.preCheckCast(r54.next(), o.class, "com.obric.aiagent.plugin");
        if (r56.a() == 0) goto L181;
        r56.a(false);
        int r57 = r56.a(r17.aj(), 1);
        if (r57 <= r112) goto L181;
        r55 = r56;
        r112 = r57;
        goto L181
    L188:
        boolean r58 = false;
        boolean r59 = true;
        if (r55 == null) goto L192;
        r17.b(com.obric.oui.constraintlayout.a.c.e.a.f34756a);
        r17.r(r112);
        r55.a(true);
    L193:
        if (r51 != null) goto L198;
        if (r55 != null) goto L198;
        return r58;
    L198:
        return r59;
    L192:
        r55 = null;
        goto L193
    L191:
        r58 = false;
        r59 = true;
    L176:
        r51 = null;
        goto L178
    }

    private static o a(ArrayList<o> r5, int r6) {
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        o r2 = (o) ZeusTransformUtils.preCheckCast(r5.get(r1), o.class, "com.obric.aiagent.plugin");
        if (r6 == r2.b()) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    public static o a(com.obric.oui.constraintlayout.a.c.e r7, int r8, ArrayList<o> r9, o r10) {
        if (r8 != 0) goto L4;
        int r0 = r7.ax;
    L5:
        int r1 = 0;
        if (r0 == (-1)) goto L19;
        if (r10 != null) goto L9;
    L10:
        int r4 = 0;
    L12:
        if (r4 >= r9.size()) goto L21;
        o r5 = (o) ZeusTransformUtils.preCheckCast(r9.get(r4), o.class, "com.obric.aiagent.plugin");
        if (r5.b() == r0) goto L15;
        r4 = r4 + 1;
        goto L12
    L15:
        if (r10 == null) goto L17;
        r10.a(r8, r5);
        r9.remove(r10);
    L17:
        r10 = r5;
    L21:
        if (r10 != null) goto L37;
        if (ZeusTransformUtils.instanceOf(r7, com.obric.oui.constraintlayout.a.c.j.class) == false) goto L33;
        int r2 = ((com.obric.oui.constraintlayout.a.c.j) ZeusTransformUtils.preCheckCast(r7, com.obric.oui.constraintlayout.a.c.j.class, "com.obric.aiagent.plugin")).L(r8);
        if (r2 == (-1)) goto L33;
        int r3 = 0;
    L28:
        if (r3 >= r9.size()) goto L33;
        o r6 = (o) ZeusTransformUtils.preCheckCast(r9.get(r3), o.class, "com.obric.aiagent.plugin");
        if (r6.b() == r2) goto L31;
        r3 = r3 + 1;
        goto L28
    L31:
        r10 = r6;
    L33:
        if (r10 != null) goto L35;
        r10 = new o(r8);
    L35:
        r9.add(r10);
    L37:
        if (r10.a(r7) == true) goto L39;
    L48:
        return r10;
    L39:
        if (ZeusTransformUtils.instanceOf(r7, com.obric.oui.constraintlayout.a.c.h.class) == false) goto L44;
        com.obric.oui.constraintlayout.a.c.h r11 = (com.obric.oui.constraintlayout.a.c.h) ZeusTransformUtils.preCheckCast(r7, com.obric.oui.constraintlayout.a.c.h.class, "com.obric.aiagent.plugin");
        com.obric.oui.constraintlayout.a.c.d r12 = r11.b();
        if (r11.c() != 0) goto L43;
        r1 = 1;
    L43:
        r12.a(r1, r9, r10);
    L44:
        if (r8 != 0) goto L46;
        r7.ax = r10.b();
        r7.B.a(r8, r9, r10);
        r7.D.a(r8, r9, r10);
    L47:
        r7.I.a(r8, r9, r10);
        goto L48
    L46:
        r7.ay = r10.b();
        r7.C.a(r8, r9, r10);
        r7.F.a(r8, r9, r10);
        r7.E.a(r8, r9, r10);
        goto L47
    L9:
        if (r0 != r10.b()) goto L10;
    L19:
        if (r0 == (-1)) goto L21;
        return r10;
    L4:
        r0 = r7.ay;
        goto L5
    }
}
