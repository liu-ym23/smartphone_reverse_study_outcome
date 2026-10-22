package D7;

import i9.C1567b;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class E implements Iterator, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f394a = 1;
    public final Iterator b;
    public int c;

    public E(Iterator iterator) {
        kotlin.jvm.internal.k.f(iterator, "iterator");
        this.b = iterator;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        Iterator it;
        switch (this.f394a) {
            case 0:
                return this.b.hasNext();
            case 1:
                break;
            default:
                return this.c > 0 && this.b.hasNext();
        }
        while (true) {
            int i = this.c;
            it = this.b;
            if (i > 0 && it.hasNext()) {
                it.next();
                this.c--;
            }
        }
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Iterator it;
        switch (this.f394a) {
            case 0:
                int i = this.c;
                this.c = i + 1;
                if (i >= 0) {
                    return new D(i, this.b.next());
                }
                H4.o.X();
                throw null;
            case 1:
                break;
            default:
                int i6 = this.c;
                if (i6 == 0) {
                    throw new NoSuchElementException();
                }
                this.c = i6 - 1;
                return this.b.next();
        }
        while (true) {
            int i10 = this.c;
            it = this.b;
            if (i10 > 0 && it.hasNext()) {
                it.next();
                this.c--;
            }
        }
        return it.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f394a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public E(C1567b c1567b, byte b) {
        this.c = c1567b.c;
        this.b = c1567b.b.iterator();
    }

    public E(C1567b c1567b) {
        this.b = c1567b.b.iterator();
        this.c = c1567b.c;
    }
}
