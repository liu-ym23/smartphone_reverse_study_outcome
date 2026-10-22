package f0;

import java.util.ListIterator;

/* loaded from: classes.dex */
public abstract class a implements ListIterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public int f3326f;

    /* renamed from: g, reason: collision with root package name */
    public int f3327g;

    public a(int i2, int i10) {
        this.f3326f = i2;
        this.f3327g = i10;
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f3326f < this.f3327g;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f3326f > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f3326f;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f3326f - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
