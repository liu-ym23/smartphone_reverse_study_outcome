package i;

import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends e implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public c f3077a;

    /* renamed from: b, reason: collision with root package name */
    public c f3078b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3079c;

    public b(c cVar, c cVar2, int i8) {
        this.f3079c = i8;
        this.f3077a = cVar2;
        this.f3078b = cVar;
    }

    @Override // i.e
    public final void a(c cVar) {
        c cVar2;
        c cVarB = null;
        if (this.f3077a == cVar && cVar == this.f3078b) {
            this.f3078b = null;
            this.f3077a = null;
        }
        c cVar3 = this.f3077a;
        if (cVar3 == cVar) {
            switch (this.f3079c) {
                case 0:
                    cVar2 = cVar3.d;
                    break;
                default:
                    cVar2 = cVar3.f3082c;
                    break;
            }
            this.f3077a = cVar2;
        }
        c cVar4 = this.f3078b;
        if (cVar4 == cVar) {
            c cVar5 = this.f3077a;
            if (cVar4 != cVar5 && cVar5 != null) {
                cVarB = b(cVar4);
            }
            this.f3078b = cVarB;
        }
    }

    public final c b(c cVar) {
        switch (this.f3079c) {
            case 0:
                return cVar.f3082c;
            default:
                return cVar.d;
        }
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f3078b != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        c cVar = this.f3078b;
        c cVar2 = this.f3077a;
        this.f3078b = (cVar == cVar2 || cVar2 == null) ? null : b(cVar);
        return cVar;
    }
}
