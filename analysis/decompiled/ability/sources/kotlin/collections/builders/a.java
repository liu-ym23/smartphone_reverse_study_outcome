package kotlin.collections.builders;

import java.util.AbstractList;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.collections.builders.ListBuilder;

/* loaded from: classes3.dex */
public final class a implements ListIterator, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public final ListBuilder.BuilderSubList f4905a;
    public int b;
    public int c = -1;
    public int d;

    public a(ListBuilder.BuilderSubList builderSubList, int i) {
        this.f4905a = builderSubList;
        this.b = i;
        this.d = ((AbstractList) builderSubList).modCount;
    }

    public final void a() {
        if (((AbstractList) this.f4905a.e).modCount != this.d) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        a();
        int i = this.b;
        this.b = i + 1;
        ListBuilder.BuilderSubList builderSubList = this.f4905a;
        builderSubList.add(i, obj);
        this.c = -1;
        this.d = ((AbstractList) builderSubList).modCount;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.b < this.f4905a.c;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        a();
        int i = this.b;
        ListBuilder.BuilderSubList builderSubList = this.f4905a;
        if (i >= builderSubList.c) {
            throw new NoSuchElementException();
        }
        this.b = i + 1;
        this.c = i;
        return builderSubList.f4899a[builderSubList.b + i];
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
        ListBuilder.BuilderSubList builderSubList = this.f4905a;
        return builderSubList.f4899a[builderSubList.b + i6];
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
        ListBuilder.BuilderSubList builderSubList = this.f4905a;
        builderSubList.removeAt(i);
        this.b = this.c;
        this.c = -1;
        this.d = ((AbstractList) builderSubList).modCount;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        a();
        int i = this.c;
        if (i == -1) {
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.");
        }
        this.f4905a.set(i, obj);
    }
}
