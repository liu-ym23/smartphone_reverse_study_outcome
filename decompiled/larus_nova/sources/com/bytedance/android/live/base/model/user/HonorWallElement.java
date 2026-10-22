package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class HonorWallElement {
    public static int TYPE_DRESS_UP = 5;
    public static int TYPE_FANS_CLUB = 2;
    public static int TYPE_GIFT = 3;
    public static int TYPE_KTV = 8;
    public static int TYPE_LEVEL = 1;
    public static int TYPE_PK_SEASON = 9;
    public static int TYPE_SHOP_FANS_CLUB = 6;
    public static int TYPE_UNKNOWN = 0;
    public static int TYPE_VIP = 4;

    @SerializedName("extra_info")
    ExtraInfo extraInfo;

    @SerializedName("honor_wall_content")
    HonorWallContent honorWallContent;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    int f58932id;

    @SerializedName("name")
    String name;

    public HonorWallElement() {
    }

    public ExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public HonorWallContent getHonorWallContent() {
        return this.honorWallContent;
    }

    public int getId() {
        return this.f58932id;
    }

    public String getName() {
        return this.name;
    }
}
