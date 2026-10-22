package com.bytedance.android.livesdk.performance;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;

/* JADX INFO: loaded from: classes11.dex */
public class v0 {

    @SerializedName("anchor_enable")
    public boolean anchorEnable;

    @SerializedName("audience_enable")
    public boolean audienceEnable;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private long interval;

    @SerializedName("java_heap_used_percent")
    public int javaHeapUsedPercent;

    public final long a() {
        long r100 = this.interval;
        if (r100 < 3600000) goto L6;
        return r100;
    L6:
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L8;
        return 3600000;
    L8:
        return this.interval;
    }

    public v0() {
        this.javaHeapUsedPercent = 80;
        this.interval = 86400000;
    }
}
