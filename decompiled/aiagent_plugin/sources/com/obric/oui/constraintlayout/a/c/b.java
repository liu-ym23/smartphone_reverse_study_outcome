package com.obric.oui.constraintlayout.a.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: Chain.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    public static void a(f r7, com.obric.oui.constraintlayout.a.d r8, ArrayList<e> r9, int r10) {
        int r0 = 0;
        if (r10 != 0) goto L5;
        int r1 = r7.aH;
        c[] r3 = r7.aK;
        int r2 = 0;
    L6:
        if (r0 >= r1) goto L13;
        c r4 = r3[r0];
        r4.a();
        if (r9 != null) goto L10;
    L11:
        a(r7, r8, r10, r2, r4);
    L12:
        r0 = r0 + 1;
        goto L6
    L10:
        if (r9.contains(r4.f34732a) == false) goto L12;
    L13:
        return;
    L5:
        int r5 = r7.aI;
        r3 = r7.aJ;
        r2 = 2;
        r1 = r5;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r39v0, types: [com.obric.oui.constraintlayout.a.d] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27, types: [com.obric.oui.constraintlayout.a.h] */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r8v39 */
    /* JADX WARN: Type inference failed for: r8v40 */
    /* JADX WARN: Type inference failed for: r8v46 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [com.obric.oui.constraintlayout.a.c.e] */
    static void a(f r38, com.obric.oui.constraintlayout.a.d r39, int r40, int r41, c r42) {
        int r10 = r40;
        e r11 = r42.f34732a;
        e r12 = r42.f34734c;
        e r13 = r42.f34733b;
        e r14 = r42.f34735d;
        e r2 = r42.f34736e;
        float r3 = r42.k;
        e r4 = r42.f;
        e r5 = r42.g;
        if (r38.L[r10] != e.a.f34757b) goto L5;
        boolean r6 = true;
    L7:
        if (r10 != 0) goto L20;
        if (r2.ao != 0) goto L11;
        boolean r8 = true;
    L13:
        if (r2.ao != 1) goto L15;
        boolean r15 = true;
    L17:
        if (r2.ao == 2) goto L29;
    L30:
        boolean r7 = false;
    L31:
        boolean r17 = r15;
        boolean r9 = false;
        boolean r16 = r8;
        ?? r18 = r11;
    L32:
        Object r22 = null;
        if (r9 == true) goto L90;
        d r19 = r18.f34748J[r41];
        if (r7 == false) goto L37;
        int r20 = 1;
    L38:
        int r24 = r19.i();
        float r25 = r3;
        boolean r26 = r9;
        if (r18.L[r10] == e.a.f34758c) goto L41;
    L43:
        boolean r21 = false;
    L45:
        if (r19.f34739c == null) goto L48;
        if (r18 == r11) goto L48;
        r24 = r24 + r19.f34739c.i();
    L48:
        int r23 = r24;
        if (r7 == false) goto L55;
        if (r18 == r11) goto L55;
        if (r18 == r13) goto L55;
        r20 = 8;
    L55:
        if (r19.f34739c == null) goto L69;
        if (r18 != r13) goto L58;
        r39.a(r19.f, r19.f34739c.f, r23, 6);
    L59:
        if (r21 == false) goto L62;
        if (r7 == true) goto L62;
        r20 = 5;
    L62:
        if (r18 != r13) goto L67;
        if (r7 == false) goto L67;
        if (r18.j(r10) == false) goto L67;
        int r27 = 5;
    L68:
        r39.c(r19.f, r19.f34739c.f, r23, r27);
    L70:
        if (r6 == true) goto L72;
    L78:
        d r28 = r18.f34748J[r41 + 1].f34739c;
        if (r28 == null) goto L86;
        e r29 = r28.f34737a;
        if (r29.f34748J[r41].f34739c == null) goto L86;
        if (r29.f34748J[r41].f34739c.f34737a != r18) goto L86;
        r22 = r29;
    L86:
        if (r22 == null) goto L88;
        r18 = r22;
        r9 = r26;
    L89:
        r16 = r16;
        r3 = r25;
        r2 = r2;
        r11 = r11;
        r18 = r18;
        goto L32
    L88:
        r9 = true;
        goto L89
    L72:
        if (r18.B() != 8) goto L74;
    L76:
        int r30 = 0;
    L77:
        r39.a(r18.f34748J[r41].f, r38.f34748J[r41].f, r30, 8);
        goto L78
    L74:
        if (r18.L[r10] != e.a.f34758c) goto L76;
        r30 = 0;
        r39.a(r18.f34748J[r41 + 1].f, r18.f34748J[r41].f, 0, 5);
    L67:
        r27 = r20;
        goto L68
    L58:
        r39.a(r19.f, r19.f34739c.f, r23, 8);
        goto L59
    L69:
        r2 = r2;
        r11 = r11;
        goto L70
    L41:
        if (r18.p[r10] != 0) goto L43;
        r21 = true;
        goto L45
    L37:
        r20 = 4;
        goto L38
    L90:
        e r210 = r2;
        float r211 = r3;
        e r212 = r11;
        boolean r213 = r16;
        if (r14 == null) goto L112;
        int r31 = r41 + 1;
        if (r12.f34748J[r31].f34739c == null) goto L112;
        d r32 = r14.f34748J[r31];
        if (r14.L[r10] == e.a.f34758c) goto L97;
    L99:
        boolean r33 = false;
    L100:
        if (r33 == false) goto L106;
        if (r7 == true) goto L106;
        if (r32.f34739c.f34737a != r38) goto L106;
        r39.c(r32.f, r32.f34739c.f, -r32.i(), 5);
    L110:
        r39.b(r32.f, r12.f34748J[r31].f34739c.f, -r32.i(), 6);
    L106:
        if (r7 == false) goto L110;
        if (r32.f34739c.f34737a != r38) goto L110;
        r39.c(r32.f, r32.f34739c.f, -r32.i(), 4);
        goto L110
    L97:
        if (r14.p[r10] != 0) goto L99;
        r33 = true;
    L112:
        if (r6 == false) goto L114;
        int r34 = r41 + 1;
        r39.a(r38.f34748J[r34].f, r12.f34748J[r34].f, r12.f34748J[r34].i(), 8);
    L114:
        ArrayList<e> r0 = r42.h;
        if (r0 == null) goto L143;
        int r35 = r0.size();
        if (r35 <= 1) goto L143;
        if (r42.p == true) goto L121;
    L123:
        float r36 = r211;
    L124:
        float r37 = 0.0f;
        float r310 = 0.0f;
        e r43 = null;
        int r44 = 0;
    L125:
        if (r44 >= r35) goto L143;
        e r45 = (e) ZeusTransformUtils.preCheckCast(r0.get(r44), e.class, "com.obric.aiagent.plugin");
        float r110 = r45.as[r10];
        if (r110 >= r37) goto L134;
        if (r42.r == false) goto L131;
        r39.c(r45.f34748J[r41 + 1].f, r45.f34748J[r41].f, 0, 4);
    L136:
        r0 = r0;
        r35 = r35;
    L142:
        r44 = r44 + 1;
        r35 = r35;
        r0 = r0;
        r37 = 0.0f;
        goto L125
    L131:
        r110 = 1.0f;
        r37 = 0.0f;
    L134:
        if (r110 != r37) goto L138;
        r39.c(r45.f34748J[r41 + 1].f, r45.f34748J[r41].f, 0, 8);
        goto L136
    L138:
        if (r43 == null) goto L141;
        com.obric.oui.constraintlayout.a.h r46 = r43.f34748J[r41].f;
        int r111 = r41 + 1;
        com.obric.oui.constraintlayout.a.h r47 = r43.f34748J[r111].f;
        com.obric.oui.constraintlayout.a.h r112 = r45.f34748J[r41].f;
        com.obric.oui.constraintlayout.a.h r1 = r45.f34748J[r111].f;
        com.obric.oui.constraintlayout.a.b r48 = r39.c();
        r48.a(r310, r36, r110, r46, r47, r112, r1);
        r39.a(r48);
    L141:
        r43 = r45;
        r310 = r110;
        goto L142
    L121:
        if (r42.r == true) goto L123;
        r36 = r42.j;
    L143:
        if (r13 == null) goto L164;
        if (r13 == r14) goto L146;
        if (r7 == false) goto L164;
    L146:
        d r49 = r212.f34748J[r41];
        int r50 = r41 + 1;
        d r51 = r12.f34748J[r50];
        if (r49.f34739c == null) goto L149;
        com.obric.oui.constraintlayout.a.h r52 = r49.f34739c.f;
    L151:
        if (r51.f34739c == null) goto L153;
        com.obric.oui.constraintlayout.a.h r53 = r51.f34739c.f;
    L154:
        d r54 = r13.f34748J[r41];
        if (r14 == null) goto L157;
        r51 = r14.f34748J[r50];
    L157:
        if (r52 == null) goto L295;
        if (r53 == null) goto L295;
        if (r10 != 0) goto L161;
        float r55 = r210.ab;
    L162:
        int r56 = r54.i();
        com.obric.oui.constraintlayout.a.h r57 = r52;
        r39.a(r54.f, r57, r56, r55, r53, r51.f, r51.i(), 7);
        goto L295
    L161:
        r55 = r210.ac;
    L295:
        if (r213 == true) goto L297;
        if (r17 == true) goto L297;
        return;
    L297:
        if (r13 == null) goto L339;
        if (r13 == r14) goto L340;
        d r58 = r13.f34748J[r41];
        if (r14 != null) goto L302;
        r14 = r13;
    L302:
        int r59 = r41 + 1;
        d r60 = r14.f34748J[r59];
        if (r58.f34739c == null) goto L305;
        com.obric.oui.constraintlayout.a.h r61 = r58.f34739c.f;
    L307:
        if (r60.f34739c == null) goto L309;
        com.obric.oui.constraintlayout.a.h r62 = r60.f34739c.f;
    L310:
        if (r12 == r14) goto L315;
        d r63 = r12.f34748J[r59];
        if (r63.f34739c == null) goto L314;
        r22 = r63.f34739c.f;
    L314:
        ?? r64 = r22;
    L316:
        if (r13 != r14) goto L318;
        r58 = r13.f34748J[r41];
        r60 = r13.f34748J[r59];
    L318:
        if (r61 == null) goto L341;
        if (r64 == 0) goto L342;
        int r65 = r58.i();
        int r66 = r14.f34748J[r59].i();
        r39.a(r58.f, r61, r65, 0.5f, r64, r60.f, r66, 5);
        return;
    L342:
        return;
    L341:
        return;
    L315:
        r64 = r62;
        goto L316
    L309:
        r62 = null;
        goto L310
    L305:
        r61 = null;
        goto L307
    L340:
        return;
    L339:
        return;
    L153:
        r53 = null;
        goto L154
    L149:
        r52 = null;
    L164:
        if (r213 == false) goto L228;
        if (r13 == null) goto L228;
        if (r42.j > 0) goto L169;
    L171:
        boolean r113 = false;
    L172:
        e r67 = r13;
        e r114 = r67;
    L173:
        if (r114 == null) goto L295;
        e r68 = r114.au[r10];
    L175:
        if (r68 == null) goto L180;
        if (r68.B() != 8) goto L180;
        r68 = r68.au[r10];
    L180:
        if (r68 != null) goto L185;
        if (r114 == r14) goto L185;
    L224:
        if (r114.B() != 8) goto L227;
        r114 = r67;
    L227:
        r67 = r114;
        r114 = r68;
    L185:
        d r69 = r114.f34748J[r41];
        com.obric.oui.constraintlayout.a.h r70 = r69.f;
        if (r69.f34739c == null) goto L188;
        com.obric.oui.constraintlayout.a.h r71 = r69.f34739c.f;
    L189:
        if (r67 == r114) goto L191;
        r71 = r67.f34748J[r41 + 1].f;
    L196:
        int r72 = r69.i();
        int r73 = r41 + 1;
        int r74 = r114.f34748J[r73].i();
        if (r68 == null) goto L200;
        d r75 = r68.f34748J[r41];
        com.obric.oui.constraintlayout.a.h r76 = r75.f;
    L204:
        com.obric.oui.constraintlayout.a.h r77 = r114.f34748J[r73].f;
        if (r75 == null) goto L207;
        r74 = r74 + r75.i();
    L207:
        int r78 = r72 + r67.f34748J[r73].i();
        if (r70 == null) goto L224;
        if (r71 == null) goto L224;
        if (r76 == null) goto L224;
        if (r77 == null) goto L224;
        if (r114 != r13) goto L214;
        r78 = r13.f34748J[r41].i();
    L214:
        int r79 = r78;
        if (r114 != r14) goto L217;
        int r115 = r14.f34748J[r73].i();
    L218:
        if (r113 == false) goto L220;
        int r116 = 8;
    L221:
        r68 = r68;
        r39.a(r70, r71, r79, 0.5f, r76, r77, r115, r116);
        goto L224
    L220:
        r116 = 5;
        goto L221
    L217:
        r115 = r74;
        goto L218
    L200:
        r75 = r12.f34748J[r73].f34739c;
        if (r75 == null) goto L203;
        r76 = r75.f;
        goto L204
    L203:
        r76 = null;
        goto L204
    L191:
        if (r114 != r13) goto L196;
        if (r212.f34748J[r41].f34739c == null) goto L195;
        r71 = r212.f34748J[r41].f34739c.f;
        goto L196
    L195:
        r71 = null;
        goto L196
    L188:
        r71 = null;
        goto L189
    L169:
        if (r42.i != r42.j) goto L171;
        r113 = true;
    L228:
        int r80 = 8;
        if (r17 == false) goto L295;
        if (r13 == null) goto L295;
        if (r42.j > 0) goto L234;
    L236:
        boolean r117 = false;
    L237:
        e r81 = r13;
        e r118 = r81;
    L238:
        if (r118 == null) goto L284;
        e r82 = r118.au[r10];
    L240:
        if (r82 == null) goto L244;
        if (r82.B() != r80) goto L244;
        r82 = r82.au[r10];
    L244:
        if (r118 == r13) goto L278;
        if (r118 == r14) goto L278;
        if (r82 == null) goto L278;
        if (r82 != r14) goto L249;
        e r83 = null;
    L250:
        d r84 = r118.f34748J[r41];
        com.obric.oui.constraintlayout.a.h r85 = r84.f;
        if (r84.f34739c == null) goto L253;
        com.obric.oui.constraintlayout.a.h r86 = r84.f34739c.f;
    L253:
        int r87 = r41 + 1;
        com.obric.oui.constraintlayout.a.h r88 = r81.f34748J[r87].f;
        int r89 = r84.i();
        int r90 = r118.f34748J[r87].i();
        if (r83 == null) goto L260;
        d r91 = r83.f34748J[r41];
        com.obric.oui.constraintlayout.a.h r92 = r91.f;
        if (r91.f34739c == null) goto L258;
        com.obric.oui.constraintlayout.a.h r93 = r91.f34739c.f;
    L259:
        com.obric.oui.constraintlayout.a.h r94 = r93;
        com.obric.oui.constraintlayout.a.h r95 = r92;
    L265:
        if (r91 == null) goto L267;
        r90 = r90 + r91.i();
    L267:
        int r119 = r90;
        int r96 = r81.f34748J[r87].i() + r89;
        if (r117 == false) goto L270;
        int r120 = 8;
    L271:
        if (r85 == null) goto L276;
        if (r88 == null) goto L276;
        if (r95 == null) goto L276;
        if (r94 == null) goto L276;
        int r121 = 8;
        r39.a(r85, r88, r96, 0.5f, r95, r94, r119, r120);
    L277:
        r82 = r83;
    L280:
        if (r118.B() == r121) goto L282;
        r81 = r118;
    L283:
        r118 = r82;
        r80 = r121;
        r10 = r40;
        goto L238
    L282:
        r81 = r81;
    L276:
        r121 = 8;
        goto L277
    L270:
        r120 = 4;
        goto L271
    L258:
        r93 = null;
        goto L259
    L260:
        r91 = r14.f34748J[r41];
        if (r91 == null) goto L263;
        r95 = r91.f;
    L264:
        r94 = r118.f34748J[r87].f;
        goto L265
    L263:
        r95 = null;
        goto L264
    L249:
        r83 = r82;
    L278:
        r81 = r81;
        r121 = r80;
        goto L280
    L284:
        d r97 = r13.f34748J[r41];
        d r98 = r212.f34748J[r41].f34739c;
        int r99 = r41 + 1;
        d r122 = r14.f34748J[r99];
        d r123 = r12.f34748J[r99].f34739c;
        if (r98 == null) goto L291;
        if (r13 == r14) goto L288;
        int r124 = 5;
        r39.c(r97.f, r98.f, r97.i(), 5);
    L292:
        if (r123 == null) goto L295;
        if (r13 == r14) goto L295;
        r39.c(r122.f, r123.f, -r122.i(), r124);
        goto L295
    L288:
        r124 = 5;
        if (r123 == null) goto L292;
        r39.a(r97.f, r98.f, r97.i(), 0.5f, r122.f, r123.f, r122.i(), 5);
        goto L292
    L291:
        r124 = 5;
        goto L292
    L234:
        if (r42.i != r42.j) goto L236;
        r117 = true;
    L29:
        r7 = true;
        goto L31
    L15:
        r15 = false;
        goto L17
    L11:
        r8 = false;
        goto L13
    L20:
        if (r2.ap != 0) goto L22;
        r8 = true;
    L24:
        if (r2.ap != 1) goto L26;
        r15 = true;
    L28:
        if (r2.ap != 2) goto L30;
    L26:
        r15 = false;
        goto L28
    L22:
        r8 = false;
        goto L24
    L5:
        r6 = false;
        goto L7
    }
}
