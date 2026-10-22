package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private transient ImmutableList<E> asList;

    static abstract class ArrayBasedBuilder<E> extends Builder<E> {
        Object[] contents;
        int size;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ Builder add(Object r1) {
            return add(r1);
        }

        ArrayBasedBuilder(int r2) {
            CollectPreconditions.checkNonnegative(r2, "initialCapacity");
            this.contents = new Object[r2];
            this.size = 0;
        }

        private void ensureCapacity(int r3) {
            Object[] r0 = this.contents;
            if (r0.length >= r3) goto L6;
            this.contents = ObjectArrays.arraysCopyOf(r0, expandedCapacity(r0.length, r3));
            return;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ArrayBasedBuilder<E> add(E r4) {
            Preconditions.checkNotNull(r4);
            ensureCapacity(this.size + 1);
            Object[] r0 = this.contents;
            int r1 = this.size;
            this.size = r1 + 1;
            r0[r1] = r4;
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E... r5) {
            ObjectArrays.checkElementsNotNull(r5);
            ensureCapacity(this.size + r5.length);
            System.arraycopy(r5, 0, this.contents, this.size, r5.length);
            this.size += r5.length;
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterable<? extends E> r3) {
            if ((r3 instanceof Collection) == false) goto L5;
            ensureCapacity(this.size + ((Collection) r3).size());
        L5:
            super.addAll(r3);
            return this;
        }
    }

    public static abstract class Builder<E> {
        static final int DEFAULT_INITIAL_CAPACITY = 4;

        public abstract Builder<E> add(E r1);

        public abstract ImmutableCollection<E> build();

        static int expandedCapacity(int r1, int r2) {
            if (r2 < 0) goto L10;
            int r3 = (r1 + (r1 >> 1)) + 1;
            if (r3 >= r2) goto L6;
            r3 = Integer.highestOneBit(r2 - 1) << 1;
        L6:
            if (r3 >= 0) goto L11;
            return Integer.MAX_VALUE;
        L11:
            return r3;
        L10:
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        Builder() {
        }

        public Builder<E> add(E... r4) {
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            add(r4[r1]);
            r1 = r1 + 1;
            goto L3
        L5:
            return this;
        }

        public Builder<E> addAll(Iterable<? extends E> r2) {
            Iterator<? extends E> r3 = r2.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            add(r3.next());
            goto L4
        L6:
            return this;
        }

        public Builder<E> addAll(Iterator<? extends E> r2) {
        L3:
            if (r2.hasNext() == false) goto L5;
            add(r2.next());
            goto L3
        L5:
            return this;
        }
    }

    abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public abstract UnmodifiableIterator<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    ImmutableCollection() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        int r0 = size();
        if (r0 == 0) goto L5;
        Object[] r1 = new Object[r0];
        copyIntoArray(r1, 0);
        return r1;
    L5:
        return ObjectArrays.EMPTY_ARRAY;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] r3) {
        Preconditions.checkNotNull(r3);
        int r0 = size();
        if (r3.length >= r0) goto L6;
        r3 = (T[]) ObjectArrays.newArray(r3, r0);
    L8:
        copyIntoArray(r3, 0);
        return r3;
    L6:
        if (r3.length <= r0) goto L8;
        r3[r0] = null;
        goto L8
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@Nullable Object r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (super.contains(r1) == false) goto L6;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> r1) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        ImmutableList<E> r0 = this.asList;
        if (r0 != null) goto L6;
        ImmutableList<E> r1 = createAsList();
        this.asList = r1;
        return r1;
    L6:
        return r0;
    }

    ImmutableList<E> createAsList() {
        int r0 = size();
        if (r0 == 0) goto L11;
        if (r0 == 1) goto L9;
        return new RegularImmutableAsList(this, toArray());
    L9:
        return ImmutableList.of(iterator().next());
    L11:
        return ImmutableList.of();
    }

    int copyIntoArray(Object[] r3, int r4) {
        UnmodifiableIterator<E> r2 = iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r3[r4] = r2.next();
        r4 = r4 + 1;
        goto L4
    L6:
        return r4;
    }

    Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }
}
