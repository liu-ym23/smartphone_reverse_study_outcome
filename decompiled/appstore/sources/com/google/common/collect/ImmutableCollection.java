package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlinx.coroutines.channels.Channel;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] EMPTY_ARRAY = null;

    public static abstract class ArrayBasedBuilder<E> extends Builder<E> {
        Object[] contents;
        boolean forceCopy;
        int size;

        public ArrayBasedBuilder(int r10) {
            CollectPreconditions.checkNonnegative(r10, "initialCapacity");
            this.contents = new Object[r10];
            this.size = 0;
        }

        private void getReadyToExpandTo(int r10) {
            Object[] r11 = this.contents;
            if (r11.length >= r10) goto L6;
            this.contents = Arrays.copyOf(r11, Builder.expandedCapacity(r11.length, r10));
            this.forceCopy = false;
            return;
        L6:
            if (this.forceCopy == false) goto L10;
            this.contents = (Object[]) r11.clone();
            this.forceCopy = false;
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ Builder add(Object r10) {
            return add(r10);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> r10) {
            if ((r10 instanceof Collection) == false) goto L8;
            Collection r11 = (Collection) r10;
            getReadyToExpandTo(this.size + r11.size());
            if ((r11 instanceof ImmutableCollection) == false) goto L8;
            this.size = ((ImmutableCollection) r11).copyIntoArray(this.contents, this.size);
            return this;
        L8:
            super.addAll(r10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public ArrayBasedBuilder<E> add(E r10) {
            Preconditions.checkNotNull(r10);
            getReadyToExpandTo(this.size + 1);
            Object[] r11 = this.contents;
            int r12 = this.size;
            this.size = r12 + 1;
            r11[r12] = r10;
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... r10) {
            ObjectArrays.checkElementsNotNull(r10);
            getReadyToExpandTo(this.size + r10.length);
            System.arraycopy(r10, 0, this.contents, this.size, r10.length);
            this.size += r10.length;
            return this;
        }
    }

    public static abstract class Builder<E> {
        static final int DEFAULT_INITIAL_CAPACITY = 4;

        public Builder() {
        }

        public static int expandedCapacity(int r10, int r11) {
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

        @CanIgnoreReturnValue
        public abstract Builder<E> add(E r10);

        @CanIgnoreReturnValue
        public Builder<E> add(E... r10) {
            int r11 = r10.length;
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L5;
            add(r10[r12]);
            r12 = r12 + 1;
            goto L3
        L5:
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> r10) {
            Iterator<? extends E> r11 = r10.iterator();
        L4:
            if (r11.hasNext() == false) goto L6;
            add(r11.next());
            goto L4
        L6:
            return this;
        }

        public abstract ImmutableCollection<E> build();

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> r10) {
        L3:
            if (r10.hasNext() == false) goto L5;
            add(r10.next());
            goto L3
        L5:
            return this;
        }
    }

    static {
        EMPTY_ARRAY = new Object[0];
    }

    public ImmutableCollection() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean add(E r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(Collection<? extends E> r10) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        if (isEmpty() == false) goto L6;
        return ImmutableList.of();
    L6:
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(@NullableDecl Object r10);

    @CanIgnoreReturnValue
    public int copyIntoArray(Object[] r10, int r11) {
        UnmodifiableIterator<E> r12 = iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r10[r11] = r12.next();
        r11 = r11 + 1;
        goto L4
    L6:
        return r11;
    }

    public Object[] internalArray() {
        return null;
    }

    public int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    public int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public abstract UnmodifiableIterator<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean remove(Object r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean removeAll(Collection<?> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean retainAll(Collection<?> r10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(EMPTY_ARRAY);
    }

    public Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final <T> T[] toArray(T[] r10) {
        Preconditions.checkNotNull(r10);
        int r11 = size();
        if (r10.length >= r11) goto L10;
        Object[] r12 = internalArray();
        if (r12 != null) goto L7;
        r10 = (T[]) ObjectArrays.newArray(r10, r11);
    L12:
        copyIntoArray(r10, 0);
        return r10;
    L7:
        return (T[]) Platform.copy(r12, internalArrayStart(), internalArrayEnd(), r10);
    L10:
        if (r10.length <= r11) goto L12;
        r10[r11] = null;
        goto L12
    }
}
