package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class ForwardingMultiset<E> extends ForwardingCollection<E> implements Multiset<E> {

    @Beta
    public class StandardElementSet extends Multisets.ElementSet<E> {
        final /* synthetic */ ForwardingMultiset this$0;

        public StandardElementSet(ForwardingMultiset r10) {
            this.this$0 = r10;
        }

        @Override // com.google.common.collect.Multisets.ElementSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Multisets.elementIterator(multiset().entrySet().iterator());
        }

        @Override // com.google.common.collect.Multisets.ElementSet
        public Multiset<E> multiset() {
            return this.this$0;
        }
    }

    public ForwardingMultiset() {
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(E r10, int r11) {
        return delegate().add(r10, r11);
    }

    @Override // com.google.common.collect.Multiset
    public int count(Object r10) {
        return delegate().count(r10);
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract Multiset<E> delegate();

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    public Set<E> elementSet() {
        return delegate().elementSet();
    }

    public Set<Multiset.Entry<E>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r10) == true) goto L7;
        return false;
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(Object r10, int r11) {
        return delegate().remove(r10, r11);
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(E r10, int r11) {
        return delegate().setCount(r10, r11);
    }

    public boolean standardAdd(E r10) {
        add(r10, 1);
        return true;
    }

    @Override // com.google.common.collect.ForwardingCollection
    @Beta
    public boolean standardAddAll(Collection<? extends E> r10) {
        return Multisets.addAllImpl(this, r10);
    }

    @Override // com.google.common.collect.ForwardingCollection
    public void standardClear() {
        Iterators.clear(entrySet().iterator());
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardContains(@NullableDecl Object r10) {
        if (count(r10) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Beta
    public int standardCount(@NullableDecl Object r10) {
        Iterator<Multiset.Entry<E>> r11 = entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        Multiset.Entry<E> r12 = r11.next();
        if (Objects.equal(r12.getElement(), r10) == false) goto L4;
        return r12.getCount();
    L9:
        return 0;
    }

    public boolean standardEquals(@NullableDecl Object r10) {
        return Multisets.equalsImpl(this, r10);
    }

    public int standardHashCode() {
        return entrySet().hashCode();
    }

    public Iterator<E> standardIterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardRemove(Object r10) {
        if (remove(r10, 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardRemoveAll(Collection<?> r10) {
        return Multisets.removeAllImpl(this, r10);
    }

    @Override // com.google.common.collect.ForwardingCollection
    public boolean standardRetainAll(Collection<?> r10) {
        return Multisets.retainAllImpl(this, r10);
    }

    public int standardSetCount(E r10, int r11) {
        return Multisets.setCountImpl(this, r10, r11);
    }

    public int standardSize() {
        return Multisets.linearTimeSizeImpl(this);
    }

    @Override // com.google.common.collect.ForwardingCollection
    public String standardToString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(E r10, int r11, int r12) {
        return delegate().setCount(r10, r11, r12);
    }

    public boolean standardSetCount(E r10, int r11, int r12) {
        return Multisets.setCountImpl(this, r10, r11, r12);
    }
}
