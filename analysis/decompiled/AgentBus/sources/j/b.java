package j;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class b extends e implements Iterator {

    /* renamed from: f, reason: collision with root package name */
    public c f5052f;

    /* renamed from: g, reason: collision with root package name */
    public c f5053g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f5054h;

    public b(c cVar, c cVar2, int i2) {
        this.f5054h = i2;
        this.f5052f = cVar2;
        this.f5053g = cVar;
    }

    @Override // j.e
    public final void a(c cVar) {
        c cVar2;
        c cVarB = null;
        if (this.f5052f == cVar && cVar == this.f5053g) {
            this.f5053g = null;
            this.f5052f = null;
        }
        c cVar3 = this.f5052f;
        if (cVar3 == cVar) {
            switch (this.f5054h) {
                case 0:
                    cVar2 = cVar3.f5058i;
                    break;
                default:
                    cVar2 = cVar3.f5057h;
                    break;
            }
            this.f5052f = cVar2;
        }
        c cVar4 = this.f5053g;
        if (cVar4 == cVar) {
            c cVar5 = this.f5052f;
            if (cVar4 != cVar5 && cVar5 != null) {
                cVarB = b(cVar4);
            }
            this.f5053g = cVarB;
        }
    }

    public final c b(c cVar) {
        switch (this.f5054h) {
            case 0:
                return cVar.f5057h;
            default:
                return cVar.f5058i;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5053g != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        c cVar = this.f5053g;
        c cVar2 = this.f5052f;
        this.f5053g = (cVar == cVar2 || cVar2 == null) ? null : b(cVar);
        return cVar;
    }
}
