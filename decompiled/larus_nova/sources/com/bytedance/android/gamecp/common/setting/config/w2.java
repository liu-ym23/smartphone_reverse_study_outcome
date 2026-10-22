package com.bytedance.android.gamecp.common.setting.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/gamecp/common/setting/config/w2;", "", "", "goodNetRate", "I", "getGoodNetRate", "()I", "defaultNetRate", "getDefaultNetRate", "badNetRate", "getBadNetRate", "goodNetLevel", "getGoodNetLevel", "badNetLevel", "getBadNetLevel", "<init>", "()V", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w2 {

    @SerializedName("bad_net_level")
    private final int badNetLevel;

    @SerializedName("bad_net_rate")
    private final int badNetRate;

    @SerializedName("default_net_rate")
    private final int defaultNetRate;

    @SerializedName("good_net_level")
    private final int goodNetLevel;

    @SerializedName("good_net_rate")
    private final int goodNetRate;

    public w2() {
        this.goodNetLevel = 7;
        this.badNetLevel = 6;
    }
}
