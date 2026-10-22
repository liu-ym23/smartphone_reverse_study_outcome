package com.bytedance.android.livesdk.dynamicstrategy.api.entity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class m {

    @SerializedName("feature_type")
    public int featureType;

    @SerializedName("feature_value")
    public n featureValue;

    @SerializedName("name")
    public String name;

    @SerializedName("nfa_info")
    public s nfaInfo;

    @SerializedName("refresh_interval")
    public int refreshInterval;

    @SerializedName("feature_source")
    public int source;

    @SerializedName("feature_timeliness")
    public int timeliness;

    public m() {
    }
}
