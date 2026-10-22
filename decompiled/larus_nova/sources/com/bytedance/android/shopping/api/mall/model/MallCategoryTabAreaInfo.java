package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAreaInfo;", "", "mallCategoryTabArea", "Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabArea;", "tabPanelConfig", "Lcom/bytedance/android/shopping/api/mall/model/TabPanelConfig;", "tabUIConfig", "Lcom/bytedance/android/shopping/api/mall/model/TabUIConfig;", "(Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabArea;Lcom/bytedance/android/shopping/api/mall/model/TabPanelConfig;Lcom/bytedance/android/shopping/api/mall/model/TabUIConfig;)V", "getMallCategoryTabArea", "()Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabArea;", "getTabPanelConfig", "()Lcom/bytedance/android/shopping/api/mall/model/TabPanelConfig;", "getTabUIConfig", "()Lcom/bytedance/android/shopping/api/mall/model/TabUIConfig;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallCategoryTabAreaInfo {

    @SerializedName("mall_category_tab_area")
    private final MallCategoryTabArea mallCategoryTabArea;

    @SerializedName("tab_panel_config")
    private final TabPanelConfig tabPanelConfig;

    @SerializedName("ui_config")
    private final TabUIConfig tabUIConfig;

    public MallCategoryTabAreaInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MallCategoryTabAreaInfo copy$default(MallCategoryTabAreaInfo r100, MallCategoryTabArea r101, TabPanelConfig r102, TabUIConfig r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.mallCategoryTabArea;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.tabPanelConfig;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.tabUIConfig;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final MallCategoryTabArea component1() {
        return this.mallCategoryTabArea;
    }

    public final TabPanelConfig component2() {
        return this.tabPanelConfig;
    }

    public final TabUIConfig component3() {
        return this.tabUIConfig;
    }

    public final MallCategoryTabAreaInfo copy(MallCategoryTabArea r100, TabPanelConfig r101, TabUIConfig r102) {
        return new MallCategoryTabAreaInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MallCategoryTabAreaInfo) == false) goto L12;
        MallCategoryTabAreaInfo r101 = (MallCategoryTabAreaInfo) r100;
        if (Intrinsics.areEqual(this.mallCategoryTabArea, r101.mallCategoryTabArea) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.tabPanelConfig, r101.tabPanelConfig) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tabUIConfig, r101.tabUIConfig) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        MallCategoryTabArea r100 = this.mallCategoryTabArea;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        TabPanelConfig r104 = this.tabPanelConfig;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        TabUIConfig r107 = this.tabUIConfig;
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
        return "MallCategoryTabAreaInfo(mallCategoryTabArea=" + this.mallCategoryTabArea + ", tabPanelConfig=" + this.tabPanelConfig + ", tabUIConfig=" + this.tabUIConfig + ")";
    }

    public final MallCategoryTabArea getMallCategoryTabArea() {
        return this.mallCategoryTabArea;
    }

    public final TabPanelConfig getTabPanelConfig() {
        return this.tabPanelConfig;
    }

    public final TabUIConfig getTabUIConfig() {
        return this.tabUIConfig;
    }

    public MallCategoryTabAreaInfo(MallCategoryTabArea r100, TabPanelConfig r101, TabUIConfig r102) {
        this.mallCategoryTabArea = r100;
        this.tabPanelConfig = r101;
        this.tabUIConfig = r102;
    }

    public /* synthetic */ MallCategoryTabAreaInfo(MallCategoryTabArea r100, TabPanelConfig r101, TabUIConfig r102, int r103, DefaultConstructorMarker r104) {
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
