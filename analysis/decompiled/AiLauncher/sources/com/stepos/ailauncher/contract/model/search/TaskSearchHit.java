package com.stepos.ailauncher.contract.model.search;

import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\rHÆ\u0003Jc\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006,"}, d2 = {"Lcom/stepos/ailauncher/contract/model/search/TaskSearchHit;", "", "taskId", "", "sessionId", "agentId", "deviceId", "title", "snippet", "status", "Lcom/stepos/ailauncher/contract/model/search/SearchTaskStatus;", "statusText", "updatedAt", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/contract/model/search/SearchTaskStatus;Ljava/lang/String;J)V", "getTaskId", "()Ljava/lang/String;", "getSessionId", "getAgentId", "getDeviceId", "getTitle", "getSnippet", "getStatus", "()Lcom/stepos/ailauncher/contract/model/search/SearchTaskStatus;", "getStatusText", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", ChatTracker.CLICK_COPY, "equals", "", "other", "hashCode", "", "toString", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskSearchHit {
    private final String agentId;
    private final String deviceId;
    private final String sessionId;
    private final String snippet;
    private final SearchTaskStatus status;
    private final String statusText;
    private final String taskId;
    private final String title;
    private final long updatedAt;

    public TaskSearchHit(String taskId, String sessionId, String agentId, String deviceId, String title, String snippet, SearchTaskStatus status, String statusText, long j10) {
        p.i(taskId, "taskId");
        p.i(sessionId, "sessionId");
        p.i(agentId, "agentId");
        p.i(deviceId, "deviceId");
        p.i(title, "title");
        p.i(snippet, "snippet");
        p.i(status, "status");
        p.i(statusText, "statusText");
        this.taskId = taskId;
        this.sessionId = sessionId;
        this.agentId = agentId;
        this.deviceId = deviceId;
        this.title = title;
        this.snippet = snippet;
        this.status = status;
        this.statusText = statusText;
        this.updatedAt = j10;
    }

    public static /* synthetic */ TaskSearchHit copy$default(TaskSearchHit taskSearchHit, String str, String str2, String str3, String str4, String str5, String str6, SearchTaskStatus searchTaskStatus, String str7, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = taskSearchHit.taskId;
        }
        if ((i10 & 2) != 0) {
            str2 = taskSearchHit.sessionId;
        }
        if ((i10 & 4) != 0) {
            str3 = taskSearchHit.agentId;
        }
        if ((i10 & 8) != 0) {
            str4 = taskSearchHit.deviceId;
        }
        if ((i10 & 16) != 0) {
            str5 = taskSearchHit.title;
        }
        if ((i10 & 32) != 0) {
            str6 = taskSearchHit.snippet;
        }
        if ((i10 & 64) != 0) {
            searchTaskStatus = taskSearchHit.status;
        }
        if ((i10 & 128) != 0) {
            str7 = taskSearchHit.statusText;
        }
        if ((i10 & 256) != 0) {
            j10 = taskSearchHit.updatedAt;
        }
        long j11 = j10;
        SearchTaskStatus searchTaskStatus2 = searchTaskStatus;
        String str8 = str7;
        String str9 = str5;
        String str10 = str6;
        return taskSearchHit.copy(str, str2, str3, str4, str9, str10, searchTaskStatus2, str8, j11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSnippet() {
        return this.snippet;
    }

    /* renamed from: component7, reason: from getter */
    public final SearchTaskStatus getStatus() {
        return this.status;
    }

    /* renamed from: component8, reason: from getter */
    public final String getStatusText() {
        return this.statusText;
    }

    /* renamed from: component9, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final TaskSearchHit copy(String taskId, String sessionId, String agentId, String deviceId, String title, String snippet, SearchTaskStatus status, String statusText, long updatedAt) {
        p.i(taskId, "taskId");
        p.i(sessionId, "sessionId");
        p.i(agentId, "agentId");
        p.i(deviceId, "deviceId");
        p.i(title, "title");
        p.i(snippet, "snippet");
        p.i(status, "status");
        p.i(statusText, "statusText");
        return new TaskSearchHit(taskId, sessionId, agentId, deviceId, title, snippet, status, statusText, updatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskSearchHit)) {
            return false;
        }
        TaskSearchHit taskSearchHit = (TaskSearchHit) other;
        return p.d(this.taskId, taskSearchHit.taskId) && p.d(this.sessionId, taskSearchHit.sessionId) && p.d(this.agentId, taskSearchHit.agentId) && p.d(this.deviceId, taskSearchHit.deviceId) && p.d(this.title, taskSearchHit.title) && p.d(this.snippet, taskSearchHit.snippet) && this.status == taskSearchHit.status && p.d(this.statusText, taskSearchHit.statusText) && this.updatedAt == taskSearchHit.updatedAt;
    }

    public final String getAgentId() {
        return this.agentId;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSnippet() {
        return this.snippet;
    }

    public final SearchTaskStatus getStatus() {
        return this.status;
    }

    public final String getStatusText() {
        return this.statusText;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        return (((((((((((((((this.taskId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.agentId.hashCode()) * 31) + this.deviceId.hashCode()) * 31) + this.title.hashCode()) * 31) + this.snippet.hashCode()) * 31) + this.status.hashCode()) * 31) + this.statusText.hashCode()) * 31) + Long.hashCode(this.updatedAt);
    }

    public String toString() {
        return "TaskSearchHit(taskId=" + this.taskId + ", sessionId=" + this.sessionId + ", agentId=" + this.agentId + ", deviceId=" + this.deviceId + ", title=" + this.title + ", snippet=" + this.snippet + ", status=" + this.status + ", statusText=" + this.statusText + ", updatedAt=" + this.updatedAt + ")";
    }

    public /* synthetic */ TaskSearchHit(String str, String str2, String str3, String str4, String str5, String str6, SearchTaskStatus searchTaskStatus, String str7, long j10, int i10, i iVar) {
        this(str, str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4, str5, (i10 & 32) != 0 ? "" : str6, searchTaskStatus, str7, j10);
    }
}
