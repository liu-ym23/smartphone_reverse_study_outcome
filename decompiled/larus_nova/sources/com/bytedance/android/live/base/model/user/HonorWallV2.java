package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class HonorWallV2 {

    @SerializedName("honor_wall_element")
    List<HonorWallElement> honorWallElement;

    @SerializedName("honor_wall_switch")
    boolean honorWallSwitch;

    public HonorWallV2() {
    }

    public List<HonorWallElement> getHonorWallElement() {
        return this.honorWallElement;
    }

    public boolean isHonorWallSwitch() {
        return this.honorWallSwitch;
    }
}
