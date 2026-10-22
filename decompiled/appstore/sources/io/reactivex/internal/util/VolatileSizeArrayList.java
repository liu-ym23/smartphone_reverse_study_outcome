package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;
    final ArrayList<T> list;

    public VolatileSizeArrayList() {
        this.list = new ArrayList();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T r10) {
        boolean r11 = this.list.add(r10);
        lazySet(this.list.size());
        return r11;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> r10) {
        boolean r11 = this.list.addAll(r10);
        lazySet(this.list.size());
        return r11;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.list.clear();
        lazySet(0);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object r10) {
        return this.list.contains(r10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> r10) {
        return this.list.containsAll(r10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object r10) {
        if ((r10 instanceof VolatileSizeArrayList) == false) goto L7;
        return this.list.equals(((VolatileSizeArrayList) r10).list);
    L7:
        return this.list.equals(r10);
    }

    @Override // java.util.List
    public T get(int r10) {
        return this.list.get(r10);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.list.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object r10) {
        return this.list.indexOf(r10);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        if (get() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return this.list.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object r10) {
        return this.list.lastIndexOf(r10);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return this.list.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object r10) {
        boolean r11 = this.list.remove(r10);
        lazySet(this.list.size());
        return r11;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> r10) {
        boolean r11 = this.list.removeAll(r10);
        lazySet(this.list.size());
        return r11;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> r10) {
        boolean r11 = this.list.retainAll(r10);
        lazySet(this.list.size());
        return r11;
    }

    @Override // java.util.List
    public T set(int r10, T r11) {
        return this.list.set(r10, r11);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return get();
    }

    @Override // java.util.List
    public List<T> subList(int r10, int r11) {
        return this.list.subList(r10, r11);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.list.toArray();
    }

    @Override // java.util.concurrent.atomic.AtomicInteger
    public String toString() {
        return this.list.toString();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int r10) {
        return this.list.listIterator(r10);
    }

    @Override // java.util.List, java.util.Collection
    public <E> E[] toArray(E[] r10) {
        return (E[]) this.list.toArray(r10);
    }

    public VolatileSizeArrayList(int r10) {
        this.list = new ArrayList(r10);
    }

    @Override // java.util.List
    public void add(int r10, T r11) {
        this.list.add(r10, r11);
        lazySet(this.list.size());
    }

    @Override // java.util.List
    public boolean addAll(int r10, Collection<? extends T> r11) {
        boolean r12 = this.list.addAll(r10, r11);
        lazySet(this.list.size());
        return r12;
    }

    @Override // java.util.List
    public T remove(int r10) {
        T r11 = this.list.remove(r10);
        lazySet(this.list.size());
        return r11;
    }
}
