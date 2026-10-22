package q4;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001d\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001e\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001f\u0010\u0013R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b \u0010\u0013R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b!\u0010\u0013R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\"\u0010\u0013R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b#\u0010\u0013R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b$\u0010\u0013R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b%\u0010\u0013R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010\u000f\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010)\u001a\u0004\b*\u0010+¨\u0006,"}, d2 = {"Lq4/b;", "", "", "fileId", "sessionId", "messageId", "toolCallId", "taskId", "versionId", "cloudPath", "fileName", "title", "mimeType", "", ContentDisposition.Parameters.Size, "createdAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;J)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "f", "getMessageId", "getToolCallId", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "getVersionId", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "e", "Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/Long;", "J", Const.INTENT_KEY_PKGNAME, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: q4.b, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class TaskResultArtifact {
    private final String cloudPath;
    private final long createdAt;
    private final String fileId;
    private final String fileName;
    private final String messageId;
    private final String mimeType;
    private final String sessionId;
    private final Long size;
    private final String taskId;
    private final String title;
    private final String toolCallId;
    private final String versionId;

    public TaskResultArtifact(String fileId, String sessionId, String messageId, String toolCallId, String str, String str2, String str3, String str4, String str5, String str6, Long l10, long j10) {
        p.i(fileId, "fileId");
        p.i(sessionId, "sessionId");
        p.i(messageId, "messageId");
        p.i(toolCallId, "toolCallId");
        this.fileId = fileId;
        this.sessionId = sessionId;
        this.messageId = messageId;
        this.toolCallId = toolCallId;
        this.taskId = str;
        this.versionId = str2;
        this.cloudPath = str3;
        this.fileName = str4;
        this.title = str5;
        this.mimeType = str6;
        this.size = l10;
        this.createdAt = j10;
    }

    /* renamed from: a, reason: from getter */
    public final String getCloudPath() {
        return this.cloudPath;
    }

    /* renamed from: b, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: c, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* renamed from: d, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: e, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskResultArtifact)) {
            return false;
        }
        TaskResultArtifact taskResultArtifact = (TaskResultArtifact) other;
        return p.d(this.fileId, taskResultArtifact.fileId) && p.d(this.sessionId, taskResultArtifact.sessionId) && p.d(this.messageId, taskResultArtifact.messageId) && p.d(this.toolCallId, taskResultArtifact.toolCallId) && p.d(this.taskId, taskResultArtifact.taskId) && p.d(this.versionId, taskResultArtifact.versionId) && p.d(this.cloudPath, taskResultArtifact.cloudPath) && p.d(this.fileName, taskResultArtifact.fileName) && p.d(this.title, taskResultArtifact.title) && p.d(this.mimeType, taskResultArtifact.mimeType) && p.d(this.size, taskResultArtifact.size) && this.createdAt == taskResultArtifact.createdAt;
    }

    /* renamed from: f, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: g, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    /* renamed from: h, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public int hashCode() {
        int iHashCode = ((((((this.fileId.hashCode() * 31) + this.sessionId.hashCode()) * 31) + this.messageId.hashCode()) * 31) + this.toolCallId.hashCode()) * 31;
        String str = this.taskId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.versionId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cloudPath;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.fileName;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.title;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.mimeType;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Long l10 = this.size;
        return ((iHashCode7 + (l10 != null ? l10.hashCode() : 0)) * 31) + Long.hashCode(this.createdAt);
    }

    /* renamed from: i, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public String toString() {
        return "TaskResultArtifact(fileId=" + this.fileId + ", sessionId=" + this.sessionId + ", messageId=" + this.messageId + ", toolCallId=" + this.toolCallId + ", taskId=" + this.taskId + ", versionId=" + this.versionId + ", cloudPath=" + this.cloudPath + ", fileName=" + this.fileName + ", title=" + this.title + ", mimeType=" + this.mimeType + ", size=" + this.size + ", createdAt=" + this.createdAt + ")";
    }
}
