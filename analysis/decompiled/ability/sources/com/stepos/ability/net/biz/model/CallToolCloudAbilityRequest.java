package com.stepos.ability.net.biz.model;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J^\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006&"}, d2 = {"Lcom/stepos/ability/net/biz/model/CallToolCloudAbilityRequest;", "", "abilityId", "", "toolName", "", "params", "", "timeoutMillis", "", "responseType", AgentBusWakeContract.EXTRA_TRACE_ID, AppAgent.CONSTRUCT, "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;JLjava/lang/String;Ljava/lang/String;)V", "getAbilityId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getToolName", "()Ljava/lang/String;", "getParams", "()Ljava/util/Map;", "getTimeoutMillis", "()J", "getResponseType", "getTraceId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Map;JLjava/lang/String;Ljava/lang/String;)Lcom/stepos/ability/net/biz/model/CallToolCloudAbilityRequest;", "equals", "", "other", "hashCode", "toString", "net_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class CallToolCloudAbilityRequest {

    @SerializedName("abilityId")
    private final Integer abilityId;

    @SerializedName("params")
    private final Map<String, Object> params;

    @SerializedName("responseType")
    private final String responseType;

    @SerializedName("timeoutMillis")
    private final long timeoutMillis;

    @SerializedName("toolName")
    private final String toolName;

    @SerializedName(AgentBusWakeContract.EXTRA_TRACE_ID)
    private final String traceId;

    public CallToolCloudAbilityRequest(Integer num, String str, Map<String, ? extends Object> map, long j5, String responseType, String traceId) {
        k.f(responseType, "responseType");
        k.f(traceId, "traceId");
        this.abilityId = num;
        this.toolName = str;
        this.params = map;
        this.timeoutMillis = j5;
        this.responseType = responseType;
        this.traceId = traceId;
    }

    public static /* synthetic */ CallToolCloudAbilityRequest copy$default(CallToolCloudAbilityRequest callToolCloudAbilityRequest, Integer num, String str, Map map, long j5, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = callToolCloudAbilityRequest.abilityId;
        }
        if ((i & 2) != 0) {
            str = callToolCloudAbilityRequest.toolName;
        }
        if ((i & 4) != 0) {
            map = callToolCloudAbilityRequest.params;
        }
        if ((i & 8) != 0) {
            j5 = callToolCloudAbilityRequest.timeoutMillis;
        }
        if ((i & 16) != 0) {
            str2 = callToolCloudAbilityRequest.responseType;
        }
        if ((i & 32) != 0) {
            str3 = callToolCloudAbilityRequest.traceId;
        }
        long j6 = j5;
        Map map2 = map;
        return callToolCloudAbilityRequest.copy(num, str, map2, j6, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getAbilityId() {
        return this.abilityId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    public final Map<String, Object> component3() {
        return this.params;
    }

    /* renamed from: component4, reason: from getter */
    public final long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    /* renamed from: component5, reason: from getter */
    public final String getResponseType() {
        return this.responseType;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final CallToolCloudAbilityRequest copy(Integer abilityId, String toolName, Map<String, ? extends Object> params, long timeoutMillis, String responseType, String traceId) {
        k.f(responseType, "responseType");
        k.f(traceId, "traceId");
        return new CallToolCloudAbilityRequest(abilityId, toolName, params, timeoutMillis, responseType, traceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CallToolCloudAbilityRequest)) {
            return false;
        }
        CallToolCloudAbilityRequest callToolCloudAbilityRequest = (CallToolCloudAbilityRequest) other;
        return k.b(this.abilityId, callToolCloudAbilityRequest.abilityId) && k.b(this.toolName, callToolCloudAbilityRequest.toolName) && k.b(this.params, callToolCloudAbilityRequest.params) && this.timeoutMillis == callToolCloudAbilityRequest.timeoutMillis && k.b(this.responseType, callToolCloudAbilityRequest.responseType) && k.b(this.traceId, callToolCloudAbilityRequest.traceId);
    }

    public final Integer getAbilityId() {
        return this.abilityId;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final String getResponseType() {
        return this.responseType;
    }

    public final long getTimeoutMillis() {
        return this.timeoutMillis;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        Integer num = this.abilityId;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.toolName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Map<String, Object> map = this.params;
        return this.traceId.hashCode() + a.c(androidx.appfunctions.metadata.a.c((iHashCode2 + (map != null ? map.hashCode() : 0)) * 31, 31, this.timeoutMillis), 31, this.responseType);
    }

    public String toString() {
        Integer num = this.abilityId;
        String str = this.toolName;
        Map<String, Object> map = this.params;
        long j5 = this.timeoutMillis;
        String str2 = this.responseType;
        String str3 = this.traceId;
        StringBuilder sb = new StringBuilder("CallToolCloudAbilityRequest(abilityId=");
        sb.append(num);
        sb.append(", toolName=");
        sb.append(str);
        sb.append(", params=");
        sb.append(map);
        sb.append(", timeoutMillis=");
        sb.append(j5);
        androidx.constraintlayout.core.dsl.a.A(sb, ", responseType=", str2, ", traceId=", str3);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ CallToolCloudAbilityRequest(Integer num, String str, Map map, long j5, String str2, String str3, int i, e eVar) {
        this(num, str, map, (i & 8) != 0 ? 60000L : j5, (i & 16) != 0 ? "CONVERT" : str2, str3);
    }
}
