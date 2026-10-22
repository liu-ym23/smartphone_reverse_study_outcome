package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public final class Bytes {

    @GwtCompatible
    public static class ByteArrayAsList extends AbstractList<Byte> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final byte[] array;
        final int end;
        final int start;

        public ByteArrayAsList(byte[] r10) {
            this(r10, 0, r10.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r10) {
            if ((r10 instanceof Byte) == true) goto L5;
        L7:
            return false;
        L5:
            if (Bytes.access$000(this.array, ((Byte) r10).byteValue(), this.start, this.end) == (-1)) goto L7;
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object r10) {
            if (r10 != this) goto L6;
            return true;
        L6:
            if ((r10 instanceof ByteArrayAsList) == false) goto L18;
            ByteArrayAsList r11 = (ByteArrayAsList) r10;
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
            r11 = (r11 * 31) + Bytes.hashCode(this.array[r10]);
            r10 = r10 + 1;
            goto L4
        L6:
            return r11;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r10) {
            if ((r10 instanceof Byte) == false) goto L8;
            int r11 = Bytes.access$000(this.array, ((Byte) r10).byteValue(), this.start, this.end);
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
            if ((r10 instanceof Byte) == false) goto L8;
            int r11 = Bytes.access$100(this.array, ((Byte) r10).byteValue(), this.start, this.end);
            if (r11 >= 0) goto L7;
            return -1;
        L7:
            return r11 - this.start;
        L8:
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object set(int r10, Object r11) {
            return set(r10, (Byte) r11);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Byte> subList(int r10, int r11) {
            Preconditions.checkPositionIndexes(r10, r11, size());
            if (r10 == r11) goto L5;
            byte[] r12 = this.array;
            int r13 = this.start;
            return new ByteArrayAsList(r12, r10 + r13, r13 + r11);
        L5:
            return Collections.emptyList();
        }

        public byte[] toByteArray() {
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

        public ByteArrayAsList(byte[] r10, int r11, int r12) {
            this.array = r10;
            this.start = r11;
            this.end = r12;
        }

        @Override // java.util.AbstractList, java.util.List
        public Byte get(int r10) {
            Preconditions.checkElementIndex(r10, size());
            return Byte.valueOf(this.array[this.start + r10]);
        }

        public Byte set(int r10, Byte r11) {
            Preconditions.checkElementIndex(r10, size());
            byte[] r12 = this.array;
            int r13 = this.start;
            byte r14 = r12[r13 + r10];
            r12[r13 + r10] = ((Byte) Preconditions.checkNotNull(r11)).byteValue();
            return Byte.valueOf(r14);
        }
    }

    private Bytes() {
    }

    public static /* synthetic */ int access$000(byte[] r10, byte r11, int r12, int r13) {
        return indexOf(r10, r11, r12, r13);
    }

    public static /* synthetic */ int access$100(byte[] r10, byte r11, int r12, int r13) {
        return lastIndexOf(r10, r11, r12, r13);
    }

    public static List<Byte> asList(byte... r10) {
        if (r10.length != 0) goto L7;
        return Collections.emptyList();
    L7:
        return new ByteArrayAsList(r10);
    }

    public static byte[] concat(byte[]... r10) {
        int r11 = r10.length;
        int r12 = 0;
        int r13 = 0;
    L3:
        if (r12 >= r11) goto L5;
        r13 = r13 + r10[r12].length;
        r12 = r12 + 1;
        goto L3
    L5:
        byte[] r14 = new byte[r13];
        int r15 = r10.length;
        int r16 = 0;
        int r17 = 0;
    L6:
        if (r16 >= r15) goto L8;
        byte[] r18 = r10[r16];
        System.arraycopy(r18, 0, r14, r17, r18.length);
        r17 = r17 + r18.length;
        r16 = r16 + 1;
        goto L6
    L8:
        return r14;
    }

    public static boolean contains(byte[] r10, byte r11) {
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

    public static byte[] ensureCapacity(byte[] r10, int r11, int r12) {
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

    public static int hashCode(byte r10) {
        return r10;
    }

    public static int indexOf(byte[] r10, byte r11) {
        return indexOf(r10, r11, 0, r10.length);
    }

    public static int lastIndexOf(byte[] r10, byte r11) {
        return lastIndexOf(r10, r11, 0, r10.length);
    }

    public static void reverse(byte[] r10) {
        Preconditions.checkNotNull(r10);
        reverse(r10, 0, r10.length);
    }

    public static byte[] toArray(Collection<? extends Number> r10) {
        if ((r10 instanceof ByteArrayAsList) == true) goto L5;
        Object[] r11 = r10.toArray();
        int r12 = r11.length;
        byte[] r13 = new byte[r12];
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L9;
        r13[r14] = ((Number) Preconditions.checkNotNull(r11[r14])).byteValue();
        r14 = r14 + 1;
        goto L7
    L9:
        return r13;
    L5:
        return ((ByteArrayAsList) r10).toByteArray();
    }

    private static int indexOf(byte[] r10, byte r11, int r12, int r13) {
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

    private static int lastIndexOf(byte[] r10, byte r11, int r12, int r13) {
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

    public static int indexOf(byte[] r10, byte[] r11) {
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

    public static void reverse(byte[] r10, int r11, int r12) {
        Preconditions.checkNotNull(r10);
        Preconditions.checkPositionIndexes(r11, r12, r10.length);
        int r13 = r12 - 1;
    L3:
        if (r11 >= r13) goto L5;
        byte r14 = r10[r11];
        r10[r11] = r10[r13];
        r10[r13] = r14;
        r11 = r11 + 1;
        r13 = r13 - 1;
        goto L3
    }
}
