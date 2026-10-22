package d7;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class b implements Iterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public int f2945f;

    /* renamed from: g, reason: collision with root package name */
    public Object f2946g;

    public abstract void a();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2 = this.f2945f;
        if (i2 == 0) {
            this.f2945f = 3;
            a();
            return this.f2945f == 1;
        }
        if (i2 == 1) {
            return true;
        }
        if (i2 == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i2 = this.f2945f;
        if (i2 == 1) {
            this.f2945f = 0;
            return this.f2946g;
        }
        if (i2 != 2) {
            this.f2945f = 3;
            a();
            if (this.f2945f == 1) {
                this.f2945f = 0;
                return this.f2946g;
            }
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
