package com.bytedance.android.livesdkapi.depend.model.live.vs;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class BusinessResourceConfigure {

    @SerializedName("BarrageConf")
    public BusinessBarrageConfigure barrageConfig;

    @SerializedName("ResourceID")
    public long resourceId;

    @SerializedName("ScreenBarConf")
    public BusinessScreenBarConfigure screenBarConfigure;

    public BusinessResourceConfigure() {
    }
}
