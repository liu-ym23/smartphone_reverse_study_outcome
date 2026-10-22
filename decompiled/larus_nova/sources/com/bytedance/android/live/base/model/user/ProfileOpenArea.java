package com.bytedance.android.live.base.model.user;

import com.bytedance.android.livesdkapi.depend.model.live.LiveDSLModel;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class ProfileOpenArea {

    @SerializedName("business_area_v3")
    public ProfileBusinessArea businessAreaV3;

    @SerializedName("business_area_version")
    public long businessAreaVersion;

    @SerializedName("ecom_card")
    public LiveDSLModel ecomCardModel;

    @SerializedName("my_live_tabs")
    public MyLiveTabs myLiveTabs;

    public ProfileOpenArea() {
        this.businessAreaVersion = 2;
    }
}
