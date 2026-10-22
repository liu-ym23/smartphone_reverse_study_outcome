package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0010HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J´\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0010HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016¨\u0006<"}, d2 = {"Lcom/stepos/agentbus/generated/TaskArtifact;", "", "artifactId", "", "status", "type", "contentType", "fileId", "content", "fileName", "title", "mimeType", "size", "", "sha256", "taskVersion", "", "errorReason", "errorDetail", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getArtifactId", "()Ljava/lang/String;", "getStatus", "getType", "getContentType", "getFileId", "getContent", "getFileName", "getTitle", "getMimeType", "getSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSha256", "getTaskVersion", "()I", "getErrorReason", "getErrorDetail", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lcom/stepos/agentbus/generated/TaskArtifact;", "equals", "", "other", "hashCode", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskArtifact {
    private final String artifactId;
    private final String content;
    private final String contentType;
    private final String errorDetail;
    private final String errorReason;
    private final String fileId;
    private final String fileName;
    private final String mimeType;
    private final String sha256;
    private final Long size;
    private final String status;
    private final int taskVersion;
    private final String title;
    private final String type;

    public TaskArtifact() {
        this(null, null, null, null, null, null, null, null, null, null, null, 0, null, null, 16383, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getArtifactId() {
        return this.artifactId;
    }

    /* renamed from: component10, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    /* renamed from: component11, reason: from getter */
    public final String getSha256() {
        return this.sha256;
    }

    /* renamed from: component12, reason: from getter */
    public final int getTaskVersion() {
        return this.taskVersion;
    }

    /* renamed from: component13, reason: from getter */
    public final String getErrorReason() {
        return this.errorReason;
    }

    /* renamed from: component14, reason: from getter */
    public final String getErrorDetail() {
        return this.errorDetail;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component3, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component7, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: component8, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component9, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    public final TaskArtifact copy(String artifactId, String status, String type, String contentType, String fileId, String content, String fileName, String title, String mimeType, Long size, String sha256, int taskVersion, String errorReason, String errorDetail) {
        return new TaskArtifact(artifactId, status, type, contentType, fileId, content, fileName, title, mimeType, size, sha256, taskVersion, errorReason, errorDetail);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskArtifact)) {
            return false;
        }
        TaskArtifact taskArtifact = (TaskArtifact) other;
        return k.b(this.artifactId, taskArtifact.artifactId) && k.b(this.status, taskArtifact.status) && k.b(this.type, taskArtifact.type) && k.b(this.contentType, taskArtifact.contentType) && k.b(this.fileId, taskArtifact.fileId) && k.b(this.content, taskArtifact.content) && k.b(this.fileName, taskArtifact.fileName) && k.b(this.title, taskArtifact.title) && k.b(this.mimeType, taskArtifact.mimeType) && k.b(this.size, taskArtifact.size) && k.b(this.sha256, taskArtifact.sha256) && this.taskVersion == taskArtifact.taskVersion && k.b(this.errorReason, taskArtifact.errorReason) && k.b(this.errorDetail, taskArtifact.errorDetail);
    }

    public final String getArtifactId() {
        return this.artifactId;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final String getErrorDetail() {
        return this.errorDetail;
    }

    public final String getErrorReason() {
        return this.errorReason;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getSha256() {
        return this.sha256;
    }

    public final Long getSize() {
        return this.size;
    }

    public final String getStatus() {
        return this.status;
    }

    public final int getTaskVersion() {
        return this.taskVersion;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
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
        Long l = this.size;
        int iHashCode10 = (iHashCode9 + (l == null ? 0 : l.hashCode())) * 31;
        String str10 = this.sha256;
        int iA = androidx.constraintlayout.core.dsl.a.a(this.taskVersion, (iHashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31, 31);
        String str11 = this.errorReason;
        int iHashCode11 = (iA + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.errorDetail;
        return iHashCode11 + (str12 != null ? str12.hashCode() : 0);
    }

    public String toString() {
        String str = this.artifactId;
        String str2 = this.status;
        String str3 = this.type;
        String str4 = this.contentType;
        String str5 = this.fileId;
        String str6 = this.content;
        String str7 = this.fileName;
        String str8 = this.title;
        String str9 = this.mimeType;
        Long l = this.size;
        String str10 = this.sha256;
        int i = this.taskVersion;
        String str11 = this.errorReason;
        String str12 = this.errorDetail;
        StringBuilder sbW = B7.a.w("TaskArtifact(artifactId=", str, ", status=", str2, ", type=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", contentType=", str4, ", fileId=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str5, ", content=", str6, ", fileName=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str7, ", title=", str8, ", mimeType=");
        sbW.append(str9);
        sbW.append(", size=");
        sbW.append(l);
        sbW.append(", sha256=");
        androidx.compose.foundation.b.B(sbW, str10, ", taskVersion=", i, ", errorReason=");
        return androidx.appfunctions.metadata.a.p(sbW, str11, ", errorDetail=", str12, ")");
    }

    public TaskArtifact(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long l, String str10, int i, String str11, String str12) {
        this.artifactId = str;
        this.status = str2;
        this.type = str3;
        this.contentType = str4;
        this.fileId = str5;
        this.content = str6;
        this.fileName = str7;
        this.title = str8;
        this.mimeType = str9;
        this.size = l;
        this.sha256 = str10;
        this.taskVersion = i;
        this.errorReason = str11;
        this.errorDetail = str12;
    }

    public /* synthetic */ TaskArtifact(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Long l, String str10, int i, String str11, String str12, int i6, e eVar) {
        this((i6 & 1) != 0 ? null : str, (i6 & 2) != 0 ? null : str2, (i6 & 4) != 0 ? null : str3, (i6 & 8) != 0 ? null : str4, (i6 & 16) != 0 ? null : str5, (i6 & 32) != 0 ? null : str6, (i6 & 64) != 0 ? null : str7, (i6 & 128) != 0 ? null : str8, (i6 & 256) != 0 ? null : str9, (i6 & 512) != 0 ? null : l, (i6 & 1024) != 0 ? null : str10, (i6 & 2048) != 0 ? 0 : i, (i6 & 4096) != 0 ? null : str11, (i6 & 8192) != 0 ? null : str12);
    }
}
