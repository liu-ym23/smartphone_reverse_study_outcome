package com.stepos.agentframework.adapter.agentspace;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ja\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006%"}, d2 = {"Lcom/stepos/agentframework/adapter/agentspace/AgentSpaceVoteRequest;", "", AgentBusWakeContract.EXTRA_TRACE_ID, "", "sessionId", "msgId", Key.KEY_TOOL_CALL_ID, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "voteType", "type", "description", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTraceId", "()Ljava/lang/String;", "getSessionId", "getMsgId", "getToolCallId", "getTaskId", "getVoteType", "getType", "getDescription", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AgentSpaceVoteRequest {
    private final String description;
    private final String msgId;
    private final String sessionId;
    private final String taskId;
    private final String toolCallId;
    private final String traceId;
    private final String type;
    private final String voteType;

    public AgentSpaceVoteRequest(String traceId, String sessionId, String str, String str2, String taskId, String voteType, String str3, String str4) {
        k.f(traceId, "traceId");
        k.f(sessionId, "sessionId");
        k.f(taskId, "taskId");
        k.f(voteType, "voteType");
        this.traceId = traceId;
        this.sessionId = sessionId;
        this.msgId = str;
        this.toolCallId = str2;
        this.taskId = taskId;
        this.voteType = voteType;
        this.type = str3;
        this.description = str4;
    }

    public static /* synthetic */ AgentSpaceVoteRequest copy$default(AgentSpaceVoteRequest agentSpaceVoteRequest, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            str = agentSpaceVoteRequest.traceId;
        }
        if ((i & 2) != 0) {
            str2 = agentSpaceVoteRequest.sessionId;
        }
        if ((i & 4) != 0) {
            str3 = agentSpaceVoteRequest.msgId;
        }
        if ((i & 8) != 0) {
            str4 = agentSpaceVoteRequest.toolCallId;
        }
        if ((i & 16) != 0) {
            str5 = agentSpaceVoteRequest.taskId;
        }
        if ((i & 32) != 0) {
            str6 = agentSpaceVoteRequest.voteType;
        }
        if ((i & 64) != 0) {
            str7 = agentSpaceVoteRequest.type;
        }
        if ((i & 128) != 0) {
            str8 = agentSpaceVoteRequest.description;
        }
        String str9 = str7;
        String str10 = str8;
        String str11 = str5;
        String str12 = str6;
        return agentSpaceVoteRequest.copy(str, str2, str3, str4, str11, str12, str9, str10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getVoteType() {
        return this.voteType;
    }

    /* renamed from: component7, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component8, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final AgentSpaceVoteRequest copy(String traceId, String sessionId, String msgId, String toolCallId, String taskId, String voteType, String type, String description) {
        k.f(traceId, "traceId");
        k.f(sessionId, "sessionId");
        k.f(taskId, "taskId");
        k.f(voteType, "voteType");
        return new AgentSpaceVoteRequest(traceId, sessionId, msgId, toolCallId, taskId, voteType, type, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentSpaceVoteRequest)) {
            return false;
        }
        AgentSpaceVoteRequest agentSpaceVoteRequest = (AgentSpaceVoteRequest) other;
        return k.b(this.traceId, agentSpaceVoteRequest.traceId) && k.b(this.sessionId, agentSpaceVoteRequest.sessionId) && k.b(this.msgId, agentSpaceVoteRequest.msgId) && k.b(this.toolCallId, agentSpaceVoteRequest.toolCallId) && k.b(this.taskId, agentSpaceVoteRequest.taskId) && k.b(this.voteType, agentSpaceVoteRequest.voteType) && k.b(this.type, agentSpaceVoteRequest.type) && k.b(this.description, agentSpaceVoteRequest.description);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getToolCallId() {
        return this.toolCallId;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final String getType() {
        return this.type;
    }

    public final String getVoteType() {
        return this.voteType;
    }

    public int hashCode() {
        int iC = a.c(this.traceId.hashCode() * 31, 31, this.sessionId);
        String str = this.msgId;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.toolCallId;
        int iC2 = a.c(a.c((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.taskId), 31, this.voteType);
        String str3 = this.type;
        int iHashCode2 = (iC2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.description;
        return iHashCode2 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        String str = this.traceId;
        String str2 = this.sessionId;
        String str3 = this.msgId;
        String str4 = this.toolCallId;
        String str5 = this.taskId;
        String str6 = this.voteType;
        String str7 = this.type;
        String str8 = this.description;
        StringBuilder sbW = a.w("AgentSpaceVoteRequest(traceId=", str, ", sessionId=", str2, ", msgId=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", toolCallId=", str4, ", taskId=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str5, ", voteType=", str6, ", type=");
        return androidx.appfunctions.metadata.a.p(sbW, str7, ", description=", str8, ")");
    }

    public /* synthetic */ AgentSpaceVoteRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, e eVar) {
        this(str, str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, str5, str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8);
    }
}
