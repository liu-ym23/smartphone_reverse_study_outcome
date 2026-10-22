package xd;

import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l extends n<Iterable<Object>> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f13816a;

    public l(n nVar) {
        this.f13816a = nVar;
    }

    @Override // xd.n
    public final void a(p pVar, Iterable<Object> iterable) {
        Iterable<Object> iterable2 = iterable;
        if (iterable2 == null) {
            return;
        }
        Iterator<Object> it = iterable2.iterator();
        while (it.hasNext()) {
            this.f13816a.a(pVar, it.next());
        }
    }
}
