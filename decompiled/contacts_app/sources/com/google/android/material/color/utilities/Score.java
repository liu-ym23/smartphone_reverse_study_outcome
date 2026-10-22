package com.google.android.material.color.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Score {
    private static final double CUTOFF_CHROMA = 15.0d;
    private static final double CUTOFF_EXCITED_PROPORTION = 0.01d;
    private static final double CUTOFF_TONE = 10.0d;
    private static final double TARGET_CHROMA = 48.0d;
    private static final double WEIGHT_CHROMA_ABOVE = 0.3d;
    private static final double WEIGHT_CHROMA_BELOW = 0.1d;
    private static final double WEIGHT_PROPORTION = 0.7d;

    static class ScoredComparator implements Comparator<Map.Entry<Integer, Double>> {
        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Map.Entry<Integer, Double> r1, Map.Entry<Integer, Double> r2) {
            return compare2(r1, r2);
        }

        public ScoredComparator() {
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Map.Entry<Integer, Double> r1, Map.Entry<Integer, Double> r2) {
            return -r1.getValue().compareTo(r2.getValue());
        }
    }

    private Score() {
    }

    public static List<Integer> score(Map<Integer, Integer> r13) {
        Iterator<Map.Entry<Integer, Integer>> r0 = r13.entrySet().iterator();
        double r3 = 0.0d;
    L4:
        if (r0.hasNext() == false) goto L6;
        r3 = r3 + ((double) r0.next().getValue().intValue());
        goto L4
    L6:
        HashMap r1 = new HashMap();
        double[] r5 = new double[361];
        Iterator<Map.Entry<Integer, Integer>> r14 = r13.entrySet().iterator();
    L8:
        if (r14.hasNext() == false) goto L10;
        Map.Entry<Integer, Integer> r6 = r14.next();
        int r7 = r6.getKey().intValue();
        double r8 = ((double) r6.getValue().intValue()) / r3;
        Cam16 r9 = Cam16.fromInt(r7);
        r1.put(Integer.valueOf(r7), r9);
        int r10 = (int) Math.round(r9.getHue());
        r5[r10] = r5[r10] + r8;
        goto L8
    L10:
        HashMap r15 = new HashMap();
        Iterator r4 = r1.entrySet().iterator();
    L12:
        if (r4.hasNext() == false) goto L18;
        Map.Entry r11 = (Map.Entry) r4.next();
        int r12 = ((Integer) r11.getKey()).intValue();
        int r16 = (int) Math.round(((Cam16) r11.getValue()).getHue());
        int r17 = r16 - 15;
        double r18 = 0.0d;
    L15:
        if (r17 >= (r16 + 15)) goto L17;
        r18 = r18 + r5[MathUtils.sanitizeDegreesInt(r17)];
        r17 = r17 + 1;
        goto L15
    L17:
        r15.put(Integer.valueOf(r12), Double.valueOf(r18));
        goto L12
    L18:
        HashMap r2 = new HashMap();
        Iterator r19 = r1.entrySet().iterator();
    L20:
        if (r19.hasNext() == false) goto L26;
        Map.Entry r20 = (Map.Entry) r19.next();
        int r21 = ((Integer) r20.getKey()).intValue();
        Cam16 r22 = (Cam16) r20.getValue();
        double r23 = (((Double) r15.get(Integer.valueOf(r21))).doubleValue() * 100.0d) * WEIGHT_PROPORTION;
        if (r22.getChroma() >= TARGET_CHROMA) goto L24;
        double r24 = 0.1d;
    L25:
        r2.put(Integer.valueOf(r21), Double.valueOf(r23 + ((r22.getChroma() - TARGET_CHROMA) * r24)));
        goto L20
    L24:
        r24 = WEIGHT_CHROMA_ABOVE;
        goto L25
    L26:
        List<Integer> r110 = filter(r15, r1);
        HashMap r25 = new HashMap();
        Iterator<Integer> r111 = r110.iterator();
    L28:
        if (r111.hasNext() == false) goto L30;
        int r26 = r111.next().intValue();
        r25.put(Integer.valueOf(r26), (Double) r2.get(Integer.valueOf(r26)));
        goto L28
    L30:
        ArrayList r112 = new ArrayList(r25.entrySet());
        Collections.sort(r112, new ScoredComparator());
        ArrayList r27 = new ArrayList();
        Iterator r113 = r112.iterator();
    L32:
        if (r113.hasNext() == false) goto L44;
        Map.Entry r28 = (Map.Entry) r113.next();
        Cam16 r29 = (Cam16) r1.get(Integer.valueOf(((Integer) r28.getKey()).intValue()));
        Iterator r30 = r27.iterator();
    L35:
        if (r30.hasNext() == false) goto L39;
        if (MathUtils.differenceDegrees(r29.getHue(), ((Cam16) r1.get((Integer) r30.next())).getHue()) >= CUTOFF_CHROMA) goto L35;
        boolean r31 = true;
    L40:
        if (r31 == true) goto L32;
        r27.add((Integer) r28.getKey());
        goto L32
    L39:
        r31 = false;
        goto L40
    L44:
        if (r27.isEmpty() == false) goto L46;
        r27.add(-12417548);
    L46:
        return r27;
    }

    private static List<Integer> filter(Map<Integer, Double> r9, Map<Integer, Cam16> r10) {
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<Integer, Cam16>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L12;
        Map.Entry<Integer, Cam16> r1 = r11.next();
        int r2 = r1.getKey().intValue();
        Cam16 r3 = r1.getValue();
        double r4 = r9.get(Integer.valueOf(r2)).doubleValue();
        if (r3.getChroma() < CUTOFF_CHROMA) goto L4;
        if (ColorUtils.lstarFromArgb(r2) < 10.0d) goto L4;
        if (r4 < CUTOFF_EXCITED_PROPORTION) goto L4;
        r0.add(Integer.valueOf(r2));
        goto L4
    L12:
        return r0;
    }
}
