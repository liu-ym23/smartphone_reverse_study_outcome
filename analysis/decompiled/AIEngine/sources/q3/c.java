package q3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c<T> implements Iterator<T>, Iterable<T> {

    /* renamed from: a, reason: collision with root package name */
    public final T[] f11554a;

    /* renamed from: b, reason: collision with root package name */
    public int f11555b = 0;

    public c(T[] tArr) {
        this.f11554a = tArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11555b < this.f11554a.length;
    }

    @Override // java.util.Iterator
    public final T next() {
        int i10 = this.f11555b;
        T[] tArr = this.f11554a;
        if (i10 >= tArr.length) {
            throw new NoSuchElementException();
        }
        this.f11555b = i10 + 1;
        return tArr[i10];
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        return this;
    }
}
