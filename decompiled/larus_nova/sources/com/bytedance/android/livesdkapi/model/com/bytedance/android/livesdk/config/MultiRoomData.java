package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\f\"\u0004\b \u0010\u000eR\u001e\u0010!\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001e\u0010$\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001e\u0010'\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR\u001e\u0010*\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR\u001e\u0010-\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010\u000eR\u001e\u0010/\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\f\"\u0004\b0\u0010\u000eR\u001e\u00101\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\f\"\u0004\b2\u0010\u000eR\u001e\u00103\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001e\u00106\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\f\"\u0004\b8\u0010\u000eR\u001e\u00109\u001a\u00020:8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001e\u0010?\u001a\u00020:8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R\u001e\u0010B\u001a\u00020:8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010<\"\u0004\bD\u0010>R \u0010E\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001e\u0010K\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\f\"\u0004\bM\u0010\u000e¨\u0006N"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/MultiRoomData;", "", "()V", "backendDataExpiredTime", "", "getBackendDataExpiredTime", "()J", "setBackendDataExpiredTime", "(J)V", "backendOpt", "", "getBackendOpt", "()Z", "setBackendOpt", "(Z)V", "blockPreloadOnAnr", "getBlockPreloadOnAnr", "setBlockPreloadOnAnr", "blockPreloadOnJavaUsedPct", "", "getBlockPreloadOnJavaUsedPct", "()F", "setBlockPreloadOnJavaUsedPct", "(F)V", "blockPreloadOnPrefSerious", "getBlockPreloadOnPrefSerious", "setBlockPreloadOnPrefSerious", "disableSearch", "getDisableSearch", "setDisableSearch", "disposeRxBus", "getDisposeRxBus", "setDisposeRxBus", "enable", "getEnable", "setEnable", "enableFastGiftRev", "getEnableFastGiftRev", "setEnableFastGiftRev", "enableRev", "getEnableRev", "setEnableRev", "enableRoomPreload", "getEnableRoomPreload", "setEnableRoomPreload", "isBlockPreloadAtPrefPoor", "setBlockPreloadAtPrefPoor", "isUseNewRoomController", "setUseNewRoomController", "isUseScopeRxBus", "setUseScopeRxBus", "postDelayTime", "getPostDelayTime", "setPostDelayTime", "postPreloadTask", "getPostPreloadTask", "setPostPreloadTask", "preEnterRoomStage", "", "getPreEnterRoomStage", "()I", "setPreEnterRoomStage", "(I)V", "preRequestRoomBackendStage", "getPreRequestRoomBackendStage", "setPreRequestRoomBackendStage", "preRequestRoomPreloadStage", "getPreRequestRoomPreloadStage", "setPreRequestRoomPreloadStage", "preloadOpt", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/PreloadOpt;", "getPreloadOpt", "()Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/PreloadOpt;", "setPreloadOpt", "(Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/PreloadOpt;)V", "useRecommendDataForPreload", "getUseRecommendDataForPreload", "setUseRecommendDataForPreload", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiRoomData {

    @SerializedName("backend_data_expired_time")
    private long backendDataExpiredTime;

    @SerializedName("backend_opt")
    private boolean backendOpt;

    @SerializedName("block_preload_on_anr")
    private boolean blockPreloadOnAnr;

    @SerializedName("block_preload_on_java_used_pct")
    private float blockPreloadOnJavaUsedPct;

    @SerializedName("block_preload_on_pref_serious")
    private boolean blockPreloadOnPrefSerious;

    @SerializedName("disable_search")
    private boolean disableSearch;
    private boolean disposeRxBus;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("fast_gift_view")
    private boolean enableFastGiftRev;

    @SerializedName("rev_enable")
    private boolean enableRev;

    @SerializedName("enable_room_preload")
    private boolean enableRoomPreload;

    @SerializedName("is_block_preload_at_pref_poor")
    private boolean isBlockPreloadAtPrefPoor;

    @SerializedName("is_use_new_roomcontroller")
    private boolean isUseNewRoomController;

    @SerializedName("use_scope_rx_bus")
    private boolean isUseScopeRxBus;

    @SerializedName("post_delay_time")
    private long postDelayTime;

    @SerializedName("post_preload_task")
    private boolean postPreloadTask;

    @SerializedName("pre_enter_room_stage")
    private int preEnterRoomStage;

    @SerializedName("pre_request_room_backend_stage")
    private int preRequestRoomBackendStage;

    @SerializedName("pre_request_room_preload_stage")
    private int preRequestRoomPreloadStage;

    @SerializedName("preload_opt")
    private PreloadOpt preloadOpt;

    @SerializedName("use_recommend_data_for_preload")
    private boolean useRecommendDataForPreload;

    public MultiRoomData() {
        this.preRequestRoomPreloadStage = 5;
        this.preRequestRoomBackendStage = 5;
        this.preEnterRoomStage = 11;
        this.backendDataExpiredTime = 60000;
        this.disableSearch = true;
        this.blockPreloadOnJavaUsedPct = 0.6f;
        this.blockPreloadOnPrefSerious = true;
        this.blockPreloadOnAnr = true;
        this.useRecommendDataForPreload = true;
        this.disposeRxBus = true;
    }

    public final long getBackendDataExpiredTime() {
        return this.backendDataExpiredTime;
    }

    public final boolean getBackendOpt() {
        return this.backendOpt;
    }

    public final boolean getBlockPreloadOnAnr() {
        return this.blockPreloadOnAnr;
    }

    public final float getBlockPreloadOnJavaUsedPct() {
        return this.blockPreloadOnJavaUsedPct;
    }

    public final boolean getBlockPreloadOnPrefSerious() {
        return this.blockPreloadOnPrefSerious;
    }

    public final boolean getDisableSearch() {
        return this.disableSearch;
    }

    public final boolean getDisposeRxBus() {
        return this.disposeRxBus;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableFastGiftRev() {
        return this.enableFastGiftRev;
    }

    public final boolean getEnableRev() {
        return this.enableRev;
    }

    public final boolean getEnableRoomPreload() {
        return this.enableRoomPreload;
    }

    public final long getPostDelayTime() {
        return this.postDelayTime;
    }

    public final boolean getPostPreloadTask() {
        return this.postPreloadTask;
    }

    public final int getPreEnterRoomStage() {
        return this.preEnterRoomStage;
    }

    public final int getPreRequestRoomBackendStage() {
        return this.preRequestRoomBackendStage;
    }

    public final int getPreRequestRoomPreloadStage() {
        return this.preRequestRoomPreloadStage;
    }

    public final PreloadOpt getPreloadOpt() {
        return this.preloadOpt;
    }

    public final boolean getUseRecommendDataForPreload() {
        return this.useRecommendDataForPreload;
    }

    public final boolean isBlockPreloadAtPrefPoor() {
        return this.isBlockPreloadAtPrefPoor;
    }

    public final boolean isUseNewRoomController() {
        return this.isUseNewRoomController;
    }

    public final boolean isUseScopeRxBus() {
        return this.isUseScopeRxBus;
    }

    public final void setBackendDataExpiredTime(long r100) {
        this.backendDataExpiredTime = r100;
    }

    public final void setBackendOpt(boolean r100) {
        this.backendOpt = r100;
    }

    public final void setBlockPreloadAtPrefPoor(boolean r100) {
        this.isBlockPreloadAtPrefPoor = r100;
    }

    public final void setBlockPreloadOnAnr(boolean r100) {
        this.blockPreloadOnAnr = r100;
    }

    public final void setBlockPreloadOnJavaUsedPct(float r100) {
        this.blockPreloadOnJavaUsedPct = r100;
    }

    public final void setBlockPreloadOnPrefSerious(boolean r100) {
        this.blockPreloadOnPrefSerious = r100;
    }

    public final void setDisableSearch(boolean r100) {
        this.disableSearch = r100;
    }

    public final void setDisposeRxBus(boolean r100) {
        this.disposeRxBus = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setEnableFastGiftRev(boolean r100) {
        this.enableFastGiftRev = r100;
    }

    public final void setEnableRev(boolean r100) {
        this.enableRev = r100;
    }

    public final void setEnableRoomPreload(boolean r100) {
        this.enableRoomPreload = r100;
    }

    public final void setPostDelayTime(long r100) {
        this.postDelayTime = r100;
    }

    public final void setPostPreloadTask(boolean r100) {
        this.postPreloadTask = r100;
    }

    public final void setPreEnterRoomStage(int r100) {
        this.preEnterRoomStage = r100;
    }

    public final void setPreRequestRoomBackendStage(int r100) {
        this.preRequestRoomBackendStage = r100;
    }

    public final void setPreRequestRoomPreloadStage(int r100) {
        this.preRequestRoomPreloadStage = r100;
    }

    public final void setPreloadOpt(PreloadOpt r100) {
        this.preloadOpt = r100;
    }

    public final void setUseNewRoomController(boolean r100) {
        this.isUseNewRoomController = r100;
    }

    public final void setUseRecommendDataForPreload(boolean r100) {
        this.useRecommendDataForPreload = r100;
    }

    public final void setUseScopeRxBus(boolean r100) {
        this.isUseScopeRxBus = r100;
    }
}
