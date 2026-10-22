package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/DSConfig;", "", "()V", "count", "", "getCount", "()I", "dsEnable", "", "getDsEnable", "()Z", "duration", "", "getDuration", "()J", "rightCardOPt", "getRightCardOPt", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DSConfig {

    @SerializedName("count")
    private final int count;

    @SerializedName("ds_enable")
    private final boolean dsEnable;

    @SerializedName("duration")
    private final long duration;

    @SerializedName("right_card_opt")
    private final boolean rightCardOPt;

    public DSConfig() {
        this.dsEnable = true;
        this.rightCardOPt = true;
        this.count = 2;
        this.duration = 3000;
    }

    public final int getCount() {
        return this.count;
    }

    public final boolean getDsEnable() {
        return this.dsEnable;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final boolean getRightCardOPt() {
        return this.rightCardOPt;
    }
}
