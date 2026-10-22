package com.google.common.math;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class Quantiles {

    /* JADX INFO: renamed from: com.google.common.math.Quantiles$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Scale {
        private final int scale;

        public /* synthetic */ Scale(int r10, AnonymousClass1 r11) {
            this(r10);
        }

        public ScaleAndIndex index(int r10) {
            return new ScaleAndIndex(this.scale, r10, null);
        }

        public ScaleAndIndexes indexes(int... r10) {
            return new ScaleAndIndexes(this.scale, (int[]) r10.clone(), null);
        }

        private Scale(int r10) {
            if (r10 <= 0) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkArgument(r11, "Quantile scale must be positive");
            this.scale = r10;
            return;
        L5:
            r11 = false;
            goto L6
        }

        public ScaleAndIndexes indexes(Collection<Integer> r10) {
            return new ScaleAndIndexes(this.scale, Ints.toArray(r10), null);
        }
    }

    public static final class ScaleAndIndex {
        private final int index;
        private final int scale;

        public /* synthetic */ ScaleAndIndex(int r10, int r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        public double compute(Collection<? extends Number> r10) {
            return computeInPlace(Doubles.toArray(r10));
        }

        public double computeInPlace(double... r14) {
            if (r14.length <= 0) goto L5;
            boolean r10 = true;
        L6:
            Preconditions.checkArgument(r10, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.access$600(r14) == false) goto L10;
            return Double.NaN;
        L10:
            long r11 = ((long) this.index) * ((long) (r14.length - 1));
            int r12 = (int) LongMath.divide(r11, this.scale, RoundingMode.DOWN);
            int r13 = (int) (r11 - (((long) r12) * ((long) this.scale)));
            Quantiles.access$700(r12, r14, 0, r14.length - 1);
            if (r13 == 0) goto L13;
            int r15 = r12 + 1;
            Quantiles.access$700(r15, r14, r15, r14.length - 1);
            return Quantiles.access$800(r14[r12], r14[r15], r13, this.scale);
        L13:
            return r14[r12];
        L5:
            r10 = false;
            goto L6
        }

        private ScaleAndIndex(int r10, int r11) {
            Quantiles.access$300(r11, r10);
            this.scale = r10;
            this.index = r11;
        }

        public double compute(double... r10) {
            return computeInPlace((double[]) r10.clone());
        }

        public double compute(long... r10) {
            return computeInPlace(Quantiles.access$400(r10));
        }

        public double compute(int... r10) {
            return computeInPlace(Quantiles.access$500(r10));
        }
    }

    public static final class ScaleAndIndexes {
        private final int[] indexes;
        private final int scale;

        public /* synthetic */ ScaleAndIndexes(int r10, int[] r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        public Map<Integer, Double> compute(Collection<? extends Number> r10) {
            return computeInPlace(Doubles.toArray(r10));
        }

        public Map<Integer, Double> computeInPlace(double... r20) {
            int r10 = 0;
            if (r20.length <= 0) goto L5;
            boolean r11 = true;
        L6:
            Preconditions.checkArgument(r11, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.access$600(r20) == false) goto L13;
            HashMap r12 = new HashMap();
            int[] r13 = this.indexes;
            int r14 = r13.length;
        L9:
            if (r10 >= r14) goto L12;
            r12.put(Integer.valueOf(r13[r10]), Double.valueOf(Double.NaN));
            r10 = r10 + 1;
            goto L9
        L12:
            return Collections.unmodifiableMap(r12);
        L13:
            int[] r15 = this.indexes;
            int[] r16 = new int[r15.length];
            int[] r17 = new int[r15.length];
            int[] r18 = new int[r15.length * 2];
            int r19 = 0;
            int r21 = 0;
        L14:
            int[] r22 = this.indexes;
            if (r19 >= r22.length) goto L21;
            long r23 = ((long) r22[r19]) * ((long) (r20.length - 1));
            int r110 = (int) LongMath.divide(r23, this.scale, RoundingMode.DOWN);
            int r24 = (int) (r23 - (((long) r110) * ((long) this.scale)));
            r16[r19] = r110;
            r17[r19] = r24;
            r18[r21] = r110;
            int r25 = r21 + 1;
            if (r24 == 0) goto L19;
            r18[r25] = r110 + 1;
            r21 = r21 + 2;
        L20:
            r19 = r19 + 1;
            goto L14
        L19:
            r21 = r25;
            goto L20
        L21:
            Arrays.sort(r18, 0, r21);
            Quantiles.access$900(r18, 0, r21 - 1, r20, 0, r20.length - 1);
            HashMap r26 = new HashMap();
        L22:
            int[] r27 = this.indexes;
            if (r10 >= r27.length) goto L30;
            int r28 = r16[r10];
            int r29 = r17[r10];
            if (r29 != 0) goto L27;
            r26.put(Integer.valueOf(r27[r10]), Double.valueOf(r20[r28]));
        L28:
            r10 = r10 + 1;
            goto L22
        L27:
            r26.put(Integer.valueOf(r27[r10]), Double.valueOf(Quantiles.access$800(r20[r28], r20[r28 + 1], r29, this.scale)));
            goto L28
        L30:
            return Collections.unmodifiableMap(r26);
        L5:
            r11 = false;
            goto L6
        }

        private ScaleAndIndexes(int r10, int[] r11) {
            int r12 = r11.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            Quantiles.access$300(r11[r13], r10);
            r13 = r13 + 1;
            goto L3
        L5:
            this.scale = r10;
            this.indexes = r11;
        }

        public Map<Integer, Double> compute(double... r10) {
            return computeInPlace((double[]) r10.clone());
        }

        public Map<Integer, Double> compute(long... r10) {
            return computeInPlace(Quantiles.access$400(r10));
        }

        public Map<Integer, Double> compute(int... r10) {
            return computeInPlace(Quantiles.access$500(r10));
        }
    }

    public Quantiles() {
    }

    public static /* synthetic */ void access$300(int r10, int r11) {
        checkIndex(r10, r11);
    }

    public static /* synthetic */ double[] access$400(long[] r10) {
        return longsToDoubles(r10);
    }

    public static /* synthetic */ double[] access$500(int[] r10) {
        return intsToDoubles(r10);
    }

    public static /* synthetic */ boolean access$600(double[] r10) {
        return containsNaN(r10);
    }

    public static /* synthetic */ void access$700(int r10, double[] r11, int r12, int r13) {
        selectInPlace(r10, r11, r12, r13);
    }

    public static /* synthetic */ double access$800(double r10, double r11, double r12, double r13) {
        return interpolate(r10, r11, r12, r13);
    }

    public static /* synthetic */ void access$900(int[] r10, int r11, int r12, double[] r13, int r14, int r15) {
        selectAllInPlace(r10, r11, r12, r13, r14, r15);
    }

    private static void checkIndex(int r10, int r11) {
        if (r10 < 0) goto L6;
        if (r10 > r11) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Quantile indexes must be between 0 and the scale, which is " + r11);
    }

    private static int chooseNextSelection(int[] r10, int r11, int r12, int r13, int r14) {
        if (r11 != r12) goto L4;
        return r11;
    L4:
        int r15 = r13 + r14;
        int r16 = r15 >>> 1;
    L6:
        if (r12 <= (r11 + 1)) goto L14;
        int r17 = (r11 + r12) >>> 1;
        int r18 = r10[r17];
        if (r18 > r16) goto L9;
        if (r18 >= r16) goto L12;
        r11 = r17;
        goto L6
    L12:
        return r17;
    L9:
        r12 = r17;
        goto L6
    L14:
        if (((r15 - r10[r11]) - r10[r12]) <= 0) goto L16;
        return r12;
    L16:
        return r11;
    }

    private static boolean containsNaN(double... r10) {
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        if (Double.isNaN(r10[r12]) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static double interpolate(double r10, double r11, double r12, double r13) {
        if (r10 != Double.NEGATIVE_INFINITY) goto L10;
        if (r11 != Double.POSITIVE_INFINITY) goto L8;
        return Double.NaN;
    L8:
        return Double.NEGATIVE_INFINITY;
    L10:
        if (r11 != Double.POSITIVE_INFINITY) goto L13;
        return Double.POSITIVE_INFINITY;
    L13:
        return r10 + (((r11 - r10) * r12) / r13);
    }

    private static double[] intsToDoubles(int[] r10) {
        int r11 = r10.length;
        double[] r12 = new double[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12[r13] = r10[r13];
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    private static double[] longsToDoubles(long[] r10) {
        int r11 = r10.length;
        double[] r12 = new double[r11];
        int r13 = 0;
    L3:
        if (r13 >= r11) goto L5;
        r12[r13] = r10[r13];
        r13 = r13 + 1;
        goto L3
    L5:
        return r12;
    }

    public static ScaleAndIndex median() {
        return scale(2).index(1);
    }

    private static void movePivotToStartOfSlice(double[] r10, int r11, int r12) {
        boolean r13 = true;
        int r14 = (r11 + r12) >>> 1;
        double r15 = r10[r12];
        double r16 = r10[r14];
        if (r15 >= r16) goto L5;
        boolean r17 = true;
    L6:
        double r18 = r10[r11];
        if (r16 >= r18) goto L9;
        boolean r19 = true;
    L11:
        if (r15 < r18) goto L14;
        r13 = false;
    L14:
        if (r17 != r19) goto L16;
        swap(r10, r14, r11);
        return;
    L16:
        if (r17 == r13) goto L20;
        swap(r10, r11, r12);
        return;
    L20:
        return;
    L9:
        r19 = false;
        goto L11
    L5:
        r17 = false;
        goto L6
    }

    private static int partition(double[] r10, int r11, int r12) {
        movePivotToStartOfSlice(r10, r11, r12);
        double r13 = r10[r11];
        int r14 = r12;
    L3:
        if (r12 <= r11) goto L8;
        if (r10[r12] <= r13) goto L7;
        swap(r10, r14, r12);
        r14 = r14 - 1;
    L7:
        r12 = r12 - 1;
        goto L3
    L8:
        swap(r10, r11, r14);
        return r14;
    }

    public static Scale percentiles() {
        return scale(100);
    }

    public static Scale quartiles() {
        return scale(4);
    }

    public static Scale scale(int r10) {
        return new Scale(r10, null);
    }

    private static void selectAllInPlace(int[] r10, int r11, int r12, double[] r13, int r14, int r15) {
        int r16 = chooseNextSelection(r10, r11, r12, r14, r15);
        int r17 = r10[r16];
        selectInPlace(r17, r13, r14, r15);
        int r18 = r16 - 1;
    L3:
        if (r18 < r11) goto L7;
        if (r10[r18] != r17) goto L7;
        r18 = r18 - 1;
    L7:
        if (r18 < r11) goto L9;
        selectAllInPlace(r10, r11, r18, r13, r14, r17 - 1);
    L9:
        int r19 = r16 + 1;
    L10:
        if (r19 > r12) goto L14;
        if (r10[r19] != r17) goto L14;
        r19 = r19 + 1;
    L14:
        if (r19 > r12) goto L21;
        selectAllInPlace(r10, r19, r12, r13, r17 + 1, r15);
        return;
    }

    private static void selectInPlace(int r10, double[] r11, int r12, int r13) {
        if (r10 != r12) goto L12;
        int r14 = r12 + 1;
        int r15 = r12;
    L4:
        if (r14 > r13) goto L9;
        if (r11[r15] <= r11[r14]) goto L8;
        r15 = r14;
    L8:
        r14 = r14 + 1;
        goto L4
    L9:
        if (r15 == r12) goto L27;
        swap(r11, r15, r12);
        return;
    L27:
        return;
    L12:
        if (r13 <= r12) goto L18;
        int r16 = partition(r11, r12, r13);
        if (r16 < r10) goto L16;
        r13 = r16 - 1;
    L16:
        if (r16 > r10) goto L12;
        r12 = r16 + 1;
        goto L12
    }

    private static void swap(double[] r10, int r11, int r12) {
        double r13 = r10[r11];
        r10[r11] = r10[r12];
        r10[r12] = r13;
    }
}
