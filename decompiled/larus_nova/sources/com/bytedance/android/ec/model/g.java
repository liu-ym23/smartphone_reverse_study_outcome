package com.bytedance.android.ec.model;

import com.bytedance.android.ec.model.api.LogPbData;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes44.dex */
public abstract class g {
    public static final int STATUS_CODE_SUCCESS = 0;
    public static final int STATUS_COMMERCE_PERMISSION_DENIED = 11272;
    public Long ecNetRequestEnd;

    @SerializedName("log_pb")
    public LogPbData logPb;

    @SerializedName("status_code")
    public int statusCode;

    @SerializedName("status_msg")
    public String statusMessage;
    public Object ttNetExtraInfo;

    public g() {
    }

    public String getLogId() {
        LogPbData r100 = this.logPb;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getImprId();
    }
}
