package com.bytedance.android.shopping.sku.common.utils;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/sku/common/utils/SkuBuyHeightPercentConfig;", "Ljava/io/Serializable;", "subHeightPercent", "", "urlWhiteList", "", "", "(ILjava/util/List;)V", "getSubHeightPercent", "()I", "setSubHeightPercent", "(I)V", "getUrlWhiteList", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuBuyHeightPercentConfig implements Serializable {

    @SerializedName("sub_height_percent")
    private int subHeightPercent;

    @SerializedName("url_white_list")
    private final List<String> urlWhiteList;

    /* JADX WARN: Multi-variable type inference failed */
    public SkuBuyHeightPercentConfig() {
        int r100 = 0;
        this(r100, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SkuBuyHeightPercentConfig copy$default(SkuBuyHeightPercentConfig r100, int r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.subHeightPercent;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.urlWhiteList;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.subHeightPercent;
    }

    public final List<String> component2() {
        return this.urlWhiteList;
    }

    public final SkuBuyHeightPercentConfig copy(int r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r101, "urlWhiteList");
        return new SkuBuyHeightPercentConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuBuyHeightPercentConfig) == false) goto L10;
        SkuBuyHeightPercentConfig r101 = (SkuBuyHeightPercentConfig) r100;
        if (this.subHeightPercent == r101.subHeightPercent) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.urlWhiteList, r101.urlWhiteList) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        int r100 = this.subHeightPercent * 31;
        List<String> r101 = this.urlWhiteList;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public String toString() {
        return "SkuBuyHeightPercentConfig(subHeightPercent=" + this.subHeightPercent + ", urlWhiteList=" + this.urlWhiteList + ")";
    }

    public final int getSubHeightPercent() {
        return this.subHeightPercent;
    }

    public final List<String> getUrlWhiteList() {
        return this.urlWhiteList;
    }

    public final void setSubHeightPercent(int r100) {
        this.subHeightPercent = r100;
    }

    public SkuBuyHeightPercentConfig(int r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r101, "urlWhiteList");
        this.subHeightPercent = r100;
        this.urlWhiteList = r101;
    }

    public /* synthetic */ SkuBuyHeightPercentConfig(int r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 73;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        this(r100, r101);
    }
}
