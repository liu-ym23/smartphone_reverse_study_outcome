package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public class EcomInfo {
    public static int ECOM_TYPE_NO = 0;
    public static int ECOM_TYPE_SHOP = 1;
    public static int ECOM_TYPE_WINDOW = 2;

    @SerializedName("content_color")
    public String contentColor;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_ECOM_TYPE)
    int ecomType;

    @SerializedName("ecom_wall_bgs")
    public Map<Integer, HonorWallUi.HonorWallBg> ecomWallBgs;

    @SerializedName("shop_header_info")
    ShopHeaderInfo shopHeaderInfo;

    @SerializedName("title_color")
    public String titleColor;

    @SerializedName("window_header_info")
    WindowHeaderInfo windowHeaderInfo;

    public EcomInfo() {
    }

    public boolean hasXzg() {
        if (isShopType() == false) goto L9;
        ShopHeaderInfo r100 = this.shopHeaderInfo;
        if (r100 == null) goto L9;
        if (r100.heartDiamondInfo == null) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isShopType() {
        if (getEcomType() != ProfileConstant$ProfileType.SHOP.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isWindowType() {
        if (getEcomType() != ProfileConstant$ProfileType.WINDOW.getType()) goto L5;
        return true;
    L5:
        return false;
    }

    public int getEcomType() {
        return this.ecomType;
    }

    public ShopHeaderInfo getShopHeaderInfo() {
        return this.shopHeaderInfo;
    }

    public WindowHeaderInfo getWindowHeaderInfo() {
        return this.windowHeaderInfo;
    }
}
