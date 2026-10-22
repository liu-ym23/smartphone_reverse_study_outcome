package mb;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class g<K, V> extends AbstractMap<K, V> implements Map<K, V>, ac.d {
    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return new u.h((u.f) this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        return new u.j((u.f) this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return ((u.f) this).h;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        return new u.l((u.f) this);
    }
}
