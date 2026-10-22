package i9;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: i9.e, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1570e implements Iterator, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4619a;
    public final Iterator b;
    public int c;
    public Object d;
    public final /* synthetic */ i e;

    public C1570e(f fVar) {
        this.f4619a = 0;
        this.e = fVar;
        this.b = fVar.f4620a.iterator();
        this.c = -1;
    }

    public void a() {
        Object next;
        f fVar = (f) this.e;
        do {
            Iterator it = this.b;
            if (!it.hasNext()) {
                this.c = 0;
                return;
            }
            next = it.next();
        } while (((Boolean) fVar.c.invoke(next)).booleanValue() != fVar.b);
        this.d = next;
        this.c = 1;
    }

    public boolean b() {
        Iterator it;
        Iterator it2 = (Iterator) this.d;
        if (it2 != null && it2.hasNext()) {
            this.c = 1;
            return true;
        }
        do {
            Iterator it3 = this.b;
            if (!it3.hasNext()) {
                this.c = 2;
                this.d = null;
                return false;
            }
            Object next = it3.next();
            g gVar = (g) this.e;
            it = (Iterator) gVar.c.invoke(gVar.b.invoke(next));
        } while (!it.hasNext());
        this.d = it;
        this.c = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f4619a) {
            case 0:
                if (this.c == -1) {
                    a();
                }
                return this.c == 1;
            default:
                int i = this.c;
                if (i == 1) {
                    return true;
                }
                if (i == 2) {
                    return false;
                }
                return b();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f4619a) {
            case 0:
                if (this.c == -1) {
                    a();
                }
                if (this.c == 0) {
                    throw new NoSuchElementException();
                }
                Object obj = this.d;
                this.d = null;
                this.c = -1;
                return obj;
            default:
                int i = this.c;
                if (i == 2) {
                    throw new NoSuchElementException();
                }
                if (i == 0 && !b()) {
                    throw new NoSuchElementException();
                }
                this.c = 0;
                Iterator it = (Iterator) this.d;
                kotlin.jvm.internal.k.c(it);
                return it.next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f4619a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C1570e(g gVar) {
        this.f4619a = 1;
        this.e = gVar;
        this.b = gVar.f4621a.iterator();
    }
}
