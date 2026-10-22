package com.google.android.material.color.utilities;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public final class QuantizerWsmeans {
    private static final int MAX_ITERATIONS = 10;
    private static final double MIN_MOVEMENT_DISTANCE = 3.0d;

    private static final class Distance implements Comparable<Distance> {
        double distance;
        int index;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Distance r1) {
            return compareTo2(r1);
        }

        Distance() {
            this.index = -1;
            this.distance = -1.0d;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(Distance r3) {
            return Double.valueOf(this.distance).compareTo(Double.valueOf(r3.distance));
        }
    }

    private QuantizerWsmeans() {
    }

    public static Map<Integer, Integer> quantize(int[] r25, int[] r26, int r27) {
        Random r2 = new Random(272008);
        LinkedHashMap r3 = new LinkedHashMap();
        double[][] r4 = new double[r25.length][];
        int[] r5 = new int[r25.length];
        PointProviderLab r6 = new PointProviderLab();
        int r8 = 0;
        int r9 = 0;
    L4:
        if (r8 >= r25.length) goto L10;
        int r10 = r25[r8];
        Integer r12 = (Integer) r3.get(Integer.valueOf(r10));
        if (r12 != null) goto L8;
        r4[r9] = r6.fromInt(r10);
        r5[r9] = r10;
        r9 = r9 + 1;
        r3.put(Integer.valueOf(r10), 1);
    L9:
        r8 = r8 + 1;
        goto L4
    L8:
        r3.put(Integer.valueOf(r10), Integer.valueOf(r12.intValue() + 1));
        goto L9
    L10:
        int[] r0 = new int[r9];
        int r11 = 0;
    L11:
        if (r11 >= r9) goto L13;
        r0[r11] = ((Integer) r3.get(Integer.valueOf(r5[r11]))).intValue();
        r11 = r11 + 1;
        goto L11
    L13:
        int r7 = Math.min(r27, r9);
        if (r26.length == 0) goto L16;
        r7 = Math.min(r7, r26.length);
    L16:
        double[][] r13 = new double[r7][];
        int r14 = 0;
        int r15 = 0;
    L18:
        if (r14 >= r26.length) goto L20;
        r13[r14] = r6.fromInt(r26[r14]);
        r15 = r15 + 1;
        r14 = r14 + 1;
        goto L18
    L20:
        int r1 = r7 - r15;
        if (r1 <= 0) goto L25;
        int r16 = 0;
    L23:
        if (r16 >= r1) goto L25;
        r16 = r16 + 1;
    L25:
        int[] r17 = new int[r9];
        int r18 = 0;
    L26:
        if (r18 >= r9) goto L28;
        r17[r18] = r2.nextInt(r7);
        r18 = r18 + 1;
        goto L26
    L28:
        int[][] r19 = new int[r7][];
        int r20 = 0;
    L29:
        if (r20 >= r7) goto L31;
        r19[r20] = new int[r7];
        r20 = r20 + 1;
        goto L29
    L31:
        Distance[][] r21 = new Distance[r7][];
        int r110 = 0;
    L32:
        if (r110 >= r7) goto L37;
        r21[r110] = new Distance[r7];
        int r111 = 0;
    L34:
        if (r111 >= r7) goto L36;
        r21[r110][r111] = new Distance();
        r111 = r111 + 1;
        goto L34
    L36:
        r110 = r110 + 1;
        goto L32
    L37:
        int[] r112 = new int[r7];
        int r113 = 0;
    L39:
        if (r113 >= 10) goto L82;
        int r114 = 0;
    L41:
        if (r114 >= r7) goto L49;
        int r115 = r114 + 1;
        int r116 = r115;
    L43:
        if (r116 >= r7) goto L45;
        int[] r28 = r112;
        double r117 = r6.distance(r13[r114], r13[r116]);
        r21[r116][r114].distance = r117;
        r21[r116][r114].index = r114;
        r21[r114][r116].distance = r117;
        r21[r114][r116].index = r116;
        r116 = r116 + 1;
        r112 = r28;
        goto L43
    L45:
        int[] r29 = r112;
        Arrays.sort(r21[r114]);
        int r22 = 0;
    L46:
        if (r22 >= r7) goto L48;
        r19[r114][r22] = r21[r114][r22].index;
        r22 = r22 + 1;
        goto L46
    L48:
        r112 = r29;
        r114 = r115;
        goto L41
    L49:
        int[] r210 = r112;
        int r23 = 0;
        int r118 = 0;
    L50:
        if (r23 >= r9) goto L66;
        double[] r119 = r4[r23];
        int r120 = r17[r23];
        double r121 = r6.distance(r119, r13[r120]);
        int[][] r211 = r19;
        int[] r122 = r0;
        double r123 = r121;
        int r24 = -1;
        int r30 = 0;
    L52:
        if (r30 >= r7) goto L60;
        Distance[][] r212 = r21;
        int r213 = r9;
        if (r21[r120][r30].distance >= (4.0d * r121)) goto L59;
        double r31 = r6.distance(r119, r13[r30]);
        if (r31 >= r123) goto L59;
        r24 = r30;
        r123 = r31;
    L59:
        r30 = r30 + 1;
        r9 = r213;
        r21 = r212;
        goto L52
    L60:
        Distance[][] r214 = r21;
        int r215 = r9;
        if (r24 == (-1)) goto L65;
        if (Math.abs(Math.sqrt(r123) - Math.sqrt(r121)) <= 3.0d) goto L65;
        r118 = r118 + 1;
        r17[r23] = r24;
    L65:
        r23 = r23 + 1;
        r19 = r211;
        r0 = r122;
        r9 = r215;
        r21 = r214;
        goto L50
    L66:
        int[] r124 = r0;
        int[][] r216 = r19;
        Distance[][] r217 = r21;
        int r218 = r9;
        if (r118 != 0) goto L70;
        if (r113 == 0) goto L70;
        int r125 = 0;
        int[] r32 = r210;
    L83:
        LinkedHashMap r33 = new LinkedHashMap();
        int r34 = r125;
    L84:
        if (r34 >= r7) goto L93;
        int r35 = r32[r34];
        if (r35 == 0) goto L92;
        int r36 = r6.toInt(r13[r34]);
        if (r33.containsKey(Integer.valueOf(r36)) == true) goto L92;
        r33.put(Integer.valueOf(r36), Integer.valueOf(r35));
    L92:
        r34 = r34 + 1;
        goto L84
    L93:
        return r33;
    L70:
        double[] r37 = new double[r7];
        double[] r38 = new double[r7];
        double[] r39 = new double[r7];
        char r40 = 0;
        Arrays.fill(r210, 0);
        int r126 = 0;
    L71:
        int r127 = r218;
        if (r126 >= r127) goto L74;
        int r128 = r17[r126];
        double[] r129 = r4[r126];
        int r130 = r124[r126];
        r210[r128] = r210[r128] + r130;
        double r131 = r130;
        r37[r128] = r37[r128] + (r129[r40] * r131);
        r38[r128] = r38[r128] + (r129[1] * r131);
        r39[r128] = r39[r128] + (r129[2] * r131);
        r126 = r126 + 1;
        r113 = r113;
        r218 = r127;
        r40 = 0;
        goto L71
    L74:
        int r41 = r113;
        int r132 = 0;
    L75:
        if (r132 >= r7) goto L81;
        int r133 = r210[r132];
        if (r133 != 0) goto L79;
        r13[r132] = new double[]{0.0d, 0.0d, 0.0d};
    L80:
        r132 = r132 + 1;
        goto L75
    L79:
        double r134 = r133;
        double r135 = r37[r132] / r134;
        double r136 = r38[r132] / r134;
        double r219 = r39[r132] / r134;
        double[] r137 = r13[r132];
        r137[0] = r135;
        r137[1] = r136;
        r137[2] = r219;
        goto L80
    L81:
        r19 = r216;
        r113 = r41 + 1;
        r112 = r210;
        r9 = r127;
        r0 = r124;
        r21 = r217;
        goto L39
    L82:
        r32 = r112;
        r125 = 0;
        goto L83
    }
}
