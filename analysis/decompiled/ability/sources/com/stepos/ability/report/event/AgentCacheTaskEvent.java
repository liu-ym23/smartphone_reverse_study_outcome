package com.stepos.ability.report.event;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JN\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006#"}, d2 = {"Lcom/stepos/ability/report/event/AgentCacheTaskEvent;", "", AgentBusWakeContract.EXTRA_TRACE_ID, "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "type", "complete", "", "success", "msgType", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;)V", "getTraceId", "()Ljava/lang/String;", "getTaskId", "getType", "getComplete", "()Z", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMsgType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/String;)Lcom/stepos/ability/report/event/AgentCacheTaskEvent;", "equals", "other", "hashCode", "", "toString", "report_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AgentCacheTaskEvent {
    private final boolean complete;
    private final String msgType;
    private final Boolean success;
    private final String taskId;
    private final String traceId;
    private final String type;

    public AgentCacheTaskEvent(String str, String taskId, String type, boolean z10, Boolean bool, String msgType) {
        k.f(taskId, "taskId");
        k.f(type, "type");
        k.f(msgType, "msgType");
        this.traceId = str;
        this.taskId = taskId;
        this.type = type;
        this.complete = z10;
        this.success = bool;
        this.msgType = msgType;
    }

    public static /* synthetic */ AgentCacheTaskEvent copy$default(AgentCacheTaskEvent agentCacheTaskEvent, String str, String str2, String str3, boolean z10, Boolean bool, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = agentCacheTaskEvent.traceId;
        }
        if ((i & 2) != 0) {
            str2 = agentCacheTaskEvent.taskId;
        }
        if ((i & 4) != 0) {
            str3 = agentCacheTaskEvent.type;
        }
        if ((i & 8) != 0) {
            z10 = agentCacheTaskEvent.complete;
        }
        if ((i & 16) != 0) {
            bool = agentCacheTaskEvent.success;
        }
        if ((i & 32) != 0) {
            str4 = agentCacheTaskEvent.msgType;
        }
        Boolean bool2 = bool;
        String str5 = str4;
        return agentCacheTaskEvent.copy(str, str2, str3, z10, bool2, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getComplete() {
        return this.complete;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMsgType() {
        return this.msgType;
    }

    public final AgentCacheTaskEvent copy(String traceId, String taskId, String type, boolean complete, Boolean success, String msgType) {
        k.f(taskId, "taskId");
        k.f(type, "type");
        k.f(msgType, "msgType");
        return new AgentCacheTaskEvent(traceId, taskId, type, complete, success, msgType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentCacheTaskEvent)) {
            return false;
        }
        AgentCacheTaskEvent agentCacheTaskEvent = (AgentCacheTaskEvent) other;
        return k.b(this.traceId, agentCacheTaskEvent.traceId) && k.b(this.taskId, agentCacheTaskEvent.taskId) && k.b(this.type, agentCacheTaskEvent.type) && this.complete == agentCacheTaskEvent.complete && k.b(this.success, agentCacheTaskEvent.success) && k.b(this.msgType, agentCacheTaskEvent.msgType);
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final String getMsgType() {
        return this.msgType;
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.traceId;
        int iD = a.d(B7.a.c(B7.a.c((str == null ? 0 : str.hashCode()) * 31, 31, this.taskId), 31, this.type), 31, this.complete);
        Boolean bool = this.success;
        return this.msgType.hashCode() + ((iD + (bool != null ? bool.hashCode() : 0)) * 31);
    }

    public String toString() {
        String str = this.traceId;
        String str2 = this.taskId;
        String str3 = this.type;
        boolean z10 = this.complete;
        Boolean bool = this.success;
        String str4 = this.msgType;
        StringBuilder sbW = B7.a.w("AgentCacheTaskEvent(traceId=", str, ", taskId=", str2, ", type=");
        sbW.append(str3);
        sbW.append(", complete=");
        sbW.append(z10);
        sbW.append(", success=");
        sbW.append(bool);
        sbW.append(", msgType=");
        sbW.append(str4);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ AgentCacheTaskEvent(String str, String str2, String str3, boolean z10, Boolean bool, String str4, int i, e eVar) {
        this(str, str2, str3, z10, (i & 16) != 0 ? null : bool, str4);
    }
}
