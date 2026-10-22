package kb;

import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a implements Iterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public int f7379c;

    /* renamed from: f, reason: collision with root package name */
    public Object f7380f;

    public abstract void a();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.f7379c;
        if (i == 0) {
            this.f7379c = 3;
            a();
            return this.f7379c == 1;
        }
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return false;
        }
        g5.f.s("hasNext called when the iterator is in the FAILED state.");
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.f7379c;
        if (i == 1) {
            this.f7379c = 0;
            return this.f7380f;
        }
        if (i != 2) {
            this.f7379c = 3;
            a();
            if (this.f7379c == 1) {
                this.f7379c = 0;
                return this.f7380f;
            }
        }
        g5.f.k();
        return null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
