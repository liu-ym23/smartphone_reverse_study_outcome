package u;

import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m<K, V> extends mb.i<Map.Entry<? extends K, ? extends V>> {

    /* renamed from: a, reason: collision with root package name */
    public final d<K, V> f13123a;

    public m(d<K, V> dVar) {
        this.f13123a = dVar;
    }

    @Override // mb.a
    public final int a() {
        d<K, V> dVar = this.f13123a;
        dVar.getClass();
        return dVar.f13107b;
    }

    @Override // mb.a, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        d<K, V> dVar = this.f13123a;
        V v3 = dVar.get(key);
        return v3 != null ? v3.equals(entry.getValue()) : entry.getValue() == null && dVar.containsKey(entry.getKey());
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        r<K, V> rVar = this.f13123a.f13106a;
        s[] sVarArr = new s[8];
        for (int i10 = 0; i10 < 8; i10++) {
            sVarArr[i10] = new t();
        }
        return new n(rVar, sVarArr);
    }
}
