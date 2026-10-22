package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001e\u0010\u0017\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001e\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveInteractOptConfig;", "", "()V", "enablePreEnter", "", "getEnablePreEnter", "()Z", "setEnablePreEnter", "(Z)V", "enableWidgetLoadPriority", "getEnableWidgetLoadPriority", "setEnableWidgetLoadPriority", "isTurnon", "setTurnon", "p0WidgetLoadTimeout", "", "getP0WidgetLoadTimeout", "()J", "setP0WidgetLoadTimeout", "(J)V", "p1WidgetLoadTimeout", "getP1WidgetLoadTimeout", "setP1WidgetLoadTimeout", "p2WidgetLoadTimeout", "getP2WidgetLoadTimeout", "setP2WidgetLoadTimeout", "roomCacheDuration", "getRoomCacheDuration", "setRoomCacheDuration", "roomCacheSize", "", "getRoomCacheSize", "()I", "setRoomCacheSize", "(I)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveInteractOptConfig {

    @SerializedName("enable_pre_enter")
    private boolean enablePreEnter;

    @SerializedName("enable_widget_load_priority")
    private boolean enableWidgetLoadPriority;

    @SerializedName("is_turn_on")
    private boolean isTurnon;

    @SerializedName("p0_widget_load_timeout")
    private long p0WidgetLoadTimeout;

    @SerializedName("p1_widget_load_timeout")
    private long p1WidgetLoadTimeout;

    @SerializedName("p2_widget_load_timeout")
    private long p2WidgetLoadTimeout;

    @SerializedName("room_cache_duration")
    private long roomCacheDuration;

    @SerializedName("room_cache_size")
    private int roomCacheSize;

    public LiveInteractOptConfig() {
        this.roomCacheDuration = 60000;
        this.p0WidgetLoadTimeout = 500;
        this.p1WidgetLoadTimeout = 500;
        this.p2WidgetLoadTimeout = 1000;
        this.roomCacheSize = 50;
    }

    public final boolean getEnablePreEnter() {
        return this.enablePreEnter;
    }

    public final boolean getEnableWidgetLoadPriority() {
        return this.enableWidgetLoadPriority;
    }

    public final long getP0WidgetLoadTimeout() {
        return this.p0WidgetLoadTimeout;
    }

    public final long getP1WidgetLoadTimeout() {
        return this.p1WidgetLoadTimeout;
    }

    public final long getP2WidgetLoadTimeout() {
        return this.p2WidgetLoadTimeout;
    }

    public final long getRoomCacheDuration() {
        return this.roomCacheDuration;
    }

    public final int getRoomCacheSize() {
        return this.roomCacheSize;
    }

    public final boolean isTurnon() {
        return this.isTurnon;
    }

    public final void setEnablePreEnter(boolean r100) {
        this.enablePreEnter = r100;
    }

    public final void setEnableWidgetLoadPriority(boolean r100) {
        this.enableWidgetLoadPriority = r100;
    }

    public final void setP0WidgetLoadTimeout(long r100) {
        this.p0WidgetLoadTimeout = r100;
    }

    public final void setP1WidgetLoadTimeout(long r100) {
        this.p1WidgetLoadTimeout = r100;
    }

    public final void setP2WidgetLoadTimeout(long r100) {
        this.p2WidgetLoadTimeout = r100;
    }

    public final void setRoomCacheDuration(long r100) {
        this.roomCacheDuration = r100;
    }

    public final void setRoomCacheSize(int r100) {
        this.roomCacheSize = r100;
    }

    public final void setTurnon(boolean r100) {
        this.isTurnon = r100;
    }
}
