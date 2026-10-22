package com.stepos.aiengine.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.foundation.b;
import androidx.constraintlayout.core.dsl.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 82\u00020\u0001:\u00018BO\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0017J\u0010\u0010\u001c\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0017J\u0010\u0010\u001d\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0019J\u0010\u0010 \u001a\u00020\bHÆ\u0003¢\u0006\u0004\b \u0010\u001eJ\u0010\u0010!\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b!\u0010\u0017J\u0010\u0010\"\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\"\u0010\u0017Jj\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b%\u0010\u0019J\u0010\u0010&\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b&\u0010\u0017J\u001a\u0010*\u001a\u00020)2\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010,\u001a\u0004\b-\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010,\u001a\u0004\b.\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010/\u001a\u0004\b0\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010/\u001a\u0004\b1\u0010\u0017R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u00102\u001a\u0004\b3\u0010\u001eR\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010,\u001a\u0004\b4\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000b\u00102\u001a\u0004\b5\u0010\u001eR\u0017\u0010\f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\f\u0010/\u001a\u0004\b6\u0010\u0017R\u0017\u0010\r\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010/\u001a\u0004\b7\u0010\u0017¨\u00069"}, d2 = {"Lcom/stepos/aiengine/model/AvailableModelInfo;", "Landroid/os/Parcelable;", "", "otaName", "abilityId", "", "remoteVersionCode", "localVersionCode", "", "fileSize", "updateInfo", "updateTime", "installStatus", "downloadProgress", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;IIJLjava/lang/String;JII)V", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "()J", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;IIJLjava/lang/String;JII)Lcom/stepos/aiengine/model/AvailableModelInfo;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getOtaName", "getAbilityId", "I", "getRemoteVersionCode", "getLocalVersionCode", "J", "getFileSize", "getUpdateInfo", "getUpdateTime", "getInstallStatus", "getDownloadProgress", "Companion", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AvailableModelInfo implements Parcelable {
    public static final int STATUS_DOWNLOADING = 4;
    public static final int STATUS_INSTALLED = 2;
    public static final int STATUS_NOT_AVAILABLE = 0;
    public static final int STATUS_NOT_INSTALLED = 1;
    public static final int STATUS_UPDATE_AVAILABLE = 3;
    private final String abilityId;
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
            k.f(parcel, "parcel");
            return new AvailableModelInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AvailableModelInfo[] newArray(int i) {
            return new AvailableModelInfo[i];
        }
    }

    public AvailableModelInfo(String otaName, String abilityId, int i, int i6, long j5, String updateInfo, long j6, int i10, int i11) {
        k.f(otaName, "otaName");
        k.f(abilityId, "abilityId");
        k.f(updateInfo, "updateInfo");
        this.otaName = otaName;
        this.abilityId = abilityId;
        this.remoteVersionCode = i;
        this.localVersionCode = i6;
        this.fileSize = j5;
        this.updateInfo = updateInfo;
        this.updateTime = j6;
        this.installStatus = i10;
        this.downloadProgress = i11;
    }

    public static /* synthetic */ AvailableModelInfo copy$default(AvailableModelInfo availableModelInfo, String str, String str2, int i, int i6, long j5, String str3, long j6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = availableModelInfo.otaName;
        }
        if ((i12 & 2) != 0) {
            str2 = availableModelInfo.abilityId;
        }
        if ((i12 & 4) != 0) {
            i = availableModelInfo.remoteVersionCode;
        }
        if ((i12 & 8) != 0) {
            i6 = availableModelInfo.localVersionCode;
        }
        if ((i12 & 16) != 0) {
            j5 = availableModelInfo.fileSize;
        }
        if ((i12 & 32) != 0) {
            str3 = availableModelInfo.updateInfo;
        }
        if ((i12 & 64) != 0) {
            j6 = availableModelInfo.updateTime;
        }
        if ((i12 & 128) != 0) {
            i10 = availableModelInfo.installStatus;
        }
        if ((i12 & 256) != 0) {
            i11 = availableModelInfo.downloadProgress;
        }
        String str4 = str3;
        long j10 = j5;
        int i13 = i;
        int i14 = i6;
        return availableModelInfo.copy(str, str2, i13, i14, j10, str4, j6, i10, i11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOtaName() {
        return this.otaName;
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

    public final AvailableModelInfo copy(String otaName, String abilityId, int remoteVersionCode, int localVersionCode, long fileSize, String updateInfo, long updateTime, int installStatus, int downloadProgress) {
        k.f(otaName, "otaName");
        k.f(abilityId, "abilityId");
        k.f(updateInfo, "updateInfo");
        return new AvailableModelInfo(otaName, abilityId, remoteVersionCode, localVersionCode, fileSize, updateInfo, updateTime, installStatus, downloadProgress);
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
        return k.b(this.otaName, availableModelInfo.otaName) && k.b(this.abilityId, availableModelInfo.abilityId) && this.remoteVersionCode == availableModelInfo.remoteVersionCode && this.localVersionCode == availableModelInfo.localVersionCode && this.fileSize == availableModelInfo.fileSize && k.b(this.updateInfo, availableModelInfo.updateInfo) && this.updateTime == availableModelInfo.updateTime && this.installStatus == availableModelInfo.installStatus && this.downloadProgress == availableModelInfo.downloadProgress;
    }

    public final String getAbilityId() {
        return this.abilityId;
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
        return Integer.hashCode(this.downloadProgress) + a.a(this.installStatus, androidx.appfunctions.metadata.a.c(B7.a.c(androidx.appfunctions.metadata.a.c(a.a(this.localVersionCode, a.a(this.remoteVersionCode, B7.a.c(this.otaName.hashCode() * 31, 31, this.abilityId), 31), 31), 31, this.fileSize), 31, this.updateInfo), 31, this.updateTime), 31);
    }

    public String toString() {
        String str = this.otaName;
        String str2 = this.abilityId;
        int i = this.remoteVersionCode;
        int i6 = this.localVersionCode;
        long j5 = this.fileSize;
        String str3 = this.updateInfo;
        long j6 = this.updateTime;
        int i10 = this.installStatus;
        int i11 = this.downloadProgress;
        StringBuilder sbW = B7.a.w("AvailableModelInfo(otaName=", str, ", abilityId=", str2, ", remoteVersionCode=");
        a.y(sbW, i, ", localVersionCode=", i6, ", fileSize=");
        sbW.append(j5);
        sbW.append(", updateInfo=");
        sbW.append(str3);
        b.y(j6, ", updateTime=", ", installStatus=", sbW);
        sbW.append(i10);
        sbW.append(", downloadProgress=");
        sbW.append(i11);
        sbW.append(")");
        return sbW.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeString(this.otaName);
        dest.writeString(this.abilityId);
        dest.writeInt(this.remoteVersionCode);
        dest.writeInt(this.localVersionCode);
        dest.writeLong(this.fileSize);
        dest.writeString(this.updateInfo);
        dest.writeLong(this.updateTime);
        dest.writeInt(this.installStatus);
        dest.writeInt(this.downloadProgress);
    }
}
