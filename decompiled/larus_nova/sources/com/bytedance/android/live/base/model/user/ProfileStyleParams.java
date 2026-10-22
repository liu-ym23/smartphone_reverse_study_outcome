package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class ProfileStyleParams {
    public static long ECOM = 1;
    public static long GROUP_LIVE = 4;
    public static long HONOUR = 0;
    public static long LOCAL_LIFE = 3;

    @SerializedName("profile_head_height")
    long profileDynamicSpaceHeight;

    @SerializedName("profile_style")
    long profileStyle;

    @SerializedName("profile_style_smart_switch")
    long profileStyleSmartSwitch;

    public ProfileStyleParams() {
    }

    public boolean isSmartSwitch() {
        if (this.profileStyleSmartSwitch != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public long getProfileDynamicSpaceHeight() {
        return this.profileDynamicSpaceHeight;
    }

    public long getProfileStyle() {
        return this.profileStyle;
    }
}
