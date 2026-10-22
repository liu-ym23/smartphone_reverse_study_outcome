package u;

import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class v<K, V> extends s<K, V, Map.Entry<K, V>> {

    /* renamed from: d, reason: collision with root package name */
    public final i<K, V> f13137d;

    public v(i<K, V> iVar) {
        this.f13137d = iVar;
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i10 = this.f13135c;
        this.f13135c = i10 + 2;
        Object[] objArr = this.f13133a;
        return new c(this.f13137d, objArr[i10], objArr[i10 + 1]);
    }
}
