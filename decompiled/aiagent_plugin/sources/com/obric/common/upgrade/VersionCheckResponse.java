package com.obric.common.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import d.h.b.o;

/* JADX INFO: compiled from: VersionCheckResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class VersionCheckResponse implements Parcelable {
    public static final CREATOR CREATOR = null;
    private String apkPath;
    private final String apkUrl;
    private int errorCode;
    private final boolean hasNewVersion;
    private boolean isNewDownload;
    private final String md5;
    private long taskId;
    private final String upgradeInfo;
    private final int upgradeMode;
    private final long versionCode;
    private final String versionName;

    /* JADX INFO: compiled from: VersionCheckResponse.kt */
    public static final class CREATOR implements Parcelable.Creator<VersionCheckResponse> {
        public /* synthetic */ CREATOR(d.h.b.h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ VersionCheckResponse createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ VersionCheckResponse[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VersionCheckResponse createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new VersionCheckResponse(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VersionCheckResponse[] newArray(int r1) {
            return new VersionCheckResponse[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VersionCheckResponse(boolean r2, long r3, String r5, String r6, String r7, int r8, String r9, String r10, int r11, boolean r12, long r13) {
        o.e(r5, "versionName");
        o.e(r6, "apkUrl");
        o.e(r7, "md5");
        this.hasNewVersion = r2;
        this.versionCode = r3;
        this.versionName = r5;
        this.apkUrl = r6;
        this.md5 = r7;
        this.upgradeMode = r8;
        this.upgradeInfo = r9;
        this.apkPath = r10;
        this.errorCode = r11;
        this.isNewDownload = r12;
        this.taskId = r13;
    }

    public /* synthetic */ VersionCheckResponse(boolean r17, long r18, String r20, String r21, String r22, int r23, String r24, String r25, int r26, boolean r27, long r28, int r30, d.h.b.h r31) {
        if ((r30 & 64) == 0) goto L5;
        String r10 = "";
    L7:
        if ((r30 & 128) == 0) goto L9;
        String r11 = null;
    L11:
        if ((r30 & 256) == 0) goto L13;
        int r12 = 0;
    L15:
        if ((r30 & 512) == 0) goto L17;
        boolean r13 = true;
    L19:
        if ((r30 & 1024) == 0) goto L21;
        long r14 = 0;
    L22:
        this(r17, r18, r20, r21, r22, r23, r10, r11, r12, r13, r14);
        return;
    L21:
        r14 = r28;
        goto L22
    L17:
        r13 = r27;
        goto L19
    L13:
        r12 = r26;
        goto L15
    L9:
        r11 = r25;
        goto L11
    L5:
        r10 = r24;
        goto L7
    }

    public final boolean getHasNewVersion() {
        return this.hasNewVersion;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final String getApkUrl() {
        return this.apkUrl;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final int getUpgradeMode() {
        return this.upgradeMode;
    }

    public final String getUpgradeInfo() {
        return this.upgradeInfo;
    }

    public final String getApkPath() {
        return this.apkPath;
    }

    public final void setApkPath(String r1) {
        this.apkPath = r1;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int r1) {
        this.errorCode = r1;
    }

    public final boolean isNewDownload() {
        return this.isNewDownload;
    }

    public final void setNewDownload(boolean r1) {
        this.isNewDownload = r1;
    }

    public final long getTaskId() {
        return this.taskId;
    }

    public final void setTaskId(long r1) {
        this.taskId = r1;
    }

    public VersionCheckResponse(Parcel r19) {
        o.e(r19, "parcel");
        if (r19.readByte() == 0) goto L5;
        boolean r5 = true;
    L6:
        long r6 = r19.readLong();
        String r8 = r19.readString();
        o.a(r8);
        String r9 = r19.readString();
        o.a(r9);
        String r10 = r19.readString();
        o.a(r10);
        int r11 = r19.readInt();
        String r12 = r19.readString();
        String r13 = r19.readString();
        int r14 = r19.readInt();
        if (r19.readByte() == 0) goto L9;
        boolean r15 = true;
    L10:
        this(r5, r6, r8, r9, r10, r11, r12, r13, r14, r15, r19.readLong());
        return;
    L9:
        r15 = false;
        goto L10
    L5:
        r5 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "parcel");
        r3.writeByte(this.hasNewVersion ? 1 : 0);
        r3.writeLong(this.versionCode);
        r3.writeString(this.versionName);
        r3.writeString(this.apkUrl);
        r3.writeString(this.md5);
        r3.writeInt(this.upgradeMode);
        r3.writeString(this.upgradeInfo);
        r3.writeString(this.apkPath);
        r3.writeInt(this.errorCode);
        r3.writeByte(this.isNewDownload ? 1 : 0);
        r3.writeLong(this.taskId);
    }
}
