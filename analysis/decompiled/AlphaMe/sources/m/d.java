package m;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class d extends f implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public c f13513a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13514b = true;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f13515c;

    public d(g gVar) {
        this.f13515c = gVar;
    }

    @Override // m.f
    public final void a(c cVar) {
        c cVar2 = this.f13513a;
        if (cVar == cVar2) {
            c cVar3 = cVar2.f13512d;
            this.f13513a = cVar3;
            this.f13514b = cVar3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f13514b) {
            return this.f13515c.f13518a != null;
        }
        c cVar = this.f13513a;
        return (cVar == null || cVar.f13511c == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f13514b) {
            this.f13514b = false;
            this.f13513a = this.f13515c.f13518a;
        } else {
            c cVar = this.f13513a;
            this.f13513a = cVar != null ? cVar.f13511c : null;
        }
        return this.f13513a;
    }
}
