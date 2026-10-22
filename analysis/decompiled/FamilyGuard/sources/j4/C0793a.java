package j4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import k4.InterfaceC0814a;

/* renamed from: j4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0793a<T> implements Iterator<T>, InterfaceC0814a {

    /* renamed from: a, reason: collision with root package name */
    private final T[] f17814a;

    /* renamed from: b, reason: collision with root package name */
    private int f17815b;

    public C0793a(T[] tArr) {
        k.g(tArr, "array");
        this.f17814a = tArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f17815b < this.f17814a.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f17814a;
            int i5 = this.f17815b;
            this.f17815b = i5 + 1;
            return tArr[i5];
        } catch (ArrayIndexOutOfBoundsException e6) {
            this.f17815b--;
            throw new NoSuchElementException(e6.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
