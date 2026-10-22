package u;

import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i<K, V> implements Iterator<Map.Entry<K, V>>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final g<K, V, Map.Entry<K, V>> f13120a;

    public i(f<K, V> fVar) {
        s[] sVarArr = new s[8];
        for (int i10 = 0; i10 < 8; i10++) {
            sVarArr[i10] = new v(this);
        }
        this.f13120a = new g<>(fVar, sVarArr);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13120a.f13110c;
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.f13120a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f13120a.remove();
    }
}
