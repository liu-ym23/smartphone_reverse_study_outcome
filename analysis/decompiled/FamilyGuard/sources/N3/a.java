package N3;

import G3.e;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class a<T> implements e<T> {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicReference<C0064a<T>> f4244a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference<C0064a<T>> f4245b = new AtomicReference<>();

    /* renamed from: N3.a$a, reason: collision with other inner class name */
    static final class C0064a<E> extends AtomicReference<C0064a<E>> {

        /* renamed from: a, reason: collision with root package name */
        private E f4246a;

        C0064a() {
        }

        public E a() {
            E eB = b();
            e(null);
            return eB;
        }

        public E b() {
            return this.f4246a;
        }

        public C0064a<E> c() {
            return get();
        }

        public void d(C0064a<E> c0064a) {
            lazySet(c0064a);
        }

        public void e(E e6) {
            this.f4246a = e6;
        }

        C0064a(E e6) {
            e(e6);
        }
    }

    public a() {
        C0064a<T> c0064a = new C0064a<>();
        e(c0064a);
        f(c0064a);
    }

    C0064a<T> a() {
        return this.f4245b.get();
    }

    C0064a<T> c() {
        return this.f4245b.get();
    }

    @Override // G3.f
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    C0064a<T> d() {
        return this.f4244a.get();
    }

    void e(C0064a<T> c0064a) {
        this.f4245b.lazySet(c0064a);
    }

    C0064a<T> f(C0064a<T> c0064a) {
        return this.f4244a.getAndSet(c0064a);
    }

    @Override // G3.f
    public boolean isEmpty() {
        return c() == d();
    }

    @Override // G3.f
    public boolean offer(T t5) {
        if (t5 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        C0064a<T> c0064a = new C0064a<>(t5);
        f(c0064a).d(c0064a);
        return true;
    }

    @Override // G3.e, G3.f
    public T poll() {
        C0064a<T> c0064aC;
        C0064a<T> c0064aA = a();
        C0064a<T> c0064aC2 = c0064aA.c();
        if (c0064aC2 != null) {
            T tA = c0064aC2.a();
            e(c0064aC2);
            return tA;
        }
        if (c0064aA == d()) {
            return null;
        }
        do {
            c0064aC = c0064aA.c();
        } while (c0064aC == null);
        T tA2 = c0064aC.a();
        e(c0064aC);
        return tA2;
    }
}
