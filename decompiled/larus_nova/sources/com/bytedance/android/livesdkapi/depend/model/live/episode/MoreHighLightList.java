package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class MoreHighLightList {

    @SerializedName("background_colors")
    public List<String> backgrounds;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    public String desc;

    @SerializedName("episode_ids")
    public List<Long> episodes;

    @SerializedName("extension_type")
    public long extensionType;

    @SerializedName("introduction_url")
    public String introductionUrl;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    public String title;

    public MoreHighLightList() {
    }
}
