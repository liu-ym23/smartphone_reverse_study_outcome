package com.bytedance.android.live.base.model.data;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class m {

    @SerializedName("icon")
    public py.k icon;

    @SerializedName("item_id")
    public String itemId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    public String itemType;

    @SerializedName("name")
    public String name;

    @SerializedName("name_color")
    public String nameColor;

    @SerializedName("schema")
    public String schema;

    public m() {
    }
}
