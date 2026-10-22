package com.stepos.agentframework.adapter.netcore;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/E;", "", "", "callId", "Lcom/stepos/agentframework/adapter/netcore/F;", UxipConstants.f30685x, "<init>", "(Ljava/lang/String;Lcom/stepos/agentframework/adapter/netcore/F;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/agentframework/adapter/netcore/F;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/adapter/netcore/F;", "protocol_netcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.netcore.E, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class ToolResponse {
    private final String callId;
    private final ToolResult response;

    public ToolResponse(String callId, ToolResult response) {
        kotlin.jvm.internal.p.i(callId, "callId");
        kotlin.jvm.internal.p.i(response, "response");
        this.callId = callId;
        this.response = response;
    }

    /* renamed from: a, reason: from getter */
    public final String getCallId() {
        return this.callId;
    }

    /* renamed from: b, reason: from getter */
    public final ToolResult getResponse() {
        return this.response;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ToolResponse)) {
            return false;
        }
        ToolResponse toolResponse = (ToolResponse) other;
        return kotlin.jvm.internal.p.d(this.callId, toolResponse.callId) && kotlin.jvm.internal.p.d(this.response, toolResponse.response);
    }

    public int hashCode() {
        return (this.callId.hashCode() * 31) + this.response.hashCode();
    }

    public String toString() {
        return "ToolResponse(callId=" + this.callId + ", response=" + this.response + ")";
    }
}
