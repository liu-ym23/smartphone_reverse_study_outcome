package com.bytedance.android.livesdkapi.depend.model.backtrace;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class AudienceBackRecordData {

    @SerializedName("end_time")
    public long endTime;

    @SerializedName("execution_id")
    public String executionId;

    @SerializedName("play_url")
    public String m3u8Url;

    @SerializedName(ILoadStallMonitor.START_TIME)
    public long startTime;

    @SerializedName("wait_timeout_seconds")
    public long timeOutSeconds;

    @SerializedName("ts_urls")
    public List<String> tsUrls;

    @SerializedName("approximate_wait_seconds")
    public long waitSeconds;

    public AudienceBackRecordData() {
        this.m3u8Url = null;
        this.tsUrls = null;
    }
}
