package a4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u0016R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001e\u001a\u0004\b \u0010\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b!\u0010\u0016R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010\u0016R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b\u001f\u0010\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b&\u0010\u001e\u001a\u0004\b&\u0010\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b'\u0010\u001e\u001a\u0004\b(\u0010\u0016R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b)\u0010\u001e\u001a\u0004\b'\u0010\u0016R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b \u0010\u001e\u001a\u0004\b)\u0010\u0016R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b-\u0010\u0018R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b(\u0010\u001e\u001a\u0004\b$\u0010\u0016R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010\u0016¨\u0006/"}, d2 = {"La4/B;", "", "", "artifactId", "status", "type", "contentType", "fileId", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "fileName", "title", "mimeType", "", ContentDisposition.Parameters.Size, "sha256", "", "taskVersion", "errorReason", "errorDetail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "k", "c", "n", Const.INTENT_KEY_UMID, "e", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "m", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "Ljava/lang/Long;", "()Ljava/lang/Long;", "l", "I", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a4.B, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class TaskArtifact {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String artifactId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String status;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String contentType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String fileId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final String content;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final String fileName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final String title;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final String mimeType;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    public final Long size;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    public final String sha256;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    public final int taskVersion;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    public final String errorReason;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    public final String errorDetail;

    public TaskArtifact() {
        this(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, 16383, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getArtifactId() {
        return this.artifactId;
    }

    /* renamed from: b, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: c, reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    /* renamed from: d, reason: from getter */
    public final String getErrorDetail() {
        return this.errorDetail;
    }

    /* renamed from: e, reason: from getter */
    public final String getErrorReason() {
        return this.errorReason;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskArtifact)) {
            return false;
        }
        TaskArtifact taskArtifact = (TaskArtifact) other;
        return kotlin.jvm.internal.p.d(this.artifactId, taskArtifact.artifactId) && kotlin.jvm.internal.p.d(this.status, taskArtifact.status) && kotlin.jvm.internal.p.d(this.type, taskArtifact.type) && kotlin.jvm.internal.p.d(this.contentType, taskArtifact.contentType) && kotlin.jvm.internal.p.d(this.fileId, taskArtifact.fileId) && kotlin.jvm.internal.p.d(this.content, taskArtifact.content) && kotlin.jvm.internal.p.d(this.fileName, taskArtifact.fileName) && kotlin.jvm.internal.p.d(this.title, taskArtifact.title) && kotlin.jvm.internal.p.d(this.mimeType, taskArtifact.mimeType) && kotlin.jvm.internal.p.d(this.size, taskArtifact.size) && kotlin.jvm.internal.p.d(this.sha256, taskArtifact.sha256) && this.taskVersion == taskArtifact.taskVersion && kotlin.jvm.internal.p.d(this.errorReason, taskArtifact.errorReason) && kotlin.jvm.internal.p.d(this.errorDetail, taskArtifact.errorDetail);
    }

    /* renamed from: f, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* renamed from: g, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: h, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    public int hashCode() {
        String str = this.artifactId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.status;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.type;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.contentType;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.fileId;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.content;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.fileName;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.title;
        int iHashCode8 = (iHashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.mimeType;
        int iHashCode9 = (iHashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Long l10 = this.size;
        int iHashCode10 = (iHashCode9 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str10 = this.sha256;
        int iHashCode11 = (((iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31) + Integer.hashCode(this.taskVersion)) * 31;
        String str11 = this.errorReason;
        int iHashCode12 = (iHashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.errorDetail;
        return iHashCode12 + (str12 != null ? str12.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getSha256() {
        return this.sha256;
    }

    /* renamed from: j, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    /* renamed from: k, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: l, reason: from getter */
    public final int getTaskVersion() {
        return this.taskVersion;
    }

    /* renamed from: m, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: n, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public String toString() {
        return "TaskArtifact(artifactId=" + this.artifactId + ", status=" + this.status + ", type=" + this.type + ", contentType=" + this.contentType + ", fileId=" + this.fileId + ", content=" + this.content + ", fileName=" + this.fileName + ", title=" + this.title + ", mimeType=" + this.mimeType + ", size=" + this.size + ", sha256=" + this.sha256 + ", taskVersion=" + this.taskVersion + ", errorReason=" + this.errorReason + ", errorDetail=" + this.errorDetail + ")";
    }

    public TaskArtifact(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long l10, String str10, int i10, String str11, String str12) {
        this.artifactId = str;
        this.status = str2;
        this.type = str3;
        this.contentType = str4;
        this.fileId = str5;
        this.content = str6;
        this.fileName = str7;
        this.title = str8;
        this.mimeType = str9;
        this.size = l10;
        this.sha256 = str10;
        this.taskVersion = i10;
        this.errorReason = str11;
        this.errorDetail = str12;
    }

    public /* synthetic */ TaskArtifact(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long l10, String str10, int i10, String str11, String str12, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : str5, (i11 & 32) != 0 ? null : str6, (i11 & 64) != 0 ? null : str7, (i11 & 128) != 0 ? null : str8, (i11 & 256) != 0 ? null : str9, (i11 & 512) != 0 ? null : l10, (i11 & 1024) != 0 ? null : str10, (i11 & 2048) != 0 ? 0 : i10, (i11 & 4096) != 0 ? null : str11, (i11 & com.stepos.agentframework.chatui.longtext.b.THRESHOLD) != 0 ? null : str12);
    }
}
