package w5;

import b5.a0;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j implements Iterator, f5.c, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public int f6218a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6219b;

    /* renamed from: c, reason: collision with root package name */
    public f5.c f6220c;

    public final RuntimeException b() {
        int i8 = this.f6218a;
        if (i8 == 4) {
            return new NoSuchElementException();
        }
        if (i8 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f6218a);
    }

    @Override // f5.c
    public final f5.h getContext() {
        return f5.i.f2626a;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i8;
        while (true) {
            i8 = this.f6218a;
            if (i8 != 0) {
                break;
            }
            this.f6218a = 5;
            f5.c cVar = this.f6220c;
            p.b(cVar);
            this.f6220c = null;
            cVar.resumeWith(a0.f883a);
        }
        if (i8 == 1) {
            p.b(null);
            throw null;
        }
        if (i8 == 2 || i8 == 3) {
            return true;
        }
        if (i8 == 4) {
            return false;
        }
        throw b();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i8 = this.f6218a;
        if (i8 == 0 || i8 == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i8 == 2) {
            this.f6218a = 1;
            p.b(null);
            throw null;
        }
        if (i8 != 3) {
            throw b();
        }
        this.f6218a = 0;
        Object obj = this.f6219b;
        this.f6219b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // f5.c
    public final void resumeWith(Object obj) {
        a.a.c0(obj);
        this.f6218a = 4;
    }
}
