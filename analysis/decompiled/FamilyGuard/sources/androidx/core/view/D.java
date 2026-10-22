package androidx.core.view;

import W3.C0403n;
import i4.InterfaceC0772l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k4.InterfaceC0814a;

/* loaded from: classes.dex */
public final class D<T> implements Iterator<T>, InterfaceC0814a {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC0772l<T, Iterator<T>> f9721a;

    /* renamed from: b, reason: collision with root package name */
    private final List<Iterator<T>> f9722b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private Iterator<? extends T> f9723c;

    /* JADX WARN: Multi-variable type inference failed */
    public D(Iterator<? extends T> it, InterfaceC0772l<? super T, ? extends Iterator<? extends T>> interfaceC0772l) {
        this.f9721a = interfaceC0772l;
        this.f9723c = it;
    }

    private final void b(T t5) {
        Iterator<T> itInvoke = this.f9721a.invoke(t5);
        if (itInvoke != null && itInvoke.hasNext()) {
            this.f9722b.add(this.f9723c);
            this.f9723c = itInvoke;
        } else {
            while (!this.f9723c.hasNext() && !this.f9722b.isEmpty()) {
                this.f9723c = (Iterator) C0403n.K(this.f9722b);
                C0403n.v(this.f9722b);
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f9723c.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        T next = this.f9723c.next();
        b(next);
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
