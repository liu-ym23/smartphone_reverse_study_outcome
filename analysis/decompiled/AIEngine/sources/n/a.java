package n;

import java.util.HashMap;
import n.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a<K, V> extends b<K, V> {

    /* renamed from: e, reason: collision with root package name */
    public final HashMap<K, b.c<K, V>> f10572e = new HashMap<>();

    @Override // n.b
    public final b.c<K, V> a(K k9) {
        return this.f10572e.get(k9);
    }

    @Override // n.b
    public final V b(K k9) {
        V v3 = (V) super.b(k9);
        this.f10572e.remove(k9);
        return v3;
    }
}
