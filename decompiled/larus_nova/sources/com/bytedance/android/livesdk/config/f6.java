package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/config/f6;", "", "", VideoThumbInfo.KEY_INTERVAL, "I", "getInterval", "()I", "delay", "getDelay", "", "enableAnim", "Z", "getEnableAnim", "()Z", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f6 {

    @SerializedName("delay")
    private final int delay;

    @SerializedName("enable_anim")
    private final boolean enableAnim;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private final int interval;

    public final String toString() {
        return "GameIconAnimationConfig(interval=" + this.interval + ", delay=" + this.delay + ", enableAnim=" + this.enableAnim + ')';
    }

    public f6() {
        this.interval = 0;
        this.delay = 0;
        this.enableAnim = true;
    }
}
