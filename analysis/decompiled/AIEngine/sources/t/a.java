package t;

import java.util.ListIterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a<E> implements ListIterator<E>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public int f12871a;

    /* renamed from: b, reason: collision with root package name */
    public int f12872b;

    public a(int i10, int i11) {
        this.f12871a = i10;
        this.f12872b = i11;
    }

    @Override // java.util.ListIterator
    public void add(E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f12871a < this.f12872b;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f12871a > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f12871a;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f12871a - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public void set(E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
