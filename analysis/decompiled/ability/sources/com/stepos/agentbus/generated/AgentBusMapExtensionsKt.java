package com.stepos.agentbus.generated;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a*\u0010\u0000\u001a\u00020\u0001*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0001\u001a\"\u0010\u0006\u001a\u0004\u0018\u00010\u0001*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0001\u001a*\u0010\u0007\u001a\u00020\b*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\b\u001a*\u0010\t\u001a\u00020\n*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\n\u001a*\u0010\u000b\u001a\u00020\f*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\f\u001a*\u0010\r\u001a\u00020\u000e*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u000e\u001a0\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0002*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0001\u001a*\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0011*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0001¨\u0006\u0012"}, d2 = {"getString", "", "", "", "key", "default", "getStringOrNull", "getInt", "", "getLong", "", "getDouble", "", "getBoolean", "", "getMap", "getList", "", "agentbus-client_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgentBusMapExtensionsKt {
    public static final boolean getBoolean(Map<String, ? extends Object> map, String key, boolean z10) {
        k.f(map, "<this>");
        k.f(key, "key");
        Object obj = map.get(key);
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        return bool != null ? bool.booleanValue() : z10;
    }

    public static /* synthetic */ boolean getBoolean$default(Map map, String str, boolean z10, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = false;
        }
        return getBoolean(map, str, z10);
    }

    public static final double getDouble(Map<String, ? extends Object> map, String key, double d) {
        k.f(map, "<this>");
        k.f(key, "key");
        Object obj = map.get(key);
        Number number = obj instanceof Number ? (Number) obj : null;
        return number != null ? number.doubleValue() : d;
    }

    public static /* synthetic */ double getDouble$default(Map map, String str, double d, int i, Object obj) {
        if ((i & 2) != 0) {
            d = 0.0d;
        }
        return getDouble(map, str, d);
    }

    public static final int getInt(Map<String, ? extends Object> map, String key, int i) {
        k.f(map, "<this>");
        k.f(key, "key");
        Object obj = map.get(key);
        Number number = obj instanceof Number ? (Number) obj : null;
        return number != null ? number.intValue() : i;
    }

    public static /* synthetic */ int getInt$default(Map map, String str, int i, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i = 0;
        }
        return getInt(map, str, i);
    }

    public static final List<Object> getList(Map<String, ? extends Object> map, String key) {
        k.f(map, "<this>");
        k.f(key, "key");
        Object obj = map.get(key);
        if (obj instanceof List) {
            return (List) obj;
        }
        return null;
    }

    public static final long getLong(Map<String, ? extends Object> map, String key, long j5) {
        k.f(map, "<this>");
        k.f(key, "key");
        Object obj = map.get(key);
        Number number = obj instanceof Number ? (Number) obj : null;
        return number != null ? number.longValue() : j5;
    }

    public static /* synthetic */ long getLong$default(Map map, String str, long j5, int i, Object obj) {
        if ((i & 2) != 0) {
            j5 = 0;
        }
        return getLong(map, str, j5);
    }

    public static final Map<String, Object> getMap(Map<String, ? extends Object> map, String key) {
        k.f(map, "<this>");
        k.f(key, "key");
        Object obj = map.get(key);
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public static final String getString(Map<String, ? extends Object> map, String key, String str) {
        k.f(map, "<this>");
        k.f(key, "key");
        k.f(str, "default");
        Object obj = map.get(key);
        String str2 = obj instanceof String ? (String) obj : null;
        return str2 == null ? str : str2;
    }

    public static /* synthetic */ String getString$default(Map map, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        return getString(map, str, str2);
    }

    public static final String getStringOrNull(Map<String, ? extends Object> map, String key) {
        k.f(map, "<this>");
        k.f(key, "key");
        Object obj = map.get(key);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }
}
