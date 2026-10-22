package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.common.EffectConstants;

/* JADX INFO: loaded from: classes8.dex */
public class t0 {

    @SerializedName("delay_time")
    public int delayTime;

    @SerializedName("enable")
    public boolean enable;

    @SerializedName(EffectConstants.CHANNEL_TEST)
    public boolean test;

    public t0() {
        this.enable = false;
        this.delayTime = 0;
        this.test = false;
    }
}
