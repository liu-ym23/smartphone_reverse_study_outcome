package com.bytedance.android.livesdk.config;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class m8 {

    @SerializedName("enable_cmc")
    public boolean mEnableCmc;

    @SerializedName("insert_queue")
    public boolean mInsertQueue;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    public int mStrategy;

    @SerializedName("timeout")
    public long mTimeout;

    public m8() {
    }
}
