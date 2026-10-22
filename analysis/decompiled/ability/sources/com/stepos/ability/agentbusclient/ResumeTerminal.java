package com.stepos.ability.agentbusclient;

import D7.F;
import D7.w;
import Y7.f;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import i9.C1566a;
import i9.i;
import j9.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JU\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\"\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0002J\u001a\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e*\u00020\u0013H\u0002J\u0014\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015*\u00020\u0016H\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\u0019"}, d2 = {"Lcom/stepos/ability/agentbusclient/ResumeTerminal;", "", AppAgent.CONSTRUCT, "()V", "parse", "Lcom/stepos/ability/agentbusclient/ResumeTerminalFields;", "approvalId", "", "sessionKey", "expectedVersion", "", "decision", "grantJson", "fallbackGrant", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/stepos/ability/agentbusclient/ResumeTerminalFields;", "parseGrant", "json", "toMap", "Lorg/json/JSONObject;", "toList", "", "Lorg/json/JSONArray;", "normalize", "value", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ResumeTerminal {
    public static final ResumeTerminal INSTANCE = new ResumeTerminal();

    private ResumeTerminal() {
    }

    private final Object normalize(Object value) {
        if (k.b(value, JSONObject.NULL)) {
            return null;
        }
        return value instanceof JSONObject ? toMap((JSONObject) value) : value instanceof JSONArray ? toList((JSONArray) value) : value;
    }

    private final Map<String, Object> parseGrant(String json) {
        Object objA;
        if (json == null || m.s0(json)) {
            return null;
        }
        try {
            objA = toMap(new JSONObject(json));
        } catch (Throwable th) {
            objA = b.a(th);
        }
        return (Map) (objA instanceof Result.Failure ? null : objA);
    }

    private final List<Object> toList(JSONArray jSONArray) {
        f fVarX = AbstractC1451a.X(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(w.c0(fVarX, 10));
        Iterator it = fVarX.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.normalize(jSONArray.get(((F) it).nextInt())));
        }
        return arrayList;
    }

    private final Map<String, Object> toMap(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        k.e(itKeys, "keys(...)");
        i iVarC0 = kotlin.sequences.a.c0(itKeys);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = ((C1566a) iVarC0).iterator();
        while (it.hasNext()) {
            Object next = it.next();
            linkedHashMap.put(next, INSTANCE.normalize(jSONObject.get((String) next)));
        }
        return linkedHashMap;
    }

    public final ResumeTerminalFields parse(String approvalId, String sessionKey, Integer expectedVersion, String decision, String grantJson, Map<String, ? extends Object> fallbackGrant) {
        if (approvalId == null || m.s0(approvalId)) {
            approvalId = null;
        }
        if (sessionKey == null || m.s0(sessionKey)) {
            sessionKey = null;
        }
        String str = k.b(decision, "allow-once") ? "allow-once" : "deny";
        Map<String, ? extends Object> grant = parseGrant(grantJson);
        return new ResumeTerminalFields(approvalId, sessionKey, expectedVersion, str, grant == null ? fallbackGrant : grant);
    }
}
