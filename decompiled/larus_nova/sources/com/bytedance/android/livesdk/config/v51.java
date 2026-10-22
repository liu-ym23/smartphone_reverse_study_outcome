package com.bytedance.android.livesdk.config;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0018\u001a\u00020\u00178\u0006X\u0087D¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u000bR\u001a\u0010\u001e\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014R\u001a\u0010 \u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b!\u0010\u000bR\u001a\u0010\"\u001a\u00020\u00178\u0006X\u0087D¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001b¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/config/v51;", "", "", "breakEnable", "Z", "getBreakEnable", "()Z", "", "chatMin", "I", "getChatMin", "()I", "chatMax", "getChatMax", "breakShowNum", "getBreakShowNum", "", "breakIntervalTimeSec", FaceService.girlLabel, "getBreakIntervalTimeSec", "()F", "dropEnable", "getDropEnable", "", "dropPeriodSec", "J", "getDropPeriodSec", "()J", "periodNumber", "getPeriodNumber", "dropRate", "getDropRate", "dropScoreThreshold", "getDropScoreThreshold", "dropDelayThresholdSec", "getDropDelayThresholdSec", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v51 {

    @SerializedName("live_public_screen_message_break_enable")
    private final boolean breakEnable;

    @SerializedName("live_public_screen_message_break_no_message_time_second")
    private final float breakIntervalTimeSec;

    @SerializedName("live_public_screen_message_break_show")
    private final int breakShowNum;

    @SerializedName("live_public_screen_message_break_chat_max")
    private final int chatMax;

    @SerializedName("live_public_screen_message_break_chat_min")
    private final int chatMin;

    @SerializedName("live_public_screen_message_drop_delay_threshold_second")
    private final long dropDelayThresholdSec;

    @SerializedName("live_public_screen_message_drop_enable")
    private final boolean dropEnable;

    @SerializedName("live_public_screen_message_drop_statistical_period_second")
    private final long dropPeriodSec;

    @SerializedName("live_public_screen_message_drop_rate")
    private final float dropRate;

    @SerializedName("live_public_screen_message_drop_score_threshold")
    private final int dropScoreThreshold;

    @SerializedName("live_public_screen_message_drop_statistical_period_number")
    private final int periodNumber;

    public v51() {
        this.chatMin = 2;
        this.chatMax = 4;
        this.breakShowNum = 1;
        this.breakIntervalTimeSec = 0.5f;
        this.dropPeriodSec = 10;
        this.periodNumber = 10;
        this.dropRate = 0.4f;
        this.dropScoreThreshold = 50;
    }
}
