package com.bytedance.android.shopping.orderlist.list.starter;

import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.list.model.PageContext;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020!J\b\u0010$\u001a\u0004\u0018\u00010\u0004R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006%"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/starter/OrderListParams;", "Ljava/io/Serializable;", "()V", "bizIdentity", "", "getBizIdentity", "()Ljava/lang/String;", "setBizIdentity", "(Ljava/lang/String;)V", "pageContext", "Lcom/bytedance/android/shopping/orderlist/list/model/PageContext;", "getPageContext", "()Lcom/bytedance/android/shopping/orderlist/list/model/PageContext;", "setPageContext", "(Lcom/bytedance/android/shopping/orderlist/list/model/PageContext;)V", "schemaParamsMap", "", "getSchemaParamsMap", "()Ljava/util/Map;", "setSchemaParamsMap", "(Ljava/util/Map;)V", "sourceBtmToken", "getSourceBtmToken", "setSourceBtmToken", "tabId", "", "getTabId", "()I", "setTabId", "(I)V", "getEnterFrom", "getPreviousPage", "hasScrollAnchorId", "", "ifMustReport", "isHideGul", "isNewEntryFromMall", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OrderListParams implements Serializable {

    @SerializedName("bizIdentity")
    private String bizIdentity;

    @SerializedName("pageContext")
    private PageContext pageContext;

    @SerializedName("schemaParamsMap")
    private Map<String, String> schemaParamsMap;

    @SerializedName("sourceBtmToken")
    private String sourceBtmToken;

    @SerializedName("tabId")
    private int tabId;

    public final String getEnterFrom() {
        Map<String, String> r100 = this.schemaParamsMap;
        if (r100 == null) goto L6;
        String r101 = r100.get("enter_from");
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final String getPreviousPage() {
        Map<String, String> r100 = this.schemaParamsMap;
        if (r100 == null) goto L5;
        String r101 = r100.get("history_path");
    L6:
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L14;
        return r101;
    L14:
        return getEnterFrom();
    L8:
        if (StringsKt.isBlank(r101) == true) goto L11;
        r102 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public final boolean hasScrollAnchorId() {
        Map<String, String> r100 = this.schemaParamsMap;
        if (r100 == null) goto L5;
        String r101 = r100.get("scroll_anchor_id");
    L7:
        return k.c(r101);
    L5:
        r101 = null;
        goto L7
    }

    public final boolean ifMustReport() {
        Map<String, String> r100 = this.schemaParamsMap;
        if (r100 == null) goto L5;
        String r101 = r100.get("performance_task_id");
    L7:
        return k.c(r101);
    L5:
        r101 = null;
        goto L7
    }

    public final boolean isHideGul() {
        Map<String, String> r100 = this.schemaParamsMap;
        if (r100 == null) goto L7;
        String r101 = r100.get("hide_guess_you_like");
        if (r101 == null) goto L7;
        return Intrinsics.areEqual(r101, "1");
    L7:
        return false;
    }

    public final String isNewEntryFromMall() {
        Map<String, String> r100 = this.schemaParamsMap;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get("is_new_entry_from_mall");
    }

    public OrderListParams() {
        this.schemaParamsMap = new LinkedHashMap();
        this.bizIdentity = "";
    }

    public final String getBizIdentity() {
        return this.bizIdentity;
    }

    public final PageContext getPageContext() {
        return this.pageContext;
    }

    public final Map<String, String> getSchemaParamsMap() {
        return this.schemaParamsMap;
    }

    public final String getSourceBtmToken() {
        return this.sourceBtmToken;
    }

    public final int getTabId() {
        return this.tabId;
    }

    public final void setBizIdentity(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.bizIdentity = r100;
    }

    public final void setPageContext(PageContext r100) {
        this.pageContext = r100;
    }

    public final void setSchemaParamsMap(Map<String, String> r100) {
        this.schemaParamsMap = r100;
    }

    public final void setSourceBtmToken(String r100) {
        this.sourceBtmToken = r100;
    }

    public final void setTabId(int r100) {
        this.tabId = r100;
    }
}
