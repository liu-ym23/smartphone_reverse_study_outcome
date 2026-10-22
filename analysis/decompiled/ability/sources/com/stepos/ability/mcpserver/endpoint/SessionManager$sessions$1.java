package com.stepos.ability.mcpserver.endpoint;

import com.stepos.ability.mcpserver.model.McpSession;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ability/mcpserver/endpoint/SessionManager$sessions$1", "Ljava/util/LinkedHashMap;", "", "Lcom/stepos/ability/mcpserver/model/McpSession;", "Lkotlin/collections/LinkedHashMap;", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SessionManager$sessions$1 extends LinkedHashMap<String, McpSession> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f3177a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionManager$sessions$1(b bVar) {
        super(16, 0.75f, true);
        this.f3177a = bVar;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return super.containsKey((String) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof McpSession) {
            return super.containsValue((McpSession) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof String) {
            return (McpSession) super.get((String) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof String) ? obj2 : (McpSession) super.getOrDefault((String) obj, (McpSession) obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        if (obj instanceof String) {
            return (McpSession) super.remove((String) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry<String, McpSession> eldest) {
        k.f(eldest, "eldest");
        return super.size() > this.f3177a.f3179a.getSessionMaxEntries();
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof McpSession)) {
            return super.remove((String) obj, (McpSession) obj2);
        }
        return false;
    }
}
