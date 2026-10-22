package com.stepos.agentframework.adapter.netcore;

import com.stepos.agentframework.adapter.netcore.DownlinkRunTelemetry;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J%\u0010\b\u001a\u00020\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/agentframework/adapter/netcore/DownlinkRunTelemetry$byRunId$1", "Ljava/util/LinkedHashMap;", "", "Lcom/stepos/agentframework/adapter/netcore/DownlinkRunTelemetry$a;", "Lkotlin/collections/LinkedHashMap;", "", "eldest", "", "removeEldestEntry", "(Ljava/util/Map$Entry;)Z", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DownlinkRunTelemetry$byRunId$1 extends LinkedHashMap<String, DownlinkRunTelemetry.Snapshot> {
    public DownlinkRunTelemetry$byRunId$1() {
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
        if (obj instanceof DownlinkRunTelemetry.Snapshot) {
            return g((DownlinkRunTelemetry.Snapshot) obj);
        }
        return false;
    }

    public /* bridge */ boolean d(String str) {
        return super.containsKey(str);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, DownlinkRunTelemetry.Snapshot>> entrySet() {
        return i();
    }

    public /* bridge */ boolean g(DownlinkRunTelemetry.Snapshot aVar) {
        return super.containsValue(aVar);
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
        return !(obj instanceof String) ? obj2 : n((String) obj, (DownlinkRunTelemetry.Snapshot) obj2);
    }

    public /* bridge */ DownlinkRunTelemetry.Snapshot h(String str) {
        return (DownlinkRunTelemetry.Snapshot) super.get(str);
    }

    public /* bridge */ Set<Map.Entry<String, DownlinkRunTelemetry.Snapshot>> i() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> j() {
        return super.keySet();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return j();
    }

    public /* bridge */ DownlinkRunTelemetry.Snapshot n(String str, DownlinkRunTelemetry.Snapshot aVar) {
        return (DownlinkRunTelemetry.Snapshot) super.getOrDefault(str, aVar);
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
    public boolean removeEldestEntry(Map.Entry<String, DownlinkRunTelemetry.Snapshot> eldest) {
        return size() > 256;
    }

    public /* bridge */ Collection<DownlinkRunTelemetry.Snapshot> s() {
        return super.values();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return q();
    }

    public /* bridge */ DownlinkRunTelemetry.Snapshot t(String str) {
        return (DownlinkRunTelemetry.Snapshot) super.remove(str);
    }

    public /* bridge */ boolean u(String str, DownlinkRunTelemetry.Snapshot aVar) {
        return super.remove(str, aVar);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<DownlinkRunTelemetry.Snapshot> values() {
        return s();
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof DownlinkRunTelemetry.Snapshot)) {
            return u((String) obj, (DownlinkRunTelemetry.Snapshot) obj2);
        }
        return false;
    }
}
