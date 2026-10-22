package t;

import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d<T> extends a<T> {

    /* renamed from: c, reason: collision with root package name */
    public final T[] f12875c;

    public d(T[] tArr, int i10, int i11) {
        super(i10, i11);
        this.f12875c = tArr;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f12871a;
        this.f12871a = i10 + 1;
        return this.f12875c[i10];
    }

    @Override // java.util.ListIterator
    public final T previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f12871a - 1;
        this.f12871a = i10;
        return this.f12875c[i10];
    }
}
