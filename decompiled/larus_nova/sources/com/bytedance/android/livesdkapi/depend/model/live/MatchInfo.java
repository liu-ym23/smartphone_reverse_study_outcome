package com.bytedance.android.livesdkapi.depend.model.live;

import com.google.gson.annotations.SerializedName;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
public class MatchInfo {

    @SerializedName("skin")
    public MatchSkinInfo skin;

    public static class FollowBtnSkin {

        @SerializedName("font_color")
        public String fontColor;

        @SerializedName("left_color")
        public String leftColor;

        @SerializedName("right_color")
        public String rightColor;

        public FollowBtnSkin() {
        }
    }

    public static class MatchSkinInfo {

        @SerializedName("anchor_info_color")
        public String anchorInfoColor;

        @SerializedName("anchor_name_color")
        public String anchorNameColor;

        @SerializedName("comment_place_holder_bg_color")
        public String commentBackgroundColor;

        @SerializedName("comment_place_holder_color")
        public String commentPlaceHolderColor;

        @SerializedName("followed_skin")
        public FollowBtnSkin followedSkin;

        @SerializedName("share_icon")
        public k shareIcon;

        @SerializedName("tab_selected_color")
        public String tabSelectedColor;

        @SerializedName("tab_unselected_color")
        public String tabUnselectedColor;

        @SerializedName("tool_bar_image")
        public k toolBarImage;

        @SerializedName("unfollow_skin")
        public FollowBtnSkin unfollowSkin;

        @SerializedName("user_banner_image")
        public k userBannerImage;

        public MatchSkinInfo() {
        }
    }

    public MatchInfo() {
    }
}
