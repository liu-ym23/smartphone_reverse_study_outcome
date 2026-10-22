package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected abstract List<E> delegate();

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Object delegate() {
        return delegate();
    }

    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    protected /* bridge */ /* synthetic */ Collection delegate() {
        return delegate();
    }

    protected ForwardingList() {
    }

    public void add(int r1, E r2) {
        delegate().add(r1, r2);
    }

    public boolean addAll(int r1, Collection<? extends E> r2) {
        return delegate().addAll(r1, r2);
    }

    @Override // java.util.List
    public E get(int r1) {
        return delegate().get(r1);
    }

    @Override // java.util.List
    public int indexOf(Object r1) {
        return delegate().indexOf(r1);
    }

    @Override // java.util.List
    public int lastIndexOf(Object r1) {
        return delegate().lastIndexOf(r1);
    }

    public ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    public ListIterator<E> listIterator(int r1) {
        return delegate().listIterator(r1);
    }

    @Override // java.util.List
    public E remove(int r1) {
        return delegate().remove(r1);
    }

    public E set(int r1, E r2) {
        return delegate().set(r1, r2);
    }

    public List<E> subList(int r1, int r2) {
        return delegate().subList(r1, r2);
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@Nullable Object r1) {
        if (r1 != this) goto L4;
    L7:
        return true;
    L4:
        if (delegate().equals(r1) == true) goto L7;
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return delegate().hashCode();
    }

    protected boolean standardAdd(E r2) {
        add(size(), r2);
        return true;
    }

    protected boolean standardAddAll(int r1, Iterable<? extends E> r2) {
        return Lists.addAllImpl(this, r1, r2);
    }

    protected int standardIndexOf(@Nullable Object r1) {
        return Lists.indexOfImpl(this, r1);
    }

    protected int standardLastIndexOf(@Nullable Object r1) {
        return Lists.lastIndexOfImpl(this, r1);
    }

    protected Iterator<E> standardIterator() {
        return listIterator();
    }

    protected ListIterator<E> standardListIterator() {
        return listIterator(0);
    }

    protected ListIterator<E> standardListIterator(int r1) {
        return Lists.listIteratorImpl(this, r1);
    }

    protected List<E> standardSubList(int r1, int r2) {
        return Lists.subListImpl(this, r1, r2);
    }

    protected boolean standardEquals(@Nullable Object r1) {
        return Lists.equalsImpl(this, r1);
    }

    protected int standardHashCode() {
        return Lists.hashCodeImpl(this);
    }
}
