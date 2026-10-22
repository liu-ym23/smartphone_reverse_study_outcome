package u;

import u.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class d<K, V> extends mb.d<K, V> {

    /* renamed from: c, reason: collision with root package name */
    public static final d f13105c = new d(r.f13126e, 0);

    /* renamed from: a, reason: collision with root package name */
    public final r<K, V> f13106a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13107b;

    public d(r<K, V> rVar, int i10) {
        this.f13106a = rVar;
        this.f13107b = i10;
    }

    public final d a(Object obj, v.a aVar) {
        r.a aVarU = this.f13106a.u(obj != null ? obj.hashCode() : 0, 0, obj, aVar);
        return aVarU == null ? this : new d(aVarU.f13131a, this.f13107b + aVarU.f13132b);
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f13106a.d(obj != null ? obj.hashCode() : 0, 0, obj);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return (V) this.f13106a.g(obj != null ? obj.hashCode() : 0, 0, obj);
    }
}
