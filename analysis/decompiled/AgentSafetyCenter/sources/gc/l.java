package gc;

import java.util.Iterator;
import java.util.NoSuchElementException;
import jb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l implements Iterator, nb.c, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public int f4700c;

    /* renamed from: f, reason: collision with root package name */
    public Object f4701f;

    /* renamed from: g, reason: collision with root package name */
    public Iterator f4702g;

    /* renamed from: h, reason: collision with root package name */
    public nb.c f4703h;

    public final RuntimeException a() {
        int i = this.f4700c;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f4700c);
    }

    public final void b(Object obj, nb.c cVar) {
        this.f4701f = obj;
        this.f4700c = 3;
        this.f4703h = cVar;
        ob.a aVar = ob.a.f9351c;
        cVar.getClass();
    }

    @Override // nb.c
    public final nb.g getContext() {
        return nb.h.f8811c;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i = this.f4700c;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw a();
                }
                Iterator it = this.f4702g;
                it.getClass();
                if (it.hasNext()) {
                    this.f4700c = 2;
                    return true;
                }
                this.f4702g = null;
            }
            this.f4700c = 5;
            nb.c cVar = this.f4703h;
            cVar.getClass();
            this.f4703h = null;
            cVar.resumeWith(v.f6774a);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f4700c;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            g5.f.k();
            return null;
        }
        if (i == 2) {
            this.f4700c = 1;
            Iterator it = this.f4702g;
            it.getClass();
            return it.next();
        }
        if (i != 3) {
            throw a();
        }
        this.f4700c = 0;
        Object obj = this.f4701f;
        this.f4701f = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // nb.c
    public final void resumeWith(Object obj) {
        id.c.I(obj);
        this.f4700c = 4;
    }
}
