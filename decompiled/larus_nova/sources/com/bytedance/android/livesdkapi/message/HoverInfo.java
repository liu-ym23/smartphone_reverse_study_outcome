package com.bytedance.android.livesdkapi.message;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class HoverInfo {

    @SerializedName("duration")
    public long duration;

    @SerializedName("duration_involve_display_time")
    public long durationInvolveDisplayTime;

    @SerializedName("duration_threshold")
    public long durationThreshold;

    @SerializedName("is_hover")
    public boolean isHover;

    @SerializedName("priority")
    public long priority;

    public HoverInfo() {
    }
}
