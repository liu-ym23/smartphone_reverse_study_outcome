package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class ForwardingCollection<E> extends ForwardingObject implements Collection<E> {
    public ForwardingCollection() {
    }

    @CanIgnoreReturnValue
    public boolean add(E r10) {
        return delegate().add(r10);
    }

    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> r10) {
        return delegate().addAll(r10);
    }

    public void clear() {
        delegate().clear();
    }

    public boolean contains(Object r10) {
        return delegate().contains(r10);
    }

    public boolean containsAll(Collection<?> r10) {
        return delegate().containsAll(r10);
    }

    @Override // com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingObject
    public abstract Collection<E> delegate();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Iterator<E> iterator() {
        return delegate().iterator();
    }

    @CanIgnoreReturnValue
    public boolean remove(Object r10) {
        return delegate().remove(r10);
    }

    @CanIgnoreReturnValue
    public boolean removeAll(Collection<?> r10) {
        return delegate().removeAll(r10);
    }

    @CanIgnoreReturnValue
    public boolean retainAll(Collection<?> r10) {
        return delegate().retainAll(r10);
    }

    @Override // java.util.Collection
    public int size() {
        return delegate().size();
    }

    public boolean standardAddAll(Collection<? extends E> r10) {
        return Iterators.addAll(this, r10.iterator());
    }

    public void standardClear() {
        Iterators.clear(iterator());
    }

    public boolean standardContains(@NullableDecl Object r10) {
        return Iterators.contains(iterator(), r10);
    }

    public boolean standardContainsAll(Collection<?> r10) {
        return Collections2.containsAllImpl(this, r10);
    }

    public boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    public boolean standardRemove(@NullableDecl Object r10) {
        Iterator<E> r11 = iterator();
    L4:
        if (r11.hasNext() == false) goto L9;
        if (Objects.equal(r11.next(), r10) == false) goto L4;
        r11.remove();
        return true;
    L9:
        return false;
    }

    public boolean standardRemoveAll(Collection<?> r10) {
        return Iterators.removeAll(iterator(), r10);
    }

    public boolean standardRetainAll(Collection<?> r10) {
        return Iterators.retainAll(iterator(), r10);
    }

    public Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    public String standardToString() {
        return Collections2.toStringImpl(this);
    }

    public Object[] toArray() {
        return delegate().toArray();
    }

    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] r10) {
        return (T[]) delegate().toArray(r10);
    }

    public <T> T[] standardToArray(T[] r10) {
        return (T[]) ObjectArrays.toArrayImpl(this, r10);
    }
}
