package com.bytedance.android.shopping.store.home.entity;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\rR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001d\u0010\rR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000b\u001a\u0004\b\u001f\u0010\rR\u001c\u0010 \u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/p;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "headerBackgroundImg", "Lcom/bytedance/android/ec/model/ECUrlModel;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/ECUrlModel;", "headerCardImg", "getHeaderCardImg", "", "primaryColor", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "secondaryColor", "d", "", "transparency", "Ljava/lang/Double;", "h", "()Ljava/lang/Double;", "", "shopUiTheme", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "tabTextColor", ce.f26391f, "navSearchColor", "getNavSearchColor", "tabIndicatorColor", "f", "maskAlpha", "b", "splitRadius", "getSplitRadius", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("header_background_img")
    private final ECUrlModel headerBackgroundImg;

    @SerializedName("header_card_img")
    private final ECUrlModel headerCardImg;

    @SerializedName("mask_alpha")
    private final Double maskAlpha;

    @SerializedName("nav_search_color")
    private final String navSearchColor;

    @SerializedName("primary_color")
    private final String primaryColor;

    @SerializedName("secondary_color")
    private final String secondaryColor;

    @SerializedName("shop_ui_theme")
    private final Integer shopUiTheme;

    @SerializedName("split_radius")
    private final Integer splitRadius;

    @SerializedName("tab_selected_indicator_color")
    private final String tabIndicatorColor;

    @SerializedName("tab_text_color")
    private final String tabTextColor;

    @SerializedName("transparency")
    private final Double transparency;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L28;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.headerBackgroundImg, r101.headerBackgroundImg) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.headerCardImg, r101.headerCardImg) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.primaryColor, r101.primaryColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.secondaryColor, r101.secondaryColor) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.transparency, r101.transparency) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.shopUiTheme, r101.shopUiTheme) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tabTextColor, r101.tabTextColor) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.navSearchColor, r101.navSearchColor) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.tabIndicatorColor, r101.tabIndicatorColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.maskAlpha, r101.maskAlpha) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.splitRadius, r101.splitRadius) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r100 = this.headerBackgroundImg;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.headerCardImg;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.primaryColor;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.secondaryColor;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Double r113 = this.transparency;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.shopUiTheme;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.tabTextColor;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.navSearchColor;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.tabIndicatorColor;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Double r128 = this.maskAlpha;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Integer r131 = this.splitRadius;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        return r130 + r101;
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
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
        return "ECStoreHeaderStyleInfoDTO(headerBackgroundImg=" + this.headerBackgroundImg + ", headerCardImg=" + this.headerCardImg + ", primaryColor=" + this.primaryColor + ", secondaryColor=" + this.secondaryColor + ", transparency=" + this.transparency + ", shopUiTheme=" + this.shopUiTheme + ", tabTextColor=" + this.tabTextColor + ", navSearchColor=" + this.navSearchColor + ", tabIndicatorColor=" + this.tabIndicatorColor + ", maskAlpha=" + this.maskAlpha + ", splitRadius=" + this.splitRadius + ")";
    }

    public p() {
        this.headerBackgroundImg = null;
        this.headerCardImg = null;
        this.primaryColor = null;
        this.secondaryColor = null;
        this.transparency = null;
        this.shopUiTheme = null;
        this.tabTextColor = null;
        this.navSearchColor = null;
        this.tabIndicatorColor = null;
        this.maskAlpha = null;
        this.splitRadius = null;
    }

    public final ECUrlModel a() {
        return this.headerBackgroundImg;
    }

    public final Double b() {
        return this.maskAlpha;
    }

    public final String c() {
        return this.primaryColor;
    }

    public final String d() {
        return this.secondaryColor;
    }

    public final Integer e() {
        return this.shopUiTheme;
    }

    public final String f() {
        return this.tabIndicatorColor;
    }

    public final String g() {
        return this.tabTextColor;
    }

    public final Double h() {
        return this.transparency;
    }
}
