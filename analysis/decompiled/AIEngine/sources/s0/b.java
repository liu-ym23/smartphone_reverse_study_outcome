package s0;

import n0.e;
import s0.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final e.a f11829a;

    /* renamed from: b, reason: collision with root package name */
    public final n f11830b;

    public b(e.a aVar, n nVar) {
        this.f11829a = aVar;
        this.f11830b = nVar;
    }

    public final void a(j.a aVar) {
        int i10 = aVar.f11858b;
        n nVar = this.f11830b;
        e.a aVar2 = this.f11829a;
        if (i10 == 0) {
            nVar.execute(new j2.a(aVar2, aVar.f11857a));
        } else {
            nVar.execute(new a(aVar2, i10));
        }
    }
}
