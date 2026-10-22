package com.bytedance.android.livehostapi.business.depend.livead.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001e\u0010 \u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSelectionModule;", "", "()V", "cells", "Ljava/util/ArrayList;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/StampSelectionCell;", "Lkotlin/collections/ArrayList;", "getCells", "()Ljava/util/ArrayList;", "setCells", "(Ljava/util/ArrayList;)V", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "page", "", "getPage", "()I", "setPage", "(I)V", "pageSize", "getPageSize", "setPageSize", "schemaUrl", "getSchemaUrl", "setSchemaUrl", "type", "", "getType", "()J", "setType", "(J)V", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StampSelectionModule {

    @SerializedName("cells")
    private ArrayList<StampSelectionCell> cells;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("name")
    private String name;

    @SerializedName("page")
    private int page;

    @SerializedName("page_size")
    private int pageSize;

    @SerializedName(a.KEY_SCHEMA_URL)
    private String schemaUrl;

    @SerializedName("type")
    private long type;

    public StampSelectionModule() {
        this.name = "";
        this.schemaUrl = "";
    }

    public final ArrayList<StampSelectionCell> getCells() {
        return this.cells;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getName() {
        return this.name;
    }

    public final int getPage() {
        return this.page;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final String getSchemaUrl() {
        return this.schemaUrl;
    }

    public final long getType() {
        return this.type;
    }

    public final void setCells(ArrayList<StampSelectionCell> r100) {
        this.cells = r100;
    }

    public final void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setPage(int r100) {
        this.page = r100;
    }

    public final void setPageSize(int r100) {
        this.pageSize = r100;
    }

    public final void setSchemaUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.schemaUrl = r100;
    }

    public final void setType(long r100) {
        this.type = r100;
    }
}
