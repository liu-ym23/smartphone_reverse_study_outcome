package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J;\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR&\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/WysiwygParam;", "", "items", "", "extraInfo", "", "blockWysiwygItems", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "getBlockWysiwygItems", "()Ljava/lang/String;", "getExtraInfo", "()Ljava/util/Map;", "getItems", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WysiwygParam {

    @SerializedName("block_wysiwyg_items")
    private final String blockWysiwygItems;

    @SerializedName("extra_info")
    private final Map<String, String> extraInfo;

    @SerializedName("items")
    private final String items;

    public WysiwygParam() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WysiwygParam copy$default(WysiwygParam r100, String r101, Map r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.items;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.extraInfo;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.blockWysiwygItems;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.items;
    }

    public final Map<String, String> component2() {
        return this.extraInfo;
    }

    public final String component3() {
        return this.blockWysiwygItems;
    }

    public final WysiwygParam copy(String r100, Map<String, String> r101, String r102) {
        return new WysiwygParam(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof WysiwygParam) == false) goto L12;
        WysiwygParam r101 = (WysiwygParam) r100;
        if (Intrinsics.areEqual(this.items, r101.items) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.extraInfo, r101.extraInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.blockWysiwygItems, r101.blockWysiwygItems) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.items;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, String> r104 = this.extraInfo;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.blockWysiwygItems;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "WysiwygParam(items=" + this.items + ", extraInfo=" + this.extraInfo + ", blockWysiwygItems=" + this.blockWysiwygItems + ")";
    }

    public final String getBlockWysiwygItems() {
        return this.blockWysiwygItems;
    }

    public final Map<String, String> getExtraInfo() {
        return this.extraInfo;
    }

    public final String getItems() {
        return this.items;
    }

    public WysiwygParam(String r100, Map<String, String> r101, String r102) {
        this.items = r100;
        this.extraInfo = r101;
        this.blockWysiwygItems = r102;
    }

    public /* synthetic */ WysiwygParam(String r100, Map r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
