package i;

import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends e implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public c f3083a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3084b = true;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f3085c;

    public d(f fVar) {
        this.f3085c = fVar;
    }

    @Override // i.e
    public final void a(c cVar) {
        c cVar2 = this.f3083a;
        if (cVar == cVar2) {
            c cVar3 = cVar2.d;
            this.f3083a = cVar3;
            this.f3084b = cVar3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f3084b) {
            return this.f3085c.f3086a != null;
        }
        c cVar = this.f3083a;
        return (cVar == null || cVar.f3082c == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f3084b) {
            this.f3084b = false;
            this.f3083a = this.f3085c.f3086a;
        } else {
            c cVar = this.f3083a;
            this.f3083a = cVar != null ? cVar.f3082c : null;
        }
        return this.f3083a;
    }
}
