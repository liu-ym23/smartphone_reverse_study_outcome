package com.stepos.ailauncher.contract.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0014J\u0010\u0010\u001f\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u001cJ\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u001cJ\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u001cJ\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001cJ\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\u001cJ\u0012\u0010&\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b&\u0010\u001cJ\u0012\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b'\u0010(J\u0012\u0010)\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b)\u0010\u001cJ\u0098\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b,\u0010\u001cJ\u0010\u0010-\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b-\u0010\u0014J\u001a\u00101\u001a\u0002002\b\u0010/\u001a\u0004\u0018\u00010.HÖ\u0003¢\u0006\u0004\b1\u00102R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00103\u001a\u0004\b4\u0010\u001cR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00103\u001a\u0004\b5\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u00106\u001a\u0004\b7\u0010\u0014R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u00108\u001a\u0004\b9\u0010 R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u00103\u001a\u0004\b:\u0010\u001cR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u00103\u001a\u0004\b;\u0010\u001cR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u00103\u001a\u0004\b<\u0010\u001cR\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u00103\u001a\u0004\b=\u0010\u001cR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u00103\u001a\u0004\b>\u0010\u001cR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u00103\u001a\u0004\b?\u0010\u001cR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\u000f\u0010@\u001a\u0004\bA\u0010(R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u00103\u001a\u0004\bB\u0010\u001c¨\u0006C"}, d2 = {"Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "Landroid/os/Parcelable;", "", "taskId", "name", "", "iconRes", "", "createdAt", "fileId", "sessionId", "cloudPath", "mimeType", "fileName", "title", ContentDisposition.Parameters.Size, "previewUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()J", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "()Ljava/lang/Long;", "component12", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTaskId", "getName", "I", "getIconRes", "J", "getCreatedAt", "getFileId", "getSessionId", "getCloudPath", "getMimeType", "getFileName", "getTitle", "Ljava/lang/Long;", "getSize", "getPreviewUrl", "contract_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SessionArtifact implements Parcelable {
    public static final Parcelable.Creator<SessionArtifact> CREATOR = new Creator();
    private final String cloudPath;
    private final long createdAt;
    private final String fileId;
    private final String fileName;
    private final int iconRes;
    private final String mimeType;
    private final String name;
    private final String previewUrl;
    private final String sessionId;
    private final Long size;
    private final String taskId;
    private final String title;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SessionArtifact> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SessionArtifact createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new SessionArtifact(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SessionArtifact[] newArray(int i10) {
            return new SessionArtifact[i10];
        }
    }

    public SessionArtifact(String taskId, String name, int i10, long j10, String str, String str2, String str3, String str4, String str5, String str6, Long l10, String str7) {
        p.i(taskId, "taskId");
        p.i(name, "name");
        this.taskId = taskId;
        this.name = name;
        this.iconRes = i10;
        this.createdAt = j10;
        this.fileId = str;
        this.sessionId = str2;
        this.cloudPath = str3;
        this.mimeType = str4;
        this.fileName = str5;
        this.title = str6;
        this.size = l10;
        this.previewUrl = str7;
    }

    public static /* synthetic */ SessionArtifact copy$default(SessionArtifact sessionArtifact, String str, String str2, int i10, long j10, String str3, String str4, String str5, String str6, String str7, String str8, Long l10, String str9, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = sessionArtifact.taskId;
        }
        return sessionArtifact.copy(str, (i11 & 2) != 0 ? sessionArtifact.name : str2, (i11 & 4) != 0 ? sessionArtifact.iconRes : i10, (i11 & 8) != 0 ? sessionArtifact.createdAt : j10, (i11 & 16) != 0 ? sessionArtifact.fileId : str3, (i11 & 32) != 0 ? sessionArtifact.sessionId : str4, (i11 & 64) != 0 ? sessionArtifact.cloudPath : str5, (i11 & 128) != 0 ? sessionArtifact.mimeType : str6, (i11 & 256) != 0 ? sessionArtifact.fileName : str7, (i11 & 512) != 0 ? sessionArtifact.title : str8, (i11 & 1024) != 0 ? sessionArtifact.size : l10, (i11 & 2048) != 0 ? sessionArtifact.previewUrl : str9);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component11, reason: from getter */
    public final Long getSize() {
        return this.size;
    }

    /* renamed from: component12, reason: from getter */
    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final int getIconRes() {
        return this.iconRes;
    }

    /* renamed from: component4, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getCloudPath() {
        return this.cloudPath;
    }

    /* renamed from: component8, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* renamed from: component9, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    public final SessionArtifact copy(String taskId, String name, int iconRes, long createdAt, String fileId, String sessionId, String cloudPath, String mimeType, String fileName, String title, Long size, String previewUrl) {
        p.i(taskId, "taskId");
        p.i(name, "name");
        return new SessionArtifact(taskId, name, iconRes, createdAt, fileId, sessionId, cloudPath, mimeType, fileName, title, size, previewUrl);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionArtifact)) {
            return false;
        }
        SessionArtifact sessionArtifact = (SessionArtifact) other;
        return p.d(this.taskId, sessionArtifact.taskId) && p.d(this.name, sessionArtifact.name) && this.iconRes == sessionArtifact.iconRes && this.createdAt == sessionArtifact.createdAt && p.d(this.fileId, sessionArtifact.fileId) && p.d(this.sessionId, sessionArtifact.sessionId) && p.d(this.cloudPath, sessionArtifact.cloudPath) && p.d(this.mimeType, sessionArtifact.mimeType) && p.d(this.fileName, sessionArtifact.fileName) && p.d(this.title, sessionArtifact.title) && p.d(this.size, sessionArtifact.size) && p.d(this.previewUrl, sessionArtifact.previewUrl);
    }

    public final String getCloudPath() {
        return this.cloudPath;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPreviewUrl() {
        return this.previewUrl;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final Long getSize() {
        return this.size;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int iHashCode = ((((((this.taskId.hashCode() * 31) + this.name.hashCode()) * 31) + Integer.hashCode(this.iconRes)) * 31) + Long.hashCode(this.createdAt)) * 31;
        String str = this.fileId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sessionId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cloudPath;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.mimeType;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.fileName;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.title;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Long l10 = this.size;
        int iHashCode8 = (iHashCode7 + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str7 = this.previewUrl;
        return iHashCode8 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "SessionArtifact(taskId=" + this.taskId + ", name=" + this.name + ", iconRes=" + this.iconRes + ", createdAt=" + this.createdAt + ", fileId=" + this.fileId + ", sessionId=" + this.sessionId + ", cloudPath=" + this.cloudPath + ", mimeType=" + this.mimeType + ", fileName=" + this.fileName + ", title=" + this.title + ", size=" + this.size + ", previewUrl=" + this.previewUrl + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.taskId);
        dest.writeString(this.name);
        dest.writeInt(this.iconRes);
        dest.writeLong(this.createdAt);
        dest.writeString(this.fileId);
        dest.writeString(this.sessionId);
        dest.writeString(this.cloudPath);
        dest.writeString(this.mimeType);
        dest.writeString(this.fileName);
        dest.writeString(this.title);
        Long l10 = this.size;
        if (l10 == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeLong(l10.longValue());
        }
        dest.writeString(this.previewUrl);
    }

    public /* synthetic */ SessionArtifact(String str, String str2, int i10, long j10, String str3, String str4, String str5, String str6, String str7, String str8, Long l10, String str9, int i11, i iVar) {
        this(str, str2, i10, j10, (i11 & 16) != 0 ? null : str3, (i11 & 32) != 0 ? null : str4, (i11 & 64) != 0 ? null : str5, (i11 & 128) != 0 ? null : str6, (i11 & 256) != 0 ? null : str7, (i11 & 512) != 0 ? null : str8, (i11 & 1024) != 0 ? null : l10, (i11 & 2048) != 0 ? null : str9);
    }
}
