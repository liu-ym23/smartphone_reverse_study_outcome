package com.stepos.agentframework.chatcore.session.list;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ConversationSessionKind;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b!\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010 \u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\"\u001a\u0004\b$\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\"\u001a\u0004\b%\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\"\u001a\u0004\b&\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b'\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010\f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\f\u0010+\u001a\u0004\b.\u0010-R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010/\u001a\u0004\b0\u00101R\u0017\u0010\u000f\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010/\u001a\u0004\b2\u00101R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u00103\u001a\u0004\b4\u00105R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u00106\u001a\u0004\b7\u00108R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0006¢\u0006\f\n\u0004\b\u0016\u00109\u001a\u0004\b:\u0010;R\u0017\u0010\u0017\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0017\u0010/\u001a\u0004\b<\u00101¨\u0006="}, d2 = {"Lcom/stepos/agentframework/chatcore/session/list/b;", "", "", "sessionId", "agentId", "deviceId", "title", "agentDisplayName", "Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;", "agentCategory", "", "createdAt", "updatedAt", "", "isRead", "sendFailed", "Lcom/stepos/agentframework/chatcore/session/ConversationSessionKind;", "sessionKind", "Lcom/stepos/agentframework/chatcore/session/list/SessionAuthorizationState;", "authorizationState", "", "Lcom/stepos/agentframework/chatcore/session/list/g;", "pendingActions", "titleLocallyFixed", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;JJZZLcom/stepos/agentframework/chatcore/session/ConversationSessionKind;Lcom/stepos/agentframework/chatcore/session/list/SessionAuthorizationState;Ljava/util/List;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "c", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_PKGNAME, "Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;", "J", "e", "()J", "l", "Z", "m", "()Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "Lcom/stepos/agentframework/chatcore/session/ConversationSessionKind;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lcom/stepos/agentframework/chatcore/session/ConversationSessionKind;", "Lcom/stepos/agentframework/chatcore/session/list/SessionAuthorizationState;", Const.INTENT_KEY_UMID, "()Lcom/stepos/agentframework/chatcore/session/list/SessionAuthorizationState;", "Ljava/util/List;", "getPendingActions", "()Ljava/util/List;", "k", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.session.list.b, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class SessionListItem {
    private final SessionAgentCategory agentCategory;
    private final String agentDisplayName;
    private final String agentId;
    private final SessionAuthorizationState authorizationState;
    private final long createdAt;
    private final String deviceId;
    private final boolean isRead;
    private final List<SessionPendingAction> pendingActions;
    private final boolean sendFailed;
    private final String sessionId;
    private final ConversationSessionKind sessionKind;
    private final String title;
    private final boolean titleLocallyFixed;
    private final long updatedAt;

    public SessionListItem(String sessionId, String agentId, String deviceId, String title, String agentDisplayName, SessionAgentCategory agentCategory, long j10, long j11, boolean z10, boolean z11, ConversationSessionKind sessionKind, SessionAuthorizationState authorizationState, List<SessionPendingAction> pendingActions, boolean z12) {
        p.i(sessionId, "sessionId");
        p.i(agentId, "agentId");
        p.i(deviceId, "deviceId");
        p.i(title, "title");
        p.i(agentDisplayName, "agentDisplayName");
        p.i(agentCategory, "agentCategory");
        p.i(sessionKind, "sessionKind");
        p.i(authorizationState, "authorizationState");
        p.i(pendingActions, "pendingActions");
        this.sessionId = sessionId;
        this.agentId = agentId;
        this.deviceId = deviceId;
        this.title = title;
        this.agentDisplayName = agentDisplayName;
        this.agentCategory = agentCategory;
        this.createdAt = j10;
        this.updatedAt = j11;
        this.isRead = z10;
        this.sendFailed = z11;
        this.sessionKind = sessionKind;
        this.authorizationState = authorizationState;
        this.pendingActions = pendingActions;
        this.titleLocallyFixed = z12;
    }

    /* renamed from: a, reason: from getter */
    public final SessionAgentCategory getAgentCategory() {
        return this.agentCategory;
    }

    /* renamed from: b, reason: from getter */
    public final String getAgentDisplayName() {
        return this.agentDisplayName;
    }

    /* renamed from: c, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: d, reason: from getter */
    public final SessionAuthorizationState getAuthorizationState() {
        return this.authorizationState;
    }

    /* renamed from: e, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionListItem)) {
            return false;
        }
        SessionListItem sessionListItem = (SessionListItem) other;
        return p.d(this.sessionId, sessionListItem.sessionId) && p.d(this.agentId, sessionListItem.agentId) && p.d(this.deviceId, sessionListItem.deviceId) && p.d(this.title, sessionListItem.title) && p.d(this.agentDisplayName, sessionListItem.agentDisplayName) && this.agentCategory == sessionListItem.agentCategory && this.createdAt == sessionListItem.createdAt && this.updatedAt == sessionListItem.updatedAt && this.isRead == sessionListItem.isRead && this.sendFailed == sessionListItem.sendFailed && this.sessionKind == sessionListItem.sessionKind && this.authorizationState == sessionListItem.authorizationState && p.d(this.pendingActions, sessionListItem.pendingActions) && this.titleLocallyFixed == sessionListItem.titleLocallyFixed;
    }

    /* renamed from: f, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getSendFailed() {
        return this.sendFailed;
    }

    /* renamed from: h, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.sessionId.hashCode() * 31) + this.agentId.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.agentDisplayName.hashCode()) * 31) + this.agentCategory.hashCode()) * 31) + Long.hashCode(this.createdAt)) * 31) + Long.hashCode(this.updatedAt)) * 31) + Boolean.hashCode(this.isRead)) * 31) + Boolean.hashCode(this.sendFailed)) * 31) + this.sessionKind.hashCode()) * 31) + this.authorizationState.hashCode()) * 31) + this.pendingActions.hashCode()) * 31) + Boolean.hashCode(this.titleLocallyFixed);
    }

    /* renamed from: i, reason: from getter */
    public final ConversationSessionKind getSessionKind() {
        return this.sessionKind;
    }

    /* renamed from: j, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getTitleLocallyFixed() {
        return this.titleLocallyFixed;
    }

    /* renamed from: l, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsRead() {
        return this.isRead;
    }

    public String toString() {
        return "SessionListItem(sessionId=" + this.sessionId + ", agentId=" + this.agentId + ", deviceId=" + this.deviceId + ", title=" + this.title + ", agentDisplayName=" + this.agentDisplayName + ", agentCategory=" + this.agentCategory + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", isRead=" + this.isRead + ", sendFailed=" + this.sendFailed + ", sessionKind=" + this.sessionKind + ", authorizationState=" + this.authorizationState + ", pendingActions=" + this.pendingActions + ", titleLocallyFixed=" + this.titleLocallyFixed + ")";
    }
}
