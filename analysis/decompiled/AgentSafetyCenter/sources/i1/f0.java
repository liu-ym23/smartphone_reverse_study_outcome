package i1;

import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f0 implements Iterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5668c;

    /* renamed from: f, reason: collision with root package name */
    public Iterator f5669f;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f5668c) {
            case 0:
                return this.f5669f.hasNext();
            default:
                return ((p0.d) this.f5669f).f9662g;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f5668c) {
            case 0:
                return (i0) this.f5669f.next();
            default:
                return (Map.Entry) ((p0.d) this.f5669f).next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f5668c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                ((p0.d) this.f5669f).remove();
                return;
        }
    }
}
