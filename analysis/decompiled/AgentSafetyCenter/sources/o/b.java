package o;

import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b extends e implements Iterator {

    /* renamed from: c, reason: collision with root package name */
    public c f8960c;

    /* renamed from: f, reason: collision with root package name */
    public c f8961f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f8962g;

    public b(c cVar, c cVar2, int i) {
        this.f8962g = i;
        this.f8960c = cVar2;
        this.f8961f = cVar;
    }

    @Override // o.e
    public final void a(c cVar) {
        c cVar2;
        c cVarB = null;
        if (this.f8960c == cVar && cVar == this.f8961f) {
            this.f8961f = null;
            this.f8960c = null;
        }
        c cVar3 = this.f8960c;
        if (cVar3 == cVar) {
            switch (this.f8962g) {
                case 0:
                    cVar2 = cVar3.f8966h;
                    break;
                default:
                    cVar2 = cVar3.f8965g;
                    break;
            }
            this.f8960c = cVar2;
        }
        c cVar4 = this.f8961f;
        if (cVar4 == cVar) {
            c cVar5 = this.f8960c;
            if (cVar4 != cVar5 && cVar5 != null) {
                cVarB = b(cVar4);
            }
            this.f8961f = cVarB;
        }
    }

    public final c b(c cVar) {
        switch (this.f8962g) {
            case 0:
                return cVar.f8965g;
            default:
                return cVar.f8966h;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f8961f != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        c cVar = this.f8961f;
        c cVar2 = this.f8960c;
        this.f8961f = (cVar == cVar2 || cVar2 == null) ? null : b(cVar);
        return cVar;
    }
}
