package com.google.android.material.color.utilities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class QuantizerWu implements Quantizer {
    private static final int INDEX_BITS = 5;
    private static final int INDEX_COUNT = 33;
    private static final int TOTAL_SIZE = 35937;
    Box[] cubes;
    double[] moments;
    int[] momentsB;
    int[] momentsG;
    int[] momentsR;
    int[] weights;

    /* JADX INFO: renamed from: com.google.android.material.color.utilities.QuantizerWu$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction = null;

        static {
            int[] r0 = new int[Direction.values().length];
            $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction = r0;
            r0[Direction.RED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[Direction.GREEN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[Direction.BLUE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private static final class Box {
        int b0;
        int b1;
        int g0;
        int g1;
        int r0;
        int r1;
        int vol;

        private Box() {
            this.r0 = 0;
            this.r1 = 0;
            this.g0 = 0;
            this.g1 = 0;
            this.b0 = 0;
            this.b1 = 0;
            this.vol = 0;
        }

        /* synthetic */ Box(AnonymousClass1 r1) {
            this();
        }
    }

    private static final class CreateBoxesResult {
        int resultCount;

        CreateBoxesResult(int r1, int r2) {
            this.resultCount = r2;
        }
    }

    private static final enum Direction extends Enum<Direction> {
        private static final /* synthetic */ Direction[] $VALUES = null;
        public static final Direction BLUE = null;
        public static final Direction GREEN = null;
        public static final Direction RED = null;

        private Direction(String r1, int r2) {
            super(r1, r2);
        }

        public static Direction valueOf(String r1) {
            return (Direction) Enum.valueOf(Direction.class, r1);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }

        static {
            Direction r0 = new Direction("RED", 0);
            RED = r0;
            Direction r1 = new Direction("GREEN", 1);
            GREEN = r1;
            Direction r3 = new Direction("BLUE", 2);
            BLUE = r3;
            $VALUES = new Direction[]{r0, r1, r3};
        }
    }

    private static final class MaximizeResult {
        int cutLocation;
        double maximum;

        MaximizeResult(int r1, double r2) {
            this.cutLocation = r1;
            this.maximum = r2;
        }
    }

    static int getIndex(int r2, int r3, int r4) {
        return (((((r2 << 10) + (r2 << 6)) + r2) + (r3 << 5)) + r3) + r4;
    }

    public QuantizerWu() {
    }

    @Override // com.google.android.material.color.utilities.Quantizer
    public QuantizerResult quantize(int[] r2, int r3) {
        constructHistogram(new QuantizerMap().quantize(r2, r3).colorToCount);
        createMoments();
        List<Integer> r1 = createResult(createBoxes(r3).resultCount);
        LinkedHashMap r4 = new LinkedHashMap();
        Iterator<Integer> r5 = r1.iterator();
    L4:
        if (r5.hasNext() == false) goto L7;
        r4.put(Integer.valueOf(r5.next().intValue()), 0);
        goto L4
    L7:
        return new QuantizerResult(r4);
    }

    void constructHistogram(Map<Integer, Integer> r9) {
        this.weights = new int[TOTAL_SIZE];
        this.momentsR = new int[TOTAL_SIZE];
        this.momentsG = new int[TOTAL_SIZE];
        this.momentsB = new int[TOTAL_SIZE];
        this.moments = new double[TOTAL_SIZE];
        Iterator<Map.Entry<Integer, Integer>> r10 = r9.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry<Integer, Integer> r0 = r10.next();
        int r1 = r0.getKey().intValue();
        int r2 = r0.getValue().intValue();
        int r3 = ColorUtils.redFromArgb(r1);
        int r4 = ColorUtils.greenFromArgb(r1);
        int r5 = ColorUtils.blueFromArgb(r1);
        int r6 = getIndex((r3 >> 3) + 1, (r4 >> 3) + 1, (r5 >> 3) + 1);
        int[] r7 = this.weights;
        r7[r6] = r7[r6] + r2;
        int[] r8 = this.momentsR;
        r8[r6] = r8[r6] + (r3 * r2);
        int[] r11 = this.momentsG;
        r11[r6] = r11[r6] + (r4 * r2);
        int[] r12 = this.momentsB;
        r12[r6] = r12[r6] + (r5 * r2);
        double[] r13 = this.moments;
        r13[r6] = r13[r6] + ((double) (r2 * (((r3 * r3) + (r4 * r4)) + (r5 * r5))));
        goto L4
    }

    void createMoments() {
        int r2 = 1;
    L3:
        int r3 = 33;
        if (r2 >= 33) goto L12;
        int[] r4 = new int[33];
        int[] r5 = new int[33];
        int[] r6 = new int[33];
        int[] r7 = new int[33];
        double[] r8 = new double[33];
        int r9 = 1;
    L6:
        if (r9 >= r3) goto L11;
        int r10 = 0;
        int r13 = 0;
        double r14 = 0.0d;
        int r1 = 1;
        int r11 = 0;
        int r12 = 0;
    L8:
        if (r1 >= r3) goto L10;
        int r16 = getIndex(r2, r9, r1);
        int r15 = r10 + this.weights[r16];
        r11 = r11 + this.momentsR[r16];
        r12 = r12 + this.momentsG[r16];
        r13 = r13 + this.momentsB[r16];
        r14 = r14 + this.moments[r16];
        r4[r1] = r4[r1] + r15;
        r5[r1] = r5[r1] + r11;
        r6[r1] = r6[r1] + r12;
        r7[r1] = r7[r1] + r13;
        r8[r1] = r8[r1] + r14;
        int r17 = getIndex(r2 - 1, r9, r1);
        int[] r18 = this.weights;
        r18[r16] = r18[r17] + r4[r1];
        int[] r19 = this.momentsR;
        r19[r16] = r19[r17] + r5[r1];
        int[] r110 = this.momentsG;
        r110[r16] = r110[r17] + r6[r1];
        int[] r111 = this.momentsB;
        r111[r16] = r111[r17] + r7[r1];
        double[] r112 = this.moments;
        r112[r16] = r112[r17] + r8[r1];
        r1 = r1 + 1;
        r10 = r15;
        r3 = 33;
        goto L8
    L10:
        r9 = r9 + 1;
        r3 = 33;
        goto L6
    L11:
        r2 = r2 + 1;
        goto L3
    }

    CreateBoxesResult createBoxes(int r14) {
        this.cubes = new Box[r14];
        int r1 = 0;
    L3:
        if (r1 >= r14) goto L5;
        this.cubes[r1] = new Box(null);
        r1 = r1 + 1;
        goto L3
    L5:
        double[] r2 = new double[r14];
        Box r3 = this.cubes[0];
        r3.r1 = 32;
        r3.g1 = 32;
        r3.b1 = 32;
        int r4 = 0;
        int r5 = 1;
    L6:
        if (r5 >= r14) goto L29;
        Box[] r6 = this.cubes;
        if (cut(r6[r4], r6[r5]).booleanValue() == true) goto L10;
        r2[r4] = 0.0d;
        r5 = r5 - 1;
    L19:
        double r7 = r2[0];
        int r8 = 0;
        int r9 = 1;
    L20:
        if (r9 > r5) goto L26;
        double r10 = r2[r9];
        if (r10 <= r7) goto L24;
        r8 = r9;
        r7 = r10;
    L24:
        r9 = r9 + 1;
        goto L20
    L26:
        if (r7 <= 0.0d) goto L27;
        r5 = r5 + 1;
        r4 = r8;
        goto L6
    L27:
        int r11 = r5 + 1;
    L31:
        return new CreateBoxesResult(r14, r11);
    L10:
        if (this.cubes[r4].vol <= 1) goto L12;
        double r12 = variance(this.cubes[r4]);
    L13:
        r2[r4] = r12;
        if (this.cubes[r5].vol <= 1) goto L16;
        double r13 = variance(this.cubes[r5]);
    L17:
        r2[r5] = r13;
        goto L19
    L16:
        r13 = 0.0d;
        goto L17
    L12:
        r12 = 0.0d;
        goto L13
    L29:
        r11 = r14;
        goto L31
    }

    List<Integer> createResult(int r8) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L8;
        Box r2 = this.cubes[r1];
        int r3 = volume(r2, this.weights);
        if (r3 <= 0) goto L7;
        int r4 = volume(r2, this.momentsR) / r3;
        int r5 = volume(r2, this.momentsG) / r3;
        int r6 = volume(r2, this.momentsB) / r3;
        int r7 = r6 & 255;
        r0.add(Integer.valueOf(r7 | ((((r4 & 255) << 16) | (-16777216)) | ((r5 & 255) << 8))));
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r0;
    }

    double variance(Box r10) {
        int r0 = volume(r10, this.momentsR);
        int r1 = volume(r10, this.momentsG);
        int r2 = volume(r10, this.momentsB);
        return (((((((this.moments[getIndex(r10.r1, r10.g1, r10.b1)] - this.moments[getIndex(r10.r1, r10.g1, r10.b0)]) - this.moments[getIndex(r10.r1, r10.g0, r10.b1)]) + this.moments[getIndex(r10.r1, r10.g0, r10.b0)]) - this.moments[getIndex(r10.r0, r10.g1, r10.b1)]) + this.moments[getIndex(r10.r0, r10.g1, r10.b0)]) + this.moments[getIndex(r10.r0, r10.g0, r10.b1)]) - this.moments[getIndex(r10.r0, r10.g0, r10.b0)]) - (((double) (((r0 * r0) + (r1 * r1)) + (r2 * r2))) / ((double) volume(r10, this.weights)));
    }

    Boolean cut(Box r18, Box r19) {
        int r12 = volume(r18, this.momentsR);
        int r13 = volume(r18, this.momentsG);
        int r14 = volume(r18, this.momentsB);
        int r15 = volume(r18, this.weights);
        MaximizeResult r8 = maximize(r18, Direction.RED, r18.r0 + 1, r18.r1, r12, r13, r14, r15);
        MaximizeResult r9 = maximize(r18, Direction.GREEN, r18.g0 + 1, r18.g1, r12, r13, r14, r15);
        MaximizeResult r0 = maximize(r18, Direction.BLUE, r18.b0 + 1, r18.b1, r12, r13, r14, r15);
        double r2 = r8.maximum;
        double r4 = r9.maximum;
        double r6 = r0.maximum;
        if (r2 < r4) goto L12;
        if (r2 < r6) goto L12;
        if (r8.cutLocation < 0) goto L9;
        Direction r3 = Direction.RED;
    L17:
        r19.r1 = r18.r1;
        r19.g1 = r18.g1;
        r19.b1 = r18.b1;
        int r5 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[r3.ordinal()];
        if (r5 != 1) goto L20;
        r18.r1 = r8.cutLocation;
        r19.r0 = r18.r1;
        r19.g0 = r18.g0;
        r19.b0 = r18.b0;
    L27:
        r18.vol = ((r18.r1 - r18.r0) * (r18.g1 - r18.g0)) * (r18.b1 - r18.b0);
        r19.vol = ((r19.r1 - r19.r0) * (r19.g1 - r19.g0)) * (r19.b1 - r19.b0);
        return true;
    L20:
        if (r5 != 2) goto L22;
        r18.g1 = r9.cutLocation;
        r19.r0 = r18.r0;
        r19.g0 = r18.g1;
        r19.b0 = r18.b0;
        goto L27
    L22:
        if (r5 != 3) goto L27;
        r18.b1 = r0.cutLocation;
        r19.r0 = r18.r0;
        r19.g0 = r18.g0;
        r19.b0 = r18.b1;
        goto L27
    L9:
        return false;
    L12:
        if (r4 >= r2) goto L14;
    L16:
        r3 = Direction.BLUE;
        goto L17
    L14:
        if (r4 < r6) goto L16;
        r3 = Direction.GREEN;
        goto L17
    }

    MaximizeResult maximize(Box r19, Direction r20, int r21, int r22, int r23, int r24, int r25, int r26) {
        QuantizerWu r0 = this;
        Box r1 = r19;
        Direction r2 = r20;
        int r3 = bottom(r1, r2, r0.momentsR);
        int r4 = bottom(r1, r2, r0.momentsG);
        int r5 = bottom(r1, r2, r0.momentsB);
        int r6 = bottom(r1, r2, r0.weights);
        int r10 = -1;
        double r8 = 0.0d;
        int r7 = r21;
    L3:
        if (r7 >= r22) goto L15;
        int r12 = top(r1, r2, r7, r0.momentsR) + r3;
        int r13 = top(r1, r2, r7, r0.momentsG) + r4;
        int r14 = top(r1, r2, r7, r0.momentsB) + r5;
        int r15 = top(r1, r2, r7, r0.weights) + r6;
        if (r15 != 0) goto L7;
        int r16 = r3;
    L13:
        r7 = r7 + 1;
        r0 = this;
        r1 = r19;
        r2 = r20;
        r3 = r16;
        goto L3
    L7:
        r16 = r3;
        double r9 = (((r12 * r12) + (r13 * r13)) + (r14 * r14)) / ((double) r15);
        int r11 = r23 - r12;
        int r17 = r24 - r13;
        int r18 = r25 - r14;
        int r110 = r26 - r15;
        if (r110 == 0) goto L13;
        double r27 = r9 + (((double) (((r11 * r11) + (r17 * r17)) + (r18 * r18))) / ((double) r110));
        if (r27 <= r8) goto L13;
        r8 = r27;
        r10 = r7;
        goto L13
    L15:
        return new MaximizeResult(r10, r8);
    }

    static int volume(Box r4, int[] r5) {
        return ((((((r5[getIndex(r4.r1, r4.g1, r4.b1)] - r5[getIndex(r4.r1, r4.g1, r4.b0)]) - r5[getIndex(r4.r1, r4.g0, r4.b1)]) + r5[getIndex(r4.r1, r4.g0, r4.b0)]) - r5[getIndex(r4.r0, r4.g1, r4.b1)]) + r5[getIndex(r4.r0, r4.g1, r4.b0)]) + r5[getIndex(r4.r0, r4.g0, r4.b1)]) - r5[getIndex(r4.r0, r4.g0, r4.b0)];
    }

    static int bottom(Box r3, Direction r4, int[] r5) {
        int r0 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[r4.ordinal()];
        if (r0 != 1) goto L5;
        int r6 = ((-r5[getIndex(r3.r0, r3.g1, r3.b1)]) + r5[getIndex(r3.r0, r3.g1, r3.b0)]) + r5[getIndex(r3.r0, r3.g0, r3.b1)];
        int r7 = r5[getIndex(r3.r0, r3.g0, r3.b0)];
    L10:
        return r6 - r7;
    L5:
        if (r0 != 2) goto L7;
        r6 = ((-r5[getIndex(r3.r1, r3.g0, r3.b1)]) + r5[getIndex(r3.r1, r3.g0, r3.b0)]) + r5[getIndex(r3.r0, r3.g0, r3.b1)];
        r7 = r5[getIndex(r3.r0, r3.g0, r3.b0)];
        goto L10
    L7:
        if (r0 != 3) goto L12;
        r6 = ((-r5[getIndex(r3.r1, r3.g1, r3.b0)]) + r5[getIndex(r3.r1, r3.g0, r3.b0)]) + r5[getIndex(r3.r0, r3.g1, r3.b0)];
        r7 = r5[getIndex(r3.r0, r3.g0, r3.b0)];
        goto L10
    L12:
        throw new IllegalArgumentException("unexpected direction " + r4);
    }

    static int top(Box r2, Direction r3, int r4, int[] r5) {
        int r0 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$QuantizerWu$Direction[r3.ordinal()];
        if (r0 != 1) goto L5;
        int r6 = (r5[getIndex(r4, r2.g1, r2.b1)] - r5[getIndex(r4, r2.g1, r2.b0)]) - r5[getIndex(r4, r2.g0, r2.b1)];
        int r7 = r5[getIndex(r4, r2.g0, r2.b0)];
    L10:
        return r6 + r7;
    L5:
        if (r0 != 2) goto L7;
        r6 = (r5[getIndex(r2.r1, r4, r2.b1)] - r5[getIndex(r2.r1, r4, r2.b0)]) - r5[getIndex(r2.r0, r4, r2.b1)];
        r7 = r5[getIndex(r2.r0, r4, r2.b0)];
        goto L10
    L7:
        if (r0 != 3) goto L12;
        r6 = (r5[getIndex(r2.r1, r2.g1, r4)] - r5[getIndex(r2.r1, r2.g0, r4)]) - r5[getIndex(r2.r0, r2.g1, r4)];
        r7 = r5[getIndex(r2.r0, r2.g0, r4)];
        goto L10
    L12:
        throw new IllegalArgumentException("unexpected direction " + r3);
    }
}
