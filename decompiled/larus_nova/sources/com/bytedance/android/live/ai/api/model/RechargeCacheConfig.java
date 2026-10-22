package com.bytedance.android.live.ai.api.model;

import androidx.camera.core.RetryPolicy;
import com.bytedance.android.live.recharge.r0;
import com.bytedance.android.live.recharge.utils.j;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh6.c;
import wh6.a;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010-\u001a\u00020\u0010J\u0006\u0010.\u001a\u00020\u0010R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001e\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001e\u0010!\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010'\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006/"}, d2 = {"Lcom/bytedance/android/live/ai/api/model/RechargeCacheConfig;", "", "()V", "diamondCacheGapDay", "", "getDiamondCacheGapDay", "()I", "setDiamondCacheGapDay", "(I)V", "diamondWeakNetworkOptDelay", "", "getDiamondWeakNetworkOptDelay", "()J", "setDiamondWeakNetworkOptDelay", "(J)V", "enableCache", "", "getEnableCache", "()Z", "setEnableCache", "(Z)V", "enableCacheDiamondReplace", "getEnableCacheDiamondReplace", "setEnableCacheDiamondReplace", "enablePreFetch", "getEnablePreFetch", "setEnablePreFetch", "enableRechargeBtnClick", "getEnableRechargeBtnClick", "setEnableRechargeBtnClick", "panelHeightAdjust", "getPanelHeightAdjust", "setPanelHeightAdjust", "preFetchDelay", "getPreFetchDelay", "setPreFetchDelay", "preFetchGapDay", "getPreFetchGapDay", "setPreFetchGapDay", "renderData", "", "getRenderData", "()Ljava/lang/String;", "setRenderData", "(Ljava/lang/String;)V", "enableCacheWithStrategy", "enableDiamondApiCache", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeCacheConfig {

    @SerializedName("diamond_cache_gap_day")
    private int diamondCacheGapDay;

    @SerializedName("diamond_api_weak_network_opt_delay")
    private long diamondWeakNetworkOptDelay;

    @SerializedName("enable_cache")
    private boolean enableCache;

    @SerializedName("enable_select_cache_diamond_replace")
    private boolean enableCacheDiamondReplace;

    @SerializedName("enable_pre_fetch")
    private boolean enablePreFetch;

    @SerializedName("enable_recharge_btn_click")
    private boolean enableRechargeBtnClick;

    @SerializedName("panel_height_adjust")
    private boolean panelHeightAdjust;

    @SerializedName("pre_fetch_delay")
    private long preFetchDelay;

    @SerializedName("pre_fetch_gap_day")
    private int preFetchGapDay;

    @SerializedName("cj_default_render_data")
    private String renderData;

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean enableCacheWithStrategy() {
        Boolean r100 = (Boolean) ((a) c.b(a.class)).getClientABValue(j.f90478o);
        if (this.enableCache == true) goto L7;
        if (r100.booleanValue() == true) goto L7;
    L9:
        return false;
    L7:
        if (((Boolean) r0.f90343d.getValue(null, r0.f90340a[2])).booleanValue() == true) goto L9;
        return true;
    }

    public final boolean enableDiamondApiCache() {
        Boolean r100 = (Boolean) ((a) c.b(a.class)).getClientABValue(j.f90478o);
        if (this.enableCache == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.booleanValue() == true) goto L8;
        return false;
    }

    public RechargeCacheConfig() {
        this.renderData = "";
        this.preFetchDelay = RetryPolicy.DEFAULT_RETRY_TIMEOUT_IN_MILLIS;
        this.preFetchGapDay = 1;
        this.diamondCacheGapDay = 3;
        this.diamondWeakNetworkOptDelay = 2000;
    }

    public final int getDiamondCacheGapDay() {
        return this.diamondCacheGapDay;
    }

    public final long getDiamondWeakNetworkOptDelay() {
        return this.diamondWeakNetworkOptDelay;
    }

    public final boolean getEnableCache() {
        return this.enableCache;
    }

    public final boolean getEnableCacheDiamondReplace() {
        return this.enableCacheDiamondReplace;
    }

    public final boolean getEnablePreFetch() {
        return this.enablePreFetch;
    }

    public final boolean getEnableRechargeBtnClick() {
        return this.enableRechargeBtnClick;
    }

    public final boolean getPanelHeightAdjust() {
        return this.panelHeightAdjust;
    }

    public final long getPreFetchDelay() {
        return this.preFetchDelay;
    }

    public final int getPreFetchGapDay() {
        return this.preFetchGapDay;
    }

    public final String getRenderData() {
        return this.renderData;
    }

    public final void setDiamondCacheGapDay(int r100) {
        this.diamondCacheGapDay = r100;
    }

    public final void setDiamondWeakNetworkOptDelay(long r100) {
        this.diamondWeakNetworkOptDelay = r100;
    }

    public final void setEnableCache(boolean r100) {
        this.enableCache = r100;
    }

    public final void setEnableCacheDiamondReplace(boolean r100) {
        this.enableCacheDiamondReplace = r100;
    }

    public final void setEnablePreFetch(boolean r100) {
        this.enablePreFetch = r100;
    }

    public final void setEnableRechargeBtnClick(boolean r100) {
        this.enableRechargeBtnClick = r100;
    }

    public final void setPanelHeightAdjust(boolean r100) {
        this.panelHeightAdjust = r100;
    }

    public final void setPreFetchDelay(long r100) {
        this.preFetchDelay = r100;
    }

    public final void setPreFetchGapDay(int r100) {
        this.preFetchGapDay = r100;
    }

    public final void setRenderData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.renderData = r100;
    }
}
