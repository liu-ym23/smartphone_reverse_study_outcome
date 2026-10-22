package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0010\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/model/l0;", "", "", "enable", "Z", "getEnable", "()Z", "", "number", "I", "getNumber", "()I", "times", "getTimes", "maxACU", "getMaxACU", "minACU", "getMinACU", "tipEnable", "getTipEnable", "maxTipACU", "getMaxTipACU", "minTipACU", "getMinTipACU", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l0 {

    @SerializedName("live_public_screen_load_more_enable")
    private final boolean enable;

    @SerializedName("live_public_screen_load_more_max_ACU")
    private final int maxACU;

    @SerializedName("live_public_screen_load_more_tip_max_ACU")
    private final int maxTipACU;

    @SerializedName("live_public_screen_load_more_min_ACU")
    private final int minACU;

    @SerializedName("live_public_screen_load_more_tip_min_ACU")
    private final int minTipACU;

    @SerializedName("live_public_screen_load_more_number")
    private final int number;

    @SerializedName("live_public_screen_load_more_times")
    private final int times;

    @SerializedName("live_public_screen_load_more_tip_enable")
    private final boolean tipEnable;

    public l0() {
        this.number = 7;
        this.times = 4;
        this.maxACU = 100;
        this.maxTipACU = 100;
    }
}
