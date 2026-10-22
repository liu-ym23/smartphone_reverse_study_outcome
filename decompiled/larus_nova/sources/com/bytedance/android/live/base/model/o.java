package com.bytedance.android.live.base.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
@ForMain
public class o {

    @SerializedName("big_card_url")
    public String bigCardUrl;

    @SerializedName(ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE)
    public int containerType;

    @SerializedName("duration")
    public long duration;

    @SerializedName("height")
    public int height;

    @SerializedName("width")
    public int width;

    public o() {
    }
}
