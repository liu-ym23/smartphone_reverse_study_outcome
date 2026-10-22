package com.bytedance.android.window.shop.repository.dto;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001c\u0010#\u001a\u0004\u0018\u00010\"8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/p;", "", "", "name", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "id", "b", "Lcom/bytedance/android/window/shop/repository/dto/WindowCategoryConfigDTO;", "categoryConfig", "Lcom/bytedance/android/window/shop/repository/dto/WindowCategoryConfigDTO;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/window/shop/repository/dto/WindowCategoryConfigDTO;", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "selectedIconUrl", "Lcom/bytedance/android/ec/model/ECUrlModel;", "f", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "unSelectedIconUrl", ce.f26395j, "selectedColor", "e", "unSelectedColor", RXScreenCaptureService.KEY_INDEX, "selectBackgroundColor", "d", "selectedIndicatorColor", ce.f26391f, "Lcom/bytedance/android/window/shop/repository/dto/a0;", "tabBackgroundColor", "Lcom/bytedance/android/window/shop/repository/dto/a0;", "h", "()Lcom/bytedance/android/window/shop/repository/dto/a0;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p {

    @SerializedName("category_config")
    private final WindowCategoryConfigDTO categoryConfig;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("back_category_ids")
    private final String f189425id;

    @SerializedName("front_category_name")
    private final String name;

    @SerializedName("selected_background_color")
    private final String selectBackgroundColor;

    @SerializedName("selected_color")
    private final String selectedColor;

    @SerializedName(alternate = {"selected_icon_transparent_url"}, value = "selected_icon_url")
    private final ECUrlModel selectedIconUrl;

    @SerializedName("selected_indicator_color")
    private final String selectedIndicatorColor;

    @SerializedName("tab_background_color")
    private final a0 tabBackgroundColor;

    @SerializedName("category_type")
    private final Integer type;

    @SerializedName("unselected_color")
    private final String unSelectedColor;

    @SerializedName(alternate = {"unselected_icon_transparent_url"}, value = "unselected_icon_url")
    private final ECUrlModel unSelectedIconUrl;

    public p() {
        this(null, null, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L28;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f189425id, r101.f189425id) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.categoryConfig, r101.categoryConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.selectedIconUrl, r101.selectedIconUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.unSelectedIconUrl, r101.unSelectedIconUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.selectedColor, r101.selectedColor) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.unSelectedColor, r101.unSelectedColor) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.selectBackgroundColor, r101.selectBackgroundColor) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.selectedIndicatorColor, r101.selectedIndicatorColor) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.tabBackgroundColor, r101.tabBackgroundColor) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        String r100 = this.name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f189425id;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        WindowCategoryConfigDTO r107 = this.categoryConfig;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.type;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ECUrlModel r113 = this.selectedIconUrl;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ECUrlModel r116 = this.unSelectedIconUrl;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.selectedColor;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.unSelectedColor;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.selectBackgroundColor;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.selectedIndicatorColor;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        a0 r131 = this.tabBackgroundColor;
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
        return "WindowCategoryDTO(name=" + this.name + ", id=" + this.f189425id + ", categoryConfig=" + this.categoryConfig + ", type=" + this.type + ", selectedIconUrl=" + this.selectedIconUrl + ", unSelectedIconUrl=" + this.unSelectedIconUrl + ", selectedColor=" + this.selectedColor + ", unSelectedColor=" + this.unSelectedColor + ", selectBackgroundColor=" + this.selectBackgroundColor + ", selectedIndicatorColor=" + this.selectedIndicatorColor + ", tabBackgroundColor=" + this.tabBackgroundColor + ")";
    }

    public final WindowCategoryConfigDTO a() {
        return this.categoryConfig;
    }

    public final String b() {
        return this.f189425id;
    }

    public final String c() {
        return this.name;
    }

    public final String d() {
        return this.selectBackgroundColor;
    }

    public final String e() {
        return this.selectedColor;
    }

    public final ECUrlModel f() {
        return this.selectedIconUrl;
    }

    public final String g() {
        return this.selectedIndicatorColor;
    }

    public final Integer getType() {
        return this.type;
    }

    public final a0 h() {
        return this.tabBackgroundColor;
    }

    public final String i() {
        return this.unSelectedColor;
    }

    public final ECUrlModel j() {
        return this.unSelectedIconUrl;
    }

    public p(String r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.name = r100;
        this.f189425id = r101;
        this.categoryConfig = null;
        this.type = null;
        this.selectedIconUrl = null;
        this.unSelectedIconUrl = null;
        this.selectedColor = null;
        this.unSelectedColor = null;
        this.selectBackgroundColor = null;
        this.selectedIndicatorColor = null;
        this.tabBackgroundColor = null;
    }
}
