package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
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
@GwtCompatible
public final class Longs {
    public static final int BYTES = 8;
    public static final long MAX_POWER_OF_TWO = 4611686018427387904L;

    public static final class AsciiDigits {
        private static final byte[] asciiDigits = null;

        static {
            byte[] r10 = new byte[128];
            Arrays.fill(r10, (byte) -1);
            int r11 = 0;
            int r12 = 0;
        L4:
            if (r12 > 9) goto L7;
            r10[r12 + 48] = (byte) r12;
            r12 = r12 + 1;
        L7:
            if (r11 > 26) goto L9;
            byte r13 = (byte) (r11 + 10);
            r10[r11 + 65] = r13;
            r10[r11 + 97] = r13;
            r11 = r11 + 1;
            goto L7
        L9:
            asciiDigits = r10;
        }

        private AsciiDigits() {
        }

        public static int digit(char r10) {
            if (r10 < 128) goto L7;
            return -1;
        L7:
            return asciiDigits[r10];
        }
    }

    public static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<long[]> {
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
        public /* bridge */ /* synthetic */ int compare(long[] r10, long[] r11) {
            return compare2(r10, r11);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Longs.lexicographicalComparator()";
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(long[] r10, long[] r11) {
            int r12 = Math.min(r10.length, r11.length);
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            int r14 = Longs.compare(r10[r13], r11[r13]);
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
    public static class LongArrayAsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final long[] array;
        final int end;
        final int start;

        public LongArrayAsList(long[] r10) {
            this(r10, 0, r10.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r10) {
            if ((r10 instanceof Long) == true) goto L5;
        L7:
            return false;
        L5:
            if (Longs.access$000(this.array, ((Long) r10).longValue(), this.start, this.end) == (-1)) goto L7;
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof LongArrayAsList) == false) goto L18;
            LongArrayAsList r11 = (LongArrayAsList) r10;
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
            r11 = (r11 * 31) + Longs.hashCode(this.array[r10]);
            r10 = r10 + 1;
            goto L4
        L6:
            return r11;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r10) {
            if ((r10 instanceof Long) == false) goto L8;
            int r11 = Longs.access$000(this.array, ((Long) r10).longValue(), this.start, this.end);
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
            if ((r10 instanceof Long) == false) goto L8;
            int r11 = Longs.access$100(this.array, ((Long) r10).longValue(), this.start, this.end);
            if (r11 >= 0) goto L7;
            return -1;
        L7:
            return r11 - this.start;
        L8:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r10, Object r11) {
            return set(r10, (Long) r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int r10, int r11) {
            Preconditions.checkPositionIndexes(r10, r11, size());
            if (r10 == r11) goto L5;
            long[] r12 = this.array;
            int r13 = this.start;
            return new LongArrayAsList(r12, r10 + r13, r13 + r11);
        L5:
            return Collections.emptyList();
        }

        public long[] toLongArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r10 = new StringBuilder(size() * 10);
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

        public LongArrayAsList(long[] r10, int r11, int r12) {
            this.array = r10;
            this.start = r11;
            this.end = r12;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int r10) {
            Preconditions.checkElementIndex(r10, size());
            return Long.valueOf(this.array[this.start + r10]);
        }

        public Long set(int r10, Long r11) {
            Preconditions.checkElementIndex(r10, size());
            long[] r12 = this.array;
            int r13 = this.start;
            long r14 = r12[r13 + r10];
            r12[r13 + r10] = ((Long) Preconditions.checkNotNull(r11)).longValue();
            return Long.valueOf(r14);
        }
    }

    public static final class LongConverter extends Converter<String, Long> implements Serializable {
        static final LongConverter INSTANCE = null;
        private static final long serialVersionUID = 1;

        static {
            INSTANCE = new LongConverter();
        }

        private LongConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ String doBackward(Long r10) {
            return doBackward2(r10);
        }

        @Override // com.google.common.base.Converter
        public /* bridge */ /* synthetic */ Long doForward(String r10) {
            return doForward2(r10);
        }

        public String toString() {
            return "Longs.stringConverter()";
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        public String doBackward2(Long r10) {
            return r10.toString();
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        public Long doForward2(String r10) {
            return Long.decode(r10);
        }
    }

    private Longs() {
    }

    public static /* synthetic */ int access$000(long[] r10, long r11, int r12, int r13) {
        return indexOf(r10, r11, r12, r13);
    }

    public static /* synthetic */ int access$100(long[] r10, long r11, int r12, int r13) {
        return lastIndexOf(r10, r11, r12, r13);
    }

    public static List<Long> asList(long... r10) {
        if (r10.length != 0) goto L7;
        return Collections.emptyList();
    L7:
        return new LongArrayAsList(r10);
    }

    public static int compare(long r10, long r11) {
        if (r10 >= r11) goto L5;
        return -1;
    L5:
        if (r10 <= r11) goto L7;
        return 1;
    L7:
        return 0;
    }

    public static long[] concat(long[]... r10) {
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r13 = r13 + r10[r12].length;
        r12 = r12 + 1;
        goto L3
    L5:
        long[] r14 = new long[r13];
        int r15 = r10.length;
        int r16 = 0;
        int r17 = 0;
    L6:
        if (r16 >= r15) goto L8;
        long[] r18 = r10[r16];
        System.arraycopy(r18, 0, r14, r17, r18.length);
        r17 = r17 + r18.length;
        r16 = r16 + 1;
        goto L6
    L8:
        return r14;
    }

    @Beta
    public static long constrainToRange(long r10, long r11, long r12) {
        if (r11 > r12) goto L6;
        boolean r13 = true;
    L7:
        Preconditions.checkArgument(r13, "min (%s) must be less than or equal to max (%s)", r11, r12);
        return Math.min(Math.max(r10, r11), r12);
    L6:
        r13 = false;
        goto L7
    }

    public static boolean contains(long[] r10, long r11) {
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

    public static long[] ensureCapacity(long[] r10, int r11, int r12) {
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

    public static long fromByteArray(byte[] r14) {
        if (r14.length < 8) goto L5;
        boolean r10 = true;
    L6:
        Preconditions.checkArgument(r10, "array too small: %s < %s", r14.length, 8);
        return fromBytes(r14[0], r14[1], r14[2], r14[3], r14[4], r14[5], r14[6], r14[7]);
    L5:
        r10 = false;
        goto L6
    }

    public static long fromBytes(byte r10, byte r11, byte r12, byte r13, byte r14, byte r15, byte r16, byte r17) {
        long r18 = (((long) r10) & 255) << 56;
        return ((((((((((long) r11) & 255) << 48) | r18) | ((((long) r12) & 255) << 40)) | ((((long) r13) & 255) << 32)) | ((((long) r14) & 255) << 24)) | ((((long) r15) & 255) << 16)) | ((((long) r16) & 255) << 8)) | (((long) r17) & 255);
    }

    public static int hashCode(long r10) {
        return (int) (r10 ^ (r10 >>> 32));
    }

    public static int indexOf(long[] r10, long r11) {
        return indexOf(r10, r11, 0, r10.length);
    }

    public static String join(String r10, long... r11) {
        Preconditions.checkNotNull(r10);
        if (r11.length != 0) goto L6;
        return "";
    L6:
        StringBuilder r12 = new StringBuilder(r11.length * 10);
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

    public static int lastIndexOf(long[] r10, long r11) {
        return lastIndexOf(r10, r11, 0, r10.length);
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long max(long... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        long r13 = r10[0];
    L8:
        if (r11 >= r10.length) goto L13;
        long r14 = r10[r11];
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

    public static long min(long... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        long r13 = r10[0];
    L8:
        if (r11 >= r10.length) goto L13;
        long r14 = r10[r11];
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

    public static void reverse(long[] r10) {
        Preconditions.checkNotNull(r10);
        reverse(r10, 0, r10.length);
    }

    public static void sortDescending(long[] r10) {
        Preconditions.checkNotNull(r10);
        sortDescending(r10, 0, r10.length);
    }

    @Beta
    public static Converter<String, Long> stringConverter() {
        return LongConverter.INSTANCE;
    }

    public static long[] toArray(Collection<? extends Number> r10) {
        if ((r10 instanceof LongArrayAsList) == true) goto L5;
        Object[] r11 = r10.toArray();
        int r12 = r11.length;
        long[] r13 = new long[r12];
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L9;
        r13[r14] = ((Number) Preconditions.checkNotNull(r11[r14])).longValue();
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return ((LongArrayAsList) r10).toLongArray();
    }

    public static byte[] toByteArray(long r10) {
        byte[] r11 = new byte[8];
        int r12 = 7;
    L3:
        if (r12 < 0) goto L5;
        r11[r12] = (byte) (255 & r10);
        r10 = r10 >> 8;
        r12 = r12 - 1;
        goto L3
    L5:
        return r11;
    }

    @Beta
    @NullableDecl
    public static Long tryParse(String r10) {
        return tryParse(r10, 10);
    }

    private static int indexOf(long[] r10, long r11, int r12, int r13) {
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

    private static int lastIndexOf(long[] r10, long r11, int r12, int r13) {
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
    public static Long tryParse(String r18, int r19) {
        if (((String) Preconditions.checkNotNull(r18)).isEmpty() == false) goto L6;
        return null;
    L6:
        if (r19 < 2) goto L43;
        if (r19 > 36) goto L43;
        int r10 = 0;
        if (r18.charAt(0) != '-') goto L13;
        r10 = 1;
    L13:
        if (r10 != r18.length()) goto L15;
        return null;
    L15:
        int r11 = r10 + 1;
        int r12 = AsciiDigits.digit(r18.charAt(r10));
        if (r12 < 0) goto L41;
        if (r12 >= r19) goto L41;
        long r13 = -r12;
        long r14 = r19;
        long r15 = Long.MIN_VALUE / r14;
    L21:
        if (r11 >= r18.length()) goto L33;
        int r16 = r11 + 1;
        int r17 = AsciiDigits.digit(r18.charAt(r11));
        if (r17 < 0) goto L32;
        if (r17 >= r19) goto L32;
        if (r13 < r15) goto L32;
        long r20 = r13 * r14;
        long r110 = r17;
        if (r20 < (r110 - Long.MIN_VALUE)) goto L30;
        r13 = r20 - r110;
        r11 = r16;
        goto L21
    L30:
        return null;
    L32:
        return null;
    L33:
        if (r10 == 0) goto L37;
        return Long.valueOf(r13);
    L37:
        if (r13 != Long.MIN_VALUE) goto L40;
        return null;
    L40:
        return Long.valueOf(-r13);
    L41:
        return null;
    L43:
        throw new IllegalArgumentException("radix must be between MIN_RADIX and MAX_RADIX but was " + r19);
    }

    public static int indexOf(long[] r10, long[] r11) {
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

    public static void reverse(long[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkPositionIndexes(r11, r12, r10.length);
        int r13 = r12 - 1;
    L3:
        if (r11 >= r13) goto L5;
        long r14 = r10[r11];
        r10[r11] = r10[r13];
        r10[r13] = r14;
        r11 = r11 + 1;
        r13 = r13 - 1;
        goto L3
    }

    public static void sortDescending(long[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkPositionIndexes(r11, r12, r10.length);
        Arrays.sort(r10, r11, r12);
        reverse(r10, r11, r12);
    }
}
