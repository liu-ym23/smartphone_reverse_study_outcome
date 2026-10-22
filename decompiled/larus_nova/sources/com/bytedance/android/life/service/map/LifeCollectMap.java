package com.bytedance.android.life.service.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u001e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003j\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002`\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0007\u001a\u00028\u00002\u0006\u0010\b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/life/service/map/LifeCollectMap;", "K", "V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "()V", "put", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "service_annotation"}, k = 1, mv = {1, 4, 1})
public final class LifeCollectMap<K, V> extends HashMap<K, V> {
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Set getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection getValues() {
        return super.values();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public LifeCollectMap() {
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K r100, V r101) {
        V r102 = get(r100);
        if (r102 == null) goto L11;
        if ((r101 instanceof List) == false) goto L8;
        LinkedList r103 = new LinkedList((Collection) r101);
        r103.add(r102);
        return (V) super.put(r100, r103);
    L8:
        LinkedList r104 = new LinkedList(CollectionsKt.listOf(r102));
        r104.add(r101);
        return (V) super.put(r100, r104);
    L11:
        return (V) super.put(r100, r101);
    }
}
