package com.bytedance.android.live.base.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
@ForMain
public class p {

    @SerializedName("duration")
    public long duration;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("bubble_id")
    public String f58903id;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    public int strategy;

    @SerializedName("ui_model")
    public r uIModel;

    public p() {
    }
}
