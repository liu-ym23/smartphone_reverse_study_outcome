package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.livehostapi.platform.base.IBaseHostPerformanceMonitor;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/StrategyRoomFeatureConfig;", "", "()V", "cacheSize", "", "getCacheSize", "()I", "setCacheSize", "(I)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "enableInsertPitaya", "getEnableInsertPitaya", "setEnableInsertPitaya", "feedRefreshInterval", "getFeedRefreshInterval", "setFeedRefreshInterval", "maxRequestSize", "getMaxRequestSize", "setMaxRequestSize", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StrategyRoomFeatureConfig {

    @SerializedName(IBaseHostPerformanceMonitor.CACHE_BITMAP_MEMORY_SIZE)
    private int cacheSize;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_insert_pitaya")
    private int enableInsertPitaya;

    @SerializedName("feed_refresh_interval_seconds")
    private int feedRefreshInterval;

    @SerializedName("max_request_size")
    private int maxRequestSize;

    public StrategyRoomFeatureConfig() {
        this.cacheSize = 10;
        this.maxRequestSize = 20;
        this.enableInsertPitaya = 1;
    }

    public final int getCacheSize() {
        return this.cacheSize;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final int getEnableInsertPitaya() {
        return this.enableInsertPitaya;
    }

    public final int getFeedRefreshInterval() {
        return this.feedRefreshInterval;
    }

    public final int getMaxRequestSize() {
        return this.maxRequestSize;
    }

    public final void setCacheSize(int r100) {
        this.cacheSize = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setEnableInsertPitaya(int r100) {
        this.enableInsertPitaya = r100;
    }

    public final void setFeedRefreshInterval(int r100) {
        this.feedRefreshInterval = r100;
    }

    public final void setMaxRequestSize(int r100) {
        this.maxRequestSize = r100;
    }
}
