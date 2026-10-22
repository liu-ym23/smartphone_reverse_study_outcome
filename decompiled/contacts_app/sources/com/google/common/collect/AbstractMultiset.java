package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractMultiset<E> extends AbstractCollection<E> implements Multiset<E> {
    private transient Set<E> elementSet;
    private transient Set<Multiset.Entry<E>> entrySet;

    class ElementSet extends Multisets.ElementSet<E> {
        final /* synthetic */ AbstractMultiset this$0;

        ElementSet(AbstractMultiset r1) {
            this.this$0 = r1;
        }

        @Override // com.google.common.collect.Multisets.ElementSet
        Multiset<E> multiset() {
            return this.this$0;
        }
    }

    class EntrySet extends Multisets.EntrySet<E> {
        final /* synthetic */ AbstractMultiset this$0;

        EntrySet(AbstractMultiset r1) {
            this.this$0 = r1;
        }

        @Override // com.google.common.collect.Multisets.EntrySet
        Multiset<E> multiset() {
            return this.this$0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Multiset.Entry<E>> iterator() {
            return this.this$0.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.distinctElements();
        }
    }

    abstract int distinctElements();

    abstract Iterator<Multiset.Entry<E>> entryIterator();

    AbstractMultiset() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return Multisets.sizeImpl(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public boolean contains(@Nullable Object r1) {
        if (count(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    public int count(@Nullable Object r3) {
        Iterator<Multiset.Entry<E>> r2 = entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Multiset.Entry<E> r0 = r2.next();
        if (Objects.equal(r0.getElement(), r3) == false) goto L4;
        return r0.getCount();
    L9:
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public boolean add(@Nullable E r2) {
        add(r2, 1);
        return true;
    }

    public int add(@Nullable E r1, int r2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public boolean remove(@Nullable Object r2) {
        if (remove(r2, 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    public int remove(@Nullable Object r1, int r2) {
        throw new UnsupportedOperationException();
    }

    public int setCount(@Nullable E r1, int r2) {
        return Multisets.setCountImpl(this, r1, r2);
    }

    @Override // com.google.common.collect.Multiset
    public boolean setCount(@Nullable E r1, int r2, int r3) {
        return Multisets.setCountImpl(this, r1, r2, r3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> r1) {
        return Multisets.addAllImpl(this, r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public boolean removeAll(Collection<?> r1) {
        return Multisets.removeAllImpl(this, r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public boolean retainAll(Collection<?> r1) {
        return Multisets.retainAllImpl(this, r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Iterators.clear(entryIterator());
    }

    @Override // com.google.common.collect.Multiset
    public Set<E> elementSet() {
        Set<E> r0 = this.elementSet;
        if (r0 != null) goto L6;
        Set<E> r1 = createElementSet();
        this.elementSet = r1;
        return r1;
    L6:
        return r0;
    }

    Set<E> createElementSet() {
        return new ElementSet(this);
    }

    public Set<Multiset.Entry<E>> entrySet() {
        Set<Multiset.Entry<E>> r0 = this.entrySet;
        if (r0 != null) goto L6;
        Set<Multiset.Entry<E>> r1 = createEntrySet();
        this.entrySet = r1;
        return r1;
    L6:
        return r0;
    }

    Set<Multiset.Entry<E>> createEntrySet() {
        return new EntrySet(this);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(@Nullable Object r1) {
        return Multisets.equalsImpl(this, r1);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset
    public String toString() {
        return entrySet().toString();
    }
}
