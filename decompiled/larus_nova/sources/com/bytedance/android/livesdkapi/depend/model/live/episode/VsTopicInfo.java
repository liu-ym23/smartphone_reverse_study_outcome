package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.google.gson.annotations.SerializedName;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
public class VsTopicInfo {

    @SerializedName("challenge_id")
    public long challengeId;

    @SerializedName("cover")
    public k cover;

    @SerializedName("is_commerce")
    public boolean isCommerce;

    @SerializedName("play_count")
    public long playCount;

    @SerializedName("see_time")
    public TimePoint timePoint;

    @SerializedName("challenge_name")
    public String title;

    public static class TimePoint {

        @SerializedName("duration")
        public long duration;

        @SerializedName("start")
        public long start;

        public TimePoint() {
        }
    }

    public VsTopicInfo() {
    }
}
