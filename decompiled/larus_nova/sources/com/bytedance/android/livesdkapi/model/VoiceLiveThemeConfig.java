package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class VoiceLiveThemeConfig {

    @SerializedName("anchor_enabled")
    public int anchorEnable;

    @SerializedName("audience_enabled")
    public int audienceEnable;

    public boolean isAnchorEnable() {
        if (this.anchorEnable == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isAudienceEnable() {
        if (this.audienceEnable == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public VoiceLiveThemeConfig(int r100, int r101) {
        this.anchorEnable = r100;
        this.audienceEnable = r101;
    }
}
