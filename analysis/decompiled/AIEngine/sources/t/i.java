package t;

import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i<E> extends a<E> {

    /* renamed from: c, reason: collision with root package name */
    public final E f12892c;

    public i(E e10, int i10) {
        super(i10, 1);
        this.f12892c = e10;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f12871a++;
        return this.f12892c;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        this.f12871a--;
        return this.f12892c;
    }
}
