package q;

import java.util.Iterator;
import java.util.NoSuchElementException;
import k4.InterfaceC0814a;

/* renamed from: q.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0937e<T> implements Iterator<T>, InterfaceC0814a {

    /* renamed from: a, reason: collision with root package name */
    private int f19626a;

    /* renamed from: b, reason: collision with root package name */
    private int f19627b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f19628c;

    public AbstractC0937e(int i5) {
        this.f19626a = i5;
    }

    protected abstract T b(int i5);

    protected abstract void c(int i5);

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f19627b < this.f19626a;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T tB = b(this.f19627b);
        this.f19627b++;
        this.f19628c = true;
        return tB;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (!this.f19628c) {
            throw new IllegalStateException("Call next() before removing an element.");
        }
        int i5 = this.f19627b - 1;
        this.f19627b = i5;
        c(i5);
        this.f19626a--;
        this.f19628c = false;
    }
}
