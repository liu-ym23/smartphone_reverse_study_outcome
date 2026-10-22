package q4;

import V3.n;
import V3.o;
import V3.v;
import a4.C0428b;
import java.util.Iterator;
import java.util.NoSuchElementException;
import k4.InterfaceC0814a;

/* renamed from: q4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class C0989c<T> extends d<T> implements Iterator<T>, Z3.e<v>, InterfaceC0814a {

    /* renamed from: a, reason: collision with root package name */
    private int f19940a;

    /* renamed from: b, reason: collision with root package name */
    private T f19941b;

    /* renamed from: c, reason: collision with root package name */
    private Iterator<? extends T> f19942c;

    /* renamed from: d, reason: collision with root package name */
    private Z3.e<? super v> f19943d;

    private final Throwable j() {
        int i5 = this.f19940a;
        if (i5 == 4) {
            return new NoSuchElementException();
        }
        if (i5 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f19940a);
    }

    private final T k() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // q4.d
    public Object c(T t5, Z3.e<? super v> eVar) {
        this.f19941b = t5;
        this.f19940a = 3;
        this.f19943d = eVar;
        Object objE = C0428b.e();
        if (objE == C0428b.e()) {
            kotlin.coroutines.jvm.internal.h.c(eVar);
        }
        return objE == C0428b.e() ? objE : v.f5542a;
    }

    @Override // q4.d
    public Object g(Iterator<? extends T> it, Z3.e<? super v> eVar) {
        if (!it.hasNext()) {
            return v.f5542a;
        }
        this.f19942c = it;
        this.f19940a = 2;
        this.f19943d = eVar;
        Object objE = C0428b.e();
        if (objE == C0428b.e()) {
            kotlin.coroutines.jvm.internal.h.c(eVar);
        }
        return objE == C0428b.e() ? objE : v.f5542a;
    }

    @Override // Z3.e
    public Z3.i getContext() {
        return Z3.j.f6656a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i5 = this.f19940a;
            if (i5 != 0) {
                if (i5 != 1) {
                    if (i5 == 2 || i5 == 3) {
                        return true;
                    }
                    if (i5 == 4) {
                        return false;
                    }
                    throw j();
                }
                Iterator<? extends T> it = this.f19942c;
                j4.k.d(it);
                if (it.hasNext()) {
                    this.f19940a = 2;
                    return true;
                }
                this.f19942c = null;
            }
            this.f19940a = 5;
            Z3.e<? super v> eVar = this.f19943d;
            j4.k.d(eVar);
            this.f19943d = null;
            eVar.resumeWith(n.a(v.f5542a));
        }
    }

    public final void l(Z3.e<? super v> eVar) {
        this.f19943d = eVar;
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i5 = this.f19940a;
        if (i5 == 0 || i5 == 1) {
            return k();
        }
        if (i5 == 2) {
            this.f19940a = 1;
            Iterator<? extends T> it = this.f19942c;
            j4.k.d(it);
            return it.next();
        }
        if (i5 != 3) {
            throw j();
        }
        this.f19940a = 0;
        T t5 = this.f19941b;
        this.f19941b = null;
        return t5;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // Z3.e
    public void resumeWith(Object obj) {
        o.b(obj);
        this.f19940a = 4;
    }
}
