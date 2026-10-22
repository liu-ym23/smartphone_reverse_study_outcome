package com.google.common.primitives;

import com.android.contacts.common.list.DefaultContactListAdapter;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public final class Booleans {

    private static class BooleanArrayAsList extends AbstractList<Boolean> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final boolean[] array;
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
            return set(r1, (Boolean) r2);
        }

        BooleanArrayAsList(boolean[] r3) {
            this(r3, 0, r3.length);
        }

        BooleanArrayAsList(boolean[] r1, int r2, int r3) {
            this.array = r1;
            this.start = r2;
            this.end = r3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public Boolean get(int r2) {
            Preconditions.checkElementIndex(r2, size());
            return Boolean.valueOf(this.array[this.start + r2]);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r3) {
            if ((r3 instanceof Boolean) == true) goto L5;
        L7:
            return false;
        L5:
            if (Booleans.access$000(this.array, ((Boolean) r3).booleanValue(), this.start, this.end) == (-1)) goto L7;
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r4) {
            if ((r4 instanceof Boolean) == false) goto L8;
            int r5 = Booleans.access$000(this.array, ((Boolean) r4).booleanValue(), this.start, this.end);
            if (r5 >= 0) goto L7;
            return -1;
        L7:
            return r5 - this.start;
        L8:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r4) {
            if ((r4 instanceof Boolean) == false) goto L8;
            int r5 = Booleans.access$100(this.array, ((Boolean) r4).booleanValue(), this.start, this.end);
            if (r5 >= 0) goto L7;
            return -1;
        L7:
            return r5 - this.start;
        L8:
            return -1;
        }

        public Boolean set(int r3, Boolean r4) {
            Preconditions.checkElementIndex(r3, size());
            boolean[] r0 = this.array;
            int r2 = this.start;
            boolean r1 = r0[r2 + r3];
            r0[r2 + r3] = ((Boolean) Preconditions.checkNotNull(r4)).booleanValue();
            return Boolean.valueOf(r1);
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Boolean> subList(int r3, int r4) {
            Preconditions.checkPositionIndexes(r3, r4, size());
            if (r3 == r4) goto L5;
            boolean[] r1 = this.array;
            int r2 = this.start;
            return new BooleanArrayAsList(r1, r3 + r2, r2 + r4);
        L5:
            return Collections.emptyList();
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(Object r8) {
            if (r8 != this) goto L6;
            return true;
        L6:
            if ((r8 instanceof BooleanArrayAsList) == false) goto L18;
            BooleanArrayAsList r9 = (BooleanArrayAsList) r8;
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
            r1 = (r1 * 31) + Booleans.hashCode(this.array[r0]);
            r0 = r0 + 1;
            goto L4
        L6:
            return r1;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r0 = new StringBuilder(size() * 7);
            if (this.array[this.start] == false) goto L5;
            String r1 = "[true";
        L6:
            r0.append(r1);
            int r2 = this.start;
        L7:
            r2 = r2 + 1;
            if (r2 >= this.end) goto L15;
            if (this.array[r2] == false) goto L12;
            String r3 = ", true";
        L13:
            r0.append(r3);
            goto L7
        L12:
            r3 = ", false";
            goto L13
        L15:
            return r0.append(DefaultContactListAdapter.SNIPPET_END_MATCH).toString();
        L5:
            r1 = "[false";
            goto L6
        }

        boolean[] toBooleanArray() {
            int r0 = size();
            boolean[] r1 = new boolean[r0];
            System.arraycopy(this.array, this.start, r1, 0, r0);
            return r1;
        }
    }

    private static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<boolean[]> {
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
        public /* bridge */ /* synthetic */ int compare(boolean[] r1, boolean[] r2) {
            return compare2(r1, r2);
        }

        static {
            LexicographicalComparator r0 = new LexicographicalComparator("INSTANCE", 0);
            INSTANCE = r0;
            $VALUES = new LexicographicalComparator[]{r0};
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(boolean[] r4, boolean[] r5) {
            int r3 = Math.min(r4.length, r5.length);
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L9;
            int r1 = Booleans.compare(r4[r0], r5[r0]);
            if (r1 != 0) goto L6;
            r0 = r0 + 1;
            goto L3
        L6:
            return r1;
        L9:
            return r4.length - r5.length;
        }
    }

    public static int compare(boolean r0, boolean r1) {
        if (r0 != r1) goto L4;
        return 0;
    L4:
        if (r0 == false) goto L6;
        return 1;
    L6:
        return -1;
    }

    public static int hashCode(boolean r0) {
        if (r0 == false) goto L4;
        return 1231;
    L4:
        return 1237;
    }

    static /* synthetic */ int access$000(boolean[] r0, boolean r1, int r2, int r3) {
        return indexOf(r0, r1, r2, r3);
    }

    static /* synthetic */ int access$100(boolean[] r0, boolean r1, int r2, int r3) {
        return lastIndexOf(r0, r1, r2, r3);
    }

    private Booleans() {
    }

    public static boolean contains(boolean[] r4, boolean r5) {
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

    public static int indexOf(boolean[] r2, boolean r3) {
        return indexOf(r2, r3, 0, r2.length);
    }

    private static int indexOf(boolean[] r1, boolean r2, int r3, int r4) {
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

    public static int indexOf(boolean[] r5, boolean[] r6) {
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

    public static int lastIndexOf(boolean[] r2, boolean r3) {
        return lastIndexOf(r2, r3, 0, r2.length);
    }

    private static int lastIndexOf(boolean[] r1, boolean r2, int r3, int r4) {
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

    public static boolean[] concat(boolean[]... r7) {
        int r0 = r7.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r3 = r3 + r7[r2].length;
        r2 = r2 + 1;
        goto L3
    L5:
        boolean[] r1 = new boolean[r3];
        int r4 = r7.length;
        int r5 = 0;
        int r6 = 0;
    L6:
        if (r5 >= r4) goto L8;
        boolean[] r8 = r7[r5];
        System.arraycopy(r8, 0, r1, r6, r8.length);
        r6 = r6 + r8.length;
        r5 = r5 + 1;
        goto L6
    L8:
        return r1;
    }

    public static boolean[] ensureCapacity(boolean[] r5, int r6, int r7) {
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

    private static boolean[] copyOf(boolean[] r2, int r3) {
        boolean[] r0 = new boolean[r3];
        System.arraycopy(r2, 0, r0, 0, Math.min(r2.length, r3));
        return r0;
    }

    public static String join(String r4, boolean... r5) {
        Preconditions.checkNotNull(r4);
        if (r5.length != 0) goto L6;
        return "";
    L6:
        StringBuilder r0 = new StringBuilder(r5.length * 7);
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

    public static Comparator<boolean[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static boolean[] toArray(Collection<Boolean> r4) {
        if ((r4 instanceof BooleanArrayAsList) == true) goto L5;
        Object[] r5 = r4.toArray();
        int r0 = r5.length;
        boolean[] r1 = new boolean[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        r1[r2] = ((Boolean) Preconditions.checkNotNull(r5[r2])).booleanValue();
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    L5:
        return ((BooleanArrayAsList) r4).toBooleanArray();
    }

    public static List<Boolean> asList(boolean... r1) {
        if (r1.length != 0) goto L7;
        return Collections.emptyList();
    L7:
        return new BooleanArrayAsList(r1);
    }

    public static int countTrue(boolean... r4) {
        int r0 = r4.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r4[r1] == false) goto L7;
        r2 = r2 + 1;
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        return r2;
    }
}
