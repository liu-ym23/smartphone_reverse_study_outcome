package com.bytedance.android.shopping.store.home.entity;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/u;", "", "", "strokeColor", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "useLocalGradientBorder", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "searchTextColor", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "searchTextColorCollapse", "getSearchTextColorCollapse", "searchBtnBgColor", "getSearchBtnBgColor", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u {

    @SerializedName("btn_bg_color")
    private final String searchBtnBgColor;

    @SerializedName("text_color")
    private final String searchTextColor;

    @SerializedName("collapse_text_color")
    private final String searchTextColorCollapse;

    @SerializedName("border_color")
    private final String strokeColor;

    @SerializedName("use_local_gradient_border")
    private final Integer useLocalGradientBorder;

    public u() {
        this.strokeColor = null;
        this.useLocalGradientBorder = 0;
        this.searchTextColor = null;
        this.searchTextColorCollapse = null;
        this.searchBtnBgColor = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L16;
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.strokeColor, r101.strokeColor) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.useLocalGradientBorder, r101.useLocalGradientBorder) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.searchTextColor, r101.searchTextColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.searchTextColorCollapse, r101.searchTextColorCollapse) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.searchBtnBgColor, r101.searchBtnBgColor) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.strokeColor;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.useLocalGradientBorder;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.searchTextColor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.searchTextColorCollapse;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.searchBtnBgColor;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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

    public final String toString() {
        return "SearchBarConfig(strokeColor=" + this.strokeColor + ", useLocalGradientBorder=" + this.useLocalGradientBorder + ", searchTextColor=" + this.searchTextColor + ", searchTextColorCollapse=" + this.searchTextColorCollapse + ", searchBtnBgColor=" + this.searchBtnBgColor + ")";
    }

    public final String a() {
        return this.searchTextColor;
    }

    public final String b() {
        return this.strokeColor;
    }

    public final Integer c() {
        return this.useLocalGradientBorder;
    }
}
