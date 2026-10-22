package r4;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import k4.v;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b implements Map, q5.e {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f5091a = new LinkedHashMap();

    @Override // java.util.Map
    public final void clear() {
        this.f5091a.clear();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return this.f5091a.containsKey(new c((String) obj));
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.f5091a.containsValue(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        return new g(this.f5091a.entrySet(), new o3.a(12), new o3.a(13));
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        return p.a(((b) obj).f5091a, this.f5091a);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        if (obj instanceof String) {
            return this.f5091a.get(v.k((String) obj));
        }
        return null;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f5091a.hashCode();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f5091a.isEmpty();
    }

    @Override // java.util.Map
    public final Set keySet() {
        return new g(this.f5091a.keySet(), new o3.a(14), new o3.a(15));
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object value) {
        String key = (String) obj;
        p.e(key, "key");
        p.e(value, "value");
        return this.f5091a.put(v.k(key), value);
    }

    @Override // java.util.Map
    public final void putAll(Map from) {
        p.e(from, "from");
        for (Map.Entry entry : from.entrySet()) {
            String key = (String) entry.getKey();
            Object value = entry.getValue();
            p.e(key, "key");
            p.e(value, "value");
            this.f5091a.put(v.k(key), value);
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        if (obj instanceof String) {
            return this.f5091a.remove(v.k((String) obj));
        }
        return null;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f5091a.size();
    }

    @Override // java.util.Map
    public final Collection values() {
        return this.f5091a.values();
    }
}
