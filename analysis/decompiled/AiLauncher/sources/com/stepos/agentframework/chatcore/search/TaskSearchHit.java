package com.stepos.agentframework.chatcore.search;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.netcore.BusTaskStatus;
import com.stepos.agentframework.chatcore.session.list.SessionAgentCategory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b \u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b!\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\"\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b#\u0010\u0016R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b'\u0010\u0016R\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b(\u0010\u0016R\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010,\u001a\u0004\b-\u0010.R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010/\u001a\u0004\b0\u00101R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u00102\u001a\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/stepos/agentframework/chatcore/search/n;", "", "", "taskId", "sessionId", "agentId", "deviceId", "agentDisplayName", "Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;", "agentCategory", "title", "matchedText", "Lcom/stepos/agentframework/chatcore/search/TaskSearchMatchedField;", "matchedField", "Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", "status", "", "updatedAt", "readAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/search/TaskSearchMatchedField;Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;JLjava/lang/Long;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "e", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "getAgentDisplayName", "Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;", "getAgentCategory", "()Lcom/stepos/agentframework/chatcore/session/list/SessionAgentCategory;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_UMID, "Lcom/stepos/agentframework/chatcore/search/TaskSearchMatchedField;", "c", "()Lcom/stepos/agentframework/chatcore/search/TaskSearchMatchedField;", "Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", "f", "()Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", "J", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()J", "Ljava/lang/Long;", "getReadAt", "()Ljava/lang/Long;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.search.n, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class TaskSearchHit {
    private final SessionAgentCategory agentCategory;
    private final String agentDisplayName;
    private final String agentId;
    private final String deviceId;
    private final TaskSearchMatchedField matchedField;
    private final String matchedText;
    private final Long readAt;
    private final String sessionId;
    private final BusTaskStatus status;
    private final String taskId;
    private final String title;
    private final long updatedAt;

    public TaskSearchHit(String taskId, String sessionId, String agentId, String deviceId, String agentDisplayName, SessionAgentCategory agentCategory, String title, String matchedText, TaskSearchMatchedField matchedField, BusTaskStatus status, long j10, Long l10) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(agentId, "agentId");
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agentDisplayName, "agentDisplayName");
        kotlin.jvm.internal.p.i(agentCategory, "agentCategory");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(matchedText, "matchedText");
        kotlin.jvm.internal.p.i(matchedField, "matchedField");
        kotlin.jvm.internal.p.i(status, "status");
        this.taskId = taskId;
        this.sessionId = sessionId;
        this.agentId = agentId;
        this.deviceId = deviceId;
        this.agentDisplayName = agentDisplayName;
        this.agentCategory = agentCategory;
        this.title = title;
        this.matchedText = matchedText;
        this.matchedField = matchedField;
        this.status = status;
        this.updatedAt = j10;
        this.readAt = l10;
    }

    /* renamed from: a, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: b, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: c, reason: from getter */
    public final TaskSearchMatchedField getMatchedField() {
        return this.matchedField;
    }

    /* renamed from: d, reason: from getter */
    public final String getMatchedText() {
        return this.matchedText;
    }

    /* renamed from: e, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskSearchHit)) {
            return false;
        }
        TaskSearchHit taskSearchHit = (TaskSearchHit) other;
        return kotlin.jvm.internal.p.d(this.taskId, taskSearchHit.taskId) && kotlin.jvm.internal.p.d(this.sessionId, taskSearchHit.sessionId) && kotlin.jvm.internal.p.d(this.agentId, taskSearchHit.agentId) && kotlin.jvm.internal.p.d(this.deviceId, taskSearchHit.deviceId) && kotlin.jvm.internal.p.d(this.agentDisplayName, taskSearchHit.agentDisplayName) && this.agentCategory == taskSearchHit.agentCategory && kotlin.jvm.internal.p.d(this.title, taskSearchHit.title) && kotlin.jvm.internal.p.d(this.matchedText, taskSearchHit.matchedText) && this.matchedField == taskSearchHit.matchedField && this.status == taskSearchHit.status && this.updatedAt == taskSearchHit.updatedAt && kotlin.jvm.internal.p.d(this.readAt, taskSearchHit.readAt);
    }

    /* renamed from: f, reason: from getter */
    public final BusTaskStatus getStatus() {
        return this.status;
    }

    /* renamed from: g, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: h, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((((((this.taskId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.agentId.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.agentDisplayName.hashCode()) * 31) + this.agentCategory.hashCode()) * 31) + this.title.hashCode()) * 31) + this.matchedText.hashCode()) * 31) + this.matchedField.hashCode()) * 31) + this.status.hashCode()) * 31) + Long.hashCode(this.updatedAt)) * 31;
        Long l10 = this.readAt;
        return iHashCode + (l10 == null ? 0 : l10.hashCode());
    }

    /* renamed from: i, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public String toString() {
        return "TaskSearchHit(taskId=" + this.taskId + ", sessionId=" + this.sessionId + ", agentId=" + this.agentId + ", deviceId=" + this.deviceId + ", agentDisplayName=" + this.agentDisplayName + ", agentCategory=" + this.agentCategory + ", title=" + this.title + ", matchedText=" + this.matchedText + ", matchedField=" + this.matchedField + ", status=" + this.status + ", updatedAt=" + this.updatedAt + ", readAt=" + this.readAt + ")";
    }
}
