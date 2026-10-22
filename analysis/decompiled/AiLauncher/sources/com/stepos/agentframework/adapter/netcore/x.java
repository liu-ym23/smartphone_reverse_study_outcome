package com.stepos.agentframework.adapter.netcore;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u000b\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/x;", "", "<init>", "()V", "", "raw", "", "fallbackSessionId", "", "requireStream", "Lcom/stepos/agentframework/adapter/netcore/v;", "c", "(Ljava/util/Map;Ljava/lang/String;Z)Lcom/stepos/agentframework/adapter/netcore/v;", "e", "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/agentframework/adapter/netcore/v;", UxipConstants.f30680s, Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;)Ljava/util/Map;", "f", "(Ljava/lang/Object;)Ljava/lang/String;", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Object;)Ljava/lang/Long;", "STREAM", "Ljava/lang/String;", "Lcom/google/gson/Gson;", "gson", "Lcom/google/gson/Gson;", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class x {
    public static final String STREAM = "stepclaw.session.update";
    public static final x INSTANCE = new x();
    private static final Gson gson = new Gson();

    public static /* synthetic */ SessionUpdate d(x xVar, Map map, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return xVar.c(map, str, z10);
    }

    public final Map<String, Object> a(Object value) {
        Map map = value instanceof Map ? (Map) value : null;
        if (map == null || map.isEmpty()) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value2 = entry.getValue();
            String str = key instanceof String ? (String) key : null;
            if (str != null) {
                linkedHashMap.put(str, value2);
            }
        }
        if (linkedHashMap.isEmpty()) {
            return null;
        }
        return linkedHashMap;
    }

    public final Long b(Object value) {
        Number number = value instanceof Number ? (Number) value : null;
        if (number != null) {
            return Long.valueOf(number.longValue());
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.agentframework.adapter.netcore.SessionUpdate c(java.util.Map<?, ?> r11, java.lang.String r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.netcore.x.c(java.util.Map, java.lang.String, boolean):com.stepos.agentframework.adapter.netcore.v");
    }

    public final SessionUpdate e(String raw, String fallbackSessionId) {
        Object objB;
        kotlin.jvm.internal.p.i(raw, "raw");
        if (!H.g0(raw, STREAM, false, 2, null)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Object objFromJson = gson.fromJson(raw, (Class<Object>) Map.class);
            objB = Result.b(objFromJson instanceof Map ? (Map) objFromJson : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Map<?, ?> map = (Map) objB;
        if (map == null) {
            return null;
        }
        return c(map, fallbackSessionId, true);
    }

    public final String f(Object value) {
        String str = value instanceof String ? (String) value : null;
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str;
    }
}
