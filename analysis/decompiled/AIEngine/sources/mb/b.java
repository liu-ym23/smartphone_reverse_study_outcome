package mb;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class b<T> implements Iterator<T>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public int f10545a;

    /* renamed from: b, reason: collision with root package name */
    public T f10546b;

    public abstract void a();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i10 = this.f10545a;
        if (i10 == 0) {
            this.f10545a = 3;
            a();
            return this.f10545a == 1;
        }
        if (i10 == 1) {
            return true;
        }
        if (i10 == 2) {
            return false;
        }
        throw new IllegalArgumentException("hasNext called when the iterator is in the FAILED state.");
    }

    @Override // java.util.Iterator
    public final T next() {
        int i10 = this.f10545a;
        if (i10 == 1) {
            this.f10545a = 0;
            return this.f10546b;
        }
        if (i10 != 2) {
            this.f10545a = 3;
            a();
            if (this.f10545a == 1) {
                this.f10545a = 0;
                return this.f10546b;
            }
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
