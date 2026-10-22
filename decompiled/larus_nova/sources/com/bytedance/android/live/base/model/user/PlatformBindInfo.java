package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class PlatformBindInfo {
    public static final int HASH_31 = 31;

    @SerializedName("allow_sync")
    private boolean allowSync;

    @SerializedName("bind_user_name")
    private String bindUserName;

    @SerializedName("platform")
    private String platform;

    @SerializedName("publish_sync_tips_cnt")
    private int publishSyncTipsCnt;

    @SerializedName("tigger_full_sync")
    private boolean tiggerFullSync;

    public PlatformBindInfo() {
    }

    public int hashCode() {
        String r100 = this.platform;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((((r102 * 31) + (this.allowSync ? 1 : 0)) * 31) + (this.tiggerFullSync ? 1 : 0)) * 31;
        String r104 = this.bindUserName;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.publishSyncTipsCnt;
    L5:
        r102 = 0;
        goto L6
    }

    public String getBindUserName() {
        return this.bindUserName;
    }

    public String getPlatform() {
        return this.platform;
    }

    public int getPublishSyncTipsCnt() {
        return this.publishSyncTipsCnt;
    }

    public boolean isAllowSync() {
        return this.allowSync;
    }

    public boolean isTiggerFullSync() {
        return this.tiggerFullSync;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L34:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L34;
        PlatformBindInfo r101 = (PlatformBindInfo) r100;
        if (this.allowSync == r101.allowSync) goto L14;
        return false;
    L14:
        if (this.tiggerFullSync == r101.tiggerFullSync) goto L17;
        return false;
    L17:
        if (this.publishSyncTipsCnt == r101.publishSyncTipsCnt) goto L19;
        return false;
    L19:
        String r102 = this.platform;
        if (r102 == null) goto L25;
        if (r102.equals(r101.platform) == false) goto L26;
    L27:
        String r103 = this.bindUserName;
        String r104 = r101.bindUserName;
        if (r103 != null) goto L35;
        if (r104 == null) goto L36;
        return false;
    L36:
        return true;
    L35:
        return r103.equals(r104);
    L26:
        return false;
    L25:
        if (r101.platform == null) goto L27;
        goto L26
    }

    public void setAllowSync(boolean r100) {
        this.allowSync = r100;
    }

    public void setBindUserName(String r100) {
        this.bindUserName = r100;
    }

    public void setPlatform(String r100) {
        this.platform = r100;
    }

    public void setPublishSyncTipsCnt(int r100) {
        this.publishSyncTipsCnt = r100;
    }

    public void setTiggerFullSync(boolean r100) {
        this.tiggerFullSync = r100;
    }
}
