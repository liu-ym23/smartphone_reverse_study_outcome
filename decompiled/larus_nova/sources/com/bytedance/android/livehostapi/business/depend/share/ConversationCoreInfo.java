package com.bytedance.android.livehostapi.business.depend.share;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class ConversationCoreInfo {
    public static final int STATUS_ALREADY_IN = 2;
    public static final int STATUS_APPLYING = 1;
    public static final int STATUS_GROUP_IS_FULL = 3;
    public static final int STATUS_NOT_APPLY = 0;

    @SerializedName("apply_status")
    public int applyStatus;

    @SerializedName("avatar_url")
    public String avatarUrl;

    @SerializedName("con_id")
    public String conId;

    @SerializedName("con_short_id")
    public String conShortId;

    @SerializedName("create_time")
    public int createTime;
    public boolean isChosen;

    @SerializedName("member_count")
    public int memberCount;

    @SerializedName("member_count_limit")
    public int memberCountLimit;

    @SerializedName("name")
    public String name;

    @SerializedName("notice")
    public String notice;

    @SerializedName("owner_uid")
    int ownerUid;

    @SerializedName("requirement")
    public String requirement;

    @SerializedName("visible")
    public boolean visible;

    public ConversationCoreInfo() {
        this.isChosen = false;
    }
}
