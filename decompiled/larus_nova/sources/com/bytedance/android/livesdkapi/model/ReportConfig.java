package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes12.dex */
public class ReportConfig {

    @SerializedName("enable_more")
    public boolean enableMore;

    @SerializedName(a.VALUE_LONG_CLICK)
    public List<String> longPressShowList;

    @SerializedName("personal_card")
    public PersonalCardConfig personalCardConfig;

    public static class PersonalCardConfig {

        @SerializedName("enable")
        public boolean enable;

        @SerializedName("enable_authorization")
        public boolean enableAuthorization;

        @SerializedName("icon")
        public String icon;

        @SerializedName("show_icon")
        public boolean showIcon;

        @SerializedName("text")
        public String text;

        @SerializedName("text_color")
        public String textColor;

        public PersonalCardConfig() {
        }
    }

    public ReportConfig() {
        this.enableMore = true;
        PersonalCardConfig r100 = new PersonalCardConfig();
        this.personalCardConfig = r100;
        r100.enable = true;
        r100.showIcon = false;
        r100.enableAuthorization = false;
        this.longPressShowList = Arrays.asList(new String[]{AppConstants.BUNDLE_DISLIKE, "follow", "pk_feedback", "report", "clear_screen", "message", "screen_record", "live_optimise"});
    }
}
