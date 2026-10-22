package com.stepos.agentframework.chatcore;

import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a!\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u0001*\u0004\u0018\u00010\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"", "", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;)Ljava/util/Map;", "chatcore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1847b {
    public static final Map<String, Object> b(Object obj) {
        Map map = obj instanceof Map ? (Map) obj : null;
        if (map == null) {
            return kotlin.collections.a.i();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && value != null) {
                linkedHashMap.put(key, value);
            }
        }
        return linkedHashMap;
    }
}
