package com.stepos.agentframework.adapter.agentbus;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\b\u0080\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u0010R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001a\u0010\u0010R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001b\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\t\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0017\u0010\n\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010\u001c\u001a\u0004\b \u0010\u001eR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/a;", "", "", "sessionId", "chatId", "outboundId", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "", "finished", "cancelled", "waitingEmptyTerminal", "", "createdAtMs", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZJ)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_PKGNAME, "e", "f", "Z", Const.INTENT_KEY_UMID, "()Z", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "J", "c", "()J", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.adapter.agentbus.a, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class ActiveChatSnapshot {
    private final boolean cancelled;
    private final String chatId;
    private final long createdAtMs;
    private final boolean finished;
    private final String outboundId;
    private final String runId;
    private final String sessionId;
    private final boolean waitingEmptyTerminal;

    public ActiveChatSnapshot(String sessionId, String chatId, String str, String str2, boolean z10, boolean z11, boolean z12, long j10) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(chatId, "chatId");
        this.sessionId = sessionId;
        this.chatId = chatId;
        this.outboundId = str;
        this.runId = str2;
        this.finished = z10;
        this.cancelled = z11;
        this.waitingEmptyTerminal = z12;
        this.createdAtMs = j10;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getCancelled() {
        return this.cancelled;
    }

    /* renamed from: b, reason: from getter */
    public final String getChatId() {
        return this.chatId;
    }

    /* renamed from: c, reason: from getter */
    public final long getCreatedAtMs() {
        return this.createdAtMs;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getFinished() {
        return this.finished;
    }

    /* renamed from: e, reason: from getter */
    public final String getOutboundId() {
        return this.outboundId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActiveChatSnapshot)) {
            return false;
        }
        ActiveChatSnapshot activeChatSnapshot = (ActiveChatSnapshot) other;
        return kotlin.jvm.internal.p.d(this.sessionId, activeChatSnapshot.sessionId) && kotlin.jvm.internal.p.d(this.chatId, activeChatSnapshot.chatId) && kotlin.jvm.internal.p.d(this.outboundId, activeChatSnapshot.outboundId) && kotlin.jvm.internal.p.d(this.runId, activeChatSnapshot.runId) && this.finished == activeChatSnapshot.finished && this.cancelled == activeChatSnapshot.cancelled && this.waitingEmptyTerminal == activeChatSnapshot.waitingEmptyTerminal && this.createdAtMs == activeChatSnapshot.createdAtMs;
    }

    /* renamed from: f, reason: from getter */
    public final String getRunId() {
        return this.runId;
    }

    /* renamed from: g, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getWaitingEmptyTerminal() {
        return this.waitingEmptyTerminal;
    }

    public int hashCode() {
        int iHashCode = ((this.sessionId.hashCode() * 31) + this.chatId.hashCode()) * 31;
        String str = this.outboundId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.runId;
        return ((((((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Boolean.hashCode(this.finished)) * 31) + Boolean.hashCode(this.cancelled)) * 31) + Boolean.hashCode(this.waitingEmptyTerminal)) * 31) + Long.hashCode(this.createdAtMs);
    }

    public String toString() {
        return "ActiveChatSnapshot(sessionId=" + this.sessionId + ", chatId=" + this.chatId + ", outboundId=" + this.outboundId + ", runId=" + this.runId + ", finished=" + this.finished + ", cancelled=" + this.cancelled + ", waitingEmptyTerminal=" + this.waitingEmptyTerminal + ", createdAtMs=" + this.createdAtMs + ")";
    }
}
