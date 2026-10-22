package w4;

import com.autonavi.aps.amapapi.config.Const;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0087\b\u0018\u00002\u00020\u0001B\u0089\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b\u001f\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b \u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b!\u0010\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\"\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b#\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b$\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b%\u0010\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b&\u0010\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b'\u0010\u0016R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010\u000f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010+\u001a\u0004\b,\u0010-R\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010.\u001a\u0004\b/\u0010\u0018R\u001a\u0010\u0012\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010+\u001a\u0004\b0\u0010-¨\u00061"}, d2 = {"Lw4/j;", "", "", "fileId", "sessionId", "messageId", "toolCallId", "taskId", "versionId", "cloudPath", "fileName", "title", "mimeType", "", ContentDisposition.Parameters.Size, "createdAt", "", "availability", "checkedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;JIJ)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_BACKGROUND_COMMAND, "e", "k", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "l", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "f", "Ljava/lang/Long;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/lang/Long;", "J", Const.INTENT_KEY_PKGNAME, "()J", "I", "getAvailability", "getCheckedAt", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: w4.j, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class TaskResultArtifactEntity {
    private final int availability;
    private final long checkedAt;
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

    public TaskResultArtifactEntity(String fileId, String sessionId, String messageId, String toolCallId, String str, String str2, String str3, String str4, String str5, String str6, Long l10, long j10, int i10, long j11) {
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
        this.availability = i10;
        this.checkedAt = j11;
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
    public final String getMessageId() {
        return this.messageId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskResultArtifactEntity)) {
            return false;
        }
        TaskResultArtifactEntity taskResultArtifactEntity = (TaskResultArtifactEntity) other;
        return p.d(this.fileId, taskResultArtifactEntity.fileId) && p.d(this.sessionId, taskResultArtifactEntity.sessionId) && p.d(this.messageId, taskResultArtifactEntity.messageId) && p.d(this.toolCallId, taskResultArtifactEntity.toolCallId) && p.d(this.taskId, taskResultArtifactEntity.taskId) && p.d(this.versionId, taskResultArtifactEntity.versionId) && p.d(this.cloudPath, taskResultArtifactEntity.cloudPath) && p.d(this.fileName, taskResultArtifactEntity.fileName) && p.d(this.title, taskResultArtifactEntity.title) && p.d(this.mimeType, taskResultArtifactEntity.mimeType) && p.d(this.size, taskResultArtifactEntity.size) && this.createdAt == taskResultArtifactEntity.createdAt && this.availability == taskResultArtifactEntity.availability && this.checkedAt == taskResultArtifactEntity.checkedAt;
    }

    /* renamed from: f, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* renamed from: g, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: h, reason: from getter */
    public final Long getSize() {
        return this.size;
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
        return ((((((iHashCode7 + (l10 != null ? l10.hashCode() : 0)) * 31) + Long.hashCode(this.createdAt)) * 31) + Integer.hashCode(this.availability)) * 31) + Long.hashCode(this.checkedAt);
    }

    /* renamed from: i, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: j, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: k, reason: from getter */
    public final String getToolCallId() {
        return this.toolCallId;
    }

    /* renamed from: l, reason: from getter */
    public final String getVersionId() {
        return this.versionId;
    }

    public String toString() {
        return "TaskResultArtifactEntity(fileId=" + this.fileId + ", sessionId=" + this.sessionId + ", messageId=" + this.messageId + ", toolCallId=" + this.toolCallId + ", taskId=" + this.taskId + ", versionId=" + this.versionId + ", cloudPath=" + this.cloudPath + ", fileName=" + this.fileName + ", title=" + this.title + ", mimeType=" + this.mimeType + ", size=" + this.size + ", createdAt=" + this.createdAt + ", availability=" + this.availability + ", checkedAt=" + this.checkedAt + ")";
    }

    public /* synthetic */ TaskResultArtifactEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Long l10, long j10, int i10, long j11, int i11, kotlin.jvm.internal.i iVar) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, l10, j10, (i11 & 4096) != 0 ? 0 : i10, (i11 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? 0L : j11);
    }
}
