package com.stepos.agentframework.chatcore.session;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import u4.AgentTaskEvent;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/W0;", "", "", "sessionId", "agentId", "Lw4/c;", "message", "Lu4/h;", "event", "", "emitToView", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lw4/c;Lu4/h;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "e", Const.INTENT_KEY_APIKEY, "Lw4/c;", Const.INTENT_KEY_UMID, "()Lw4/c;", "Lu4/h;", "c", "()Lu4/h;", "Z", Const.INTENT_KEY_PKGNAME, "()Z", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.W0, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class TaskMessageUpdate {
    private final String agentId;
    private final boolean emitToView;
    private final AgentTaskEvent event;
    private final ChatMessage message;
    private final String sessionId;

    public TaskMessageUpdate(String sessionId, String agentId, ChatMessage message, AgentTaskEvent event, boolean z10) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(message, "message");
        kotlin.jvm.internal.p.i(event, "event");
        this.sessionId = sessionId;
        this.agentId = agentId;
        this.message = message;
        this.event = event;
        this.emitToView = z10;
    }

    /* renamed from: a, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEmitToView() {
        return this.emitToView;
    }

    /* renamed from: c, reason: from getter */
    public final AgentTaskEvent getEvent() {
        return this.event;
    }

    /* renamed from: d, reason: from getter */
    public final ChatMessage getMessage() {
        return this.message;
    }

    /* renamed from: e, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskMessageUpdate)) {
            return false;
        }
        TaskMessageUpdate taskMessageUpdate = (TaskMessageUpdate) other;
        return kotlin.jvm.internal.p.d(this.sessionId, taskMessageUpdate.sessionId) && kotlin.jvm.internal.p.d(this.agentId, taskMessageUpdate.agentId) && kotlin.jvm.internal.p.d(this.message, taskMessageUpdate.message) && kotlin.jvm.internal.p.d(this.event, taskMessageUpdate.event) && this.emitToView == taskMessageUpdate.emitToView;
    }

    public int hashCode() {
        return (((((((this.sessionId.hashCode() * 31) + this.agentId.hashCode()) * 31) + this.message.hashCode()) * 31) + this.event.hashCode()) * 31) + Boolean.hashCode(this.emitToView);
    }

    public String toString() {
        return "TaskMessageUpdate(sessionId=" + this.sessionId + ", agentId=" + this.agentId + ", message=" + this.message + ", event=" + this.event + ", emitToView=" + this.emitToView + ")";
    }
}
