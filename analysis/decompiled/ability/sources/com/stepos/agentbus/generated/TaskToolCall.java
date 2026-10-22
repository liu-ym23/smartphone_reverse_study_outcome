package com.stepos.agentbus.generated;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b\u0012\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\u0019\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bHÆ\u0003J\u0019\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bHÆ\u0003J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bHÆ\u0003J\u0089\u0001\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000bHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R!\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019¨\u0006+"}, d2 = {"Lcom/stepos/agentbus/generated/TaskToolCall;", "", "callId", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "toolName", TypedValues.CycleType.S_WAVE_PHASE, "Lcom/stepos/agentbus/generated/ToolCallPhase;", "ts", "", "args", "", "result", "extensions", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentbus/generated/ToolCallPhase;JLjava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getCallId", "()Ljava/lang/String;", "getTaskId", "getToolName", "getPhase", "()Lcom/stepos/agentbus/generated/ToolCallPhase;", "getTs", "()J", "getArgs", "()Ljava/util/Map;", "getResult", "getExtensions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskToolCall {
    private final Map<String, Object> args;
    private final String callId;
    private final Map<String, Object> extensions;
    private final ToolCallPhase phase;
    private final Map<String, Object> result;
    private final String taskId;
    private final String toolName;
    private final long ts;

    public TaskToolCall(String callId, String taskId, String toolName, ToolCallPhase phase, long j5, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Map<String, ? extends Object> map3) {
        k.f(callId, "callId");
        k.f(taskId, "taskId");
        k.f(toolName, "toolName");
        k.f(phase, "phase");
        this.callId = callId;
        this.taskId = taskId;
        this.toolName = toolName;
        this.phase = phase;
        this.ts = j5;
        this.args = map;
        this.result = map2;
        this.extensions = map3;
    }

    public static /* synthetic */ TaskToolCall copy$default(TaskToolCall taskToolCall, String str, String str2, String str3, ToolCallPhase toolCallPhase, long j5, Map map, Map map2, Map map3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = taskToolCall.callId;
        }
        if ((i & 2) != 0) {
            str2 = taskToolCall.taskId;
        }
        if ((i & 4) != 0) {
            str3 = taskToolCall.toolName;
        }
        if ((i & 8) != 0) {
            toolCallPhase = taskToolCall.phase;
        }
        if ((i & 16) != 0) {
            j5 = taskToolCall.ts;
        }
        if ((i & 32) != 0) {
            map = taskToolCall.args;
        }
        if ((i & 64) != 0) {
            map2 = taskToolCall.result;
        }
        if ((i & 128) != 0) {
            map3 = taskToolCall.extensions;
        }
        Map map4 = map3;
        Map map5 = map;
        long j6 = j5;
        String str4 = str3;
        ToolCallPhase toolCallPhase2 = toolCallPhase;
        return taskToolCall.copy(str, str2, str4, toolCallPhase2, j6, map5, map2, map4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCallId() {
        return this.callId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component4, reason: from getter */
    public final ToolCallPhase getPhase() {
        return this.phase;
    }

    /* renamed from: component5, reason: from getter */
    public final long getTs() {
        return this.ts;
    }

    public final Map<String, Object> component6() {
        return this.args;
    }

    public final Map<String, Object> component7() {
        return this.result;
    }

    public final Map<String, Object> component8() {
        return this.extensions;
    }

    public final TaskToolCall copy(String callId, String taskId, String toolName, ToolCallPhase phase, long ts, Map<String, ? extends Object> args, Map<String, ? extends Object> result, Map<String, ? extends Object> extensions) {
        k.f(callId, "callId");
        k.f(taskId, "taskId");
        k.f(toolName, "toolName");
        k.f(phase, "phase");
        return new TaskToolCall(callId, taskId, toolName, phase, ts, args, result, extensions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskToolCall)) {
            return false;
        }
        TaskToolCall taskToolCall = (TaskToolCall) other;
        return k.b(this.callId, taskToolCall.callId) && k.b(this.taskId, taskToolCall.taskId) && k.b(this.toolName, taskToolCall.toolName) && this.phase == taskToolCall.phase && this.ts == taskToolCall.ts && k.b(this.args, taskToolCall.args) && k.b(this.result, taskToolCall.result) && k.b(this.extensions, taskToolCall.extensions);
    }

    public final Map<String, Object> getArgs() {
        return this.args;
    }

    public final String getCallId() {
        return this.callId;
    }

    public final Map<String, Object> getExtensions() {
        return this.extensions;
    }

    public final ToolCallPhase getPhase() {
        return this.phase;
    }

    public final Map<String, Object> getResult() {
        return this.result;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public final long getTs() {
        return this.ts;
    }

    public int hashCode() {
        int iC = androidx.appfunctions.metadata.a.c((this.phase.hashCode() + B7.a.c(B7.a.c(this.callId.hashCode() * 31, 31, this.taskId), 31, this.toolName)) * 31, 31, this.ts);
        Map<String, Object> map = this.args;
        int iHashCode = (iC + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, Object> map2 = this.result;
        int iHashCode2 = (iHashCode + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, Object> map3 = this.extensions;
        return iHashCode2 + (map3 != null ? map3.hashCode() : 0);
    }

    public String toString() {
        String str = this.callId;
        String str2 = this.taskId;
        String str3 = this.toolName;
        ToolCallPhase toolCallPhase = this.phase;
        long j5 = this.ts;
        Map<String, Object> map = this.args;
        Map<String, Object> map2 = this.result;
        Map<String, Object> map3 = this.extensions;
        StringBuilder sbW = B7.a.w("TaskToolCall(callId=", str, ", taskId=", str2, ", toolName=");
        sbW.append(str3);
        sbW.append(", phase=");
        sbW.append(toolCallPhase);
        sbW.append(", ts=");
        sbW.append(j5);
        sbW.append(", args=");
        sbW.append(map);
        sbW.append(", result=");
        sbW.append(map2);
        sbW.append(", extensions=");
        sbW.append(map3);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ TaskToolCall(String str, String str2, String str3, ToolCallPhase toolCallPhase, long j5, Map map, Map map2, Map map3, int i, e eVar) {
        this(str, str2, str3, toolCallPhase, j5, (i & 32) != 0 ? null : map, (i & 64) != 0 ? null : map2, (i & 128) != 0 ? null : map3);
    }
}
