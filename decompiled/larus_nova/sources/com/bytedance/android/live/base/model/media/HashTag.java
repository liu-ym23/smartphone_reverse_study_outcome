package com.bytedance.android.live.base.model.media;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import py.k;

/* JADX INFO: loaded from: classes45.dex */
public class HashTag {

    @SerializedName("activity_text")
    private String activityText;

    @SerializedName("author")
    private IBaseUser author;

    @SerializedName("bulletin")
    String bulletin;

    @SerializedName("desc_h5")
    private b descH5;

    @SerializedName("enable_community")
    boolean enableCommunity;

    @SerializedName("title_img")
    k hashBackgroundImage;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f58842id;

    @SerializedName("is_user_favorite")
    private boolean isUserFavorite;

    @SerializedName("manager")
    private IBaseUser manager;

    @SerializedName("fav_cnt")
    private int memberCount;

    @SerializedName("pop_tips")
    private String popTips;

    @SerializedName("record_enable_community")
    private boolean recordEnableCommunity;

    @SerializedName("schema")
    private String schema;

    @SerializedName("share_h5_url")
    private String shareUrl;

    @SerializedName(Keys.API_EVENT_KEY_SONG)
    private Music song;

    @SerializedName("sticker_id")
    private String stickerId;

    @SerializedName("tips_time")
    private int tipsTime;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private int type;

    @SerializedName("update_cnt")
    int updateCount;

    @SerializedName("video_cnt")
    private long videoCount;

    public HashTag() {
        this.popTips = "";
    }
}
