package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.livehostapi.platform.base.IBaseHostPerformanceMonitor;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/SdkParamsOptimizeConfig;", "", "()V", "cacheSize", "", "getCacheSize", "()I", "setCacheSize", "(I)V", "enableOptimize", "", "getEnableOptimize", "()Z", "setEnableOptimize", "(Z)V", "enableRemoveAll", "getEnableRemoveAll", "setEnableRemoveAll", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SdkParamsOptimizeConfig {

    @SerializedName(IBaseHostPerformanceMonitor.CACHE_BITMAP_MEMORY_SIZE)
    private int cacheSize;

    @SerializedName("enable_optimize")
    private boolean enableOptimize;

    @SerializedName("enable_remove_all")
    private boolean enableRemoveAll;

    public SdkParamsOptimizeConfig() {
        this.cacheSize = 10;
    }

    public final int getCacheSize() {
        return this.cacheSize;
    }

    public final boolean getEnableOptimize() {
        return this.enableOptimize;
    }

    public final boolean getEnableRemoveAll() {
        return this.enableRemoveAll;
    }

    public final void setCacheSize(int r100) {
        this.cacheSize = r100;
    }

    public final void setEnableOptimize(boolean r100) {
        this.enableOptimize = r100;
    }

    public final void setEnableRemoveAll(boolean r100) {
        this.enableRemoveAll = r100;
    }
}
