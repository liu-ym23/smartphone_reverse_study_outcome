package com.bytedance.android.livehostapi.business.depend.livead.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSelectionRequest;", "", "()V", "page", "", "getPage", "()I", "setPage", "(I)V", "pageSize", "getPageSize", "setPageSize", "tabId", "", "getTabId", "()Ljava/lang/String;", "setTabId", "(Ljava/lang/String;)V", "type", "", "getType", "()J", "setType", "(J)V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StampSelectionRequest {

    @SerializedName("page")
    private int page;

    @SerializedName("page_size")
    private int pageSize;

    @SerializedName("tab_id")
    private String tabId;

    @SerializedName("type")
    private long type;

    public StampSelectionRequest() {
        this.tabId = "";
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final long getType() {
        return this.type;
    }

    public final void setPage(int r100) {
        this.page = r100;
    }

    public final void setPageSize(int r100) {
        this.pageSize = r100;
    }

    public final void setTabId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tabId = r100;
    }

    public final void setType(long r100) {
        this.type = r100;
    }
}
