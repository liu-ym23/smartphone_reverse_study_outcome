package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import com.ss.videoarch.strategy.dataCenter.strategyData.HistoryTableOperate;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/l;", "", "", "enable", "I", "getEnable", "()I", "", "blockRate", "D", "getBlockRate", "()D", "displayPeriod", "getDisplayPeriod", "displayMaxCount", "getDisplayMaxCount", "mobileDataConsumption", "getMobileDataConsumption", "consumptionToastCountPerDay", "getConsumptionToastCountPerDay", "playTime", "getPlayTime", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l {

    @SerializedName("block_rate")
    private final double blockRate;

    @SerializedName("consumption_toast_count_per_day")
    private final int consumptionToastCountPerDay;

    @SerializedName("setting_display_max_count")
    private final int displayMaxCount;

    @SerializedName("setting_display_period")
    private final int displayPeriod;

    @SerializedName("multi_path_enable")
    private final int enable;

    @SerializedName("mobile_data_consumption")
    private final int mobileDataConsumption;

    @SerializedName(HistoryTableOperate.HISTORY_PLAY_TIME)
    private final int playTime;

    public l() {
        this.blockRate = 0.4d;
        this.displayPeriod = 10;
        this.displayMaxCount = 4;
        this.mobileDataConsumption = 500;
        this.consumptionToastCountPerDay = 2;
        this.playTime = 180;
    }
}
