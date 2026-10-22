package com.stepos.agentframework.adapter.netcore;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/ToolResponse;", "", "callId", "", "response", "Lcom/stepos/agentframework/adapter/netcore/ToolResult;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/stepos/agentframework/adapter/netcore/ToolResult;)V", "getCallId", "()Ljava/lang/String;", "getResponse", "()Lcom/stepos/agentframework/adapter/netcore/ToolResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "netcore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ToolResponse {
    private final String callId;
    private final ToolResult response;

    public ToolResponse(String callId, ToolResult response) {
        k.f(callId, "callId");
        k.f(response, "response");
        this.callId = callId;
        this.response = response;
    }

    public static /* synthetic */ ToolResponse copy$default(ToolResponse toolResponse, String str, ToolResult toolResult, int i, Object obj) {
        if ((i & 1) != 0) {
            str = toolResponse.callId;
        }
        if ((i & 2) != 0) {
            toolResult = toolResponse.response;
        }
        return toolResponse.copy(str, toolResult);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCallId() {
        return this.callId;
    }

    /* renamed from: component2, reason: from getter */
    public final ToolResult getResponse() {
        return this.response;
    }

    public final ToolResponse copy(String callId, ToolResult response) {
        k.f(callId, "callId");
        k.f(response, "response");
        return new ToolResponse(callId, response);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolResponse)) {
            return false;
        }
        ToolResponse toolResponse = (ToolResponse) other;
        return k.b(this.callId, toolResponse.callId) && k.b(this.response, toolResponse.response);
    }

    public final String getCallId() {
        return this.callId;
    }

    public final ToolResult getResponse() {
        return this.response;
    }

    public int hashCode() {
        return this.response.hashCode() + (this.callId.hashCode() * 31);
    }

    public String toString() {
        return "ToolResponse(callId=" + this.callId + ", response=" + this.response + ")";
    }
}
