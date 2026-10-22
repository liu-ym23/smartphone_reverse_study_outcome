package com.bytedance.android.gamecp.common.setting.config;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
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

    public final List<String> a() {
        List<String> r100 = this.ignore;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return Collections.emptyList();
    }

    public NetworkApmSetting() {
        this.enable = false;
        this.interval = 30000;
        this.strategy = 1;
        this.maxNetworkLog = 500;
        this.minNetworkLog = 3;
        this.ignore = new AnonymousClass1(this);
    }

    public final long b() {
        return this.interval;
    }

    public final int c() {
        return this.maxNetworkLog;
    }

    public final int d() {
        return this.minNetworkLog;
    }

    public final int e() {
        return this.strategy;
    }

    public final boolean f() {
        return this.enable;
    }
}
