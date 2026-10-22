package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public class ActivityBadges {

    @SerializedName("badges")
    public List<NewProfileBadge> badges;

    @SerializedName("open_url")
    public String url;

    public static class GradientColor {

        @SerializedName("from")
        public String from;

        /* JADX INFO: renamed from: to, reason: collision with root package name */
        @SerializedName(RemoteMessageConst.TO)
        public String f58931to;

        public GradientColor() {
        }
    }

    public static class NewProfileBadge {

        @SerializedName("bg_color")
        public GradientColor bgColor;

        @SerializedName("expire_date")
        public String expireDate;

        @SerializedName("image")
        public py.k image;

        @SerializedName("name")
        public String name;

        @SerializedName("reward_date")
        public String reward_date;

        @SerializedName("bg_icon")
        public py.k rightIcon;

        public NewProfileBadge() {
        }
    }

    public ActivityBadges() {
    }
}
