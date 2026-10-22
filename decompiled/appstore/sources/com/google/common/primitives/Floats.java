package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Floats {
    public static final int BYTES = 4;

    @GwtCompatible
    public static class FloatArrayAsList extends AbstractList<Float> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final float[] array;
        final int end;
        final int start;

        public FloatArrayAsList(float[] r10) {
            this(r10, 0, r10.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r10) {
            if ((r10 instanceof Float) == true) goto L5;
        L7:
            return false;
        L5:
            if (Floats.access$000(this.array, ((Float) r10).floatValue(), this.start, this.end) == (-1)) goto L7;
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof FloatArrayAsList) == false) goto L18;
            FloatArrayAsList r11 = (FloatArrayAsList) r10;
            int r12 = size();
            if (r11.size() == r12) goto L10;
            return false;
        L10:
            int r13 = 0;
        L11:
            if (r13 >= r12) goto L16;
            if (this.array[this.start + r13] != r11.array[r11.start + r13]) goto L14;
            r13 = r13 + 1;
            goto L11
        L14:
            return false;
        L16:
            return true;
        L18:
            return super.equals(r10);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int r10 = this.start;
            int r11 = 1;
        L4:
            if (r10 >= this.end) goto L6;
            r11 = (r11 * 31) + Floats.hashCode(this.array[r10]);
            r10 = r10 + 1;
            goto L4
        L6:
            return r11;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r10) {
            if ((r10 instanceof Float) == false) goto L8;
            int r11 = Floats.access$000(this.array, ((Float) r10).floatValue(), this.start, this.end);
            if (r11 >= 0) goto L7;
            return -1;
        L7:
            return r11 - this.start;
        L8:
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r10) {
            if ((r10 instanceof Float) == false) goto L8;
            int r11 = Floats.access$100(this.array, ((Float) r10).floatValue(), this.start, this.end);
            if (r11 >= 0) goto L7;
            return -1;
        L7:
            return r11 - this.start;
        L8:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r10, Object r11) {
            return set(r10, (Float) r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Float> subList(int r10, int r11) {
            Preconditions.checkPositionIndexes(r10, r11, size());
            if (r10 == r11) goto L5;
            float[] r12 = this.array;
            int r13 = this.start;
            return new FloatArrayAsList(r12, r10 + r13, r13 + r11);
        L5:
            return Collections.emptyList();
        }

        public float[] toFloatArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r10 = new StringBuilder(size() * 12);
            r10.append('[');
            r10.append(this.array[this.start]);
            int r11 = this.start;
        L3:
            r11 = r11 + 1;
            if (r11 >= this.end) goto L6;
            r10.append(", ");
            r10.append(this.array[r11]);
            goto L3
        L6:
            r10.append(']');
            return r10.toString();
        }

        public FloatArrayAsList(float[] r10, int r11, int r12) {
            this.array = r10;
            this.start = r11;
            this.end = r12;
        }

        @Override // java.util.AbstractList, java.util.List
        public Float get(int r10) {
            Preconditions.checkElementIndex(r10, size());
            return Float.valueOf(this.array[this.start + r10]);
        }

        public Float set(int r10, Float r11) {
            Preconditions.checkElementIndex(r10, size());
            float[] r12 = this.array;
            int r13 = this.start;
            float r14 = r12[r13 + r10];
            r12[r13 + r10] = ((Float) Preconditions.checkNotNull(r11)).floatValue();
            return Float.valueOf(r14);
        }
    }

    public static final class FloatConverter extends Converter<String, Float> implements Serializable {
        static final FloatConverter INSTANCE = null;
        private static final long serialVersionUID = 1;

        static {
            INSTANCE = new FloatConverter();
        }

        private FloatConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ String doBackward(Float r10) {
            return doBackward2(r10);
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ Float doForward(String r10) {
            return doForward2(r10);
        }

        public String toString() {
            return "Floats.stringConverter()";
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        public String doBackward2(Float r10) {
            return r10.toString();
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        public Float doForward2(String r10) {
            return Float.valueOf(r10);
        }
    }

    public static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<float[]> {
        private static final /* synthetic */ LexicographicalComparator[] $VALUES = null;
        public static final LexicographicalComparator INSTANCE = null;

        static {
            LexicographicalComparator r10 = new LexicographicalComparator("INSTANCE", 0);
            INSTANCE = r10;
            $VALUES = new LexicographicalComparator[]{r10};
        }

        private LexicographicalComparator(String r10, int r11) {
            super(r10, r11);
        }

        public static LexicographicalComparator valueOf(String r10) {
            return (LexicographicalComparator) Enum.valueOf(LexicographicalComparator.class, r10);
        }

        public static LexicographicalComparator[] values() {
            return (LexicographicalComparator[]) $VALUES.clone();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(float[] r10, float[] r11) {
            return compare2(r10, r11);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Floats.lexicographicalComparator()";
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(float[] r10, float[] r11) {
            int r12 = Math.min(r10.length, r11.length);
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            int r14 = Float.compare(r10[r13], r11[r13]);
            if (r14 != 0) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return r14;
        L9:
            return r10.length - r11.length;
        }
    }

    private Floats() {
    }

    public static /* synthetic */ int access$000(float[] r10, float r11, int r12, int r13) {
        return indexOf(r10, r11, r12, r13);
    }

    public static /* synthetic */ int access$100(float[] r10, float r11, int r12, int r13) {
        return lastIndexOf(r10, r11, r12, r13);
    }

    public static List<Float> asList(float... r10) {
        if (r10.length != 0) goto L7;
        return Collections.emptyList();
    L7:
        return new FloatArrayAsList(r10);
    }

    public static int compare(float r10, float r11) {
        return Float.compare(r10, r11);
    }

    public static float[] concat(float[]... r10) {
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r13 = r13 + r10[r12].length;
        r12 = r12 + 1;
        goto L3
    L5:
        float[] r14 = new float[r13];
        int r15 = r10.length;
        int r16 = 0;
        int r17 = 0;
    L6:
        if (r16 >= r15) goto L8;
        float[] r18 = r10[r16];
        System.arraycopy(r18, 0, r14, r17, r18.length);
        r17 = r17 + r18.length;
        r16 = r16 + 1;
        goto L6
    L8:
        return r14;
    }

    @Beta
    public static float constrainToRange(float r10, float r11, float r12) {
        if (r11 > r12) goto L5;
        boolean r13 = true;
    L6:
        Preconditions.checkArgument(r13, "min (%s) must be less than or equal to max (%s)", Float.valueOf(r11), Float.valueOf(r12));
        return Math.min(Math.max(r10, r11), r12);
    L5:
        r13 = false;
        goto L6
    }

    public static boolean contains(float[] r10, float r11) {
        int r12 = r10.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r10[r13] == r11) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static float[] ensureCapacity(float[] r10, int r11, int r12) {
        boolean r13 = false;
        if (r11 < 0) goto L5;
        boolean r14 = true;
    L6:
        Preconditions.checkArgument(r14, "Invalid minLength: %s", r11);
        if (r12 < 0) goto L9;
        r13 = true;
    L9:
        Preconditions.checkArgument(r13, "Invalid padding: %s", r12);
        if (r10.length < r11) goto L12;
        return r10;
    L12:
        return Arrays.copyOf(r10, r11 + r12);
    L5:
        r14 = false;
        goto L6
    }

    public static int hashCode(float r10) {
        return Float.valueOf(r10).hashCode();
    }

    public static int indexOf(float[] r10, float r11) {
        return indexOf(r10, r11, 0, r10.length);
    }

    public static boolean isFinite(float r10) {
        if (Float.NEGATIVE_INFINITY < r10) goto L5;
    L7:
        return false;
    L5:
        if (r10 >= Float.POSITIVE_INFINITY) goto L7;
        return true;
    }

    public static String join(String r10, float... r11) {
        Preconditions.checkNotNull(r10);
        if (r11.length != 0) goto L6;
        return "";
    L6:
        StringBuilder r12 = new StringBuilder(r11.length * 12);
        r12.append(r11[0]);
        int r13 = 1;
    L8:
        if (r13 >= r11.length) goto L11;
        r12.append(r10);
        r12.append(r11[r13]);
        r13 = r13 + 1;
        goto L8
    L11:
        return r12.toString();
    }

    public static int lastIndexOf(float[] r10, float r11) {
        return lastIndexOf(r10, r11, 0, r10.length);
    }

    public static Comparator<float[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static float max(float... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        float r13 = r10[0];
    L8:
        if (r11 >= r10.length) goto L10;
        r13 = Math.max(r13, r10[r11]);
        r11 = r11 + 1;
        goto L8
    L10:
        return r13;
    L5:
        r12 = false;
        goto L6
    }

    public static float min(float... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        float r13 = r10[0];
    L8:
        if (r11 >= r10.length) goto L10;
        r13 = Math.min(r13, r10[r11]);
        r11 = r11 + 1;
        goto L8
    L10:
        return r13;
    L5:
        r12 = false;
        goto L6
    }

    public static void reverse(float[] r10) {
        Preconditions.checkNotNull(r10);
        reverse(r10, 0, r10.length);
    }

    public static void sortDescending(float[] r10) {
        Preconditions.checkNotNull(r10);
        sortDescending(r10, 0, r10.length);
    }

    @Beta
    public static Converter<String, Float> stringConverter() {
        return FloatConverter.INSTANCE;
    }

    public static float[] toArray(Collection<? extends Number> r10) {
        if ((r10 instanceof FloatArrayAsList) == true) goto L5;
        Object[] r11 = r10.toArray();
        int r12 = r11.length;
        float[] r13 = new float[r12];
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L9;
        r13[r14] = ((Number) Preconditions.checkNotNull(r11[r14])).floatValue();
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return ((FloatArrayAsList) r10).toFloatArray();
    }

    @Beta
    @NullableDecl
    @GwtIncompatible
    public static Float tryParse(String r10) {
        if (Doubles.FLOATING_POINT_PATTERN.matcher(r10).matches() == true) goto L9;
        return null;
    L9:
        return Float.valueOf(Float.parseFloat(r10));
    L11:
        return null;
    }

    private static int indexOf(float[] r10, float r11, int r12, int r13) {
    L2:
        if (r12 >= r13) goto L7;
        if (r10[r12] == r11) goto L5;
        r12 = r12 + 1;
        goto L2
    L5:
        return r12;
    L7:
        return -1;
    }

    private static int lastIndexOf(float[] r10, float r11, int r12, int r13) {
        int r14 = r13 - 1;
    L3:
        if (r14 < r12) goto L8;
        if (r10[r14] == r11) goto L6;
        r14 = r14 - 1;
        goto L3
    L6:
        return r14;
    L8:
        return -1;
    }

    public static int indexOf(float[] r10, float[] r11) {
        Preconditions.checkNotNull(r10, "array");
        Preconditions.checkNotNull(r11, "target");
        if (r11.length != 0) goto L5;
        return 0;
    L5:
        int r12 = 0;
    L7:
        if (r12 >= ((r10.length - r11.length) + 1)) goto L16;
        int r13 = 0;
    L10:
        if (r13 >= r11.length) goto L15;
        if (r10[r12 + r13] != r11[r13]) goto L13;
        r13 = r13 + 1;
        goto L10
    L13:
        r12 = r12 + 1;
        goto L7
    L15:
        return r12;
    L16:
        return -1;
    }

    public static void reverse(float[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkPositionIndexes(r11, r12, r10.length);
        int r13 = r12 - 1;
    L3:
        if (r11 >= r13) goto L5;
        float r14 = r10[r11];
        r10[r11] = r10[r13];
        r10[r13] = r14;
        r11 = r11 + 1;
        r13 = r13 - 1;
        goto L3
    }

    public static void sortDescending(float[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkPositionIndexes(r11, r12, r10.length);
        Arrays.sort(r10, r11, r12);
        reverse(r10, r11, r12);
    }
}
