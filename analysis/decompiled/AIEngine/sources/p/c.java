package p;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class c<T> implements Iterator<T>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public int f11356a;

    /* renamed from: b, reason: collision with root package name */
    public int f11357b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11358c;

    public c(int i10) {
        this.f11356a = i10;
    }

    public abstract T a(int i10);

    public abstract void b(int i10);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11357b < this.f11356a;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T tA = a(this.f11357b);
        this.f11357b++;
        this.f11358c = true;
        return tA;
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f11358c) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i10 = this.f11357b - 1;
        this.f11357b = i10;
        b(i10);
        this.f11356a--;
        this.f11358c = false;
    }
}
