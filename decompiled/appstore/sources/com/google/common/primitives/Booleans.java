package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
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
public final class Booleans {

    @GwtCompatible
    public static class BooleanArrayAsList extends AbstractList<Boolean> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final boolean[] array;
        final int end;
        final int start;

        public BooleanArrayAsList(boolean[] r10) {
            this(r10, 0, r10.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r10) {
            if ((r10 instanceof Boolean) == true) goto L5;
        L7:
            return false;
        L5:
            if (Booleans.access$000(this.array, ((Boolean) r10).booleanValue(), this.start, this.end) == (-1)) goto L7;
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof BooleanArrayAsList) == false) goto L18;
            BooleanArrayAsList r11 = (BooleanArrayAsList) r10;
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
            r11 = (r11 * 31) + Booleans.hashCode(this.array[r10]);
            r10 = r10 + 1;
            goto L4
        L6:
            return r11;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r10) {
            if ((r10 instanceof Boolean) == false) goto L8;
            int r11 = Booleans.access$000(this.array, ((Boolean) r10).booleanValue(), this.start, this.end);
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
            if ((r10 instanceof Boolean) == false) goto L8;
            int r11 = Booleans.access$100(this.array, ((Boolean) r10).booleanValue(), this.start, this.end);
            if (r11 >= 0) goto L7;
            return -1;
        L7:
            return r11 - this.start;
        L8:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r10, Object r11) {
            return set(r10, (Boolean) r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Boolean> subList(int r10, int r11) {
            Preconditions.checkPositionIndexes(r10, r11, size());
            if (r10 == r11) goto L5;
            boolean[] r12 = this.array;
            int r13 = this.start;
            return new BooleanArrayAsList(r12, r10 + r13, r13 + r11);
        L5:
            return Collections.emptyList();
        }

        public boolean[] toBooleanArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r10 = new StringBuilder(size() * 7);
            if (this.array[this.start] == false) goto L5;
            String r11 = "[true";
        L6:
            r10.append(r11);
            int r12 = this.start;
        L7:
            r12 = r12 + 1;
            if (r12 >= this.end) goto L14;
            if (this.array[r12] == false) goto L12;
            String r13 = ", true";
        L13:
            r10.append(r13);
            goto L7
        L12:
            r13 = ", false";
            goto L13
        L14:
            r10.append(']');
            return r10.toString();
        L5:
            r11 = "[false";
            goto L6
        }

        public BooleanArrayAsList(boolean[] r10, int r11, int r12) {
            this.array = r10;
            this.start = r11;
            this.end = r12;
        }

        @Override // java.util.AbstractList, java.util.List
        public Boolean get(int r10) {
            Preconditions.checkElementIndex(r10, size());
            return Boolean.valueOf(this.array[this.start + r10]);
        }

        public Boolean set(int r10, Boolean r11) {
            Preconditions.checkElementIndex(r10, size());
            boolean[] r12 = this.array;
            int r13 = this.start;
            boolean r14 = r12[r13 + r10];
            r12[r13 + r10] = ((Boolean) Preconditions.checkNotNull(r11)).booleanValue();
            return Boolean.valueOf(r14);
        }
    }

    public static final enum BooleanComparator extends Enum<BooleanComparator> implements Comparator<Boolean> {
        private static final /* synthetic */ BooleanComparator[] $VALUES = null;
        public static final BooleanComparator FALSE_FIRST = null;
        public static final BooleanComparator TRUE_FIRST = null;
        private final String toString;
        private final int trueValue;

        static {
            BooleanComparator r10 = new BooleanComparator("TRUE_FIRST", 0, 1, "Booleans.trueFirst()");
            TRUE_FIRST = r10;
            BooleanComparator r11 = new BooleanComparator("FALSE_FIRST", 1, -1, "Booleans.falseFirst()");
            FALSE_FIRST = r11;
            $VALUES = new BooleanComparator[]{r10, r11};
        }

        private BooleanComparator(String r10, int r11, int r12, String r13) {
            super(r10, r11);
            this.trueValue = r12;
            this.toString = r13;
        }

        public static BooleanComparator valueOf(String r10) {
            return (BooleanComparator) Enum.valueOf(BooleanComparator.class, r10);
        }

        public static BooleanComparator[] values() {
            return (BooleanComparator[]) $VALUES.clone();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Boolean r10, Boolean r11) {
            return compare2(r10, r11);
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.toString;
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(Boolean r10, Boolean r11) {
            int r12 = 0;
            if (r10.booleanValue() == false) goto L5;
            int r13 = this.trueValue;
        L7:
            if (r11.booleanValue() == false) goto L10;
            r12 = this.trueValue;
        L10:
            return r12 - r13;
        L5:
            r13 = 0;
            goto L7
        }
    }

    public static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<boolean[]> {
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
        public /* bridge */ /* synthetic */ int compare(boolean[] r10, boolean[] r11) {
            return compare2(r10, r11);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Booleans.lexicographicalComparator()";
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(boolean[] r10, boolean[] r11) {
            int r12 = Math.min(r10.length, r11.length);
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            int r14 = Booleans.compare(r10[r13], r11[r13]);
            if (r14 != 0) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return r14;
        L9:
            return r10.length - r11.length;
        }
    }

    private Booleans() {
    }

    public static /* synthetic */ int access$000(boolean[] r10, boolean r11, int r12, int r13) {
        return indexOf(r10, r11, r12, r13);
    }

    public static /* synthetic */ int access$100(boolean[] r10, boolean r11, int r12, int r13) {
        return lastIndexOf(r10, r11, r12, r13);
    }

    public static List<Boolean> asList(boolean... r10) {
        if (r10.length != 0) goto L7;
        return Collections.emptyList();
    L7:
        return new BooleanArrayAsList(r10);
    }

    public static int compare(boolean r10, boolean r11) {
        if (r10 != r11) goto L4;
        return 0;
    L4:
        if (r10 == false) goto L6;
        return 1;
    L6:
        return -1;
    }

    public static boolean[] concat(boolean[]... r10) {
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r13 = r13 + r10[r12].length;
        r12 = r12 + 1;
        goto L3
    L5:
        boolean[] r14 = new boolean[r13];
        int r15 = r10.length;
        int r16 = 0;
        int r17 = 0;
    L6:
        if (r16 >= r15) goto L8;
        boolean[] r18 = r10[r16];
        System.arraycopy(r18, 0, r14, r17, r18.length);
        r17 = r17 + r18.length;
        r16 = r16 + 1;
        goto L6
    L8:
        return r14;
    }

    public static boolean contains(boolean[] r10, boolean r11) {
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

    @Beta
    public static int countTrue(boolean... r10) {
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L8;
        if (r10[r12] == false) goto L7;
        r13 = r13 + 1;
    L7:
        r12 = r12 + 1;
        goto L3
    L8:
        return r13;
    }

    public static boolean[] ensureCapacity(boolean[] r10, int r11, int r12) {
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

    @Beta
    public static Comparator<Boolean> falseFirst() {
        return BooleanComparator.FALSE_FIRST;
    }

    public static int hashCode(boolean r10) {
        if (r10 == false) goto L4;
        return 1231;
    L4:
        return 1237;
    }

    public static int indexOf(boolean[] r10, boolean r11) {
        return indexOf(r10, r11, 0, r10.length);
    }

    public static String join(String r10, boolean... r11) {
        Preconditions.checkNotNull(r10);
        if (r11.length != 0) goto L6;
        return "";
    L6:
        StringBuilder r12 = new StringBuilder(r11.length * 7);
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

    public static int lastIndexOf(boolean[] r10, boolean r11) {
        return lastIndexOf(r10, r11, 0, r10.length);
    }

    public static Comparator<boolean[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static void reverse(boolean[] r10) {
        Preconditions.checkNotNull(r10);
        reverse(r10, 0, r10.length);
    }

    public static boolean[] toArray(Collection<Boolean> r10) {
        if ((r10 instanceof BooleanArrayAsList) == true) goto L5;
        Object[] r11 = r10.toArray();
        int r12 = r11.length;
        boolean[] r13 = new boolean[r12];
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L9;
        r13[r14] = ((Boolean) Preconditions.checkNotNull(r11[r14])).booleanValue();
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return ((BooleanArrayAsList) r10).toBooleanArray();
    }

    @Beta
    public static Comparator<Boolean> trueFirst() {
        return BooleanComparator.TRUE_FIRST;
    }

    private static int indexOf(boolean[] r10, boolean r11, int r12, int r13) {
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

    private static int lastIndexOf(boolean[] r10, boolean r11, int r12, int r13) {
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

    public static int indexOf(boolean[] r10, boolean[] r11) {
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

    public static void reverse(boolean[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkPositionIndexes(r11, r12, r10.length);
        int r13 = r12 - 1;
    L3:
        if (r11 >= r13) goto L5;
        boolean r14 = r10[r11];
        r10[r11] = r10[r13];
        r10[r13] = r14;
        r11 = r11 + 1;
        r13 = r13 - 1;
        goto L3
    }
}
