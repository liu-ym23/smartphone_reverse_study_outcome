package com.stepos.aiengine.model;

import ai.onnxruntime.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AvailableModelInfo implements Parcelable {
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
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<AvailableModelInfo> CREATOR = new Creator();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Creator implements Parcelable.Creator<AvailableModelInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AvailableModelInfo createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new AvailableModelInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readLong(), parcel.readInt(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AvailableModelInfo[] newArray(int i10) {
            return new AvailableModelInfo[i10];
        }
    }

    public AvailableModelInfo(String otaName, String abilityId, int i10, int i11, long j10, String updateInfo, long j11, int i12, int i13, String displayDir) {
        g.f(otaName, "otaName");
        g.f(abilityId, "abilityId");
        g.f(updateInfo, "updateInfo");
        g.f(displayDir, "displayDir");
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
        if ((i14 & TraceIdKeys.MAX_LENGTH) != 0) {
            i12 = availableModelInfo.installStatus;
        }
        if ((i14 & 256) != 0) {
            i13 = availableModelInfo.downloadProgress;
        }
        if ((i14 & VadSessionManager.FRAME_BYTES) != 0) {
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

    public final String component1() {
        return this.otaName;
    }

    public final String component10() {
        return this.displayDir;
    }

    public final String component2() {
        return this.abilityId;
    }

    public final int component3() {
        return this.remoteVersionCode;
    }

    public final int component4() {
        return this.localVersionCode;
    }

    public final long component5() {
        return this.fileSize;
    }

    public final String component6() {
        return this.updateInfo;
    }

    public final long component7() {
        return this.updateTime;
    }

    public final int component8() {
        return this.installStatus;
    }

    public final int component9() {
        return this.downloadProgress;
    }

    public final AvailableModelInfo copy(String otaName, String abilityId, int i10, int i11, long j10, String updateInfo, long j11, int i12, int i13, String displayDir) {
        g.f(otaName, "otaName");
        g.f(abilityId, "abilityId");
        g.f(updateInfo, "updateInfo");
        g.f(displayDir, "displayDir");
        return new AvailableModelInfo(otaName, abilityId, i10, i11, j10, updateInfo, j11, i12, i13, displayDir);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AvailableModelInfo)) {
            return false;
        }
        AvailableModelInfo availableModelInfo = (AvailableModelInfo) obj;
        return g.b(this.otaName, availableModelInfo.otaName) && g.b(this.abilityId, availableModelInfo.abilityId) && this.remoteVersionCode == availableModelInfo.remoteVersionCode && this.localVersionCode == availableModelInfo.localVersionCode && this.fileSize == availableModelInfo.fileSize && g.b(this.updateInfo, availableModelInfo.updateInfo) && this.updateTime == availableModelInfo.updateTime && this.installStatus == availableModelInfo.installStatus && this.downloadProgress == availableModelInfo.downloadProgress && g.b(this.displayDir, availableModelInfo.displayDir);
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
        return this.displayDir.hashCode() + a.d(this.downloadProgress, a.d(this.installStatus, a0.a.c(d.a(a0.a.c(a.d(this.localVersionCode, a.d(this.remoteVersionCode, d.a(this.otaName.hashCode() * 31, 31, this.abilityId), 31), 31), this.fileSize, 31), 31, this.updateInfo), this.updateTime, 31), 31), 31);
    }

    public String toString() {
        String str = this.otaName;
        String str2 = this.abilityId;
        int i10 = this.remoteVersionCode;
        int i11 = this.localVersionCode;
        long j10 = this.fileSize;
        String str3 = this.updateInfo;
        long j11 = this.updateTime;
        int i12 = this.installStatus;
        int i13 = this.downloadProgress;
        String str4 = this.displayDir;
        StringBuilder sbS = a.s("AvailableModelInfo(otaName=", str, ", abilityId=", str2, ", remoteVersionCode=");
        h0.e.l(sbS, i10, ", localVersionCode=", i11, ", fileSize=");
        a.u(j10, ", updateInfo=", str3, sbS);
        a0.a.s(j11, ", updateTime=", ", installStatus=", sbS);
        h0.e.l(sbS, i12, ", downloadProgress=", i13, ", displayDir=");
        return a.o(sbS, str4, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
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

    public /* synthetic */ AvailableModelInfo(String str, String str2, int i10, int i11, long j10, String str3, long j11, int i12, int i13, String str4, int i14, e eVar) {
        this(str, str2, i10, i11, j10, str3, j11, i12, i13, (i14 & VadSessionManager.FRAME_BYTES) != 0 ? "" : str4);
    }
}
