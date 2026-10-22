package com.stepos.ability.api.ability.calltool;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.commoninternal.AbilityType;
import com.stepos.ability.commoninternal.Key;
import com.stepos.ability.commoninternal.SLAScene;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010&\u001a\u00020\u0005H\u0016J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010,\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\nHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0010HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u009c\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0018¨\u0006:"}, d2 = {"Lcom/stepos/ability/api/ability/calltool/CallToolRequest;", "", "abilityId", "", "servicePkg", "", "toolName", "functionName", "params", "extra", "", "timeoutMs", AgentBusWakeContract.EXTRA_TRACE_ID, Key.KEY_TOOL_CALL_ID, "sessionId", "abilityType", "Lcom/stepos/ability/commoninternal/AbilityType;", SLAScene.SLA_SCENE, AppAgent.CONSTRUCT, "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ability/commoninternal/AbilityType;Ljava/lang/String;)V", "getAbilityId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getServicePkg", "()Ljava/lang/String;", "getToolName", "getFunctionName", "getParams", "getExtra", "()Ljava/util/Map;", "getTimeoutMs", "()J", "getTraceId", "getToolCallId", "getSessionId", "getAbilityType", "()Lcom/stepos/ability/commoninternal/AbilityType;", "getSlaScene", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ability/commoninternal/AbilityType;Ljava/lang/String;)Lcom/stepos/ability/api/ability/calltool/CallToolRequest;", "equals", "", "other", "hashCode", "", "api_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CallToolRequest {
    private final Long abilityId;
    private final AbilityType abilityType;
    private final Map<String, Object> extra;
    private final String functionName;
    private final String params;
    private final String servicePkg;
    private final String sessionId;
    private final String slaScene;
    private final long timeoutMs;
    private final String toolCallId;
    private final String toolName;
    private final String traceId;

    public CallToolRequest(Long l, String servicePkg, String toolName, String functionName, String str, Map<String, ? extends Object> map, long j5, String traceId, String toolCallId, String sessionId, AbilityType abilityType, String str2) {
        k.f(servicePkg, "servicePkg");
        k.f(toolName, "toolName");
        k.f(functionName, "functionName");
        k.f(traceId, "traceId");
        k.f(toolCallId, "toolCallId");
        k.f(sessionId, "sessionId");
        k.f(abilityType, "abilityType");
        this.abilityId = l;
        this.servicePkg = servicePkg;
        this.toolName = toolName;
        this.functionName = functionName;
        this.params = str;
        this.extra = map;
        this.timeoutMs = j5;
        this.traceId = traceId;
        this.toolCallId = toolCallId;
        this.sessionId = sessionId;
        this.abilityType = abilityType;
        this.slaScene = str2;
    }

    public static /* synthetic */ CallToolRequest copy$default(CallToolRequest callToolRequest, Long l, String str, String str2, String str3, String str4, Map map, long j5, String str5, String str6, String str7, AbilityType abilityType, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            l = callToolRequest.abilityId;
        }
        return callToolRequest.copy(l, (i & 2) != 0 ? callToolRequest.servicePkg : str, (i & 4) != 0 ? callToolRequest.toolName : str2, (i & 8) != 0 ? callToolRequest.functionName : str3, (i & 16) != 0 ? callToolRequest.params : str4, (i & 32) != 0 ? callToolRequest.extra : map, (i & 64) != 0 ? callToolRequest.timeoutMs : j5, (i & 128) != 0 ? callToolRequest.traceId : str5, (i & 256) != 0 ? callToolRequest.toolCallId : str6, (i & 512) != 0 ? callToolRequest.sessionId : str7, (i & 1024) != 0 ? callToolRequest.abilityType : abilityType, (i & 2048) != 0 ? callToolRequest.slaScene : str8);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getAbilityId() {
        return this.abilityId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component11, reason: from getter */
    public final AbilityType getAbilityType() {
        return this.abilityType;
    }

    /* renamed from: component12, reason: from getter */
    public final String getSlaScene() {
        return this.slaScene;
    }

    /* renamed from: component2, reason: from getter */
    public final String getServicePkg() {
        return this.servicePkg;
    }

    /* renamed from: component3, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFunctionName() {
        return this.functionName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getParams() {
        return this.params;
    }

    public final Map<String, Object> component6() {
        return this.extra;
    }

    /* renamed from: component7, reason: from getter */
    public final long getTimeoutMs() {
        return this.timeoutMs;
    }

    /* renamed from: component8, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component9, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    public final CallToolRequest copy(Long abilityId, String servicePkg, String toolName, String functionName, String params, Map<String, ? extends Object> extra, long timeoutMs, String traceId, String toolCallId, String sessionId, AbilityType abilityType, String slaScene) {
        k.f(servicePkg, "servicePkg");
        k.f(toolName, "toolName");
        k.f(functionName, "functionName");
        k.f(traceId, "traceId");
        k.f(toolCallId, "toolCallId");
        k.f(sessionId, "sessionId");
        k.f(abilityType, "abilityType");
        return new CallToolRequest(abilityId, servicePkg, toolName, functionName, params, extra, timeoutMs, traceId, toolCallId, sessionId, abilityType, slaScene);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallToolRequest)) {
            return false;
        }
        CallToolRequest callToolRequest = (CallToolRequest) other;
        return k.b(this.abilityId, callToolRequest.abilityId) && k.b(this.servicePkg, callToolRequest.servicePkg) && k.b(this.toolName, callToolRequest.toolName) && k.b(this.functionName, callToolRequest.functionName) && k.b(this.params, callToolRequest.params) && k.b(this.extra, callToolRequest.extra) && this.timeoutMs == callToolRequest.timeoutMs && k.b(this.traceId, callToolRequest.traceId) && k.b(this.toolCallId, callToolRequest.toolCallId) && k.b(this.sessionId, callToolRequest.sessionId) && this.abilityType == callToolRequest.abilityType && k.b(this.slaScene, callToolRequest.slaScene);
    }

    public final Long getAbilityId() {
        return this.abilityId;
    }

    public final AbilityType getAbilityType() {
        return this.abilityType;
    }

    public final Map<String, Object> getExtra() {
        return this.extra;
    }

    public final String getFunctionName() {
        return this.functionName;
    }

    public final String getParams() {
        return this.params;
    }

    public final String getServicePkg() {
        return this.servicePkg;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSlaScene() {
        return this.slaScene;
    }

    public final long getTimeoutMs() {
        return this.timeoutMs;
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
        Long l = this.abilityId;
        int iC = a.c(a.c(a.c((l == null ? 0 : l.hashCode()) * 31, 31, this.servicePkg), 31, this.toolName), 31, this.functionName);
        String str = this.params;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, Object> map = this.extra;
        int iHashCode2 = (this.abilityType.hashCode() + a.c(a.c(a.c(androidx.appfunctions.metadata.a.c((iHashCode + (map == null ? 0 : map.hashCode())) * 31, 31, this.timeoutMs), 31, this.traceId), 31, this.toolCallId), 31, this.sessionId)) * 31;
        String str2 = this.slaScene;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        Long l = this.abilityId;
        String str = this.servicePkg;
        String str2 = this.toolName;
        String str3 = this.functionName;
        String str4 = this.params;
        long j5 = this.timeoutMs;
        String str5 = this.traceId;
        String str6 = this.toolCallId;
        String str7 = this.sessionId;
        AbilityType abilityType = this.abilityType;
        String str8 = this.slaScene;
        Map<String, Object> map = this.extra;
        StringBuilder sb = new StringBuilder("CallToolRequest(abilityId=");
        sb.append(l);
        sb.append(", servicePkg=");
        sb.append(str);
        sb.append(", toolName=");
        androidx.constraintlayout.core.dsl.a.A(sb, str2, ", functionName=", str3, ", params=");
        a.y(j5, str4, ", timeoutMs=", sb);
        androidx.constraintlayout.core.dsl.a.A(sb, ", traceId=", str5, ", toolCallId=", str6);
        sb.append(", sessionId=");
        sb.append(str7);
        sb.append(", abilityType=");
        sb.append(abilityType);
        sb.append(", slaScene=");
        sb.append(str8);
        sb.append(", extra=");
        sb.append(map);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ CallToolRequest(Long l, String str, String str2, String str3, String str4, Map map, long j5, String str5, String str6, String str7, AbilityType abilityType, String str8, int i, e eVar) {
        this(l, str, str2, str3, str4, (i & 32) != 0 ? null : map, j5, str5, str6, (i & 512) != 0 ? "" : str7, abilityType, (i & 2048) != 0 ? null : str8);
    }
}
