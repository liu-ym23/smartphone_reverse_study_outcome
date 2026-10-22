package com.stepos.ability.agentbusclient;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003JM\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/stepos/ability/agentbusclient/PendingAuth;", "", Key.KEY_TOOL_CALL_ID, "", "sessionId", "toolName", AgentBusWakeContract.EXTRA_TRACE_ID, "token", "idempotencyKey", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getToolCallId", "()Ljava/lang/String;", "getSessionId", "getToolName", "getTraceId", "getToken", "getIdempotencyKey", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PendingAuth {
    private final String idempotencyKey;
    private final String sessionId;
    private final String token;
    private final String toolCallId;
    private final String toolName;
    private final String traceId;

    public PendingAuth(String toolCallId, String str, String toolName, String str2, String str3, String str4) {
        k.f(toolCallId, "toolCallId");
        k.f(toolName, "toolName");
        this.toolCallId = toolCallId;
        this.sessionId = str;
        this.toolName = toolName;
        this.traceId = str2;
        this.token = str3;
        this.idempotencyKey = str4;
    }

    public static /* synthetic */ PendingAuth copy$default(PendingAuth pendingAuth, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pendingAuth.toolCallId;
        }
        if ((i & 2) != 0) {
            str2 = pendingAuth.sessionId;
        }
        if ((i & 4) != 0) {
            str3 = pendingAuth.toolName;
        }
        if ((i & 8) != 0) {
            str4 = pendingAuth.traceId;
        }
        if ((i & 16) != 0) {
            str5 = pendingAuth.token;
        }
        if ((i & 32) != 0) {
            str6 = pendingAuth.idempotencyKey;
        }
        String str7 = str5;
        String str8 = str6;
        return pendingAuth.copy(str, str2, str3, str4, str7, str8);
    }

    /* renamed from: component1, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component6, reason: from getter */
    public final String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    public final PendingAuth copy(String toolCallId, String sessionId, String toolName, String traceId, String token, String idempotencyKey) {
        k.f(toolCallId, "toolCallId");
        k.f(toolName, "toolName");
        return new PendingAuth(toolCallId, sessionId, toolName, traceId, token, idempotencyKey);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PendingAuth)) {
            return false;
        }
        PendingAuth pendingAuth = (PendingAuth) other;
        return k.b(this.toolCallId, pendingAuth.toolCallId) && k.b(this.sessionId, pendingAuth.sessionId) && k.b(this.toolName, pendingAuth.toolName) && k.b(this.traceId, pendingAuth.traceId) && k.b(this.token, pendingAuth.token) && k.b(this.idempotencyKey, pendingAuth.idempotencyKey);
    }

    public final String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getToolCallId() {
        return this.toolCallId;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int iHashCode = this.toolCallId.hashCode() * 31;
        String str = this.sessionId;
        int iC = B7.a.c((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.toolName);
        String str2 = this.traceId;
        int iHashCode2 = (iC + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.token;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.idempotencyKey;
        return iHashCode3 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        String str = this.toolCallId;
        String str2 = this.sessionId;
        String str3 = this.toolName;
        String str4 = this.traceId;
        String str5 = this.token;
        String str6 = this.idempotencyKey;
        StringBuilder sbW = B7.a.w("PendingAuth(toolCallId=", str, ", sessionId=", str2, ", toolName=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", traceId=", str4, ", token=");
        return androidx.appfunctions.metadata.a.p(sbW, str5, ", idempotencyKey=", str6, ")");
    }
}
