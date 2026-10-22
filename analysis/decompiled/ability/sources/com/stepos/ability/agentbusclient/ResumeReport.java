package com.stepos.ability.agentbusclient;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J{\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00052\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0002\u0010\u0010J,\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0005H\u0002R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/stepos/ability/agentbusclient/ResumeReport;", "", AppAgent.CONSTRUCT, "()V", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "", "", "sessionKey", "approvalId", "decision", "expectedVersion", "", "idempotencyKey", "executionGrant", "toolResult", "reasonMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;)Ljava/util/Map;", "toCloudGrantKeys", "grant", "CLOUD_GRANT_KEYS", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ResumeReport {
    public static final ResumeReport INSTANCE = new ResumeReport();
    private static final Map<String, String> CLOUD_GRANT_KEYS = kotlin.collections.a.R(new Pair("idempotency_key", "idempotencyKey"), new Pair("expires_at", "expiresAt"));

    private ResumeReport() {
    }

    private final Map<String, Object> toCloudGrantKeys(Map<String, ? extends Object> grant) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.collections.a.P(grant.size()));
        Iterator<T> it = grant.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            String str2 = CLOUD_GRANT_KEYS.get(str);
            if (str2 != null) {
                str = str2;
            }
            linkedHashMap.put(str, entry.getValue());
        }
        return linkedHashMap;
    }

    public final Map<String, Object> build(String sessionKey, String approvalId, String decision, Integer expectedVersion, String idempotencyKey, Map<String, ? extends Object> executionGrant, Map<String, ? extends Object> toolResult, String reasonMessage) {
        k.f(sessionKey, "sessionKey");
        k.f(decision, "decision");
        k.f(idempotencyKey, "idempotencyKey");
        k.f(toolResult, "toolResult");
        k.f(reasonMessage, "reasonMessage");
        MapBuilder mapBuilder = new MapBuilder();
        boolean zEquals = decision.equals("allow-once");
        mapBuilder.put("sessionKey", sessionKey);
        mapBuilder.put("approvalId", approvalId);
        mapBuilder.put("decision", decision);
        if (expectedVersion != null) {
            mapBuilder.put("expectedVersion", Integer.valueOf(expectedVersion.intValue()));
        }
        mapBuilder.put("idempotencyKey", idempotencyKey);
        if (zEquals) {
            if (executionGrant != null) {
                mapBuilder.put("executionGrant", INSTANCE.toCloudGrantKeys(executionGrant));
            }
            mapBuilder.put("toolResult", toolResult);
        }
        mapBuilder.put("reason", kotlin.collections.a.R(new Pair("code", zEquals ? "APPROVED" : "DENIED"), new Pair("message", reasonMessage)));
        return mapBuilder.b();
    }
}
