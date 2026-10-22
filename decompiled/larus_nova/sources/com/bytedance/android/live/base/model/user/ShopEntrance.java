package com.bytedance.android.live.base.model.user;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class ShopEntrance {

    @SerializedName(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE)
    public int entranceType;

    @SerializedName("shop_url")
    public String shopUrl;

    @SerializedName("window_url")
    public String windowUrl;

    public ShopEntrance() {
    }
}
