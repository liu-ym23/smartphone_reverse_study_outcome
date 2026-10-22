package gc;

import java.util.ArrayList;
import java.util.Iterator;
import n3.l0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r implements Iterator, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4709c;

    /* renamed from: f, reason: collision with root package name */
    public Iterator f4710f;

    /* renamed from: g, reason: collision with root package name */
    public Object f4711g;

    public /* synthetic */ r(int i) {
        this.f4709c = i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f4709c) {
        }
        return this.f4710f.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f4709c) {
            case 0:
                return ((xb.l) ((i) this.f4711g).f4695c).invoke(this.f4710f.next());
            default:
                Object next = this.f4710f.next();
                ArrayList arrayList = (ArrayList) this.f4711g;
                Iterator it = (Iterator) l0.f8729c.invoke(next);
                if (it == null || !it.hasNext()) {
                    while (!this.f4710f.hasNext() && !arrayList.isEmpty()) {
                        this.f4710f = (Iterator) kb.l.C0(arrayList);
                        kb.q.q0(arrayList);
                    }
                } else {
                    arrayList.add(this.f4710f);
                    this.f4710f = it;
                }
                return next;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f4709c) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
}
