package com.stepos.agentcache.sdk.api;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/stepos/agentcache/sdk/api/AgentCacheSendResult;", "", "success", "", "reason", "", DidiCardProvider.KEY_TRACE_ID, "<init>", "(ZLjava/lang/String;Ljava/lang/String;)V", "getSuccess", "()Z", "getReason", "()Ljava/lang/String;", "getTraceId", "component1", "component2", "component3", ChatTracker.CLICK_COPY, "equals", "other", "hashCode", "", "toString", "sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AgentCacheSendResult {
    private final String reason;
    private final boolean success;
    private final String traceId;

    public AgentCacheSendResult(boolean z10, String reason, String str) {
        p.i(reason, "reason");
        this.success = z10;
        this.reason = reason;
        this.traceId = str;
    }

    public static /* synthetic */ AgentCacheSendResult copy$default(AgentCacheSendResult agentCacheSendResult, boolean z10, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = agentCacheSendResult.success;
        }
        if ((i10 & 2) != 0) {
            str = agentCacheSendResult.reason;
        }
        if ((i10 & 4) != 0) {
            str2 = agentCacheSendResult.traceId;
        }
        return agentCacheSendResult.copy(z10, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    /* renamed from: component2, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    public final AgentCacheSendResult copy(boolean success, String reason, String traceId) {
        p.i(reason, "reason");
        return new AgentCacheSendResult(success, reason, traceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentCacheSendResult)) {
            return false;
        }
        AgentCacheSendResult agentCacheSendResult = (AgentCacheSendResult) other;
        return this.success == agentCacheSendResult.success && p.d(this.reason, agentCacheSendResult.reason) && p.d(this.traceId, agentCacheSendResult.traceId);
    }

    public final String getReason() {
        return this.reason;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int iHashCode = ((Boolean.hashCode(this.success) * 31) + this.reason.hashCode()) * 31;
        String str = this.traceId;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "AgentCacheSendResult(success=" + this.success + ", reason=" + this.reason + ", traceId=" + this.traceId + ")";
    }

    public /* synthetic */ AgentCacheSendResult(boolean z10, String str, String str2, int i10, i iVar) {
        this(z10, str, (i10 & 4) != 0 ? null : str2);
    }
}
