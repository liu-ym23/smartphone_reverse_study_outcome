package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class LivePlayerSeekMsgTextConfig {

    @SerializedName("audience_close_public_screen")
    public String audienceClosePublicScreen;

    @SerializedName("audience_close_toast")
    public String audienceCloseToast;

    @SerializedName("audience_error_toast")
    public String audienceErrorToast;

    public LivePlayerSeekMsgTextConfig() {
        this.audienceClosePublicScreen = "当前直播间内容暂不支持实时回放，已关闭实时回放功能";
        this.audienceCloseToast = "播放回放出错啦，已为您回到实时直播进度";
        this.audienceErrorToast = "播放回放出错啦，已为您回到实时直播进度";
    }
}
