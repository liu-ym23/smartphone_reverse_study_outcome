package ec;

import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements Iterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3749c;

    /* renamed from: f, reason: collision with root package name */
    public int f3750f;

    /* renamed from: g, reason: collision with root package name */
    public int f3751g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3752h;
    public int i;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f3749c) {
        }
        return this.f3752h;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f3749c) {
            case 0:
                int i = this.i;
                if (i != this.f3751g) {
                    this.i = this.f3750f + i;
                } else {
                    if (!this.f3752h) {
                        g5.f.k();
                        return null;
                    }
                    this.f3752h = false;
                }
                return Character.valueOf((char) i);
            default:
                return Integer.valueOf(nextInt());
        }
    }

    public int nextInt() {
        int i = this.i;
        if (i != this.f3751g) {
            this.i = this.f3750f + i;
            return i;
        }
        if (this.f3752h) {
            this.f3752h = false;
            return i;
        }
        g5.f.k();
        return 0;
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f3749c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}
