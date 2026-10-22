package com.stepos.agentframework.chatui.view;

import com.stepos.agentframework.chatui.view.CotHeaderDurationStore;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J%\u0010\b\u001a\u00020\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/agentframework/chatui/view/CotHeaderDurationStore$entries$1", "Ljava/util/LinkedHashMap;", "Lcom/stepos/agentframework/chatui/view/CotHeaderDurationStore$b;", "Lcom/stepos/agentframework/chatui/view/CotHeaderDurationStore$a;", "Lkotlin/collections/LinkedHashMap;", "", "eldest", "", "removeEldestEntry", "(Ljava/util/Map$Entry;)Z", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CotHeaderDurationStore$entries$1 extends LinkedHashMap<CotHeaderDurationStore.Key, CotHeaderDurationStore.a> {
    final /* synthetic */ CotHeaderDurationStore this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CotHeaderDurationStore$entries$1(CotHeaderDurationStore cotHeaderDurationStore) {
        super(16, 0.75f, true);
        this.this$0 = cotHeaderDurationStore;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof CotHeaderDurationStore.Key) {
            return d((CotHeaderDurationStore.Key) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof CotHeaderDurationStore.a) {
            return g((CotHeaderDurationStore.a) obj);
        }
        return false;
    }

    public /* bridge */ boolean d(CotHeaderDurationStore.Key key) {
        return super.containsKey(key);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<CotHeaderDurationStore.Key, CotHeaderDurationStore.a>> entrySet() {
        return i();
    }

    public /* bridge */ boolean g(CotHeaderDurationStore.a aVar) {
        return super.containsValue(aVar);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof CotHeaderDurationStore.Key) {
            return h((CotHeaderDurationStore.Key) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof CotHeaderDurationStore.Key) ? obj2 : n((CotHeaderDurationStore.Key) obj, (CotHeaderDurationStore.a) obj2);
    }

    public /* bridge */ CotHeaderDurationStore.a h(CotHeaderDurationStore.Key key) {
        return (CotHeaderDurationStore.a) super.get(key);
    }

    public /* bridge */ Set<Map.Entry<CotHeaderDurationStore.Key, CotHeaderDurationStore.a>> i() {
        return super.entrySet();
    }

    public /* bridge */ Set<CotHeaderDurationStore.Key> j() {
        return super.keySet();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<CotHeaderDurationStore.Key> keySet() {
        return j();
    }

    public /* bridge */ CotHeaderDurationStore.a n(CotHeaderDurationStore.Key key, CotHeaderDurationStore.a aVar) {
        return (CotHeaderDurationStore.a) super.getOrDefault(key, aVar);
    }

    public /* bridge */ int q() {
        return super.size();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        if (obj instanceof CotHeaderDurationStore.Key) {
            return t((CotHeaderDurationStore.Key) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<CotHeaderDurationStore.Key, CotHeaderDurationStore.a> eldest) {
        return size() > this.this$0.capacity;
    }

    public /* bridge */ Collection<CotHeaderDurationStore.a> s() {
        return super.values();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return q();
    }

    public /* bridge */ CotHeaderDurationStore.a t(CotHeaderDurationStore.Key key) {
        return (CotHeaderDurationStore.a) super.remove(key);
    }

    public /* bridge */ boolean u(CotHeaderDurationStore.Key key, CotHeaderDurationStore.a aVar) {
        return super.remove(key, aVar);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<CotHeaderDurationStore.a> values() {
        return s();
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof CotHeaderDurationStore.Key) && (obj2 instanceof CotHeaderDurationStore.a)) {
            return u((CotHeaderDurationStore.Key) obj, (CotHeaderDurationStore.a) obj2);
        }
        return false;
    }
}
