package com.stepos.agentframework.chatcore.session;

import com.stepos.agentframework.chatcore.session.TaskIngress;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"com/stepos/agentframework/chatcore/session/TaskIngress$SignatureLruCache$map$1", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TaskIngress$SignatureLruCache$map$1 extends LinkedHashMap<String, Integer> {
    final /* synthetic */ TaskIngress.SignatureLruCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskIngress$SignatureLruCache$map$1(TaskIngress.SignatureLruCache signatureLruCache, int i10) {
        super(i10, 0.75f, true);
        this.this$0 = signatureLruCache;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return d((String) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Integer) {
            return g((Integer) obj);
        }
        return false;
    }

    public /* bridge */ boolean d(String str) {
        return super.containsKey(str);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Integer>> entrySet() {
        return i();
    }

    public /* bridge */ boolean g(Integer num) {
        return super.containsValue(num);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof String) {
            return h((String) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof String) ? obj2 : n((String) obj, (Integer) obj2);
    }

    public /* bridge */ Integer h(String str) {
        return (Integer) super.get(str);
    }

    public /* bridge */ Set<Map.Entry<String, Integer>> i() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> j() {
        return super.keySet();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return j();
    }

    public /* bridge */ Integer n(String str, Integer num) {
        return (Integer) super.getOrDefault(str, num);
    }

    public /* bridge */ int q() {
        return super.size();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        if (obj instanceof String) {
            return t((String) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
        return size() > this.this$0.capacity;
    }

    public /* bridge */ Collection<Integer> s() {
        return super.values();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return q();
    }

    public /* bridge */ Integer t(String str) {
        return (Integer) super.remove(str);
    }

    public /* bridge */ boolean u(String str, Integer num) {
        return super.remove(str, num);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Integer> values() {
        return s();
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof Integer)) {
            return u((String) obj, (Integer) obj2);
        }
        return false;
    }
}
