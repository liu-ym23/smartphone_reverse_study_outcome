package com.bytedance.android.livesdkapi.model.com.bytedance.android.live.config.setting;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/live/config/setting/LiveUserStayTimeStrategyConfig;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "shortStayTime", "", "getShortStayTime", "()I", "setShortStayTime", "(I)V", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "getStrategy", "setStrategy", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveUserStayTimeStrategyConfig {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("short_stay_time")
    private int shortStayTime;

    @SerializedName(BdpAppEventConstant.PARAMS_STRATEGY_NAME)
    private int strategy;

    public LiveUserStayTimeStrategyConfig() {
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getShortStayTime() {
        return this.shortStayTime;
    }

    public final int getStrategy() {
        return this.strategy;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setShortStayTime(int r100) {
        this.shortStayTime = r100;
    }

    public final void setStrategy(int r100) {
        this.strategy = r100;
    }
}
