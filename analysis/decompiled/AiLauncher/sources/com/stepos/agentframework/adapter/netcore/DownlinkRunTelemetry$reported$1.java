package com.stepos.agentframework.adapter.netcore;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001e\u0010\u0005\u001a\u00020\u00032\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007H\u0014¨\u0006\b"}, d2 = {"com/stepos/agentframework/adapter/netcore/DownlinkRunTelemetry$reported$1", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "eldest", "", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DownlinkRunTelemetry$reported$1 extends LinkedHashMap<String, Boolean> {
    public DownlinkRunTelemetry$reported$1() {
        super(64, 0.75f, true);
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
        if (obj instanceof Boolean) {
            return g((Boolean) obj);
        }
        return false;
    }

    public /* bridge */ boolean d(String str) {
        return super.containsKey(str);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Boolean>> entrySet() {
        return i();
    }

    public /* bridge */ boolean g(Boolean bool) {
        return super.containsValue(bool);
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
        return !(obj instanceof String) ? obj2 : n((String) obj, (Boolean) obj2);
    }

    public /* bridge */ Boolean h(String str) {
        return (Boolean) super.get(str);
    }

    public /* bridge */ Set<Map.Entry<String, Boolean>> i() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> j() {
        return super.keySet();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return j();
    }

    public /* bridge */ Boolean n(String str, Boolean bool) {
        return (Boolean) super.getOrDefault(str, bool);
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
    public boolean removeEldestEntry(Map.Entry<String, Boolean> eldest) {
        return size() > 256;
    }

    public /* bridge */ Collection<Boolean> s() {
        return super.values();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return q();
    }

    public /* bridge */ Boolean t(String str) {
        return (Boolean) super.remove(str);
    }

    public /* bridge */ boolean u(String str, Boolean bool) {
        return super.remove(str, bool);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Boolean> values() {
        return s();
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof Boolean)) {
            return u((String) obj, (Boolean) obj2);
        }
        return false;
    }
}
