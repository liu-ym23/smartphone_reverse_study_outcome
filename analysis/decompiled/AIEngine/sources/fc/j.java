package fc;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j<T> extends k<T> implements Iterator<T>, qb.b<lb.n>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public int f8818a;

    /* renamed from: b, reason: collision with root package name */
    public T f8819b;

    /* renamed from: c, reason: collision with root package name */
    public Iterator<? extends T> f8820c;

    /* renamed from: d, reason: collision with root package name */
    public qb.b<? super lb.n> f8821d;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // fc.k
    public final void a(Object obj, qb.b frame) {
        this.f8819b = obj;
        this.f8818a = 3;
        this.f8821d = frame;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        kotlin.jvm.internal.g.f(frame, "frame");
    }

    @Override // fc.k
    public final Object b(Iterator<? extends T> it, qb.b<? super lb.n> bVar) {
        if (!it.hasNext()) {
            return lb.n.f10413a;
        }
        this.f8820c = it;
        this.f8818a = 2;
        this.f8821d = bVar;
        return CoroutineSingletons.f10059a;
    }

    public final RuntimeException c() {
        int i10 = this.f8818a;
        if (i10 == 4) {
            return new NoSuchElementException();
        }
        if (i10 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f8818a);
    }

    @Override // qb.b
    public final kotlin.coroutines.d getContext() {
        return EmptyCoroutineContext.f10057a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i10 = this.f8818a;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2 || i10 == 3) {
                        return true;
                    }
                    if (i10 == 4) {
                        return false;
                    }
                    throw c();
                }
                Iterator<? extends T> it = this.f8820c;
                kotlin.jvm.internal.g.c(it);
                if (it.hasNext()) {
                    this.f8818a = 2;
                    return true;
                }
                this.f8820c = null;
            }
            this.f8818a = 5;
            qb.b<? super lb.n> bVar = this.f8821d;
            kotlin.jvm.internal.g.c(bVar);
            this.f8821d = null;
            bVar.resumeWith(lb.n.f10413a);
        }
    }

    @Override // java.util.Iterator
    public final T next() {
        int i10 = this.f8818a;
        if (i10 == 0 || i10 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i10 == 2) {
            this.f8818a = 1;
            Iterator<? extends T> it = this.f8820c;
            kotlin.jvm.internal.g.c(it);
            return it.next();
        }
        if (i10 != 3) {
            throw c();
        }
        this.f8818a = 0;
        T t8 = this.f8819b;
        this.f8819b = null;
        return t8;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // qb.b
    public final void resumeWith(Object obj) {
        kotlin.c.b(obj);
        this.f8818a = 4;
    }
}
