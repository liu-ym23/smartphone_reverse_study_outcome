package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class SubscribeInfo {

    @SerializedName("is_member")
    public boolean isMember;

    @SerializedName("member_count")
    public int memberCount;

    @SerializedName("member_count_str")
    public String memberCountStr;

    @SerializedName("member_count_substr")
    public String memberCountSubStr;

    @SerializedName("url")
    public String routeUrl;

    public SubscribeInfo() {
    }
}
