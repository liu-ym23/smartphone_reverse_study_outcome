package com.bytedance.android.livesdkapi.ai.skylight;

import com.bytedance.android.livesdkapi.app.AppConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010G\u001a\u00020\u0011J\u0006\u0010H\u001a\u00020\u0011J\u0006\u0010I\u001a\u00020\u0011R,\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0019\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001e\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001e\u0010\u001f\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R2\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010#j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010)\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R \u0010.\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\u001e\u00101\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000fR\u001e\u00104\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\r\"\u0004\b6\u0010\u000fR\u001e\u00107\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\r\"\u0004\b9\u0010\u000fR\u0012\u0010:\u001a\u00020;8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001e\u0010<\u001a\u00020;8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001e\u0010A\u001a\u00020;8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010>\"\u0004\bC\u0010@R\u001e\u0010D\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0013\"\u0004\bF\u0010\u0015¨\u0006J"}, d2 = {"Lcom/bytedance/android/livesdkapi/ai/skylight/LiveAiSkylightPreloadPredictConfig;", "", "()V", "abParams", "", "", "getAbParams", "()Ljava/util/Map;", "setAbParams", "(Ljava/util/Map;)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "enableBackup", "", "getEnableBackup", "()Z", "setEnableBackup", "(Z)V", "enableBandwidthLimit", "getEnableBandwidthLimit", "setEnableBandwidthLimit", "enablePreCreateSurface", "getEnablePreCreateSurface", "setEnablePreCreateSurface", "enablePreEnterRoom", "getEnablePreEnterRoom", "setEnablePreEnterRoom", "enableRoomTags", "getEnableRoomTags", "setEnableRoomTags", "feedFeatureList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getFeedFeatureList", "()Ljava/util/ArrayList;", "setFeedFeatureList", "(Ljava/util/ArrayList;)V", "limitEndTime", "getLimitEndTime", "()Ljava/lang/String;", "setLimitEndTime", "(Ljava/lang/String;)V", "limitStartTime", "getLimitStartTime", "setLimitStartTime", "maxWaitDuration", "getMaxWaitDuration", "setMaxWaitDuration", "predictInterval", "getPredictInterval", "setPredictInterval", "preloadInterval", "getPreloadInterval", "setPreloadInterval", "preloadType", "", "refreshRoomTagInterval", "getRefreshRoomTagInterval", "()I", "setRefreshRoomTagInterval", "(I)V", "roomCount", "getRoomCount", "setRoomCount", "showToastEnable", "getShowToastEnable", "setShowToastEnable", "isDirectEnable", "isEnable", "isPredictEnable", "liveai-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAiSkylightPreloadPredictConfig {

    @SerializedName(AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS)
    private Map<String, ? extends Object> abParams;

    @SerializedName("duration")
    private long duration;

    @SerializedName("enable_backup")
    private boolean enableBackup;

    @SerializedName("enable_bandwidth_limit")
    private boolean enableBandwidthLimit;

    @SerializedName("enable_pre_create_surface")
    private boolean enablePreCreateSurface;

    @SerializedName("enable_pre_enter_room")
    private boolean enablePreEnterRoom;

    @SerializedName("enable_room_tags")
    private boolean enableRoomTags;

    @SerializedName("aweme_feed_feature")
    private ArrayList<String> feedFeatureList;

    @SerializedName("limit_end_time")
    private String limitEndTime;

    @SerializedName("limit_start_time")
    private String limitStartTime;

    @SerializedName("max_wait_duration")
    private long maxWaitDuration;

    @SerializedName("predict_interval")
    private long predictInterval;

    @SerializedName("preload_interval")
    private long preloadInterval;

    @SerializedName(ChameleonOpenTracker.ParamKey.PRELOAD_TYPE)
    private int preloadType;

    @SerializedName("refresh_room_tag_interval")
    private int refreshRoomTagInterval;

    @SerializedName("room_count")
    private int roomCount;

    @SerializedName("show_toast_enable")
    private boolean showToastEnable;

    public final boolean isDirectEnable() {
        if (this.preloadType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean isEnable() {
        if (this.preloadType == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isPredictEnable() {
        if (this.preloadType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public LiveAiSkylightPreloadPredictConfig() {
        this.predictInterval = 10000;
        this.preloadInterval = 10000;
        this.duration = 10000;
        this.enableBandwidthLimit = true;
        this.limitStartTime = "19:00";
        this.limitEndTime = "23:59";
        this.feedFeatureList = new ArrayList();
        this.roomCount = 3;
        this.enableRoomTags = true;
        this.refreshRoomTagInterval = 7;
        this.maxWaitDuration = 2000;
    }

    public final Map<String, Object> getAbParams() {
        return this.abParams;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final boolean getEnableBackup() {
        return this.enableBackup;
    }

    public final boolean getEnableBandwidthLimit() {
        return this.enableBandwidthLimit;
    }

    public final boolean getEnablePreCreateSurface() {
        return this.enablePreCreateSurface;
    }

    public final boolean getEnablePreEnterRoom() {
        return this.enablePreEnterRoom;
    }

    public final boolean getEnableRoomTags() {
        return this.enableRoomTags;
    }

    public final ArrayList<String> getFeedFeatureList() {
        return this.feedFeatureList;
    }

    public final String getLimitEndTime() {
        return this.limitEndTime;
    }

    public final String getLimitStartTime() {
        return this.limitStartTime;
    }

    public final long getMaxWaitDuration() {
        return this.maxWaitDuration;
    }

    public final long getPredictInterval() {
        return this.predictInterval;
    }

    public final long getPreloadInterval() {
        return this.preloadInterval;
    }

    public final int getRefreshRoomTagInterval() {
        return this.refreshRoomTagInterval;
    }

    public final int getRoomCount() {
        return this.roomCount;
    }

    public final boolean getShowToastEnable() {
        return this.showToastEnable;
    }

    public final void setAbParams(Map<String, ? extends Object> r100) {
        this.abParams = r100;
    }

    public final void setDuration(long r100) {
        this.duration = r100;
    }

    public final void setEnableBackup(boolean r100) {
        this.enableBackup = r100;
    }

    public final void setEnableBandwidthLimit(boolean r100) {
        this.enableBandwidthLimit = r100;
    }

    public final void setEnablePreCreateSurface(boolean r100) {
        this.enablePreCreateSurface = r100;
    }

    public final void setEnablePreEnterRoom(boolean r100) {
        this.enablePreEnterRoom = r100;
    }

    public final void setEnableRoomTags(boolean r100) {
        this.enableRoomTags = r100;
    }

    public final void setFeedFeatureList(ArrayList<String> r100) {
        this.feedFeatureList = r100;
    }

    public final void setLimitEndTime(String r100) {
        this.limitEndTime = r100;
    }

    public final void setLimitStartTime(String r100) {
        this.limitStartTime = r100;
    }

    public final void setMaxWaitDuration(long r100) {
        this.maxWaitDuration = r100;
    }

    public final void setPredictInterval(long r100) {
        this.predictInterval = r100;
    }

    public final void setPreloadInterval(long r100) {
        this.preloadInterval = r100;
    }

    public final void setRefreshRoomTagInterval(int r100) {
        this.refreshRoomTagInterval = r100;
    }

    public final void setRoomCount(int r100) {
        this.roomCount = r100;
    }

    public final void setShowToastEnable(boolean r100) {
        this.showToastEnable = r100;
    }
}
