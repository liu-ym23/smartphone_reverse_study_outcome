package N1;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class c implements Iterator, f {

    /* renamed from: a, reason: collision with root package name */
    public d f1467a;

    /* renamed from: b, reason: collision with root package name */
    public d f1468b;

    @Override // N1.f
    public final void a(d dVar) {
        d dVar2 = null;
        if (this.f1467a == dVar && dVar == this.f1468b) {
            this.f1468b = null;
            this.f1467a = null;
        }
        d dVar3 = this.f1467a;
        if (dVar3 == dVar) {
            this.f1467a = dVar3.f1472d;
        }
        d dVar4 = this.f1468b;
        if (dVar4 == dVar) {
            d dVar5 = this.f1467a;
            if (dVar4 != dVar5 && dVar5 != null) {
                dVar2 = dVar4.f1471c;
            }
            this.f1468b = dVar2;
        }
    }

    @Override // java.util.Iterator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final boolean hasNext() {
        return this.f1468b != null;
    }

    @Override // java.util.Iterator
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final Object next() {
        d dVar = this.f1468b;
        d dVar2 = this.f1467a;
        this.f1468b = (dVar == dVar2 || dVar2 == null) ? null : dVar.f1471c;
        return dVar;
    }
}
