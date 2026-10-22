package E7;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.collections.builders.ListBuilder;

/* loaded from: classes3.dex */
public final class a implements ListIterator, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public final ListBuilder f489a;
    public int b;
    public int c = -1;
    public int d;

    public a(ListBuilder listBuilder, int i) {
        this.f489a = listBuilder;
        this.b = i;
        this.d = ((AbstractList) listBuilder).modCount;
    }

    public final void a() {
        if (((AbstractList) this.f489a).modCount != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        a();
        int i = this.b;
        this.b = i + 1;
        ListBuilder listBuilder = this.f489a;
        listBuilder.add(i, obj);
        this.c = -1;
        this.d = ((AbstractList) listBuilder).modCount;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.f489a.b;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        a();
        int i = this.b;
        ListBuilder listBuilder = this.f489a;
        if (i >= listBuilder.b) {
            throw new NoSuchElementException();
        }
        this.b = i + 1;
        this.c = i;
        return listBuilder.f4898a[i];
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        a();
        int i = this.b;
        if (i <= 0) {
            throw new NoSuchElementException();
        }
        int i6 = i - 1;
        this.b = i6;
        this.c = i6;
        return this.f489a.f4898a[i6];
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        a();
        int i = this.c;
        if (i == -1) {
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.");
        }
        ListBuilder listBuilder = this.f489a;
        listBuilder.removeAt(i);
        this.b = this.c;
        this.c = -1;
        this.d = ((AbstractList) listBuilder).modCount;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        a();
        int i = this.c;
        if (i == -1) {
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
        }
        this.f489a.set(i, obj);
    }
}
