package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r38v0, types: [androidx.constraintlayout.core.LinearSystem] */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28, types: [androidx.constraintlayout.core.SolverVariable] */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v39 */
    /* JADX WARN: Type inference failed for: r8v37 */
    /* JADX WARN: Type inference failed for: r8v38 */
    /* JADX WARN: Type inference failed for: r8v43 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    public static void a(ConstraintWidgetContainer r37, LinearSystem r38, int r39, int r40, c r41) {
        int r10 = r39;
        ConstraintWidget r11 = r41.f1595a;
        ConstraintWidget r12 = r41.f1597c;
        ConstraintWidget r13 = r41.f1596b;
        ConstraintWidget r14 = r41.f1598d;
        ConstraintWidget r15 = r41.f1599e;
        float r16 = r41.f1605k;
        if (r37.f1435b0[r10] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L5;
        boolean r17 = true;
    L7:
        if (r10 != 0) goto L19;
        int r18 = r15.J0;
        if (r18 != 0) goto L11;
        boolean r19 = true;
    L12:
        if (r18 != 1) goto L14;
        boolean r110 = true;
    L15:
        if (r18 != 2) goto L17;
    L16:
        boolean r20 = true;
    L18:
        boolean r111 = r110;
        boolean r21 = false;
        boolean r112 = r19;
        ?? r22 = r11;
    L28:
        Object r23 = null;
        if (r21 == true) goto L86;
        ConstraintAnchor r24 = r22.Y[r40];
        if (r20 == false) goto L33;
        int r113 = 1;
    L34:
        int r25 = r24.f();
        ConstraintWidget.DimensionBehaviour r114 = r22.f1435b0[r10];
        float r26 = r16;
        ConstraintWidget.DimensionBehaviour r27 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r114 == r27) goto L37;
    L39:
        boolean r115 = false;
    L40:
        ConstraintAnchor r28 = r24.f1426f;
        if (r28 == null) goto L44;
        if (r22 == r11) goto L44;
        r25 = r25 + r28.f();
    L44:
        int r29 = r25;
        if (r20 == false) goto L50;
        if (r22 == r11) goto L50;
        if (r22 == r13) goto L50;
        r113 = 8;
    L50:
        ConstraintAnchor r30 = r24.f1426f;
        if (r30 == null) goto L65;
        if (r22 != r13) goto L54;
        r38.h(r24.f1429i, r30.f1429i, r29, 6);
    L55:
        if (r115 == false) goto L58;
        if (r20 == true) goto L58;
        r113 = 5;
    L58:
        if (r22 != r13) goto L63;
        if (r20 == false) goto L63;
        if (r22.g0(r10) == false) goto L63;
        int r31 = 5;
    L64:
        r38.e(r24.f1429i, r24.f1426f.f1429i, r29, r31);
    L66:
        if (r17 == true) goto L68;
    L74:
        ConstraintAnchor r32 = r22.Y[r40 + 1].f1426f;
        if (r32 == null) goto L82;
        ConstraintWidget r33 = r32.f1424d;
        ConstraintAnchor r34 = r33.Y[r40].f1426f;
        if (r34 == null) goto L82;
        if (r34.f1424d != r22) goto L82;
        r23 = r33;
    L82:
        if (r23 == null) goto L84;
        r22 = r23;
        r21 = r21;
    L85:
        r15 = r15;
        r16 = r26;
        r11 = r11;
        r22 = r22;
        goto L28
    L84:
        r21 = true;
        goto L85
    L68:
        if (r22.U() != 8) goto L70;
    L72:
        int r35 = 0;
    L73:
        r38.h(r22.Y[r40].f1429i, r37.Y[r40].f1429i, r35, 8);
        goto L74
    L70:
        if (r22.f1435b0[r10] != r27) goto L72;
        ConstraintAnchor[] r36 = r22.Y;
        r35 = 0;
        r38.h(r36[r40 + 1].f1429i, r36[r40].f1429i, 0, 5);
    L63:
        r31 = r113;
        goto L64
    L54:
        r38.h(r24.f1429i, r30.f1429i, r29, 8);
        goto L55
    L65:
        r11 = r11;
        goto L66
    L37:
        if (r22.f1480y[r10] != 0) goto L39;
        r115 = true;
        goto L40
    L33:
        r113 = 4;
        goto L34
    L86:
        ConstraintWidget r210 = r15;
        float r211 = r16;
        ConstraintWidget r212 = r11;
        if (r14 == null) goto L105;
        int r42 = r40 + 1;
        if (r12.Y[r42].f1426f == null) goto L105;
        ConstraintAnchor r43 = r14.Y[r42];
        if (r14.f1435b0[r10] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L99;
        if (r14.f1480y[r10] != 0) goto L99;
        if (r20 == true) goto L99;
        ConstraintAnchor r44 = r43.f1426f;
        if (r44.f1424d != r37) goto L99;
        r38.e(r43.f1429i, r44.f1429i, -r43.f(), 5);
    L103:
        r38.j(r43.f1429i, r12.Y[r42].f1426f.f1429i, -r43.f(), 6);
    L99:
        if (r20 == false) goto L103;
        ConstraintAnchor r45 = r43.f1426f;
        if (r45.f1424d != r37) goto L103;
        r38.e(r43.f1429i, r45.f1429i, -r43.f(), 4);
    L105:
        if (r17 == false) goto L107;
        int r46 = r40 + 1;
        SolverVariable r47 = r37.Y[r46].f1429i;
        ConstraintAnchor r48 = r12.Y[r46];
        r38.h(r47, r48.f1429i, r48.f(), 8);
    L107:
        ArrayList r49 = r41.f1602h;
        if (r49 == null) goto L137;
        int r50 = r49.size();
        if (r50 <= 1) goto L137;
        if (r41.f1612r == true) goto L114;
    L116:
        float r51 = r211;
    L117:
        float r52 = 0.0f;
        float r213 = 0.0f;
        ConstraintWidget r53 = null;
        int r54 = 0;
    L118:
        if (r54 >= r50) goto L137;
        ConstraintWidget r116 = (ConstraintWidget) r49.get(r54);
        float r117 = r116.N0[r10];
        if (r117 >= r52) goto L128;
        if (r41.f1614t == false) goto L124;
        ConstraintAnchor[] r118 = r116.Y;
        r38.e(r118[r40 + 1].f1429i, r118[r40].f1429i, 0, 4);
    L130:
        r49 = r49;
        r50 = r50;
    L136:
        r54 = r54 + 1;
        r50 = r50;
        r49 = r49;
        r52 = 0.0f;
        goto L118
    L124:
        r117 = 1.0f;
    L128:
        if (r117 != 0.0f) goto L132;
        ConstraintAnchor[] r119 = r116.Y;
        r38.e(r119[r40 + 1].f1429i, r119[r40].f1429i, 0, 8);
        goto L130
    L132:
        if (r53 == null) goto L135;
        ConstraintAnchor[] r55 = r53.Y;
        SolverVariable r56 = r55[r40].f1429i;
        int r120 = r40 + 1;
        SolverVariable r57 = r55[r120].f1429i;
        ConstraintAnchor[] r58 = r116.Y;
        SolverVariable r59 = r58[r40].f1429i;
        SolverVariable r60 = r58[r120].f1429i;
        ArrayRow r61 = r38.r();
        r61.i(r213, r51, r117, r56, r57, r59, r60);
        r38.d(r61);
    L135:
        r53 = r116;
        r213 = r117;
        goto L136
    L114:
        if (r41.f1614t == true) goto L116;
        r51 = r41.f1604j;
    L137:
        if (r13 == null) goto L160;
        if (r13 == r14) goto L142;
        if (r20 == false) goto L160;
    L142:
        ConstraintAnchor r62 = r212.Y[r40];
        int r63 = r40 + 1;
        ConstraintAnchor r64 = r12.Y[r63];
        ConstraintAnchor r65 = r62.f1426f;
        if (r65 == null) goto L145;
        SolverVariable r66 = r65.f1429i;
    L146:
        ConstraintAnchor r67 = r64.f1426f;
        if (r67 == null) goto L149;
        SolverVariable r68 = r67.f1429i;
    L150:
        ConstraintAnchor r69 = r13.Y[r40];
        if (r14 == null) goto L153;
        r64 = r14.Y[r63];
    L153:
        if (r66 == null) goto L289;
        if (r68 == null) goto L289;
        if (r10 != 0) goto L158;
        float r70 = r210.f1465q0;
    L157:
        float r71 = r70;
        SolverVariable r72 = r66;
        r38.c(r69.f1429i, r72, r69.f(), r71, r68, r64.f1429i, r64.f(), 7);
        goto L289
    L158:
        r70 = r210.f1467r0;
    L289:
        if (r112 == true) goto L291;
        if (r111 == true) goto L291;
        return;
    L291:
        if (r13 == null) goto L332;
        if (r13 == r14) goto L333;
        ConstraintAnchor[] r73 = r13.Y;
        ConstraintAnchor r74 = r73[r40];
        if (r14 != null) goto L296;
        r14 = r13;
    L296:
        int r75 = r40 + 1;
        ConstraintAnchor r76 = r14.Y[r75];
        ConstraintAnchor r77 = r74.f1426f;
        if (r77 == null) goto L299;
        SolverVariable r78 = r77.f1429i;
    L300:
        ConstraintAnchor r79 = r76.f1426f;
        if (r79 == null) goto L303;
        ?? r80 = r79.f1429i;
    L304:
        if (r12 == r14) goto L309;
        ConstraintAnchor r81 = r12.Y[r75].f1426f;
        if (r81 == null) goto L308;
        r23 = r81.f1429i;
    L308:
        r80 = r23;
    L309:
        if (r13 != r14) goto L311;
        r76 = r73[r75];
    L311:
        if (r78 == null) goto L334;
        if (r80 == 0) goto L335;
        int r82 = r74.f();
        int r83 = r14.Y[r75].f();
        r38.c(r74.f1429i, r78, r82, 0.5f, r80, r76.f1429i, r83, 5);
        return;
    L335:
        return;
    L334:
        return;
    L303:
        r80 = 0;
        goto L304
    L299:
        r78 = null;
        goto L300
    L333:
        return;
    L332:
        return;
    L149:
        r68 = null;
        goto L150
    L145:
        r66 = null;
    L160:
        if (r112 == false) goto L224;
        if (r13 == null) goto L224;
        int r84 = r41.f1604j;
        if (r84 > 0) goto L165;
    L167:
        boolean r214 = false;
    L168:
        ConstraintWidget r85 = r13;
        ConstraintWidget r121 = r85;
    L169:
        if (r121 == null) goto L289;
        ConstraintWidget r86 = r121.P0[r10];
    L171:
        if (r86 == null) goto L176;
        if (r86.U() != 8) goto L176;
        r86 = r86.P0[r10];
    L176:
        if (r86 != null) goto L181;
        if (r121 == r14) goto L181;
    L220:
        if (r121.U() != 8) goto L223;
        r121 = r85;
    L223:
        r85 = r121;
        r121 = r86;
    L181:
        ConstraintAnchor r87 = r121.Y[r40];
        SolverVariable r88 = r87.f1429i;
        ConstraintAnchor r89 = r87.f1426f;
        if (r89 == null) goto L184;
        SolverVariable r90 = r89.f1429i;
    L185:
        if (r85 == r121) goto L187;
        r90 = r85.Y[r40 + 1].f1429i;
    L192:
        int r91 = r87.f();
        int r92 = r40 + 1;
        int r93 = r121.Y[r92].f();
        if (r86 == null) goto L196;
        ConstraintAnchor r94 = r86.Y[r40];
        SolverVariable r95 = r94.f1429i;
    L200:
        SolverVariable r96 = r121.Y[r92].f1429i;
        if (r94 == null) goto L203;
        r93 = r93 + r94.f();
    L203:
        int r97 = r91 + r85.Y[r92].f();
        if (r88 == null) goto L220;
        if (r90 == null) goto L220;
        if (r95 == null) goto L220;
        if (r96 == null) goto L220;
        if (r121 != r13) goto L210;
        r97 = r13.Y[r40].f();
    L210:
        int r98 = r97;
        if (r121 != r14) goto L213;
        int r122 = r14.Y[r92].f();
    L214:
        if (r214 == false) goto L216;
        int r123 = 8;
    L217:
        r86 = r86;
        r38.c(r88, r90, r98, 0.5f, r95, r96, r122, r123);
        goto L220
    L216:
        r123 = 5;
        goto L217
    L213:
        r122 = r93;
        goto L214
    L196:
        r94 = r12.Y[r92].f1426f;
        if (r94 == null) goto L199;
        r95 = r94.f1429i;
        goto L200
    L199:
        r95 = null;
        goto L200
    L187:
        if (r121 != r13) goto L192;
        ConstraintAnchor r99 = r212.Y[r40].f1426f;
        if (r99 == null) goto L191;
        r90 = r99.f1429i;
        goto L192
    L191:
        r90 = null;
        goto L192
    L184:
        r90 = null;
        goto L185
    L165:
        if (r41.f1603i != r84) goto L167;
        r214 = true;
    L224:
        int r100 = 8;
        if (r111 == false) goto L289;
        if (r13 == null) goto L289;
        int r101 = r41.f1604j;
        if (r101 > 0) goto L230;
    L232:
        boolean r215 = false;
    L233:
        ConstraintWidget r102 = r13;
        ConstraintWidget r124 = r102;
    L234:
        if (r124 == null) goto L280;
        ConstraintWidget r103 = r124.P0[r10];
    L236:
        if (r103 == null) goto L240;
        if (r103.U() != r100) goto L240;
        r103 = r103.P0[r10];
    L240:
        if (r124 == r13) goto L274;
        if (r124 == r14) goto L274;
        if (r103 == null) goto L274;
        if (r103 != r14) goto L245;
        ConstraintWidget r104 = null;
    L246:
        ConstraintAnchor r105 = r124.Y[r40];
        SolverVariable r106 = r105.f1429i;
        ConstraintAnchor r107 = r105.f1426f;
        if (r107 == null) goto L249;
        SolverVariable r108 = r107.f1429i;
    L249:
        int r109 = r40 + 1;
        SolverVariable r125 = r102.Y[r109].f1429i;
        int r126 = r105.f();
        int r127 = r124.Y[r109].f();
        if (r104 == null) goto L256;
        ConstraintAnchor r128 = r104.Y[r40];
        SolverVariable r129 = r128.f1429i;
        ConstraintAnchor r130 = r128.f1426f;
        if (r130 == null) goto L254;
        SolverVariable r131 = r130.f1429i;
    L255:
        SolverVariable r132 = r131;
        SolverVariable r133 = r129;
    L261:
        if (r128 == null) goto L263;
        r127 = r127 + r128.f();
    L263:
        int r134 = r127;
        int r135 = r102.Y[r109].f() + r126;
        if (r215 == false) goto L266;
        int r216 = 8;
    L267:
        if (r106 == null) goto L272;
        if (r125 == null) goto L272;
        if (r133 == null) goto L272;
        if (r132 == null) goto L272;
        int r136 = 8;
        r38.c(r106, r125, r135, 0.5f, r133, r132, r134, r216);
    L273:
        r103 = r104;
    L276:
        if (r124.U() == r136) goto L278;
        r102 = r124;
    L279:
        r124 = r103;
        r100 = r136;
        r10 = r39;
        goto L234
    L278:
        r102 = r102;
    L272:
        r136 = 8;
        goto L273
    L266:
        r216 = 4;
        goto L267
    L254:
        r131 = null;
        goto L255
    L256:
        r128 = r14.Y[r40];
        if (r128 == null) goto L259;
        r133 = r128.f1429i;
    L260:
        r132 = r124.Y[r109].f1429i;
        goto L261
    L259:
        r133 = null;
        goto L260
    L245:
        r104 = r103;
    L274:
        r102 = r102;
        r136 = r100;
        goto L276
    L280:
        ConstraintAnchor r137 = r13.Y[r40];
        ConstraintAnchor r138 = r212.Y[r40].f1426f;
        int r139 = r40 + 1;
        ConstraintAnchor r140 = r14.Y[r139];
        ConstraintAnchor r141 = r12.Y[r139].f1426f;
        if (r138 == null) goto L286;
        if (r13 == r14) goto L284;
        r38.e(r137.f1429i, r138.f1429i, r137.f(), 5);
        goto L286
    L284:
        if (r141 == null) goto L286;
        r38.c(r137.f1429i, r138.f1429i, r137.f(), 0.5f, r140.f1429i, r141.f1429i, r140.f(), 5);
    L286:
        if (r141 == null) goto L289;
        if (r13 == r14) goto L289;
        r38.e(r140.f1429i, r141.f1429i, -r140.f(), 5);
        goto L289
    L230:
        if (r41.f1603i != r101) goto L232;
        r215 = true;
    L17:
        r20 = false;
        goto L18
    L14:
        r110 = false;
        goto L15
    L11:
        r19 = false;
        goto L12
    L19:
        int r142 = r15.K0;
        if (r142 != 0) goto L22;
        r19 = true;
    L23:
        if (r142 != 1) goto L25;
        r110 = true;
    L26:
        if (r142 != 2) goto L17;
    L25:
        r110 = false;
        goto L26
    L22:
        r19 = false;
        goto L23
    L5:
        r17 = false;
        goto L7
    }

    public static void b(ConstraintWidgetContainer r10, LinearSystem r11, ArrayList r12, int r13) {
        int r14 = 0;
        if (r13 != 0) goto L5;
        int r15 = r10.f1493h1;
        c[] r16 = r10.f1496k1;
        int r17 = 0;
    L6:
        if (r14 >= r15) goto L13;
        c r18 = r16[r14];
        r18.a();
        if (r12 != null) goto L10;
    L11:
        a(r10, r11, r13, r17, r18);
    L12:
        r14 = r14 + 1;
        goto L6
    L10:
        if (r12.contains(r18.f1595a) == false) goto L12;
    L13:
        return;
    L5:
        r15 = r10.f1494i1;
        r16 = r10.f1495j1;
        r17 = 2;
        goto L6
    }
}
