package gc;

import java.util.Iterator;
import kb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements Iterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4680c;

    /* renamed from: f, reason: collision with root package name */
    public Iterator f4681f;

    /* renamed from: g, reason: collision with root package name */
    public int f4682g;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f4680c) {
            case 0:
                Iterator it = this.f4681f;
                while (this.f4682g > 0 && it.hasNext()) {
                    it.next();
                    this.f4682g--;
                }
                return it.hasNext();
            default:
                return this.f4681f.hasNext();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f4680c) {
            case 0:
                Iterator it = this.f4681f;
                while (this.f4682g > 0 && it.hasNext()) {
                    it.next();
                    this.f4682g--;
                }
                return it.next();
            default:
                int i = this.f4682g;
                this.f4682g = i + 1;
                if (i >= 0) {
                    return new v(i, this.f4681f.next());
                }
                ac.a.a0();
                throw null;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f4680c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}
