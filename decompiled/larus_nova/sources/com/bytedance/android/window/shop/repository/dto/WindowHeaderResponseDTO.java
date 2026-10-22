package com.bytedance.android.window.shop.repository.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b$\u0010%J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J9\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0011\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010!\u001a\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/WindowHeaderResponseDTO;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "Lcom/bytedance/android/window/shop/repository/dto/d0;", "component1", "Lcom/bytedance/android/window/shop/repository/dto/g0;", "component2", "Lcom/bytedance/android/window/shop/repository/dto/c;", "component3", "Lcom/bytedance/android/window/shop/repository/dto/e0;", "component4", "shopHeaderBaseInfo", "shopHeaderControl", "productListInfo", "windowHeaderBffDataData", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/window/shop/repository/dto/d0;", "getShopHeaderBaseInfo", "()Lcom/bytedance/android/window/shop/repository/dto/d0;", "Lcom/bytedance/android/window/shop/repository/dto/g0;", "getShopHeaderControl", "()Lcom/bytedance/android/window/shop/repository/dto/g0;", "Lcom/bytedance/android/window/shop/repository/dto/c;", "getProductListInfo", "()Lcom/bytedance/android/window/shop/repository/dto/c;", "Lcom/bytedance/android/window/shop/repository/dto/e0;", "getWindowHeaderBffDataData", "()Lcom/bytedance/android/window/shop/repository/dto/e0;", "<init>", "(Lcom/bytedance/android/window/shop/repository/dto/d0;Lcom/bytedance/android/window/shop/repository/dto/g0;Lcom/bytedance/android/window/shop/repository/dto/c;Lcom/bytedance/android/window/shop/repository/dto/e0;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowHeaderResponseDTO extends CommerceBaseResponse {

    @SerializedName("inventories")
    private final c productListInfo;

    @SerializedName("window_header_basic_info")
    private final d0 shopHeaderBaseInfo;

    @SerializedName("window_header_control_info")
    private final g0 shopHeaderControl;

    @SerializedName("window_header_bff")
    private final e0 windowHeaderBffDataData;

    public WindowHeaderResponseDTO() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ WindowHeaderResponseDTO copy$default(WindowHeaderResponseDTO r100, d0 r101, g0 r102, c r103, e0 r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.shopHeaderBaseInfo;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.shopHeaderControl;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.productListInfo;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.windowHeaderBffDataData;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final d0 component1() {
        return this.shopHeaderBaseInfo;
    }

    public final g0 component2() {
        return this.shopHeaderControl;
    }

    public final c component3() {
        return this.productListInfo;
    }

    public final e0 component4() {
        return this.windowHeaderBffDataData;
    }

    public final WindowHeaderResponseDTO copy(d0 r100, g0 r101, c r102, e0 r103) {
        return new WindowHeaderResponseDTO(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof WindowHeaderResponseDTO) == false) goto L14;
        WindowHeaderResponseDTO r101 = (WindowHeaderResponseDTO) r100;
        if (Intrinsics.areEqual(this.shopHeaderBaseInfo, r101.shopHeaderBaseInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shopHeaderControl, r101.shopHeaderControl) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.productListInfo, r101.productListInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.windowHeaderBffDataData, r101.windowHeaderBffDataData) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        d0 r100 = this.shopHeaderBaseInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        g0 r104 = this.shopHeaderControl;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        c r107 = this.productListInfo;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        e0 r110 = this.windowHeaderBffDataData;
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
        return "WindowHeaderResponseDTO(shopHeaderBaseInfo=" + this.shopHeaderBaseInfo + ", shopHeaderControl=" + this.shopHeaderControl + ", productListInfo=" + this.productListInfo + ", windowHeaderBffDataData=" + this.windowHeaderBffDataData + ")";
    }

    public final c getProductListInfo() {
        return this.productListInfo;
    }

    public final d0 getShopHeaderBaseInfo() {
        return this.shopHeaderBaseInfo;
    }

    public final g0 getShopHeaderControl() {
        return this.shopHeaderControl;
    }

    public final e0 getWindowHeaderBffDataData() {
        return this.windowHeaderBffDataData;
    }

    public WindowHeaderResponseDTO(d0 r100, g0 r101, c r102, e0 r103) {
        this.shopHeaderBaseInfo = r100;
        this.shopHeaderControl = r101;
        this.productListInfo = r102;
        this.windowHeaderBffDataData = r103;
    }

    public /* synthetic */ WindowHeaderResponseDTO(d0 r100, g0 r101, c r102, e0 r103, int r104, DefaultConstructorMarker r105) {
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
