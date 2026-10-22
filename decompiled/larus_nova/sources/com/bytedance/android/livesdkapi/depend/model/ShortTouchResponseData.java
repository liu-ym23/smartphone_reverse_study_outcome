package com.bytedance.android.livesdkapi.depend.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.n;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
@ForMain
public class ShortTouchResponseData {

    @SerializedName("short_touch_area")
    public List<n> shortTouchAreas;

    public ShortTouchResponseData() {
    }
}
