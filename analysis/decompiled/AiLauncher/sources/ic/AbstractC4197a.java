package ic;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: ic.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC4197a<K, V, C extends Collection<V>> implements Map<K, C> {

    /* renamed from: a, reason: collision with root package name */
    public Map<K, C> f33137a;

    public AbstractC4197a(Map<K, C> map) {
        this.f33137a = map;
    }

    @Override // java.util.Map
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized C get(Object obj) {
        return this.f33137a.get(obj);
    }

    @Override // java.util.Map
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public synchronized C put(K k10, C c10) {
        return this.f33137a.put(k10, c10);
    }

    @Override // java.util.Map
    public synchronized void clear() {
        this.f33137a.clear();
    }

    @Override // java.util.Map
    public synchronized boolean containsKey(Object obj) {
        return this.f33137a.containsKey(obj);
    }

    @Override // java.util.Map
    public synchronized boolean containsValue(Object obj) {
        return this.f33137a.containsValue(obj);
    }

    @Override // java.util.Map
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public synchronized C remove(Object obj) {
        return this.f33137a.remove(obj);
    }

    @Override // java.util.Map
    public synchronized Set<Map.Entry<K, C>> entrySet() {
        return this.f33137a.entrySet();
    }

    @Override // java.util.Map
    public synchronized boolean equals(Object obj) {
        return this.f33137a.equals(obj);
    }

    @Override // java.util.Map
    public synchronized int hashCode() {
        return this.f33137a.hashCode();
    }

    @Override // java.util.Map
    public synchronized boolean isEmpty() {
        return this.f33137a.isEmpty();
    }

    @Override // java.util.Map
    public synchronized Set<K> keySet() {
        return this.f33137a.keySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends C> map) {
        this.f33137a.putAll(map);
    }

    @Override // java.util.Map
    public synchronized int size() {
        return this.f33137a.size();
    }

    @Override // java.util.Map
    public synchronized Collection<C> values() {
        return this.f33137a.values();
    }
}
