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
public final class Shorts {
    public static final int BYTES = 2;
    public static final short MAX_POWER_OF_TWO = 16384;

    public static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<short[]> {
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
        public /* bridge */ /* synthetic */ int compare(short[] r10, short[] r11) {
            return compare2(r10, r11);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Shorts.lexicographicalComparator()";
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(short[] r10, short[] r11) {
            int r12 = Math.min(r10.length, r11.length);
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            int r14 = Shorts.compare(r10[r13], r11[r13]);
            if (r14 != 0) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return r14;
        L9:
            return r10.length - r11.length;
        }
    }

    @GwtCompatible
    public static class ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final short[] array;
        final int end;
        final int start;

        public ShortArrayAsList(short[] r10) {
            this(r10, 0, r10.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@NullableDecl Object r10) {
            if ((r10 instanceof Short) == true) goto L5;
        L7:
            return false;
        L5:
            if (Shorts.access$000(this.array, ((Short) r10).shortValue(), this.start, this.end) == (-1)) goto L7;
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof ShortArrayAsList) == false) goto L18;
            ShortArrayAsList r11 = (ShortArrayAsList) r10;
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
            r11 = (r11 * 31) + Shorts.hashCode(this.array[r10]);
            r10 = r10 + 1;
            goto L4
        L6:
            return r11;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@NullableDecl Object r10) {
            if ((r10 instanceof Short) == false) goto L8;
            int r11 = Shorts.access$000(this.array, ((Short) r10).shortValue(), this.start, this.end);
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
        public int lastIndexOf(@NullableDecl Object r10) {
            if ((r10 instanceof Short) == false) goto L8;
            int r11 = Shorts.access$100(this.array, ((Short) r10).shortValue(), this.start, this.end);
            if (r11 >= 0) goto L7;
            return -1;
        L7:
            return r11 - this.start;
        L8:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r10, Object r11) {
            return set(r10, (Short) r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Short> subList(int r10, int r11) {
            Preconditions.checkPositionIndexes(r10, r11, size());
            if (r10 == r11) goto L5;
            short[] r12 = this.array;
            int r13 = this.start;
            return new ShortArrayAsList(r12, r10 + r13, r13 + r11);
        L5:
            return Collections.emptyList();
        }

        public short[] toShortArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r10 = new StringBuilder(size() * 6);
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

        public ShortArrayAsList(short[] r10, int r11, int r12) {
            this.array = r10;
            this.start = r11;
            this.end = r12;
        }

        @Override // java.util.AbstractList, java.util.List
        public Short get(int r10) {
            Preconditions.checkElementIndex(r10, size());
            return Short.valueOf(this.array[this.start + r10]);
        }

        public Short set(int r10, Short r11) {
            Preconditions.checkElementIndex(r10, size());
            short[] r12 = this.array;
            int r13 = this.start;
            short r14 = r12[r13 + r10];
            r12[r13 + r10] = ((Short) Preconditions.checkNotNull(r11)).shortValue();
            return Short.valueOf(r14);
        }
    }

    public static final class ShortConverter extends Converter<String, Short> implements Serializable {
        static final ShortConverter INSTANCE = null;
        private static final long serialVersionUID = 1;

        static {
            INSTANCE = new ShortConverter();
        }

        private ShortConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ String doBackward(Short r10) {
            return doBackward2(r10);
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ Short doForward(String r10) {
            return doForward2(r10);
        }

        public String toString() {
            return "Shorts.stringConverter()";
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        public String doBackward2(Short r10) {
            return r10.toString();
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        public Short doForward2(String r10) {
            return Short.decode(r10);
        }
    }

    private Shorts() {
    }

    public static /* synthetic */ int access$000(short[] r10, short r11, int r12, int r13) {
        return indexOf(r10, r11, r12, r13);
    }

    public static /* synthetic */ int access$100(short[] r10, short r11, int r12, int r13) {
        return lastIndexOf(r10, r11, r12, r13);
    }

    public static List<Short> asList(short... r10) {
        if (r10.length != 0) goto L7;
        return Collections.emptyList();
    L7:
        return new ShortArrayAsList(r10);
    }

    public static short checkedCast(long r10) {
        short r11 = (short) r10;
        if (r11 != r10) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "Out of range: %s", r10);
        return r11;
    L5:
        r12 = false;
        goto L6
    }

    public static int compare(short r10, short r11) {
        return r10 - r11;
    }

    public static short[] concat(short[]... r10) {
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r13 = r13 + r10[r12].length;
        r12 = r12 + 1;
        goto L3
    L5:
        short[] r14 = new short[r13];
        int r15 = r10.length;
        int r16 = 0;
        int r17 = 0;
    L6:
        if (r16 >= r15) goto L8;
        short[] r18 = r10[r16];
        System.arraycopy(r18, 0, r14, r17, r18.length);
        r17 = r17 + r18.length;
        r16 = r16 + 1;
        goto L6
    L8:
        return r14;
    }

    @Beta
    public static short constrainToRange(short r10, short r11, short r12) {
        if (r11 > r12) goto L4;
        boolean r13 = true;
    L5:
        Preconditions.checkArgument(r13, "min (%s) must be less than or equal to max (%s)", r11, r12);
        if (r10 < r11) goto L12;
        if (r10 >= r12) goto L11;
        return r10;
    L11:
        return r12;
    L12:
        return r11;
    L4:
        r13 = false;
        goto L5
    }

    public static boolean contains(short[] r10, short r11) {
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

    public static short[] ensureCapacity(short[] r10, int r11, int r12) {
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

    @GwtIncompatible
    public static short fromByteArray(byte[] r10) {
        if (r10.length < 2) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "array too small: %s < %s", r10.length, 2);
        return fromBytes(r10[0], r10[1]);
    L5:
        r11 = false;
        goto L6
    }

    @GwtIncompatible
    public static short fromBytes(byte r10, byte r11) {
        return (short) ((r10 << 8) | (r11 & UnsignedBytes.MAX_VALUE));
    }

    public static int hashCode(short r10) {
        return r10;
    }

    public static int indexOf(short[] r10, short r11) {
        return indexOf(r10, r11, 0, r10.length);
    }

    public static String join(String r10, short... r11) {
        Preconditions.checkNotNull(r10);
        if (r11.length != 0) goto L6;
        return "";
    L6:
        StringBuilder r12 = new StringBuilder(r11.length * 6);
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

    public static int lastIndexOf(short[] r10, short r11) {
        return lastIndexOf(r10, r11, 0, r10.length);
    }

    public static Comparator<short[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static short max(short... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        short r13 = r10[0];
    L8:
        if (r11 >= r10.length) goto L13;
        short r14 = r10[r11];
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

    public static short min(short... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        short r13 = r10[0];
    L8:
        if (r11 >= r10.length) goto L13;
        short r14 = r10[r11];
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

    public static void reverse(short[] r10) {
        Preconditions.checkNotNull(r10);
        reverse(r10, 0, r10.length);
    }

    public static short saturatedCast(long r10) {
        if (r10 <= 32767) goto L7;
        return Short.MAX_VALUE;
    L7:
        if (r10 >= (-32768)) goto L11;
        return Short.MIN_VALUE;
    L11:
        return (short) r10;
    }

    public static void sortDescending(short[] r10) {
        Preconditions.checkNotNull(r10);
        sortDescending(r10, 0, r10.length);
    }

    @Beta
    public static Converter<String, Short> stringConverter() {
        return ShortConverter.INSTANCE;
    }

    public static short[] toArray(Collection<? extends Number> r10) {
        if ((r10 instanceof ShortArrayAsList) == true) goto L5;
        Object[] r11 = r10.toArray();
        int r12 = r11.length;
        short[] r13 = new short[r12];
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L9;
        r13[r14] = ((Number) Preconditions.checkNotNull(r11[r14])).shortValue();
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return ((ShortArrayAsList) r10).toShortArray();
    }

    @GwtIncompatible
    public static byte[] toByteArray(short r10) {
        return new byte[]{(byte) (r10 >> 8), (byte) r10};
    }

    private static int indexOf(short[] r10, short r11, int r12, int r13) {
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

    private static int lastIndexOf(short[] r10, short r11, int r12, int r13) {
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

    public static int indexOf(short[] r10, short[] r11) {
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

    public static void reverse(short[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkPositionIndexes(r11, r12, r10.length);
        int r13 = r12 - 1;
    L3:
        if (r11 >= r13) goto L5;
        short r14 = r10[r11];
        r10[r11] = r10[r13];
        r10[r13] = r14;
        r11 = r11 + 1;
        r13 = r13 - 1;
        goto L3
    }

    public static void sortDescending(short[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkPositionIndexes(r11, r12, r10.length);
        Arrays.sort(r10, r11, r12);
        reverse(r10, r11, r12);
    }
}
