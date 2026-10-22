package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0010JD\u0010\u0017\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabArea;", "", "mallCategoryTabList", "", "Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTab;", "defaultTab", "", "topTab", "maxFontLen", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getDefaultTab", "()Ljava/lang/String;", "getMallCategoryTabList", "()Ljava/util/List;", "getMaxFontLen", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTopTab", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabArea;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallCategoryTabArea {

    @SerializedName("default_tab")
    private final String defaultTab;

    @SerializedName("mall_category_tab_list")
    private final List<MallCategoryTab> mallCategoryTabList;

    @SerializedName("max_font_len")
    private final Integer maxFontLen;

    @SerializedName("top_tab")
    private final String topTab;

    public MallCategoryTabArea() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MallCategoryTabArea copy$default(MallCategoryTabArea r100, List r101, String r102, String r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.mallCategoryTabList;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.defaultTab;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.topTab;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.maxFontLen;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final List<MallCategoryTab> component1() {
        return this.mallCategoryTabList;
    }

    public final String component2() {
        return this.defaultTab;
    }

    public final String component3() {
        return this.topTab;
    }

    public final Integer component4() {
        return this.maxFontLen;
    }

    public final MallCategoryTabArea copy(List<MallCategoryTab> r100, String r101, String r102, Integer r103) {
        return new MallCategoryTabArea(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MallCategoryTabArea) == false) goto L14;
        MallCategoryTabArea r101 = (MallCategoryTabArea) r100;
        if (Intrinsics.areEqual(this.mallCategoryTabList, r101.mallCategoryTabList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.defaultTab, r101.defaultTab) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.topTab, r101.topTab) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxFontLen, r101.maxFontLen) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        List<MallCategoryTab> r100 = this.mallCategoryTabList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.defaultTab;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.topTab;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.maxFontLen;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "MallCategoryTabArea(mallCategoryTabList=" + this.mallCategoryTabList + ", defaultTab=" + this.defaultTab + ", topTab=" + this.topTab + ", maxFontLen=" + this.maxFontLen + ")";
    }

    public final String getDefaultTab() {
        return this.defaultTab;
    }

    public final List<MallCategoryTab> getMallCategoryTabList() {
        return this.mallCategoryTabList;
    }

    public final Integer getMaxFontLen() {
        return this.maxFontLen;
    }

    public final String getTopTab() {
        return this.topTab;
    }

    public MallCategoryTabArea(List<MallCategoryTab> r100, String r101, String r102, Integer r103) {
        this.mallCategoryTabList = r100;
        this.defaultTab = r101;
        this.topTab = r102;
        this.maxFontLen = r103;
    }

    public /* synthetic */ MallCategoryTabArea(List r100, String r101, String r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
