package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class LiveLogFlushConfig {

    @SerializedName("enable_draw_duration_onemin")
    public boolean mEnableDrawDurationOnemin;

    @SerializedName("enable_draw_exit_room")
    public boolean mEnableDrawExitRoom;

    @SerializedName("enable_preview_click")
    public boolean mEnablePreviewClick;

    @SerializedName("enable_preview_duration")
    public boolean mEnablePreviewDuration;

    @SerializedName("enable_preview_duration_limit")
    public long mEnablePreviewDurationLimit;

    public LiveLogFlushConfig() {
        this.mEnableDrawExitRoom = false;
        this.mEnableDrawDurationOnemin = false;
        this.mEnablePreviewClick = false;
        this.mEnablePreviewDuration = false;
        this.mEnablePreviewDurationLimit = 60000;
    }
}
