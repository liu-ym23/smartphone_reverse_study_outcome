package com.stepos.agentframework.chatcore.search;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.netcore.BusTaskStatus;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u001a\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001b\u0010\u000fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/stepos/agentframework/chatcore/search/o;", "", "", "taskId", "sessionId", "title", "searchableText", "Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", "status", "", "updatedAt", "readAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;JLjava/lang/Long;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "e", "c", "f", Const.INTENT_KEY_PKGNAME, "Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", Const.INTENT_KEY_UMID, "()Lcom/stepos/agentframework/adapter/netcore/BusTaskStatus;", "J", Const.INTENT_KEY_BACKGROUND_COMMAND, "()J", "Ljava/lang/Long;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Long;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.search.o, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class TaskSearchRecord {
    private final Long readAt;
    private final String searchableText;
    private final String sessionId;
    private final BusTaskStatus status;
    private final String taskId;
    private final String title;
    private final long updatedAt;

    public TaskSearchRecord(String taskId, String sessionId, String title, String searchableText, BusTaskStatus status, long j10, Long l10) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(searchableText, "searchableText");
        kotlin.jvm.internal.p.i(status, "status");
        this.taskId = taskId;
        this.sessionId = sessionId;
        this.title = title;
        this.searchableText = searchableText;
        this.status = status;
        this.updatedAt = j10;
        this.readAt = l10;
    }

    /* renamed from: a, reason: from getter */
    public final Long getReadAt() {
        return this.readAt;
    }

    /* renamed from: b, reason: from getter */
    public final String getSearchableText() {
        return this.searchableText;
    }

    /* renamed from: c, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: d, reason: from getter */
    public final BusTaskStatus getStatus() {
        return this.status;
    }

    /* renamed from: e, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskSearchRecord)) {
            return false;
        }
        TaskSearchRecord taskSearchRecord = (TaskSearchRecord) other;
        return kotlin.jvm.internal.p.d(this.taskId, taskSearchRecord.taskId) && kotlin.jvm.internal.p.d(this.sessionId, taskSearchRecord.sessionId) && kotlin.jvm.internal.p.d(this.title, taskSearchRecord.title) && kotlin.jvm.internal.p.d(this.searchableText, taskSearchRecord.searchableText) && this.status == taskSearchRecord.status && this.updatedAt == taskSearchRecord.updatedAt && kotlin.jvm.internal.p.d(this.readAt, taskSearchRecord.readAt);
    }

    /* renamed from: f, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: g, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.taskId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.searchableText.hashCode()) * 31) + this.status.hashCode()) * 31) + Long.hashCode(this.updatedAt)) * 31;
        Long l10 = this.readAt;
        return iHashCode + (l10 == null ? 0 : l10.hashCode());
    }

    public String toString() {
        return "TaskSearchRecord(taskId=" + this.taskId + ", sessionId=" + this.sessionId + ", title=" + this.title + ", searchableText=" + this.searchableText + ", status=" + this.status + ", updatedAt=" + this.updatedAt + ", readAt=" + this.readAt + ")";
    }
}
