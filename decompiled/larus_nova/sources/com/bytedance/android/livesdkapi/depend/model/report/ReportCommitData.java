package com.bytedance.android.livesdkapi.depend.model.report;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes12.dex */
public class ReportCommitData {

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    public String desc;

    @SerializedName("record_id")
    public long recordId;

    @SerializedName("report_id")
    public long reportId;

    @SerializedName("status")
    public long status;

    public ReportCommitData() {
    }
}
