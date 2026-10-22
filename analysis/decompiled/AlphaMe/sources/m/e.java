package m;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class e extends f implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public c f13516a;

    /* renamed from: b, reason: collision with root package name */
    public c f13517b;

    @Override // m.f
    public final void a(c cVar) {
        c cVar2;
        c cVar3;
        c cVar4 = null;
        if (this.f13516a == cVar && cVar == this.f13517b) {
            this.f13517b = null;
            this.f13516a = null;
        }
        c cVar5 = this.f13516a;
        if (cVar5 == cVar) {
            switch (((b) this).f13508c) {
                case 0:
                    cVar3 = cVar5.f13512d;
                    break;
                default:
                    cVar3 = cVar5.f13511c;
                    break;
            }
            this.f13516a = cVar3;
        }
        c cVar6 = this.f13517b;
        if (cVar6 == cVar) {
            c cVar7 = this.f13516a;
            if (cVar6 != cVar7 && cVar7 != null) {
                switch (((b) this).f13508c) {
                    case 0:
                        cVar2 = cVar6.f13511c;
                        break;
                    default:
                        cVar2 = cVar6.f13512d;
                        break;
                }
                cVar4 = cVar2;
            }
            this.f13517b = cVar4;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13517b != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        c cVar;
        c cVar2 = this.f13517b;
        c cVar3 = this.f13516a;
        if (cVar2 != cVar3 && cVar3 != null) {
            switch (((b) this).f13508c) {
                case 0:
                    cVar = cVar2.f13511c;
                    break;
                default:
                    cVar = cVar2.f13512d;
                    break;
            }
        } else {
            cVar = null;
        }
        this.f13517b = cVar;
        return cVar2;
    }
}
