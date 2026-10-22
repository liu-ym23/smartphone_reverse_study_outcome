package com.bytedance.android.livesdk.chatroom.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class k3 {

    @SerializedName("AnchorShareText")
    String AnchorShareText;

    @SerializedName("IsShopGuide")
    Boolean IsShopGuide;

    @SerializedName("ShareUrl")
    String ShareUrl;

    @SerializedName("ShopGuideId")
    String ShopGuideId;

    @SerializedName("UserShareText")
    String UserShareText;

    @SerializedName("CommonShareParams")
    Map<String, String> liveCommonShareParams;

    public k3() {
    }

    public final Boolean a() {
        return this.IsShopGuide;
    }

    public final Map<String, String> b() {
        return this.liveCommonShareParams;
    }

    public final String c() {
        return this.ShareUrl;
    }

    public final String d() {
        return this.ShopGuideId;
    }
}
