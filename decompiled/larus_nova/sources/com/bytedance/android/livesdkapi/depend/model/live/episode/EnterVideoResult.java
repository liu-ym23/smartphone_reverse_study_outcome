package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class EnterVideoResult {

    @SerializedName("episode")
    public Episode episode;

    @SerializedName("vid_is_valid")
    public boolean isVidValid;

    @SerializedName("more")
    public MoreSpectacular more;

    @SerializedName("not_report_pv")
    public boolean notReportPV;

    public EnterVideoResult() {
        this.notReportPV = false;
    }
}
