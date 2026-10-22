package com.bytedance.android.livehostapi.business.depend.livead.model;

import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR2\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R2\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u0015\u0018\u0001`\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSelectionResponse;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/BaseResponse;", "()V", "enableLoadMore", "", "getEnableLoadMore", "()Z", "setEnableLoadMore", "(Z)V", "enableSearch", "getEnableSearch", "setEnableSearch", IPerformanceManager.Params.modules, "Ljava/util/ArrayList;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSelectionModule;", "Lkotlin/collections/ArrayList;", "getModules", "()Ljava/util/ArrayList;", "setModules", "(Ljava/util/ArrayList;)V", "tabs", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSelectionTab;", "getTabs", "setTabs", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StampSelectionResponse extends BaseResponse {

    @SerializedName("enable_load_more")
    private boolean enableLoadMore;

    @SerializedName("enable_search")
    private boolean enableSearch;

    @SerializedName(IPerformanceManager.Params.modules)
    private ArrayList<StampSelectionModule> modules;

    @SerializedName("tabs")
    private ArrayList<StampSelectionTab> tabs;

    public StampSelectionResponse() {
    }

    public final boolean getEnableLoadMore() {
        return this.enableLoadMore;
    }

    public final boolean getEnableSearch() {
        return this.enableSearch;
    }

    public final ArrayList<StampSelectionModule> getModules() {
        return this.modules;
    }

    public final ArrayList<StampSelectionTab> getTabs() {
        return this.tabs;
    }

    public final void setEnableLoadMore(boolean r100) {
        this.enableLoadMore = r100;
    }

    public final void setEnableSearch(boolean r100) {
        this.enableSearch = r100;
    }

    public final void setModules(ArrayList<StampSelectionModule> r100) {
        this.modules = r100;
    }

    public final void setTabs(ArrayList<StampSelectionTab> r100) {
        this.tabs = r100;
    }
}
