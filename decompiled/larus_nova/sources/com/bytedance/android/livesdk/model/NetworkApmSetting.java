package com.bytedance.android.livesdk.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class NetworkApmSetting {

    @SerializedName("enable_all")
    private boolean enable;

    @SerializedName("ignore_path")
    private List<String> ignore;

    @SerializedName(VideoThumbInfo.KEY_INTERVAL)
    private long interval;

    @SerializedName("max_network_log")
    private int maxNetworkLog;

    @SerializedName("min_network_log")
    private int minNetworkLog;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    private int strategy;

    public NetworkApmSetting() {
        this.enable = false;
        this.interval = 30000;
        this.strategy = 1;
        this.maxNetworkLog = 500;
        this.minNetworkLog = 3;
        this.ignore = new AnonymousClass1(this);
    }

    public final boolean a() {
        return this.enable;
    }
}
