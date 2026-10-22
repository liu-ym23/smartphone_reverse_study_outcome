package com.bytedance.android.live.base.model.user;

import com.bytedance.android.live.base.model.message.a5;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public class ProfileTagContent {
    public static long TAG_TYPE_ADMIN = 5;
    public static long TAG_TYPE_AGE = 8;
    public static long TAG_TYPE_FROM_INTERCOM = 7;
    public static long TAG_TYPE_LOCAL_LIFE = 3;
    public static long TAG_TYPE_LOCATION = 9;
    public static long TAG_TYPE_POI = 12;
    public static long TAG_TYPE_RANK = 6;
    public static long TAG_TYPE_SAME_FOLLOWER = 11;
    public static long TAG_TYPE_SCHOOL = 10;
    public static long TAG_TYPE_SHOP_PEOPLE = 2;
    public static long TAG_TYPE_UNKNOWN = 0;
    public static long TAG_TYPE_V = 1;
    public static long TAG_TYPE_WHITE_CERT = 4;

    @SerializedName("bg_color")
    public BgColor bgColor;

    @SerializedName("is_click_tag")
    public boolean canClick;

    @SerializedName("click_buried_point")
    public String clickBuriedPoint;

    @SerializedName("click_buried_point_params")
    public Map<String, String> clickBuriedPointParams;

    @SerializedName("click_hide_profile")
    public boolean clickHideProfile;

    @SerializedName("is_bg_picture")
    public boolean isBgPicture;

    @SerializedName("schema")
    public String schema;

    @SerializedName("show_buried_point")
    public String showBuriedPoint;

    @SerializedName("show_buried_point_params")
    public Map<String, String> showBuriedPointParams;

    @SerializedName("tag_content")
    public a5 tagContent;

    @SerializedName("tag_name")
    public String tagName;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE)
    public long tagType;

    public static class BgColor {

        @SerializedName("bg_color_end")
        public String bgColorEnd;

        @SerializedName("bg_color_start")
        public String bgColorStart;

        public BgColor() {
        }
    }

    public ProfileTagContent() {
    }
}
