package com.fasterxml.jackson.databind.l;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ArrayIterator.java */
/* JADX INFO: loaded from: classes2.dex */
public class d<T> implements Iterable<T>, Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T[] f13013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13014b;

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this;
    }

    public d(T[] r1) {
        this.f13013a = r1;
        this.f13014b = 0;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.f13014b >= this.f13013a.length) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        int r0 = this.f13014b;
        T[] r1 = this.f13013a;
        if (r0 >= r1.length) goto L7;
        this.f13014b = r0 + 1;
        return r1[r0];
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
