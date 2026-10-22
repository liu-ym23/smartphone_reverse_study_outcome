package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveOptRecommendHintConfig;", "", "()V", "skipRoomLimit", "", "getSkipRoomLimit", "()I", "setSkipRoomLimit", "(I)V", "tipAbVersion", "getTipAbVersion", "setTipAbVersion", "tipContextText", "", "getTipContextText", "()Ljava/lang/String;", "setTipContextText", "(Ljava/lang/String;)V", "tipEnable", "", "getTipEnable", "()Z", "setTipEnable", "(Z)V", "tipShowDateReset", "getTipShowDateReset", "setTipShowDateReset", "tipShowInterval", "getTipShowInterval", "setTipShowInterval", "tipShowMaxTime", "getTipShowMaxTime", "setTipShowMaxTime", "tipShowTimesReset", "getTipShowTimesReset", "setTipShowTimesReset", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOptRecommendHintConfig {

    @SerializedName("skip_room_limit")
    private int skipRoomLimit;

    @SerializedName("tip_ab_version")
    private int tipAbVersion;

    @SerializedName("tip_content_text")
    private String tipContextText;

    @SerializedName("tip_enable")
    private boolean tipEnable;

    @SerializedName("tip_show_date_reset")
    private boolean tipShowDateReset;

    @SerializedName("tip_show_interval")
    private int tipShowInterval;

    @SerializedName("tip_show_max_time")
    private int tipShowMaxTime;

    @SerializedName("tip_show_times_reset")
    private boolean tipShowTimesReset;

    public LiveOptRecommendHintConfig() {
        this.tipContextText = "";
        this.tipShowMaxTime = 3;
        this.tipShowInterval = 14;
        this.skipRoomLimit = 3;
    }

    public final int getSkipRoomLimit() {
        return this.skipRoomLimit;
    }

    public final int getTipAbVersion() {
        return this.tipAbVersion;
    }

    public final String getTipContextText() {
        return this.tipContextText;
    }

    public final boolean getTipEnable() {
        return this.tipEnable;
    }

    public final boolean getTipShowDateReset() {
        return this.tipShowDateReset;
    }

    public final int getTipShowInterval() {
        return this.tipShowInterval;
    }

    public final int getTipShowMaxTime() {
        return this.tipShowMaxTime;
    }

    public final boolean getTipShowTimesReset() {
        return this.tipShowTimesReset;
    }

    public final void setSkipRoomLimit(int r100) {
        this.skipRoomLimit = r100;
    }

    public final void setTipAbVersion(int r100) {
        this.tipAbVersion = r100;
    }

    public final void setTipContextText(String r100) {
        this.tipContextText = r100;
    }

    public final void setTipEnable(boolean r100) {
        this.tipEnable = r100;
    }

    public final void setTipShowDateReset(boolean r100) {
        this.tipShowDateReset = r100;
    }

    public final void setTipShowInterval(int r100) {
        this.tipShowInterval = r100;
    }

    public final void setTipShowMaxTime(int r100) {
        this.tipShowMaxTime = r100;
    }

    public final void setTipShowTimesReset(boolean r100) {
        this.tipShowTimesReset = r100;
    }
}
