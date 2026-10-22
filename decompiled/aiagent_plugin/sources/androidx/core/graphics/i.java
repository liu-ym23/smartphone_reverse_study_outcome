package androidx.core.graphics;

import android.graphics.Path;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: PathParser.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: compiled from: PathParser.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f1216b;

        a() {
        }
    }

    /* JADX INFO: compiled from: PathParser.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public char f1217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float[] f1218b;

        b(char r1, float[] r2) {
            this.f1217a = r1;
            this.f1218b = r2;
        }

        b(b r3) {
            this.f1217a = r3.f1217a;
            float[] r4 = r3.f1218b;
            this.f1218b = i.a(r4, 0, r4.length);
        }

        public static void a(b[] r5, Path r6) {
            float[] r0 = new float[6];
            char r1 = 'm';
            int r2 = 0;
        L4:
            if (r2 >= r5.length) goto L6;
            a(r6, r0, r1, r5[r2].f1217a, r5[r2].f1218b);
            r1 = r5[r2].f1217a;
            r2 = r2 + 1;
            goto L4
        }

        public void a(b r5, b r6, float r7) {
            this.f1217a = r5.f1217a;
            int r0 = 0;
        L3:
            float[] r1 = r5.f1218b;
            if (r0 >= r1.length) goto L6;
            this.f1218b[r0] = (r1[r0] * (1.0f - r7)) + (r6.f1218b[r0] * r7);
            r0 = r0 + 1;
            goto L3
        }

        private static void a(Path r25, float[] r26, char r27, char r28, float[] r29) {
            char r11 = r28;
            boolean r13 = false;
            float r0 = r26[0];
            float r1 = r26[1];
            float r2 = r26[2];
            float r3 = r26[3];
            float r4 = r26[4];
            float r5 = r26[5];
            switch(r11) {
                case 65: goto L9;
                case 67: goto L8;
                case 72: goto L7;
                case 76: goto L4;
                case 77: goto L4;
                case 81: goto L6;
                case 83: goto L6;
                case 84: goto L4;
                case 86: goto L7;
                case 90: goto L5;
                case 97: goto L9;
                case 99: goto L8;
                case 104: goto L7;
                case 108: goto L4;
                case 109: goto L4;
                case 113: goto L6;
                case 115: goto L6;
                case 116: goto L4;
                case 118: goto L7;
                case 122: goto L5;
                default: goto L4;
            };
        L4:
            int r19 = 2;
        L11:
            float r9 = r0;
            float r8 = r1;
            float r20 = r4;
            float r21 = r5;
            int r7 = 0;
            char r6 = r27;
        L13:
            if (r7 >= r29.length) goto L123;
            if (r11 != 'A') goto L17;
            int r24 = r7;
            float r15 = r8;
            float r12 = r9;
            int r14 = r24 + 5;
            float r10 = r29[r14];
            int r16 = r24 + 6;
            float r17 = r29[r16];
            float r18 = r29[r24 + 0];
            float r22 = r29[r24 + 1];
            float r23 = r29[r24 + 2];
            if (r29[r24 + 3] == 0.0f) goto L115;
            boolean r30 = true;
        L117:
            if (r29[r24 + 4] == 0.0f) goto L119;
            boolean r31 = true;
        L120:
            a(r25, r12, r15, r10, r17, r18, r22, r23, r30, r31);
            r9 = r29[r14];
            r8 = r29[r16];
        L121:
            r3 = r8;
            r2 = r9;
        L122:
            r7 = r24 + r19;
            r6 = r28;
            r11 = r6;
            r13 = false;
            goto L13
        L119:
            r31 = false;
            goto L120
        L115:
            r30 = false;
            goto L117
        L17:
            if (r11 != 'C') goto L19;
            r24 = r7;
            int r32 = r24 + 2;
            int r33 = r24 + 3;
            int r34 = r24 + 4;
            int r110 = r24 + 5;
            r25.cubicTo(r29[r24 + 0], r29[r24 + 1], r29[r32], r29[r33], r29[r34], r29[r110]);
            r9 = r29[r34];
            float r35 = r29[r110];
            float r36 = r29[r32];
            float r37 = r29[r33];
            r8 = r35;
            r3 = r37;
            r2 = r36;
            goto L122
        L19:
            if (r11 != 'H') goto L21;
            r24 = r7;
            int r38 = r24 + 0;
            r25.lineTo(r29[r38], r8);
            r9 = r29[r38];
            goto L122
        L21:
            if (r11 != 'Q') goto L23;
            r24 = r7;
            int r39 = r24 + 0;
            int r40 = r24 + 1;
            int r41 = r24 + 2;
            int r42 = r24 + 3;
            r25.quadTo(r29[r39], r29[r40], r29[r41], r29[r42]);
            float r43 = r29[r39];
            float r44 = r29[r40];
            r9 = r29[r41];
            r8 = r29[r42];
            r2 = r43;
            r3 = r44;
            goto L122
        L23:
            if (r11 != 'V') goto L25;
            r24 = r7;
            int r45 = r24 + 0;
            r25.lineTo(r9, r29[r45]);
            r8 = r29[r45];
            goto L122
        L25:
            if (r11 != 'a') goto L27;
            int r111 = r7 + 5;
            float r46 = r29[r111] + r9;
            int r112 = r7 + 6;
            float r47 = r29[r112] + r8;
            float r48 = r29[r7 + 0];
            float r49 = r29[r7 + 1];
            float r113 = r29[r7 + 2];
            if (r29[r7 + 3] == 0.0f) goto L102;
            boolean r210 = true;
        L104:
            if (r29[r7 + 4] == 0.0f) goto L106;
            boolean r211 = true;
        L107:
            r24 = r7;
            a(r25, r9, r8, r46, r47, r48, r49, r113, r210, r211);
            r9 = r9 + r29[r111];
            r8 = r8 + r29[r112];
            goto L121
        L106:
            r211 = false;
            goto L107
        L102:
            r210 = false;
            goto L104
        L27:
            if (r11 != 'c') goto L29;
            int r114 = r7 + 2;
            int r115 = r7 + 3;
            int r116 = r7 + 4;
            int r212 = r7 + 5;
            r25.rCubicTo(r29[r7 + 0], r29[r7 + 1], r29[r114], r29[r115], r29[r116], r29[r212]);
            float r50 = r29[r114] + r9;
            float r51 = r29[r115] + r8;
            r9 = r9 + r29[r116];
            float r52 = r29[r212];
        L97:
            r8 = r8 + r52;
        L98:
            r2 = r50;
            r3 = r51;
        L48:
            r24 = r7;
            goto L122
        L29:
            if (r11 != 'h') goto L31;
            int r53 = r7 + 0;
            r25.rLineTo(r29[r53], 0.0f);
            r9 = r9 + r29[r53];
            goto L48
        L31:
            if (r11 != 'q') goto L33;
            int r54 = r7 + 0;
            int r55 = r7 + 1;
            int r56 = r7 + 2;
            int r57 = r7 + 3;
            r25.rQuadTo(r29[r54], r29[r55], r29[r56], r29[r57]);
            r50 = r29[r54] + r9;
            r51 = r29[r55] + r8;
            r9 = r9 + r29[r56];
            r52 = r29[r57];
            goto L97
        L33:
            if (r11 != 'v') goto L35;
            int r58 = r7 + 0;
            r25.rLineTo(0.0f, r29[r58]);
            float r59 = r29[r58];
        L72:
            r8 = r8 + r59;
            goto L48
        L35:
            if (r11 != 'L') goto L37;
            int r60 = r7 + 0;
            int r61 = r7 + 1;
            r25.lineTo(r29[r60], r29[r61]);
            r9 = r29[r60];
            r8 = r29[r61];
            goto L48
        L37:
            if (r11 != 'M') goto L39;
            int r62 = r7 + 0;
            r9 = r29[r62];
            int r63 = r7 + 1;
            r8 = r29[r63];
            if (r7 <= 0) goto L90;
            r25.lineTo(r29[r62], r29[r63]);
            goto L48
        L90:
            r25.moveTo(r29[r62], r29[r63]);
        L91:
            r24 = r7;
            r21 = r8;
            r20 = r9;
            goto L122
        L39:
            if (r11 != 'S') goto L41;
            if (r6 == 'c') goto L85;
            if (r6 == 's') goto L85;
            if (r6 == 'C') goto L85;
            if (r6 == 'S') goto L85;
        L86:
            float r64 = r8;
            int r65 = r7 + 0;
            int r66 = r7 + 1;
            int r117 = r7 + 2;
            int r118 = r7 + 3;
            r25.cubicTo(r9, r64, r29[r65], r29[r66], r29[r117], r29[r118]);
            r50 = r29[r65];
            r51 = r29[r66];
            r9 = r29[r117];
            r8 = r29[r118];
        L85:
            r9 = (r9 * 2.0f) - r2;
            r8 = (r8 * 2.0f) - r3;
            goto L86
        L41:
            if (r11 != 'T') goto L43;
            if (r6 == 'q') goto L77;
            if (r6 == 't') goto L77;
            if (r6 == 'Q') goto L77;
            if (r6 == 'T') goto L77;
        L78:
            int r67 = r7 + 0;
            int r68 = r7 + 1;
            r25.quadTo(r9, r8, r29[r67], r29[r68]);
            float r69 = r29[r67];
            float r70 = r29[r68];
            r24 = r7;
            r3 = r8;
            r2 = r9;
            r9 = r69;
            r8 = r70;
        L77:
            r9 = (r9 * 2.0f) - r2;
            r8 = (r8 * 2.0f) - r3;
            goto L78
        L43:
            if (r11 != 'l') goto L45;
            int r71 = r7 + 0;
            int r72 = r7 + 1;
            r25.rLineTo(r29[r71], r29[r72]);
            r9 = r9 + r29[r71];
            r59 = r29[r72];
            goto L72
        L45:
            if (r11 == 'm') goto L67;
            if (r11 == 's') goto L57;
            if (r11 != 't') goto L48;
            if (r6 == 'q') goto L55;
            if (r6 == 't') goto L55;
            if (r6 == 'Q') goto L55;
            if (r6 == 'T') goto L55;
            float r73 = 0.0f;
            float r74 = 0.0f;
        L56:
            int r75 = r7 + 0;
            int r76 = r7 + 1;
            r25.rQuadTo(r74, r73, r29[r75], r29[r76]);
            float r77 = r74 + r9;
            float r78 = r73 + r8;
            r9 = r9 + r29[r75];
            r8 = r8 + r29[r76];
            r3 = r78;
            r2 = r77;
        L55:
            r74 = r9 - r2;
            r73 = r8 - r3;
            goto L56
        L57:
            if (r6 == 'c') goto L65;
            if (r6 == 's') goto L65;
            if (r6 == 'C') goto L65;
            if (r6 == 'S') goto L65;
            float r79 = 0.0f;
            float r80 = 0.0f;
        L66:
            int r119 = r7 + 0;
            int r120 = r7 + 1;
            int r121 = r7 + 2;
            int r213 = r7 + 3;
            r25.rCubicTo(r79, r80, r29[r119], r29[r120], r29[r121], r29[r213]);
            r50 = r29[r119] + r9;
            r51 = r29[r120] + r8;
            r9 = r9 + r29[r121];
            r52 = r29[r213];
        L65:
            float r81 = r9 - r2;
            r80 = r8 - r3;
            r79 = r81;
            goto L66
        L67:
            int r82 = r7 + 0;
            r9 = r9 + r29[r82];
            int r83 = r7 + 1;
            r8 = r8 + r29[r83];
            if (r7 <= 0) goto L70;
            r25.rLineTo(r29[r82], r29[r83]);
            goto L48
        L70:
            r25.rMoveTo(r29[r82], r29[r83]);
            goto L91
        L123:
            r26[r13 ? 1 : 0] = r9;
            r26[1] = r8;
            r26[2] = r2;
            r26[3] = r3;
            r26[4] = r20;
            r26[5] = r21;
            return;
        L5:
            r25.close();
            r25.moveTo(r4, r5);
            r0 = r4;
            r2 = r0;
            r1 = r5;
            r3 = r1;
            goto L4
        L6:
            r19 = 4;
            goto L11
        L7:
            r19 = 1;
            goto L11
        L8:
            int r84 = 6;
        L10:
            r19 = r84;
            goto L11
        L9:
            r84 = 7;
            goto L10
        }

        private static void a(Path r41, float r42, float r43, float r44, float r45, float r46, float r47, float r48, boolean r49, boolean r50) {
            double r19 = Math.toRadians(r48);
            double r4 = Math.cos(r19);
            double r10 = Math.sin(r19);
            double r13 = r42;
            double r15 = r13 * r4;
            double r14 = r43;
            double r6 = r46;
            double r16 = (r15 + (r14 * r10)) / r6;
            double r8 = (((double) (-r42)) * r10) + (r14 * r4);
            double r17 = r47;
            double r9 = r8 / r17;
            double r11 = r45;
            double r1 = ((((double) r44) * r4) + (r11 * r10)) / r6;
            double r7 = ((((double) (-r44)) * r10) + (r11 * r4)) / r17;
            double r12 = r16 - r1;
            double r27 = r9 - r7;
            double r29 = (r16 + r1) / 2.0d;
            double r33 = (r9 + r7) / 2.0d;
            double r18 = (r12 * r12) + (r27 * r27);
            if (r18 != 0.0d) goto L6;
            a("PathParser", " Points are coincident");
            return;
        L6:
            double r35 = (1.0d / r18) - 0.25d;
            if (r35 >= 0.0d) goto L10;
            a("PathParser", "Points are too far apart " + r18);
            float r2 = (float) (Math.sqrt(r18) / 1.99999d);
            a(r41, r42, r43, r44, r45, r46 * r2, r47 * r2, r48, r49, r50);
            return;
        L10:
            double r110 = Math.sqrt(r35);
            double r20 = r12 * r110;
            double r111 = r110 * r27;
            if (r49 != r50) goto L13;
            double r210 = r29 - r111;
            double r34 = r33 + r20;
        L14:
            double r23 = Math.atan2(r9 - r34, r16 - r210);
            double r0 = Math.atan2(r7 - r34, r1 - r210) - r23;
            if (r0 < 0.0d) goto L17;
            boolean r21 = true;
        L18:
            if (r50 != r21) goto L20;
        L23:
            double r211 = r210 * r6;
            double r36 = r34 * r17;
            a(r41, (r211 * r4) - (r36 * r10), (r211 * r10) + (r36 * r4), r6, r17, r13, r14, r19, r23, r0);
            return;
        L20:
            if (r0 <= 0.0d) goto L22;
            r0 = r0 - 6.283185307179586d;
            goto L23
        L22:
            r0 = r0 + 6.283185307179586d;
            goto L23
        L17:
            r21 = false;
            goto L18
        L13:
            r210 = r29 + r111;
            r34 = r33 - r20;
            goto L14
        }

        private static void a(Path r49, double r50, double r52, double r54, double r56, double r58, double r60, double r62, double r64, double r66) {
            double r0 = r54;
            int r4 = (int) Math.ceil(Math.abs((r66 * 4.0d) / 3.141592653589793d));
            double r5 = Math.cos(r62);
            double r7 = Math.sin(r62);
            double r9 = Math.cos(r64);
            double r11 = Math.sin(r64);
            double r13 = -r0;
            double r15 = r13 * r5;
            double r19 = r56 * r7;
            double r17 = (r15 * r11) - (r19 * r9);
            double r14 = r13 * r7;
            double r21 = r56 * r5;
            double r12 = (r11 * r14) + (r9 * r21);
            double r10 = r66 / ((double) r4);
            double r25 = r12;
            double r27 = r17;
            int r2 = 0;
            double r16 = r58;
            double r18 = r60;
            double r23 = r64;
        L3:
            if (r2 >= r4) goto L5;
            double r31 = r23 + r10;
            double r33 = Math.sin(r31);
            double r35 = Math.cos(r31);
            double r3 = (r50 + ((r0 * r5) * r35)) - (r19 * r33);
            double r1 = (r52 + ((r0 * r7) * r35)) + (r21 * r33);
            double r37 = (r15 * r33) - (r19 * r35);
            double r34 = (r33 * r14) + (r35 * r21);
            double r24 = r31 - r23;
            double r36 = Math.tan(r24 / 2.0d);
            double r26 = (Math.sin(r24) * (Math.sqrt(((r36 * 3.0d) * r36) + 4.0d) - 1.0d)) / 3.0d;
            double r110 = r16 + (r27 * r26);
            double r28 = r5;
            double r63 = r7;
            r49.rLineTo(0.0f, 0.0f);
            r49.cubicTo((float) r110, (float) (r18 + (r25 * r26)), (float) (r3 - (r26 * r37)), (float) (r1 - (r26 * r34)), (float) r3, (float) r1);
            r2 = r2 + 1;
            r10 = r10;
            r7 = r63;
            r16 = r3;
            r14 = r14;
            r5 = r28;
            r23 = r31;
            r25 = r34;
            r27 = r37;
            r4 = r4;
            r18 = r1;
            r0 = r54;
            goto L3
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }
    }

    static float[] a(float[] r2, int r3, int r4) {
        if (r3 > r4) goto L11;
        int r0 = r2.length;
        if (r3 < 0) goto L9;
        if (r3 > r0) goto L9;
        int r5 = r4 - r3;
        int r1 = Math.min(r5, r0 - r3);
        float[] r6 = new float[r5];
        System.arraycopy(r2, r3, r6, 0, r1);
        return r6;
    L9:
        throw new ArrayIndexOutOfBoundsException();
    L11:
        throw new IllegalArgumentException();
    }

    public static Path a(String r4) {
        Path r0 = new Path();
        b[] r1 = b(r4);
        if (r1 != null) goto L11;
        return null;
    L11:
        b.a(r1, r0);     // Catch: RuntimeException -> L6
        return r0;
    L6:
        e = move-exception;
        throw new RuntimeException("Error in parsing " + r4, e);
    }

    public static b[] b(String r7) {
        if (r7 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        int r3 = 1;
        int r4 = 0;
    L7:
        if (r3 >= r7.length()) goto L13;
        int r5 = a(r7, r3);
        String r6 = r7.substring(r4, r5).trim();
        if (r6.length() <= 0) goto L11;
        a(r0, r6.charAt(0), c(r6));
    L11:
        r4 = r5;
        r3 = r5 + 1;
        goto L7
    L13:
        if ((r3 - r4) != 1) goto L18;
        if (r4 >= r7.length()) goto L18;
        a(r0, r7.charAt(r4), new float[0]);
    L18:
        return (b[]) ZeusTransformUtils.preCheckCast(r0.toArray(new b[r0.size()]), b[].class, "com.obric.aiagent.plugin");
    }

    public static b[] a(b[] r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        b[] r0 = new b[r4.length];
        int r1 = 0;
    L7:
        if (r1 >= r4.length) goto L9;
        r0[r1] = new b(r4[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    public static boolean a(b[] r4, b[] r5) {
        if (r4 == null) goto L21;
        if (r5 == null) goto L21;
        if (r4.length == r5.length) goto L9;
        return false;
    L9:
        int r1 = 0;
    L11:
        if (r1 >= r4.length) goto L19;
        if (r4[r1].f1217a != r5[r1].f1217a) goto L18;
        if (r4[r1].f1218b.length != r5[r1].f1218b.length) goto L18;
        r1 = r1 + 1;
    L18:
        return false;
    L19:
        return true;
    L21:
        return false;
    }

    public static void b(b[] r5, b[] r6) {
        int r1 = 0;
    L4:
        if (r1 >= r6.length) goto L10;
        r5[r1].f1217a = r6[r1].f1217a;
        int r2 = 0;
    L7:
        if (r2 >= r6[r1].f1218b.length) goto L9;
        r5[r1].f1218b[r2] = r6[r1].f1218b[r2];
        r2 = r2 + 1;
        goto L7
    L9:
        r1 = r1 + 1;
        goto L4
    }

    private static int a(String r3, int r4) {
    L3:
        if (r4 >= r3.length()) goto L14;
        char r0 = r3.charAt(r4);
        if (((r0 - 'A') * (r0 - 'Z')) <= 0) goto L9;
        if (((r0 - 'a') * (r0 - 'z')) <= 0) goto L9;
    L13:
        r4 = r4 + 1;
    L9:
        if (r0 == 'e') goto L13;
        if (r0 == 'E') goto L13;
        return r4;
    L14:
        return r4;
    }

    private static void a(ArrayList<b> r1, char r2, float[] r3) {
        r1.add(new b(r2, r3));
    }

    private static float[] c(String r8) {
        if (r8.charAt(0) == 'z') goto L22;
        if (r8.charAt(0) == 'Z') goto L22;
        float[] r1 = new float[r8.length()];     // Catch: NumberFormatException -> L18
        a r2 = new a();     // Catch: NumberFormatException -> L18
        int r3 = r8.length();     // Catch: NumberFormatException -> L18
        int r4 = 1;
        int r5 = 0;
    L8:
        if (r4 >= r3) goto L16;
        a(r8, r4, r2);     // Catch: NumberFormatException -> L18
        int r6 = r2.f1215a;     // Catch: NumberFormatException -> L18
        if (r4 >= r6) goto L13;
        r1[r5] = Float.parseFloat(r8.substring(r4, r6));     // Catch: NumberFormatException -> L18
        r5 = r5 + 1;     // Catch: NumberFormatException -> L18
    L13:
        if (r2.f1216b == true) goto L14;
        r4 = r6 + 1;     // Catch: NumberFormatException -> L18
        goto L8
    L14:
        r4 = r6;
        goto L8
    L16:
        return a(r1, 0, r5);
    L18:
        e = move-exception;
        throw new RuntimeException("error in parsing \"" + r8 + "\"", e);
    L22:
        return new float[0];
    }

    private static void a(String r8, int r9, a r10) {
        r10.f1216b = false;
        int r1 = r9;
        boolean r2 = false;
        boolean r3 = false;
        boolean r4 = false;
    L4:
        if (r1 >= r8.length()) goto L25;
        char r5 = r8.charAt(r1);
        if (r5 != ' ') goto L8;
    L21:
        r2 = false;
        r4 = true;
    L22:
        if (r4 == true) goto L25;
        r1 = r1 + 1;
        goto L4
    L8:
        if (r5 != 'E') goto L10;
    L20:
        r2 = true;
        goto L22
    L10:
        if (r5 == 'e') goto L20;
        switch(r5) {
            case 44: goto L21;
            case 45: goto L16;
            case 46: goto L13;
            default: goto L30;
        };
    L13:
        if (r3 == true) goto L15;
        r2 = false;
        r3 = true;
        goto L22
    L15:
        r10.f1216b = true;
        goto L21
    L16:
        if (r1 == r9) goto L19;
        if (r2 == true) goto L29;
        r10.f1216b = true;
        goto L21
    L29:
        r2 = false;
        goto L22
    L19:
        r2 = false;
        goto L22
    L30:
        r2 = false;
    L25:
        r10.f1215a = r1;
    }
}
