package u;

import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c<K, V> extends b<K, V> {

    /* renamed from: c, reason: collision with root package name */
    public final i<K, V> f13103c;

    /* renamed from: d, reason: collision with root package name */
    public V f13104d;

    public c(i<K, V> iVar, K k9, V v3) {
        super(k9, v3);
        this.f13103c = iVar;
        this.f13104d = v3;
    }

    @Override // u.b, java.util.Map.Entry
    public final V getValue() {
        return this.f13104d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u.b, java.util.Map.Entry
    public final V setValue(V v3) {
        V v7 = this.f13104d;
        this.f13104d = v3;
        g<K, V, Map.Entry<K, V>> gVar = this.f13103c.f13120a;
        f<K, V> fVar = gVar.f13116d;
        K k9 = this.f13101a;
        if (!fVar.containsKey(k9)) {
            return v7;
        }
        boolean z = gVar.f13110c;
        if (!z) {
            fVar.put(k9, v3);
        } else {
            if (!z) {
                throw new NoSuchElementException();
            }
            s sVar = gVar.f13108a[gVar.f13109b];
            Object obj = sVar.f13133a[sVar.f13135c];
            fVar.put(k9, v3);
            gVar.c(obj != null ? obj.hashCode() : 0, fVar.f13113c, obj, 0);
        }
        gVar.f13118j = fVar.f13115e;
        return v7;
    }
}
