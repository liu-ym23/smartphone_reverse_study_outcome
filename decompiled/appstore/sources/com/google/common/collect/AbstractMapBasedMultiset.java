package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;
    transient ObjectCountHashMap<E> backingMap;
    transient long size;

    public abstract class Itr<T> implements Iterator<T> {
        int entryIndex;
        int expectedModCount;
        final /* synthetic */ AbstractMapBasedMultiset this$0;
        int toRemove;

        public Itr(AbstractMapBasedMultiset r10) {
            this.this$0 = r10;
            this.entryIndex = r10.backingMap.firstIndex();
            this.toRemove = -1;
            this.expectedModCount = r10.backingMap.modCount;
        }

        private void checkForConcurrentModification() {
            if (this.this$0.backingMap.modCount != this.expectedModCount) goto L6;
            return;
        L6:
            throw new ConcurrentModificationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            checkForConcurrentModification();
            if (this.entryIndex < 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext() == false) goto L7;
            T r10 = result(this.entryIndex);
            int r11 = this.entryIndex;
            this.toRemove = r11;
            this.entryIndex = this.this$0.backingMap.nextIndex(r11);
            return r10;
        L7:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            checkForConcurrentModification();
            if (this.toRemove == (-1)) goto L5;
            boolean r10 = true;
        L6:
            CollectPreconditions.checkRemove(r10);
            AbstractMapBasedMultiset r11 = this.this$0;
            r11.size -= (long) r11.backingMap.removeEntry(this.toRemove);
            this.entryIndex = this.this$0.backingMap.nextIndexAfterRemove(this.entryIndex, this.toRemove);
            this.toRemove = -1;
            this.expectedModCount = this.this$0.backingMap.modCount;
            return;
        L5:
            r10 = false;
            goto L6
        }

        public abstract T result(int r10);
    }

    public AbstractMapBasedMultiset(int r10) {
        init(r10);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream r10) throws IOException, ClassNotFoundException {
        r10.defaultReadObject();
        int r11 = Serialization.readCount(r10);
        init(3);
        Serialization.populateMultiset(this, r10, r11);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream r10) throws IOException {
        r10.defaultWriteObject();
        Serialization.writeMultiset(this, r10);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int add(@NullableDecl E r10, int r11) {
        if (r11 == 0) goto L4;
        boolean r12 = true;
        if (r11 <= 0) goto L8;
        boolean r13 = true;
    L9:
        Preconditions.checkArgument(r13, "occurrences cannot be negative: %s", r11);
        int r14 = this.backingMap.indexOf(r10);
        if (r14 != (-1)) goto L13;
        this.backingMap.put(r10, r11);
        this.size += (long) r11;
        return 0;
    L13:
        int r15 = this.backingMap.getValue(r14);
        long r16 = r11;
        long r17 = ((long) r15) + r16;
        if (r17 <= 2147483647L) goto L17;
        r12 = false;
    L17:
        Preconditions.checkArgument(r12, "too many occurrences: %s", r17);
        this.backingMap.setValue(r14, (int) r17);
        this.size += r16;
        return r15;
    L8:
        r13 = false;
        goto L9
    L4:
        return count(r10);
    }

    public void addTo(Multiset<? super E> r10) {
        Preconditions.checkNotNull(r10);
        int r11 = this.backingMap.firstIndex();
    L3:
        if (r11 < 0) goto L5;
        r10.add(this.backingMap.getKey(r11), this.backingMap.getValue(r11));
        r11 = this.backingMap.nextIndex(r11);
        goto L3
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.clear();
        this.size = 0;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(@NullableDecl Object r10) {
        return this.backingMap.get(r10);
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final int distinctElements() {
        return this.backingMap.size();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final Iterator<E> elementIterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final Iterator<Multiset.Entry<E>> entryIterator() {
        return new AnonymousClass2(this);
    }

    public abstract void init(int r10);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public final Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int remove(@NullableDecl Object r10, int r11) {
        if (r11 != 0) goto L6;
        return count(r10);
    L6:
        if (r11 <= 0) goto L8;
        boolean r12 = true;
    L9:
        Preconditions.checkArgument(r12, "occurrences cannot be negative: %s", r11);
        int r13 = this.backingMap.indexOf(r10);
        if (r13 != (-1)) goto L12;
        return 0;
    L12:
        int r14 = this.backingMap.getValue(r13);
        if (r14 <= r11) goto L15;
        this.backingMap.setValue(r13, r14 - r11);
    L16:
        this.size -= (long) r11;
        return r14;
    L15:
        this.backingMap.removeEntry(r13);
        r11 = r14;
        goto L16
    L8:
        r12 = false;
        goto L9
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int setCount(@NullableDecl E r10, int r11) {
        CollectPreconditions.checkNonnegative(r11, "count");
        ObjectCountHashMap<E> r12 = this.backingMap;
        if (r11 != 0) goto L5;
        int r13 = r12.remove(r10);
    L6:
        this.size += (long) (r11 - r13);
        return r13;
    L5:
        r13 = r12.put(r10, r11);
        goto L6
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return Ints.saturatedCast(this.size);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final boolean setCount(@NullableDecl E r10, int r11, int r12) {
        CollectPreconditions.checkNonnegative(r11, "oldCount");
        CollectPreconditions.checkNonnegative(r12, "newCount");
        int r13 = this.backingMap.indexOf(r10);
        if (r13 != (-1)) goto L10;
        if (r11 == 0) goto L6;
        return false;
    L6:
        if (r12 <= 0) goto L8;
        this.backingMap.put(r10, r12);
        this.size += (long) r12;
    L8:
        return true;
    L10:
        if (this.backingMap.getValue(r13) == r11) goto L12;
        return false;
    L12:
        if (r12 != 0) goto L14;
        this.backingMap.removeEntry(r13);
        this.size -= (long) r11;
    L15:
        return true;
    L14:
        this.backingMap.setValue(r13, r12);
        this.size += (long) (r12 - r11);
        goto L15
    }
}
