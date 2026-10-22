package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveViewInflateConfig;", "", "()V", "audienceRank", "", "getAudienceRank", "()Z", "setAudienceRank", "(Z)V", PbRequest.SwitchType.GIFT, "getGift", "setGift", "landscapeSlideGuideAsync", "getLandscapeSlideGuideAsync", "setLandscapeSlideGuideAsync", "loading", "getLoading", "setLoading", "profit", "getProfit", "setProfit", "toolbarBoolean", "getToolbarBoolean", "setToolbarBoolean", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveViewInflateConfig {

    @SerializedName("audience_rank")
    private boolean audienceRank;

    @SerializedName(PbRequest.SwitchType.GIFT)
    private boolean gift;

    @SerializedName("landscape_slide_guide_async")
    private boolean landscapeSlideGuideAsync;

    @SerializedName("loading")
    private boolean loading;

    @SerializedName("profit")
    private boolean profit;

    @SerializedName("toolbar_button")
    private boolean toolbarBoolean;

    public LiveViewInflateConfig() {
    }

    public final boolean getAudienceRank() {
        return this.audienceRank;
    }

    public final boolean getGift() {
        return this.gift;
    }

    public final boolean getLandscapeSlideGuideAsync() {
        return this.landscapeSlideGuideAsync;
    }

    public final boolean getLoading() {
        return this.loading;
    }

    public final boolean getProfit() {
        return this.profit;
    }

    public final boolean getToolbarBoolean() {
        return this.toolbarBoolean;
    }

    public final void setAudienceRank(boolean r100) {
        this.audienceRank = r100;
    }

    public final void setGift(boolean r100) {
        this.gift = r100;
    }

    public final void setLandscapeSlideGuideAsync(boolean r100) {
        this.landscapeSlideGuideAsync = r100;
    }

    public final void setLoading(boolean r100) {
        this.loading = r100;
    }

    public final void setProfit(boolean r100) {
        this.profit = r100;
    }

    public final void setToolbarBoolean(boolean r100) {
        this.toolbarBoolean = r100;
    }
}
