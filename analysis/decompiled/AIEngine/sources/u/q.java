package u;

import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class q<K, V> extends mb.a<V> {

    /* renamed from: a, reason: collision with root package name */
    public final d<K, V> f13125a;

    public q(d<K, V> dVar) {
        this.f13125a = dVar;
    }

    @Override // mb.a
    public final int a() {
        d<K, V> dVar = this.f13125a;
        dVar.getClass();
        return dVar.f13107b;
    }

    @Override // mb.a, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.f13125a.containsValue(obj);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<V> iterator() {
        r<K, V> rVar = this.f13125a.f13106a;
        s[] sVarArr = new s[8];
        for (int i10 = 0; i10 < 8; i10++) {
            sVarArr[i10] = new u(1);
        }
        return new p(rVar, sVarArr);
    }
}
