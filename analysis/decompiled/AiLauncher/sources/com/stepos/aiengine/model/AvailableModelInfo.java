package com.stepos.aiengine.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0001;BY\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0018J\u0010\u0010\u001d\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0018J\u0010\u0010\u001e\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u001aJ\u0010\u0010!\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b!\u0010\u001fJ\u0010\u0010\"\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\"\u0010\u0018J\u0010\u0010#\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b#\u0010\u0018J\u0010\u0010$\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\u001aJt\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b%\u0010&J\u0010\u0010'\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b'\u0010\u001aJ\u0010\u0010(\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b(\u0010\u0018J\u001a\u0010,\u001a\u00020+2\b\u0010*\u001a\u0004\u0018\u00010)HÖ\u0003¢\u0006\u0004\b,\u0010-R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010.\u001a\u0004\b/\u0010\u001aR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010.\u001a\u0004\b0\u0010\u001aR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u00101\u001a\u0004\b2\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u00101\u001a\u0004\b3\u0010\u0018R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00104\u001a\u0004\b5\u0010\u001fR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010.\u001a\u0004\b6\u0010\u001aR\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000b\u00104\u001a\u0004\b7\u0010\u001fR\u0017\u0010\f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u00101\u001a\u0004\b8\u0010\u0018R\u0017\u0010\r\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u00101\u001a\u0004\b9\u0010\u0018R\u0017\u0010\u000e\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000e\u0010.\u001a\u0004\b:\u0010\u001a¨\u0006<"}, d2 = {"Lcom/stepos/aiengine/model/AvailableModelInfo;", "Landroid/os/Parcelable;", "", "otaName", "abilityId", "", "remoteVersionCode", "localVersionCode", "", "fileSize", "updateInfo", "updateTime", "installStatus", "downloadProgress", "displayDir", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIJLjava/lang/String;JIILjava/lang/String;)V", "Landroid/os/Parcel;", "dest", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "()J", "component6", "component7", "component8", "component9", "component10", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;IIJLjava/lang/String;JIILjava/lang/String;)Lcom/stepos/aiengine/model/AvailableModelInfo;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getOtaName", "getAbilityId", "I", "getRemoteVersionCode", "getLocalVersionCode", "J", "getFileSize", "getUpdateInfo", "getUpdateTime", "getInstallStatus", "getDownloadProgress", "getDisplayDir", "Companion", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AvailableModelInfo implements Parcelable {
    public static final int STATUS_DOWNLOADING = 4;
    public static final int STATUS_INSTALLED = 2;
    public static final int STATUS_INSTALLING = 5;
    public static final int STATUS_NOT_AVAILABLE = 0;
    public static final int STATUS_NOT_INSTALLED = 1;
    public static final int STATUS_UPDATE_AVAILABLE = 3;
    private final String abilityId;
    private final String displayDir;
    private final int downloadProgress;
    private final long fileSize;
    private final int installStatus;
    private final int localVersionCode;
    private final String otaName;
    private final int remoteVersionCode;
    private final String updateInfo;
    private final long updateTime;
    public static final Parcelable.Creator<AvailableModelInfo> CREATOR = new Creator();

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AvailableModelInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AvailableModelInfo createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new AvailableModelInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AvailableModelInfo[] newArray(int i10) {
            return new AvailableModelInfo[i10];
        }
    }

    public AvailableModelInfo(String otaName, String abilityId, int i10, int i11, long j10, String updateInfo, long j11, int i12, int i13, String displayDir) {
        p.i(otaName, "otaName");
        p.i(abilityId, "abilityId");
        p.i(updateInfo, "updateInfo");
        p.i(displayDir, "displayDir");
        this.otaName = otaName;
        this.abilityId = abilityId;
        this.remoteVersionCode = i10;
        this.localVersionCode = i11;
        this.fileSize = j10;
        this.updateInfo = updateInfo;
        this.updateTime = j11;
        this.installStatus = i12;
        this.downloadProgress = i13;
        this.displayDir = displayDir;
    }

    public static /* synthetic */ AvailableModelInfo copy$default(AvailableModelInfo availableModelInfo, String str, String str2, int i10, int i11, long j10, String str3, long j11, int i12, int i13, String str4, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            str = availableModelInfo.otaName;
        }
        if ((i14 & 2) != 0) {
            str2 = availableModelInfo.abilityId;
        }
        if ((i14 & 4) != 0) {
            i10 = availableModelInfo.remoteVersionCode;
        }
        if ((i14 & 8) != 0) {
            i11 = availableModelInfo.localVersionCode;
        }
        if ((i14 & 16) != 0) {
            j10 = availableModelInfo.fileSize;
        }
        if ((i14 & 32) != 0) {
            str3 = availableModelInfo.updateInfo;
        }
        if ((i14 & 64) != 0) {
            j11 = availableModelInfo.updateTime;
        }
        if ((i14 & 128) != 0) {
            i12 = availableModelInfo.installStatus;
        }
        if ((i14 & 256) != 0) {
            i13 = availableModelInfo.downloadProgress;
        }
        if ((i14 & 512) != 0) {
            str4 = availableModelInfo.displayDir;
        }
        String str5 = str4;
        int i15 = i12;
        String str6 = str3;
        long j12 = j10;
        int i16 = i10;
        int i17 = i11;
        return availableModelInfo.copy(str, str2, i16, i17, j12, str6, j11, i15, i13, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOtaName() {
        return this.otaName;
    }

    /* renamed from: component10, reason: from getter */
    public final String getDisplayDir() {
        return this.displayDir;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAbilityId() {
        return this.abilityId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getRemoteVersionCode() {
        return this.remoteVersionCode;
    }

    /* renamed from: component4, reason: from getter */
    public final int getLocalVersionCode() {
        return this.localVersionCode;
    }

    /* renamed from: component5, reason: from getter */
    public final long getFileSize() {
        return this.fileSize;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUpdateInfo() {
        return this.updateInfo;
    }

    /* renamed from: component7, reason: from getter */
    public final long getUpdateTime() {
        return this.updateTime;
    }

    /* renamed from: component8, reason: from getter */
    public final int getInstallStatus() {
        return this.installStatus;
    }

    /* renamed from: component9, reason: from getter */
    public final int getDownloadProgress() {
        return this.downloadProgress;
    }

    public final AvailableModelInfo copy(String otaName, String abilityId, int remoteVersionCode, int localVersionCode, long fileSize, String updateInfo, long updateTime, int installStatus, int downloadProgress, String displayDir) {
        p.i(otaName, "otaName");
        p.i(abilityId, "abilityId");
        p.i(updateInfo, "updateInfo");
        p.i(displayDir, "displayDir");
        return new AvailableModelInfo(otaName, abilityId, remoteVersionCode, localVersionCode, fileSize, updateInfo, updateTime, installStatus, downloadProgress, displayDir);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AvailableModelInfo)) {
            return false;
        }
        AvailableModelInfo availableModelInfo = (AvailableModelInfo) other;
        return p.d(this.otaName, availableModelInfo.otaName) && p.d(this.abilityId, availableModelInfo.abilityId) && this.remoteVersionCode == availableModelInfo.remoteVersionCode && this.localVersionCode == availableModelInfo.localVersionCode && this.fileSize == availableModelInfo.fileSize && p.d(this.updateInfo, availableModelInfo.updateInfo) && this.updateTime == availableModelInfo.updateTime && this.installStatus == availableModelInfo.installStatus && this.downloadProgress == availableModelInfo.downloadProgress && p.d(this.displayDir, availableModelInfo.displayDir);
    }

    public final String getAbilityId() {
        return this.abilityId;
    }

    public final String getDisplayDir() {
        return this.displayDir;
    }

    public final int getDownloadProgress() {
        return this.downloadProgress;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final int getInstallStatus() {
        return this.installStatus;
    }

    public final int getLocalVersionCode() {
        return this.localVersionCode;
    }

    public final String getOtaName() {
        return this.otaName;
    }

    public final int getRemoteVersionCode() {
        return this.remoteVersionCode;
    }

    public final String getUpdateInfo() {
        return this.updateInfo;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public int hashCode() {
        return (((((((((((((((((this.otaName.hashCode() * 31) + this.abilityId.hashCode()) * 31) + Integer.hashCode(this.remoteVersionCode)) * 31) + Integer.hashCode(this.localVersionCode)) * 31) + Long.hashCode(this.fileSize)) * 31) + this.updateInfo.hashCode()) * 31) + Long.hashCode(this.updateTime)) * 31) + Integer.hashCode(this.installStatus)) * 31) + Integer.hashCode(this.downloadProgress)) * 31) + this.displayDir.hashCode();
    }

    public String toString() {
        return "AvailableModelInfo(otaName=" + this.otaName + ", abilityId=" + this.abilityId + ", remoteVersionCode=" + this.remoteVersionCode + ", localVersionCode=" + this.localVersionCode + ", fileSize=" + this.fileSize + ", updateInfo=" + this.updateInfo + ", updateTime=" + this.updateTime + ", installStatus=" + this.installStatus + ", downloadProgress=" + this.downloadProgress + ", displayDir=" + this.displayDir + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        p.i(dest, "dest");
        dest.writeString(this.otaName);
        dest.writeString(this.abilityId);
        dest.writeInt(this.remoteVersionCode);
        dest.writeInt(this.localVersionCode);
        dest.writeLong(this.fileSize);
        dest.writeString(this.updateInfo);
        dest.writeLong(this.updateTime);
        dest.writeInt(this.installStatus);
        dest.writeInt(this.downloadProgress);
        dest.writeString(this.displayDir);
    }

    public /* synthetic */ AvailableModelInfo(String str, String str2, int i10, int i11, long j10, String str3, long j11, int i12, int i13, String str4, int i14, i iVar) {
        this(str, str2, i10, i11, j10, str3, j11, i12, i13, (i14 & 512) != 0 ? "" : str4);
    }
}
