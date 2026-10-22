package com.bytedance.android.livesdk.interactivity.api.publicscreen.api;

import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
@ForMain
public class u {

    @SerializedName("can_show")
    public boolean canShow;

    @SerializedName("inside_name")
    public List<String> insideName;

    @SerializedName("item_id")
    public long itemId;

    @SerializedName("outside_name")
    public List<String> outsideName;

    @SerializedName("priority")
    public long priority;

    @SerializedName("show_outside")
    public boolean showOutside;

    public u() {
    }
}
