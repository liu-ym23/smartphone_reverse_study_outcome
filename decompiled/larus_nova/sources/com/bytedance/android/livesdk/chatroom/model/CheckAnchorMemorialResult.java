package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;

/* JADX INFO: loaded from: classes7.dex */
public class CheckAnchorMemorialResult {

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    public int interval;

    @SerializedName("is_memorial")
    public boolean isMemorial;

    public CheckAnchorMemorialResult() {
    }
}
