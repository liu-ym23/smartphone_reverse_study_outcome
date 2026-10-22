package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class ActionConfigs {

    @SerializedName("entrances")
    public List<ActionConfig> entrances;

    @SerializedName("flash_shopping")
    public ActionConfig flashShopping;

    public ActionConfigs() {
    }
}
