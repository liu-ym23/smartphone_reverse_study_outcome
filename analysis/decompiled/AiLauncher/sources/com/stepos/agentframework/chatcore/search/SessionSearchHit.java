package com.stepos.agentframework.chatcore.search;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.list.SessionAgentCategory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011Jt\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001e\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001c\u001a\u0004\b\u001f\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b \u0010\u0015R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b$\u0010\u0015R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010(\u001a\u0004\b\r\u0010)R\u0017\u0010\u000e\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b*\u0010)R\u0017\u0010\u000f\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b+\u0010\u0015¨\u0006,"}, d2 = {"Lcom/stepos/agentframework/chatcore/search/m;", "", "", "sessionId", "agentId", "deviceId", "agentDisplayName", "Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;", "agentCategory", "title", "", "updatedAt", "", "isRead", "sendFailed", "previewText", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;Ljava/lang/String;JZZLjava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;Ljava/lang/String;JZZLjava/lang/String;)Lcom/stepos/agentframework/chatcore/search/m;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "e", "f", Const.INTENT_KEY_UMID, "Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;", "c", "()Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "J", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()J", "Z", "()Z", "getSendFailed", Const.INTENT_KEY_BACKGROUND_COMMAND, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.search.m, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class SessionSearchHit {
    private final SessionAgentCategory agentCategory;
    private final String agentDisplayName;
    private final String agentId;
    private final String deviceId;
    private final boolean isRead;
    private final String previewText;
    private final boolean sendFailed;
    private final String sessionId;
    private final String title;
    private final long updatedAt;

    public SessionSearchHit(String sessionId, String agentId, String deviceId, String agentDisplayName, SessionAgentCategory agentCategory, String title, long j10, boolean z10, boolean z11, String previewText) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agentDisplayName, "agentDisplayName");
        kotlin.jvm.internal.p.i(agentCategory, "agentCategory");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(previewText, "previewText");
        this.sessionId = sessionId;
        this.agentId = agentId;
        this.deviceId = deviceId;
        this.agentDisplayName = agentDisplayName;
        this.agentCategory = agentCategory;
        this.title = title;
        this.updatedAt = j10;
        this.isRead = z10;
        this.sendFailed = z11;
        this.previewText = previewText;
    }

    public static /* synthetic */ SessionSearchHit b(SessionSearchHit sessionSearchHit, String str, String str2, String str3, String str4, SessionAgentCategory sessionAgentCategory, String str5, long j10, boolean z10, boolean z11, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = sessionSearchHit.sessionId;
        }
        if ((i10 & 2) != 0) {
            str2 = sessionSearchHit.agentId;
        }
        if ((i10 & 4) != 0) {
            str3 = sessionSearchHit.deviceId;
        }
        if ((i10 & 8) != 0) {
            str4 = sessionSearchHit.agentDisplayName;
        }
        if ((i10 & 16) != 0) {
            sessionAgentCategory = sessionSearchHit.agentCategory;
        }
        if ((i10 & 32) != 0) {
            str5 = sessionSearchHit.title;
        }
        if ((i10 & 64) != 0) {
            j10 = sessionSearchHit.updatedAt;
        }
        if ((i10 & 128) != 0) {
            z10 = sessionSearchHit.isRead;
        }
        if ((i10 & 256) != 0) {
            z11 = sessionSearchHit.sendFailed;
        }
        if ((i10 & 512) != 0) {
            str6 = sessionSearchHit.previewText;
        }
        String str7 = str6;
        boolean z12 = z10;
        long j11 = j10;
        SessionAgentCategory sessionAgentCategory2 = sessionAgentCategory;
        String str8 = str5;
        String str9 = str3;
        String str10 = str4;
        return sessionSearchHit.a(str, str2, str9, str10, sessionAgentCategory2, str8, j11, z12, z11, str7);
    }

    public final SessionSearchHit a(String sessionId, String agentId, String deviceId, String agentDisplayName, SessionAgentCategory agentCategory, String title, long updatedAt, boolean isRead, boolean sendFailed, String previewText) {
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agentDisplayName, "agentDisplayName");
        kotlin.jvm.internal.p.i(agentCategory, "agentCategory");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(previewText, "previewText");
        return new SessionSearchHit(sessionId, agentId, deviceId, agentDisplayName, agentCategory, title, updatedAt, isRead, sendFailed, previewText);
    }

    /* renamed from: c, reason: from getter */
    public final SessionAgentCategory getAgentCategory() {
        return this.agentCategory;
    }

    /* renamed from: d, reason: from getter */
    public final String getAgentDisplayName() {
        return this.agentDisplayName;
    }

    /* renamed from: e, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionSearchHit)) {
            return false;
        }
        SessionSearchHit sessionSearchHit = (SessionSearchHit) other;
        return kotlin.jvm.internal.p.d(this.sessionId, sessionSearchHit.sessionId) && kotlin.jvm.internal.p.d(this.agentId, sessionSearchHit.agentId) && kotlin.jvm.internal.p.d(this.deviceId, sessionSearchHit.deviceId) && kotlin.jvm.internal.p.d(this.agentDisplayName, sessionSearchHit.agentDisplayName) && this.agentCategory == sessionSearchHit.agentCategory && kotlin.jvm.internal.p.d(this.title, sessionSearchHit.title) && this.updatedAt == sessionSearchHit.updatedAt && this.isRead == sessionSearchHit.isRead && this.sendFailed == sessionSearchHit.sendFailed && kotlin.jvm.internal.p.d(this.previewText, sessionSearchHit.previewText);
    }

    /* renamed from: f, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: g, reason: from getter */
    public final String getPreviewText() {
        return this.previewText;
    }

    /* renamed from: h, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public int hashCode() {
        return (((((((((((((((((this.sessionId.hashCode() * 31) + this.agentId.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.agentDisplayName.hashCode()) * 31) + this.agentCategory.hashCode()) * 31) + this.title.hashCode()) * 31) + Long.hashCode(this.updatedAt)) * 31) + Boolean.hashCode(this.isRead)) * 31) + Boolean.hashCode(this.sendFailed)) * 31) + this.previewText.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: j, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public String toString() {
        return "SessionSearchHit(sessionId=" + this.sessionId + ", agentId=" + this.agentId + ", deviceId=" + this.deviceId + ", agentDisplayName=" + this.agentDisplayName + ", agentCategory=" + this.agentCategory + ", title=" + this.title + ", updatedAt=" + this.updatedAt + ", isRead=" + this.isRead + ", sendFailed=" + this.sendFailed + ", previewText=" + this.previewText + ")";
    }

    public /* synthetic */ SessionSearchHit(String str, String str2, String str3, String str4, SessionAgentCategory sessionAgentCategory, String str5, long j10, boolean z10, boolean z11, String str6, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4, (i10 & 16) != 0 ? SessionAgentCategory.PRIMARY : sessionAgentCategory, str5, j10, z10, z11, (i10 & 512) != 0 ? "" : str6);
    }
}
