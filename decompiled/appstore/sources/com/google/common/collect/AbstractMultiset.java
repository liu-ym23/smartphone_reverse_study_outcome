package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
abstract class AbstractMultiset<E> extends AbstractCollection<E> implements Multiset<E> {

    @MonotonicNonNullDecl
    private transient Set<E> elementSet;

    @MonotonicNonNullDecl
    private transient Set<Multiset.Entry<E>> entrySet;

    public class ElementSet extends Multisets.ElementSet<E> {
        final /* synthetic */ AbstractMultiset this$0;

        public ElementSet(AbstractMultiset r10) {
            this.this$0 = r10;
        }

        @Override // com.google.common.collect.Multisets.ElementSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return this.this$0.elementIterator();
        }

        @Override // com.google.common.collect.Multisets.ElementSet
        public Multiset<E> multiset() {
            return this.this$0;
        }
    }

    public class EntrySet extends Multisets.EntrySet<E> {
        final /* synthetic */ AbstractMultiset this$0;

        public EntrySet(AbstractMultiset r10) {
            this.this$0 = r10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Multiset.Entry<E>> iterator() {
            return this.this$0.entryIterator();
        }

        @Override // com.google.common.collect.Multisets.EntrySet
        public Multiset<E> multiset() {
            return this.this$0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.this$0.distinctElements();
        }
    }

    public AbstractMultiset() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final boolean add(@NullableDecl E r10) {
        add(r10, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean addAll(Collection<? extends E> r10) {
        return Multisets.addAllImpl(this, r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract void clear();

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public boolean contains(@NullableDecl Object r10) {
        if (count(r10) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Set<E> createElementSet() {
        return new ElementSet(this);
    }

    public Set<Multiset.Entry<E>> createEntrySet() {
        return new EntrySet(this);
    }

    public abstract int distinctElements();

    public abstract Iterator<E> elementIterator();

    @Override // com.google.common.collect.Multiset
    public Set<E> elementSet() {
        Set<E> r10 = this.elementSet;
        if (r10 != null) goto L6;
        Set<E> r11 = createElementSet();
        this.elementSet = r11;
        return r11;
    L6:
        return r10;
    }

    public abstract Iterator<Multiset.Entry<E>> entryIterator();

    @Override // com.google.common.collect.Multiset
    public Set<Multiset.Entry<E>> entrySet() {
        Set<Multiset.Entry<E>> r10 = this.entrySet;
        if (r10 != null) goto L6;
        Set<Multiset.Entry<E>> r11 = createEntrySet();
        this.entrySet = r11;
        return r11;
    L6:
        return r10;
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final boolean equals(@NullableDecl Object r10) {
        return Multisets.equalsImpl(this, r10);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final boolean remove(@NullableDecl Object r10) {
        if (remove(r10, 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final boolean removeAll(Collection<?> r10) {
        return Multisets.removeAllImpl(this, r10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final boolean retainAll(Collection<?> r10) {
        return Multisets.retainAllImpl(this, r10);
    }

    @CanIgnoreReturnValue
    public int setCount(@NullableDecl E r10, int r11) {
        return Multisets.setCountImpl(this, r10, r11);
    }

    @Override // java.util.AbstractCollection, com.google.common.collect.Multiset
    public final String toString() {
        return entrySet().toString();
    }

    @CanIgnoreReturnValue
    public int add(@NullableDecl E r10, int r11) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object r10, int r11) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    public boolean setCount(@NullableDecl E r10, int r11, int r12) {
        return Multisets.setCountImpl(this, r10, r11, r12);
    }
}
