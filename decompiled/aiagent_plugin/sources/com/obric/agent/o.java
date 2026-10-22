package com.obric.agent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: LRUCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o<K, V> extends LinkedHashMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f15239b;

    public /* synthetic */ o(int r1, boolean r2, int r3, d.h.b.h r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        this(r1, r2);
    }

    public Collection<Object> b() {
        return super.values();
    }

    public int c() {
        return super.size();
    }

    public Set<Map.Entry<Object, Object>> d() {
        return super.entrySet();
    }

    public Set<Object> e() {
        return super.keySet();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return (Set<Map.Entry<K, V>>) d();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<K> keySet() {
        return (Set<K>) e();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final int size() {
        return c();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Collection<V> values() {
        return (Collection<V>) b();
    }

    public o(int r2, boolean r3) {
        super(r2, 0.75f, r3);
        this.f15238a = r2;
        this.f15239b = r3;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> r3) {
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r3, Map.Entry.class, "com.obric.aiagent.plugin");
        if (size() <= this.f15238a) goto L5;
        return true;
    L5:
        return false;
    }

    public final K a() {
        if (size() >= this.f15238a) goto L5;
        return null;
    L5:
        Set<Map.Entry<K, V>> r3 = entrySet();
        d.h.b.o.c(r3, "<get-entries>(...)");
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(d.a.p.f((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")), Map.Entry.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L8;
        return null;
    L8:
        return (K) r4.getKey();
    }
}
