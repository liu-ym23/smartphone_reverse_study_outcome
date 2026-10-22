package j;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class d extends e implements Iterator {

    /* renamed from: f, reason: collision with root package name */
    public c f5059f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5060g = true;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ f f5061h;

    public d(f fVar) {
        this.f5061h = fVar;
    }

    @Override // j.e
    public final void a(c cVar) {
        c cVar2 = this.f5059f;
        if (cVar == cVar2) {
            c cVar3 = cVar2.f5058i;
            this.f5059f = cVar3;
            this.f5060g = cVar3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f5060g) {
            return this.f5061h.f5062f != null;
        }
        c cVar = this.f5059f;
        return (cVar == null || cVar.f5057h == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f5060g) {
            this.f5060g = false;
            this.f5059f = this.f5061h.f5062f;
        } else {
            c cVar = this.f5059f;
            this.f5059f = cVar != null ? cVar.f5057h : null;
        }
        return this.f5059f;
    }
}
