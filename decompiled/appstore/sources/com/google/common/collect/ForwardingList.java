package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    public ForwardingList() {
    }

    public void add(int r10, E r11) {
        delegate().add(r10, r11);
    }

    @CanIgnoreReturnValue
    public boolean addAll(int r10, Collection<? extends E> r11) {
        return delegate().addAll(r10, r11);
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract List<E> delegate();

    @Override // java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object r10) {
        if (r10 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r10) == true) goto L7;
        return false;
    }

    @Override // java.util.List
    public E get(int r10) {
        return delegate().get(r10);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object r10) {
        return delegate().indexOf(r10);
    }

    @Override // java.util.List
    public int lastIndexOf(Object r10) {
        return delegate().lastIndexOf(r10);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    public E remove(int r10) {
        return delegate().remove(r10);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    public E set(int r10, E r11) {
        return delegate().set(r10, r11);
    }

    public boolean standardAdd(E r10) {
        add(size(), r10);
        return true;
    }

    public boolean standardAddAll(int r10, Iterable<? extends E> r11) {
        return Lists.addAllImpl(this, r10, r11);
    }

    @Beta
    public boolean standardEquals(@NullableDecl Object r10) {
        return Lists.equalsImpl(this, r10);
    }

    @Beta
    public int standardHashCode() {
        return Lists.hashCodeImpl(this);
    }

    public int standardIndexOf(@NullableDecl Object r10) {
        return Lists.indexOfImpl(this, r10);
    }

    public Iterator<E> standardIterator() {
        return listIterator();
    }

    public int standardLastIndexOf(@NullableDecl Object r10) {
        return Lists.lastIndexOfImpl(this, r10);
    }

    public ListIterator<E> standardListIterator() {
        return listIterator(0);
    }

    @Beta
    public List<E> standardSubList(int r10, int r11) {
        return Lists.subListImpl(this, r10, r11);
    }

    @Override // java.util.List
    public List<E> subList(int r10, int r11) {
        return delegate().subList(r10, r11);
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int r10) {
        return delegate().listIterator(r10);
    }

    @Beta
    public ListIterator<E> standardListIterator(int r10) {
        return Lists.listIteratorImpl(this, r10);
    }
}
