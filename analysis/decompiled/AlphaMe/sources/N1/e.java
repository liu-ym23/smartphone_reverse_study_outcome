package N1;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class e implements Iterator, f {

    /* renamed from: a, reason: collision with root package name */
    public d f1473a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1474b = true;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g f1475c;

    public e(g gVar) {
        this.f1475c = gVar;
    }

    @Override // N1.f
    public final void a(d dVar) {
        d dVar2 = this.f1473a;
        if (dVar == dVar2) {
            d dVar3 = dVar2.f1472d;
            this.f1473a = dVar3;
            this.f1474b = dVar3 == null;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f1474b) {
            return this.f1475c.f1476a != null;
        }
        d dVar = this.f1473a;
        return (dVar == null || dVar.f1471c == null) ? false : true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f1474b) {
            this.f1474b = false;
            this.f1473a = this.f1475c.f1476a;
        } else {
            d dVar = this.f1473a;
            this.f1473a = dVar != null ? dVar.f1471c : null;
        }
        return this.f1473a;
    }
}
