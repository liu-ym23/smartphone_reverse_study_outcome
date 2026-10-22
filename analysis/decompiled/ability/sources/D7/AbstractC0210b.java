package D7;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: D7.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0210b implements Iterator, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public int f400a;
    public Object b;

    public abstract void a();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.f400a;
        if (i == 0) {
            this.f400a = 3;
            a();
            return this.f400a == 1;
        }
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f400a;
        if (i == 1) {
            this.f400a = 0;
            return this.b;
        }
        if (i != 2) {
            this.f400a = 3;
            a();
            if (this.f400a == 1) {
                this.f400a = 0;
                return this.b;
            }
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
