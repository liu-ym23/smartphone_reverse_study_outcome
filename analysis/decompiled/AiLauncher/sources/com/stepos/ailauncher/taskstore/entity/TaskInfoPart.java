package com.stepos.ailauncher.taskstore.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.agentframework.chatui.longtext.b;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0011¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0011¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010 J\u0010\u0010\"\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b$\u0010%J\u0012\u0010&\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b&\u0010 J\u0010\u0010'\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b'\u0010 J\u0012\u0010(\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b(\u0010 J\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010 J\u0012\u0010*\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b*\u0010 J\u0012\u0010+\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0004\b+\u0010,J\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010 J\u0010\u0010.\u001a\u00020\u0011HÆ\u0003¢\u0006\u0004\b.\u0010\u0018J\u0012\u0010/\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b/\u0010 J\u0012\u00100\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b0\u0010 J°\u0001\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b1\u00102J\u0010\u00103\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b3\u0010 J\u0010\u00104\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b4\u0010\u0018J\u001a\u00108\u001a\u0002072\b\u00106\u001a\u0004\u0018\u000105HÖ\u0003¢\u0006\u0004\b8\u00109R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010:\u001a\u0004\b;\u0010 R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010:\u001a\u0004\b<\u0010 R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010=\u001a\u0004\b>\u0010#R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010?\u001a\u0004\b@\u0010%R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010:\u001a\u0004\bA\u0010 R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010:\u001a\u0004\bB\u0010 R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010:\u001a\u0004\bC\u0010 R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010:\u001a\u0004\bD\u0010 R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010:\u001a\u0004\bE\u0010 R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010F\u001a\u0004\bG\u0010,R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010:\u001a\u0004\bH\u0010 R\u0017\u0010\u0012\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010I\u001a\u0004\bJ\u0010\u0018R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010:\u001a\u0004\bK\u0010 R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010:\u001a\u0004\bL\u0010 ¨\u0006M"}, d2 = {"Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "Landroid/os/Parcelable;", "", "partId", "status", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPartType;", "type", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoContentType;", "contentType", "fileId", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "fileName", "title", "mimeType", "", ContentDisposition.Parameters.Size, "sha256", "", "taskVersion", "errorReason", "errorDetail", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPartType;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoContentType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPartType;", "component4", "()Lcom/stepos/ailauncher/taskstore/entity/TaskInfoContentType;", "component5", "component6", "component7", "component8", "component9", "component10", "()Ljava/lang/Long;", "component11", "component12", "component13", "component14", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPartType;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoContentType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPartId", "getStatus", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPartType;", "getType", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoContentType;", "getContentType", "getFileId", "getContent", "getFileName", "getTitle", "getMimeType", "Ljava/lang/Long;", "getSize", "getSha256", "I", "getTaskVersion", "getErrorReason", "getErrorDetail", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskInfoPart implements Parcelable {
    public static final Parcelable.Creator<TaskInfoPart> CREATOR = new Creator();
    private final String content;
    private final TaskInfoContentType contentType;
    private final String errorDetail;
    private final String errorReason;
    private final String fileId;
    private final String fileName;
    private final String mimeType;
    private final String partId;
    private final String sha256;
    private final Long size;
    private final String status;
    private final int taskVersion;
    private final String title;
    private final TaskInfoPartType type;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TaskInfoPart> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskInfoPart createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new TaskInfoPart(parcel.readString(), parcel.readString(), TaskInfoPartType.valueOf(parcel.readString()), TaskInfoContentType.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final TaskInfoPart[] newArray(int i10) {
            return new TaskInfoPart[i10];
        }
    }

    public TaskInfoPart(String str, String str2, TaskInfoPartType type, TaskInfoContentType contentType, String str3, String content, String str4, String str5, String str6, Long l10, String str7, int i10, String str8, String str9) {
        p.i(type, "type");
        p.i(contentType, "contentType");
        p.i(content, "content");
        this.partId = str;
        this.status = str2;
        this.type = type;
        this.contentType = contentType;
        this.fileId = str3;
        this.content = content;
        this.fileName = str4;
        this.title = str5;
        this.mimeType = str6;
        this.size = l10;
        this.sha256 = str7;
        this.taskVersion = i10;
        this.errorReason = str8;
        this.errorDetail = str9;
    }

    /* renamed from: component1, reason: from getter */
    public final String getPartId() {
        return this.partId;
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
    public final TaskInfoPartType getType() {
        return this.type;
    }

    /* renamed from: component4, reason: from getter */
    public final TaskInfoContentType getContentType() {
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

    public final TaskInfoPart copy(String partId, String status, TaskInfoPartType type, TaskInfoContentType contentType, String fileId, String content, String fileName, String title, String mimeType, Long size, String sha256, int taskVersion, String errorReason, String errorDetail) {
        p.i(type, "type");
        p.i(contentType, "contentType");
        p.i(content, "content");
        return new TaskInfoPart(partId, status, type, contentType, fileId, content, fileName, title, mimeType, size, sha256, taskVersion, errorReason, errorDetail);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskInfoPart)) {
            return false;
        }
        TaskInfoPart taskInfoPart = (TaskInfoPart) other;
        return p.d(this.partId, taskInfoPart.partId) && p.d(this.status, taskInfoPart.status) && this.type == taskInfoPart.type && this.contentType == taskInfoPart.contentType && p.d(this.fileId, taskInfoPart.fileId) && p.d(this.content, taskInfoPart.content) && p.d(this.fileName, taskInfoPart.fileName) && p.d(this.title, taskInfoPart.title) && p.d(this.mimeType, taskInfoPart.mimeType) && p.d(this.size, taskInfoPart.size) && p.d(this.sha256, taskInfoPart.sha256) && this.taskVersion == taskInfoPart.taskVersion && p.d(this.errorReason, taskInfoPart.errorReason) && p.d(this.errorDetail, taskInfoPart.errorDetail);
    }

    public final String getContent() {
        return this.content;
    }

    public final TaskInfoContentType getContentType() {
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

    public final String getPartId() {
        return this.partId;
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

    public final TaskInfoPartType getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.partId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.status;
        int iHashCode2 = (((((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.type.hashCode()) * 31) + this.contentType.hashCode()) * 31;
        String str3 = this.fileId;
        int iHashCode3 = (((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.content.hashCode()) * 31;
        String str4 = this.fileName;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.title;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.mimeType;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Long l10 = this.size;
        int iHashCode7 = (iHashCode6 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str7 = this.sha256;
        int iHashCode8 = (((iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + Integer.hashCode(this.taskVersion)) * 31;
        String str8 = this.errorReason;
        int iHashCode9 = (iHashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.errorDetail;
        return iHashCode9 + (str9 != null ? str9.hashCode() : 0);
    }

    public String toString() {
        return "TaskInfoPart(partId=" + this.partId + ", status=" + this.status + ", type=" + this.type + ", contentType=" + this.contentType + ", fileId=" + this.fileId + ", content=" + this.content + ", fileName=" + this.fileName + ", title=" + this.title + ", mimeType=" + this.mimeType + ", size=" + this.size + ", sha256=" + this.sha256 + ", taskVersion=" + this.taskVersion + ", errorReason=" + this.errorReason + ", errorDetail=" + this.errorDetail + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.partId);
        dest.writeString(this.status);
        dest.writeString(this.type.name());
        dest.writeString(this.contentType.name());
        dest.writeString(this.fileId);
        dest.writeString(this.content);
        dest.writeString(this.fileName);
        dest.writeString(this.title);
        dest.writeString(this.mimeType);
        Long l10 = this.size;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        dest.writeString(this.sha256);
        dest.writeInt(this.taskVersion);
        dest.writeString(this.errorReason);
        dest.writeString(this.errorDetail);
    }

    public /* synthetic */ TaskInfoPart(String str, String str2, TaskInfoPartType taskInfoPartType, TaskInfoContentType taskInfoContentType, String str3, String str4, String str5, String str6, String str7, Long l10, String str8, int i10, String str9, String str10, int i11, i iVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, taskInfoPartType, taskInfoContentType, (i11 & 16) != 0 ? null : str3, str4, (i11 & 64) != 0 ? null : str5, (i11 & 128) != 0 ? null : str6, (i11 & 256) != 0 ? null : str7, (i11 & 512) != 0 ? null : l10, (i11 & 1024) != 0 ? null : str8, (i11 & 2048) != 0 ? 0 : i10, (i11 & 4096) != 0 ? null : str9, (i11 & b.THRESHOLD) != 0 ? null : str10);
    }
}
