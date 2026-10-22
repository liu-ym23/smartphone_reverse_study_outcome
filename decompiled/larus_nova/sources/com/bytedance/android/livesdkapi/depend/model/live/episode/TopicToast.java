package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class TopicToast {

    @SerializedName("content")
    public String content;

    @SerializedName("end_time")
    public long endTime;

    @SerializedName("schema")
    public String schema;

    @SerializedName(ILoadStallMonitor.START_TIME)
    public long startTime;

    @SerializedName("toast_id")
    public String toastId;

    public TopicToast() {
    }
}
