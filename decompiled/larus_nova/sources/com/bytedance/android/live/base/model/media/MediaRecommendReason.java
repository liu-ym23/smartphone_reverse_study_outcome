package com.bytedance.android.live.base.model.media;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class MediaRecommendReason {
    public static final int TYPE_FRIENDSHIP = 2;
    public static final int TYPE_LOCATION = 1;

    @SerializedName("city")
    private String city;

    @SerializedName("friend_name")
    private String friendName;

    @SerializedName("reason")
    private String reason;

    @SerializedName("type")
    private int type;

    public MediaRecommendReason() {
    }

    public String getCity() {
        return this.city;
    }

    public String getFriendName() {
        return this.friendName;
    }

    public String getReason() {
        return this.reason;
    }

    public int getType() {
        return this.type;
    }

    public void setCity(String r100) {
        this.city = r100;
    }

    public void setFriendName(String r100) {
        this.friendName = r100;
    }

    public void setReason(String r100) {
        this.reason = r100;
    }

    public void setType(int r100) {
        this.type = r100;
    }
}
