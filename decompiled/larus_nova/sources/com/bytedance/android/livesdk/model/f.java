package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\u0019\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/model/f;", "", "", "enable", "Z", "getEnable", "()Z", "", "displayDurationSec", "J", "getDisplayDurationSec", "()J", "", "comboCount", "I", "getComboCount", "()I", "sameMax", "getSameMax", "diffMax", "getDiffMax", "intervalSecond", "getIntervalSecond", "intervalCount", "getIntervalCount", "totalCount", "getTotalCount", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("live_hot_message_quick_comment_combo_count")
    private final int comboCount;

    @SerializedName("live_hot_message_quick_comment_diff_max")
    private final int diffMax;

    @SerializedName("live_hot_message_quick_comment_quit_interval_second")
    private final long displayDurationSec;

    @SerializedName("live_hot_message_quick_comment_enable")
    private final boolean enable;

    @SerializedName("live_hot_message_quick_comment_interval_count")
    private final int intervalCount;

    @SerializedName("live_hot_message_quick_comment_interval_second")
    private final int intervalSecond;

    @SerializedName("live_hot_message_quick_comment_same_max")
    private final int sameMax;

    @SerializedName("live_hot_message_quick_comment_total_count")
    private final int totalCount;

    public f() {
        this.displayDurationSec = 30;
        this.comboCount = 10;
        this.sameMax = 1;
        this.diffMax = 2;
        this.intervalSecond = 60;
        this.intervalCount = 1;
        this.totalCount = 5;
    }
}
