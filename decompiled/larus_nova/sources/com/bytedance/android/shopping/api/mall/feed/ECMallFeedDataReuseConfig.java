package com.bytedance.android.shopping.api.mall.feed;

import com.bytedance.android.livehostapi.platform.base.IBaseHostPerformanceMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR&\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\u001e\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\b¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/feed/ECMallFeedDataReuseConfig;", "Ljava/io/Serializable;", "()V", "cacheSize", "", "getCacheSize", "()I", "setCacheSize", "(I)V", "combinedItemType", "getCombinedItemType", "setCombinedItemType", "enabledPages", "", "", "getEnabledPages", "()Ljava/util/List;", "setEnabledPages", "(Ljava/util/List;)V", "maxSize", "getMaxSize", "()Ljava/lang/Integer;", "setMaxSize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "skipTrim", "", "getSkipTrim", "()Z", "setSkipTrim", "(Z)V", "specifiedItemTypes", "getSpecifiedItemTypes", "setSpecifiedItemTypes", "tabId", "getTabId", "setTabId", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallFeedDataReuseConfig implements Serializable {

    @SerializedName(IBaseHostPerformanceMonitor.CACHE_BITMAP_MEMORY_SIZE)
    private int cacheSize;

    @SerializedName("combined_item_type")
    private int combinedItemType;

    @SerializedName("enabled_pages")
    private List<String> enabledPages;

    @SerializedName(DownloadSettingKeys.MaxDiskSizeLimit.MAX_SIZE)
    private Integer maxSize;

    @SerializedName("skip_trim")
    private boolean skipTrim;

    @SerializedName("specified_item_types")
    private List<Integer> specifiedItemTypes;

    @SerializedName("tab_id")
    private int tabId;

    public ECMallFeedDataReuseConfig() {
        this.cacheSize = 10;
        this.skipTrim = true;
        this.combinedItemType = 51019;
    }

    public final int getCacheSize() {
        return this.cacheSize;
    }

    public final int getCombinedItemType() {
        return this.combinedItemType;
    }

    public final List<String> getEnabledPages() {
        return this.enabledPages;
    }

    public final Integer getMaxSize() {
        return this.maxSize;
    }

    public final boolean getSkipTrim() {
        return this.skipTrim;
    }

    public final List<Integer> getSpecifiedItemTypes() {
        return this.specifiedItemTypes;
    }

    public final int getTabId() {
        return this.tabId;
    }

    public final void setCacheSize(int r100) {
        this.cacheSize = r100;
    }

    public final void setCombinedItemType(int r100) {
        this.combinedItemType = r100;
    }

    public final void setEnabledPages(List<String> r100) {
        this.enabledPages = r100;
    }

    public final void setMaxSize(Integer r100) {
        this.maxSize = r100;
    }

    public final void setSkipTrim(boolean r100) {
        this.skipTrim = r100;
    }

    public final void setSpecifiedItemTypes(List<Integer> r100) {
        this.specifiedItemTypes = r100;
    }

    public final void setTabId(int r100) {
        this.tabId = r100;
    }
}
