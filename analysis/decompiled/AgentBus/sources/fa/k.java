package fa;

import c7.r;
import java.util.Iterator;
import java.util.NoSuchElementException;
import w7.e0;

/* loaded from: classes.dex */
public final class k implements Iterator, g7.d, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public int f3636f;

    /* renamed from: g, reason: collision with root package name */
    public Object f3637g;

    /* renamed from: h, reason: collision with root package name */
    public g7.d f3638h;

    public final RuntimeException c() {
        int i2 = this.f3636f;
        if (i2 == 4) {
            return new NoSuchElementException();
        }
        if (i2 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f3636f);
    }

    public final void d(Object obj, i7.h hVar) {
        this.f3637g = obj;
        this.f3636f = 3;
        this.f3638h = hVar;
        h7.a aVar = h7.a.f4212f;
    }

    @Override // g7.d
    public final g7.l getContext() {
        return g7.m.f3866f;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i2;
        while (true) {
            i2 = this.f3636f;
            if (i2 != 0) {
                break;
            }
            this.f3636f = 5;
            g7.d dVar = this.f3638h;
            q7.k.b(dVar);
            this.f3638h = null;
            dVar.resumeWith(r.f1986a);
        }
        if (i2 == 1) {
            q7.k.b(null);
            throw null;
        }
        if (i2 == 2 || i2 == 3) {
            return true;
        }
        if (i2 == 4) {
            return false;
        }
        throw c();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i2 = this.f3636f;
        if (i2 == 0 || i2 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i2 == 2) {
            this.f3636f = 1;
            q7.k.b(null);
            throw null;
        }
        if (i2 != 3) {
            throw c();
        }
        this.f3636f = 0;
        Object obj = this.f3637g;
        this.f3637g = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // g7.d
    public final void resumeWith(Object obj) {
        e0.N(obj);
        this.f3636f = 4;
    }
}
