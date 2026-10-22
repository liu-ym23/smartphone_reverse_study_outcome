package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
public class ShowCenterShowInfo {

    @SerializedName("card_color")
    public String cardColor;

    @SerializedName("horizontal_cover")
    public k horizonTalCover;

    @SerializedName("last_seen")
    public boolean lastSeen;

    @SerializedName(BdpAppEventConstant.PARAMS_MAIN_TITLE)
    public String mainTitle;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    public String subTitle;

    @SerializedName("tag")
    public String tag;

    @SerializedName("update_status_desc")
    public String updateStatusDes;

    @SerializedName("vertical_cover")
    public k verticalCover;

    public ShowCenterShowInfo() {
    }
}
