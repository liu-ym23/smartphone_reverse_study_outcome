package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class ProfileSetting {

    @SerializedName("show_setting")
    long showSetting;

    @SerializedName("style_template")
    List<ProfileStyleTemplate> styleTemplates;

    public ProfileSetting() {
    }

    public long getShowSetting() {
        return this.showSetting;
    }

    public List<ProfileStyleTemplate> getStyleTemplates() {
        return this.styleTemplates;
    }
}
