package com.stepos.agentframework.chatcore.search;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.core.ability.converter.BundleContentBridge;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001a\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001b\u0010\u000eR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001f\u0010\u000e¨\u0006 "}, d2 = {"Lcom/stepos/agentframework/chatcore/search/g;", "", "", "messageId", "sessionId", "agentId", BundleContentBridge.KEY_ROLE, "text", "", "updatedAt", "status", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMessageId", Const.INTENT_KEY_APIKEY, "getAgentId", "getRole", Const.INTENT_KEY_PKGNAME, "J", "c", "()J", "getStatus", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.search.g, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class MessageSearchHit {
    private final String agentId;
    private final String messageId;
    private final String role;
    private final String sessionId;
    private final String status;
    private final String text;
    private final long updatedAt;

    public MessageSearchHit(String messageId, String sessionId, String agentId, String role, String text, long j10, String status) {
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(role, "role");
        kotlin.jvm.internal.p.i(text, "text");
        kotlin.jvm.internal.p.i(status, "status");
        this.messageId = messageId;
        this.sessionId = sessionId;
        this.agentId = agentId;
        this.role = role;
        this.text = text;
        this.updatedAt = j10;
        this.status = status;
    }

    /* renamed from: a, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: b, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: c, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageSearchHit)) {
            return false;
        }
        MessageSearchHit messageSearchHit = (MessageSearchHit) other;
        return kotlin.jvm.internal.p.d(this.messageId, messageSearchHit.messageId) && kotlin.jvm.internal.p.d(this.sessionId, messageSearchHit.sessionId) && kotlin.jvm.internal.p.d(this.agentId, messageSearchHit.agentId) && kotlin.jvm.internal.p.d(this.role, messageSearchHit.role) && kotlin.jvm.internal.p.d(this.text, messageSearchHit.text) && this.updatedAt == messageSearchHit.updatedAt && kotlin.jvm.internal.p.d(this.status, messageSearchHit.status);
    }

    public int hashCode() {
        return (((((((((((this.messageId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.agentId.hashCode()) * 31) + this.role.hashCode()) * 31) + this.text.hashCode()) * 31) + Long.hashCode(this.updatedAt)) * 31) + this.status.hashCode();
    }

    public String toString() {
        return "MessageSearchHit(messageId=" + this.messageId + ", sessionId=" + this.sessionId + ", agentId=" + this.agentId + ", role=" + this.role + ", text=" + this.text + ", updatedAt=" + this.updatedAt + ", status=" + this.status + ")";
    }
}
