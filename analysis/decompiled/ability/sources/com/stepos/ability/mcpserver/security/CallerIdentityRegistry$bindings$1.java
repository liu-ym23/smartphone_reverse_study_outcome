package com.stepos.ability.mcpserver.security;

import java.util.LinkedHashMap;
import java.util.Map;
import k4.m;
import k4.n;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004¨\u0006\u0005"}, d2 = {"com/stepos/ability/mcpserver/security/CallerIdentityRegistry$bindings$1", "Ljava/util/LinkedHashMap;", "", "Lk4/m;", "Lkotlin/collections/LinkedHashMap;", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CallerIdentityRegistry$bindings$1 extends LinkedHashMap<String, m> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f3202a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallerIdentityRegistry$bindings$1(n nVar) {
        super(16, 0.75f, true);
        this.f3202a = nVar;
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
        if (obj instanceof m) {
            return super.containsValue((m) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof String) {
            return (m) super.get((String) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof String) ? obj2 : (m) super.getOrDefault((String) obj, (m) obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Object remove(Object obj) {
        if (obj instanceof String) {
            return (m) super.remove((String) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry<String, m> eldest) {
        k.f(eldest, "eldest");
        if (super.size() <= 128) {
            return false;
        }
        String key = eldest.getKey();
        this.f3202a.a(eldest.getValue().b, key);
        return true;
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof m)) {
            return super.remove((String) obj, (m) obj2);
        }
        return false;
    }
}
