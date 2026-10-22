package f9;

import java.util.ListIterator;

/* loaded from: classes.dex */
public final class f0 implements ListIterator {

    /* renamed from: f, reason: collision with root package name */
    public ListIterator f3555f;

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f3555f.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f3555f.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return (String) this.f3555f.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f3555f.nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return (String) this.f3555f.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f3555f.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
