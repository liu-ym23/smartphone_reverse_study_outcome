package w4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0019\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u001a\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u001b\u0010\u000eR\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lw4/k;", "", "", "taskId", "sessionId", "title", "searchableText", "status", "", "updatedAt", "readAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "e", "c", "f", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, "J", Const.INTENT_KEY_BACKGROUND_COMMAND, "()J", "Ljava/lang/Long;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Long;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: w4.k, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class TaskSearchDocumentEntity {
    private final Long readAt;
    private final String searchableText;
    private final String sessionId;
    private final String status;
    private final String taskId;
    private final String title;
    private final long updatedAt;

    public TaskSearchDocumentEntity(String taskId, String sessionId, String title, String searchableText, String status, long j10, Long l10) {
        p.i(taskId, "taskId");
        p.i(sessionId, "sessionId");
        p.i(title, "title");
        p.i(searchableText, "searchableText");
        p.i(status, "status");
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
    public final String getStatus() {
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
        if (!(other instanceof TaskSearchDocumentEntity)) {
            return false;
        }
        TaskSearchDocumentEntity taskSearchDocumentEntity = (TaskSearchDocumentEntity) other;
        return p.d(this.taskId, taskSearchDocumentEntity.taskId) && p.d(this.sessionId, taskSearchDocumentEntity.sessionId) && p.d(this.title, taskSearchDocumentEntity.title) && p.d(this.searchableText, taskSearchDocumentEntity.searchableText) && p.d(this.status, taskSearchDocumentEntity.status) && this.updatedAt == taskSearchDocumentEntity.updatedAt && p.d(this.readAt, taskSearchDocumentEntity.readAt);
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
        return "TaskSearchDocumentEntity(taskId=" + this.taskId + ", sessionId=" + this.sessionId + ", title=" + this.title + ", searchableText=" + this.searchableText + ", status=" + this.status + ", updatedAt=" + this.updatedAt + ", readAt=" + this.readAt + ")";
    }
}
