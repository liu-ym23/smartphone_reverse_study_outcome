package com.stepos.ability.report.event;

import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/stepos/ability/report/event/IToolCallEvent;", "", AgentBusWakeContract.EXTRA_TRACE_ID, "", "getTraceId", "()Ljava/lang/String;", Key.KEY_TOOL_CALL_ID, "getToolCallId", "toolName", "getToolName", "toolId", "getToolId", "callType", "Lcom/stepos/ability/report/event/CallType;", "getCallType", "()Lcom/stepos/ability/report/event/CallType;", "sessionId", "getSessionId", "report_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IToolCallEvent {
    CallType getCallType();

    String getSessionId();

    String getToolCallId();

    String getToolId();

    String getToolName();

    String getTraceId();
}
