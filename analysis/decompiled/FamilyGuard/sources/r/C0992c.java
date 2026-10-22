package r;

import j4.k;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: r.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0992c<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final LinkedHashMap<K, V> f19954a;

    public C0992c(int i5, float f5) {
        this.f19954a = new LinkedHashMap<>(i5, f5, true);
    }

    public final V a(K k5) {
        k.g(k5, "key");
        return this.f19954a.get(k5);
    }

    public final Set<Map.Entry<K, V>> b() {
        Set<Map.Entry<K, V>> setEntrySet = this.f19954a.entrySet();
        k.f(setEntrySet, "map.entries");
        return setEntrySet;
    }

    public final boolean c() {
        return this.f19954a.isEmpty();
    }

    public final V d(K k5, V v5) {
        k.g(k5, "key");
        k.g(v5, "value");
        return this.f19954a.put(k5, v5);
    }

    public final V e(K k5) {
        k.g(k5, "key");
        return this.f19954a.remove(k5);
    }
}
