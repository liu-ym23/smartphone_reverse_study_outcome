package com.google.gson.internal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public class NonNullElementWrapperList<E> extends AbstractList<E> implements RandomAccess {
    private final ArrayList<E> delegate;

    public NonNullElementWrapperList(ArrayList<E> r1) {
        this.delegate = (ArrayList) Objects.requireNonNull(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int r1) {
        return this.delegate.get(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.delegate.size();
    }

    private E nonNull(E r1) {
        if (r1 == null) goto L5;
        return r1;
    L5:
        throw new NullPointerException("Element must be non-null");
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int r2, E r3) {
        return this.delegate.set(r2, nonNull(r3));
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r2, E r3) {
        this.delegate.add(r2, nonNull(r3));
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int r1) {
        return this.delegate.remove(r1);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.delegate.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r1) {
        return this.delegate.remove(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> r1) {
        return this.delegate.removeAll(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> r1) {
        return this.delegate.retainAll(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r1) {
        return this.delegate.contains(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object r1) {
        return this.delegate.indexOf(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object r1) {
        return this.delegate.lastIndexOf(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.delegate.toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] r1) {
        return (T[]) this.delegate.toArray(r1);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object r1) {
        return this.delegate.equals(r1);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return this.delegate.hashCode();
    }
}
