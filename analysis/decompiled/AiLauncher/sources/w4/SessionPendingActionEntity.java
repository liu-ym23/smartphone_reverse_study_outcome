package w4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJN\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001a\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001b\u0010\u000fR\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lw4/i;", "", "", "requestId", "sessionId", "agentId", "actionKind", "", "createdAt", "expiresAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;)Lw4/i;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_UMID, "c", "J", "e", "()J", "Ljava/lang/Long;", "f", "()Ljava/lang/Long;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: w4.i, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class SessionPendingActionEntity {
    private final String actionKind;
    private final String agentId;
    private final long createdAt;
    private final Long expiresAt;
    private final String requestId;
    private final String sessionId;

    public SessionPendingActionEntity(String requestId, String sessionId, String agentId, String actionKind, long j10, Long l10) {
        p.i(requestId, "requestId");
        p.i(sessionId, "sessionId");
        p.i(agentId, "agentId");
        p.i(actionKind, "actionKind");
        this.requestId = requestId;
        this.sessionId = sessionId;
        this.agentId = agentId;
        this.actionKind = actionKind;
        this.createdAt = j10;
        this.expiresAt = l10;
    }

    public static /* synthetic */ SessionPendingActionEntity b(SessionPendingActionEntity sessionPendingActionEntity, String str, String str2, String str3, String str4, long j10, Long l10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = sessionPendingActionEntity.requestId;
        }
        if ((i10 & 2) != 0) {
            str2 = sessionPendingActionEntity.sessionId;
        }
        if ((i10 & 4) != 0) {
            str3 = sessionPendingActionEntity.agentId;
        }
        if ((i10 & 8) != 0) {
            str4 = sessionPendingActionEntity.actionKind;
        }
        if ((i10 & 16) != 0) {
            j10 = sessionPendingActionEntity.createdAt;
        }
        if ((i10 & 32) != 0) {
            l10 = sessionPendingActionEntity.expiresAt;
        }
        Long l11 = l10;
        long j11 = j10;
        return sessionPendingActionEntity.a(str, str2, str3, str4, j11, l11);
    }

    public final SessionPendingActionEntity a(String requestId, String sessionId, String agentId, String actionKind, long createdAt, Long expiresAt) {
        p.i(requestId, "requestId");
        p.i(sessionId, "sessionId");
        p.i(agentId, "agentId");
        p.i(actionKind, "actionKind");
        return new SessionPendingActionEntity(requestId, sessionId, agentId, actionKind, createdAt, expiresAt);
    }

    /* renamed from: c, reason: from getter */
    public final String getActionKind() {
        return this.actionKind;
    }

    /* renamed from: d, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: e, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionPendingActionEntity)) {
            return false;
        }
        SessionPendingActionEntity sessionPendingActionEntity = (SessionPendingActionEntity) other;
        return p.d(this.requestId, sessionPendingActionEntity.requestId) && p.d(this.sessionId, sessionPendingActionEntity.sessionId) && p.d(this.agentId, sessionPendingActionEntity.agentId) && p.d(this.actionKind, sessionPendingActionEntity.actionKind) && this.createdAt == sessionPendingActionEntity.createdAt && p.d(this.expiresAt, sessionPendingActionEntity.expiresAt);
    }

    /* renamed from: f, reason: from getter */
    public final Long getExpiresAt() {
        return this.expiresAt;
    }

    /* renamed from: g, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    /* renamed from: h, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        int iHashCode = ((((((((this.requestId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.agentId.hashCode()) * 31) + this.actionKind.hashCode()) * 31) + Long.hashCode(this.createdAt)) * 31;
        Long l10 = this.expiresAt;
        return iHashCode + (l10 == null ? 0 : l10.hashCode());
    }

    public String toString() {
        return "SessionPendingActionEntity(requestId=" + this.requestId + ", sessionId=" + this.sessionId + ", agentId=" + this.agentId + ", actionKind=" + this.actionKind + ", createdAt=" + this.createdAt + ", expiresAt=" + this.expiresAt + ")";
    }
}
