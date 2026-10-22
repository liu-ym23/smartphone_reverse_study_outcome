package g9;

import d9.C1396q;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class h implements Iterator, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4506a;
    public boolean b = true;
    public final Object c;

    public /* synthetic */ h(Object obj, int i) {
        this.f4506a = i;
        this.c = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f4506a) {
        }
        return this.b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f4506a) {
            case 0:
                if (!this.b) {
                    throw new NoSuchElementException();
                }
                this.b = false;
                return this.c;
            case 1:
                if (!this.b) {
                    throw new NoSuchElementException();
                }
                this.b = false;
                return this.c;
            default:
                if (!this.b) {
                    throw new NoSuchElementException();
                }
                this.b = false;
                return ((C1396q) this.c).f4315a;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f4506a) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}
