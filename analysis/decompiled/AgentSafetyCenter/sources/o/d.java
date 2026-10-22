package o;

import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d extends e implements Iterator {

    /* renamed from: c, reason: collision with root package name */
    public c f8967c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f8968f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ f f8969g;

    @Override // o.e
    public final void a(c cVar) {
        c cVar2 = this.f8967c;
        if (cVar == cVar2) {
            c cVar3 = cVar2.f8966h;
            this.f8967c = cVar3;
            this.f8968f = cVar3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f8968f) {
            return this.f8969g.f8970c != null;
        }
        c cVar = this.f8967c;
        return (cVar == null || cVar.f8965g == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f8968f) {
            this.f8968f = false;
            this.f8967c = this.f8969g.f8970c;
        } else {
            c cVar = this.f8967c;
            this.f8967c = cVar != null ? cVar.f8965g : null;
        }
        return this.f8967c;
    }
}
