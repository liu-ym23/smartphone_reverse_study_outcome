package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
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
public final class Chars {
    public static final int BYTES = 2;

    @GwtCompatible
    public static class CharArrayAsList extends AbstractList<Character> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final char[] array;
        final int end;
        final int start;

        public CharArrayAsList(char[] r10) {
            this(r10, 0, r10.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r10) {
            if ((r10 instanceof Character) == true) goto L5;
        L7:
            return false;
        L5:
            if (Chars.access$000(this.array, ((Character) r10).charValue(), this.start, this.end) == (-1)) goto L7;
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof CharArrayAsList) == false) goto L18;
            CharArrayAsList r11 = (CharArrayAsList) r10;
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
            r11 = (r11 * 31) + Chars.hashCode(this.array[r10]);
            r10 = r10 + 1;
            goto L4
        L6:
            return r11;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r10) {
            if ((r10 instanceof Character) == false) goto L8;
            int r11 = Chars.access$000(this.array, ((Character) r10).charValue(), this.start, this.end);
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
            if ((r10 instanceof Character) == false) goto L8;
            int r11 = Chars.access$100(this.array, ((Character) r10).charValue(), this.start, this.end);
            if (r11 >= 0) goto L7;
            return -1;
        L7:
            return r11 - this.start;
        L8:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r10, Object r11) {
            return set(r10, (Character) r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Character> subList(int r10, int r11) {
            Preconditions.checkPositionIndexes(r10, r11, size());
            if (r10 == r11) goto L5;
            char[] r12 = this.array;
            int r13 = this.start;
            return new CharArrayAsList(r12, r10 + r13, r13 + r11);
        L5:
            return Collections.emptyList();
        }

        public char[] toCharArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder r10 = new StringBuilder(size() * 3);
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

        public CharArrayAsList(char[] r10, int r11, int r12) {
            this.array = r10;
            this.start = r11;
            this.end = r12;
        }

        @Override // java.util.AbstractList, java.util.List
        public Character get(int r10) {
            Preconditions.checkElementIndex(r10, size());
            return Character.valueOf(this.array[this.start + r10]);
        }

        public Character set(int r10, Character r11) {
            Preconditions.checkElementIndex(r10, size());
            char[] r12 = this.array;
            int r13 = this.start;
            char r14 = r12[r13 + r10];
            r12[r13 + r10] = ((Character) Preconditions.checkNotNull(r11)).charValue();
            return Character.valueOf(r14);
        }
    }

    public static final enum LexicographicalComparator extends Enum<LexicographicalComparator> implements Comparator<char[]> {
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
        public /* bridge */ /* synthetic */ int compare(char[] r10, char[] r11) {
            return compare2(r10, r11);
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Chars.lexicographicalComparator()";
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(char[] r10, char[] r11) {
            int r12 = Math.min(r10.length, r11.length);
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L9;
            int r14 = Chars.compare(r10[r13], r11[r13]);
            if (r14 != 0) goto L6;
            r13 = r13 + 1;
            goto L3
        L6:
            return r14;
        L9:
            return r10.length - r11.length;
        }
    }

    private Chars() {
    }

    public static /* synthetic */ int access$000(char[] r10, char r11, int r12, int r13) {
        return indexOf(r10, r11, r12, r13);
    }

    public static /* synthetic */ int access$100(char[] r10, char r11, int r12, int r13) {
        return lastIndexOf(r10, r11, r12, r13);
    }

    public static List<Character> asList(char... r10) {
        if (r10.length != 0) goto L7;
        return Collections.emptyList();
    L7:
        return new CharArrayAsList(r10);
    }

    public static char checkedCast(long r10) {
        char r11 = (char) r10;
        if (r11 != r10) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "Out of range: %s", r10);
        return r11;
    L5:
        r12 = false;
        goto L6
    }

    public static int compare(char r10, char r11) {
        return r10 - r11;
    }

    public static char[] concat(char[]... r10) {
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r13 = r13 + r10[r12].length;
        r12 = r12 + 1;
        goto L3
    L5:
        char[] r14 = new char[r13];
        int r15 = r10.length;
        int r16 = 0;
        int r17 = 0;
    L6:
        if (r16 >= r15) goto L8;
        char[] r18 = r10[r16];
        System.arraycopy(r18, 0, r14, r17, r18.length);
        r17 = r17 + r18.length;
        r16 = r16 + 1;
        goto L6
    L8:
        return r14;
    }

    @Beta
    public static char constrainToRange(char r10, char r11, char r12) {
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

    public static boolean contains(char[] r10, char r11) {
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

    public static char[] ensureCapacity(char[] r10, int r11, int r12) {
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
    public static char fromByteArray(byte[] r10) {
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
    public static char fromBytes(byte r10, byte r11) {
        return (char) ((r10 << 8) | (r11 & UnsignedBytes.MAX_VALUE));
    }

    public static int hashCode(char r10) {
        return r10;
    }

    public static int indexOf(char[] r10, char r11) {
        return indexOf(r10, r11, 0, r10.length);
    }

    public static String join(String r10, char... r11) {
        Preconditions.checkNotNull(r10);
        int r12 = r11.length;
        if (r12 != 0) goto L6;
        return "";
    L6:
        StringBuilder r13 = new StringBuilder((r10.length() * (r12 - 1)) + r12);
        r13.append(r11[0]);
        int r14 = 1;
    L7:
        if (r14 >= r12) goto L10;
        r13.append(r10);
        r13.append(r11[r14]);
        r14 = r14 + 1;
        goto L7
    L10:
        return r13.toString();
    }

    public static int lastIndexOf(char[] r10, char r11) {
        return lastIndexOf(r10, r11, 0, r10.length);
    }

    public static Comparator<char[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static char max(char... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        char r13 = r10[0];
    L8:
        if (r11 >= r10.length) goto L13;
        char r14 = r10[r11];
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

    public static char min(char... r10) {
        int r11 = 1;
        if (r10.length <= 0) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12);
        char r13 = r10[0];
    L8:
        if (r11 >= r10.length) goto L13;
        char r14 = r10[r11];
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

    public static void reverse(char[] r10) {
        Preconditions.checkNotNull(r10);
        reverse(r10, 0, r10.length);
    }

    public static char saturatedCast(long r10) {
        if (r10 <= 65535) goto L7;
        return 65535;
    L7:
        if (r10 >= 0) goto L11;
        return 0;
    L11:
        return (char) r10;
    }

    public static void sortDescending(char[] r10) {
        Preconditions.checkNotNull(r10);
        sortDescending(r10, 0, r10.length);
    }

    public static char[] toArray(Collection<Character> r10) {
        if ((r10 instanceof CharArrayAsList) == true) goto L5;
        Object[] r11 = r10.toArray();
        int r12 = r11.length;
        char[] r13 = new char[r12];
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L9;
        r13[r14] = ((Character) Preconditions.checkNotNull(r11[r14])).charValue();
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return ((CharArrayAsList) r10).toCharArray();
    }

    @GwtIncompatible
    public static byte[] toByteArray(char r10) {
        return new byte[]{(byte) (r10 >> '\b'), (byte) r10};
    }

    private static int indexOf(char[] r10, char r11, int r12, int r13) {
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

    private static int lastIndexOf(char[] r10, char r11, int r12, int r13) {
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

    public static int indexOf(char[] r10, char[] r11) {
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

    public static void reverse(char[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkPositionIndexes(r11, r12, r10.length);
        int r13 = r12 - 1;
    L3:
        if (r11 >= r13) goto L5;
        char r14 = r10[r11];
        r10[r11] = r10[r13];
        r10[r13] = r14;
        r11 = r11 + 1;
        r13 = r13 - 1;
        goto L3
    }

    public static void sortDescending(char[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkPositionIndexes(r11, r12, r10.length);
        Arrays.sort(r10, r11, r12);
        reverse(r10, r11, r12);
    }
}
