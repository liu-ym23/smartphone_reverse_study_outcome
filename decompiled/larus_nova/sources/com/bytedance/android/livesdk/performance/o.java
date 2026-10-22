package com.bytedance.android.livesdk.performance;

import com.alibaba.gaiax.template.GXMode;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;

/* JADX INFO: loaded from: classes11.dex */
public class o {

    @SerializedName("anchor_enable")
    public boolean anchorEnable;

    @SerializedName("audience_enable")
    public boolean audienceEnable;

    @SerializedName(GXMode.MODE_TYPE_CROP)
    public boolean crop;

    @SerializedName("dump_strategy")
    public int dumpStrategy;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private long interval;

    @SerializedName("java_heap_used_percent")
    public int javaHeapUsedPercent;

    @SerializedName("upload_strategy")
    public String uploadStrategy;

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

    public o() {
        this.uploadStrategy = "slardar";
        this.dumpStrategy = 1;
        this.crop = true;
        this.javaHeapUsedPercent = 80;
        this.interval = 86400000;
    }
}
