package r4;

import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f implements Iterator, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5095a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Iterator f5096b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f5097c;

    public f(g gVar) {
        this.f5097c = gVar;
        this.f5096b = gVar.f5098a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f5095a) {
        }
        return this.f5096b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f5095a) {
            case 0:
                return ((g) this.f5097c).f5099b.invoke(this.f5096b.next());
            default:
                return ((w5.g) this.f5097c).f6214c.invoke(this.f5096b.next());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f5095a) {
            case 0:
                this.f5096b.remove();
                return;
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public f(w5.g gVar) {
        this.f5097c = gVar;
        this.f5096b = gVar.f6213b.iterator();
    }
}
