package w4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.ability.converter.BundleContentBridge;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001a\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001b\u0010\u000eR\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001f\u0010\u000e¨\u0006 "}, d2 = {"Lw4/g;", "", "", "messageId", "sessionId", "agentId", BundleContentBridge.KEY_ROLE, "searchableText", "", "updatedAt", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "e", Const.INTENT_KEY_APIKEY, "c", Const.INTENT_KEY_UMID, "J", Const.INTENT_KEY_BACKGROUND_COMMAND, "()J", "f", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: w4.g, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class MessageSearchProjectionEntity {
    private final String agentId;
    private final String messageId;
    private final String role;
    private final String searchableText;
    private final String sessionId;
    private final String status;
    private final long updatedAt;

    public MessageSearchProjectionEntity(String messageId, String sessionId, String agentId, String role, String searchableText, long j10, String status) {
        p.i(messageId, "messageId");
        p.i(sessionId, "sessionId");
        p.i(agentId, "agentId");
        p.i(role, "role");
        p.i(searchableText, "searchableText");
        p.i(status, "status");
        this.messageId = messageId;
        this.sessionId = sessionId;
        this.agentId = agentId;
        this.role = role;
        this.searchableText = searchableText;
        this.updatedAt = j10;
        this.status = status;
    }

    /* renamed from: a, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: b, reason: from getter */
    public final String getMessageId() {
        return this.messageId;
    }

    /* renamed from: c, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: d, reason: from getter */
    public final String getSearchableText() {
        return this.searchableText;
    }

    /* renamed from: e, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageSearchProjectionEntity)) {
            return false;
        }
        MessageSearchProjectionEntity messageSearchProjectionEntity = (MessageSearchProjectionEntity) other;
        return p.d(this.messageId, messageSearchProjectionEntity.messageId) && p.d(this.sessionId, messageSearchProjectionEntity.sessionId) && p.d(this.agentId, messageSearchProjectionEntity.agentId) && p.d(this.role, messageSearchProjectionEntity.role) && p.d(this.searchableText, messageSearchProjectionEntity.searchableText) && this.updatedAt == messageSearchProjectionEntity.updatedAt && p.d(this.status, messageSearchProjectionEntity.status);
    }

    /* renamed from: f, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: g, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        return (((((((((((this.messageId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.agentId.hashCode()) * 31) + this.role.hashCode()) * 31) + this.searchableText.hashCode()) * 31) + Long.hashCode(this.updatedAt)) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "MessageSearchProjectionEntity(messageId=" + this.messageId + ", sessionId=" + this.sessionId + ", agentId=" + this.agentId + ", role=" + this.role + ", searchableText=" + this.searchableText + ", updatedAt=" + this.updatedAt + ", status=" + this.status + ")";
    }
}
