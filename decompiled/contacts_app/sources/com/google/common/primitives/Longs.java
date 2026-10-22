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

/* JADX INFO: loaded from: classes2.dex */
public final class Longs {
    public static final int BYTES = 8;
    public static final long MAX_POWER_OF_TWO = 4611686018427387904L;

    private static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<long[]> {
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
        public /* bridge */ /* synthetic */ int compare(long[] r1, long[] r2) {
            return compare2(r1, r2);
        }

        static {
            LexicographicalComparator r0 = new LexicographicalComparator("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new LexicographicalComparator[]{r0};
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(long[] r6, long[] r7) {
            int r5 = Math.min(r6.length, r7.length);
            int r0 = 0;
        L3:
            if (r0 >= r5) goto L9;
            int r1 = Longs.compare(r6[r0], r7[r0]);
            if (r1 != 0) goto L6;
            r0 = r0 + 1;
            goto L3
        L6:
            return r1;
        L9:
            return r6.length - r7.length;
        }
    }

    private static class LongArrayAsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final long[] array;
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
            return set(r1, (Long) r2);
        }

        LongArrayAsList(long[] r3) {
            this(r3, 0, r3.length);
        }

        LongArrayAsList(long[] r1, int r2, int r3) {
            this.array = r1;
            this.start = r2;
            this.end = r3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int r2) {
            Preconditions.checkElementIndex(r2, size());
            return Long.valueOf(this.array[this.start + r2]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r4) {
            if ((r4 instanceof Long) == true) goto L5;
        L7:
            return false;
        L5:
            if (Longs.access$000(this.array, ((Long) r4).longValue(), this.start, this.end) == (-1)) goto L7;
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r5) {
            if ((r5 instanceof Long) == false) goto L8;
            int r6 = Longs.access$000(this.array, ((Long) r5).longValue(), this.start, this.end);
            if (r6 >= 0) goto L7;
            return -1;
        L7:
            return r6 - this.start;
        L8:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r5) {
            if ((r5 instanceof Long) == false) goto L8;
            int r6 = Longs.access$100(this.array, ((Long) r5).longValue(), this.start, this.end);
            if (r6 >= 0) goto L7;
            return -1;
        L7:
            return r6 - this.start;
        L8:
            return -1;
        }

        public Long set(int r4, Long r5) {
            Preconditions.checkElementIndex(r4, size());
            long[] r0 = this.array;
            int r3 = this.start;
            long r1 = r0[r3 + r4];
            r0[r3 + r4] = ((Long) Preconditions.checkNotNull(r5)).longValue();
            return Long.valueOf(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int r3, int r4) {
            Preconditions.checkPositionIndexes(r3, r4, size());
            if (r3 == r4) goto L5;
            long[] r1 = this.array;
            int r2 = this.start;
            return new LongArrayAsList(r1, r3 + r2, r2 + r4);
        L5:
            return Collections.emptyList();
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object r9) {
            if (r9 != this) goto L6;
            return true;
        L6:
            if ((r9 instanceof LongArrayAsList) == false) goto L18;
            LongArrayAsList r10 = (LongArrayAsList) r9;
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
            r1 = (r1 * 31) + Longs.hashCode(this.array[r0]);
            r0 = r0 + 1;
            goto L4
        L6:
            return r1;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r0 = new StringBuilder(size() * 10);
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

        long[] toLongArray() {
            int r0 = size();
            long[] r1 = new long[r0];
            System.arraycopy(this.array, this.start, r1, 0, r0);
            return r1;
        }
    }

    private static final class LongConverter extends Converter<String, Long> implements Serializable {
        static final LongConverter INSTANCE = null;
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Longs.stringConverter()";
        }

        private LongConverter() {
        }

        @Override // com.google.common.base.Converter
        protected /* bridge */ /* synthetic */ String doBackward(Long r1) {
            return doBackward2(r1);
        }

        @Override // com.google.common.base.Converter
        protected /* bridge */ /* synthetic */ Long doForward(String r1) {
            return doForward2(r1);
        }

        static {
            INSTANCE = new LongConverter();
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        protected Long doForward2(String r1) {
            return Long.decode(r1);
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        protected String doBackward2(Long r1) {
            return r1.toString();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    public static int compare(long r0, long r2) {
        if (r0 >= r2) goto L5;
        return -1;
    L5:
        if (r0 <= r2) goto L7;
        return 1;
    L7:
        return 0;
    }

    public static long fromBytes(byte r5, byte r6, byte r7, byte r8, byte r9, byte r10, byte r11, byte r12) {
        long r0 = (((long) r5) & 255) << 56;
        return ((((((((((long) r6) & 255) << 48) | r0) | ((((long) r7) & 255) << 40)) | ((((long) r8) & 255) << 32)) | ((((long) r9) & 255) << 24)) | ((((long) r10) & 255) << 16)) | ((((long) r11) & 255) << 8)) | (((long) r12) & 255);
    }

    public static int hashCode(long r2) {
        return (int) (r2 ^ (r2 >>> 32));
    }

    static /* synthetic */ int access$000(long[] r0, long r1, int r3, int r4) {
        return indexOf(r0, r1, r3, r4);
    }

    static /* synthetic */ int access$100(long[] r0, long r1, int r3, int r4) {
        return lastIndexOf(r0, r1, r3, r4);
    }

    private Longs() {
    }

    public static boolean contains(long[] r5, long r6) {
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

    public static int indexOf(long[] r2, long r3) {
        return indexOf(r2, r3, 0, r2.length);
    }

    private static int indexOf(long[] r2, long r3, int r5, int r6) {
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

    public static int indexOf(long[] r7, long[] r8) {
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

    public static int lastIndexOf(long[] r2, long r3) {
        return lastIndexOf(r2, r3, 0, r2.length);
    }

    private static int lastIndexOf(long[] r2, long r3, int r5, int r6) {
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

    public static long min(long... r6) {
        int r2 = 1;
        if (r6.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        long r1 = r6[0];
    L8:
        if (r2 >= r6.length) goto L13;
        long r3 = r6[r2];
        if (r3 >= r1) goto L12;
        r1 = r3;
    L12:
        r2 = r2 + 1;
        goto L8
    L13:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public static long max(long... r6) {
        int r2 = 1;
        if (r6.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        long r1 = r6[0];
    L8:
        if (r2 >= r6.length) goto L13;
        long r3 = r6[r2];
        if (r3 <= r1) goto L12;
        r1 = r3;
    L12:
        r2 = r2 + 1;
        goto L8
    L13:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public static long[] concat(long[]... r7) {
        int r0 = r7.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r3 = r3 + r7[r2].length;
        r2 = r2 + 1;
        goto L3
    L5:
        long[] r1 = new long[r3];
        int r4 = r7.length;
        int r5 = 0;
        int r6 = 0;
    L6:
        if (r5 >= r4) goto L8;
        long[] r8 = r7[r5];
        System.arraycopy(r8, 0, r1, r6, r8.length);
        r6 = r6 + r8.length;
        r5 = r5 + 1;
        goto L6
    L8:
        return r1;
    }

    public static byte[] toByteArray(long r5) {
        byte[] r1 = new byte[8];
        int r2 = 7;
    L3:
        if (r2 < 0) goto L5;
        r1[r2] = (byte) (255 & r5);
        r5 = r5 >> 8;
        r2 = r2 - 1;
        goto L3
    L5:
        return r1;
    }

    public static long fromByteArray(byte[] r14) {
        if (r14.length < 8) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "array too small: %s < %s", new Object[]{Integer.valueOf(r14.length), 8});
        return fromBytes(r14[0], r14[1], r14[2], r14[3], r14[4], r14[5], r14[6], r14[7]);
    L5:
        r0 = false;
        goto L6
    }

    public static Long tryParse(String r11) {
        if (((String) Preconditions.checkNotNull(r11)).isEmpty() == false) goto L5;
        return null;
    L5:
        int r0 = 0;
        if (r11.charAt(0) != '-') goto L9;
        r0 = 1;
    L9:
        if (r0 != r11.length()) goto L11;
        return null;
    L11:
        int r2 = r0 + 1;
        int r3 = r11.charAt(r0) - '0';
        if (r3 >= 0) goto L14;
    L38:
        return null;
    L14:
        if (r3 > 9) goto L38;
        long r5 = -r3;
    L18:
        if (r2 >= r11.length()) goto L30;
        int r4 = r2 + 1;
        int r6 = r11.charAt(r2) - '0';
        if (r6 < 0) goto L29;
        if (r6 > 9) goto L29;
        if (r5 < (-922337203685477580L)) goto L29;
        long r7 = r5 * 10;
        long r9 = r6;
        if (r7 < (Long.MIN_VALUE + r9)) goto L27;
        r5 = r7 - r9;
        r2 = r4;
        goto L18
    L27:
        return null;
    L29:
        return null;
    L30:
        if (r0 == 0) goto L34;
        return Long.valueOf(r5);
    L34:
        if (r5 != Long.MIN_VALUE) goto L37;
        return null;
    L37:
        return Long.valueOf(-r5);
    }

    public static Converter<String, Long> stringConverter() {
        return LongConverter.INSTANCE;
    }

    public static long[] ensureCapacity(long[] r5, int r6, int r7) {
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

    private static long[] copyOf(long[] r2, int r3) {
        long[] r0 = new long[r3];
        System.arraycopy(r2, 0, r0, 0, Math.min(r2.length, r3));
        return r0;
    }

    public static String join(String r5, long... r6) {
        Preconditions.checkNotNull(r5);
        if (r6.length != 0) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder(r6.length * 10);
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

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long[] toArray(Collection<? extends Number> r5) {
        if ((r5 instanceof LongArrayAsList) == true) goto L5;
        Object[] r6 = r5.toArray();
        int r0 = r6.length;
        long[] r1 = new long[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        r1[r2] = ((Number) Preconditions.checkNotNull(r6[r2])).longValue();
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    L5:
        return ((LongArrayAsList) r5).toLongArray();
    }

    public static List<Long> asList(long... r1) {
        if (r1.length != 0) goto L7;
        return Collections.emptyList();
    L7:
        return new LongArrayAsList(r1);
    }
}
