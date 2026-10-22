package com.bytedanceos.common.model;

import android.text.TextUtils;
import com.bytedanceos.common.toolbox.ServerElements;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class GiftPackInfo extends GameModel {
    public String fileMd5;
    public boolean isReceived;
    public long mAppByte;
    public String mAppDownloadUrl;
    public String mAppName;
    public int mAppType;
    public String mContent;
    public int mCount;
    public long mEndTime;
    public String mGiftPackCode;
    public String mInstuction;
    public long mStartTime;

    public GiftPackInfo(JSONObject r10, int r11) {
        boolean r12 = false;
        this.isReceived = false;
        this.fileMd5 = "";
        this.mId = r10.optString("id");
        this.mName = r10.optString("name");
        this.mContent = r10.optString(ServerElements.CONTENT);
        this.mCount = r10.optInt(ServerElements.GAME_GIFT_PACK_COUNT);
        this.mGiftPackCode = r10.optString(ServerElements.CODE);
        this.mPackageName = r10.optString("package");
        this.mLogo = r10.optString(ServerElements.LOGO);
        this.mStartTime = r10.optLong("start_time") * 1000;
        this.mEndTime = r10.optLong("end_time") * 1000;
        this.mInstuction = r10.optString(ServerElements.GAME_GIFT_INSTUCTION);
        this.mAppName = r10.optString("app_name");
        if (r10.optInt(ServerElements.GAME_GIFT_RECEIVED, 0) != 1) goto L5;
        r12 = true;
    L5:
        this.isReceived = r12;
        this.mAppDownloadUrl = r10.optString("app_download_url");
        this.fileMd5 = r10.optString(ServerElements.FILE_MD5);
        this.mAppByte = r10.optLong(ServerElements.FILESIZE);
        this.mAppType = r11;
    }

    public AppInfo convertToAppInfo() {
        AppInfo r10 = new AppInfo();
        r10.appId = this.mId;
        r10.appName = this.mAppName;
        r10.appPackageName = this.mPackageName;
        r10.appSource = "local";
        r10.appDownloadUrl = this.mAppDownloadUrl;
        r10.mGiftPackCode = this.mGiftPackCode;
        r10.appIcon = this.mLogo;
        r10.appBytes = this.mAppByte;
        r10.mApiUrl = this.mApiurl;
        r10.mAppType = this.mAppType;
        r10.fileMd5 = this.fileMd5;
        return r10;
    }

    public boolean equals(Object r10) {
        if (r10 != null) goto L5;
    L15:
        return false;
    L5:
        if ((r10 instanceof GiftPackInfo) == false) goto L15;
        GiftPackInfo r11 = (GiftPackInfo) r10;
        if (TextUtils.equals(r11.mId, this.mId) == false) goto L15;
        if (TextUtils.equals(r11.mName, this.mName) == false) goto L15;
        if (TextUtils.equals(r11.mGiftPackCode, this.mGiftPackCode) == false) goto L15;
        return true;
    }

    public int hashCode() {
        return (this.mName + this.mId + this.mGiftPackCode).hashCode();
    }
}
