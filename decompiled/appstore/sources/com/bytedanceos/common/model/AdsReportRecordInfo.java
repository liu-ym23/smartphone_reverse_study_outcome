package com.bytedanceos.common.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;

/* JADX INFO: loaded from: classes2.dex */
public class AdsReportRecordInfo {
    public static final int HTTP_REQUEST_PARAMS_INSTALL = 0;
    public static final int HTTP_REQUEST_PARAMS_UPDATE = 1;
    public static final int MAX_RETRIES_PER_DAY = 5;
    public static final int MAX_RETRY_DAYS = 2;
    public static final int TASK_OWNER_APPSTORE = 1;
    public static final int TASK_OWNER_GAMESTORE = 2;
    public int mAppUpdate;
    public long mEventTime;
    public int mEventType;
    public int mID;
    public String mReportUrl;
    public int mRetriedCount;
    public int mTaskOwner;
    public String mTitle;
    public String mUrlMD5;

    public AdsReportRecordInfo() {
    }

    public static AdsReportRecordInfo buildInstance(String r10, String r11, int r12) {
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return null;
    L6:
        AdsReportRecordInfo r13 = new AdsReportRecordInfo();
        r13.mTitle = r10;
        r13.mReportUrl = r11;
        r13.mEventType = r12;
        if (BaseApplication.c().o() == false) goto L9;
        r13.mTaskOwner = 1;
    L10:
        r13.mEventTime = System.currentTimeMillis();
        return r13;
    L9:
        r13.mTaskOwner = 2;
        goto L10
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if (r10 != null) goto L9;
        return false;
    L9:
        if ((r10 instanceof AdsReportRecordInfo) == true) goto L11;
        return false;
    L11:
        return TextUtils.equals(this.mReportUrl, ((AdsReportRecordInfo) r10).mReportUrl);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setAppUpdate(boolean r10) {
        if (r10 == false) goto L4;
        this.mAppUpdate = 1;
        return;
    L4:
        this.mAppUpdate = 0;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(this.mTitle);
        r10.append(":");
        r10.append(this.mEventType);
        r10.append(":");
        String r11 = this.mReportUrl;
        if (r11 == null) goto L6;
        r10.append(Uri.parse(r11).getHost());
    L6:
        return r10.toString();
    }
}
