package ba;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class r implements Iterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f1624f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1625g = true;

    /* renamed from: h, reason: collision with root package name */
    public final Object f1626h;

    public /* synthetic */ r(int i2, Object obj) {
        this.f1624f = i2;
        this.f1626h = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f1624f) {
        }
        return this.f1625g;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f1624f) {
            case 0:
                if (!this.f1625g) {
                    throw new NoSuchElementException();
                }
                this.f1625g = false;
                return ((s) this.f1626h).f1627f;
            default:
                if (!this.f1625g) {
                    throw new NoSuchElementException();
                }
                this.f1625g = false;
                return this.f1626h;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f1624f) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException();
        }
    }
}
