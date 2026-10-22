package com.stepos.ability.agentbusclient;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J<\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ(\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00072\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\u0002¨\u0006\u000e"}, d2 = {"Lcom/stepos/ability/agentbusclient/PendingAuthParser;", "", AppAgent.CONSTRUCT, "()V", "parse", "Lcom/stepos/ability/agentbusclient/PendingAuth;", "mapped", "", "", Key.KEY_TOOL_CALL_ID, "sessionId", "toolName", AgentBusWakeContract.EXTRA_TRACE_ID, "approvalRequestOf", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PendingAuthParser {
    public static final PendingAuthParser INSTANCE = new PendingAuthParser();

    private PendingAuthParser() {
    }

    private final Map<?, ?> approvalRequestOf(Map<String, ? extends Object> mapped) {
        Map<?, ?> mapApprovalRequestOf$from = approvalRequestOf$from(mapped.get("content"));
        return mapApprovalRequestOf$from == null ? approvalRequestOf$from(mapped.get("structuredContent")) : mapApprovalRequestOf$from;
    }

    private static final Map<?, ?> approvalRequestOf$from(Object obj) {
        Map map = obj instanceof Map ? (Map) obj : null;
        if (map == null) {
            return null;
        }
        Object obj2 = map.get("approval_request");
        Map<?, ?> map2 = obj2 instanceof Map ? (Map) obj2 : null;
        if (map2 != null) {
            return map2;
        }
        Map<?, ?> mapApprovalRequestOf$from = approvalRequestOf$from(map.get("structuredContent"));
        if (mapApprovalRequestOf$from != null) {
            return mapApprovalRequestOf$from;
        }
        Map<?, ?> mapApprovalRequestOf$from2 = approvalRequestOf$from(map.get("content"));
        if (mapApprovalRequestOf$from2 != null) {
            return mapApprovalRequestOf$from2;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ability.agentbusclient.PendingAuth parse(java.util.Map<java.lang.String, ? extends java.lang.Object> r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            r9 = this;
            java.lang.String r0 = "mapped"
            kotlin.jvm.internal.k.f(r10, r0)
            java.lang.String r0 = "toolCallId"
            kotlin.jvm.internal.k.f(r11, r0)
            java.lang.String r0 = "sessionId"
            kotlin.jvm.internal.k.f(r12, r0)
            java.lang.String r0 = "toolName"
            kotlin.jvm.internal.k.f(r13, r0)
            java.lang.String r0 = "traceId"
            kotlin.jvm.internal.k.f(r14, r0)
            java.util.Map r9 = r9.approvalRequestOf(r10)
            r10 = 0
            if (r9 == 0) goto L27
            java.lang.String r0 = "execution_grant"
            java.lang.Object r9 = r9.get(r0)
            goto L28
        L27:
            r9 = r10
        L28:
            boolean r0 = r9 instanceof java.util.Map
            if (r0 == 0) goto L2f
            java.util.Map r9 = (java.util.Map) r9
            goto L30
        L2f:
            r9 = r10
        L30:
            if (r9 == 0) goto L39
            java.lang.String r0 = "token"
            java.lang.Object r0 = r9.get(r0)
            goto L3a
        L39:
            r0 = r10
        L3a:
            boolean r1 = r0 instanceof java.lang.String
            if (r1 == 0) goto L41
            java.lang.String r0 = (java.lang.String) r0
            goto L42
        L41:
            r0 = r10
        L42:
            if (r0 == 0) goto L4c
            boolean r1 = j9.m.s0(r0)
            if (r1 != 0) goto L4c
            r7 = r0
            goto L4d
        L4c:
            r7 = r10
        L4d:
            if (r9 == 0) goto L56
            java.lang.String r0 = "idempotency_key"
            java.lang.Object r9 = r9.get(r0)
            goto L57
        L56:
            r9 = r10
        L57:
            boolean r0 = r9 instanceof java.lang.String
            if (r0 == 0) goto L5e
            java.lang.String r9 = (java.lang.String) r9
            goto L5f
        L5e:
            r9 = r10
        L5f:
            if (r9 == 0) goto L6e
            boolean r0 = j9.m.s0(r9)
            if (r0 != 0) goto L68
            goto L69
        L68:
            r9 = r10
        L69:
            if (r9 != 0) goto L6c
            goto L6e
        L6c:
            r8 = r9
            goto L6f
        L6e:
            r8 = r7
        L6f:
            int r9 = r12.length()
            if (r9 <= 0) goto L77
            r4 = r12
            goto L78
        L77:
            r4 = r10
        L78:
            int r9 = r14.length()
            if (r9 <= 0) goto L80
            r6 = r14
            goto L81
        L80:
            r6 = r10
        L81:
            com.stepos.ability.agentbusclient.PendingAuth r2 = new com.stepos.ability.agentbusclient.PendingAuth
            r3 = r11
            r5 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ability.agentbusclient.PendingAuthParser.parse(java.util.Map, java.lang.String, java.lang.String, java.lang.String, java.lang.String):com.stepos.ability.agentbusclient.PendingAuth");
    }
}
