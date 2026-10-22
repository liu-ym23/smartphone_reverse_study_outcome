package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\fJ\u0006\u0010\u0017\u001a\u00020\u0004J\u0006\u0010\u0018\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u0006R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00068\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/config/MultiLinkRevenueEnterRoomOptConfig;", "", "()V", "adjustLayerDelay", "", "advanceLoadLynx", "", "asyncLoadLynx", "jsbTansOpt", "preLoadDynamicContainerOnFeedView", "preLoadDynamicContainerWhenIdle", "preLoadRenderWidgetSize", "", "preLoadRootWidgetSize", "preloadIdleDelay", "reloadCount", "slowFunctionOpt", "totalEnable", "enableJsbTransferOpt", "enablePreLoadDynamicContainerOnFeedView", "enablePreLoadDynamicContainerWhenIdle", "getPreLoadRenderWidgetSize", "getPreLoadRootWidgetSize", "getPreloadIdleDelay", "isTotalEnable", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiLinkRevenueEnterRoomOptConfig {

    @SerializedName("adjust_layer_delay")
    private long adjustLayerDelay;

    @SerializedName("advance_load_lynx")
    private boolean advanceLoadLynx;

    @SerializedName("async_load_lynx")
    private boolean asyncLoadLynx;

    @SerializedName("jsb_trans_opt")
    private boolean jsbTansOpt;

    @SerializedName("pre_load_dynamic_container_on_feedview")
    private boolean preLoadDynamicContainerOnFeedView;

    @SerializedName("pre_load_dynamic_container_when_idle")
    private boolean preLoadDynamicContainerWhenIdle;

    @SerializedName("pre_load_render_widget_size")
    private int preLoadRenderWidgetSize;

    @SerializedName("pre_load_root_widget_size")
    private int preLoadRootWidgetSize;

    @SerializedName("pre_load_idle_delay")
    private long preloadIdleDelay;

    @SerializedName("reload_count")
    private int reloadCount;

    @SerializedName("slow_function_opt")
    private boolean slowFunctionOpt;

    @SerializedName("total_enable")
    private boolean totalEnable;

    public MultiLinkRevenueEnterRoomOptConfig() {
        this.jsbTansOpt = true;
        this.asyncLoadLynx = true;
        this.adjustLayerDelay = 1000;
        this.advanceLoadLynx = true;
        this.preloadIdleDelay = 10000;
        this.preLoadRootWidgetSize = 1;
        this.preLoadRenderWidgetSize = 3;
        this.reloadCount = 3;
    }

    public final long adjustLayerDelay() {
        return this.adjustLayerDelay;
    }

    public final boolean advanceLoadLynx() {
        return this.advanceLoadLynx;
    }

    public final boolean asyncLoadLynx() {
        return this.asyncLoadLynx;
    }

    public final boolean enableJsbTransferOpt() {
        return this.jsbTansOpt;
    }

    public final boolean enablePreLoadDynamicContainerOnFeedView() {
        return this.preLoadDynamicContainerOnFeedView;
    }

    public final boolean enablePreLoadDynamicContainerWhenIdle() {
        return this.preLoadDynamicContainerWhenIdle;
    }

    public final int getPreLoadRenderWidgetSize() {
        return this.preLoadRenderWidgetSize;
    }

    public final int getPreLoadRootWidgetSize() {
        return this.preLoadRootWidgetSize;
    }

    public final long getPreloadIdleDelay() {
        return this.preloadIdleDelay;
    }

    public final boolean isTotalEnable() {
        return this.totalEnable;
    }

    public final int reloadCount() {
        return this.reloadCount;
    }

    public final boolean slowFunctionOpt() {
        return this.slowFunctionOpt;
    }
}
