package com.stepos.ability.report.event;

import B7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u001a\u001a\u00020\u0003H\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\fHÆ\u0003JY\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\fHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\t\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/stepos/ability/report/event/ToolCallRequestEvent;", "Lcom/stepos/ability/report/event/IToolCallEvent;", AgentBusWakeContract.EXTRA_TRACE_ID, "", Key.KEY_TOOL_CALL_ID, "toolName", "toolId", "callType", "Lcom/stepos/ability/report/event/CallType;", "sessionId", "input", "statusCode", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ability/report/event/CallType;Ljava/lang/String;Ljava/lang/String;I)V", "getTraceId", "()Ljava/lang/String;", "getToolCallId", "getToolName", "getToolId", "getCallType", "()Lcom/stepos/ability/report/event/CallType;", "getSessionId", "getInput", "getStatusCode", "()I", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "report_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToolCallRequestEvent implements IToolCallEvent {
    private final CallType callType;
    private final String input;
    private final String sessionId;
    private final int statusCode;
    private final String toolCallId;
    private final String toolId;
    private final String toolName;
    private final String traceId;

    public ToolCallRequestEvent(String traceId, String toolCallId, String toolName, String toolId, CallType callType, String sessionId, String input, int i) {
        k.f(traceId, "traceId");
        k.f(toolCallId, "toolCallId");
        k.f(toolName, "toolName");
        k.f(toolId, "toolId");
        k.f(callType, "callType");
        k.f(sessionId, "sessionId");
        k.f(input, "input");
        this.traceId = traceId;
        this.toolCallId = toolCallId;
        this.toolName = toolName;
        this.toolId = toolId;
        this.callType = callType;
        this.sessionId = sessionId;
        this.input = input;
        this.statusCode = i;
    }

    public static /* synthetic */ ToolCallRequestEvent copy$default(ToolCallRequestEvent toolCallRequestEvent, String str, String str2, String str3, String str4, CallType callType, String str5, String str6, int i, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = toolCallRequestEvent.traceId;
        }
        if ((i6 & 2) != 0) {
            str2 = toolCallRequestEvent.toolCallId;
        }
        if ((i6 & 4) != 0) {
            str3 = toolCallRequestEvent.toolName;
        }
        if ((i6 & 8) != 0) {
            str4 = toolCallRequestEvent.toolId;
        }
        if ((i6 & 16) != 0) {
            callType = toolCallRequestEvent.callType;
        }
        if ((i6 & 32) != 0) {
            str5 = toolCallRequestEvent.sessionId;
        }
        if ((i6 & 64) != 0) {
            str6 = toolCallRequestEvent.input;
        }
        if ((i6 & 128) != 0) {
            i = toolCallRequestEvent.statusCode;
        }
        String str7 = str6;
        int i10 = i;
        CallType callType2 = callType;
        String str8 = str5;
        return toolCallRequestEvent.copy(str, str2, str3, str4, callType2, str8, str7, i10);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getToolId() {
        return this.toolId;
    }

    /* renamed from: component5, reason: from getter */
    public final CallType getCallType() {
        return this.callType;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getInput() {
        return this.input;
    }

    /* renamed from: component8, reason: from getter */
    public final int getStatusCode() {
        return this.statusCode;
    }

    public final ToolCallRequestEvent copy(String traceId, String toolCallId, String toolName, String toolId, CallType callType, String sessionId, String input, int statusCode) {
        k.f(traceId, "traceId");
        k.f(toolCallId, "toolCallId");
        k.f(toolName, "toolName");
        k.f(toolId, "toolId");
        k.f(callType, "callType");
        k.f(sessionId, "sessionId");
        k.f(input, "input");
        return new ToolCallRequestEvent(traceId, toolCallId, toolName, toolId, callType, sessionId, input, statusCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolCallRequestEvent)) {
            return false;
        }
        ToolCallRequestEvent toolCallRequestEvent = (ToolCallRequestEvent) other;
        return k.b(this.traceId, toolCallRequestEvent.traceId) && k.b(this.toolCallId, toolCallRequestEvent.toolCallId) && k.b(this.toolName, toolCallRequestEvent.toolName) && k.b(this.toolId, toolCallRequestEvent.toolId) && this.callType == toolCallRequestEvent.callType && k.b(this.sessionId, toolCallRequestEvent.sessionId) && k.b(this.input, toolCallRequestEvent.input) && this.statusCode == toolCallRequestEvent.statusCode;
    }

    @Override // com.stepos.ability.report.event.IToolCallEvent
    public CallType getCallType() {
        return this.callType;
    }

    public final String getInput() {
        return this.input;
    }

    @Override // com.stepos.ability.report.event.IToolCallEvent
    public String getSessionId() {
        return this.sessionId;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    @Override // com.stepos.ability.report.event.IToolCallEvent
    public String getToolCallId() {
        return this.toolCallId;
    }

    @Override // com.stepos.ability.report.event.IToolCallEvent
    public String getToolId() {
        return this.toolId;
    }

    @Override // com.stepos.ability.report.event.IToolCallEvent
    public String getToolName() {
        return this.toolName;
    }

    @Override // com.stepos.ability.report.event.IToolCallEvent
    public String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        return Integer.hashCode(this.statusCode) + a.c(a.c((this.callType.hashCode() + a.c(a.c(a.c(this.traceId.hashCode() * 31, 31, this.toolCallId), 31, this.toolName), 31, this.toolId)) * 31, 31, this.sessionId), 31, this.input);
    }

    public String toString() {
        String traceId = getTraceId();
        String toolCallId = getToolCallId();
        String toolName = getToolName();
        String toolId = getToolId();
        CallType callType = getCallType();
        String sessionId = getSessionId();
        int i = this.statusCode;
        StringBuilder sbW = a.w("ToolCallRequestEvent(traceId=", traceId, ", toolCallId=", toolCallId, ", toolName=");
        androidx.constraintlayout.core.dsl.a.A(sbW, toolName, ", toolId=", toolId, ", callType=");
        sbW.append(callType);
        sbW.append(", sessionId=");
        sbW.append(sessionId);
        sbW.append(", input=<redacted>, statusCode=");
        return androidx.appfunctions.metadata.a.o(sbW, ")", i);
    }

    public /* synthetic */ ToolCallRequestEvent(String str, String str2, String str3, String str4, CallType callType, String str5, String str6, int i, int i6, e eVar) {
        this(str, str2, str3, str4, callType, str5, (i6 & 64) != 0 ? "{}" : str6, (i6 & 128) != 0 ? 200 : i);
    }
}
