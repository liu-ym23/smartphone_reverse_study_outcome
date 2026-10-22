package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveInnerViewPagerConfig;", "", "()V", "enableReleaseLowItem", "", "getEnableReleaseLowItem", "()Z", "setEnableReleaseLowItem", "(Z)V", "enableSeparatePageLimit", "getEnableSeparatePageLimit", "setEnableSeparatePageLimit", "releaseLowItemDelayTime", "", "getReleaseLowItemDelayTime", "()J", "setReleaseLowItemDelayTime", "(J)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInnerViewPagerConfig {

    @SerializedName("enable_release_low_item")
    private boolean enableReleaseLowItem;

    @SerializedName("enable_separate_page_limit")
    private boolean enableSeparatePageLimit;

    @SerializedName("release_low_item_delay_time")
    private long releaseLowItemDelayTime;

    public LiveInnerViewPagerConfig() {
        this.releaseLowItemDelayTime = 10000;
    }

    public final boolean getEnableReleaseLowItem() {
        return this.enableReleaseLowItem;
    }

    public final boolean getEnableSeparatePageLimit() {
        return this.enableSeparatePageLimit;
    }

    public final long getReleaseLowItemDelayTime() {
        return this.releaseLowItemDelayTime;
    }

    public final void setEnableReleaseLowItem(boolean r100) {
        this.enableReleaseLowItem = r100;
    }

    public final void setEnableSeparatePageLimit(boolean r100) {
        this.enableSeparatePageLimit = r100;
    }

    public final void setReleaseLowItemDelayTime(long r100) {
        this.releaseLowItemDelayTime = r100;
    }
}
