package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlinx.coroutines.channels.Channel;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Immutable
@Beta
@GwtCompatible
public final class ImmutableLongArray implements Serializable {
    private static final ImmutableLongArray EMPTY = null;
    private final long[] array;
    private final int end;
    private final transient int start;

    /* JADX INFO: renamed from: com.google.common.primitives.ImmutableLongArray$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class AsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private final ImmutableLongArray parent;

        public /* synthetic */ AsList(ImmutableLongArray r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(Object r10) {
            if (indexOf(r10) < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@NullableDecl Object r10) {
            if ((r10 instanceof AsList) == false) goto L7;
            return this.parent.equals(((AsList) r10).parent);
        L7:
            if ((r10 instanceof List) == true) goto L9;
            return false;
        L9:
            List r11 = (List) r10;
            if (size() == r11.size()) goto L12;
            return false;
        L12:
            int r12 = ImmutableLongArray.access$100(this.parent);
            Iterator r13 = r11.iterator();
        L14:
            if (r13.hasNext() == false) goto L22;
            Object r14 = r13.next();
            if ((r14 instanceof Long) == false) goto L21;
            int r15 = r12 + 1;
            if (ImmutableLongArray.access$000(this.parent)[r12] != ((Long) r14).longValue()) goto L21;
            r12 = r15;
        L21:
            return false;
        L22:
            return true;
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r10) {
            return get(r10);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(Object r10) {
            if ((r10 instanceof Long) == true) goto L7;
            return -1;
        L7:
            return this.parent.indexOf(((Long) r10).longValue());
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(Object r10) {
            if ((r10 instanceof Long) == true) goto L7;
            return -1;
        L7:
            return this.parent.lastIndexOf(((Long) r10).longValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int r10, int r11) {
            return this.parent.subArray(r10, r11).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        private AsList(ImmutableLongArray r10) {
            this.parent = r10;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int r10) {
            return Long.valueOf(this.parent.get(r10));
        }
    }

    @CanIgnoreReturnValue
    public static final class Builder {
        private long[] array;
        private int count;

        public Builder(int r10) {
            this.count = 0;
            this.array = new long[r10];
        }

        private void ensureRoomFor(int r10) {
            int r11 = this.count + r10;
            long[] r12 = this.array;
            if (r11 <= r12.length) goto L6;
            long[] r13 = new long[expandedCapacity(r12.length, r11)];
            System.arraycopy(this.array, 0, r13, 0, this.count);
            this.array = r13;
            return;
        }

        private static int expandedCapacity(int r10, int r11) {
            if (r11 < 0) goto L10;
            int r12 = (r10 + (r10 >> 1)) + 1;
            if (r12 >= r11) goto L6;
            r12 = Integer.highestOneBit(r11 - 1) << 1;
        L6:
            if (r12 >= 0) goto L11;
            return Channel.UNLIMITED;
        L11:
            return r12;
        L10:
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        public Builder add(long r10) {
            ensureRoomFor(1);
            long[] r11 = this.array;
            int r12 = this.count;
            r11[r12] = r10;
            this.count = r12 + 1;
            return this;
        }

        public Builder addAll(long[] r10) {
            ensureRoomFor(r10.length);
            System.arraycopy(r10, 0, this.array, this.count, r10.length);
            this.count += r10.length;
            return this;
        }

        @CheckReturnValue
        public ImmutableLongArray build() {
            if (this.count == 0) goto L7;
            int r10 = 0;
            return new ImmutableLongArray(this.array, r10, this.count, null);
        L7:
            return ImmutableLongArray.access$200();
        }

        public Builder addAll(Iterable<Long> r10) {
            if ((r10 instanceof Collection) == true) goto L5;
            Iterator<Long> r11 = r10.iterator();
        L8:
            if (r11.hasNext() == false) goto L10;
            add(r11.next().longValue());
            goto L8
        L10:
            return this;
        L5:
            return addAll((Collection) r10);
        }

        public Builder addAll(Collection<Long> r10) {
            ensureRoomFor(r10.size());
            Iterator<Long> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            Long r12 = r11.next();
            long[] r13 = this.array;
            int r14 = this.count;
            this.count = r14 + 1;
            r13[r14] = r12.longValue();
            goto L4
        L6:
            return this;
        }

        public Builder addAll(ImmutableLongArray r10) {
            ensureRoomFor(r10.length());
            System.arraycopy(ImmutableLongArray.access$000(r10), ImmutableLongArray.access$100(r10), this.array, this.count, r10.length());
            this.count += r10.length();
            return this;
        }
    }

    static {
        EMPTY = new ImmutableLongArray(new long[0]);
    }

    public /* synthetic */ ImmutableLongArray(long[] r10, int r11, int r12, AnonymousClass1 r13) {
        this(r10, r11, r12);
    }

    public static /* synthetic */ long[] access$000(ImmutableLongArray r10) {
        return r10.array;
    }

    public static /* synthetic */ int access$100(ImmutableLongArray r10) {
        return r10.start;
    }

    public static /* synthetic */ ImmutableLongArray access$200() {
        return EMPTY;
    }

    public static Builder builder(int r10) {
        if (r10 < 0) goto L4;
        boolean r11 = true;
    L5:
        Preconditions.checkArgument(r11, "Invalid initialCapacity: %s", r10);
        return new Builder(r10);
    L4:
        r11 = false;
        goto L5
    }

    public static ImmutableLongArray copyOf(long[] r10) {
        if (r10.length != 0) goto L6;
        return EMPTY;
    L6:
        return new ImmutableLongArray(Arrays.copyOf(r10, r10.length));
    }

    private boolean isPartialView() {
        if (this.start <= 0) goto L5;
    L8:
        return true;
    L5:
        if (this.end < this.array.length) goto L8;
        return false;
    }

    public static ImmutableLongArray of() {
        return EMPTY;
    }

    public List<Long> asList() {
        return new AsList(this, null);
    }

    public boolean contains(long r10) {
        if (indexOf(r10) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L6;
        return true;
    L6:
        if ((r10 instanceof ImmutableLongArray) == true) goto L8;
        return false;
    L8:
        ImmutableLongArray r11 = (ImmutableLongArray) r10;
        if (length() == r11.length()) goto L11;
        return false;
    L11:
        int r12 = 0;
    L13:
        if (r12 >= length()) goto L18;
        if (get(r12) != r11.get(r12)) goto L16;
        r12 = r12 + 1;
        goto L13
    L16:
        return false;
    L18:
        return true;
    }

    public long get(int r10) {
        Preconditions.checkElementIndex(r10, length());
        return this.array[this.start + r10];
    }

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

    public int indexOf(long r10) {
        int r11 = this.start;
    L4:
        if (r11 >= this.end) goto L10;
        if (this.array[r11] == r10) goto L8;
        r11 = r11 + 1;
        goto L4
    L8:
        return r11 - this.start;
    L10:
        return -1;
    }

    public boolean isEmpty() {
        if (this.end != this.start) goto L5;
        return true;
    L5:
        return false;
    }

    public int lastIndexOf(long r10) {
        int r11 = this.end;
    L3:
        r11 = r11 - 1;
        int r12 = this.start;
        if (r11 < r12) goto L10;
        if (this.array[r11] != r10) goto L3;
        return r11 - r12;
    L10:
        return -1;
    }

    public int length() {
        return this.end - this.start;
    }

    public Object readResolve() {
        if (isEmpty() == true) goto L5;
        return this;
    L5:
        return EMPTY;
    }

    public ImmutableLongArray subArray(int r10, int r11) {
        Preconditions.checkPositionIndexes(r10, r11, length());
        if (r10 == r11) goto L7;
        long[] r12 = this.array;
        int r13 = this.start;
        return new ImmutableLongArray(r12, r10 + r13, r13 + r11);
    L7:
        return EMPTY;
    }

    public long[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    public String toString() {
        if (isEmpty() == false) goto L6;
        return "[]";
    L6:
        StringBuilder r10 = new StringBuilder(length() * 5);
        r10.append('[');
        r10.append(this.array[this.start]);
        int r11 = this.start;
    L7:
        r11 = r11 + 1;
        if (r11 >= this.end) goto L10;
        r10.append(", ");
        r10.append(this.array[r11]);
        goto L7
    L10:
        r10.append(']');
        return r10.toString();
    }

    public ImmutableLongArray trimmed() {
        if (isPartialView() == true) goto L5;
        return this;
    L5:
        return new ImmutableLongArray(toArray());
    }

    public Object writeReplace() {
        return trimmed();
    }

    private ImmutableLongArray(long[] r10) {
        this(r10, 0, r10.length);
    }

    public static ImmutableLongArray of(long r10) {
        return new ImmutableLongArray(new long[]{r10});
    }

    private ImmutableLongArray(long[] r10, int r11, int r12) {
        this.array = r10;
        this.start = r11;
        this.end = r12;
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableLongArray copyOf(Collection<Long> r10) {
        if (r10.isEmpty() == false) goto L6;
        return EMPTY;
    L6:
        return new ImmutableLongArray(Longs.toArray(r10));
    }

    public static ImmutableLongArray of(long r10, long r11) {
        return new ImmutableLongArray(new long[]{r10, r11});
    }

    public static ImmutableLongArray copyOf(Iterable<Long> r10) {
        if ((r10 instanceof Collection) == false) goto L7;
        return copyOf((Collection) r10);
    L7:
        return builder().addAll(r10).build();
    }

    public static ImmutableLongArray of(long r10, long r11, long r12) {
        return new ImmutableLongArray(new long[]{r10, r11, r12});
    }

    public static ImmutableLongArray of(long r10, long r11, long r12, long r13) {
        return new ImmutableLongArray(new long[]{r10, r11, r12, r13});
    }

    public static ImmutableLongArray of(long r10, long r11, long r12, long r13, long r14) {
        return new ImmutableLongArray(new long[]{r10, r11, r12, r13, r14});
    }

    public static ImmutableLongArray of(long r10, long r11, long r12, long r13, long r14, long r15) {
        return new ImmutableLongArray(new long[]{r10, r11, r12, r13, r14, r15});
    }

    public static ImmutableLongArray of(long r10, long... r11) {
        if (r11.length > 2147483646) goto L5;
        boolean r12 = true;
    L6:
        Preconditions.checkArgument(r12, "the total number of elements must fit in an int");
        long[] r13 = new long[r11.length + 1];
        r13[0] = r10;
        System.arraycopy(r11, 0, r13, 1, r11.length);
        return new ImmutableLongArray(r13);
    L5:
        r12 = false;
        goto L6
    }
}
