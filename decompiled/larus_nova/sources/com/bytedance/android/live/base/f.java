package com.bytedance.android.live.base;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b)\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b7\u00108R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\"\u0010 \u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\"\u0010#\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000fR\"\u0010&\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0012\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\"\u0010)\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0012\u001a\u0004\b*\u0010\u0014\"\u0004\b+\u0010\u0016R\"\u0010,\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\r\"\u0004\b.\u0010\u000fR\"\u0010/\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\r\"\u0004\b1\u0010\u000fR\"\u00102\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u0012\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010\u0016R\u001a\u00105\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b5\u0010\u0012\u001a\u0004\b6\u0010\u0014¨\u00069"}, d2 = {"Lcom/bytedance/android/live/base/f;", "", "", "scene", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "", "style", "I", "getStyle", "()I", "setStyle", "(I)V", "triggerStrategy", "getTriggerStrategy", "setTriggerStrategy", "stayTime", "d", "setStayTime", "maxRequestCount", "b", "setMaxRequestCount", "refreshInterval", "getRefreshInterval", "setRefreshInterval", "closeCarOpt", "getCloseCarOpt", "setCloseCarOpt", "maxCloseTimes", "getMaxCloseTimes", "setMaxCloseTimes", "maxBlockDay", "getMaxBlockDay", "setMaxBlockDay", "disableWhenSlide", "getDisableWhenSlide", "setDisableWhenSlide", "enablePreloadCover", "getEnablePreloadCover", "setEnablePreloadCover", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "getStrategy", "setStrategy", "apiTimeout", "getApiTimeout", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("api_timeout")
    private final int apiTimeout;

    @SerializedName("close_card_opt")
    private boolean closeCarOpt;

    @SerializedName("disable_when_slide")
    private boolean disableWhenSlide;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_preload_cover")
    private boolean enablePreloadCover;

    @SerializedName("max_block_day")
    private int maxBlockDay;

    @SerializedName("max_close_times")
    private int maxCloseTimes;

    @SerializedName("max_request_count")
    private int maxRequestCount;

    @SerializedName("refresh_interval")
    private int refreshInterval;

    @SerializedName("scene")
    private String scene;

    @SerializedName("stay_time")
    private int stayTime;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    private int strategy;

    @SerializedName("style")
    private int style;

    @SerializedName("trigger_strategy")
    private int triggerStrategy;

    public final String toString() {
        return "LivePreviewCardConfig(scene='" + this.scene + "', enable=" + this.enable + ", style=" + this.style + ", triggerStrategy=" + this.triggerStrategy + ", stayTime=" + this.stayTime + ", maxRequestCount=" + this.maxRequestCount + ", refreshInterval=" + this.refreshInterval + ", closeCarOpt=" + this.closeCarOpt + ", maxCloseTimes=" + this.maxCloseTimes + ", maxBlockDay=" + this.maxBlockDay + ", disableWhenSlide=" + this.disableWhenSlide + ", strategy=" + this.strategy + ')';
    }

    public f() {
        this.scene = "";
        this.style = -1;
        this.triggerStrategy = 1;
        this.stayTime = -1;
        this.maxRequestCount = -1;
        this.refreshInterval = -1;
        this.maxCloseTimes = -1;
        this.maxBlockDay = -1;
        this.apiTimeout = 15000;
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.maxRequestCount;
    }

    public final String c() {
        return this.scene;
    }

    public final int d() {
        return this.stayTime;
    }
}
