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
import kotlin.jvm.internal.ShortCompanionObject;

/* JADX INFO: loaded from: classes2.dex */
public final class Shorts {
    public static final int BYTES = 2;
    public static final short MAX_POWER_OF_TWO = 16384;

    private static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<short[]> {
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
        public /* bridge */ /* synthetic */ int compare(short[] r1, short[] r2) {
            return compare2(r1, r2);
        }

        static {
            LexicographicalComparator r0 = new LexicographicalComparator("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new LexicographicalComparator[]{r0};
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(short[] r4, short[] r5) {
            int r3 = Math.min(r4.length, r5.length);
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L9;
            int r1 = Shorts.compare(r4[r0], r5[r0]);
            if (r1 != 0) goto L6;
            r0 = r0 + 1;
            goto L3
        L6:
            return r1;
        L9:
            return r4.length - r5.length;
        }
    }

    private static class ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final short[] array;
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
            return set(r1, (Short) r2);
        }

        ShortArrayAsList(short[] r3) {
            this(r3, 0, r3.length);
        }

        ShortArrayAsList(short[] r1, int r2, int r3) {
            this.array = r1;
            this.start = r2;
            this.end = r3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Short get(int r2) {
            Preconditions.checkElementIndex(r2, size());
            return Short.valueOf(this.array[this.start + r2]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r3) {
            if ((r3 instanceof Short) == true) goto L5;
        L7:
            return false;
        L5:
            if (Shorts.access$000(this.array, ((Short) r3).shortValue(), this.start, this.end) == (-1)) goto L7;
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r4) {
            if ((r4 instanceof Short) == false) goto L8;
            int r5 = Shorts.access$000(this.array, ((Short) r4).shortValue(), this.start, this.end);
            if (r5 >= 0) goto L7;
            return -1;
        L7:
            return r5 - this.start;
        L8:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r4) {
            if ((r4 instanceof Short) == false) goto L8;
            int r5 = Shorts.access$100(this.array, ((Short) r4).shortValue(), this.start, this.end);
            if (r5 >= 0) goto L7;
            return -1;
        L7:
            return r5 - this.start;
        L8:
            return -1;
        }

        public Short set(int r3, Short r4) {
            Preconditions.checkElementIndex(r3, size());
            short[] r0 = this.array;
            int r2 = this.start;
            short r1 = r0[r2 + r3];
            r0[r2 + r3] = ((Short) Preconditions.checkNotNull(r4)).shortValue();
            return Short.valueOf(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Short> subList(int r3, int r4) {
            Preconditions.checkPositionIndexes(r3, r4, size());
            if (r3 == r4) goto L5;
            short[] r1 = this.array;
            int r2 = this.start;
            return new ShortArrayAsList(r1, r3 + r2, r2 + r4);
        L5:
            return Collections.emptyList();
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof ShortArrayAsList) == false) goto L18;
            ShortArrayAsList r9 = (ShortArrayAsList) r8;
            int r1 = size();
            if (r9.size() == r1) goto L10;
            return false;
        L10:
            int r2 = 0;
        L11:
            if (r2 >= r1) goto L16;
            if (this.array[this.start + r2] != r9.array[r9.start + r2]) goto L14;
            r2 = r2 + 1;
            goto L11
        L14:
            return false;
        L16:
            return true;
        L18:
            return super.equals(r8);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int r0 = this.start;
            int r1 = 1;
        L4:
            if (r0 >= this.end) goto L6;
            r1 = (r1 * 31) + Shorts.hashCode(this.array[r0]);
            r0 = r0 + 1;
            goto L4
        L6:
            return r1;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r0 = new StringBuilder(size() * 6);
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

        short[] toShortArray() {
            int r0 = size();
            short[] r1 = new short[r0];
            System.arraycopy(this.array, this.start, r1, 0, r0);
            return r1;
        }
    }

    private static final class ShortConverter extends Converter<String, Short> implements Serializable {
        static final ShortConverter INSTANCE = null;
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Shorts.stringConverter()";
        }

        private ShortConverter() {
        }

        @Override // com.google.common.base.Converter
        protected /* bridge */ /* synthetic */ String doBackward(Short r1) {
            return doBackward2(r1);
        }

        @Override // com.google.common.base.Converter
        protected /* bridge */ /* synthetic */ Short doForward(String r1) {
            return doForward2(r1);
        }

        static {
            INSTANCE = new ShortConverter();
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        protected Short doForward2(String r1) {
            return Short.decode(r1);
        }

        /* JADX INFO: renamed from: doBackward, reason: avoid collision after fix types in other method */
        protected String doBackward2(Short r1) {
            return r1.toString();
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    public static int compare(short r0, short r1) {
        return r0 - r1;
    }

    public static short fromBytes(byte r0, byte r1) {
        return (short) ((r0 << 8) | (r1 & 255));
    }

    public static int hashCode(short r0) {
        return r0;
    }

    public static short saturatedCast(long r2) {
        if (r2 <= 32767) goto L7;
        return ShortCompanionObject.MAX_VALUE;
    L7:
        if (r2 >= (-32768)) goto L11;
        return ShortCompanionObject.MIN_VALUE;
    L11:
        return (short) r2;
    }

    public static byte[] toByteArray(short r3) {
        return new byte[]{(byte) (r3 >> 8), (byte) r3};
    }

    static /* synthetic */ int access$000(short[] r0, short r1, int r2, int r3) {
        return indexOf(r0, r1, r2, r3);
    }

    static /* synthetic */ int access$100(short[] r0, short r1, int r2, int r3) {
        return lastIndexOf(r0, r1, r2, r3);
    }

    private Shorts() {
    }

    public static short checkedCast(long r3) {
        short r0 = (short) r3;
        if (r0 != r3) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("Out of range: " + r3);
    }

    public static boolean contains(short[] r4, short r5) {
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4[r2] == r5) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static int indexOf(short[] r2, short r3) {
        return indexOf(r2, r3, 0, r2.length);
    }

    private static int indexOf(short[] r1, short r2, int r3, int r4) {
    L2:
        if (r3 >= r4) goto L7;
        if (r1[r3] == r2) goto L5;
        r3 = r3 + 1;
        goto L2
    L5:
        return r3;
    L7:
        return -1;
    }

    public static int indexOf(short[] r5, short[] r6) {
        Preconditions.checkNotNull(r5, "array");
        Preconditions.checkNotNull(r6, "target");
        if (r6.length != 0) goto L5;
        return 0;
    L5:
        int r0 = 0;
    L7:
        if (r0 >= ((r5.length - r6.length) + 1)) goto L16;
        int r2 = 0;
    L10:
        if (r2 >= r6.length) goto L15;
        if (r5[r0 + r2] != r6[r2]) goto L13;
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

    public static int lastIndexOf(short[] r2, short r3) {
        return lastIndexOf(r2, r3, 0, r2.length);
    }

    private static int lastIndexOf(short[] r1, short r2, int r3, int r4) {
        int r5 = r4 - 1;
    L3:
        if (r5 < r3) goto L8;
        if (r1[r5] == r2) goto L6;
        r5 = r5 - 1;
        goto L3
    L6:
        return r5;
    L8:
        return -1;
    }

    public static short min(short... r3) {
        int r2 = 1;
        if (r3.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        short r1 = r3[0];
    L8:
        if (r2 >= r3.length) goto L13;
        short r4 = r3[r2];
        if (r4 >= r1) goto L12;
        r1 = r4;
    L12:
        r2 = r2 + 1;
        goto L8
    L13:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public static short max(short... r3) {
        int r2 = 1;
        if (r3.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        short r1 = r3[0];
    L8:
        if (r2 >= r3.length) goto L13;
        short r4 = r3[r2];
        if (r4 <= r1) goto L12;
        r1 = r4;
    L12:
        r2 = r2 + 1;
        goto L8
    L13:
        return r1;
    L5:
        r0 = false;
        goto L6
    }

    public static short[] concat(short[]... r7) {
        int r0 = r7.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r3 = r3 + r7[r2].length;
        r2 = r2 + 1;
        goto L3
    L5:
        short[] r1 = new short[r3];
        int r4 = r7.length;
        int r5 = 0;
        int r6 = 0;
    L6:
        if (r5 >= r4) goto L8;
        short[] r8 = r7[r5];
        System.arraycopy(r8, 0, r1, r6, r8.length);
        r6 = r6 + r8.length;
        r5 = r5 + 1;
        goto L6
    L8:
        return r1;
    }

    public static short fromByteArray(byte[] r6) {
        if (r6.length < 2) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "array too small: %s < %s", new Object[]{Integer.valueOf(r6.length), 2});
        return fromBytes(r6[0], r6[1]);
    L5:
        r0 = false;
        goto L6
    }

    public static Converter<String, Short> stringConverter() {
        return ShortConverter.INSTANCE;
    }

    public static short[] ensureCapacity(short[] r5, int r6, int r7) {
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

    private static short[] copyOf(short[] r2, int r3) {
        short[] r0 = new short[r3];
        System.arraycopy(r2, 0, r0, 0, Math.min(r2.length, r3));
        return r0;
    }

    public static String join(String r4, short... r5) {
        Preconditions.checkNotNull(r4);
        if (r5.length != 0) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder(r5.length * 6);
        r0.append(r5[0]);
        int r1 = 1;
    L8:
        if (r1 >= r5.length) goto L11;
        r0.append(r4).append(r5[r1]);
        r1 = r1 + 1;
        goto L8
    L11:
        return r0.toString();
    }

    public static Comparator<short[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static short[] toArray(Collection<? extends Number> r4) {
        if ((r4 instanceof ShortArrayAsList) == true) goto L5;
        Object[] r5 = r4.toArray();
        int r0 = r5.length;
        short[] r1 = new short[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        r1[r2] = ((Number) Preconditions.checkNotNull(r5[r2])).shortValue();
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    L5:
        return ((ShortArrayAsList) r4).toShortArray();
    }

    public static List<Short> asList(short... r1) {
        if (r1.length != 0) goto L7;
        return Collections.emptyList();
    L7:
        return new ShortArrayAsList(r1);
    }
}
