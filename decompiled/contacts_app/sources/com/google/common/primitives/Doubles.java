package com.google.common.primitives;

import com.android.contacts.common.list.DefaultContactListAdapter;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class Doubles {
    public static final int BYTES = 8;
    static final Pattern FLOATING_POINT_PATTERN = null;

    private static class DoubleArrayAsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final double[] array;
        final int end;
        final int start;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r1) {
            return get(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r1, Object r2) {
            return set(r1, (Double) r2);
        }

        DoubleArrayAsList(double[] r3) {
            this(r3, 0, r3.length);
        }

        DoubleArrayAsList(double[] r1, int r2, int r3) {
            this.array = r1;
            this.start = r2;
            this.end = r3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Double get(int r2) {
            Preconditions.checkElementIndex(r2, size());
            return Double.valueOf(this.array[this.start + r2]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r4) {
            if ((r4 instanceof Double) == true) goto L5;
        L7:
            return false;
        L5:
            if (Doubles.access$000(this.array, ((Double) r4).doubleValue(), this.start, this.end) == (-1)) goto L7;
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r5) {
            if ((r5 instanceof Double) == false) goto L8;
            int r6 = Doubles.access$000(this.array, ((Double) r5).doubleValue(), this.start, this.end);
            if (r6 >= 0) goto L7;
            return -1;
        L7:
            return r6 - this.start;
        L8:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r5) {
            if ((r5 instanceof Double) == false) goto L8;
            int r6 = Doubles.access$100(this.array, ((Double) r5).doubleValue(), this.start, this.end);
            if (r6 >= 0) goto L7;
            return -1;
        L7:
            return r6 - this.start;
        L8:
            return -1;
        }

        public Double set(int r4, Double r5) {
            Preconditions.checkElementIndex(r4, size());
            double[] r0 = this.array;
            int r3 = this.start;
            double r1 = r0[r3 + r4];
            r0[r3 + r4] = ((Double) Preconditions.checkNotNull(r5)).doubleValue();
            return Double.valueOf(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int r3, int r4) {
            Preconditions.checkPositionIndexes(r3, r4, size());
            if (r3 == r4) goto L5;
            double[] r1 = this.array;
            int r2 = this.start;
            return new DoubleArrayAsList(r1, r3 + r2, r2 + r4);
        L5:
            return Collections.emptyList();
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object r9) {
            if (r9 != this) goto L6;
            return true;
        L6:
            if ((r9 instanceof DoubleArrayAsList) == false) goto L18;
            DoubleArrayAsList r10 = (DoubleArrayAsList) r9;
            int r1 = size();
            if (r10.size() == r1) goto L10;
            return false;
        L10:
            int r2 = 0;
        L11:
            if (r2 >= r1) goto L16;
            if (this.array[this.start + r2] != r10.array[r10.start + r2]) goto L14;
            r2 = r2 + 1;
            goto L11
        L14:
            return false;
        L16:
            return true;
        L18:
            return super.equals(r9);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int r0 = this.start;
            int r1 = 1;
        L4:
            if (r0 >= this.end) goto L6;
            r1 = (r1 * 31) + Doubles.hashCode(this.array[r0]);
            r0 = r0 + 1;
            goto L4
        L6:
            return r1;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r0 = new StringBuilder(size() * 12);
            r0.append(DefaultContactListAdapter.SNIPPET_START_MATCH).append(this.array[this.start]);
            int r1 = this.start;
        L3:
            r1 = r1 + 1;
            if (r1 >= this.end) goto L7;
            r0.append(", ").append(this.array[r1]);
            goto L3
        L7:
            return r0.append(DefaultContactListAdapter.SNIPPET_END_MATCH).toString();
        }

        double[] toDoubleArray() {
            int r0 = size();
            double[] r1 = new double[r0];
            System.arraycopy(this.array, this.start, r1, 0, r0);
            return r1;
        }
    }

    private static final class DoubleConverter extends Converter<String, Double> implements Serializable {
        static final DoubleConverter INSTANCE = null;
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Doubles.stringConverter()";
        }

        private DoubleConverter() {
        }

        @Override // com.google.common.base.Converter
        protected /* bridge */ /* synthetic */ String doBackward(Double r1) {
            return doBackward2(r1);
        }

        @Override // com.google.common.base.Converter
        protected /* bridge */ /* synthetic */ Double doForward(String r1) {
            return doForward2(r1);
        }

        static {
            INSTANCE = new DoubleConverter();
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        protected Double doForward2(String r1) {
            return Double.valueOf(r1);
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        protected String doBackward2(Double r1) {
            return r1.toString();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    private static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<double[]> {
        private static final /* synthetic */ LexicographicalComparator[] $VALUES = null;
        public static final LexicographicalComparator INSTANCE = null;

        private LexicographicalComparator(String r1, int r2) {
            super(r1, r2);
        }

        public static LexicographicalComparator valueOf(String r1) {
            return (LexicographicalComparator) Enum.valueOf(LexicographicalComparator.class, r1);
        }

        public static LexicographicalComparator[] values() {
            return (LexicographicalComparator[]) $VALUES.clone();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(double[] r1, double[] r2) {
            return compare2(r1, r2);
        }

        static {
            LexicographicalComparator r0 = new LexicographicalComparator("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new LexicographicalComparator[]{r0};
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(double[] r6, double[] r7) {
            int r5 = Math.min(r6.length, r7.length);
            int r0 = 0;
        L3:
            if (r0 >= r5) goto L9;
            int r1 = Double.compare(r6[r0], r7[r0]);
            if (r1 != 0) goto L6;
            r0 = r0 + 1;
            goto L3
        L6:
            return r1;
        L9:
            return r6.length - r7.length;
        }
    }

    public static boolean isFinite(double r5) {
        boolean r1 = true;
        if (Double.NEGATIVE_INFINITY >= r5) goto L5;
        boolean r0 = true;
    L7:
        if (r5 < Double.POSITIVE_INFINITY) goto L11;
        r1 = false;
    L11:
        return r0 & r1;
    L5:
        r0 = false;
        goto L7
    }

    static /* synthetic */ int access$000(double[] r0, double r1, int r3, int r4) {
        return indexOf(r0, r1, r3, r4);
    }

    static /* synthetic */ int access$100(double[] r0, double r1, int r3, int r4) {
        return lastIndexOf(r0, r1, r3, r4);
    }

    private Doubles() {
    }

    public static int hashCode(double r0) {
        return Double.valueOf(r0).hashCode();
    }

    public static int compare(double r0, double r2) {
        return Double.compare(r0, r2);
    }

    public static boolean contains(double[] r5, double r6) {
        int r0 = r5.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r5[r2] == r6) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static int indexOf(double[] r2, double r3) {
        return indexOf(r2, r3, 0, r2.length);
    }

    private static int indexOf(double[] r2, double r3, int r5, int r6) {
    L2:
        if (r5 >= r6) goto L7;
        if (r2[r5] == r3) goto L5;
        r5 = r5 + 1;
        goto L2
    L5:
        return r5;
    L7:
        return -1;
    }

    public static int indexOf(double[] r7, double[] r8) {
        Preconditions.checkNotNull(r7, "array");
        Preconditions.checkNotNull(r8, "target");
        if (r8.length != 0) goto L5;
        return 0;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= ((r7.length - r8.length) + 1)) goto L16;
        int r2 = 0;
    L10:
        if (r2 >= r8.length) goto L15;
        if (r7[r0 + r2] != r8[r2]) goto L13;
        r2 = r2 + 1;
        goto L10
    L13:
        r0 = r0 + 1;
        goto L7
    L15:
        return r0;
    L16:
        return -1;
    }

    public static int lastIndexOf(double[] r2, double r3) {
        return lastIndexOf(r2, r3, 0, r2.length);
    }

    private static int lastIndexOf(double[] r2, double r3, int r5, int r6) {
        int r7 = r6 - 1;
    L3:
        if (r7 < r5) goto L8;
        if (r2[r7] == r3) goto L6;
        r7 = r7 - 1;
        goto L3
    L6:
        return r7;
    L8:
        return -1;
    }

    public static double min(double... r5) {
        int r2 = 1;
        if (r5.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        double r1 = r5[0];
    L8:
        if (r2 >= r5.length) goto L10;
        r1 = Math.min(r1, r5[r2]);
        r2 = r2 + 1;
        goto L8
    L10:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public static double max(double... r5) {
        int r2 = 1;
        if (r5.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        double r1 = r5[0];
    L8:
        if (r2 >= r5.length) goto L10;
        r1 = Math.max(r1, r5[r2]);
        r2 = r2 + 1;
        goto L8
    L10:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public static double[] concat(double[]... r7) {
        int r0 = r7.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r3 = r3 + r7[r2].length;
        r2 = r2 + 1;
        goto L3
    L5:
        double[] r1 = new double[r3];
        int r4 = r7.length;
        int r5 = 0;
        int r6 = 0;
    L6:
        if (r5 >= r4) goto L8;
        double[] r8 = r7[r5];
        System.arraycopy(r8, 0, r1, r6, r8.length);
        r6 = r6 + r8.length;
        r5 = r5 + 1;
        goto L6
    L8:
        return r1;
    }

    public static Converter<String, Double> stringConverter() {
        return DoubleConverter.INSTANCE;
    }

    public static double[] ensureCapacity(double[] r5, int r6, int r7) {
        if (r6 < 0) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "Invalid minLength: %s", new Object[]{Integer.valueOf(r6)});
        if (r7 < 0) goto L9;
        boolean r3 = true;
    L10:
        Preconditions.checkArgument(r3, "Invalid padding: %s", new Object[]{Integer.valueOf(r7)});
        if (r5.length < r6) goto L13;
        return r5;
    L13:
        return copyOf(r5, r6 + r7);
    L9:
        r3 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    private static double[] copyOf(double[] r2, int r3) {
        double[] r0 = new double[r3];
        System.arraycopy(r2, 0, r0, 0, Math.min(r2.length, r3));
        return r0;
    }

    public static String join(String r5, double... r6) {
        Preconditions.checkNotNull(r5);
        if (r6.length != 0) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder(r6.length * 12);
        r0.append(r6[0]);
        int r1 = 1;
    L8:
        if (r1 >= r6.length) goto L11;
        r0.append(r5).append(r6[r1]);
        r1 = r1 + 1;
        goto L8
    L11:
        return r0.toString();
    }

    public static Comparator<double[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static double[] toArray(Collection<? extends Number> r5) {
        if ((r5 instanceof DoubleArrayAsList) == true) goto L5;
        Object[] r6 = r5.toArray();
        int r0 = r6.length;
        double[] r1 = new double[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        r1[r2] = ((Number) Preconditions.checkNotNull(r6[r2])).doubleValue();
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    L5:
        return ((DoubleArrayAsList) r5).toDoubleArray();
    }

    public static List<Double> asList(double... r1) {
        if (r1.length != 0) goto L7;
        return Collections.emptyList();
    L7:
        return new DoubleArrayAsList(r1);
    }

    static {
        FLOATING_POINT_PATTERN = fpPattern();
    }

    private static Pattern fpPattern() {
        return Pattern.compile("[+-]?(?:NaN|Infinity|(?:\\d++(?:\\.\\d*+)?|\\.\\d++)(?:[eE][+-]?\\d++)?[fFdD]?|0[xX](?:\\p{XDigit}++(?:\\.\\p{XDigit}*+)?|\\.\\p{XDigit}++)[pP][+-]?\\d++[fFdD]?)");
    }

    @Nullable
    public static Double tryParse(String r2) {
        if (FLOATING_POINT_PATTERN.matcher(r2).matches() == true) goto L9;
        return null;
    L9:
        return Double.valueOf(Double.parseDouble(r2));
    L11:
        return null;
    }
}
