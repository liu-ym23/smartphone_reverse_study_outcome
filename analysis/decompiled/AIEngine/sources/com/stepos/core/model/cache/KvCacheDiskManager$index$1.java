package com.stepos.core.model.cache;

import com.stepos.core.model.cache.KvCacheDiskManager;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class KvCacheDiskManager$index$1 extends LinkedHashMap<String, KvCacheDiskManager.KvCacheEntry> {
    public KvCacheDiskManager$index$1() {
        super(16, 0.75f, true);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    public /* bridge */ boolean containsValue(KvCacheDiskManager.KvCacheEntry kvCacheEntry) {
        return super.containsValue((Object) kvCacheEntry);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, KvCacheDiskManager.KvCacheEntry>> entrySet() {
        return getEntries();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ KvCacheDiskManager.KvCacheEntry get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public /* bridge */ Set<Map.Entry<String, KvCacheDiskManager.KvCacheEntry>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public final /* bridge */ KvCacheDiskManager.KvCacheEntry getOrDefault(Object obj, KvCacheDiskManager.KvCacheEntry kvCacheEntry) {
        return !(obj instanceof String) ? kvCacheEntry : getOrDefault((String) obj, kvCacheEntry);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<KvCacheDiskManager.KvCacheEntry> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ KvCacheDiskManager.KvCacheEntry remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<KvCacheDiskManager.KvCacheEntry> values() {
        return getValues();
    }

    public /* bridge */ boolean containsKey(String str) {
        return super.containsKey((Object) str);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof KvCacheDiskManager.KvCacheEntry) {
            return containsValue((KvCacheDiskManager.KvCacheEntry) obj);
        }
        return false;
    }

    public /* bridge */ KvCacheDiskManager.KvCacheEntry get(String str) {
        return (KvCacheDiskManager.KvCacheEntry) super.get((Object) str);
    }

    public /* bridge */ KvCacheDiskManager.KvCacheEntry getOrDefault(String str, KvCacheDiskManager.KvCacheEntry kvCacheEntry) {
        return (KvCacheDiskManager.KvCacheEntry) super.getOrDefault((Object) str, (String) kvCacheEntry);
    }

    public /* bridge */ KvCacheDiskManager.KvCacheEntry remove(String str) {
        return (KvCacheDiskManager.KvCacheEntry) super.remove((Object) str);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (KvCacheDiskManager.KvCacheEntry) obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof KvCacheDiskManager.KvCacheEntry)) {
            return remove((String) obj, (KvCacheDiskManager.KvCacheEntry) obj2);
        }
        return false;
    }

    public /* bridge */ boolean remove(String str, KvCacheDiskManager.KvCacheEntry kvCacheEntry) {
        return super.remove((Object) str, (Object) kvCacheEntry);
    }
}
