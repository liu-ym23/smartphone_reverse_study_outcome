package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingMultiset<E> extends ForwardingCollection<E> implements Multiset<E> {

    protected class StandardElementSet extends Multisets.ElementSet<E> {
        final /* synthetic */ ForwardingMultiset this$0;

        public StandardElementSet(ForwardingMultiset r1) {
            this.this$0 = r1;
        }

        @Override // com.google.common.collect.Multisets.ElementSet
        Multiset<E> multiset() {
            return this.this$0;
        }
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected abstract Multiset<E> delegate();

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    protected ForwardingMultiset() {
    }

    @Override // com.google.common.collect.Multiset
    public int count(Object r1) {
        return delegate().count(r1);
    }

    @Override // com.google.common.collect.Multiset
    public int add(E r1, int r2) {
        return delegate().add(r1, r2);
    }

    @Override // com.google.common.collect.Multiset
    public int remove(Object r1, int r2) {
        return delegate().remove(r1, r2);
    }

    public Set<E> elementSet() {
        return delegate().elementSet();
    }

    public Set<Multiset.Entry<E>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(@Nullable Object r1) {
        if (r1 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r1) == true) goto L7;
        return false;
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // com.google.common.collect.Multiset
    public int setCount(E r1, int r2) {
        return delegate().setCount(r1, r2);
    }

    @Override // com.google.common.collect.Multiset
    public boolean setCount(E r1, int r2, int r3) {
        return delegate().setCount(r1, r2, r3);
    }

    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardContains(@Nullable Object r1) {
        if (count(r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.google.common.collect.ForwardingCollection
    protected void standardClear() {
        Iterators.clear(entrySet().iterator());
    }

    protected int standardCount(@Nullable Object r3) {
        Iterator<Multiset.Entry<E>> r2 = entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Multiset.Entry<E> r0 = r2.next();
        if (Objects.equal(r0.getElement(), r3) == false) goto L4;
        return r0.getCount();
    L9:
        return 0;
    }

    protected boolean standardAdd(E r2) {
        add(r2, 1);
        return true;
    }

    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardAddAll(Collection<? extends E> r1) {
        return Multisets.addAllImpl(this, r1);
    }

    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardRemove(Object r2) {
        if (remove(r2, 1) > 0) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardRemoveAll(Collection<?> r1) {
        return Multisets.removeAllImpl(this, r1);
    }

    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardRetainAll(Collection<?> r1) {
        return Multisets.retainAllImpl(this, r1);
    }

    protected int standardSetCount(E r1, int r2) {
        return Multisets.setCountImpl(this, r1, r2);
    }

    protected boolean standardSetCount(E r1, int r2, int r3) {
        return Multisets.setCountImpl(this, r1, r2, r3);
    }

    protected Iterator<E> standardIterator() {
        return Multisets.iteratorImpl(this);
    }

    protected int standardSize() {
        return Multisets.sizeImpl(this);
    }

    protected boolean standardEquals(@Nullable Object r1) {
        return Multisets.equalsImpl(this, r1);
    }

    protected int standardHashCode() {
        return entrySet().hashCode();
    }

    @Override // com.google.common.collect.ForwardingCollection
    protected String standardToString() {
        return entrySet().toString();
    }
}
