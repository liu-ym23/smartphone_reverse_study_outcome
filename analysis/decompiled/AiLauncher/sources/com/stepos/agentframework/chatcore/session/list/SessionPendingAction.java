package com.stepos.agentframework.chatcore.session.list;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\n\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\n\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/list/g;", "", "", "requestId", "sessionId", "agentId", "Lcom/stepos/agentframework/chatcore/session/list/SessionPendingActionKind;", "kind", "", "createdAt", "expiresAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/list/SessionPendingActionKind;JLjava/lang/Long;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRequestId", Const.INTENT_KEY_PKGNAME, "getAgentId", "Lcom/stepos/agentframework/chatcore/session/list/SessionPendingActionKind;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/chatcore/session/list/SessionPendingActionKind;", "J", "getCreatedAt", "()J", "Ljava/lang/Long;", "getExpiresAt", "()Ljava/lang/Long;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.list.g, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class SessionPendingAction {
    private final String agentId;
    private final long createdAt;
    private final Long expiresAt;
    private final SessionPendingActionKind kind;
    private final String requestId;
    private final String sessionId;

    public SessionPendingAction(String requestId, String sessionId, String agentId, SessionPendingActionKind kind, long j10, Long l10) {
        p.i(requestId, "requestId");
        p.i(sessionId, "sessionId");
        p.i(agentId, "agentId");
        p.i(kind, "kind");
        this.requestId = requestId;
        this.sessionId = sessionId;
        this.agentId = agentId;
        this.kind = kind;
        this.createdAt = j10;
        this.expiresAt = l10;
    }

    /* renamed from: a, reason: from getter */
    public final SessionPendingActionKind getKind() {
        return this.kind;
    }

    /* renamed from: b, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionPendingAction)) {
            return false;
        }
        SessionPendingAction sessionPendingAction = (SessionPendingAction) other;
        return p.d(this.requestId, sessionPendingAction.requestId) && p.d(this.sessionId, sessionPendingAction.sessionId) && p.d(this.agentId, sessionPendingAction.agentId) && this.kind == sessionPendingAction.kind && this.createdAt == sessionPendingAction.createdAt && p.d(this.expiresAt, sessionPendingAction.expiresAt);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.requestId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.agentId.hashCode()) * 31) + this.kind.hashCode()) * 31) + Long.hashCode(this.createdAt)) * 31;
        Long l10 = this.expiresAt;
        return iHashCode + (l10 == null ? 0 : l10.hashCode());
    }

    public String toString() {
        return "SessionPendingAction(requestId=" + this.requestId + ", sessionId=" + this.sessionId + ", agentId=" + this.agentId + ", kind=" + this.kind + ", createdAt=" + this.createdAt + ", expiresAt=" + this.expiresAt + ")";
    }
}
