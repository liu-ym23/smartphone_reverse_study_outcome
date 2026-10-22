package androidx.datastore.preferences.protobuf;

import java.util.ListIterator;

/* loaded from: classes.dex */
public final class s0 implements ListIterator {

    /* renamed from: a, reason: collision with root package name */
    public final ListIterator f3535a;

    public s0(u0 u0Var, int i4) {
        this.f3535a = u0Var.f3542a.listIterator(i4);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f3535a.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f3535a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return (String) this.f3535a.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f3535a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return (String) this.f3535a.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f3535a.previousIndex();
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
