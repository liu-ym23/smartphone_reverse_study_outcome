package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Ascii;
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
import kotlinx.coroutines.channels.Channel;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Ints {
    public static final int BYTES = 4;
    public static final int MAX_POWER_OF_TWO = 1073741824;

    @GwtCompatible
    public static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final int[] array;
        final int end;
        final int start;

        public IntArrayAsList(int[] r10) {
            this(r10, 0, r10.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r10) {
            if ((r10 instanceof Integer) == true) goto L5;
        L7:
            return false;
        L5:
            if (Ints.access$000(this.array, ((Integer) r10).intValue(), this.start, this.end) == (-1)) goto L7;
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof IntArrayAsList) == false) goto L18;
            IntArrayAsList r11 = (IntArrayAsList) r10;
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
            r11 = (r11 * 31) + Ints.hashCode(this.array[r10]);
            r10 = r10 + 1;
            goto L4
        L6:
            return r11;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r10) {
            if ((r10 instanceof Integer) == false) goto L8;
            int r11 = Ints.access$000(this.array, ((Integer) r10).intValue(), this.start, this.end);
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
            if ((r10 instanceof Integer) == false) goto L8;
            int r11 = Ints.access$100(this.array, ((Integer) r10).intValue(), this.start, this.end);
            if (r11 >= 0) goto L7;
            return -1;
        L7:
            return r11 - this.start;
        L8:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r10, Object r11) {
            return set(r10, (Integer) r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int r10, int r11) {
            Preconditions.checkPositionIndexes(r10, r11, size());
            if (r10 == r11) goto L5;
            int[] r12 = this.array;
            int r13 = this.start;
            return new IntArrayAsList(r12, r10 + r13, r13 + r11);
        L5:
            return Collections.emptyList();
        }

        public int[] toIntArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r10 = new StringBuilder(size() * 5);
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

        public IntArrayAsList(int[] r10, int r11, int r12) {
            this.array = r10;
            this.start = r11;
            this.end = r12;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int r10) {
            Preconditions.checkElementIndex(r10, size());
            return Integer.valueOf(this.array[this.start + r10]);
        }

        public Integer set(int r10, Integer r11) {
            Preconditions.checkElementIndex(r10, size());
            int[] r12 = this.array;
            int r13 = this.start;
            int r14 = r12[r13 + r10];
            r12[r13 + r10] = ((Integer) Preconditions.checkNotNull(r11)).intValue();
            return Integer.valueOf(r14);
        }
    }

    public static final class IntConverter extends Converter<String, Integer> implements Serializable {
        static final IntConverter INSTANCE = null;
        private static final long serialVersionUID = 1;

        static {
            INSTANCE = new IntConverter();
        }

        private IntConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ String doBackward(Integer r10) {
            return doBackward2(r10);
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ Integer doForward(String r10) {
            return doForward2(r10);
        }

        public String toString() {
            return "Ints.stringConverter()";
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        public String doBackward2(Integer r10) {
            return r10.toString();
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        public Integer doForward2(String r10) {
            return Integer.decode(r10);
        }
    }

    public static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<int[]> {
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
        public /* bridge */ /* synthetic */ int compare(int[] r10, int[] r11) {
            return compare2(r10, r11);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Ints.lexicographicalComparator()";
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(int[] r10, int[] r11) {
            int r12 = Math.min(r10.length, r11.length);
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            int r14 = Ints.compare(r10[r13], r11[r13]);
            if (r14 != 0) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return r14;
        L9:
            return r10.length - r11.length;
        }
    }

    private Ints() {
    }

    public static /* synthetic */ int access$000(int[] r10, int r11, int r12, int r13) {
        return indexOf(r10, r11, r12, r13);
    }

    public static /* synthetic */ int access$100(int[] r10, int r11, int r12, int r13) {
        return lastIndexOf(r10, r11, r12, r13);
    }

    public static List<Integer> asList(int... r10) {
        if (r10.length != 0) goto L7;
        return Collections.emptyList();
    L7:
        return new IntArrayAsList(r10);
    }

    public static int checkedCast(long r10) {
        int r11 = (int) r10;
        if (r11 != r10) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "Out of range: %s", r10);
        return r11;
    L5:
        r12 = false;
        goto L6
    }

    public static int compare(int r10, int r11) {
        if (r10 >= r11) goto L4;
        return -1;
    L4:
        if (r10 <= r11) goto L6;
        return 1;
    L6:
        return 0;
    }

    public static int[] concat(int[]... r10) {
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r13 = r13 + r10[r12].length;
        r12 = r12 + 1;
        goto L3
    L5:
        int[] r14 = new int[r13];
        int r15 = r10.length;
        int r16 = 0;
        int r17 = 0;
    L6:
        if (r16 >= r15) goto L8;
        int[] r18 = r10[r16];
        System.arraycopy(r18, 0, r14, r17, r18.length);
        r17 = r17 + r18.length;
        r16 = r16 + 1;
        goto L6
    L8:
        return r14;
    }

    @Beta
    public static int constrainToRange(int r10, int r11, int r12) {
        if (r11 > r12) goto L4;
        boolean r13 = true;
    L5:
        Preconditions.checkArgument(r13, "min (%s) must be less than or equal to max (%s)", r11, r12);
        return Math.min(Math.max(r10, r11), r12);
    L4:
        r13 = false;
        goto L5
    }

    public static boolean contains(int[] r10, int r11) {
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

    public static int[] ensureCapacity(int[] r10, int r11, int r12) {
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

    public static int fromByteArray(byte[] r10) {
        if (r10.length < 4) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "array too small: %s < %s", r10.length, 4);
        return fromBytes(r10[0], r10[1], r10[2], r10[3]);
    L5:
        r11 = false;
        goto L6
    }

    public static int fromBytes(byte r10, byte r11, byte r12, byte r13) {
        return (((r10 << Ascii.CAN) | ((r11 & UnsignedBytes.MAX_VALUE) << 16)) | ((r12 & UnsignedBytes.MAX_VALUE) << 8)) | (r13 & UnsignedBytes.MAX_VALUE);
    }

    public static int hashCode(int r10) {
        return r10;
    }

    public static int indexOf(int[] r10, int r11) {
        return indexOf(r10, r11, 0, r10.length);
    }

    public static String join(String r10, int... r11) {
        Preconditions.checkNotNull(r10);
        if (r11.length != 0) goto L6;
        return "";
    L6:
        StringBuilder r12 = new StringBuilder(r11.length * 5);
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

    public static int lastIndexOf(int[] r10, int r11) {
        return lastIndexOf(r10, r11, 0, r10.length);
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static int max(int... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        int r13 = r10[0];
    L8:
        if (r11 >= r10.length) goto L13;
        int r14 = r10[r11];
        if (r14 <= r13) goto L12;
        r13 = r14;
    L12:
        r11 = r11 + 1;
        goto L8
    L13:
        return r13;
    L5:
        r12 = false;
        goto L6
    }

    public static int min(int... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        int r13 = r10[0];
    L8:
        if (r11 >= r10.length) goto L13;
        int r14 = r10[r11];
        if (r14 >= r13) goto L12;
        r13 = r14;
    L12:
        r11 = r11 + 1;
        goto L8
    L13:
        return r13;
    L5:
        r12 = false;
        goto L6
    }

    public static void reverse(int[] r10) {
        Preconditions.checkNotNull(r10);
        reverse(r10, 0, r10.length);
    }

    public static int saturatedCast(long r10) {
        if (r10 <= 2147483647L) goto L7;
        return Channel.UNLIMITED;
    L7:
        if (r10 >= (-2147483648L)) goto L11;
        return Integer.MIN_VALUE;
    L11:
        return (int) r10;
    }

    public static void sortDescending(int[] r10) {
        Preconditions.checkNotNull(r10);
        sortDescending(r10, 0, r10.length);
    }

    @Beta
    public static Converter<String, Integer> stringConverter() {
        return IntConverter.INSTANCE;
    }

    public static int[] toArray(Collection<? extends Number> r10) {
        if ((r10 instanceof IntArrayAsList) == true) goto L5;
        Object[] r11 = r10.toArray();
        int r12 = r11.length;
        int[] r13 = new int[r12];
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L9;
        r13[r14] = ((Number) Preconditions.checkNotNull(r11[r14])).intValue();
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return ((IntArrayAsList) r10).toIntArray();
    }

    public static byte[] toByteArray(int r10) {
        return new byte[]{(byte) (r10 >> 24), (byte) (r10 >> 16), (byte) (r10 >> 8), (byte) r10};
    }

    @Beta
    @NullableDecl
    public static Integer tryParse(String r10) {
        return tryParse(r10, 10);
    }

    private static int indexOf(int[] r10, int r11, int r12, int r13) {
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

    private static int lastIndexOf(int[] r10, int r11, int r12, int r13) {
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

    @Beta
    @NullableDecl
    public static Integer tryParse(String r10, int r11) {
        Long r12 = Longs.tryParse(r10, r11);
        if (r12 != null) goto L5;
        return null;
    L5:
        if (r12.longValue() == r12.intValue()) goto L8;
        return null;
    L8:
        return Integer.valueOf(r12.intValue());
    }

    public static int indexOf(int[] r10, int[] r11) {
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

    public static void reverse(int[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkPositionIndexes(r11, r12, r10.length);
        int r13 = r12 - 1;
    L3:
        if (r11 >= r13) goto L5;
        int r14 = r10[r11];
        r10[r11] = r10[r13];
        r10[r13] = r14;
        r11 = r11 + 1;
        r13 = r13 - 1;
        goto L3
    }

    public static void sortDescending(int[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkPositionIndexes(r11, r12, r10.length);
        Arrays.sort(r10, r11, r12);
        reverse(r10, r11, r12);
    }
}
