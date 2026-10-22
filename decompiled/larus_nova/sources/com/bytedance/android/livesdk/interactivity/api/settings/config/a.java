package com.bytedance.android.livesdk.interactivity.api.settings.config;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.log.IVideoEventLogger;

/* JADX INFO: loaded from: classes9.dex */
public class a {

    @SerializedName("drop_interval")
    public int dropInterval;

    @SerializedName("enable_async_handle_sei")
    public boolean enableAsyncHandleSei;

    @SerializedName("enable_drop_frame")
    public Boolean enableDropFrame;

    @SerializedName(IVideoEventLogger.FEATURE_KEY_THREAD_PRIORITY)
    public int threadPriority;

    public a() {
        this.enableDropFrame = Boolean.FALSE;
        this.dropInterval = 3;
        this.enableAsyncHandleSei = true;
        this.threadPriority = -2;
    }
}
