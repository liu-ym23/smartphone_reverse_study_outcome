package i9;

import C7.r;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

/* loaded from: classes4.dex */
public final class j extends k implements Iterator, H7.c, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public int f4623a;
    public Object b;
    public Iterator c;
    public H7.c d;

    @Override // i9.k
    public final void a(H7.c frame, Object obj) {
        this.b = obj;
        this.f4623a = 3;
        this.d = frame;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        kotlin.jvm.internal.k.f(frame, "frame");
    }

    public final RuntimeException b() {
        int i = this.f4623a;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f4623a);
    }

    @Override // H7.c
    public final H7.h getContext() {
        return EmptyCoroutineContext.f4908a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i = this.f4623a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw b();
                }
                Iterator it = this.c;
                kotlin.jvm.internal.k.c(it);
                if (it.hasNext()) {
                    this.f4623a = 2;
                    return true;
                }
                this.c = null;
            }
            this.f4623a = 5;
            H7.c cVar = this.d;
            kotlin.jvm.internal.k.c(cVar);
            this.d = null;
            cVar.resumeWith(r.f317a);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f4623a;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i == 2) {
            this.f4623a = 1;
            Iterator it = this.c;
            kotlin.jvm.internal.k.c(it);
            return it.next();
        }
        if (i != 3) {
            throw b();
        }
        this.f4623a = 0;
        Object obj = this.b;
        this.b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // H7.c
    public final void resumeWith(Object obj) {
        kotlin.b.b(obj);
        this.f4623a = 4;
    }
}
